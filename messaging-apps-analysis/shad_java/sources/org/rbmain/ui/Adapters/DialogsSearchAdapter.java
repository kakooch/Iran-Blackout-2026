package org.rbmain.ui.Adapters;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidMessenger.proxy.DialogsProxy;
import androidx.collection.LongSparseArray;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import io.github.inflationx.calligraphy3.BuildConfig;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.rbmain.messenger.AccountInstance;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.DispatchQueue;
import org.rbmain.messenger.MediaDataController;
import org.rbmain.messenger.MessageObject;
import org.rbmain.messenger.MessagesController;
import org.rbmain.messenger.MessagesStorage;
import org.rbmain.messenger.UserConfig;
import org.rbmain.messenger.UserObject;
import org.rbmain.messenger.Utilities;
import org.rbmain.tgnet.ConnectionsManager;
import org.rbmain.tgnet.RequestDelegate;
import org.rbmain.tgnet.TLObject;
import org.rbmain.tgnet.TLRPC$Chat;
import org.rbmain.tgnet.TLRPC$EncryptedChat;
import org.rbmain.tgnet.TLRPC$Message;
import org.rbmain.tgnet.TLRPC$Peer;
import org.rbmain.tgnet.TLRPC$RecentListResult;
import org.rbmain.tgnet.TLRPC$TL_dialog;
import org.rbmain.tgnet.TLRPC$TL_error;
import org.rbmain.tgnet.TLRPC$TL_inputMessagesFilterEmpty;
import org.rbmain.tgnet.TLRPC$TL_inputPeerEmpty;
import org.rbmain.tgnet.TLRPC$TL_messages_searchGlobal;
import org.rbmain.tgnet.TLRPC$TL_topPeer;
import org.rbmain.tgnet.TLRPC$User;
import org.rbmain.tgnet.TLRPC$messages_Messages;
import org.rbmain.ui.Adapters.FiltersView;
import org.rbmain.ui.Adapters.SearchAdapterHelper;
import org.rbmain.ui.Cells.DialogCell;
import org.rbmain.ui.Cells.GraySectionCell;
import org.rbmain.ui.Cells.HashtagSearchCell;
import org.rbmain.ui.Cells.HintDialogCell;
import org.rbmain.ui.Cells.ProfileSearchCell;
import org.rbmain.ui.Cells.TextCell;
import org.rbmain.ui.Components.FlickerLoadingView;
import org.rbmain.ui.Components.RecyclerListView;
import org.rbmain.ui.FilteredSearchView;

/* loaded from: classes4.dex */
public class DialogsSearchAdapter extends RecyclerListView.SelectionAdapter {
    private int currentItemCount;
    private DialogsSearchAdapterDelegate delegate;
    private int dialogsType;
    private FilteredSearchView.Delegate filtersDelegate;
    private RecyclerListView innerListView;
    private int lastGlobalSearchId;
    private int lastLocalSearchId;
    private int lastMessagesSearchId;
    private String lastMessagesSearchString;
    private int lastReqId;
    private int lastSearchId;
    private String lastSearchText;
    private ArrayList<FiltersView.DateData> localTipDates;
    private Context mContext;
    private boolean messagesSearchEndReached;
    private int needMessagesSearch;
    private int nextSearchRate;
    private String nextStartId;
    private SearchAdapterHelper searchAdapterHelper;
    private Runnable searchRunnable;
    private Runnable searchRunnable2;
    private boolean searchWas;
    private int selfUserId;
    int waitingResponseCount;
    private ArrayList<Object> searchResult = new ArrayList<>();
    private ArrayList<CharSequence> searchResultNames = new ArrayList<>();
    private ArrayList<MessageObject> searchResultMessages = new ArrayList<>();
    private ArrayList<String> searchResultHashtags = new ArrayList<>();
    private int reqId = 0;
    private int currentAccount = UserConfig.selectedAccount;
    private ArrayList<RecentSearchObject> recentSearchObjects = new ArrayList<>();
    private LongSparseArray<RecentSearchObject> recentSearchObjectsById = new LongSparseArray<>();

    public static class DialogSearchResult {
        public int date;
        public CharSequence name;
        public TLObject object;
    }

    public interface DialogsSearchAdapterDelegate {
        void didPressedOnSubDialog(long j);

        void needClearList();

        void needRemoveHint(int i);

        void runResultsEnterAnimation();

        void searchStateChanged(boolean z, boolean z2);
    }

    public static class RecentSearchObject {
        public long did;
        public TLObject object;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        return i;
    }

    public boolean isSearching() {
        return this.waitingResponseCount > 0;
    }

    private class CategoryAdapterRecycler extends RecyclerListView.SelectionAdapter {
        private boolean drawChecked;

        @Override // org.rbmain.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder viewHolder) {
            return true;
        }

        public CategoryAdapterRecycler(boolean z) {
            this.drawChecked = z;
        }

