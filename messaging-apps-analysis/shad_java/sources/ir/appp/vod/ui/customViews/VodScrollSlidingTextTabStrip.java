package ir.appp.vod.ui.customViews;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.SystemClock;
import android.util.SparseIntArray;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Keep;
import ir.appp.vod.ui.customViews.VodScrollSlidingTextTabStrip;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.LocaleController;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Components.CubicBezierInterpolator;

/* compiled from: VodScrollSlidingTextTabStrip.kt */
/* loaded from: classes3.dex */
public final class VodScrollSlidingTextTabStrip extends HorizontalScrollView {
    private int activeTextColorKey;
    private int allTextWidth;
    private int animateFromIndicatorWidth;
    private int animateFromIndicaxtorX;
    private int animateIndicatorStartWidth;
    private int animateIndicatorStartX;
    private int animateIndicatorToWidth;
    private int animateIndicatorToX;
    private final Runnable animationRunnable;
    private float animationTime;
    private int currentPosition;
    private int currentTabId;
    private ScrollSlidingTabStripDelegate delegate;
    private final SparseIntArray idToPosition;
    private int indicatorWidth;
    private float indicatorWidthAnimationDx;
    private int indicatorX;
    private float indicatorXAnimationDx;
    private final CubicBezierInterpolator interpolator;
    private boolean isAnimatingIndicator;
    private final SparseIntArray positionToId;
    private final SparseIntArray positionToWidth;
    private int prevLayoutWidth;
    private int previousPosition;
    private int scrollingToChild;
    private final GradientDrawable selectorDrawable;
    private final int slideBarHeight;
    private LinearLayout tabsContainer;
    private int tabsCount;
    private int unactiveTextColorKey;
    private boolean useSameWidth;

    /* compiled from: VodScrollSlidingTextTabStrip.kt */
    public interface ScrollSlidingTabStripDelegate {
        void onPageScrolled(float f);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VodScrollSlidingTextTabStrip(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        new LinkedHashMap();
        this.slideBarHeight = AndroidUtilities.dpr(5.0f);
        this.selectorDrawable = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, null);
        this.activeTextColorKey = Theme.key_actionBarTabActiveText;
        this.unactiveTextColorKey = Theme.key_actionBarTabUnactiveText;
        this.interpolator = CubicBezierInterpolator.EASE_OUT_QUINT;
        this.positionToId = new SparseIntArray(5);
        this.idToPosition = new SparseIntArray(5);
        this.positionToWidth = new SparseIntArray(5);
        this.scrollingToChild = -1;
        this.currentTabId = -1;
        this.animationRunnable = new Runnable() { // from class: ir.appp.vod.ui.customViews.VodScrollSlidingTextTabStrip$animationRunnable$1
            @Override // java.lang.Runnable
            public void run() {
                if (this.this$0.isAnimatingIndicator()) {
                    long jElapsedRealtime = SystemClock.elapsedRealtime();
                    if (jElapsedRealtime > 17) {
                        jElapsedRealtime = 17;
                    }
                    this.this$0.animationTime += jElapsedRealtime / 200.0f;
                    VodScrollSlidingTextTabStrip vodScrollSlidingTextTabStrip = this.this$0;
                    vodScrollSlidingTextTabStrip.setAnimationIdicatorProgress(vodScrollSlidingTextTabStrip.interpolator.getInterpolation(this.this$0.animationTime));
                    if (this.this$0.animationTime > 1.0f) {
                        this.this$0.animationTime = 1.0f;
                    }
                    if (this.this$0.animationTime >= 1.0f) {
                        this.this$0.isAnimatingIndicator = false;
                        this.this$0.setEnabled(true);
                        VodScrollSlidingTextTabStrip.ScrollSlidingTabStripDelegate scrollSlidingTabStripDelegate = this.this$0.delegate;
                        if (scrollSlidingTabStripDelegate == null) {
                            return;
                        }
                        scrollSlidingTabStripDelegate.onPageScrolled(1.0f);
                        return;
                    }
                    AndroidUtilities.runOnUIThread(this);
                }
            }
        };
        initViews();
    }

