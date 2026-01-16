package ir.appp.rghapp.rubinoPostSlider;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.SystemClock;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Keep;
import ir.appp.rghapp.rubinoPostSlider.RGHAddPostActivity;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Components.CubicBezierInterpolator;
import org.rbmain.ui.Components.LayoutHelper;

/* loaded from: classes3.dex */
public class AddPostBottomTab extends HorizontalScrollView {
    private int activeTextColorKey;
    private int animateIndicatorStartWidth;
    private int animateIndicatorStartX;
    private int animateIndicatorToWidth;
    private int animateIndicatorToX;
    private boolean animatingIndicator;
    private float animationIdicatorProgress;
    private Runnable animationRunnable;
    private float animationTime;
    private int currentPosition;
    private AddPostBottomTabDelegate delegate;
    private SparseIntArray idToPosition;
    private int indicatorWidth;
    private int indicatorX;
    private CubicBezierInterpolator interpolator;
    private long lastAnimationTime;
    private SparseIntArray positionToId;
    private SparseIntArray positionToWidth;
    private int prevLayoutWidth;
    private int previousPosition;
    private boolean resettingTabIndicatorToCurrentIndex;
    private int scrollingToChild;
    private int selectedTabId;
    private int selectorColorKey;
    private GradientDrawable selectorDrawable;
    private int tabCount;
    private int tabLineColorKey;
    private float tabScrollProgress;
    private LinearLayout tabsContainer;
    private int unactiveTextColorKey;

    public interface AddPostBottomTabDelegate {

        /* renamed from: ir.appp.rghapp.rubinoPostSlider.AddPostBottomTab$AddPostBottomTabDelegate$-CC, reason: invalid class name */
        public final /* synthetic */ class CC {
            public static void $default$onSamePageSelected(AddPostBottomTabDelegate addPostBottomTabDelegate) {
            }
        }

        void onPageScrolled(float f);

        void onPageSelected(int i, boolean z);

        void onSamePageSelected();
    }

    public void setUseSameWidth(boolean z) {
    }

    static /* synthetic */ float access$216(AddPostBottomTab addPostBottomTab, float f) {
        float f2 = addPostBottomTab.animationTime + f;
        addPostBottomTab.animationTime = f2;
        return f2;
    }

