package ir.eitaa.ui;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.collection.LongSparseArray;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ApplicationLoader;
import ir.eitaa.messenger.ChatObject;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.ImageLocation;
import ir.eitaa.messenger.ImageReceiver;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MediaDataController;
import ir.eitaa.messenger.MessageObject;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.messenger.MessagesStorage;
import ir.eitaa.messenger.NotificationCenter;
import ir.eitaa.messenger.NotificationsController;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.UserConfig;
import ir.eitaa.tgnet.ConnectionsManager;
import ir.eitaa.tgnet.TLRPC$Chat;
import ir.eitaa.tgnet.TLRPC$ChatFull;
import ir.eitaa.tgnet.TLRPC$ChatPhoto;
import ir.eitaa.tgnet.TLRPC$TL_channelForbidden;
import ir.eitaa.tgnet.TLRPC$TL_dialog;
import ir.eitaa.tgnet.TLRPC$TL_peerNotifySettings;
import ir.eitaa.ui.ActionBar.ActionBar;
import ir.eitaa.ui.ActionBar.ActionBarMenuItem;
import ir.eitaa.ui.ActionBar.AlertDialog;
import ir.eitaa.ui.ActionBar.BackDrawable;
import ir.eitaa.ui.ActionBar.BaseFragment;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.ActionBar.ThemeDescription;
import ir.eitaa.ui.Cells.GraySectionCell;
import ir.eitaa.ui.Cells.LoadingCell;
import ir.eitaa.ui.Cells.MediaChatInfoCell;
import ir.eitaa.ui.Cells.SharedAudioCell;
import ir.eitaa.ui.Cells.SharedDocumentCell;
import ir.eitaa.ui.Cells.SharedLinkCell;
import ir.eitaa.ui.Cells.SharedMediaSectionCell;
import ir.eitaa.ui.Cells.StaggeredMediaCell;
import ir.eitaa.ui.Components.AlertsCreator;
import ir.eitaa.ui.Components.CombinedDrawable;
import ir.eitaa.ui.Components.FragmentContextView;
import ir.eitaa.ui.Components.LayoutHelper;
import ir.eitaa.ui.Components.RecyclerListView;
import ir.eitaa.ui.PhotoViewer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;

/* loaded from: classes3.dex */
public class MediaChannelActivity extends BaseFragment implements NotificationCenter.NotificationCenterDelegate {
    private ImageReceiver avatarImage;
    private ArrayList<StaggeredMediaCell> cache;
    private ArrayList<StaggeredMediaCell> cellCache;
    private int columnsCount;
    private TLRPC$Chat currentChat;
    private long dialog_id;
    private ImageView emptyImageView;
    private TextView emptyTextView;
    private LinearLayout emptyView;
    private boolean firstLoaded;
    private ImageView floatingButton;
    private final AccelerateDecelerateInterpolator floatingInterpolator;
    private boolean floatingShow;
    private FragmentContextView fragmentContextView;
    protected TLRPC$ChatFull info;
    private LinearLayoutManager layoutManager;
    private RecyclerListView listView;
    private MediaChatInfoCell mediaChatInfoCell;
    private long mergeDialogId;
    private SharedPhotoVideoAdapter photoVideoAdapter;
    private PhotoViewer.PhotoViewerProvider provider;
    private SharedMediaData sharedMediaData;
    private int unreadCount;

    static /* synthetic */ boolean lambda$createView$0(View view, MotionEvent motionEvent) {
        return true;
    }

    private class SharedMediaData {
        private boolean[] endReached;
        private LongSparseArray<MessageObject.GroupedMessages> groupedMessagesMap;
        private boolean loading;
        private int[] max_id;
        private ArrayList<MessageObject> messages;
        private SparseArray<MessageObject>[] messagesDict;
        private int totalCount;

        private SharedMediaData() {
            this.messages = new ArrayList<>();
            this.messagesDict = new SparseArray[]{new SparseArray<>(), new SparseArray<>()};
            this.groupedMessagesMap = new LongSparseArray<>();
            this.endReached = new boolean[]{false, true};
            this.max_id = new int[]{0, 0};
        }

        public boolean addMessage(MessageObject messageObject, boolean isNew, boolean enc) {
            boolean z;
            int iIndexOf;
            char c = messageObject.getDialogId() == MediaChannelActivity.this.dialog_id ? (char) 0 : (char) 1;
            if (this.messagesDict[c].indexOfKey(messageObject.getId()) >= 0) {
                return false;
            }
            if (messageObject.getGroupId() == 0) {
                z = true;
            } else {
                MessageObject.GroupedMessages groupedMessages = this.groupedMessagesMap.get(messageObject.getGroupId());
                if (groupedMessages != null) {
                    ArrayList<MessageObject> arrayList = groupedMessages.messages;
                    int i = 0;
                    while (true) {
                        if (i >= arrayList.size()) {
                            break;
                        }
                        if (messageObject.getId() < arrayList.get(i).getId()) {
                            arrayList.add(i, messageObject);
                            break;
                        }
                        i++;
                    }
                    if (arrayList.isEmpty()) {
                        arrayList.add(messageObject);
                    }
                    if (arrayList.size() > 1) {
                        arrayList.get(0).isNotAloneInGroup = true;
                    }
                    MessageObject messageObject2 = arrayList.size() > 1 ? arrayList.get(1) : messageObject;
                    if (messageObject2 != null && (iIndexOf = this.messages.indexOf(messageObject2)) >= 0) {
                        this.messages.set(iIndexOf, messageObject);
                    }
                    z = false;
                } else {
                    MessageObject.GroupedMessages groupedMessages2 = new MessageObject.GroupedMessages();
                    groupedMessages2.groupId = messageObject.getGroupId();
                    groupedMessages2.messages.add(messageObject);
                    this.groupedMessagesMap.put(groupedMessages2.groupId, groupedMessages2);
                    z = true;
                }
            }
            if (z) {
                if (isNew) {
                    this.messages.add(0, messageObject);
                } else {
                    this.messages.add(messageObject);
                }
            }
            this.messagesDict[c].put(messageObject.getId(), messageObject);
            if (!enc) {
                if (messageObject.getId() > 0) {
                    this.max_id[c] = Math.min(messageObject.getId(), this.max_id[c]);
                }
            } else {
                this.max_id[c] = Math.max(messageObject.getId(), this.max_id[c]);
            }
            return true;
        }

