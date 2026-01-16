package org.rbmain.ui.Components;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Vibrator;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Property;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Keep;
import androidx.core.graphics.ColorUtils;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.medu.shad.R;
import java.util.ArrayList;
import java.util.HashMap;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ChatObject;
import org.rbmain.messenger.ContactsController;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.MediaController;
import org.rbmain.messenger.MediaDataController;
import org.rbmain.messenger.MessageObject;
import org.rbmain.messenger.MessagesController;
import org.rbmain.messenger.NotificationCenter;
import org.rbmain.messenger.NotificationsSettingsFacade;
import org.rbmain.messenger.SendMessagesHelper;
import org.rbmain.messenger.SharedConfig;
import org.rbmain.messenger.UserConfig;
import org.rbmain.tgnet.TLRPC$BotInlineResult;
import org.rbmain.tgnet.TLRPC$Chat;
import org.rbmain.tgnet.TLRPC$MessageMedia;
import org.rbmain.tgnet.TLRPC$TL_messageMediaPoll;
import org.rbmain.tgnet.TLRPC$User;
import org.rbmain.ui.ActionBar.ActionBar;
import org.rbmain.ui.ActionBar.ActionBarMenu;
import org.rbmain.ui.ActionBar.ActionBarMenuItem;
import org.rbmain.ui.ActionBar.ActionBarMenuSubItem;
import org.rbmain.ui.ActionBar.ActionBarPopupWindow;
import org.rbmain.ui.ActionBar.AdjustPanLayoutHelper;
import org.rbmain.ui.ActionBar.AlertDialog;
import org.rbmain.ui.ActionBar.BaseFragment;
import org.rbmain.ui.ActionBar.BottomSheet;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.ActionBar.ThemeDescription;
import org.rbmain.ui.ChatActivity;
import org.rbmain.ui.Components.AlertsCreator;
import org.rbmain.ui.Components.AnimationProperties;
import org.rbmain.ui.Components.ChatAttachAlert;
import org.rbmain.ui.Components.ChatAttachAlertAudioLayout;
import org.rbmain.ui.Components.ChatAttachAlertContactsLayout;
import org.rbmain.ui.Components.ChatAttachAlertDocumentLayout;
import org.rbmain.ui.Components.ChatAttachAlertLiveLayout;
import org.rbmain.ui.Components.ChatAttachAlertLocationLayout;
import org.rbmain.ui.Components.ChatAttachAlertPollLayout;
import org.rbmain.ui.Components.RecyclerListView;
import org.rbmain.ui.PassportActivity;
import org.rbmain.ui.PhotoPickerActivity;
import org.rbmain.ui.PhotoPickerSearchActivity;

/* loaded from: classes5.dex */
public class ChatAttachAlert extends BottomSheet implements NotificationCenter.NotificationCenterDelegate, BottomSheet.BottomSheetDelegateInterface {
    public final Property<AttachAlertLayout, Float> ATTACH_ALERT_LAYOUT_TRANSLATION;
    private final Property<ChatAttachAlert, Float> ATTACH_ALERT_PROGRESS;
    protected ActionBar actionBar;
    private AnimatorSet actionBarAnimation;
    private View actionBarShadow;
    protected boolean allowOrder;
    private Paint attachButtonPaint;
    private int attachItemSize;
    private ChatAttachAlertAudioLayout audioLayout;
    protected int avatarPicker;
    protected BaseFragment baseFragment;
    private float baseSelectedTextViewTranslationY;
    private float bottomPannelTranslation;
    private boolean buttonPressed;
    private ButtonsAdapter buttonsAdapter;
    private LinearLayoutManager buttonsLayoutManager;
    protected RecyclerListView buttonsRecyclerView;
    private float captionEditTextTopOffset;
    private final NumberTextView captionLimitView;
    private float chatActivityEnterViewAnimateFromTop;
    private int codepointCount;
    protected EditTextEmoji commentTextView;
    private AnimatorSet commentsAnimator;
    private ChatAttachAlertContactsLayout contactsLayout;
    protected float cornerRadius;
    protected int currentAccount;
    private AttachAlertLayout currentAttachLayout;
    private final int currentLimit;
    float currentPanTranslationY;
    protected ChatAttachViewDelegate delegate;
    private ChatAttachAlertDocumentLayout documentLayout;
    protected ActionBarMenuItem doneItem;
    protected MessageObject editingMessageObject;
    private boolean enterCommentEventSent;
    private ArrayList<android.graphics.Rect> exclusionRects;
    private android.graphics.Rect exclustionRect;
    private boolean forceDarkTheme;
    private FrameLayout frameLayout2;
    private float fromScrollY;
    protected boolean inBubbleMode;
    private ActionBarMenuSubItem[] itemCells;
    private AttachAlertLayout[] layouts;
    private ChatAttachAlertLiveLayout liveLayout;
    private ChatAttachAlertLocationLayout locationLayout;
    protected int maxSelectedPhotos;
    private boolean mediaEnabled;
    private AnimatorSet menuAnimator;
    private boolean menuShowed;
    private AttachAlertLayout nextAttachLayout;
    private boolean openTransitionFinished;
    protected boolean openWithFrontFaceCamera;
    private Paint paint;
    public ChatActivity.ThemeDelegate parentThemeDelegate;
    protected boolean paused;
    private ChatAttachAlertPhotoLayout photoLayout;
    private ChatAttachAlertPollLayout pollLayout;
    private boolean pollsEnabled;
    private int previousScrollOffsetY;
    private RectF rect;
    private boolean rtlLayout;
    protected int[] scrollOffsetY;
    protected ActionBarMenuItem searchItem;
    private View selectedCountView;
    private int selectedId;
    protected ActionBarMenuItem selectedMenuItem;
    protected TextView selectedTextView;
    private ValueAnimator sendButtonColorAnimator;
    boolean sendButtonEnabled;
    private float sendButtonEnabledProgress;
    private ActionBarPopupWindow.ActionBarPopupWindowLayout sendPopupLayout;
    private ActionBarPopupWindow sendPopupWindow;
    private View shadow;
    protected SizeNotifierFrameLayout sizeNotifierFrameLayout;
    private TextPaint textPaint;
    private float toScrollY;
    private ValueAnimator topBackgroundAnimator;
    public float translationProgress;
    protected boolean typeButtonsAvailable;
    private Object viewChangeAnimator;
    private ImageView writeButton;
    private FrameLayout writeButtonContainer;
    private Drawable writeButtonDrawable;

    public interface ChatAttachViewDelegate {

        /* renamed from: org.rbmain.ui.Components.ChatAttachAlert$ChatAttachViewDelegate$-CC, reason: invalid class name */
        public final /* synthetic */ class CC {
            public static void $default$openAvatarsSearch(ChatAttachViewDelegate chatAttachViewDelegate) {
            }
        }

        void didPressedButton(int i, boolean z, boolean z2, int i2, boolean z3);

        void didSelectBot(TLRPC$User tLRPC$User);

        void doOnIdle(Runnable runnable);

        boolean needEnterComment();

        void onCameraOpened();

        void openAvatarsSearch();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$new$10(View view, MotionEvent motionEvent) {
        return true;
    }

    @Override // org.rbmain.ui.ActionBar.BottomSheet.BottomSheetDelegateInterface
    public boolean canDismiss() {
        return true;
    }

    @Override // org.rbmain.ui.ActionBar.BottomSheet
    protected boolean canDismissWithSwipe() {
        return false;
    }

    public float getClipLayoutBottom() {
        return this.frameLayout2.getMeasuredHeight() - ((this.frameLayout2.getMeasuredHeight() - AndroidUtilities.dp(84.0f)) * (1.0f - this.frameLayout2.getAlpha()));
    }

    public static class AttachAlertLayout extends FrameLayout {
        protected ChatAttachAlert parentAlert;

        void applyCaption(String str) {
        }

        boolean canDismissWithTouchOutside() {
            return true;
        }

        boolean canScheduleMessages() {
            return true;
        }

        void checkColors() {
        }

        int getCurrentItemTop() {
            return 0;
        }

        int getFirstOffset() {
            return 0;
        }

        int getListTopPadding() {
            return 0;
        }

        int getSelectedItemsCount() {
            return 0;
        }

        ArrayList<ThemeDescription> getThemeDescriptions() {
            return null;
        }

        int needsActionBar() {
            return 0;
        }

        boolean onBackPressed() {
            return false;
        }

        void onButtonsTranslationYUpdated() {
        }

        void onContainerTranslationUpdated(float f) {
        }

        boolean onContainerViewTouchEvent(MotionEvent motionEvent) {
            return false;
        }

        void onDestroy() {
        }

        boolean onDismiss() {
            return false;
        }

        void onDismissWithButtonClick(int i) {
        }

        void onHidden() {
        }

        void onHide() {
        }

        void onHideShowProgress(float f) {
        }

        void onMenuItemClick(int i) {
        }

        void onOpenAnimationEnd() {
        }

        void onPause() {
        }

        void onPreMeasure(int i, int i2) {
        }

        void onResume() {
        }

        void onSelectedItemsCountChanged(int i) {
        }

        boolean onSheetKeyDown(int i, KeyEvent keyEvent) {
            return false;
        }

        void onShow() {
        }

        void onShown() {
        }

        void scrollToTop() {
        }

        void sendSelectedItems(boolean z, int i) {
        }

        public AttachAlertLayout(ChatAttachAlert chatAttachAlert, Context context) {
            super(context);
            this.parentAlert = chatAttachAlert;
        }

        int getButtonsHideOffset() {
            return AndroidUtilities.dp(needsActionBar() != 0 ? 12.0f : 17.0f);
        }
    }

    private class AttachButton extends FrameLayout {
        private int backgroundKey;
        private Animator checkAnimator;
        private boolean checked;
        private float checkedState;
        private int currentId;
        private RLottieImageView imageView;
        private int textKey;
        private TextView textView;

        @Override // android.view.View
        public boolean hasOverlappingRendering() {
            return false;
        }

        public AttachButton(Context context) {
            super(context);
            setWillNotDraw(false);
            RLottieImageView rLottieImageView = new RLottieImageView(context, ChatAttachAlert.this) { // from class: org.rbmain.ui.Components.ChatAttachAlert.AttachButton.1
                @Override // android.view.View
                public void setScaleX(float f) {
                    super.setScaleX(f);
                    AttachButton.this.invalidate();
                }
            };
            this.imageView = rLottieImageView;
            rLottieImageView.setScaleType(ImageView.ScaleType.CENTER);
            addView(this.imageView, LayoutHelper.createFrame(32, 32.0f, 49, 0.0f, 18.0f, 0.0f, 0.0f));
            TextView textView = new TextView(context);
            this.textView = textView;
            textView.setMaxLines(2);
            this.textView.setGravity(1);
            this.textView.setEllipsize(TextUtils.TruncateAt.END);
            this.textView.setTextColor(Theme.getColor(Theme.key_dialogTextGray2));
            this.textView.setTextSize(1, 12.0f);
            this.textView.setLineSpacing(-AndroidUtilities.dp(2.0f), 1.0f);
            addView(this.textView, LayoutHelper.createFrame(-1, -2.0f, 51, 0.0f, 62.0f, 0.0f, 0.0f));
        }

        void updateCheckedState(boolean z) {
            if (this.checked == (this.currentId == ChatAttachAlert.this.selectedId)) {
                return;
            }
            this.checked = this.currentId == ChatAttachAlert.this.selectedId;
            Animator animator = this.checkAnimator;
            if (animator != null) {
                animator.cancel();
            }
            if (z) {
                if (this.checked) {
                    this.imageView.setProgress(0.0f);
                    this.imageView.playAnimation();
                }
                float[] fArr = new float[1];
                fArr[0] = this.checked ? 1.0f : 0.0f;
                ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "checkedState", fArr);
                this.checkAnimator = objectAnimatorOfFloat;
                objectAnimatorOfFloat.setDuration(200L);
                this.checkAnimator.start();
                return;
            }
            this.imageView.stopAnimation();
            this.imageView.setProgress(0.0f);
            setCheckedState(this.checked ? 1.0f : 0.0f);
        }

        @Keep
        public void setCheckedState(float f) {
            this.checkedState = f;
            float f2 = 1.0f - (f * 0.06f);
            this.imageView.setScaleX(f2);
            this.imageView.setScaleY(f2);
            this.textView.setTextColor(ColorUtils.blendARGB(Theme.getColor(Theme.key_dialogTextGray2), Theme.getColor(this.textKey), this.checkedState));
            invalidate();
        }