    public AddPostBottomTab(Context context) {
        super(context);
        this.selectedTabId = -1;
        this.scrollingToChild = -1;
        this.tabLineColorKey = Theme.key_rubino_add_post_TabLine;
        this.activeTextColorKey = Theme.key_rubino_add_post_TabActiveText;
        this.unactiveTextColorKey = Theme.key_rubino_add_post_TabUnactiveText;
        this.selectorColorKey = Theme.key_rubino_add_post_TabSelector;
        this.interpolator = CubicBezierInterpolator.EASE_OUT_QUINT;
        this.positionToId = new SparseIntArray(3);
        this.idToPosition = new SparseIntArray(3);
        this.positionToWidth = new SparseIntArray(3);
        this.animationRunnable = new Runnable() { // from class: ir.appp.rghapp.rubinoPostSlider.AddPostBottomTab.1
            @Override // java.lang.Runnable
            public void run() {
                if (AddPostBottomTab.this.animatingIndicator) {
                    long jElapsedRealtime = SystemClock.elapsedRealtime() - AddPostBottomTab.this.lastAnimationTime;
                    if (jElapsedRealtime > 17) {
                        jElapsedRealtime = 17;
                    }
                    AddPostBottomTab.access$216(AddPostBottomTab.this, jElapsedRealtime / 200.0f);
                    AddPostBottomTab addPostBottomTab = AddPostBottomTab.this;
                    addPostBottomTab.setAnimationIdicatorProgress(addPostBottomTab.interpolator.getInterpolation(AddPostBottomTab.this.animationTime));
                    if (AddPostBottomTab.this.animationTime > 1.0f) {
                        AddPostBottomTab.this.animationTime = 1.0f;
                    }
                    if (AddPostBottomTab.this.animationTime < 1.0f) {
                        AndroidUtilities.runOnUIThread(AddPostBottomTab.this.animationRunnable);
                        return;
                    }
                    AddPostBottomTab.this.animatingIndicator = false;
                    AddPostBottomTab.this.setEnabled(true);
                    if (AddPostBottomTab.this.delegate != null && !AddPostBottomTab.this.resettingTabIndicatorToCurrentIndex) {
                        AddPostBottomTab.this.delegate.onPageScrolled(1.0f);
                    }
                    if (AddPostBottomTab.this.resettingTabIndicatorToCurrentIndex) {
                        AddPostBottomTab.this.tabScrollProgress = 0.0f;
                        AddPostBottomTab.this.resettingTabIndicatorToCurrentIndex = false;
                    }
                }
            }
        };
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, null);
        this.selectorDrawable = gradientDrawable;
        gradientDrawable.setColor(Theme.getColor(this.tabLineColorKey));
        setFillViewport(true);
        setWillNotDraw(false);
        setHorizontalScrollBarEnabled(false);
        LinearLayout linearLayout = new LinearLayout(context) { // from class: ir.appp.rghapp.rubinoPostSlider.AddPostBottomTab.2
            @Override // android.view.View
            public void setAlpha(float f) {
                super.setAlpha(f);
                AddPostBottomTab.this.invalidate();
            }
        };
        this.tabsContainer = linearLayout;
        linearLayout.setOrientation(0);
        this.tabsContainer.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.tabsContainer);
    }

    public void setDelegate(AddPostBottomTabDelegate addPostBottomTabDelegate) {
        this.delegate = addPostBottomTabDelegate;
    }

    public boolean isAnimatingIndicator() {
        return this.animatingIndicator;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0077  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void setAnimationProgressInernal(android.widget.TextView r17, android.widget.TextView r18, float r19) {
        /*
            Method dump skipped, instructions count: 186
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.appp.rghapp.rubinoPostSlider.AddPostBottomTab.setAnimationProgressInernal(android.widget.TextView, android.widget.TextView, float):void");
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
            if (!this.resettingTabIndicatorToCurrentIndex) {
                textView2.setTag(Integer.valueOf(this.unactiveTextColorKey));
            }
            textView.setTag(Integer.valueOf(this.activeTextColorKey));
        }
        AddPostBottomTabDelegate addPostBottomTabDelegate = this.delegate;
        if (addPostBottomTabDelegate == null || this.resettingTabIndicatorToCurrentIndex) {
            return;
        }
        addPostBottomTabDelegate.onPageScrolled(f);
    }

    public Drawable getSelectorDrawable() {
        return this.selectorDrawable;
    }

    public View getTabsContainer() {
        return this.tabsContainer;
    }

    public void selectTabWithAnimation(int i) {
        LinearLayout linearLayout = this.tabsContainer;
        if (linearLayout == null || linearLayout.getChildCount() == 0) {
            return;
        }
        ((TextView) this.tabsContainer.getChildAt(i)).performClick();
    }

    public void resetTabIndicatorToCurrentPage(int i, float f) {
        if (this.animatingIndicator) {
            AndroidUtilities.cancelRunOnUIThread(this.animationRunnable);
            this.animatingIndicator = false;
        }
        ((TextView) this.tabsContainer.getChildAt(i)).setTextColor(Theme.getColor(this.unactiveTextColorKey));
        this.tabScrollProgress = f;
        this.animationTime = 0.0f;
        this.animatingIndicator = true;
        this.resettingTabIndicatorToCurrentIndex = true;
        this.animateIndicatorStartX = this.indicatorX;
        this.animateIndicatorStartWidth = this.indicatorWidth;
        TextView textView = (TextView) this.tabsContainer.getChildAt(this.currentPosition);
        this.animateIndicatorToWidth = getChildWidth(textView);
        this.animateIndicatorToX = textView.getLeft() + ((textView.getMeasuredWidth() - this.animateIndicatorToWidth) / 2);
        setEnabled(false);
        AndroidUtilities.runOnUIThread(this.animationRunnable, 16L);
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
        this.positionToWidth.clear();
        this.tabsContainer.removeAllViews();
        this.tabCount = 0;
    }

    public int getTabsCount() {
        return this.tabCount;
    }

    public boolean hasTab(int i) {
        return this.idToPosition.get(i, -1) != -1;
    }

    public void addTextTab(final int i, CharSequence charSequence) {
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
        textView.setGravity(17);
        textView.setText(charSequence);
        textView.setBackgroundDrawable(Theme.createSelectorDrawable(Theme.getColor(this.selectorColorKey), 3));
        textView.setTextSize(1, 15.0f);
        textView.setSingleLine(true);
        textView.setTypeface(Theme.getRubinoTypeFaceMedium());
        textView.setPadding(AndroidUtilities.dp(16.0f), 0, AndroidUtilities.dp(16.0f), 0);
        textView.setOnClickListener(new View.OnClickListener() { // from class: ir.appp.rghapp.rubinoPostSlider.AddPostBottomTab$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$addTextTab$0(i, view);
            }
        });
        this.tabsContainer.addView(textView, LayoutHelper.createLinear(0, -1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addTextTab$0(int i, View view) {
        int i2;
        AddPostBottomTabDelegate addPostBottomTabDelegate;
        int iIndexOfChild = this.tabsContainer.indexOfChild(view);
        if (iIndexOfChild < 0) {
            return;
        }
        int i3 = this.currentPosition;
        if (iIndexOfChild == i3 && (addPostBottomTabDelegate = this.delegate) != null) {
            addPostBottomTabDelegate.onSamePageSelected();
            return;
        }
        boolean z = true;
        boolean z2 = i3 < iIndexOfChild;
        this.scrollingToChild = -1;
        this.previousPosition = i3;
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
        AddPostBottomTabDelegate addPostBottomTabDelegate2 = this.delegate;
        if (addPostBottomTabDelegate2 != null) {
            addPostBottomTabDelegate2.onPageSelected(i, z2);
        }
        if (this.currentPosition == RGHAddPostActivity.AddPostPages.ADD_POST_GALLERY_PAGE_INDEX || (((i2 = this.previousPosition) != RGHAddPostActivity.AddPostPages.ADD_POST_PHOTO_PAGE_INDEX || !z2) && (i2 != RGHAddPostActivity.AddPostPages.ADD_POST_VIDEO_PAGE_INDEX || z2))) {
            z = false;
        }
        if (z) {
            return;
        }
        scrollToChild(iIndexOfChild);
    }

    public void finishAddingTabs() {
        int childCount = this.tabsContainer.getChildCount();
        int i = 0;
        while (i < childCount) {
            TextView textView = (TextView) this.tabsContainer.getChildAt(i);
            textView.setTag(Integer.valueOf(this.currentPosition == i ? this.activeTextColorKey : this.unactiveTextColorKey));
            textView.setTextColor(Theme.getColor(this.currentPosition == i ? this.activeTextColorKey : this.unactiveTextColorKey));
            if (i == 0) {
                textView.getLayoutParams().width = childCount == 1 ? -2 : 0;
            }
            i++;
        }
    }

    public void setColors(int i, int i2, int i3, int i4) {
        this.tabLineColorKey = i;
        this.activeTextColorKey = i2;
        this.unactiveTextColorKey = i3;
        this.selectorColorKey = i4;
        this.selectorDrawable.setColor(Theme.getColor(i));
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
                AddPostBottomTabDelegate addPostBottomTabDelegate = this.delegate;
                if (addPostBottomTabDelegate != null) {
                    addPostBottomTabDelegate.onPageScrolled(1.0f);
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
                textView.setTag(Integer.valueOf(this.unactiveTextColorKey));
                textView2.setTag(Integer.valueOf(this.activeTextColorKey));
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
