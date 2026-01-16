package ir.eitaa.ui.Adapters;

import androidx.collection.LongSparseArray;
import ir.eitaa.PhoneFormat.PhoneFormat;
import ir.eitaa.SQLite.SQLiteCursor;
import ir.eitaa.SQLite.SQLitePreparedStatement;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ChatObject;
import ir.eitaa.messenger.ContactsController;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.MessageObject;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.messenger.MessagesStorage;
import ir.eitaa.messenger.UserConfig;
import ir.eitaa.tgnet.ConnectionsManager;
import ir.eitaa.tgnet.RequestDelegate;
import ir.eitaa.tgnet.TLObject;
import ir.eitaa.tgnet.TLRPC$ChannelParticipant;
import ir.eitaa.tgnet.TLRPC$ChannelParticipantsFilter;
import ir.eitaa.tgnet.TLRPC$Chat;
import ir.eitaa.tgnet.TLRPC$ChatParticipant;
import ir.eitaa.tgnet.TLRPC$Peer;
import ir.eitaa.tgnet.TLRPC$TL_channelParticipantsAdmins;
import ir.eitaa.tgnet.TLRPC$TL_channelParticipantsBanned;
import ir.eitaa.tgnet.TLRPC$TL_channelParticipantsKicked;
import ir.eitaa.tgnet.TLRPC$TL_channels_channelParticipants;
import ir.eitaa.tgnet.TLRPC$TL_channels_getParticipants;
import ir.eitaa.tgnet.TLRPC$TL_contact;
import ir.eitaa.tgnet.TLRPC$TL_contacts_found;
import ir.eitaa.tgnet.TLRPC$TL_contacts_search;
import ir.eitaa.tgnet.TLRPC$TL_error;
import ir.eitaa.tgnet.TLRPC$TL_groupCallParticipant;
import ir.eitaa.tgnet.TLRPC$User;
import ir.eitaa.ui.Components.ShareAlert;
import ir.eitaa.ui.FilteredSearchView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
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
    private String lastFoundUsername = null;
    private ArrayList<TLObject> localServerSearch = new ArrayList<>();
    private ArrayList<TLObject> globalSearch = new ArrayList<>();
    private LongSparseArray<TLObject> globalSearchMap = new LongSparseArray<>();
    private ArrayList<TLObject> groupSearch = new ArrayList<>();
    private LongSparseArray<TLObject> groupSearchMap = new LongSparseArray<>();
    private LongSparseArray<TLObject> phoneSearchMap = new LongSparseArray<>();
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

        /* renamed from: ir.eitaa.ui.Adapters.SearchAdapterHelper$SearchAdapterHelperDelegate$-CC, reason: invalid class name */
        public final /* synthetic */ class CC {
            public static boolean $default$canApplySearchResults(SearchAdapterHelperDelegate searchAdapterHelperDelegate, int i) {
                return true;
            }

            public static LongSparseArray $default$getExcludeCallParticipants(SearchAdapterHelperDelegate searchAdapterHelperDelegate) {
                return null;
            }

            public static LongSparseArray $default$getExcludeUsers(SearchAdapterHelperDelegate searchAdapterHelperDelegate) {
                return null;
            }

            public static void $default$onSetHashtags(SearchAdapterHelperDelegate searchAdapterHelperDelegate, ArrayList arrayList, HashMap map) {
            }
        }

        boolean canApplySearchResults(int searchId);

        LongSparseArray<TLRPC$TL_groupCallParticipant> getExcludeCallParticipants();

        LongSparseArray<TLRPC$User> getExcludeUsers();

        void onDataSetChanged(int searchId);

        void onSetHashtags(ArrayList<HashtagObject> arrayList, HashMap<String, HashtagObject> hashMap);
    }

    public SearchAdapterHelper(boolean allAsGlobal) {
        this.allResultsAreGlobal = allAsGlobal;
    }

    public void setAllowGlobalResults(boolean value) {
        this.allowGlobalResults = value;
    }

    public boolean isSearchInProgress() {
        return (this.reqId == 0 && this.channelReqId == 0) ? false : true;
    }

    public void queryServerSearch(final String query, boolean allowUsername, final boolean allowChats, final boolean allowBots, final boolean allowSelf, final boolean canAddGroupsOnly, long channelId, boolean phoneNumbers, int type, final int searchId) {
        String str;
        if (this.reqId != 0) {
            ConnectionsManager.getInstance(this.currentAccount).cancelRequest(this.reqId, true);
            this.reqId = 0;
        }
        if (this.channelReqId != 0) {
            ConnectionsManager.getInstance(this.currentAccount).cancelRequest(this.channelReqId, true);
            this.channelReqId = 0;
        }
        if (query == null) {
            this.groupSearch.clear();
            this.groupSearchMap.clear();
            this.globalSearch.clear();
            this.globalSearchMap.clear();
            this.localServerSearch.clear();
            this.phonesSearch.clear();
            this.phoneSearchMap.clear();
            this.lastReqId = 0;
            this.channelLastReqId = 0;
            this.delegate.onDataSetChanged(searchId);
            return;
        }
        if (query.length() <= 0) {
            this.groupSearch.clear();
            this.groupSearchMap.clear();
            this.channelLastReqId = 0;
            this.delegate.onDataSetChanged(searchId);
        } else if (channelId != 0) {
            TLRPC$TL_channels_getParticipants tLRPC$TL_channels_getParticipants = new TLRPC$TL_channels_getParticipants();
            if (type == 1) {
                tLRPC$TL_channels_getParticipants.filter = new TLRPC$TL_channelParticipantsAdmins();
            } else if (type == 3) {
                tLRPC$TL_channels_getParticipants.filter = new TLRPC$TL_channelParticipantsBanned();
            } else if (type == 0) {
                tLRPC$TL_channels_getParticipants.filter = new TLRPC$TL_channelParticipantsKicked();
            } else {
                tLRPC$TL_channels_getParticipants.filter = new TLRPC$ChannelParticipantsFilter() { // from class: ir.eitaa.tgnet.TLRPC$TL_channelParticipantsSearch
                    public static int constructor = 106343499;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream, boolean exception) {
                        this.q = stream.readString(exception);
                    }

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream) {
                        stream.writeInt32(constructor);
                        stream.writeString(this.q);
                    }
                };
            }
            tLRPC$TL_channels_getParticipants.filter.q = query;
            tLRPC$TL_channels_getParticipants.limit = 50;
            tLRPC$TL_channels_getParticipants.offset = 0;
            tLRPC$TL_channels_getParticipants.channel = MessagesController.getInstance(this.currentAccount).getInputChannel(channelId);
            final int i = this.channelLastReqId + 1;
            this.channelLastReqId = i;
            this.channelReqId = ConnectionsManager.getInstance(this.currentAccount).sendRequest(tLRPC$TL_channels_getParticipants, new RequestDelegate() { // from class: ir.eitaa.ui.Adapters.-$$Lambda$SearchAdapterHelper$TVuc5yJOxp6rJHsXFo428bB4_WQ
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$queryServerSearch$1$SearchAdapterHelper(i, query, allowSelf, searchId, tLObject, tLRPC$TL_error);
                }
            }, 2);
        } else {
            this.lastFoundChannel = query.toLowerCase();
        }
        if (allowUsername) {
            if (query.length() > 0) {
                TLRPC$TL_contacts_search tLRPC$TL_contacts_search = new TLRPC$TL_contacts_search();
                tLRPC$TL_contacts_search.q = query;
                tLRPC$TL_contacts_search.limit = 50;
                final int i2 = this.lastReqId + 1;
                this.lastReqId = i2;
                this.reqId = ConnectionsManager.getInstance(this.currentAccount).sendRequest(tLRPC$TL_contacts_search, new RequestDelegate() { // from class: ir.eitaa.ui.Adapters.-$$Lambda$SearchAdapterHelper$txV_34fAz9jjP724WFtC69Wn75E
                    @Override // ir.eitaa.tgnet.RequestDelegate
                    public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                        this.f$0.lambda$queryServerSearch$3$SearchAdapterHelper(i2, searchId, allowChats, canAddGroupsOnly, allowBots, allowSelf, query, tLObject, tLRPC$TL_error);
                    }
                }, 2);
            } else {
                this.globalSearch.clear();
                this.globalSearchMap.clear();
                this.localServerSearch.clear();
                this.lastReqId = 0;
                this.delegate.onDataSetChanged(searchId);
            }
        } else {
            this.delegate.onDataSetChanged(searchId);
        }
        if (!canAddGroupsOnly && phoneNumbers && query.startsWith("+") && query.length() > 3) {
            this.phonesSearch.clear();
            this.phoneSearchMap.clear();
            String strStripExceptNumbers = PhoneFormat.stripExceptNumbers(query);
            ArrayList<TLRPC$TL_contact> arrayList = ContactsController.getInstance(this.currentAccount).contacts;
            int size = arrayList.size();
            boolean z = false;
            for (int i3 = 0; i3 < size; i3++) {
                TLRPC$User user = MessagesController.getInstance(this.currentAccount).getUser(Long.valueOf(arrayList.get(i3).user_id));
                if (user != null && (str = user.phone) != null && str.startsWith(strStripExceptNumbers)) {
                    if (!z) {
                        z = user.phone.length() == strStripExceptNumbers.length();
                    }
                    this.phonesSearch.add(user);
                    this.phoneSearchMap.put(user.id, user);
                }
            }
            if (!z) {
                this.phonesSearch.add("section");
                this.phonesSearch.add(strStripExceptNumbers);
            }
            this.delegate.onDataSetChanged(searchId);
        }
        this.delegate.onDataSetChanged(searchId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$queryServerSearch$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$queryServerSearch$1$SearchAdapterHelper(final int i, final String str, final boolean z, final int i2, final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.Adapters.-$$Lambda$SearchAdapterHelper$cBxGjaHGTLQVBeLuRq-oM_l8qis
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$queryServerSearch$0$SearchAdapterHelper(i, tLRPC$TL_error, tLObject, str, z, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$queryServerSearch$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$queryServerSearch$0$SearchAdapterHelper(int i, TLRPC$TL_error tLRPC$TL_error, TLObject tLObject, String str, boolean z, int i2) {
        if (i == this.channelLastReqId) {
            this.channelReqId = 0;
            if (tLRPC$TL_error == null) {
                TLRPC$TL_channels_channelParticipants tLRPC$TL_channels_channelParticipants = (TLRPC$TL_channels_channelParticipants) tLObject;
                this.lastFoundChannel = str.toLowerCase();
                MessagesController.getInstance(this.currentAccount).putUsers(tLRPC$TL_channels_channelParticipants.users, false);
                MessagesController.getInstance(this.currentAccount).putChats(tLRPC$TL_channels_channelParticipants.chats, false);
                this.groupSearch.clear();
                this.groupSearchMap.clear();
                this.groupSearch.addAll(tLRPC$TL_channels_channelParticipants.participants);
                long clientUserId = UserConfig.getInstance(this.currentAccount).getClientUserId();
                int size = tLRPC$TL_channels_channelParticipants.participants.size();
                for (int i3 = 0; i3 < size; i3++) {
                    TLRPC$ChannelParticipant tLRPC$ChannelParticipant = tLRPC$TL_channels_channelParticipants.participants.get(i3);
                    long peerId = MessageObject.getPeerId(tLRPC$ChannelParticipant.peer);
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
    /* renamed from: lambda$queryServerSearch$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$queryServerSearch$3$SearchAdapterHelper(final int i, final int i2, final boolean z, final boolean z2, final boolean z3, final boolean z4, final String str, final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.Adapters.-$$Lambda$SearchAdapterHelper$tY6EfYt-sFAOay0Q18vWswry4o0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$queryServerSearch$2$SearchAdapterHelper(i, i2, tLRPC$TL_error, tLObject, z, z2, z3, z4, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$queryServerSearch$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$queryServerSearch$2$SearchAdapterHelper(int i, int i2, TLRPC$TL_error tLRPC$TL_error, TLObject tLObject, boolean z, boolean z2, boolean z3, boolean z4, String str) {
        LongSparseArray longSparseArray;
        TLRPC$Chat tLRPC$Chat;
        TLRPC$User tLRPC$User;
        ArrayList<TLRPC$Peer> arrayList;
        TLRPC$Chat tLRPC$Chat2;
        TLRPC$User tLRPC$User2;
        LongSparseArray longSparseArray2;
        ArrayList<TLRPC$Peer> arrayList2;
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
            int i4 = 1;
            MessagesStorage.getInstance(this.currentAccount).putUsersAndChats(tLRPC$TL_contacts_found.users, tLRPC$TL_contacts_found.chats, true, true);
            LongSparseArray longSparseArray3 = new LongSparseArray();
            LongSparseArray longSparseArray4 = new LongSparseArray();
            for (int i5 = 0; i5 < tLRPC$TL_contacts_found.chats.size(); i5++) {
                TLRPC$Chat tLRPC$Chat3 = tLRPC$TL_contacts_found.chats.get(i5);
                longSparseArray3.put(tLRPC$Chat3.id, tLRPC$Chat3);
            }
            for (int i6 = 0; i6 < tLRPC$TL_contacts_found.users.size(); i6++) {
                TLRPC$User tLRPC$User3 = tLRPC$TL_contacts_found.users.get(i6);
                longSparseArray4.put(tLRPC$User3.id, tLRPC$User3);
            }
            int i7 = 0;
            while (i7 < 2) {
                if (i7 == 0) {
                    if (this.allResultsAreGlobal) {
                        arrayList = tLRPC$TL_contacts_found.my_results;
                    }
                    i7++;
                    longSparseArray4 = longSparseArray4;
                    i4 = 1;
                } else {
                    arrayList = tLRPC$TL_contacts_found.results;
                }
                int i8 = 0;
                while (i8 < arrayList.size()) {
                    TLRPC$Peer tLRPC$Peer = arrayList.get(i8);
                    long j = tLRPC$Peer.user_id;
                    if (j != 0) {
                        tLRPC$User2 = (TLRPC$User) longSparseArray4.get(j);
                        tLRPC$Chat2 = null;
                    } else {
                        long j2 = tLRPC$Peer.chat_id;
                        if (j2 != 0) {
                            tLRPC$Chat2 = (TLRPC$Chat) longSparseArray3.get(j2);
                        } else {
                            long j3 = tLRPC$Peer.channel_id;
                            if (j3 != 0) {
                                tLRPC$Chat2 = (TLRPC$Chat) longSparseArray3.get(j3);
                            } else {
                                tLRPC$Chat2 = null;
                                tLRPC$User2 = null;
                            }
                        }
                        tLRPC$User2 = null;
                    }
                    if (tLRPC$Chat2 != null) {
                        if (!z || ((z2 && !ChatObject.canAddBotsToChat(tLRPC$Chat2)) || (!this.allowGlobalResults && ChatObject.isNotInChat(tLRPC$Chat2)))) {
                            longSparseArray2 = longSparseArray4;
                        } else {
                            this.globalSearch.add(tLRPC$Chat2);
                            FilteredSearchView.globalSearch.add(tLRPC$Chat2);
                            longSparseArray2 = longSparseArray4;
                            this.globalSearchMap.put(-tLRPC$Chat2.id, tLRPC$Chat2);
                        }
                    } else {
                        longSparseArray2 = longSparseArray4;
                        if (tLRPC$User2 != null && !z2 && ((z3 || !tLRPC$User2.bot) && ((z4 || !tLRPC$User2.self) && (this.allowGlobalResults || i7 != i4 || tLRPC$User2.contact)))) {
                            this.globalSearch.add(tLRPC$User2);
                            FilteredSearchView.globalSearch.add(tLRPC$User2);
                            arrayList2 = arrayList;
                            this.globalSearchMap.put(tLRPC$User2.id, tLRPC$User2);
                        }
                        i8++;
                        longSparseArray4 = longSparseArray2;
                        arrayList = arrayList2;
                        i4 = 1;
                    }
                    arrayList2 = arrayList;
                    i8++;
                    longSparseArray4 = longSparseArray2;
                    arrayList = arrayList2;
                    i4 = 1;
                }
                i7++;
                longSparseArray4 = longSparseArray4;
                i4 = 1;
            }
            LongSparseArray longSparseArray5 = longSparseArray4;
            if (!this.allResultsAreGlobal) {
                int i9 = 0;
                while (i9 < tLRPC$TL_contacts_found.my_results.size()) {
                    TLRPC$Peer tLRPC$Peer2 = tLRPC$TL_contacts_found.my_results.get(i9);
                    long j4 = tLRPC$Peer2.user_id;
                    if (j4 != 0) {
                        longSparseArray = longSparseArray5;
                        tLRPC$User = (TLRPC$User) longSparseArray.get(j4);
                        tLRPC$Chat = null;
                    } else {
                        longSparseArray = longSparseArray5;
                        long j5 = tLRPC$Peer2.chat_id;
                        if (j5 != 0) {
                            tLRPC$Chat = (TLRPC$Chat) longSparseArray3.get(j5);
                        } else {
                            long j6 = tLRPC$Peer2.channel_id;
                            if (j6 != 0) {
                                tLRPC$Chat = (TLRPC$Chat) longSparseArray3.get(j6);
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
                    i9++;
                    longSparseArray5 = longSparseArray;
                }
            }
            removeGroupSearchFromGlobal();
            this.lastFoundUsername = str.toLowerCase();
            ArrayList<Object> arrayList3 = this.localSearchResults;
            if (arrayList3 != null) {
                mergeResults(arrayList3);
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
        MessagesStorage.getInstance(this.currentAccount).getStorageQueue().postRunnable(new Runnable() { // from class: ir.eitaa.ui.Adapters.-$$Lambda$SearchAdapterHelper$yvaot2BvqoVa5CXyxZA5wDvsWng
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadRecentHashtags$6$SearchAdapterHelper();
            }
        });
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadRecentHashtags$6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadRecentHashtags$6$SearchAdapterHelper() {
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
            Collections.sort(arrayList, $$Lambda$SearchAdapterHelper$r94IEY_r67Tv7aeRoG6VTMvavVI.INSTANCE);
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.Adapters.-$$Lambda$SearchAdapterHelper$dgV6Spg3FC0i8MKJ_W1LikVAPbc
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$loadRecentHashtags$5$SearchAdapterHelper(arrayList, map);
                }
            });
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    static /* synthetic */ int lambda$loadRecentHashtags$4(HashtagObject hashtagObject, HashtagObject hashtagObject2) {
        int i = hashtagObject.date;
        int i2 = hashtagObject2.date;
        if (i < i2) {
            return 1;
        }
        return i > i2 ? -1 : 0;
    }

    public void addGroupMembers(ArrayList<TLObject> participants) {
        this.groupSearch.clear();
        this.groupSearch.addAll(participants);
        int size = participants.size();
        for (int i = 0; i < size; i++) {
            TLObject tLObject = participants.get(i);
            if (tLObject instanceof TLRPC$ChatParticipant) {
                this.groupSearchMap.put(((TLRPC$ChatParticipant) tLObject).user_id, tLObject);
            } else if (tLObject instanceof TLRPC$ChannelParticipant) {
                this.groupSearchMap.put(MessageObject.getPeerId(((TLRPC$ChannelParticipant) tLObject).peer), tLObject);
            }
        }
        removeGroupSearchFromGlobal();
    }

    public void mergeResults(ArrayList<Object> localResults) {
        TLRPC$Chat tLRPC$Chat;
        this.localSearchResults = localResults;
        if (this.globalSearchMap.size() == 0 || localResults == null) {
            return;
        }
        int size = localResults.size();
        for (int i = 0; i < size; i++) {
            Object obj = localResults.get(i);
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
        LongSparseArray<TLRPC$User> excludeUsers = searchAdapterHelperDelegate.getExcludeUsers();
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
        LongSparseArray<TLRPC$TL_groupCallParticipant> excludeCallParticipants = this.delegate.getExcludeCallParticipants();
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

    public void addHashtagsFromMessage(CharSequence message) {
        if (message == null) {
            return;
        }
        Matcher matcher = Pattern.compile("(^|\\s)#[^0-9][\\w@.]+").matcher(message);
        boolean z = false;
        while (matcher.find()) {
            int iStart = matcher.start();
            int iEnd = matcher.end();
            if (message.charAt(iStart) != '@' && message.charAt(iStart) != '#') {
                iStart++;
            }
            String string = message.subSequence(iStart, iEnd).toString();
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
        MessagesStorage.getInstance(this.currentAccount).getStorageQueue().postRunnable(new Runnable() { // from class: ir.eitaa.ui.Adapters.-$$Lambda$SearchAdapterHelper$T6T57yb58t6OF75JMhClmFLVKzs
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$putRecentHashtags$7$SearchAdapterHelper(arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$putRecentHashtags$7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$putRecentHashtags$7$SearchAdapterHelper(ArrayList arrayList) {
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

    public void removeUserId(long userId) {
        TLObject tLObject = this.globalSearchMap.get(userId);
        if (tLObject != null) {
            this.globalSearch.remove(tLObject);
        }
        TLObject tLObject2 = this.groupSearchMap.get(userId);
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
        MessagesStorage.getInstance(this.currentAccount).getStorageQueue().postRunnable(new Runnable() { // from class: ir.eitaa.ui.Adapters.-$$Lambda$SearchAdapterHelper$2JrFf8U6HIekZvpq1FHi11Hwaxk
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$clearRecentHashtags$8$SearchAdapterHelper();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$clearRecentHashtags$8, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$clearRecentHashtags$8$SearchAdapterHelper() {
        try {
            MessagesStorage.getInstance(this.currentAccount).getDatabase().executeFast("DELETE FROM hashtag_recent_v2 WHERE 1").stepThis().dispose();
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    /* renamed from: setHashtags, reason: merged with bridge method [inline-methods] */
    public void lambda$loadRecentHashtags$5$SearchAdapterHelper(ArrayList<HashtagObject> arrayList, HashMap<String, HashtagObject> hashMap) {
        this.hashtags = arrayList;
        this.hashtagsByText = hashMap;
        this.hashtagsLoadedFromDb = true;
        this.delegate.onSetHashtags(arrayList, hashMap);
    }
}