        public void setIndex(int i) {
            notifyDataSetChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            HintDialogCell hintDialogCell = new HintDialogCell(DialogsSearchAdapter.this.mContext, this.drawChecked);
            hintDialogCell.setLayoutParams(new RecyclerView.LayoutParams(AndroidUtilities.dp(80.0f), AndroidUtilities.dp(86.0f)));
            return new RecyclerListView.Holder(hintDialogCell);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            TLRPC$Chat chat;
            String firstName;
            HintDialogCell hintDialogCell = (HintDialogCell) viewHolder.itemView;
            TLRPC$TL_topPeer tLRPC$TL_topPeer = MediaDataController.getInstance(DialogsSearchAdapter.this.currentAccount).hints.get(i);
            new TLRPC$TL_dialog();
            TLRPC$Peer tLRPC$Peer = tLRPC$TL_topPeer.peer;
            int i2 = tLRPC$Peer.user_id;
            TLRPC$User user = null;
            if (i2 != 0) {
                user = MessagesController.getInstance(DialogsSearchAdapter.this.currentAccount).getUser(Integer.valueOf(tLRPC$TL_topPeer.peer.user_id));
                chat = null;
            } else {
                int i3 = tLRPC$Peer.channel_id;
                if (i3 != 0) {
                    i2 = -i3;
                    chat = MessagesController.getInstance(DialogsSearchAdapter.this.currentAccount).getChat(Integer.valueOf(tLRPC$TL_topPeer.peer.channel_id));
                } else {
                    int i4 = tLRPC$Peer.chat_id;
                    if (i4 != 0) {
                        i2 = -i4;
                        chat = MessagesController.getInstance(DialogsSearchAdapter.this.currentAccount).getChat(Integer.valueOf(tLRPC$TL_topPeer.peer.chat_id));
                    } else {
                        i2 = 0;
                        chat = null;
                    }
                }
            }
            hintDialogCell.setTag(Integer.valueOf(i2));
            if (user != null) {
                firstName = UserObject.getFirstName(user);
            } else {
                firstName = chat != null ? chat.title : BuildConfig.FLAVOR;
            }
            hintDialogCell.setDialog(i2, true, firstName);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return MediaDataController.getInstance(DialogsSearchAdapter.this.currentAccount).hints.size();
        }
    }

    public DialogsSearchAdapter(Context context, int i, int i2, int i3) {
        new ArrayList();
        this.localTipDates = new ArrayList<>();
        SearchAdapterHelper searchAdapterHelper = new SearchAdapterHelper(false);
        this.searchAdapterHelper = searchAdapterHelper;
        searchAdapterHelper.setDelegate(new SearchAdapterHelper.SearchAdapterHelperDelegate() { // from class: org.rbmain.ui.Adapters.DialogsSearchAdapter.1
            @Override // org.rbmain.ui.Adapters.SearchAdapterHelper.SearchAdapterHelperDelegate
            public /* synthetic */ SparseArray getExcludeCallParticipants() {
                return SearchAdapterHelper.SearchAdapterHelperDelegate.CC.$default$getExcludeCallParticipants(this);
            }

            @Override // org.rbmain.ui.Adapters.SearchAdapterHelper.SearchAdapterHelperDelegate
            public /* synthetic */ SparseArray getExcludeUsers() {
                return SearchAdapterHelper.SearchAdapterHelperDelegate.CC.$default$getExcludeUsers(this);
            }

            @Override // org.rbmain.ui.Adapters.SearchAdapterHelper.SearchAdapterHelperDelegate
            public void onDataSetChanged(int i4) {
                DialogsSearchAdapter dialogsSearchAdapter = DialogsSearchAdapter.this;
                dialogsSearchAdapter.waitingResponseCount--;
                dialogsSearchAdapter.lastGlobalSearchId = i4;
                if (DialogsSearchAdapter.this.lastLocalSearchId != i4) {
                    DialogsSearchAdapter.this.searchResult.clear();
                }
                if (DialogsSearchAdapter.this.lastMessagesSearchId != i4) {
                    DialogsSearchAdapter.this.searchResultMessages.clear();
                }
                DialogsSearchAdapter.this.searchWas = true;
                if (DialogsSearchAdapter.this.delegate != null) {
                    DialogsSearchAdapter.this.delegate.searchStateChanged(DialogsSearchAdapter.this.waitingResponseCount > 0, true);
                }
                DialogsSearchAdapter.this.notifyDataSetChanged();
                if (DialogsSearchAdapter.this.delegate != null) {
                    DialogsSearchAdapter.this.delegate.runResultsEnterAnimation();
                }
            }

            @Override // org.rbmain.ui.Adapters.SearchAdapterHelper.SearchAdapterHelperDelegate
            public void onSetHashtags(ArrayList<SearchAdapterHelper.HashtagObject> arrayList, HashMap<String, SearchAdapterHelper.HashtagObject> map) {
                for (int i4 = 0; i4 < arrayList.size(); i4++) {
                    DialogsSearchAdapter.this.searchResultHashtags.add(arrayList.get(i4).hashtag);
                }
                if (DialogsSearchAdapter.this.delegate != null) {
                    DialogsSearchAdapter.this.delegate.searchStateChanged(DialogsSearchAdapter.this.waitingResponseCount > 0, false);
                }
                DialogsSearchAdapter.this.notifyDataSetChanged();
            }

            @Override // org.rbmain.ui.Adapters.SearchAdapterHelper.SearchAdapterHelperDelegate
            public boolean canApplySearchResults(int i4) {
                return i4 == DialogsSearchAdapter.this.lastSearchId;
            }
        });
        this.mContext = context;
        this.needMessagesSearch = i;
        this.dialogsType = i2;
        this.selfUserId = UserConfig.getInstance(this.currentAccount).getClientUserId();
        loadRecentSearch();
        MediaDataController.getInstance(this.currentAccount).loadHints(true);
    }

    public RecyclerListView getInnerListView() {
        return this.innerListView;
    }

    public void setDelegate(DialogsSearchAdapterDelegate dialogsSearchAdapterDelegate) {
        this.delegate = dialogsSearchAdapterDelegate;
    }

    public boolean isMessagesSearchEndReached() {
        return this.messagesSearchEndReached;
    }

    public void loadMoreSearchMessages(String str) {
        if (this.reqId != 0 || this.needMessagesSearch == 0) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            searchMessagesInternal(this.lastMessagesSearchString, this.lastMessagesSearchId);
        } else {
            this.waitingResponseCount++;
            searchMessagesInternal(str, this.lastSearchId);
        }
    }

    public String getLastSearchString() {
        return this.lastMessagesSearchString;
    }

    private void searchMessagesInternal(final String str, final int i) {
        if (this.needMessagesSearch != 0) {
            if (TextUtils.isEmpty(this.lastMessagesSearchString) && TextUtils.isEmpty(str)) {
                return;
            }
            if (this.reqId != 0) {
                ConnectionsManager.getInstance(this.currentAccount).cancelRequest(this.reqId, true);
                this.reqId = 0;
            }
            if (TextUtils.isEmpty(str)) {
                this.searchResultMessages.clear();
                this.lastReqId = 0;
                this.lastMessagesSearchString = null;
                this.searchWas = false;
                this.messagesSearchEndReached = false;
                notifyDataSetChanged();
                return;
            }
            final TLRPC$TL_messages_searchGlobal tLRPC$TL_messages_searchGlobal = new TLRPC$TL_messages_searchGlobal();
            tLRPC$TL_messages_searchGlobal.limit = 20;
            tLRPC$TL_messages_searchGlobal.q = str;
            tLRPC$TL_messages_searchGlobal.filter = new TLRPC$TL_inputMessagesFilterEmpty();
            if (str.equals(this.lastMessagesSearchString) && !this.searchResultMessages.isEmpty()) {
                ArrayList<MessageObject> arrayList = this.searchResultMessages;
                MessageObject messageObject = arrayList.get(arrayList.size() - 1);
                tLRPC$TL_messages_searchGlobal.offset_id = messageObject.getId();
                tLRPC$TL_messages_searchGlobal.nextStartId = this.nextStartId;
                tLRPC$TL_messages_searchGlobal.offset_rate = this.nextSearchRate;
                TLRPC$Peer tLRPC$Peer = messageObject.messageOwner.peer_id;
                int i2 = tLRPC$Peer.channel_id;
                tLRPC$TL_messages_searchGlobal.offset_peer = MessagesController.getInstance(this.currentAccount).getInputPeer((i2 == 0 && (i2 = tLRPC$Peer.chat_id) == 0) ? tLRPC$Peer.user_id : -i2);
            } else {
                tLRPC$TL_messages_searchGlobal.offset_rate = 0;
                tLRPC$TL_messages_searchGlobal.offset_id = 0L;
                tLRPC$TL_messages_searchGlobal.offset_peer = new TLRPC$TL_inputPeerEmpty();
                tLRPC$TL_messages_searchGlobal.nextStartId = null;
            }
            this.lastMessagesSearchString = str;
            final int i3 = this.lastReqId + 1;
            this.lastReqId = i3;
            this.reqId = DialogsProxy.getInstance(this.currentAccount).searchGlobalMessages(tLRPC$TL_messages_searchGlobal, new RequestDelegate() { // from class: org.rbmain.ui.Adapters.DialogsSearchAdapter$$ExternalSyntheticLambda11
                @Override // org.rbmain.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$searchMessagesInternal$1(str, i3, i, tLRPC$TL_messages_searchGlobal, tLObject, tLRPC$TL_error);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$searchMessagesInternal$1(final String str, final int i, final int i2, final TLRPC$TL_messages_searchGlobal tLRPC$TL_messages_searchGlobal, final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        final ArrayList arrayList = new ArrayList();
        if (tLRPC$TL_error == null) {
            TLRPC$messages_Messages tLRPC$messages_Messages = (TLRPC$messages_Messages) tLObject;
            SparseArray sparseArray = new SparseArray();
            SparseArray sparseArray2 = new SparseArray();
            for (int i3 = 0; i3 < tLRPC$messages_Messages.chats.size(); i3++) {
                TLRPC$Chat tLRPC$Chat = tLRPC$messages_Messages.chats.get(i3);
                sparseArray.put(tLRPC$Chat.id, tLRPC$Chat);
            }
            for (int i4 = 0; i4 < tLRPC$messages_Messages.users.size(); i4++) {
                TLRPC$User tLRPC$User = tLRPC$messages_Messages.users.get(i4);
                sparseArray2.put(tLRPC$User.id, tLRPC$User);
            }
            for (int i5 = 0; i5 < tLRPC$messages_Messages.messages.size(); i5++) {
                MessageObject messageObject = new MessageObject(this.currentAccount, tLRPC$messages_Messages.messages.get(i5), (SparseArray<TLRPC$User>) sparseArray2, (SparseArray<TLRPC$Chat>) sparseArray, false, true);
                arrayList.add(messageObject);
                messageObject.setQuery(str);
            }
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.Adapters.DialogsSearchAdapter$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$searchMessagesInternal$0(i, i2, tLRPC$TL_error, str, tLObject, tLRPC$TL_messages_searchGlobal, arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$searchMessagesInternal$0(int i, int i2, TLRPC$TL_error tLRPC$TL_error, String str, TLObject tLObject, TLRPC$TL_messages_searchGlobal tLRPC$TL_messages_searchGlobal, ArrayList arrayList) {
        if (i == this.lastReqId && (i2 <= 0 || i2 == this.lastSearchId)) {
            this.waitingResponseCount--;
            if (tLRPC$TL_error == null) {
                TLRPC$messages_Messages tLRPC$messages_Messages = (TLRPC$messages_Messages) tLObject;
                MessagesStorage.getInstance(this.currentAccount).putUsersAndChats(tLRPC$messages_Messages.users, tLRPC$messages_Messages.chats, true, true);
                MessagesController.getInstance(this.currentAccount).putUsers(tLRPC$messages_Messages.users, false);
                MessagesController.getInstance(this.currentAccount).putChats(tLRPC$messages_Messages.chats, false);
                if (tLRPC$TL_messages_searchGlobal.offset_id == 0) {
                    this.searchResultMessages.clear();
                }
                this.nextSearchRate = tLRPC$messages_Messages.next_rate;
                this.nextStartId = tLRPC$messages_Messages.nextStartId;
                for (int i3 = 0; i3 < tLRPC$messages_Messages.messages.size(); i3++) {
                    TLRPC$Message tLRPC$Message = tLRPC$messages_Messages.messages.get(i3);
                    Long l = MessagesController.getInstance(this.currentAccount).deletedHistory.get(MessageObject.getDialogId(tLRPC$Message));
                    if (l == null || tLRPC$Message.id > l.longValue()) {
                        this.searchResultMessages.add((MessageObject) arrayList.get(i3));
                        long dialogId = MessageObject.getDialogId(tLRPC$Message);
                        ConcurrentHashMap<Long, Long> concurrentHashMap = tLRPC$Message.out ? MessagesController.getInstance(this.currentAccount).dialogs_read_outbox_max : MessagesController.getInstance(this.currentAccount).dialogs_read_inbox_max;
                        Long lValueOf = concurrentHashMap.get(Long.valueOf(dialogId));
                        if (lValueOf == null) {
                            lValueOf = Long.valueOf(MessagesStorage.getInstance(this.currentAccount).getDialogReadMax(tLRPC$Message.out, dialogId));
                            concurrentHashMap.put(Long.valueOf(dialogId), lValueOf);
                        }
                        tLRPC$Message.unread = lValueOf.longValue() < tLRPC$Message.id;
                    }
                }
                this.searchWas = true;
                this.messagesSearchEndReached = !tLRPC$messages_Messages.hasContinue;
                if (i2 > 0) {
                    this.lastMessagesSearchId = i2;
                    if (this.lastLocalSearchId != i2) {
                        this.searchResult.clear();
                    }
                    if (this.lastGlobalSearchId != i2) {
                        this.searchAdapterHelper.clear();
                    }
                }
                notifyDataSetChanged();
                DialogsSearchAdapterDelegate dialogsSearchAdapterDelegate = this.delegate;
                if (dialogsSearchAdapterDelegate != null) {
                    dialogsSearchAdapterDelegate.searchStateChanged(this.waitingResponseCount > 0, true);
                    this.delegate.runResultsEnterAnimation();
                }
            }
        }
        this.reqId = 0;
    }

    public boolean hasRecentSearch() {
        int i = this.dialogsType;
        return (i == 2 || i == 4 || i == 5 || i == 6 || i == 11 || (this.recentSearchObjects.isEmpty() && MediaDataController.getInstance(this.currentAccount).hints.isEmpty())) ? false : true;
    }

    public boolean isRecentSearchDisplayed() {
        int i;
        return (this.needMessagesSearch == 2 || this.searchWas || (this.recentSearchObjects.isEmpty() && MediaDataController.getInstance(this.currentAccount).hints.isEmpty()) || (i = this.dialogsType) == 2 || i == 4 || i == 5 || i == 6 || i == 11) ? false : true;
    }

    public void loadRecentSearch() {
        final LongSparseArray longSparseArray = new LongSparseArray();
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: org.rbmain.ui.Adapters.DialogsSearchAdapter$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadRecentSearch$4(longSparseArray);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadRecentSearch$4(final LongSparseArray longSparseArray) {
        DialogsProxy.getInstance(this.currentAccount).getRecentSearch(new RequestDelegate() { // from class: org.rbmain.ui.Adapters.DialogsSearchAdapter$$ExternalSyntheticLambda10
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$loadRecentSearch$3(longSparseArray, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadRecentSearch$3(final LongSparseArray longSparseArray, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error == null) {
            final ArrayList<RecentSearchObject> arrayList = ((TLRPC$RecentListResult) tLObject).recentSearchObjects;
            Iterator<RecentSearchObject> it = arrayList.iterator();
            while (it.hasNext()) {
                RecentSearchObject next = it.next();
                longSparseArray.put(next.did, next);
            }
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.Adapters.DialogsSearchAdapter$$ExternalSyntheticLambda9
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$loadRecentSearch$2(arrayList, longSparseArray);
                }
            });
        }
    }

    public void putRecentSearch(long j, TLObject tLObject) {
        RecentSearchObject recentSearchObject = this.recentSearchObjectsById.get(j);
        if (recentSearchObject == null) {
            recentSearchObject = new RecentSearchObject();
            this.recentSearchObjectsById.put(j, recentSearchObject);
        } else {
            this.recentSearchObjects.remove(recentSearchObject);
        }
        this.recentSearchObjects.add(0, recentSearchObject);
        recentSearchObject.did = j;
        recentSearchObject.object = tLObject;
        long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
        notifyDataSetChanged();
        DialogsProxy.getInstance(this.currentAccount).addRecentChat(j);
    }

    public void clearRecentSearch() {
        this.recentSearchObjectsById = new LongSparseArray<>();
        this.recentSearchObjects = new ArrayList<>();
        notifyDataSetChanged();
        DialogsProxy.getInstance(this.currentAccount).clearRecentSearch();
    }

    public void removeRecentSearch(long j) {
        RecentSearchObject recentSearchObject = this.recentSearchObjectsById.get(j);
        if (recentSearchObject == null) {
            return;
        }
        this.recentSearchObjectsById.remove(j);
        this.recentSearchObjects.remove(recentSearchObject);
        notifyDataSetChanged();
        DialogsProxy.getInstance(this.currentAccount).removeRecentChat(j);
    }

    public void addHashtagsFromMessage(CharSequence charSequence) {
        this.searchAdapterHelper.addHashtagsFromMessage(charSequence);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setRecentSearch, reason: merged with bridge method [inline-methods] */
    public void lambda$loadRecentSearch$2(ArrayList<RecentSearchObject> arrayList, LongSparseArray<RecentSearchObject> longSparseArray) {
        this.recentSearchObjects = arrayList;
        this.recentSearchObjectsById = longSparseArray;
        for (int i = 0; i < this.recentSearchObjects.size(); i++) {
            RecentSearchObject recentSearchObject = this.recentSearchObjects.get(i);
            TLObject tLObject = recentSearchObject.object;
            if (tLObject instanceof TLRPC$User) {
                MessagesController.getInstance(this.currentAccount).putUser((TLRPC$User) recentSearchObject.object, true);
            } else if (tLObject instanceof TLRPC$Chat) {
                MessagesController.getInstance(this.currentAccount).putChat((TLRPC$Chat) recentSearchObject.object, true);
            } else if (tLObject instanceof TLRPC$EncryptedChat) {
                MessagesController.getInstance(this.currentAccount).putEncryptedChat((TLRPC$EncryptedChat) recentSearchObject.object, true);
            }
        }
        notifyDataSetChanged();
    }

    private void searchDialogsInternal(String str, final int i) {
        if (this.needMessagesSearch == 2) {
            return;
        }
        final String lowerCase = str.trim().toLowerCase();
        if (lowerCase.length() == 0) {
            this.lastSearchId = 0;
            updateSearchResults(new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), this.lastSearchId);
        } else {
            MessagesStorage.getInstance(this.currentAccount).getStorageQueue().postRunnable(new Runnable() { // from class: org.rbmain.ui.Adapters.DialogsSearchAdapter$$ExternalSyntheticLambda8
                @Override // java.lang.Runnable
                public final void run() throws NumberFormatException {
                    this.f$0.lambda$searchDialogsInternal$6(lowerCase, i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$searchDialogsInternal$6(String str, int i) throws NumberFormatException {
        ArrayList<Object> arrayList = new ArrayList<>();
        ArrayList<CharSequence> arrayList2 = new ArrayList<>();
        ArrayList<TLRPC$User> arrayList3 = new ArrayList<>();
        AccountInstance.getInstance(this.currentAccount).getDialogsProxy().localSearch(str, arrayList, arrayList2, null);
        updateSearchResults(arrayList, arrayList2, arrayList3, i);
        FiltersView.fillTipDates(str, this.localTipDates);
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.Adapters.DialogsSearchAdapter$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$searchDialogsInternal$5();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$searchDialogsInternal$5() {
        FilteredSearchView.Delegate delegate = this.filtersDelegate;
        if (delegate != null) {
            delegate.updateFiltersView(false, null, this.localTipDates);
        }
    }

    private void updateSearchResults(final ArrayList<Object> arrayList, final ArrayList<CharSequence> arrayList2, final ArrayList<TLRPC$User> arrayList3, final int i) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.Adapters.DialogsSearchAdapter$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$updateSearchResults$7(i, arrayList, arrayList3, arrayList2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateSearchResults$7(int i, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3) {
        this.waitingResponseCount--;
        if (i != this.lastSearchId) {
            return;
        }
        this.lastLocalSearchId = i;
        if (this.lastGlobalSearchId != i) {
            this.searchAdapterHelper.clear();
        }
        if (this.lastMessagesSearchId != i) {
            this.searchResultMessages.clear();
        }
        this.searchWas = true;
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            Object obj = arrayList.get(i2);
            if (obj instanceof TLRPC$User) {
                MessagesController.getInstance(this.currentAccount).putUser((TLRPC$User) obj, true);
            } else if (obj instanceof TLRPC$Chat) {
                MessagesController.getInstance(this.currentAccount).putChat((TLRPC$Chat) obj, true);
            } else if (obj instanceof TLRPC$EncryptedChat) {
                MessagesController.getInstance(this.currentAccount).putEncryptedChat((TLRPC$EncryptedChat) obj, true);
            }
        }
        MessagesController.getInstance(this.currentAccount).putUsers(arrayList2, true);
        this.searchResult = arrayList;
        this.searchResultNames = arrayList3;
        this.searchAdapterHelper.mergeResults(arrayList);
        notifyDataSetChanged();
        DialogsSearchAdapterDelegate dialogsSearchAdapterDelegate = this.delegate;
        if (dialogsSearchAdapterDelegate != null) {
            dialogsSearchAdapterDelegate.searchStateChanged(this.waitingResponseCount > 0, true);
            this.delegate.runResultsEnterAnimation();
        }
    }

    public boolean isHashtagSearch() {
        return !this.searchResultHashtags.isEmpty();
    }

    public void clearRecentHashtags() {
        this.searchAdapterHelper.clearRecentHashtags();
        this.searchResultHashtags.clear();
        notifyDataSetChanged();
    }

    public void searchDialogs(String str) {
        if (str == null || !str.equals(this.lastSearchText)) {
            this.lastSearchText = str;
            if (this.searchRunnable != null) {
                Utilities.searchQueue.cancelRunnable(this.searchRunnable);
                this.searchRunnable = null;
            }
            Runnable runnable = this.searchRunnable2;
            if (runnable != null) {
                AndroidUtilities.cancelRunOnUIThread(runnable);
                this.searchRunnable2 = null;
            }
            final String strTrim = str != null ? str.trim() : null;
            if (TextUtils.isEmpty(strTrim)) {
                this.searchAdapterHelper.unloadRecentHashtags();
                this.searchResult.clear();
                this.searchResultNames.clear();
                this.searchResultHashtags.clear();
                this.searchAdapterHelper.mergeResults(null);
                SearchAdapterHelper searchAdapterHelper = this.searchAdapterHelper;
                int i = this.dialogsType;
                searchAdapterHelper.queryServerSearch(null, true, true, i != 11, i != 11, i == 2 || i == 11, 0, i == 0, 0, 0);
                this.searchWas = false;
                this.lastSearchId = 0;
                this.waitingResponseCount = 0;
                DialogsSearchAdapterDelegate dialogsSearchAdapterDelegate = this.delegate;
                if (dialogsSearchAdapterDelegate != null) {
                    dialogsSearchAdapterDelegate.searchStateChanged(false, true);
                }
                searchMessagesInternal(null, 0);
                notifyDataSetChanged();
                this.localTipDates.clear();
                FilteredSearchView.Delegate delegate = this.filtersDelegate;
                if (delegate != null) {
                    delegate.updateFiltersView(false, null, this.localTipDates);
                    return;
                }
                return;
            }
            if (this.needMessagesSearch != 2 && strTrim.startsWith("#") && strTrim.length() == 1) {
                this.messagesSearchEndReached = true;
                if (this.searchAdapterHelper.loadRecentHashtags()) {
                    this.searchResultMessages.clear();
                    this.searchResultHashtags.clear();
                    ArrayList<SearchAdapterHelper.HashtagObject> hashtags = this.searchAdapterHelper.getHashtags();
                    for (int i2 = 0; i2 < hashtags.size(); i2++) {
                        this.searchResultHashtags.add(hashtags.get(i2).hashtag);
                    }
                    this.waitingResponseCount = 0;
                    notifyDataSetChanged();
                    DialogsSearchAdapterDelegate dialogsSearchAdapterDelegate2 = this.delegate;
                    if (dialogsSearchAdapterDelegate2 != null) {
                        dialogsSearchAdapterDelegate2.searchStateChanged(false, false);
                    }
                }
            } else {
                this.searchResultHashtags.clear();
            }
            final int i3 = this.lastSearchId + 1;
            this.lastSearchId = i3;
            this.waitingResponseCount = 3;
            notifyDataSetChanged();
            DialogsSearchAdapterDelegate dialogsSearchAdapterDelegate3 = this.delegate;
            if (dialogsSearchAdapterDelegate3 != null) {
                dialogsSearchAdapterDelegate3.searchStateChanged(true, false);
            }
            DispatchQueue dispatchQueue = Utilities.searchQueue;
            Runnable runnable2 = new Runnable() { // from class: org.rbmain.ui.Adapters.DialogsSearchAdapter$$ExternalSyntheticLambda7
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$searchDialogs$9(strTrim, i3);
                }
            };
            this.searchRunnable = runnable2;
            dispatchQueue.postRunnable(runnable2, 600L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$searchDialogs$9(final String str, final int i) {
        this.searchRunnable = null;
        searchDialogsInternal(str, i);
        Runnable runnable = new Runnable() { // from class: org.rbmain.ui.Adapters.DialogsSearchAdapter$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$searchDialogs$8(i, str);
            }
        };
        this.searchRunnable2 = runnable;
        AndroidUtilities.runOnUIThread(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$searchDialogs$8(int i, String str) {
        this.searchRunnable2 = null;
        if (i != this.lastSearchId) {
            return;
        }
        int i2 = this.needMessagesSearch;
        if (i2 != 0) {
            this.messagesSearchEndReached = false;
        }
        if (i2 != 2) {
            SearchAdapterHelper searchAdapterHelper = this.searchAdapterHelper;
            int i3 = this.dialogsType;
            searchAdapterHelper.queryServerSearch(str, true, i3 != 4, true, (i3 == 4 || i3 == 11) ? false : true, i3 == 2 || i3 == 1, 0, i3 == 0, 0, i);
        } else {
            this.waitingResponseCount -= 2;
        }
        this.waitingResponseCount--;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.waitingResponseCount == 3) {
            return 0;
        }
        if (isRecentSearchDisplayed()) {
            return (this.recentSearchObjects.isEmpty() ? 0 : this.recentSearchObjects.size() + 1) + (!MediaDataController.getInstance(this.currentAccount).hints.isEmpty() ? 1 : 0);
        }
        if (!this.searchResultHashtags.isEmpty()) {
            return this.searchResultHashtags.size() + 1 + 0;
        }
        int size = this.searchResult.size() + 0;
        int size2 = this.searchAdapterHelper.getLocalServerSearch().size();
        int size3 = this.searchAdapterHelper.getGlobalSearch().size();
        int size4 = this.searchAdapterHelper.getPhoneSearch().size();
        int size5 = this.searchResultMessages.size();
        int i = size + size2;
        if (size3 != 0) {
            i += size3 + 1;
        }
        if (size4 != 0) {
            i += size4;
        }
        if (size5 != 0) {
            i += size5 + 1 + (!this.messagesSearchEndReached ? 1 : 0);
        }
        this.currentItemCount = i;
        return i;
    }

    public Object getItem(int i) {
        int i2;
        Object chat;
        if (isRecentSearchDisplayed()) {
            int i3 = !MediaDataController.getInstance(this.currentAccount).hints.isEmpty() ? 1 : 0;
            if (i <= i3 || (i2 = (i - 1) - i3) >= this.recentSearchObjects.size()) {
                return null;
            }
            TLObject tLObject = this.recentSearchObjects.get(i2).object;
            if (tLObject instanceof TLRPC$User) {
                chat = MessagesController.getInstance(this.currentAccount).getUser(Integer.valueOf(((TLRPC$User) tLObject).id));
                if (chat == null) {
                    return tLObject;
                }
            } else if (!(tLObject instanceof TLRPC$Chat) || (chat = MessagesController.getInstance(this.currentAccount).getChat(Integer.valueOf(((TLRPC$Chat) tLObject).id))) == null) {
                return tLObject;
            }
            return chat;
        }
        if (!this.searchResultHashtags.isEmpty()) {
            if (i > 0) {
                return this.searchResultHashtags.get(i - 1);
            }
            return null;
        }
        ArrayList<TLObject> globalSearch = this.searchAdapterHelper.getGlobalSearch();
        ArrayList<TLObject> localServerSearch = this.searchAdapterHelper.getLocalServerSearch();
        ArrayList<Object> phoneSearch = this.searchAdapterHelper.getPhoneSearch();
        int size = this.searchResult.size();
        int size2 = localServerSearch.size();
        int size3 = phoneSearch.size();
        int size4 = globalSearch.isEmpty() ? 0 : globalSearch.size() + 1;
        int size5 = this.searchResultMessages.isEmpty() ? 0 : this.searchResultMessages.size() + 1;
        if (i >= 0 && i < size) {
            return this.searchResult.get(i);
        }
        int i4 = i - size;
        if (i4 >= 0 && i4 < size2) {
            return localServerSearch.get(i4);
        }
        int i5 = i4 - size2;
        if (i5 >= 0 && i5 < size3) {
            return phoneSearch.get(i5);
        }
        int i6 = i5 - size3;
        if (i6 > 0 && i6 < size4) {
            return globalSearch.get(i6 - 1);
        }
        int i7 = i6 - size4;
        if (i7 <= 0 || i7 >= size5) {
            return null;
        }
        return this.searchResultMessages.get(i7 - 1);
    }

    public boolean isGlobalSearch(int i) {
        int i2;
        if (isRecentSearchDisplayed() || !this.searchResultHashtags.isEmpty()) {
            return false;
        }
        ArrayList<TLObject> globalSearch = this.searchAdapterHelper.getGlobalSearch();
        ArrayList<TLObject> localServerSearch = this.searchAdapterHelper.getLocalServerSearch();
        int size = this.searchResult.size();
        int size2 = localServerSearch.size();
        int size3 = this.searchAdapterHelper.getPhoneSearch().size();
        int size4 = globalSearch.isEmpty() ? 0 : globalSearch.size() + 1;
        if (!this.searchResultMessages.isEmpty()) {
            this.searchResultMessages.size();
        }
        if (i >= 0 && i < size) {
            return false;
        }
        int i3 = i - size;
        if (i3 >= 0 && i3 < size2) {
            return false;
        }
        int i4 = i3 - size2;
        return (i4 <= 0 || i4 >= size3) && (i2 = i4 - size3) > 0 && i2 < size4;
    }

    public boolean isLocalSearch(int i) {
        return !isRecentSearchDisplayed() && this.searchResultHashtags.isEmpty() && i >= 0 && i < this.searchResult.size();
    }

    @Override // org.rbmain.ui.Components.RecyclerListView.SelectionAdapter
    public boolean isEnabled(RecyclerView.ViewHolder viewHolder) {
        int itemViewType = viewHolder.getItemViewType();
        return (itemViewType == 1 || itemViewType == 3) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateViewHolder$10(View view, int i) {
        DialogsSearchAdapterDelegate dialogsSearchAdapterDelegate = this.delegate;
        if (dialogsSearchAdapterDelegate != null) {
            dialogsSearchAdapterDelegate.didPressedOnSubDialog(((Integer) view.getTag()).intValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$onCreateViewHolder$11(View view, int i) {
        DialogsSearchAdapterDelegate dialogsSearchAdapterDelegate = this.delegate;
        if (dialogsSearchAdapterDelegate == null) {
            return true;
        }
        dialogsSearchAdapterDelegate.needRemoveHint(((Integer) view.getTag()).intValue());
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View dialogCell = null;
        switch (i) {
            case 0:
                dialogCell = new ProfileSearchCell(this.mContext);
                break;
            case 1:
                dialogCell = new GraySectionCell(this.mContext);
                break;
            case 2:
                dialogCell = new DialogCell(null, this.mContext, false, true);
                break;
            case 3:
                FlickerLoadingView flickerLoadingView = new FlickerLoadingView(this.mContext);
                flickerLoadingView.setViewType(1);
                flickerLoadingView.setIsSingleCell(true);
                dialogCell = flickerLoadingView;
                break;
            case 4:
                dialogCell = new HashtagSearchCell(this.mContext);
                break;
            case 5:
                RecyclerListView recyclerListView = new RecyclerListView(this, this.mContext) { // from class: org.rbmain.ui.Adapters.DialogsSearchAdapter.2
                    @Override // org.rbmain.ui.Components.RecyclerListView, androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
                    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
                        if (getParent() != null && getParent().getParent() != null) {
                            ViewParent parent = getParent().getParent();
                            boolean z = true;
                            if (!canScrollHorizontally(-1) && !canScrollHorizontally(1)) {
                                z = false;
                            }
                            parent.requestDisallowInterceptTouchEvent(z);
                        }
                        return super.onInterceptTouchEvent(motionEvent);
                    }
                };
                recyclerListView.setTag(9);
                recyclerListView.setItemAnimator(null);
                recyclerListView.setLayoutAnimation(null);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, this.mContext) { // from class: org.rbmain.ui.Adapters.DialogsSearchAdapter.3
                    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
                    public boolean supportsPredictiveItemAnimations() {
                        return false;
                    }
                };
                linearLayoutManager.setOrientation(0);
                recyclerListView.setLayoutManager(linearLayoutManager);
                recyclerListView.setAdapter(new CategoryAdapterRecycler(false));
                recyclerListView.setOnItemClickListener(new RecyclerListView.OnItemClickListener() { // from class: org.rbmain.ui.Adapters.DialogsSearchAdapter$$ExternalSyntheticLambda12
                    @Override // org.rbmain.ui.Components.RecyclerListView.OnItemClickListener
                    public final void onItemClick(View view, int i2) {
                        this.f$0.lambda$onCreateViewHolder$10(view, i2);
                    }
                });
                recyclerListView.setOnItemLongClickListener(new RecyclerListView.OnItemLongClickListener() { // from class: org.rbmain.ui.Adapters.DialogsSearchAdapter$$ExternalSyntheticLambda13
                    @Override // org.rbmain.ui.Components.RecyclerListView.OnItemLongClickListener
                    public final boolean onItemClick(View view, int i2) {
                        return this.f$0.lambda$onCreateViewHolder$11(view, i2);
                    }
                });
                this.innerListView = recyclerListView;
                dialogCell = recyclerListView;
                break;
            case 6:
                dialogCell = new TextCell(this.mContext, 16, false);
                break;
        }
        if (i == 5) {
            dialogCell.setLayoutParams(new RecyclerView.LayoutParams(-1, AndroidUtilities.dp(86.0f)));
        } else {
            dialogCell.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        }
        return new RecyclerListView.Holder(dialogCell);
    }

    /* JADX WARN: Code restructure failed: missing block: B:95:0x0275, code lost:
    
        if (r0.startsWith("@" + r3.username) != false) goto L96;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r10v6, types: [org.rbmain.tgnet.TLRPC$Chat] */
    /* JADX WARN: Type inference failed for: r10v8 */
    /* JADX WARN: Type inference failed for: r10v9 */
    /* JADX WARN: Type inference failed for: r11v6, types: [android.text.SpannableStringBuilder] */
    /* JADX WARN: Type inference failed for: r2v6, types: [android.text.SpannableStringBuilder] */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.ViewHolder r19, int r20) {
        /*
            Method dump skipped, instructions count: 867
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.Adapters.DialogsSearchAdapter.onBindViewHolder(androidx.recyclerview.widget.RecyclerView$ViewHolder, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onBindViewHolder$12(View view) {
        DialogsSearchAdapterDelegate dialogsSearchAdapterDelegate = this.delegate;
        if (dialogsSearchAdapterDelegate != null) {
            dialogsSearchAdapterDelegate.needClearList();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onBindViewHolder$13(View view) {
        DialogsSearchAdapterDelegate dialogsSearchAdapterDelegate = this.delegate;
        if (dialogsSearchAdapterDelegate != null) {
            dialogsSearchAdapterDelegate.needClearList();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        if (isRecentSearchDisplayed()) {
            int i2 = !MediaDataController.getInstance(this.currentAccount).hints.isEmpty() ? 1 : 0;
            if (i < i2) {
                return 5;
            }
            return i == i2 ? 1 : 0;
        }
        if (!this.searchResultHashtags.isEmpty()) {
            return i == 0 ? 1 : 4;
        }
        ArrayList<TLObject> globalSearch = this.searchAdapterHelper.getGlobalSearch();
        int size = this.searchResult.size();
        int size2 = this.searchAdapterHelper.getLocalServerSearch().size();
        int size3 = this.searchAdapterHelper.getPhoneSearch().size();
        int size4 = globalSearch.isEmpty() ? 0 : globalSearch.size() + 1;
        int size5 = this.searchResultMessages.isEmpty() ? 0 : this.searchResultMessages.size() + 1;
        if (i >= 0 && i < size) {
            return 0;
        }
        int i3 = i - size;
        if (i3 >= 0 && i3 < size2) {
            return 0;
        }
        int i4 = i3 - size2;
        if (i4 >= 0 && i4 < size3) {
            Object item = getItem(i4);
            if (item instanceof String) {
                return "section".equals((String) item) ? 1 : 6;
            }
            return 0;
        }
        int i5 = i4 - size3;
        if (i5 >= 0 && i5 < size4) {
            return i5 == 0 ? 1 : 0;
        }
        int i6 = i5 - size4;
        if (i6 < 0 || i6 >= size5) {
            return 3;
        }
        return i6 == 0 ? 1 : 2;
    }

    public void setFiltersDelegate(FilteredSearchView.Delegate delegate, boolean z) {
        this.filtersDelegate = delegate;
        if (delegate == null || !z) {
            return;
        }
        delegate.updateFiltersView(false, null, this.localTipDates);
    }

    public int getCurrentItemCount() {
        return this.currentItemCount;
    }
}