    public final int getTabsCount() {
        return this.tabsCount;
    }

    public final int getCurrentPosition() {
        return this.currentPosition;
    }

    public final int getCurrentTabId() {
        return this.currentTabId;
    }

    public final boolean isAnimatingIndicator() {
        return this.isAnimatingIndicator;
    }

    private final void initViews() {
        float fDpf2 = AndroidUtilities.dpf2(0.0f);
        this.selectorDrawable.setCornerRadii(new float[]{fDpf2, fDpf2, fDpf2, fDpf2, 0.0f, 0.0f, 0.0f, 0.0f});
        this.selectorDrawable.setColor(-1767148);
        setFillViewport(true);
        setWillNotDraw(false);
        setHorizontalScrollBarEnabled(false);
        LinearLayout linearLayout = new LinearLayout(getContext()) { // from class: ir.appp.vod.ui.customViews.VodScrollSlidingTextTabStrip.initViews.1
            {
                new LinkedHashMap();
            }

            @Override // android.view.View
            public void setAlpha(float f) {
                super.setAlpha(f);
                VodScrollSlidingTextTabStrip.this.invalidate();
            }
        };
        this.tabsContainer = linearLayout;
        if (Build.VERSION.SDK_INT >= 17) {
            linearLayout.setLayoutDirection(1);
        }
        LinearLayout linearLayout2 = this.tabsContainer;
        if (linearLayout2 != null) {
            linearLayout2.setBackgroundColor(-16777216);
        }
        LinearLayout linearLayout3 = this.tabsContainer;
        if (linearLayout3 != null) {
            linearLayout3.setOrientation(0);
        }
        LinearLayout linearLayout4 = this.tabsContainer;
        if (linearLayout4 != null) {
            linearLayout4.setPadding(AndroidUtilities.dp(7.0f), 0, AndroidUtilities.dp(7.0f), 0);
        }
        LinearLayout linearLayout5 = this.tabsContainer;
        if (linearLayout5 != null) {
            linearLayout5.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        }
        addView(this.tabsContainer);
    }

    private final void setAnimationProgressInernal(TextView textView, TextView textView2, float f) {
        if (textView == null || textView2 == null) {
            return;
        }
        int color = Theme.getColor(this.unactiveTextColorKey);
        int iRed = Color.red(-1);
        int iGreen = Color.green(-1);
        int iBlue = Color.blue(-1);
        int iAlpha = Color.alpha(-1);
        int iRed2 = Color.red(color);
        int iGreen2 = Color.green(color);
        int iBlue2 = Color.blue(color);
        int iAlpha2 = Color.alpha(color);
        textView2.setTextColor(Color.argb((int) (iAlpha + ((iAlpha2 - iAlpha) * f)), (int) (iRed + ((iRed2 - iRed) * f)), (int) (iGreen + ((iGreen2 - iGreen) * f)), (int) (iBlue + ((iBlue2 - iBlue) * f))));
        textView.setTextColor(Color.argb((int) (iAlpha2 + ((iAlpha - iAlpha2) * f)), (int) (iRed2 + ((iRed - iRed2) * f)), (int) (iGreen2 + ((iGreen - iGreen2) * f)), (int) (iBlue2 + ((iBlue - iBlue2) * f))));
        this.indicatorX = (int) (this.animateIndicatorStartX + ((this.animateIndicatorToX - r1) * f));
        this.indicatorWidth = (int) (this.animateIndicatorStartWidth + ((this.animateIndicatorToWidth - r1) * f));
        invalidate();
    }

