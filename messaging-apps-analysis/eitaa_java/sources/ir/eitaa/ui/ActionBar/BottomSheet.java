package ir.eitaa.ui.ActionBar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Insets;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Property;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.NestedScrollingParentHelper;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.NotificationCenter;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.UserConfig;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Components.AnimationProperties;
import ir.eitaa.ui.Components.Bulletin;
import ir.eitaa.ui.Components.CubicBezierInterpolator;
import ir.eitaa.ui.Components.LayoutHelper;
import java.util.ArrayList;
import org.linphone.mediastream.Factory;

/* loaded from: classes3.dex */
public class BottomSheet extends Dialog {
    private boolean allowCustomAnimation;
    private boolean allowDrawContent;
    protected boolean allowNestedScroll;
    private boolean applyBottomPadding;
    private boolean applyTopPadding;
    protected ColorDrawable backDrawable;
    protected int backgroundPaddingLeft;
    protected int backgroundPaddingTop;
    protected int behindKeyboardColor;
    protected String behindKeyboardColorKey;
    private boolean bigTitle;
    private int bottomInset;
    protected boolean calcMandatoryInsets;
    private boolean canDismissWithSwipe;
    protected ContainerView container;
    protected ViewGroup containerView;
    protected int currentAccount;
    private float currentPanTranslationY;
    protected AnimatorSet currentSheetAnimation;
    protected int currentSheetAnimationType;
    private View customView;
    private BottomSheetDelegateInterface delegate;
    private boolean dimBehind;
    private int dimBehindAlpha;
    private boolean disableScroll;
    private Runnable dismissRunnable;
    private boolean dismissed;
    protected boolean drawNavigationBar;
    private boolean focusable;
    protected boolean fullWidth;
    protected boolean isFullscreen;
    private int[] itemIcons;
    private ArrayList<BottomSheetCell> itemViews;
    private CharSequence[] items;
    private ValueAnimator keyboardContentAnimator;
    protected boolean keyboardVisible;
    private WindowInsets lastInsets;
    private int layoutCount;
    private int leftInset;
    protected int navBarColor;
    protected String navBarColorKey;
    protected View nestedScrollChild;
    private DialogInterface.OnClickListener onClickListener;
    private DialogInterface.OnDismissListener onHideListener;
    protected Interpolator openInterpolator;
    private int overlayDrawNavBarColor;
    protected Theme.ResourcesProvider resourcesProvider;
    private int rightInset;
    protected boolean scrollNavBar;
    protected Drawable shadowDrawable;
    private boolean showWithoutAnimation;
    protected boolean smoothKeyboardAnimationEnabled;
    protected Runnable startAnimationRunnable;
    protected int statusBarHeight;
    private CharSequence title;
    private TextView titleView;
    private int touchSlop;
    private boolean useFastDismiss;
    private boolean useHardwareLayer;
    protected boolean useLightNavBar;
    protected boolean useLightStatusBar;
    protected boolean useSmoothKeyboard;

    public static class BottomSheetDelegate implements BottomSheetDelegateInterface {
        @Override // ir.eitaa.ui.ActionBar.BottomSheet.BottomSheetDelegateInterface
        public void onOpenAnimationEnd() {
        }
    }

    public interface BottomSheetDelegateInterface {
        boolean canDismiss();

        void onOpenAnimationEnd();
    }

    static /* synthetic */ boolean lambda$onCreate$1(View view, MotionEvent motionEvent) {
        return true;
    }

    protected boolean canDismissWithTouchOutside() {
        return true;
    }

    public ArrayList<ThemeDescription> getThemeDescriptions() {
        return null;
    }

    public void onConfigurationChanged(Configuration newConfig) {
    }

    public void onContainerDraw(Canvas canvas) {
    }

    protected boolean onContainerTouchEvent(MotionEvent event) {
        return false;
    }

    protected void onContainerTranslationYChanged(float translationY) {
    }

    protected boolean onCustomCloseAnimation() {
        return false;
    }

    protected boolean onCustomLayout(View view, int left, int top, int right, int bottom) {
        return false;
    }

    protected boolean onCustomMeasure(View view, int width, int height) {
        return false;
    }

    protected boolean onCustomOpenAnimation() {
        return false;
    }

    static /* synthetic */ int access$1110(BottomSheet bottomSheet) {
        int i = bottomSheet.layoutCount;
        bottomSheet.layoutCount = i - 1;
        return i;
    }

    static /* synthetic */ int access$612(BottomSheet bottomSheet, int i) {
        int i2 = bottomSheet.bottomInset + i;
        bottomSheet.bottomInset = i2;
        return i2;
    }

    static /* synthetic */ int access$620(BottomSheet bottomSheet, int i) {
        int i2 = bottomSheet.bottomInset - i;
        bottomSheet.bottomInset = i2;
        return i2;
    }

