package org.rbmain.ui.Adapters;

import android.util.SparseArray;
import androidMessenger.proxy.DialogsProxy;
import ir.aaap.messengercore.model.api.SearchGlobalObjectsInput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.rbmain.PhoneFormat.PhoneFormat;
import org.rbmain.SQLite.SQLiteCursor;
import org.rbmain.SQLite.SQLitePreparedStatement;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ChatObject;
import org.rbmain.messenger.ContactsController;
import org.rbmain.messenger.FileLog;
import org.rbmain.messenger.MessageObject;
import org.rbmain.messenger.MessagesController;
import org.rbmain.messenger.MessagesStorage;
import org.rbmain.messenger.UserConfig;
import org.rbmain.tgnet.ConnectionsManager;
import org.rbmain.tgnet.RequestDelegate;
import org.rbmain.tgnet.TLObject;
import org.rbmain.tgnet.TLRPC$ChannelParticipant;
import org.rbmain.tgnet.TLRPC$ChannelParticipantsFilter;
import org.rbmain.tgnet.TLRPC$Chat;
import org.rbmain.tgnet.TLRPC$ChatParticipant;
import org.rbmain.tgnet.TLRPC$Peer;
import org.rbmain.tgnet.TLRPC$TL_channelParticipantsAdmins;
import org.rbmain.tgnet.TLRPC$TL_channelParticipantsBanned;
import org.rbmain.tgnet.TLRPC$TL_channelParticipantsKicked;
import org.rbmain.tgnet.TLRPC$TL_channels_channelParticipants;
import org.rbmain.tgnet.TLRPC$TL_channels_getParticipants;
import org.rbmain.tgnet.TLRPC$TL_contact;
import org.rbmain.tgnet.TLRPC$TL_contacts_found;
import org.rbmain.tgnet.TLRPC$TL_contacts_search;
import org.rbmain.tgnet.TLRPC$TL_error;
import org.rbmain.tgnet.TLRPC$TL_groupCallParticipant;
import org.rbmain.tgnet.TLRPC$User;
import org.rbmain.ui.Adapters.SearchAdapterHelper;
import org.rbmain.ui.Components.ShareAlert;

/* loaded from: classes4.dex */
public class SearchAdapterHelper {
    private boolean allResultsAreGlobal;
    private int channelLastReqId;
    private SearchAdapterHelperDelegate delegate;
    private ArrayList<HashtagObject> hashtags;
    private HashMap<String, HashtagObject> hashtagsByText;
    private String lastFoundChannel;
    private int lastReqId;
    private ArrayList<Object> localSearchResults;
    private int reqId = 0;
    public boolean searchHasContinue = false;
    public String searchNextStartId = null;
    private String lastFoundUsername = null;
    private ArrayList<TLObject> localServerSearch = new ArrayList<>();
    private ArrayList<TLObject> globalSearch = new ArrayList<>();
    private SparseArray<TLObject> globalSearchMap = new SparseArray<>();
    private ArrayList<TLObject> groupSearch = new ArrayList<>();
    private SparseArray<TLObject> groupSearchMap = new SparseArray<>();
    private SparseArray<TLObject> phoneSearchMap = new SparseArray<>();
    private ArrayList<Object> phonesSearch = new ArrayList<>();
    private int currentAccount = UserConfig.selectedAccount;
    private int channelReqId = 0;
    private boolean allowGlobalResults = true;
    private boolean hashtagsLoadedFromDb = false;

    public static class HashtagObject {
        int date;
        String hashtag;
    }

    public interface SearchAdapterHelperDelegate {

        /* renamed from: org.rbmain.ui.Adapters.SearchAdapterHelper$SearchAdapterHelperDelegate$-CC, reason: invalid class name */
        public final /* synthetic */ class CC {
            public static boolean $default$canApplySearchResults(SearchAdapterHelperDelegate searchAdapterHelperDelegate, int i) {
                return true;
            }

            public static SparseArray $default$getExcludeCallParticipants(SearchAdapterHelperDelegate searchAdapterHelperDelegate) {
                return null;
            }

            public static SparseArray $default$getExcludeUsers(SearchAdapterHelperDelegate searchAdapterHelperDelegate) {
                return null;
            }

            public static void $default$onSetHashtags(SearchAdapterHelperDelegate searchAdapterHelperDelegate, ArrayList arrayList, HashMap map) {
            }
        }

