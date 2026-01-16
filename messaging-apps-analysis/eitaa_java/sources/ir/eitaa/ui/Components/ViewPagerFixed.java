package ir.eitaa.ui.Components;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.SystemClock;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.Emoji;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.messenger.MessagesStorage;
import ir.eitaa.messenger.UserConfig;
import ir.eitaa.messenger.browser.Browser;
import ir.eitaa.tgnet.ConnectionsManager;
import ir.eitaa.tgnet.RequestDelegate;
import ir.eitaa.tgnet.TLObject;
import ir.eitaa.tgnet.TLRPC$TL_error;
import ir.eitaa.tgnet.TLRPC$TL_messages_updateDialogFiltersOrder;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Components.RecyclerListView;
import ir.eitaa.ui.Components.ViewPagerFixed;
import ir.eitaa.ui.DialogsActivity;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class ViewPagerFixed extends FrameLayout {
    private static final Interpolator interpolator = new Interpolator() { // from class: ir.eitaa.ui.Components.-$$Lambda$ViewPagerFixed$TLYpTX7fmMpnI0azdLEzA9UsuVo
        @Override // android.animation.TimeInterpolator
        public final float getInterpolation(float f) {
            return ViewPagerFixed.lambda$static$0(f);
        }
    };
    private Adapter adapter;
    private float additionalOffset;
    private boolean animatingForward;
    private boolean backAnimation;
    int currentPosition;
    private int maximumVelocity;
    private boolean maybeStartTracking;
    int nextPosition;
    private android.graphics.Rect rect;
    private boolean startedTracking;
    private int startedTrackingPointerId;
    private int startedTrackingX;
    private int startedTrackingY;
    private AnimatorSet tabsAnimation;
    private boolean tabsAnimationInProgress;
    TabsView tabsView;
    private final float touchSlop;
    ValueAnimator.AnimatorUpdateListener updateTabProgress;
    private VelocityTracker velocityTracker;
    private View[] viewPages;
    private int[] viewTypes;
    protected SparseArray<View> viewsByType;

    public static abstract class Adapter {
        public abstract void bindView(View view, int position, int viewType);

        public abstract View createView(int viewType);

        public abstract int getItemCount();

        public int getItemId(int position) {
            return position;
        }

        public abstract String getItemTitle(int position);

        public abstract int getItemViewType(int position);
    }

    static /* synthetic */ float lambda$static$0(float f) {
        float f2 = f - 1.0f;
        return (f2 * f2 * f2 * f2 * f2) + 1.0f;
    }

    protected void onItemSelected(View currentPage, View oldPage, int position, int oldPosition) {
    }

    public ViewPagerFixed(Context context) {
        super(context);
        this.viewsByType = new SparseArray<>();
        this.updateTabProgress = new ValueAnimator.AnimatorUpdateListener() { // from class: ir.eitaa.ui.Components.ViewPagerFixed.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (ViewPagerFixed.this.tabsAnimationInProgress) {
                    float fAbs = Math.abs(ViewPagerFixed.this.viewPages[0].getTranslationX()) / ViewPagerFixed.this.viewPages[0].getMeasuredWidth();
                    ViewPagerFixed viewPagerFixed = ViewPagerFixed.this;
                    TabsView tabsView = viewPagerFixed.tabsView;
                    if (tabsView != null) {
                        tabsView.selectTab(viewPagerFixed.nextPosition, viewPagerFixed.currentPosition, 1.0f - fAbs);
                    }
                }
            }
        };
        this.rect = new android.graphics.Rect();
        this.touchSlop = AndroidUtilities.getPixelsInCM(0.3f, true);
        this.maximumVelocity = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
        this.viewTypes = new int[2];
        this.viewPages = new View[2];
        setClipChildren(true);
    }

    public void setAdapter(Adapter adapter) {
        this.adapter = adapter;
        if (LocaleController.isRTL) {
            this.currentPosition = 5;
        }
        this.viewTypes[0] = adapter.getItemViewType(this.currentPosition);
        this.viewPages[0] = adapter.createView(this.viewTypes[0]);
        adapter.bindView(this.viewPages[0], this.currentPosition, this.viewTypes[0]);
        addView(this.viewPages[0]);
        this.viewPages[0].setVisibility(0);
        fillTabs();
    }

    public TabsView createTabsView() {
        TabsView tabsView = new TabsView(getContext());
        this.tabsView = tabsView;
        tabsView.setDelegate(new TabsView.TabsViewDelegate() { // from class: ir.eitaa.ui.Components.ViewPagerFixed.2
            @Override // ir.eitaa.ui.Components.ViewPagerFixed.TabsView.TabsViewDelegate
            public void onSamePageSelected() {
            }

            @Override // ir.eitaa.ui.Components.ViewPagerFixed.TabsView.TabsViewDelegate
            public void onPageSelected(int page, boolean forward) {
                ViewPagerFixed.this.animatingForward = forward;
                ViewPagerFixed viewPagerFixed = ViewPagerFixed.this;
                viewPagerFixed.nextPosition = page;
                viewPagerFixed.updateViewForIndex(1);
                if (forward) {
                    ViewPagerFixed.this.viewPages[1].setTranslationX(ViewPagerFixed.this.viewPages[0].getMeasuredWidth());
                } else {
                    ViewPagerFixed.this.viewPages[1].setTranslationX(-ViewPagerFixed.this.viewPages[0].getMeasuredWidth());
                }
            }

            @Override // ir.eitaa.ui.Components.ViewPagerFixed.TabsView.TabsViewDelegate
            public void onPageScrolled(float progress) {
                if (progress == 1.0f) {
                    if (ViewPagerFixed.this.viewPages[1] != null) {
                        ViewPagerFixed.this.swapViews();
                        ViewPagerFixed viewPagerFixed = ViewPagerFixed.this;
                        viewPagerFixed.viewsByType.put(viewPagerFixed.viewTypes[1], ViewPagerFixed.this.viewPages[1]);
                        ViewPagerFixed viewPagerFixed2 = ViewPagerFixed.this;
                        viewPagerFixed2.removeView(viewPagerFixed2.viewPages[1]);
                        ViewPagerFixed.this.viewPages[0].setTranslationX(0.0f);
                        ViewPagerFixed.this.viewPages[1] = null;
                        return;
                    }
                    return;
                }
                if (ViewPagerFixed.this.viewPages[1] == null) {
                    return;
                }
                if (ViewPagerFixed.this.animatingForward) {
                    ViewPagerFixed.this.viewPages[1].setTranslationX(ViewPagerFixed.this.viewPages[0].getMeasuredWidth() * (1.0f - progress));
                    ViewPagerFixed.this.viewPages[0].setTranslationX((-ViewPagerFixed.this.viewPages[0].getMeasuredWidth()) * progress);
                } else {
                    ViewPagerFixed.this.viewPages[1].setTranslationX((-ViewPagerFixed.this.viewPages[0].getMeasuredWidth()) * (1.0f - progress));
                    ViewPagerFixed.this.viewPages[0].setTranslationX(ViewPagerFixed.this.viewPages[0].getMeasuredWidth() * progress);
                }
            }

            @Override // ir.eitaa.ui.Components.ViewPagerFixed.TabsView.TabsViewDelegate
            public boolean canPerformActions() {
                return (ViewPagerFixed.this.tabsAnimationInProgress || ViewPagerFixed.this.startedTracking) ? false : true;
            }
        });
        fillTabs();
        return this.tabsView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateViewForIndex(int index) {
        int i = index == 0 ? this.currentPosition : this.nextPosition;
        if (this.viewPages[index] == null) {
            this.viewTypes[index] = this.adapter.getItemViewType(i);
            View viewCreateView = this.viewsByType.get(this.viewTypes[index]);
            if (viewCreateView == null) {
                viewCreateView = this.adapter.createView(this.viewTypes[index]);
            } else {
                this.viewsByType.remove(this.viewTypes[index]);
            }
            if (viewCreateView.getParent() != null) {
                ((ViewGroup) viewCreateView.getParent()).removeView(viewCreateView);
            }
            addView(viewCreateView);
            View[] viewArr = this.viewPages;
            viewArr[index] = viewCreateView;
            this.adapter.bindView(viewArr[index], i, this.viewTypes[index]);
            this.viewPages[index].setVisibility(0);
            return;
        }
        if (this.viewTypes[index] == this.adapter.getItemViewType(i)) {
            this.adapter.bindView(this.viewPages[index], i, this.viewTypes[index]);
            this.viewPages[index].setVisibility(0);
            return;
        }
        this.viewsByType.put(this.viewTypes[index], this.viewPages[index]);
        this.viewPages[index].setVisibility(8);
        removeView(this.viewPages[index]);
        this.viewTypes[index] = this.adapter.getItemViewType(i);
        View viewCreateView2 = this.viewsByType.get(this.viewTypes[index]);
        if (viewCreateView2 == null) {
            viewCreateView2 = this.adapter.createView(this.viewTypes[index]);
        } else {
            this.viewsByType.remove(this.viewTypes[index]);
        }
        addView(viewCreateView2);
        View[] viewArr2 = this.viewPages;
        viewArr2[index] = viewCreateView2;
        viewArr2[index].setVisibility(0);
        Adapter adapter = this.adapter;
        adapter.bindView(this.viewPages[index], i, adapter.getItemViewType(i));
    }

    private void fillTabs() {
        TabsView tabsView;
        if (this.adapter == null || (tabsView = this.tabsView) == null) {
            return;
        }
        tabsView.removeTabs();
        for (int i = 0; i < this.adapter.getItemCount(); i++) {
            this.tabsView.addTab(this.adapter.getItemId(i), this.adapter.getItemTitle(i));
        }
    }

    private boolean prepareForMoving(MotionEvent ev, boolean forward) {
        if (LocaleController.isRTL) {
            if (this.currentPosition + (forward ? 1 : -1) == 0) {
                return false;
            }
        } else {
            if (this.currentPosition + (forward ? 1 : -1) == 5) {
                return false;
            }
        }
        if ((!forward && this.currentPosition == 0) || (forward && this.currentPosition == this.adapter.getItemCount() - 1)) {
            return false;
        }
        getParent().requestDisallowInterceptTouchEvent(true);
        this.maybeStartTracking = false;
        this.startedTracking = true;
        this.startedTrackingX = (int) (ev.getX() + this.additionalOffset);
        TabsView tabsView = this.tabsView;
        if (tabsView != null) {
            tabsView.setEnabled(false);
        }
        this.animatingForward = forward;
        this.nextPosition = this.currentPosition + (forward ? 1 : -1);
        updateViewForIndex(1);
        if (forward) {
            this.viewPages[1].setTranslationX(r6[0].getMeasuredWidth());
        } else {
            this.viewPages[1].setTranslationX(-r6[0].getMeasuredWidth());
        }
        return true;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        TabsView tabsView = this.tabsView;
        if (tabsView != null && tabsView.isAnimatingIndicator()) {
            return false;
        }
        if (checkTabsAnimationInProgress()) {
            return true;
        }
        onTouchEvent(ev);
        return this.startedTracking;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        if (this.maybeStartTracking && !this.startedTracking) {
            onTouchEvent(null);
        }
        super.requestDisallowInterceptTouchEvent(disallowIntercept);
    }

    /* JADX WARN: Code restructure failed: missing block: B:141:0x028f, code lost:
    
        r7 = true;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r14) {
        /*
            Method dump skipped, instructions count: 1154
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Components.ViewPagerFixed.onTouchEvent(android.view.MotionEvent):boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void swapViews() {
        View[] viewArr = this.viewPages;
        View view = viewArr[0];
        viewArr[0] = viewArr[1];
        viewArr[1] = view;
        int i = this.currentPosition;
        int i2 = this.nextPosition;
        this.currentPosition = i2;
        this.nextPosition = i;
        int[] iArr = this.viewTypes;
        int i3 = iArr[0];
        iArr[0] = iArr[1];
        iArr[1] = i3;
        onItemSelected(viewArr[0], viewArr[1], i2, i);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0069  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean checkTabsAnimationInProgress() {
        /*
            r7 = this;
            boolean r0 = r7.tabsAnimationInProgress
            r1 = 0
            if (r0 == 0) goto L7b
            boolean r0 = r7.backAnimation
            r2 = -1
            r3 = 0
            r4 = 1065353216(0x3f800000, float:1.0)
            r5 = 1
            if (r0 == 0) goto L3b
            android.view.View[] r0 = r7.viewPages
            r0 = r0[r1]
            float r0 = r0.getTranslationX()
            float r0 = java.lang.Math.abs(r0)
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 >= 0) goto L69
            android.view.View[] r0 = r7.viewPages
            r0 = r0[r1]
            r0.setTranslationX(r3)
            android.view.View[] r0 = r7.viewPages
            r3 = r0[r5]
            r0 = r0[r1]
            int r0 = r0.getMeasuredWidth()
            boolean r4 = r7.animatingForward
            if (r4 == 0) goto L34
            r2 = 1
        L34:
            int r0 = r0 * r2
            float r0 = (float) r0
            r3.setTranslationX(r0)
            goto L6a
        L3b:
            android.view.View[] r0 = r7.viewPages
            r0 = r0[r5]
            float r0 = r0.getTranslationX()
            float r0 = java.lang.Math.abs(r0)
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 >= 0) goto L69
            android.view.View[] r0 = r7.viewPages
            r4 = r0[r1]
            r0 = r0[r1]
            int r0 = r0.getMeasuredWidth()
            boolean r6 = r7.animatingForward
            if (r6 == 0) goto L5a
            goto L5b
        L5a:
            r2 = 1
        L5b:
            int r0 = r0 * r2
            float r0 = (float) r0
            r4.setTranslationX(r0)
            android.view.View[] r0 = r7.viewPages
            r0 = r0[r5]
            r0.setTranslationX(r3)
            goto L6a
        L69:
            r5 = 0
        L6a:
            if (r5 == 0) goto L78
            android.animation.AnimatorSet r0 = r7.tabsAnimation
            if (r0 == 0) goto L76
            r0.cancel()
            r0 = 0
            r7.tabsAnimation = r0
        L76:
            r7.tabsAnimationInProgress = r1
        L78:
            boolean r0 = r7.tabsAnimationInProgress
            return r0
        L7b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Components.ViewPagerFixed.checkTabsAnimationInProgress():boolean");
    }

    public static float distanceInfluenceForSnapDuration(float f) {
        return (float) Math.sin((f - 0.5f) * 0.47123894f);
    }

    public void setPosition(int position) {
        AnimatorSet animatorSet = this.tabsAnimation;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        View[] viewArr = this.viewPages;
        if (viewArr[1] != null) {
            this.viewsByType.put(this.viewTypes[1], viewArr[1]);
            removeView(this.viewPages[1]);
            this.viewPages[1] = null;
        }
        int i = this.currentPosition;
        if (i != position) {
            this.currentPosition = position;
            View view = this.viewPages[0];
            updateViewForIndex(0);
            onItemSelected(this.viewPages[0], view, this.currentPosition, i);
            this.viewPages[0].setTranslationX(0.0f);
            TabsView tabsView = this.tabsView;
            if (tabsView != null) {
                tabsView.selectTab(position, 0, 1.0f);
            }
        }
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int direction) {
        if (direction == 0) {
            return false;
        }
        if (!this.tabsAnimationInProgress && !this.startedTracking) {
            boolean z = direction > 0;
            if ((!z && this.currentPosition == 0) || (z && this.currentPosition == this.adapter.getItemCount() - 1)) {
                return false;
            }
        }
        return true;
    }

    public View getCurrentView() {
        return this.viewPages[0];
    }

    public int getCurrentPosition() {
        return this.currentPosition;
    }

    public static class TabsView extends FrameLayout {
        private int activeTextColorKey;
        private ListAdapter adapter;
        private int additionalTabWidth;
        private int allTabsWidth;
        private boolean animatingIndicator;
        private float animatingIndicatorProgress;
        private Runnable animationRunnable;
        private float animationTime;
        private String backgroundColorKey;
        private Paint counterPaint;
        private float crossfadeAlpha;
        private Bitmap crossfadeBitmap;
        private Paint crossfadePaint;
        private int currentPosition;
        private TabsViewDelegate delegate;
        private Paint deletePaint;
        private float editingAnimationProgress;
        private boolean editingForwardAnimation;
        private float editingStartAnimationProgress;
        private float hideProgress;
        private SparseIntArray idToPosition;
        private boolean ignoreLayout;
        private CubicBezierInterpolator interpolator;
        private boolean invalidated;
        private boolean isEditing;
        private boolean isInHiddenMode;
        private long lastAnimationTime;
        private LinearLayoutManager layoutManager;
        private RecyclerListView listView;
        private int manualScrollingToId;
        private int manualScrollingToPosition;
        private boolean orderChanged;
        private SparseIntArray positionToId;
        private SparseIntArray positionToWidth;
        private SparseIntArray positionToX;
        private int prevLayoutWidth;
        private int previousId;
        private int previousPosition;
        private int scrollingToChild;
        private int selectedTabId;
        private String selectorColorKey;
        private GradientDrawable selectorDrawable;
        private String tabLineColorKey;
        private ArrayList<Tab> tabs;
        ValueAnimator tabsAnimator;
        private TextPaint textCounterPaint;
        private TextPaint textPaint;
        private int unactiveTextColorKey;

        public interface TabsViewDelegate {
            boolean canPerformActions();

            void onPageScrolled(float progress);

            void onPageSelected(int page, boolean forward);

            void onSamePageSelected();
        }

        static /* synthetic */ void lambda$setIsEditing$1(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        }

        static /* synthetic */ float access$2816(TabsView tabsView, float f) {
            float f2 = tabsView.animationTime + f;
            tabsView.animationTime = f2;
            return f2;
        }

        private static class Tab {
            public int counter;
            public int id;
            public String title;
            public int titleWidth;

            public Tab(int i, String t) {
                this.id = i;
                this.title = t;
            }

            public int getWidth(boolean store, TextPaint textPaint) {
                int iCeil = (int) Math.ceil(textPaint.measureText(this.title));
                this.titleWidth = iCeil;
                return Math.max(AndroidUtilities.dp(40.0f), iCeil);
            }
        }

        public class TabView extends View {
            private int currentPosition;
            private Tab currentTab;
            private String currentText;
            private RectF rect;
            private int tabWidth;
            private int textHeight;
            private StaticLayout textLayout;
            private int textOffsetX;

            public TabView(Context context) {
                super(context);
                this.rect = new RectF();
            }

            public void setTab(Tab tab, int position) {
                this.currentTab = tab;
                this.currentPosition = position;
                setContentDescription(tab.title);
                requestLayout();
            }

            @Override // android.view.View
            public int getId() {
                return this.currentTab.id;
            }

            @Override // android.view.View
            protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
                setMeasuredDimension(this.currentTab.getWidth(false, TabsView.this.textPaint) + AndroidUtilities.dp(32.0f) + TabsView.this.additionalTabWidth, View.MeasureSpec.getSize(heightMeasureSpec));
            }

            @Override // android.view.View
            @SuppressLint({"DrawAllocation"})
            protected void onDraw(Canvas canvas) {
                int i;
                int i2;
                int i3;
                int i4;
                int i5;
                String str;
                int iCeil;
                int iDp;
                int iDp2;
                int i6;
                if (this.currentTab.id != Integer.MAX_VALUE && TabsView.this.editingAnimationProgress != 0.0f) {
                    canvas.save();
                    float f = TabsView.this.editingAnimationProgress * (this.currentPosition % 2 == 0 ? 1.0f : -1.0f);
                    canvas.translate(AndroidUtilities.dp(0.66f) * f, 0.0f);
                    canvas.rotate(f, getMeasuredWidth() / 2, getMeasuredHeight() / 2);
                }
                if (TabsView.this.manualScrollingToId != -1) {
                    i = TabsView.this.manualScrollingToId;
                    i2 = TabsView.this.selectedTabId;
                } else {
                    i = TabsView.this.selectedTabId;
                    i2 = TabsView.this.previousId;
                }
                String str2 = "chats_tabUnreadActiveBackground";
                String str3 = "chats_tabUnreadUnactiveBackground";
                if (this.currentTab.id == i) {
                    i3 = TabsView.this.activeTextColorKey;
                    i4 = TabsView.this.unactiveTextColorKey;
                } else {
                    i3 = TabsView.this.unactiveTextColorKey;
                    i4 = TabsView.this.activeTextColorKey;
                    str3 = "chats_tabUnreadActiveBackground";
                    str2 = "chats_tabUnreadUnactiveBackground";
                }
                if ((TabsView.this.animatingIndicator || TabsView.this.manualScrollingToId != -1) && ((i5 = this.currentTab.id) == i || i5 == i2)) {
                    TabsView.this.textPaint.setColor(ColorUtils.blendARGB(i4, i3, TabsView.this.animatingIndicatorProgress));
                } else {
                    TabsView.this.textPaint.setColor(i3);
                }
                int i7 = this.currentTab.counter;
                if (i7 > 0) {
                    str = String.format("%d", Integer.valueOf(i7));
                    iCeil = (int) Math.ceil(TabsView.this.textCounterPaint.measureText(str));
                    iDp = Math.max(AndroidUtilities.dp(10.0f), iCeil) + AndroidUtilities.dp(10.0f);
                } else {
                    str = null;
                    iCeil = 0;
                    iDp = 0;
                }
                if (this.currentTab.id != Integer.MAX_VALUE && (TabsView.this.isEditing || TabsView.this.editingStartAnimationProgress != 0.0f)) {
                    iDp = (int) (iDp + ((AndroidUtilities.dp(20.0f) - iDp) * TabsView.this.editingStartAnimationProgress));
                }
                int i8 = this.currentTab.titleWidth;
                if (iDp != 0) {
                    iDp2 = AndroidUtilities.dp((str != null ? 1.0f : TabsView.this.editingStartAnimationProgress) * 6.0f) + iDp;
                } else {
                    iDp2 = 0;
                }
                this.tabWidth = i8 + iDp2;
                int measuredWidth = (getMeasuredWidth() - this.tabWidth) / 2;
                if (!TextUtils.equals(this.currentTab.title, this.currentText)) {
                    String str4 = this.currentTab.title;
                    this.currentText = str4;
                    StaticLayout staticLayout = new StaticLayout(Emoji.replaceEmoji(str4, TabsView.this.textPaint.getFontMetricsInt(), AndroidUtilities.dp(15.0f), false), TabsView.this.textPaint, AndroidUtilities.dp(400.0f), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
                    this.textLayout = staticLayout;
                    this.textHeight = staticLayout.getHeight();
                    this.textOffsetX = (int) (-this.textLayout.getLineLeft(0));
                }
                if (this.textLayout != null) {
                    canvas.save();
                    canvas.translate(this.textOffsetX + measuredWidth, ((getMeasuredHeight() - this.textHeight) / 2) + 1);
                    canvas.drawColor(Theme.getColor("actionBarDefault"));
                    this.textLayout.draw(canvas);
                    canvas.restore();
                }
                if (str != null || (this.currentTab.id != Integer.MAX_VALUE && (TabsView.this.isEditing || TabsView.this.editingStartAnimationProgress != 0.0f))) {
                    TabsView.this.textCounterPaint.setColor(Theme.getColor(TabsView.this.backgroundColorKey));
                    if (!Theme.hasThemeKey(str2) || !Theme.hasThemeKey(str3)) {
                        TabsView.this.counterPaint.setColor(TabsView.this.textPaint.getColor());
                    } else {
                        int color = Theme.getColor(str2);
                        if ((TabsView.this.animatingIndicator || TabsView.this.manualScrollingToPosition != -1) && ((i6 = this.currentTab.id) == i || i6 == i2)) {
                            TabsView.this.counterPaint.setColor(ColorUtils.blendARGB(Theme.getColor(str3), color, TabsView.this.animatingIndicatorProgress));
                        } else {
                            TabsView.this.counterPaint.setColor(color);
                        }
                    }
                    int iDp3 = measuredWidth + this.currentTab.titleWidth + AndroidUtilities.dp(6.0f);
                    int measuredHeight = (getMeasuredHeight() - AndroidUtilities.dp(20.0f)) / 2;
                    if (this.currentTab.id == Integer.MAX_VALUE || ((!TabsView.this.isEditing && TabsView.this.editingStartAnimationProgress == 0.0f) || str != null)) {
                        TabsView.this.counterPaint.setAlpha(255);
                    } else {
                        TabsView.this.counterPaint.setAlpha((int) (TabsView.this.editingStartAnimationProgress * 255.0f));
                    }
                    this.rect.set(iDp3, measuredHeight, iDp3 + iDp, AndroidUtilities.dp(20.0f) + measuredHeight);
                    RectF rectF = this.rect;
                    float f2 = AndroidUtilities.density;
                    canvas.drawRoundRect(rectF, f2 * 11.5f, f2 * 11.5f, TabsView.this.counterPaint);
                    if (str != null) {
                        if (this.currentTab.id != Integer.MAX_VALUE) {
                            TabsView.this.textCounterPaint.setAlpha((int) ((1.0f - TabsView.this.editingStartAnimationProgress) * 255.0f));
                        }
                        RectF rectF2 = this.rect;
                        canvas.drawText(str, rectF2.left + ((rectF2.width() - iCeil) / 2.0f), measuredHeight + AndroidUtilities.dp(14.5f), TabsView.this.textCounterPaint);
                    }
                    if (this.currentTab.id != Integer.MAX_VALUE && (TabsView.this.isEditing || TabsView.this.editingStartAnimationProgress != 0.0f)) {
                        TabsView.this.deletePaint.setColor(TabsView.this.textCounterPaint.getColor());
                        TabsView.this.deletePaint.setAlpha((int) (TabsView.this.editingStartAnimationProgress * 255.0f));
                        float fDp = AndroidUtilities.dp(3.0f);
                        canvas.drawLine(this.rect.centerX() - fDp, this.rect.centerY() - fDp, this.rect.centerX() + fDp, this.rect.centerY() + fDp, TabsView.this.deletePaint);
                        canvas.drawLine(this.rect.centerX() - fDp, this.rect.centerY() + fDp, this.rect.centerX() + fDp, this.rect.centerY() - fDp, TabsView.this.deletePaint);
                    }
                }
                if (this.currentTab.id == Integer.MAX_VALUE || TabsView.this.editingAnimationProgress == 0.0f) {
                    return;
                }
                canvas.restore();
            }

            @Override // android.view.View
            public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
                super.onInitializeAccessibilityNodeInfo(info);
                info.setSelected((this.currentTab == null || TabsView.this.selectedTabId == -1 || this.currentTab.id != TabsView.this.selectedTabId) ? false : true);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public TabsView(Context context) {
            super(context);
            this.textPaint = new TextPaint(1);
            this.textCounterPaint = new TextPaint(1);
            this.deletePaint = new TextPaint(1);
            this.counterPaint = new Paint(1);
            this.tabs = new ArrayList<>();
            this.crossfadePaint = new Paint();
            this.selectedTabId = -1;
            this.manualScrollingToPosition = -1;
            this.manualScrollingToId = -1;
            this.scrollingToChild = -1;
            this.tabLineColorKey = "profile_tabSelectedLine";
            this.activeTextColorKey = -1;
            this.unactiveTextColorKey = -2829100;
            this.selectorColorKey = "profile_tabSelector";
            this.backgroundColorKey = "actionBarDefault";
            this.interpolator = CubicBezierInterpolator.EASE_OUT_QUINT;
            this.positionToId = new SparseIntArray(5);
            this.idToPosition = new SparseIntArray(5);
            this.positionToWidth = new SparseIntArray(5);
            this.positionToX = new SparseIntArray(5);
            this.animationRunnable = new Runnable() { // from class: ir.eitaa.ui.Components.ViewPagerFixed.TabsView.1
                @Override // java.lang.Runnable
                public void run() {
                    if (TabsView.this.animatingIndicator) {
                        long jElapsedRealtime = SystemClock.elapsedRealtime() - TabsView.this.lastAnimationTime;
                        if (jElapsedRealtime > 17) {
                            jElapsedRealtime = 17;
                        }
                        TabsView.access$2816(TabsView.this, jElapsedRealtime / 200.0f);
                        TabsView tabsView = TabsView.this;
                        tabsView.setAnimationIdicatorProgress(tabsView.interpolator.getInterpolation(TabsView.this.animationTime));
                        if (TabsView.this.animationTime > 1.0f) {
                            TabsView.this.animationTime = 1.0f;
                        }
                        if (TabsView.this.animationTime < 1.0f) {
                            AndroidUtilities.runOnUIThread(TabsView.this.animationRunnable);
                            return;
                        }
                        TabsView.this.animatingIndicator = false;
                        TabsView.this.setEnabled(true);
                        if (TabsView.this.delegate != null) {
                            TabsView.this.delegate.onPageScrolled(1.0f);
                        }
                    }
                }
            };
            this.textCounterPaint.setTextSize(AndroidUtilities.dp(13.0f));
            this.textCounterPaint.setTypeface(AndroidUtilities.getFontFamily(true));
            this.textPaint.setTextSize(AndroidUtilities.dp(15.0f));
            this.textPaint.setTypeface(AndroidUtilities.getFontFamily(true));
            this.deletePaint.setStyle(Paint.Style.STROKE);
            this.deletePaint.setStrokeCap(Paint.Cap.ROUND);
            this.deletePaint.setStrokeWidth(AndroidUtilities.dp(1.5f));
            this.selectorDrawable = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, null);
            float fDpf2 = AndroidUtilities.dpf2(3.0f);
            this.selectorDrawable.setCornerRadii(new float[]{fDpf2, fDpf2, fDpf2, fDpf2, 0.0f, 0.0f, 0.0f, 0.0f});
            this.selectorDrawable.setColor(Theme.getColor(this.tabLineColorKey));
            setHorizontalScrollBarEnabled(false);
            RecyclerListView recyclerListView = new RecyclerListView(context) { // from class: ir.eitaa.ui.Components.ViewPagerFixed.TabsView.2
                @Override // android.view.ViewGroup
                public void addView(View child, int index, ViewGroup.LayoutParams params) {
                    super.addView(child, index, params);
                    if (TabsView.this.isInHiddenMode) {
                        child.setScaleX(0.3f);
                        child.setScaleY(0.3f);
                        child.setAlpha(0.0f);
                    } else {
                        child.setScaleX(1.0f);
                        child.setScaleY(1.0f);
                        child.setAlpha(1.0f);
                    }
                }

                @Override // android.view.View
                public void setAlpha(float alpha) {
                    super.setAlpha(alpha);
                    TabsView.this.invalidate();
                }

                @Override // ir.eitaa.ui.Components.RecyclerListView
                protected boolean canHighlightChildAt(View child, float x, float y) {
                    if (TabsView.this.isEditing) {
                        TabView tabView = (TabView) child;
                        float fDp = AndroidUtilities.dp(6.0f);
                        if (tabView.rect.left - fDp < x && tabView.rect.right + fDp > x) {
                            return false;
                        }
                    }
                    return super.canHighlightChildAt(child, x, y);
                }
            };
            this.listView = recyclerListView;
            ((DefaultItemAnimator) recyclerListView.getItemAnimator()).setDelayAnimations(false);
            this.listView.setSelectorType(7);
            this.listView.setSelectorDrawableColor(Theme.getColor(this.selectorColorKey));
            RecyclerListView recyclerListView2 = this.listView;
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, 0, 0 == true ? 1 : 0) { // from class: ir.eitaa.ui.Components.ViewPagerFixed.TabsView.3
                @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
                public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int position) {
                    LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(recyclerView.getContext()) { // from class: ir.eitaa.ui.Components.ViewPagerFixed.TabsView.3.1
                        @Override // androidx.recyclerview.widget.LinearSmoothScroller, androidx.recyclerview.widget.RecyclerView.SmoothScroller
                        protected void onTargetFound(View targetView, RecyclerView.State state2, RecyclerView.SmoothScroller.Action action) {
                            int iCalculateDxToMakeVisible = calculateDxToMakeVisible(targetView, getHorizontalSnapPreference());
                            if (iCalculateDxToMakeVisible > 0 || (iCalculateDxToMakeVisible == 0 && targetView.getLeft() - AndroidUtilities.dp(21.0f) < 0)) {
                                iCalculateDxToMakeVisible += AndroidUtilities.dp(60.0f);
                            } else if (iCalculateDxToMakeVisible < 0 || (iCalculateDxToMakeVisible == 0 && targetView.getRight() + AndroidUtilities.dp(21.0f) > TabsView.this.getMeasuredWidth())) {
                                iCalculateDxToMakeVisible -= AndroidUtilities.dp(60.0f);
                            }
                            int iCalculateDyToMakeVisible = calculateDyToMakeVisible(targetView, getVerticalSnapPreference());
                            int iMax = Math.max(180, calculateTimeForDeceleration((int) Math.sqrt((iCalculateDxToMakeVisible * iCalculateDxToMakeVisible) + (iCalculateDyToMakeVisible * iCalculateDyToMakeVisible))));
                            if (iMax > 0) {
                                action.update(-iCalculateDxToMakeVisible, -iCalculateDyToMakeVisible, iMax, this.mDecelerateInterpolator);
                            }
                        }
                    };
                    linearSmoothScroller.setTargetPosition(position);
                    startSmoothScroll(linearSmoothScroller);
                }

                @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
                public void onInitializeAccessibilityNodeInfo(RecyclerView.Recycler recycler, RecyclerView.State state, AccessibilityNodeInfoCompat info) {
                    super.onInitializeAccessibilityNodeInfo(recycler, state, info);
                    if (TabsView.this.isInHiddenMode) {
                        info.setVisibleToUser(false);
                    }
                }
            };
            this.layoutManager = linearLayoutManager;
            recyclerListView2.setLayoutManager(linearLayoutManager);
            this.listView.setClipToPadding(false);
            this.listView.setDrawSelectorBehind(true);
            RecyclerListView recyclerListView3 = this.listView;
            ListAdapter listAdapter = new ListAdapter(context);
            this.adapter = listAdapter;
            recyclerListView3.setAdapter(listAdapter);
            this.listView.setOnItemClickListener(new RecyclerListView.OnItemClickListenerExtended() { // from class: ir.eitaa.ui.Components.-$$Lambda$ViewPagerFixed$TabsView$PicUI4c1-IZ1BFp-0_5-Ghdk-BY
                @Override // ir.eitaa.ui.Components.RecyclerListView.OnItemClickListenerExtended
                public final void onItemClick(View view, int i, float f, float f2) {
                    this.f$0.lambda$new$0$ViewPagerFixed$TabsView(view, i, f, f2);
                }
            });
            this.listView.setOnScrollListener(new RecyclerView.OnScrollListener() { // from class: ir.eitaa.ui.Components.ViewPagerFixed.TabsView.4
                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                    TabsView.this.invalidate();
                }
            });
            addView(this.listView, LayoutHelper.createFrame(-1, 50.0f));
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$0$ViewPagerFixed$TabsView(View view, int i, float f, float f2) {
            TabsViewDelegate tabsViewDelegate;
            if (this.delegate.canPerformActions()) {
                TabView tabView = (TabView) view;
                if (i == this.currentPosition && (tabsViewDelegate = this.delegate) != null) {
                    tabsViewDelegate.onSamePageSelected();
                    return;
                }
                if (!LocaleController.isRTL) {
                    if (i == 5 && DialogsActivity.lastSearchString_.equals("")) {
                        return;
                    }
                    if (i == 5 && !DialogsActivity.lastSearchString_.equals("")) {
                        try {
                            Browser.openUrl(getContext(), Uri.parse("https://search.eitaa.com/search").buildUpon().appendQueryParameter("q", DialogsActivity.lastSearchString_).build().toString(), true);
                            return;
                        } catch (Exception e) {
                            FileLog.e(e);
                            return;
                        }
                    }
                } else {
                    if (i == 0 && DialogsActivity.lastSearchString_.equals("")) {
                        return;
                    }
                    if (i == 0 && !DialogsActivity.lastSearchString_.equals("")) {
                        try {
                            Browser.openUrl(getContext(), Uri.parse("https://search.eitaa.com/search").buildUpon().appendQueryParameter("q", DialogsActivity.lastSearchString_).build().toString(), true);
                            return;
                        } catch (Exception e2) {
                            FileLog.e(e2);
                            return;
                        }
                    }
                }
                scrollToTab(tabView.currentTab.id, i);
            }
        }

        public void setDelegate(TabsViewDelegate filterTabsViewDelegate) {
            this.delegate = filterTabsViewDelegate;
        }

        public boolean isAnimatingIndicator() {
            return this.animatingIndicator;
        }

        public void scrollToTab(int id, int position) {
            int i = this.currentPosition;
            boolean z = i < position;
            this.scrollingToChild = -1;
            this.previousPosition = i;
            this.previousId = this.selectedTabId;
            this.currentPosition = position;
            this.selectedTabId = id;
            ValueAnimator valueAnimator = this.tabsAnimator;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            if (this.animatingIndicator) {
                this.animatingIndicator = false;
            }
            this.animationTime = 0.0f;
            this.animatingIndicatorProgress = 0.0f;
            this.animatingIndicator = true;
            setEnabled(false);
            TabsViewDelegate tabsViewDelegate = this.delegate;
            if (tabsViewDelegate != null) {
                tabsViewDelegate.onPageSelected(id, z);
            }
            scrollToChild(position);
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.tabsAnimator = valueAnimatorOfFloat;
            valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.eitaa.ui.Components.ViewPagerFixed.TabsView.5
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    float fFloatValue = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                    TabsView.this.setAnimationIdicatorProgress(fFloatValue);
                    if (TabsView.this.delegate != null) {
                        TabsView.this.delegate.onPageScrolled(fFloatValue);
                    }
                }
            });
            this.tabsAnimator.setDuration(250L);
            this.tabsAnimator.setInterpolator(CubicBezierInterpolator.DEFAULT);
            this.tabsAnimator.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.ViewPagerFixed.TabsView.6
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    TabsView.this.animatingIndicator = false;
                    TabsView.this.setEnabled(true);
                    if (TabsView.this.delegate != null) {
                        TabsView.this.delegate.onPageScrolled(1.0f);
                    }
                    TabsView.this.invalidate();
                }
            });
            this.tabsAnimator.start();
        }

        public void setAnimationIdicatorProgress(float value) {
            this.animatingIndicatorProgress = value;
            this.listView.invalidateViews();
            invalidate();
            TabsViewDelegate tabsViewDelegate = this.delegate;
            if (tabsViewDelegate != null) {
                tabsViewDelegate.onPageScrolled(value);
            }
        }

        public Drawable getSelectorDrawable() {
            return this.selectorDrawable;
        }

        public RecyclerListView getTabsContainer() {
            return this.listView;
        }

        public void addTab(int id, String text) {
            int size = this.tabs.size();
            if (size == 0 && this.selectedTabId == -1) {
                this.selectedTabId = id;
            }
            this.positionToId.put(size, id);
            this.idToPosition.put(id, size);
            int i = this.selectedTabId;
            if (i != -1 && i == id) {
                this.currentPosition = size;
            }
            Tab tab = new Tab(id, text);
            this.allTabsWidth += tab.getWidth(true, this.textPaint) + AndroidUtilities.dp(32.0f);
            this.tabs.add(tab);
        }

        public void removeTabs() {
            this.tabs.clear();
            this.positionToId.clear();
            this.idToPosition.clear();
            this.positionToWidth.clear();
            this.positionToX.clear();
            this.allTabsWidth = 0;
        }

        public int getCurrentTabId() {
            return this.selectedTabId;
        }

        public int getFirstTabId() {
            return this.positionToId.get(0, 0);
        }

        private void updateTabsWidths() {
            this.positionToX.clear();
            this.positionToWidth.clear();
            int iDp = AndroidUtilities.dp(7.0f);
            int size = this.tabs.size();
            for (int i = 0; i < size; i++) {
                int width = this.tabs.get(i).getWidth(false, this.textPaint);
                this.positionToWidth.put(i, width);
                this.positionToX.put(i, (this.additionalTabWidth / 2) + iDp);
                iDp += width + AndroidUtilities.dp(32.0f) + this.additionalTabWidth;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x008a  */
        /* JADX WARN: Removed duplicated region for block: B:42:0x00fe  */
        /* JADX WARN: Removed duplicated region for block: B:68:0x01cc  */
        @Override // android.view.ViewGroup
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        protected boolean drawChild(android.graphics.Canvas r17, android.view.View r18, long r19) {
            /*
                Method dump skipped, instructions count: 480
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Components.ViewPagerFixed.TabsView.drawChild(android.graphics.Canvas, android.view.View, long):boolean");
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            if (!this.tabs.isEmpty()) {
                int size = (View.MeasureSpec.getSize(widthMeasureSpec) - AndroidUtilities.dp(7.0f)) - AndroidUtilities.dp(7.0f);
                int i = this.additionalTabWidth;
                int i2 = this.allTabsWidth;
                int size2 = i2 < size ? (size - i2) / this.tabs.size() : 0;
                this.additionalTabWidth = size2;
                if (i != size2) {
                    this.ignoreLayout = true;
                    this.adapter.notifyDataSetChanged();
                    this.ignoreLayout = false;
                }
                updateTabsWidths();
                this.invalidated = false;
            }
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }

        public void updateColors() {
            this.selectorDrawable.setColor(Theme.getColor(this.tabLineColorKey));
            this.listView.invalidateViews();
            this.listView.invalidate();
            invalidate();
        }

        @Override // android.view.View, android.view.ViewParent
        public void requestLayout() {
            if (this.ignoreLayout) {
                return;
            }
            super.requestLayout();
        }

        private void scrollToChild(int position) {
            if (this.tabs.isEmpty() || this.scrollingToChild == position || position < 0 || position >= this.tabs.size()) {
                return;
            }
            this.scrollingToChild = position;
            this.listView.scrollToPosition(position);
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean changed, int l, int t, int r, int b) {
            super.onLayout(changed, l, t, r, b);
            int i = r - l;
            if (this.prevLayoutWidth != i) {
                this.prevLayoutWidth = i;
                this.scrollingToChild = -1;
                if (this.animatingIndicator) {
                    AndroidUtilities.cancelRunOnUIThread(this.animationRunnable);
                    this.animatingIndicator = false;
                    setEnabled(true);
                    TabsViewDelegate tabsViewDelegate = this.delegate;
                    if (tabsViewDelegate != null) {
                        tabsViewDelegate.onPageScrolled(1.0f);
                    }
                }
            }
        }

        public void selectTab(int currentPosition, int nextPosition, float progress) {
            if (progress < 0.0f) {
                progress = 0.0f;
            } else if (progress > 1.0f) {
                progress = 1.0f;
            }
            this.currentPosition = currentPosition;
            this.selectedTabId = this.positionToId.get(currentPosition);
            if (progress > 0.0f) {
                this.manualScrollingToPosition = nextPosition;
                this.manualScrollingToId = this.positionToId.get(nextPosition);
            } else {
                this.manualScrollingToPosition = -1;
                this.manualScrollingToId = -1;
            }
            this.animatingIndicatorProgress = progress;
            this.listView.invalidateViews();
            invalidate();
            scrollToChild(currentPosition);
            if (progress >= 1.0f) {
                this.manualScrollingToPosition = -1;
                this.manualScrollingToId = -1;
                this.currentPosition = nextPosition;
                this.selectedTabId = this.positionToId.get(nextPosition);
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
            if (progress > 0.0f) {
                this.manualScrollingToPosition = i;
                this.manualScrollingToId = id;
            } else {
                this.manualScrollingToPosition = -1;
                this.manualScrollingToId = -1;
            }
            this.animatingIndicatorProgress = progress;
            this.listView.invalidateViews();
            invalidate();
            scrollToChild(i);
            if (progress >= 1.0f) {
                this.manualScrollingToPosition = -1;
                this.manualScrollingToId = -1;
                this.currentPosition = i;
                this.selectedTabId = id;
            }
        }

        public void setIsEditing(boolean value) {
            this.isEditing = value;
            this.editingForwardAnimation = true;
            this.listView.invalidateViews();
            invalidate();
            if (this.isEditing || !this.orderChanged) {
                return;
            }
            MessagesStorage.getInstance(UserConfig.selectedAccount).saveDialogFiltersOrder();
            TLRPC$TL_messages_updateDialogFiltersOrder tLRPC$TL_messages_updateDialogFiltersOrder = new TLRPC$TL_messages_updateDialogFiltersOrder();
            ArrayList<MessagesController.DialogFilter> arrayList = MessagesController.getInstance(UserConfig.selectedAccount).dialogFilters;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                arrayList.get(i);
                tLRPC$TL_messages_updateDialogFiltersOrder.order.add(Integer.valueOf(arrayList.get(i).id));
            }
            ConnectionsManager.getInstance(UserConfig.selectedAccount).sendRequest(tLRPC$TL_messages_updateDialogFiltersOrder, new RequestDelegate() { // from class: ir.eitaa.ui.Components.-$$Lambda$ViewPagerFixed$TabsView$yEFm9IV-uXjAhcL5thJek_dTrLc
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    ViewPagerFixed.TabsView.lambda$setIsEditing$1(tLObject, tLRPC$TL_error);
                }
            });
            this.orderChanged = false;
        }

        private class ListAdapter extends RecyclerListView.SelectionAdapter {
            private Context mContext;

            @Override // androidx.recyclerview.widget.RecyclerView.Adapter
            public long getItemId(int i) {
                return i;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.Adapter
            public int getItemViewType(int i) {
                return 0;
            }

            @Override // ir.eitaa.ui.Components.RecyclerListView.SelectionAdapter
            public boolean isEnabled(RecyclerView.ViewHolder holder) {
                return true;
            }

            public ListAdapter(Context context) {
                this.mContext = context;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.Adapter
            public int getItemCount() {
                return TabsView.this.tabs.size();
            }

            @Override // androidx.recyclerview.widget.RecyclerView.Adapter
            public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                return new RecyclerListView.Holder(TabsView.this.new TabView(this.mContext));
            }

            @Override // androidx.recyclerview.widget.RecyclerView.Adapter
            public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
                ((TabView) holder.itemView).setTab((Tab) TabsView.this.tabs.get(position), position);
            }
        }

        public void hide(boolean hide, boolean animated) {
            this.isInHiddenMode = hide;
            int i = 0;
            if (animated) {
                while (i < this.listView.getChildCount()) {
                    this.listView.getChildAt(i).animate().alpha(hide ? 0.0f : 1.0f).scaleX(hide ? 0.0f : 1.0f).scaleY(hide ? 0.0f : 1.0f).setInterpolator(CubicBezierInterpolator.DEFAULT).setDuration(220L).start();
                    i++;
                }
            } else {
                while (i < this.listView.getChildCount()) {
                    View childAt = this.listView.getChildAt(i);
                    childAt.setScaleX(hide ? 0.0f : 1.0f);
                    childAt.setScaleY(hide ? 0.0f : 1.0f);
                    childAt.setAlpha(hide ? 0.0f : 1.0f);
                    i++;
                }
                this.hideProgress = hide ? 1.0f : 0.0f;
            }
            invalidate();
        }
    }

    private View findScrollingChild(ViewGroup parent, float x, float y) {
        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = parent.getChildAt(i);
            if (childAt.getVisibility() == 0) {
                childAt.getHitRect(this.rect);
                if (!this.rect.contains((int) x, (int) y)) {
                    continue;
                } else {
                    if (childAt.canScrollHorizontally(-1)) {
                        return childAt;
                    }
                    if (childAt instanceof ViewGroup) {
                        android.graphics.Rect rect = this.rect;
                        View viewFindScrollingChild = findScrollingChild((ViewGroup) childAt, x - rect.left, y - rect.top);
                        if (viewFindScrollingChild != null) {
                            return viewFindScrollingChild;
                        }
                    } else {
                        continue;
                    }
                }
            }
        }
        return null;
    }
}
