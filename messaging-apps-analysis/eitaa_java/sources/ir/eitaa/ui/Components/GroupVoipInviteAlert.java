package ir.eitaa.ui.Components;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.collection.LongSparseArray;
import androidx.recyclerview.widget.RecyclerView;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ChatObject;
import ir.eitaa.messenger.ContactsController;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MessageObject;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.UserConfig;
import ir.eitaa.messenger.UserObject;
import ir.eitaa.messenger.Utilities;
import ir.eitaa.tgnet.ConnectionsManager;
import ir.eitaa.tgnet.RequestDelegate;
import ir.eitaa.tgnet.TLObject;
import ir.eitaa.tgnet.TLRPC$ChannelParticipant;
import ir.eitaa.tgnet.TLRPC$Chat;
import ir.eitaa.tgnet.TLRPC$ChatFull;
import ir.eitaa.tgnet.TLRPC$ChatParticipant;
import ir.eitaa.tgnet.TLRPC$TL_channelParticipantsContacts;
import ir.eitaa.tgnet.TLRPC$TL_channelParticipantsRecent;
import ir.eitaa.tgnet.TLRPC$TL_channels_channelParticipants;
import ir.eitaa.tgnet.TLRPC$TL_channels_getParticipants;
import ir.eitaa.tgnet.TLRPC$TL_contact;
import ir.eitaa.tgnet.TLRPC$TL_error;
import ir.eitaa.tgnet.TLRPC$TL_groupCallParticipant;
import ir.eitaa.tgnet.TLRPC$User;
import ir.eitaa.tgnet.TLRPC$UserStatus;
import ir.eitaa.ui.ActionBar.BottomSheet;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Adapters.SearchAdapterHelper;
import ir.eitaa.ui.Cells.GraySectionCell;
import ir.eitaa.ui.Cells.ManageChatTextCell;
import ir.eitaa.ui.Cells.ManageChatUserCell;
import ir.eitaa.ui.Components.RecyclerListView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

/* loaded from: classes3.dex */
public class GroupVoipInviteAlert extends UsersAlertBase {
    private int addNewRow;
    private ArrayList<TLObject> contacts;
    private boolean contactsEndReached;
    private int contactsEndRow;
    private int contactsHeaderRow;
    private LongSparseArray<TLObject> contactsMap;
    private int contactsStartRow;
    private TLRPC$Chat currentChat;
    private int delayResults;
    private GroupVoipInviteAlertDelegate delegate;
    private int emptyRow;
    private boolean firstLoaded;
    private int flickerProgressRow;
    private LongSparseArray<TLRPC$TL_groupCallParticipant> ignoredUsers;
    private TLRPC$ChatFull info;
    private HashSet<Long> invitedUsers;
    private int lastRow;
    private boolean loadingUsers;
    private int membersHeaderRow;
    private ArrayList<TLObject> participants;
    private int participantsEndRow;
    private LongSparseArray<TLObject> participantsMap;
    private int participantsStartRow;
    private int rowCount;
    private final SearchAdapter searchAdapter;
    private boolean showContacts;

    public interface GroupVoipInviteAlertDelegate {
        void copyInviteLink();

        void inviteUser(long id);

        void needOpenSearch(MotionEvent ev, EditTextBoldCursor editText);
    }

    @Override // ir.eitaa.ui.Components.UsersAlertBase
    protected void updateColorKeys() {
        this.keyScrollUp = "voipgroup_scrollUp";
        this.keyListSelector = "voipgroup_listSelector";
        this.keySearchBackground = "voipgroup_searchBackground";
        this.keyInviteMembersBackground = "voipgroup_inviteMembersBackground";
        this.keyListViewBackground = "voipgroup_listViewBackground";
        this.keyActionBarUnscrolled = "voipgroup_actionBarUnscrolled";
        this.keyNameText = "voipgroup_nameText";
        this.keyLastSeenText = "voipgroup_lastSeenText";
        this.keyLastSeenTextUnscrolled = "voipgroup_lastSeenTextUnscrolled";
        this.keySearchPlaceholder = "voipgroup_searchPlaceholder";
        this.keySearchText = "voipgroup_searchText";
        this.keySearchIcon = "voipgroup_mutedIcon";
        this.keySearchIconUnscrolled = "voipgroup_mutedIconUnscrolled";
    }

