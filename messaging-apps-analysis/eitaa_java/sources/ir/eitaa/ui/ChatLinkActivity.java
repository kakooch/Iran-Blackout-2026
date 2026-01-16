package ir.eitaa.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ChatObject;
import ir.eitaa.messenger.DispatchQueue;
import ir.eitaa.messenger.ImageLocation;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MediaDataController;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.messenger.MessagesStorage;
import ir.eitaa.messenger.NotificationCenter;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.UserConfig;
import ir.eitaa.messenger.Utilities;
import ir.eitaa.tgnet.ConnectionsManager;
import ir.eitaa.tgnet.RequestDelegate;
import ir.eitaa.tgnet.TLObject;
import ir.eitaa.tgnet.TLRPC$Chat;
import ir.eitaa.tgnet.TLRPC$ChatFull;
import ir.eitaa.tgnet.TLRPC$TL_channels_setDiscussionGroup;
import ir.eitaa.tgnet.TLRPC$TL_error;
import ir.eitaa.tgnet.TLRPC$TL_inputChannelEmpty;
import ir.eitaa.tgnet.TLRPC$TL_messages_stickerSet;
import ir.eitaa.tgnet.TLRPC$messages_Chats;
import ir.eitaa.ui.ActionBar.ActionBar;
import ir.eitaa.ui.ActionBar.ActionBarMenuItem;
import ir.eitaa.ui.ActionBar.AlertDialog;
import ir.eitaa.ui.ActionBar.BaseFragment;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.ActionBar.ThemeDescription;
import ir.eitaa.ui.Cells.ManageChatTextCell;
import ir.eitaa.ui.Cells.ManageChatUserCell;
import ir.eitaa.ui.Cells.TextInfoPrivacyCell;
import ir.eitaa.ui.Components.AvatarDrawable;
import ir.eitaa.ui.Components.BackupImageView;
import ir.eitaa.ui.Components.EmptyTextProgressView;
import ir.eitaa.ui.Components.LayoutHelper;
import ir.eitaa.ui.Components.LoadingStickerDrawable;
import ir.eitaa.ui.Components.RecyclerListView;
import ir.eitaa.ui.GroupCreateFinalActivity;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class ChatLinkActivity extends BaseFragment implements NotificationCenter.NotificationCenterDelegate {
    private int chatEndRow;
    private int chatStartRow;
    private ArrayList<TLRPC$Chat> chats = new ArrayList<>();
    private boolean chatsLoaded;
    private int createChatRow;
    private TLRPC$Chat currentChat;
    private long currentChatId;
    private int detailRow;
    private EmptyTextProgressView emptyView;
    private int helpRow;
    private TLRPC$ChatFull info;
    private boolean isChannel;
    private RecyclerListView listView;
    private ListAdapter listViewAdapter;
    private boolean loadingChats;
    private int removeChatRow;
    private int rowCount;
    private SearchAdapter searchAdapter;
    private ActionBarMenuItem searchItem;
    private boolean searchWas;
    private boolean searching;
    private TLRPC$Chat waitingForFullChat;
    private AlertDialog waitingForFullChatProgressAlert;

    private static class EmptyView extends LinearLayout implements NotificationCenter.NotificationCenterDelegate {
        private int currentAccount;
        private LoadingStickerDrawable drawable;
        private BackupImageView stickerView;

        public EmptyView(Context context) {
            super(context);
            this.currentAccount = UserConfig.selectedAccount;
            setPadding(0, AndroidUtilities.dp(12.0f), 0, AndroidUtilities.dp(12.0f));
            setOrientation(1);
            this.stickerView = new BackupImageView(context);
            LoadingStickerDrawable loadingStickerDrawable = new LoadingStickerDrawable(this.stickerView, "M476.1,397.4c25.8-47.2,0.3-105.9-50.9-120c-2.5-6.9-7.8-12.7-15-16.4l0.4-229.4c0-12.3-10-22.4-22.4-22.4H128.5c-12.3,0-22.4,10-22.4,22.4l-0.4,229.8v0c0,6.7,2.9,12.6,7.6,16.7c-51.6,15.9-79.2,77.2-48.1,116.4c-8.7,11.7-13.4,27.5-14,47.2c-1.7,34.5,21.6,45.8,55.9,45.8c52.3,0,99.1,4.6,105.1-36.2c16.5,0.9,7.1-37.3-6.5-53.3c18.4-22.4,18.3-52.9,4.9-78.2c-0.7-5.3-3.8-9.8-8.1-12.6c-1.5-2-1.6-2-2.1-2.7c0.2-1,1.2-11.8-3.4-20.9h138.5c-4.8,8.8-4.7,17-2.9,22.1c-5.3,4.8-6.8,12.3-5.2,17c-11.4,24.9-10,53.8,4.3,77.5c-6.8,9.7-11.2,21.7-12.6,31.6c-0.2-0.2-0.4-0.3-0.6-0.5c0.8-3.3,0.4-6.4-1.3-7.8c9.3-12.1-4.5-29.2-17-21.7c-3.8-2.8-10.6-3.2-18.1-0.5c-2.4-10.6-21.1-10.6-28.6-1c-1.3,0.3-2.9,0.8-4.5,1.9c-5.2-0.9-10.9,0.1-14.1,4.4c-6.9,3-9.5,10.4-7.8,17c-0.9,1.8-1.1,4-0.8,6.3c-1.6,1.2-2.3,3.1-2,4.9c0.1,0.6,10.4,56.6,11.2,62c0.3,1.8,1.5,3.2,3.1,3.9c8.7,3.4,12,3.8,30.1,9.4c2.7,0.8,2.4,0.8,6.7-0.1c16.4-3.5,30.2-8.9,30.8-9.2c1.6-0.6,2.7-2,3.1-3.7c0.1-0.4,6.8-36.5,10-53.2c0.9,4.2,3.3,7.3,7.4,7.5c1.2,7.8,4.4,14.5,9.5,19.9c16.4,17.3,44.9,15.7,64.9,16.1c38.3,0.8,74.5,1.5,84.4-24.4C488.9,453.5,491.3,421.3,476.1,397.4z", AndroidUtilities.dp(104.0f), AndroidUtilities.dp(104.0f));
            this.drawable = loadingStickerDrawable;
            this.stickerView.setImageDrawable(loadingStickerDrawable);
            addView(this.stickerView, LayoutHelper.createLinear(R.styleable.AppCompatTheme_textColorAlertDialogListItem, R.styleable.AppCompatTheme_textColorAlertDialogListItem, 49, 0, 2, 0, 0));
        }

        private void setSticker() {
            TLRPC$TL_messages_stickerSet stickerSetByName = MediaDataController.getInstance(this.currentAccount).getStickerSetByName(AndroidUtilities.STICKERS_PLACEHOLDER_PACK_NAME);
            if (stickerSetByName == null) {
                stickerSetByName = MediaDataController.getInstance(this.currentAccount).getStickerSetByEmojiOrName(AndroidUtilities.STICKERS_PLACEHOLDER_PACK_NAME);
            }
            TLRPC$TL_messages_stickerSet tLRPC$TL_messages_stickerSet = stickerSetByName;
            if (tLRPC$TL_messages_stickerSet != null && tLRPC$TL_messages_stickerSet.documents.size() >= 3) {
                this.stickerView.setImage(ImageLocation.getForDocument(tLRPC$TL_messages_stickerSet.documents.get(2)), "104_104", "tgs", this.drawable, tLRPC$TL_messages_stickerSet);
            } else {
                MediaDataController.getInstance(this.currentAccount).loadStickersByEmojiOrName(AndroidUtilities.STICKERS_PLACEHOLDER_PACK_NAME, false, tLRPC$TL_messages_stickerSet == null);
                this.stickerView.setImageDrawable(this.drawable);
            }
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onAttachedToWindow() {
            super.onAttachedToWindow();
            setSticker();
            NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.diceStickersDidLoad);
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.diceStickersDidLoad);
        }

        @Override // ir.eitaa.messenger.NotificationCenter.NotificationCenterDelegate
        public void didReceivedNotification(int id, int account, Object... args) {
            if (id == NotificationCenter.diceStickersDidLoad && AndroidUtilities.STICKERS_PLACEHOLDER_PACK_NAME.equals((String) args[0])) {
                setSticker();
            }
        }
    }

    public ChatLinkActivity(long chatId) {
        this.currentChatId = chatId;
        TLRPC$Chat chat = getMessagesController().getChat(Long.valueOf(chatId));
        this.currentChat = chat;
        this.isChannel = ChatObject.isChannel(chat) && !this.currentChat.megagroup;
    }

    private void updateRows() {
        TLRPC$Chat chat = getMessagesController().getChat(Long.valueOf(this.currentChatId));
        this.currentChat = chat;
        if (chat == null) {
            return;
        }
        this.rowCount = 0;
        this.helpRow = -1;
        this.createChatRow = -1;
        this.chatStartRow = -1;
        this.chatEndRow = -1;
        this.removeChatRow = -1;
        this.detailRow = -1;
        int i = 0 + 1;
        this.rowCount = i;
        this.helpRow = 0;
        if (this.isChannel) {
            if (this.info.linked_chat_id == 0) {
                this.rowCount = i + 1;
                this.createChatRow = i;
            }
            int i2 = this.rowCount;
            this.chatStartRow = i2;
            int size = i2 + this.chats.size();
            this.rowCount = size;
            this.chatEndRow = size;
            if (this.info.linked_chat_id != 0) {
                this.rowCount = size + 1;
                this.createChatRow = size;
            }
        } else {
            this.chatStartRow = i;
            int size2 = i + this.chats.size();
            this.rowCount = size2;
            this.chatEndRow = size2;
            this.rowCount = size2 + 1;
            this.createChatRow = size2;
        }
        int i3 = this.rowCount;
        this.rowCount = i3 + 1;
        this.detailRow = i3;
        ListAdapter listAdapter = this.listViewAdapter;
        if (listAdapter != null) {
            listAdapter.notifyDataSetChanged();
        }
        ActionBarMenuItem actionBarMenuItem = this.searchItem;
        if (actionBarMenuItem != null) {
            actionBarMenuItem.setVisibility(this.chats.size() <= 10 ? 8 : 0);
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public boolean onFragmentCreate() {
        super.onFragmentCreate();
        getNotificationCenter().addObserver(this, NotificationCenter.chatInfoDidLoad);
        loadChats();
        return true;
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onFragmentDestroy() throws InterruptedException {
        super.onFragmentDestroy();
        getNotificationCenter().removeObserver(this, NotificationCenter.chatInfoDidLoad);
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment, ir.eitaa.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int id, int account, Object... args) {
        if (id == NotificationCenter.chatInfoDidLoad) {
            TLRPC$ChatFull tLRPC$ChatFull = (TLRPC$ChatFull) args[0];
            long j = tLRPC$ChatFull.id;
            if (j == this.currentChatId) {
                this.info = tLRPC$ChatFull;
                loadChats();
                updateRows();
                return;
            }
            TLRPC$Chat tLRPC$Chat = this.waitingForFullChat;
            if (tLRPC$Chat == null || tLRPC$Chat.id != j) {
                return;
            }
            try {
                this.waitingForFullChatProgressAlert.dismiss();
            } catch (Throwable unused) {
            }
            this.waitingForFullChatProgressAlert = null;
            showLinkAlert(this.waitingForFullChat, false);
            this.waitingForFullChat = null;
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public View createView(Context context) {
        this.searching = false;
        this.searchWas = false;
        this.actionBar.setBackButtonImage(R.drawable.ic_ab_back);
        this.actionBar.setAllowOverlayTitle(true);
        this.actionBar.setTitle(LocaleController.getString("Discussion", R.string.Discussion));
        this.actionBar.setActionBarMenuOnItemClick(new ActionBar.ActionBarMenuOnItemClick() { // from class: ir.eitaa.ui.ChatLinkActivity.1
            @Override // ir.eitaa.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
            public void onItemClick(int id) {
                if (id == -1) {
                    ChatLinkActivity.this.finishFragment();
                }
            }
        });
        ActionBarMenuItem actionBarMenuItemSearchListener = this.actionBar.createMenu().addItem(0, R.drawable.ic_ab_search).setIsSearchField(true).setActionBarMenuItemSearchListener(new ActionBarMenuItem.ActionBarMenuItemSearchListener() { // from class: ir.eitaa.ui.ChatLinkActivity.2
            @Override // ir.eitaa.ui.ActionBar.ActionBarMenuItem.ActionBarMenuItemSearchListener
            public void onSearchExpand() {
                ChatLinkActivity.this.searching = true;
                ChatLinkActivity.this.emptyView.setShowAtCenter(true);
            }

            @Override // ir.eitaa.ui.ActionBar.ActionBarMenuItem.ActionBarMenuItemSearchListener
            public void onSearchCollapse() throws InterruptedException {
                ChatLinkActivity.this.searchAdapter.searchDialogs(null);
                ChatLinkActivity.this.searching = false;
                ChatLinkActivity.this.searchWas = false;
                ChatLinkActivity.this.listView.setAdapter(ChatLinkActivity.this.listViewAdapter);
                ChatLinkActivity.this.listViewAdapter.notifyDataSetChanged();
                ChatLinkActivity.this.listView.setFastScrollVisible(true);
                ChatLinkActivity.this.listView.setVerticalScrollBarEnabled(false);
                ChatLinkActivity.this.emptyView.setShowAtCenter(false);
                ((BaseFragment) ChatLinkActivity.this).fragmentView.setBackgroundColor(Theme.getColor("windowBackgroundGray"));
                ((BaseFragment) ChatLinkActivity.this).fragmentView.setTag("windowBackgroundGray");
                ChatLinkActivity.this.emptyView.showProgress();
            }

            @Override // ir.eitaa.ui.ActionBar.ActionBarMenuItem.ActionBarMenuItemSearchListener
            public void onTextChanged(EditText editText) throws InterruptedException {
                if (ChatLinkActivity.this.searchAdapter == null) {
                    return;
                }
                String string = editText.getText().toString();
                if (string.length() != 0) {
                    ChatLinkActivity.this.searchWas = true;
                    if (ChatLinkActivity.this.listView != null && ChatLinkActivity.this.listView.getAdapter() != ChatLinkActivity.this.searchAdapter) {
                        ChatLinkActivity.this.listView.setAdapter(ChatLinkActivity.this.searchAdapter);
                        ((BaseFragment) ChatLinkActivity.this).fragmentView.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
                        ((BaseFragment) ChatLinkActivity.this).fragmentView.setTag("windowBackgroundWhite");
                        ChatLinkActivity.this.searchAdapter.notifyDataSetChanged();
                        ChatLinkActivity.this.listView.setFastScrollVisible(false);
                        ChatLinkActivity.this.listView.setVerticalScrollBarEnabled(true);
                        ChatLinkActivity.this.emptyView.showProgress();
                    }
                }
                ChatLinkActivity.this.searchAdapter.searchDialogs(string);
            }
        });
        this.searchItem = actionBarMenuItemSearchListener;
        actionBarMenuItemSearchListener.setSearchFieldHint(LocaleController.getString("Search", R.string.Search));
        this.searchAdapter = new SearchAdapter(context);
        FrameLayout frameLayout = new FrameLayout(context);
        this.fragmentView = frameLayout;
        frameLayout.setBackgroundColor(Theme.getColor("windowBackgroundGray"));
        this.fragmentView.setTag("windowBackgroundGray");
        FrameLayout frameLayout2 = (FrameLayout) this.fragmentView;
        EmptyTextProgressView emptyTextProgressView = new EmptyTextProgressView(context);
        this.emptyView = emptyTextProgressView;
        emptyTextProgressView.showProgress();
        this.emptyView.setText(LocaleController.getString("NoResult", R.string.NoResult));
        frameLayout2.addView(this.emptyView, LayoutHelper.createFrame(-1, -1.0f));
        RecyclerListView recyclerListView = new RecyclerListView(context);
        this.listView = recyclerListView;
        recyclerListView.setEmptyView(this.emptyView);
        this.listView.setLayoutManager(new LinearLayoutManager(context, 1, false));
        RecyclerListView recyclerListView2 = this.listView;
        ListAdapter listAdapter = new ListAdapter(context);
        this.listViewAdapter = listAdapter;
        recyclerListView2.setAdapter(listAdapter);
        this.listView.setVerticalScrollbarPosition(LocaleController.isRTL ? 1 : 2);
        frameLayout2.addView(this.listView, LayoutHelper.createFrame(-1, -1.0f));
        this.listView.setOnItemClickListener(new RecyclerListView.OnItemClickListener() { // from class: ir.eitaa.ui.-$$Lambda$ChatLinkActivity$5yvNaaz8tza5sc85QFV-SB-CpaA
            @Override // ir.eitaa.ui.Components.RecyclerListView.OnItemClickListener
            public final void onItemClick(View view, int i) {
                this.f$0.lambda$createView$6$ChatLinkActivity(view, i);
            }
        });
        updateRows();
        return this.fragmentView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$6$ChatLinkActivity(View view, int i) {
        TLRPC$Chat item;
        String string;
        String string2;
        if (getParentActivity() == null) {
            return;
        }
        RecyclerView.Adapter adapter = this.listView.getAdapter();
        SearchAdapter searchAdapter = this.searchAdapter;
        if (adapter == searchAdapter) {
            item = searchAdapter.getItem(i);
        } else {
            int i2 = this.chatStartRow;
            item = (i < i2 || i >= this.chatEndRow) ? null : this.chats.get(i - i2);
        }
        if (item != null) {
            if (this.isChannel && this.info.linked_chat_id == 0) {
                showLinkAlert(item, true);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putLong("chat_id", item.id);
            presentFragment(new ChatActivity(bundle));
            return;
        }
        if (i == this.createChatRow) {
            if (this.isChannel && this.info.linked_chat_id == 0) {
                Bundle bundle2 = new Bundle();
                bundle2.putLongArray("result", new long[]{getUserConfig().getClientUserId()});
                bundle2.putInt("chatType", 4);
                GroupCreateFinalActivity groupCreateFinalActivity = new GroupCreateFinalActivity(bundle2);
                groupCreateFinalActivity.setDelegate(new GroupCreateFinalActivity.GroupCreateFinalActivityDelegate() { // from class: ir.eitaa.ui.ChatLinkActivity.3
                    @Override // ir.eitaa.ui.GroupCreateFinalActivity.GroupCreateFinalActivityDelegate
                    public void didFailChatCreation() {
                    }

                    @Override // ir.eitaa.ui.GroupCreateFinalActivity.GroupCreateFinalActivityDelegate
                    public void didStartChatCreation() {
                    }

                    @Override // ir.eitaa.ui.GroupCreateFinalActivity.GroupCreateFinalActivityDelegate
                    public void didFinishChatCreation(GroupCreateFinalActivity fragment, long chatId) {
                        ChatLinkActivity chatLinkActivity = ChatLinkActivity.this;
                        chatLinkActivity.linkChat(chatLinkActivity.getMessagesController().getChat(Long.valueOf(chatId)), fragment);
                    }
                });
                presentFragment(groupCreateFinalActivity);
                return;
            }
            if (this.chats.isEmpty()) {
                return;
            }
            TLRPC$Chat tLRPC$Chat = this.chats.get(0);
            AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
            if (this.isChannel) {
                string = LocaleController.getString("DiscussionUnlinkGroup", R.string.DiscussionUnlinkGroup);
                string2 = LocaleController.formatString("DiscussionUnlinkChannelAlert", R.string.DiscussionUnlinkChannelAlert, tLRPC$Chat.title);
            } else {
                string = LocaleController.getString("DiscussionUnlink", R.string.DiscussionUnlinkChannel);
                string2 = LocaleController.formatString("DiscussionUnlinkGroupAlert", R.string.DiscussionUnlinkGroupAlert, tLRPC$Chat.title);
            }
            builder.setTitle(string);
            builder.setMessage(AndroidUtilities.replaceTags(string2));
            builder.setPositiveButton(LocaleController.getString("DiscussionUnlink", R.string.DiscussionUnlink), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$ChatLinkActivity$fS533M1RBBo4CCUj0FyvGn3qU40
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    this.f$0.lambda$createView$5$ChatLinkActivity(dialogInterface, i3);
                }
            });
            builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
            AlertDialog alertDialogCreate = builder.create();
            showDialog(alertDialogCreate);
            TextView textView = (TextView) alertDialogCreate.getButton(-1);
            if (textView != null) {
                textView.setTextColor(Theme.getColor("dialogTextRed2"));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$5$ChatLinkActivity(DialogInterface dialogInterface, int i) {
        if (this.isChannel && this.info.linked_chat_id == 0) {
            return;
        }
        final AlertDialog[] alertDialogArr = {new AlertDialog(getParentActivity(), 3)};
        TLRPC$TL_channels_setDiscussionGroup tLRPC$TL_channels_setDiscussionGroup = new TLRPC$TL_channels_setDiscussionGroup();
        if (this.isChannel) {
            tLRPC$TL_channels_setDiscussionGroup.broadcast = MessagesController.getInputChannel(this.currentChat);
            tLRPC$TL_channels_setDiscussionGroup.group = new TLRPC$TL_inputChannelEmpty();
        } else {
            tLRPC$TL_channels_setDiscussionGroup.broadcast = new TLRPC$TL_inputChannelEmpty();
            tLRPC$TL_channels_setDiscussionGroup.group = MessagesController.getInputChannel(this.currentChat);
        }
        final int iSendRequest = getConnectionsManager().sendRequest(tLRPC$TL_channels_setDiscussionGroup, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$ChatLinkActivity$CELpuz-pDlVWc7nesFuYfmw-Ef4
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$createView$2$ChatLinkActivity(alertDialogArr, tLObject, tLRPC$TL_error);
            }
        });
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ChatLinkActivity$5Hs8llSF8tshwDtZcVYeNHnsEFM
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$createView$4$ChatLinkActivity(alertDialogArr, iSendRequest);
            }
        }, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$2$ChatLinkActivity(final AlertDialog[] alertDialogArr, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ChatLinkActivity$Zg6XinNMA9ofxgoe4E0wmVTfVEc
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$createView$1$ChatLinkActivity(alertDialogArr);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$1$ChatLinkActivity(AlertDialog[] alertDialogArr) {
        try {
            alertDialogArr[0].dismiss();
        } catch (Throwable unused) {
        }
        alertDialogArr[0] = null;
        this.info.linked_chat_id = 0L;
        NotificationCenter notificationCenter = NotificationCenter.getInstance(this.currentAccount);
        int i = NotificationCenter.chatInfoDidLoad;
        Boolean bool = Boolean.FALSE;
        notificationCenter.postNotificationName(i, this.info, 0, bool, bool);
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ChatLinkActivity$guZMrVL2uZ9DqfQpWMmpPIxat08
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$createView$0$ChatLinkActivity();
            }
        }, 1000L);
        if (this.isChannel) {
            return;
        }
        finishFragment();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$0$ChatLinkActivity() {
        getMessagesController().loadFullChat(this.currentChatId, 0, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$4$ChatLinkActivity(AlertDialog[] alertDialogArr, final int i) {
        if (alertDialogArr[0] == null) {
            return;
        }
        alertDialogArr[0].setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: ir.eitaa.ui.-$$Lambda$ChatLinkActivity$tFuTB0UM4ec2HpBZYl9SxTlv__s
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                this.f$0.lambda$createView$3$ChatLinkActivity(i, dialogInterface);
            }
        });
        showDialog(alertDialogArr[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$3$ChatLinkActivity(int i, DialogInterface dialogInterface) {
        ConnectionsManager.getInstance(this.currentAccount).cancelRequest(i, true);
    }

    private void showLinkAlert(final TLRPC$Chat chat, boolean query) {
        String string;
        final TLRPC$ChatFull chatFull = getMessagesController().getChatFull(chat.id);
        if (chatFull == null) {
            if (query) {
                getMessagesController().loadFullChat(chat.id, 0, true);
                this.waitingForFullChat = chat;
                this.waitingForFullChatProgressAlert = new AlertDialog(getParentActivity(), 3);
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ChatLinkActivity$Vl1zeGoRuZ03p-g7OngcOfI-X4Y
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$showLinkAlert$8$ChatLinkActivity();
                    }
                }, 500L);
                return;
            }
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
        TextView textView = new TextView(getParentActivity());
        textView.setTextColor(Theme.getColor("dialogTextBlack"));
        textView.setTextSize(1, 16.0f);
        textView.setGravity((LocaleController.isRTL ? 5 : 3) | 48);
        if (TextUtils.isEmpty(chat.username)) {
            string = LocaleController.formatString("DiscussionLinkGroupPublicPrivateAlert", R.string.DiscussionLinkGroupPublicPrivateAlert, chat.title, this.currentChat.title);
        } else {
            string = TextUtils.isEmpty(this.currentChat.username) ? LocaleController.formatString("DiscussionLinkGroupPrivateAlert", R.string.DiscussionLinkGroupPrivateAlert, chat.title, this.currentChat.title) : LocaleController.formatString("DiscussionLinkGroupPublicAlert", R.string.DiscussionLinkGroupPublicAlert, chat.title, this.currentChat.title);
        }
        if (chatFull.hidden_prehistory) {
            string = string + "\n\n" + LocaleController.getString("DiscussionLinkGroupAlertHistory", R.string.DiscussionLinkGroupAlertHistory);
        }
        textView.setText(AndroidUtilities.replaceTags(string));
        FrameLayout frameLayout = new FrameLayout(getParentActivity());
        builder.setView(frameLayout);
        AvatarDrawable avatarDrawable = new AvatarDrawable();
        avatarDrawable.setTextSize(AndroidUtilities.dp(12.0f));
        BackupImageView backupImageView = new BackupImageView(getParentActivity());
        backupImageView.setRoundRadius(AndroidUtilities.dp(20.0f));
        frameLayout.addView(backupImageView, LayoutHelper.createFrame(40, 40.0f, (LocaleController.isRTL ? 5 : 3) | 48, 22.0f, 5.0f, 22.0f, 0.0f));
        TextView textView2 = new TextView(getParentActivity());
        textView2.setTextColor(Theme.getColor("actionBarDefaultSubmenuItem"));
        textView2.setTextSize(1, 20.0f);
        textView2.setTypeface(AndroidUtilities.getFontFamily(true));
        textView2.setLines(1);
        textView2.setMaxLines(1);
        textView2.setSingleLine(true);
        textView2.setGravity((LocaleController.isRTL ? 5 : 3) | 16);
        textView2.setEllipsize(TextUtils.TruncateAt.END);
        textView2.setText(chat.title);
        boolean z = LocaleController.isRTL;
        frameLayout.addView(textView2, LayoutHelper.createFrame(-1, -2.0f, (z ? 5 : 3) | 48, z ? 21 : 76, 11.0f, z ? 76 : 21, 0.0f));
        frameLayout.addView(textView, LayoutHelper.createFrame(-2, -2.0f, (LocaleController.isRTL ? 5 : 3) | 48, 24.0f, 57.0f, 24.0f, 9.0f));
        avatarDrawable.setInfo(chat);
        backupImageView.setForUserOrChat(chat, avatarDrawable);
        builder.setPositiveButton(LocaleController.getString("DiscussionLinkGroup", R.string.DiscussionLinkGroup), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$ChatLinkActivity$YYw09-9qEFT4E0D85yawgQZBcH8
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showLinkAlert$9$ChatLinkActivity(chatFull, chat, dialogInterface, i);
            }
        });
        builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
        showDialog(builder.create());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$showLinkAlert$8, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$showLinkAlert$8$ChatLinkActivity() {
        AlertDialog alertDialog = this.waitingForFullChatProgressAlert;
        if (alertDialog == null) {
            return;
        }
        alertDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: ir.eitaa.ui.-$$Lambda$ChatLinkActivity$K_889_z06t_oHjAJ7JiXaekDGxU
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                this.f$0.lambda$showLinkAlert$7$ChatLinkActivity(dialogInterface);
            }
        });
        showDialog(this.waitingForFullChatProgressAlert);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$showLinkAlert$7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$showLinkAlert$7$ChatLinkActivity(DialogInterface dialogInterface) {
        this.waitingForFullChat = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$showLinkAlert$9, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$showLinkAlert$9$ChatLinkActivity(TLRPC$ChatFull tLRPC$ChatFull, TLRPC$Chat tLRPC$Chat, DialogInterface dialogInterface, int i) {
        if (tLRPC$ChatFull.hidden_prehistory) {
            getMessagesController().toogleChannelInvitesHistory(tLRPC$Chat.id, false);
        }
        linkChat(tLRPC$Chat, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void linkChat(final TLRPC$Chat chat, final BaseFragment createFragment) {
        if (chat == null) {
            return;
        }
        if (!ChatObject.isChannel(chat)) {
            getMessagesController().convertToMegaGroup(getParentActivity(), chat.id, this, new MessagesStorage.LongCallback() { // from class: ir.eitaa.ui.-$$Lambda$ChatLinkActivity$mH6jDlYwqUx3xUDDeJaZsR_Z9gE
                @Override // ir.eitaa.messenger.MessagesStorage.LongCallback
                public final void run(long j) {
                    this.f$0.lambda$linkChat$10$ChatLinkActivity(createFragment, j);
                }
            });
            return;
        }
        final AlertDialog[] alertDialogArr = new AlertDialog[1];
        alertDialogArr[0] = createFragment != null ? null : new AlertDialog(getParentActivity(), 3);
        TLRPC$TL_channels_setDiscussionGroup tLRPC$TL_channels_setDiscussionGroup = new TLRPC$TL_channels_setDiscussionGroup();
        tLRPC$TL_channels_setDiscussionGroup.broadcast = MessagesController.getInputChannel(this.currentChat);
        tLRPC$TL_channels_setDiscussionGroup.group = MessagesController.getInputChannel(chat);
        final int iSendRequest = getConnectionsManager().sendRequest(tLRPC$TL_channels_setDiscussionGroup, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$ChatLinkActivity$ZQ3jtn6cujjTkOqOCD-SPZljRnw
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$linkChat$13$ChatLinkActivity(alertDialogArr, chat, createFragment, tLObject, tLRPC$TL_error);
            }
        }, 64);
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ChatLinkActivity$UvQL2QE90jw6abXjbjqbjcntWtI
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$linkChat$15$ChatLinkActivity(alertDialogArr, iSendRequest);
            }
        }, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$linkChat$10, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$linkChat$10$ChatLinkActivity(BaseFragment baseFragment, long j) {
        if (j != 0) {
            getMessagesController().toogleChannelInvitesHistory(j, false);
            linkChat(getMessagesController().getChat(Long.valueOf(j)), baseFragment);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$linkChat$13, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$linkChat$13$ChatLinkActivity(final AlertDialog[] alertDialogArr, final TLRPC$Chat tLRPC$Chat, final BaseFragment baseFragment, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ChatLinkActivity$MZKcPUq3UOvz2A_2dvAmE2SiG88
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$linkChat$12$ChatLinkActivity(alertDialogArr, tLRPC$Chat, baseFragment);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$linkChat$12, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$linkChat$12$ChatLinkActivity(AlertDialog[] alertDialogArr, TLRPC$Chat tLRPC$Chat, BaseFragment baseFragment) {
        if (alertDialogArr[0] != null) {
            try {
                alertDialogArr[0].dismiss();
            } catch (Throwable unused) {
            }
            alertDialogArr[0] = null;
        }
        this.info.linked_chat_id = tLRPC$Chat.id;
        NotificationCenter notificationCenter = NotificationCenter.getInstance(this.currentAccount);
        int i = NotificationCenter.chatInfoDidLoad;
        Boolean bool = Boolean.FALSE;
        notificationCenter.postNotificationName(i, this.info, 0, bool, bool);
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ChatLinkActivity$Zd-e9s5LiW_23oCzH2lHviuXfR4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$linkChat$11$ChatLinkActivity();
            }
        }, 1000L);
        if (baseFragment != null) {
            removeSelfFromStack();
            baseFragment.finishFragment();
        } else {
            finishFragment();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$linkChat$11, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$linkChat$11$ChatLinkActivity() {
        getMessagesController().loadFullChat(this.currentChatId, 0, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$linkChat$15, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$linkChat$15$ChatLinkActivity(AlertDialog[] alertDialogArr, final int i) {
        if (alertDialogArr[0] == null) {
            return;
        }
        alertDialogArr[0].setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: ir.eitaa.ui.-$$Lambda$ChatLinkActivity$Rnownk4BtIigQuMAtuLr-vo_bBo
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                this.f$0.lambda$linkChat$14$ChatLinkActivity(i, dialogInterface);
            }
        });
        showDialog(alertDialogArr[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$linkChat$14, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$linkChat$14$ChatLinkActivity(int i, DialogInterface dialogInterface) {
        ConnectionsManager.getInstance(this.currentAccount).cancelRequest(i, true);
    }

    public void setInfo(TLRPC$ChatFull chatFull) {
        this.info = chatFull;
    }

    private void loadChats() {
        if (this.info.linked_chat_id != 0) {
            this.chats.clear();
            TLRPC$Chat chat = getMessagesController().getChat(Long.valueOf(this.info.linked_chat_id));
            if (chat != null) {
                this.chats.add(chat);
            }
            ActionBarMenuItem actionBarMenuItem = this.searchItem;
            if (actionBarMenuItem != null) {
                actionBarMenuItem.setVisibility(8);
            }
        }
        if (!this.loadingChats && this.isChannel && this.info.linked_chat_id == 0) {
            this.loadingChats = true;
            getConnectionsManager().sendRequest(new TLObject() { // from class: ir.eitaa.tgnet.TLRPC$TL_channels_getGroupsForDiscussion
                public static int constructor = -170208392;

                @Override // ir.eitaa.tgnet.TLObject
                public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
                    return TLRPC$messages_Chats.TLdeserialize(stream, constructor2, exception);
                }

                @Override // ir.eitaa.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData stream) {
                    stream.writeInt32(constructor);
                }
            }, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$ChatLinkActivity$GiEbBMtGlFMzD6lgQMTCEfA_66U
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$loadChats$17$ChatLinkActivity(tLObject, tLRPC$TL_error);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadChats$17, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadChats$17$ChatLinkActivity(final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ChatLinkActivity$I6F5TdZh5JK18JW2UOgcnOaMcqQ
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadChats$16$ChatLinkActivity(tLObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadChats$16, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadChats$16$ChatLinkActivity(TLObject tLObject) {
        if (tLObject instanceof TLRPC$messages_Chats) {
            TLRPC$messages_Chats tLRPC$messages_Chats = (TLRPC$messages_Chats) tLObject;
            getMessagesController().putChats(tLRPC$messages_Chats.chats, false);
            this.chats = tLRPC$messages_Chats.chats;
        }
        this.loadingChats = false;
        this.chatsLoaded = true;
        updateRows();
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onResume() {
        super.onResume();
        ListAdapter listAdapter = this.listViewAdapter;
        if (listAdapter != null) {
            listAdapter.notifyDataSetChanged();
        }
    }

    public class HintInnerCell extends FrameLayout {
        private EmptyView emptyView;
        private TextView messageTextView;

        public HintInnerCell(Context context) {
            super(context);
            EmptyView emptyView = new EmptyView(context);
            this.emptyView = emptyView;
            addView(emptyView, LayoutHelper.createFrame(-2, -2.0f, 49, 0.0f, 10.0f, 0.0f, 0.0f));
            TextView textView = new TextView(context);
            this.messageTextView = textView;
            textView.setTextColor(Theme.getColor("chats_message"));
            this.messageTextView.setTextSize(1, 14.0f);
            this.messageTextView.setGravity(17);
            if (ChatLinkActivity.this.isChannel) {
                if (ChatLinkActivity.this.info != null && ChatLinkActivity.this.info.linked_chat_id != 0) {
                    TLRPC$Chat chat = ChatLinkActivity.this.getMessagesController().getChat(Long.valueOf(ChatLinkActivity.this.info.linked_chat_id));
                    if (chat != null) {
                        this.messageTextView.setText(AndroidUtilities.replaceTags(LocaleController.formatString("DiscussionChannelGroupSetHelp2", R.string.DiscussionChannelGroupSetHelp2, chat.title)));
                    }
                } else {
                    this.messageTextView.setText(LocaleController.getString("DiscussionChannelHelp3", R.string.DiscussionChannelHelp3));
                }
            } else {
                TLRPC$Chat chat2 = ChatLinkActivity.this.getMessagesController().getChat(Long.valueOf(ChatLinkActivity.this.info.linked_chat_id));
                if (chat2 != null) {
                    this.messageTextView.setText(AndroidUtilities.replaceTags(LocaleController.formatString("DiscussionGroupHelp", R.string.DiscussionGroupHelp, chat2.title)));
                }
            }
            addView(this.messageTextView, LayoutHelper.createFrame(-1, -2.0f, 51, 52.0f, 143.0f, 52.0f, 18.0f));
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(widthMeasureSpec), 1073741824), heightMeasureSpec);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class SearchAdapter extends RecyclerListView.SelectionAdapter {
        private Context mContext;
        private ArrayList<TLRPC$Chat> searchResult = new ArrayList<>();
        private ArrayList<CharSequence> searchResultNames = new ArrayList<>();
        private Runnable searchRunnable;

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            return 0;
        }

        public SearchAdapter(Context context) {
            this.mContext = context;
        }

        public void searchDialogs(final String query) throws InterruptedException {
            if (this.searchRunnable != null) {
                Utilities.searchQueue.cancelRunnable(this.searchRunnable);
                this.searchRunnable = null;
            }
            if (TextUtils.isEmpty(query)) {
                this.searchResult.clear();
                this.searchResultNames.clear();
                notifyDataSetChanged();
            } else {
                DispatchQueue dispatchQueue = Utilities.searchQueue;
                Runnable runnable = new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ChatLinkActivity$SearchAdapter$HSav2iC1It4t-SjN87eMolF9r4E
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$searchDialogs$0$ChatLinkActivity$SearchAdapter(query);
                    }
                };
                this.searchRunnable = runnable;
                dispatchQueue.postRunnable(runnable, 300L);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: processSearch, reason: merged with bridge method [inline-methods] */
        public void lambda$searchDialogs$0$ChatLinkActivity$SearchAdapter(final String query) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ChatLinkActivity$SearchAdapter$eGdBdr2Nh0FAbnMIMtHDM5zx-KU
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$processSearch$2$ChatLinkActivity$SearchAdapter(query);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$processSearch$2, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$processSearch$2$ChatLinkActivity$SearchAdapter(final String str) {
            this.searchRunnable = null;
            final ArrayList arrayList = new ArrayList(ChatLinkActivity.this.chats);
            Utilities.searchQueue.postRunnable(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ChatLinkActivity$SearchAdapter$TvHfTleHgAntqub3yAJOTAXskoY
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$processSearch$1$ChatLinkActivity$SearchAdapter(str, arrayList);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:41:0x00be  */
        /* JADX WARN: Removed duplicated region for block: B:47:0x00fd A[LOOP:1: B:25:0x0073->B:47:0x00fd, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:55:0x00c1 A[SYNTHETIC] */
        /* renamed from: lambda$processSearch$1, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public /* synthetic */ void lambda$processSearch$1$ChatLinkActivity$SearchAdapter(java.lang.String r18, java.util.ArrayList r19) {
            /*
                Method dump skipped, instructions count: 269
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.ChatLinkActivity.SearchAdapter.lambda$processSearch$1$ChatLinkActivity$SearchAdapter(java.lang.String, java.util.ArrayList):void");
        }

        private void updateSearchResults(final ArrayList<TLRPC$Chat> chats, final ArrayList<CharSequence> names) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ChatLinkActivity$SearchAdapter$i1IjYLlr8Z-nlFzc_iGMGxIp4jQ
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$updateSearchResults$3$ChatLinkActivity$SearchAdapter(chats, names);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$updateSearchResults$3, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$updateSearchResults$3$ChatLinkActivity$SearchAdapter(ArrayList arrayList, ArrayList arrayList2) {
            if (ChatLinkActivity.this.searching) {
                this.searchResult = arrayList;
                this.searchResultNames = arrayList2;
                if (ChatLinkActivity.this.listView.getAdapter() == ChatLinkActivity.this.searchAdapter) {
                    ChatLinkActivity.this.emptyView.showTextView();
                }
                notifyDataSetChanged();
            }
        }

        @Override // ir.eitaa.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder holder) {
            return holder.getItemViewType() != 1;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.searchResult.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void notifyDataSetChanged() {
            super.notifyDataSetChanged();
        }

        public TLRPC$Chat getItem(int i) {
            return this.searchResult.get(i);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            ManageChatUserCell manageChatUserCell = new ManageChatUserCell(this.mContext, 6, 2, false);
            manageChatUserCell.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
            return new RecyclerListView.Holder(manageChatUserCell);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            TLRPC$Chat tLRPC$Chat = this.searchResult.get(position);
            String str = tLRPC$Chat.username;
            CharSequence charSequence = this.searchResultNames.get(position);
            CharSequence charSequence2 = null;
            if (charSequence != null && !TextUtils.isEmpty(str)) {
                if (charSequence.toString().startsWith("@" + str)) {
                    charSequence2 = charSequence;
                    charSequence = null;
                }
            }
            ManageChatUserCell manageChatUserCell = (ManageChatUserCell) holder.itemView;
            manageChatUserCell.setTag(Integer.valueOf(position));
            manageChatUserCell.setData(tLRPC$Chat, charSequence, charSequence2, false);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onViewRecycled(RecyclerView.ViewHolder holder) {
            View view = holder.itemView;
            if (view instanceof ManageChatUserCell) {
                ((ManageChatUserCell) view).recycle();
            }
        }
    }

    private class ListAdapter extends RecyclerListView.SelectionAdapter {
        private Context mContext;

        public ListAdapter(Context context) {
            this.mContext = context;
        }

        @Override // ir.eitaa.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder holder) {
            int itemViewType = holder.getItemViewType();
            return itemViewType == 0 || itemViewType == 2;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            if (!ChatLinkActivity.this.loadingChats || ChatLinkActivity.this.chatsLoaded) {
                return ChatLinkActivity.this.rowCount;
            }
            return 0;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View manageChatUserCell;
            View textInfoPrivacyCell;
            if (viewType == 0) {
                manageChatUserCell = new ManageChatUserCell(this.mContext, 6, 2, false);
                manageChatUserCell.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
            } else {
                if (viewType == 1) {
                    textInfoPrivacyCell = new TextInfoPrivacyCell(this.mContext);
                    textInfoPrivacyCell.setBackgroundDrawable(Theme.getThemedDrawable(this.mContext, R.drawable.greydivider_bottom, "windowBackgroundGrayShadow"));
                } else if (viewType == 2) {
                    manageChatUserCell = new ManageChatTextCell(this.mContext);
                    manageChatUserCell.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
                } else {
                    textInfoPrivacyCell = ChatLinkActivity.this.new HintInnerCell(this.mContext);
                }
                return new RecyclerListView.Holder(textInfoPrivacyCell);
            }
            textInfoPrivacyCell = manageChatUserCell;
            return new RecyclerListView.Holder(textInfoPrivacyCell);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            String str;
            int itemViewType = holder.getItemViewType();
            if (itemViewType == 0) {
                ManageChatUserCell manageChatUserCell = (ManageChatUserCell) holder.itemView;
                manageChatUserCell.setTag(Integer.valueOf(position));
                TLRPC$Chat tLRPC$Chat = (TLRPC$Chat) ChatLinkActivity.this.chats.get(position - ChatLinkActivity.this.chatStartRow);
                if (TextUtils.isEmpty(tLRPC$Chat.username)) {
                    str = null;
                } else {
                    str = "@" + tLRPC$Chat.username;
                }
                manageChatUserCell.setData(tLRPC$Chat, null, str, (position == ChatLinkActivity.this.chatEndRow - 1 && ChatLinkActivity.this.info.linked_chat_id == 0) ? false : true);
                return;
            }
            if (itemViewType == 1) {
                TextInfoPrivacyCell textInfoPrivacyCell = (TextInfoPrivacyCell) holder.itemView;
                if (position == ChatLinkActivity.this.detailRow) {
                    if (ChatLinkActivity.this.isChannel) {
                        textInfoPrivacyCell.setText(LocaleController.getString("DiscussionChannelHelp2", R.string.DiscussionChannelHelp2));
                        return;
                    } else {
                        textInfoPrivacyCell.setText(LocaleController.getString("DiscussionGroupHelp2", R.string.DiscussionGroupHelp2));
                        return;
                    }
                }
                return;
            }
            if (itemViewType != 2) {
                return;
            }
            ManageChatTextCell manageChatTextCell = (ManageChatTextCell) holder.itemView;
            if (!ChatLinkActivity.this.isChannel) {
                manageChatTextCell.setColors("windowBackgroundWhiteRedText5", "windowBackgroundWhiteRedText5");
                manageChatTextCell.setText(LocaleController.getString("DiscussionUnlinkChannel", R.string.DiscussionUnlinkChannel), null, R.drawable.actions_remove_user, false);
            } else if (ChatLinkActivity.this.info.linked_chat_id != 0) {
                manageChatTextCell.setColors("windowBackgroundWhiteRedText5", "windowBackgroundWhiteRedText5");
                manageChatTextCell.setText(LocaleController.getString("DiscussionUnlinkGroup", R.string.DiscussionUnlinkGroup), null, R.drawable.actions_remove_user, false);
            } else {
                manageChatTextCell.setColors("windowBackgroundWhiteBlueIcon", "windowBackgroundWhiteBlueButton");
                manageChatTextCell.setText(LocaleController.getString("DiscussionCreateGroup", R.string.DiscussionCreateGroup), null, R.drawable.menu_groups, true);
            }
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
            if (position == ChatLinkActivity.this.helpRow) {
                return 3;
            }
            if (position == ChatLinkActivity.this.createChatRow || position == ChatLinkActivity.this.removeChatRow) {
                return 2;
            }
            return (position < ChatLinkActivity.this.chatStartRow || position >= ChatLinkActivity.this.chatEndRow) ? 1 : 0;
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public ArrayList<ThemeDescription> getThemeDescriptions() {
        ArrayList<ThemeDescription> arrayList = new ArrayList<>();
        ThemeDescription.ThemeDescriptionDelegate themeDescriptionDelegate = new ThemeDescription.ThemeDescriptionDelegate() { // from class: ir.eitaa.ui.-$$Lambda$ChatLinkActivity$ORmOcPRcw_kxEszZ8i4q91jsRg8
            @Override // ir.eitaa.ui.ActionBar.ThemeDescription.ThemeDescriptionDelegate
            public final void didSetColor() {
                this.f$0.lambda$getThemeDescriptions$18$ChatLinkActivity();
            }

            @Override // ir.eitaa.ui.ActionBar.ThemeDescription.ThemeDescriptionDelegate
            public /* synthetic */ void onAnimationProgress(float f) {
                ThemeDescription.ThemeDescriptionDelegate.CC.$default$onAnimationProgress(this, f);
            }
        };
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CELLBACKGROUNDCOLOR, new Class[]{ManageChatUserCell.class, ManageChatTextCell.class}, null, null, null, "windowBackgroundWhite"));
        arrayList.add(new ThemeDescription(this.fragmentView, ThemeDescription.FLAG_BACKGROUND | ThemeDescription.FLAG_CHECKTAG, null, null, null, null, "windowBackgroundGray"));
        arrayList.add(new ThemeDescription(this.fragmentView, ThemeDescription.FLAG_CHECKTAG | ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "windowBackgroundWhite"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "actionBarDefault"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_LISTGLOWCOLOR, null, null, null, null, "actionBarDefault"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_ITEMSCOLOR, null, null, null, null, "actionBarDefaultIcon"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_TITLECOLOR, null, null, null, null, "actionBarDefaultTitle"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SELECTORCOLOR, null, null, null, null, "actionBarDefaultSelector"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_SELECTOR, null, null, null, null, "listSelectorSDK21"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{View.class}, Theme.dividerPaint, null, null, "divider"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{TextInfoPrivacyCell.class}, null, null, null, "windowBackgroundGrayShadow"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextInfoPrivacyCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteGrayText4"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{ManageChatUserCell.class}, new String[]{"nameTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{ManageChatUserCell.class}, new String[]{"statusColor"}, (Paint[]) null, (Drawable[]) null, themeDescriptionDelegate, "windowBackgroundWhiteGrayText"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{ManageChatUserCell.class}, new String[]{"statusOnlineColor"}, (Paint[]) null, (Drawable[]) null, themeDescriptionDelegate, "windowBackgroundWhiteBlueText"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{ManageChatUserCell.class}, null, Theme.avatarDrawables, null, "avatar_text"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, "avatar_backgroundRed"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, "avatar_backgroundOrange"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, "avatar_backgroundViolet"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, "avatar_backgroundGreen"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, "avatar_backgroundCyan"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, "avatar_backgroundBlue"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, "avatar_backgroundPink"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{HintInnerCell.class}, new String[]{"messageTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "chats_message"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CHECKTAG, new Class[]{ManageChatTextCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CHECKTAG, new Class[]{ManageChatTextCell.class}, new String[]{"imageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteGrayIcon"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CHECKTAG, new Class[]{ManageChatTextCell.class}, new String[]{"imageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlueButton"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CHECKTAG, new Class[]{ManageChatTextCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlueIcon"));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$getThemeDescriptions$18, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$getThemeDescriptions$18$ChatLinkActivity() {
        RecyclerListView recyclerListView = this.listView;
        if (recyclerListView != null) {
            int childCount = recyclerListView.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.listView.getChildAt(i);
                if (childAt instanceof ManageChatUserCell) {
                    ((ManageChatUserCell) childAt).update(0);
                }
            }
        }
    }
}