    public void setDisableScroll(boolean b) {
        this.disableScroll = b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public class ContainerView extends FrameLayout implements NestedScrollingParent {
        private Paint backgroundPaint;
        private AnimatorSet currentAnimation;
        private boolean keyboardChanged;
        private int keyboardHeight;
        private boolean maybeStartTracking;
        private NestedScrollingParentHelper nestedScrollingParentHelper;
        private Rect rect;
        private boolean startedTracking;
        private int startedTrackingPointerId;
        private int startedTrackingX;
        private int startedTrackingY;
        private VelocityTracker velocityTracker;

        @Override // android.view.View
        public boolean hasOverlappingRendering() {
            return false;
        }

        @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
        public boolean onNestedFling(View target, float velocityX, float velocityY, boolean consumed) {
            return false;
        }

        @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
        public boolean onNestedPreFling(View target, float velocityX, float velocityY) {
            return false;
        }

        public ContainerView(Context context) {
            super(context);
            this.velocityTracker = null;
            this.startedTrackingPointerId = -1;
            this.maybeStartTracking = false;
            this.startedTracking = false;
            this.currentAnimation = null;
            this.rect = new Rect();
            this.backgroundPaint = new Paint();
            this.nestedScrollingParentHelper = new NestedScrollingParentHelper(this);
            setWillNotDraw(false);
        }

        @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
        public boolean onStartNestedScroll(View child, View target, int nestedScrollAxes) {
            BottomSheet bottomSheet = BottomSheet.this;
            View view = bottomSheet.nestedScrollChild;
            if ((view == null || child == view) && !bottomSheet.dismissed) {
                BottomSheet bottomSheet2 = BottomSheet.this;
                if (bottomSheet2.allowNestedScroll && nestedScrollAxes == 2 && !bottomSheet2.canDismissWithSwipe()) {
                    return true;
                }
            }
            return false;
        }

        @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
        public void onNestedScrollAccepted(View child, View target, int nestedScrollAxes) {
            this.nestedScrollingParentHelper.onNestedScrollAccepted(child, target, nestedScrollAxes);
            if (BottomSheet.this.dismissed || !BottomSheet.this.allowNestedScroll) {
                return;
            }
            cancelCurrentAnimation();
        }

        @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
        public void onStopNestedScroll(View target) {
            this.nestedScrollingParentHelper.onStopNestedScroll(target);
            if (BottomSheet.this.dismissed) {
                return;
            }
            BottomSheet bottomSheet = BottomSheet.this;
            if (bottomSheet.allowNestedScroll) {
                bottomSheet.containerView.getTranslationY();
                checkDismiss(0.0f, 0.0f);
            }
        }

        @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
        public void onNestedScroll(View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
            if (BottomSheet.this.dismissed || !BottomSheet.this.allowNestedScroll) {
                return;
            }
            cancelCurrentAnimation();
            if (dyUnconsumed != 0) {
                float translationY = BottomSheet.this.containerView.getTranslationY() - dyUnconsumed;
                if (translationY < 0.0f) {
                    translationY = 0.0f;
                }
                BottomSheet.this.containerView.setTranslationY(translationY);
                BottomSheet.this.container.invalidate();
            }
        }

        @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
        public void onNestedPreScroll(View target, int dx, int dy, int[] consumed) {
            if (BottomSheet.this.dismissed || !BottomSheet.this.allowNestedScroll) {
                return;
            }
            cancelCurrentAnimation();
            float translationY = BottomSheet.this.containerView.getTranslationY();
            if (translationY <= 0.0f || dy <= 0) {
                return;
            }
            float f = translationY - dy;
            consumed[1] = dy;
            BottomSheet.this.containerView.setTranslationY(f >= 0.0f ? f : 0.0f);
            BottomSheet.this.container.invalidate();
        }

        @Override // android.view.ViewGroup
        public int getNestedScrollAxes() {
            return this.nestedScrollingParentHelper.getNestedScrollAxes();
        }

        private void checkDismiss(float velX, float velY) {
            if (!((BottomSheet.this.containerView.getTranslationY() < AndroidUtilities.getPixelsInCM(0.8f, false) && (velY < 3500.0f || Math.abs(velY) < Math.abs(velX))) || (velY < 0.0f && Math.abs(velY) >= 3500.0f))) {
                boolean z = BottomSheet.this.allowCustomAnimation;
                BottomSheet.this.allowCustomAnimation = false;
                BottomSheet.this.useFastDismiss = true;
                BottomSheet.this.dismiss();
                BottomSheet.this.allowCustomAnimation = z;
                return;
            }
            AnimatorSet animatorSet = new AnimatorSet();
            this.currentAnimation = animatorSet;
            animatorSet.playTogether(ObjectAnimator.ofFloat(BottomSheet.this.containerView, "translationY", 0.0f));
            this.currentAnimation.setDuration((int) ((Math.max(0.0f, r0) / AndroidUtilities.getPixelsInCM(0.8f, false)) * 150.0f));
            this.currentAnimation.setInterpolator(CubicBezierInterpolator.EASE_OUT);
            this.currentAnimation.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.ActionBar.BottomSheet.ContainerView.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    if (ContainerView.this.currentAnimation != null && ContainerView.this.currentAnimation.equals(animation)) {
                        ContainerView.this.currentAnimation = null;
                    }
                    NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.startAllHeavyOperations, Integer.valueOf(Factory.DEVICE_USE_ANDROID_CAMCORDER));
                }
            });
            NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.stopAllHeavyOperations, Integer.valueOf(Factory.DEVICE_USE_ANDROID_CAMCORDER));
            this.currentAnimation.start();
        }

        private void cancelCurrentAnimation() {
            AnimatorSet animatorSet = this.currentAnimation;
            if (animatorSet != null) {
                animatorSet.cancel();
                this.currentAnimation = null;
            }
        }

        boolean processTouchEvent(MotionEvent ev, boolean intercept) {
            if (BottomSheet.this.dismissed) {
                return false;
            }
            if (BottomSheet.this.onContainerTouchEvent(ev)) {
                return true;
            }
            if (BottomSheet.this.canDismissWithTouchOutside() && ev != null && ((ev.getAction() == 0 || ev.getAction() == 2) && !this.startedTracking && !this.maybeStartTracking && ev.getPointerCount() == 1)) {
                this.startedTrackingX = (int) ev.getX();
                int y = (int) ev.getY();
                this.startedTrackingY = y;
                if (y < BottomSheet.this.containerView.getTop() || this.startedTrackingX < BottomSheet.this.containerView.getLeft() || this.startedTrackingX > BottomSheet.this.containerView.getRight()) {
                    BottomSheet.this.dismiss();
                    return true;
                }
                this.startedTrackingPointerId = ev.getPointerId(0);
                this.maybeStartTracking = true;
                cancelCurrentAnimation();
                VelocityTracker velocityTracker = this.velocityTracker;
                if (velocityTracker != null) {
                    velocityTracker.clear();
                }
            } else {
                if (ev != null && ev.getAction() == 2 && ev.getPointerId(0) == this.startedTrackingPointerId) {
                    if (this.velocityTracker == null) {
                        this.velocityTracker = VelocityTracker.obtain();
                    }
                    float fAbs = Math.abs((int) (ev.getX() - this.startedTrackingX));
                    float y2 = ((int) ev.getY()) - this.startedTrackingY;
                    this.velocityTracker.addMovement(ev);
                    if (!BottomSheet.this.disableScroll && this.maybeStartTracking && !this.startedTracking && y2 > 0.0f && y2 / 3.0f > Math.abs(fAbs) && Math.abs(y2) >= BottomSheet.this.touchSlop) {
                        this.startedTrackingY = (int) ev.getY();
                        this.maybeStartTracking = false;
                        this.startedTracking = true;
                        requestDisallowInterceptTouchEvent(true);
                    } else if (this.startedTracking) {
                        float translationY = BottomSheet.this.containerView.getTranslationY() + y2;
                        BottomSheet.this.containerView.setTranslationY(translationY >= 0.0f ? translationY : 0.0f);
                        this.startedTrackingY = (int) ev.getY();
                        BottomSheet.this.container.invalidate();
                    }
                } else if (ev == null || (ev.getPointerId(0) == this.startedTrackingPointerId && (ev.getAction() == 3 || ev.getAction() == 1 || ev.getAction() == 6))) {
                    if (this.velocityTracker == null) {
                        this.velocityTracker = VelocityTracker.obtain();
                    }
                    this.velocityTracker.computeCurrentVelocity(1000);
                    float translationY2 = BottomSheet.this.containerView.getTranslationY();
                    if (this.startedTracking || translationY2 != 0.0f) {
                        checkDismiss(this.velocityTracker.getXVelocity(), this.velocityTracker.getYVelocity());
                        this.startedTracking = false;
                    } else {
                        this.maybeStartTracking = false;
                        this.startedTracking = false;
                    }
                    VelocityTracker velocityTracker2 = this.velocityTracker;
                    if (velocityTracker2 != null) {
                        velocityTracker2.recycle();
                        this.velocityTracker = null;
                    }
                    this.startedTrackingPointerId = -1;
                }
            }
            return (!intercept && this.maybeStartTracking) || this.startedTracking || !BottomSheet.this.canDismissWithSwipe();
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent ev) {
            return processTouchEvent(ev, false);
        }

        /* JADX WARN: Removed duplicated region for block: B:39:0x00cc  */
        @Override // android.widget.FrameLayout, android.view.View
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        protected void onMeasure(int r13, int r14) {
            /*
                Method dump skipped, instructions count: 444
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.ActionBar.BottomSheet.ContainerView.onMeasure(int, int):void");
        }

        @Override // android.view.View, android.view.ViewParent
        public void requestLayout() {
            super.requestLayout();
        }

        /* JADX WARN: Removed duplicated region for block: B:66:0x019a  */
        /* JADX WARN: Removed duplicated region for block: B:70:0x01a7  */
        /* JADX WARN: Removed duplicated region for block: B:74:0x01ba  */
        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        protected void onLayout(boolean r17, int r18, int r19, int r20, int r21) {
            /*
                Method dump skipped, instructions count: 498
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.ActionBar.BottomSheet.ContainerView.onLayout(boolean, int, int, int, int):void");
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onLayout$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onLayout$0$BottomSheet$ContainerView(ValueAnimator valueAnimator) {
            BottomSheet.this.containerView.setTranslationY(((Float) valueAnimator.getAnimatedValue()).floatValue());
            invalidate();
        }

        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent event) {
            if (BottomSheet.this.canDismissWithSwipe()) {
                return processTouchEvent(event, true);
            }
            return super.onInterceptTouchEvent(event);
        }

        @Override // android.view.ViewGroup, android.view.ViewParent
        public void requestDisallowInterceptTouchEvent(boolean disallowIntercept) {
            if (this.maybeStartTracking && !this.startedTracking) {
                onTouchEvent(null);
            }
            super.requestDisallowInterceptTouchEvent(disallowIntercept);
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void dispatchDraw(Canvas canvas) {
            super.dispatchDraw(canvas);
            int i = Build.VERSION.SDK_INT;
            if (i >= 26) {
                BottomSheet bottomSheet = BottomSheet.this;
                String str = bottomSheet.navBarColorKey;
                if (str != null) {
                    this.backgroundPaint.setColor(bottomSheet.getThemedColor(str));
                } else {
                    this.backgroundPaint.setColor(bottomSheet.navBarColor);
                }
            } else {
                this.backgroundPaint.setColor(-16777216);
            }
            BottomSheet bottomSheet2 = BottomSheet.this;
            if ((bottomSheet2.drawNavigationBar && bottomSheet2.bottomInset != 0) || BottomSheet.this.currentPanTranslationY != 0.0f) {
                BottomSheet bottomSheet3 = BottomSheet.this;
                float fMax = (bottomSheet3.scrollNavBar || (i >= 29 && bottomSheet3.getAdditionalMandatoryOffsets() > 0)) ? Math.max(0.0f, BottomSheet.this.bottomInset - (BottomSheet.this.containerView.getMeasuredHeight() - BottomSheet.this.containerView.getTranslationY())) : 0.0f;
                BottomSheet bottomSheet4 = BottomSheet.this;
                int i2 = bottomSheet4.drawNavigationBar ? bottomSheet4.bottomInset : 0;
                canvas.drawRect(BottomSheet.this.containerView.getLeft() + BottomSheet.this.backgroundPaddingLeft, ((getMeasuredHeight() - i2) + fMax) - BottomSheet.this.currentPanTranslationY, BottomSheet.this.containerView.getRight() - BottomSheet.this.backgroundPaddingLeft, getMeasuredHeight() + fMax, this.backgroundPaint);
                if (BottomSheet.this.overlayDrawNavBarColor != 0) {
                    this.backgroundPaint.setColor(BottomSheet.this.overlayDrawNavBarColor);
                    canvas.drawRect(BottomSheet.this.containerView.getLeft() + BottomSheet.this.backgroundPaddingLeft, ((getMeasuredHeight() - i2) + fMax) - BottomSheet.this.currentPanTranslationY, BottomSheet.this.containerView.getRight() - BottomSheet.this.backgroundPaddingLeft, getMeasuredHeight() + fMax, this.backgroundPaint);
                }
            }
            BottomSheet bottomSheet5 = BottomSheet.this;
            if (bottomSheet5.drawNavigationBar && bottomSheet5.rightInset != 0 && BottomSheet.this.rightInset > BottomSheet.this.leftInset) {
                BottomSheet bottomSheet6 = BottomSheet.this;
                if (bottomSheet6.fullWidth) {
                    Point point = AndroidUtilities.displaySize;
                    if (point.x > point.y) {
                        int right = bottomSheet6.containerView.getRight();
                        canvas.drawRect(right - r1.backgroundPaddingLeft, BottomSheet.this.containerView.getTranslationY(), BottomSheet.this.containerView.getRight() + BottomSheet.this.rightInset, getMeasuredHeight(), this.backgroundPaint);
                    }
                }
            }
            BottomSheet bottomSheet7 = BottomSheet.this;
            if (bottomSheet7.drawNavigationBar && bottomSheet7.leftInset != 0 && BottomSheet.this.leftInset > BottomSheet.this.rightInset) {
                BottomSheet bottomSheet8 = BottomSheet.this;
                if (bottomSheet8.fullWidth) {
                    Point point2 = AndroidUtilities.displaySize;
                    if (point2.x > point2.y) {
                        canvas.drawRect(0.0f, bottomSheet8.containerView.getTranslationY(), BottomSheet.this.containerView.getLeft() + BottomSheet.this.backgroundPaddingLeft, getMeasuredHeight(), this.backgroundPaint);
                    }
                }
            }
            if (BottomSheet.this.containerView.getTranslationY() < 0.0f) {
                Paint paint = this.backgroundPaint;
                BottomSheet bottomSheet9 = BottomSheet.this;
                String str2 = bottomSheet9.behindKeyboardColorKey;
                paint.setColor(str2 != null ? bottomSheet9.getThemedColor(str2) : bottomSheet9.behindKeyboardColor);
                int left = BottomSheet.this.containerView.getLeft();
                canvas.drawRect(left + r1.backgroundPaddingLeft, BottomSheet.this.containerView.getY() + BottomSheet.this.containerView.getMeasuredHeight(), BottomSheet.this.containerView.getRight() - BottomSheet.this.backgroundPaddingLeft, getMeasuredHeight(), this.backgroundPaint);
            }
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            if (BottomSheet.this.lastInsets != null && this.keyboardHeight != 0) {
                Paint paint = this.backgroundPaint;
                BottomSheet bottomSheet = BottomSheet.this;
                String str = bottomSheet.behindKeyboardColorKey;
                paint.setColor(str != null ? bottomSheet.getThemedColor(str) : bottomSheet.behindKeyboardColor);
                float left = BottomSheet.this.containerView.getLeft() + BottomSheet.this.backgroundPaddingLeft;
                int measuredHeight = getMeasuredHeight() - this.keyboardHeight;
                BottomSheet bottomSheet2 = BottomSheet.this;
                float f = measuredHeight - (bottomSheet2.drawNavigationBar ? bottomSheet2.bottomInset : 0);
                float right = BottomSheet.this.containerView.getRight() - BottomSheet.this.backgroundPaddingLeft;
                int measuredHeight2 = getMeasuredHeight();
                canvas.drawRect(left, f, right, measuredHeight2 - (BottomSheet.this.drawNavigationBar ? r5.bottomInset : 0), this.backgroundPaint);
            }
            BottomSheet.this.onContainerDraw(canvas);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getAdditionalMandatoryOffsets() {
        if (!this.calcMandatoryInsets) {
            return 0;
        }
        Insets systemGestureInsets = this.lastInsets.getSystemGestureInsets();
        if (this.keyboardVisible || !this.drawNavigationBar || systemGestureInsets == null) {
            return 0;
        }
        if (systemGestureInsets.left == 0 && systemGestureInsets.right == 0) {
            return 0;
        }
        return systemGestureInsets.bottom;
    }

    public void setCalcMandatoryInsets(boolean value) {
        this.calcMandatoryInsets = value;
        this.drawNavigationBar = value;
    }

    public static class BottomSheetCell extends FrameLayout {
        int currentType;
        private ImageView imageView;
        private final Theme.ResourcesProvider resourcesProvider;
        private TextView textView;

        public BottomSheetCell(Context context, int type) {
            this(context, type, null);
        }

        public BottomSheetCell(Context context, int type, Theme.ResourcesProvider resourcesProvider) {
            super(context);
            this.resourcesProvider = resourcesProvider;
            this.currentType = type;
            setBackgroundDrawable(Theme.getSelectorDrawable(false));
            ImageView imageView = new ImageView(context);
            this.imageView = imageView;
            imageView.setScaleType(ImageView.ScaleType.CENTER);
            this.imageView.setColorFilter(new PorterDuffColorFilter(getThemedColor("dialogIcon"), PorterDuff.Mode.MULTIPLY));
            addView(this.imageView, LayoutHelper.createFrame(56, 48, (LocaleController.isRTL ? 5 : 3) | 16));
            TextView textView = new TextView(context);
            this.textView = textView;
            textView.setLines(1);
            this.textView.setSingleLine(true);
            this.textView.setGravity(1);
            this.textView.setEllipsize(TextUtils.TruncateAt.END);
            if (type == 0) {
                this.textView.setTextColor(getThemedColor("dialogTextBlack"));
                this.textView.setTextSize(1, 16.0f);
                this.textView.setTypeface(AndroidUtilities.getFontFamily(false));
                addView(this.textView, LayoutHelper.createFrame(-2, -2, (LocaleController.isRTL ? 5 : 3) | 16));
                return;
            }
            if (type == 1) {
                this.textView.setGravity(17);
                this.textView.setTextColor(getThemedColor("dialogTextBlack"));
                this.textView.setTextSize(1, 14.0f);
                this.textView.setTypeface(AndroidUtilities.getFontFamily(true));
                addView(this.textView, LayoutHelper.createFrame(-1, -1.0f));
                return;
            }
            if (type == 2) {
                this.textView.setGravity(17);
                this.textView.setTextColor(getThemedColor("featuredStickers_buttonText"));
                this.textView.setTextSize(1, 14.0f);
                this.textView.setTypeface(AndroidUtilities.getFontFamily(true));
                this.textView.setBackground(Theme.createSimpleSelectorRoundRectDrawable(AndroidUtilities.dp(4.0f), getThemedColor("featuredStickers_addButton"), getThemedColor("featuredStickers_addButtonPressed")));
                addView(this.textView, LayoutHelper.createFrame(-1, -1.0f, 0, 16.0f, 16.0f, 16.0f, 16.0f));
            }
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            int i = this.currentType;
            int i2 = i == 2 ? 80 : 48;
            if (i == 0) {
                widthMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(widthMeasureSpec), 1073741824);
            }
            super.onMeasure(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(i2), 1073741824));
        }

        public void setTextColor(int color) {
            this.textView.setTextColor(color);
        }

        public void setIconColor(int color) {
            this.imageView.setColorFilter(new PorterDuffColorFilter(color, PorterDuff.Mode.MULTIPLY));
        }

        public void setGravity(int gravity) {
            this.textView.setGravity(gravity);
        }

        public void setTextAndIcon(CharSequence text, int icon) {
            setTextAndIcon(text, icon, null, false);
        }

        public void setTextAndIcon(CharSequence text, Drawable icon) {
            setTextAndIcon(text, 0, icon, false);
        }

        public void setTextAndIcon(CharSequence text, int icon, Drawable drawable, boolean bigTitle) {
            this.textView.setText(text);
            if (icon != 0 || drawable != null) {
                if (drawable != null) {
                    this.imageView.setImageDrawable(drawable);
                } else {
                    this.imageView.setImageResource(icon);
                }
                this.imageView.setVisibility(0);
                if (bigTitle) {
                    this.textView.setPadding(AndroidUtilities.dp(LocaleController.isRTL ? 21.0f : 72.0f), 0, AndroidUtilities.dp(LocaleController.isRTL ? 72.0f : 21.0f), 0);
                    this.imageView.setPadding(LocaleController.isRTL ? 0 : AndroidUtilities.dp(5.0f), 0, LocaleController.isRTL ? AndroidUtilities.dp(5.0f) : 5, 0);
                    return;
                } else {
                    this.textView.setPadding(AndroidUtilities.dp(LocaleController.isRTL ? 16.0f : 72.0f), 0, AndroidUtilities.dp(LocaleController.isRTL ? 72.0f : 16.0f), 0);
                    this.imageView.setPadding(0, 0, 0, 0);
                    return;
                }
            }
            this.imageView.setVisibility(4);
            this.textView.setPadding(AndroidUtilities.dp(bigTitle ? 21.0f : 16.0f), 0, AndroidUtilities.dp(bigTitle ? 21.0f : 16.0f), 0);
        }

        public TextView getTextView() {
            return this.textView;
        }

        public ImageView getImageView() {
            return this.imageView;
        }

        private int getThemedColor(String key) {
            Theme.ResourcesProvider resourcesProvider = this.resourcesProvider;
            Integer color = resourcesProvider != null ? resourcesProvider.getColor(key) : null;
            return color != null ? color.intValue() : Theme.getColor(key);
        }
    }

    public void setAllowNestedScroll(boolean value) {
        this.allowNestedScroll = value;
        if (value) {
            return;
        }
        this.containerView.setTranslationY(0.0f);
    }

    public BottomSheet(Context context, boolean needFocus) {
        this(context, needFocus, null);
    }

    public BottomSheet(Context context, boolean needFocus, Theme.ResourcesProvider resourcesProvider) {
        super(context, R.style.TransparentDialog);
        this.currentAccount = UserConfig.selectedAccount;
        this.allowDrawContent = true;
        this.useHardwareLayer = true;
        this.backDrawable = new ColorDrawable(-16777216) { // from class: ir.eitaa.ui.ActionBar.BottomSheet.1
            @Override // android.graphics.drawable.ColorDrawable, android.graphics.drawable.Drawable
            public void setAlpha(int alpha) {
                super.setAlpha(alpha);
                BottomSheet.this.container.invalidate();
            }
        };
        this.useLightStatusBar = true;
        this.behindKeyboardColorKey = "dialogBackground";
        this.canDismissWithSwipe = true;
        this.allowCustomAnimation = true;
        this.statusBarHeight = AndroidUtilities.statusBarHeight;
        this.openInterpolator = CubicBezierInterpolator.EASE_OUT_QUINT;
        this.dimBehind = true;
        this.dimBehindAlpha = 51;
        this.allowNestedScroll = true;
        this.applyTopPadding = true;
        this.applyBottomPadding = true;
        this.itemViews = new ArrayList<>();
        this.dismissRunnable = new Runnable() { // from class: ir.eitaa.ui.ActionBar.-$$Lambda$AmmPSj03_WRTsmfo83UTzD2hJME
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.dismiss();
            }
        };
        this.navBarColorKey = "windowBackgroundGray";
        this.resourcesProvider = resourcesProvider;
        int i = Build.VERSION.SDK_INT;
        if (i >= 30) {
            getWindow().addFlags(-2147483392);
        } else if (i >= 21) {
            getWindow().addFlags(-2147417856);
        }
        this.touchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        Rect rect = new Rect();
        Drawable drawableMutate = context.getResources().getDrawable(R.drawable.sheet_shadow_round).mutate();
        this.shadowDrawable = drawableMutate;
        drawableMutate.setColorFilter(new PorterDuffColorFilter(getThemedColor("dialogBackground"), PorterDuff.Mode.MULTIPLY));
        this.shadowDrawable.getPadding(rect);
        this.backgroundPaddingLeft = rect.left;
        this.backgroundPaddingTop = rect.top;
        ContainerView containerView = new ContainerView(getContext()) { // from class: ir.eitaa.ui.ActionBar.BottomSheet.2
            @Override // android.view.ViewGroup
            public boolean drawChild(Canvas canvas, View child, long drawingTime) {
                try {
                    if (BottomSheet.this.allowDrawContent) {
                        if (super.drawChild(canvas, child, drawingTime)) {
                            return true;
                        }
                    }
                    return false;
                } catch (Exception e) {
                    FileLog.e(e);
                    return true;
                }
            }
        };
        this.container = containerView;
        containerView.setBackgroundDrawable(this.backDrawable);
        this.focusable = needFocus;
        if (i >= 21) {
            this.container.setFitsSystemWindows(true);
            this.container.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: ir.eitaa.ui.ActionBar.-$$Lambda$BottomSheet$HFkC-vCRbZmxxKa0lH9lASJt-i8
                @Override // android.view.View.OnApplyWindowInsetsListener
                public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                    return this.f$0.lambda$new$0$BottomSheet(view, windowInsets);
                }
            });
            if (i >= 30) {
                this.container.setSystemUiVisibility(1792);
            } else {
                this.container.setSystemUiVisibility(1280);
            }
        }
        this.backDrawable.setAlpha(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ WindowInsets lambda$new$0$BottomSheet(View view, WindowInsets windowInsets) {
        int i;
        int systemWindowInsetTop = windowInsets.getSystemWindowInsetTop();
        if ((systemWindowInsetTop != 0 || AndroidUtilities.isInMultiwindow) && (i = this.statusBarHeight) != 0 && i != systemWindowInsetTop) {
            this.statusBarHeight = systemWindowInsetTop;
        }
        this.lastInsets = windowInsets;
        view.requestLayout();
        if (Build.VERSION.SDK_INT >= 30) {
            return WindowInsets.CONSUMED;
        }
        return windowInsets.consumeSystemWindowInsets();
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle savedInstanceState) {
        int i;
        super.onCreate(savedInstanceState);
        Window window = getWindow();
        window.setWindowAnimations(R.style.DialogNoAnimation);
        setContentView(this.container, new ViewGroup.LayoutParams(-1, -1));
        if (this.useLightStatusBar && Build.VERSION.SDK_INT >= 23 && Theme.getColor("actionBarDefault", null, true) == -1) {
            this.container.setSystemUiVisibility(this.container.getSystemUiVisibility() | 8192);
        }
        if (this.useLightNavBar && Build.VERSION.SDK_INT >= 26) {
            AndroidUtilities.setLightNavigationBar(getWindow(), false);
        }
        if (this.containerView == null) {
            FrameLayout frameLayout = new FrameLayout(getContext()) { // from class: ir.eitaa.ui.ActionBar.BottomSheet.3
                @Override // android.view.View
                public boolean hasOverlappingRendering() {
                    return false;
                }

                @Override // android.view.View
                public void setTranslationY(float translationY) {
                    super.setTranslationY(translationY);
                    BottomSheet.this.onContainerTranslationYChanged(translationY);
                }
            };
            this.containerView = frameLayout;
            frameLayout.setBackgroundDrawable(this.shadowDrawable);
            this.containerView.setPadding(this.backgroundPaddingLeft, ((this.applyTopPadding ? AndroidUtilities.dp(8.0f) : 0) + this.backgroundPaddingTop) - 1, this.backgroundPaddingLeft, this.applyBottomPadding ? AndroidUtilities.dp(8.0f) : 0);
        }
        this.containerView.setVisibility(4);
        this.container.addView(this.containerView, 0, LayoutHelper.createFrame(-1, -2, 80));
        if (this.title != null) {
            TextView textView = new TextView(getContext());
            this.titleView = textView;
            textView.setLines(1);
            this.titleView.setSingleLine(true);
            this.titleView.setText(this.title);
            if (this.bigTitle) {
                this.titleView.setTextColor(getThemedColor("dialogTextBlack"));
                this.titleView.setTextSize(1, 20.0f);
                this.titleView.setTypeface(AndroidUtilities.getFontFamily(true));
                this.titleView.setPadding(AndroidUtilities.dp(21.0f), AndroidUtilities.dp(6.0f), AndroidUtilities.dp(21.0f), AndroidUtilities.dp(8.0f));
            } else {
                this.titleView.setTextColor(getThemedColor("dialogTextGray2"));
                this.titleView.setTextSize(1, 16.0f);
                this.titleView.setTypeface(AndroidUtilities.getFontFamily(false));
                this.titleView.setPadding(AndroidUtilities.dp(16.0f), 0, AndroidUtilities.dp(16.0f), AndroidUtilities.dp(8.0f));
            }
            this.titleView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
            this.titleView.setGravity(16);
            this.containerView.addView(this.titleView, LayoutHelper.createFrame(-1, 48.0f));
            this.titleView.setOnTouchListener(new View.OnTouchListener() { // from class: ir.eitaa.ui.ActionBar.-$$Lambda$BottomSheet$StPIdFVN4Tx6jCWasRXrFocdqpw
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    return BottomSheet.lambda$onCreate$1(view, motionEvent);
                }
            });
            i = 48;
        } else {
            i = 0;
        }
        View view = this.customView;
        if (view != null) {
            if (view.getParent() != null) {
                ((ViewGroup) this.customView.getParent()).removeView(this.customView);
            }
            this.containerView.addView(this.customView, LayoutHelper.createFrame(-1, -2.0f, 51, 0.0f, i, 0.0f, 0.0f));
        } else if (this.items != null) {
            int i2 = 0;
            while (true) {
                CharSequence[] charSequenceArr = this.items;
                if (i2 >= charSequenceArr.length) {
                    break;
                }
                if (charSequenceArr[i2] != null) {
                    BottomSheetCell bottomSheetCell = new BottomSheetCell(getContext(), 0, this.resourcesProvider);
                    CharSequence charSequence = this.items[i2];
                    int[] iArr = this.itemIcons;
                    bottomSheetCell.setTextAndIcon(charSequence, iArr != null ? iArr[i2] : 0, null, this.bigTitle);
                    this.containerView.addView(bottomSheetCell, LayoutHelper.createFrame(-1, 48.0f, 51, 0.0f, i, 0.0f, 0.0f));
                    i += 48;
                    bottomSheetCell.setTag(Integer.valueOf(i2));
                    bottomSheetCell.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.ActionBar.-$$Lambda$BottomSheet$6VyVL-lCnVjsVozdifOSjgoxHmY
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view2) {
                            this.f$0.lambda$onCreate$2$BottomSheet(view2);
                        }
                    });
                    this.itemViews.add(bottomSheetCell);
                }
                i2++;
            }
        }
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.gravity = 51;
        attributes.dimAmount = 0.0f;
        int i3 = attributes.flags & (-3);
        attributes.flags = i3;
        if (this.focusable) {
            attributes.softInputMode = 16;
        } else {
            attributes.flags = i3 | 131072;
        }
        if (this.isFullscreen) {
            if (Build.VERSION.SDK_INT >= 21) {
                attributes.flags |= -2147417856;
            }
            attributes.flags |= Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV;
            this.container.setSystemUiVisibility(1284);
        }
        attributes.height = -1;
        if (Build.VERSION.SDK_INT >= 28) {
            attributes.layoutInDisplayCutoutMode = 1;
        }
        window.setAttributes(attributes);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onCreate$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onCreate$2$BottomSheet(View view) {
        dismissWithButtonClick(((Integer) view.getTag()).intValue());
    }

    public void setUseLightStatusBar(boolean value) {
        this.useLightStatusBar = value;
        if (Build.VERSION.SDK_INT >= 23) {
            int color = Theme.getColor("actionBarDefault", null, true);
            int systemUiVisibility = this.container.getSystemUiVisibility();
            this.container.setSystemUiVisibility((this.useLightStatusBar && color == -1) ? systemUiVisibility | 8192 : systemUiVisibility & (-8193));
        }
    }

    public void setFocusable(boolean value) {
        if (this.focusable == value) {
            return;
        }
        this.focusable = value;
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        if (this.focusable) {
            attributes.softInputMode = 16;
            attributes.flags &= -131073;
        } else {
            attributes.softInputMode = 48;
            attributes.flags |= 131072;
        }
        window.setAttributes(attributes);
    }

    public void setShowWithoutAnimation(boolean value) {
        this.showWithoutAnimation = value;
    }

    public void setBackgroundColor(int color) {
        this.shadowDrawable.setColorFilter(color, PorterDuff.Mode.MULTIPLY);
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        if (this.focusable) {
            getWindow().setSoftInputMode(16);
        }
        this.dismissed = false;
        cancelSheetAnimation();
        this.containerView.measure(View.MeasureSpec.makeMeasureSpec(AndroidUtilities.displaySize.x + (this.backgroundPaddingLeft * 2), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.displaySize.y, Integer.MIN_VALUE));
        if (this.showWithoutAnimation) {
            this.backDrawable.setAlpha(this.dimBehind ? this.dimBehindAlpha : 0);
            this.containerView.setTranslationY(0.0f);
            return;
        }
        this.backDrawable.setAlpha(0);
        int i = Build.VERSION.SDK_INT;
        if (i >= 18) {
            this.layoutCount = 2;
            this.containerView.setTranslationY((i >= 21 ? AndroidUtilities.statusBarHeight : 0) + r2.getMeasuredHeight());
            Runnable runnable = new Runnable() { // from class: ir.eitaa.ui.ActionBar.BottomSheet.4
                @Override // java.lang.Runnable
                public void run() {
                    BottomSheet bottomSheet = BottomSheet.this;
                    if (bottomSheet.startAnimationRunnable != this || bottomSheet.dismissed) {
                        return;
                    }
                    BottomSheet bottomSheet2 = BottomSheet.this;
                    bottomSheet2.startAnimationRunnable = null;
                    bottomSheet2.startOpenAnimation();
                }
            };
            this.startAnimationRunnable = runnable;
            AndroidUtilities.runOnUIThread(runnable, 150L);
            return;
        }
        startOpenAnimation();
    }

    public ColorDrawable getBackDrawable() {
        return this.backDrawable;
    }

    public int getBackgroundPaddingTop() {
        return this.backgroundPaddingTop;
    }

    public void setAllowDrawContent(boolean value) {
        if (this.allowDrawContent != value) {
            this.allowDrawContent = value;
            this.container.setBackgroundDrawable(value ? this.backDrawable : null);
            this.container.invalidate();
        }
    }

    protected boolean canDismissWithSwipe() {
        return this.canDismissWithSwipe;
    }

    public void setCanDismissWithSwipe(boolean value) {
        this.canDismissWithSwipe = value;
    }

    public void setCustomView(View view) {
        this.customView = view;
    }

    @Override // android.app.Dialog
    public void setTitle(CharSequence value) {
        setTitle(value, false);
    }

    public void setTitle(CharSequence value, boolean big) {
        this.title = value;
        this.bigTitle = big;
    }

    public void setApplyTopPadding(boolean value) {
        this.applyTopPadding = value;
    }

    public void setApplyBottomPadding(boolean value) {
        this.applyBottomPadding = value;
    }

    public TextView getTitleView() {
        return this.titleView;
    }

    private void cancelSheetAnimation() {
        AnimatorSet animatorSet = this.currentSheetAnimation;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.currentSheetAnimation = null;
            this.currentSheetAnimationType = 0;
        }
    }

    public void setOnHideListener(DialogInterface.OnDismissListener listener) {
        this.onHideListener = listener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startOpenAnimation() {
        if (this.dismissed) {
            return;
        }
        this.containerView.setVisibility(0);
        if (onCustomOpenAnimation()) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 20 && this.useHardwareLayer) {
            this.container.setLayerType(2, null);
        }
        this.containerView.setTranslationY(r0.getMeasuredHeight());
        this.currentSheetAnimationType = 1;
        AnimatorSet animatorSet = new AnimatorSet();
        this.currentSheetAnimation = animatorSet;
        Animator[] animatorArr = new Animator[2];
        animatorArr[0] = ObjectAnimator.ofFloat(this.containerView, (Property<ViewGroup, Float>) View.TRANSLATION_Y, 0.0f);
        ColorDrawable colorDrawable = this.backDrawable;
        Property<ColorDrawable, Integer> property = AnimationProperties.COLOR_DRAWABLE_ALPHA;
        int[] iArr = new int[1];
        iArr[0] = this.dimBehind ? this.dimBehindAlpha : 0;
        animatorArr[1] = ObjectAnimator.ofInt(colorDrawable, property, iArr);
        animatorSet.playTogether(animatorArr);
        this.currentSheetAnimation.setDuration(400L);
        this.currentSheetAnimation.setStartDelay(20L);
        this.currentSheetAnimation.setInterpolator(this.openInterpolator);
        this.currentSheetAnimation.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.ActionBar.BottomSheet.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                AnimatorSet animatorSet2 = BottomSheet.this.currentSheetAnimation;
                if (animatorSet2 != null && animatorSet2.equals(animation)) {
                    BottomSheet bottomSheet = BottomSheet.this;
                    bottomSheet.currentSheetAnimation = null;
                    bottomSheet.currentSheetAnimationType = 0;
                    if (bottomSheet.delegate != null) {
                        BottomSheet.this.delegate.onOpenAnimationEnd();
                    }
                    if (BottomSheet.this.useHardwareLayer) {
                        BottomSheet.this.container.setLayerType(0, null);
                    }
                    BottomSheet bottomSheet2 = BottomSheet.this;
                    if (bottomSheet2.isFullscreen) {
                        WindowManager.LayoutParams attributes = bottomSheet2.getWindow().getAttributes();
                        attributes.flags &= -1025;
                        BottomSheet.this.getWindow().setAttributes(attributes);
                    }
                }
                NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.startAllHeavyOperations, Integer.valueOf(Factory.DEVICE_USE_ANDROID_CAMCORDER));
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
                AnimatorSet animatorSet2 = BottomSheet.this.currentSheetAnimation;
                if (animatorSet2 == null || !animatorSet2.equals(animation)) {
                    return;
                }
                BottomSheet bottomSheet = BottomSheet.this;
                bottomSheet.currentSheetAnimation = null;
                bottomSheet.currentSheetAnimationType = 0;
            }
        });
        NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.stopAllHeavyOperations, Integer.valueOf(Factory.DEVICE_USE_ANDROID_CAMCORDER));
        this.currentSheetAnimation.start();
    }

    public void setDelegate(BottomSheetDelegateInterface bottomSheetDelegate) {
        this.delegate = bottomSheetDelegate;
    }

    public FrameLayout getContainer() {
        return this.container;
    }

    public ViewGroup getSheetContainer() {
        return this.containerView;
    }

    public void setDimBehind(boolean value) {
        this.dimBehind = value;
    }

    public void setDimBehindAlpha(int value) {
        this.dimBehindAlpha = value;
    }

    public void setItemColor(int item, int color, int icon) {
        if (item < 0 || item >= this.itemViews.size()) {
            return;
        }
        BottomSheetCell bottomSheetCell = this.itemViews.get(item);
        bottomSheetCell.textView.setTextColor(color);
        bottomSheetCell.imageView.setColorFilter(new PorterDuffColorFilter(icon, PorterDuff.Mode.MULTIPLY));
    }

    public ArrayList<BottomSheetCell> getItemViews() {
        return this.itemViews;
    }

    public void setItems(CharSequence[] i, int[] icons, final DialogInterface.OnClickListener listener) {
        this.items = i;
        this.itemIcons = icons;
        this.onClickListener = listener;
    }

    public void setTitleColor(int color) {
        TextView textView = this.titleView;
        if (textView == null) {
            return;
        }
        textView.setTextColor(color);
    }

    public boolean isDismissed() {
        return this.dismissed;
    }

    public void dismissWithButtonClick(final int item) {
        if (this.dismissed) {
            return;
        }
        this.dismissed = true;
        cancelSheetAnimation();
        this.currentSheetAnimationType = 2;
        AnimatorSet animatorSet = new AnimatorSet();
        this.currentSheetAnimation = animatorSet;
        animatorSet.playTogether(ObjectAnimator.ofFloat(this.containerView, (Property<ViewGroup, Float>) View.TRANSLATION_Y, r3.getMeasuredHeight() + AndroidUtilities.dp(10.0f)), ObjectAnimator.ofInt(this.backDrawable, AnimationProperties.COLOR_DRAWABLE_ALPHA, 0));
        this.currentSheetAnimation.setDuration(180L);
        this.currentSheetAnimation.setInterpolator(CubicBezierInterpolator.EASE_OUT);
        this.currentSheetAnimation.addListener(new AnonymousClass6(item));
        NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.stopAllHeavyOperations, Integer.valueOf(Factory.DEVICE_USE_ANDROID_CAMCORDER));
        this.currentSheetAnimation.start();
    }

    /* renamed from: ir.eitaa.ui.ActionBar.BottomSheet$6, reason: invalid class name */
    class AnonymousClass6 extends AnimatorListenerAdapter {
        final /* synthetic */ int val$item;

        AnonymousClass6(final int val$item) {
            this.val$item = val$item;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            AnimatorSet animatorSet = BottomSheet.this.currentSheetAnimation;
            if (animatorSet != null && animatorSet.equals(animation)) {
                BottomSheet bottomSheet = BottomSheet.this;
                bottomSheet.currentSheetAnimation = null;
                bottomSheet.currentSheetAnimationType = 0;
                if (bottomSheet.onClickListener != null) {
                    BottomSheet.this.onClickListener.onClick(BottomSheet.this, this.val$item);
                }
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.ActionBar.-$$Lambda$BottomSheet$6$2O3KSyI9_4ze4EVQd2DzJ8uXIHU
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onAnimationEnd$0$BottomSheet$6();
                    }
                });
            }
            NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.startAllHeavyOperations, Integer.valueOf(Factory.DEVICE_USE_ANDROID_CAMCORDER));
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onAnimationEnd$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onAnimationEnd$0$BottomSheet$6() {
            try {
                BottomSheet.super.dismiss();
            } catch (Exception e) {
                FileLog.e(e);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animation) {
            AnimatorSet animatorSet = BottomSheet.this.currentSheetAnimation;
            if (animatorSet == null || !animatorSet.equals(animation)) {
                return;
            }
            BottomSheet bottomSheet = BottomSheet.this;
            bottomSheet.currentSheetAnimation = null;
            bottomSheet.currentSheetAnimationType = 0;
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (this.dismissed) {
            return false;
        }
        return super.dispatchTouchEvent(ev);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        long jMax;
        BottomSheetDelegateInterface bottomSheetDelegateInterface = this.delegate;
        if ((bottomSheetDelegateInterface == null || bottomSheetDelegateInterface.canDismiss()) && !this.dismissed) {
            this.dismissed = true;
            DialogInterface.OnDismissListener onDismissListener = this.onHideListener;
            if (onDismissListener != null) {
                onDismissListener.onDismiss(this);
            }
            cancelSheetAnimation();
            if (this.allowCustomAnimation && onCustomCloseAnimation()) {
                jMax = 0;
            } else {
                this.currentSheetAnimationType = 2;
                AnimatorSet animatorSet = new AnimatorSet();
                this.currentSheetAnimation = animatorSet;
                animatorSet.playTogether(ObjectAnimator.ofFloat(this.containerView, (Property<ViewGroup, Float>) View.TRANSLATION_Y, r5.getMeasuredHeight() + this.container.keyboardHeight + AndroidUtilities.dp(10.0f)), ObjectAnimator.ofInt(this.backDrawable, AnimationProperties.COLOR_DRAWABLE_ALPHA, 0));
                if (this.useFastDismiss) {
                    float measuredHeight = this.containerView.getMeasuredHeight();
                    jMax = Math.max(60, (int) (((measuredHeight - this.containerView.getTranslationY()) * 250.0f) / measuredHeight));
                    this.currentSheetAnimation.setDuration(jMax);
                    this.useFastDismiss = false;
                } else {
                    jMax = 250;
                    this.currentSheetAnimation.setDuration(250L);
                }
                this.currentSheetAnimation.setInterpolator(CubicBezierInterpolator.DEFAULT);
                this.currentSheetAnimation.addListener(new AnonymousClass7());
                NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.stopAllHeavyOperations, Integer.valueOf(Factory.DEVICE_USE_ANDROID_CAMCORDER));
                this.currentSheetAnimation.start();
            }
            Bulletin visibleBulletin = Bulletin.getVisibleBulletin();
            if (visibleBulletin == null || !visibleBulletin.isShowing()) {
                return;
            }
            if (jMax > 0) {
                visibleBulletin.hide((long) (jMax * 0.6f));
            } else {
                visibleBulletin.hide();
            }
        }
    }

    /* renamed from: ir.eitaa.ui.ActionBar.BottomSheet$7, reason: invalid class name */
    class AnonymousClass7 extends AnimatorListenerAdapter {
        AnonymousClass7() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            AnimatorSet animatorSet = BottomSheet.this.currentSheetAnimation;
            if (animatorSet != null && animatorSet.equals(animation)) {
                BottomSheet bottomSheet = BottomSheet.this;
                bottomSheet.currentSheetAnimation = null;
                bottomSheet.currentSheetAnimationType = 0;
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.ActionBar.-$$Lambda$BottomSheet$7$mXqSW6SA-dYDkXrNFwa4x7OjkMw
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onAnimationEnd$0$BottomSheet$7();
                    }
                });
            }
            NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.startAllHeavyOperations, Integer.valueOf(Factory.DEVICE_USE_ANDROID_CAMCORDER));
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onAnimationEnd$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onAnimationEnd$0$BottomSheet$7() {
            try {
                BottomSheet.this.dismissInternal();
            } catch (Exception e) {
                FileLog.e(e);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animation) {
            AnimatorSet animatorSet = BottomSheet.this.currentSheetAnimation;
            if (animatorSet == null || !animatorSet.equals(animation)) {
                return;
            }
            BottomSheet bottomSheet = BottomSheet.this;
            bottomSheet.currentSheetAnimation = null;
            bottomSheet.currentSheetAnimationType = 0;
        }
    }

    public int getSheetAnimationType() {
        return this.currentSheetAnimationType;
    }

    public void dismissInternal() {
        try {
            super.dismiss();
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public static class Builder {
        private BottomSheet bottomSheet;

        public Builder(Context context) {
            this(context, false);
        }

        public Builder(Context context, boolean needFocus) {
            this(context, needFocus, null);
        }

        public Builder(Context context, boolean needFocus, Theme.ResourcesProvider resourcesProvider) {
            this.bottomSheet = new BottomSheet(context, needFocus, resourcesProvider);
        }

        public Builder setItems(CharSequence[] items, final DialogInterface.OnClickListener onClickListener) {
            this.bottomSheet.items = items;
            this.bottomSheet.onClickListener = onClickListener;
            return this;
        }

        public Builder setItems(CharSequence[] items, int[] icons, final DialogInterface.OnClickListener onClickListener) {
            this.bottomSheet.items = items;
            this.bottomSheet.itemIcons = icons;
            this.bottomSheet.onClickListener = onClickListener;
            return this;
        }

        public Builder setCustomView(View view) {
            this.bottomSheet.customView = view;
            return this;
        }

        public Builder setTitle(CharSequence title) {
            return setTitle(title, false);
        }

        public Builder setTitle(CharSequence title, boolean big) {
            this.bottomSheet.title = title;
            this.bottomSheet.bigTitle = big;
            return this;
        }

        public BottomSheet create() {
            return this.bottomSheet;
        }

        public BottomSheet setDimBehind(boolean value) {
            this.bottomSheet.dimBehind = value;
            return this.bottomSheet;
        }

        public BottomSheet show() {
            this.bottomSheet.show();
            return this.bottomSheet;
        }

        public Builder setUseHardwareLayer(boolean value) {
            this.bottomSheet.useHardwareLayer = value;
            return this;
        }

        public Builder setDelegate(BottomSheetDelegate delegate) {
            this.bottomSheet.setDelegate(delegate);
            return this;
        }

        public Builder setApplyTopPadding(boolean value) {
            this.bottomSheet.applyTopPadding = value;
            return this;
        }

        public Builder setApplyBottomPadding(boolean value) {
            this.bottomSheet.applyBottomPadding = value;
            return this;
        }

        public Runnable getDismissRunnable() {
            return this.bottomSheet.dismissRunnable;
        }
    }

    public int getLeftInset() {
        WindowInsets windowInsets = this.lastInsets;
        if (windowInsets == null || Build.VERSION.SDK_INT < 21) {
            return 0;
        }
        return windowInsets.getSystemWindowInsetLeft();
    }

    public int getRightInset() {
        WindowInsets windowInsets = this.lastInsets;
        if (windowInsets == null || Build.VERSION.SDK_INT < 21) {
            return 0;
        }
        return windowInsets.getSystemWindowInsetRight();
    }

    public int getBottomInset() {
        return this.bottomInset;
    }

    public void setCurrentPanTranslationY(float currentPanTranslationY) {
        this.currentPanTranslationY = currentPanTranslationY;
        this.container.invalidate();
    }

    public void setOverlayNavBarColor(int color) {
        this.overlayDrawNavBarColor = color;
        ContainerView containerView = this.container;
        if (containerView != null) {
            containerView.invalidate();
        }
        if (Color.alpha(color) > 120) {
            AndroidUtilities.setLightStatusBar(getWindow(), false);
            AndroidUtilities.setLightNavigationBar(getWindow(), false);
        } else {
            AndroidUtilities.setLightNavigationBar(getWindow(), !this.useLightNavBar);
            AndroidUtilities.setLightStatusBar(getWindow(), !this.useLightStatusBar);
        }
    }

    public ViewGroup getContainerView() {
        return this.containerView;
    }

    public int getCurrentAccount() {
        return this.currentAccount;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getThemedColor(String key) {
        Theme.ResourcesProvider resourcesProvider = this.resourcesProvider;
        Integer color = resourcesProvider != null ? resourcesProvider.getColor(key) : null;
        return color != null ? color.intValue() : Theme.getColor(key);
    }
}
