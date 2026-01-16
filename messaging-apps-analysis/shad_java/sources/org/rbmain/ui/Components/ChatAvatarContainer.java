package org.rbmain.ui.Components;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.ImageView;
import ir.medu.shad.R;
import java.util.concurrent.atomic.AtomicReference;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ChatObject;
import org.rbmain.messenger.FileLog;
import org.rbmain.messenger.ImageLocation;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.MessagesController;
import org.rbmain.messenger.NotificationCenter;
import org.rbmain.messenger.UserConfig;
import org.rbmain.messenger.UserObject;
import org.rbmain.tgnet.ConnectionsManager;
import org.rbmain.tgnet.TLRPC$Chat;
import org.rbmain.tgnet.TLRPC$ChatFull;
import org.rbmain.tgnet.TLRPC$TL_channelFull;
import org.rbmain.tgnet.TLRPC$TL_chatFull;
import org.rbmain.tgnet.TLRPC$User;
import org.rbmain.tgnet.TLRPC$UserFull;
import org.rbmain.tgnet.TLRPC$UserStatus;
import org.rbmain.ui.ActionBar.ActionBar;
import org.rbmain.ui.ActionBar.ActionBarPopupWindow;
import org.rbmain.ui.ActionBar.BaseFragment;
import org.rbmain.ui.ActionBar.SimpleTextView;
import org.rbmain.ui.ActionBar.SimpleTextView2;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.ChatActivity;
import org.rbmain.ui.Components.AnimatedEmojiDrawable;
import org.rbmain.ui.Components.AutoDeletePopupWrapper;
import org.rbmain.ui.Components.SharedMediaLayout;

/* loaded from: classes5.dex */
public class ChatAvatarContainer extends FrameLayout implements NotificationCenter.NotificationCenterDelegate {
    public boolean allowShorterStatus;
    private AvatarDrawable avatarDrawable;
    private BackupImageView avatarImageView;
    private int currentAccount;
    private int currentConnectionState;
    StatusDrawable currentTypingDrawable;
    private AnimatedEmojiDrawable.SwapAnimatedEmojiDrawable emojiStatusDrawable;
    private boolean[] isOnline;
    private int largerWidth;
    private CharSequence lastSubtitle;
    private int lastSubtitleColorKey;
    private int lastWidth;
    private int leftPadding;
    private boolean occupyStatusBar;
    private int onlineCount;
    private Integer overrideSubtitleColor;
    private ChatActivity parentFragment;
    public boolean premiumIconHiddable;
    private Theme.ResourcesProvider resourcesProvider;
    private String rightDrawableContentDescription;
    private boolean rightDrawableIsScamOrVerified;
    private boolean rtlLayout;
    private boolean secretChatTimer;
    private StatusDrawable[] statusDrawables;
    private AtomicReference<SimpleTextView2> subtitleTextLargerCopyView;
    private SimpleTextView2 subtitleTextView;
    private ImageView timeItem;
    private TimerDrawable timerDrawable;
    private AnimatorSet titleAnimation;
    private AtomicReference<SimpleTextView> titleTextLargerCopyView;
    private SimpleTextView titleTextView;

    public SharedMediaLayout.SharedMediaPreloader getSharedMediaPreloader() {
        return null;
    }

    protected boolean onAvatarClick() {
        return false;
    }

    public void onDestroy() {
    }

    private class SimpleTextConnectedView extends SimpleTextView {
        private AtomicReference<SimpleTextView> reference;

        public SimpleTextConnectedView(ChatAvatarContainer chatAvatarContainer, Context context, AtomicReference<SimpleTextView> atomicReference) {
            super(context);
            this.reference = atomicReference;
        }

        @Override // android.view.View
        public void setTranslationY(float f) {
            SimpleTextView simpleTextView;
            AtomicReference<SimpleTextView> atomicReference = this.reference;
            if (atomicReference != null && (simpleTextView = atomicReference.get()) != null) {
                simpleTextView.setTranslationY(f);
            }
            super.setTranslationY(f);
        }

        @Override // org.rbmain.ui.ActionBar.SimpleTextView
        public boolean setText(CharSequence charSequence) {
            SimpleTextView simpleTextView;
            AtomicReference<SimpleTextView> atomicReference = this.reference;
            if (atomicReference != null && (simpleTextView = atomicReference.get()) != null) {
                simpleTextView.setText(charSequence);
            }
            return super.setText(charSequence);
        }
    }

    public ChatAvatarContainer(Context context, BaseFragment baseFragment, boolean z) {
        this(context, baseFragment, z, null);
    }

