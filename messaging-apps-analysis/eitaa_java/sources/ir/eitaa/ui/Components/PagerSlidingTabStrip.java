package ir.eitaa.ui.Components;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.viewpager.widget.ViewPager;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.ui.ActionBar.Theme;

/* loaded from: classes3.dex */
public class PagerSlidingTabStrip extends HorizontalScrollView {
    private int currentPosition;
    private float currentPositionOffset;
    private LinearLayout.LayoutParams defaultTabLayoutParams;
    public ViewPager.OnPageChangeListener delegatePageListener;
    private int dividerPadding;
    private int indicatorColor;
    private int indicatorHeight;
    private int lastScrollX;
    private final PageListener pageListener;
    private ViewPager pager;
    private Paint rectPaint;
    private int scrollOffset;
    private boolean shouldExpand;
    private int tabCount;
    private int tabPadding;
    private LinearLayout tabsContainer;
    private int underlineColor;
    private int underlineHeight;

    public interface IconTabProvider {
        boolean canScrollToTab(int position);

        void customOnDraw(Canvas canvas, int position);

        Drawable getPageIconDrawable(int position);
    }

    public PagerSlidingTabStrip(Context context) {
        super(context);
        this.pageListener = new PageListener();
        this.currentPosition = 0;
        this.currentPositionOffset = 0.0f;
        this.indicatorColor = -10066330;
        this.underlineColor = 436207616;
        this.shouldExpand = false;
        this.scrollOffset = AndroidUtilities.dp(52.0f);
        this.indicatorHeight = AndroidUtilities.dp(8.0f);
        this.underlineHeight = AndroidUtilities.dp(2.0f);
        this.dividerPadding = AndroidUtilities.dp(12.0f);
        this.tabPadding = AndroidUtilities.dp(24.0f);
        this.lastScrollX = 0;
        setFillViewport(true);
        setWillNotDraw(false);
        LinearLayout linearLayout = new LinearLayout(context);
        this.tabsContainer = linearLayout;
        linearLayout.setOrientation(0);
        this.tabsContainer.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.tabsContainer);
        Paint paint = new Paint();
        this.rectPaint = paint;
        paint.setAntiAlias(true);
        this.rectPaint.setStyle(Paint.Style.FILL);
        this.defaultTabLayoutParams = new LinearLayout.LayoutParams(-2, -1);
    }

    public void setViewPager(ViewPager pager) {
        this.pager = pager;
        if (pager.getAdapter() == null) {
            throw new IllegalStateException("ViewPager does not have adapter instance.");
        }
        pager.setOnPageChangeListener(this.pageListener);
        notifyDataSetChanged();
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener listener) {
        this.delegatePageListener = listener;
    }

    public void notifyDataSetChanged() {
        this.tabsContainer.removeAllViews();
        this.tabCount = this.pager.getAdapter().getCount();
        for (int i = 0; i < this.tabCount; i++) {
            if (this.pager.getAdapter() instanceof IconTabProvider) {
                addIconTab(i, ((IconTabProvider) this.pager.getAdapter()).getPageIconDrawable(i), this.pager.getAdapter().getPageTitle(i));
            }
        }
        updateTabStyles();
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: ir.eitaa.ui.Components.PagerSlidingTabStrip.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                PagerSlidingTabStrip.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                PagerSlidingTabStrip pagerSlidingTabStrip = PagerSlidingTabStrip.this;
                pagerSlidingTabStrip.currentPosition = pagerSlidingTabStrip.pager.getCurrentItem();
                PagerSlidingTabStrip pagerSlidingTabStrip2 = PagerSlidingTabStrip.this;
                pagerSlidingTabStrip2.scrollToChild(pagerSlidingTabStrip2.currentPosition, 0);
            }
        });
    }

    public View getTab(int position) {
        if (position < 0 || position >= this.tabsContainer.getChildCount()) {
            return null;
        }
        return this.tabsContainer.getChildAt(position);
    }

    private void addIconTab(final int position, Drawable drawable, CharSequence contentDescription) {
        ImageView imageView = new ImageView(getContext()) { // from class: ir.eitaa.ui.Components.PagerSlidingTabStrip.2
            @Override // android.widget.ImageView, android.view.View
            protected void onDraw(Canvas canvas) {
                super.onDraw(canvas);
                if (PagerSlidingTabStrip.this.pager.getAdapter() instanceof IconTabProvider) {
                    ((IconTabProvider) PagerSlidingTabStrip.this.pager.getAdapter()).customOnDraw(canvas, position);
                }
            }

            @Override // android.widget.ImageView, android.view.View
            public void setSelected(boolean selected) {
                super.setSelected(selected);
                Drawable background = getBackground();
                if (Build.VERSION.SDK_INT < 21 || background == null) {
                    return;
                }
                int color = Theme.getColor(selected ? "chat_emojiPanelIconSelected" : "chat_emojiBottomPanelIcon");
                Theme.setSelectorDrawableColor(background, Color.argb(30, Color.red(color), Color.green(color), Color.blue(color)), true);
            }
        };
        imageView.setFocusable(true);
        if (Build.VERSION.SDK_INT >= 21) {
            RippleDrawable rippleDrawable = (RippleDrawable) Theme.createSelectorDrawable(Theme.getColor("chat_emojiBottomPanelIcon"));
            Theme.setRippleDrawableForceSoftware(rippleDrawable);
            imageView.setBackground(rippleDrawable);
        }
        imageView.setImageDrawable(drawable);
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$PagerSlidingTabStrip$7xCNG9BUb0so4Ay3lBqIV1nOct4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws Resources.NotFoundException {
                this.f$0.lambda$addIconTab$0$PagerSlidingTabStrip(position, view);
            }
        });
        this.tabsContainer.addView(imageView);
        imageView.setSelected(position == this.currentPosition);
        imageView.setContentDescription(contentDescription);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$addIconTab$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$addIconTab$0$PagerSlidingTabStrip(int i, View view) throws Resources.NotFoundException {
        if (!(this.pager.getAdapter() instanceof IconTabProvider) || ((IconTabProvider) this.pager.getAdapter()).canScrollToTab(i)) {
            this.pager.setCurrentItem(i, false);
        }
    }

    private void updateTabStyles() {
        for (int i = 0; i < this.tabCount; i++) {
            View childAt = this.tabsContainer.getChildAt(i);
            childAt.setLayoutParams(this.defaultTabLayoutParams);
            if (this.shouldExpand) {
                childAt.setPadding(0, 0, 0, 0);
                childAt.setLayoutParams(new LinearLayout.LayoutParams(-1, -1, 1.0f));
            } else {
                int i2 = this.tabPadding;
                childAt.setPadding(i2, 0, i2, 0);
            }
        }
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (!this.shouldExpand || View.MeasureSpec.getMode(widthMeasureSpec) == 0) {
            return;
        }
        this.tabsContainer.measure(getMeasuredWidth() | 1073741824, heightMeasureSpec);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int position, int offset) {
        if (this.tabCount == 0) {
            return;
        }
        int left = this.tabsContainer.getChildAt(position).getLeft() + offset;
        if (position > 0 || offset > 0) {
            left -= this.scrollOffset;
        }
        if (left != this.lastScrollX) {
            this.lastScrollX = left;
            scrollTo(left, 0);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int i;
        super.onDraw(canvas);
        if (isInEditMode() || this.tabCount == 0) {
            return;
        }
        int height = getHeight();
        if (this.underlineHeight != 0) {
            this.rectPaint.setColor(this.underlineColor);
            canvas.drawRect(0.0f, height - this.underlineHeight, this.tabsContainer.getWidth(), height, this.rectPaint);
        }
        View childAt = this.tabsContainer.getChildAt(this.currentPosition);
        float left = childAt.getLeft();
        float right = childAt.getRight();
        if (this.currentPositionOffset > 0.0f && (i = this.currentPosition) < this.tabCount - 1) {
            View childAt2 = this.tabsContainer.getChildAt(i + 1);
            float left2 = childAt2.getLeft();
            float right2 = childAt2.getRight();
            float f = this.currentPositionOffset;
            left = (left2 * f) + ((1.0f - f) * left);
            right = (right2 * f) + ((1.0f - f) * right);
        }
        float f2 = right;
        float f3 = left;
        if (this.indicatorHeight != 0) {
            this.rectPaint.setColor(this.indicatorColor);
            canvas.drawRect(f3, height - this.indicatorHeight, f2, height, this.rectPaint);
        }
    }

    private class PageListener implements ViewPager.OnPageChangeListener {
        private PageListener() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            PagerSlidingTabStrip.this.currentPosition = position;
            PagerSlidingTabStrip.this.currentPositionOffset = positionOffset;
            PagerSlidingTabStrip.this.scrollToChild(position, (int) (r0.tabsContainer.getChildAt(position).getWidth() * positionOffset));
            PagerSlidingTabStrip.this.invalidate();
            ViewPager.OnPageChangeListener onPageChangeListener = PagerSlidingTabStrip.this.delegatePageListener;
            if (onPageChangeListener != null) {
                onPageChangeListener.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int state) {
            if (state == 0) {
                PagerSlidingTabStrip pagerSlidingTabStrip = PagerSlidingTabStrip.this;
                pagerSlidingTabStrip.scrollToChild(pagerSlidingTabStrip.pager.getCurrentItem(), 0);
            }
            ViewPager.OnPageChangeListener onPageChangeListener = PagerSlidingTabStrip.this.delegatePageListener;
            if (onPageChangeListener != null) {
                onPageChangeListener.onPageScrollStateChanged(state);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int position) {
            ViewPager.OnPageChangeListener onPageChangeListener = PagerSlidingTabStrip.this.delegatePageListener;
            if (onPageChangeListener != null) {
                onPageChangeListener.onPageSelected(position);
            }
            int i = 0;
            while (i < PagerSlidingTabStrip.this.tabsContainer.getChildCount()) {
                PagerSlidingTabStrip.this.tabsContainer.getChildAt(i).setSelected(i == position);
                i++;
            }
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        if (this.shouldExpand) {
            return;
        }
        post(new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$ojZRo0isKYKih-CbDa9fNrrFl_g
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.notifyDataSetChanged();
            }
        });
    }

    public void setIndicatorColor(int indicatorColor) {
        this.indicatorColor = indicatorColor;
        invalidate();
    }

    public void setIndicatorColorResource(int resId) {
        this.indicatorColor = getResources().getColor(resId);
        invalidate();
    }

    public int getIndicatorColor() {
        return this.indicatorColor;
    }

    public void setIndicatorHeight(int indicatorLineHeightPx) {
        this.indicatorHeight = indicatorLineHeightPx;
        invalidate();
    }

    public int getIndicatorHeight() {
        return this.indicatorHeight;
    }

    public void setUnderlineColor(int underlineColor) {
        this.underlineColor = underlineColor;
        invalidate();
    }

    public void setUnderlineColorResource(int resId) {
        this.underlineColor = getResources().getColor(resId);
        invalidate();
    }

    public int getUnderlineColor() {
        return this.underlineColor;
    }

    public void setUnderlineHeight(int underlineHeightPx) {
        this.underlineHeight = underlineHeightPx;
        invalidate();
    }

    public int getUnderlineHeight() {
        return this.underlineHeight;
    }

    public void setDividerPadding(int dividerPaddingPx) {
        this.dividerPadding = dividerPaddingPx;
        invalidate();
    }

    public int getDividerPadding() {
        return this.dividerPadding;
    }

    public void setScrollOffset(int scrollOffsetPx) {
        this.scrollOffset = scrollOffsetPx;
        invalidate();
    }

    public int getScrollOffset() {
        return this.scrollOffset;
    }

    public void setShouldExpand(boolean shouldExpand) {
        this.shouldExpand = shouldExpand;
        this.tabsContainer.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        updateTabStyles();
        requestLayout();
    }

    public boolean getShouldExpand() {
        return this.shouldExpand;
    }

    public void setTabPaddingLeftRight(int paddingPx) {
        this.tabPadding = paddingPx;
        updateTabStyles();
    }

    public int getTabPaddingLeftRight() {
        return this.tabPadding;
    }
}
