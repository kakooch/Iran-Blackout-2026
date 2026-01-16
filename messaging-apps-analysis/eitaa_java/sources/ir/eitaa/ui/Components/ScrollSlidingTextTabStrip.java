package ir.eitaa.ui.Components;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.SystemClock;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Keep;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.ui.ActionBar.Theme;

/* loaded from: classes3.dex */
public class ScrollSlidingTextTabStrip extends HorizontalScrollView {
    private String activeTextColorKey;
    private int allTextWidth;
    private int animateFromIndicatorWidth;
    private int animateFromIndicaxtorX;
    private int animateIndicatorStartWidth;
    private int animateIndicatorStartX;
    private int animateIndicatorToWidth;
    private int animateIndicatorToX;
    private boolean animatingIndicator;
    private float animationIdicatorProgress;
    private Runnable animationRunnable;
    private float animationTime;
    private int currentPosition;
    private ScrollSlidingTabStripDelegate delegate;
    private SparseIntArray idToPosition;
    private int indicatorWidth;
    private float indicatorWidthAnimationDx;
    private int indicatorX;
    private float indicatorXAnimationDx;
    private CubicBezierInterpolator interpolator;
    private long lastAnimationTime;
    private SparseIntArray positionToId;
    private SparseIntArray positionToWidth;
    private int prevLayoutWidth;
    private int previousPosition;
    private int scrollingToChild;
    private int selectedTabId;
    private String selectorColorKey;
    private GradientDrawable selectorDrawable;
    private int tabCount;
    private String tabLineColorKey;
    private LinearLayout tabsContainer;
    private String unactiveTextColorKey;
    private boolean useSameWidth;

    public interface ScrollSlidingTabStripDelegate {

        /* renamed from: ir.eitaa.ui.Components.ScrollSlidingTextTabStrip$ScrollSlidingTabStripDelegate$-CC, reason: invalid class name */
        public final /* synthetic */ class CC {
            public static void $default$onSamePageSelected(ScrollSlidingTabStripDelegate scrollSlidingTabStripDelegate) {
            }
        }

        void onPageScrolled(float progress);

        void onPageSelected(int page, boolean forward);

        void onSamePageSelected();
    }

    static /* synthetic */ float access$216(ScrollSlidingTextTabStrip scrollSlidingTextTabStrip, float f) {
        float f2 = scrollSlidingTextTabStrip.animationTime + f;
        scrollSlidingTextTabStrip.animationTime = f2;
        return f2;
    }