        public boolean deleteMessage(int mid, int loadIndex) {
            MessageObject messageObject = this.messagesDict[loadIndex].get(mid);
            if (messageObject == null) {
                return false;
            }
            if (messageObject.getGroupId() != 0) {
                MessageObject.GroupedMessages groupedMessages = this.groupedMessagesMap.get(messageObject.getGroupId());
                if (groupedMessages != null) {
                    groupedMessages.messages.remove(messageObject);
                    MessageObject messageObject2 = null;
                    Iterator<MessageObject> it = groupedMessages.messages.iterator();
                    while (it.hasNext()) {
                        MessageObject next = it.next();
                        if (messageObject2 == null || messageObject2.getId() > next.getId()) {
                            messageObject2 = next;
                        }
                    }
                    int iIndexOf = this.messages.indexOf(messageObject);
                    if (iIndexOf >= 0 && messageObject2 != null) {
                        this.messages.set(iIndexOf, messageObject2);
                        if (groupedMessages.messages.size() > 1) {
                            messageObject2.isNotAloneInGroup = true;
                        } else {
                            messageObject2.isNotAloneInGroup = false;
                        }
                    } else {
                        this.messages.remove(messageObject);
                    }
                }
            } else {
                this.messages.remove(messageObject);
            }
            this.messagesDict[loadIndex].remove(messageObject.getId());
            this.totalCount--;
            return true;
        }

        public void replaceMid(int oldMid, int newMid) {
            MessageObject messageObject = this.messagesDict[0].get(oldMid);
            if (messageObject != null) {
                this.messagesDict[0].remove(oldMid);
                this.messagesDict[0].put(newMid, messageObject);
                messageObject.messageOwner.id = newMid;
            }
        }
    }

