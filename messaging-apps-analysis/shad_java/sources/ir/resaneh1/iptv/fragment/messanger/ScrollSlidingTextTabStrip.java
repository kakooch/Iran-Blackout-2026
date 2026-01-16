package ir.resaneh1.iptv.fragment.messanger;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Build;
import android.os.SystemClock;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Keep;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Components.CubicBezierInterpolator;
import org.rbmain.ui.Components.LayoutHelper;

/* loaded from: classes3.dex */
public class ScrollSlidingTextTabStrip extends HorizontalScrollView {
    private int allTextWidth;
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
    private SparseIntArray positionToWidth;
    private int prevLayoutWidth;
    private int previousPosition;
    private Paint rectPaint;
    private int selectedTabId;
    private int tabCount;
    private LinearLayout tabsContainer;

    public interface ScrollSlidingTabStripDelegate {
        void onPageScrolled(float f);

        void onPageSelected(int i, boolean z);
    }

    static /* synthetic */ float access$216(ScrollSlidingTextTabStrip scrollSlidingTextTabStrip, float f) {
        float f2 = scrollSlidingTextTabStrip.animationTime + f;
        scrollSlidingTextTabStrip.animationTime = f2;
        return f2;
    }

    public ScrollSlidingTextTabStrip(Context context) {
        super(context);
        this.selectedTabId = -1;
        this.interpolator = CubicBezierInterpolator.EASE_OUT_QUINT;
        this.positionToId = new SparseIntArray(5);
        this.idToPosition = new SparseIntArray(5);
        this.positionToWidth = new SparseIntArray(5);
        this.animationRunnable = new Runnable() { // from class: ir.resaneh1.iptv.fragment.messanger.ScrollSlidingTextTabStrip.1
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
        setFillViewport(true);
        setWillNotDraw(false);
        setHorizontalScrollBarEnabled(false);
        LinearLayout linearLayout = new LinearLayout(context);
        this.tabsContainer = linearLayout;
        linearLayout.setOrientation(0);
        if (Build.VERSION.SDK_INT >= 17) {
            this.tabsContainer.setLayoutDirection(0);
        }
        this.tabsContainer.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.tabsContainer);
        Paint paint = new Paint();
        this.rectPaint = paint;
        paint.setAntiAlias(true);
        this.rectPaint.setStyle(Paint.Style.FILL);
        this.rectPaint.setColor(Theme.getColor(Theme.key_actionBarDefaultTitle));
    }

    public void setDelegate(ScrollSlidingTabStripDelegate scrollSlidingTabStripDelegate) {
        this.delegate = scrollSlidingTabStripDelegate;
    }

    public boolean isAnimatingIndicator() {
        return this.animatingIndicator;
    }

    private void setAnimationProgressInernal(TextView textView, TextView textView2, float f) {
        int color = Theme.getColor(Theme.key_actionBarDefaultTitle);
        int color2 = Theme.getColor(Theme.key_actionBarDefaultSubtitle);
        int iRed = Color.red(color);
        int iGreen = Color.green(color);
        int iBlue = Color.blue(color);
        int iAlpha = Color.alpha(color);
        int iRed2 = Color.red(color2);
        int iGreen2 = Color.green(color2);
        int iBlue2 = Color.blue(color2);
        int iAlpha2 = Color.alpha(color2);
        textView2.setTextColor(Color.argb((int) (iAlpha + ((iAlpha2 - iAlpha) * f)), (int) (iRed + ((iRed2 - iRed) * f)), (int) (iGreen + ((iGreen2 - iGreen) * f)), (int) (iBlue + ((iBlue2 - iBlue) * f))));
        textView.setTextColor(Color.argb((int) (iAlpha2 + ((iAlpha - iAlpha2) * f)), (int) (iRed2 + ((iRed - iRed2) * f)), (int) (iGreen2 + ((iGreen - iGreen2) * f)), (int) (iBlue2 + ((iBlue - iBlue2) * f))));
        this.indicatorX = (int) (this.animateIndicatorStartX + ((this.animateIndicatorToX - r1) * f));
        this.indicatorWidth = (int) (this.animateIndicatorStartWidth + ((this.animateIndicatorToWidth - r1) * f));
        invalidate();
    }

    @Keep
    public void setAnimationIdicatorProgress(float f) {
        this.animationIdicatorProgress = f;
        setAnimationProgressInernal((TextView) this.tabsContainer.getChildAt(this.currentPosition), (TextView) this.tabsContainer.getChildAt(this.previousPosition), f);
        ScrollSlidingTabStripDelegate scrollSlidingTabStripDelegate = this.delegate;
        if (scrollSlidingTabStripDelegate != null) {
            scrollSlidingTabStripDelegate.onPageScrolled(f);
        }
    }

    public Paint getRectPaint() {
        return this.rectPaint;
    }

    public View getTabsContainer() {
        return this.tabsContainer;
    }

    public float getAnimationIdicatorProgress() {
        return this.animationIdicatorProgress;
    }

    public int getNextPageId(boolean z) {
        return this.positionToId.get(this.currentPosition + (z ? 1 : -1), -1);
    }

    public void removeTabs() {
        this.positionToId.clear();
        this.idToPosition.clear();
        this.positionToWidth.clear();
        this.tabsContainer.removeAllViews();
        this.allTextWidth = 0;
        this.tabCount = 0;
    }

    public int getTabsCount() {
        return this.tabCount;
    }