    public ChatAvatarContainer(Context context, BaseFragment baseFragment, boolean z, Theme.ResourcesProvider resourcesProvider) {
        ChatActivity chatActivity;
        super(context);
        this.titleTextLargerCopyView = new AtomicReference<>();
        this.subtitleTextLargerCopyView = new AtomicReference<>();
        this.statusDrawables = new StatusDrawable[6];
        this.avatarDrawable = new AvatarDrawable();
        this.currentAccount = UserConfig.selectedAccount;
        this.occupyStatusBar = false;
        this.leftPadding = AndroidUtilities.dp(8.0f);
        this.lastWidth = -1;
        this.largerWidth = -1;
        this.isOnline = new boolean[1];
        this.rtlLayout = true;
        this.onlineCount = -1;
        this.rightDrawableIsScamOrVerified = false;
        this.rightDrawableContentDescription = null;
        this.resourcesProvider = resourcesProvider;
        boolean z2 = baseFragment instanceof ChatActivity;
        if (z2) {
            this.parentFragment = (ChatActivity) baseFragment;
        }
        ChatActivity chatActivity2 = this.parentFragment;
        final boolean z3 = (chatActivity2 == null || chatActivity2.getChatMode() != 0 || UserObject.isReplyUser(this.parentFragment.getCurrentUser())) ? false : true;
        this.avatarImageView = new BackupImageView(this, context) { // from class: org.rbmain.ui.Components.ChatAvatarContainer.1
            @Override // android.view.View
            public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
                super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
                if (z3 && getImageReceiver().hasNotThumb()) {
                    accessibilityNodeInfo.setText(LocaleController.getString("AccDescrProfilePicture", R.string.AccDescrProfilePicture));
                    if (Build.VERSION.SDK_INT >= 21) {
                        accessibilityNodeInfo.addAction(new AccessibilityNodeInfo.AccessibilityAction(16, LocaleController.getString("Open", R.string.Open)));
                        return;
                    }
                    return;
                }
                accessibilityNodeInfo.setVisibleToUser(false);
            }
        };
        if (z2 && (chatActivity = this.parentFragment) != null && (chatActivity.isThreadChat() || this.parentFragment.getChatMode() == 2)) {
            this.avatarImageView.setVisibility(8);
        }
        this.avatarImageView.setContentDescription(LocaleController.getString("AccDescrProfilePicture", R.string.AccDescrProfilePicture));
        this.avatarImageView.setRoundRadius(AndroidUtilities.dp(21.0f));
        addView(this.avatarImageView);
        if (z3) {
            this.avatarImageView.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.Components.ChatAvatarContainer$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$new$0(view);
                }
            });
        }
        SimpleTextConnectedView simpleTextConnectedView = new SimpleTextConnectedView(this, context, this.titleTextLargerCopyView);
        this.titleTextView = simpleTextConnectedView;
        simpleTextConnectedView.setEllipsizeByGradient(0, Boolean.TRUE);
        this.titleTextView.setTextColor(getThemedColor(Theme.key_actionBarDefaultTitle));
        this.titleTextView.setTextSize(18);
        this.titleTextView.setGravity(3);
        this.titleTextView.setTypeface(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM));
        this.titleTextView.setLeftDrawableTopPadding(-AndroidUtilities.dp(1.3f));
        this.titleTextView.setCanHideRightDrawable(false);
        this.titleTextView.setRightDrawableOutside(true);
        this.titleTextView.setPadding(0, AndroidUtilities.dp(6.0f), 0, AndroidUtilities.dp(12.0f));
        addView(this.titleTextView);
        SimpleTextView2 simpleTextView2 = new SimpleTextView2(context);
        this.subtitleTextView = simpleTextView2;
        simpleTextView2.setEllipsizeByGradient(true);
        SimpleTextView2 simpleTextView22 = this.subtitleTextView;
        int i = Theme.key_actionBarDefaultSubtitle;
        simpleTextView22.setTextColor(getThemedColor(i));
        this.subtitleTextView.setTag(Integer.valueOf(i));
        this.subtitleTextView.setTextSize(14);
        this.subtitleTextView.setGravity(isRtlLayout() ? 5 : 3);
        this.subtitleTextView.setPadding(0, 0, AndroidUtilities.dp(10.0f), 0);
        addView(this.subtitleTextView);
        if (this.parentFragment != null) {
            ImageView imageView = new ImageView(context);
            this.timeItem = imageView;
            imageView.setPadding(AndroidUtilities.dp(10.0f), AndroidUtilities.dp(10.0f), AndroidUtilities.dp(5.0f), AndroidUtilities.dp(5.0f));
            this.timeItem.setScaleType(ImageView.ScaleType.CENTER);
            this.timeItem.setAlpha(0.0f);
            this.timeItem.setScaleY(0.0f);
            this.timeItem.setScaleX(0.0f);
            this.timeItem.setVisibility(8);
            ImageView imageView2 = this.timeItem;
            TimerDrawable timerDrawable = new TimerDrawable(context, resourcesProvider);
            this.timerDrawable = timerDrawable;
            imageView2.setImageDrawable(timerDrawable);
            addView(this.timeItem);
            this.secretChatTimer = z;
            this.timeItem.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.Components.ChatAvatarContainer$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$new$1(view);
                }
            });
            if (this.secretChatTimer) {
                this.timeItem.setContentDescription(LocaleController.getString("SetTimer", R.string.SetTimer));
            } else {
                this.timeItem.setContentDescription(LocaleController.getString("AccAutoDeleteTimer", R.string.AccAutoDeleteTimer));
            }
        }
        ChatActivity chatActivity3 = this.parentFragment;
        if (chatActivity3 != null && chatActivity3.getChatMode() == 0) {
            if ((!this.parentFragment.isThreadChat() || this.parentFragment.isTopic) && !UserObject.isReplyUser(this.parentFragment.getCurrentUser())) {
                setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.Components.ChatAvatarContainer$$ExternalSyntheticLambda1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.lambda$new$2(view);
                    }
                });
            }
            TLRPC$Chat currentChat = this.parentFragment.getCurrentChat();
            this.statusDrawables[0] = new TypingDotsDrawable(true);
            this.statusDrawables[1] = new RecordStatusDrawable(true);
            this.statusDrawables[2] = new SendingFileDrawable(true);
            this.statusDrawables[3] = new PlayingGameDrawable(false, resourcesProvider);
            this.statusDrawables[4] = new RoundStatusDrawable(true);
            this.statusDrawables[5] = new org.rbmain.ui.Components.voip.ChoosingStickerStatusDrawable(true);
            int i2 = 0;
            while (true) {
                StatusDrawable[] statusDrawableArr = this.statusDrawables;
                if (i2 >= statusDrawableArr.length) {
                    break;
                }
                statusDrawableArr[i2].setIsChat(currentChat != null);
                i2++;
            }
        }
        this.emojiStatusDrawable = new AnimatedEmojiDrawable.SwapAnimatedEmojiDrawable(this.titleTextView, AndroidUtilities.dp(24.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(View view) {
        if (onAvatarClick()) {
            return;
        }
        openProfile(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$1(View view) {
        if (this.secretChatTimer) {
            this.parentFragment.showDialog(AlertsCreator.createTTLAlert(getContext(), this.parentFragment.getCurrentEncryptedChat()).create());
        } else {
            openSetTimer();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$2(View view) {
        openProfile(false);
    }

    public void setTitleExpand(boolean z) {
        int iDp = z ? AndroidUtilities.dp(10.0f) : 0;
        if (this.titleTextView.getPaddingRight() != iDp) {
            this.titleTextView.setPadding(0, AndroidUtilities.dp(6.0f), iDp, AndroidUtilities.dp(12.0f));
            requestLayout();
            invalidate();
        }
    }

    public void setOverrideSubtitleColor(Integer num) {
        this.overrideSubtitleColor = num;
    }

    public boolean openSetTimer() {
        int i;
        if (this.parentFragment.getParentActivity() == null) {
            return false;
        }
        TLRPC$Chat currentChat = this.parentFragment.getCurrentChat();
        if (currentChat != null && !ChatObject.canUserDoAdminAction(currentChat, 13)) {
            if (this.timeItem.getTag() != null) {
                this.parentFragment.showTimerHint();
            }
            return false;
        }
        TLRPC$ChatFull currentChatInfo = this.parentFragment.getCurrentChatInfo();
        TLRPC$UserFull currentUserInfo = this.parentFragment.getCurrentUserInfo();
        if (currentUserInfo != null) {
            i = currentUserInfo.ttl_period;
        } else {
            i = currentChatInfo != null ? currentChatInfo.ttl_period : 0;
        }
        AutoDeletePopupWrapper autoDeletePopupWrapper = new AutoDeletePopupWrapper(getContext(), null, new AutoDeletePopupWrapper.Callback() { // from class: org.rbmain.ui.Components.ChatAvatarContainer.2
            @Override // org.rbmain.ui.Components.AutoDeletePopupWrapper.Callback
            public void dismiss() {
                ActionBarPopupWindow[] actionBarPopupWindowArr = actionBarPopupWindowArr;
                if (actionBarPopupWindowArr[0] != null) {
                    actionBarPopupWindowArr[0].dismiss();
                }
            }

            @Override // org.rbmain.ui.Components.AutoDeletePopupWrapper.Callback
            public void setAutoDeleteHistory(int i2, int i3) {
                UndoView undoView;
                if (ChatAvatarContainer.this.parentFragment == null) {
                    return;
                }
                ChatAvatarContainer.this.parentFragment.getMessagesController().setDialogHistoryTTL(ChatAvatarContainer.this.parentFragment.getDialogId(), i2);
                TLRPC$ChatFull currentChatInfo2 = ChatAvatarContainer.this.parentFragment.getCurrentChatInfo();
                TLRPC$UserFull currentUserInfo2 = ChatAvatarContainer.this.parentFragment.getCurrentUserInfo();
                if ((currentUserInfo2 == null && currentChatInfo2 == null) || (undoView = ChatAvatarContainer.this.parentFragment.getUndoView()) == null) {
                    return;
                }
                undoView.showWithAction(ChatAvatarContainer.this.parentFragment.getDialogId(), i3, ChatAvatarContainer.this.parentFragment.getCurrentUser(), Integer.valueOf(currentUserInfo2 != null ? currentUserInfo2.ttl_period : currentChatInfo2.ttl_period), null, null);
            }
        }, true, 0, this.resourcesProvider);
        autoDeletePopupWrapper.lambda$updateItems$7(i);
        int i2 = -2;
        final ActionBarPopupWindow[] actionBarPopupWindowArr = {new ActionBarPopupWindow(autoDeletePopupWrapper.windowLayout, i2, i2) { // from class: org.rbmain.ui.Components.ChatAvatarContainer.3
            @Override // org.rbmain.ui.ActionBar.ActionBarPopupWindow, android.widget.PopupWindow
            public void dismiss() {
                super.dismiss();
                if (ChatAvatarContainer.this.parentFragment != null) {
                    ChatAvatarContainer.this.parentFragment.dimBehindView(false);
                }
            }
        }};
        actionBarPopupWindowArr[0].setPauseNotifications(true);
        actionBarPopupWindowArr[0].setDismissAnimationDuration(220);
        actionBarPopupWindowArr[0].setOutsideTouchable(true);
        actionBarPopupWindowArr[0].setClippingEnabled(true);
        actionBarPopupWindowArr[0].setAnimationStyle(R.style.PopupContextAnimation);
        actionBarPopupWindowArr[0].setFocusable(true);
        autoDeletePopupWrapper.windowLayout.measure(View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(1000.0f), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(1000.0f), Integer.MIN_VALUE));
        actionBarPopupWindowArr[0].setInputMethodMode(2);
        actionBarPopupWindowArr[0].getContentView().setFocusableInTouchMode(true);
        ActionBarPopupWindow actionBarPopupWindow = actionBarPopupWindowArr[0];
        BackupImageView backupImageView = this.avatarImageView;
        actionBarPopupWindow.showAtLocation(backupImageView, 0, (int) (backupImageView.getX() + getX()), (int) this.avatarImageView.getY());
        this.parentFragment.dimBehindView(true);
        return true;
    }

    public void openProfile(boolean z) {
        openProfile(z, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void openProfile(boolean r9, boolean r10) {
        /*
            Method dump skipped, instructions count: 272
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.Components.ChatAvatarContainer.openProfile(boolean, boolean):void");
    }

    public void setOccupyStatusBar(boolean z) {
        this.occupyStatusBar = false;
    }

    public void setTitleColors(int i, int i2) {
        this.titleTextView.setTextColor(i);
        this.subtitleTextView.setTextColor(i2);
        this.subtitleTextView.setTag(Integer.valueOf(i2));
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i) + this.titleTextView.getPaddingRight();
        int iDp = size - AndroidUtilities.dp((this.avatarImageView.getVisibility() == 0 ? 54 : 0) + 16);
        this.avatarImageView.measure(View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(42.0f), 1073741824), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(42.0f), 1073741824));
        if (isRtlLayout()) {
            this.titleTextView.measure(View.MeasureSpec.makeMeasureSpec((int) (this.titleTextView.getPaint().measureText(this.titleTextView.getText().toString()) + this.titleTextView.getSideDrawablesSize()), 1073741824), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(24.0f), Integer.MIN_VALUE));
        } else {
            this.titleTextView.measure(View.MeasureSpec.makeMeasureSpec(iDp, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(32.0f) + this.titleTextView.getPaddingRight(), Integer.MIN_VALUE));
        }
        this.subtitleTextView.measure(View.MeasureSpec.makeMeasureSpec(iDp, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(20.0f), Integer.MIN_VALUE));
        ImageView imageView = this.timeItem;
        if (imageView != null) {
            imageView.measure(View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(34.0f), 1073741824), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(34.0f), 1073741824));
        }
        setMeasuredDimension(size, View.MeasureSpec.getSize(i2));
        int i3 = this.lastWidth;
        if (i3 != -1 && i3 != size && i3 > size) {
            fadeOutToLessWidth(i3);
        }
        SimpleTextView simpleTextView = this.titleTextLargerCopyView.get();
        if (simpleTextView != null) {
            simpleTextView.measure(View.MeasureSpec.makeMeasureSpec(this.largerWidth - AndroidUtilities.dp((this.avatarImageView.getVisibility() != 0 ? 0 : 54) + 16), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(24.0f), Integer.MIN_VALUE));
        }
        this.lastWidth = size;
    }

    private void fadeOutToLessWidth(int i) {
        this.largerWidth = i;
        View view = (SimpleTextView) this.titleTextLargerCopyView.get();
        if (view != null) {
            removeView(view);
        }
        SimpleTextView simpleTextView = new SimpleTextView(getContext());
        this.titleTextLargerCopyView.set(simpleTextView);
        simpleTextView.setTextColor(getThemedColor(Theme.key_actionBarDefaultTitle));
        simpleTextView.setTextSize(18);
        simpleTextView.setGravity(3);
        simpleTextView.setTypeface(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM));
        simpleTextView.setLeftDrawableTopPadding(-AndroidUtilities.dp(1.3f));
        simpleTextView.setRightDrawable(this.titleTextView.getRightDrawable());
        simpleTextView.setRightDrawableOutside(this.titleTextView.getRightDrawableOutside());
        simpleTextView.setLeftDrawable(this.titleTextView.getLeftDrawable());
        simpleTextView.setText(this.titleTextView.getText());
        ViewPropertyAnimator duration = simpleTextView.animate().alpha(0.0f).setDuration(350L);
        CubicBezierInterpolator cubicBezierInterpolator = CubicBezierInterpolator.EASE_OUT_QUINT;
        duration.setInterpolator(cubicBezierInterpolator).withEndAction(new Runnable() { // from class: org.rbmain.ui.Components.ChatAvatarContainer$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$fadeOutToLessWidth$3();
            }
        }).start();
        addView(simpleTextView);
        View view2 = (SimpleTextView2) this.subtitleTextLargerCopyView.get();
        if (view2 != null) {
            removeView(view2);
        }
        SimpleTextView2 simpleTextView2 = new SimpleTextView2(getContext());
        this.subtitleTextLargerCopyView.set(simpleTextView2);
        int i2 = Theme.key_actionBarDefaultSubtitle;
        simpleTextView2.setTextColor(getThemedColor(i2));
        simpleTextView2.setTag(Integer.valueOf(i2));
        simpleTextView2.setTextSize(14);
        simpleTextView2.setGravity(3);
        simpleTextView2.setText(this.subtitleTextView.getText());
        simpleTextView2.animate().alpha(0.0f).setDuration(350L).setInterpolator(cubicBezierInterpolator).withEndAction(new Runnable() { // from class: org.rbmain.ui.Components.ChatAvatarContainer$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$fadeOutToLessWidth$4();
            }
        }).start();
        addView(simpleTextView2);
        setClipChildren(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fadeOutToLessWidth$3() {
        SimpleTextView simpleTextView = this.titleTextLargerCopyView.get();
        if (simpleTextView != null) {
            removeView(simpleTextView);
            this.titleTextLargerCopyView.set(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fadeOutToLessWidth$4() {
        SimpleTextView2 simpleTextView2 = this.subtitleTextLargerCopyView.get();
        if (simpleTextView2 != null) {
            removeView(simpleTextView2);
            this.subtitleTextLargerCopyView.set(null);
            setClipChildren(true);
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int currentActionBarHeight = ((ActionBar.getCurrentActionBarHeight() - AndroidUtilities.dp(42.0f)) / 2) + ((Build.VERSION.SDK_INT < 21 || !this.occupyStatusBar) ? 0 : AndroidUtilities.statusBarHeight);
        if (isRtlLayout()) {
            int iDp = this.avatarImageView.getVisibility() == 0 ? AndroidUtilities.dp(54.0f) : 0;
            int i5 = i3 - i;
            int iDp2 = AndroidUtilities.dp(16.0f);
            this.avatarImageView.layout((i5 - AndroidUtilities.dp(50.0f)) - iDp2, currentActionBarHeight, (i5 - AndroidUtilities.dp(8.0f)) - iDp2, AndroidUtilities.dp(42.0f) + currentActionBarHeight);
            int iMeasureText = (int) (this.titleTextView.getPaint().measureText(this.titleTextView.getText().toString()) + this.titleTextView.getSideDrawablesSize());
            if (this.subtitleTextView.getVisibility() == 0) {
                this.titleTextView.layout((((i5 - AndroidUtilities.dp(8.0f)) - iDp) - iMeasureText) - iDp2, (AndroidUtilities.dp(1.3f) + currentActionBarHeight) - this.titleTextView.getPaddingTop(), ((i5 - AndroidUtilities.dp(8.0f)) - iDp) - iDp2, this.titleTextView.getTextHeight() + currentActionBarHeight + AndroidUtilities.dp(1.3f));
            } else {
                this.titleTextView.layout((((i5 - AndroidUtilities.dp(8.0f)) - iDp) - iMeasureText) - iDp2, (AndroidUtilities.dp(11.0f) + currentActionBarHeight) - this.titleTextView.getPaddingTop(), ((i5 - AndroidUtilities.dp(8.0f)) - iDp) - iDp2, this.titleTextView.getTextHeight() + currentActionBarHeight + AndroidUtilities.dp(11.0f));
            }
            ImageView imageView = this.timeItem;
            if (imageView != null) {
                imageView.layout(((i5 - AndroidUtilities.dp(50.0f)) - iDp2) - AndroidUtilities.dp(16.0f), AndroidUtilities.dp(15.0f) + currentActionBarHeight, ((i5 - AndroidUtilities.dp(8.0f)) - iDp2) - AndroidUtilities.dp(16.0f), AndroidUtilities.dp(49.0f) + currentActionBarHeight);
            }
            this.subtitleTextView.layout((((i5 - AndroidUtilities.dp(8.0f)) - iDp) - iDp2) - this.subtitleTextView.getMeasuredWidth(), AndroidUtilities.dp(24.0f) + currentActionBarHeight, ((i5 - AndroidUtilities.dp(8.0f)) - iDp) - iDp2, currentActionBarHeight + this.subtitleTextView.getTextHeight() + AndroidUtilities.dp(24.0f));
            return;
        }
        BackupImageView backupImageView = this.avatarImageView;
        int i6 = this.leftPadding;
        int i7 = currentActionBarHeight + 1;
        backupImageView.layout(i6, i7, AndroidUtilities.dp(42.0f) + i6, AndroidUtilities.dp(42.0f) + i7);
        int iDp3 = this.leftPadding + (this.avatarImageView.getVisibility() == 0 ? AndroidUtilities.dp(54.0f) : 0);
        SimpleTextView simpleTextView = this.titleTextLargerCopyView.get();
        if (this.subtitleTextView.getVisibility() != 8) {
            this.titleTextView.layout(iDp3, (AndroidUtilities.dp(1.3f) + currentActionBarHeight) - this.titleTextView.getPaddingTop(), this.titleTextView.getMeasuredWidth() + iDp3, (((this.titleTextView.getTextHeight() + currentActionBarHeight) + AndroidUtilities.dp(1.3f)) - this.titleTextView.getPaddingTop()) + this.titleTextView.getPaddingBottom());
            if (simpleTextView != null) {
                simpleTextView.layout(iDp3, AndroidUtilities.dp(1.3f) + currentActionBarHeight, simpleTextView.getMeasuredWidth() + iDp3, simpleTextView.getTextHeight() + currentActionBarHeight + AndroidUtilities.dp(1.3f));
            }
        } else {
            this.titleTextView.layout(iDp3, (AndroidUtilities.dp(11.0f) + currentActionBarHeight) - this.titleTextView.getPaddingTop(), this.titleTextView.getMeasuredWidth() + iDp3, (((this.titleTextView.getTextHeight() + currentActionBarHeight) + AndroidUtilities.dp(11.0f)) - this.titleTextView.getPaddingTop()) + this.titleTextView.getPaddingBottom());
            if (simpleTextView != null) {
                simpleTextView.layout(iDp3, AndroidUtilities.dp(11.0f) + currentActionBarHeight, simpleTextView.getMeasuredWidth() + iDp3, simpleTextView.getTextHeight() + currentActionBarHeight + AndroidUtilities.dp(11.0f));
            }
        }
        ImageView imageView2 = this.timeItem;
        if (imageView2 != null) {
            imageView2.layout(this.leftPadding + AndroidUtilities.dp(16.0f), AndroidUtilities.dp(15.0f) + currentActionBarHeight, this.leftPadding + AndroidUtilities.dp(50.0f), AndroidUtilities.dp(49.0f) + currentActionBarHeight);
        }
        this.subtitleTextView.layout(iDp3, AndroidUtilities.dp(24.0f) + currentActionBarHeight, this.subtitleTextView.getMeasuredWidth() + iDp3, this.subtitleTextView.getTextHeight() + currentActionBarHeight + AndroidUtilities.dp(24.0f));
        SimpleTextView2 simpleTextView2 = this.subtitleTextLargerCopyView.get();
        if (simpleTextView2 != null) {
            simpleTextView2.layout(iDp3, AndroidUtilities.dp(24.0f) + currentActionBarHeight, simpleTextView2.getMeasuredWidth() + iDp3, currentActionBarHeight + simpleTextView2.getTextHeight() + AndroidUtilities.dp(24.0f));
        }
    }

    public void setLeftPadding(int i) {
        this.leftPadding = i;
    }

    public void showTimeItem(boolean z) {
        ImageView imageView = this.timeItem;
        if (imageView != null && imageView.getTag() == null && this.avatarImageView.getVisibility() == 0) {
            this.timeItem.clearAnimation();
            this.timeItem.setVisibility(0);
            this.timeItem.setTag(1);
            if (z) {
                this.timeItem.animate().setDuration(180L).alpha(1.0f).scaleX(1.0f).scaleY(1.0f).setListener(null).start();
                return;
            }
            this.timeItem.setAlpha(1.0f);
            this.timeItem.setScaleY(1.0f);
            this.timeItem.setScaleX(1.0f);
        }
    }

    public void hideTimeItem(boolean z) {
        ImageView imageView = this.timeItem;
        if (imageView == null || imageView.getTag() == null) {
            return;
        }
        this.timeItem.clearAnimation();
        this.timeItem.setTag(null);
        if (z) {
            this.timeItem.animate().setDuration(180L).alpha(0.0f).scaleX(0.0f).scaleY(0.0f).setListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.Components.ChatAvatarContainer.4
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    ChatAvatarContainer.this.timeItem.setVisibility(8);
                    super.onAnimationEnd(animator);
                }
            }).start();
            return;
        }
        this.timeItem.setVisibility(8);
        this.timeItem.setAlpha(0.0f);
        this.timeItem.setScaleY(0.0f);
        this.timeItem.setScaleX(0.0f);
    }

    public void setTime(int i, boolean z) {
        if (this.timerDrawable == null) {
            return;
        }
        if (i != 0 || this.secretChatTimer) {
            showTimeItem(z);
            this.timerDrawable.setTime(i);
        }
    }

    public void setTitleIcons(Drawable drawable, Drawable drawable2) {
        if (isRtlLayout()) {
            this.titleTextView.setRightDrawable(drawable);
            if (this.rightDrawableIsScamOrVerified) {
                return;
            }
            if (drawable2 != null) {
                this.rightDrawableContentDescription = LocaleController.getString("NotificationsMuted", R.string.NotificationsMuted);
            } else {
                this.rightDrawableContentDescription = null;
            }
            this.titleTextView.setLeftDrawable(drawable2);
            return;
        }
        this.titleTextView.setLeftDrawable(drawable);
        if (this.rightDrawableIsScamOrVerified) {
            return;
        }
        if (drawable2 != null) {
            this.rightDrawableContentDescription = LocaleController.getString("NotificationsMuted", R.string.NotificationsMuted);
        } else {
            this.rightDrawableContentDescription = null;
        }
        this.titleTextView.setRightDrawable(drawable2);
    }

    public void setTitle(CharSequence charSequence) {
        setTitle(charSequence, false, false, false, false, null, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00ef  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void setTitle(java.lang.CharSequence r4, boolean r5, boolean r6, boolean r7, boolean r8, org.rbmain.tgnet.TLRPC$EmojiStatus r9, boolean r10) {
        /*
            Method dump skipped, instructions count: 376
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.Components.ChatAvatarContainer.setTitle(java.lang.CharSequence, boolean, boolean, boolean, boolean, org.rbmain.tgnet.TLRPC$EmojiStatus, boolean):void");
    }

    public void setSubtitle(CharSequence charSequence) {
        if (this.lastSubtitle == null) {
            this.subtitleTextView.setText(charSequence);
        } else {
            this.lastSubtitle = charSequence;
        }
    }

    public ImageView getTimeItem() {
        return this.timeItem;
    }

    public SimpleTextView getTitleTextView() {
        return this.titleTextView;
    }

    public SimpleTextView getSubtitleTextView() {
        return this.subtitleTextView;
    }

    private void setTypingAnimation(boolean z) {
        int i = 0;
        if (z) {
            try {
                int iIntValue = MessagesController.getInstance(this.currentAccount).getPrintingStringType(this.parentFragment.getDialogId(), this.parentFragment.getThreadId()).intValue();
                if (iIntValue == 5) {
                    this.subtitleTextView.replaceTextWithDrawable(this.statusDrawables[iIntValue], "**oo**");
                    this.statusDrawables[iIntValue].setColor(getThemedColor(Theme.key_chat_status));
                    if (isRtlLayout()) {
                        this.subtitleTextView.setRightDrawable((Drawable) null);
                    } else {
                        this.subtitleTextView.setLeftDrawable((Drawable) null);
                    }
                } else {
                    this.subtitleTextView.replaceTextWithDrawable(null, null);
                    this.statusDrawables[iIntValue].setColor(getThemedColor(Theme.key_chat_status));
                    if (isRtlLayout()) {
                        this.subtitleTextView.setRightDrawable(this.statusDrawables[iIntValue]);
                    } else {
                        this.subtitleTextView.setLeftDrawable(this.statusDrawables[iIntValue]);
                    }
                }
                this.currentTypingDrawable = this.statusDrawables[iIntValue];
                while (true) {
                    StatusDrawable[] statusDrawableArr = this.statusDrawables;
                    if (i >= statusDrawableArr.length) {
                        return;
                    }
                    if (i == iIntValue) {
                        statusDrawableArr[i].start();
                    } else {
                        statusDrawableArr[i].stop();
                    }
                    i++;
                }
            } catch (Exception e) {
                FileLog.e(e);
            }
        } else {
            this.currentTypingDrawable = null;
            if (isRtlLayout()) {
                this.subtitleTextView.setRightDrawable((Drawable) null);
            } else {
                this.subtitleTextView.setLeftDrawable((Drawable) null);
            }
            this.subtitleTextView.replaceTextWithDrawable(null, null);
            while (true) {
                StatusDrawable[] statusDrawableArr2 = this.statusDrawables;
                if (i >= statusDrawableArr2.length) {
                    return;
                }
                statusDrawableArr2[i].stop();
                i++;
            }
        }
    }

    public void updateSubtitle() {
        updateSubtitle(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:139:0x0387 A[PHI: r3
      0x0387: PHI (r3v10 java.lang.CharSequence) = (r3v1 java.lang.CharSequence), (r3v1 java.lang.CharSequence), (r3v11 java.lang.CharSequence) binds: [B:109:0x02f9, B:114:0x0312, B:119:0x032d] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void updateSubtitle(boolean r13) {
        /*
            Method dump skipped, instructions count: 978
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.Components.ChatAvatarContainer.updateSubtitle(boolean):void");
    }

    public int getLastSubtitleColorKey() {
        return this.lastSubtitleColorKey;
    }

    public void setChatAvatar(TLRPC$Chat tLRPC$Chat) {
        this.avatarDrawable.setInfo(tLRPC$Chat);
        BackupImageView backupImageView = this.avatarImageView;
        if (backupImageView != null) {
            backupImageView.setForUserOrChat(tLRPC$Chat, this.avatarDrawable);
            this.avatarImageView.setRoundRadius(AndroidUtilities.dp((tLRPC$Chat == null || !tLRPC$Chat.forum) ? 21.0f : 16.0f));
        }
    }

    public void setUserAvatar(TLRPC$User tLRPC$User) {
        setUserAvatar(tLRPC$User, false);
    }

    public void setUserAvatar(TLRPC$User tLRPC$User, boolean z) {
        this.avatarDrawable.setInfo(tLRPC$User);
        if (UserObject.isReplyUser(tLRPC$User)) {
            this.avatarDrawable.setAvatarType(12);
            this.avatarDrawable.setScaleSize(0.8f);
            BackupImageView backupImageView = this.avatarImageView;
            if (backupImageView != null) {
                backupImageView.setImage((ImageLocation) null, (String) null, this.avatarDrawable, tLRPC$User);
                return;
            }
            return;
        }
        if (UserObject.isUserSelf(tLRPC$User) && !z) {
            this.avatarDrawable.setAvatarType(1);
            this.avatarDrawable.setScaleSize(0.8f);
            BackupImageView backupImageView2 = this.avatarImageView;
            if (backupImageView2 != null) {
                backupImageView2.setImage((ImageLocation) null, (String) null, this.avatarDrawable, tLRPC$User);
                return;
            }
            return;
        }
        this.avatarDrawable.setScaleSize(1.0f);
        BackupImageView backupImageView3 = this.avatarImageView;
        if (backupImageView3 != null) {
            backupImageView3.setForUserOrChat(tLRPC$User, this.avatarDrawable);
        }
    }

    public void checkAndUpdateAvatar() {
        ChatActivity chatActivity = this.parentFragment;
        if (chatActivity == null) {
            return;
        }
        TLRPC$User currentUser = chatActivity.getCurrentUser();
        TLRPC$Chat currentChat = this.parentFragment.getCurrentChat();
        if (currentUser == null) {
            if (currentChat != null) {
                this.avatarDrawable.setInfo(currentChat);
                BackupImageView backupImageView = this.avatarImageView;
                if (backupImageView != null) {
                    backupImageView.setForUserOrChat(currentChat, this.avatarDrawable);
                }
                this.avatarImageView.setRoundRadius(AndroidUtilities.dp(currentChat.forum ? 16.0f : 21.0f));
                return;
            }
            return;
        }
        this.avatarDrawable.setInfo(currentUser);
        if (UserObject.isReplyUser(currentUser)) {
            this.avatarDrawable.setScaleSize(0.8f);
            this.avatarDrawable.setAvatarType(12);
            BackupImageView backupImageView2 = this.avatarImageView;
            if (backupImageView2 != null) {
                backupImageView2.setImage((ImageLocation) null, (String) null, this.avatarDrawable, currentUser);
                return;
            }
            return;
        }
        if (UserObject.isUserSelf(currentUser)) {
            this.avatarDrawable.setScaleSize(0.8f);
            this.avatarDrawable.setAvatarType(1);
            BackupImageView backupImageView3 = this.avatarImageView;
            if (backupImageView3 != null) {
                backupImageView3.setImage((ImageLocation) null, (String) null, this.avatarDrawable, currentUser);
                return;
            }
            return;
        }
        this.avatarDrawable.setScaleSize(1.0f);
        BackupImageView backupImageView4 = this.avatarImageView;
        if (backupImageView4 != null) {
            backupImageView4.imageReceiver.setForUserOrChat(currentUser, this.avatarDrawable, null, true, 3);
        }
    }

    public void updateOnlineCount() {
        TLRPC$UserStatus tLRPC$UserStatus;
        boolean z;
        ChatActivity chatActivity = this.parentFragment;
        if (chatActivity == null) {
            return;
        }
        this.onlineCount = 0;
        TLRPC$ChatFull currentChatInfo = chatActivity.getCurrentChatInfo();
        if (currentChatInfo == null) {
            return;
        }
        int currentTime = ConnectionsManager.getInstance(this.currentAccount).getCurrentTime();
        if (!(currentChatInfo instanceof TLRPC$TL_chatFull) && (!((z = currentChatInfo instanceof TLRPC$TL_channelFull)) || currentChatInfo.participants_count > 200 || currentChatInfo.participants == null || currentChatInfo.online_count != 0)) {
            if (z) {
                this.onlineCount = currentChatInfo.online_count;
                return;
            }
            return;
        }
        for (int i = 0; i < currentChatInfo.participants.participants.size(); i++) {
            TLRPC$User user = MessagesController.getInstance(this.currentAccount).getUser(Integer.valueOf(currentChatInfo.participants.participants.get(i).user_id));
            if (user != null && (tLRPC$UserStatus = user.status) != null && ((tLRPC$UserStatus.expires > currentTime || user.id == UserConfig.getInstance(this.currentAccount).getClientUserId()) && user.status.expires > 10000)) {
                this.onlineCount++;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.parentFragment != null) {
            NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.didUpdateConnectionState);
            NotificationCenter.getGlobalInstance().addObserver(this, NotificationCenter.emojiDidLoad);
            this.currentConnectionState = ConnectionsManager.getInstance(this.currentAccount).getConnectionState();
            updateCurrentConnectionState();
        }
        AnimatedEmojiDrawable.SwapAnimatedEmojiDrawable swapAnimatedEmojiDrawable = this.emojiStatusDrawable;
        if (swapAnimatedEmojiDrawable != null) {
            swapAnimatedEmojiDrawable.attach();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.parentFragment != null) {
            NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.didUpdateConnectionState);
            NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.emojiDidLoad);
        }
        AnimatedEmojiDrawable.SwapAnimatedEmojiDrawable swapAnimatedEmojiDrawable = this.emojiStatusDrawable;
        if (swapAnimatedEmojiDrawable != null) {
            swapAnimatedEmojiDrawable.detach();
        }
    }

    @Override // org.rbmain.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int i, int i2, Object... objArr) {
        if (i == NotificationCenter.didUpdateConnectionState) {
            int connectionState = ConnectionsManager.getInstance(this.currentAccount).getConnectionState();
            if (this.currentConnectionState != connectionState) {
                this.currentConnectionState = connectionState;
                updateCurrentConnectionState();
                return;
            }
            return;
        }
        if (i == NotificationCenter.emojiDidLoad) {
            SimpleTextView simpleTextView = this.titleTextView;
            if (simpleTextView != null) {
                simpleTextView.invalidate();
            }
            SimpleTextView2 simpleTextView2 = this.subtitleTextView;
            if (simpleTextView2 != null) {
                simpleTextView2.invalidate();
            }
            invalidate();
        }
    }

    private void updateCurrentConnectionState() {
        String string;
        int i = this.currentConnectionState;
        if (i == 2) {
            string = LocaleController.getString("WaitingForNetwork", R.string.WaitingForNetwork);
        } else if (i == 1) {
            string = LocaleController.getString("Connecting", R.string.Connecting);
        } else if (i == 5) {
            string = LocaleController.getString("Updating", R.string.Updating);
        } else {
            string = i == 4 ? LocaleController.getString("ConnectingToProxy", R.string.ConnectingToProxy) : null;
        }
        if (string == null) {
            CharSequence charSequence = this.lastSubtitle;
            if (charSequence != null) {
                this.subtitleTextView.setText(charSequence);
                this.lastSubtitle = null;
                Integer num = this.overrideSubtitleColor;
                if (num != null) {
                    this.subtitleTextView.setTextColor(num.intValue());
                    return;
                }
                int i2 = this.lastSubtitleColorKey;
                if (i2 >= 0) {
                    this.subtitleTextView.setTextColor(getThemedColor(i2));
                    this.subtitleTextView.setTag(Integer.valueOf(this.lastSubtitleColorKey));
                    return;
                }
                return;
            }
            return;
        }
        if (this.lastSubtitle == null) {
            this.lastSubtitle = this.subtitleTextView.getText();
        }
        this.subtitleTextView.setText(string);
        Integer num2 = this.overrideSubtitleColor;
        if (num2 != null) {
            this.subtitleTextView.setTextColor(num2.intValue());
            return;
        }
        SimpleTextView2 simpleTextView2 = this.subtitleTextView;
        int i3 = Theme.key_actionBarDefaultSubtitle;
        simpleTextView2.setTextColor(getThemedColor(i3));
        this.subtitleTextView.setTag(Integer.valueOf(i3));
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        StringBuilder sb = new StringBuilder();
        sb.append(this.titleTextView.getText());
        if (this.rightDrawableContentDescription != null) {
            sb.append(", ");
            sb.append(this.rightDrawableContentDescription);
        }
        sb.append("\n");
        sb.append(this.subtitleTextView.getText());
        accessibilityNodeInfo.setContentDescription(sb);
        if (!accessibilityNodeInfo.isClickable() || Build.VERSION.SDK_INT < 21) {
            return;
        }
        accessibilityNodeInfo.addAction(new AccessibilityNodeInfo.AccessibilityAction(16, LocaleController.getString("OpenProfile", R.string.OpenProfile)));
    }

    public BackupImageView getAvatarImageView() {
        return this.avatarImageView;
    }

    private int getThemedColor(int i) {
        return Theme.getColor(i, this.resourcesProvider);
    }

    public void updateColors() {
        StatusDrawable statusDrawable = this.currentTypingDrawable;
        if (statusDrawable != null) {
            statusDrawable.setColor(getThemedColor(Theme.key_chat_status));
        }
    }

    public void setRtlLayout(boolean z) {
        this.rtlLayout = z;
    }

    public boolean isRtlLayout() {
        return LocaleController.isRTL && this.rtlLayout;
    }
}