    @Keep
    public final void setAnimationIdicatorProgress(float f) {
        LinearLayout linearLayout = this.tabsContainer;
        View childAt = linearLayout == null ? null : linearLayout.getChildAt(this.currentPosition);
        TextView textView = childAt instanceof TextView ? (TextView) childAt : null;
        LinearLayout linearLayout2 = this.tabsContainer;
        KeyEvent.Callback childAt2 = linearLayout2 == null ? null : linearLayout2.getChildAt(this.previousPosition);
        TextView textView2 = childAt2 instanceof TextView ? (TextView) childAt2 : null;
        if (textView2 == null || textView == null) {
            return;
        }
        setAnimationProgressInernal(textView, textView2, f);
        if (f >= 1.0f) {
            textView2.setTag(Integer.valueOf(this.unactiveTextColorKey));
            textView.setTag(Integer.valueOf(this.activeTextColorKey));
        }
        ScrollSlidingTabStripDelegate scrollSlidingTabStripDelegate = this.delegate;
        if (scrollSlidingTabStripDelegate == null) {
            return;
        }
        scrollSlidingTabStripDelegate.onPageScrolled(f);
    }

    public final void setUseSameWidth(boolean z) {
        this.useSameWidth = z;
    }

    public final Drawable getSelectorDrawable() {
        return this.selectorDrawable;
    }

    public final ViewGroup getTabsContainer() {
        return this.tabsContainer;
    }

    public final int getNextPageId(boolean z) {
        if (LocaleController.isRTL) {
            z = !z;
        }
        return this.positionToId.get(this.currentPosition + (z ? 1 : -1), -1);
    }

    public final void finishAddingTabs() {
        LinearLayout linearLayout = this.tabsContainer;
        int childCount = linearLayout == null ? 0 : linearLayout.getChildCount();
        int i = 0;
        while (i < childCount) {
            int i2 = i + 1;
            LinearLayout linearLayout2 = this.tabsContainer;
            View childAt = linearLayout2 == null ? null : linearLayout2.getChildAt(i);
            TextView textView = childAt instanceof TextView ? (TextView) childAt : null;
            if (textView != null) {
                textView.setTag(Integer.valueOf(this.currentPosition == i ? this.activeTextColorKey : this.unactiveTextColorKey));
            }
            if (textView != null) {
                textView.setTextColor(this.currentPosition == i ? -1 : Theme.getColor(this.unactiveTextColorKey));
            }
            if (i == 0) {
                ViewGroup.LayoutParams layoutParams = textView != null ? textView.getLayoutParams() : null;
                if (layoutParams != null) {
                    layoutParams.width = childCount == 1 ? -2 : 0;
                }
            }
            i = i2;
        }
    }

    public final void setInitialTabId(int i) {
        this.currentTabId = i;
        int i2 = this.idToPosition.get(i);
        LinearLayout linearLayout = this.tabsContainer;
        View childAt = linearLayout == null ? null : linearLayout.getChildAt(i2);
        if ((childAt instanceof TextView ? (TextView) childAt : null) != null) {
            this.currentPosition = i2;
            this.prevLayoutWidth = 0;
            finishAddingTabs();
            requestLayout();
        }
    }