    public boolean hasTab(int i) {
        return this.idToPosition.get(i, -1) != -1;
    }

    public void addTextTab(final int i, CharSequence charSequence, int i2, Typeface typeface) {
        int i3 = this.tabCount;
        this.tabCount = i3 + 1;
        if (i3 == 0 && this.selectedTabId == -1) {
            this.selectedTabId = i;
        }
        this.positionToId.put(i3, i);
        this.idToPosition.put(i, i3);
        int i4 = this.selectedTabId;
        if (i4 != -1 && i4 == i) {
            this.currentPosition = i3;
            this.prevLayoutWidth = 0;
        }
        TextView textView = new TextView(getContext());
        textView.setGravity(17);
        textView.setText(charSequence);
        textView.setBackgroundDrawable(Theme.createSelectorDrawable(Theme.getColor(Theme.key_actionBarDefaultSelector), 2));
        textView.setTag(Integer.valueOf(this.selectedTabId == i ? Theme.key_actionBarDefaultTitle : Theme.key_actionBarDefaultSubtitle));
        textView.setTextColor(Theme.getColor(this.currentPosition == i3 ? Theme.key_actionBarDefaultTitle : Theme.key_actionBarDefaultSubtitle));
        textView.setTextSize(1, i2);
        textView.setSingleLine(true);
        textView.setTypeface(typeface);
        textView.setPadding(AndroidUtilities.dp(8.0f), 0, AndroidUtilities.dp(8.0f), 0);
        textView.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.messanger.ScrollSlidingTextTabStrip$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$addTextTab$0(i, view);
            }
        });
        int iCeil = ((int) Math.ceil(textView.getPaint().measureText(charSequence, 0, charSequence.length()))) + AndroidUtilities.dp(16.0f);
        this.allTextWidth += iCeil;
        this.positionToWidth.put(i3, iCeil);
        this.tabsContainer.addView(textView, LayoutHelper.createLinear(0, -1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addTextTab$0(int i, View view) {
        int i2;
        int iIndexOfChild = this.tabsContainer.indexOfChild(view);
        if (iIndexOfChild < 0 || iIndexOfChild == (i2 = this.currentPosition)) {
            return;
        }
        boolean z = i2 < iIndexOfChild;
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
        this.animateIndicatorToX = view.getLeft();
        this.animateIndicatorToWidth = view.getMeasuredWidth();
        setEnabled(false);
        AndroidUtilities.runOnUIThread(this.animationRunnable, 16L);
        ScrollSlidingTabStripDelegate scrollSlidingTabStripDelegate = this.delegate;
        if (scrollSlidingTabStripDelegate != null) {
            scrollSlidingTabStripDelegate.onPageSelected(i, z);
        }
        scrollToChild(iIndexOfChild);
    }

    public int getCurrentTabId() {
        return this.selectedTabId;
    }

    public int getFirstTabId() {
        return this.positionToId.get(0, 0);
    }

    public int getLastTabId() {
        if (this.positionToId.size() > 0) {
            return this.positionToId.get(r0.size() - 1, 0);
        }
        return this.positionToId.get(0, 0);
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j) {
        boolean zDrawChild = super.drawChild(canvas, view, j);
        if (view == this.tabsContainer) {
            canvas.drawRect(this.indicatorX, r8 - AndroidUtilities.dp(1.0f), this.indicatorX + this.indicatorWidth, getMeasuredHeight(), this.rectPaint);
        }
        return zDrawChild;
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        int childCount = this.tabsContainer.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.tabsContainer.getChildAt(i3).getLayoutParams();
            int i4 = this.allTextWidth;
            if (i4 > size) {
                layoutParams.weight = 0.0f;
                layoutParams.width = -2;
            } else {
                layoutParams.weight = (1.0f / i4) * this.positionToWidth.get(i3);
                layoutParams.width = 0;
            }
        }
        if (this.allTextWidth > size) {
            this.tabsContainer.setWeightSum(0.0f);
        } else {
            this.tabsContainer.setWeightSum(1.0f);
        }
        super.onMeasure(i, i2);
    }

    private void scrollToChild(int i) {
        View childAt;
        if (this.tabCount == 0 || (childAt = this.tabsContainer.getChildAt(i)) == null) {
            return;
        }
        int scrollX = getScrollX();
        int left = childAt.getLeft();
        int measuredWidth = childAt.getMeasuredWidth();
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
            if (this.animatingIndicator) {
                AndroidUtilities.cancelRunOnUIThread(this.animationRunnable);
                this.animatingIndicator = false;
                setEnabled(true);
                ScrollSlidingTabStripDelegate scrollSlidingTabStripDelegate = this.delegate;
                if (scrollSlidingTabStripDelegate != null) {
                    scrollSlidingTabStripDelegate.onPageScrolled(1.0f);
                }
            }
            View childAt = this.tabsContainer.getChildAt(this.currentPosition);
            if (childAt != null) {
                this.indicatorX = childAt.getLeft();
                this.indicatorWidth = childAt.getMeasuredWidth();
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
            this.animateIndicatorStartX = textView.getLeft();
            this.animateIndicatorStartWidth = textView.getMeasuredWidth();
            this.animateIndicatorToX = textView2.getLeft();
            this.animateIndicatorToWidth = textView2.getMeasuredWidth();
            setAnimationProgressInernal(textView2, textView, f);
        }
        if (f >= 1.0f) {
            this.currentPosition = i2;
            this.selectedTabId = i;
        }
    }
}
