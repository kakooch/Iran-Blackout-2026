package ir.eitaa.ui;

import android.app.Activity;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.PowerManager;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import ir.eitaa.PhoneFormat.PhoneFormat;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ApplicationLoader;
import ir.eitaa.messenger.ContactsController;
import ir.eitaa.messenger.DialogObject;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MediaController;
import ir.eitaa.messenger.MessageObject;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.messenger.NotificationCenter;
import ir.eitaa.messenger.NotificationsController;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.SendMessagesHelper;
import ir.eitaa.messenger.UserConfig;
import ir.eitaa.messenger.UserObject;
import ir.eitaa.tgnet.ConnectionsManager;
import ir.eitaa.tgnet.TLRPC$Chat;
import ir.eitaa.tgnet.TLRPC$KeyboardButton;
import ir.eitaa.tgnet.TLRPC$ReplyMarkup;
import ir.eitaa.tgnet.TLRPC$TL_keyboardButtonCallback;
import ir.eitaa.tgnet.TLRPC$TL_keyboardButtonRow;
import ir.eitaa.tgnet.TLRPC$User;
import ir.eitaa.ui.ActionBar.ActionBar;
import ir.eitaa.ui.ActionBar.ActionBarMenuItem;
import ir.eitaa.ui.ActionBar.AlertDialog;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Components.AvatarDrawable;
import ir.eitaa.ui.Components.BackupImageView;
import ir.eitaa.ui.Components.ChatActivityEnterView;
import ir.eitaa.ui.Components.LayoutHelper;
import ir.eitaa.ui.Components.PlayingGameDrawable;
import ir.eitaa.ui.Components.PopupAudioView;
import ir.eitaa.ui.Components.RecordStatusDrawable;
import ir.eitaa.ui.Components.RoundStatusDrawable;
import ir.eitaa.ui.Components.SendingFileDrawable;
import ir.eitaa.ui.Components.SizeNotifierFrameLayout;
import ir.eitaa.ui.Components.StatusDrawable;
import ir.eitaa.ui.Components.TypingDotsDrawable;
import java.io.IOException;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class PopupNotificationActivity extends Activity implements NotificationCenter.NotificationCenterDelegate {
    private ActionBar actionBar;
    private FrameLayout avatarContainer;
    private BackupImageView avatarImageView;
    private ViewGroup centerButtonsView;
    private ViewGroup centerView;
    private ChatActivityEnterView chatActivityEnterView;
    private int classGuid;
    private TextView countText;
    private TLRPC$Chat currentChat;
    private TLRPC$User currentUser;
    private boolean isReply;
    private CharSequence lastPrintString;
    private ViewGroup leftButtonsView;
    private ViewGroup leftView;
    private ViewGroup messageContainer;
    private TextView nameTextView;
    private TextView onlineTextView;
    private RelativeLayout popupContainer;
    private ViewGroup rightButtonsView;
    private ViewGroup rightView;
    private ArrayList<ViewGroup> textViews = new ArrayList<>();
    private ArrayList<ViewGroup> imageViews = new ArrayList<>();
    private ArrayList<ViewGroup> audioViews = new ArrayList<>();
    private VelocityTracker velocityTracker = null;
    private StatusDrawable[] statusDrawables = new StatusDrawable[5];
    private int lastResumedAccount = -1;
    private boolean finished = false;
    private MessageObject currentMessageObject = null;
    private MessageObject[] setMessageObjects = new MessageObject[3];
    private int currentMessageNum = 0;
    private PowerManager.WakeLock wakeLock = null;
    private boolean animationInProgress = false;
    private long animationStartTime = 0;
    private float moveStartX = -1.0f;
    private boolean startedMoving = false;
    private Runnable onAnimationEndRunnable = null;
    private ArrayList<MessageObject> popupMessages = new ArrayList<>();

    static /* synthetic */ boolean lambda$getButtonsViewForMessage$4(View view, MotionEvent motionEvent) {
        return true;
    }

    private class FrameLayoutTouch extends FrameLayout {
        public FrameLayoutTouch(Context context) {
            super(context);
        }

        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent ev) {
            return PopupNotificationActivity.this.checkTransitionAnimation() || ((PopupNotificationActivity) getContext()).onTouchEventMy(ev);
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent ev) {
            return PopupNotificationActivity.this.checkTransitionAnimation() || ((PopupNotificationActivity) getContext()).onTouchEventMy(ev);
        }

        @Override // android.view.ViewGroup, android.view.ViewParent
        public void requestDisallowInterceptTouchEvent(boolean disallowIntercept) {
            ((PopupNotificationActivity) getContext()).onTouchEventMy(null);
            super.requestDisallowInterceptTouchEvent(disallowIntercept);
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) throws InterruptedException, Resources.NotFoundException, IOException {
        super.onCreate(savedInstanceState);
        Theme.createDialogsResources(this);
        Theme.createChatResources(this, false);
        AndroidUtilities.fillStatusBarHeight(this);
        for (int i = 0; i < 3; i++) {
            NotificationCenter.getInstance(i).addObserver(this, NotificationCenter.appDidLogout);
            NotificationCenter.getInstance(i).addObserver(this, NotificationCenter.updateInterfaces);
            NotificationCenter.getInstance(i).addObserver(this, NotificationCenter.messagePlayingProgressDidChanged);
            NotificationCenter.getInstance(i).addObserver(this, NotificationCenter.messagePlayingDidReset);
            NotificationCenter.getInstance(i).addObserver(this, NotificationCenter.contactsDidLoad);
        }
        NotificationCenter.getGlobalInstance().addObserver(this, NotificationCenter.pushMessagesUpdated);
        NotificationCenter.getGlobalInstance().addObserver(this, NotificationCenter.emojiLoaded);
        this.classGuid = ConnectionsManager.generateClassGuid();
        this.statusDrawables[0] = new TypingDotsDrawable(false);
        this.statusDrawables[1] = new RecordStatusDrawable(false);
        this.statusDrawables[2] = new SendingFileDrawable(false);
        this.statusDrawables[3] = new PlayingGameDrawable(false, null);
        this.statusDrawables[4] = new RoundStatusDrawable(false);
        SizeNotifierFrameLayout sizeNotifierFrameLayout = new SizeNotifierFrameLayout(this) { // from class: ir.eitaa.ui.PopupNotificationActivity.1
            @Override // android.widget.FrameLayout, android.view.View
            protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
                View.MeasureSpec.getMode(widthMeasureSpec);
                View.MeasureSpec.getMode(heightMeasureSpec);
                int size = View.MeasureSpec.getSize(widthMeasureSpec);
                int size2 = View.MeasureSpec.getSize(heightMeasureSpec);
                setMeasuredDimension(size, size2);
                if (measureKeyboardHeight() <= AndroidUtilities.dp(20.0f)) {
                    size2 -= PopupNotificationActivity.this.chatActivityEnterView.getEmojiPadding();
                }
                int childCount = getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = getChildAt(i2);
                    if (childAt.getVisibility() != 8) {
                        if (!PopupNotificationActivity.this.chatActivityEnterView.isPopupView(childAt)) {
                            if (PopupNotificationActivity.this.chatActivityEnterView.isRecordCircle(childAt)) {
                                measureChildWithMargins(childAt, widthMeasureSpec, 0, heightMeasureSpec, 0);
                            } else {
                                childAt.measure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(Math.max(AndroidUtilities.dp(10.0f), AndroidUtilities.dp(2.0f) + size2), 1073741824));
                            }
                        } else {
                            childAt.measure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(childAt.getLayoutParams().height, 1073741824));
                        }
                    }
                }
            }

            /* JADX WARN: Removed duplicated region for block: B:23:0x0065  */
            /* JADX WARN: Removed duplicated region for block: B:27:0x0073  */
            /* JADX WARN: Removed duplicated region for block: B:31:0x008b  */
            /* JADX WARN: Removed duplicated region for block: B:35:0x0094  */
            @Override // ir.eitaa.ui.Components.SizeNotifierFrameLayout, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            protected void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
                /*
                    Method dump skipped, instructions count: 231
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.PopupNotificationActivity.AnonymousClass1.onLayout(boolean, int, int, int, int):void");
            }
        };
        setContentView(sizeNotifierFrameLayout);
        sizeNotifierFrameLayout.setBackgroundColor(-1728053248);
        RelativeLayout relativeLayout = new RelativeLayout(this);
        sizeNotifierFrameLayout.addView(relativeLayout, LayoutHelper.createFrame(-1, -1.0f));
        RelativeLayout relativeLayout2 = new RelativeLayout(this) { // from class: ir.eitaa.ui.PopupNotificationActivity.2
            @Override // android.widget.RelativeLayout, android.view.View
            protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
                super.onMeasure(widthMeasureSpec, heightMeasureSpec);
                int measuredWidth = PopupNotificationActivity.this.chatActivityEnterView.getMeasuredWidth();
                int measuredHeight = PopupNotificationActivity.this.chatActivityEnterView.getMeasuredHeight();
                for (int i2 = 0; i2 < getChildCount(); i2++) {
                    View childAt = getChildAt(i2);
                    if (childAt.getTag() instanceof String) {
                        childAt.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(measuredHeight - AndroidUtilities.dp(3.0f), 1073741824));
                    }
                }
            }

            @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
            protected void onLayout(boolean changed, int l, int t, int r, int b) {
                super.onLayout(changed, l, t, r, b);
                for (int i2 = 0; i2 < getChildCount(); i2++) {
                    View childAt = getChildAt(i2);
                    if (childAt.getTag() instanceof String) {
                        childAt.layout(childAt.getLeft(), PopupNotificationActivity.this.chatActivityEnterView.getTop() + AndroidUtilities.dp(3.0f), childAt.getRight(), PopupNotificationActivity.this.chatActivityEnterView.getBottom());
                    }
                }
            }
        };
        this.popupContainer = relativeLayout2;
        relativeLayout2.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
        relativeLayout.addView(this.popupContainer, LayoutHelper.createRelative(-1, 240, 12, 0, 12, 0, 13));
        ChatActivityEnterView chatActivityEnterView = this.chatActivityEnterView;
        if (chatActivityEnterView != null) {
            chatActivityEnterView.onDestroy();
        }
        ChatActivityEnterView chatActivityEnterView2 = new ChatActivityEnterView(this, sizeNotifierFrameLayout, null, false);
        this.chatActivityEnterView = chatActivityEnterView2;
        chatActivityEnterView2.setId(1000);
        this.popupContainer.addView(this.chatActivityEnterView, LayoutHelper.createRelative(-1, -2, 12));
        this.chatActivityEnterView.setDelegate(new ChatActivityEnterView.ChatActivityEnterViewDelegate() { // from class: ir.eitaa.ui.PopupNotificationActivity.3
            @Override // ir.eitaa.ui.Components.ChatActivityEnterView.ChatActivityEnterViewDelegate
            public /* synthetic */ void bottomPanelTranslationYChanged(float f) {
                ChatActivityEnterView.ChatActivityEnterViewDelegate.CC.$default$bottomPanelTranslationYChanged(this, f);
            }

            @Override // ir.eitaa.ui.Components.ChatActivityEnterView.ChatActivityEnterViewDelegate
            public void didPressAttachButton() {
            }

            @Override // ir.eitaa.ui.Components.ChatActivityEnterView.ChatActivityEnterViewDelegate
            public /* synthetic */ boolean hasForwardingMessages() {
                return ChatActivityEnterView.ChatActivityEnterViewDelegate.CC.$default$hasForwardingMessages(this);
            }

            @Override // ir.eitaa.ui.Components.ChatActivityEnterView.ChatActivityEnterViewDelegate
            public /* synthetic */ boolean hasScheduledMessages() {
                return ChatActivityEnterView.ChatActivityEnterViewDelegate.CC.$default$hasScheduledMessages(this);
            }

            @Override // ir.eitaa.ui.Components.ChatActivityEnterView.ChatActivityEnterViewDelegate
            public void needChangeVideoPreviewState(int state, float seekProgress) {
            }

            @Override // ir.eitaa.ui.Components.ChatActivityEnterView.ChatActivityEnterViewDelegate
            public void needShowMediaBanHint() {
            }

            @Override // ir.eitaa.ui.Components.ChatActivityEnterView.ChatActivityEnterViewDelegate
            public void needStartRecordAudio(int state) {
            }

            @Override // ir.eitaa.ui.Components.ChatActivityEnterView.ChatActivityEnterViewDelegate
            public void needStartRecordVideo(int state, boolean notify, int scheduleDate) {
            }

            @Override // ir.eitaa.ui.Components.ChatActivityEnterView.ChatActivityEnterViewDelegate
            public void onAttachButtonHidden() {
            }

            @Override // ir.eitaa.ui.Components.ChatActivityEnterView.ChatActivityEnterViewDelegate
            public void onAttachButtonShow() {
            }

            @Override // ir.eitaa.ui.Components.ChatActivityEnterView.ChatActivityEnterViewDelegate
            public void onAudioVideoInterfaceUpdated() {
            }

            @Override // ir.eitaa.ui.Components.ChatActivityEnterView.ChatActivityEnterViewDelegate
            public void onMessageEditEnd(boolean loading) {
            }

            @Override // ir.eitaa.ui.Components.ChatActivityEnterView.ChatActivityEnterViewDelegate
            public void onPreAudioVideoRecord() {
            }

            @Override // ir.eitaa.ui.Components.ChatActivityEnterView.ChatActivityEnterViewDelegate
            public void onSendLongClick() {
            }

            @Override // ir.eitaa.ui.Components.ChatActivityEnterView.ChatActivityEnterViewDelegate
            public void onStickersExpandedChange() {
            }

            @Override // ir.eitaa.ui.Components.ChatActivityEnterView.ChatActivityEnterViewDelegate
            public void onStickersTab(boolean opened) {
            }

            @Override // ir.eitaa.ui.Components.ChatActivityEnterView.ChatActivityEnterViewDelegate
            public void onSwitchRecordMode(boolean video) {
            }

            @Override // ir.eitaa.ui.Components.ChatActivityEnterView.ChatActivityEnterViewDelegate
            public void onTextChanged(CharSequence text, boolean big) {
            }

            @Override // ir.eitaa.ui.Components.ChatActivityEnterView.ChatActivityEnterViewDelegate
            public void onTextSelectionChanged(int start, int end) {
            }

            @Override // ir.eitaa.ui.Components.ChatActivityEnterView.ChatActivityEnterViewDelegate
            public void onTextSpansChanged(CharSequence text) {
            }

            @Override // ir.eitaa.ui.Components.ChatActivityEnterView.ChatActivityEnterViewDelegate
            public /* synthetic */ void onTrendingStickersShowed(boolean z) {
                ChatActivityEnterView.ChatActivityEnterViewDelegate.CC.$default$onTrendingStickersShowed(this, z);
            }

            @Override // ir.eitaa.ui.Components.ChatActivityEnterView.ChatActivityEnterViewDelegate
            public void onUpdateSlowModeButton(View button, boolean show, CharSequence time) {
            }

            @Override // ir.eitaa.ui.Components.ChatActivityEnterView.ChatActivityEnterViewDelegate
            public void onWindowSizeChanged(int size) {
            }

            @Override // ir.eitaa.ui.Components.ChatActivityEnterView.ChatActivityEnterViewDelegate
            public /* synthetic */ void openScheduledMessages() {
                ChatActivityEnterView.ChatActivityEnterViewDelegate.CC.$default$openScheduledMessages(this);
            }

            @Override // ir.eitaa.ui.Components.ChatActivityEnterView.ChatActivityEnterViewDelegate
            public /* synthetic */ void prepareMessageSending() {
                ChatActivityEnterView.ChatActivityEnterViewDelegate.CC.$default$prepareMessageSending(this);
            }

            @Override // ir.eitaa.ui.Components.ChatActivityEnterView.ChatActivityEnterViewDelegate
            public /* synthetic */ void scrollToSendingMessage() {
                ChatActivityEnterView.ChatActivityEnterViewDelegate.CC.$default$scrollToSendingMessage(this);
            }

            @Override // ir.eitaa.ui.Components.ChatActivityEnterView.ChatActivityEnterViewDelegate
            public void onMessageSend(CharSequence message, boolean notify, int scheduleDate) throws InterruptedException, IOException {
                if (PopupNotificationActivity.this.currentMessageObject == null) {
                    return;
                }
                if (PopupNotificationActivity.this.currentMessageNum >= 0 && PopupNotificationActivity.this.currentMessageNum < PopupNotificationActivity.this.popupMessages.size()) {
                    PopupNotificationActivity.this.popupMessages.remove(PopupNotificationActivity.this.currentMessageNum);
                }
                MessagesController.getInstance(PopupNotificationActivity.this.currentMessageObject.currentAccount).markDialogAsRead(PopupNotificationActivity.this.currentMessageObject.getDialogId(), PopupNotificationActivity.this.currentMessageObject.getId(), Math.max(0, PopupNotificationActivity.this.currentMessageObject.getId()), PopupNotificationActivity.this.currentMessageObject.messageOwner.date, true, 0, 0, true, 0);
                PopupNotificationActivity.this.currentMessageObject = null;
                PopupNotificationActivity.this.getNewMessage();
            }

            @Override // ir.eitaa.ui.Components.ChatActivityEnterView.ChatActivityEnterViewDelegate
            public void needSendTyping() {
                if (PopupNotificationActivity.this.currentMessageObject != null) {
                    MessagesController.getInstance(PopupNotificationActivity.this.currentMessageObject.currentAccount).sendTyping(PopupNotificationActivity.this.currentMessageObject.getDialogId(), 0, 0, PopupNotificationActivity.this.classGuid);
                }
            }
        });
        FrameLayoutTouch frameLayoutTouch = new FrameLayoutTouch(this);
        this.messageContainer = frameLayoutTouch;
        this.popupContainer.addView(frameLayoutTouch, 0);
        ActionBar actionBar = new ActionBar(this);
        this.actionBar = actionBar;
        actionBar.setOccupyStatusBar(false);
        this.actionBar.setBackButtonImage(R.drawable.ic_close_white);
        this.actionBar.setBackgroundColor(Theme.getColor("actionBarDefault"));
        this.actionBar.setItemsBackgroundColor(Theme.getColor("actionBarDefaultSelector"), false);
        this.popupContainer.addView(this.actionBar);
        ViewGroup.LayoutParams layoutParams = this.actionBar.getLayoutParams();
        layoutParams.width = -1;
        this.actionBar.setLayoutParams(layoutParams);
        ActionBarMenuItem actionBarMenuItemAddItemWithWidth = this.actionBar.createMenu().addItemWithWidth(2, 0, AndroidUtilities.dp(56.0f));
        TextView textView = new TextView(this);
        this.countText = textView;
        textView.setTextColor(Theme.getColor("actionBarDefaultSubtitle"));
        this.countText.setTextSize(1, 14.0f);
        this.countText.setGravity(17);
        actionBarMenuItemAddItemWithWidth.addView(this.countText, LayoutHelper.createFrame(56, -1.0f));
        FrameLayout frameLayout = new FrameLayout(this);
        this.avatarContainer = frameLayout;
        frameLayout.setPadding(AndroidUtilities.dp(4.0f), 0, AndroidUtilities.dp(4.0f), 0);
        this.actionBar.addView(this.avatarContainer);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.avatarContainer.getLayoutParams();
        layoutParams2.height = -1;
        layoutParams2.width = -2;
        layoutParams2.rightMargin = AndroidUtilities.dp(48.0f);
        layoutParams2.leftMargin = AndroidUtilities.dp(60.0f);
        layoutParams2.gravity = 51;
        this.avatarContainer.setLayoutParams(layoutParams2);
        BackupImageView backupImageView = new BackupImageView(this);
        this.avatarImageView = backupImageView;
        backupImageView.setRoundRadius(AndroidUtilities.dp(21.0f));
        this.avatarContainer.addView(this.avatarImageView);
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.avatarImageView.getLayoutParams();
        layoutParams3.width = AndroidUtilities.dp(42.0f);
        layoutParams3.height = AndroidUtilities.dp(42.0f);
        layoutParams3.topMargin = AndroidUtilities.dp(3.0f);
        this.avatarImageView.setLayoutParams(layoutParams3);
        TextView textView2 = new TextView(this);
        this.nameTextView = textView2;
        textView2.setTextColor(Theme.getColor("actionBarDefaultTitle"));
        this.nameTextView.setTextSize(1, 18.0f);
        this.nameTextView.setLines(1);
        this.nameTextView.setMaxLines(1);
        this.nameTextView.setSingleLine(true);
        this.nameTextView.setEllipsize(TextUtils.TruncateAt.END);
        this.nameTextView.setGravity(3);
        this.nameTextView.setTypeface(AndroidUtilities.getFontFamily(true));
        this.avatarContainer.addView(this.nameTextView);
        FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) this.nameTextView.getLayoutParams();
        layoutParams4.width = -2;
        layoutParams4.height = -2;
        layoutParams4.leftMargin = AndroidUtilities.dp(54.0f);
        layoutParams4.bottomMargin = AndroidUtilities.dp(22.0f);
        layoutParams4.gravity = 80;
        this.nameTextView.setLayoutParams(layoutParams4);
        TextView textView3 = new TextView(this);
        this.onlineTextView = textView3;
        textView3.setTextColor(Theme.getColor("actionBarDefaultSubtitle"));
        this.onlineTextView.setTextSize(1, 14.0f);
        this.onlineTextView.setLines(1);
        this.onlineTextView.setMaxLines(1);
        this.onlineTextView.setSingleLine(true);
        this.onlineTextView.setEllipsize(TextUtils.TruncateAt.END);
        this.onlineTextView.setGravity(3);
        this.avatarContainer.addView(this.onlineTextView);
        FrameLayout.LayoutParams layoutParams5 = (FrameLayout.LayoutParams) this.onlineTextView.getLayoutParams();
        layoutParams5.width = -2;
        layoutParams5.height = -2;
        layoutParams5.leftMargin = AndroidUtilities.dp(54.0f);
        layoutParams5.bottomMargin = AndroidUtilities.dp(4.0f);
        layoutParams5.gravity = 80;
        this.onlineTextView.setLayoutParams(layoutParams5);
        this.actionBar.setActionBarMenuOnItemClick(new ActionBar.ActionBarMenuOnItemClick() { // from class: ir.eitaa.ui.PopupNotificationActivity.4
            @Override // ir.eitaa.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
            public void onItemClick(int id) throws InterruptedException, IOException {
                if (id == -1) {
                    PopupNotificationActivity.this.onFinish();
                    PopupNotificationActivity.this.finish();
                } else if (id == 1) {
                    PopupNotificationActivity.this.openCurrentMessage();
                } else if (id == 2) {
                    PopupNotificationActivity.this.switchToNextMessage();
                }
            }
        });
        PowerManager.WakeLock wakeLockNewWakeLock = ((PowerManager) ApplicationLoader.applicationContext.getSystemService("power")).newWakeLock(268435462, "screen");
        this.wakeLock = wakeLockNewWakeLock;
        wakeLockNewWakeLock.setReferenceCounted(false);
        handleIntent(getIntent());
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        AndroidUtilities.checkDisplaySize(this, newConfig);
        fixLayout();
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) throws InterruptedException, IOException {
        super.onNewIntent(intent);
        handleIntent(intent);
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode != 3 || grantResults[0] == 0) {
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(LocaleController.getString("AppName", R.string.AppName));
        builder.setMessage(LocaleController.getString("PermissionNoAudio", R.string.PermissionNoAudio));
        builder.setNegativeButton(LocaleController.getString("PermissionOpenSettings", R.string.PermissionOpenSettings), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$PopupNotificationActivity$8SlmGeLfwYFzMtmcTJWkxGG-Fh8
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$onRequestPermissionsResult$0$PopupNotificationActivity(dialogInterface, i);
            }
        });
        builder.setPositiveButton(LocaleController.getString("OK", R.string.OK), null);
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onRequestPermissionsResult$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onRequestPermissionsResult$0$PopupNotificationActivity(DialogInterface dialogInterface, int i) {
        try {
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.parse("package:" + ApplicationLoader.applicationContext.getPackageName()));
            startActivity(intent);
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void switchToNextMessage() throws InterruptedException, IOException {
        if (this.popupMessages.size() > 1) {
            if (this.currentMessageNum < this.popupMessages.size() - 1) {
                this.currentMessageNum++;
            } else {
                this.currentMessageNum = 0;
            }
            this.currentMessageObject = this.popupMessages.get(this.currentMessageNum);
            updateInterfaceForCurrentMessage(2);
            this.countText.setText(String.format("%d/%d", Integer.valueOf(this.currentMessageNum + 1), Integer.valueOf(this.popupMessages.size())));
        }
    }

    private void switchToPreviousMessage() throws InterruptedException, IOException {
        if (this.popupMessages.size() > 1) {
            int i = this.currentMessageNum;
            if (i > 0) {
                this.currentMessageNum = i - 1;
            } else {
                this.currentMessageNum = this.popupMessages.size() - 1;
            }
            this.currentMessageObject = this.popupMessages.get(this.currentMessageNum);
            updateInterfaceForCurrentMessage(1);
            this.countText.setText(String.format("%d/%d", Integer.valueOf(this.currentMessageNum + 1), Integer.valueOf(this.popupMessages.size())));
        }
    }

    public boolean checkTransitionAnimation() {
        if (this.animationInProgress && this.animationStartTime < System.currentTimeMillis() - 400) {
            this.animationInProgress = false;
            Runnable runnable = this.onAnimationEndRunnable;
            if (runnable != null) {
                runnable.run();
                this.onAnimationEndRunnable = null;
            }
        }
        return this.animationInProgress;
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x00c6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEventMy(android.view.MotionEvent r14) {
        /*
            Method dump skipped, instructions count: 455
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.PopupNotificationActivity.onTouchEventMy(android.view.MotionEvent):boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onTouchEventMy$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onTouchEventMy$1$PopupNotificationActivity() throws InterruptedException, IOException {
        this.animationInProgress = false;
        switchToPreviousMessage();
        AndroidUtilities.unlockOrientation(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onTouchEventMy$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onTouchEventMy$2$PopupNotificationActivity() throws InterruptedException, IOException {
        this.animationInProgress = false;
        switchToNextMessage();
        AndroidUtilities.unlockOrientation(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onTouchEventMy$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onTouchEventMy$3$PopupNotificationActivity() {
        this.animationInProgress = false;
        applyViewsLayoutParams(0);
        AndroidUtilities.unlockOrientation(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void applyViewsLayoutParams(int xOffset) {
        int iDp = AndroidUtilities.displaySize.x - AndroidUtilities.dp(24.0f);
        ViewGroup viewGroup = this.leftView;
        if (viewGroup != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
            if (layoutParams.width != iDp) {
                layoutParams.width = iDp;
                this.leftView.setLayoutParams(layoutParams);
            }
            this.leftView.setTranslationX((-iDp) + xOffset);
        }
        ViewGroup viewGroup2 = this.leftButtonsView;
        if (viewGroup2 != null) {
            viewGroup2.setTranslationX((-iDp) + xOffset);
        }
        ViewGroup viewGroup3 = this.centerView;
        if (viewGroup3 != null) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) viewGroup3.getLayoutParams();
            if (layoutParams2.width != iDp) {
                layoutParams2.width = iDp;
                this.centerView.setLayoutParams(layoutParams2);
            }
            this.centerView.setTranslationX(xOffset);
        }
        ViewGroup viewGroup4 = this.centerButtonsView;
        if (viewGroup4 != null) {
            viewGroup4.setTranslationX(xOffset);
        }
        ViewGroup viewGroup5 = this.rightView;
        if (viewGroup5 != null) {
            FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) viewGroup5.getLayoutParams();
            if (layoutParams3.width != iDp) {
                layoutParams3.width = iDp;
                this.rightView.setLayoutParams(layoutParams3);
            }
            this.rightView.setTranslationX(iDp + xOffset);
        }
        ViewGroup viewGroup6 = this.rightButtonsView;
        if (viewGroup6 != null) {
            viewGroup6.setTranslationX(iDp + xOffset);
        }
        this.messageContainer.invalidate();
    }

    private LinearLayout getButtonsViewForMessage(int num, boolean applyOffset) {
        int i;
        int size = num;
        LinearLayout linearLayout = null;
        if (this.popupMessages.size() == 1 && (size < 0 || size >= this.popupMessages.size())) {
            return null;
        }
        int i2 = 0;
        if (size == -1) {
            size = this.popupMessages.size() - 1;
        } else if (size == this.popupMessages.size()) {
            size = 0;
        }
        final MessageObject messageObject = this.popupMessages.get(size);
        TLRPC$ReplyMarkup tLRPC$ReplyMarkup = messageObject.messageOwner.reply_markup;
        if (messageObject.getDialogId() != 777000 || tLRPC$ReplyMarkup == null) {
            i = 0;
        } else {
            ArrayList<TLRPC$TL_keyboardButtonRow> arrayList = tLRPC$ReplyMarkup.rows;
            int size2 = arrayList.size();
            i = 0;
            for (int i3 = 0; i3 < size2; i3++) {
                TLRPC$TL_keyboardButtonRow tLRPC$TL_keyboardButtonRow = arrayList.get(i3);
                int size3 = tLRPC$TL_keyboardButtonRow.buttons.size();
                for (int i4 = 0; i4 < size3; i4++) {
                    if (tLRPC$TL_keyboardButtonRow.buttons.get(i4) instanceof TLRPC$TL_keyboardButtonCallback) {
                        i++;
                    }
                }
            }
        }
        final int i5 = messageObject.currentAccount;
        if (i > 0) {
            ArrayList<TLRPC$TL_keyboardButtonRow> arrayList2 = tLRPC$ReplyMarkup.rows;
            int size4 = arrayList2.size();
            int i6 = 0;
            while (i6 < size4) {
                TLRPC$TL_keyboardButtonRow tLRPC$TL_keyboardButtonRow2 = arrayList2.get(i6);
                int size5 = tLRPC$TL_keyboardButtonRow2.buttons.size();
                int i7 = 0;
                while (i7 < size5) {
                    TLRPC$KeyboardButton tLRPC$KeyboardButton = tLRPC$TL_keyboardButtonRow2.buttons.get(i7);
                    if (tLRPC$KeyboardButton instanceof TLRPC$TL_keyboardButtonCallback) {
                        if (linearLayout == null) {
                            linearLayout = new LinearLayout(this);
                            linearLayout.setOrientation(i2);
                            linearLayout.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
                            linearLayout.setWeightSum(100.0f);
                            linearLayout.setTag("b");
                            linearLayout.setOnTouchListener(new View.OnTouchListener() { // from class: ir.eitaa.ui.-$$Lambda$PopupNotificationActivity$pKVEKoCaON9O-U-llWmWNb8Gypw
                                @Override // android.view.View.OnTouchListener
                                public final boolean onTouch(View view, MotionEvent motionEvent) {
                                    return PopupNotificationActivity.lambda$getButtonsViewForMessage$4(view, motionEvent);
                                }
                            });
                        }
                        TextView textView = new TextView(this);
                        textView.setTextSize(1, 16.0f);
                        textView.setTextColor(Theme.getColor("windowBackgroundWhiteBlueText"));
                        textView.setTypeface(AndroidUtilities.getFontFamily(true));
                        textView.setText(tLRPC$KeyboardButton.text.toUpperCase());
                        textView.setTag(tLRPC$KeyboardButton);
                        textView.setGravity(17);
                        textView.setBackgroundDrawable(Theme.getSelectorDrawable(true));
                        linearLayout.addView(textView, LayoutHelper.createLinear(-1, -1, 100.0f / i));
                        textView.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$PopupNotificationActivity$XDbCp9nHH8SoElkU1kH_RxdrgGE
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                PopupNotificationActivity.lambda$getButtonsViewForMessage$5(i5, messageObject, view);
                            }
                        });
                    }
                    i7++;
                    i2 = 0;
                }
                i6++;
                i2 = 0;
            }
        }
        if (linearLayout != null) {
            int iDp = AndroidUtilities.displaySize.x - AndroidUtilities.dp(24.0f);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            if (applyOffset) {
                int i8 = this.currentMessageNum;
                if (size == i8) {
                    linearLayout.setTranslationX(0.0f);
                } else if (size == i8 - 1) {
                    linearLayout.setTranslationX(-iDp);
                } else if (size == i8 + 1) {
                    linearLayout.setTranslationX(iDp);
                }
            }
            this.popupContainer.addView(linearLayout, layoutParams);
        }
        return linearLayout;
    }

    static /* synthetic */ void lambda$getButtonsViewForMessage$5(int i, MessageObject messageObject, View view) {
        TLRPC$KeyboardButton tLRPC$KeyboardButton = (TLRPC$KeyboardButton) view.getTag();
        if (tLRPC$KeyboardButton != null) {
            SendMessagesHelper.getInstance(i).sendNotificationCallback(messageObject.getDialogId(), messageObject.getId(), tLRPC$KeyboardButton.data);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x017e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private android.view.ViewGroup getViewForMessage(int r29, boolean r30) {
        /*
            Method dump skipped, instructions count: 884
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.PopupNotificationActivity.getViewForMessage(int, boolean):android.view.ViewGroup");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$getViewForMessage$6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$getViewForMessage$6$PopupNotificationActivity(View view) {
        openCurrentMessage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$getViewForMessage$7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$getViewForMessage$7$PopupNotificationActivity(View view) {
        openCurrentMessage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$getViewForMessage$8, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$getViewForMessage$8$PopupNotificationActivity(View view) {
        openCurrentMessage();
    }

    private void reuseButtonsView(ViewGroup view) {
        if (view == null) {
            return;
        }
        this.popupContainer.removeView(view);
    }

    private void reuseView(ViewGroup view) {
        if (view == null) {
            return;
        }
        int iIntValue = ((Integer) view.getTag()).intValue();
        view.setVisibility(8);
        if (iIntValue == 1) {
            this.textViews.add(view);
        } else if (iIntValue == 2) {
            this.imageViews.add(view);
        } else if (iIntValue == 3) {
            this.audioViews.add(view);
        }
    }

    private void prepareLayouts(int move) {
        MessageObject messageObject;
        int iDp = AndroidUtilities.displaySize.x - AndroidUtilities.dp(24.0f);
        if (move == 0) {
            reuseView(this.centerView);
            reuseView(this.leftView);
            reuseView(this.rightView);
            reuseButtonsView(this.centerButtonsView);
            reuseButtonsView(this.leftButtonsView);
            reuseButtonsView(this.rightButtonsView);
            int i = this.currentMessageNum - 1;
            while (true) {
                int i2 = this.currentMessageNum;
                if (i >= i2 + 2) {
                    break;
                }
                if (i == i2 - 1) {
                    this.leftView = getViewForMessage(i, true);
                    this.leftButtonsView = getButtonsViewForMessage(i, true);
                } else if (i == i2) {
                    this.centerView = getViewForMessage(i, true);
                    this.centerButtonsView = getButtonsViewForMessage(i, true);
                } else if (i == i2 + 1) {
                    this.rightView = getViewForMessage(i, true);
                    this.rightButtonsView = getButtonsViewForMessage(i, true);
                }
                i++;
            }
        } else if (move == 1) {
            reuseView(this.rightView);
            reuseButtonsView(this.rightButtonsView);
            this.rightView = this.centerView;
            this.centerView = this.leftView;
            this.leftView = getViewForMessage(this.currentMessageNum - 1, true);
            this.rightButtonsView = this.centerButtonsView;
            this.centerButtonsView = this.leftButtonsView;
            this.leftButtonsView = getButtonsViewForMessage(this.currentMessageNum - 1, true);
        } else if (move == 2) {
            reuseView(this.leftView);
            reuseButtonsView(this.leftButtonsView);
            this.leftView = this.centerView;
            this.centerView = this.rightView;
            this.rightView = getViewForMessage(this.currentMessageNum + 1, true);
            this.leftButtonsView = this.centerButtonsView;
            this.centerButtonsView = this.rightButtonsView;
            this.rightButtonsView = getButtonsViewForMessage(this.currentMessageNum + 1, true);
        } else if (move == 3) {
            ViewGroup viewGroup = this.rightView;
            if (viewGroup != null) {
                float translationX = viewGroup.getTranslationX();
                reuseView(this.rightView);
                ViewGroup viewForMessage = getViewForMessage(this.currentMessageNum + 1, false);
                this.rightView = viewForMessage;
                if (viewForMessage != null) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewForMessage.getLayoutParams();
                    layoutParams.width = iDp;
                    this.rightView.setLayoutParams(layoutParams);
                    this.rightView.setTranslationX(translationX);
                    this.rightView.invalidate();
                }
            }
            ViewGroup viewGroup2 = this.rightButtonsView;
            if (viewGroup2 != null) {
                float translationX2 = viewGroup2.getTranslationX();
                reuseButtonsView(this.rightButtonsView);
                LinearLayout buttonsViewForMessage = getButtonsViewForMessage(this.currentMessageNum + 1, false);
                this.rightButtonsView = buttonsViewForMessage;
                if (buttonsViewForMessage != null) {
                    buttonsViewForMessage.setTranslationX(translationX2);
                }
            }
        } else if (move == 4) {
            ViewGroup viewGroup3 = this.leftView;
            if (viewGroup3 != null) {
                float translationX3 = viewGroup3.getTranslationX();
                reuseView(this.leftView);
                ViewGroup viewForMessage2 = getViewForMessage(0, false);
                this.leftView = viewForMessage2;
                if (viewForMessage2 != null) {
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) viewForMessage2.getLayoutParams();
                    layoutParams2.width = iDp;
                    this.leftView.setLayoutParams(layoutParams2);
                    this.leftView.setTranslationX(translationX3);
                    this.leftView.invalidate();
                }
            }
            ViewGroup viewGroup4 = this.leftButtonsView;
            if (viewGroup4 != null) {
                float translationX4 = viewGroup4.getTranslationX();
                reuseButtonsView(this.leftButtonsView);
                LinearLayout buttonsViewForMessage2 = getButtonsViewForMessage(0, false);
                this.leftButtonsView = buttonsViewForMessage2;
                if (buttonsViewForMessage2 != null) {
                    buttonsViewForMessage2.setTranslationX(translationX4);
                }
            }
        }
        for (int i3 = 0; i3 < 3; i3++) {
            int size = (this.currentMessageNum - 1) + i3;
            if (this.popupMessages.size() != 1 || (size >= 0 && size < this.popupMessages.size())) {
                if (size == -1) {
                    size = this.popupMessages.size() - 1;
                } else if (size == this.popupMessages.size()) {
                    size = 0;
                }
                messageObject = this.popupMessages.get(size);
            } else {
                messageObject = null;
            }
            this.setMessageObjects[i3] = messageObject;
        }
    }

    private void fixLayout() {
        FrameLayout frameLayout = this.avatarContainer;
        if (frameLayout != null) {
            frameLayout.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: ir.eitaa.ui.PopupNotificationActivity.6
                @Override // android.view.ViewTreeObserver.OnPreDrawListener
                public boolean onPreDraw() {
                    if (PopupNotificationActivity.this.avatarContainer != null) {
                        PopupNotificationActivity.this.avatarContainer.getViewTreeObserver().removeOnPreDrawListener(this);
                    }
                    int currentActionBarHeight = (ActionBar.getCurrentActionBarHeight() - AndroidUtilities.dp(48.0f)) / 2;
                    PopupNotificationActivity.this.avatarContainer.setPadding(PopupNotificationActivity.this.avatarContainer.getPaddingLeft(), currentActionBarHeight, PopupNotificationActivity.this.avatarContainer.getPaddingRight(), currentActionBarHeight);
                    return true;
                }
            });
        }
        ViewGroup viewGroup = this.messageContainer;
        if (viewGroup != null) {
            viewGroup.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: ir.eitaa.ui.PopupNotificationActivity.7
                @Override // android.view.ViewTreeObserver.OnPreDrawListener
                public boolean onPreDraw() {
                    PopupNotificationActivity.this.messageContainer.getViewTreeObserver().removeOnPreDrawListener(this);
                    if (PopupNotificationActivity.this.checkTransitionAnimation() || PopupNotificationActivity.this.startedMoving) {
                        return true;
                    }
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) PopupNotificationActivity.this.messageContainer.getLayoutParams();
                    marginLayoutParams.topMargin = ActionBar.getCurrentActionBarHeight();
                    marginLayoutParams.bottomMargin = AndroidUtilities.dp(48.0f);
                    marginLayoutParams.width = -1;
                    marginLayoutParams.height = -1;
                    PopupNotificationActivity.this.messageContainer.setLayoutParams(marginLayoutParams);
                    PopupNotificationActivity.this.applyViewsLayoutParams(0);
                    return true;
                }
            });
        }
    }

    private void handleIntent(Intent intent) throws InterruptedException, IOException {
        this.isReply = intent != null && intent.getBooleanExtra("force", false);
        this.popupMessages.clear();
        if (this.isReply) {
            int intExtra = intent != null ? intent.getIntExtra("currentAccount", UserConfig.selectedAccount) : UserConfig.selectedAccount;
            if (!UserConfig.isValidAccount(intExtra)) {
                return;
            } else {
                this.popupMessages.addAll(NotificationsController.getInstance(intExtra).popupReplyMessages);
            }
        } else {
            for (int i = 0; i < 3; i++) {
                if (UserConfig.getInstance(i).isClientActivated()) {
                    this.popupMessages.addAll(NotificationsController.getInstance(i).popupMessages);
                }
            }
        }
        if (((KeyguardManager) getSystemService("keyguard")).inKeyguardRestrictedInputMode() || !ApplicationLoader.isScreenOn) {
            getWindow().addFlags(2623490);
        } else {
            getWindow().addFlags(2623488);
            getWindow().clearFlags(2);
        }
        if (this.currentMessageObject == null) {
            this.currentMessageNum = 0;
        }
        getNewMessage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getNewMessage() throws InterruptedException, IOException {
        boolean z;
        if (this.popupMessages.isEmpty()) {
            onFinish();
            finish();
            return;
        }
        if ((this.currentMessageNum != 0 || this.chatActivityEnterView.hasText() || this.startedMoving) && this.currentMessageObject != null) {
            int size = this.popupMessages.size();
            for (int i = 0; i < size; i++) {
                MessageObject messageObject = this.popupMessages.get(i);
                if (messageObject.currentAccount == this.currentMessageObject.currentAccount && messageObject.getDialogId() == this.currentMessageObject.getDialogId() && messageObject.getId() == this.currentMessageObject.getId()) {
                    this.currentMessageNum = i;
                    z = true;
                    break;
                }
            }
            z = false;
        } else {
            z = false;
        }
        if (!z) {
            this.currentMessageNum = 0;
            this.currentMessageObject = this.popupMessages.get(0);
            updateInterfaceForCurrentMessage(0);
        } else if (this.startedMoving) {
            if (this.currentMessageNum == this.popupMessages.size() - 1) {
                prepareLayouts(3);
            } else if (this.currentMessageNum == 1) {
                prepareLayouts(4);
            }
        }
        this.countText.setText(String.format("%d/%d", Integer.valueOf(this.currentMessageNum + 1), Integer.valueOf(this.popupMessages.size())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openCurrentMessage() {
        if (this.currentMessageObject == null) {
            return;
        }
        Intent intent = new Intent(ApplicationLoader.applicationContext, (Class<?>) LaunchActivity.class);
        long dialogId = this.currentMessageObject.getDialogId();
        if (DialogObject.isEncryptedDialog(dialogId)) {
            intent.putExtra("encId", DialogObject.getEncryptedChatId(dialogId));
        } else if (DialogObject.isUserDialog(dialogId)) {
            intent.putExtra("userId", dialogId);
        } else if (DialogObject.isChatDialog(dialogId)) {
            intent.putExtra("chatId", -dialogId);
        }
        intent.putExtra("currentAccount", this.currentMessageObject.currentAccount);
        intent.setAction("com.tmessages.openchat" + Math.random() + ConnectionsManager.DEFAULT_DATACENTER_ID);
        intent.setFlags(32768);
        startActivity(intent);
        onFinish();
        finish();
    }

    private void updateInterfaceForCurrentMessage(int move) throws InterruptedException, IOException {
        if (this.actionBar == null) {
            return;
        }
        int i = this.lastResumedAccount;
        if (i != this.currentMessageObject.currentAccount) {
            if (i >= 0) {
                ConnectionsManager.getInstance(i).setAppPaused(true, false);
            }
            int i2 = this.currentMessageObject.currentAccount;
            this.lastResumedAccount = i2;
            ConnectionsManager.getInstance(i2).setAppPaused(false, false);
        }
        this.currentChat = null;
        this.currentUser = null;
        long dialogId = this.currentMessageObject.getDialogId();
        this.chatActivityEnterView.setDialogId(dialogId, this.currentMessageObject.currentAccount);
        if (DialogObject.isEncryptedDialog(dialogId)) {
            this.currentUser = MessagesController.getInstance(this.currentMessageObject.currentAccount).getUser(Long.valueOf(MessagesController.getInstance(this.currentMessageObject.currentAccount).getEncryptedChat(Integer.valueOf(DialogObject.getEncryptedChatId(dialogId))).user_id));
        } else if (DialogObject.isUserDialog(dialogId)) {
            this.currentUser = MessagesController.getInstance(this.currentMessageObject.currentAccount).getUser(Long.valueOf(dialogId));
        } else if (DialogObject.isChatDialog(dialogId)) {
            this.currentChat = MessagesController.getInstance(this.currentMessageObject.currentAccount).getChat(Long.valueOf(-dialogId));
            if (this.currentMessageObject.isFromUser()) {
                this.currentUser = MessagesController.getInstance(this.currentMessageObject.currentAccount).getUser(Long.valueOf(this.currentMessageObject.messageOwner.from_id.user_id));
            }
        }
        TLRPC$Chat tLRPC$Chat = this.currentChat;
        if (tLRPC$Chat != null) {
            this.nameTextView.setText(tLRPC$Chat.title);
            TLRPC$User tLRPC$User = this.currentUser;
            if (tLRPC$User != null) {
                this.onlineTextView.setText(UserObject.getUserName(tLRPC$User));
            } else {
                this.onlineTextView.setText((CharSequence) null);
            }
            this.nameTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            this.nameTextView.setCompoundDrawablePadding(0);
        } else {
            TLRPC$User tLRPC$User2 = this.currentUser;
            if (tLRPC$User2 != null) {
                this.nameTextView.setText(UserObject.getUserName(tLRPC$User2));
                if (DialogObject.isEncryptedDialog(dialogId)) {
                    this.nameTextView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_lock_white, 0, 0, 0);
                    this.nameTextView.setCompoundDrawablePadding(AndroidUtilities.dp(4.0f));
                } else {
                    this.nameTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    this.nameTextView.setCompoundDrawablePadding(0);
                }
            }
        }
        prepareLayouts(move);
        updateSubtitle();
        checkAndUpdateAvatar();
        applyViewsLayoutParams(0);
    }

    private void updateSubtitle() {
        MessageObject messageObject;
        TLRPC$User tLRPC$User;
        String str;
        if (this.actionBar == null || (messageObject = this.currentMessageObject) == null || this.currentChat != null || (tLRPC$User = this.currentUser) == null) {
            return;
        }
        long j = tLRPC$User.id;
        if (j / 1000 != 777 && j / 1000 != 333 && ContactsController.getInstance(messageObject.currentAccount).contactsDict.get(Long.valueOf(this.currentUser.id)) == null && ((ContactsController.getInstance(this.currentMessageObject.currentAccount).contactsDict.size() != 0 || !ContactsController.getInstance(this.currentMessageObject.currentAccount).isLoadingContacts()) && (str = this.currentUser.phone) != null && str.length() != 0)) {
            this.nameTextView.setText(PhoneFormat.getInstance().format("+" + this.currentUser.phone));
        } else {
            this.nameTextView.setText(UserObject.getUserName(this.currentUser));
        }
        TLRPC$User tLRPC$User2 = this.currentUser;
        if (tLRPC$User2 != null && tLRPC$User2.id == 777000) {
            this.onlineTextView.setText(LocaleController.getString("ServiceNotifications", R.string.ServiceNotifications));
            return;
        }
        CharSequence printingString = MessagesController.getInstance(this.currentMessageObject.currentAccount).getPrintingString(this.currentMessageObject.getDialogId(), 0, false);
        if (printingString == null || printingString.length() == 0) {
            this.lastPrintString = null;
            setTypingAnimation(false);
            TLRPC$User user = MessagesController.getInstance(this.currentMessageObject.currentAccount).getUser(Long.valueOf(this.currentUser.id));
            if (user != null) {
                this.currentUser = user;
            }
            this.onlineTextView.setText(LocaleController.formatUserStatus(this.currentMessageObject.currentAccount, this.currentUser));
            return;
        }
        this.lastPrintString = printingString;
        this.onlineTextView.setText(printingString);
        setTypingAnimation(true);
    }

    private void checkAndUpdateAvatar() {
        TLRPC$User user;
        MessageObject messageObject = this.currentMessageObject;
        if (messageObject == null) {
            return;
        }
        if (this.currentChat != null) {
            TLRPC$Chat chat = MessagesController.getInstance(messageObject.currentAccount).getChat(Long.valueOf(this.currentChat.id));
            if (chat == null) {
                return;
            }
            this.currentChat = chat;
            if (this.avatarImageView != null) {
                this.avatarImageView.setForUserOrChat(chat, new AvatarDrawable(this.currentChat));
                return;
            }
            return;
        }
        if (this.currentUser == null || (user = MessagesController.getInstance(messageObject.currentAccount).getUser(Long.valueOf(this.currentUser.id))) == null) {
            return;
        }
        this.currentUser = user;
        if (this.avatarImageView != null) {
            this.avatarImageView.setForUserOrChat(user, new AvatarDrawable(this.currentUser));
        }
    }

    private void setTypingAnimation(boolean start) {
        if (this.actionBar == null) {
            return;
        }
        int i = 0;
        if (start) {
            try {
                Integer printingStringType = MessagesController.getInstance(this.currentMessageObject.currentAccount).getPrintingStringType(this.currentMessageObject.getDialogId(), 0);
                this.onlineTextView.setCompoundDrawablesWithIntrinsicBounds(this.statusDrawables[printingStringType.intValue()], (Drawable) null, (Drawable) null, (Drawable) null);
                this.onlineTextView.setCompoundDrawablePadding(AndroidUtilities.dp(4.0f));
                while (i < this.statusDrawables.length) {
                    if (i == printingStringType.intValue()) {
                        this.statusDrawables[i].start();
                    } else {
                        this.statusDrawables[i].stop();
                    }
                    i++;
                }
                return;
            } catch (Exception e) {
                FileLog.e(e);
                return;
            }
        }
        this.onlineTextView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        this.onlineTextView.setCompoundDrawablePadding(0);
        while (true) {
            StatusDrawable[] statusDrawableArr = this.statusDrawables;
            if (i >= statusDrawableArr.length) {
                return;
            }
            statusDrawableArr[i].stop();
            i++;
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.chatActivityEnterView.isPopupShowing()) {
            this.chatActivityEnterView.hidePopup(true);
        } else {
            super.onBackPressed();
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        MediaController.getInstance().setFeedbackView(this.chatActivityEnterView, true);
        ChatActivityEnterView chatActivityEnterView = this.chatActivityEnterView;
        if (chatActivityEnterView != null) {
            chatActivityEnterView.setFieldFocused(true);
        }
        fixLayout();
        checkAndUpdateAvatar();
        this.wakeLock.acquire(7000L);
    }

    @Override // android.app.Activity
    protected void onPause() throws InterruptedException, IOException {
        super.onPause();
        overridePendingTransition(0, 0);
        ChatActivityEnterView chatActivityEnterView = this.chatActivityEnterView;
        if (chatActivityEnterView != null) {
            chatActivityEnterView.hidePopup(false);
            this.chatActivityEnterView.setFieldFocused(false);
        }
        int i = this.lastResumedAccount;
        if (i >= 0) {
            ConnectionsManager.getInstance(i).setAppPaused(true, false);
        }
    }

    @Override // ir.eitaa.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int id, int account, Object... args) throws InterruptedException, IOException {
        TextView textView;
        PopupAudioView popupAudioView;
        MessageObject messageObject;
        PopupAudioView popupAudioView2;
        MessageObject messageObject2;
        MessageObject messageObject3;
        if (id == NotificationCenter.appDidLogout) {
            if (account == this.lastResumedAccount) {
                onFinish();
                finish();
                return;
            }
            return;
        }
        int i = 0;
        if (id == NotificationCenter.pushMessagesUpdated) {
            if (this.isReply) {
                return;
            }
            this.popupMessages.clear();
            for (int i2 = 0; i2 < 3; i2++) {
                if (UserConfig.getInstance(i2).isClientActivated()) {
                    this.popupMessages.addAll(NotificationsController.getInstance(i2).popupMessages);
                }
            }
            getNewMessage();
            if (this.popupMessages.isEmpty()) {
                return;
            }
            for (int i3 = 0; i3 < 3; i3++) {
                int size = (this.currentMessageNum - 1) + i3;
                if (this.popupMessages.size() != 1 || (size >= 0 && size < this.popupMessages.size())) {
                    if (size == -1) {
                        size = this.popupMessages.size() - 1;
                    } else if (size == this.popupMessages.size()) {
                        size = 0;
                    }
                    messageObject3 = this.popupMessages.get(size);
                } else {
                    messageObject3 = null;
                }
                if (this.setMessageObjects[i3] != messageObject3) {
                    updateInterfaceForCurrentMessage(0);
                }
            }
            return;
        }
        if (id == NotificationCenter.updateInterfaces) {
            if (this.currentMessageObject == null || account != this.lastResumedAccount) {
                return;
            }
            int iIntValue = ((Integer) args[0]).intValue();
            if ((MessagesController.UPDATE_MASK_NAME & iIntValue) != 0 || (MessagesController.UPDATE_MASK_STATUS & iIntValue) != 0 || (MessagesController.UPDATE_MASK_CHAT_NAME & iIntValue) != 0 || (MessagesController.UPDATE_MASK_CHAT_MEMBERS & iIntValue) != 0) {
                updateSubtitle();
            }
            if ((MessagesController.UPDATE_MASK_AVATAR & iIntValue) != 0 || (MessagesController.UPDATE_MASK_CHAT_AVATAR & iIntValue) != 0) {
                checkAndUpdateAvatar();
            }
            if ((iIntValue & MessagesController.UPDATE_MASK_USER_PRINT) != 0) {
                CharSequence printingString = MessagesController.getInstance(this.currentMessageObject.currentAccount).getPrintingString(this.currentMessageObject.getDialogId(), 0, false);
                CharSequence charSequence = this.lastPrintString;
                if ((charSequence == null || printingString != null) && ((charSequence != null || printingString == null) && (charSequence == null || charSequence.equals(printingString)))) {
                    return;
                }
                updateSubtitle();
                return;
            }
            return;
        }
        if (id == NotificationCenter.messagePlayingDidReset) {
            Integer num = (Integer) args[0];
            ViewGroup viewGroup = this.messageContainer;
            if (viewGroup != null) {
                int childCount = viewGroup.getChildCount();
                while (i < childCount) {
                    View childAt = this.messageContainer.getChildAt(i);
                    if (((Integer) childAt.getTag()).intValue() == 3 && (messageObject2 = (popupAudioView2 = (PopupAudioView) childAt.findViewWithTag(300)).getMessageObject()) != null && messageObject2.currentAccount == account && messageObject2.getId() == num.intValue()) {
                        popupAudioView2.updateButtonState();
                        return;
                    }
                    i++;
                }
                return;
            }
            return;
        }
        if (id == NotificationCenter.messagePlayingProgressDidChanged) {
            Integer num2 = (Integer) args[0];
            ViewGroup viewGroup2 = this.messageContainer;
            if (viewGroup2 != null) {
                int childCount2 = viewGroup2.getChildCount();
                while (i < childCount2) {
                    View childAt2 = this.messageContainer.getChildAt(i);
                    if (((Integer) childAt2.getTag()).intValue() == 3 && (messageObject = (popupAudioView = (PopupAudioView) childAt2.findViewWithTag(300)).getMessageObject()) != null && messageObject.currentAccount == account && messageObject.getId() == num2.intValue()) {
                        popupAudioView.updateProgress();
                        return;
                    }
                    i++;
                }
                return;
            }
            return;
        }
        if (id == NotificationCenter.emojiLoaded) {
            ViewGroup viewGroup3 = this.messageContainer;
            if (viewGroup3 != null) {
                int childCount3 = viewGroup3.getChildCount();
                while (i < childCount3) {
                    View childAt3 = this.messageContainer.getChildAt(i);
                    if (((Integer) childAt3.getTag()).intValue() == 1 && (textView = (TextView) childAt3.findViewWithTag(301)) != null) {
                        textView.invalidate();
                    }
                    i++;
                }
                return;
            }
            return;
        }
        if (id == NotificationCenter.contactsDidLoad && account == this.lastResumedAccount) {
            updateSubtitle();
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        onFinish();
        MediaController.getInstance().setFeedbackView(this.chatActivityEnterView, false);
        if (this.wakeLock.isHeld()) {
            this.wakeLock.release();
        }
        BackupImageView backupImageView = this.avatarImageView;
        if (backupImageView != null) {
            backupImageView.setImageDrawable(null);
        }
    }

    protected void onFinish() {
        if (this.finished) {
            return;
        }
        this.finished = true;
        if (this.isReply) {
            this.popupMessages.clear();
        }
        for (int i = 0; i < 3; i++) {
            NotificationCenter.getInstance(i).removeObserver(this, NotificationCenter.appDidLogout);
            NotificationCenter.getInstance(i).removeObserver(this, NotificationCenter.updateInterfaces);
            NotificationCenter.getInstance(i).removeObserver(this, NotificationCenter.messagePlayingProgressDidChanged);
            NotificationCenter.getInstance(i).removeObserver(this, NotificationCenter.messagePlayingDidReset);
            NotificationCenter.getInstance(i).removeObserver(this, NotificationCenter.contactsDidLoad);
        }
        NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.pushMessagesUpdated);
        NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.emojiLoaded);
        ChatActivityEnterView chatActivityEnterView = this.chatActivityEnterView;
        if (chatActivityEnterView != null) {
            chatActivityEnterView.onDestroy();
        }
        if (this.wakeLock.isHeld()) {
            this.wakeLock.release();
        }
    }
}