    public final int getFirstTabId() {
        return this.positionToId.get(0, 0);
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View child, long j) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(child, "child");
        boolean zDrawChild = super.drawChild(canvas, child, j);
        if (Intrinsics.areEqual(child, this.tabsContainer)) {
            GradientDrawable gradientDrawable = this.selectorDrawable;
            float f = 255;
            LinearLayout linearLayout = this.tabsContainer;
            gradientDrawable.setAlpha((int) (f * (linearLayout == null ? 1.0f : linearLayout.getAlpha())));
            float f2 = this.indicatorX + this.indicatorXAnimationDx;
            this.selectorDrawable.setBounds((int) f2, 0, (int) (this.indicatorWidth + f2 + this.indicatorWidthAnimationDx), this.slideBarHeight);
            this.selectorDrawable.draw(canvas);
        }
        return zDrawChild;
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i) - AndroidUtilities.dp(22.0f);
        LinearLayout linearLayout = this.tabsContainer;
        int childCount = linearLayout == null ? 0 : linearLayout.getChildCount();
        int i3 = 0;
        while (i3 < childCount) {
            int i4 = i3 + 1;
            LinearLayout linearLayout2 = this.tabsContainer;
            View childAt = linearLayout2 == null ? null : linearLayout2.getChildAt(i3);
            ViewGroup.LayoutParams layoutParams = childAt == null ? null : childAt.getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = layoutParams instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) layoutParams : null;
            if (this.allTextWidth > size) {
                if (layoutParams2 != null) {
                    layoutParams2.weight = 0.0f;
                }
                if (layoutParams2 != null) {
                    layoutParams2.width = -2;
                }
            } else if (this.useSameWidth) {
                if (layoutParams2 != null) {
                    layoutParams2.weight = 1.0f / childCount;
                }
                if (layoutParams2 != null) {
                    layoutParams2.width = 0;
                }
            } else if (i3 == 0 && childCount == 1) {
                if (layoutParams2 != null) {
                    layoutParams2.weight = 0.0f;
                }
                if (layoutParams2 != null) {
                    layoutParams2.width = -2;
                }
            } else {
                if (layoutParams2 != null) {
                    layoutParams2.weight = 0.0f;
                }
                if (layoutParams2 != null) {
                    layoutParams2.width = -2;
                }
            }
            i3 = i4;
        }
        if (childCount == 1 || this.allTextWidth > size) {
            LinearLayout linearLayout3 = this.tabsContainer;
            if (linearLayout3 != null) {
                linearLayout3.setWeightSum(0.0f);
            }
        } else {
            LinearLayout linearLayout4 = this.tabsContainer;
            if (linearLayout4 != null) {
                linearLayout4.setWeightSum(1.0f);
            }
        }
        super.onMeasure(i, i2);
    }

    private final void scrollToChild(int i) {
        if (this.tabsCount == 0 || this.scrollingToChild == i) {
            return;
        }
        this.scrollingToChild = i;
        LinearLayout linearLayout = this.tabsContainer;
        View childAt = linearLayout == null ? null : linearLayout.getChildAt(i);
        TextView textView = childAt instanceof TextView ? (TextView) childAt : null;
        if (textView == null) {
            return;
        }
        int scrollX = getScrollX();
        int left = textView.getLeft();
        int measuredWidth = textView.getMeasuredWidth();
        if (left < scrollX) {
            smoothScrollTo(left, 0);
            return;
        }
        int i2 = left + measuredWidth;
        if (i2 > scrollX + getWidth()) {
            smoothScrollTo(i2, 0);
        }
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        super.onLayout(z, i, i2, i3, i4);
        int i6 = i3 - i;
        if (this.prevLayoutWidth != i6) {
            this.prevLayoutWidth = i6;
            this.scrollingToChild = -1;
            if (this.isAnimatingIndicator) {
                AndroidUtilities.cancelRunOnUIThread(this.animationRunnable);
                this.isAnimatingIndicator = false;
                setEnabled(true);
                ScrollSlidingTabStripDelegate scrollSlidingTabStripDelegate = this.delegate;
                if (scrollSlidingTabStripDelegate != null) {
                    Intrinsics.checkNotNull(scrollSlidingTabStripDelegate);
                    scrollSlidingTabStripDelegate.onPageScrolled(1.0f);
                }
            }
            LinearLayout linearLayout = this.tabsContainer;
            View childAt = linearLayout == null ? null : linearLayout.getChildAt(this.currentPosition);
            TextView textView = childAt instanceof TextView ? (TextView) childAt : null;
            if (textView != null) {
                this.indicatorWidth = textView.getWidth();
                int left = textView.getLeft();
                this.indicatorX = left;
                int i7 = this.animateFromIndicaxtorX;
                if (i7 <= 0 || (i5 = this.animateFromIndicatorWidth) <= 0) {
                    return;
                }
                if (i7 != left || i5 != this.indicatorWidth) {
                    final int i8 = i7 - left;
                    final int i9 = i5 - this.indicatorWidth;
                    ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
                    valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.appp.vod.ui.customViews.VodScrollSlidingTextTabStrip$$ExternalSyntheticLambda0
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                            VodScrollSlidingTextTabStrip.m369onLayout$lambda1(this.f$0, i8, i9, valueAnimator);
                        }
                    });
                    valueAnimatorOfFloat.setDuration(200L);
                    valueAnimatorOfFloat.setInterpolator(CubicBezierInterpolator.DEFAULT);
                    valueAnimatorOfFloat.start();
                }
                this.animateFromIndicaxtorX = 0;
                this.animateFromIndicatorWidth = 0;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onLayout$lambda-1, reason: not valid java name */
    public static final void m369onLayout$lambda1(VodScrollSlidingTextTabStrip this$0, int i, int i2, ValueAnimator valueAnimator1) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(valueAnimator1, "valueAnimator1");
        Object animatedValue = valueAnimator1.getAnimatedValue();
        if (animatedValue == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
        float fFloatValue = ((Float) animatedValue).floatValue();
        this$0.indicatorXAnimationDx = i * fFloatValue;
        this$0.indicatorWidthAnimationDx = i2 * fFloatValue;
        LinearLayout linearLayout = this$0.tabsContainer;
        if (linearLayout != null) {
            linearLayout.invalidate();
        }
        this$0.invalidate();
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        LinearLayout linearLayout = this.tabsContainer;
        int i = 0;
        int childCount = linearLayout == null ? 0 : linearLayout.getChildCount();
        while (i < childCount) {
            int i2 = i + 1;
            LinearLayout linearLayout2 = this.tabsContainer;
            View childAt = linearLayout2 == null ? null : linearLayout2.getChildAt(i);
            if (childAt != null) {
                childAt.setEnabled(z);
            }
            i = i2;
        }
    }

    public final void selectTabWithId(int i, float f) {
        int i2 = this.idToPosition.get(i, -1);
        if (i2 < 0) {
            return;
        }
        if (f < 0.0f) {
            f = 0.0f;
        } else if (f > 1.0f) {
            f = 1.0f;
        }
        LinearLayout linearLayout = this.tabsContainer;
        View childAt = linearLayout == null ? null : linearLayout.getChildAt(this.currentPosition);
        TextView textView = childAt instanceof TextView ? (TextView) childAt : null;
        LinearLayout linearLayout2 = this.tabsContainer;
        KeyEvent.Callback childAt2 = linearLayout2 == null ? null : linearLayout2.getChildAt(i2);
        TextView textView2 = childAt2 instanceof TextView ? (TextView) childAt2 : null;
        if (textView != null && textView2 != null) {
            this.animateIndicatorStartWidth = textView.getWidth();
            this.animateIndicatorStartX = textView.getLeft();
            this.animateIndicatorToWidth = textView2.getWidth();
            this.animateIndicatorToX = textView2.getLeft();
            setAnimationProgressInernal(textView2, textView, f);
            if (f >= 1.0f) {
                textView.setTag(Integer.valueOf(this.unactiveTextColorKey));
                textView2.setTag(Integer.valueOf(this.activeTextColorKey));
            }
            LinearLayout linearLayout3 = this.tabsContainer;
            scrollToChild(linearLayout3 == null ? 0 : linearLayout3.indexOfChild(textView2));
        }
        if (f >= 1.0f) {
            this.currentPosition = i2;
            this.currentTabId = i;
        }
    }

    public final void setDelegate(ScrollSlidingTabStripDelegate scrollSlidingTabStripDelegate) {
        this.delegate = scrollSlidingTabStripDelegate;
    }
}
