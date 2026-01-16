package ir.resaneh1.iptv.fragment.rubino;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.SystemClock;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Keep;
import ir.appp.common.utils.LayoutHelper;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Components.CubicBezierInterpolator;

/* loaded from: classes3.dex */
public class HighlightScrollSlidingTextTabStrip extends HorizontalScrollView {
    private String activeTabTag;
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
    private int indicatorX;
    private CubicBezierInterpolator interpolator;
    private long lastAnimationTime;
    private SparseIntArray positionToId;
    private int prevLayoutWidth;
    private int previousPosition;
    private int scrollingToChild;
    private int selectedTabId;
    private GradientDrawable selectorDrawable;
    private int tabCount;
    private LinearLayout tabsContainer;
    private String unactiveTabTag;

    public interface ScrollSlidingTabStripDelegate {
        void onPageScrolled(float f);

        void onPageSelected(int i, boolean z);

        void onSamePageSelected();
    }

    static /* synthetic */ float access$216(HighlightScrollSlidingTextTabStrip highlightScrollSlidingTextTabStrip, float f) {
        float f2 = highlightScrollSlidingTextTabStrip.animationTime + f;
        highlightScrollSlidingTextTabStrip.animationTime = f2;
        return f2;
    }

    public HighlightScrollSlidingTextTabStrip(Context context) {
        super(context);
        this.selectedTabId = -1;
        this.scrollingToChild = -1;
        this.activeTabTag = "selectedTabTag";
        this.unactiveTabTag = "unselectedTabTag";
        this.interpolator = CubicBezierInterpolator.EASE_OUT_QUINT;
        this.positionToId = new SparseIntArray(5);
        this.idToPosition = new SparseIntArray(5);
        this.animationRunnable = new Runnable() { // from class: ir.resaneh1.iptv.fragment.rubino.HighlightScrollSlidingTextTabStrip.1
            @Override // java.lang.Runnable
            public void run() {
                if (HighlightScrollSlidingTextTabStrip.this.animatingIndicator) {
                    long jElapsedRealtime = SystemClock.elapsedRealtime() - HighlightScrollSlidingTextTabStrip.this.lastAnimationTime;
                    if (jElapsedRealtime > 17) {
                        jElapsedRealtime = 17;
                    }
                    HighlightScrollSlidingTextTabStrip.access$216(HighlightScrollSlidingTextTabStrip.this, jElapsedRealtime / 200.0f);
                    HighlightScrollSlidingTextTabStrip highlightScrollSlidingTextTabStrip = HighlightScrollSlidingTextTabStrip.this;
                    highlightScrollSlidingTextTabStrip.setAnimationIdicatorProgress(highlightScrollSlidingTextTabStrip.interpolator.getInterpolation(HighlightScrollSlidingTextTabStrip.this.animationTime));
                    if (HighlightScrollSlidingTextTabStrip.this.animationTime > 1.0f) {
                        HighlightScrollSlidingTextTabStrip.this.animationTime = 1.0f;
                    }
                    if (HighlightScrollSlidingTextTabStrip.this.animationTime < 1.0f) {
                        AndroidUtilities.runOnUIThread(HighlightScrollSlidingTextTabStrip.this.animationRunnable);
                        return;
                    }
                    HighlightScrollSlidingTextTabStrip.this.animatingIndicator = false;
                    HighlightScrollSlidingTextTabStrip.this.setEnabled(true);
                    if (HighlightScrollSlidingTextTabStrip.this.delegate != null) {
                        HighlightScrollSlidingTextTabStrip.this.delegate.onPageScrolled(1.0f);
                    }
                }
            }
        };
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, null);
        this.selectorDrawable = gradientDrawable;
        gradientDrawable.setColor(Theme.getColor(Theme.key_rubinoBlackColor));
        if (Build.VERSION.SDK_INT >= 17) {
            setLayoutDirection(0);
        }
        setFillViewport(true);
        setWillNotDraw(false);
        setHorizontalScrollBarEnabled(false);
        LinearLayout linearLayout = new LinearLayout(context) { // from class: ir.resaneh1.iptv.fragment.rubino.HighlightScrollSlidingTextTabStrip.2
            @Override // android.view.View
            public void setAlpha(float f) {
                super.setAlpha(f);
                HighlightScrollSlidingTextTabStrip.this.invalidate();
            }
        };
        this.tabsContainer = linearLayout;
        linearLayout.setOrientation(0);
        this.tabsContainer.setPadding(0, 0, 0, 0);
        this.tabsContainer.setBackgroundColor(Theme.getColor(Theme.key_actionBarDefault));
        this.tabsContainer.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.tabsContainer);
    }

    public void setDelegate(ScrollSlidingTabStripDelegate scrollSlidingTabStripDelegate) {
        this.delegate = scrollSlidingTabStripDelegate;
    }

    public boolean isAnimatingIndicator() {
        return this.animatingIndicator;
    }

    private void setAnimationProgressInernal(TextView textView, TextView textView2, float f) {
        if (textView == null || textView2 == null) {
            return;
        }
        int color = Theme.getColor(Theme.key_rubinoBlackColor);
        int color2 = Theme.getColor(Theme.key_rubinoGrayColor);
        int iRed = Color.red(color);
        int iGreen = Color.green(color);
        int iBlue = Color.blue(color);
        int iAlpha = Color.alpha(color);
        int iRed2 = Color.red(color2);
        int iGreen2 = Color.green(color2);
        int iBlue2 = Color.blue(color2);
        int iAlpha2 = Color.alpha(color2);
        int iArgb = Color.argb((int) (iAlpha + ((iAlpha2 - iAlpha) * f)), (int) (iRed + ((iRed2 - iRed) * f)), (int) (iGreen + ((iGreen2 - iGreen) * f)), (int) (iBlue + ((iBlue2 - iBlue) * f)));
        int iArgb2 = Color.argb((int) (iAlpha2 + ((iAlpha - iAlpha2) * f)), (int) (iRed2 + ((iRed - iRed2) * f)), (int) (iGreen2 + ((iGreen - iGreen2) * f)), (int) (iBlue2 + ((iBlue - iBlue2) * f)));
        textView2.setTextColor(iArgb);
        textView.setTextColor(iArgb2);
        this.indicatorX = (int) (this.animateIndicatorStartX + ((this.animateIndicatorToX - r1) * f));
        this.indicatorWidth = (int) (this.animateIndicatorStartWidth + ((this.animateIndicatorToWidth - r1) * f));
        invalidate();
    }

    @Keep
    public void setAnimationIdicatorProgress(float f) {
        this.animationIdicatorProgress = f;
        TextView textView = (TextView) this.tabsContainer.getChildAt(this.currentPosition);
        TextView textView2 = (TextView) this.tabsContainer.getChildAt(this.previousPosition);
        if (textView2 == null || textView == null) {
            return;
        }
        setAnimationProgressInernal(textView, textView2, f);
        if (f >= 1.0f) {
            textView2.setTag(this.unactiveTabTag);
            textView.setTag(this.activeTabTag);
        }
        ScrollSlidingTabStripDelegate scrollSlidingTabStripDelegate = this.delegate;
        if (scrollSlidingTabStripDelegate != null) {
            scrollSlidingTabStripDelegate.onPageScrolled(f);
        }
    }

    public Drawable getSelectorDrawable() {
        return this.selectorDrawable;
    }

    public View getTabsContainer() {
        return this.tabsContainer;
    }

    @Keep
    public float getAnimationIdicatorProgress() {
        return this.animationIdicatorProgress;
    }

    public int getNextPageId(boolean z) {
        return this.positionToId.get(this.currentPosition + (z ? 1 : -1), -1);
    }

    public void removeTabs() {
        this.positionToId.clear();
        this.idToPosition.clear();
        this.tabsContainer.removeAllViews();
        this.tabCount = 0;
    }

    public int getTabsCount() {
        return this.tabCount;
    }

    public boolean hasTab(int i) {
        return this.idToPosition.get(i, -1) != -1;
    }

    public void addTab(final int i, String str) {
        int i2 = this.tabCount;
        this.tabCount = i2 + 1;
        if (i2 == 0 && this.selectedTabId == -1) {
            this.selectedTabId = i;
        }
        this.positionToId.put(i2, i);
        this.idToPosition.put(i, i2);
        int i3 = this.selectedTabId;
        if (i3 != -1 && i3 == i) {
            this.currentPosition = i2;
            this.prevLayoutWidth = 0;
        }
        TextView textView = new TextView(getContext());
        textView.setWillNotDraw(false);
        textView.setText(str);
        textView.setTypeface(Theme.getRubinoTypeFaceRegular());
        textView.setGravity(17);
        textView.setBackgroundDrawable(Theme.createSelectorDrawable(Theme.getColor(Theme.key_actionBarDefault), 3));
        textView.setPadding(AndroidUtilities.dp(16.0f), 0, AndroidUtilities.dp(16.0f), 0);
        textView.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.HighlightScrollSlidingTextTabStrip$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$addTab$0(i, view);
            }
        });
        this.tabsContainer.addView(textView, LayoutHelper.createLinear(0, -1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addTab$0(int i, View view) {
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
            textView.setTag(this.currentPosition == i ? this.activeTabTag : this.unactiveTabTag);
            int color = Theme.getColor(this.currentPosition == i ? Theme.key_rubinoBlackColor : Theme.key_rubinoGrayColor);
            int iDp = AndroidUtilities.dp(12.0f);
            textView.setPadding(iDp, iDp, iDp, iDp);
            textView.setTextColor(color);
            if (i == 0) {
                textView.getLayoutParams().width = childCount == 1 ? -2 : 0;
            }
            i++;
        }
    }

    public int getCurrentTabId() {
        return this.selectedTabId;
    }

    public void setInitialTabId(int i) {
        this.selectedTabId = i;
        int i2 = this.idToPosition.get(i);
        if (((TextView) this.tabsContainer.getChildAt(i2)) != null) {
            this.currentPosition = i2;
            this.prevLayoutWidth = 0;
            finishAddingTabs();
            requestLayout();
        }
    }

    public int getFirstTabId() {
        return this.positionToId.get(0, 0);
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j) {
        boolean zDrawChild = super.drawChild(canvas, view, j);
        if (view == this.tabsContainer) {
            int measuredHeight = getMeasuredHeight();
            this.selectorDrawable.setAlpha((int) (this.tabsContainer.getAlpha() * 255.0f));
            this.selectorDrawable.setBounds(this.indicatorX, measuredHeight - AndroidUtilities.dp(1.0f), this.indicatorX + this.indicatorWidth, measuredHeight);
            this.selectorDrawable.draw(canvas);
        }
        return zDrawChild;
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        View.MeasureSpec.getSize(i);
        AndroidUtilities.dp(22.0f);
        int childCount = this.tabsContainer.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.tabsContainer.getChildAt(i3).getLayoutParams();
            layoutParams.weight = 1.0f / childCount;
            layoutParams.width = 0;
        }
        this.tabsContainer.setWeightSum(1.0f);
        super.onMeasure(i, i2);
    }

    private void scrollToChild(int i) {
        if (this.tabCount == 0 || this.scrollingToChild == i) {
            return;
        }
        this.scrollingToChild = i;
        TextView textView = (TextView) this.tabsContainer.getChildAt(i);
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
        super.onLayout(z, i, i2, i3, i4);
        int i5 = i3 - i;
        if (this.prevLayoutWidth != i5) {
            this.prevLayoutWidth = i5;
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
                this.indicatorX = textView.getLeft() + ((textView.getMeasuredWidth() - this.indicatorWidth) / 2);
            }
        }
    }

    public int getCurrentPosition() {
        return this.currentPosition;
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        int childCount = this.tabsContainer.getChildCount();
        for (int i = 0; i < childCount; i++) {
            this.tabsContainer.getChildAt(i).setEnabled(z);
        }
    }

    public void selectTabWithId(int i, float f) {
        int i2 = this.idToPosition.get(i, -1);
        if (i2 < 0) {
            return;
        }
        if (f < 0.0f) {
            f = 0.0f;
        } else if (f > 1.0f) {
            f = 1.0f;
        }
        TextView textView = (TextView) this.tabsContainer.getChildAt(this.currentPosition);
        TextView textView2 = (TextView) this.tabsContainer.getChildAt(i2);
        if (textView != null && textView2 != null) {
            this.animateIndicatorStartWidth = getChildWidth(textView);
            this.animateIndicatorStartX = textView.getLeft() + ((textView.getMeasuredWidth() - this.animateIndicatorStartWidth) / 2);
            this.animateIndicatorToWidth = getChildWidth(textView2);
            this.animateIndicatorToX = textView2.getLeft() + ((textView2.getMeasuredWidth() - this.animateIndicatorToWidth) / 2);
            setAnimationProgressInernal(textView2, textView, f);
            if (f >= 1.0f) {
                textView.setTag(this.unactiveTabTag);
                textView2.setTag(this.activeTabTag);
            }
            scrollToChild(this.tabsContainer.indexOfChild(textView2));
        }
        if (f >= 1.0f) {
            this.currentPosition = i2;
            this.selectedTabId = i;
        }
    }

    private int getChildWidth(TextView textView) {
        return textView.getMeasuredWidth();
    }
}