        @Keep
        public float getCheckedState() {
            return this.checkedState;
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onAttachedToWindow() {
            super.onAttachedToWindow();
            updateCheckedState(false);
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int i, int i2) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(ChatAttachAlert.this.attachItemSize, 1073741824), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(84.0f), 1073741824));
        }

        public void setTextAndIcon(int i, CharSequence charSequence, RLottieDrawable rLottieDrawable, int i2, int i3) {
            this.currentId = i;
            this.textView.setText(charSequence);
            this.imageView.setAnimation(rLottieDrawable);
            this.backgroundKey = i2;
            this.textKey = i3;
            this.textView.setTextColor(ColorUtils.blendARGB(Theme.getColor(Theme.key_dialogTextGray2), Theme.getColor(this.textKey), this.checkedState));
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            float scaleX = this.imageView.getScaleX() + (this.checkedState * 0.06f);
            float fDp = AndroidUtilities.dp(23.0f) * scaleX;
            float left = this.imageView.getLeft() + (this.imageView.getMeasuredWidth() / 2);
            float top = this.imageView.getTop() + (this.imageView.getMeasuredWidth() / 2);
            ChatAttachAlert.this.attachButtonPaint.setColor(Theme.getColor(this.backgroundKey));
            ChatAttachAlert.this.attachButtonPaint.setStyle(Paint.Style.STROKE);
            ChatAttachAlert.this.attachButtonPaint.setStrokeWidth(AndroidUtilities.dp(3.0f) * scaleX);
            ChatAttachAlert.this.attachButtonPaint.setAlpha(Math.round(this.checkedState * 255.0f));
            canvas.drawCircle(left, top, fDp - (ChatAttachAlert.this.attachButtonPaint.getStrokeWidth() * 0.5f), ChatAttachAlert.this.attachButtonPaint);
            ChatAttachAlert.this.attachButtonPaint.setAlpha(255);
            ChatAttachAlert.this.attachButtonPaint.setStyle(Paint.Style.FILL);
            canvas.drawCircle(left, top, fDp - (AndroidUtilities.dp(5.0f) * this.checkedState), ChatAttachAlert.this.attachButtonPaint);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class AttachBotButton extends FrameLayout {
        private AvatarDrawable avatarDrawable;
        private TLRPC$User currentUser;
        private BackupImageView imageView;
        private TextView nameTextView;

        public AttachBotButton(Context context) {
            super(context);
            this.avatarDrawable = new AvatarDrawable();
            BackupImageView backupImageView = new BackupImageView(context);
            this.imageView = backupImageView;
            backupImageView.setRoundRadius(AndroidUtilities.dp(25.0f));
            addView(this.imageView, LayoutHelper.createFrame(46, 46.0f, 49, 0.0f, 9.0f, 0.0f, 0.0f));
            if (Build.VERSION.SDK_INT >= 21) {
                View view = new View(context);
                view.setBackgroundDrawable(Theme.createSelectorDrawable(Theme.getColor(Theme.key_dialogButtonSelector), 1, AndroidUtilities.dp(23.0f)));
                addView(view, LayoutHelper.createFrame(46, 46.0f, 49, 0.0f, 9.0f, 0.0f, 0.0f));
            }
            TextView textView = new TextView(context);
            this.nameTextView = textView;
            textView.setTextSize(1, 12.0f);
            this.nameTextView.setGravity(49);
            this.nameTextView.setLines(1);
            this.nameTextView.setSingleLine(true);
            this.nameTextView.setEllipsize(TextUtils.TruncateAt.END);
            addView(this.nameTextView, LayoutHelper.createFrame(-1, -2.0f, 51, 6.0f, 60.0f, 6.0f, 0.0f));
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int i, int i2) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(ChatAttachAlert.this.attachItemSize, 1073741824), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(100.0f), 1073741824));
        }

        public void setUser(TLRPC$User tLRPC$User) {
            if (tLRPC$User == null) {
                return;
            }
            this.nameTextView.setTextColor(Theme.getColor(Theme.key_dialogTextGray2));
            this.currentUser = tLRPC$User;
            this.nameTextView.setText(ContactsController.formatName(tLRPC$User.first_name, tLRPC$User.last_name));
            this.avatarDrawable.setInfo(tLRPC$User);
            this.imageView.setForUserOrChat(tLRPC$User, this.avatarDrawable);
            requestLayout();
        }
    }

    public ChatAttachAlert(Context context, BaseFragment baseFragment, boolean z, boolean z2) {
        this(context, baseFragment, z, z2, true, null);
    }

    public ChatAttachAlert(Context context, BaseFragment baseFragment, boolean z, boolean z2, boolean z3, Theme.ResourcesProvider resourcesProvider) {
        super(context, false);
        this.rtlLayout = true;
        this.ATTACH_ALERT_LAYOUT_TRANSLATION = new AnimationProperties.FloatProperty<AttachAlertLayout>("translation") { // from class: org.rbmain.ui.Components.ChatAttachAlert.1
            @Override // org.rbmain.ui.Components.AnimationProperties.FloatProperty
            public void setValue(AttachAlertLayout attachAlertLayout, float f) {
                if (f > 0.7f) {
                    float f2 = 1.0f - ((1.0f - f) / 0.3f);
                    if (ChatAttachAlert.this.nextAttachLayout == ChatAttachAlert.this.locationLayout) {
                        ChatAttachAlert.this.currentAttachLayout.setAlpha(1.0f - f2);
                        ChatAttachAlert.this.nextAttachLayout.setAlpha(1.0f);
                    } else {
                        ChatAttachAlert.this.nextAttachLayout.setAlpha(f2);
                        ChatAttachAlert.this.nextAttachLayout.onHideShowProgress(f2);
                    }
                } else if (ChatAttachAlert.this.nextAttachLayout == ChatAttachAlert.this.locationLayout) {
                    ChatAttachAlert.this.nextAttachLayout.setAlpha(0.0f);
                }
                if (ChatAttachAlert.this.nextAttachLayout == ChatAttachAlert.this.pollLayout || ChatAttachAlert.this.currentAttachLayout == ChatAttachAlert.this.pollLayout) {
                    ChatAttachAlert chatAttachAlert = ChatAttachAlert.this;
                    chatAttachAlert.updateSelectedPosition(chatAttachAlert.nextAttachLayout == ChatAttachAlert.this.pollLayout ? 1 : 0);
                }
                ChatAttachAlert.this.nextAttachLayout.setTranslationY(AndroidUtilities.dp(78.0f) * f);
                ChatAttachAlert.this.currentAttachLayout.onHideShowProgress(1.0f - Math.min(1.0f, f / 0.7f));
                ChatAttachAlert.this.currentAttachLayout.onContainerTranslationUpdated(ChatAttachAlert.this.currentPanTranslationY);
                ((BottomSheet) ChatAttachAlert.this).containerView.invalidate();
            }

            @Override // android.util.Property
            public Float get(AttachAlertLayout attachAlertLayout) {
                return Float.valueOf(ChatAttachAlert.this.translationProgress);
            }
        };
        this.layouts = new AttachAlertLayout[6];
        this.textPaint = new TextPaint(1);
        this.rect = new RectF();
        this.paint = new Paint(1);
        this.sendButtonEnabled = true;
        this.sendButtonEnabledProgress = 1.0f;
        this.cornerRadius = 1.0f;
        this.currentAccount = UserConfig.selectedAccount;
        this.mediaEnabled = true;
        this.pollsEnabled = true;
        this.maxSelectedPhotos = -1;
        this.allowOrder = true;
        this.attachItemSize = AndroidUtilities.dp(85.0f);
        new DecelerateInterpolator();
        this.scrollOffsetY = new int[2];
        this.attachButtonPaint = new Paint(1);
        this.exclusionRects = new ArrayList<>();
        this.exclustionRect = new android.graphics.Rect();
        this.ATTACH_ALERT_PROGRESS = new AnimationProperties.FloatProperty<ChatAttachAlert>("openProgress") { // from class: org.rbmain.ui.Components.ChatAttachAlert.18
            private float openProgress;

            @Override // org.rbmain.ui.Components.AnimationProperties.FloatProperty
            public void setValue(ChatAttachAlert chatAttachAlert, float f) {
                float interpolation;
                int childCount = ChatAttachAlert.this.buttonsRecyclerView.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    float f2 = (3 - i) * 32.0f;
                    View childAt = ChatAttachAlert.this.buttonsRecyclerView.getChildAt(i);
                    if (f > f2) {
                        float f3 = f - f2;
                        interpolation = 1.0f;
                        if (f3 <= 200.0f) {
                            float f4 = f3 / 200.0f;
                            interpolation = CubicBezierInterpolator.EASE_OUT.getInterpolation(f4) * 1.1f;
                            childAt.setAlpha(CubicBezierInterpolator.EASE_BOTH.getInterpolation(f4));
                        } else {
                            childAt.setAlpha(1.0f);
                            float f5 = f3 - 200.0f;
                            if (f5 <= 100.0f) {
                                interpolation = 1.1f - (CubicBezierInterpolator.EASE_IN.getInterpolation(f5 / 100.0f) * 0.1f);
                            }
                        }
                    } else {
                        interpolation = 0.0f;
                    }
                    if (childAt instanceof AttachButton) {
                        AttachButton attachButton = (AttachButton) childAt;
                        attachButton.textView.setScaleX(interpolation);
                        attachButton.textView.setScaleY(interpolation);
                        attachButton.imageView.setScaleX(interpolation);
                        attachButton.imageView.setScaleY(interpolation);
                    } else if (childAt instanceof AttachBotButton) {
                        AttachBotButton attachBotButton = (AttachBotButton) childAt;
                        attachBotButton.nameTextView.setScaleX(interpolation);
                        attachBotButton.nameTextView.setScaleY(interpolation);
                        attachBotButton.imageView.setScaleX(interpolation);
                        attachBotButton.imageView.setScaleY(interpolation);
                    }
                }
            }

            @Override // android.util.Property
            public Float get(ChatAttachAlert chatAttachAlert) {
                return Float.valueOf(this.openProgress);
            }
        };
        this.forceDarkTheme = z;
        this.drawNavigationBar = true;
        this.inBubbleMode = (baseFragment instanceof ChatActivity) && baseFragment.isInBubbleMode();
        this.openInterpolator = new OvershootInterpolator(0.7f);
        this.baseFragment = baseFragment;
        this.useSmoothKeyboard = true;
        setDelegate(this);
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.reloadInlineHints);
        this.exclusionRects.add(this.exclustionRect);
        AnonymousClass2 anonymousClass2 = new AnonymousClass2(context, z);
        this.sizeNotifierFrameLayout = anonymousClass2;
        this.containerView = anonymousClass2;
        anonymousClass2.setWillNotDraw(false);
        this.containerView.setClipChildren(false);
        ViewGroup viewGroup = this.containerView;
        int i = this.backgroundPaddingLeft;
        viewGroup.setPadding(i, 0, i, 0);
        ActionBar actionBar = new ActionBar(context) { // from class: org.rbmain.ui.Components.ChatAttachAlert.3
            @Override // android.view.View
            public void setAlpha(float f) {
                super.setAlpha(f);
                ((BottomSheet) ChatAttachAlert.this).containerView.invalidate();
                if (ChatAttachAlert.this.frameLayout2 != null) {
                    ChatAttachAlert chatAttachAlert = ChatAttachAlert.this;
                    if (chatAttachAlert.buttonsRecyclerView != null) {
                        if (chatAttachAlert.frameLayout2.getTag() != null) {
                            float f2 = f != 0.0f ? 0.0f : 1.0f;
                            if (ChatAttachAlert.this.buttonsRecyclerView.getAlpha() != f2) {
                                ChatAttachAlert.this.buttonsRecyclerView.setAlpha(f2);
                                return;
                            }
                            return;
                        }
                        float f3 = 1.0f - f;
                        ChatAttachAlert.this.buttonsRecyclerView.setAlpha(f3);
                        ChatAttachAlert.this.shadow.setAlpha(f3);
                        ChatAttachAlert.this.buttonsRecyclerView.setTranslationY(AndroidUtilities.dp(44.0f) * f);
                        ChatAttachAlert.this.frameLayout2.setTranslationY(AndroidUtilities.dp(48.0f) * f);
                        ChatAttachAlert.this.shadow.setTranslationY(AndroidUtilities.dp(84.0f) * f);
                    }
                }
            }
        };
        this.actionBar = actionBar;
        actionBar.setRtlLayout(this.rtlLayout);
        ActionBar actionBar2 = this.actionBar;
        int i2 = Theme.key_dialogBackground;
        actionBar2.setBackgroundColor(Theme.getColor(i2));
        this.actionBar.setBackButtonImage(R.drawable.ic_ab_back);
        ActionBar actionBar3 = this.actionBar;
        int i3 = Theme.key_dialogTextBlack;
        actionBar3.setItemsColor(Theme.getColor(i3), false);
        ActionBar actionBar4 = this.actionBar;
        int i4 = Theme.key_dialogButtonSelector;
        actionBar4.setItemsBackgroundColor(Theme.getColor(i4), false);
        this.actionBar.setTitleColor(Theme.getColor(i3));
        this.actionBar.setOccupyStatusBar(false);
        this.actionBar.setAlpha(0.0f);
        this.actionBar.setActionBarMenuOnItemClick(new ActionBar.ActionBarMenuOnItemClick() { // from class: org.rbmain.ui.Components.ChatAttachAlert.4
            @Override // org.rbmain.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
            public void onItemClick(int i5) {
                if (i5 == -1) {
                    if (ChatAttachAlert.this.currentAttachLayout.onBackPressed()) {
                        return;
                    }
                    ChatAttachAlert.this.dismiss();
                    return;
                }
                ChatAttachAlert.this.currentAttachLayout.onMenuItemClick(i5);
            }
        });
        ActionBarMenuItem actionBarMenuItem = new ActionBarMenuItem(context, null, 0, Theme.getColor(i3));
        this.selectedMenuItem = actionBarMenuItem;
        actionBarMenuItem.setRtlLayout(this.rtlLayout);
        this.selectedMenuItem.setLongClickEnabled(false);
        this.selectedMenuItem.setIcon(R.drawable.ic_ab_other);
        this.selectedMenuItem.setContentDescription(LocaleController.getString("AccDescrMoreOptions", R.string.AccDescrMoreOptions));
        this.selectedMenuItem.setVisibility(4);
        this.selectedMenuItem.setAlpha(0.0f);
        this.selectedMenuItem.setSubMenuOpenSide(2);
        this.selectedMenuItem.setDelegate(new ActionBarMenuItem.ActionBarMenuItemDelegate() { // from class: org.rbmain.ui.Components.ChatAttachAlert$$ExternalSyntheticLambda11
            @Override // org.rbmain.ui.ActionBar.ActionBarMenuItem.ActionBarMenuItemDelegate
            public final void onItemClick(int i5) {
                this.f$0.lambda$new$0(i5);
            }
        });
        this.selectedMenuItem.setAdditionalYOffset(AndroidUtilities.dp(72.0f));
        this.selectedMenuItem.setTranslationX(AndroidUtilities.dp(6.0f));
        this.selectedMenuItem.setBackgroundDrawable(Theme.createSelectorDrawable(Theme.getColor(i4), 6));
        this.selectedMenuItem.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.Components.ChatAttachAlert$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$new$1(view);
            }
        });
        ActionBarMenuItem actionBarMenuItem2 = new ActionBarMenuItem(context, (ActionBarMenu) null, 0, Theme.getColor(Theme.key_windowBackgroundWhiteBlueHeader), true);
        this.doneItem = actionBarMenuItem2;
        actionBarMenuItem2.setLongClickEnabled(false);
        this.doneItem.setText(LocaleController.getString("Create", R.string.Create).toUpperCase());
        this.doneItem.setVisibility(4);
        this.doneItem.setAlpha(0.0f);
        if (!isRtlLayout()) {
            this.doneItem.setTranslationX(-AndroidUtilities.dp(12.0f));
        }
        this.doneItem.setBackgroundDrawable(Theme.createSelectorDrawable(Theme.getColor(i4), 3));
        this.doneItem.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.Components.ChatAttachAlert$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$new$2(view);
            }
        });
        ActionBarMenuItem actionBarMenuItem3 = new ActionBarMenuItem(context, null, 0, Theme.getColor(i3));
        this.searchItem = actionBarMenuItem3;
        actionBarMenuItem3.setRtlLayout(this.rtlLayout);
        this.searchItem.setLongClickEnabled(false);
        this.searchItem.setIcon(R.drawable.ic_ab_search);
        this.searchItem.setContentDescription(LocaleController.getString("Search", R.string.Search));
        this.searchItem.setVisibility(4);
        this.searchItem.setAlpha(0.0f);
        this.searchItem.setTranslationX(-AndroidUtilities.dp(42.0f));
        this.searchItem.setBackgroundDrawable(Theme.createSelectorDrawable(Theme.getColor(i4), 6));
        this.searchItem.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.Components.ChatAttachAlert$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$new$3(view);
            }
        });
        TextView textView = new TextView(context) { // from class: org.rbmain.ui.Components.ChatAttachAlert.6
            @Override // android.view.View
            public void setAlpha(float f) {
                super.setAlpha(f);
                ChatAttachAlert.this.updateSelectedPosition(0);
                ((BottomSheet) ChatAttachAlert.this).containerView.invalidate();
            }

            @Override // android.view.View
            public void setTranslationY(float f) {
                super.setTranslationY(f);
            }
        };
        this.selectedTextView = textView;
        textView.setTextColor(Theme.getColor(i3));
        this.selectedTextView.setTextSize(1, 16.0f);
        this.selectedTextView.setTypeface(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM));
        this.selectedTextView.setGravity(isRtlLayout() ? 53 : 51);
        this.selectedTextView.setVisibility(4);
        this.selectedTextView.setAlpha(0.0f);
        AttachAlertLayout[] attachAlertLayoutArr = this.layouts;
        ChatAttachAlertPhotoLayout chatAttachAlertPhotoLayout = new ChatAttachAlertPhotoLayout(this, context, z);
        this.photoLayout = chatAttachAlertPhotoLayout;
        attachAlertLayoutArr[0] = chatAttachAlertPhotoLayout;
        this.currentAttachLayout = chatAttachAlertPhotoLayout;
        this.selectedId = 1;
        this.containerView.addView(chatAttachAlertPhotoLayout, LayoutHelper.createFrame(-1, -1.0f));
        this.containerView.addView(this.selectedTextView, LayoutHelper.createFrame(-1, -2.0f, isRtlLayout() ? 53 : 51, isRtlLayout() ? 48.0f : 23.0f, 0.0f, isRtlLayout() ? 23.0f : 48.0f, 0.0f));
        this.containerView.addView(this.actionBar, LayoutHelper.createFrame(-1, -2.0f));
        this.containerView.addView(this.selectedMenuItem, LayoutHelper.createFrame(48, 48, (isRtlLayout() ? 3 : 5) | 48));
        this.containerView.addView(this.searchItem, LayoutHelper.createFrame(48, 48, (isRtlLayout() ? 3 : 5) | 48));
        this.containerView.addView(this.doneItem, LayoutHelper.createFrame(-2, 48, (isRtlLayout() ? 3 : 5) | 48));
        View view = new View(context);
        this.actionBarShadow = view;
        view.setAlpha(0.0f);
        this.actionBarShadow.setBackgroundColor(Theme.getColor(Theme.key_dialogShadowLine));
        this.containerView.addView(this.actionBarShadow, LayoutHelper.createFrame(-1, 1.0f));
        View view2 = new View(context);
        this.shadow = view2;
        view2.setBackgroundResource(R.drawable.attach_shadow);
        this.shadow.getBackground().setColorFilter(new PorterDuffColorFilter(-16777216, PorterDuff.Mode.MULTIPLY));
        this.containerView.addView(this.shadow, LayoutHelper.createFrame(-1, 2.0f, 83, 0.0f, 0.0f, 0.0f, 84.0f));
        RecyclerListView recyclerListView = new RecyclerListView(context) { // from class: org.rbmain.ui.Components.ChatAttachAlert.7
            @Override // org.rbmain.ui.Components.RecyclerListView, android.view.View
            public void setTranslationY(float f) {
                super.setTranslationY(f);
                ChatAttachAlert.this.currentAttachLayout.onButtonsTranslationYUpdated();
            }
        };
        this.buttonsRecyclerView = recyclerListView;
        ButtonsAdapter buttonsAdapter = new ButtonsAdapter(context);
        this.buttonsAdapter = buttonsAdapter;
        recyclerListView.setAdapter(buttonsAdapter);
        RecyclerListView recyclerListView2 = this.buttonsRecyclerView;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, 0, false);
        this.buttonsLayoutManager = linearLayoutManager;
        recyclerListView2.setLayoutManager(linearLayoutManager);
        this.buttonsRecyclerView.setVerticalScrollBarEnabled(false);
        this.buttonsRecyclerView.setHorizontalScrollBarEnabled(false);
        this.buttonsRecyclerView.setItemAnimator(null);
        this.buttonsRecyclerView.setLayoutAnimation(null);
        this.buttonsRecyclerView.setGlowColor(Theme.getColor(Theme.key_dialogScrollGlow));
        this.buttonsRecyclerView.setBackgroundColor(Theme.getColor(i2));
        this.containerView.addView(this.buttonsRecyclerView, LayoutHelper.createFrame(-1, 84, 83));
        this.buttonsRecyclerView.setOnItemClickListener(new RecyclerListView.OnItemClickListener() { // from class: org.rbmain.ui.Components.ChatAttachAlert$$ExternalSyntheticLambda20
            @Override // org.rbmain.ui.Components.RecyclerListView.OnItemClickListener
            public final void onItemClick(View view3, int i5) {
                this.f$0.lambda$new$7(view3, i5);
            }
        });
        this.buttonsRecyclerView.setOnItemLongClickListener(new RecyclerListView.OnItemLongClickListener() { // from class: org.rbmain.ui.Components.ChatAttachAlert$$ExternalSyntheticLambda21
            @Override // org.rbmain.ui.Components.RecyclerListView.OnItemLongClickListener
            public final boolean onItemClick(View view3, int i5) {
                return this.f$0.lambda$new$9(view3, i5);
            }
        });
        AnonymousClass8 anonymousClass8 = new AnonymousClass8(context, z);
        this.frameLayout2 = anonymousClass8;
        anonymousClass8.setWillNotDraw(false);
        this.frameLayout2.setVisibility(4);
        this.frameLayout2.setAlpha(0.0f);
        this.containerView.addView(this.frameLayout2, LayoutHelper.createFrame(-1, -2, 83));
        this.frameLayout2.setOnTouchListener(new View.OnTouchListener() { // from class: org.rbmain.ui.Components.ChatAttachAlert$$ExternalSyntheticLambda7
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view3, MotionEvent motionEvent) {
                return ChatAttachAlert.lambda$new$10(view3, motionEvent);
            }
        });
        NumberTextView numberTextView = new NumberTextView(context);
        this.captionLimitView = numberTextView;
        numberTextView.setVisibility(8);
        numberTextView.setTextSize(15);
        numberTextView.setTextColor(Theme.getColor(Theme.key_windowBackgroundWhiteGrayText));
        numberTextView.setTypeface(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM));
        numberTextView.setCenterAlign(true);
        this.frameLayout2.addView(numberTextView, LayoutHelper.createFrame(56, 20.0f, 85, 3.0f, 0.0f, 14.0f, 78.0f));
        this.currentLimit = MessagesController.getInstance(UserConfig.selectedAccount).maxCaptionLength;
        AnonymousClass9 anonymousClass9 = new AnonymousClass9(context, this.sizeNotifierFrameLayout, null, 1);
        this.commentTextView = anonymousClass9;
        anonymousClass9.getEditText().setGravity((LocaleController.isRTL ? 5 : 3) | 16);
        this.commentTextView.setHint(LocaleController.getString("AddCaption", R.string.AddCaption));
        this.commentTextView.onResume();
        this.commentTextView.getEditText().addTextChangedListener(new AnonymousClass10());
        this.frameLayout2.addView(this.commentTextView, LayoutHelper.createFrame(-1, -2.0f, 83, 0.0f, 0.0f, 84.0f, 0.0f));
        this.frameLayout2.setClipChildren(false);
        this.commentTextView.setClipChildren(false);
        FrameLayout frameLayout = new FrameLayout(context) { // from class: org.rbmain.ui.Components.ChatAttachAlert.11
            @Override // android.view.View
            public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
                super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
                if (ChatAttachAlert.this.currentAttachLayout == ChatAttachAlert.this.photoLayout) {
                    accessibilityNodeInfo.setText(LocaleController.formatPluralString("AccDescrSendPhotos", ChatAttachAlert.this.photoLayout.getSelectedItemsCount()));
                } else if (ChatAttachAlert.this.currentAttachLayout == ChatAttachAlert.this.documentLayout) {
                    accessibilityNodeInfo.setText(LocaleController.formatPluralString("AccDescrSendFiles", ChatAttachAlert.this.documentLayout.getSelectedItemsCount()));
                } else if (ChatAttachAlert.this.currentAttachLayout == ChatAttachAlert.this.audioLayout) {
                    accessibilityNodeInfo.setText(LocaleController.formatPluralString("AccDescrSendAudio", ChatAttachAlert.this.audioLayout.getSelectedItemsCount()));
                }
                accessibilityNodeInfo.setClassName(Button.class.getName());
                accessibilityNodeInfo.setLongClickable(true);
                accessibilityNodeInfo.setClickable(true);
            }
        };
        this.writeButtonContainer = frameLayout;
        frameLayout.setFocusable(true);
        this.writeButtonContainer.setFocusableInTouchMode(true);
        this.writeButtonContainer.setVisibility(4);
        this.writeButtonContainer.setScaleX(0.2f);
        this.writeButtonContainer.setScaleY(0.2f);
        this.writeButtonContainer.setAlpha(0.0f);
        this.containerView.addView(this.writeButtonContainer, LayoutHelper.createFrame(60, 60.0f, 85, 0.0f, 0.0f, 6.0f, 10.0f));
        this.writeButton = new ImageView(context);
        int iDp = AndroidUtilities.dp(56.0f);
        int i5 = Theme.key_dialogFloatingButton;
        int color = Theme.getColor(i5);
        int i6 = Build.VERSION.SDK_INT;
        this.writeButtonDrawable = Theme.createSimpleSelectorCircleDrawable(iDp, color, Theme.getColor(i6 >= 21 ? Theme.key_dialogFloatingButtonPressed : i5));
        if (i6 < 21) {
            Drawable drawableMutate = context.getResources().getDrawable(R.drawable.floating_shadow_profile).mutate();
            drawableMutate.setColorFilter(new PorterDuffColorFilter(-16777216, PorterDuff.Mode.MULTIPLY));
            CombinedDrawable combinedDrawable = new CombinedDrawable(drawableMutate, this.writeButtonDrawable, 0, 0);
            combinedDrawable.setIconSize(AndroidUtilities.dp(56.0f), AndroidUtilities.dp(56.0f));
            this.writeButtonDrawable = combinedDrawable;
        }
        this.writeButton.setBackgroundDrawable(this.writeButtonDrawable);
        this.writeButton.setImageResource(R.drawable.attach_send);
        this.writeButton.setColorFilter(new PorterDuffColorFilter(Theme.getColor(Theme.key_dialogFloatingIcon), PorterDuff.Mode.MULTIPLY));
        this.writeButton.setImportantForAccessibility(2);
        this.writeButton.setScaleType(ImageView.ScaleType.CENTER);
        if (i6 >= 21) {
            this.writeButton.setOutlineProvider(new ViewOutlineProvider(this) { // from class: org.rbmain.ui.Components.ChatAttachAlert.12
                @Override // android.view.ViewOutlineProvider
                public void getOutline(View view3, Outline outline) {
                    outline.setOval(0, 0, AndroidUtilities.dp(56.0f), AndroidUtilities.dp(56.0f));
                }
            });
        }
        this.writeButtonContainer.addView(this.writeButton, LayoutHelper.createFrame(i6 >= 21 ? 56 : 60, i6 >= 21 ? 56.0f : 60.0f, 51, i6 >= 21 ? 2.0f : 0.0f, 0.0f, 0.0f, 0.0f));
        this.writeButton.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.Components.ChatAttachAlert$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                this.f$0.lambda$new$12(view3);
            }
        });
        this.writeButton.setOnLongClickListener(new View.OnLongClickListener() { // from class: org.rbmain.ui.Components.ChatAttachAlert$$ExternalSyntheticLambda6
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view3) {
                return this.f$0.lambda$new$16(view3);
            }
        });
        this.textPaint.setTextSize(AndroidUtilities.dp(12.0f));
        this.textPaint.setTypeface(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM));
        View view3 = new View(context) { // from class: org.rbmain.ui.Components.ChatAttachAlert.14
            @Override // android.view.View
            protected void onDraw(Canvas canvas) {
                String str = String.format("%d", Integer.valueOf(Math.max(1, ChatAttachAlert.this.currentAttachLayout.getSelectedItemsCount())));
                int iMax = Math.max(AndroidUtilities.dp(16.0f) + ((int) Math.ceil(ChatAttachAlert.this.textPaint.measureText(str))), AndroidUtilities.dp(24.0f));
                int measuredWidth = getMeasuredWidth() / 2;
                int color2 = Theme.getColor(Theme.key_dialogRoundCheckBoxCheck);
                TextPaint textPaint = ChatAttachAlert.this.textPaint;
                double dAlpha = Color.alpha(color2);
                double d = ChatAttachAlert.this.sendButtonEnabledProgress;
                Double.isNaN(d);
                Double.isNaN(dAlpha);
                textPaint.setColor(ColorUtils.setAlphaComponent(color2, (int) (dAlpha * ((d * 0.42d) + 0.58d))));
                ChatAttachAlert.this.paint.setColor(Theme.getColor(Theme.key_dialogBackground));
                int i7 = iMax / 2;
                ChatAttachAlert.this.rect.set(measuredWidth - i7, 0.0f, i7 + measuredWidth, getMeasuredHeight());
                canvas.drawRoundRect(ChatAttachAlert.this.rect, AndroidUtilities.dp(12.0f), AndroidUtilities.dp(12.0f), ChatAttachAlert.this.paint);
                ChatAttachAlert.this.paint.setColor(Theme.getColor(Theme.key_dialogRoundCheckBox));
                ChatAttachAlert.this.rect.set(r5 + AndroidUtilities.dp(2.0f), AndroidUtilities.dp(2.0f), r2 - AndroidUtilities.dp(2.0f), getMeasuredHeight() - AndroidUtilities.dp(2.0f));
                canvas.drawRoundRect(ChatAttachAlert.this.rect, AndroidUtilities.dp(10.0f), AndroidUtilities.dp(10.0f), ChatAttachAlert.this.paint);
                canvas.drawText(str, measuredWidth - (r1 / 2), AndroidUtilities.dp(16.2f), ChatAttachAlert.this.textPaint);
            }
        };
        this.selectedCountView = view3;
        view3.setAlpha(0.0f);
        this.selectedCountView.setScaleX(0.2f);
        this.selectedCountView.setScaleY(0.2f);
        this.containerView.addView(this.selectedCountView, LayoutHelper.createFrame(42, 24.0f, 85, 0.0f, 0.0f, -8.0f, 9.0f));
        if (z) {
            checkColors();
            this.navBarColorKey = -1;
        }
    }

    /* renamed from: org.rbmain.ui.Components.ChatAttachAlert$2, reason: invalid class name */
    class AnonymousClass2 extends SizeNotifierFrameLayout {
        AdjustPanLayoutHelper adjustPanLayoutHelper;
        private boolean ignoreLayout;
        private float initialTranslationY;
        private int lastNotifyWidth;
        private RectF rect;
        final /* synthetic */ boolean val$forceDarkTheme;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Context context, boolean z) {
            super(context);
            this.val$forceDarkTheme = z;
            this.rect = new RectF();
            this.adjustPanLayoutHelper = new AdjustPanLayoutHelper(this) { // from class: org.rbmain.ui.Components.ChatAttachAlert.2.1
                /* JADX WARN: Removed duplicated region for block: B:8:0x0037  */
                @Override // org.rbmain.ui.ActionBar.AdjustPanLayoutHelper
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                protected void onTransitionStart(boolean r4, int r5) {
                    /*
                        r3 = this;
                        super.onTransitionStart(r4, r5)
                        org.rbmain.ui.Components.ChatAttachAlert$2 r5 = org.rbmain.ui.Components.ChatAttachAlert.AnonymousClass2.this
                        org.rbmain.ui.Components.ChatAttachAlert r5 = org.rbmain.ui.Components.ChatAttachAlert.this
                        int r5 = org.rbmain.ui.Components.ChatAttachAlert.access$900(r5)
                        if (r5 <= 0) goto L37
                        org.rbmain.ui.Components.ChatAttachAlert$2 r5 = org.rbmain.ui.Components.ChatAttachAlert.AnonymousClass2.this
                        org.rbmain.ui.Components.ChatAttachAlert r5 = org.rbmain.ui.Components.ChatAttachAlert.this
                        int r5 = org.rbmain.ui.Components.ChatAttachAlert.access$900(r5)
                        org.rbmain.ui.Components.ChatAttachAlert$2 r0 = org.rbmain.ui.Components.ChatAttachAlert.AnonymousClass2.this
                        org.rbmain.ui.Components.ChatAttachAlert r0 = org.rbmain.ui.Components.ChatAttachAlert.this
                        int[] r1 = r0.scrollOffsetY
                        r2 = 0
                        r1 = r1[r2]
                        if (r5 == r1) goto L37
                        if (r4 == 0) goto L37
                        int r4 = org.rbmain.ui.Components.ChatAttachAlert.access$900(r0)
                        float r4 = (float) r4
                        org.rbmain.ui.Components.ChatAttachAlert.access$1002(r0, r4)
                        org.rbmain.ui.Components.ChatAttachAlert$2 r4 = org.rbmain.ui.Components.ChatAttachAlert.AnonymousClass2.this
                        org.rbmain.ui.Components.ChatAttachAlert r4 = org.rbmain.ui.Components.ChatAttachAlert.this
                        int[] r5 = r4.scrollOffsetY
                        r5 = r5[r2]
                        float r5 = (float) r5
                        org.rbmain.ui.Components.ChatAttachAlert.access$1102(r4, r5)
                        goto L40
                    L37:
                        org.rbmain.ui.Components.ChatAttachAlert$2 r4 = org.rbmain.ui.Components.ChatAttachAlert.AnonymousClass2.this
                        org.rbmain.ui.Components.ChatAttachAlert r4 = org.rbmain.ui.Components.ChatAttachAlert.this
                        r5 = -1082130432(0xffffffffbf800000, float:-1.0)
                        org.rbmain.ui.Components.ChatAttachAlert.access$1002(r4, r5)
                    L40:
                        org.rbmain.ui.Components.ChatAttachAlert$2 r4 = org.rbmain.ui.Components.ChatAttachAlert.AnonymousClass2.this
                        r4.invalidate()
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.Components.ChatAttachAlert.AnonymousClass2.AnonymousClass1.onTransitionStart(boolean, int):void");
                }

                @Override // org.rbmain.ui.ActionBar.AdjustPanLayoutHelper
                protected void onTransitionEnd() {
                    super.onTransitionEnd();
                    ChatAttachAlert chatAttachAlert = ChatAttachAlert.this;
                    chatAttachAlert.updateLayout(chatAttachAlert.currentAttachLayout, false, 0);
                    ChatAttachAlert chatAttachAlert2 = ChatAttachAlert.this;
                    chatAttachAlert2.previousScrollOffsetY = chatAttachAlert2.scrollOffsetY[0];
                }

                @Override // org.rbmain.ui.ActionBar.AdjustPanLayoutHelper
                protected void onPanTranslationUpdate(float f, float f2, boolean z2) {
                    ChatAttachAlert chatAttachAlert = ChatAttachAlert.this;
                    chatAttachAlert.currentPanTranslationY = f;
                    if (chatAttachAlert.fromScrollY > 0.0f) {
                        ChatAttachAlert chatAttachAlert2 = ChatAttachAlert.this;
                        chatAttachAlert2.currentPanTranslationY += (chatAttachAlert2.fromScrollY - ChatAttachAlert.this.toScrollY) * (1.0f - f2);
                    }
                    ChatAttachAlert chatAttachAlert3 = ChatAttachAlert.this;
                    chatAttachAlert3.actionBar.setTranslationY(chatAttachAlert3.currentPanTranslationY);
                    ChatAttachAlert chatAttachAlert4 = ChatAttachAlert.this;
                    chatAttachAlert4.selectedMenuItem.setTranslationY(chatAttachAlert4.currentPanTranslationY);
                    ChatAttachAlert chatAttachAlert5 = ChatAttachAlert.this;
                    chatAttachAlert5.searchItem.setTranslationY(chatAttachAlert5.currentPanTranslationY);
                    ChatAttachAlert chatAttachAlert6 = ChatAttachAlert.this;
                    chatAttachAlert6.doneItem.setTranslationY(chatAttachAlert6.currentPanTranslationY);
                    ChatAttachAlert.this.actionBarShadow.setTranslationY(ChatAttachAlert.this.currentPanTranslationY);
                    ChatAttachAlert.this.updateSelectedPosition(0);
                    ChatAttachAlert chatAttachAlert7 = ChatAttachAlert.this;
                    chatAttachAlert7.setCurrentPanTranslationY(chatAttachAlert7.currentPanTranslationY);
                    AnonymousClass2.this.invalidate();
                    ChatAttachAlert.this.frameLayout2.invalidate();
                    if (ChatAttachAlert.this.currentAttachLayout != null) {
                        ChatAttachAlert.this.currentAttachLayout.onContainerTranslationUpdated(ChatAttachAlert.this.currentPanTranslationY);
                    }
                }

                @Override // org.rbmain.ui.ActionBar.AdjustPanLayoutHelper
                protected boolean heightAnimationEnabled() {
                    if (ChatAttachAlert.this.isDismissed() || !ChatAttachAlert.this.openTransitionFinished) {
                        return false;
                    }
                    return !ChatAttachAlert.this.commentTextView.isPopupVisible();
                }
            };
        }

        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (ChatAttachAlert.this.currentAttachLayout.onContainerViewTouchEvent(motionEvent)) {
                return true;
            }
            if (motionEvent.getAction() == 0 && ChatAttachAlert.this.scrollOffsetY[0] != 0) {
                float y = motionEvent.getY();
                ChatAttachAlert chatAttachAlert = ChatAttachAlert.this;
                if (y < chatAttachAlert.scrollOffsetY[0] && chatAttachAlert.actionBar.getAlpha() == 0.0f) {
                    ChatAttachAlert.this.dismiss();
                    return true;
                }
            }
            return super.onInterceptTouchEvent(motionEvent);
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            if (ChatAttachAlert.this.currentAttachLayout.onContainerViewTouchEvent(motionEvent)) {
                return true;
            }
            return !ChatAttachAlert.this.isDismissed() && super.onTouchEvent(motionEvent);
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int i, int i2) {
            int size;
            if (getLayoutParams().height > 0) {
                size = getLayoutParams().height;
            } else {
                size = View.MeasureSpec.getSize(i2);
            }
            if (Build.VERSION.SDK_INT >= 21) {
                ChatAttachAlert chatAttachAlert = ChatAttachAlert.this;
                if (!chatAttachAlert.inBubbleMode) {
                    this.ignoreLayout = true;
                    setPadding(((BottomSheet) chatAttachAlert).backgroundPaddingLeft, AndroidUtilities.statusBarHeight, ((BottomSheet) ChatAttachAlert.this).backgroundPaddingLeft, 0);
                    this.ignoreLayout = false;
                }
            }
            getPaddingTop();
            int size2 = View.MeasureSpec.getSize(i) - (((BottomSheet) ChatAttachAlert.this).backgroundPaddingLeft * 2);
            if (AndroidUtilities.isTablet()) {
                ChatAttachAlert.this.selectedMenuItem.setAdditionalYOffset(-AndroidUtilities.dp(3.0f));
            } else {
                android.graphics.Point point = AndroidUtilities.displaySize;
                if (point.x > point.y) {
                    ChatAttachAlert.this.selectedMenuItem.setAdditionalYOffset(0);
                } else {
                    ChatAttachAlert.this.selectedMenuItem.setAdditionalYOffset(-AndroidUtilities.dp(3.0f));
                }
            }
            ((FrameLayout.LayoutParams) ChatAttachAlert.this.actionBarShadow.getLayoutParams()).topMargin = ActionBar.getCurrentActionBarHeight();
            ((FrameLayout.LayoutParams) ChatAttachAlert.this.doneItem.getLayoutParams()).height = ActionBar.getCurrentActionBarHeight();
            this.ignoreLayout = true;
            int iMin = (int) (size2 / Math.min(4.5f, ChatAttachAlert.this.buttonsAdapter.getItemCount()));
            if (ChatAttachAlert.this.attachItemSize != iMin) {
                ChatAttachAlert.this.attachItemSize = iMin;
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.Components.ChatAttachAlert$2$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onMeasure$0();
                    }
                });
            }
            this.ignoreLayout = false;
            onMeasureInternal(i, View.MeasureSpec.makeMeasureSpec(size, 1073741824));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onMeasure$0() {
            ChatAttachAlert.this.buttonsAdapter.notifyDataSetChanged();
        }

        private void onMeasureInternal(int i, int i2) {
            int size = View.MeasureSpec.getSize(i);
            int size2 = View.MeasureSpec.getSize(i2);
            setMeasuredDimension(size, size2);
            int i3 = size - (((BottomSheet) ChatAttachAlert.this).backgroundPaddingLeft * 2);
            int iMeasureKeyboardHeight = SharedConfig.smoothKeyboard ? 0 : measureKeyboardHeight();
            if (!ChatAttachAlert.this.commentTextView.isWaitingForKeyboardOpen() && iMeasureKeyboardHeight <= AndroidUtilities.dp(20.0f) && !ChatAttachAlert.this.commentTextView.isPopupShowing() && !ChatAttachAlert.this.commentTextView.isAnimatePopupClosing()) {
                this.ignoreLayout = true;
                ChatAttachAlert.this.commentTextView.hideEmojiView();
                this.ignoreLayout = false;
            }
            if (iMeasureKeyboardHeight <= AndroidUtilities.dp(20.0f)) {
                int emojiPadding = (SharedConfig.smoothKeyboard && ((BottomSheet) ChatAttachAlert.this).keyboardVisible) ? 0 : ChatAttachAlert.this.commentTextView.getEmojiPadding();
                if (!AndroidUtilities.isInMultiwindow) {
                    size2 -= emojiPadding;
                    i2 = View.MeasureSpec.makeMeasureSpec(size2, 1073741824);
                }
                this.ignoreLayout = true;
                ChatAttachAlert.this.currentAttachLayout.onPreMeasure(i3, size2);
                if (ChatAttachAlert.this.nextAttachLayout != null) {
                    ChatAttachAlert.this.nextAttachLayout.onPreMeasure(i3, size2);
                }
                this.ignoreLayout = false;
            }
            int childCount = getChildCount();
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = getChildAt(i4);
                if (childAt != null && childAt.getVisibility() != 8) {
                    EditTextEmoji editTextEmoji = ChatAttachAlert.this.commentTextView;
                    if (editTextEmoji != null && editTextEmoji.isPopupView(childAt)) {
                        if (ChatAttachAlert.this.inBubbleMode) {
                            childAt.measure(View.MeasureSpec.makeMeasureSpec(i3, 1073741824), View.MeasureSpec.makeMeasureSpec(getPaddingTop() + size2, 1073741824));
                        } else if (AndroidUtilities.isInMultiwindow || AndroidUtilities.isTablet()) {
                            if (AndroidUtilities.isTablet()) {
                                childAt.measure(View.MeasureSpec.makeMeasureSpec(i3, 1073741824), View.MeasureSpec.makeMeasureSpec(Math.min(AndroidUtilities.dp(AndroidUtilities.isTablet() ? 200.0f : 320.0f), (size2 - AndroidUtilities.statusBarHeight) + getPaddingTop()), 1073741824));
                            } else {
                                childAt.measure(View.MeasureSpec.makeMeasureSpec(i3, 1073741824), View.MeasureSpec.makeMeasureSpec((size2 - AndroidUtilities.statusBarHeight) + getPaddingTop(), 1073741824));
                            }
                        } else {
                            childAt.measure(View.MeasureSpec.makeMeasureSpec(i3, 1073741824), View.MeasureSpec.makeMeasureSpec(childAt.getLayoutParams().height, 1073741824));
                        }
                    } else {
                        measureChildWithMargins(childAt, i, 0, i2, 0);
                    }
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:42:0x00ca  */
        /* JADX WARN: Removed duplicated region for block: B:49:0x00e4  */
        /* JADX WARN: Removed duplicated region for block: B:53:0x00f7  */
        /* JADX WARN: Removed duplicated region for block: B:57:0x0103  */
        /* JADX WARN: Removed duplicated region for block: B:58:0x010c  */
        @Override // org.rbmain.ui.Components.SizeNotifierFrameLayout, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        protected void onLayout(boolean r11, int r12, int r13, int r14, int r15) {
            /*
                Method dump skipped, instructions count: 309
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.Components.ChatAttachAlert.AnonymousClass2.onLayout(boolean, int, int, int, int):void");
        }

        @Override // android.view.View, android.view.ViewParent
        public void requestLayout() {
            if (this.ignoreLayout) {
                return;
            }
            super.requestLayout();
        }

        /* JADX WARN: Removed duplicated region for block: B:38:0x0103  */
        @Override // android.view.ViewGroup
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        protected boolean drawChild(android.graphics.Canvas r19, android.view.View r20, long r21) {
            /*
                Method dump skipped, instructions count: 682
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.Components.ChatAttachAlert.AnonymousClass2.drawChild(android.graphics.Canvas, android.view.View, long):boolean");
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            if (ChatAttachAlert.this.inBubbleMode) {
                return;
            }
            int color = Theme.getColor(this.val$forceDarkTheme ? Theme.key_voipgroup_listViewBackground : Theme.key_dialogBackground);
            Theme.dialogs_onlineCirclePaint.setColor(Color.argb((int) (ChatAttachAlert.this.actionBar.getAlpha() * 255.0f), (int) (Color.red(color) * 0.8f), (int) (Color.green(color) * 0.8f), (int) (Color.blue(color) * 0.8f)));
            canvas.drawRect(((BottomSheet) ChatAttachAlert.this).backgroundPaddingLeft, ChatAttachAlert.this.currentPanTranslationY, getMeasuredWidth() - ((BottomSheet) ChatAttachAlert.this).backgroundPaddingLeft, AndroidUtilities.statusBarHeight + ChatAttachAlert.this.currentPanTranslationY, Theme.dialogs_onlineCirclePaint);
        }

        @Override // org.rbmain.ui.Components.SizeNotifierFrameLayout, android.view.ViewGroup, android.view.View
        protected void dispatchDraw(Canvas canvas) {
            canvas.save();
            canvas.clipRect(0.0f, getPaddingTop() + ChatAttachAlert.this.currentPanTranslationY, getMeasuredWidth(), getMeasuredHeight() + ChatAttachAlert.this.currentPanTranslationY);
            super.dispatchDraw(canvas);
            canvas.restore();
        }

        @Override // android.view.View
        public void setTranslationY(float f) {
            ChatAttachAlert chatAttachAlert = ChatAttachAlert.this;
            float f2 = f + chatAttachAlert.currentPanTranslationY;
            if (((BottomSheet) chatAttachAlert).currentSheetAnimationType == 0) {
                this.initialTranslationY = f2;
            }
            if (((BottomSheet) ChatAttachAlert.this).currentSheetAnimationType == 1) {
                if (f2 < 0.0f) {
                    ChatAttachAlert.this.currentAttachLayout.setTranslationY(f2);
                    ChatAttachAlert chatAttachAlert2 = ChatAttachAlert.this;
                    if (chatAttachAlert2.avatarPicker != 0) {
                        chatAttachAlert2.selectedTextView.setTranslationY((chatAttachAlert2.baseSelectedTextViewTranslationY + f2) - ChatAttachAlert.this.currentPanTranslationY);
                    }
                    ChatAttachAlert.this.buttonsRecyclerView.setTranslationY(0.0f);
                    f2 = 0.0f;
                } else {
                    ChatAttachAlert.this.currentAttachLayout.setTranslationY(0.0f);
                    ChatAttachAlert.this.buttonsRecyclerView.setTranslationY((-f2) + (r0.getMeasuredHeight() * (f2 / this.initialTranslationY)));
                }
                ((BottomSheet) ChatAttachAlert.this).containerView.invalidate();
            }
            super.setTranslationY(f2 - ChatAttachAlert.this.currentPanTranslationY);
            if (((BottomSheet) ChatAttachAlert.this).currentSheetAnimationType != 1) {
                ChatAttachAlert.this.currentAttachLayout.onContainerTranslationUpdated(ChatAttachAlert.this.currentPanTranslationY);
            }
        }

        @Override // org.rbmain.ui.Components.SizeNotifierFrameLayout, android.view.ViewGroup, android.view.View
        protected void onAttachedToWindow() {
            super.onAttachedToWindow();
            this.adjustPanLayoutHelper.setResizableView(this);
            this.adjustPanLayoutHelper.onAttach();
            ChatAttachAlert.this.commentTextView.setAdjustPanLayoutHelper(this.adjustPanLayoutHelper);
        }

        @Override // org.rbmain.ui.Components.SizeNotifierFrameLayout, android.view.ViewGroup, android.view.View
        protected void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            this.adjustPanLayoutHelper.onDetach();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(int i) {
        this.actionBar.getActionBarMenuOnItemClick().onItemClick(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$1(View view) {
        this.selectedMenuItem.toggleSubMenu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$2(View view) {
        this.currentAttachLayout.onMenuItemClick(40);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$3(View view) {
        if (this.avatarPicker != 0) {
            this.delegate.openAvatarsSearch();
            dismiss();
            return;
        }
        final HashMap map = new HashMap();
        final ArrayList arrayList = new ArrayList();
        PhotoPickerSearchActivity photoPickerSearchActivity = new PhotoPickerSearchActivity(map, arrayList, 0, true, (ChatActivity) this.baseFragment);
        photoPickerSearchActivity.setDelegate(new PhotoPickerActivity.PhotoPickerActivityDelegate() { // from class: org.rbmain.ui.Components.ChatAttachAlert.5
            private boolean sendPressed;

            @Override // org.rbmain.ui.PhotoPickerActivity.PhotoPickerActivityDelegate
            public void onCaptionChanged(CharSequence charSequence) {
            }

            @Override // org.rbmain.ui.PhotoPickerActivity.PhotoPickerActivityDelegate
            public /* synthetic */ void onOpenInPressed() {
                PhotoPickerActivity.PhotoPickerActivityDelegate.CC.$default$onOpenInPressed(this);
            }

            @Override // org.rbmain.ui.PhotoPickerActivity.PhotoPickerActivityDelegate
            public void selectedPhotosChanged() {
            }

            @Override // org.rbmain.ui.PhotoPickerActivity.PhotoPickerActivityDelegate
            public void actionButtonPressed(boolean z, boolean z2, int i) {
                if (z || map.isEmpty() || this.sendPressed) {
                    return;
                }
                this.sendPressed = true;
                ArrayList<SendMessagesHelper.SendingMediaInfo> arrayList2 = new ArrayList<>();
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    Object obj = map.get(arrayList.get(i2));
                    SendMessagesHelper.SendingMediaInfo sendingMediaInfo = new SendMessagesHelper.SendingMediaInfo();
                    arrayList2.add(sendingMediaInfo);
                    MediaController.SearchImage searchImage = (MediaController.SearchImage) obj;
                    String str = searchImage.imagePath;
                    if (str != null) {
                        sendingMediaInfo.path = str;
                    } else {
                        sendingMediaInfo.searchImage = searchImage;
                    }
                    sendingMediaInfo.thumbPath = searchImage.thumbPath;
                    sendingMediaInfo.videoEditedInfo = searchImage.editedInfo;
                    CharSequence charSequence = searchImage.caption;
                    sendingMediaInfo.caption = charSequence != null ? charSequence.toString() : null;
                    sendingMediaInfo.entities = searchImage.entities;
                    sendingMediaInfo.masks = searchImage.stickers;
                    sendingMediaInfo.ttl = searchImage.ttl;
                    TLRPC$BotInlineResult tLRPC$BotInlineResult = searchImage.inlineResult;
                    if (tLRPC$BotInlineResult != null && searchImage.type == 1) {
                        sendingMediaInfo.inlineResult = tLRPC$BotInlineResult;
                        sendingMediaInfo.params = searchImage.params;
                    }
                    searchImage.date = (int) (System.currentTimeMillis() / 1000);
                }
                ((ChatActivity) ChatAttachAlert.this.baseFragment).didSelectSearchPhotos(arrayList2, z2, i);
            }
        });
        photoPickerSearchActivity.setMaxSelectedPhotos(this.maxSelectedPhotos, this.allowOrder);
        this.baseFragment.presentFragment(photoPickerSearchActivity);
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$7(View view, int i) {
        if (this.baseFragment.getParentActivity() == null) {
            return;
        }
        if (view instanceof AttachButton) {
            final int iIntValue = ((Integer) view.getTag()).intValue();
            if (iIntValue == 1) {
                showLayout(this.photoLayout);
            } else if (iIntValue == 3) {
                if (Build.VERSION.SDK_INT >= 23 && this.baseFragment.getParentActivity().checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") != 0) {
                    this.baseFragment.getParentActivity().requestPermissions(new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, 4);
                    return;
                }
                openAudioLayout(true);
            } else if (iIntValue == 4) {
                if (Build.VERSION.SDK_INT >= 23 && this.baseFragment.getParentActivity().checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") != 0) {
                    this.baseFragment.getParentActivity().requestPermissions(new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, 4);
                    return;
                }
                openDocumentsLayout(true);
            } else if (iIntValue == 5) {
                if (Build.VERSION.SDK_INT >= 23 && this.baseFragment.getParentActivity().checkSelfPermission("android.permission.READ_CONTACTS") != 0) {
                    this.baseFragment.getParentActivity().requestPermissions(new String[]{"android.permission.READ_CONTACTS"}, 5);
                    return;
                }
                openContactsLayout();
            } else if (iIntValue == 6) {
                if (!AndroidUtilities.isGoogleMapsInstalled(this.baseFragment)) {
                    return;
                }
                if (this.locationLayout == null) {
                    AttachAlertLayout[] attachAlertLayoutArr = this.layouts;
                    ChatAttachAlertLocationLayout chatAttachAlertLocationLayout = new ChatAttachAlertLocationLayout(this, getContext());
                    this.locationLayout = chatAttachAlertLocationLayout;
                    attachAlertLayoutArr[5] = chatAttachAlertLocationLayout;
                    chatAttachAlertLocationLayout.setDelegate(new ChatAttachAlertLocationLayout.LocationActivityDelegate() { // from class: org.rbmain.ui.Components.ChatAttachAlert$$ExternalSyntheticLambda18
                        @Override // org.rbmain.ui.Components.ChatAttachAlertLocationLayout.LocationActivityDelegate
                        public final void didSelectLocation(TLRPC$MessageMedia tLRPC$MessageMedia, int i2, boolean z, int i3) {
                            this.f$0.lambda$new$4(tLRPC$MessageMedia, i2, z, i3);
                        }
                    });
                }
                showLayout(this.locationLayout);
            } else if (iIntValue == 9) {
                if (this.pollLayout == null) {
                    AttachAlertLayout[] attachAlertLayoutArr2 = this.layouts;
                    ChatAttachAlertPollLayout chatAttachAlertPollLayout = new ChatAttachAlertPollLayout(this, getContext());
                    this.pollLayout = chatAttachAlertPollLayout;
                    attachAlertLayoutArr2[1] = chatAttachAlertPollLayout;
                    chatAttachAlertPollLayout.setDelegate(new ChatAttachAlertPollLayout.PollCreateActivityDelegate() { // from class: org.rbmain.ui.Components.ChatAttachAlert$$ExternalSyntheticLambda19
                        @Override // org.rbmain.ui.Components.ChatAttachAlertPollLayout.PollCreateActivityDelegate
                        public final void sendPoll(TLRPC$TL_messageMediaPoll tLRPC$TL_messageMediaPoll, HashMap map, boolean z, int i2) {
                            this.f$0.lambda$new$5(tLRPC$TL_messageMediaPoll, map, z, i2);
                        }
                    });
                }
                showLayout(this.pollLayout);
            } else if (iIntValue == 10) {
                if (this.liveLayout == null) {
                    this.liveLayout = new ChatAttachAlertLiveLayout(this, getContext(), new ChatAttachAlertLiveLayout.ChatAttachAlertLiveDelegate() { // from class: org.rbmain.ui.Components.ChatAttachAlert$$ExternalSyntheticLambda17
                        @Override // org.rbmain.ui.Components.ChatAttachAlertLiveLayout.ChatAttachAlertLiveDelegate
                        public final void onStartLive() {
                            this.f$0.lambda$new$6(iIntValue);
                        }
                    });
                }
                showLayout(this.liveLayout);
            } else {
                this.delegate.didPressedButton(((Integer) view.getTag()).intValue(), true, true, 0, false);
            }
            int left = view.getLeft();
            int right = view.getRight();
            int iDp = AndroidUtilities.dp(10.0f);
            int i2 = left - iDp;
            if (i2 < 0) {
                this.buttonsRecyclerView.smoothScrollBy(i2, 0);
                return;
            }
            int i3 = right + iDp;
            if (i3 > this.buttonsRecyclerView.getMeasuredWidth()) {
                RecyclerListView recyclerListView = this.buttonsRecyclerView;
                recyclerListView.smoothScrollBy(i3 - recyclerListView.getMeasuredWidth(), 0);
                return;
            }
            return;
        }
        if (view instanceof AttachBotButton) {
            this.delegate.didSelectBot(((AttachBotButton) view).currentUser);
            dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$4(TLRPC$MessageMedia tLRPC$MessageMedia, int i, boolean z, int i2) {
        ((ChatActivity) this.baseFragment).didSelectLocation(tLRPC$MessageMedia, i, z, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$5(TLRPC$TL_messageMediaPoll tLRPC$TL_messageMediaPoll, HashMap map, boolean z, int i) {
        ((ChatActivity) this.baseFragment).sendPoll(tLRPC$TL_messageMediaPoll, map, z, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$6(int i) {
        this.delegate.didPressedButton(i, true, true, 0, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$new$9(View view, int i) {
        if (view instanceof AttachBotButton) {
            final AttachBotButton attachBotButton = (AttachBotButton) view;
            if (this.baseFragment != null && attachBotButton.currentUser != null) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setTitle(LocaleController.getString("AppName", R.string.AppName));
                builder.setMessage(LocaleController.formatString("ChatHintsDelete", R.string.ChatHintsDelete, ContactsController.formatName(attachBotButton.currentUser.first_name, attachBotButton.currentUser.last_name)));
                builder.setPositiveButton(LocaleController.getString("OK", R.string.OK), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.Components.ChatAttachAlert$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$new$8(attachBotButton, dialogInterface, i2);
                    }
                });
                builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
                builder.show();
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$8(AttachBotButton attachBotButton, DialogInterface dialogInterface, int i) {
        MediaDataController.getInstance(this.currentAccount).removeInline(attachBotButton.currentUser.id);
    }

    /* renamed from: org.rbmain.ui.Components.ChatAttachAlert$8, reason: invalid class name */
    class AnonymousClass8 extends FrameLayout {
        private int color;
        private final Paint p;
        final /* synthetic */ boolean val$forceDarkTheme;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass8(Context context, boolean z) {
            super(context);
            this.val$forceDarkTheme = z;
            this.p = new Paint();
        }

        @Override // android.view.View
        public void setAlpha(float f) {
            super.setAlpha(f);
            invalidate();
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            if (ChatAttachAlert.this.chatActivityEnterViewAnimateFromTop != 0.0f && ChatAttachAlert.this.chatActivityEnterViewAnimateFromTop != ChatAttachAlert.this.frameLayout2.getTop() + ChatAttachAlert.this.chatActivityEnterViewAnimateFromTop) {
                if (ChatAttachAlert.this.topBackgroundAnimator != null) {
                    ChatAttachAlert.this.topBackgroundAnimator.cancel();
                }
                ChatAttachAlert chatAttachAlert = ChatAttachAlert.this;
                chatAttachAlert.captionEditTextTopOffset = chatAttachAlert.chatActivityEnterViewAnimateFromTop - (ChatAttachAlert.this.frameLayout2.getTop() + ChatAttachAlert.this.captionEditTextTopOffset);
                ChatAttachAlert chatAttachAlert2 = ChatAttachAlert.this;
                chatAttachAlert2.topBackgroundAnimator = ValueAnimator.ofFloat(chatAttachAlert2.captionEditTextTopOffset, 0.0f);
                ChatAttachAlert.this.topBackgroundAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: org.rbmain.ui.Components.ChatAttachAlert$8$$ExternalSyntheticLambda0
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        this.f$0.lambda$onDraw$0(valueAnimator);
                    }
                });
                ChatAttachAlert.this.topBackgroundAnimator.setInterpolator(CubicBezierInterpolator.DEFAULT);
                ChatAttachAlert.this.topBackgroundAnimator.setDuration(200L);
                ChatAttachAlert.this.topBackgroundAnimator.start();
                ChatAttachAlert.this.chatActivityEnterViewAnimateFromTop = 0.0f;
            }
            float measuredHeight = (ChatAttachAlert.this.frameLayout2.getMeasuredHeight() - AndroidUtilities.dp(84.0f)) * (1.0f - getAlpha());
            View view = ChatAttachAlert.this.shadow;
            float f = (-(ChatAttachAlert.this.frameLayout2.getMeasuredHeight() - AndroidUtilities.dp(84.0f))) + ChatAttachAlert.this.captionEditTextTopOffset;
            ChatAttachAlert chatAttachAlert3 = ChatAttachAlert.this;
            view.setTranslationY(f + chatAttachAlert3.currentPanTranslationY + chatAttachAlert3.bottomPannelTranslation + measuredHeight);
            int color = Theme.getColor(this.val$forceDarkTheme ? Theme.key_voipgroup_listViewBackground : Theme.key_dialogBackground);
            if (this.color != color) {
                this.color = color;
                this.p.setColor(color);
            }
            canvas.drawRect(0.0f, ChatAttachAlert.this.captionEditTextTopOffset, getMeasuredWidth(), getMeasuredHeight(), this.p);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onDraw$0(ValueAnimator valueAnimator) {
            ChatAttachAlert.this.captionEditTextTopOffset = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            ChatAttachAlert.this.frameLayout2.invalidate();
            invalidate();
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void dispatchDraw(Canvas canvas) {
            canvas.save();
            canvas.clipRect(0.0f, ChatAttachAlert.this.captionEditTextTopOffset, getMeasuredWidth(), getMeasuredHeight());
            super.dispatchDraw(canvas);
            canvas.restore();
        }
    }

    /* renamed from: org.rbmain.ui.Components.ChatAttachAlert$9, reason: invalid class name */
    class AnonymousClass9 extends EditTextEmoji {
        private ValueAnimator messageEditTextAnimator;
        private int messageEditTextPredrawHeigth;
        private int messageEditTextPredrawScrollY;
        private boolean shouldAnimateEditTextWithBounds;

        AnonymousClass9(Context context, SizeNotifierFrameLayout sizeNotifierFrameLayout, BaseFragment baseFragment, int i) {
            super(context, sizeNotifierFrameLayout, baseFragment, i);
        }

        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (!ChatAttachAlert.this.enterCommentEventSent) {
                if (motionEvent.getX() > ChatAttachAlert.this.commentTextView.getEditText().getLeft() && motionEvent.getX() < ChatAttachAlert.this.commentTextView.getEditText().getRight() && motionEvent.getY() > ChatAttachAlert.this.commentTextView.getEditText().getTop() && motionEvent.getY() < ChatAttachAlert.this.commentTextView.getEditText().getBottom()) {
                    ChatAttachAlert chatAttachAlert = ChatAttachAlert.this;
                    chatAttachAlert.makeFocusable(chatAttachAlert.commentTextView.getEditText(), true);
                } else {
                    ChatAttachAlert chatAttachAlert2 = ChatAttachAlert.this;
                    chatAttachAlert2.makeFocusable(chatAttachAlert2.commentTextView.getEditText(), false);
                }
            }
            return super.onInterceptTouchEvent(motionEvent);
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void dispatchDraw(Canvas canvas) {
            if (this.shouldAnimateEditTextWithBounds) {
                final EditTextCaption editText = ChatAttachAlert.this.commentTextView.getEditText();
                editText.setOffsetY(editText.getOffsetY() - ((this.messageEditTextPredrawHeigth - editText.getMeasuredHeight()) + (this.messageEditTextPredrawScrollY - editText.getScrollY())));
                ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(editText.getOffsetY(), 0.0f);
                valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: org.rbmain.ui.Components.ChatAttachAlert$9$$ExternalSyntheticLambda0
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        ChatAttachAlert.AnonymousClass9.lambda$dispatchDraw$0(editText, valueAnimator);
                    }
                });
                ValueAnimator valueAnimator = this.messageEditTextAnimator;
                if (valueAnimator != null) {
                    valueAnimator.cancel();
                }
                this.messageEditTextAnimator = valueAnimatorOfFloat;
                valueAnimatorOfFloat.setDuration(200L);
                valueAnimatorOfFloat.setInterpolator(CubicBezierInterpolator.DEFAULT);
                valueAnimatorOfFloat.start();
                this.shouldAnimateEditTextWithBounds = false;
            }
            super.dispatchDraw(canvas);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$dispatchDraw$0(EditTextCaption editTextCaption, ValueAnimator valueAnimator) {
            editTextCaption.setOffsetY(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }

        @Override // org.rbmain.ui.Components.EditTextEmoji
        protected void onLineCountChanged(int i, int i2) {
            if (!TextUtils.isEmpty(getEditText().getText())) {
                this.shouldAnimateEditTextWithBounds = true;
                this.messageEditTextPredrawHeigth = getEditText().getMeasuredHeight();
                this.messageEditTextPredrawScrollY = getEditText().getScrollY();
                invalidate();
            } else {
                getEditText().animate().cancel();
                getEditText().setOffsetY(0.0f);
                this.shouldAnimateEditTextWithBounds = false;
            }
            ChatAttachAlert.this.chatActivityEnterViewAnimateFromTop = r2.frameLayout2.getTop() + ChatAttachAlert.this.captionEditTextTopOffset;
            ChatAttachAlert.this.frameLayout2.invalidate();
        }

        @Override // org.rbmain.ui.Components.EditTextEmoji
        protected void bottomPanelTranslationY(float f) {
            ChatAttachAlert.this.bottomPannelTranslation = f;
            ChatAttachAlert.this.frameLayout2.setTranslationY(f);
            ChatAttachAlert.this.writeButtonContainer.setTranslationY(f);
            ChatAttachAlert.this.selectedCountView.setTranslationY(f);
            ChatAttachAlert.this.frameLayout2.invalidate();
            ChatAttachAlert chatAttachAlert = ChatAttachAlert.this;
            chatAttachAlert.updateLayout(chatAttachAlert.currentAttachLayout, true, 0);
        }
    }

    /* renamed from: org.rbmain.ui.Components.ChatAttachAlert$10, reason: invalid class name */
    class AnonymousClass10 implements TextWatcher {
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        AnonymousClass10() {
        }

        /* JADX WARN: Removed duplicated region for block: B:24:0x00f8  */
        /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
        @Override // android.text.TextWatcher
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void afterTextChanged(android.text.Editable r10) {
            /*
                Method dump skipped, instructions count: 323
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.Components.ChatAttachAlert.AnonymousClass10.afterTextChanged(android.text.Editable):void");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$afterTextChanged$0(ValueAnimator valueAnimator) {
            ChatAttachAlert.this.sendButtonEnabledProgress = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            ChatAttachAlert.this.writeButton.setColorFilter(new PorterDuffColorFilter(ColorUtils.setAlphaComponent(Theme.getColor(Theme.key_dialogFloatingIcon), (int) (Color.alpha(r6) * ((ChatAttachAlert.this.sendButtonEnabledProgress * 0.42f) + 0.58f))), PorterDuff.Mode.MULTIPLY));
            ChatAttachAlert.this.selectedCountView.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$12(View view) {
        if (this.currentLimit - this.codepointCount < 0) {
            AndroidUtilities.shakeView(this.captionLimitView, 2.0f, 0);
            Vibrator vibrator = (Vibrator) this.captionLimitView.getContext().getSystemService("vibrator");
            if (vibrator != null) {
                vibrator.vibrate(200L);
                return;
            }
            return;
        }
        if (this.editingMessageObject == null) {
            BaseFragment baseFragment = this.baseFragment;
            if ((baseFragment instanceof ChatActivity) && ((ChatActivity) baseFragment).isInScheduleMode()) {
                AlertsCreator.createScheduleDatePickerDialog(getContext(), ((ChatActivity) this.baseFragment).getDialogId(), new AlertsCreator.ScheduleDatePickerDelegate() { // from class: org.rbmain.ui.Components.ChatAttachAlert$$ExternalSyntheticLambda13
                    @Override // org.rbmain.ui.Components.AlertsCreator.ScheduleDatePickerDelegate
                    public final void didSelectDate(boolean z, int i) {
                        this.f$0.lambda$new$11(z, i);
                    }
                });
                return;
            }
        }
        AttachAlertLayout attachAlertLayout = this.currentAttachLayout;
        if (attachAlertLayout == this.photoLayout) {
            sendPressed(true, 0);
        } else {
            attachAlertLayout.sendSelectedItems(true, 0);
            dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$11(boolean z, int i) {
        AttachAlertLayout attachAlertLayout = this.currentAttachLayout;
        if (attachAlertLayout == this.photoLayout) {
            sendPressed(z, i);
        } else {
            attachAlertLayout.sendSelectedItems(z, i);
            dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0070  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ boolean lambda$new$16(android.view.View r12) {
        /*
            Method dump skipped, instructions count: 396
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.Components.ChatAttachAlert.lambda$new$16(android.view.View):boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$13(KeyEvent keyEvent) {
        ActionBarPopupWindow actionBarPopupWindow;
        if (keyEvent.getKeyCode() == 4 && keyEvent.getRepeatCount() == 0 && (actionBarPopupWindow = this.sendPopupWindow) != null && actionBarPopupWindow.isShowing()) {
            this.sendPopupWindow.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$15(int i, ChatActivity chatActivity, View view) {
        ActionBarPopupWindow actionBarPopupWindow = this.sendPopupWindow;
        if (actionBarPopupWindow != null && actionBarPopupWindow.isShowing()) {
            this.sendPopupWindow.dismiss();
        }
        if (i == 0) {
            AlertsCreator.createScheduleDatePickerDialog(getContext(), chatActivity.getDialogId(), new AlertsCreator.ScheduleDatePickerDelegate() { // from class: org.rbmain.ui.Components.ChatAttachAlert$$ExternalSyntheticLambda14
                @Override // org.rbmain.ui.Components.AlertsCreator.ScheduleDatePickerDelegate
                public final void didSelectDate(boolean z, int i2) {
                    this.f$0.lambda$new$14(z, i2);
                }
            });
            return;
        }
        if (i == 1) {
            AttachAlertLayout attachAlertLayout = this.currentAttachLayout;
            if (attachAlertLayout == this.photoLayout) {
                sendPressed(false, 0);
            } else {
                attachAlertLayout.sendSelectedItems(false, 0);
                dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$14(boolean z, int i) {
        AttachAlertLayout attachAlertLayout = this.currentAttachLayout;
        if (attachAlertLayout == this.photoLayout) {
            sendPressed(z, i);
        } else {
            attachAlertLayout.sendSelectedItems(z, i);
            dismiss();
        }
    }

    private boolean isRtlLayout() {
        return LocaleController.isRTL && this.rtlLayout;
    }

    @Override // org.rbmain.ui.ActionBar.BottomSheet, android.app.Dialog
    public void show() {
        super.show();
        this.buttonPressed = false;
        BaseFragment baseFragment = this.baseFragment;
        if (baseFragment instanceof ChatActivity) {
            this.calcMandatoryInsets = ((ChatActivity) baseFragment).isKeyboardVisible();
        }
        this.openTransitionFinished = false;
    }

    public void setEditingMessageObject(MessageObject messageObject) {
        if (this.editingMessageObject == messageObject) {
            return;
        }
        this.editingMessageObject = messageObject;
        if (messageObject != null) {
            this.maxSelectedPhotos = 1;
            this.allowOrder = false;
        } else {
            this.maxSelectedPhotos = -1;
            this.allowOrder = true;
        }
        this.buttonsAdapter.notifyDataSetChanged();
    }

    public MessageObject getEditingMessageObject() {
        return this.editingMessageObject;
    }

    protected void applyCaption() {
        if (this.commentTextView.length() <= 0) {
            return;
        }
        this.currentAttachLayout.applyCaption(this.commentTextView.getText().toString());
    }

    private void sendPressed(boolean z, int i) {
        if (this.buttonPressed) {
            return;
        }
        BaseFragment baseFragment = this.baseFragment;
        if (baseFragment instanceof ChatActivity) {
            ChatActivity chatActivity = (ChatActivity) baseFragment;
            TLRPC$Chat currentChat = chatActivity.getCurrentChat();
            if (chatActivity.getCurrentUser() != null || ((ChatObject.isChannel(currentChat) && currentChat.megagroup) || !ChatObject.isChannel(currentChat))) {
                MessagesController.getNotificationsSettings(this.currentAccount).edit().putBoolean(NotificationsSettingsFacade.PROPERTY_SILENT + chatActivity.getDialogId(), !z).apply();
            }
        }
        applyCaption();
        this.buttonPressed = true;
        this.delegate.didPressedButton(7, true, z, i, false);
    }

    private void showLayout(AttachAlertLayout attachAlertLayout) {
        if (this.viewChangeAnimator == null && this.commentsAnimator == null) {
            AttachAlertLayout attachAlertLayout2 = this.currentAttachLayout;
            if (attachAlertLayout2 == attachAlertLayout) {
                attachAlertLayout2.scrollToTop();
                return;
            }
            if (attachAlertLayout == this.photoLayout) {
                this.selectedId = 1;
            } else if (attachAlertLayout == this.audioLayout) {
                this.selectedId = 3;
            } else if (attachAlertLayout == this.documentLayout) {
                this.selectedId = 4;
            } else if (attachAlertLayout == this.contactsLayout) {
                this.selectedId = 5;
            } else if (attachAlertLayout == this.locationLayout) {
                this.selectedId = 6;
            } else if (attachAlertLayout == this.pollLayout) {
                this.selectedId = 9;
            } else if (attachAlertLayout == this.liveLayout) {
                this.selectedId = 10;
            }
            int childCount = this.buttonsRecyclerView.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.buttonsRecyclerView.getChildAt(i);
                if (childAt instanceof AttachButton) {
                    ((AttachButton) childAt).updateCheckedState(true);
                }
            }
            int firstOffset = (this.currentAttachLayout.getFirstOffset() - AndroidUtilities.dp(11.0f)) - this.scrollOffsetY[0];
            this.nextAttachLayout = attachAlertLayout;
            if (Build.VERSION.SDK_INT >= 20) {
                this.container.setLayerType(2, null);
            }
            this.actionBar.setVisibility(this.nextAttachLayout.needsActionBar() != 0 ? 0 : 4);
            this.actionBarShadow.setVisibility(this.actionBar.getVisibility());
            if (this.actionBar.isSearchFieldVisible()) {
                this.actionBar.closeSearchField();
            }
            this.currentAttachLayout.onHide();
            this.nextAttachLayout.onShow();
            this.nextAttachLayout.setVisibility(0);
            this.nextAttachLayout.setAlpha(0.0f);
            if (attachAlertLayout.getParent() != null) {
                this.containerView.removeView(this.nextAttachLayout);
            }
            int iIndexOfChild = this.containerView.indexOfChild(this.currentAttachLayout);
            ViewGroup viewGroup = this.containerView;
            AttachAlertLayout attachAlertLayout3 = this.nextAttachLayout;
            if (attachAlertLayout3 != this.locationLayout) {
                iIndexOfChild++;
            }
            viewGroup.addView(attachAlertLayout3, iIndexOfChild, LayoutHelper.createFrame(-1, -1.0f));
            this.nextAttachLayout.setTranslationY(AndroidUtilities.dp(78.0f));
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(ObjectAnimator.ofFloat(this.currentAttachLayout, (Property<AttachAlertLayout, Float>) View.TRANSLATION_Y, AndroidUtilities.dp(78.0f) + firstOffset), ObjectAnimator.ofFloat(this.currentAttachLayout, this.ATTACH_ALERT_LAYOUT_TRANSLATION, 0.0f, 1.0f));
            animatorSet.setInterpolator(CubicBezierInterpolator.DEFAULT);
            animatorSet.setDuration(180L);
            animatorSet.setStartDelay(20L);
            animatorSet.addListener(new AnonymousClass15());
            this.viewChangeAnimator = animatorSet;
            animatorSet.start();
        }
    }

    /* renamed from: org.rbmain.ui.Components.ChatAttachAlert$15, reason: invalid class name */
    class AnonymousClass15 extends AnimatorListenerAdapter {
        AnonymousClass15() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ChatAttachAlert.this.currentAttachLayout.setAlpha(0.0f);
            SpringAnimation springAnimation = new SpringAnimation(ChatAttachAlert.this.nextAttachLayout, DynamicAnimation.TRANSLATION_Y, 0.0f);
            springAnimation.getSpring().setDampingRatio(0.7f);
            springAnimation.getSpring().setStiffness(400.0f);
            springAnimation.addUpdateListener(new DynamicAnimation.OnAnimationUpdateListener() { // from class: org.rbmain.ui.Components.ChatAttachAlert$15$$ExternalSyntheticLambda1
                @Override // androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationUpdateListener
                public final void onAnimationUpdate(DynamicAnimation dynamicAnimation, float f, float f2) {
                    this.f$0.lambda$onAnimationEnd$0(dynamicAnimation, f, f2);
                }
            });
            springAnimation.addEndListener(new DynamicAnimation.OnAnimationEndListener() { // from class: org.rbmain.ui.Components.ChatAttachAlert$15$$ExternalSyntheticLambda0
                @Override // androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationEndListener
                public final void onAnimationEnd(DynamicAnimation dynamicAnimation, boolean z, float f, float f2) {
                    this.f$0.lambda$onAnimationEnd$1(dynamicAnimation, z, f, f2);
                }
            });
            ChatAttachAlert.this.viewChangeAnimator = springAnimation;
            springAnimation.start();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onAnimationEnd$0(DynamicAnimation dynamicAnimation, float f, float f2) {
            if (ChatAttachAlert.this.nextAttachLayout == ChatAttachAlert.this.pollLayout) {
                ChatAttachAlert.this.updateSelectedPosition(1);
            }
            ChatAttachAlert.this.nextAttachLayout.onContainerTranslationUpdated(ChatAttachAlert.this.currentPanTranslationY);
            ((BottomSheet) ChatAttachAlert.this).containerView.invalidate();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onAnimationEnd$1(DynamicAnimation dynamicAnimation, boolean z, float f, float f2) {
            if (Build.VERSION.SDK_INT >= 20) {
                ((BottomSheet) ChatAttachAlert.this).container.setLayerType(0, null);
            }
            ChatAttachAlert.this.viewChangeAnimator = null;
            ((BottomSheet) ChatAttachAlert.this).containerView.removeView(ChatAttachAlert.this.currentAttachLayout);
            ChatAttachAlert.this.currentAttachLayout.setVisibility(8);
            ChatAttachAlert.this.currentAttachLayout.onHidden();
            ChatAttachAlert.this.nextAttachLayout.onShown();
            ChatAttachAlert chatAttachAlert = ChatAttachAlert.this;
            chatAttachAlert.currentAttachLayout = chatAttachAlert.nextAttachLayout;
            ChatAttachAlert.this.nextAttachLayout = null;
            int[] iArr = ChatAttachAlert.this.scrollOffsetY;
            iArr[0] = iArr[1];
        }
    }

    public void onRequestPermissionsResultFragment(int i, String[] strArr, int[] iArr) {
        ChatAttachAlertLocationLayout chatAttachAlertLocationLayout;
        if (i == 5 && iArr != null && iArr.length > 0 && iArr[0] == 0) {
            openContactsLayout();
        } else if (i == 30 && (chatAttachAlertLocationLayout = this.locationLayout) != null && this.currentAttachLayout == chatAttachAlertLocationLayout && isShowing()) {
            this.locationLayout.openShareLiveLocation();
        }
    }

    private void openContactsLayout() {
        if (this.contactsLayout == null) {
            AttachAlertLayout[] attachAlertLayoutArr = this.layouts;
            ChatAttachAlertContactsLayout chatAttachAlertContactsLayout = new ChatAttachAlertContactsLayout(this, getContext());
            this.contactsLayout = chatAttachAlertContactsLayout;
            attachAlertLayoutArr[2] = chatAttachAlertContactsLayout;
            chatAttachAlertContactsLayout.setDelegate(new ChatAttachAlertContactsLayout.PhonebookShareAlertDelegate() { // from class: org.rbmain.ui.Components.ChatAttachAlert$$ExternalSyntheticLambda16
                @Override // org.rbmain.ui.Components.ChatAttachAlertContactsLayout.PhonebookShareAlertDelegate
                public final void didSelectContact(TLRPC$User tLRPC$User, boolean z, int i) {
                    this.f$0.lambda$openContactsLayout$17(tLRPC$User, z, i);
                }
            });
        }
        showLayout(this.contactsLayout);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$openContactsLayout$17(TLRPC$User tLRPC$User, boolean z, int i) {
        ((ChatActivity) this.baseFragment).sendContact(tLRPC$User, z, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openAudioLayout(boolean z) {
        if (this.audioLayout == null) {
            AttachAlertLayout[] attachAlertLayoutArr = this.layouts;
            ChatAttachAlertAudioLayout chatAttachAlertAudioLayout = new ChatAttachAlertAudioLayout(this, getContext());
            this.audioLayout = chatAttachAlertAudioLayout;
            attachAlertLayoutArr[3] = chatAttachAlertAudioLayout;
            chatAttachAlertAudioLayout.setDelegate(new ChatAttachAlertAudioLayout.AudioSelectDelegate() { // from class: org.rbmain.ui.Components.ChatAttachAlert$$ExternalSyntheticLambda15
                @Override // org.rbmain.ui.Components.ChatAttachAlertAudioLayout.AudioSelectDelegate
                public final void didSelectAudio(ArrayList arrayList, CharSequence charSequence, boolean z2, int i) {
                    this.f$0.lambda$openAudioLayout$18(arrayList, charSequence, z2, i);
                }
            });
        }
        BaseFragment baseFragment = this.baseFragment;
        if (baseFragment instanceof ChatActivity) {
            TLRPC$Chat currentChat = ((ChatActivity) baseFragment).getCurrentChat();
            this.audioLayout.setMaxSelectedFiles(((currentChat == null || ChatObject.hasAdminRights(currentChat) || !currentChat.slowmode_enabled) && this.editingMessageObject == null) ? -1 : 1);
        }
        if (z) {
            showLayout(this.audioLayout);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$openAudioLayout$18(ArrayList arrayList, CharSequence charSequence, boolean z, int i) {
        ((ChatActivity) this.baseFragment).sendAudio(arrayList, charSequence, z, i);
    }

    private void openDocumentsLayout(boolean z) {
        if (this.documentLayout == null) {
            AttachAlertLayout[] attachAlertLayoutArr = this.layouts;
            ChatAttachAlertDocumentLayout chatAttachAlertDocumentLayout = new ChatAttachAlertDocumentLayout(this, getContext(), false);
            this.documentLayout = chatAttachAlertDocumentLayout;
            attachAlertLayoutArr[4] = chatAttachAlertDocumentLayout;
            chatAttachAlertDocumentLayout.setDelegate(new ChatAttachAlertDocumentLayout.DocumentSelectActivityDelegate() { // from class: org.rbmain.ui.Components.ChatAttachAlert.16
                @Override // org.rbmain.ui.Components.ChatAttachAlertDocumentLayout.DocumentSelectActivityDelegate
                public void didSelectFiles(ArrayList<String> arrayList, String str, boolean z2, int i) {
                    BaseFragment baseFragment = ChatAttachAlert.this.baseFragment;
                    if (baseFragment instanceof ChatActivity) {
                        ((ChatActivity) baseFragment).didSelectFiles(arrayList, str, z2, i);
                    } else if (baseFragment instanceof PassportActivity) {
                        ((PassportActivity) baseFragment).didSelectFiles(arrayList, str, z2, i);
                    }
                }

                @Override // org.rbmain.ui.Components.ChatAttachAlertDocumentLayout.DocumentSelectActivityDelegate
                public void didSelectPhotos(ArrayList<SendMessagesHelper.SendingMediaInfo> arrayList, boolean z2, int i) {
                    BaseFragment baseFragment = ChatAttachAlert.this.baseFragment;
                    if (baseFragment instanceof ChatActivity) {
                        ((ChatActivity) baseFragment).didSelectPhotos(arrayList, z2, i);
                    } else if (baseFragment instanceof PassportActivity) {
                        ((PassportActivity) baseFragment).didSelectPhotos(arrayList, z2, i);
                    }
                }

                @Override // org.rbmain.ui.Components.ChatAttachAlertDocumentLayout.DocumentSelectActivityDelegate
                public void startDocumentSelectActivity() {
                    BaseFragment baseFragment = ChatAttachAlert.this.baseFragment;
                    if (baseFragment instanceof ChatActivity) {
                        ((ChatActivity) baseFragment).startDocumentSelectActivity();
                    } else if (baseFragment instanceof PassportActivity) {
                        ((PassportActivity) baseFragment).startDocumentSelectActivity();
                    }
                }

                @Override // org.rbmain.ui.Components.ChatAttachAlertDocumentLayout.DocumentSelectActivityDelegate
                public void startMusicSelectActivity() {
                    ChatAttachAlert.this.openAudioLayout(true);
                }
            });
        }
        BaseFragment baseFragment = this.baseFragment;
        int i = 1;
        if (baseFragment instanceof ChatActivity) {
            TLRPC$Chat currentChat = ((ChatActivity) baseFragment).getCurrentChat();
            ChatAttachAlertDocumentLayout chatAttachAlertDocumentLayout2 = this.documentLayout;
            if ((currentChat == null || ChatObject.hasAdminRights(currentChat) || !currentChat.slowmode_enabled) && this.editingMessageObject == null) {
                i = -1;
            }
            chatAttachAlertDocumentLayout2.setMaxSelectedFiles(i);
        } else {
            this.documentLayout.setMaxSelectedFiles(this.maxSelectedPhotos);
            this.documentLayout.setCanSelectOnlyImageFiles(true);
        }
        if (z) {
            showLayout(this.documentLayout);
        }
    }

    private boolean showCommentTextView(final boolean z, boolean z2) {
        if (z == (this.frameLayout2.getTag() != null)) {
            return false;
        }
        AnimatorSet animatorSet = this.commentsAnimator;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        this.frameLayout2.setTag(z ? 1 : null);
        if (this.commentTextView.getEditText().isFocused()) {
            AndroidUtilities.hideKeyboard(this.commentTextView.getEditText());
        }
        this.commentTextView.hidePopup(true);
        if (z) {
            this.frameLayout2.setVisibility(0);
            this.writeButtonContainer.setVisibility(0);
            if (!this.typeButtonsAvailable) {
                this.shadow.setVisibility(0);
            }
        } else if (this.typeButtonsAvailable) {
            this.buttonsRecyclerView.setVisibility(0);
        }
        if (z2) {
            this.commentsAnimator = new AnimatorSet();
            ArrayList arrayList = new ArrayList();
            FrameLayout frameLayout = this.frameLayout2;
            Property property = View.ALPHA;
            float[] fArr = new float[1];
            fArr[0] = z ? 1.0f : 0.0f;
            arrayList.add(ObjectAnimator.ofFloat(frameLayout, (Property<FrameLayout, Float>) property, fArr));
            FrameLayout frameLayout2 = this.writeButtonContainer;
            Property property2 = View.SCALE_X;
            float[] fArr2 = new float[1];
            fArr2[0] = z ? 1.0f : 0.2f;
            arrayList.add(ObjectAnimator.ofFloat(frameLayout2, (Property<FrameLayout, Float>) property2, fArr2));
            FrameLayout frameLayout3 = this.writeButtonContainer;
            Property property3 = View.SCALE_Y;
            float[] fArr3 = new float[1];
            fArr3[0] = z ? 1.0f : 0.2f;
            arrayList.add(ObjectAnimator.ofFloat(frameLayout3, (Property<FrameLayout, Float>) property3, fArr3));
            FrameLayout frameLayout4 = this.writeButtonContainer;
            Property property4 = View.ALPHA;
            float[] fArr4 = new float[1];
            fArr4[0] = z ? 1.0f : 0.0f;
            arrayList.add(ObjectAnimator.ofFloat(frameLayout4, (Property<FrameLayout, Float>) property4, fArr4));
            View view = this.selectedCountView;
            Property property5 = View.SCALE_X;
            float[] fArr5 = new float[1];
            fArr5[0] = z ? 1.0f : 0.2f;
            arrayList.add(ObjectAnimator.ofFloat(view, (Property<View, Float>) property5, fArr5));
            View view2 = this.selectedCountView;
            Property property6 = View.SCALE_Y;
            float[] fArr6 = new float[1];
            fArr6[0] = z ? 1.0f : 0.2f;
            arrayList.add(ObjectAnimator.ofFloat(view2, (Property<View, Float>) property6, fArr6));
            View view3 = this.selectedCountView;
            Property property7 = View.ALPHA;
            float[] fArr7 = new float[1];
            fArr7[0] = z ? 1.0f : 0.0f;
            arrayList.add(ObjectAnimator.ofFloat(view3, (Property<View, Float>) property7, fArr7));
            if (this.actionBar.getTag() != null) {
                FrameLayout frameLayout5 = this.frameLayout2;
                Property property8 = View.TRANSLATION_Y;
                float[] fArr8 = new float[1];
                fArr8[0] = z ? 0.0f : AndroidUtilities.dp(48.0f);
                arrayList.add(ObjectAnimator.ofFloat(frameLayout5, (Property<FrameLayout, Float>) property8, fArr8));
                View view4 = this.shadow;
                Property property9 = View.TRANSLATION_Y;
                float[] fArr9 = new float[1];
                fArr9[0] = z ? AndroidUtilities.dp(36.0f) : AndroidUtilities.dp(84.0f);
                arrayList.add(ObjectAnimator.ofFloat(view4, (Property<View, Float>) property9, fArr9));
                View view5 = this.shadow;
                Property property10 = View.ALPHA;
                float[] fArr10 = new float[1];
                fArr10[0] = z ? 1.0f : 0.0f;
                arrayList.add(ObjectAnimator.ofFloat(view5, (Property<View, Float>) property10, fArr10));
            } else if (this.typeButtonsAvailable) {
                RecyclerListView recyclerListView = this.buttonsRecyclerView;
                Property property11 = View.TRANSLATION_Y;
                float[] fArr11 = new float[1];
                fArr11[0] = z ? AndroidUtilities.dp(36.0f) : 0.0f;
                arrayList.add(ObjectAnimator.ofFloat(recyclerListView, (Property<RecyclerListView, Float>) property11, fArr11));
                View view6 = this.shadow;
                Property property12 = View.TRANSLATION_Y;
                float[] fArr12 = new float[1];
                fArr12[0] = z ? AndroidUtilities.dp(36.0f) : 0.0f;
                arrayList.add(ObjectAnimator.ofFloat(view6, (Property<View, Float>) property12, fArr12));
            } else {
                this.shadow.setTranslationY(AndroidUtilities.dp(36.0f));
                View view7 = this.shadow;
                Property property13 = View.ALPHA;
                float[] fArr13 = new float[1];
                fArr13[0] = z ? 1.0f : 0.0f;
                arrayList.add(ObjectAnimator.ofFloat(view7, (Property<View, Float>) property13, fArr13));
            }
            this.commentsAnimator.playTogether(arrayList);
            this.commentsAnimator.setInterpolator(new DecelerateInterpolator());
            this.commentsAnimator.setDuration(180L);
            this.commentsAnimator.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.Components.ChatAttachAlert.17
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (animator.equals(ChatAttachAlert.this.commentsAnimator)) {
                        if (!z) {
                            ChatAttachAlert.this.frameLayout2.setVisibility(4);
                            ChatAttachAlert.this.writeButtonContainer.setVisibility(4);
                            ChatAttachAlert chatAttachAlert = ChatAttachAlert.this;
                            if (!chatAttachAlert.typeButtonsAvailable) {
                                chatAttachAlert.shadow.setVisibility(4);
                            }
                        } else {
                            ChatAttachAlert chatAttachAlert2 = ChatAttachAlert.this;
                            if (chatAttachAlert2.typeButtonsAvailable) {
                                chatAttachAlert2.buttonsRecyclerView.setVisibility(4);
                            }
                        }
                        ChatAttachAlert.this.commentsAnimator = null;
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    if (animator.equals(ChatAttachAlert.this.commentsAnimator)) {
                        ChatAttachAlert.this.commentsAnimator = null;
                    }
                }
            });
            this.commentsAnimator.start();
        } else {
            this.frameLayout2.setAlpha(z ? 1.0f : 0.0f);
            this.writeButtonContainer.setScaleX(z ? 1.0f : 0.2f);
            this.writeButtonContainer.setScaleY(z ? 1.0f : 0.2f);
            this.writeButtonContainer.setAlpha(z ? 1.0f : 0.0f);
            this.selectedCountView.setScaleX(z ? 1.0f : 0.2f);
            this.selectedCountView.setScaleY(z ? 1.0f : 0.2f);
            this.selectedCountView.setAlpha(z ? 1.0f : 0.0f);
            if (this.actionBar.getTag() != null) {
                this.frameLayout2.setTranslationY(z ? 0.0f : AndroidUtilities.dp(48.0f));
                this.shadow.setTranslationY(z ? AndroidUtilities.dp(36.0f) : AndroidUtilities.dp(84.0f));
                this.shadow.setAlpha(z ? 1.0f : 0.0f);
            } else if (this.typeButtonsAvailable) {
                this.buttonsRecyclerView.setTranslationY(z ? AndroidUtilities.dp(36.0f) : 0.0f);
                this.shadow.setTranslationY(z ? AndroidUtilities.dp(36.0f) : 0.0f);
            } else {
                this.shadow.setTranslationY(AndroidUtilities.dp(36.0f));
                this.shadow.setAlpha(z ? 1.0f : 0.0f);
            }
            if (!z) {
                this.frameLayout2.setVisibility(4);
                this.writeButtonContainer.setVisibility(4);
                if (!this.typeButtonsAvailable) {
                    this.shadow.setVisibility(4);
                }
            }
        }
        return true;
    }

    @Override // org.rbmain.ui.ActionBar.BottomSheet
    protected boolean onCustomOpenAnimation() {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofFloat(this, this.ATTACH_ALERT_PROGRESS, 0.0f, 400.0f));
        animatorSet.setDuration(400L);
        animatorSet.setStartDelay(20L);
        animatorSet.start();
        return false;
    }

    @Override // org.rbmain.ui.ActionBar.BottomSheet
    protected boolean onContainerTouchEvent(MotionEvent motionEvent) {
        return this.currentAttachLayout.onContainerViewTouchEvent(motionEvent);
    }

    protected void makeFocusable(final EditTextBoldCursor editTextBoldCursor, final boolean z) {
        if (this.enterCommentEventSent) {
            return;
        }
        boolean zNeedEnterComment = this.delegate.needEnterComment();
        this.enterCommentEventSent = true;
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.Components.ChatAttachAlert$$ExternalSyntheticLambda9
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$makeFocusable$20(editTextBoldCursor, z);
            }
        }, zNeedEnterComment ? 200L : 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$makeFocusable$20(final EditTextBoldCursor editTextBoldCursor, boolean z) {
        setFocusable(true);
        editTextBoldCursor.requestFocus();
        if (z) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.Components.ChatAttachAlert$$ExternalSyntheticLambda10
                @Override // java.lang.Runnable
                public final void run() {
                    AndroidUtilities.showKeyboard(editTextBoldCursor);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void applyAttachButtonColors(View view) {
        if (view instanceof AttachButton) {
            AttachButton attachButton = (AttachButton) view;
            attachButton.textView.setTextColor(ColorUtils.blendARGB(Theme.getColor(Theme.key_dialogTextGray2), Theme.getColor(attachButton.textKey), attachButton.checkedState));
        } else if (view instanceof AttachBotButton) {
            ((AttachBotButton) view).nameTextView.setTextColor(Theme.getColor(Theme.key_dialogTextGray2));
        }
    }

    @Override // org.rbmain.ui.ActionBar.BottomSheet
    public ArrayList<ThemeDescription> getThemeDescriptions() {
        ArrayList<ThemeDescription> themeDescriptions;
        ArrayList<ThemeDescription> arrayList = new ArrayList<>();
        int i = 0;
        while (true) {
            AttachAlertLayout[] attachAlertLayoutArr = this.layouts;
            if (i < attachAlertLayoutArr.length) {
                if (attachAlertLayoutArr[i] != null && (themeDescriptions = attachAlertLayoutArr[i].getThemeDescriptions()) != null) {
                    arrayList.addAll(themeDescriptions);
                }
                i++;
            } else {
                arrayList.add(new ThemeDescription(this.container, 0, null, null, null, null, Theme.key_dialogBackgroundGray));
                return arrayList;
            }
        }
    }

    public void checkColors() {
        RecyclerListView recyclerListView = this.buttonsRecyclerView;
        if (recyclerListView == null) {
            return;
        }
        int childCount = recyclerListView.getChildCount();
        int i = 0;
        for (int i2 = 0; i2 < childCount; i2++) {
            applyAttachButtonColors(this.buttonsRecyclerView.getChildAt(i2));
        }
        this.selectedTextView.setTextColor(Theme.getColor(this.forceDarkTheme ? Theme.key_voipgroup_actionBarItems : Theme.key_dialogTextBlack));
        this.doneItem.getTextView().setTextColor(Theme.getColor(Theme.key_windowBackgroundWhiteBlueHeader));
        this.selectedMenuItem.setIconColor(Theme.getColor(this.forceDarkTheme ? Theme.key_voipgroup_actionBarItems : Theme.key_dialogTextBlack));
        Theme.setDrawableColor(this.selectedMenuItem.getBackground(), Theme.getColor(this.forceDarkTheme ? Theme.key_voipgroup_actionBarItemsSelector : Theme.key_dialogButtonSelector));
        ActionBarMenuItem actionBarMenuItem = this.selectedMenuItem;
        int i3 = Theme.key_actionBarDefaultSubmenuItem;
        actionBarMenuItem.setPopupItemsColor(Theme.getColor(i3), false);
        this.selectedMenuItem.setPopupItemsColor(Theme.getColor(i3), true);
        this.selectedMenuItem.redrawPopup(Theme.getColor(Theme.key_actionBarDefaultSubmenuBackground));
        this.searchItem.setIconColor(Theme.getColor(this.forceDarkTheme ? Theme.key_voipgroup_actionBarItems : Theme.key_dialogTextBlack));
        Theme.setDrawableColor(this.searchItem.getBackground(), Theme.getColor(this.forceDarkTheme ? Theme.key_voipgroup_actionBarItemsSelector : Theme.key_dialogButtonSelector));
        this.commentTextView.updateColors();
        if (this.sendPopupLayout != null) {
            int i4 = 0;
            while (true) {
                ActionBarMenuSubItem[] actionBarMenuSubItemArr = this.itemCells;
                if (i4 >= actionBarMenuSubItemArr.length) {
                    break;
                }
                if (actionBarMenuSubItemArr[i4] != null) {
                    actionBarMenuSubItemArr[i4].setColors(Theme.getColor(Theme.key_actionBarDefaultSubmenuItem), Theme.getColor(Theme.key_actionBarDefaultSubmenuItemIcon));
                    this.itemCells[i4].setSelectorColor(Theme.getColor(this.forceDarkTheme ? Theme.key_voipgroup_actionBarItemsSelector : Theme.key_dialogButtonSelector));
                }
                i4++;
            }
            this.sendPopupLayout.setBackgroundColor(Theme.getColor(Theme.key_actionBarDefaultSubmenuBackground));
            ActionBarPopupWindow actionBarPopupWindow = this.sendPopupWindow;
            if (actionBarPopupWindow != null && actionBarPopupWindow.isShowing()) {
                this.sendPopupLayout.invalidate();
            }
        }
        Drawable drawable = this.writeButtonDrawable;
        int i5 = Theme.key_dialogFloatingButton;
        Theme.setSelectorDrawableColor(drawable, Theme.getColor(i5), false);
        Drawable drawable2 = this.writeButtonDrawable;
        if (Build.VERSION.SDK_INT >= 21) {
            i5 = Theme.key_dialogFloatingButtonPressed;
        }
        Theme.setSelectorDrawableColor(drawable2, Theme.getColor(i5), true);
        this.writeButton.setColorFilter(new PorterDuffColorFilter(Theme.getColor(Theme.key_dialogFloatingIcon), PorterDuff.Mode.MULTIPLY));
        this.actionBarShadow.setBackgroundColor(Theme.getColor(Theme.key_dialogShadowLine));
        this.buttonsRecyclerView.setGlowColor(Theme.getColor(Theme.key_dialogScrollGlow));
        this.buttonsRecyclerView.setBackgroundColor(Theme.getColor(this.forceDarkTheme ? Theme.key_voipgroup_listViewBackground : Theme.key_dialogBackground));
        this.frameLayout2.setBackgroundColor(Theme.getColor(this.forceDarkTheme ? Theme.key_voipgroup_listViewBackground : Theme.key_dialogBackground));
        this.selectedCountView.invalidate();
        this.actionBar.setBackgroundColor(Theme.getColor(this.forceDarkTheme ? Theme.key_voipgroup_actionBar : Theme.key_dialogBackground));
        this.actionBar.setItemsColor(Theme.getColor(this.forceDarkTheme ? Theme.key_voipgroup_actionBarItems : Theme.key_dialogTextBlack), false);
        this.actionBar.setItemsBackgroundColor(Theme.getColor(this.forceDarkTheme ? Theme.key_voipgroup_actionBarItemsSelector : Theme.key_dialogButtonSelector), false);
        this.actionBar.setTitleColor(Theme.getColor(this.forceDarkTheme ? Theme.key_voipgroup_actionBarItems : Theme.key_dialogTextBlack));
        Theme.setDrawableColor(this.shadowDrawable, Theme.getColor(this.forceDarkTheme ? Theme.key_voipgroup_listViewBackground : Theme.key_dialogBackground));
        this.containerView.invalidate();
        while (true) {
            AttachAlertLayout[] attachAlertLayoutArr = this.layouts;
            if (i >= attachAlertLayoutArr.length) {
                return;
            }
            if (attachAlertLayoutArr[i] != null) {
                attachAlertLayoutArr[i].checkColors();
            }
            i++;
        }
    }

    @Override // org.rbmain.ui.ActionBar.BottomSheet
    protected boolean onCustomMeasure(View view, int i, int i2) {
        return this.photoLayout.onCustomMeasure(view, i, i2);
    }

    @Override // org.rbmain.ui.ActionBar.BottomSheet
    protected boolean onCustomLayout(View view, int i, int i2, int i3, int i4) {
        return this.photoLayout.onCustomLayout(view, i, i2, i3, i4);
    }

    public void onPause() {
        int i = 0;
        while (true) {
            AttachAlertLayout[] attachAlertLayoutArr = this.layouts;
            if (i < attachAlertLayoutArr.length) {
                if (attachAlertLayoutArr[i] != null) {
                    attachAlertLayoutArr[i].onPause();
                }
                i++;
            } else {
                this.paused = true;
                return;
            }
        }
    }

    public void onResume() {
        int i = 0;
        this.paused = false;
        while (true) {
            AttachAlertLayout[] attachAlertLayoutArr = this.layouts;
            if (i >= attachAlertLayoutArr.length) {
                break;
            }
            if (attachAlertLayoutArr[i] != null) {
                attachAlertLayoutArr[i].onResume();
            }
            i++;
        }
        if (isShowing()) {
            this.delegate.needEnterComment();
        }
    }

    public void onActivityResultFragment(int i, Intent intent, String str) {
        this.photoLayout.onActivityResultFragment(i, intent, str);
    }

    @Override // org.rbmain.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int i, int i2, Object... objArr) {
        ButtonsAdapter buttonsAdapter;
        if (i != NotificationCenter.reloadInlineHints || (buttonsAdapter = this.buttonsAdapter) == null) {
            return;
        }
        buttonsAdapter.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSelectedPosition(int i) {
        int iDp;
        int iDp2;
        float fMin;
        int i2;
        int i3;
        AttachAlertLayout attachAlertLayout = i == 0 ? this.currentAttachLayout : this.nextAttachLayout;
        int i4 = this.scrollOffsetY[i] - this.backgroundPaddingTop;
        if (attachAlertLayout == this.pollLayout) {
            iDp = i4 - AndroidUtilities.dp(13.0f);
            iDp2 = AndroidUtilities.dp(11.0f);
        } else {
            iDp = i4 - AndroidUtilities.dp(39.0f);
            iDp2 = AndroidUtilities.dp(43.0f);
        }
        float f = iDp2;
        if (this.backgroundPaddingTop + iDp < ActionBar.getCurrentActionBarHeight()) {
            fMin = Math.min(1.0f, ((ActionBar.getCurrentActionBarHeight() - iDp) - this.backgroundPaddingTop) / f);
            this.cornerRadius = 1.0f - fMin;
        } else {
            this.cornerRadius = 1.0f;
            fMin = 0.0f;
        }
        if (AndroidUtilities.isTablet()) {
            i2 = 16;
        } else {
            android.graphics.Point point = AndroidUtilities.displaySize;
            i2 = point.x > point.y ? 6 : 12;
        }
        float fDp = this.actionBar.getAlpha() != 0.0f ? 0.0f : AndroidUtilities.dp((1.0f - this.selectedTextView.getAlpha()) * 26.0f);
        if (this.menuShowed && this.avatarPicker == 0) {
            this.selectedMenuItem.setTranslationY((this.scrollOffsetY[i] - AndroidUtilities.dp((i2 * fMin) + 37.0f)) + fDp + this.currentPanTranslationY);
        } else {
            this.selectedMenuItem.setTranslationY(((ActionBar.getCurrentActionBarHeight() - AndroidUtilities.dp(4.0f)) - AndroidUtilities.dp(i2 + 37)) + this.currentPanTranslationY);
        }
        this.searchItem.setTranslationY(((ActionBar.getCurrentActionBarHeight() - AndroidUtilities.dp(4.0f)) - AndroidUtilities.dp(i2 + 37)) + this.currentPanTranslationY);
        TextView textView = this.selectedTextView;
        float fDp2 = (this.scrollOffsetY[i] - AndroidUtilities.dp((i2 * fMin) + 25.0f)) + fDp + this.currentPanTranslationY;
        this.baseSelectedTextViewTranslationY = fDp2;
        textView.setTranslationY(fDp2);
        ChatAttachAlertPollLayout chatAttachAlertPollLayout = this.pollLayout;
        if (chatAttachAlertPollLayout == null || attachAlertLayout != chatAttachAlertPollLayout) {
            return;
        }
        if (AndroidUtilities.isTablet()) {
            i3 = 63;
        } else {
            android.graphics.Point point2 = AndroidUtilities.displaySize;
            i3 = point2.x > point2.y ? 53 : 59;
        }
        this.doneItem.setTranslationY(Math.max(0.0f, (this.pollLayout.getTranslationY() + this.scrollOffsetY[i]) - AndroidUtilities.dp((i3 * fMin) + 7.0f)) + this.currentPanTranslationY);
    }

    protected void updateLayout(AttachAlertLayout attachAlertLayout, boolean z, int i) {
        int currentItemTop;
        if (attachAlertLayout == null || (currentItemTop = attachAlertLayout.getCurrentItemTop()) == Integer.MAX_VALUE) {
            return;
        }
        final boolean z2 = attachAlertLayout == this.currentAttachLayout && currentItemTop <= attachAlertLayout.getButtonsHideOffset();
        if (this.keyboardVisible && z) {
            z = false;
        }
        if ((z2 && this.actionBar.getTag() == null) || (!z2 && this.actionBar.getTag() != null)) {
            this.actionBar.setTag(z2 ? 1 : null);
            AnimatorSet animatorSet = this.actionBarAnimation;
            if (animatorSet != null) {
                animatorSet.cancel();
                this.actionBarAnimation = null;
            }
            boolean z3 = this.avatarPicker != 0 || (!this.menuShowed && this.currentAttachLayout == this.photoLayout && this.mediaEnabled);
            if (z2) {
                if (z3) {
                    this.selectedMenuItem.setVisibility(0);
                }
            } else if (this.typeButtonsAvailable) {
                this.buttonsRecyclerView.setVisibility(0);
            }
            if (z) {
                AnimatorSet animatorSet2 = new AnimatorSet();
                this.actionBarAnimation = animatorSet2;
                animatorSet2.setDuration(180L);
                ArrayList arrayList = new ArrayList();
                ActionBar actionBar = this.actionBar;
                Property property = View.ALPHA;
                float[] fArr = new float[1];
                fArr[0] = z2 ? 1.0f : 0.0f;
                arrayList.add(ObjectAnimator.ofFloat(actionBar, (Property<ActionBar, Float>) property, fArr));
                View view = this.actionBarShadow;
                Property property2 = View.ALPHA;
                float[] fArr2 = new float[1];
                fArr2[0] = z2 ? 1.0f : 0.0f;
                arrayList.add(ObjectAnimator.ofFloat(view, (Property<View, Float>) property2, fArr2));
                if (z3) {
                    ActionBarMenuItem actionBarMenuItem = this.selectedMenuItem;
                    Property property3 = View.ALPHA;
                    float[] fArr3 = new float[1];
                    fArr3[0] = z2 ? 1.0f : 0.0f;
                    arrayList.add(ObjectAnimator.ofFloat(actionBarMenuItem, (Property<ActionBarMenuItem, Float>) property3, fArr3));
                }
                this.actionBarAnimation.playTogether(arrayList);
                this.actionBarAnimation.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.Components.ChatAttachAlert.19
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (ChatAttachAlert.this.actionBarAnimation != null) {
                            if (z2) {
                                ChatAttachAlert chatAttachAlert = ChatAttachAlert.this;
                                if (chatAttachAlert.typeButtonsAvailable) {
                                    chatAttachAlert.buttonsRecyclerView.setVisibility(4);
                                    return;
                                }
                                return;
                            }
                            ChatAttachAlert.this.searchItem.setVisibility(4);
                            ChatAttachAlert chatAttachAlert2 = ChatAttachAlert.this;
                            if (chatAttachAlert2.avatarPicker == 0 && chatAttachAlert2.menuShowed) {
                                return;
                            }
                            ChatAttachAlert.this.selectedMenuItem.setVisibility(4);
                        }
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        ChatAttachAlert.this.actionBarAnimation = null;
                    }
                });
                this.actionBarAnimation.start();
            } else {
                if (z2 && this.typeButtonsAvailable) {
                    this.buttonsRecyclerView.setVisibility(4);
                }
                this.actionBar.setAlpha(z2 ? 1.0f : 0.0f);
                this.actionBarShadow.setAlpha(z2 ? 1.0f : 0.0f);
                if (z3) {
                    this.selectedMenuItem.setAlpha(z2 ? 1.0f : 0.0f);
                }
                if (!z2) {
                    this.searchItem.setVisibility(4);
                    if (this.avatarPicker != 0 || !this.menuShowed) {
                        this.selectedMenuItem.setVisibility(4);
                    }
                }
            }
        }
        int iDp = currentItemTop + (((FrameLayout.LayoutParams) attachAlertLayout.getLayoutParams()).topMargin - AndroidUtilities.dp(11.0f));
        int i2 = this.currentAttachLayout == attachAlertLayout ? 0 : 1;
        int[] iArr = this.scrollOffsetY;
        if (iArr[i2] == iDp) {
            if (i != 0) {
                this.previousScrollOffsetY = iArr[i2];
            }
        } else {
            this.previousScrollOffsetY = iArr[i2];
            iArr[i2] = iDp;
            updateSelectedPosition(i2);
            this.containerView.invalidate();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x0102  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void updateCountButton(int r19) {
        /*
            Method dump skipped, instructions count: 473
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.Components.ChatAttachAlert.updateCountButton(int):void");
    }

    public void setDelegate(ChatAttachViewDelegate chatAttachViewDelegate) {
        this.delegate = chatAttachViewDelegate;
    }

    public void init() {
        AttachAlertLayout attachAlertLayout;
        BaseFragment baseFragment = this.baseFragment;
        if (baseFragment == null) {
            return;
        }
        if ((baseFragment instanceof ChatActivity) && this.avatarPicker != 2) {
            TLRPC$Chat currentChat = ((ChatActivity) baseFragment).getCurrentChat();
            TLRPC$User currentUser = ((ChatActivity) this.baseFragment).getCurrentUser();
            if (currentChat != null) {
                this.mediaEnabled = ChatObject.canSendMedia(currentChat);
                this.pollsEnabled = ChatObject.canSendPolls(currentChat);
            } else {
                this.pollsEnabled = currentUser != null && currentUser.bot;
            }
        } else {
            this.commentTextView.setVisibility(4);
        }
        this.photoLayout.onInit(this.mediaEnabled);
        this.commentTextView.hidePopup(true);
        this.enterCommentEventSent = false;
        setFocusable(false);
        MessageObject messageObject = this.editingMessageObject;
        if (messageObject != null && (messageObject.isMusic() || (this.editingMessageObject.isDocument() && !this.editingMessageObject.isGif()))) {
            if (this.editingMessageObject.isMusic()) {
                openAudioLayout(false);
                attachAlertLayout = this.audioLayout;
                this.selectedId = 3;
            } else {
                openDocumentsLayout(false);
                attachAlertLayout = this.documentLayout;
                this.selectedId = 4;
            }
            this.typeButtonsAvailable = !this.editingMessageObject.hasValidGroupId();
        } else {
            attachAlertLayout = this.photoLayout;
            this.typeButtonsAvailable = this.avatarPicker == 0;
            this.selectedId = 1;
        }
        this.buttonsRecyclerView.setVisibility(this.typeButtonsAvailable ? 0 : 8);
        this.shadow.setVisibility(this.typeButtonsAvailable ? 0 : 4);
        if (this.currentAttachLayout != attachAlertLayout) {
            if (this.actionBar.isSearchFieldVisible()) {
                this.actionBar.closeSearchField();
            }
            this.containerView.removeView(this.currentAttachLayout);
            this.currentAttachLayout.onHide();
            this.currentAttachLayout.setVisibility(8);
            this.currentAttachLayout.onHidden();
            this.currentAttachLayout = attachAlertLayout;
            setAllowNestedScroll(true);
            if (this.currentAttachLayout.getParent() == null) {
                this.containerView.addView(this.currentAttachLayout, 0, LayoutHelper.createFrame(-1, -1.0f));
            }
            attachAlertLayout.setAlpha(1.0f);
            attachAlertLayout.setVisibility(0);
            attachAlertLayout.onShow();
            attachAlertLayout.onShown();
            this.actionBar.setVisibility(attachAlertLayout.needsActionBar() != 0 ? 0 : 4);
            this.actionBarShadow.setVisibility(this.actionBar.getVisibility());
        }
        AttachAlertLayout attachAlertLayout2 = this.currentAttachLayout;
        ChatAttachAlertPhotoLayout chatAttachAlertPhotoLayout = this.photoLayout;
        if (attachAlertLayout2 != chatAttachAlertPhotoLayout) {
            chatAttachAlertPhotoLayout.setCheckCameraWhenShown(true);
        }
        updateCountButton(0);
        this.buttonsAdapter.notifyDataSetChanged();
        this.commentTextView.setText(BuildConfig.FLAVOR);
        this.buttonsLayoutManager.scrollToPositionWithOffset(0, MediaController.VIDEO_BITRATE_480);
    }

    public void onDestroy() {
        int i = 0;
        while (true) {
            AttachAlertLayout[] attachAlertLayoutArr = this.layouts;
            if (i >= attachAlertLayoutArr.length) {
                break;
            }
            if (attachAlertLayoutArr[i] != null) {
                attachAlertLayoutArr[i].onDestroy();
            }
            i++;
        }
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.reloadInlineHints);
        this.baseFragment = null;
        EditTextEmoji editTextEmoji = this.commentTextView;
        if (editTextEmoji != null) {
            editTextEmoji.onDestroy();
        }
    }

    @Override // org.rbmain.ui.ActionBar.BottomSheet, org.rbmain.ui.ActionBar.BottomSheet.BottomSheetDelegateInterface
    public void onOpenAnimationEnd() {
        MediaController.AlbumEntry albumEntry;
        if (this.baseFragment instanceof ChatActivity) {
            albumEntry = MediaController.allMediaAlbumEntry;
        } else {
            albumEntry = MediaController.allPhotosAlbumEntry;
        }
        if (Build.VERSION.SDK_INT <= 19 && albumEntry == null) {
            MediaController.loadGalleryPhotosAlbums(0);
        }
        this.currentAttachLayout.onOpenAnimationEnd();
        AndroidUtilities.makeAccessibilityAnnouncement(LocaleController.getString("AccDescrAttachButton", R.string.AccDescrAttachButton));
        this.openTransitionFinished = true;
    }

    @Override // org.rbmain.ui.ActionBar.BottomSheet
    public void setAllowDrawContent(boolean z) {
        super.setAllowDrawContent(z);
        this.currentAttachLayout.onContainerTranslationUpdated(this.currentPanTranslationY);
    }

    public void setAvatarPicker(int i, boolean z) {
        this.avatarPicker = i;
        if (i != 0) {
            this.typeButtonsAvailable = false;
            this.buttonsRecyclerView.setVisibility(8);
            this.shadow.setVisibility(8);
            if (this.avatarPicker == 2) {
                this.selectedTextView.setText(LocaleController.getString("ChoosePhotoOrVideo", R.string.ChoosePhotoOrVideo));
                return;
            } else {
                this.selectedTextView.setText(LocaleController.getString("ChoosePhoto", R.string.ChoosePhoto));
                return;
            }
        }
        this.typeButtonsAvailable = true;
    }

    public void setMaxSelectedPhotos(int i, boolean z) {
        if (this.editingMessageObject != null) {
            return;
        }
        this.maxSelectedPhotos = i;
        this.allowOrder = z;
    }

    public void setOpenWithFrontFaceCamera(boolean z) {
        this.openWithFrontFaceCamera = z;
    }

    public ChatAttachAlertPhotoLayout getPhotoLayout() {
        return this.photoLayout;
    }

    private class ButtonsAdapter extends RecyclerListView.SelectionAdapter {
        private int buttonsCount;
        private int contactButton;
        private int documentButton;
        private int galleryButton;
        private int liveButton;
        private int locationButton;
        private Context mContext;
        private int musicButton;
        private int pollButton;

        @Override // org.rbmain.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder viewHolder) {
            return false;
        }

        public ButtonsAdapter(Context context) {
            this.mContext = context;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View attachButton;
            if (i == 0) {
                attachButton = ChatAttachAlert.this.new AttachButton(this.mContext);
            } else {
                attachButton = ChatAttachAlert.this.new AttachBotButton(this.mContext);
            }
            return new RecyclerListView.Holder(attachButton);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            int itemViewType = viewHolder.getItemViewType();
            if (itemViewType != 0) {
                if (itemViewType != 1) {
                    return;
                }
                int i2 = i - this.buttonsCount;
                AttachBotButton attachBotButton = (AttachBotButton) viewHolder.itemView;
                attachBotButton.setTag(Integer.valueOf(i2));
                attachBotButton.setUser(MessagesController.getInstance(ChatAttachAlert.this.currentAccount).getUser(Integer.valueOf(MediaDataController.getInstance(ChatAttachAlert.this.currentAccount).inlineBots.get(i2).peer.user_id)));
                return;
            }
            AttachButton attachButton = (AttachButton) viewHolder.itemView;
            if (i == this.galleryButton) {
                attachButton.setTextAndIcon(1, LocaleController.getString("ChatGallery", R.string.ChatGallery), Theme.chat_attachButtonDrawables[0], Theme.key_chat_attachGalleryBackground, Theme.key_chat_attachGalleryText);
                attachButton.setTag(1);
                return;
            }
            if (i == this.documentButton) {
                attachButton.setTextAndIcon(4, LocaleController.getString("ChatDocument", R.string.ChatDocument), Theme.chat_attachButtonDrawables[2], Theme.key_chat_attachFileBackground, Theme.key_chat_attachFileText);
                attachButton.setTag(4);
                return;
            }
            if (i == this.locationButton) {
                attachButton.setTextAndIcon(6, LocaleController.getString("ChatLocation", R.string.ChatLocation), Theme.chat_attachButtonDrawables[4], Theme.key_chat_attachLocationBackground, Theme.key_chat_attachLocationText);
                attachButton.setTag(6);
                return;
            }
            if (i == this.musicButton) {
                attachButton.setTextAndIcon(3, LocaleController.getString("AttachMusic", R.string.AttachMusic), Theme.chat_attachButtonDrawables[1], Theme.key_chat_attachAudioBackground, Theme.key_chat_attachAudioText);
                attachButton.setTag(3);
                return;
            }
            if (i == this.pollButton) {
                attachButton.setTextAndIcon(9, LocaleController.getString("Poll", R.string.Poll), Theme.chat_attachButtonDrawables[5], Theme.key_chat_attachPollBackground, Theme.key_chat_attachPollText);
                attachButton.setTag(9);
            } else if (i == this.contactButton) {
                attachButton.setTextAndIcon(5, LocaleController.getString("AttachContact", R.string.AttachContact), Theme.chat_attachButtonDrawables[3], Theme.key_chat_attachContactBackground, Theme.key_chat_attachContactText);
                attachButton.setTag(5);
            } else if (i == this.liveButton) {
                attachButton.setTextAndIcon(10, LocaleController.getString("AttachLive", R.string.AttachLive), Theme.chat_attachButtonDrawables[6], Theme.key_chat_attachContactBackground, Theme.key_chat_attachContactText);
                attachButton.setTag(10);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
            ChatAttachAlert.this.applyAttachButtonColors(viewHolder.itemView);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            int i = this.buttonsCount;
            ChatAttachAlert chatAttachAlert = ChatAttachAlert.this;
            return (chatAttachAlert.editingMessageObject == null && (chatAttachAlert.baseFragment instanceof ChatActivity)) ? i + MediaDataController.getInstance(chatAttachAlert.currentAccount).inlineBots.size() : i;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void notifyDataSetChanged() {
            this.buttonsCount = 0;
            this.galleryButton = -1;
            this.documentButton = -1;
            this.musicButton = -1;
            this.pollButton = -1;
            this.contactButton = -1;
            this.locationButton = -1;
            this.liveButton = -1;
            ChatAttachAlert chatAttachAlert = ChatAttachAlert.this;
            if (!(chatAttachAlert.baseFragment instanceof ChatActivity)) {
                int i = 0 + 1;
                this.buttonsCount = i;
                this.galleryButton = 0;
                this.buttonsCount = i + 1;
                this.documentButton = i;
            } else {
                MessageObject messageObject = chatAttachAlert.editingMessageObject;
                if (messageObject == null) {
                    if (chatAttachAlert.mediaEnabled) {
                        int i2 = this.buttonsCount;
                        int i3 = i2 + 1;
                        this.buttonsCount = i3;
                        this.galleryButton = i2;
                        this.buttonsCount = i3 + 1;
                        this.documentButton = i3;
                    }
                    int i4 = this.buttonsCount;
                    this.buttonsCount = i4 + 1;
                    this.locationButton = i4;
                    if (ChatAttachAlert.this.pollsEnabled) {
                        int i5 = this.buttonsCount;
                        this.buttonsCount = i5 + 1;
                        this.pollButton = i5;
                    } else {
                        int i6 = this.buttonsCount;
                        this.buttonsCount = i6 + 1;
                        this.contactButton = i6;
                    }
                    if (ChatAttachAlert.this.mediaEnabled) {
                        int i7 = this.buttonsCount;
                        this.buttonsCount = i7 + 1;
                        this.musicButton = i7;
                    }
                    int i8 = this.buttonsCount;
                    this.buttonsCount = i8 + 1;
                    this.liveButton = i8;
                    BaseFragment baseFragment = ChatAttachAlert.this.baseFragment;
                    TLRPC$User currentUser = baseFragment instanceof ChatActivity ? ((ChatActivity) baseFragment).getCurrentUser() : null;
                    if (currentUser != null && currentUser.bot) {
                        int i9 = this.buttonsCount;
                        this.buttonsCount = i9 + 1;
                        this.contactButton = i9;
                    }
                } else if ((messageObject.isMusic() || ChatAttachAlert.this.editingMessageObject.isDocument()) && ChatAttachAlert.this.editingMessageObject.hasValidGroupId()) {
                    if (ChatAttachAlert.this.editingMessageObject.isMusic()) {
                        int i10 = this.buttonsCount;
                        this.buttonsCount = i10 + 1;
                        this.musicButton = i10;
                    } else {
                        int i11 = this.buttonsCount;
                        this.buttonsCount = i11 + 1;
                        this.documentButton = i11;
                    }
                } else {
                    int i12 = this.buttonsCount;
                    int i13 = i12 + 1;
                    this.buttonsCount = i13;
                    this.galleryButton = i12;
                    int i14 = i13 + 1;
                    this.buttonsCount = i14;
                    this.documentButton = i13;
                    this.buttonsCount = i14 + 1;
                    this.musicButton = i14;
                }
            }
            super.notifyDataSetChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            return i < this.buttonsCount ? 0 : 1;
        }
    }

    @Override // org.rbmain.ui.ActionBar.BottomSheet
    public void dismissInternal() {
        this.delegate.doOnIdle(new Runnable() { // from class: org.rbmain.ui.Components.ChatAttachAlert$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.removeFromRoot();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeFromRoot() {
        ViewGroup viewGroup = this.containerView;
        if (viewGroup != null) {
            viewGroup.setVisibility(4);
        }
        if (this.actionBar.isSearchFieldVisible()) {
            this.actionBar.closeSearchField();
        }
        this.contactsLayout = null;
        this.audioLayout = null;
        this.pollLayout = null;
        this.locationLayout = null;
        this.documentLayout = null;
        int i = 1;
        while (true) {
            AttachAlertLayout[] attachAlertLayoutArr = this.layouts;
            if (i < attachAlertLayoutArr.length) {
                if (attachAlertLayoutArr[i] != null) {
                    attachAlertLayoutArr[i].onDestroy();
                    this.containerView.removeView(this.layouts[i]);
                    this.layouts[i] = null;
                }
                i++;
            } else {
                super.dismissInternal();
                return;
            }
        }
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        if (this.actionBar.isSearchFieldVisible()) {
            this.actionBar.closeSearchField();
            return;
        }
        if (this.currentAttachLayout.onBackPressed()) {
            return;
        }
        EditTextEmoji editTextEmoji = this.commentTextView;
        if (editTextEmoji != null && editTextEmoji.isPopupShowing()) {
            this.commentTextView.hidePopup(true);
        } else {
            super.onBackPressed();
        }
    }

    @Override // org.rbmain.ui.ActionBar.BottomSheet
    public void dismissWithButtonClick(int i) {
        super.dismissWithButtonClick(i);
        this.currentAttachLayout.onDismissWithButtonClick(i);
    }

    @Override // org.rbmain.ui.ActionBar.BottomSheet
    protected boolean canDismissWithTouchOutside() {
        return this.currentAttachLayout.canDismissWithTouchOutside();
    }

    public void dismiss(boolean z) {
        dismiss();
    }

    @Override // org.rbmain.ui.ActionBar.BottomSheet, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        if (this.currentAttachLayout.onDismiss()) {
            return;
        }
        int i = 0;
        while (true) {
            AttachAlertLayout[] attachAlertLayoutArr = this.layouts;
            if (i >= attachAlertLayoutArr.length) {
                break;
            }
            if (attachAlertLayoutArr[i] != null && this.currentAttachLayout != attachAlertLayoutArr[i]) {
                attachAlertLayoutArr[i].onDismiss();
            }
            i++;
        }
        EditTextEmoji editTextEmoji = this.commentTextView;
        if (editTextEmoji != null) {
            AndroidUtilities.hideKeyboard(editTextEmoji.getEditText());
        }
        super.dismiss();
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.currentAttachLayout.onSheetKeyDown(i, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // org.rbmain.ui.ActionBar.BottomSheet
    public void setAllowNestedScroll(boolean z) {
        this.allowNestedScroll = z;
    }

    public BaseFragment getBaseFragment() {
        return this.baseFragment;
    }

    public EditTextEmoji getCommentTextView() {
        return this.commentTextView;
    }
}
