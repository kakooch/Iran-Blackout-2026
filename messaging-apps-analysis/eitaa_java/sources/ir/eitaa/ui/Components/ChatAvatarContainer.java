package ir.eitaa.ui.Components;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.Property;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.ImageView;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ChatObject;
import ir.eitaa.messenger.Emoji;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.ImageLocation;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.messenger.NotificationCenter;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.UserConfig;
import ir.eitaa.messenger.UserObject;
import ir.eitaa.tgnet.ConnectionsManager;
import ir.eitaa.tgnet.TLRPC$Chat;
import ir.eitaa.tgnet.TLRPC$ChatFull;
import ir.eitaa.tgnet.TLRPC$ChatParticipants;
import ir.eitaa.tgnet.TLRPC$TL_channelFull;
import ir.eitaa.tgnet.TLRPC$TL_chatFull;
import ir.eitaa.tgnet.TLRPC$User;
import ir.eitaa.tgnet.TLRPC$UserFull;
import ir.eitaa.tgnet.TLRPC$UserStatus;
import ir.eitaa.ui.ActionBar.ActionBar;
import ir.eitaa.ui.ActionBar.SimpleTextView;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.ChatActivity;
import ir.eitaa.ui.Components.ClearHistoryAlert;
import ir.eitaa.ui.Components.SharedMediaLayout;

/* loaded from: classes3.dex */
public class ChatAvatarContainer extends FrameLayout implements NotificationCenter.NotificationCenterDelegate {
    private AvatarDrawable avatarDrawable;
    private BackupImageView avatarImageView;
    private int currentAccount;
    private int currentConnectionState;
    StatusDrawable currentTypingDrawable;
    private boolean[] isOnline;
    private CharSequence lastSubtitle;
    private String lastSubtitleColorKey;
    private int leftPadding;
    private boolean occupyStatusBar;
    private int onlineCount;
    private ChatActivity parentFragment;
    private Theme.ResourcesProvider resourcesProvider;
    private boolean secretChatTimer;
    private SharedMediaLayout.SharedMediaPreloader sharedMediaPreloader;
    private StatusDrawable[] statusDrawables;
    private SimpleTextView subtitleTextView;
    private ImageView timeItem;
    private TimerDrawable timerDrawable;
    private AnimatorSet titleAnimation;
    private SimpleTextView titleTextView;

    public ChatAvatarContainer(Context context, ChatActivity chatActivity, boolean needTime) {
        this(context, chatActivity, needTime, null);
    }

