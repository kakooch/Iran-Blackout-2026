package ir.eitaa.ui.Adapters;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.collection.LongSparseArray;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ir.eitaa.SQLite.SQLiteCursor;
import ir.eitaa.SQLite.SQLitePreparedStatement;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ChatObject;
import ir.eitaa.messenger.ContactsController;
import ir.eitaa.messenger.DialogObject;
import ir.eitaa.messenger.DispatchQueue;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MediaDataController;
import ir.eitaa.messenger.MessageObject;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.messenger.MessagesStorage;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.UserConfig;
import ir.eitaa.messenger.UserObject;
import ir.eitaa.messenger.Utilities;
import ir.eitaa.tgnet.ConnectionsManager;
import ir.eitaa.tgnet.RequestDelegate;
import ir.eitaa.tgnet.TLObject;
import ir.eitaa.tgnet.TLRPC$Chat;
import ir.eitaa.tgnet.TLRPC$EncryptedChat;
import ir.eitaa.tgnet.TLRPC$Message;
import ir.eitaa.tgnet.TLRPC$Peer;
import ir.eitaa.tgnet.TLRPC$TL_dialog;
import ir.eitaa.tgnet.TLRPC$TL_error;
import ir.eitaa.tgnet.TLRPC$TL_inputMessagesFilterEmpty;
import ir.eitaa.tgnet.TLRPC$TL_inputPeerEmpty;
import ir.eitaa.tgnet.TLRPC$TL_messages_searchGlobal;
import ir.eitaa.tgnet.TLRPC$TL_topPeer;
import ir.eitaa.tgnet.TLRPC$User;
import ir.eitaa.tgnet.TLRPC$messages_Messages;
import ir.eitaa.ui.Adapters.FiltersView;
import ir.eitaa.ui.Adapters.SearchAdapterHelper;
import ir.eitaa.ui.Cells.DialogCell;
import ir.eitaa.ui.Cells.GraySectionCell;
import ir.eitaa.ui.Cells.HashtagSearchCell;
import ir.eitaa.ui.Cells.HintDialogCell;
import ir.eitaa.ui.Cells.InviteUserCell;
import ir.eitaa.ui.Cells.ProfileSearchCell;
import ir.eitaa.ui.Cells.TextCell;
import ir.eitaa.ui.Components.FlickerLoadingView;
import ir.eitaa.ui.Components.RecyclerListView;
import ir.eitaa.ui.FilteredSearchView;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class DialogsSearchAdapter extends RecyclerListView.SelectionAdapter {
    public static ArrayList<RecentSearchObject> recentSearchObjects = new ArrayList<>();
    public static LongSparseArray<RecentSearchObject> recentSearchObjectsById = new LongSparseArray<>();
    private int currentItemCount;
    private String currentMessagesQuery;
    private DialogsSearchAdapterDelegate delegate;
    private int dialogsType;
    private FilteredSearchView.Delegate filtersDelegate;
    private int folderId;
    private RecyclerListView innerListView;
    private int lastGlobalSearchId;
    private int lastLocalSearchId;
    private int lastMessagesSearchId;
    private String lastMessagesSearchString;
    private int lastReqId;
    private int lastSearchId;
    private String lastSearchText;
    private boolean localTipArchive;
    private Context mContext;
    private boolean messagesSearchEndReached;
    private int needMessagesSearch;
    private int nextSearchRate;
    private ArrayList<ContactsController.Contact> phoneBookContacts;
    private SearchAdapterHelper searchAdapterHelper;
    private int searchInContactsCount;
    private int searchInUsersCount;
    private Runnable searchRunnable;
    private Runnable searchRunnable2;
    private boolean searchWas;
    private long selfUserId;
    int waitingResponseCount;
    private ArrayList<Object> searchResult = new ArrayList<>();
    private ArrayList<CharSequence> searchResultNames = new ArrayList<>();
    private ArrayList<MessageObject> searchResultMessages = new ArrayList<>();
    private ArrayList<String> searchResultHashtags = new ArrayList<>();
    private int reqId = 0;
    private int currentAccount = UserConfig.selectedAccount;
    private ArrayList<FiltersView.DateData> localTipDates = new ArrayList<>();

    public static class DialogSearchResult {
        public int date;
        public CharSequence name;
        public TLObject object;
    }

    public interface DialogsSearchAdapterDelegate {
        void didPressedOnSubDialog(long did);

        boolean isForward();

        boolean isSelected(long dialogId);

        void mxbPressed(String phone);

        void needClearList();

        void needRemoveHint(long did);

        void runResultsEnterAnimation();

        void searchStateChanged(boolean searching, boolean animated);
    }

    public interface OnRecentSearchLoaded {
        void setRecentSearch(ArrayList<RecentSearchObject> arrayList, LongSparseArray<RecentSearchObject> hashMap);
    }

    public static class RecentSearchObject {
        public int date;
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

    public static class CategoryAdapterRecycler extends RecyclerListView.SelectionAdapter {
        private final int currentAccount;
        private boolean drawChecked;
        private final Context mContext;

        @Override // ir.eitaa.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder holder) {
            return true;
        }

        public CategoryAdapterRecycler(Context context, int account, boolean drawChecked) {
            this.drawChecked = drawChecked;
            this.mContext = context;
            this.currentAccount = account;
        }

        public void setIndex(int value) {
            notifyDataSetChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            HintDialogCell hintDialogCell = new HintDialogCell(this.mContext, this.drawChecked);
            hintDialogCell.setLayoutParams(new RecyclerView.LayoutParams(AndroidUtilities.dp(80.0f), AndroidUtilities.dp(86.0f)));
            return new RecyclerListView.Holder(hintDialogCell);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            TLRPC$Chat chat;
            String firstName;
            HintDialogCell hintDialogCell = (HintDialogCell) holder.itemView;
            TLRPC$TL_topPeer tLRPC$TL_topPeer = MediaDataController.getInstance(this.currentAccount).hints.get(position);
            new TLRPC$TL_dialog();
            TLRPC$Peer tLRPC$Peer = tLRPC$TL_topPeer.peer;
            long j = tLRPC$Peer.user_id;
            TLRPC$User user = null;
            if (j != 0) {
                user = MessagesController.getInstance(this.currentAccount).getUser(Long.valueOf(tLRPC$TL_topPeer.peer.user_id));
                chat = null;
            } else {
                long j2 = tLRPC$Peer.channel_id;
                if (j2 != 0) {
                    j = -j2;
                    chat = MessagesController.getInstance(this.currentAccount).getChat(Long.valueOf(tLRPC$TL_topPeer.peer.channel_id));
                } else {
                    long j3 = tLRPC$Peer.chat_id;
                    if (j3 != 0) {
                        j = -j3;
                        chat = MessagesController.getInstance(this.currentAccount).getChat(Long.valueOf(tLRPC$TL_topPeer.peer.chat_id));
                    } else {
                        chat = null;
                        j = 0;
                    }
                }
            }
            hintDialogCell.setTag(Long.valueOf(j));
            if (user != null) {
                firstName = UserObject.getFirstName(user);
            } else {
                firstName = chat != null ? chat.title : "";
            }
            hintDialogCell.setDialog(j, true, firstName);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return MediaDataController.getInstance(this.currentAccount).hints.size();
        }
    }

    public DialogsSearchAdapter(Context context, int messagesSearch, int type) {
        SearchAdapterHelper searchAdapterHelper = new SearchAdapterHelper(false);
        this.searchAdapterHelper = searchAdapterHelper;
        searchAdapterHelper.setDelegate(new SearchAdapterHelper.SearchAdapterHelperDelegate() { // from class: ir.eitaa.ui.Adapters.DialogsSearchAdapter.1
            @Override // ir.eitaa.ui.Adapters.SearchAdapterHelper.SearchAdapterHelperDelegate
            public /* synthetic */ LongSparseArray getExcludeCallParticipants() {
                return SearchAdapterHelper.SearchAdapterHelperDelegate.CC.$default$getExcludeCallParticipants(this);
            }

            @Override // ir.eitaa.ui.Adapters.SearchAdapterHelper.SearchAdapterHelperDelegate
            public /* synthetic */ LongSparseArray getExcludeUsers() {
                return SearchAdapterHelper.SearchAdapterHelperDelegate.CC.$default$getExcludeUsers(this);
            }

            @Override // ir.eitaa.ui.Adapters.SearchAdapterHelper.SearchAdapterHelperDelegate
            public void onDataSetChanged(int searchId) {
                DialogsSearchAdapter dialogsSearchAdapter = DialogsSearchAdapter.this;
                dialogsSearchAdapter.waitingResponseCount--;
                dialogsSearchAdapter.lastGlobalSearchId = searchId;
                if (DialogsSearchAdapter.this.lastLocalSearchId != searchId) {
                    DialogsSearchAdapter.this.searchResult.clear();
                }
                if (DialogsSearchAdapter.this.lastMessagesSearchId != searchId) {
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

            @Override // ir.eitaa.ui.Adapters.SearchAdapterHelper.SearchAdapterHelperDelegate
            public void onSetHashtags(ArrayList<SearchAdapterHelper.HashtagObject> arrayList, HashMap<String, SearchAdapterHelper.HashtagObject> hashMap) {
                for (int i = 0; i < arrayList.size(); i++) {
                    DialogsSearchAdapter.this.searchResultHashtags.add(arrayList.get(i).hashtag);
                }
                if (DialogsSearchAdapter.this.delegate != null) {
                    DialogsSearchAdapter.this.delegate.searchStateChanged(DialogsSearchAdapter.this.waitingResponseCount > 0, false);
                }
                DialogsSearchAdapter.this.notifyDataSetChanged();
            }

            @Override // ir.eitaa.ui.Adapters.SearchAdapterHelper.SearchAdapterHelperDelegate
            public boolean canApplySearchResults(int searchId) {
                return searchId == DialogsSearchAdapter.this.lastSearchId;
            }
        });
        this.mContext = context;
        this.needMessagesSearch = messagesSearch;
        this.dialogsType = type;
        this.selfUserId = UserConfig.getInstance(this.currentAccount).getClientUserId();
        loadRecentSearch();
        MediaDataController.getInstance(this.currentAccount).loadHints(true);
    }

    public RecyclerListView getInnerListView() {
        return this.innerListView;
    }

    public void setDelegate(DialogsSearchAdapterDelegate delegate) {
        this.delegate = delegate;
    }

    public boolean isMessagesSearchEndReached() {
        return this.messagesSearchEndReached;
    }

    public void loadMoreSearchMessages() {
        if (this.reqId != 0) {
            return;
        }
        searchMessagesInternal(this.lastMessagesSearchString, this.lastMessagesSearchId);
    }

    public String getLastSearchString() {
        return this.lastMessagesSearchString;
    }

    private void searchMessagesInternal(final String query, final int searchId) {
        if (this.needMessagesSearch != 0) {
            if (TextUtils.isEmpty(this.lastMessagesSearchString) && TextUtils.isEmpty(query)) {
                return;
            }
            if (this.reqId != 0) {
                ConnectionsManager.getInstance(this.currentAccount).cancelRequest(this.reqId, true);
                this.reqId = 0;
            }
            if (TextUtils.isEmpty(query)) {
                this.searchResultMessages.clear();
                this.lastReqId = 0;
                this.lastMessagesSearchString = null;
                this.searchWas = false;
                notifyDataSetChanged();
                return;
            }
            final TLRPC$TL_messages_searchGlobal tLRPC$TL_messages_searchGlobal = new TLRPC$TL_messages_searchGlobal();
            tLRPC$TL_messages_searchGlobal.limit = 20;
            tLRPC$TL_messages_searchGlobal.q = query;
            tLRPC$TL_messages_searchGlobal.filter = new TLRPC$TL_inputMessagesFilterEmpty();
            tLRPC$TL_messages_searchGlobal.flags |= 1;
            tLRPC$TL_messages_searchGlobal.folder_id = this.folderId;
            if (query.equals(this.lastMessagesSearchString) && !this.searchResultMessages.isEmpty()) {
                ArrayList<MessageObject> arrayList = this.searchResultMessages;
                MessageObject messageObject = arrayList.get(arrayList.size() - 1);
                tLRPC$TL_messages_searchGlobal.offset_id = messageObject.getId();
                tLRPC$TL_messages_searchGlobal.offset_rate = this.nextSearchRate;
                tLRPC$TL_messages_searchGlobal.offset_peer = MessagesController.getInstance(this.currentAccount).getInputPeer(MessageObject.getPeerId(messageObject.messageOwner.peer_id));
            } else {
                tLRPC$TL_messages_searchGlobal.offset_rate = 0;
                tLRPC$TL_messages_searchGlobal.offset_id = 0;
                tLRPC$TL_messages_searchGlobal.offset_peer = new TLRPC$TL_inputPeerEmpty();
            }
            this.lastMessagesSearchString = query;
            final int i = this.lastReqId + 1;
            this.lastReqId = i;
            this.reqId = ConnectionsManager.getInstance(this.currentAccount).sendRequest(tLRPC$TL_messages_searchGlobal, new RequestDelegate() { // from class: ir.eitaa.ui.Adapters.-$$Lambda$DialogsSearchAdapter$NSdJHRz51ZchMclka9xeKTUTZsQ
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$searchMessagesInternal$1$DialogsSearchAdapter(query, i, searchId, tLRPC$TL_messages_searchGlobal, tLObject, tLRPC$TL_error);
                }
            }, 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$searchMessagesInternal$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$searchMessagesInternal$1$DialogsSearchAdapter(final String str, final int i, final int i2, final TLRPC$TL_messages_searchGlobal tLRPC$TL_messages_searchGlobal, final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        final ArrayList arrayList = new ArrayList();
        if (tLRPC$TL_error == null) {
            TLRPC$messages_Messages tLRPC$messages_Messages = (TLRPC$messages_Messages) tLObject;
            LongSparseArray longSparseArray = new LongSparseArray();
            LongSparseArray longSparseArray2 = new LongSparseArray();
            for (int i3 = 0; i3 < tLRPC$messages_Messages.chats.size(); i3++) {
                TLRPC$Chat tLRPC$Chat = tLRPC$messages_Messages.chats.get(i3);
                longSparseArray.put(tLRPC$Chat.id, tLRPC$Chat);
            }
            for (int i4 = 0; i4 < tLRPC$messages_Messages.users.size(); i4++) {
                TLRPC$User tLRPC$User = tLRPC$messages_Messages.users.get(i4);
                longSparseArray2.put(tLRPC$User.id, tLRPC$User);
            }
            for (int i5 = 0; i5 < tLRPC$messages_Messages.messages.size(); i5++) {
                MessageObject messageObject = new MessageObject(this.currentAccount, tLRPC$messages_Messages.messages.get(i5), (LongSparseArray<TLRPC$User>) longSparseArray2, (LongSparseArray<TLRPC$Chat>) longSparseArray, false, true);
                arrayList.add(messageObject);
                messageObject.setQuery(str);
            }
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.Adapters.-$$Lambda$DialogsSearchAdapter$MlNg2aTF9aO-hl2MguXyIzUy6qQ
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$searchMessagesInternal$0$DialogsSearchAdapter(i, i2, tLRPC$TL_error, str, tLObject, tLRPC$TL_messages_searchGlobal, arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$searchMessagesInternal$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$searchMessagesInternal$0$DialogsSearchAdapter(int i, int i2, TLRPC$TL_error tLRPC$TL_error, String str, TLObject tLObject, TLRPC$TL_messages_searchGlobal tLRPC$TL_messages_searchGlobal, ArrayList arrayList) {
        if (i == this.lastReqId && (i2 <= 0 || i2 == this.lastSearchId)) {
            this.waitingResponseCount--;
            if (tLRPC$TL_error == null) {
                this.currentMessagesQuery = str;
                TLRPC$messages_Messages tLRPC$messages_Messages = (TLRPC$messages_Messages) tLObject;
                MessagesStorage.getInstance(this.currentAccount).putUsersAndChats(tLRPC$messages_Messages.users, tLRPC$messages_Messages.chats, true, true);
                MessagesController.getInstance(this.currentAccount).putUsers(tLRPC$messages_Messages.users, false);
                MessagesController.getInstance(this.currentAccount).putChats(tLRPC$messages_Messages.chats, false);
                if (tLRPC$TL_messages_searchGlobal.offset_id == 0) {
                    this.searchResultMessages.clear();
                }
                this.nextSearchRate = tLRPC$messages_Messages.next_rate;
                for (int i3 = 0; i3 < tLRPC$messages_Messages.messages.size(); i3++) {
                    TLRPC$Message tLRPC$Message = tLRPC$messages_Messages.messages.get(i3);
                    int i4 = MessagesController.getInstance(this.currentAccount).deletedHistory.get(MessageObject.getDialogId(tLRPC$Message));
                    if (i4 == 0 || tLRPC$Message.id > i4) {
                        this.searchResultMessages.add((MessageObject) arrayList.get(i3));
                        long dialogId = MessageObject.getDialogId(tLRPC$Message);
                        ConcurrentHashMap<Long, Integer> concurrentHashMap = tLRPC$Message.out ? MessagesController.getInstance(this.currentAccount).dialogs_read_outbox_max : MessagesController.getInstance(this.currentAccount).dialogs_read_inbox_max;
                        Integer numValueOf = (Integer) concurrentHashMap.get(Long.valueOf(dialogId));
                        if (numValueOf == null) {
                            numValueOf = Integer.valueOf(MessagesStorage.getInstance(this.currentAccount).getDialogReadMax(tLRPC$Message.out, dialogId));
                            concurrentHashMap.put(Long.valueOf(dialogId), numValueOf);
                        }
                        tLRPC$Message.unread = numValueOf.intValue() < tLRPC$Message.id;
                    }
                }
                this.searchWas = true;
                this.messagesSearchEndReached = tLRPC$messages_Messages.messages.size() != 20;
                if (i2 > 0) {
                    this.lastMessagesSearchId = i2;
                    if (this.lastLocalSearchId != i2) {
                        this.searchResult.clear();
                    }
                    if (this.lastGlobalSearchId != i2) {
                        this.searchAdapterHelper.clear();
                    }
                }
                DialogsSearchAdapterDelegate dialogsSearchAdapterDelegate = this.delegate;
                if (dialogsSearchAdapterDelegate != null) {
                    dialogsSearchAdapterDelegate.searchStateChanged(this.waitingResponseCount > 0, true);
                    this.delegate.runResultsEnterAnimation();
                }
                notifyDataSetChanged();
            }
        }
        this.reqId = 0;
    }

    public boolean hasRecentSearch() {
        int i = this.dialogsType;
        return (i == 2 || i == 4 || i == 5 || i == 6 || i == 11 || (recentSearchObjects.isEmpty() && MediaDataController.getInstance(this.currentAccount).hints.isEmpty())) ? false : true;
    }

    public boolean isRecentSearchDisplayed() {
        int i;
        return (this.needMessagesSearch == 2 || this.searchWas || (recentSearchObjects.isEmpty() && MediaDataController.getInstance(this.currentAccount).hints.isEmpty()) || (i = this.dialogsType) == 2 || i == 4 || i == 5 || i == 6 || i == 11) ? false : true;
    }

    public void loadRecentSearch() {
        loadRecentSearch(this.currentAccount, this.dialogsType, new OnRecentSearchLoaded() { // from class: ir.eitaa.ui.Adapters.-$$Lambda$DialogsSearchAdapter$0cWESkp--ayj7YZGtNWTef654DY
            @Override // ir.eitaa.ui.Adapters.DialogsSearchAdapter.OnRecentSearchLoaded
            public final void setRecentSearch(ArrayList arrayList, LongSparseArray longSparseArray) {
                this.f$0.lambda$loadRecentSearch$2$DialogsSearchAdapter(arrayList, longSparseArray);
            }
        });
    }

    public static void loadRecentSearch(final int currentAccount, final int dialogsType, final OnRecentSearchLoaded callback) {
        MessagesStorage.getInstance(currentAccount).getStorageQueue().postRunnable(new Runnable() { // from class: ir.eitaa.ui.Adapters.-$$Lambda$DialogsSearchAdapter$SsT830YDyQ2OOwqCUHt5HGCLPi4
            @Override // java.lang.Runnable
            public final void run() {
                DialogsSearchAdapter.lambda$loadRecentSearch$5(currentAccount, dialogsType, callback);
            }
        });
    }

    static /* synthetic */ void lambda$loadRecentSearch$5(int i, int i2, final OnRecentSearchLoaded onRecentSearchLoaded) {
        boolean z;
        try {
            SQLiteCursor sQLiteCursorQueryFinalized = MessagesStorage.getInstance(i).getDatabase().queryFinalized("SELECT did, date FROM search_recent WHERE 1", new Object[0]);
            ArrayList<Long> arrayList = new ArrayList<>();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            new ArrayList();
            final ArrayList arrayList4 = new ArrayList();
            final LongSparseArray longSparseArray = new LongSparseArray();
            while (sQLiteCursorQueryFinalized.next()) {
                long jLongValue = sQLiteCursorQueryFinalized.longValue(0);
                if (DialogObject.isEncryptedDialog(jLongValue)) {
                    if (i2 == 0 || i2 == 3) {
                        int encryptedChatId = DialogObject.getEncryptedChatId(jLongValue);
                        if (!arrayList3.contains(Integer.valueOf(encryptedChatId))) {
                            arrayList3.add(Integer.valueOf(encryptedChatId));
                            z = true;
                        }
                    }
                    z = false;
                } else if (DialogObject.isUserDialog(jLongValue)) {
                    if (i2 != 2 && !arrayList.contains(Long.valueOf(jLongValue))) {
                        arrayList.add(Long.valueOf(jLongValue));
                        z = true;
                    }
                    z = false;
                } else {
                    long j = -jLongValue;
                    if (!arrayList2.contains(Long.valueOf(j))) {
                        arrayList2.add(Long.valueOf(j));
                        z = true;
                    }
                    z = false;
                }
                if (z) {
                    RecentSearchObject recentSearchObject = new RecentSearchObject();
                    recentSearchObject.did = jLongValue;
                    recentSearchObject.date = sQLiteCursorQueryFinalized.intValue(1);
                    arrayList4.add(recentSearchObject);
                    longSparseArray.put(recentSearchObject.did, recentSearchObject);
                }
            }
            sQLiteCursorQueryFinalized.dispose();
            ArrayList<TLRPC$User> arrayList5 = new ArrayList<>();
            if (!arrayList3.isEmpty()) {
                ArrayList<TLRPC$EncryptedChat> arrayList6 = new ArrayList<>();
                MessagesStorage.getInstance(i).getEncryptedChatsInternal(TextUtils.join(",", arrayList3), arrayList6, arrayList);
                for (int i3 = 0; i3 < arrayList6.size(); i3++) {
                    RecentSearchObject recentSearchObject2 = (RecentSearchObject) longSparseArray.get(DialogObject.makeEncryptedDialogId(arrayList6.get(i3).id));
                    if (recentSearchObject2 != null) {
                        recentSearchObject2.object = arrayList6.get(i3);
                    }
                }
            }
            if (!arrayList2.isEmpty()) {
                ArrayList<TLRPC$Chat> arrayList7 = new ArrayList<>();
                MessagesStorage.getInstance(i).getChatsInternal(TextUtils.join(",", arrayList2), arrayList7);
                for (int i4 = 0; i4 < arrayList7.size(); i4++) {
                    TLRPC$Chat tLRPC$Chat = arrayList7.get(i4);
                    long j2 = -tLRPC$Chat.id;
                    if (tLRPC$Chat.migrated_to != null) {
                        RecentSearchObject recentSearchObject3 = (RecentSearchObject) longSparseArray.get(j2);
                        longSparseArray.remove(j2);
                        if (recentSearchObject3 != null) {
                            arrayList4.remove(recentSearchObject3);
                        }
                    } else {
                        RecentSearchObject recentSearchObject4 = (RecentSearchObject) longSparseArray.get(j2);
                        if (recentSearchObject4 != null) {
                            recentSearchObject4.object = tLRPC$Chat;
                        }
                    }
                }
            }
            if (!arrayList.isEmpty()) {
                MessagesStorage.getInstance(i).getUsersInternal(TextUtils.join(",", arrayList), arrayList5);
                for (int i5 = 0; i5 < arrayList5.size(); i5++) {
                    TLRPC$User tLRPC$User = arrayList5.get(i5);
                    RecentSearchObject recentSearchObject5 = (RecentSearchObject) longSparseArray.get(tLRPC$User.id);
                    if (recentSearchObject5 != null) {
                        recentSearchObject5.object = tLRPC$User;
                    }
                }
            }
            Collections.sort(arrayList4, $$Lambda$DialogsSearchAdapter$80O6852YLD47TcUzvMzHQxVimc.INSTANCE);
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.Adapters.-$$Lambda$DialogsSearchAdapter$BmYwxuoYSXC_XWP3DuWSMQxxp0Y
                @Override // java.lang.Runnable
                public final void run() {
                    onRecentSearchLoaded.setRecentSearch(arrayList4, longSparseArray);
                }
            });
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    static /* synthetic */ int lambda$loadRecentSearch$3(RecentSearchObject recentSearchObject, RecentSearchObject recentSearchObject2) {
        int i = recentSearchObject.date;
        int i2 = recentSearchObject2.date;
        if (i < i2) {
            return 1;
        }
        return i > i2 ? -1 : 0;
    }

    public void putRecentSearch(final long did, TLObject object) {
        RecentSearchObject recentSearchObject = recentSearchObjectsById.get(did);
        if (recentSearchObject == null) {
            recentSearchObject = new RecentSearchObject();
            recentSearchObjectsById.put(did, recentSearchObject);
        } else {
            recentSearchObjects.remove(recentSearchObject);
        }
        recentSearchObjects.add(0, recentSearchObject);
        recentSearchObject.did = did;
        recentSearchObject.object = object;
        recentSearchObject.date = (int) (System.currentTimeMillis() / 1000);
        notifyDataSetChanged();
        MessagesStorage.getInstance(this.currentAccount).getStorageQueue().postRunnable(new Runnable() { // from class: ir.eitaa.ui.Adapters.-$$Lambda$DialogsSearchAdapter$12fnp4T8RY4wbFVHPnGZc07_VIg
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$putRecentSearch$6$DialogsSearchAdapter(did);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$putRecentSearch$6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$putRecentSearch$6$DialogsSearchAdapter(long j) {
        try {
            SQLitePreparedStatement sQLitePreparedStatementExecuteFast = MessagesStorage.getInstance(this.currentAccount).getDatabase().executeFast("REPLACE INTO search_recent VALUES(?, ?)");
            sQLitePreparedStatementExecuteFast.requery();
            sQLitePreparedStatementExecuteFast.bindLong(1, j);
            sQLitePreparedStatementExecuteFast.bindInteger(2, (int) (System.currentTimeMillis() / 1000));
            sQLitePreparedStatementExecuteFast.step();
            sQLitePreparedStatementExecuteFast.dispose();
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public void clearRecentSearch() {
        recentSearchObjectsById = new LongSparseArray<>();
        recentSearchObjects = new ArrayList<>();
        notifyDataSetChanged();
        MessagesStorage.getInstance(this.currentAccount).getStorageQueue().postRunnable(new Runnable() { // from class: ir.eitaa.ui.Adapters.-$$Lambda$DialogsSearchAdapter$PXp9-0dBUvwFmTjke4SvAKyoC3U
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$clearRecentSearch$7$DialogsSearchAdapter();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$clearRecentSearch$7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$clearRecentSearch$7$DialogsSearchAdapter() {
        try {
            MessagesStorage.getInstance(this.currentAccount).getDatabase().executeFast("DELETE FROM search_recent WHERE 1").stepThis().dispose();
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public void removeRecentSearch(final long did) {
        RecentSearchObject recentSearchObject = recentSearchObjectsById.get(did);
        if (recentSearchObject == null) {
            return;
        }
        recentSearchObjectsById.remove(did);
        recentSearchObjects.remove(recentSearchObject);
        notifyDataSetChanged();
        MessagesStorage.getInstance(this.currentAccount).getStorageQueue().postRunnable(new Runnable() { // from class: ir.eitaa.ui.Adapters.-$$Lambda$DialogsSearchAdapter$B-JS_Tvzo8VghMydPFOl4ylpeE8
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$removeRecentSearch$8$DialogsSearchAdapter(did);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$removeRecentSearch$8, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$removeRecentSearch$8$DialogsSearchAdapter(long j) {
        try {
            MessagesStorage.getInstance(this.currentAccount).getDatabase().executeFast("DELETE FROM search_recent WHERE did = " + j).stepThis().dispose();
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public void addHashtagsFromMessage(CharSequence message) {
        this.searchAdapterHelper.addHashtagsFromMessage(message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setRecentSearch, reason: merged with bridge method [inline-methods] */
    public void lambda$loadRecentSearch$2$DialogsSearchAdapter(ArrayList<RecentSearchObject> arrayList, LongSparseArray<RecentSearchObject> hashMap) {
        recentSearchObjects = arrayList;
        recentSearchObjectsById = hashMap;
        for (int i = 0; i < recentSearchObjects.size(); i++) {
            RecentSearchObject recentSearchObject = recentSearchObjects.get(i);
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

    private void searchDialogsInternal(final String query, final int searchId) {
        this.searchInContactsCount = 0;
        this.searchInUsersCount = 0;
        if (this.needMessagesSearch == 2) {
            return;
        }
        final String lowerCase = query.trim().toLowerCase();
        if (lowerCase.length() == 0) {
            this.lastSearchId = 0;
            updateSearchResults(new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), this.lastSearchId);
        } else {
            MessagesStorage.getInstance(this.currentAccount).getStorageQueue().postRunnable(new Runnable() { // from class: ir.eitaa.ui.Adapters.-$$Lambda$DialogsSearchAdapter$4DcSmkoRticgkBnZv7cY0S5BIyA
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$searchDialogsInternal$10$DialogsSearchAdapter(lowerCase, searchId, query);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$searchDialogsInternal$10, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$searchDialogsInternal$10$DialogsSearchAdapter(String str, int i, String str2) {
        ArrayList<Object> arrayList = new ArrayList<>();
        ArrayList<CharSequence> arrayList2 = new ArrayList<>();
        ArrayList<TLRPC$User> arrayList3 = new ArrayList<>();
        DialogsSearchAdapterDelegate dialogsSearchAdapterDelegate = this.delegate;
        MessagesStorage.getInstance(this.currentAccount).localSearchFull(this.dialogsType, str, dialogsSearchAdapterDelegate != null ? dialogsSearchAdapterDelegate.isForward() : false, arrayList, arrayList2, arrayList3, -1);
        this.searchInUsersCount = arrayList.size();
        if (UserConfig.mxbState && MessagesController.getInstance(UserConfig.selectedAccount).mxbEnabled) {
            searchInContacts(str, arrayList, arrayList2);
            this.searchInContactsCount = arrayList.size() - this.searchInUsersCount;
        }
        updateSearchResults(arrayList, arrayList2, arrayList3, i);
        FiltersView.fillTipDates(str, this.localTipDates);
        this.localTipArchive = false;
        if (str.length() >= 3 && (LocaleController.getString("ArchiveSearchFilter", R.string.ArchiveSearchFilter).toLowerCase().startsWith(str) || "archive".startsWith(str2))) {
            this.localTipArchive = true;
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.Adapters.-$$Lambda$DialogsSearchAdapter$xIv4quSB2RoWWEgYlzgNth3bkRI
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$searchDialogsInternal$9$DialogsSearchAdapter();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$searchDialogsInternal$9, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$searchDialogsInternal$9$DialogsSearchAdapter() {
        FilteredSearchView.Delegate delegate = this.filtersDelegate;
        if (delegate != null) {
            delegate.updateFiltersView(false, null, this.localTipDates, this.localTipArchive);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00b4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void searchInContacts(java.lang.String r18, java.util.ArrayList<java.lang.Object> r19, java.util.ArrayList<java.lang.CharSequence> r20) {
        /*
            Method dump skipped, instructions count: 270
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Adapters.DialogsSearchAdapter.searchInContacts(java.lang.String, java.util.ArrayList, java.util.ArrayList):void");
    }

    public void fetchContacts() {
        ArrayList<ContactsController.Contact> arrayList = new ArrayList<>(ContactsController.getInstance(this.currentAccount).phoneBookContacts);
        this.phoneBookContacts = arrayList;
        if (arrayList.isEmpty()) {
            ContactsController.getInstance(this.currentAccount).checkContacts();
        } else {
            Collections.sort(this.phoneBookContacts, $$Lambda$DialogsSearchAdapter$PWyorKy_lfd71vICWI1h54fE4k.INSTANCE);
        }
    }

    static /* synthetic */ int lambda$fetchContacts$11(ContactsController.Contact contact, ContactsController.Contact contact2) {
        int i = contact.imported;
        int i2 = contact2.imported;
        if (i > i2) {
            return -1;
        }
        return i < i2 ? 1 : 0;
    }

    private void updateSearchResults(final ArrayList<Object> result, final ArrayList<CharSequence> names, final ArrayList<TLRPC$User> encUsers, final int searchId) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.Adapters.-$$Lambda$DialogsSearchAdapter$v9toBheb3fM9ynafAv23OhAOgl0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$updateSearchResults$13$DialogsSearchAdapter(searchId, result, encUsers, names);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$updateSearchResults$13, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$updateSearchResults$13$DialogsSearchAdapter(int i, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3) {
        final long j;
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
            final Object obj = arrayList.get(i2);
            if (obj instanceof TLRPC$User) {
                TLRPC$User tLRPC$User = (TLRPC$User) obj;
                MessagesController.getInstance(this.currentAccount).putUser(tLRPC$User, true);
                j = tLRPC$User.id;
            } else if (obj instanceof TLRPC$Chat) {
                TLRPC$Chat tLRPC$Chat = (TLRPC$Chat) obj;
                MessagesController.getInstance(this.currentAccount).putChat(tLRPC$Chat, true);
                j = -tLRPC$Chat.id;
            } else {
                if (obj instanceof TLRPC$EncryptedChat) {
                    MessagesController.getInstance(this.currentAccount).putEncryptedChat((TLRPC$EncryptedChat) obj, true);
                }
                j = 0;
            }
            if (j != 0 && MessagesController.getInstance(this.currentAccount).dialogs_dict.get(j) == null) {
                MessagesStorage.getInstance(this.currentAccount).getDialogFolderId(j, new MessagesStorage.IntCallback() { // from class: ir.eitaa.ui.Adapters.-$$Lambda$DialogsSearchAdapter$WQdqzun3jXPLYL-kgODnMoCBD2Q
                    @Override // ir.eitaa.messenger.MessagesStorage.IntCallback
                    public final void run(int i3) {
                        this.f$0.lambda$updateSearchResults$12$DialogsSearchAdapter(j, obj, i3);
                    }
                });
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

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$updateSearchResults$12, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$updateSearchResults$12$DialogsSearchAdapter(long j, Object obj, int i) {
        if (i != -1) {
            TLRPC$TL_dialog tLRPC$TL_dialog = new TLRPC$TL_dialog();
            tLRPC$TL_dialog.id = j;
            if (i != 0) {
                tLRPC$TL_dialog.folder_id = i;
            }
            if (obj instanceof TLRPC$Chat) {
                tLRPC$TL_dialog.flags = ChatObject.isChannel((TLRPC$Chat) obj) ? 1 : 0;
            }
            MessagesController.getInstance(this.currentAccount).dialogs_dict.put(j, tLRPC$TL_dialog);
            MessagesController.getInstance(this.currentAccount).getAllDialogs().add(tLRPC$TL_dialog);
            MessagesController.getInstance(this.currentAccount).sortDialogs(null);
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

    public void searchDialogs(final String text, int folderId) throws InterruptedException {
        if (text != null && text.equals(this.lastSearchText) && (folderId == this.folderId || TextUtils.isEmpty(text))) {
            return;
        }
        this.lastSearchText = text;
        this.folderId = folderId;
        if (this.searchRunnable != null) {
            Utilities.searchQueue.cancelRunnable(this.searchRunnable);
            this.searchRunnable = null;
        }
        Runnable runnable = this.searchRunnable2;
        if (runnable != null) {
            AndroidUtilities.cancelRunOnUIThread(runnable);
            this.searchRunnable2 = null;
        }
        final String strTrim = text != null ? text.trim() : null;
        if (TextUtils.isEmpty(strTrim)) {
            this.searchAdapterHelper.unloadRecentHashtags();
            this.searchResult.clear();
            this.searchResultNames.clear();
            this.searchResultHashtags.clear();
            this.searchAdapterHelper.mergeResults(null);
            SearchAdapterHelper searchAdapterHelper = this.searchAdapterHelper;
            int i = this.dialogsType;
            searchAdapterHelper.queryServerSearch(null, true, true, i != 11, i != 11, i == 2 || i == 11, 0L, i == 0, 0, 0);
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
            this.localTipArchive = false;
            FilteredSearchView.Delegate delegate = this.filtersDelegate;
            if (delegate != null) {
                delegate.updateFiltersView(false, null, this.localTipDates, false);
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
        Runnable runnable2 = new Runnable() { // from class: ir.eitaa.ui.Adapters.-$$Lambda$DialogsSearchAdapter$B8ALW4B_bWnjse3Xaa3eP4ZsFK4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$searchDialogs$15$DialogsSearchAdapter(strTrim, i3, text);
            }
        };
        this.searchRunnable = runnable2;
        dispatchQueue.postRunnable(runnable2, 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$searchDialogs$15, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$searchDialogs$15$DialogsSearchAdapter(final String str, final int i, final String str2) {
        this.searchRunnable = null;
        searchDialogsInternal(str, i);
        Runnable runnable = new Runnable() { // from class: ir.eitaa.ui.Adapters.-$$Lambda$DialogsSearchAdapter$Kz_-6ZiSgn3D1IPKyXkWihd2F0c
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$searchDialogs$14$DialogsSearchAdapter(i, str, str2);
            }
        };
        this.searchRunnable2 = runnable;
        AndroidUtilities.runOnUIThread(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$searchDialogs$14, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$searchDialogs$14$DialogsSearchAdapter(int i, String str, String str2) {
        this.searchRunnable2 = null;
        if (i != this.lastSearchId) {
            return;
        }
        if (this.needMessagesSearch != 2) {
            SearchAdapterHelper searchAdapterHelper = this.searchAdapterHelper;
            int i2 = this.dialogsType;
            searchAdapterHelper.queryServerSearch(str, false, i2 != 4, true, (i2 == 4 || i2 == 11) ? false : true, i2 == 2 || i2 == 1, 0L, i2 == 0, 0, i);
        } else {
            this.waitingResponseCount -= 2;
        }
        if (this.needMessagesSearch == 0) {
            this.waitingResponseCount--;
        } else {
            searchMessagesInternal(str2, i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.waitingResponseCount == 3) {
            return 0;
        }
        if (isRecentSearchDisplayed()) {
            return (recentSearchObjects.isEmpty() ? 0 : recentSearchObjects.size() + 1) + (!MediaDataController.getInstance(this.currentAccount).hints.isEmpty() ? 1 : 0);
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
        if (this.searchInContactsCount != 0) {
            i++;
        }
        this.currentItemCount = i;
        return i;
    }

    public Object getItem(int i) {
        int i2;
        Object chat;
        if (isRecentSearchDisplayed()) {
            int i3 = !MediaDataController.getInstance(this.currentAccount).hints.isEmpty() ? 1 : 0;
            if (i <= i3 || (i2 = (i - 1) - i3) >= recentSearchObjects.size()) {
                return null;
            }
            TLObject tLObject = recentSearchObjects.get(i2).object;
            if (tLObject instanceof TLRPC$User) {
                chat = MessagesController.getInstance(this.currentAccount).getUser(Long.valueOf(((TLRPC$User) tLObject).id));
                if (chat == null) {
                    return tLObject;
                }
            } else if (!(tLObject instanceof TLRPC$Chat) || (chat = MessagesController.getInstance(this.currentAccount).getChat(Long.valueOf(((TLRPC$Chat) tLObject).id))) == null) {
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
        if (isRecentSearchDisplayed() || !this.searchResultHashtags.isEmpty()) {
            return false;
        }
        ArrayList<TLObject> globalSearch = this.searchAdapterHelper.getGlobalSearch();
        ArrayList<TLObject> localServerSearch = this.searchAdapterHelper.getLocalServerSearch();
        int size = this.searchResult.size();
        int size2 = localServerSearch.size();
        int size3 = this.searchAdapterHelper.getPhoneSearch().size();
        int size4 = globalSearch.isEmpty() ? 0 : globalSearch.size() + 1;
        int size5 = this.searchResultMessages.isEmpty() ? 0 : this.searchResultMessages.size() + 1;
        if (i >= 0 && i < size) {
            return false;
        }
        int i2 = i - size;
        if (i2 >= 0 && i2 < size2) {
            return false;
        }
        int i3 = i2 - size2;
        if (i3 > 0 && i3 < size3) {
            return false;
        }
        int i4 = i3 - size3;
        if (i4 > 0 && i4 < size4) {
            return true;
        }
        int i5 = i4 - size4;
        if (i5 <= 0 || i5 < size5) {
        }
        return false;
    }

    @Override // ir.eitaa.ui.Components.RecyclerListView.SelectionAdapter
    public boolean isEnabled(RecyclerView.ViewHolder holder) {
        int itemViewType = holder.getItemViewType();
        return (itemViewType == 1 || itemViewType == 3) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onCreateViewHolder$16, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onCreateViewHolder$16$DialogsSearchAdapter(View view, int i) {
        DialogsSearchAdapterDelegate dialogsSearchAdapterDelegate = this.delegate;
        if (dialogsSearchAdapterDelegate != null) {
            dialogsSearchAdapterDelegate.didPressedOnSubDialog(((Long) view.getTag()).longValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onCreateViewHolder$17, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean lambda$onCreateViewHolder$17$DialogsSearchAdapter(View view, int i) {
        DialogsSearchAdapterDelegate dialogsSearchAdapterDelegate = this.delegate;
        if (dialogsSearchAdapterDelegate == null) {
            return true;
        }
        dialogsSearchAdapterDelegate.needRemoveHint(((Long) view.getTag()).longValue());
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View profileSearchCell;
        View dialogCell;
        if (i == 0) {
            profileSearchCell = new ProfileSearchCell(this.mContext);
        } else if (i != 1) {
            if (i == 2) {
                dialogCell = new DialogCell(null, this.mContext, false, true);
            } else if (i == 3) {
                FlickerLoadingView flickerLoadingView = new FlickerLoadingView(this.mContext);
                flickerLoadingView.setViewType(1);
                flickerLoadingView.setIsSingleCell(true);
                dialogCell = flickerLoadingView;
            } else if (i == 4) {
                profileSearchCell = new HashtagSearchCell(this.mContext);
            } else if (i == 5) {
                RecyclerListView recyclerListView = new RecyclerListView(this.mContext) { // from class: ir.eitaa.ui.Adapters.DialogsSearchAdapter.2
                    @Override // ir.eitaa.ui.Components.RecyclerListView, androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
                    public boolean onInterceptTouchEvent(MotionEvent e) {
                        if (getParent() != null && getParent().getParent() != null) {
                            ViewParent parent = getParent().getParent();
                            boolean z = true;
                            if (!canScrollHorizontally(-1) && !canScrollHorizontally(1)) {
                                z = false;
                            }
                            parent.requestDisallowInterceptTouchEvent(z);
                        }
                        return super.onInterceptTouchEvent(e);
                    }
                };
                recyclerListView.setTag(9);
                recyclerListView.setItemAnimator(null);
                recyclerListView.setLayoutAnimation(null);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.mContext) { // from class: ir.eitaa.ui.Adapters.DialogsSearchAdapter.3
                    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
                    public boolean supportsPredictiveItemAnimations() {
                        return false;
                    }
                };
                linearLayoutManager.setOrientation(0);
                recyclerListView.setLayoutManager(linearLayoutManager);
                recyclerListView.setAdapter(new CategoryAdapterRecycler(this.mContext, this.currentAccount, false));
                recyclerListView.setOnItemClickListener(new RecyclerListView.OnItemClickListener() { // from class: ir.eitaa.ui.Adapters.-$$Lambda$DialogsSearchAdapter$tCFqfBox5kEfys797TJsbaTxWGY
                    @Override // ir.eitaa.ui.Components.RecyclerListView.OnItemClickListener
                    public final void onItemClick(View view, int i2) {
                        this.f$0.lambda$onCreateViewHolder$16$DialogsSearchAdapter(view, i2);
                    }
                });
                recyclerListView.setOnItemLongClickListener(new RecyclerListView.OnItemLongClickListener() { // from class: ir.eitaa.ui.Adapters.-$$Lambda$DialogsSearchAdapter$3cbcP8PnJnCHe2IB-TpWutm4fS0
                    @Override // ir.eitaa.ui.Components.RecyclerListView.OnItemLongClickListener
                    public final boolean onItemClick(View view, int i2) {
                        return this.f$0.lambda$onCreateViewHolder$17$DialogsSearchAdapter(view, i2);
                    }
                });
                this.innerListView = recyclerListView;
                profileSearchCell = recyclerListView;
            } else if (i == 1380) {
                dialogCell = new InviteUserCell(this.mContext, true);
            } else {
                profileSearchCell = new TextCell(this.mContext, 16, false);
            }
            profileSearchCell = dialogCell;
        } else {
            profileSearchCell = new GraySectionCell(this.mContext);
        }
        if (i == 5) {
            profileSearchCell.setLayoutParams(new RecyclerView.LayoutParams(-1, AndroidUtilities.dp(86.0f)));
        } else {
            profileSearchCell.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        }
        return new RecyclerListView.Holder(profileSearchCell);
    }

    /* JADX WARN: Code restructure failed: missing block: B:110:0x02d7, code lost:
    
        if (r0.startsWith("@" + r8.username) != false) goto L111;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v5, types: [android.text.SpannableStringBuilder] */
    /* JADX WARN: Type inference failed for: r2v6, types: [android.text.SpannableStringBuilder] */
    /* JADX WARN: Type inference failed for: r3v2, types: [ir.eitaa.ui.Cells.ProfileSearchCell] */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v10 */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v6 */
    /* JADX WARN: Type inference failed for: r9v7, types: [ir.eitaa.tgnet.TLRPC$Chat] */
    /* JADX WARN: Type inference failed for: r9v8, types: [ir.eitaa.tgnet.TLObject] */
    /* JADX WARN: Type inference failed for: r9v9 */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.ViewHolder r20, int r21) {
        /*
            Method dump skipped, instructions count: 1032
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Adapters.DialogsSearchAdapter.onBindViewHolder(androidx.recyclerview.widget.RecyclerView$ViewHolder, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onBindViewHolder$18, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onBindViewHolder$18$DialogsSearchAdapter(View view) {
        DialogsSearchAdapterDelegate dialogsSearchAdapterDelegate = this.delegate;
        if (dialogsSearchAdapterDelegate != null) {
            dialogsSearchAdapterDelegate.needClearList();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onBindViewHolder$19, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onBindViewHolder$19$DialogsSearchAdapter(View view) {
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
        int i3 = this.searchInUsersCount;
        if (i == i3 && this.searchInContactsCount != 0) {
            return 1;
        }
        if (getItem(i - (i > i3 ? 1 : 0)) instanceof ContactsController.Contact) {
            return 1380;
        }
        if (i >= 0 && i < size) {
            return 0;
        }
        int i4 = i - size;
        if (i4 >= 0 && i4 < size2) {
            return 0;
        }
        int i5 = i4 - size2;
        if (i5 >= 0 && i5 < size3) {
            Object item = getItem(i5);
            if (item instanceof String) {
                return "section".equals((String) item) ? 1 : 6;
            }
            return 0;
        }
        int i6 = i5 - size3;
        if (i6 >= 0 && i6 < size4) {
            return i6 == 0 ? 1 : 0;
        }
        int i7 = i6 - size4;
        if (i7 < 0 || i7 >= size5) {
            return 3;
        }
        return i7 == 0 ? 1 : 2;
    }

    public void setFiltersDelegate(FilteredSearchView.Delegate filtersDelegate, boolean update) {
        this.filtersDelegate = filtersDelegate;
        if (filtersDelegate == null || !update) {
            return;
        }
        filtersDelegate.updateFiltersView(false, null, this.localTipDates, this.localTipArchive);
    }

    public int getCurrentItemCount() {
        return this.currentItemCount;
    }
}