    public ScrollSlidingTextTabStrip(Context context) {
        super(context);
        this.selectedTabId = -1;
        this.scrollingToChild = -1;
        this.tabLineColorKey = "actionBarTabLine";
        this.activeTextColorKey = "actionBarTabActiveText";
        this.unactiveTextColorKey = "actionBarTabUnactiveText";
        this.selectorColorKey = "actionBarTabSelector";
        this.interpolator = CubicBezierInterpolator.EASE_OUT_QUINT;
        this.positionToId = new SparseIntArray(5);
        this.idToPosition = new SparseIntArray(5);
        this.positionToWidth = new SparseIntArray(5);
        this.animationRunnable = new Runnable() { // from class: ir.eitaa.ui.Components.ScrollSlidingTextTabStrip.1
            @Override // java.lang.Runnable
            public void run() {
                if (ScrollSlidingTextTabStrip.this.animatingIndicator) {
                    long jElapsedRealtime = SystemClock.elapsedRealtime() - ScrollSlidingTextTabStrip.this.lastAnimationTime;
                    if (jElapsedRealtime > 17) {
                        jElapsedRealtime = 17;
                    }
                    ScrollSlidingTextTabStrip.access$216(ScrollSlidingTextTabStrip.this, jElapsedRealtime / 200.0f);
                    ScrollSlidingTextTabStrip scrollSlidingTextTabStrip = ScrollSlidingTextTabStrip.this;
                    scrollSlidingTextTabStrip.setAnimationIdicatorProgress(scrollSlidingTextTabStrip.interpolator.getInterpolation(ScrollSlidingTextTabStrip.this.animationTime));
                    if (ScrollSlidingTextTabStrip.this.animationTime > 1.0f) {
                        ScrollSlidingTextTabStrip.this.animationTime = 1.0f;
                    }
                    if (ScrollSlidingTextTabStrip.this.animationTime < 1.0f) {
                        AndroidUtilities.runOnUIThread(ScrollSlidingTextTabStrip.this.animationRunnable);
                        return;
                    }
                    ScrollSlidingTextTabStrip.this.animatingIndicator = false;
                    ScrollSlidingTextTabStrip.this.setEnabled(true);
                    if (ScrollSlidingTextTabStrip.this.delegate != null) {
                        ScrollSlidingTextTabStrip.this.delegate.onPageScrolled(1.0f);
                    }
                }
            }
        };
        this.selectorDrawable = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, null);
        float fDpf2 = AndroidUtilities.dpf2(3.0f);
        this.selectorDrawable.setCornerRadii(new float[]{fDpf2, fDpf2, fDpf2, fDpf2, 0.0f, 0.0f, 0.0f, 0.0f});
        this.selectorDrawable.setColor(Theme.getColor(this.tabLineColorKey));
        setFillViewport(true);
        setWillNotDraw(false);
        setHorizontalScrollBarEnabled(false);
        LinearLayout linearLayout = new LinearLayout(context) { // from class: ir.eitaa.ui.Components.ScrollSlidingTextTabStrip.2
            @Override // android.view.View
            public void setAlpha(float alpha) {
                super.setAlpha(alpha);
                ScrollSlidingTextTabStrip.this.invalidate();
            }
        };
        this.tabsContainer = linearLayout;
        linearLayout.setOrientation(0);
        this.tabsContainer.setPadding(AndroidUtilities.dp(7.0f), 0, AndroidUtilities.dp(7.0f), 0);
        this.tabsContainer.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.tabsContainer);
    }

    public void setDelegate(ScrollSlidingTabStripDelegate scrollSlidingTabStripDelegate) {
        this.delegate = scrollSlidingTabStripDelegate;
    }

    public boolean isAnimatingIndicator() {
        return this.animatingIndicator;
    }

    private void setAnimationProgressInernal(TextView newTab, TextView prevTab, float value) {
        if (newTab == null || prevTab == null) {
            return;
        }
        int color = Theme.getColor(this.activeTextColorKey);
        int color2 = Theme.getColor(this.unactiveTextColorKey);
        int iRed = Color.red(color);
        int iGreen = Color.green(color);
        int iBlue = Color.blue(color);
        int iAlpha = Color.alpha(color);
        int iRed2 = Color.red(color2);
        int iGreen2 = Color.green(color2);
        int iBlue2 = Color.blue(color2);
        int iAlpha2 = Color.alpha(color2);
        prevTab.setTextColor(Color.argb((int) (iAlpha + ((iAlpha2 - iAlpha) * value)), (int) (iRed + ((iRed2 - iRed) * value)), (int) (iGreen + ((iGreen2 - iGreen) * value)), (int) (iBlue + ((iBlue2 - iBlue) * value))));
        newTab.setTextColor(Color.argb((int) (iAlpha2 + ((iAlpha - iAlpha2) * value)), (int) (iRed2 + ((iRed - iRed2) * value)), (int) (iGreen2 + ((iGreen - iGreen2) * value)), (int) (iBlue2 + ((iBlue - iBlue2) * value))));
        this.indicatorX = (int) (this.animateIndicatorStartX + ((this.animateIndicatorToX - r1) * value));
        this.indicatorWidth = (int) (this.animateIndicatorStartWidth + ((this.animateIndicatorToWidth - r1) * value));
        invalidate();
    }

    @Keep
    public void setAnimationIdicatorProgress(float value) {
        this.animationIdicatorProgress = value;
        TextView textView = (TextView) this.tabsContainer.getChildAt(this.currentPosition);
        TextView textView2 = (TextView) this.tabsContainer.getChildAt(this.previousPosition);
        if (textView2 == null || textView == null) {
            return;
        }
        setAnimationProgressInernal(textView, textView2, value);
        if (value >= 1.0f) {
            textView2.setTag(this.unactiveTextColorKey);
            textView.setTag(this.activeTextColorKey);
        }
        ScrollSlidingTabStripDelegate scrollSlidingTabStripDelegate = this.delegate;
        if (scrollSlidingTabStripDelegate != null) {
            scrollSlidingTabStripDelegate.onPageScrolled(value);
        }
    }

    public void setUseSameWidth(boolean value) {
        this.useSameWidth = value;
    }

    public Drawable getSelectorDrawable() {
        return this.selectorDrawable;
    }

    public ViewGroup getTabsContainer() {
        return this.tabsContainer;
    }

    @Keep
    public float getAnimationIdicatorProgress() {
        return this.animationIdicatorProgress;
    }

    public int getNextPageId(boolean forward) {
        return this.positionToId.get(this.currentPosition + (forward ? 1 : -1), -1);
    }

    public SparseArray<View> removeTabs() {
        SparseArray<View> sparseArray = new SparseArray<>();
        for (int i = 0; i < getChildCount(); i++) {
            sparseArray.get(this.positionToId.get(i), getChildAt(i));
        }
        this.positionToId.clear();
        this.idToPosition.clear();
        this.positionToWidth.clear();
        this.tabsContainer.removeAllViews();
        this.allTextWidth = 0;
        this.tabCount = 0;
        return sparseArray;
    }

    public int getTabsCount() {
        return this.tabCount;
    }

    public boolean hasTab(int id) {
        return this.idToPosition.get(id, -1) != -1;
    }

    public void addTextTab(final int id, CharSequence text) {
        addTextTab(id, text, null);
    }

    public void addTextTab(final int id, CharSequence text, SparseArray<View> viewsCache) {
        int i = this.tabCount;
        this.tabCount = i + 1;
        if (i == 0 && this.selectedTabId == -1) {
            this.selectedTabId = id;
        }
        this.positionToId.put(i, id);
        this.idToPosition.put(id, i);
        int i2 = this.selectedTabId;
        if (i2 != -1 && i2 == id) {
            this.currentPosition = i;
            this.prevLayoutWidth = 0;
        }
        TextView textView = null;
        if (viewsCache != null) {
            textView = (TextView) viewsCache.get(id);
            viewsCache.delete(id);
        }
        if (textView == null) {
            textView = new TextView(getContext()) { // from class: ir.eitaa.ui.Components.ScrollSlidingTextTabStrip.3
                @Override // android.view.View
                public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
                    super.onInitializeAccessibilityNodeInfo(info);
                    info.setSelected(ScrollSlidingTextTabStrip.this.selectedTabId == id);
                }
            };
            textView.setWillNotDraw(false);
            textView.setGravity(17);
            textView.setBackgroundDrawable(Theme.createSelectorDrawable(Theme.getColor(this.selectorColorKey), 3));
            textView.setTextSize(1, 15.0f);
            textView.setSingleLine(true);
            textView.setTypeface(AndroidUtilities.getFontFamily(true));
            textView.setPadding(AndroidUtilities.dp(16.0f), 0, AndroidUtilities.dp(16.0f), 0);
            textView.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$ScrollSlidingTextTabStrip$AqFg6om8FZmGOYsbb1i0xIbbOFM
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$addTextTab$0$ScrollSlidingTextTabStrip(id, view);
                }
            });
        }
        textView.setText(text);
        int iCeil = ((int) Math.ceil(textView.getPaint().measureText(text, 0, text.length()))) + textView.getPaddingLeft() + textView.getPaddingRight();
        this.tabsContainer.addView(textView, LayoutHelper.createLinear(0, -1));
        this.allTextWidth += iCeil;
        this.positionToWidth.put(i, iCeil);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$addTextTab$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$addTextTab$0$ScrollSlidingTextTabStrip(int i, View view) {
        ScrollSlidingTabStripDelegate scrollSlidingTabStripDelegate;
        int iIndexOfChild = this.tabsContainer.indexOfChild(view);
        if (iIndexOfChild < 0) {
            return;
        }
        int i2 = this.currentPosition;
        if (iIndexOfChild == i2 && (scrollSlidingTabStripDelegate = this.delegate) != null) {
            scrollSlidingTabStripDelegate.onSamePageSelected();
            return;
        }
        boolean z = i2 < iIndexOfChild;
        this.scrollingToChild = -1;
        this.previousPosition = i2;
        this.currentPosition = iIndexOfChild;
        this.selectedTabId = i;
        if (this.animatingIndicator) {
            AndroidUtilities.cancelRunOnUIThread(this.animationRunnable);
            this.animatingIndicator = false;
        }
        this.animationTime = 0.0f;
        this.animatingIndicator = true;
        this.animateIndicatorStartX = this.indicatorX;
        this.animateIndicatorStartWidth = this.indicatorWidth;
        TextView textView = (TextView) view;
        this.animateIndicatorToWidth = getChildWidth(textView);
        this.animateIndicatorToX = textView.getLeft() + ((textView.getMeasuredWidth() - this.animateIndicatorToWidth) / 2);
        setEnabled(false);
        AndroidUtilities.runOnUIThread(this.animationRunnable, 16L);
        ScrollSlidingTabStripDelegate scrollSlidingTabStripDelegate2 = this.delegate;
        if (scrollSlidingTabStripDelegate2 != null) {
            scrollSlidingTabStripDelegate2.onPageSelected(i, z);
        }
        scrollToChild(iIndexOfChild);
    }

    public void finishAddingTabs() {
        int childCount = this.tabsContainer.getChildCount();
        int i = 0;
        while (i < childCount) {
            TextView textView = (TextView) this.tabsContainer.getChildAt(i);
            textView.setTag(this.currentPosition == i ? this.activeTextColorKey : this.unactiveTextColorKey);
            textView.setTextColor(Theme.getColor(this.currentPosition == i ? this.activeTextColorKey : this.unactiveTextColorKey));
            if (i == 0) {
                textView.getLayoutParams().width = childCount == 1 ? -2 : 0;
            }
            i++;
        }
    }

    public void setColors(String line, String active, String unactive, String selector) {
        this.tabLineColorKey = line;
        this.activeTextColorKey = active;
        this.unactiveTextColorKey = unactive;
        this.selectorColorKey = selector;
        this.selectorDrawable.setColor(Theme.getColor(line));
    }

    public int getCurrentTabId() {
        return this.selectedTabId;
    }

    public void setInitialTabId(int id) {
        this.selectedTabId = id;
        int i = this.idToPosition.get(id);
        if (((TextView) this.tabsContainer.getChildAt(i)) != null) {
            this.currentPosition = i;
            this.prevLayoutWidth = 0;
            finishAddingTabs();
            requestLayout();
        }
    }

    public void resetTab() {
        this.selectedTabId = -1;
    }

    public int getFirstTabId() {
        return this.positionToId.get(0, 0);
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View child, long drawingTime) {
        boolean zDrawChild = super.drawChild(canvas, child, drawingTime);
        if (child == this.tabsContainer) {
            int measuredHeight = getMeasuredHeight();
            this.selectorDrawable.setAlpha((int) (this.tabsContainer.getAlpha() * 255.0f));
            float f = this.indicatorX + this.indicatorXAnimationDx;
            this.selectorDrawable.setBounds((int) f, measuredHeight - AndroidUtilities.dpr(4.0f), (int) (this.indicatorWidth + f + this.indicatorWidthAnimationDx), measuredHeight);
            this.selectorDrawable.draw(canvas);
        }
        return zDrawChild;
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int size = View.MeasureSpec.getSize(widthMeasureSpec) - AndroidUtilities.dp(22.0f);
        int childCount = this.tabsContainer.getChildCount();
        for (int i = 0; i < childCount; i++) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.tabsContainer.getChildAt(i).getLayoutParams();
            int i2 = this.allTextWidth;
            if (i2 > size) {
                layoutParams.weight = 0.0f;
                layoutParams.width = -2;
            } else if (this.useSameWidth) {
                layoutParams.weight = 1.0f / childCount;
                layoutParams.width = 0;
            } else if (i == 0 && childCount == 1) {
                layoutParams.weight = 0.0f;
                layoutParams.width = -2;
            } else {
                layoutParams.weight = (1.0f / i2) * this.positionToWidth.get(i);
                layoutParams.width = 0;
            }
        }
        if (childCount == 1 || this.allTextWidth > size) {
            this.tabsContainer.setWeightSum(0.0f);
        } else {
            this.tabsContainer.setWeightSum(1.0f);
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    private void scrollToChild(int position) {
        if (this.tabCount == 0 || this.scrollingToChild == position) {
            return;
        }
        this.scrollingToChild = position;
        TextView textView = (TextView) this.tabsContainer.getChildAt(position);
        if (textView == null) {
            return;
        }
        int scrollX = getScrollX();
        int left = textView.getLeft();
        int measuredWidth = textView.getMeasuredWidth();
        if (left - AndroidUtilities.dp(50.0f) < scrollX) {
            smoothScrollTo(left - AndroidUtilities.dp(50.0f), 0);
            return;
        }
        int i = left + measuredWidth;
        if (AndroidUtilities.dp(21.0f) + i > scrollX + getWidth()) {
            smoothScrollTo(i, 0);
        }
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int i;
        super.onLayout(changed, l, t, r, b);
        int i2 = r - l;
        if (this.prevLayoutWidth != i2) {
            this.prevLayoutWidth = i2;
            this.scrollingToChild = -1;
            if (this.animatingIndicator) {
                AndroidUtilities.cancelRunOnUIThread(this.animationRunnable);
                this.animatingIndicator = false;
                setEnabled(true);
                ScrollSlidingTabStripDelegate scrollSlidingTabStripDelegate = this.delegate;
                if (scrollSlidingTabStripDelegate != null) {
                    scrollSlidingTabStripDelegate.onPageScrolled(1.0f);
                }
            }
            TextView textView = (TextView) this.tabsContainer.getChildAt(this.currentPosition);
            if (textView != null) {
                this.indicatorWidth = getChildWidth(textView);
                int left = textView.getLeft();
                int measuredWidth = textView.getMeasuredWidth();
                int i3 = this.indicatorWidth;
                int i4 = left + ((measuredWidth - i3) / 2);
                this.indicatorX = i4;
                int i5 = this.animateFromIndicaxtorX;
                if (i5 <= 0 || (i = this.animateFromIndicatorWidth) <= 0) {
                    return;
                }
                if (i5 != i4 || i != i3) {
                    final int i6 = i5 - i4;
                    final int i7 = i - i3;
                    ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
                    valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$ScrollSlidingTextTabStrip$X3Q4UJ_-7qzNVsNNsSVs89VPwws
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                            this.f$0.lambda$onLayout$1$ScrollSlidingTextTabStrip(i6, i7, valueAnimator);
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
    /* renamed from: lambda$onLayout$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onLayout$1$ScrollSlidingTextTabStrip(int i, int i2, ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.indicatorXAnimationDx = i * fFloatValue;
        this.indicatorWidthAnimationDx = i2 * fFloatValue;
        this.tabsContainer.invalidate();
        invalidate();
    }

    public int getCurrentPosition() {
        return this.currentPosition;
    }

    @Override // android.view.View
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        int childCount = this.tabsContainer.getChildCount();
        for (int i = 0; i < childCount; i++) {
            this.tabsContainer.getChildAt(i).setEnabled(enabled);
        }
    }

    public void selectTabWithId(int id, float progress) {
        int i = this.idToPosition.get(id, -1);
        if (i < 0) {
            return;
        }
        if (progress < 0.0f) {
            progress = 0.0f;
        } else if (progress > 1.0f) {
            progress = 1.0f;
        }
        TextView textView = (TextView) this.tabsContainer.getChildAt(this.currentPosition);
        TextView textView2 = (TextView) this.tabsContainer.getChildAt(i);
        if (textView != null && textView2 != null) {
            this.animateIndicatorStartWidth = getChildWidth(textView);
            this.animateIndicatorStartX = textView.getLeft() + ((textView.getMeasuredWidth() - this.animateIndicatorStartWidth) / 2);
            this.animateIndicatorToWidth = getChildWidth(textView2);
            this.animateIndicatorToX = textView2.getLeft() + ((textView2.getMeasuredWidth() - this.animateIndicatorToWidth) / 2);
            setAnimationProgressInernal(textView2, textView, progress);
            if (progress >= 1.0f) {
                textView.setTag(this.unactiveTextColorKey);
                textView2.setTag(this.activeTextColorKey);
            }
            scrollToChild(this.tabsContainer.indexOfChild(textView2));
        }
        if (progress >= 1.0f) {
            this.currentPosition = i;
            this.selectedTabId = id;
        }
    }

    private int getChildWidth(TextView child) {
        if (child.getLayout() != null) {
            return ((int) Math.ceil(r0.getLineWidth(0))) + AndroidUtilities.dp(2.0f);
        }
        return child.getMeasuredWidth();
    }

    public void recordIndicatorParams() {
        this.animateFromIndicaxtorX = this.indicatorX;
        this.animateFromIndicatorWidth = this.indicatorWidth;
    }
}