    public ChatAvatarContainer(Context context, ChatActivity chatActivity, boolean needTime, final Theme.ResourcesProvider resourcesProvider) {
        super(context);
        this.statusDrawables = new StatusDrawable[6];
        this.avatarDrawable = new AvatarDrawable();
        this.currentAccount = UserConfig.selectedAccount;
        this.occupyStatusBar = true;
        this.leftPadding = AndroidUtilities.dp(8.0f);
        this.isOnline = new boolean[1];
        this.onlineCount = -1;
        this.resourcesProvider = resourcesProvider;
        this.parentFragment = chatActivity;
        final boolean z = (chatActivity == null || chatActivity.getChatMode() != 0 || UserObject.isReplyUser(this.parentFragment.getCurrentUser())) ? false : true;
        this.avatarImageView = new BackupImageView(context) { // from class: ir.eitaa.ui.Components.ChatAvatarContainer.1
            @Override // android.view.View
            public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
                super.onInitializeAccessibilityNodeInfo(info);
                if (z && getImageReceiver().hasNotThumb()) {
                    info.setText(LocaleController.getString("AccDescrProfilePicture", R.string.AccDescrProfilePicture));
                    if (Build.VERSION.SDK_INT >= 21) {
                        info.addAction(new AccessibilityNodeInfo.AccessibilityAction(16, LocaleController.getString("Open", R.string.Open)));
                        return;
                    }
                    return;
                }
                info.setVisibleToUser(false);
            }
        };
        if (this.parentFragment != null) {
            this.sharedMediaPreloader = new SharedMediaLayout.SharedMediaPreloader(chatActivity);
            if (this.parentFragment.isThreadChat() || this.parentFragment.getChatMode() == 2) {
                this.avatarImageView.setVisibility(8);
            }
        }
        this.avatarImageView.setContentDescription(LocaleController.getString("AccDescrProfilePicture", R.string.AccDescrProfilePicture));
        this.avatarImageView.setRoundRadius(AndroidUtilities.dp(21.0f));
        addView(this.avatarImageView);
        if (z) {
            this.avatarImageView.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatAvatarContainer$76-70JyVpAVF2vdIl9CAYAdXA60
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$new$0$ChatAvatarContainer(view);
                }
            });
        }
        SimpleTextView simpleTextView = new SimpleTextView(context);
        this.titleTextView = simpleTextView;
        simpleTextView.setTextColor(getThemedColor("actionBarDefaultTitle"));
        this.titleTextView.setTextSize(18);
        this.titleTextView.setGravity(3);
        this.titleTextView.setTypeface(AndroidUtilities.getFontFamily(true));
        this.titleTextView.setLeftDrawableTopPadding(-AndroidUtilities.dp(1.3f));
        addView(this.titleTextView);
        SimpleTextView simpleTextView2 = new SimpleTextView(context);
        this.subtitleTextView = simpleTextView2;
        simpleTextView2.setTextColor(getThemedColor("actionBarDefaultSubtitle"));
        this.subtitleTextView.setTag("actionBarDefaultSubtitle");
        this.subtitleTextView.setTextSize(14);
        this.subtitleTextView.setTypeface(AndroidUtilities.getFontFamily(false));
        this.subtitleTextView.setGravity(3);
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
            TimerDrawable timerDrawable = new TimerDrawable(context);
            this.timerDrawable = timerDrawable;
            imageView2.setImageDrawable(timerDrawable);
            addView(this.timeItem);
            this.secretChatTimer = needTime;
            this.timeItem.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatAvatarContainer$cejc59bWrmG7hBfZxjVwlKYCgaE
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$new$1$ChatAvatarContainer(resourcesProvider, view);
                }
            });
            if (this.secretChatTimer) {
                this.timeItem.setContentDescription(LocaleController.getString("SetTimer", R.string.SetTimer));
            } else {
                this.timeItem.setContentDescription(LocaleController.getString("AccAutoDeleteTimer", R.string.AccAutoDeleteTimer));
            }
        }
        ChatActivity chatActivity2 = this.parentFragment;
        if (chatActivity2 == null || chatActivity2.getChatMode() != 0) {
            return;
        }
        if (!this.parentFragment.isThreadChat() && !UserObject.isReplyUser(this.parentFragment.getCurrentUser())) {
            setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatAvatarContainer$cgxm5IgPQdlVwYxSZQIbD0Jn2Uo
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$new$2$ChatAvatarContainer(view);
                }
            });
        }
        TLRPC$Chat currentChat = this.parentFragment.getCurrentChat();
        this.statusDrawables[0] = new TypingDotsDrawable(true);
        this.statusDrawables[1] = new RecordStatusDrawable(true);
        this.statusDrawables[2] = new SendingFileDrawable(true);
        this.statusDrawables[3] = new PlayingGameDrawable(false, resourcesProvider);
        this.statusDrawables[4] = new RoundStatusDrawable(true);
        this.statusDrawables[5] = new ChoosingStickerStatusDrawable(true);
        int i = 0;
        while (true) {
            StatusDrawable[] statusDrawableArr = this.statusDrawables;
            if (i >= statusDrawableArr.length) {
                return;
            }
            statusDrawableArr[i].setIsChat(currentChat != null);
            i++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$0$ChatAvatarContainer(View view) {
        openProfile(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$1$ChatAvatarContainer(Theme.ResourcesProvider resourcesProvider, View view) {
        if (this.secretChatTimer) {
            this.parentFragment.showDialog(AlertsCreator.createTTLAlert(getContext(), this.parentFragment.getCurrentEncryptedChat(), resourcesProvider).create());
        } else {
            openSetTimer();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$2$ChatAvatarContainer(View view) {
        openProfile(false);
    }

    public boolean openSetTimer() {
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
        ClearHistoryAlert clearHistoryAlert = new ClearHistoryAlert(this.parentFragment.getParentActivity(), this.parentFragment.getCurrentUser(), this.parentFragment.getCurrentChat(), false, null);
        clearHistoryAlert.setDelegate(new ClearHistoryAlert.ClearHistoryAlertDelegate() { // from class: ir.eitaa.ui.Components.ChatAvatarContainer.2
            @Override // ir.eitaa.ui.Components.ClearHistoryAlert.ClearHistoryAlertDelegate
            public /* synthetic */ void onClearHistory(boolean z) {
                ClearHistoryAlert.ClearHistoryAlertDelegate.CC.$default$onClearHistory(this, z);
            }

            @Override // ir.eitaa.ui.Components.ClearHistoryAlert.ClearHistoryAlertDelegate
            public void onAutoDeleteHistory(int ttl, int action) {
                ChatAvatarContainer.this.parentFragment.getMessagesController().setDialogHistoryTTL(ChatAvatarContainer.this.parentFragment.getDialogId(), ttl);
                TLRPC$ChatFull currentChatInfo = ChatAvatarContainer.this.parentFragment.getCurrentChatInfo();
                TLRPC$UserFull currentUserInfo = ChatAvatarContainer.this.parentFragment.getCurrentUserInfo();
                if (currentUserInfo == null && currentChatInfo == null) {
                    return;
                }
                ChatAvatarContainer.this.parentFragment.getUndoView().showWithAction(ChatAvatarContainer.this.parentFragment.getDialogId(), action, ChatAvatarContainer.this.parentFragment.getCurrentUser(), Integer.valueOf(currentUserInfo != null ? currentUserInfo.ttl_period : currentChatInfo.ttl_period), (Runnable) null, (Runnable) null);
            }
        });
        this.parentFragment.showDialog(clearHistoryAlert);
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void openProfile(boolean r8) {
        /*
            Method dump skipped, instructions count: 256
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Components.ChatAvatarContainer.openProfile(boolean):void");
    }

    public void setOccupyStatusBar(boolean value) {
        this.occupyStatusBar = value;
    }

    public void setTitleColors(int title, int subtitle) {
        this.titleTextView.setTextColor(title);
        this.subtitleTextView.setTextColor(subtitle);
        this.subtitleTextView.setTag(Integer.valueOf(subtitle));
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int size = View.MeasureSpec.getSize(widthMeasureSpec);
        int iDp = size - AndroidUtilities.dp((this.avatarImageView.getVisibility() == 0 ? 54 : 0) + 16);
        this.avatarImageView.measure(View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(42.0f), 1073741824), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(42.0f), 1073741824));
        this.titleTextView.measure(View.MeasureSpec.makeMeasureSpec(iDp, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(24.0f), Integer.MIN_VALUE));
        this.subtitleTextView.measure(View.MeasureSpec.makeMeasureSpec(iDp, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(20.0f), Integer.MIN_VALUE));
        ImageView imageView = this.timeItem;
        if (imageView != null) {
            imageView.measure(View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(34.0f), 1073741824), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(34.0f), 1073741824));
        }
        setMeasuredDimension(size, View.MeasureSpec.getSize(heightMeasureSpec));
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        int currentActionBarHeight = ((ActionBar.getCurrentActionBarHeight() - AndroidUtilities.dp(42.0f)) / 2) + ((Build.VERSION.SDK_INT < 21 || !this.occupyStatusBar) ? 0 : AndroidUtilities.statusBarHeight);
        BackupImageView backupImageView = this.avatarImageView;
        int i = this.leftPadding;
        backupImageView.layout(i, currentActionBarHeight, AndroidUtilities.dp(42.0f) + i, AndroidUtilities.dp(42.0f) + currentActionBarHeight);
        int iDp = this.leftPadding + (this.avatarImageView.getVisibility() == 0 ? AndroidUtilities.dp(54.0f) : 0);
        if (this.subtitleTextView.getVisibility() != 8) {
            this.titleTextView.layout(iDp, AndroidUtilities.dp(1.3f) + currentActionBarHeight, this.titleTextView.getMeasuredWidth() + iDp, this.titleTextView.getTextHeight() + currentActionBarHeight + AndroidUtilities.dp(1.3f));
        } else {
            this.titleTextView.layout(iDp, AndroidUtilities.dp(11.0f) + currentActionBarHeight, this.titleTextView.getMeasuredWidth() + iDp, this.titleTextView.getTextHeight() + currentActionBarHeight + AndroidUtilities.dp(11.0f));
        }
        ImageView imageView = this.timeItem;
        if (imageView != null) {
            imageView.layout(this.leftPadding + AndroidUtilities.dp(16.0f), AndroidUtilities.dp(15.0f) + currentActionBarHeight, this.leftPadding + AndroidUtilities.dp(50.0f), AndroidUtilities.dp(49.0f) + currentActionBarHeight);
        }
        this.subtitleTextView.layout(iDp, AndroidUtilities.dp(24.0f) + currentActionBarHeight, this.subtitleTextView.getMeasuredWidth() + iDp, currentActionBarHeight + this.subtitleTextView.getTextHeight() + AndroidUtilities.dp(24.0f));
    }

    public void setLeftPadding(int value) {
        this.leftPadding = value;
    }

    public void showTimeItem(boolean animated) {
        ImageView imageView = this.timeItem;
        if (imageView == null || imageView.getTag() != null) {
            return;
        }
        this.timeItem.clearAnimation();
        this.timeItem.setVisibility(0);
        this.timeItem.setTag(1);
        if (animated) {
            this.timeItem.animate().setDuration(180L).alpha(1.0f).scaleX(1.0f).scaleY(1.0f).setListener(null).start();
            return;
        }
        this.timeItem.setAlpha(1.0f);
        this.timeItem.setScaleY(1.0f);
        this.timeItem.setScaleX(1.0f);
    }

    public void hideTimeItem(boolean animated) {
        ImageView imageView = this.timeItem;
        if (imageView == null || imageView.getTag() == null) {
            return;
        }
        this.timeItem.clearAnimation();
        this.timeItem.setTag(null);
        if (animated) {
            this.timeItem.animate().setDuration(180L).alpha(0.0f).scaleX(0.0f).scaleY(0.0f).setListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.ChatAvatarContainer.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    ChatAvatarContainer.this.timeItem.setVisibility(8);
                    super.onAnimationEnd(animation);
                }
            }).start();
            return;
        }
        this.timeItem.setVisibility(8);
        this.timeItem.setAlpha(0.0f);
        this.timeItem.setScaleY(0.0f);
        this.timeItem.setScaleX(0.0f);
    }

    public void setTime(int value) {
        TimerDrawable timerDrawable = this.timerDrawable;
        if (timerDrawable == null) {
            return;
        }
        if (value != 0 || this.secretChatTimer) {
            timerDrawable.setTime(value);
        }
    }

    public void setTitleIcons(Drawable leftIcon, Drawable rightIcon) {
        this.titleTextView.setLeftDrawable(leftIcon);
        if (this.titleTextView.getRightDrawable() instanceof ScamDrawable) {
            return;
        }
        this.titleTextView.setRightDrawable(rightIcon);
    }

    public void setTitle(CharSequence value) {
        setTitle(value, false, false, false, false);
    }

    public void setTitle(CharSequence value, boolean trusty, boolean fake, boolean shop, boolean verified) {
        this.titleTextView.setText(value);
        if (trusty || fake || shop) {
            int i = 0;
            if (!trusty) {
                if (fake) {
                    i = 1;
                } else if (shop) {
                    i = 2;
                }
            }
            if (this.titleTextView.getRightDrawable() instanceof ScamDrawable) {
                return;
            }
            ScamDrawable scamDrawable = new ScamDrawable(11, i);
            scamDrawable.setColor(getThemedColor("actionBarDefaultSubtitle"));
            this.titleTextView.setRightDrawable(scamDrawable);
            return;
        }
        if (verified) {
            Drawable drawableMutate = getResources().getDrawable(R.drawable.verified_area).mutate();
            drawableMutate.setColorFilter(new PorterDuffColorFilter(getThemedColor("profile_verifiedBackground"), PorterDuff.Mode.MULTIPLY));
            Drawable drawableMutate2 = getResources().getDrawable(R.drawable.verified_check).mutate();
            drawableMutate2.setColorFilter(new PorterDuffColorFilter(getThemedColor("profile_verifiedCheck"), PorterDuff.Mode.MULTIPLY));
            this.titleTextView.setRightDrawable(new CombinedDrawable(drawableMutate, drawableMutate2));
            return;
        }
        if (this.titleTextView.getRightDrawable() instanceof ScamDrawable) {
            this.titleTextView.setRightDrawable((Drawable) null);
        }
    }

    public void setSubtitle(CharSequence value) {
        if (this.lastSubtitle == null) {
            this.subtitleTextView.setText(AndroidUtilities.fixNumbers(value.toString()));
        } else {
            this.lastSubtitle = value;
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

    public void onDestroy() {
        SharedMediaLayout.SharedMediaPreloader sharedMediaPreloader = this.sharedMediaPreloader;
        if (sharedMediaPreloader != null) {
            sharedMediaPreloader.onDestroy(this.parentFragment);
        }
    }

    private void setTypingAnimation(boolean start) {
        int i = 0;
        if (start) {
            try {
                int iIntValue = MessagesController.getInstance(this.currentAccount).getPrintingStringType(this.parentFragment.getDialogId(), this.parentFragment.getThreadId()).intValue();
                if (iIntValue == 5) {
                    this.subtitleTextView.replaceTextWithDrawable(this.statusDrawables[iIntValue], "**oo**");
                    this.statusDrawables[iIntValue].setColor(getThemedColor("chat_status"));
                    this.subtitleTextView.setLeftDrawable((Drawable) null);
                } else {
                    this.subtitleTextView.replaceTextWithDrawable(null, null);
                    this.statusDrawables[iIntValue].setColor(getThemedColor("chat_status"));
                    this.subtitleTextView.setLeftDrawable(this.statusDrawables[iIntValue]);
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
            this.subtitleTextView.setLeftDrawable((Drawable) null);
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

    public void updateSubtitle(boolean animated) {
        String string;
        TLRPC$ChatParticipants tLRPC$ChatParticipants;
        int i;
        ChatActivity chatActivity = this.parentFragment;
        if (chatActivity == null) {
            return;
        }
        TLRPC$User currentUser = chatActivity.getCurrentUser();
        if (UserObject.isUserSelf(currentUser) || UserObject.isReplyUser(currentUser) || this.parentFragment.getChatMode() != 0) {
            if (this.subtitleTextView.getVisibility() != 8) {
                this.subtitleTextView.setVisibility(8);
                return;
            }
            return;
        }
        TLRPC$Chat currentChat = this.parentFragment.getCurrentChat();
        boolean z = false;
        CharSequence printingString = MessagesController.getInstance(this.currentAccount).getPrintingString(this.parentFragment.getDialogId(), this.parentFragment.getThreadId(), false);
        CharSequence userStatus = "";
        if (printingString != null) {
            printingString = TextUtils.replace(printingString, new String[]{"..."}, new String[]{""});
        }
        if (printingString == null || printingString.length() == 0 || (ChatObject.isChannel(currentChat) && !currentChat.megagroup)) {
            if (this.parentFragment.isThreadChat()) {
                if (this.titleTextView.getTag() != null) {
                    return;
                }
                this.titleTextView.setTag(1);
                AnimatorSet animatorSet = this.titleAnimation;
                if (animatorSet != null) {
                    animatorSet.cancel();
                    this.titleAnimation = null;
                }
                if (animated) {
                    AnimatorSet animatorSet2 = new AnimatorSet();
                    this.titleAnimation = animatorSet2;
                    animatorSet2.playTogether(ObjectAnimator.ofFloat(this.titleTextView, (Property<SimpleTextView, Float>) View.TRANSLATION_Y, AndroidUtilities.dp(9.7f)), ObjectAnimator.ofFloat(this.subtitleTextView, (Property<SimpleTextView, Float>) View.ALPHA, 0.0f));
                    this.titleAnimation.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.ChatAvatarContainer.4
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationCancel(Animator animation) {
                            ChatAvatarContainer.this.titleAnimation = null;
                        }

                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animation) {
                            if (ChatAvatarContainer.this.titleAnimation == animation) {
                                ChatAvatarContainer.this.subtitleTextView.setVisibility(4);
                                ChatAvatarContainer.this.titleAnimation = null;
                            }
                        }
                    });
                    this.titleAnimation.setDuration(180L);
                    this.titleAnimation.start();
                    return;
                }
                this.titleTextView.setTranslationY(AndroidUtilities.dp(9.7f));
                this.subtitleTextView.setAlpha(0.0f);
                this.subtitleTextView.setVisibility(4);
                return;
            }
            setTypingAnimation(false);
            if (currentChat != null) {
                TLRPC$ChatFull currentChatInfo = this.parentFragment.getCurrentChatInfo();
                if (ChatObject.isChannel(currentChat)) {
                    if (currentChatInfo != null && (i = currentChatInfo.participants_count) != 0) {
                        if (currentChat.megagroup) {
                            string = this.onlineCount > 1 ? String.format("%s, %s", LocaleController.formatPluralString("Members", i), LocaleController.formatPluralString("OnlineCount", Math.min(this.onlineCount, currentChatInfo.participants_count))) : LocaleController.formatPluralString("Members", i);
                        } else {
                            int[] iArr = new int[1];
                            String shortNumber = LocaleController.formatShortNumber(i, iArr);
                            if (currentChat.megagroup) {
                                string = LocaleController.formatPluralString("Members", iArr[0]).replace(String.format("%d", Integer.valueOf(iArr[0])), shortNumber);
                            } else {
                                string = LocaleController.formatPluralString("Subscribers", iArr[0]).replace(String.format("%d", Integer.valueOf(iArr[0])), shortNumber);
                            }
                        }
                    } else if (currentChat.megagroup) {
                        if (currentChatInfo == null) {
                            string = LocaleController.getString("Loading", R.string.Loading).toLowerCase();
                        } else if (currentChat.has_geo) {
                            string = LocaleController.getString("MegaLocation", R.string.MegaLocation).toLowerCase();
                        } else if (!TextUtils.isEmpty(currentChat.username)) {
                            string = LocaleController.getString("MegaPublic", R.string.MegaPublic).toLowerCase();
                        } else {
                            string = LocaleController.getString("MegaPrivate", R.string.MegaPrivate).toLowerCase();
                        }
                    } else if ((currentChat.flags & 64) != 0) {
                        string = LocaleController.getString("ChannelPublic", R.string.ChannelPublic).toLowerCase();
                    } else {
                        string = LocaleController.getString("ChannelPrivate", R.string.ChannelPrivate).toLowerCase();
                    }
                } else if (ChatObject.isKickedFromChat(currentChat)) {
                    string = LocaleController.getString("YouWereKicked", R.string.YouWereKicked);
                } else if (ChatObject.isLeftFromChat(currentChat)) {
                    string = LocaleController.getString("YouLeft", R.string.YouLeft);
                } else {
                    int size = currentChat.participants_count;
                    if (currentChatInfo != null && (tLRPC$ChatParticipants = currentChatInfo.participants) != null) {
                        size = tLRPC$ChatParticipants.participants.size();
                    }
                    string = (this.onlineCount <= 1 || size == 0) ? LocaleController.formatPluralString("Members", size) : String.format("%s, %s", LocaleController.formatPluralString("Members", size), LocaleController.formatPluralString("OnlineCount", this.onlineCount));
                }
            } else if (currentUser != null) {
                TLRPC$User user = MessagesController.getInstance(this.currentAccount).getUser(Long.valueOf(currentUser.id));
                if (user != null) {
                    currentUser = user;
                }
                if (!UserObject.isReplyUser(currentUser)) {
                    if (currentUser.id == UserConfig.getInstance(this.currentAccount).getClientUserId()) {
                        string = LocaleController.getString("ChatYourSelf", R.string.ChatYourSelf);
                    } else {
                        long j = currentUser.id;
                        if (j == 333000 || j == 777000 || j == 42777) {
                            string = LocaleController.getString("ServiceNotifications", R.string.ServiceNotifications);
                        } else if (MessagesController.isSupportUser(currentUser)) {
                            string = LocaleController.getString("SupportStatus", R.string.SupportStatus);
                        } else if (currentUser.bot) {
                            string = LocaleController.getString("Bot", R.string.Bot);
                        } else {
                            boolean[] zArr = this.isOnline;
                            zArr[0] = false;
                            userStatus = LocaleController.formatUserStatus(this.currentAccount, currentUser, zArr);
                            z = this.isOnline[0];
                        }
                    }
                }
            }
            userStatus = string;
        } else {
            if (this.parentFragment.isThreadChat() && this.titleTextView.getTag() != null) {
                this.titleTextView.setTag(null);
                this.subtitleTextView.setVisibility(0);
                AnimatorSet animatorSet3 = this.titleAnimation;
                if (animatorSet3 != null) {
                    animatorSet3.cancel();
                    this.titleAnimation = null;
                }
                if (animated) {
                    AnimatorSet animatorSet4 = new AnimatorSet();
                    this.titleAnimation = animatorSet4;
                    animatorSet4.playTogether(ObjectAnimator.ofFloat(this.titleTextView, (Property<SimpleTextView, Float>) View.TRANSLATION_Y, 0.0f), ObjectAnimator.ofFloat(this.subtitleTextView, (Property<SimpleTextView, Float>) View.ALPHA, 1.0f));
                    this.titleAnimation.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.ChatAvatarContainer.5
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animation) {
                            ChatAvatarContainer.this.titleAnimation = null;
                        }
                    });
                    this.titleAnimation.setDuration(180L);
                    this.titleAnimation.start();
                } else {
                    this.titleTextView.setTranslationY(0.0f);
                    this.subtitleTextView.setAlpha(1.0f);
                }
            }
            userStatus = MessagesController.getInstance(this.currentAccount).getPrintingStringType(this.parentFragment.getDialogId(), this.parentFragment.getThreadId()).intValue() == 5 ? Emoji.replaceEmoji(printingString, this.subtitleTextView.getTextPaint().getFontMetricsInt(), AndroidUtilities.dp(15.0f), false) : printingString;
            setTypingAnimation(true);
            z = true;
        }
        this.lastSubtitleColorKey = z ? "chat_status" : "actionBarDefaultSubtitle";
        if (this.lastSubtitle == null) {
            this.subtitleTextView.setText(AndroidUtilities.fixNumbers(userStatus.toString()));
            this.subtitleTextView.setTextColor(getThemedColor(this.lastSubtitleColorKey));
            this.subtitleTextView.setTag(this.lastSubtitleColorKey);
            return;
        }
        this.lastSubtitle = userStatus;
    }

    public void setChatAvatar(TLRPC$Chat chat) {
        this.avatarDrawable.setInfo(chat);
        BackupImageView backupImageView = this.avatarImageView;
        if (backupImageView != null) {
            backupImageView.setForUserOrChat(chat, this.avatarDrawable);
        }
    }

    public void setUserAvatar(TLRPC$User user) {
        setUserAvatar(user, false);
    }

    public void setUserAvatar(TLRPC$User user, boolean showSelf) {
        this.avatarDrawable.setInfo(user);
        if (UserObject.isReplyUser(user)) {
            this.avatarDrawable.setAvatarType(12);
            this.avatarDrawable.setSmallSize(true);
            BackupImageView backupImageView = this.avatarImageView;
            if (backupImageView != null) {
                backupImageView.setImage((ImageLocation) null, (String) null, this.avatarDrawable, user);
                return;
            }
            return;
        }
        if (UserObject.isUserSelf(user) && !showSelf) {
            this.avatarDrawable.setAvatarType(1);
            this.avatarDrawable.setSmallSize(true);
            BackupImageView backupImageView2 = this.avatarImageView;
            if (backupImageView2 != null) {
                backupImageView2.setImage((ImageLocation) null, (String) null, this.avatarDrawable, user);
                return;
            }
            return;
        }
        this.avatarDrawable.setSmallSize(false);
        BackupImageView backupImageView3 = this.avatarImageView;
        if (backupImageView3 != null) {
            backupImageView3.setForUserOrChat(user, this.avatarDrawable);
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
                    return;
                }
                return;
            }
            return;
        }
        this.avatarDrawable.setInfo(currentUser);
        if (UserObject.isReplyUser(currentUser)) {
            this.avatarDrawable.setSmallSize(true);
            this.avatarDrawable.setAvatarType(12);
            BackupImageView backupImageView2 = this.avatarImageView;
            if (backupImageView2 != null) {
                backupImageView2.setImage((ImageLocation) null, (String) null, this.avatarDrawable, currentUser);
                return;
            }
            return;
        }
        if (UserObject.isUserSelf(currentUser)) {
            this.avatarDrawable.setSmallSize(true);
            this.avatarDrawable.setAvatarType(1);
            BackupImageView backupImageView3 = this.avatarImageView;
            if (backupImageView3 != null) {
                backupImageView3.setImage((ImageLocation) null, (String) null, this.avatarDrawable, currentUser);
                return;
            }
            return;
        }
        this.avatarDrawable.setSmallSize(false);
        BackupImageView backupImageView4 = this.avatarImageView;
        if (backupImageView4 != null) {
            backupImageView4.setForUserOrChat(currentUser, this.avatarDrawable);
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
        if ((currentChatInfo instanceof TLRPC$TL_chatFull) || (((z = currentChatInfo instanceof TLRPC$TL_channelFull)) && currentChatInfo.participants_count <= 200 && currentChatInfo.participants != null)) {
            for (int i = 0; i < currentChatInfo.participants.participants.size(); i++) {
                TLRPC$User user = MessagesController.getInstance(this.currentAccount).getUser(Long.valueOf(currentChatInfo.participants.participants.get(i).user_id));
                if (user != null && (tLRPC$UserStatus = user.status) != null && ((tLRPC$UserStatus.expires > currentTime || user.id == UserConfig.getInstance(this.currentAccount).getClientUserId()) && user.status.expires > 10000)) {
                    this.onlineCount++;
                }
            }
            return;
        }
        if (!z || currentChatInfo.participants_count <= 200) {
            return;
        }
        this.onlineCount = currentChatInfo.online_count;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.parentFragment != null) {
            NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.didUpdateConnectionState);
            this.currentConnectionState = ConnectionsManager.getInstance(this.currentAccount).getConnectionState();
            updateCurrentConnectionState();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.parentFragment != null) {
            NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.didUpdateConnectionState);
        }
    }

    @Override // ir.eitaa.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int id, int account, Object... args) {
        int connectionState;
        if (id != NotificationCenter.didUpdateConnectionState || this.currentConnectionState == (connectionState = ConnectionsManager.getInstance(this.currentAccount).getConnectionState())) {
            return;
        }
        this.currentConnectionState = connectionState;
        updateCurrentConnectionState();
    }

    private void updateCurrentConnectionState() {
        String string;
        int i = this.currentConnectionState;
        if (i == 2) {
            string = LocaleController.getString("WaitingForNetwork", R.string.WaitingForNetwork);
        } else if (i == 1) {
            string = LocaleController.getString("Connecting", R.string.Connecting);
        } else if (i == 4) {
            string = LocaleController.getString("Updating", R.string.Updating);
        } else {
            string = i == 5 ? LocaleController.getString("ConnectingToProxy", R.string.ConnectingToProxy) : null;
        }
        if (string == null) {
            CharSequence charSequence = this.lastSubtitle;
            if (charSequence != null) {
                this.subtitleTextView.setText(AndroidUtilities.fixNumbers(charSequence.toString()));
                this.lastSubtitle = null;
                String str = this.lastSubtitleColorKey;
                if (str != null) {
                    this.subtitleTextView.setTextColor(getThemedColor(str));
                    this.subtitleTextView.setTag(this.lastSubtitleColorKey);
                    return;
                }
                return;
            }
            return;
        }
        if (this.lastSubtitle == null) {
            this.lastSubtitle = this.subtitleTextView.getText();
        }
        this.subtitleTextView.setText(AndroidUtilities.fixNumbers(string));
        this.subtitleTextView.setTextColor(getThemedColor("actionBarDefaultSubtitle"));
        this.subtitleTextView.setTag("actionBarDefaultSubtitle");
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        super.onInitializeAccessibilityNodeInfo(info);
        if (!info.isClickable() || Build.VERSION.SDK_INT < 21) {
            return;
        }
        info.addAction(new AccessibilityNodeInfo.AccessibilityAction(16, LocaleController.getString("OpenProfile", R.string.OpenProfile)));
    }

    public SharedMediaLayout.SharedMediaPreloader getSharedMediaPreloader() {
        return this.sharedMediaPreloader;
    }

    public BackupImageView getAvatarImageView() {
        return this.avatarImageView;
    }

    private int getThemedColor(String key) {
        Theme.ResourcesProvider resourcesProvider = this.resourcesProvider;
        Integer color = resourcesProvider != null ? resourcesProvider.getColor(key) : null;
        return color != null ? color.intValue() : Theme.getColor(key);
    }

    public void updateColors() {
        StatusDrawable statusDrawable = this.currentTypingDrawable;
        if (statusDrawable != null) {
            statusDrawable.setColor(getThemedColor("chat_status"));
        }
    }
}
