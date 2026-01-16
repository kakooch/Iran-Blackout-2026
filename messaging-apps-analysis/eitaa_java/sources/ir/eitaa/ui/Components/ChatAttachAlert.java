package ir.eitaa.ui.Components;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
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
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ChatObject;
import ir.eitaa.messenger.ContactsController;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MediaController;
import ir.eitaa.messenger.MediaDataController;
import ir.eitaa.messenger.MessageObject;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.messenger.NotificationCenter;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.SendMessagesHelper;
import ir.eitaa.messenger.SharedConfig;
import ir.eitaa.messenger.UserConfig;
import ir.eitaa.tgnet.TLRPC$Chat;
import ir.eitaa.tgnet.TLRPC$MessageMedia;
import ir.eitaa.tgnet.TLRPC$TL_chatAdminRights;
import ir.eitaa.tgnet.TLRPC$TL_liveStreamConfig;
import ir.eitaa.tgnet.TLRPC$TL_messageMediaPoll;
import ir.eitaa.tgnet.TLRPC$User;
import ir.eitaa.ui.ActionBar.ActionBar;
import ir.eitaa.ui.ActionBar.ActionBarMenuItem;
import ir.eitaa.ui.ActionBar.ActionBarMenuSubItem;
import ir.eitaa.ui.ActionBar.ActionBarPopupWindow;
import ir.eitaa.ui.ActionBar.AdjustPanLayoutHelper;
import ir.eitaa.ui.ActionBar.AlertDialog;
import ir.eitaa.ui.ActionBar.BaseFragment;
import ir.eitaa.ui.ActionBar.BottomSheet;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.ActionBar.ThemeDescription;
import ir.eitaa.ui.ChatActivity;
import ir.eitaa.ui.Components.AlertsCreator;
import ir.eitaa.ui.Components.AnimationProperties;
import ir.eitaa.ui.Components.ChatAttachAlertAudioLayout;
import ir.eitaa.ui.Components.ChatAttachAlertContactsLayout;
import ir.eitaa.ui.Components.ChatAttachAlertDocumentLayout;
import ir.eitaa.ui.Components.ChatAttachAlertLocationLayout;
import ir.eitaa.ui.Components.ChatAttachAlertPollLayout;
import ir.eitaa.ui.Components.RecyclerListView;
import ir.eitaa.ui.PassportActivity;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class ChatAttachAlert extends BottomSheet implements NotificationCenter.NotificationCenterDelegate, BottomSheet.BottomSheetDelegateInterface {
    public final Property<AttachAlertLayout, Float> ATTACH_ALERT_LAYOUT_TRANSLATION;
    private final Property<ChatAttachAlert, Float> ATTACH_ALERT_PROGRESS;
    protected ActionBar actionBar;
    private AnimatorSet actionBarAnimation;
    private View actionBarShadow;
    protected boolean allowOrder;
    private final Paint attachButtonPaint;
    private int attachItemSize;
    private ChatAttachAlertAudioLayout audioLayout;
    protected int avatarPicker;
    protected boolean avatarSearch;
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
    private DecelerateInterpolator decelerateInterpolator;
    protected ChatAttachViewDelegate delegate;
    private ChatAttachAlertDocumentLayout documentLayout;
    protected ActionBarMenuItem doneItem;
    protected MessageObject editingMessageObject;
    private boolean enterCommentEventSent;
    private ArrayList<android.graphics.Rect> exclusionRects;
    private android.graphics.Rect exclustionRect;
    private final boolean forceDarkTheme;
    private FrameLayout frameLayout2;
    private float fromScrollY;
    protected boolean inBubbleMode;
    private ActionBarMenuSubItem[] itemCells;
    private AttachAlertLayout[] layouts;
    private ChatAttachAlertLocationLayout locationLayout;
    protected int maxSelectedPhotos;
    private boolean mediaEnabled;
    private AnimatorSet menuAnimator;
    private boolean menuShowed;
    private AttachAlertLayout nextAttachLayout;
    private boolean openTransitionFinished;
    protected boolean openWithFrontFaceCamera;
    private Paint paint;
    protected boolean paused;
    private ChatAttachAlertPhotoLayout photoLayout;
    private ChatAttachAlertPollLayout pollLayout;
    private boolean pollsEnabled;
    private int previousScrollOffsetY;
    private RectF rect;
    protected int[] scrollOffsetY;
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
    private final boolean showingFromDialog;
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
        void didPressedButton(int button, boolean arg, boolean notify, int scheduleDate, boolean forceDocument);

        void didSelectBot(TLRPC$User user);

        void doOnIdle(Runnable runnable);

        boolean needEnterComment();

        void onCameraOpened();
    }

    static /* synthetic */ boolean lambda$new$8(View view, MotionEvent motionEvent) {
        return true;
    }

    @Override // ir.eitaa.ui.ActionBar.BottomSheet.BottomSheetDelegateInterface
    public boolean canDismiss() {
        return true;
    }

    @Override // ir.eitaa.ui.ActionBar.BottomSheet
    protected boolean canDismissWithSwipe() {
        return false;
    }

    public float getClipLayoutBottom() {
        return this.frameLayout2.getMeasuredHeight() - ((this.frameLayout2.getMeasuredHeight() - AndroidUtilities.dp(84.0f)) * (1.0f - this.frameLayout2.getAlpha()));
    }

    public static class AttachAlertLayout extends FrameLayout {
        protected ChatAttachAlert parentAlert;
        protected final Theme.ResourcesProvider resourcesProvider;

        void applyCaption(String text) {
        }

        boolean canDismissWithTouchOutside() {
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

        void onContainerTranslationUpdated(float currentPanTranslationY) {
        }

        boolean onContainerViewTouchEvent(MotionEvent event) {
            return false;
        }

        void onDestroy() {
        }

        boolean onDismiss() {
            return false;
        }

        void onDismissWithButtonClick(int item) {
        }

        void onHidden() {
        }

        void onHide() {
        }

        void onHideShowProgress(float progress) {
        }

        void onMenuItemClick(int id) {
        }

        void onOpenAnimationEnd() {
        }

        void onPause() {
        }

        void onPreMeasure(int availableWidth, int availableHeight) {
        }

        void onResume() {
        }

        void onSelectedItemsCountChanged(int count) {
        }

        boolean onSheetKeyDown(int keyCode, KeyEvent event) {
            return false;
        }

        void onShow() {
        }

        void onShown() {
        }

        void scrollToTop() {
        }

        void sendSelectedItems(boolean notify, int scheduleDate) {
        }

        public AttachAlertLayout(ChatAttachAlert alert, Context context, Theme.ResourcesProvider resourcesProvider) {
            super(context);
            this.resourcesProvider = resourcesProvider;
            this.parentAlert = alert;
        }

        int getButtonsHideOffset() {
            return AndroidUtilities.dp(needsActionBar() != 0 ? 12.0f : 17.0f);
        }

        protected int getThemedColor(String key) {
            Theme.ResourcesProvider resourcesProvider = this.resourcesProvider;
            Integer color = resourcesProvider != null ? resourcesProvider.getColor(key) : null;
            return color != null ? color.intValue() : Theme.getColor(key);
        }
    }

    private class AttachButton extends FrameLayout {
        private String backgroundKey;
        private Animator checkAnimator;
        private boolean checked;
        private float checkedState;
        private int currentId;
        private RLottieImageView imageView;
        private String textKey;
        private TextView textView;

        @Override // android.view.View
        public boolean hasOverlappingRendering() {
            return false;
        }

        public AttachButton(Context context) {
            super(context);
            setWillNotDraw(false);
            RLottieImageView rLottieImageView = new RLottieImageView(context) { // from class: ir.eitaa.ui.Components.ChatAttachAlert.AttachButton.1
                @Override // android.view.View
                public void setScaleX(float scaleX) {
                    super.setScaleX(scaleX);
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
            this.textView.setTextColor(ChatAttachAlert.this.getThemedColor("dialogTextGray2"));
            this.textView.setTextSize(1, 12.0f);
            this.textView.setTypeface(AndroidUtilities.getFontFamily(false));
            this.textView.setLineSpacing(-AndroidUtilities.dp(2.0f), 1.0f);
            addView(this.textView, LayoutHelper.createFrame(-1, -2.0f, 51, 0.0f, 62.0f, 0.0f, 0.0f));
        }

        void updateCheckedState(boolean animate) {
            if (this.checked == (this.currentId == ChatAttachAlert.this.selectedId)) {
                return;
            }
            this.checked = this.currentId == ChatAttachAlert.this.selectedId;
            Animator animator = this.checkAnimator;
            if (animator != null) {
                animator.cancel();
            }
            if (animate) {
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
        public void setCheckedState(float state) {
            this.checkedState = state;
            float f = 1.0f - (state * 0.06f);
            this.imageView.setScaleX(f);
            this.imageView.setScaleY(f);
            this.textView.setTextColor(ColorUtils.blendARGB(ChatAttachAlert.this.getThemedColor("dialogTextGray2"), ChatAttachAlert.this.getThemedColor(this.textKey), this.checkedState));
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
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(ChatAttachAlert.this.attachItemSize, 1073741824), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(84.0f), 1073741824));
        }

        public void setTextAndIcon(int id, CharSequence text, RLottieDrawable drawable, String background, String textColor) {
            this.currentId = id;
            this.textView.setText(text);
            this.imageView.setAnimation(drawable);
            this.backgroundKey = background;
            this.textKey = textColor;
            this.textView.setTextColor(ColorUtils.blendARGB(ChatAttachAlert.this.getThemedColor("dialogTextGray2"), ChatAttachAlert.this.getThemedColor(this.textKey), this.checkedState));
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            float scaleX = this.imageView.getScaleX() + (this.checkedState * 0.06f);
            float fDp = AndroidUtilities.dp(23.0f) * scaleX;
            float left = this.imageView.getLeft() + (this.imageView.getMeasuredWidth() / 2);
            float top = this.imageView.getTop() + (this.imageView.getMeasuredWidth() / 2);
            ChatAttachAlert.this.attachButtonPaint.setColor(ChatAttachAlert.this.getThemedColor(this.backgroundKey));
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
                view.setBackgroundDrawable(Theme.createSelectorDrawable(ChatAttachAlert.this.getThemedColor("dialogButtonSelector"), 1, AndroidUtilities.dp(23.0f)));
                addView(view, LayoutHelper.createFrame(46, 46.0f, 49, 0.0f, 9.0f, 0.0f, 0.0f));
            }
            TextView textView = new TextView(context);
            this.nameTextView = textView;
            textView.setTextSize(1, 12.0f);
            this.nameTextView.setTypeface(AndroidUtilities.getFontFamily(false));
            this.nameTextView.setGravity(49);
            this.nameTextView.setLines(1);
            this.nameTextView.setSingleLine(true);
            this.nameTextView.setEllipsize(TextUtils.TruncateAt.END);
            addView(this.nameTextView, LayoutHelper.createFrame(-1, -2.0f, 51, 6.0f, 60.0f, 6.0f, 0.0f));
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(ChatAttachAlert.this.attachItemSize, 1073741824), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(100.0f), 1073741824));
        }

        public void setUser(TLRPC$User user) {
            if (user == null) {
                return;
            }
            this.nameTextView.setTextColor(ChatAttachAlert.this.getThemedColor("dialogTextGray2"));
            this.currentUser = user;
            this.nameTextView.setText(ContactsController.formatName(user.first_name, user.last_name));
            this.avatarDrawable.setInfo(user);
            this.imageView.setForUserOrChat(user, this.avatarDrawable);
            requestLayout();
        }
    }

    public ChatAttachAlert(Context context, final BaseFragment parentFragment, boolean forceDarkTheme, boolean showingFromDialog) {
        this(context, parentFragment, forceDarkTheme, showingFromDialog, null);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public ChatAttachAlert(Context context, final BaseFragment parentFragment, boolean forceDarkTheme, boolean showingFromDialog, final Theme.ResourcesProvider resourcesProvider) {
        super(context, false, resourcesProvider);
        this.ATTACH_ALERT_LAYOUT_TRANSLATION = new AnimationProperties.FloatProperty<AttachAlertLayout>("translation") { // from class: ir.eitaa.ui.Components.ChatAttachAlert.1
            @Override // ir.eitaa.ui.Components.AnimationProperties.FloatProperty
            public void setValue(AttachAlertLayout object, float value) {
                if (value > 0.7f) {
                    float f = 1.0f - ((1.0f - value) / 0.3f);
                    if (ChatAttachAlert.this.nextAttachLayout == ChatAttachAlert.this.locationLayout) {
                        ChatAttachAlert.this.currentAttachLayout.setAlpha(1.0f - f);
                        ChatAttachAlert.this.nextAttachLayout.setAlpha(1.0f);
                    } else {
                        ChatAttachAlert.this.nextAttachLayout.setAlpha(f);
                        ChatAttachAlert.this.nextAttachLayout.onHideShowProgress(f);
                    }
                } else if (ChatAttachAlert.this.nextAttachLayout == ChatAttachAlert.this.locationLayout) {
                    ChatAttachAlert.this.nextAttachLayout.setAlpha(0.0f);
                }
                if (ChatAttachAlert.this.nextAttachLayout == ChatAttachAlert.this.pollLayout || ChatAttachAlert.this.currentAttachLayout == ChatAttachAlert.this.pollLayout) {
                    ChatAttachAlert chatAttachAlert = ChatAttachAlert.this;
                    chatAttachAlert.updateSelectedPosition(chatAttachAlert.nextAttachLayout == ChatAttachAlert.this.pollLayout ? 1 : 0);
                }
                ChatAttachAlert.this.nextAttachLayout.setTranslationY(AndroidUtilities.dp(78.0f) * value);
                ChatAttachAlert.this.currentAttachLayout.onHideShowProgress(1.0f - Math.min(1.0f, value / 0.7f));
                ChatAttachAlert.this.currentAttachLayout.onContainerTranslationUpdated(ChatAttachAlert.this.currentPanTranslationY);
                ((BottomSheet) ChatAttachAlert.this).containerView.invalidate();
            }

            @Override // android.util.Property
            public Float get(AttachAlertLayout object) {
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
        this.decelerateInterpolator = new DecelerateInterpolator();
        this.scrollOffsetY = new int[2];
        this.attachButtonPaint = new Paint(1);
        this.exclusionRects = new ArrayList<>();
        this.exclustionRect = new android.graphics.Rect();
        this.ATTACH_ALERT_PROGRESS = new AnimationProperties.FloatProperty<ChatAttachAlert>("openProgress") { // from class: ir.eitaa.ui.Components.ChatAttachAlert.16
            private float openProgress;

            @Override // ir.eitaa.ui.Components.AnimationProperties.FloatProperty
            public void setValue(ChatAttachAlert object, float value) {
                float interpolation;
                int childCount = ChatAttachAlert.this.buttonsRecyclerView.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    float f = (3 - i) * 32.0f;
                    View childAt = ChatAttachAlert.this.buttonsRecyclerView.getChildAt(i);
                    if (value > f) {
                        float f2 = value - f;
                        interpolation = 1.0f;
                        if (f2 <= 200.0f) {
                            float f3 = f2 / 200.0f;
                            interpolation = CubicBezierInterpolator.EASE_OUT.getInterpolation(f3) * 1.1f;
                            childAt.setAlpha(CubicBezierInterpolator.EASE_BOTH.getInterpolation(f3));
                        } else {
                            childAt.setAlpha(1.0f);
                            float f4 = f2 - 200.0f;
                            if (f4 <= 100.0f) {
                                interpolation = 1.1f - (CubicBezierInterpolator.EASE_IN.getInterpolation(f4 / 100.0f) * 0.1f);
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
            public Float get(ChatAttachAlert object) {
                return Float.valueOf(this.openProgress);
            }
        };
        this.forceDarkTheme = forceDarkTheme;
        this.showingFromDialog = showingFromDialog;
        this.drawNavigationBar = true;
        this.inBubbleMode = (parentFragment instanceof ChatActivity) && parentFragment.isInBubbleMode();
        this.openInterpolator = new OvershootInterpolator(0.7f);
        this.baseFragment = parentFragment;
        this.useSmoothKeyboard = true;
        this.textPaint.setTypeface(AndroidUtilities.getFontFamily(false));
        setDelegate(this);
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.reloadInlineHints);
        this.exclusionRects.add(this.exclustionRect);
        AnonymousClass2 anonymousClass2 = new AnonymousClass2(context, forceDarkTheme);
        this.sizeNotifierFrameLayout = anonymousClass2;
        this.containerView = anonymousClass2;
        anonymousClass2.setWillNotDraw(false);
        this.containerView.setClipChildren(false);
        ViewGroup viewGroup = this.containerView;
        int i = this.backgroundPaddingLeft;
        viewGroup.setPadding(i, 0, i, 0);
        ActionBar actionBar = new ActionBar(context, resourcesProvider) { // from class: ir.eitaa.ui.Components.ChatAttachAlert.3
            @Override // android.view.View
            public void setAlpha(float alpha) {
                super.setAlpha(alpha);
                ((BottomSheet) ChatAttachAlert.this).containerView.invalidate();
                if (ChatAttachAlert.this.frameLayout2 != null) {
                    ChatAttachAlert chatAttachAlert = ChatAttachAlert.this;
                    if (chatAttachAlert.buttonsRecyclerView != null) {
                        if (chatAttachAlert.frameLayout2.getTag() != null) {
                            float f = alpha != 0.0f ? 0.0f : 1.0f;
                            if (ChatAttachAlert.this.buttonsRecyclerView.getAlpha() != f) {
                                ChatAttachAlert.this.buttonsRecyclerView.setAlpha(f);
                                return;
                            }
                            return;
                        }
                        float f2 = 1.0f - alpha;
                        ChatAttachAlert.this.buttonsRecyclerView.setAlpha(f2);
                        ChatAttachAlert.this.shadow.setAlpha(f2);
                        ChatAttachAlert.this.buttonsRecyclerView.setTranslationY(AndroidUtilities.dp(44.0f) * alpha);
                        ChatAttachAlert.this.frameLayout2.setTranslationY(AndroidUtilities.dp(48.0f) * alpha);
                        ChatAttachAlert.this.shadow.setTranslationY(AndroidUtilities.dp(84.0f) * alpha);
                    }
                }
            }
        };
        this.actionBar = actionBar;
        actionBar.setBackgroundColor(getThemedColor("dialogBackground"));
        this.actionBar.setBackButtonImage(R.drawable.ic_ab_back);
        this.actionBar.setItemsColor(getThemedColor("dialogTextBlack"), false);
        this.actionBar.setItemsBackgroundColor(getThemedColor("dialogButtonSelector"), false);
        this.actionBar.setTitleColor(getThemedColor("dialogTextBlack"));
        this.actionBar.setOccupyStatusBar(false);
        this.actionBar.setAlpha(0.0f);
        this.actionBar.setActionBarMenuOnItemClick(new ActionBar.ActionBarMenuOnItemClick() { // from class: ir.eitaa.ui.Components.ChatAttachAlert.4
            @Override // ir.eitaa.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
            public void onItemClick(int id) {
                if (id == -1) {
                    if (ChatAttachAlert.this.currentAttachLayout.onBackPressed()) {
                        return;
                    }
                    ChatAttachAlert.this.dismiss();
                    return;
                }
                ChatAttachAlert.this.currentAttachLayout.onMenuItemClick(id);
            }
        });
        ActionBarMenuItem actionBarMenuItem = new ActionBarMenuItem(context, null, 0, getThemedColor("dialogTextBlack"), false, resourcesProvider);
        this.selectedMenuItem = actionBarMenuItem;
        actionBarMenuItem.setLongClickEnabled(false);
        this.selectedMenuItem.setIcon(R.drawable.ic_ab_other);
        this.selectedMenuItem.setContentDescription(LocaleController.getString("AccDescrMoreOptions", R.string.AccDescrMoreOptions));
        this.selectedMenuItem.setVisibility(4);
        this.selectedMenuItem.setAlpha(0.0f);
        this.selectedMenuItem.setSubMenuOpenSide(2);
        this.selectedMenuItem.setDelegate(new ActionBarMenuItem.ActionBarMenuItemDelegate() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatAttachAlert$H9rAvQ7GtQWDSiBQfRQTSCR6yVE
            @Override // ir.eitaa.ui.ActionBar.ActionBarMenuItem.ActionBarMenuItemDelegate
            public final void onItemClick(int i2) {
                this.f$0.lambda$new$0$ChatAttachAlert(i2);
            }
        });
        this.selectedMenuItem.setAdditionalYOffset(AndroidUtilities.dp(72.0f));
        this.selectedMenuItem.setTranslationX(AndroidUtilities.dp(6.0f));
        this.selectedMenuItem.setBackgroundDrawable(Theme.createSelectorDrawable(getThemedColor("dialogButtonSelector"), 6));
        this.selectedMenuItem.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatAttachAlert$g1VUi3nIXVZuv-M_KZ5j4SAFgWY
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$new$1$ChatAttachAlert(view);
            }
        });
        ActionBarMenuItem actionBarMenuItem2 = new ActionBarMenuItem(context, null, 0, getThemedColor("windowBackgroundWhiteBlueHeader"), true, resourcesProvider);
        this.doneItem = actionBarMenuItem2;
        actionBarMenuItem2.setLongClickEnabled(false);
        this.doneItem.setText(LocaleController.getString("Create", R.string.Create).toUpperCase());
        this.doneItem.setVisibility(4);
        this.doneItem.setAlpha(0.0f);
        this.doneItem.setTranslationX(-AndroidUtilities.dp(12.0f));
        this.doneItem.setBackgroundDrawable(Theme.createSelectorDrawable(getThemedColor("dialogButtonSelector"), 3));
        this.doneItem.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatAttachAlert$KNbk5ysAfkEZO04W7dE9ioJL9tg
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$new$2$ChatAttachAlert(view);
            }
        });
        TextView textView = new TextView(context) { // from class: ir.eitaa.ui.Components.ChatAttachAlert.5
            @Override // android.view.View
            public void setAlpha(float alpha) {
                super.setAlpha(alpha);
                ChatAttachAlert.this.updateSelectedPosition(0);
                ((BottomSheet) ChatAttachAlert.this).containerView.invalidate();
            }

            @Override // android.view.View
            public void setTranslationY(float translationY) {
                super.setTranslationY(translationY);
            }
        };
        this.selectedTextView = textView;
        textView.setTextColor(getThemedColor("dialogTextBlack"));
        this.selectedTextView.setTextSize(1, 16.0f);
        this.selectedTextView.setTypeface(AndroidUtilities.getFontFamily(true));
        this.selectedTextView.setGravity(51);
        this.selectedTextView.setVisibility(4);
        this.selectedTextView.setAlpha(0.0f);
        AttachAlertLayout[] attachAlertLayoutArr = this.layouts;
        ChatAttachAlertPhotoLayout chatAttachAlertPhotoLayout = new ChatAttachAlertPhotoLayout(this, context, forceDarkTheme, resourcesProvider);
        this.photoLayout = chatAttachAlertPhotoLayout;
        attachAlertLayoutArr[0] = chatAttachAlertPhotoLayout;
        this.currentAttachLayout = chatAttachAlertPhotoLayout;
        this.selectedId = 1;
        this.containerView.addView(chatAttachAlertPhotoLayout, LayoutHelper.createFrame(-1, -1.0f));
        this.containerView.addView(this.selectedTextView, LayoutHelper.createFrame(-1, -2.0f, 51, 23.0f, 0.0f, 48.0f, 0.0f));
        this.containerView.addView(this.actionBar, LayoutHelper.createFrame(-1, -2.0f));
        this.containerView.addView(this.selectedMenuItem, LayoutHelper.createFrame(48, 48, 53));
        this.containerView.addView(this.doneItem, LayoutHelper.createFrame(-2, 48, 53));
        View view = new View(context);
        this.actionBarShadow = view;
        view.setAlpha(0.0f);
        this.actionBarShadow.setBackgroundColor(getThemedColor("dialogShadowLine"));
        this.containerView.addView(this.actionBarShadow, LayoutHelper.createFrame(-1, 1.0f));
        View view2 = new View(context);
        this.shadow = view2;
        view2.setBackgroundResource(R.drawable.attach_shadow);
        this.shadow.getBackground().setColorFilter(new PorterDuffColorFilter(-16777216, PorterDuff.Mode.MULTIPLY));
        this.containerView.addView(this.shadow, LayoutHelper.createFrame(-1, 2.0f, 83, 0.0f, 0.0f, 0.0f, 84.0f));
        RecyclerListView recyclerListView = new RecyclerListView(context) { // from class: ir.eitaa.ui.Components.ChatAttachAlert.6
            @Override // ir.eitaa.ui.Components.RecyclerListView, android.view.View
            public void setTranslationY(float translationY) {
                super.setTranslationY(translationY);
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
        this.buttonsRecyclerView.setGlowColor(getThemedColor("dialogScrollGlow"));
        this.buttonsRecyclerView.setBackgroundColor(getThemedColor("dialogBackground"));
        this.containerView.addView(this.buttonsRecyclerView, LayoutHelper.createFrame(-1, 84, 83));
        this.buttonsRecyclerView.setOnItemClickListener(new RecyclerListView.OnItemClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatAttachAlert$4ZeIX-0e0RPQ6wfFgOjKG7YJkhs
            @Override // ir.eitaa.ui.Components.RecyclerListView.OnItemClickListener
            public final void onItemClick(View view3, int i2) {
                this.f$0.lambda$new$5$ChatAttachAlert(resourcesProvider, view3, i2);
            }
        });
        this.buttonsRecyclerView.setOnItemLongClickListener(new RecyclerListView.OnItemLongClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatAttachAlert$x42z7gwbhWQcXzvNyio3bLzRKqU
            @Override // ir.eitaa.ui.Components.RecyclerListView.OnItemLongClickListener
            public final boolean onItemClick(View view3, int i2) {
                return this.f$0.lambda$new$7$ChatAttachAlert(view3, i2);
            }
        });
        AnonymousClass7 anonymousClass7 = new AnonymousClass7(context, forceDarkTheme);
        this.frameLayout2 = anonymousClass7;
        anonymousClass7.setWillNotDraw(false);
        this.frameLayout2.setVisibility(4);
        this.frameLayout2.setAlpha(0.0f);
        this.containerView.addView(this.frameLayout2, LayoutHelper.createFrame(-1, -2, 83));
        this.frameLayout2.setOnTouchListener(new View.OnTouchListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatAttachAlert$jDm1GyR_iMhMwkW0vXHUAQjVKg4
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view3, MotionEvent motionEvent) {
                return ChatAttachAlert.lambda$new$8(view3, motionEvent);
            }
        });
        NumberTextView numberTextView = new NumberTextView(context);
        this.captionLimitView = numberTextView;
        numberTextView.setVisibility(8);
        numberTextView.setTextSize(15);
        numberTextView.setTextColor(getThemedColor("windowBackgroundWhiteGrayText"));
        numberTextView.setTypeface(AndroidUtilities.getFontFamily(true));
        numberTextView.setCenterAlign(true);
        this.frameLayout2.addView(numberTextView, LayoutHelper.createFrame(56, 20.0f, 85, 3.0f, 0.0f, 14.0f, 78.0f));
        this.currentLimit = MessagesController.getInstance(UserConfig.selectedAccount).maxCaptionLength;
        AnonymousClass8 anonymousClass8 = new AnonymousClass8(context, this.sizeNotifierFrameLayout, null, 1, resourcesProvider);
        this.commentTextView = anonymousClass8;
        anonymousClass8.setHint(LocaleController.getString("AddCaption", R.string.AddCaption));
        this.commentTextView.onResume();
        this.commentTextView.getEditText().addTextChangedListener(new AnonymousClass9());
        this.frameLayout2.addView(this.commentTextView, LayoutHelper.createFrame(-1, -2.0f, 83, 0.0f, 0.0f, 84.0f, 0.0f));
        this.frameLayout2.setClipChildren(false);
        this.commentTextView.setClipChildren(false);
        FrameLayout frameLayout = new FrameLayout(context) { // from class: ir.eitaa.ui.Components.ChatAttachAlert.10
            @Override // android.view.View
            public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
                super.onInitializeAccessibilityNodeInfo(info);
                if (ChatAttachAlert.this.currentAttachLayout == ChatAttachAlert.this.photoLayout) {
                    info.setText(LocaleController.formatPluralString("AccDescrSendPhotos", ChatAttachAlert.this.photoLayout.getSelectedItemsCount()));
                } else if (ChatAttachAlert.this.currentAttachLayout == ChatAttachAlert.this.documentLayout) {
                    info.setText(LocaleController.formatPluralString("AccDescrSendFiles", ChatAttachAlert.this.documentLayout.getSelectedItemsCount()));
                } else if (ChatAttachAlert.this.currentAttachLayout == ChatAttachAlert.this.audioLayout) {
                    info.setText(LocaleController.formatPluralString("AccDescrSendAudio", ChatAttachAlert.this.audioLayout.getSelectedItemsCount()));
                }
                info.setClassName(Button.class.getName());
                info.setLongClickable(true);
                info.setClickable(true);
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
        int themedColor = getThemedColor("dialogFloatingButton");
        int i2 = Build.VERSION.SDK_INT;
        this.writeButtonDrawable = Theme.createSimpleSelectorCircleDrawable(iDp, themedColor, getThemedColor(i2 >= 21 ? "dialogFloatingButtonPressed" : "dialogFloatingButton"));
        if (i2 < 21) {
            Drawable drawableMutate = context.getResources().getDrawable(R.drawable.floating_shadow_profile).mutate();
            drawableMutate.setColorFilter(new PorterDuffColorFilter(-16777216, PorterDuff.Mode.MULTIPLY));
            CombinedDrawable combinedDrawable = new CombinedDrawable(drawableMutate, this.writeButtonDrawable, 0, 0);
            combinedDrawable.setIconSize(AndroidUtilities.dp(56.0f), AndroidUtilities.dp(56.0f));
            this.writeButtonDrawable = combinedDrawable;
        }
        this.writeButton.setBackgroundDrawable(this.writeButtonDrawable);
        this.writeButton.setImageResource(R.drawable.attach_send);
        this.writeButton.setColorFilter(new PorterDuffColorFilter(getThemedColor("dialogFloatingIcon"), PorterDuff.Mode.MULTIPLY));
        this.writeButton.setImportantForAccessibility(2);
        this.writeButton.setScaleType(ImageView.ScaleType.CENTER);
        if (i2 >= 21) {
            this.writeButton.setOutlineProvider(new ViewOutlineProvider() { // from class: ir.eitaa.ui.Components.ChatAttachAlert.11
                @Override // android.view.ViewOutlineProvider
                @SuppressLint({"NewApi"})
                public void getOutline(View view3, Outline outline) {
                    outline.setOval(0, 0, AndroidUtilities.dp(56.0f), AndroidUtilities.dp(56.0f));
                }
            });
        }
        this.writeButtonContainer.addView(this.writeButton, LayoutHelper.createFrame(i2 >= 21 ? 56 : 60, i2 >= 21 ? 56.0f : 60.0f, 51, i2 >= 21 ? 2.0f : 0.0f, 0.0f, 0.0f, 0.0f));
        this.writeButton.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatAttachAlert$9iNqkgn-pz64L2qPF1-eY1YCw1Q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                this.f$0.lambda$new$10$ChatAttachAlert(resourcesProvider, view3);
            }
        });
        this.textPaint.setTextSize(AndroidUtilities.dp(12.0f));
        this.textPaint.setTypeface(AndroidUtilities.getFontFamily(true));
        View view3 = new View(context) { // from class: ir.eitaa.ui.Components.ChatAttachAlert.12
            @Override // android.view.View
            protected void onDraw(Canvas canvas) {
                String str = String.format("%d", Integer.valueOf(Math.max(1, ChatAttachAlert.this.currentAttachLayout.getSelectedItemsCount())));
                int iMax = Math.max(AndroidUtilities.dp(16.0f) + ((int) Math.ceil(ChatAttachAlert.this.textPaint.measureText(str))), AndroidUtilities.dp(24.0f));
                int measuredWidth = getMeasuredWidth() / 2;
                int themedColor2 = ChatAttachAlert.this.getThemedColor("dialogRoundCheckBoxCheck");
                TextPaint textPaint = ChatAttachAlert.this.textPaint;
                double dAlpha = Color.alpha(themedColor2);
                double d = ChatAttachAlert.this.sendButtonEnabledProgress;
                Double.isNaN(d);
                Double.isNaN(dAlpha);
                textPaint.setColor(ColorUtils.setAlphaComponent(themedColor2, (int) (dAlpha * ((d * 0.42d) + 0.58d))));
                ChatAttachAlert.this.paint.setColor(ChatAttachAlert.this.getThemedColor("dialogBackground"));
                int i3 = iMax / 2;
                ChatAttachAlert.this.rect.set(measuredWidth - i3, 0.0f, i3 + measuredWidth, getMeasuredHeight());
                canvas.drawRoundRect(ChatAttachAlert.this.rect, AndroidUtilities.dp(12.0f), AndroidUtilities.dp(12.0f), ChatAttachAlert.this.paint);
                ChatAttachAlert.this.paint.setColor(ChatAttachAlert.this.getThemedColor("dialogRoundCheckBox"));
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
        if (forceDarkTheme) {
            checkColors();
            this.navBarColorKey = null;
        }
    }

    /* renamed from: ir.eitaa.ui.Components.ChatAttachAlert$2, reason: invalid class name */
    class AnonymousClass2 extends SizeNotifierFrameLayout {
        AdjustPanLayoutHelper adjustPanLayoutHelper;
        private boolean ignoreLayout;
        private float initialTranslationY;
        private int lastNotifyWidth;
        private RectF rect;
        final /* synthetic */ boolean val$forceDarkTheme;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Context context, final boolean val$forceDarkTheme) {
            super(context);
            this.val$forceDarkTheme = val$forceDarkTheme;
            this.rect = new RectF();
            this.adjustPanLayoutHelper = new AdjustPanLayoutHelper(this) { // from class: ir.eitaa.ui.Components.ChatAttachAlert.2.1
                /* JADX WARN: Removed duplicated region for block: B:8:0x0037  */
                @Override // ir.eitaa.ui.ActionBar.AdjustPanLayoutHelper
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                protected void onTransitionStart(boolean r4, int r5) {
                    /*
                        r3 = this;
                        super.onTransitionStart(r4, r5)
                        ir.eitaa.ui.Components.ChatAttachAlert$2 r5 = ir.eitaa.ui.Components.ChatAttachAlert.AnonymousClass2.this
                        ir.eitaa.ui.Components.ChatAttachAlert r5 = ir.eitaa.ui.Components.ChatAttachAlert.this
                        int r5 = ir.eitaa.ui.Components.ChatAttachAlert.access$1700(r5)
                        if (r5 <= 0) goto L37
                        ir.eitaa.ui.Components.ChatAttachAlert$2 r5 = ir.eitaa.ui.Components.ChatAttachAlert.AnonymousClass2.this
                        ir.eitaa.ui.Components.ChatAttachAlert r5 = ir.eitaa.ui.Components.ChatAttachAlert.this
                        int r5 = ir.eitaa.ui.Components.ChatAttachAlert.access$1700(r5)
                        ir.eitaa.ui.Components.ChatAttachAlert$2 r0 = ir.eitaa.ui.Components.ChatAttachAlert.AnonymousClass2.this
                        ir.eitaa.ui.Components.ChatAttachAlert r0 = ir.eitaa.ui.Components.ChatAttachAlert.this
                        int[] r1 = r0.scrollOffsetY
                        r2 = 0
                        r1 = r1[r2]
                        if (r5 == r1) goto L37
                        if (r4 == 0) goto L37
                        int r4 = ir.eitaa.ui.Components.ChatAttachAlert.access$1700(r0)
                        float r4 = (float) r4
                        ir.eitaa.ui.Components.ChatAttachAlert.access$1802(r0, r4)
                        ir.eitaa.ui.Components.ChatAttachAlert$2 r4 = ir.eitaa.ui.Components.ChatAttachAlert.AnonymousClass2.this
                        ir.eitaa.ui.Components.ChatAttachAlert r4 = ir.eitaa.ui.Components.ChatAttachAlert.this
                        int[] r5 = r4.scrollOffsetY
                        r5 = r5[r2]
                        float r5 = (float) r5
                        ir.eitaa.ui.Components.ChatAttachAlert.access$1902(r4, r5)
                        goto L40
                    L37:
                        ir.eitaa.ui.Components.ChatAttachAlert$2 r4 = ir.eitaa.ui.Components.ChatAttachAlert.AnonymousClass2.this
                        ir.eitaa.ui.Components.ChatAttachAlert r4 = ir.eitaa.ui.Components.ChatAttachAlert.this
                        r5 = -1082130432(0xffffffffbf800000, float:-1.0)
                        ir.eitaa.ui.Components.ChatAttachAlert.access$1802(r4, r5)
                    L40:
                        ir.eitaa.ui.Components.ChatAttachAlert$2 r4 = ir.eitaa.ui.Components.ChatAttachAlert.AnonymousClass2.this
                        r4.invalidate()
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Components.ChatAttachAlert.AnonymousClass2.AnonymousClass1.onTransitionStart(boolean, int):void");
                }

                @Override // ir.eitaa.ui.ActionBar.AdjustPanLayoutHelper
                protected void onTransitionEnd() {
                    super.onTransitionEnd();
                    ChatAttachAlert chatAttachAlert = ChatAttachAlert.this;
                    chatAttachAlert.updateLayout(chatAttachAlert.currentAttachLayout, false, 0);
                    ChatAttachAlert chatAttachAlert2 = ChatAttachAlert.this;
                    chatAttachAlert2.previousScrollOffsetY = chatAttachAlert2.scrollOffsetY[0];
                }

                @Override // ir.eitaa.ui.ActionBar.AdjustPanLayoutHelper
                protected void onPanTranslationUpdate(float y, float progress, boolean keyboardVisible) {
                    ChatAttachAlert chatAttachAlert = ChatAttachAlert.this;
                    chatAttachAlert.currentPanTranslationY = y;
                    if (chatAttachAlert.fromScrollY > 0.0f) {
                        ChatAttachAlert chatAttachAlert2 = ChatAttachAlert.this;
                        chatAttachAlert2.currentPanTranslationY += (chatAttachAlert2.fromScrollY - ChatAttachAlert.this.toScrollY) * (1.0f - progress);
                    }
                    ChatAttachAlert chatAttachAlert3 = ChatAttachAlert.this;
                    chatAttachAlert3.actionBar.setTranslationY(chatAttachAlert3.currentPanTranslationY);
                    ChatAttachAlert chatAttachAlert4 = ChatAttachAlert.this;
                    chatAttachAlert4.selectedMenuItem.setTranslationY(chatAttachAlert4.currentPanTranslationY);
                    ChatAttachAlert chatAttachAlert5 = ChatAttachAlert.this;
                    chatAttachAlert5.doneItem.setTranslationY(chatAttachAlert5.currentPanTranslationY);
                    ChatAttachAlert.this.actionBarShadow.setTranslationY(ChatAttachAlert.this.currentPanTranslationY);
                    ChatAttachAlert.this.updateSelectedPosition(0);
                    ChatAttachAlert chatAttachAlert6 = ChatAttachAlert.this;
                    chatAttachAlert6.setCurrentPanTranslationY(chatAttachAlert6.currentPanTranslationY);
                    AnonymousClass2.this.invalidate();
                    ChatAttachAlert.this.frameLayout2.invalidate();
                    if (ChatAttachAlert.this.currentAttachLayout != null) {
                        ChatAttachAlert.this.currentAttachLayout.onContainerTranslationUpdated(ChatAttachAlert.this.currentPanTranslationY);
                    }
                }

                @Override // ir.eitaa.ui.ActionBar.AdjustPanLayoutHelper
                protected boolean heightAnimationEnabled() {
                    if (ChatAttachAlert.this.isDismissed() || !ChatAttachAlert.this.openTransitionFinished) {
                        return false;
                    }
                    return !ChatAttachAlert.this.commentTextView.isPopupVisible();
                }
            };
        }

        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent ev) {
            if (ChatAttachAlert.this.currentAttachLayout.onContainerViewTouchEvent(ev)) {
                return true;
            }
            if (ev.getAction() == 0 && ChatAttachAlert.this.scrollOffsetY[0] != 0) {
                float y = ev.getY();
                ChatAttachAlert chatAttachAlert = ChatAttachAlert.this;
                if (y < chatAttachAlert.scrollOffsetY[0] && chatAttachAlert.actionBar.getAlpha() == 0.0f) {
                    ChatAttachAlert.this.dismiss();
                    return true;
                }
            }
            return super.onInterceptTouchEvent(ev);
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent event) {
            if (ChatAttachAlert.this.currentAttachLayout.onContainerViewTouchEvent(event)) {
                return true;
            }
            return !ChatAttachAlert.this.isDismissed() && super.onTouchEvent(event);
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            int size;
            if (getLayoutParams().height > 0) {
                size = getLayoutParams().height;
            } else {
                size = View.MeasureSpec.getSize(heightMeasureSpec);
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
            int size2 = View.MeasureSpec.getSize(widthMeasureSpec) - (((BottomSheet) ChatAttachAlert.this).backgroundPaddingLeft * 2);
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
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatAttachAlert$2$t4RBuiIx2qqpAym6qDpgLhBAdWc
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onMeasure$0$ChatAttachAlert$2();
                    }
                });
            }
            this.ignoreLayout = false;
            onMeasureInternal(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec(size, 1073741824));
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onMeasure$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onMeasure$0$ChatAttachAlert$2() {
            ChatAttachAlert.this.buttonsAdapter.notifyDataSetChanged();
        }

        private void onMeasureInternal(int widthMeasureSpec, int heightMeasureSpec) {
            int size = View.MeasureSpec.getSize(widthMeasureSpec);
            int size2 = View.MeasureSpec.getSize(heightMeasureSpec);
            setMeasuredDimension(size, size2);
            int i = size - (((BottomSheet) ChatAttachAlert.this).backgroundPaddingLeft * 2);
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
                    heightMeasureSpec = View.MeasureSpec.makeMeasureSpec(size2, 1073741824);
                }
                this.ignoreLayout = true;
                ChatAttachAlert.this.currentAttachLayout.onPreMeasure(i, size2);
                if (ChatAttachAlert.this.nextAttachLayout != null) {
                    ChatAttachAlert.this.nextAttachLayout.onPreMeasure(i, size2);
                }
                this.ignoreLayout = false;
            }
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt != null && childAt.getVisibility() != 8) {
                    EditTextEmoji editTextEmoji = ChatAttachAlert.this.commentTextView;
                    if (editTextEmoji != null && editTextEmoji.isPopupView(childAt)) {
                        if (ChatAttachAlert.this.inBubbleMode) {
                            childAt.measure(View.MeasureSpec.makeMeasureSpec(i, 1073741824), View.MeasureSpec.makeMeasureSpec(getPaddingTop() + size2, 1073741824));
                        } else if (AndroidUtilities.isInMultiwindow || AndroidUtilities.isTablet()) {
                            if (AndroidUtilities.isTablet()) {
                                childAt.measure(View.MeasureSpec.makeMeasureSpec(i, 1073741824), View.MeasureSpec.makeMeasureSpec(Math.min(AndroidUtilities.dp(AndroidUtilities.isTablet() ? 200.0f : 320.0f), (size2 - AndroidUtilities.statusBarHeight) + getPaddingTop()), 1073741824));
                            } else {
                                childAt.measure(View.MeasureSpec.makeMeasureSpec(i, 1073741824), View.MeasureSpec.makeMeasureSpec((size2 - AndroidUtilities.statusBarHeight) + getPaddingTop(), 1073741824));
                            }
                        } else {
                            childAt.measure(View.MeasureSpec.makeMeasureSpec(i, 1073741824), View.MeasureSpec.makeMeasureSpec(childAt.getLayoutParams().height, 1073741824));
                        }
                    } else {
                        measureChildWithMargins(childAt, widthMeasureSpec, 0, heightMeasureSpec, 0);
                    }
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:42:0x00ca  */
        /* JADX WARN: Removed duplicated region for block: B:49:0x00e4  */
        /* JADX WARN: Removed duplicated region for block: B:53:0x00f7  */
        /* JADX WARN: Removed duplicated region for block: B:57:0x0103  */
        /* JADX WARN: Removed duplicated region for block: B:58:0x010c  */
        @Override // ir.eitaa.ui.Components.SizeNotifierFrameLayout, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        protected void onLayout(boolean r11, int r12, int r13, int r14, int r15) {
            /*
                Method dump skipped, instructions count: 309
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Components.ChatAttachAlert.AnonymousClass2.onLayout(boolean, int, int, int, int):void");
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
                Method dump skipped, instructions count: 686
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Components.ChatAttachAlert.AnonymousClass2.drawChild(android.graphics.Canvas, android.view.View, long):boolean");
        }

        @Override // ir.eitaa.ui.Components.SizeNotifierFrameLayout, android.view.View
        protected void onDraw(Canvas canvas) {
            ChatAttachAlert chatAttachAlert = ChatAttachAlert.this;
            if (chatAttachAlert.inBubbleMode) {
                return;
            }
            int themedColor = chatAttachAlert.getThemedColor(this.val$forceDarkTheme ? "voipgroup_listViewBackground" : "dialogBackground");
            Theme.dialogs_onlineCirclePaint.setColor(Color.argb((int) (ChatAttachAlert.this.actionBar.getAlpha() * 255.0f), (int) (Color.red(themedColor) * 0.8f), (int) (Color.green(themedColor) * 0.8f), (int) (Color.blue(themedColor) * 0.8f)));
            canvas.drawRect(((BottomSheet) ChatAttachAlert.this).backgroundPaddingLeft, ChatAttachAlert.this.currentPanTranslationY, getMeasuredWidth() - ((BottomSheet) ChatAttachAlert.this).backgroundPaddingLeft, AndroidUtilities.statusBarHeight + ChatAttachAlert.this.currentPanTranslationY, Theme.dialogs_onlineCirclePaint);
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void dispatchDraw(Canvas canvas) {
            canvas.save();
            canvas.clipRect(0.0f, getPaddingTop() + ChatAttachAlert.this.currentPanTranslationY, getMeasuredWidth(), getMeasuredHeight() + ChatAttachAlert.this.currentPanTranslationY);
            super.dispatchDraw(canvas);
            canvas.restore();
        }

        @Override // android.view.View
        public void setTranslationY(float translationY) {
            ChatAttachAlert chatAttachAlert = ChatAttachAlert.this;
            float f = translationY + chatAttachAlert.currentPanTranslationY;
            if (((BottomSheet) chatAttachAlert).currentSheetAnimationType == 0) {
                this.initialTranslationY = f;
            }
            if (((BottomSheet) ChatAttachAlert.this).currentSheetAnimationType == 1) {
                if (f < 0.0f) {
                    ChatAttachAlert.this.currentAttachLayout.setTranslationY(f);
                    ChatAttachAlert chatAttachAlert2 = ChatAttachAlert.this;
                    if (chatAttachAlert2.avatarPicker != 0) {
                        chatAttachAlert2.selectedTextView.setTranslationY((chatAttachAlert2.baseSelectedTextViewTranslationY + f) - ChatAttachAlert.this.currentPanTranslationY);
                    }
                    ChatAttachAlert.this.buttonsRecyclerView.setTranslationY(0.0f);
                    f = 0.0f;
                } else {
                    ChatAttachAlert.this.currentAttachLayout.setTranslationY(0.0f);
                    ChatAttachAlert.this.buttonsRecyclerView.setTranslationY((-f) + (r0.getMeasuredHeight() * (f / this.initialTranslationY)));
                }
                ((BottomSheet) ChatAttachAlert.this).containerView.invalidate();
            }
            super.setTranslationY(f - ChatAttachAlert.this.currentPanTranslationY);
            if (((BottomSheet) ChatAttachAlert.this).currentSheetAnimationType != 1) {
                ChatAttachAlert.this.currentAttachLayout.onContainerTranslationUpdated(ChatAttachAlert.this.currentPanTranslationY);
            }
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onAttachedToWindow() {
            super.onAttachedToWindow();
            this.adjustPanLayoutHelper.setResizableView(this);
            this.adjustPanLayoutHelper.onAttach();
            ChatAttachAlert.this.commentTextView.setAdjustPanLayoutHelper(this.adjustPanLayoutHelper);
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            this.adjustPanLayoutHelper.onDetach();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$0$ChatAttachAlert(int i) {
        this.actionBar.getActionBarMenuOnItemClick().onItemClick(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$1$ChatAttachAlert(View view) {
        this.selectedMenuItem.toggleSubMenu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$2$ChatAttachAlert(View view) {
        this.currentAttachLayout.onMenuItemClick(40);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$5$ChatAttachAlert(Theme.ResourcesProvider resourcesProvider, View view, int i) {
        if (this.baseFragment.getParentActivity() == null) {
            return;
        }
        if (view instanceof AttachButton) {
            int iIntValue = ((Integer) view.getTag()).intValue();
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
                    ChatAttachAlertLocationLayout chatAttachAlertLocationLayout = new ChatAttachAlertLocationLayout(this, getContext(), resourcesProvider);
                    this.locationLayout = chatAttachAlertLocationLayout;
                    attachAlertLayoutArr[5] = chatAttachAlertLocationLayout;
                    chatAttachAlertLocationLayout.setDelegate(new ChatAttachAlertLocationLayout.LocationActivityDelegate() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatAttachAlert$2EXgRAdE4L3N8LljXOfJky6u9Jg
                        @Override // ir.eitaa.ui.Components.ChatAttachAlertLocationLayout.LocationActivityDelegate
                        public final void didSelectLocation(TLRPC$MessageMedia tLRPC$MessageMedia, int i2, boolean z, int i3) {
                            this.f$0.lambda$new$3$ChatAttachAlert(tLRPC$MessageMedia, i2, z, i3);
                        }
                    });
                }
                showLayout(this.locationLayout);
            } else if (iIntValue == 9) {
                if (this.pollLayout == null) {
                    AttachAlertLayout[] attachAlertLayoutArr2 = this.layouts;
                    ChatAttachAlertPollLayout chatAttachAlertPollLayout = new ChatAttachAlertPollLayout(this, getContext(), resourcesProvider);
                    this.pollLayout = chatAttachAlertPollLayout;
                    attachAlertLayoutArr2[1] = chatAttachAlertPollLayout;
                    chatAttachAlertPollLayout.setDelegate(new ChatAttachAlertPollLayout.PollCreateActivityDelegate() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatAttachAlert$2k_YYDqF1cTXHCtpuUGZQ7C_5uw
                        @Override // ir.eitaa.ui.Components.ChatAttachAlertPollLayout.PollCreateActivityDelegate
                        public final void sendPoll(TLRPC$TL_messageMediaPoll tLRPC$TL_messageMediaPoll, HashMap map, boolean z, int i2) {
                            this.f$0.lambda$new$4$ChatAttachAlert(tLRPC$TL_messageMediaPoll, map, z, i2);
                        }
                    });
                }
                showLayout(this.pollLayout);
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
    /* renamed from: lambda$new$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$3$ChatAttachAlert(TLRPC$MessageMedia tLRPC$MessageMedia, int i, boolean z, int i2) {
        ((ChatActivity) this.baseFragment).didSelectLocation(tLRPC$MessageMedia, i, z, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$4$ChatAttachAlert(TLRPC$TL_messageMediaPoll tLRPC$TL_messageMediaPoll, HashMap map, boolean z, int i) {
        ((ChatActivity) this.baseFragment).sendPoll(tLRPC$TL_messageMediaPoll, map, z, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean lambda$new$7$ChatAttachAlert(View view, int i) {
        if (view instanceof AttachBotButton) {
            final AttachBotButton attachBotButton = (AttachBotButton) view;
            if (this.baseFragment != null && attachBotButton.currentUser != null) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setTitle(LocaleController.getString("AppName", R.string.AppName));
                builder.setMessage(LocaleController.formatString("ChatHintsDelete", R.string.ChatHintsDelete, ContactsController.formatName(attachBotButton.currentUser.first_name, attachBotButton.currentUser.last_name)));
                builder.setPositiveButton(LocaleController.getString("OK", R.string.OK), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatAttachAlert$74m_hg6Djg73VBjC0tlF07uehGk
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$new$6$ChatAttachAlert(attachBotButton, dialogInterface, i2);
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
    /* renamed from: lambda$new$6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$6$ChatAttachAlert(AttachBotButton attachBotButton, DialogInterface dialogInterface, int i) {
        MediaDataController.getInstance(this.currentAccount).removeInline(attachBotButton.currentUser.id);
    }

    /* renamed from: ir.eitaa.ui.Components.ChatAttachAlert$7, reason: invalid class name */
    class AnonymousClass7 extends FrameLayout {
        private int color;
        private final Paint p;
        final /* synthetic */ boolean val$forceDarkTheme;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass7(Context context, final boolean val$forceDarkTheme) {
            super(context);
            this.val$forceDarkTheme = val$forceDarkTheme;
            this.p = new Paint();
        }

        @Override // android.view.View
        public void setAlpha(float alpha) {
            super.setAlpha(alpha);
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
                ChatAttachAlert.this.topBackgroundAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatAttachAlert$7$7QIVdvwXWxBZK1w3t5BaTzjM7TU
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        this.f$0.lambda$onDraw$0$ChatAttachAlert$7(valueAnimator);
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
            int themedColor = ChatAttachAlert.this.getThemedColor(this.val$forceDarkTheme ? "voipgroup_listViewBackground" : "dialogBackground");
            if (this.color != themedColor) {
                this.color = themedColor;
                this.p.setColor(themedColor);
            }
            canvas.drawRect(0.0f, ChatAttachAlert.this.captionEditTextTopOffset, getMeasuredWidth(), getMeasuredHeight(), this.p);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onDraw$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onDraw$0$ChatAttachAlert$7(ValueAnimator valueAnimator) {
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

    /* renamed from: ir.eitaa.ui.Components.ChatAttachAlert$8, reason: invalid class name */
    class AnonymousClass8 extends EditTextEmoji {
        private ValueAnimator messageEditTextAnimator;
        private int messageEditTextPredrawHeigth;
        private int messageEditTextPredrawScrollY;
        private boolean shouldAnimateEditTextWithBounds;

        AnonymousClass8(Context context, SizeNotifierFrameLayout parent, BaseFragment fragment, int style, Theme.ResourcesProvider resourcesProvider) {
            super(context, parent, fragment, style, resourcesProvider);
        }

        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent ev) {
            if (!ChatAttachAlert.this.enterCommentEventSent) {
                if (ev.getX() > ChatAttachAlert.this.commentTextView.getEditText().getLeft() && ev.getX() < ChatAttachAlert.this.commentTextView.getEditText().getRight() && ev.getY() > ChatAttachAlert.this.commentTextView.getEditText().getTop() && ev.getY() < ChatAttachAlert.this.commentTextView.getEditText().getBottom()) {
                    ChatAttachAlert chatAttachAlert = ChatAttachAlert.this;
                    chatAttachAlert.makeFocusable(chatAttachAlert.commentTextView.getEditText(), true);
                } else {
                    ChatAttachAlert chatAttachAlert2 = ChatAttachAlert.this;
                    chatAttachAlert2.makeFocusable(chatAttachAlert2.commentTextView.getEditText(), false);
                }
            }
            return super.onInterceptTouchEvent(ev);
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void dispatchDraw(Canvas canvas) {
            if (this.shouldAnimateEditTextWithBounds) {
                final EditTextCaption editText = ChatAttachAlert.this.commentTextView.getEditText();
                editText.setOffsetY(editText.getOffsetY() - ((this.messageEditTextPredrawHeigth - editText.getMeasuredHeight()) + (this.messageEditTextPredrawScrollY - editText.getScrollY())));
                ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(editText.getOffsetY(), 0.0f);
                valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatAttachAlert$8$qn2hmh7p-rmffSbwbytERH04u2E
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        editText.setOffsetY(((Float) valueAnimator.getAnimatedValue()).floatValue());
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

        @Override // ir.eitaa.ui.Components.EditTextEmoji
        protected void onLineCountChanged(int oldLineCount, int newLineCount) {
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

        @Override // ir.eitaa.ui.Components.EditTextEmoji
        protected void bottomPanelTranslationY(float translation) {
            ChatAttachAlert.this.bottomPannelTranslation = translation;
            ChatAttachAlert.this.frameLayout2.setTranslationY(translation);
            ChatAttachAlert.this.writeButtonContainer.setTranslationY(translation);
            ChatAttachAlert.this.selectedCountView.setTranslationY(translation);
            ChatAttachAlert.this.frameLayout2.invalidate();
            ChatAttachAlert chatAttachAlert = ChatAttachAlert.this;
            chatAttachAlert.updateLayout(chatAttachAlert.currentAttachLayout, true, 0);
        }
    }

    /* renamed from: ir.eitaa.ui.Components.ChatAttachAlert$9, reason: invalid class name */
    class AnonymousClass9 implements TextWatcher {
        private boolean processChange;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        AnonymousClass9() {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
            if (count - before >= 1) {
                this.processChange = true;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:31:0x0133  */
        /* JADX WARN: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
        @Override // android.text.TextWatcher
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void afterTextChanged(android.text.Editable r10) {
            /*
                Method dump skipped, instructions count: 382
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Components.ChatAttachAlert.AnonymousClass9.afterTextChanged(android.text.Editable):void");
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$afterTextChanged$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$afterTextChanged$0$ChatAttachAlert$9(ValueAnimator valueAnimator) {
            ChatAttachAlert.this.sendButtonEnabledProgress = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            ChatAttachAlert.this.writeButton.setColorFilter(new PorterDuffColorFilter(ColorUtils.setAlphaComponent(ChatAttachAlert.this.getThemedColor("dialogFloatingIcon"), (int) (Color.alpha(r6) * ((ChatAttachAlert.this.sendButtonEnabledProgress * 0.42f) + 0.58f))), PorterDuff.Mode.MULTIPLY));
            ChatAttachAlert.this.selectedCountView.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$10, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$10$ChatAttachAlert(Theme.ResourcesProvider resourcesProvider, View view) {
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
                AlertsCreator.createScheduleDatePickerDialog(getContext(), ((ChatActivity) this.baseFragment).getDialogId(), new AlertsCreator.ScheduleDatePickerDelegate() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatAttachAlert$GFCWaG7TBUdpQUD4zfSpXSwsHLk
                    @Override // ir.eitaa.ui.Components.AlertsCreator.ScheduleDatePickerDelegate
                    public final void didSelectDate(boolean z, int i) {
                        this.f$0.lambda$new$9$ChatAttachAlert(z, i);
                    }
                }, resourcesProvider);
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
    /* renamed from: lambda$new$9, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$9$ChatAttachAlert(boolean z, int i) {
        AttachAlertLayout attachAlertLayout = this.currentAttachLayout;
        if (attachAlertLayout == this.photoLayout) {
            sendPressed(z, i);
        } else {
            attachAlertLayout.sendSelectedItems(z, i);
            dismiss();
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BottomSheet, android.app.Dialog
    public void show() {
        super.show();
        this.buttonPressed = false;
        BaseFragment baseFragment = this.baseFragment;
        if (baseFragment instanceof ChatActivity) {
            this.calcMandatoryInsets = ((ChatActivity) baseFragment).isKeyboardVisible();
        }
        this.openTransitionFinished = false;
        if (Build.VERSION.SDK_INT >= 30) {
            int themedColor = getThemedColor("windowBackgroundGray");
            if (AndroidUtilities.computePerceivedBrightness(themedColor) < 0.721d) {
                getWindow().setNavigationBarColor(themedColor);
            }
        }
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
        updateLiveStreamMusicButton();
    }

    public MessageObject getEditingMessageObject() {
        return this.editingMessageObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean updateLiveStreamMusicButton() {
        TLRPC$TL_chatAdminRights tLRPC$TL_chatAdminRights;
        String str;
        TLRPC$TL_chatAdminRights tLRPC$TL_chatAdminRights2;
        String str2;
        TLRPC$TL_chatAdminRights tLRPC$TL_chatAdminRights3;
        if (this.editingMessageObject != null) {
            return false;
        }
        BaseFragment baseFragment = this.baseFragment;
        if (!(baseFragment instanceof ChatActivity)) {
            return false;
        }
        TLRPC$Chat currentChat = ((ChatActivity) baseFragment).getCurrentChat();
        TLRPC$User currentUser = ((ChatActivity) this.baseFragment).getCurrentUser();
        TLRPC$TL_liveStreamConfig tLRPC$TL_liveStreamConfig = MessagesController.getInstance(this.currentAccount).liveStreamConfig;
        return !(currentChat == null || !ChatObject.isChannel(currentChat) || (str2 = currentChat.username) == null || str2.length() == 0 || ((!currentChat.creator && ((tLRPC$TL_chatAdminRights3 = currentChat.admin_rights) == null || !tLRPC$TL_chatAdminRights3.post_live)) || !tLRPC$TL_liveStreamConfig.send_in_publicChannel)) || (currentChat != null && ChatObject.isChannel(currentChat) && (((str = currentChat.username) == null || str.length() == 0) && ((currentChat.creator || ((tLRPC$TL_chatAdminRights2 = currentChat.admin_rights) != null && tLRPC$TL_chatAdminRights2.post_live)) && tLRPC$TL_liveStreamConfig.send_in_privateChannel))) || ((currentChat != null && ChatObject.isMegagroup(currentChat) && ((currentChat.creator || ((tLRPC$TL_chatAdminRights = currentChat.admin_rights) != null && tLRPC$TL_chatAdminRights.post_live)) && tLRPC$TL_liveStreamConfig.send_in_supergroups)) || (!(currentChat == null || ChatObject.isChannel(currentChat) || ChatObject.isMegagroup(currentChat) || !currentChat.creator || !tLRPC$TL_liveStreamConfig.send_in_groups) || (currentUser != null && tLRPC$TL_liveStreamConfig.send_in_privateChat)));
    }

    protected void applyCaption() {
        if (this.commentTextView.length() <= 0) {
            return;
        }
        this.currentAttachLayout.applyCaption(this.commentTextView.getText().toString());
    }

    private void sendPressed(boolean notify, int scheduleDate) {
        if (this.buttonPressed) {
            return;
        }
        BaseFragment baseFragment = this.baseFragment;
        if (baseFragment instanceof ChatActivity) {
            ChatActivity chatActivity = (ChatActivity) baseFragment;
            TLRPC$Chat currentChat = chatActivity.getCurrentChat();
            if (chatActivity.getCurrentUser() != null || ((ChatObject.isChannel(currentChat) && currentChat.megagroup) || !ChatObject.isChannel(currentChat))) {
                MessagesController.getNotificationsSettings(this.currentAccount).edit().putBoolean("silent_" + chatActivity.getDialogId(), !notify).commit();
            }
        }
        applyCaption();
        this.buttonPressed = true;
        this.delegate.didPressedButton(7, true, notify, scheduleDate, false);
    }

    private void showLayout(AttachAlertLayout layout) {
        if (this.viewChangeAnimator == null && this.commentsAnimator == null) {
            AttachAlertLayout attachAlertLayout = this.currentAttachLayout;
            if (attachAlertLayout == layout) {
                attachAlertLayout.scrollToTop();
                return;
            }
            if (layout == this.photoLayout) {
                this.selectedId = 1;
            } else if (layout == this.audioLayout) {
                this.selectedId = 3;
            } else if (layout == this.documentLayout) {
                this.selectedId = 4;
            } else if (layout == this.contactsLayout) {
                this.selectedId = 5;
            } else if (layout == this.locationLayout) {
                this.selectedId = 6;
            } else if (layout == this.pollLayout) {
                this.selectedId = 9;
            }
            int childCount = this.buttonsRecyclerView.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.buttonsRecyclerView.getChildAt(i);
                if (childAt instanceof AttachButton) {
                    ((AttachButton) childAt).updateCheckedState(true);
                }
            }
            int firstOffset = (this.currentAttachLayout.getFirstOffset() - AndroidUtilities.dp(11.0f)) - this.scrollOffsetY[0];
            this.nextAttachLayout = layout;
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
            if (layout.getParent() != null) {
                this.containerView.removeView(this.nextAttachLayout);
            }
            int iIndexOfChild = this.containerView.indexOfChild(this.currentAttachLayout);
            ViewGroup viewGroup = this.containerView;
            AttachAlertLayout attachAlertLayout2 = this.nextAttachLayout;
            if (attachAlertLayout2 != this.locationLayout) {
                iIndexOfChild++;
            }
            viewGroup.addView(attachAlertLayout2, iIndexOfChild, LayoutHelper.createFrame(-1, -1.0f));
            this.nextAttachLayout.setTranslationY(AndroidUtilities.dp(78.0f));
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(ObjectAnimator.ofFloat(this.currentAttachLayout, (Property<AttachAlertLayout, Float>) View.TRANSLATION_Y, AndroidUtilities.dp(78.0f) + firstOffset), ObjectAnimator.ofFloat(this.currentAttachLayout, this.ATTACH_ALERT_LAYOUT_TRANSLATION, 0.0f, 1.0f));
            animatorSet.setInterpolator(CubicBezierInterpolator.DEFAULT);
            animatorSet.setDuration(180L);
            animatorSet.setStartDelay(20L);
            animatorSet.addListener(new AnonymousClass13());
            this.viewChangeAnimator = animatorSet;
            animatorSet.start();
        }
    }

    /* renamed from: ir.eitaa.ui.Components.ChatAttachAlert$13, reason: invalid class name */
    class AnonymousClass13 extends AnimatorListenerAdapter {
        AnonymousClass13() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            ChatAttachAlert.this.currentAttachLayout.setAlpha(0.0f);
            SpringAnimation springAnimation = new SpringAnimation(ChatAttachAlert.this.nextAttachLayout, DynamicAnimation.TRANSLATION_Y, 0.0f);
            springAnimation.getSpring().setDampingRatio(0.7f);
            springAnimation.getSpring().setStiffness(400.0f);
            springAnimation.addUpdateListener(new DynamicAnimation.OnAnimationUpdateListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatAttachAlert$13$t63I1a4i37NLVL8vVQIu0D2ITcA
                @Override // androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationUpdateListener
                public final void onAnimationUpdate(DynamicAnimation dynamicAnimation, float f, float f2) {
                    this.f$0.lambda$onAnimationEnd$0$ChatAttachAlert$13(dynamicAnimation, f, f2);
                }
            });
            springAnimation.addEndListener(new DynamicAnimation.OnAnimationEndListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatAttachAlert$13$RxYMamP45MpoFPw2LySqEBrR4HQ
                @Override // androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationEndListener
                public final void onAnimationEnd(DynamicAnimation dynamicAnimation, boolean z, float f, float f2) {
                    this.f$0.lambda$onAnimationEnd$1$ChatAttachAlert$13(dynamicAnimation, z, f, f2);
                }
            });
            ChatAttachAlert.this.viewChangeAnimator = springAnimation;
            springAnimation.start();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onAnimationEnd$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onAnimationEnd$0$ChatAttachAlert$13(DynamicAnimation dynamicAnimation, float f, float f2) {
            if (ChatAttachAlert.this.nextAttachLayout == ChatAttachAlert.this.pollLayout) {
                ChatAttachAlert.this.updateSelectedPosition(1);
            }
            ChatAttachAlert.this.nextAttachLayout.onContainerTranslationUpdated(ChatAttachAlert.this.currentPanTranslationY);
            ((BottomSheet) ChatAttachAlert.this).containerView.invalidate();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onAnimationEnd$1, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onAnimationEnd$1$ChatAttachAlert$13(DynamicAnimation dynamicAnimation, boolean z, float f, float f2) {
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

    public void onRequestPermissionsResultFragment(int requestCode, String[] permissions, int[] grantResults) {
        ChatAttachAlertLocationLayout chatAttachAlertLocationLayout;
        if (requestCode == 5 && grantResults != null && grantResults.length > 0 && grantResults[0] == 0) {
            openContactsLayout();
        } else if (requestCode == 30 && (chatAttachAlertLocationLayout = this.locationLayout) != null && this.currentAttachLayout == chatAttachAlertLocationLayout) {
            isShowing();
        }
    }

    private void openContactsLayout() {
        if (this.contactsLayout == null) {
            AttachAlertLayout[] attachAlertLayoutArr = this.layouts;
            ChatAttachAlertContactsLayout chatAttachAlertContactsLayout = new ChatAttachAlertContactsLayout(this, getContext(), this.resourcesProvider);
            this.contactsLayout = chatAttachAlertContactsLayout;
            attachAlertLayoutArr[2] = chatAttachAlertContactsLayout;
            chatAttachAlertContactsLayout.setDelegate(new ChatAttachAlertContactsLayout.PhonebookShareAlertDelegate() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatAttachAlert$AKCKQICSuUghEe5IChgzkXMCVoA
                @Override // ir.eitaa.ui.Components.ChatAttachAlertContactsLayout.PhonebookShareAlertDelegate
                public final void didSelectContact(TLRPC$User tLRPC$User, boolean z, int i) {
                    this.f$0.lambda$openContactsLayout$11$ChatAttachAlert(tLRPC$User, z, i);
                }
            });
        }
        showLayout(this.contactsLayout);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$openContactsLayout$11, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$openContactsLayout$11$ChatAttachAlert(TLRPC$User tLRPC$User, boolean z, int i) {
        ((ChatActivity) this.baseFragment).sendContact(tLRPC$User, z, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openAudioLayout(boolean show) {
        if (this.audioLayout == null) {
            AttachAlertLayout[] attachAlertLayoutArr = this.layouts;
            ChatAttachAlertAudioLayout chatAttachAlertAudioLayout = new ChatAttachAlertAudioLayout(this, getContext(), this.resourcesProvider);
            this.audioLayout = chatAttachAlertAudioLayout;
            attachAlertLayoutArr[3] = chatAttachAlertAudioLayout;
            chatAttachAlertAudioLayout.setDelegate(new ChatAttachAlertAudioLayout.AudioSelectDelegate() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatAttachAlert$J-OCt0jvQlt_ir0rLCXmv8H2NLc
                @Override // ir.eitaa.ui.Components.ChatAttachAlertAudioLayout.AudioSelectDelegate
                public final void didSelectAudio(ArrayList arrayList, CharSequence charSequence, boolean z, int i) {
                    this.f$0.lambda$openAudioLayout$12$ChatAttachAlert(arrayList, charSequence, z, i);
                }
            });
        }
        BaseFragment baseFragment = this.baseFragment;
        if (baseFragment instanceof ChatActivity) {
            TLRPC$Chat currentChat = ((ChatActivity) baseFragment).getCurrentChat();
            this.audioLayout.setMaxSelectedFiles(((currentChat == null || ChatObject.hasAdminRights(currentChat) || !currentChat.slowmode_enabled) && this.editingMessageObject == null) ? -1 : 1);
        }
        if (show) {
            showLayout(this.audioLayout);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$openAudioLayout$12, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$openAudioLayout$12$ChatAttachAlert(ArrayList arrayList, CharSequence charSequence, boolean z, int i) {
        ((ChatActivity) this.baseFragment).sendAudio(arrayList, charSequence, z, i);
    }

    private void openDocumentsLayout(boolean show) {
        if (this.documentLayout == null) {
            AttachAlertLayout[] attachAlertLayoutArr = this.layouts;
            ChatAttachAlertDocumentLayout chatAttachAlertDocumentLayout = new ChatAttachAlertDocumentLayout(this, getContext(), false, this.resourcesProvider);
            this.documentLayout = chatAttachAlertDocumentLayout;
            attachAlertLayoutArr[4] = chatAttachAlertDocumentLayout;
            chatAttachAlertDocumentLayout.setDelegate(new ChatAttachAlertDocumentLayout.DocumentSelectActivityDelegate() { // from class: ir.eitaa.ui.Components.ChatAttachAlert.14
                @Override // ir.eitaa.ui.Components.ChatAttachAlertDocumentLayout.DocumentSelectActivityDelegate
                public void didSelectFiles(ArrayList<String> files, String caption, ArrayList<MessageObject> fmessages, boolean notify, int scheduleDate) {
                    BaseFragment baseFragment = ChatAttachAlert.this.baseFragment;
                    if (baseFragment instanceof ChatActivity) {
                        ((ChatActivity) baseFragment).didSelectFiles(files, caption, fmessages, notify, scheduleDate);
                    } else if (baseFragment instanceof PassportActivity) {
                        ((PassportActivity) baseFragment).didSelectFiles(files, caption, notify, scheduleDate);
                    }
                }

                @Override // ir.eitaa.ui.Components.ChatAttachAlertDocumentLayout.DocumentSelectActivityDelegate
                public void didSelectPhotos(ArrayList<SendMessagesHelper.SendingMediaInfo> photos, boolean notify, int scheduleDate) {
                    BaseFragment baseFragment = ChatAttachAlert.this.baseFragment;
                    if (baseFragment instanceof ChatActivity) {
                        ((ChatActivity) baseFragment).didSelectPhotos(photos, notify, scheduleDate);
                    } else if (baseFragment instanceof PassportActivity) {
                        ((PassportActivity) baseFragment).didSelectPhotos(photos, notify, scheduleDate);
                    }
                }

                @Override // ir.eitaa.ui.Components.ChatAttachAlertDocumentLayout.DocumentSelectActivityDelegate
                public void startDocumentSelectActivity() {
                    BaseFragment baseFragment = ChatAttachAlert.this.baseFragment;
                    if (baseFragment instanceof ChatActivity) {
                        ((ChatActivity) baseFragment).startDocumentSelectActivity();
                    } else if (baseFragment instanceof PassportActivity) {
                        ((PassportActivity) baseFragment).startDocumentSelectActivity();
                    }
                }

                @Override // ir.eitaa.ui.Components.ChatAttachAlertDocumentLayout.DocumentSelectActivityDelegate
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
        if (show) {
            showLayout(this.documentLayout);
        }
    }

    private boolean showCommentTextView(final boolean show, boolean animated) {
        if (show == (this.frameLayout2.getTag() != null)) {
            return false;
        }
        AnimatorSet animatorSet = this.commentsAnimator;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        this.frameLayout2.setTag(show ? 1 : null);
        if (this.commentTextView.getEditText().isFocused()) {
            AndroidUtilities.hideKeyboard(this.commentTextView.getEditText());
        }
        this.commentTextView.hidePopup(true);
        if (show) {
            this.frameLayout2.setVisibility(0);
            this.writeButtonContainer.setVisibility(0);
            if (!this.typeButtonsAvailable) {
                this.shadow.setVisibility(0);
            }
        } else if (this.typeButtonsAvailable) {
            this.buttonsRecyclerView.setVisibility(0);
        }
        if (animated) {
            this.commentsAnimator = new AnimatorSet();
            ArrayList arrayList = new ArrayList();
            FrameLayout frameLayout = this.frameLayout2;
            Property property = View.ALPHA;
            float[] fArr = new float[1];
            fArr[0] = show ? 1.0f : 0.0f;
            arrayList.add(ObjectAnimator.ofFloat(frameLayout, (Property<FrameLayout, Float>) property, fArr));
            FrameLayout frameLayout2 = this.writeButtonContainer;
            Property property2 = View.SCALE_X;
            float[] fArr2 = new float[1];
            fArr2[0] = show ? 1.0f : 0.2f;
            arrayList.add(ObjectAnimator.ofFloat(frameLayout2, (Property<FrameLayout, Float>) property2, fArr2));
            FrameLayout frameLayout3 = this.writeButtonContainer;
            Property property3 = View.SCALE_Y;
            float[] fArr3 = new float[1];
            fArr3[0] = show ? 1.0f : 0.2f;
            arrayList.add(ObjectAnimator.ofFloat(frameLayout3, (Property<FrameLayout, Float>) property3, fArr3));
            FrameLayout frameLayout4 = this.writeButtonContainer;
            Property property4 = View.ALPHA;
            float[] fArr4 = new float[1];
            fArr4[0] = show ? 1.0f : 0.0f;
            arrayList.add(ObjectAnimator.ofFloat(frameLayout4, (Property<FrameLayout, Float>) property4, fArr4));
            View view = this.selectedCountView;
            Property property5 = View.SCALE_X;
            float[] fArr5 = new float[1];
            fArr5[0] = show ? 1.0f : 0.2f;
            arrayList.add(ObjectAnimator.ofFloat(view, (Property<View, Float>) property5, fArr5));
            View view2 = this.selectedCountView;
            Property property6 = View.SCALE_Y;
            float[] fArr6 = new float[1];
            fArr6[0] = show ? 1.0f : 0.2f;
            arrayList.add(ObjectAnimator.ofFloat(view2, (Property<View, Float>) property6, fArr6));
            View view3 = this.selectedCountView;
            Property property7 = View.ALPHA;
            float[] fArr7 = new float[1];
            fArr7[0] = show ? 1.0f : 0.0f;
            arrayList.add(ObjectAnimator.ofFloat(view3, (Property<View, Float>) property7, fArr7));
            if (this.actionBar.getTag() != null) {
                FrameLayout frameLayout5 = this.frameLayout2;
                Property property8 = View.TRANSLATION_Y;
                float[] fArr8 = new float[1];
                fArr8[0] = show ? 0.0f : AndroidUtilities.dp(48.0f);
                arrayList.add(ObjectAnimator.ofFloat(frameLayout5, (Property<FrameLayout, Float>) property8, fArr8));
                View view4 = this.shadow;
                Property property9 = View.TRANSLATION_Y;
                float[] fArr9 = new float[1];
                fArr9[0] = show ? AndroidUtilities.dp(36.0f) : AndroidUtilities.dp(84.0f);
                arrayList.add(ObjectAnimator.ofFloat(view4, (Property<View, Float>) property9, fArr9));
                View view5 = this.shadow;
                Property property10 = View.ALPHA;
                float[] fArr10 = new float[1];
                fArr10[0] = show ? 1.0f : 0.0f;
                arrayList.add(ObjectAnimator.ofFloat(view5, (Property<View, Float>) property10, fArr10));
            } else if (this.typeButtonsAvailable) {
                RecyclerListView recyclerListView = this.buttonsRecyclerView;
                Property property11 = View.TRANSLATION_Y;
                float[] fArr11 = new float[1];
                fArr11[0] = show ? AndroidUtilities.dp(36.0f) : 0.0f;
                arrayList.add(ObjectAnimator.ofFloat(recyclerListView, (Property<RecyclerListView, Float>) property11, fArr11));
                View view6 = this.shadow;
                Property property12 = View.TRANSLATION_Y;
                float[] fArr12 = new float[1];
                fArr12[0] = show ? AndroidUtilities.dp(36.0f) : 0.0f;
                arrayList.add(ObjectAnimator.ofFloat(view6, (Property<View, Float>) property12, fArr12));
            } else {
                this.shadow.setTranslationY(AndroidUtilities.dp(36.0f));
                View view7 = this.shadow;
                Property property13 = View.ALPHA;
                float[] fArr13 = new float[1];
                fArr13[0] = show ? 1.0f : 0.0f;
                arrayList.add(ObjectAnimator.ofFloat(view7, (Property<View, Float>) property13, fArr13));
            }
            this.commentsAnimator.playTogether(arrayList);
            this.commentsAnimator.setInterpolator(new DecelerateInterpolator());
            this.commentsAnimator.setDuration(180L);
            this.commentsAnimator.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.ChatAttachAlert.15
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    if (animation.equals(ChatAttachAlert.this.commentsAnimator)) {
                        if (!show) {
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
                public void onAnimationCancel(Animator animation) {
                    if (animation.equals(ChatAttachAlert.this.commentsAnimator)) {
                        ChatAttachAlert.this.commentsAnimator = null;
                    }
                }
            });
            this.commentsAnimator.start();
        } else {
            this.frameLayout2.setAlpha(show ? 1.0f : 0.0f);
            this.writeButtonContainer.setScaleX(show ? 1.0f : 0.2f);
            this.writeButtonContainer.setScaleY(show ? 1.0f : 0.2f);
            this.writeButtonContainer.setAlpha(show ? 1.0f : 0.0f);
            this.selectedCountView.setScaleX(show ? 1.0f : 0.2f);
            this.selectedCountView.setScaleY(show ? 1.0f : 0.2f);
            this.selectedCountView.setAlpha(show ? 1.0f : 0.0f);
            if (this.actionBar.getTag() != null) {
                this.frameLayout2.setTranslationY(show ? 0.0f : AndroidUtilities.dp(48.0f));
                this.shadow.setTranslationY(show ? AndroidUtilities.dp(36.0f) : AndroidUtilities.dp(84.0f));
                this.shadow.setAlpha(show ? 1.0f : 0.0f);
            } else if (this.typeButtonsAvailable) {
                this.buttonsRecyclerView.setTranslationY(show ? AndroidUtilities.dp(36.0f) : 0.0f);
                this.shadow.setTranslationY(show ? AndroidUtilities.dp(36.0f) : 0.0f);
            } else {
                this.shadow.setTranslationY(AndroidUtilities.dp(36.0f));
                this.shadow.setAlpha(show ? 1.0f : 0.0f);
            }
            if (!show) {
                this.frameLayout2.setVisibility(4);
                this.writeButtonContainer.setVisibility(4);
                if (!this.typeButtonsAvailable) {
                    this.shadow.setVisibility(4);
                }
            }
        }
        return true;
    }

    @Override // ir.eitaa.ui.ActionBar.BottomSheet
    protected boolean onCustomOpenAnimation() {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofFloat(this, this.ATTACH_ALERT_PROGRESS, 0.0f, 400.0f));
        animatorSet.setDuration(400L);
        animatorSet.setStartDelay(20L);
        animatorSet.start();
        updateLiveStreamMusicButton();
        return false;
    }

    @Override // ir.eitaa.ui.ActionBar.BottomSheet
    protected boolean onContainerTouchEvent(MotionEvent event) {
        return this.currentAttachLayout.onContainerViewTouchEvent(event);
    }

    protected void makeFocusable(final EditTextBoldCursor editText, final boolean showKeyboard) {
        if (this.enterCommentEventSent) {
            return;
        }
        boolean zNeedEnterComment = this.delegate.needEnterComment();
        this.enterCommentEventSent = true;
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatAttachAlert$E8gF6w3K63wraQDc6kOIkw0NNHY
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$makeFocusable$14$ChatAttachAlert(editText, showKeyboard);
            }
        }, zNeedEnterComment ? 200L : 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$makeFocusable$14, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$makeFocusable$14$ChatAttachAlert(final EditTextBoldCursor editTextBoldCursor, boolean z) {
        setFocusable(true);
        editTextBoldCursor.requestFocus();
        if (z) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatAttachAlert$EBwis9djhzWiwui_TcBXpsWqi70
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
            attachButton.textView.setTextColor(ColorUtils.blendARGB(getThemedColor("dialogTextGray2"), getThemedColor(attachButton.textKey), attachButton.checkedState));
        } else if (view instanceof AttachBotButton) {
            ((AttachBotButton) view).nameTextView.setTextColor(getThemedColor("dialogTextGray2"));
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BottomSheet
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
                arrayList.add(new ThemeDescription(this.container, 0, null, null, null, null, "dialogBackgroundGray"));
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
        this.selectedTextView.setTextColor(this.forceDarkTheme ? getThemedColor("voipgroup_actionBarItems") : getThemedColor("dialogTextBlack"));
        this.doneItem.getTextView().setTextColor(getThemedColor("windowBackgroundWhiteBlueHeader"));
        this.selectedMenuItem.setIconColor(this.forceDarkTheme ? getThemedColor("voipgroup_actionBarItems") : getThemedColor("dialogTextBlack"));
        Theme.setDrawableColor(this.selectedMenuItem.getBackground(), this.forceDarkTheme ? getThemedColor("voipgroup_actionBarItemsSelector") : getThemedColor("dialogButtonSelector"));
        this.selectedMenuItem.setPopupItemsColor(getThemedColor("actionBarDefaultSubmenuItem"), false);
        this.selectedMenuItem.setPopupItemsColor(getThemedColor("actionBarDefaultSubmenuItem"), true);
        this.selectedMenuItem.redrawPopup(getThemedColor("actionBarDefaultSubmenuBackground"));
        this.commentTextView.updateColors();
        if (this.sendPopupLayout != null) {
            int i3 = 0;
            while (true) {
                ActionBarMenuSubItem[] actionBarMenuSubItemArr = this.itemCells;
                if (i3 >= actionBarMenuSubItemArr.length) {
                    break;
                }
                if (actionBarMenuSubItemArr[i3] != null) {
                    actionBarMenuSubItemArr[i3].setColors(getThemedColor("actionBarDefaultSubmenuItem"), getThemedColor("actionBarDefaultSubmenuItemIcon"));
                    this.itemCells[i3].setSelectorColor(this.forceDarkTheme ? getThemedColor("voipgroup_actionBarItemsSelector") : getThemedColor("dialogButtonSelector"));
                }
                i3++;
            }
            this.sendPopupLayout.setBackgroundColor(getThemedColor("actionBarDefaultSubmenuBackground"));
            ActionBarPopupWindow actionBarPopupWindow = this.sendPopupWindow;
            if (actionBarPopupWindow != null && actionBarPopupWindow.isShowing()) {
                this.sendPopupLayout.invalidate();
            }
        }
        Theme.setSelectorDrawableColor(this.writeButtonDrawable, getThemedColor("dialogFloatingButton"), false);
        Theme.setSelectorDrawableColor(this.writeButtonDrawable, getThemedColor(Build.VERSION.SDK_INT >= 21 ? "dialogFloatingButtonPressed" : "dialogFloatingButton"), true);
        this.writeButton.setColorFilter(new PorterDuffColorFilter(getThemedColor("dialogFloatingIcon"), PorterDuff.Mode.MULTIPLY));
        this.actionBarShadow.setBackgroundColor(getThemedColor("dialogShadowLine"));
        this.buttonsRecyclerView.setGlowColor(getThemedColor("dialogScrollGlow"));
        this.buttonsRecyclerView.setBackgroundColor(getThemedColor(this.forceDarkTheme ? "voipgroup_listViewBackground" : "dialogBackground"));
        this.frameLayout2.setBackgroundColor(getThemedColor(this.forceDarkTheme ? "voipgroup_listViewBackground" : "dialogBackground"));
        this.selectedCountView.invalidate();
        this.actionBar.setBackgroundColor(this.forceDarkTheme ? getThemedColor("voipgroup_actionBar") : getThemedColor("dialogBackground"));
        this.actionBar.setItemsColor(this.forceDarkTheme ? getThemedColor("voipgroup_actionBarItems") : getThemedColor("dialogTextBlack"), false);
        this.actionBar.setItemsBackgroundColor(this.forceDarkTheme ? getThemedColor("voipgroup_actionBarItemsSelector") : getThemedColor("dialogButtonSelector"), false);
        this.actionBar.setTitleColor(this.forceDarkTheme ? getThemedColor("voipgroup_actionBarItems") : getThemedColor("dialogTextBlack"));
        Theme.setDrawableColor(this.shadowDrawable, getThemedColor(this.forceDarkTheme ? "voipgroup_listViewBackground" : "dialogBackground"));
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

    @Override // ir.eitaa.ui.ActionBar.BottomSheet
    protected boolean onCustomMeasure(View view, int width, int height) {
        return this.photoLayout.onCustomMeasure(view, width, height);
    }

    @Override // ir.eitaa.ui.ActionBar.BottomSheet
    protected boolean onCustomLayout(View view, int left, int top, int right, int bottom) {
        return this.photoLayout.onCustomLayout(view, left, top, right, bottom);
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

    public void onActivityResultFragment(int requestCode, Intent data, String currentPicturePath) {
        this.photoLayout.onActivityResultFragment(requestCode, data, currentPicturePath);
    }

    @Override // ir.eitaa.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int id, int account, Object... args) {
        ButtonsAdapter buttonsAdapter;
        if (id != NotificationCenter.reloadInlineHints || (buttonsAdapter = this.buttonsAdapter) == null) {
            return;
        }
        buttonsAdapter.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSelectedPosition(int idx) {
        int iDp;
        int iDp2;
        float fMin;
        int i;
        int i2;
        AttachAlertLayout attachAlertLayout = idx == 0 ? this.currentAttachLayout : this.nextAttachLayout;
        int i3 = this.scrollOffsetY[idx] - this.backgroundPaddingTop;
        if (attachAlertLayout == this.pollLayout) {
            iDp = i3 - AndroidUtilities.dp(13.0f);
            iDp2 = AndroidUtilities.dp(11.0f);
        } else {
            iDp = i3 - AndroidUtilities.dp(39.0f);
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
            i = 16;
        } else {
            android.graphics.Point point = AndroidUtilities.displaySize;
            i = point.x > point.y ? 6 : 12;
        }
        float fDp = this.actionBar.getAlpha() != 0.0f ? 0.0f : AndroidUtilities.dp((1.0f - this.selectedTextView.getAlpha()) * 26.0f);
        if (this.menuShowed && this.avatarPicker == 0) {
            this.selectedMenuItem.setTranslationY((this.scrollOffsetY[idx] - AndroidUtilities.dp((i * fMin) + 37.0f)) + fDp + this.currentPanTranslationY);
        } else {
            this.selectedMenuItem.setTranslationY(((ActionBar.getCurrentActionBarHeight() - AndroidUtilities.dp(4.0f)) - AndroidUtilities.dp(i + 37)) + this.currentPanTranslationY);
        }
        TextView textView = this.selectedTextView;
        float fDp2 = (this.scrollOffsetY[idx] - AndroidUtilities.dp((i * fMin) + 25.0f)) + fDp + this.currentPanTranslationY;
        this.baseSelectedTextViewTranslationY = fDp2;
        textView.setTranslationY(fDp2);
        ChatAttachAlertPollLayout chatAttachAlertPollLayout = this.pollLayout;
        if (chatAttachAlertPollLayout == null || attachAlertLayout != chatAttachAlertPollLayout) {
            return;
        }
        if (AndroidUtilities.isTablet()) {
            i2 = 63;
        } else {
            android.graphics.Point point2 = AndroidUtilities.displaySize;
            i2 = point2.x > point2.y ? 53 : 59;
        }
        this.doneItem.setTranslationY(Math.max(0.0f, (this.pollLayout.getTranslationY() + this.scrollOffsetY[idx]) - AndroidUtilities.dp((i2 * fMin) + 7.0f)) + this.currentPanTranslationY);
    }

    @SuppressLint({"NewApi"})
    protected void updateLayout(AttachAlertLayout layout, boolean animated, int dy) {
        int currentItemTop;
        if (layout == null || (currentItemTop = layout.getCurrentItemTop()) == Integer.MAX_VALUE) {
            return;
        }
        final boolean z = layout == this.currentAttachLayout && currentItemTop <= layout.getButtonsHideOffset();
        if (this.keyboardVisible && animated) {
            animated = false;
        }
        if ((z && this.actionBar.getTag() == null) || (!z && this.actionBar.getTag() != null)) {
            this.actionBar.setTag(z ? 1 : null);
            AnimatorSet animatorSet = this.actionBarAnimation;
            if (animatorSet != null) {
                animatorSet.cancel();
                this.actionBarAnimation = null;
            }
            if (!this.avatarSearch && this.currentAttachLayout == this.photoLayout && !this.menuShowed) {
                BaseFragment baseFragment = this.baseFragment;
                if (baseFragment instanceof ChatActivity) {
                    ((ChatActivity) baseFragment).allowSendGifs();
                }
            }
            boolean z2 = this.avatarPicker != 0 || (!this.menuShowed && this.currentAttachLayout == this.photoLayout && this.mediaEnabled);
            if (z) {
                if (z2) {
                    this.selectedMenuItem.setVisibility(0);
                }
            } else if (this.typeButtonsAvailable) {
                this.buttonsRecyclerView.setVisibility(0);
            }
            if (animated) {
                AnimatorSet animatorSet2 = new AnimatorSet();
                this.actionBarAnimation = animatorSet2;
                animatorSet2.setDuration(180L);
                ArrayList arrayList = new ArrayList();
                ActionBar actionBar = this.actionBar;
                Property property = View.ALPHA;
                float[] fArr = new float[1];
                fArr[0] = z ? 1.0f : 0.0f;
                arrayList.add(ObjectAnimator.ofFloat(actionBar, (Property<ActionBar, Float>) property, fArr));
                View view = this.actionBarShadow;
                Property property2 = View.ALPHA;
                float[] fArr2 = new float[1];
                fArr2[0] = z ? 1.0f : 0.0f;
                arrayList.add(ObjectAnimator.ofFloat(view, (Property<View, Float>) property2, fArr2));
                if (z2) {
                    ActionBarMenuItem actionBarMenuItem = this.selectedMenuItem;
                    Property property3 = View.ALPHA;
                    float[] fArr3 = new float[1];
                    fArr3[0] = z ? 1.0f : 0.0f;
                    arrayList.add(ObjectAnimator.ofFloat(actionBarMenuItem, (Property<ActionBarMenuItem, Float>) property3, fArr3));
                }
                this.actionBarAnimation.playTogether(arrayList);
                this.actionBarAnimation.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.ChatAttachAlert.17
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animation) {
                        if (ChatAttachAlert.this.actionBarAnimation != null) {
                            if (z) {
                                ChatAttachAlert chatAttachAlert = ChatAttachAlert.this;
                                if (chatAttachAlert.typeButtonsAvailable) {
                                    chatAttachAlert.buttonsRecyclerView.setVisibility(4);
                                    return;
                                }
                                return;
                            }
                            ChatAttachAlert chatAttachAlert2 = ChatAttachAlert.this;
                            if (chatAttachAlert2.avatarPicker == 0 && chatAttachAlert2.menuShowed) {
                                return;
                            }
                            ChatAttachAlert.this.selectedMenuItem.setVisibility(4);
                        }
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animation) {
                        ChatAttachAlert.this.actionBarAnimation = null;
                    }
                });
                this.actionBarAnimation.start();
            } else {
                if (z && this.typeButtonsAvailable) {
                    this.buttonsRecyclerView.setVisibility(4);
                }
                this.actionBar.setAlpha(z ? 1.0f : 0.0f);
                this.actionBarShadow.setAlpha(z ? 1.0f : 0.0f);
                if (z2) {
                    this.selectedMenuItem.setAlpha(z ? 1.0f : 0.0f);
                }
                if (!z && (this.avatarPicker != 0 || !this.menuShowed)) {
                    this.selectedMenuItem.setVisibility(4);
                }
            }
        }
        int iDp = currentItemTop + (((FrameLayout.LayoutParams) layout.getLayoutParams()).topMargin - AndroidUtilities.dp(11.0f));
        int i = this.currentAttachLayout == layout ? 0 : 1;
        int[] iArr = this.scrollOffsetY;
        if (iArr[i] == iDp) {
            if (dy != 0) {
                this.previousScrollOffsetY = iArr[i];
            }
        } else {
            this.previousScrollOffsetY = iArr[i];
            iArr[i] = iDp;
            updateSelectedPosition(i);
            this.containerView.invalidate();
        }
    }

    public void updateCountButton(int animated) {
        if (this.viewChangeAnimator != null) {
            return;
        }
        int selectedItemsCount = this.currentAttachLayout.getSelectedItemsCount();
        if (selectedItemsCount == 0) {
            this.selectedCountView.setPivotX(0.0f);
            this.selectedCountView.setPivotY(0.0f);
            showCommentTextView(false, animated != 0);
        } else {
            this.selectedCountView.invalidate();
            if (!showCommentTextView(true, animated != 0) && animated != 0) {
                this.selectedCountView.setPivotX(AndroidUtilities.dp(21.0f));
                this.selectedCountView.setPivotY(AndroidUtilities.dp(12.0f));
                AnimatorSet animatorSet = new AnimatorSet();
                Animator[] animatorArr = new Animator[2];
                View view = this.selectedCountView;
                Property property = View.SCALE_X;
                float[] fArr = new float[2];
                fArr[0] = animated == 1 ? 1.1f : 0.9f;
                fArr[1] = 1.0f;
                animatorArr[0] = ObjectAnimator.ofFloat(view, (Property<View, Float>) property, fArr);
                View view2 = this.selectedCountView;
                Property property2 = View.SCALE_Y;
                float[] fArr2 = new float[2];
                fArr2[0] = animated != 1 ? 0.9f : 1.1f;
                fArr2[1] = 1.0f;
                animatorArr[1] = ObjectAnimator.ofFloat(view2, (Property<View, Float>) property2, fArr2);
                animatorSet.playTogether(animatorArr);
                animatorSet.setInterpolator(new OvershootInterpolator());
                animatorSet.setDuration(180L);
                animatorSet.start();
            } else {
                this.selectedCountView.setPivotX(0.0f);
                this.selectedCountView.setPivotY(0.0f);
            }
        }
        this.currentAttachLayout.onSelectedItemsCountChanged(selectedItemsCount);
        if (this.currentAttachLayout == this.photoLayout) {
            if ((this.baseFragment instanceof ChatActivity) || this.avatarPicker != 0) {
                if (!(selectedItemsCount == 0 && this.menuShowed) && ((selectedItemsCount == 0 && this.avatarPicker == 0) || this.menuShowed)) {
                    return;
                }
                this.menuShowed = (selectedItemsCount == 0 && this.avatarPicker == 0) ? false : true;
                AnimatorSet animatorSet2 = this.menuAnimator;
                if (animatorSet2 != null) {
                    animatorSet2.cancel();
                    this.menuAnimator = null;
                }
                if (this.actionBar.getTag() != null) {
                    BaseFragment baseFragment = this.baseFragment;
                    if (baseFragment instanceof ChatActivity) {
                        ((ChatActivity) baseFragment).allowSendGifs();
                    }
                }
                if (this.menuShowed) {
                    if (this.avatarPicker == 0) {
                        this.selectedMenuItem.setVisibility(0);
                    }
                    this.selectedTextView.setVisibility(0);
                }
                if (animated == 0) {
                    if (this.actionBar.getTag() == null && this.avatarPicker == 0) {
                        this.selectedMenuItem.setAlpha(this.menuShowed ? 1.0f : 0.0f);
                    }
                    this.selectedTextView.setAlpha(this.menuShowed ? 1.0f : 0.0f);
                    return;
                }
                this.menuAnimator = new AnimatorSet();
                ArrayList arrayList = new ArrayList();
                if (this.actionBar.getTag() == null && this.avatarPicker == 0) {
                    ActionBarMenuItem actionBarMenuItem = this.selectedMenuItem;
                    Property property3 = View.ALPHA;
                    float[] fArr3 = new float[1];
                    fArr3[0] = this.menuShowed ? 1.0f : 0.0f;
                    arrayList.add(ObjectAnimator.ofFloat(actionBarMenuItem, (Property<ActionBarMenuItem, Float>) property3, fArr3));
                }
                TextView textView = this.selectedTextView;
                Property property4 = View.ALPHA;
                float[] fArr4 = new float[1];
                fArr4[0] = this.menuShowed ? 1.0f : 0.0f;
                arrayList.add(ObjectAnimator.ofFloat(textView, (Property<TextView, Float>) property4, fArr4));
                this.menuAnimator.playTogether(arrayList);
                this.menuAnimator.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.ChatAttachAlert.18
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animation) {
                        ChatAttachAlert.this.menuAnimator = null;
                        if (ChatAttachAlert.this.menuShowed) {
                            return;
                        }
                        if (ChatAttachAlert.this.actionBar.getTag() == null) {
                            ChatAttachAlert chatAttachAlert = ChatAttachAlert.this;
                            if (chatAttachAlert.avatarPicker == 0) {
                                chatAttachAlert.selectedMenuItem.setVisibility(4);
                            }
                        }
                        ChatAttachAlert.this.selectedTextView.setVisibility(4);
                    }
                });
                this.menuAnimator.setDuration(180L);
                this.menuAnimator.start();
            }
        }
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
        this.commentTextView.setText("");
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

    @Override // ir.eitaa.ui.ActionBar.BottomSheet.BottomSheetDelegateInterface
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

    @Override // ir.eitaa.ui.ActionBar.BottomSheet
    public void setAllowDrawContent(boolean value) {
        super.setAllowDrawContent(value);
        this.currentAttachLayout.onContainerTranslationUpdated(this.currentPanTranslationY);
    }

    public void setAvatarPicker(int type, boolean search) {
        this.avatarPicker = type;
        this.avatarSearch = search;
        if (type != 0) {
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

    public void setMaxSelectedPhotos(int value, boolean order) {
        if (this.editingMessageObject != null) {
            return;
        }
        this.maxSelectedPhotos = value;
        this.allowOrder = order;
    }

    public void setOpenWithFrontFaceCamera(boolean value) {
        this.openWithFrontFaceCamera = value;
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

        @Override // ir.eitaa.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder holder) {
            return false;
        }

        public ButtonsAdapter(Context context) {
            this.mContext = context;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View attachButton;
            if (viewType == 0) {
                attachButton = ChatAttachAlert.this.new AttachButton(this.mContext);
            } else {
                attachButton = ChatAttachAlert.this.new AttachBotButton(this.mContext);
            }
            return new RecyclerListView.Holder(attachButton);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            int itemViewType = holder.getItemViewType();
            if (itemViewType != 0) {
                if (itemViewType != 1) {
                    return;
                }
                int i = position - this.buttonsCount;
                AttachBotButton attachBotButton = (AttachBotButton) holder.itemView;
                attachBotButton.setTag(Integer.valueOf(i));
                attachBotButton.setUser(MessagesController.getInstance(ChatAttachAlert.this.currentAccount).getUser(Long.valueOf(MediaDataController.getInstance(ChatAttachAlert.this.currentAccount).inlineBots.get(i).peer.user_id)));
                return;
            }
            AttachButton attachButton = (AttachButton) holder.itemView;
            if (position == this.galleryButton) {
                attachButton.setTextAndIcon(1, LocaleController.getString("ChatGallery", R.string.ChatGallery), Theme.chat_attachButtonDrawables[0], "chat_attachGalleryBackground", "chat_attachGalleryText");
                attachButton.setTag(1);
                return;
            }
            if (position == this.documentButton) {
                attachButton.setTextAndIcon(4, LocaleController.getString("ChatDocument", R.string.ChatDocument), Theme.chat_attachButtonDrawables[2], "chat_attachFileBackground", "chat_attachFileText");
                attachButton.setTag(4);
                return;
            }
            if (position == this.locationButton) {
                attachButton.setTextAndIcon(6, LocaleController.getString("ChatLocation", R.string.ChatLocation), Theme.chat_attachButtonDrawables[4], "chat_attachLocationBackground", "chat_attachLocationText");
                attachButton.setTag(6);
                return;
            }
            if (position == this.musicButton) {
                attachButton.setTextAndIcon(3, LocaleController.getString("AttachMusic", R.string.AttachMusic), Theme.chat_attachButtonDrawables[1], "chat_attachAudioBackground", "chat_attachAudioText");
                attachButton.setTag(3);
                return;
            }
            if (position == this.pollButton) {
                attachButton.setTextAndIcon(9, LocaleController.getString("Poll", R.string.Poll), Theme.chat_attachButtonDrawables[5], "chat_attachPollBackground", "chat_attachPollText");
                attachButton.setTag(9);
            } else if (position == this.contactButton) {
                attachButton.setTextAndIcon(5, LocaleController.getString("AttachContact", R.string.AttachContact), Theme.chat_attachButtonDrawables[3], "chat_attachContactBackground", "chat_attachContactText");
                attachButton.setTag(5);
            } else if (position == this.liveButton) {
                attachButton.setTextAndIcon(10, LocaleController.getString("ChatLiveStream", R.string.ChatLiveStream), Theme.chat_attachButtonDrawables[6], "chat_attachAudioBackground", "chat_attachAudioText");
                attachButton.setTag(10);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onViewAttachedToWindow(RecyclerView.ViewHolder holder) {
            ChatAttachAlert.this.applyAttachButtonColors(holder.itemView);
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
                    int i5 = i4 + 1;
                    this.buttonsCount = i5;
                    this.locationButton = i4;
                    this.buttonsCount = i5 + 1;
                    this.contactButton = i5;
                    if (ChatAttachAlert.this.mediaEnabled) {
                        int i6 = this.buttonsCount;
                        this.buttonsCount = i6 + 1;
                        this.musicButton = i6;
                    }
                    BaseFragment baseFragment = ChatAttachAlert.this.baseFragment;
                    TLRPC$User currentUser = baseFragment instanceof ChatActivity ? ((ChatActivity) baseFragment).getCurrentUser() : null;
                    if (currentUser != null && currentUser.bot) {
                        int i7 = this.buttonsCount;
                        this.buttonsCount = i7 + 1;
                        this.contactButton = i7;
                    }
                } else if ((messageObject.isMusic() || ChatAttachAlert.this.editingMessageObject.isDocument()) && ChatAttachAlert.this.editingMessageObject.hasValidGroupId()) {
                    if (ChatAttachAlert.this.editingMessageObject.isMusic()) {
                        int i8 = this.buttonsCount;
                        this.buttonsCount = i8 + 1;
                        this.musicButton = i8;
                    } else {
                        int i9 = this.buttonsCount;
                        this.buttonsCount = i9 + 1;
                        this.documentButton = i9;
                    }
                } else {
                    int i10 = this.buttonsCount;
                    int i11 = i10 + 1;
                    this.buttonsCount = i11;
                    this.galleryButton = i10;
                    int i12 = i11 + 1;
                    this.buttonsCount = i12;
                    this.documentButton = i11;
                    this.buttonsCount = i12 + 1;
                    this.musicButton = i12;
                }
            }
            if (ChatAttachAlert.this.updateLiveStreamMusicButton()) {
                int i13 = this.buttonsCount;
                this.buttonsCount = i13 + 1;
                this.liveButton = i13;
            }
            super.notifyDataSetChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int position) {
            return position < this.buttonsCount ? 0 : 1;
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BottomSheet
    public void dismissInternal() {
        this.delegate.doOnIdle(new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatAttachAlert$FEu7tuC0W510v5xHm29imCb_oZ4
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

    @Override // ir.eitaa.ui.ActionBar.BottomSheet
    public void dismissWithButtonClick(int item) {
        super.dismissWithButtonClick(item);
        this.currentAttachLayout.onDismissWithButtonClick(item);
    }

    @Override // ir.eitaa.ui.ActionBar.BottomSheet
    protected boolean canDismissWithTouchOutside() {
        return this.currentAttachLayout.canDismissWithTouchOutside();
    }

    @Override // ir.eitaa.ui.ActionBar.BottomSheet, android.app.Dialog, android.content.DialogInterface
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
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (this.currentAttachLayout.onSheetKeyDown(keyCode, event)) {
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override // ir.eitaa.ui.ActionBar.BottomSheet
    public void setAllowNestedScroll(boolean allowNestedScroll) {
        this.allowNestedScroll = allowNestedScroll;
    }

    public BaseFragment getBaseFragment() {
        return this.baseFragment;
    }
}