    public MediaChannelActivity(Bundle args) {
        super(args);
        this.floatingInterpolator = new AccelerateDecelerateInterpolator();
        this.cellCache = new ArrayList<>(6);
        this.cache = new ArrayList<>(6);
        this.info = null;
        this.columnsCount = 3;
        this.firstLoaded = false;
        this.provider = new PhotoViewer.EmptyPhotoViewerProvider() { // from class: ir.eitaa.ui.MediaChannelActivity.1
            @Override // ir.eitaa.ui.PhotoViewer.EmptyPhotoViewerProvider, ir.eitaa.ui.PhotoViewer.PhotoViewerProvider
            public void willHidePhotoViewer() {
                MediaChannelActivity.this.avatarImage.setVisible(true, true);
            }
        };
        this.sharedMediaData = new SharedMediaData();
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public boolean onFragmentCreate() throws InterruptedException {
        super.onFragmentCreate();
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.closeChats);
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.didUpdateMessagesViews);
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.mediaDidLoad);
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.messagesDeleted);
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.didReceiveNewMessages);
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.updateInterfaces);
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.messageReceivedByServer);
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.chatInfoDidLoad);
        long j = getArguments().getLong("dialog_id", 0L);
        this.dialog_id = j;
        if (j < 0) {
            final Long lValueOf = Long.valueOf(-j);
            if (lValueOf.longValue() != 0) {
                TLRPC$Chat chat = MessagesController.getInstance(this.currentAccount).getChat(lValueOf);
                this.currentChat = chat;
                if (chat == null) {
                    final CountDownLatch countDownLatch = new CountDownLatch(1);
                    MessagesStorage.getInstance(this.currentAccount).getStorageQueue().postRunnable(new Runnable() { // from class: ir.eitaa.ui.MediaChannelActivity.2
                        @Override // java.lang.Runnable
                        public void run() {
                            MediaChannelActivity mediaChannelActivity = MediaChannelActivity.this;
                            mediaChannelActivity.currentChat = MessagesStorage.getInstance(((BaseFragment) mediaChannelActivity).currentAccount).getChat(lValueOf.longValue());
                            countDownLatch.countDown();
                        }
                    });
                    try {
                        countDownLatch.await();
                    } catch (Exception e) {
                        FileLog.e(e);
                    }
                    if (this.currentChat == null) {
                        return false;
                    }
                    MessagesController.getInstance(this.currentAccount).putChat(this.currentChat, true);
                }
            }
        }
        TLRPC$TL_dialog tLRPC$TL_dialog = (TLRPC$TL_dialog) MessagesController.getInstance(UserConfig.selectedAccount).dialogs_dict.get(this.dialog_id);
        if (tLRPC$TL_dialog != null) {
            this.unreadCount = tLRPC$TL_dialog.unread_count;
            MessagesController messagesController = MessagesController.getInstance(this.currentAccount);
            long j2 = tLRPC$TL_dialog.id;
            int i = tLRPC$TL_dialog.top_message;
            messagesController.markDialogAsRead(j2, i, i, tLRPC$TL_dialog.last_message_date, false, 0, 0, false, 0);
        }
        SharedMediaData sharedMediaData = new SharedMediaData();
        this.sharedMediaData = sharedMediaData;
        sharedMediaData.max_id[0] = ((int) this.dialog_id) == 0 ? Integer.MIN_VALUE : ConnectionsManager.DEFAULT_DATACENTER_ID;
        if (this.mergeDialogId != 0 && this.info != null) {
            this.sharedMediaData.max_id[1] = this.info.migrated_from_max_id;
            this.sharedMediaData.endReached[1] = false;
        }
        this.sharedMediaData.loading = true;
        MediaDataController.getInstance(this.currentAccount).loadMedia(this.dialog_id, 50, 0, 0, 1, this.classGuid);
        if (this.currentChat == null) {
            return false;
        }
        CountDownLatch countDownLatch2 = new CountDownLatch(1);
        MessagesController messagesController2 = MessagesController.getInstance(this.currentAccount);
        TLRPC$Chat tLRPC$Chat = this.currentChat;
        messagesController2.loadChatInfo(tLRPC$Chat.id, ChatObject.isChannel(tLRPC$Chat), countDownLatch2, ChatObject.isChannel(this.currentChat));
        try {
            countDownLatch2.await();
        } catch (Exception e2) {
            FileLog.e(e2);
        }
        if (ChatObject.isChannel(this.currentChat)) {
            MessagesController.getInstance(this.currentAccount).startShortPoll(this.currentChat, this.classGuid, false);
        }
        return true;
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onFragmentDestroy() throws InterruptedException {
        super.onFragmentDestroy();
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.closeChats);
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.didUpdateMessagesViews);
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.mediaDidLoad);
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.didReceiveNewMessages);
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.updateInterfaces);
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.messagesDeleted);
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.messageReceivedByServer);
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.chatInfoDidLoad);
        if (ChatObject.isChannel(this.currentChat)) {
            MessagesController.getInstance(this.currentAccount).startShortPoll(this.currentChat, this.classGuid, true);
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public View createView(Context context) {
        String str;
        Theme.createProfileResources(context);
        this.actionBar.setBackButtonDrawable(new BackDrawable(false));
        TLRPC$Chat tLRPC$Chat = this.currentChat;
        if (tLRPC$Chat != null) {
            if (!TextUtils.isEmpty(tLRPC$Chat.username)) {
                this.actionBar.setTitle(this.currentChat.username);
            } else {
                this.actionBar.setTitle(LocaleController.getString("ChannelPrivate", R.string.ChannelPrivate));
            }
        }
        this.actionBar.setAllowOverlayTitle(false);
        this.actionBar.setActionBarMenuOnItemClick(new AnonymousClass3());
        ActionBarMenuItem actionBarMenuItemAddItem = this.actionBar.createMenu().addItem(0, R.drawable.ic_ab_other);
        actionBarMenuItemAddItem.setContentDescription(LocaleController.getString("BotsMenuTitle", R.string.BotsMenuTitle));
        if (ChatObject.hasAdminRights(this.currentChat)) {
            actionBarMenuItemAddItem.addSubItem(12, LocaleController.getString("ManageChannelMenu", R.string.ManageChannelMenu));
        }
        actionBarMenuItemAddItem.addSubItem(24, LocaleController.getString("AddShortcut", R.string.AddShortcut));
        if (ChatObject.isChannel(this.currentChat)) {
            TLRPC$Chat tLRPC$Chat2 = this.currentChat;
            if (!tLRPC$Chat2.creator && (!tLRPC$Chat2.megagroup || ((str = tLRPC$Chat2.username) != null && str.length() > 0))) {
                actionBarMenuItemAddItem.addSubItem(21, LocaleController.getString("ReportChat", R.string.ReportChat));
            }
        }
        TLRPC$Chat tLRPC$Chat3 = this.currentChat;
        if (!tLRPC$Chat3.creator && !tLRPC$Chat3.left && !tLRPC$Chat3.kicked && !tLRPC$Chat3.megagroup) {
            actionBarMenuItemAddItem.addSubItem(22, LocaleController.getString("LeaveChannel", R.string.LeaveChannel));
        }
        this.actionBar.createActionMode(false, null).setBackgroundColor(Theme.getColor("actionBarDefault"));
        this.actionBar.setItemsColor(Theme.getColor("actionBarDefaultIcon"), true);
        this.actionBar.setItemsBackgroundColor(Theme.getColor("actionBarDefaultSelector"), true);
        this.photoVideoAdapter = new SharedPhotoVideoAdapter(context);
        FrameLayout frameLayout = new FrameLayout(context);
        this.fragmentView = frameLayout;
        this.layoutManager = new LinearLayoutManager(context, 1, false);
        RecyclerListView recyclerListView = new RecyclerListView(context) { // from class: ir.eitaa.ui.MediaChannelActivity.4
            Drawable headerShadowDrawable = getResources().getDrawable(R.drawable.header_shadow).mutate();

            @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
            public boolean drawChild(Canvas canvas, View child, long drawingTime) {
                boolean zDrawChild = super.drawChild(canvas, child, drawingTime);
                if ((child instanceof StaggeredMediaCell) && ((StaggeredMediaCell) child).isFirst && this.headerShadowDrawable != null) {
                    int top = child.getTop();
                    this.headerShadowDrawable.setBounds(0, top, getMeasuredWidth(), this.headerShadowDrawable.getIntrinsicHeight() + top);
                    this.headerShadowDrawable.draw(canvas);
                }
                return zDrawChild;
            }
        };
        this.listView = recyclerListView;
        recyclerListView.setClipToPadding(false);
        this.listView.setLayoutManager(this.layoutManager);
        frameLayout.addView(this.listView, LayoutHelper.createFrame(-1, -1.0f));
        this.listView.setOnScrollListener(new RecyclerView.OnScrollListener() { // from class: ir.eitaa.ui.MediaChannelActivity.5
            private int prevPosition;
            private int prevTop;
            private boolean scrollUpdated;
            private boolean scrollingManually;

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                this.scrollingManually = newState == 1;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                boolean z;
                int iFindFirstVisibleItemPosition = MediaChannelActivity.this.layoutManager.findFirstVisibleItemPosition();
                int iAbs = iFindFirstVisibleItemPosition == -1 ? 0 : Math.abs(MediaChannelActivity.this.layoutManager.findLastVisibleItemPosition() - iFindFirstVisibleItemPosition) + 1;
                int itemCount = recyclerView.getAdapter().getItemCount();
                if (iAbs != 0 && iAbs + iFindFirstVisibleItemPosition > itemCount - 2 && !MediaChannelActivity.this.sharedMediaData.loading) {
                    if (!MediaChannelActivity.this.sharedMediaData.endReached[0]) {
                        MediaChannelActivity.this.sharedMediaData.loading = true;
                        MediaDataController.getInstance(((BaseFragment) MediaChannelActivity.this).currentAccount).loadMedia(MediaChannelActivity.this.dialog_id, 50, MediaChannelActivity.this.sharedMediaData.max_id[0], 0, 1, ((BaseFragment) MediaChannelActivity.this).classGuid);
                    } else if (MediaChannelActivity.this.mergeDialogId != 0 && !MediaChannelActivity.this.sharedMediaData.endReached[1]) {
                        MediaChannelActivity.this.sharedMediaData.loading = true;
                        MediaDataController.getInstance(((BaseFragment) MediaChannelActivity.this).currentAccount).loadMedia(MediaChannelActivity.this.mergeDialogId, 50, MediaChannelActivity.this.sharedMediaData.max_id[1], 0, 1, ((BaseFragment) MediaChannelActivity.this).classGuid);
                    }
                }
                View childAt = recyclerView.getChildAt(0);
                int top = childAt != null ? childAt.getTop() : 0;
                int i = this.prevPosition;
                if (i == iFindFirstVisibleItemPosition) {
                    int i2 = this.prevTop;
                    int i3 = i2 - top;
                    z = top < i2;
                    if (Math.abs(i3) > 1) {
                    }
                    if (z && this.scrollUpdated && (z || (!z && this.scrollingManually))) {
                        MediaChannelActivity.this.showFloatingButton(z);
                    }
                    this.prevPosition = iFindFirstVisibleItemPosition;
                    this.prevTop = top;
                    this.scrollUpdated = true;
                }
                z = iFindFirstVisibleItemPosition > i;
                z = true;
                if (z) {
                    MediaChannelActivity.this.showFloatingButton(z);
                }
                this.prevPosition = iFindFirstVisibleItemPosition;
                this.prevTop = top;
                this.scrollUpdated = true;
            }
        });
        LinearLayout linearLayout = new LinearLayout(context);
        this.emptyView = linearLayout;
        linearLayout.setOrientation(1);
        this.emptyView.setGravity(17);
        this.emptyView.setVisibility(8);
        this.emptyView.setBackgroundColor(Theme.getColor("windowBackgroundGray"));
        frameLayout.addView(this.emptyView, LayoutHelper.createFrame(-1, -1.0f));
        this.emptyView.setOnTouchListener(new View.OnTouchListener() { // from class: ir.eitaa.ui.-$$Lambda$MediaChannelActivity$HHdBloulk9iJmCq_E6VJLqpMx4g
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return MediaChannelActivity.lambda$createView$0(view, motionEvent);
            }
        });
        ImageView imageView = new ImageView(context);
        this.emptyImageView = imageView;
        this.emptyView.addView(imageView, LayoutHelper.createLinear(-2, -2));
        TextView textView = new TextView(context);
        this.emptyTextView = textView;
        textView.setTextColor(Theme.getColor("windowBackgroundWhiteGrayText2"));
        this.emptyTextView.setGravity(17);
        this.emptyTextView.setTextSize(1, 17.0f);
        this.emptyTextView.setPadding(AndroidUtilities.dp(40.0f), 0, AndroidUtilities.dp(40.0f), AndroidUtilities.dp(128.0f));
        this.emptyView.addView(this.emptyTextView, LayoutHelper.createLinear(-2, -2, 17, 0, 24, 0, 0));
        for (int i = 0; i < 6; i++) {
            this.cellCache.add(new StaggeredMediaCell(context));
        }
        switchToCurrentSelectedMode(false);
        if (!AndroidUtilities.isTablet()) {
            FragmentContextView fragmentContextView = new FragmentContextView(context, this, false);
            this.fragmentContextView = fragmentContextView;
            frameLayout.addView(fragmentContextView, LayoutHelper.createFrame(-1, 39.0f, 51, 0.0f, 8.0f, 0.0f, 0.0f));
        }
        ImageView imageView2 = new ImageView(context);
        this.floatingButton = imageView2;
        imageView2.setTranslationY(AndroidUtilities.dp(100.0f));
        this.floatingButton.setScaleType(ImageView.ScaleType.CENTER);
        ShapeDrawable shapeDrawableCreateCircleDrawable = Theme.createCircleDrawable(AndroidUtilities.dp(42.0f), Theme.getColor("chat_goDownButton"));
        Drawable drawableMutate = context.getResources().getDrawable(R.drawable.pagedown_shadow).mutate();
        drawableMutate.setColorFilter(new PorterDuffColorFilter(Theme.getColor("chat_goDownButtonShadow"), PorterDuff.Mode.MULTIPLY));
        CombinedDrawable combinedDrawable = new CombinedDrawable(drawableMutate, shapeDrawableCreateCircleDrawable, 0, 0);
        combinedDrawable.setIconSize(AndroidUtilities.dp(42.0f), AndroidUtilities.dp(42.0f));
        this.floatingButton.setBackgroundDrawable(combinedDrawable);
        this.floatingButton.setPadding(0, AndroidUtilities.dp(2.0f), 0, 0);
        this.floatingButton.setColorFilter(new PorterDuffColorFilter(Theme.getColor("chat_goDownButtonIcon"), PorterDuff.Mode.MULTIPLY));
        this.floatingButton.setImageResource(R.drawable.pagedown);
        this.floatingButton.setContentDescription(LocaleController.getString("ScrollToTop", R.string.ScrollToTop));
        this.floatingButton.setRotation(180.0f);
        ImageView imageView3 = this.floatingButton;
        boolean z = LocaleController.isRTL;
        frameLayout.addView(imageView3, LayoutHelper.createFrame(46, 46.0f, (z ? 3 : 5) | 80, z ? 14.0f : 0.0f, 0.0f, z ? 0.0f : 14.0f, 14.0f));
        this.floatingButton.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$MediaChannelActivity$1_1wqOrRPIK6IKVSFOXi1TnIYgo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$createView$1$MediaChannelActivity(view);
            }
        });
        return this.fragmentView;
    }

    /* renamed from: ir.eitaa.ui.MediaChannelActivity$3, reason: invalid class name */
    class AnonymousClass3 extends ActionBar.ActionBarMenuOnItemClick {
        AnonymousClass3() {
        }

        @Override // ir.eitaa.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
        public void onItemClick(int id) {
            if (id == -1) {
                if (((BaseFragment) MediaChannelActivity.this).actionBar.isActionModeShowed()) {
                    ((BaseFragment) MediaChannelActivity.this).actionBar.hideActionMode();
                    int childCount = MediaChannelActivity.this.listView.getChildCount();
                    for (int i = 0; i < childCount; i++) {
                        View childAt = MediaChannelActivity.this.listView.getChildAt(i);
                        if (childAt instanceof StaggeredMediaCell) {
                            for (int i2 = 0; i2 < 6; i2++) {
                                ((StaggeredMediaCell) childAt).setChecked(i2, false, true);
                            }
                        }
                    }
                    return;
                }
                MediaChannelActivity.this.finishFragment();
                return;
            }
            if (id == 24) {
                try {
                    MediaDataController.getInstance(((BaseFragment) MediaChannelActivity.this).currentAccount).installShortcut(-MediaChannelActivity.this.currentChat.id);
                    return;
                } catch (Exception e) {
                    FileLog.e(e);
                    return;
                }
            }
            if (id == 12) {
                Bundle bundle = new Bundle();
                bundle.putLong("chat_id", MediaChannelActivity.this.currentChat.id);
                ChatEditActivity chatEditActivity = new ChatEditActivity(bundle);
                chatEditActivity.setInfo(MediaChannelActivity.this.info);
                MediaChannelActivity.this.presentFragment(chatEditActivity);
                return;
            }
            if (id == 21) {
                AlertsCreator.createEitaaReportAlert(MediaChannelActivity.this.getParentActivity(), MediaChannelActivity.this.dialog_id, 0, MediaChannelActivity.this);
                return;
            }
            if (id == 22) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MediaChannelActivity.this.getParentActivity());
                if (ChatObject.isChannel(MediaChannelActivity.this.currentChat.id, ((BaseFragment) MediaChannelActivity.this).currentAccount) && !MediaChannelActivity.this.currentChat.megagroup) {
                    builder.setMessage(ChatObject.isChannel(MediaChannelActivity.this.currentChat.id, ((BaseFragment) MediaChannelActivity.this).currentAccount) ? LocaleController.getString("ChannelLeaveAlert", R.string.ChannelLeaveAlert) : LocaleController.getString("AreYouSureDeleteAndExit", R.string.AreYouSureDeleteAndExit));
                } else {
                    builder.setMessage(LocaleController.getString("AreYouSureDeleteAndExit", R.string.AreYouSureDeleteAndExit));
                }
                builder.setTitle(LocaleController.getString("AppName", R.string.AppName));
                builder.setPositiveButton(LocaleController.getString("OK", R.string.OK), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$MediaChannelActivity$3$GvuWr9nEjV4TZHK2f3ii5dAaVQ8
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i3) {
                        this.f$0.lambda$onItemClick$0$MediaChannelActivity$3(dialogInterface, i3);
                    }
                });
                builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
                MediaChannelActivity.this.showDialog(builder.create());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onItemClick$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onItemClick$0$MediaChannelActivity$3(DialogInterface dialogInterface, int i) {
            NotificationCenter notificationCenter = NotificationCenter.getInstance(((BaseFragment) MediaChannelActivity.this).currentAccount);
            MediaChannelActivity mediaChannelActivity = MediaChannelActivity.this;
            int i2 = NotificationCenter.closeChats;
            notificationCenter.removeObserver(mediaChannelActivity, i2);
            if (AndroidUtilities.isTablet()) {
                NotificationCenter.getInstance(((BaseFragment) MediaChannelActivity.this).currentAccount).postNotificationName(i2, Long.valueOf(-MediaChannelActivity.this.currentChat.id));
            } else {
                NotificationCenter.getInstance(((BaseFragment) MediaChannelActivity.this).currentAccount).postNotificationName(i2, new Object[0]);
            }
            MessagesController.getInstance(((BaseFragment) MediaChannelActivity.this).currentAccount).deleteParticipantFromChat(MediaChannelActivity.this.currentChat.id, MessagesController.getInstance(((BaseFragment) MediaChannelActivity.this).currentAccount).getUser(Long.valueOf(UserConfig.getInstance(((BaseFragment) MediaChannelActivity.this).currentAccount).getClientUserId())), MediaChannelActivity.this.info);
            MediaChannelActivity.this.finishFragment();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$1$MediaChannelActivity(View view) {
        this.listView.smoothScrollToPosition(0);
        showFloatingButton(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:87:0x01b4  */
    @Override // ir.eitaa.ui.ActionBar.BaseFragment, ir.eitaa.messenger.NotificationCenter.NotificationCenterDelegate
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void didReceivedNotification(int r19, int r20, java.lang.Object... r21) {
        /*
            Method dump skipped, instructions count: 787
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.MediaChannelActivity.didReceivedNotification(int, int, java.lang.Object[]):void");
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onResume() {
        super.onResume();
        SharedPhotoVideoAdapter sharedPhotoVideoAdapter = this.photoVideoAdapter;
        if (sharedPhotoVideoAdapter != null) {
            sharedPhotoVideoAdapter.notifyDataSetChanged();
        }
        fixLayoutInternal();
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        RecyclerListView recyclerListView = this.listView;
        if (recyclerListView != null) {
            recyclerListView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: ir.eitaa.ui.MediaChannelActivity.6
                @Override // android.view.ViewTreeObserver.OnPreDrawListener
                public boolean onPreDraw() {
                    MediaChannelActivity.this.listView.getViewTreeObserver().removeOnPreDrawListener(this);
                    MediaChannelActivity.this.fixLayoutInternal();
                    return true;
                }
            });
        }
        ImageView imageView = this.floatingButton;
        if (imageView != null) {
            imageView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: ir.eitaa.ui.MediaChannelActivity.7
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    MediaChannelActivity.this.floatingButton.setTranslationY(MediaChannelActivity.this.floatingShow ? 0.0f : AndroidUtilities.dp(100.0f));
                    MediaChannelActivity.this.floatingButton.setClickable(MediaChannelActivity.this.floatingShow);
                    if (MediaChannelActivity.this.floatingButton != null) {
                        MediaChannelActivity.this.floatingButton.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    }
                }
            });
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public boolean onBackPressed() {
        return this.actionBar.isEnabled();
    }

    private void switchToCurrentSelectedMode(boolean animated) {
        this.listView.stopScroll();
        RecyclerView.Adapter adapter = this.listView.getAdapter();
        this.emptyTextView.setTextSize(1, 17.0f);
        this.emptyImageView.setVisibility(0);
        if (adapter != this.photoVideoAdapter) {
            recycleAdapter(adapter);
            this.listView.setAdapter(this.photoVideoAdapter);
        }
        this.emptyImageView.setImageResource(R.drawable.tip1);
        if (((int) this.dialog_id) == 0) {
            this.emptyTextView.setText(LocaleController.getString("NoMediaSecret", R.string.NoMediaSecret));
        } else {
            this.emptyTextView.setText(LocaleController.getString("NoMedia", R.string.NoMedia));
        }
        this.emptyTextView.setPadding(AndroidUtilities.dp(40.0f), 0, AndroidUtilities.dp(40.0f), AndroidUtilities.dp(128.0f));
        this.listView.setVisibility(0);
        this.listView.setPadding(0, 0, 0, AndroidUtilities.dp(4.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onItemClick(int index, View view, MessageObject message) {
        if (message == null) {
            return;
        }
        MediaChatInfoCell mediaChatInfoCell = this.mediaChatInfoCell;
        if (mediaChatInfoCell != null) {
            mediaChatInfoCell.markAsRead();
        }
        Bundle bundle = new Bundle();
        long j = this.dialog_id;
        int i = (int) (j >> 32);
        if (j == 0) {
            bundle.putInt("enc_id", i);
        } else if (i == 1) {
            bundle.putInt("chat_id", (int) j);
        } else if (j > 0) {
            bundle.putInt("user_id", (int) j);
        } else if (j < 0) {
            TLRPC$Chat chat = MessagesController.getInstance(this.currentAccount).getChat(Long.valueOf(-j));
            if (chat != null && chat.migrated_to != null) {
                bundle.putInt("migrated_to", (int) j);
                j = -chat.migrated_to.channel_id;
            }
            bundle.putInt("chat_id", -((int) j));
        }
        bundle.putInt("message_id", ((MessageObject) this.sharedMediaData.messages.get(index)).messageOwner.id);
        presentFragment(new MessageExploreActivity(1, this.sharedMediaData.messages, this.sharedMediaData.groupedMessagesMap, message.getId()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onItemLongClick(int index, View view, MessageObject message) {
        if (message == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add((MessageObject) this.sharedMediaData.messages.get(index));
        presentFragmentAsPreview(new MessageExploreActivity(1, arrayList, this.sharedMediaData.groupedMessagesMap, 0), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showFloatingButton(boolean show) {
        if (this.floatingShow == show) {
            return;
        }
        this.floatingShow = show;
        AnimatorSet animatorSet = new AnimatorSet();
        Animator[] animatorArr = new Animator[1];
        ImageView imageView = this.floatingButton;
        float[] fArr = new float[1];
        fArr[0] = this.floatingShow ? 0.0f : AndroidUtilities.dp(100.0f);
        animatorArr[0] = ObjectAnimator.ofFloat(imageView, "translationY", fArr);
        animatorSet.playTogether(animatorArr);
        animatorSet.setDuration(300L);
        animatorSet.setInterpolator(this.floatingInterpolator);
        this.floatingButton.setClickable(show);
        animatorSet.start();
    }

    private void recycleAdapter(RecyclerView.Adapter adapter) {
        if (adapter instanceof SharedPhotoVideoAdapter) {
            this.cellCache.addAll(this.cache);
            this.cache.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fixLayoutInternal() {
        int rotation = ((WindowManager) ApplicationLoader.applicationContext.getSystemService("window")).getDefaultDisplay().getRotation();
        if (AndroidUtilities.isTablet()) {
            this.columnsCount = 5;
            this.emptyTextView.setPadding(AndroidUtilities.dp(40.0f), 0, AndroidUtilities.dp(40.0f), AndroidUtilities.dp(128.0f));
        } else if (rotation == 3 || rotation == 1) {
            this.columnsCount = 6;
            this.emptyTextView.setPadding(AndroidUtilities.dp(40.0f), 0, AndroidUtilities.dp(40.0f), 0);
        } else {
            this.columnsCount = 3;
            this.emptyTextView.setPadding(AndroidUtilities.dp(40.0f), 0, AndroidUtilities.dp(40.0f), AndroidUtilities.dp(128.0f));
        }
        this.photoVideoAdapter.notifyDataSetChanged();
    }

    private class SharedPhotoVideoAdapter extends RecyclerListView.SelectionAdapter {
        private Context mContext;
        private int viewMode = 0;

        @Override // ir.eitaa.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder holder) {
            return true;
        }

        public SharedPhotoVideoAdapter(Context context) {
            this.mContext = context;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v12, types: [android.view.View] */
        /* JADX WARN: Type inference failed for: r3v14, types: [android.widget.LinearLayout, ir.eitaa.ui.Cells.MediaChatInfoCell] */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            FrameLayout sharedMediaSectionCell;
            FrameLayout staggeredMediaCell;
            if (i == 0) {
                sharedMediaSectionCell = new SharedMediaSectionCell(this.mContext);
            } else if (i == 1) {
                if (!MediaChannelActivity.this.cellCache.isEmpty()) {
                    ?? r3 = (View) MediaChannelActivity.this.cellCache.get(0);
                    MediaChannelActivity.this.cellCache.remove(0);
                    staggeredMediaCell = r3;
                } else {
                    staggeredMediaCell = new StaggeredMediaCell(this.mContext);
                }
                StaggeredMediaCell staggeredMediaCell2 = (StaggeredMediaCell) staggeredMediaCell;
                staggeredMediaCell2.setDelegate(new StaggeredMediaCell.StaggeredMediaCellDelegate() { // from class: ir.eitaa.ui.MediaChannelActivity.SharedPhotoVideoAdapter.1
                    @Override // ir.eitaa.ui.Cells.StaggeredMediaCell.StaggeredMediaCellDelegate
                    public void didClickItem(StaggeredMediaCell cell, int index, MessageObject messageObject, int a) {
                        MediaChannelActivity.this.onItemClick(index, cell, messageObject);
                    }

                    @Override // ir.eitaa.ui.Cells.StaggeredMediaCell.StaggeredMediaCellDelegate
                    public boolean didLongClickItem(StaggeredMediaCell cell, int index, MessageObject messageObject, int a) {
                        MediaChannelActivity.this.onItemLongClick(index, cell, messageObject);
                        return true;
                    }

                    @Override // ir.eitaa.ui.Cells.StaggeredMediaCell.StaggeredMediaCellDelegate
                    @SuppressLint({"WrongConstant"})
                    public boolean onLongClickRelease(StaggeredMediaCell cell, int index, MessageObject messageObject, int a) {
                        MediaChannelActivity.this.finishPreviewFragment();
                        MediaChannelActivity.this.layoutManager.setOrientation(1);
                        return false;
                    }
                });
                MediaChannelActivity.this.cache.add(staggeredMediaCell2);
                sharedMediaSectionCell = staggeredMediaCell;
            } else if (i == 3) {
                final ?? mediaChatInfoCell = new MediaChatInfoCell(this.mContext);
                mediaChatInfoCell.setUnreadCount(MediaChannelActivity.this.unreadCount);
                mediaChatInfoCell.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
                mediaChatInfoCell.setChat(MediaChannelActivity.this.currentChat);
                mediaChatInfoCell.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                MediaChannelActivity.this.mediaChatInfoCell = mediaChatInfoCell;
                MediaChannelActivity mediaChannelActivity = MediaChannelActivity.this;
                mediaChannelActivity.avatarImage = mediaChannelActivity.mediaChatInfoCell.getAvatarImage();
                mediaChatInfoCell.setDelegate(new MediaChatInfoCell.MediaChatInfoCellDelegate() { // from class: ir.eitaa.ui.MediaChannelActivity.SharedPhotoVideoAdapter.2
                    @Override // ir.eitaa.ui.Cells.MediaChatInfoCell.MediaChatInfoCellDelegate
                    public void onMessageButtonClicked() {
                        mediaChatInfoCell.markAsRead();
                        Bundle bundle = new Bundle();
                        long j = MediaChannelActivity.this.dialog_id;
                        int i2 = (int) (MediaChannelActivity.this.dialog_id >> 32);
                        if (j == 0) {
                            bundle.putInt("enc_id", i2);
                        } else if (i2 == 1) {
                            bundle.putLong("chat_id", j);
                        } else if (j > 0) {
                            bundle.putLong("user_id", j);
                        } else if (j < 0) {
                            TLRPC$Chat chat = MessagesController.getInstance(((BaseFragment) MediaChannelActivity.this).currentAccount).getChat(Long.valueOf(-j));
                            if (chat != null && chat.migrated_to != null) {
                                bundle.putLong("migrated_to", j);
                                j = -chat.migrated_to.channel_id;
                            }
                            bundle.putLong("chat_id", -j);
                        }
                        MediaChannelActivity.this.presentFragment(new ChatActivity(bundle));
                    }

                    @Override // ir.eitaa.ui.Cells.MediaChatInfoCell.MediaChatInfoCellDelegate
                    public void onJoinButtonClicked() {
                        AlertDialog.Builder builder;
                        if (ChatObject.isChannel(MediaChannelActivity.this.currentChat) && !(MediaChannelActivity.this.currentChat instanceof TLRPC$TL_channelForbidden)) {
                            if (!ChatObject.isNotInChat(MediaChannelActivity.this.currentChat) || (MessagesController.getInstance(((BaseFragment) MediaChannelActivity.this).currentAccount).isPromoDialog(MediaChannelActivity.this.dialog_id, true) && MessagesController.getInstance(((BaseFragment) MediaChannelActivity.this).currentAccount).proxyDisableJoin)) {
                                MediaChannelActivity.this.toggleMute(true);
                            } else {
                                MessagesController.getInstance(((BaseFragment) MediaChannelActivity.this).currentAccount).addUserToChat(MediaChannelActivity.this.currentChat.id, UserConfig.getInstance(((BaseFragment) MediaChannelActivity.this).currentAccount).getCurrentUser(), 0, null, MediaChannelActivity.this, null);
                            }
                            builder = null;
                        } else {
                            builder = new AlertDialog.Builder(MediaChannelActivity.this.getParentActivity());
                            builder.setMessage(LocaleController.getString("AreYouSureDeleteThisChat", R.string.AreYouSureDeleteThisChat));
                            builder.setPositiveButton(LocaleController.getString("OK", R.string.OK), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.MediaChannelActivity.SharedPhotoVideoAdapter.2.1
                                @Override // android.content.DialogInterface.OnClickListener
                                public void onClick(DialogInterface dialogInterface, int i2) {
                                    MessagesController.getInstance(((BaseFragment) MediaChannelActivity.this).currentAccount).deleteDialog(MediaChannelActivity.this.dialog_id, 0);
                                    MediaChannelActivity.this.finishFragment();
                                }
                            });
                        }
                        if (builder != null) {
                            builder.setTitle(LocaleController.getString("AppName", R.string.AppName));
                            builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
                            MediaChannelActivity.this.showDialog(builder.create());
                        }
                    }

                    @Override // ir.eitaa.ui.Cells.MediaChatInfoCell.MediaChatInfoCellDelegate
                    public void onAvatarImageClicked() throws Resources.NotFoundException {
                        TLRPC$Chat tLRPC$Chat;
                        TLRPC$ChatPhoto tLRPC$ChatPhoto;
                        if (MediaChannelActivity.this.currentChat == null || (tLRPC$ChatPhoto = (tLRPC$Chat = MediaChannelActivity.this.currentChat).photo) == null || tLRPC$ChatPhoto.photo_big == null) {
                            return;
                        }
                        PhotoViewer.getInstance().setParentActivity(MediaChannelActivity.this.getParentActivity());
                        PhotoViewer.getInstance().openPhoto(tLRPC$Chat.photo.photo_big, ImageLocation.getForChat(tLRPC$Chat, 0), MediaChannelActivity.this.provider);
                    }

                    @Override // ir.eitaa.ui.Cells.MediaChatInfoCell.MediaChatInfoCellDelegate
                    public void didPressUrl(String url) {
                        if (url.startsWith("@")) {
                            MessagesController.getInstance(((BaseFragment) MediaChannelActivity.this).currentAccount).openByUserName(url.substring(1), MediaChannelActivity.this, 0);
                            return;
                        }
                        if (url.startsWith("#")) {
                            DialogsActivity dialogsActivity = new DialogsActivity(null);
                            dialogsActivity.setSearchString(url);
                            MediaChannelActivity.this.presentFragment(dialogsActivity);
                        } else {
                            if (!url.startsWith("/") || ((BaseFragment) MediaChannelActivity.this).parentLayout.fragmentsStack.size() <= 1) {
                                return;
                            }
                            BaseFragment baseFragment = ((BaseFragment) MediaChannelActivity.this).parentLayout.fragmentsStack.get(((BaseFragment) MediaChannelActivity.this).parentLayout.fragmentsStack.size() - 2);
                            if (baseFragment instanceof ChatActivity) {
                                MediaChannelActivity.this.finishFragment();
                                ((ChatActivity) baseFragment).chatActivityEnterView.setCommand(null, url, false, false);
                            }
                        }
                    }
                });
                TLRPC$ChatFull tLRPC$ChatFull = MediaChannelActivity.this.info;
                sharedMediaSectionCell = mediaChatInfoCell;
                if (tLRPC$ChatFull != null) {
                    mediaChatInfoCell.setChatInfo(tLRPC$ChatFull);
                    sharedMediaSectionCell = mediaChatInfoCell;
                }
            } else {
                sharedMediaSectionCell = new LoadingCell(this.mContext);
            }
            return new RecyclerListView.Holder(sharedMediaSectionCell);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            if (holder.getItemViewType() == 3 || holder.getItemViewType() == 2) {
                return;
            }
            int i = position - 1;
            if (holder.getItemViewType() != 1) {
                return;
            }
            StaggeredMediaCell staggeredMediaCell = (StaggeredMediaCell) holder.itemView;
            staggeredMediaCell.setItemsCount(MediaChannelActivity.this.columnsCount);
            for (int i2 = 0; i2 < MediaChannelActivity.this.columnsCount; i2++) {
                int i3 = (MediaChannelActivity.this.columnsCount * i) + i2;
                if (i3 < MediaChannelActivity.this.sharedMediaData.messages.size()) {
                    MessageObject messageObject = (MessageObject) MediaChannelActivity.this.sharedMediaData.messages.get(i3);
                    staggeredMediaCell.setIsFirst(i == 0);
                    staggeredMediaCell.setItem(i2, MediaChannelActivity.this.sharedMediaData.messages.indexOf(messageObject), messageObject);
                    staggeredMediaCell.setChecked(i2, false, true);
                } else {
                    staggeredMediaCell.setItem(i2, i3, null);
                }
            }
            staggeredMediaCell.requestLayout();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int position) {
            if (position == 0) {
                return 3;
            }
            int i = position - 1;
            return this.viewMode == 0 ? i < ((int) Math.ceil((double) (((float) MediaChannelActivity.this.sharedMediaData.messages.size()) / ((float) MediaChannelActivity.this.columnsCount)))) ? 1 : 2 : i < MediaChannelActivity.this.sharedMediaData.messages.size() ? 5 : 2;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            int size;
            if (this.viewMode == 0) {
                size = (int) Math.ceil(MediaChannelActivity.this.sharedMediaData.messages.size() / MediaChannelActivity.this.columnsCount);
            } else {
                size = MediaChannelActivity.this.sharedMediaData.messages.size();
            }
            int i = 1 + size;
            return MediaChannelActivity.this.sharedMediaData.loading ? i + 1 : i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void toggleMute(boolean instant) {
        if (MessagesController.getInstance(this.currentAccount).isDialogMuted(this.dialog_id)) {
            SharedPreferences.Editor editorEdit = MessagesController.getNotificationsSettings(this.currentAccount).edit();
            editorEdit.putInt("notify2_" + this.dialog_id, 0);
            MessagesStorage.getInstance(this.currentAccount).setDialogNotificationFlags(this.dialog_id, 0L);
            editorEdit.commit();
            TLRPC$TL_dialog tLRPC$TL_dialog = (TLRPC$TL_dialog) MessagesController.getInstance(this.currentAccount).dialogs_dict.get(this.dialog_id);
            if (tLRPC$TL_dialog != null) {
                tLRPC$TL_dialog.notify_settings = new TLRPC$TL_peerNotifySettings();
            }
            NotificationsController.getInstance(this.currentAccount).updateServerNotificationsSettings(this.dialog_id);
            return;
        }
        if (instant) {
            SharedPreferences.Editor editorEdit2 = MessagesController.getNotificationsSettings(this.currentAccount).edit();
            editorEdit2.putInt("notify2_" + this.dialog_id, 2);
            MessagesStorage.getInstance(this.currentAccount).setDialogNotificationFlags(this.dialog_id, 1L);
            editorEdit2.commit();
            TLRPC$TL_dialog tLRPC$TL_dialog2 = (TLRPC$TL_dialog) MessagesController.getInstance(this.currentAccount).dialogs_dict.get(this.dialog_id);
            if (tLRPC$TL_dialog2 != null) {
                TLRPC$TL_peerNotifySettings tLRPC$TL_peerNotifySettings = new TLRPC$TL_peerNotifySettings();
                tLRPC$TL_dialog2.notify_settings = tLRPC$TL_peerNotifySettings;
                tLRPC$TL_peerNotifySettings.mute_until = ConnectionsManager.DEFAULT_DATACENTER_ID;
            }
            NotificationsController.getInstance(this.currentAccount).updateServerNotificationsSettings(this.dialog_id);
            NotificationsController.getInstance(this.currentAccount).removeNotificationsForDialog(this.dialog_id);
            return;
        }
        showDialog(AlertsCreator.createMuteAlert(this, this.dialog_id, null));
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public ArrayList<ThemeDescription> getThemeDescriptions() {
        ArrayList<ThemeDescription> arrayList = new ArrayList<>();
        arrayList.add(new ThemeDescription(this.fragmentView, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "windowBackgroundWhite"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "actionBarDefault"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_ITEMSCOLOR, null, null, null, null, "actionBarDefaultIcon"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_TITLECOLOR, null, null, null, null, "actionBarDefaultTitle"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SELECTORCOLOR, null, null, null, null, "actionBarDefaultSelector"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SUBMENUBACKGROUND, null, null, null, null, "actionBarDefaultSubmenuBackground"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SUBMENUITEM, null, null, null, null, "actionBarDefaultSubmenuItem"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_AM_ITEMSCOLOR, null, null, null, null, "actionBarDefaultIcon"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_AM_BACKGROUND, null, null, null, null, "actionBarDefault"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_AM_SELECTORCOLOR, null, null, null, null, "actionBarDefaultSelector"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SEARCH, null, null, null, null, "actionBarDefaultSearch"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SEARCHPLACEHOLDER, null, null, null, null, "actionBarDefaultSearchPlaceholder"));
        arrayList.add(new ThemeDescription(this.fragmentContextView, ThemeDescription.FLAG_CELLBACKGROUNDCOLOR, new Class[]{FragmentContextView.class}, new String[]{"frameLayout"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "inappPlayerBackground"));
        arrayList.add(new ThemeDescription(this.fragmentContextView, 0, new Class[]{FragmentContextView.class}, new String[]{"playButton"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "inappPlayerPlayPause"));
        arrayList.add(new ThemeDescription(this.fragmentContextView, ThemeDescription.FLAG_TEXTCOLOR, new Class[]{FragmentContextView.class}, new String[]{"titleTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "inappPlayerTitle"));
        arrayList.add(new ThemeDescription(this.fragmentContextView, ThemeDescription.FLAG_TEXTCOLOR, new Class[]{FragmentContextView.class}, new String[]{"frameLayout"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "inappPlayerPerformer"));
        arrayList.add(new ThemeDescription(this.fragmentContextView, ThemeDescription.FLAG_CELLBACKGROUNDCOLOR, new Class[]{FragmentContextView.class}, new String[]{"closeButton"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "inappPlayerClose"));
        ThemeDescription.ThemeDescriptionDelegate themeDescriptionDelegate = new ThemeDescription.ThemeDescriptionDelegate() { // from class: ir.eitaa.ui.-$$Lambda$MediaChannelActivity$hv9DgoyFN1pDlK09S3uSd_PeNcU
            @Override // ir.eitaa.ui.ActionBar.ThemeDescription.ThemeDescriptionDelegate
            public final void didSetColor() {
                this.f$0.lambda$getThemeDescriptions$2$MediaChannelActivity();
            }

            @Override // ir.eitaa.ui.ActionBar.ThemeDescription.ThemeDescriptionDelegate
            public /* synthetic */ void onAnimationProgress(float f) {
                ThemeDescription.ThemeDescriptionDelegate.CC.$default$onAnimationProgress(this, f);
            }
        };
        arrayList.add(new ThemeDescription(this.emptyView, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "windowBackgroundGray"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_LISTGLOWCOLOR, null, null, null, null, "actionBarDefault"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_SELECTOR, null, null, null, null, "listSelectorSDK21"));
        arrayList.add(new ThemeDescription(this.emptyView, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "emptyListPlaceholder"));
        arrayList.add(new ThemeDescription(this.emptyTextView, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "windowBackgroundWhiteGrayText2"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_SECTIONS, new Class[]{GraySectionCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "key_graySectionText"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CELLBACKGROUNDCOLOR | ThemeDescription.FLAG_SECTIONS, new Class[]{GraySectionCell.class}, null, null, null, "graySection"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_TEXTCOLOR, new Class[]{SharedDocumentCell.class}, new String[]{"nameTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_TEXTCOLOR, new Class[]{SharedDocumentCell.class}, new String[]{"dateTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteGrayText3"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_PROGRESSBAR, new Class[]{SharedDocumentCell.class}, new String[]{"progressView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "sharedMedia_startStopLoadIcon"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_IMAGECOLOR, new Class[]{SharedDocumentCell.class}, new String[]{"statusImageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "sharedMedia_startStopLoadIcon"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CHECKBOX, new Class[]{SharedDocumentCell.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "checkbox"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CHECKBOXCHECK, new Class[]{SharedDocumentCell.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "checkboxCheck"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_IMAGECOLOR, new Class[]{SharedDocumentCell.class}, new String[]{"thumbImageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "files_folderIcon"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_TEXTCOLOR, new Class[]{SharedDocumentCell.class}, new String[]{"extTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "files_iconText"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{LoadingCell.class}, new String[]{"progressBar"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "progressCircle"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CHECKBOX, new Class[]{SharedAudioCell.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "checkbox"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CHECKBOXCHECK, new Class[]{SharedAudioCell.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "checkboxCheck"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_TEXTCOLOR, new Class[]{SharedAudioCell.class}, Theme.chat_contextResult_titleTextPaint, null, null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_TEXTCOLOR, new Class[]{SharedAudioCell.class}, Theme.chat_contextResult_descriptionTextPaint, null, null, "windowBackgroundWhiteGrayText2"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CHECKBOX, new Class[]{SharedLinkCell.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "checkbox"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CHECKBOXCHECK, new Class[]{SharedLinkCell.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "checkboxCheck"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{SharedLinkCell.class}, new String[]{"titleTextPaint"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{SharedLinkCell.class}, null, null, null, "windowBackgroundWhiteLinkText"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{SharedLinkCell.class}, Theme.linkSelectionPaint, null, null, "windowBackgroundWhiteLinkSelection"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{SharedLinkCell.class}, new String[]{"letterDrawable"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "sharedMedia_linkPlaceholderText"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{SharedLinkCell.class}, new String[]{"letterDrawable"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "sharedMedia_linkPlaceholder"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CELLBACKGROUNDCOLOR | ThemeDescription.FLAG_SECTIONS, new Class[]{SharedMediaSectionCell.class}, null, null, null, "windowBackgroundWhite"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_SECTIONS, new Class[]{SharedMediaSectionCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{SharedMediaSectionCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CHECKBOX, new Class[]{StaggeredMediaCell.class}, null, null, themeDescriptionDelegate, "checkbox"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CHECKBOXCHECK, new Class[]{StaggeredMediaCell.class}, null, null, themeDescriptionDelegate, "checkboxCheck"));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$getThemeDescriptions$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$getThemeDescriptions$2$MediaChannelActivity() {
        RecyclerListView recyclerListView = this.listView;
        if (recyclerListView != null) {
            int childCount = recyclerListView.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.listView.getChildAt(i);
                if (childAt instanceof StaggeredMediaCell) {
                    ((StaggeredMediaCell) childAt).updateCheckboxColor();
                }
            }
        }
    }
}