    public GroupVoipInviteAlert(final Context context, int account, TLRPC$Chat chat, TLRPC$ChatFull chatFull, LongSparseArray<TLRPC$TL_groupCallParticipant> participants, HashSet<Long> invited) {
        super(context, false, account, null);
        this.participants = new ArrayList<>();
        this.contacts = new ArrayList<>();
        this.participantsMap = new LongSparseArray<>();
        this.contactsMap = new LongSparseArray<>();
        setDimBehindAlpha(75);
        this.currentChat = chat;
        this.info = chatFull;
        this.ignoredUsers = participants;
        this.invitedUsers = invited;
        this.listView.setOnItemClickListener(new RecyclerListView.OnItemClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$GroupVoipInviteAlert$wTPb9cm-C0Z5l2mr9CHHGfUyNr8
            @Override // ir.eitaa.ui.Components.RecyclerListView.OnItemClickListener
            public final void onItemClick(View view, int i) {
                this.f$0.lambda$new$0$GroupVoipInviteAlert(view, i);
            }
        });
        SearchAdapter searchAdapter = new SearchAdapter(context);
        this.searchAdapter = searchAdapter;
        this.searchListViewAdapter = searchAdapter;
        RecyclerListView recyclerListView = this.listView;
        ListAdapter listAdapter = new ListAdapter(context);
        this.listViewAdapter = listAdapter;
        recyclerListView.setAdapter(listAdapter);
        loadChatParticipants(0, 200);
        updateRows();
        setColorProgress(0.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$0$GroupVoipInviteAlert(View view, int i) {
        if (i == this.addNewRow) {
            this.delegate.copyInviteLink();
            dismiss();
        } else if (view instanceof ManageChatUserCell) {
            ManageChatUserCell manageChatUserCell = (ManageChatUserCell) view;
            if (this.invitedUsers.contains(Long.valueOf(manageChatUserCell.getUserId()))) {
                return;
            }
            this.delegate.inviteUser(manageChatUserCell.getUserId());
        }
    }

    public void setDelegate(GroupVoipInviteAlertDelegate groupVoipInviteAlertDelegate) {
        this.delegate = groupVoipInviteAlertDelegate;
    }

    private void updateRows() {
        this.addNewRow = -1;
        this.emptyRow = -1;
        this.participantsStartRow = -1;
        this.participantsEndRow = -1;
        this.contactsHeaderRow = -1;
        this.contactsStartRow = -1;
        this.contactsEndRow = -1;
        this.membersHeaderRow = -1;
        this.lastRow = -1;
        boolean z = false;
        this.rowCount = 0;
        this.rowCount = 0 + 1;
        this.emptyRow = 0;
        if (!TextUtils.isEmpty(this.currentChat.username) || ChatObject.canUserDoAdminAction(this.currentChat, 3)) {
            int i = this.rowCount;
            this.rowCount = i + 1;
            this.addNewRow = i;
        }
        if (!this.loadingUsers || this.firstLoaded) {
            if (!this.contacts.isEmpty()) {
                int i2 = this.rowCount;
                int i3 = i2 + 1;
                this.rowCount = i3;
                this.contactsHeaderRow = i2;
                this.contactsStartRow = i3;
                int size = i3 + this.contacts.size();
                this.rowCount = size;
                this.contactsEndRow = size;
                z = true;
            }
            if (!this.participants.isEmpty()) {
                if (z) {
                    int i4 = this.rowCount;
                    this.rowCount = i4 + 1;
                    this.membersHeaderRow = i4;
                }
                int i5 = this.rowCount;
                this.participantsStartRow = i5;
                int size2 = i5 + this.participants.size();
                this.rowCount = size2;
                this.participantsEndRow = size2;
            }
        }
        if (this.loadingUsers) {
            int i6 = this.rowCount;
            this.rowCount = i6 + 1;
            this.flickerProgressRow = i6;
        }
        int i7 = this.rowCount;
        this.rowCount = i7 + 1;
        this.lastRow = i7;
    }

    private void loadChatParticipants(int offset, int count) {
        if (this.loadingUsers) {
            return;
        }
        this.contactsEndReached = false;
        loadChatParticipants(offset, count, true);
    }

    private void fillContacts() {
        if (this.showContacts) {
            this.contacts.addAll(ContactsController.getInstance(this.currentAccount).contacts);
            long j = UserConfig.getInstance(this.currentAccount).clientUserId;
            int i = 0;
            int size = this.contacts.size();
            while (i < size) {
                TLObject tLObject = this.contacts.get(i);
                if (tLObject instanceof TLRPC$TL_contact) {
                    long j2 = ((TLRPC$TL_contact) tLObject).user_id;
                    if (j2 == j || this.ignoredUsers.indexOfKey(j2) >= 0 || this.invitedUsers.contains(Long.valueOf(j2))) {
                        this.contacts.remove(i);
                        i--;
                        size--;
                    }
                }
                i++;
            }
            Collections.sort(this.contacts, new $$Lambda$GroupVoipInviteAlert$0z2mMMjhtnUTkb6UYZxxpc6yu2g(MessagesController.getInstance(this.currentAccount), ConnectionsManager.getInstance(this.currentAccount).getCurrentTime()));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static /* synthetic */ int lambda$fillContacts$1(ir.eitaa.messenger.MessagesController r2, int r3, ir.eitaa.tgnet.TLObject r4, ir.eitaa.tgnet.TLObject r5) {
        /*
            ir.eitaa.tgnet.TLRPC$TL_contact r5 = (ir.eitaa.tgnet.TLRPC$TL_contact) r5
            long r0 = r5.user_id
            java.lang.Long r5 = java.lang.Long.valueOf(r0)
            ir.eitaa.tgnet.TLRPC$User r5 = r2.getUser(r5)
            ir.eitaa.tgnet.TLRPC$TL_contact r4 = (ir.eitaa.tgnet.TLRPC$TL_contact) r4
            long r0 = r4.user_id
            java.lang.Long r4 = java.lang.Long.valueOf(r0)
            ir.eitaa.tgnet.TLRPC$User r2 = r2.getUser(r4)
            r4 = 50000(0xc350, float:7.0065E-41)
            r0 = 0
            if (r5 == 0) goto L2c
            boolean r1 = r5.self
            if (r1 == 0) goto L25
            int r5 = r3 + r4
            goto L2d
        L25:
            ir.eitaa.tgnet.TLRPC$UserStatus r5 = r5.status
            if (r5 == 0) goto L2c
            int r5 = r5.expires
            goto L2d
        L2c:
            r5 = 0
        L2d:
            if (r2 == 0) goto L3c
            boolean r1 = r2.self
            if (r1 == 0) goto L35
            int r3 = r3 + r4
            goto L3d
        L35:
            ir.eitaa.tgnet.TLRPC$UserStatus r2 = r2.status
            if (r2 == 0) goto L3c
            int r3 = r2.expires
            goto L3d
        L3c:
            r3 = 0
        L3d:
            r2 = -1
            r4 = 1
            if (r5 <= 0) goto L4a
            if (r3 <= 0) goto L4a
            if (r5 <= r3) goto L46
            return r4
        L46:
            if (r5 >= r3) goto L49
            return r2
        L49:
            return r0
        L4a:
            if (r5 >= 0) goto L55
            if (r3 >= 0) goto L55
            if (r5 <= r3) goto L51
            return r4
        L51:
            if (r5 >= r3) goto L54
            return r2
        L54:
            return r0
        L55:
            if (r5 >= 0) goto L59
            if (r3 > 0) goto L5d
        L59:
            if (r5 != 0) goto L5e
            if (r3 == 0) goto L5e
        L5d:
            return r2
        L5e:
            if (r3 < 0) goto L64
            if (r5 == 0) goto L63
            goto L64
        L63:
            return r0
        L64:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Components.GroupVoipInviteAlert.lambda$fillContacts$1(ir.eitaa.messenger.MessagesController, int, ir.eitaa.tgnet.TLObject, ir.eitaa.tgnet.TLObject):int");
    }

    protected void loadChatParticipants(int offset, int count, boolean reset) {
        LongSparseArray<TLRPC$TL_groupCallParticipant> longSparseArray;
        if (!ChatObject.isChannel(this.currentChat)) {
            this.loadingUsers = false;
            this.participants.clear();
            this.contacts.clear();
            this.participantsMap.clear();
            this.contactsMap.clear();
            if (this.info != null) {
                long j = UserConfig.getInstance(this.currentAccount).clientUserId;
                int size = this.info.participants.participants.size();
                for (int i = 0; i < size; i++) {
                    TLRPC$ChatParticipant tLRPC$ChatParticipant = this.info.participants.participants.get(i);
                    long j2 = tLRPC$ChatParticipant.user_id;
                    if (j2 != j && ((longSparseArray = this.ignoredUsers) == null || longSparseArray.indexOfKey(j2) < 0)) {
                        TLRPC$User user = MessagesController.getInstance(this.currentAccount).getUser(Long.valueOf(tLRPC$ChatParticipant.user_id));
                        if (!UserObject.isDeleted(user) && !user.bot) {
                            this.participants.add(tLRPC$ChatParticipant);
                            this.participantsMap.put(tLRPC$ChatParticipant.user_id, tLRPC$ChatParticipant);
                        }
                    }
                }
                if (this.participants.isEmpty()) {
                    this.showContacts = true;
                    fillContacts();
                }
            }
            updateRows();
            RecyclerListView.SelectionAdapter selectionAdapter = this.listViewAdapter;
            if (selectionAdapter != null) {
                selectionAdapter.notifyDataSetChanged();
                return;
            }
            return;
        }
        this.loadingUsers = true;
        StickerEmptyView stickerEmptyView = this.emptyView;
        if (stickerEmptyView != null) {
            stickerEmptyView.showProgress(true, false);
        }
        RecyclerListView.SelectionAdapter selectionAdapter2 = this.listViewAdapter;
        if (selectionAdapter2 != null) {
            selectionAdapter2.notifyDataSetChanged();
        }
        final TLRPC$TL_channels_getParticipants tLRPC$TL_channels_getParticipants = new TLRPC$TL_channels_getParticipants();
        tLRPC$TL_channels_getParticipants.channel = MessagesController.getInputChannel(this.currentChat);
        TLRPC$ChatFull tLRPC$ChatFull = this.info;
        if ((tLRPC$ChatFull == null || tLRPC$ChatFull.participants_count > 200) && !this.contactsEndReached) {
            this.delayResults = 2;
            tLRPC$TL_channels_getParticipants.filter = new TLRPC$TL_channelParticipantsContacts();
            this.contactsEndReached = true;
            loadChatParticipants(0, 200, false);
        } else {
            tLRPC$TL_channels_getParticipants.filter = new TLRPC$TL_channelParticipantsRecent();
        }
        tLRPC$TL_channels_getParticipants.filter.q = "";
        tLRPC$TL_channels_getParticipants.offset = offset;
        tLRPC$TL_channels_getParticipants.limit = count;
        ConnectionsManager.getInstance(this.currentAccount).sendRequest(tLRPC$TL_channels_getParticipants, new RequestDelegate() { // from class: ir.eitaa.ui.Components.-$$Lambda$GroupVoipInviteAlert$U8dumjznQ9Dmx4XhBTC5fthNa-g
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$loadChatParticipants$4$GroupVoipInviteAlert(tLRPC$TL_channels_getParticipants, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadChatParticipants$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadChatParticipants$4$GroupVoipInviteAlert(final TLRPC$TL_channels_getParticipants tLRPC$TL_channels_getParticipants, final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$GroupVoipInviteAlert$VK33hSx-VsfGHHHU0hmryc35w_4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadChatParticipants$3$GroupVoipInviteAlert(tLRPC$TL_error, tLObject, tLRPC$TL_channels_getParticipants);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadChatParticipants$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadChatParticipants$3$GroupVoipInviteAlert(TLRPC$TL_error tLRPC$TL_error, TLObject tLObject, TLRPC$TL_channels_getParticipants tLRPC$TL_channels_getParticipants) {
        int itemCount;
        ArrayList<TLObject> arrayList;
        LongSparseArray<TLObject> longSparseArray;
        LongSparseArray<TLRPC$TL_groupCallParticipant> longSparseArray2;
        if (tLRPC$TL_error == null) {
            TLRPC$TL_channels_channelParticipants tLRPC$TL_channels_channelParticipants = (TLRPC$TL_channels_channelParticipants) tLObject;
            MessagesController.getInstance(this.currentAccount).putUsers(tLRPC$TL_channels_channelParticipants.users, false);
            MessagesController.getInstance(this.currentAccount).putChats(tLRPC$TL_channels_channelParticipants.chats, false);
            long clientUserId = UserConfig.getInstance(this.currentAccount).getClientUserId();
            int i = 0;
            while (true) {
                if (i >= tLRPC$TL_channels_channelParticipants.participants.size()) {
                    break;
                }
                if (MessageObject.getPeerId(tLRPC$TL_channels_channelParticipants.participants.get(i).peer) == clientUserId) {
                    tLRPC$TL_channels_channelParticipants.participants.remove(i);
                    break;
                }
                i++;
            }
            this.delayResults--;
            if (tLRPC$TL_channels_getParticipants.filter instanceof TLRPC$TL_channelParticipantsContacts) {
                arrayList = this.contacts;
                longSparseArray = this.contactsMap;
            } else {
                arrayList = this.participants;
                longSparseArray = this.participantsMap;
            }
            arrayList.clear();
            arrayList.addAll(tLRPC$TL_channels_channelParticipants.participants);
            int size = tLRPC$TL_channels_channelParticipants.participants.size();
            for (int i2 = 0; i2 < size; i2++) {
                TLRPC$ChannelParticipant tLRPC$ChannelParticipant = tLRPC$TL_channels_channelParticipants.participants.get(i2);
                longSparseArray.put(MessageObject.getPeerId(tLRPC$ChannelParticipant.peer), tLRPC$ChannelParticipant);
            }
            int size2 = this.participants.size();
            int i3 = 0;
            while (i3 < size2) {
                long peerId = MessageObject.getPeerId(((TLRPC$ChannelParticipant) this.participants.get(i3)).peer);
                boolean z = this.contactsMap.get(peerId) != null || ((longSparseArray2 = this.ignoredUsers) != null && longSparseArray2.indexOfKey(peerId) >= 0);
                TLRPC$User user = MessagesController.getInstance(this.currentAccount).getUser(Long.valueOf(peerId));
                if ((user != null && user.bot) || UserObject.isDeleted(user)) {
                    z = true;
                }
                if (z) {
                    this.participants.remove(i3);
                    this.participantsMap.remove(peerId);
                    i3--;
                    size2--;
                }
                i3++;
            }
            try {
                if (this.info.participants_count <= 200) {
                    Collections.sort(arrayList, new $$Lambda$GroupVoipInviteAlert$XqeHfEzfmNAekDteJO61k4GJdQ(this, ConnectionsManager.getInstance(this.currentAccount).getCurrentTime()));
                }
            } catch (Exception e) {
                FileLog.e(e);
            }
        }
        if (this.delayResults <= 0) {
            this.loadingUsers = false;
            this.firstLoaded = true;
            if (this.flickerProgressRow == 1) {
                itemCount = 1;
            } else {
                RecyclerListView.SelectionAdapter selectionAdapter = this.listViewAdapter;
                itemCount = selectionAdapter != null ? selectionAdapter.getItemCount() - 1 : 0;
            }
            showItemsAnimated(itemCount);
            if (this.participants.isEmpty()) {
                this.showContacts = true;
                fillContacts();
            }
        }
        updateRows();
        RecyclerListView.SelectionAdapter selectionAdapter2 = this.listViewAdapter;
        if (selectionAdapter2 != null) {
            selectionAdapter2.notifyDataSetChanged();
            if (this.emptyView != null && this.listViewAdapter.getItemCount() == 0 && this.firstLoaded) {
                this.emptyView.showProgress(false, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadChatParticipants$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ int lambda$loadChatParticipants$2$GroupVoipInviteAlert(int i, TLObject tLObject, TLObject tLObject2) {
        int i2;
        int i3;
        TLRPC$UserStatus tLRPC$UserStatus;
        TLRPC$UserStatus tLRPC$UserStatus2;
        TLRPC$User user = MessagesController.getInstance(this.currentAccount).getUser(Long.valueOf(MessageObject.getPeerId(((TLRPC$ChannelParticipant) tLObject).peer)));
        TLRPC$User user2 = MessagesController.getInstance(this.currentAccount).getUser(Long.valueOf(MessageObject.getPeerId(((TLRPC$ChannelParticipant) tLObject2).peer)));
        if (user == null || (tLRPC$UserStatus2 = user.status) == null) {
            i2 = 0;
        } else {
            i2 = user.self ? i + 50000 : tLRPC$UserStatus2.expires;
        }
        if (user2 == null || (tLRPC$UserStatus = user2.status) == null) {
            i3 = 0;
        } else {
            i3 = user2.self ? i + 50000 : tLRPC$UserStatus.expires;
        }
        if (i2 > 0 && i3 > 0) {
            if (i2 > i3) {
                return 1;
            }
            return i2 < i3 ? -1 : 0;
        }
        if (i2 < 0 && i3 < 0) {
            if (i2 > i3) {
                return 1;
            }
            return i2 < i3 ? -1 : 0;
        }
        if ((i2 >= 0 || i3 <= 0) && (i2 != 0 || i3 == 0)) {
            return ((i3 >= 0 || i2 <= 0) && (i3 != 0 || i2 == 0)) ? 0 : 1;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    class SearchAdapter extends RecyclerListView.SelectionAdapter {
        private int emptyRow;
        private int globalStartRow;
        private int groupStartRow;
        private int lastRow;
        private int lastSearchId;
        private Context mContext;
        private SearchAdapterHelper searchAdapterHelper;
        private boolean searchInProgress;
        private Runnable searchRunnable;
        private int totalCount;

        public SearchAdapter(Context context) {
            this.mContext = context;
            SearchAdapterHelper searchAdapterHelper = new SearchAdapterHelper(true);
            this.searchAdapterHelper = searchAdapterHelper;
            searchAdapterHelper.setDelegate(new SearchAdapterHelper.SearchAdapterHelperDelegate() { // from class: ir.eitaa.ui.Components.GroupVoipInviteAlert.SearchAdapter.1
                @Override // ir.eitaa.ui.Adapters.SearchAdapterHelper.SearchAdapterHelperDelegate
                public /* synthetic */ boolean canApplySearchResults(int i) {
                    return SearchAdapterHelper.SearchAdapterHelperDelegate.CC.$default$canApplySearchResults(this, i);
                }

                @Override // ir.eitaa.ui.Adapters.SearchAdapterHelper.SearchAdapterHelperDelegate
                public /* synthetic */ LongSparseArray getExcludeUsers() {
                    return SearchAdapterHelper.SearchAdapterHelperDelegate.CC.$default$getExcludeUsers(this);
                }

                @Override // ir.eitaa.ui.Adapters.SearchAdapterHelper.SearchAdapterHelperDelegate
                public /* synthetic */ void onSetHashtags(ArrayList arrayList, HashMap map) {
                    SearchAdapterHelper.SearchAdapterHelperDelegate.CC.$default$onSetHashtags(this, arrayList, map);
                }

                @Override // ir.eitaa.ui.Adapters.SearchAdapterHelper.SearchAdapterHelperDelegate
                public void onDataSetChanged(int searchId) {
                    if (searchId < 0 || searchId != SearchAdapter.this.lastSearchId || SearchAdapter.this.searchInProgress) {
                        return;
                    }
                    int itemCount = SearchAdapter.this.getItemCount() - 1;
                    boolean z = GroupVoipInviteAlert.this.emptyView.getVisibility() == 0;
                    SearchAdapter.this.notifyDataSetChanged();
                    if (SearchAdapter.this.getItemCount() > itemCount) {
                        GroupVoipInviteAlert.this.showItemsAnimated(itemCount);
                    }
                    if (SearchAdapter.this.searchAdapterHelper.isSearchInProgress() || !GroupVoipInviteAlert.this.listView.emptyViewIsVisible()) {
                        return;
                    }
                    GroupVoipInviteAlert.this.emptyView.showProgress(false, z);
                }

                @Override // ir.eitaa.ui.Adapters.SearchAdapterHelper.SearchAdapterHelperDelegate
                public LongSparseArray<TLRPC$TL_groupCallParticipant> getExcludeCallParticipants() {
                    return GroupVoipInviteAlert.this.ignoredUsers;
                }
            });
        }

        public void searchUsers(final String query) {
            Runnable runnable = this.searchRunnable;
            if (runnable != null) {
                AndroidUtilities.cancelRunOnUIThread(runnable);
                this.searchRunnable = null;
            }
            this.searchAdapterHelper.mergeResults(null);
            this.searchAdapterHelper.queryServerSearch(null, true, false, true, false, false, GroupVoipInviteAlert.this.currentChat.id, false, 2, -1);
            if (!TextUtils.isEmpty(query)) {
                GroupVoipInviteAlert.this.emptyView.showProgress(true, true);
                GroupVoipInviteAlert.this.listView.setAnimateEmptyView(false, 0);
                notifyDataSetChanged();
                GroupVoipInviteAlert.this.listView.setAnimateEmptyView(true, 0);
                this.searchInProgress = true;
                final int i = this.lastSearchId + 1;
                this.lastSearchId = i;
                Runnable runnable2 = new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$GroupVoipInviteAlert$SearchAdapter$9YtKssf0V884P0AA_T67-tySxKg
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$searchUsers$0$GroupVoipInviteAlert$SearchAdapter(query, i);
                    }
                };
                this.searchRunnable = runnable2;
                AndroidUtilities.runOnUIThread(runnable2, 300L);
                RecyclerView.Adapter adapter = GroupVoipInviteAlert.this.listView.getAdapter();
                GroupVoipInviteAlert groupVoipInviteAlert = GroupVoipInviteAlert.this;
                RecyclerListView.SelectionAdapter selectionAdapter = groupVoipInviteAlert.searchListViewAdapter;
                if (adapter != selectionAdapter) {
                    groupVoipInviteAlert.listView.setAdapter(selectionAdapter);
                    return;
                }
                return;
            }
            this.lastSearchId = -1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$searchUsers$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$searchUsers$0$GroupVoipInviteAlert$SearchAdapter(String str, int i) {
            if (this.searchRunnable == null) {
                return;
            }
            this.searchRunnable = null;
            processSearch(str, i);
        }