        boolean canApplySearchResults(int i);

        SparseArray<TLRPC$TL_groupCallParticipant> getExcludeCallParticipants();

        SparseArray<TLRPC$User> getExcludeUsers();

        void onDataSetChanged(int i);

        void onSetHashtags(ArrayList<HashtagObject> arrayList, HashMap<String, HashtagObject> map);
    }

    public SearchAdapterHelper(boolean z) {
        this.allResultsAreGlobal = z;
    }

    public void setAllowGlobalResults(boolean z) {
        this.allowGlobalResults = z;
    }

    public boolean isSearchInProgress() {
        return (this.reqId == 0 && this.channelReqId == 0) ? false : true;
    }

    public void queryServerSearch(String str, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, int i, boolean z6, int i2, int i3) {
        queryServerSearch(str, z, z2, z3, z4, z5, i, z6, i2, i3, null);
    }

    public void queryServerSearch(final String str, boolean z, final boolean z2, final boolean z3, final boolean z4, final boolean z5, int i, boolean z6, int i2, final int i3, String str2) {
        String str3;
        if (this.reqId != 0) {
            ConnectionsManager.getInstance(this.currentAccount).cancelRequest(this.reqId, true);
            this.reqId = 0;
        }
        if (this.channelReqId != 0) {
            ConnectionsManager.getInstance(this.currentAccount).cancelRequest(this.channelReqId, true);
            this.channelReqId = 0;
        }
        if (str == null) {
            this.groupSearch.clear();
            this.groupSearchMap.clear();
            this.globalSearch.clear();
            this.globalSearchMap.clear();
            this.localServerSearch.clear();
            this.phonesSearch.clear();
            this.phoneSearchMap.clear();
            this.lastReqId = 0;
            this.channelLastReqId = 0;
            this.delegate.onDataSetChanged(i3);
            return;
        }
        if (str.length() <= 0) {
            this.groupSearch.clear();
            this.groupSearchMap.clear();
            this.channelLastReqId = 0;
            this.delegate.onDataSetChanged(i3);
        } else if (i != 0) {
            TLRPC$TL_channels_getParticipants tLRPC$TL_channels_getParticipants = new TLRPC$TL_channels_getParticipants();
            if (i2 == 1) {
                tLRPC$TL_channels_getParticipants.filter = new TLRPC$TL_channelParticipantsAdmins();
            } else if (i2 == 3) {
                tLRPC$TL_channels_getParticipants.filter = new TLRPC$TL_channelParticipantsBanned();
            } else if (i2 == 0) {
                tLRPC$TL_channels_getParticipants.filter = new TLRPC$TL_channelParticipantsKicked();
            } else {
                tLRPC$TL_channels_getParticipants.filter = new TLRPC$ChannelParticipantsFilter() { // from class: org.rbmain.tgnet.TLRPC$TL_channelParticipantsSearch
                    public static int constructor = 106343499;

                    @Override // org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData, boolean z7) {
                        this.q = abstractSerializedData.readString(z7);
                    }

                    @Override // org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
                        abstractSerializedData.writeInt32(constructor);
                        abstractSerializedData.writeString(this.q);
                    }
                };
            }
            tLRPC$TL_channels_getParticipants.filter.q = str;
            tLRPC$TL_channels_getParticipants.nextStartId = str2;
            tLRPC$TL_channels_getParticipants.limit = 50;
            tLRPC$TL_channels_getParticipants.offset = 0;
            tLRPC$TL_channels_getParticipants.channel = MessagesController.getInstance(this.currentAccount).getInputChannel(i);
            final int i4 = this.channelLastReqId + 1;
            this.channelLastReqId = i4;
            this.channelReqId = DialogsProxy.getInstance(this.currentAccount).getMembersByType(tLRPC$TL_channels_getParticipants, new RequestDelegate() { // from class: org.rbmain.ui.Adapters.SearchAdapterHelper$$ExternalSyntheticLambda8
                @Override // org.rbmain.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$queryServerSearch$1(i4, str, z4, i3, tLObject, tLRPC$TL_error);
                }
            });
        } else {
            this.lastFoundChannel = str.toLowerCase();
        }
        if (z) {
            if (str.length() > 0) {
                TLRPC$TL_contacts_search tLRPC$TL_contacts_search = new TLRPC$TL_contacts_search();
                tLRPC$TL_contacts_search.q = str;
                if (z3) {
                    tLRPC$TL_contacts_search.filterTypes.add(SearchGlobalObjectsInput.FilterType.Bot);
                }
                if (z2) {
                    tLRPC$TL_contacts_search.filterTypes.add(SearchGlobalObjectsInput.FilterType.Channel);
                }
                tLRPC$TL_contacts_search.filterTypes.add(SearchGlobalObjectsInput.FilterType.User);
                tLRPC$TL_contacts_search.limit = 50;
                final int i5 = this.lastReqId + 1;
                this.lastReqId = i5;
                this.reqId = DialogsProxy.getInstance(this.currentAccount).searchGlobalObjects(tLRPC$TL_contacts_search, new RequestDelegate() { // from class: org.rbmain.ui.Adapters.SearchAdapterHelper$$ExternalSyntheticLambda7
                    @Override // org.rbmain.tgnet.RequestDelegate
                    public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                        this.f$0.lambda$queryServerSearch$3(i5, i3, z2, z5, z3, z4, str, tLObject, tLRPC$TL_error);
                    }
                });
            } else {
                this.globalSearch.clear();
                this.globalSearchMap.clear();
                this.localServerSearch.clear();
                this.lastReqId = 0;
                this.delegate.onDataSetChanged(i3);
            }
        }
        if (z5 || !z6 || !str.startsWith("+") || str.length() <= 3) {
            return;
        }
        this.phonesSearch.clear();
        this.phoneSearchMap.clear();
        String strStripExceptNumbers = PhoneFormat.stripExceptNumbers(str);
        ArrayList<TLRPC$TL_contact> arrayList = ContactsController.getInstance(this.currentAccount).contacts;
        int size = arrayList.size();
        boolean z7 = false;
        for (int i6 = 0; i6 < size; i6++) {
            TLRPC$User user = MessagesController.getInstance(this.currentAccount).getUser(Integer.valueOf(arrayList.get(i6).user_id));
            if (user != null && (str3 = user.phone) != null && str3.startsWith(strStripExceptNumbers)) {
                if (!z7) {
                    z7 = user.phone.length() == strStripExceptNumbers.length();
                }
                this.phonesSearch.add(user);
                this.phoneSearchMap.put(user.id, user);
            }
        }
        if (!z7) {
            this.phonesSearch.add("section");
            this.phonesSearch.add(strStripExceptNumbers);
        }
        this.delegate.onDataSetChanged(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$queryServerSearch$1(final int i, final String str, final boolean z, final int i2, final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.Adapters.SearchAdapterHelper$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$queryServerSearch$0(i, tLRPC$TL_error, tLObject, str, z, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$queryServerSearch$0(int i, TLRPC$TL_error tLRPC$TL_error, TLObject tLObject, String str, boolean z, int i2) {
        if (i == this.channelLastReqId) {
            this.channelReqId = 0;
            if (tLRPC$TL_error == null) {
                TLRPC$TL_channels_channelParticipants tLRPC$TL_channels_channelParticipants = (TLRPC$TL_channels_channelParticipants) tLObject;
                this.searchHasContinue = tLRPC$TL_channels_channelParticipants.hasContinue;
                this.searchNextStartId = tLRPC$TL_channels_channelParticipants.nextStartId;
                this.lastFoundChannel = str.toLowerCase();
                MessagesController.getInstance(this.currentAccount).putUsers(tLRPC$TL_channels_channelParticipants.users, false);
                MessagesController.getInstance(this.currentAccount).putChats(tLRPC$TL_channels_channelParticipants.chats, false);
                this.groupSearch.addAll(tLRPC$TL_channels_channelParticipants.participants);
                int clientUserId = UserConfig.getInstance(this.currentAccount).getClientUserId();
                int size = tLRPC$TL_channels_channelParticipants.participants.size();
                for (int i3 = 0; i3 < size; i3++) {
                    TLRPC$ChannelParticipant tLRPC$ChannelParticipant = tLRPC$TL_channels_channelParticipants.participants.get(i3);
                    int peerId = MessageObject.getPeerId(tLRPC$ChannelParticipant.peer);
                    if (!z && peerId == clientUserId) {
                        this.groupSearch.remove(tLRPC$ChannelParticipant);
                    } else {
                        this.groupSearchMap.put(peerId, tLRPC$ChannelParticipant);
                    }
                }
                removeGroupSearchFromGlobal();
                ArrayList<Object> arrayList = this.localSearchResults;
                if (arrayList != null) {
                    mergeResults(arrayList);
                }
                this.delegate.onDataSetChanged(i2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$queryServerSearch$3(final int i, final int i2, final boolean z, final boolean z2, final boolean z3, final boolean z4, final String str, final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.Adapters.SearchAdapterHelper$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$queryServerSearch$2(i, i2, tLRPC$TL_error, tLObject, z, z2, z3, z4, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$queryServerSearch$2(int i, int i2, TLRPC$TL_error tLRPC$TL_error, TLObject tLObject, boolean z, boolean z2, boolean z3, boolean z4, String str) {
        TLRPC$Chat tLRPC$Chat;
        TLRPC$User tLRPC$User;
        ArrayList<TLRPC$Peer> arrayList;
        TLRPC$Chat tLRPC$Chat2;
        TLRPC$User tLRPC$User2;
        int i3 = this.lastReqId;
        if (i == i3) {
            this.reqId = 0;
        }
        if (i == i3 && this.delegate.canApplySearchResults(i2) && tLRPC$TL_error == null) {
            TLRPC$TL_contacts_found tLRPC$TL_contacts_found = (TLRPC$TL_contacts_found) tLObject;
            this.globalSearch.clear();
            this.globalSearchMap.clear();
            this.localServerSearch.clear();
            MessagesController.getInstance(this.currentAccount).putChats(tLRPC$TL_contacts_found.chats, false);
            MessagesController.getInstance(this.currentAccount).putUsers(tLRPC$TL_contacts_found.users, false);
            MessagesStorage.getInstance(this.currentAccount).putUsersAndChats(tLRPC$TL_contacts_found.users, tLRPC$TL_contacts_found.chats, true, true);
            SparseArray sparseArray = new SparseArray();
            SparseArray sparseArray2 = new SparseArray();
            for (int i4 = 0; i4 < tLRPC$TL_contacts_found.chats.size(); i4++) {
                TLRPC$Chat tLRPC$Chat3 = tLRPC$TL_contacts_found.chats.get(i4);
                sparseArray.put(tLRPC$Chat3.id, tLRPC$Chat3);
            }
            for (int i5 = 0; i5 < tLRPC$TL_contacts_found.users.size(); i5++) {
                TLRPC$User tLRPC$User3 = tLRPC$TL_contacts_found.users.get(i5);
                sparseArray2.put(tLRPC$User3.id, tLRPC$User3);
            }
            for (int i6 = 0; i6 < 2; i6++) {
                if (i6 == 0) {
                    if (this.allResultsAreGlobal) {
                        arrayList = tLRPC$TL_contacts_found.my_results;
                    }
                } else {
                    arrayList = tLRPC$TL_contacts_found.results;
                }
                for (int i7 = 0; i7 < arrayList.size(); i7++) {
                    TLRPC$Peer tLRPC$Peer = arrayList.get(i7);
                    int i8 = tLRPC$Peer.user_id;
                    if (i8 != 0) {
                        tLRPC$User2 = (TLRPC$User) sparseArray2.get(i8);
                        tLRPC$Chat2 = null;
                    } else {
                        int i9 = tLRPC$Peer.chat_id;
                        if (i9 != 0) {
                            tLRPC$Chat2 = (TLRPC$Chat) sparseArray.get(i9);
                        } else {
                            int i10 = tLRPC$Peer.channel_id;
                            if (i10 != 0) {
                                tLRPC$Chat2 = (TLRPC$Chat) sparseArray.get(i10);
                            } else {
                                tLRPC$Chat2 = null;
                                tLRPC$User2 = null;
                            }
                        }
                        tLRPC$User2 = null;
                    }
                    if (tLRPC$Chat2 != null) {
                        if (z && ((!z2 || ChatObject.canAddBotsToChat(tLRPC$Chat2)) && (this.allowGlobalResults || !ChatObject.isNotInChat(tLRPC$Chat2)))) {
                            this.globalSearch.add(tLRPC$Chat2);
                            this.globalSearchMap.put(-tLRPC$Chat2.id, tLRPC$Chat2);
                        }
                    } else if (tLRPC$User2 != null && !z2 && ((z3 || !tLRPC$User2.bot) && ((z4 || !tLRPC$User2.self) && (this.allowGlobalResults || i6 != 1 || tLRPC$User2.contact)))) {
                        this.globalSearch.add(tLRPC$User2);
                        this.globalSearchMap.put(tLRPC$User2.id, tLRPC$User2);
                    }
                }
            }
            if (!this.allResultsAreGlobal) {
                for (int i11 = 0; i11 < tLRPC$TL_contacts_found.my_results.size(); i11++) {
                    TLRPC$Peer tLRPC$Peer2 = tLRPC$TL_contacts_found.my_results.get(i11);
                    int i12 = tLRPC$Peer2.user_id;
                    if (i12 != 0) {
                        tLRPC$User = (TLRPC$User) sparseArray2.get(i12);
                        tLRPC$Chat = null;
                    } else {
                        int i13 = tLRPC$Peer2.chat_id;
                        if (i13 != 0) {
                            tLRPC$Chat = (TLRPC$Chat) sparseArray.get(i13);
                        } else {
                            int i14 = tLRPC$Peer2.channel_id;
                            if (i14 != 0) {
                                tLRPC$Chat = (TLRPC$Chat) sparseArray.get(i14);
                            } else {
                                tLRPC$Chat = null;
                                tLRPC$User = null;
                            }
                        }
                        tLRPC$User = null;
                    }
                    if (tLRPC$Chat != null) {
                        if (z && (!z2 || ChatObject.canAddBotsToChat(tLRPC$Chat))) {
                            this.localServerSearch.add(tLRPC$Chat);
                            this.globalSearchMap.put(-tLRPC$Chat.id, tLRPC$Chat);
                        }
                    } else if (tLRPC$User != null && !z2 && ((z3 || !tLRPC$User.bot) && (z4 || !tLRPC$User.self))) {
                        this.localServerSearch.add(tLRPC$User);
                        this.globalSearchMap.put(tLRPC$User.id, tLRPC$User);
                    }
                }
            }
            removeGroupSearchFromGlobal();
            this.lastFoundUsername = str.toLowerCase();
            ArrayList<Object> arrayList2 = this.localSearchResults;
            if (arrayList2 != null) {
                mergeResults(arrayList2);
            }
            mergeExcludeResults();
            this.delegate.onDataSetChanged(i2);
        }
    }

    private void removeGroupSearchFromGlobal() {
        if (this.globalSearchMap.size() == 0) {
            return;
        }
        int size = this.groupSearchMap.size();
        for (int i = 0; i < size; i++) {
            TLRPC$User tLRPC$User = (TLRPC$User) this.globalSearchMap.get(this.groupSearchMap.keyAt(i));
            if (tLRPC$User != null) {
                this.globalSearch.remove(tLRPC$User);
                this.localServerSearch.remove(tLRPC$User);
                this.globalSearchMap.remove(tLRPC$User.id);
            }
        }
    }

    public void clear() {
        this.globalSearch.clear();
        this.globalSearchMap.clear();
        this.localServerSearch.clear();
    }

    public void unloadRecentHashtags() {
        this.hashtagsLoadedFromDb = false;
    }

    public boolean loadRecentHashtags() {
        if (this.hashtagsLoadedFromDb) {
            return true;
        }
        MessagesStorage.getInstance(this.currentAccount).getStorageQueue().postRunnable(new Runnable() { // from class: org.rbmain.ui.Adapters.SearchAdapterHelper$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadRecentHashtags$6();
            }
        });
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadRecentHashtags$6() {
        try {
            SQLiteCursor sQLiteCursorQueryFinalized = MessagesStorage.getInstance(this.currentAccount).getDatabase().queryFinalized("SELECT id, date FROM hashtag_recent_v2 WHERE 1", new Object[0]);
            final ArrayList arrayList = new ArrayList();
            final HashMap map = new HashMap();
            while (sQLiteCursorQueryFinalized.next()) {
                HashtagObject hashtagObject = new HashtagObject();
                hashtagObject.hashtag = sQLiteCursorQueryFinalized.stringValue(0);
                hashtagObject.date = sQLiteCursorQueryFinalized.intValue(1);
                arrayList.add(hashtagObject);
                map.put(hashtagObject.hashtag, hashtagObject);
            }
            sQLiteCursorQueryFinalized.dispose();
            Collections.sort(arrayList, new Comparator() { // from class: org.rbmain.ui.Adapters.SearchAdapterHelper$$ExternalSyntheticLambda6
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return SearchAdapterHelper.lambda$loadRecentHashtags$4((SearchAdapterHelper.HashtagObject) obj, (SearchAdapterHelper.HashtagObject) obj2);
                }
            });
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.Adapters.SearchAdapterHelper$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$loadRecentHashtags$5(arrayList, map);
                }
            });
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$loadRecentHashtags$4(HashtagObject hashtagObject, HashtagObject hashtagObject2) {
        int i = hashtagObject.date;
        int i2 = hashtagObject2.date;
        if (i < i2) {
            return 1;
        }
        return i > i2 ? -1 : 0;
    }

    public void addGroupMembers(ArrayList<TLObject> arrayList) {
        this.groupSearch.clear();
        this.groupSearch.addAll(arrayList);
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            TLObject tLObject = arrayList.get(i);
            if (tLObject instanceof TLRPC$ChatParticipant) {
                this.groupSearchMap.put(((TLRPC$ChatParticipant) tLObject).user_id, tLObject);
            } else if (tLObject instanceof TLRPC$ChannelParticipant) {
                this.groupSearchMap.put(MessageObject.getPeerId(((TLRPC$ChannelParticipant) tLObject).peer), tLObject);
            }
        }
        removeGroupSearchFromGlobal();
    }

    public void mergeResults(ArrayList<Object> arrayList) {
        TLRPC$Chat tLRPC$Chat;
        this.localSearchResults = arrayList;
        if (this.globalSearchMap.size() == 0 || arrayList == null) {
            return;
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            Object obj = arrayList.get(i);
            if (obj instanceof ShareAlert.DialogSearchResult) {
                obj = ((ShareAlert.DialogSearchResult) obj).object;
            }
            if (obj instanceof TLRPC$User) {
                TLRPC$User tLRPC$User = (TLRPC$User) obj;
                TLRPC$User tLRPC$User2 = (TLRPC$User) this.globalSearchMap.get(tLRPC$User.id);
                if (tLRPC$User2 != null) {
                    this.globalSearch.remove(tLRPC$User2);
                    this.localServerSearch.remove(tLRPC$User2);
                    this.globalSearchMap.remove(tLRPC$User2.id);
                }
                TLObject tLObject = this.groupSearchMap.get(tLRPC$User.id);
                if (tLObject != null) {
                    this.groupSearch.remove(tLObject);
                    this.groupSearchMap.remove(tLRPC$User.id);
                }
                TLObject tLObject2 = this.phoneSearchMap.get(tLRPC$User.id);
                if (tLObject2 != null) {
                    this.phonesSearch.remove(tLObject2);
                    this.phoneSearchMap.remove(tLRPC$User.id);
                }
            } else if ((obj instanceof TLRPC$Chat) && (tLRPC$Chat = (TLRPC$Chat) this.globalSearchMap.get(-((TLRPC$Chat) obj).id)) != null) {
                this.globalSearch.remove(tLRPC$Chat);
                this.localServerSearch.remove(tLRPC$Chat);
                this.globalSearchMap.remove(-tLRPC$Chat.id);
            }
        }
    }

    public void mergeExcludeResults() {
        SearchAdapterHelperDelegate searchAdapterHelperDelegate = this.delegate;
        if (searchAdapterHelperDelegate == null) {
            return;
        }
        SparseArray<TLRPC$User> excludeUsers = searchAdapterHelperDelegate.getExcludeUsers();
        if (excludeUsers != null) {
            int size = excludeUsers.size();
            for (int i = 0; i < size; i++) {
                TLRPC$User tLRPC$User = (TLRPC$User) this.globalSearchMap.get(excludeUsers.keyAt(i));
                if (tLRPC$User != null) {
                    this.globalSearch.remove(tLRPC$User);
                    this.localServerSearch.remove(tLRPC$User);
                    this.globalSearchMap.remove(tLRPC$User.id);
                }
            }
        }
        SparseArray<TLRPC$TL_groupCallParticipant> excludeCallParticipants = this.delegate.getExcludeCallParticipants();
        if (excludeCallParticipants != null) {
            int size2 = excludeCallParticipants.size();
            for (int i2 = 0; i2 < size2; i2++) {
                TLRPC$User tLRPC$User2 = (TLRPC$User) this.globalSearchMap.get(excludeCallParticipants.keyAt(i2));
                if (tLRPC$User2 != null) {
                    this.globalSearch.remove(tLRPC$User2);
                    this.localServerSearch.remove(tLRPC$User2);
                    this.globalSearchMap.remove(tLRPC$User2.id);
                }
            }
        }
    }

    public void setDelegate(SearchAdapterHelperDelegate searchAdapterHelperDelegate) {
        this.delegate = searchAdapterHelperDelegate;
    }

    public void addHashtagsFromMessage(CharSequence charSequence) {
        if (charSequence == null) {
            return;
        }
        Matcher matcher = Pattern.compile("(^|\\s)#[^0-9][\\w@.]+").matcher(charSequence);
        boolean z = false;
        while (matcher.find()) {
            int iStart = matcher.start();
            int iEnd = matcher.end();
            if (charSequence.charAt(iStart) != '@' && charSequence.charAt(iStart) != '#') {
                iStart++;
            }
            String string = charSequence.subSequence(iStart, iEnd).toString();
            if (this.hashtagsByText == null) {
                this.hashtagsByText = new HashMap<>();
                this.hashtags = new ArrayList<>();
            }
            HashtagObject hashtagObject = this.hashtagsByText.get(string);
            if (hashtagObject == null) {
                hashtagObject = new HashtagObject();
                hashtagObject.hashtag = string;
                this.hashtagsByText.put(string, hashtagObject);
            } else {
                this.hashtags.remove(hashtagObject);
            }
            hashtagObject.date = (int) (System.currentTimeMillis() / 1000);
            this.hashtags.add(0, hashtagObject);
            z = true;
        }
        if (z) {
            putRecentHashtags(this.hashtags);
        }
    }

    private void putRecentHashtags(final ArrayList<HashtagObject> arrayList) {
        MessagesStorage.getInstance(this.currentAccount).getStorageQueue().postRunnable(new Runnable() { // from class: org.rbmain.ui.Adapters.SearchAdapterHelper$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$putRecentHashtags$7(arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$putRecentHashtags$7(ArrayList arrayList) {
        int i;
        try {
            MessagesStorage.getInstance(this.currentAccount).getDatabase().beginTransaction();
            SQLitePreparedStatement sQLitePreparedStatementExecuteFast = MessagesStorage.getInstance(this.currentAccount).getDatabase().executeFast("REPLACE INTO hashtag_recent_v2 VALUES(?, ?)");
            int i2 = 0;
            while (true) {
                if (i2 >= arrayList.size() || i2 == 100) {
                    break;
                }
                HashtagObject hashtagObject = (HashtagObject) arrayList.get(i2);
                sQLitePreparedStatementExecuteFast.requery();
                sQLitePreparedStatementExecuteFast.bindString(1, hashtagObject.hashtag);
                sQLitePreparedStatementExecuteFast.bindInteger(2, hashtagObject.date);
                sQLitePreparedStatementExecuteFast.step();
                i2++;
            }
            sQLitePreparedStatementExecuteFast.dispose();
            if (arrayList.size() > 100) {
                SQLitePreparedStatement sQLitePreparedStatementExecuteFast2 = MessagesStorage.getInstance(this.currentAccount).getDatabase().executeFast("DELETE FROM hashtag_recent_v2 WHERE id = ?");
                for (i = 100; i < arrayList.size(); i++) {
                    sQLitePreparedStatementExecuteFast2.requery();
                    sQLitePreparedStatementExecuteFast2.bindString(1, ((HashtagObject) arrayList.get(i)).hashtag);
                    sQLitePreparedStatementExecuteFast2.step();
                }
                sQLitePreparedStatementExecuteFast2.dispose();
            }
            MessagesStorage.getInstance(this.currentAccount).getDatabase().commitTransaction();
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public void removeUserId(int i) {
        TLObject tLObject = this.globalSearchMap.get(i);
        if (tLObject != null) {
            this.globalSearch.remove(tLObject);
        }
        TLObject tLObject2 = this.groupSearchMap.get(i);
        if (tLObject2 != null) {
            this.groupSearch.remove(tLObject2);
        }
    }

    public ArrayList<TLObject> getGlobalSearch() {
        return this.globalSearch;
    }

    public ArrayList<Object> getPhoneSearch() {
        return this.phonesSearch;
    }

    public ArrayList<TLObject> getLocalServerSearch() {
        return this.localServerSearch;
    }

    public ArrayList<TLObject> getGroupSearch() {
        return this.groupSearch;
    }

    public ArrayList<HashtagObject> getHashtags() {
        return this.hashtags;
    }

    public String getLastFoundUsername() {
        return this.lastFoundUsername;
    }

    public String getLastFoundChannel() {
        return this.lastFoundChannel;
    }

    public void clearRecentHashtags() {
        this.hashtags = new ArrayList<>();
        this.hashtagsByText = new HashMap<>();
        MessagesStorage.getInstance(this.currentAccount).getStorageQueue().postRunnable(new Runnable() { // from class: org.rbmain.ui.Adapters.SearchAdapterHelper$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$clearRecentHashtags$8();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$clearRecentHashtags$8() {
        try {
            MessagesStorage.getInstance(this.currentAccount).getDatabase().executeFast("DELETE FROM hashtag_recent_v2 WHERE 1").stepThis().dispose();
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    /* renamed from: setHashtags, reason: merged with bridge method [inline-methods] */
    public void lambda$loadRecentHashtags$5(ArrayList<HashtagObject> arrayList, HashMap<String, HashtagObject> map) {
        this.hashtags = arrayList;
        this.hashtagsByText = map;
        this.hashtagsLoadedFromDb = true;
        this.delegate.onSetHashtags(arrayList, map);
    }
}