        private void processSearch(final String query, final int searchId) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$GroupVoipInviteAlert$SearchAdapter$DQYlvjkVe8kshHlHzLWr7Bq3rQ4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$processSearch$2$GroupVoipInviteAlert$SearchAdapter(query, searchId);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$processSearch$2, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$processSearch$2$GroupVoipInviteAlert$SearchAdapter(final String str, final int i) {
            final ArrayList arrayList = null;
            this.searchRunnable = null;
            if (!ChatObject.isChannel(GroupVoipInviteAlert.this.currentChat) && GroupVoipInviteAlert.this.info != null) {
                arrayList = new ArrayList(GroupVoipInviteAlert.this.info.participants.participants);
            }
            if (arrayList != null) {
                Utilities.searchQueue.postRunnable(new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$GroupVoipInviteAlert$SearchAdapter$NM50eiS4ZfzOsOJZBBcDLp4UqsE
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$processSearch$1$GroupVoipInviteAlert$SearchAdapter(str, i, arrayList);
                    }
                });
            } else {
                this.searchInProgress = false;
            }
            this.searchAdapterHelper.queryServerSearch(str, ChatObject.canAddUsers(GroupVoipInviteAlert.this.currentChat), false, true, false, false, ChatObject.isChannel(GroupVoipInviteAlert.this.currentChat) ? GroupVoipInviteAlert.this.currentChat.id : 0L, false, 2, i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:49:0x00eb  */
        /* JADX WARN: Removed duplicated region for block: B:52:0x00f3 A[LOOP:1: B:33:0x009f->B:52:0x00f3, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:61:0x00ef A[SYNTHETIC] */
        /* renamed from: lambda$processSearch$1, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public /* synthetic */ void lambda$processSearch$1$GroupVoipInviteAlert$SearchAdapter(java.lang.String r19, int r20, java.util.ArrayList r21) {
            /*
                Method dump skipped, instructions count: 258
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Components.GroupVoipInviteAlert.SearchAdapter.lambda$processSearch$1$GroupVoipInviteAlert$SearchAdapter(java.lang.String, int, java.util.ArrayList):void");
        }

        private void updateSearchResults(final ArrayList<TLObject> participants, final int searchId) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$GroupVoipInviteAlert$SearchAdapter$fy9LAy76x7i7bVkVNwrM7M6bGxg
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$updateSearchResults$3$GroupVoipInviteAlert$SearchAdapter(searchId, participants);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$updateSearchResults$3, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$updateSearchResults$3$GroupVoipInviteAlert$SearchAdapter(int i, ArrayList arrayList) {
            if (i != this.lastSearchId) {
                return;
            }
            this.searchInProgress = false;
            if (!ChatObject.isChannel(GroupVoipInviteAlert.this.currentChat)) {
                this.searchAdapterHelper.addGroupMembers(arrayList);
            }
            int itemCount = getItemCount() - 1;
            boolean z = GroupVoipInviteAlert.this.emptyView.getVisibility() == 0;
            notifyDataSetChanged();
            if (getItemCount() > itemCount) {
                GroupVoipInviteAlert.this.showItemsAnimated(itemCount);
            }
            if (this.searchInProgress || this.searchAdapterHelper.isSearchInProgress() || !GroupVoipInviteAlert.this.listView.emptyViewIsVisible()) {
                return;
            }
            GroupVoipInviteAlert.this.emptyView.showProgress(false, z);
        }

        @Override // ir.eitaa.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder holder) {
            View view = holder.itemView;
            return !((view instanceof ManageChatUserCell) && GroupVoipInviteAlert.this.invitedUsers.contains(Long.valueOf(((ManageChatUserCell) view).getUserId()))) && holder.getItemViewType() == 0;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.totalCount;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void notifyDataSetChanged() {
            this.totalCount = 0;
            this.totalCount = 0 + 1;
            this.emptyRow = 0;
            int size = this.searchAdapterHelper.getGroupSearch().size();
            if (size != 0) {
                int i = this.totalCount;
                this.groupStartRow = i;
                this.totalCount = i + size + 1;
            } else {
                this.groupStartRow = -1;
            }
            int size2 = this.searchAdapterHelper.getGlobalSearch().size();
            if (size2 != 0) {
                int i2 = this.totalCount;
                this.globalStartRow = i2;
                this.totalCount = i2 + size2 + 1;
            } else {
                this.globalStartRow = -1;
            }
            int i3 = this.totalCount;
            this.totalCount = i3 + 1;
            this.lastRow = i3;
            super.notifyDataSetChanged();
        }

        public TLObject getItem(int i) {
            int i2 = this.groupStartRow;
            if (i2 >= 0 && i > i2 && i < i2 + 1 + this.searchAdapterHelper.getGroupSearch().size()) {
                return this.searchAdapterHelper.getGroupSearch().get((i - this.groupStartRow) - 1);
            }
            int i3 = this.globalStartRow;
            if (i3 < 0 || i <= i3 || i >= i3 + 1 + this.searchAdapterHelper.getGlobalSearch().size()) {
                return null;
            }
            return this.searchAdapterHelper.getGlobalSearch().get((i - this.globalStartRow) - 1);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v10, types: [android.widget.FrameLayout, ir.eitaa.ui.Cells.GraySectionCell] */
        /* JADX WARN: Type inference failed for: r3v11, types: [android.view.View] */
        /* JADX WARN: Type inference failed for: r3v12, types: [android.view.View] */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            ManageChatUserCell view;
            if (i == 0) {
                ManageChatUserCell manageChatUserCell = new ManageChatUserCell(this.mContext, 2, 2, false);
                manageChatUserCell.setCustomRightImage(R.drawable.msg_invited);
                manageChatUserCell.setNameColor(Theme.getColor("voipgroup_nameText"));
                manageChatUserCell.setStatusColors(Theme.getColor("voipgroup_lastSeenTextUnscrolled"), Theme.getColor("voipgroup_listeningText"));
                manageChatUserCell.setDividerColor("voipgroup_listViewBackground");
                view = manageChatUserCell;
            } else if (i == 1) {
                ?? graySectionCell = new GraySectionCell(this.mContext);
                graySectionCell.setBackgroundColor(Theme.getColor("voipgroup_actionBarUnscrolled"));
                graySectionCell.setTextColor("voipgroup_searchPlaceholder");
                view = graySectionCell;
            } else if (i == 2) {
                ?? view2 = new View(this.mContext);
                view2.setLayoutParams(new RecyclerView.LayoutParams(-1, AndroidUtilities.dp(56.0f)));
                view = view2;
            } else {
                view = new View(this.mContext);
            }
            return new RecyclerListView.Holder(view);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            TLRPC$User user;
            String lastFoundChannel;
            boolean z;
            int size;
            int itemViewType = holder.getItemViewType();
            if (itemViewType != 0) {
                if (itemViewType != 1) {
                    return;
                }
                GraySectionCell graySectionCell = (GraySectionCell) holder.itemView;
                if (position == this.groupStartRow) {
                    graySectionCell.setText(LocaleController.getString("ChannelMembers", R.string.ChannelMembers));
                    return;
                } else {
                    if (position == this.globalStartRow) {
                        graySectionCell.setText(LocaleController.getString("GlobalSearch", R.string.GlobalSearch));
                        return;
                    }
                    return;
                }
            }
            TLObject item = getItem(position);
            if (item instanceof TLRPC$User) {
                user = (TLRPC$User) item;
            } else if (item instanceof TLRPC$ChannelParticipant) {
                user = MessagesController.getInstance(((BottomSheet) GroupVoipInviteAlert.this).currentAccount).getUser(Long.valueOf(MessageObject.getPeerId(((TLRPC$ChannelParticipant) item).peer)));
            } else if (!(item instanceof TLRPC$ChatParticipant)) {
                return;
            } else {
                user = MessagesController.getInstance(((BottomSheet) GroupVoipInviteAlert.this).currentAccount).getUser(Long.valueOf(((TLRPC$ChatParticipant) item).user_id));
            }
            String str = user.username;
            int size2 = this.searchAdapterHelper.getGroupSearch().size();
            SpannableStringBuilder spannableStringBuilder = null;
            if (size2 == 0) {
                lastFoundChannel = null;
                z = false;
            } else {
                int i = size2 + 1;
                if (i > position) {
                    lastFoundChannel = this.searchAdapterHelper.getLastFoundChannel();
                    z = true;
                } else {
                    position -= i;
                    lastFoundChannel = null;
                    z = false;
                }
            }
            if (z || str == null || (size = this.searchAdapterHelper.getGlobalSearch().size()) == 0 || size + 1 <= position) {
                str = null;
            } else {
                String lastFoundUsername = this.searchAdapterHelper.getLastFoundUsername();
                if (lastFoundUsername.startsWith("@")) {
                    lastFoundUsername = lastFoundUsername.substring(1);
                }
                try {
                    SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
                    spannableStringBuilder2.append((CharSequence) "@");
                    spannableStringBuilder2.append((CharSequence) str);
                    int iIndexOfIgnoreCase = AndroidUtilities.indexOfIgnoreCase(str, lastFoundUsername);
                    if (iIndexOfIgnoreCase != -1) {
                        int length = lastFoundUsername.length();
                        if (iIndexOfIgnoreCase == 0) {
                            length++;
                        } else {
                            iIndexOfIgnoreCase++;
                        }
                        spannableStringBuilder2.setSpan(new ForegroundColorSpan(Theme.getColor("voipgroup_listeningText")), iIndexOfIgnoreCase, length + iIndexOfIgnoreCase, 33);
                    }
                    str = spannableStringBuilder2;
                } catch (Exception e) {
                    FileLog.e(e);
                }
            }
            if (lastFoundChannel != null) {
                String userName = UserObject.getUserName(user);
                spannableStringBuilder = new SpannableStringBuilder(userName);
                int iIndexOfIgnoreCase2 = AndroidUtilities.indexOfIgnoreCase(userName, lastFoundChannel);
                if (iIndexOfIgnoreCase2 != -1) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(Theme.getColor("voipgroup_listeningText")), iIndexOfIgnoreCase2, lastFoundChannel.length() + iIndexOfIgnoreCase2, 33);
                }
            }
            ManageChatUserCell manageChatUserCell = (ManageChatUserCell) holder.itemView;
            manageChatUserCell.setTag(Integer.valueOf(position));
            manageChatUserCell.setCustomImageVisible(GroupVoipInviteAlert.this.invitedUsers.contains(Long.valueOf(user.id)));
            manageChatUserCell.setData(user, spannableStringBuilder, str, false);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onViewRecycled(RecyclerView.ViewHolder holder) {
            View view = holder.itemView;
            if (view instanceof ManageChatUserCell) {
                ((ManageChatUserCell) view).recycle();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            if (i == this.emptyRow) {
                return 2;
            }
            if (i == this.lastRow) {
                return 3;
            }
            return (i == this.globalStartRow || i == this.groupStartRow) ? 1 : 0;
        }
    }

    private class ListAdapter extends RecyclerListView.SelectionAdapter {
        private Context mContext;

        public ListAdapter(Context context) {
            this.mContext = context;
        }

        @Override // ir.eitaa.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder holder) {
            View view = holder.itemView;
            if ((view instanceof ManageChatUserCell) && GroupVoipInviteAlert.this.invitedUsers.contains(Long.valueOf(((ManageChatUserCell) view).getUserId()))) {
                return false;
            }
            int itemViewType = holder.getItemViewType();
            return itemViewType == 0 || itemViewType == 1;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return GroupVoipInviteAlert.this.rowCount;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            ManageChatUserCell manageChatUserCell;
            View view;
            if (i == 0) {
                ManageChatUserCell manageChatUserCell2 = new ManageChatUserCell(this.mContext, 6, 2, false);
                manageChatUserCell2.setCustomRightImage(R.drawable.msg_invited);
                manageChatUserCell2.setNameColor(Theme.getColor("voipgroup_nameText"));
                manageChatUserCell2.setStatusColors(Theme.getColor("voipgroup_lastSeenTextUnscrolled"), Theme.getColor("voipgroup_listeningText"));
                manageChatUserCell2.setDividerColor("voipgroup_actionBar");
                manageChatUserCell = manageChatUserCell2;
            } else if (i == 1) {
                ManageChatTextCell manageChatTextCell = new ManageChatTextCell(this.mContext);
                manageChatTextCell.setColors("voipgroup_listeningText", "voipgroup_listeningText");
                manageChatTextCell.setDividerColor("voipgroup_actionBar");
                manageChatUserCell = manageChatTextCell;
            } else if (i == 2) {
                GraySectionCell graySectionCell = new GraySectionCell(this.mContext);
                graySectionCell.setBackgroundColor(Theme.getColor("voipgroup_actionBarUnscrolled"));
                graySectionCell.setTextColor("voipgroup_searchPlaceholder");
                manageChatUserCell = graySectionCell;
            } else {
                if (i == 3) {
                    view = new View(this.mContext);
                    view.setLayoutParams(new RecyclerView.LayoutParams(-1, AndroidUtilities.dp(56.0f)));
                } else if (i == 5) {
                    FlickerLoadingView flickerLoadingView = new FlickerLoadingView(this.mContext);
                    flickerLoadingView.setViewType(6);
                    flickerLoadingView.setIsSingleCell(true);
                    flickerLoadingView.setColors("voipgroup_inviteMembersBackground", "voipgroup_searchBackground", "voipgroup_actionBarUnscrolled");
                    manageChatUserCell = flickerLoadingView;
                } else {
                    view = new View(this.mContext);
                }
                return new RecyclerListView.Holder(view);
            }
            view = manageChatUserCell;
            return new RecyclerListView.Holder(view);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            long peerId;
            int itemViewType = holder.getItemViewType();
            if (itemViewType == 0) {
                ManageChatUserCell manageChatUserCell = (ManageChatUserCell) holder.itemView;
                manageChatUserCell.setTag(Integer.valueOf(position));
                TLObject item = getItem(position);
                int i = (position < GroupVoipInviteAlert.this.participantsStartRow || position >= GroupVoipInviteAlert.this.participantsEndRow) ? GroupVoipInviteAlert.this.contactsEndRow : GroupVoipInviteAlert.this.participantsEndRow;
                if (item instanceof TLRPC$TL_contact) {
                    peerId = ((TLRPC$TL_contact) item).user_id;
                } else if (item instanceof TLRPC$User) {
                    peerId = ((TLRPC$User) item).id;
                } else if (item instanceof TLRPC$ChannelParticipant) {
                    peerId = MessageObject.getPeerId(((TLRPC$ChannelParticipant) item).peer);
                } else {
                    peerId = ((TLRPC$ChatParticipant) item).user_id;
                }
                TLRPC$User user = MessagesController.getInstance(((BottomSheet) GroupVoipInviteAlert.this).currentAccount).getUser(Long.valueOf(peerId));
                if (user != null) {
                    manageChatUserCell.setCustomImageVisible(GroupVoipInviteAlert.this.invitedUsers.contains(Long.valueOf(user.id)));
                    manageChatUserCell.setData(user, null, null, position != i - 1);
                    return;
                }
                return;
            }
            if (itemViewType == 1) {
                ManageChatTextCell manageChatTextCell = (ManageChatTextCell) holder.itemView;
                if (position == GroupVoipInviteAlert.this.addNewRow) {
                    manageChatTextCell.setText(LocaleController.getString("VoipGroupCopyInviteLink", R.string.VoipGroupCopyInviteLink), null, R.drawable.msg_link, 7, (!GroupVoipInviteAlert.this.loadingUsers || GroupVoipInviteAlert.this.firstLoaded) && GroupVoipInviteAlert.this.membersHeaderRow == -1 && !GroupVoipInviteAlert.this.participants.isEmpty());
                    return;
                }
                return;
            }
            if (itemViewType != 2) {
                return;
            }
            GraySectionCell graySectionCell = (GraySectionCell) holder.itemView;
            if (position != GroupVoipInviteAlert.this.membersHeaderRow) {
                if (position == GroupVoipInviteAlert.this.contactsHeaderRow) {
                    if (GroupVoipInviteAlert.this.showContacts) {
                        graySectionCell.setText(LocaleController.getString("YourContactsToInvite", R.string.YourContactsToInvite));
                        return;
                    } else {
                        graySectionCell.setText(LocaleController.getString("GroupContacts", R.string.GroupContacts));
                        return;
                    }
                }
                return;
            }
            graySectionCell.setText(LocaleController.getString("ChannelOtherMembers", R.string.ChannelOtherMembers));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onViewRecycled(RecyclerView.ViewHolder holder) {
            View view = holder.itemView;
            if (view instanceof ManageChatUserCell) {
                ((ManageChatUserCell) view).recycle();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int position) {
            if ((position >= GroupVoipInviteAlert.this.participantsStartRow && position < GroupVoipInviteAlert.this.participantsEndRow) || (position >= GroupVoipInviteAlert.this.contactsStartRow && position < GroupVoipInviteAlert.this.contactsEndRow)) {
                return 0;
            }
            if (position == GroupVoipInviteAlert.this.addNewRow) {
                return 1;
            }
            if (position == GroupVoipInviteAlert.this.membersHeaderRow || position == GroupVoipInviteAlert.this.contactsHeaderRow) {
                return 2;
            }
            if (position == GroupVoipInviteAlert.this.emptyRow) {
                return 3;
            }
            if (position == GroupVoipInviteAlert.this.lastRow) {
                return 4;
            }
            return position == GroupVoipInviteAlert.this.flickerProgressRow ? 5 : 0;
        }

        public TLObject getItem(int position) {
            if (position < GroupVoipInviteAlert.this.participantsStartRow || position >= GroupVoipInviteAlert.this.participantsEndRow) {
                if (position < GroupVoipInviteAlert.this.contactsStartRow || position >= GroupVoipInviteAlert.this.contactsEndRow) {
                    return null;
                }
                return (TLObject) GroupVoipInviteAlert.this.contacts.get(position - GroupVoipInviteAlert.this.contactsStartRow);
            }
            return (TLObject) GroupVoipInviteAlert.this.participants.get(position - GroupVoipInviteAlert.this.participantsStartRow);
        }
    }

    @Override // ir.eitaa.ui.Components.UsersAlertBase
    protected void search(String text) {
        this.searchAdapter.searchUsers(text);
    }

    @Override // ir.eitaa.ui.Components.UsersAlertBase
    protected void onSearchViewTouched(MotionEvent ev, EditTextBoldCursor searchEditText) {
        this.delegate.needOpenSearch(ev, searchEditText);
    }
}
