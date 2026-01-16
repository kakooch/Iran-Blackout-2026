package ir.eitaa.ui.Components;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.SystemClock;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.Property;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import androidx.core.graphics.ColorUtils;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.Emoji;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.messenger.MessagesStorage;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.UserConfig;
import ir.eitaa.tgnet.ConnectionsManager;
import ir.eitaa.tgnet.RequestDelegate;
import ir.eitaa.tgnet.TLObject;
import ir.eitaa.tgnet.TLRPC$TL_error;
import ir.eitaa.tgnet.TLRPC$TL_messages_updateDialogFiltersOrder;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Components.AnimationProperties;
import ir.eitaa.ui.Components.FilterTabsView;
import ir.eitaa.ui.Components.RecyclerListView;
import java.util.ArrayList;
import java.util.Collections;

/* loaded from: classes3.dex */
public class FilterTabsView extends FrameLayout {
    private final Property<FilterTabsView, Float> COLORS;
    private String aActiveTextColorKey;
    private String aBackgroundColorKey;
    private String aTabLineColorKey;
    private String aUnactiveTextColorKey;
    private String activeTextColorKey;
    private ListAdapter adapter;
    private int additionalTabWidth;
    private int allTabsWidth;
    private boolean animatingIndicator;
    private float animatingIndicatorProgress;
    private Runnable animationRunnable;
    private float animationTime;
    private float animationValue;
    private String backgroundColorKey;
    private AnimatorSet colorChangeAnimator;
    private Paint counterPaint;
    private int currentPosition;
    private FilterTabsViewDelegate delegate;
    private Paint deletePaint;
    private float editingAnimationProgress;
    private boolean editingForwardAnimation;
    private float editingStartAnimationProgress;
    private SparseIntArray idToPosition;
    private boolean ignoreLayout;
    private CubicBezierInterpolator interpolator;
    private boolean invalidated;
    private boolean isEditing;
    DefaultItemAnimator itemAnimator;
    private long lastAnimationTime;
    private long lastEditingAnimationTime;
    private LinearLayoutManager layoutManager;
    private RecyclerListView listView;
    private int manualScrollingToId;
    private int manualScrollingToPosition;
    private boolean orderChanged;
    private SparseIntArray positionToId;
    private SparseIntArray positionToStableId;
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
    private TextPaint textCounterPaint;
    private TextPaint textPaint;
    private String unactiveTextColorKey;

    public interface FilterTabsViewDelegate {
        boolean canPerformActions();

        boolean didSelectTab(TabView tabView, boolean selected);

        int getTabCounter(int tabId);

        boolean isTabMenuVisible();

        void onDeletePressed(int id);

        void onPageReorder(int fromId, int toId);

        void onPageScrolled(float progress);

        void onPageSelected(int page, boolean forward);

        void onSamePageSelected();
    }

    static /* synthetic */ void lambda$setIsEditing$2(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
    }

    static /* synthetic */ float access$2316(FilterTabsView filterTabsView, float f) {
        float f2 = filterTabsView.animationTime + f;
        filterTabsView.animationTime = f2;
        return f2;
    }

    private class Tab {
        public int counter;
        public int id;
        public String title;
        public int titleWidth;

        public Tab(int i, String t) {
            this.id = i;
            this.title = t;
        }

        public int getWidth(boolean store) {
            int tabCounter;
            int iCeil = (int) Math.ceil(FilterTabsView.this.textPaint.measureText(this.title));
            this.titleWidth = iCeil;
            if (store) {
                tabCounter = FilterTabsView.this.delegate.getTabCounter(this.id);
                if (tabCounter < 0) {
                    tabCounter = 0;
                }
                if (store) {
                    this.counter = tabCounter;
                }
            } else {
                tabCounter = this.counter;
            }
            if (tabCounter > 0) {
                iCeil += Math.max(AndroidUtilities.dp(10.0f), (int) Math.ceil(FilterTabsView.this.textCounterPaint.measureText(String.format("%d", Integer.valueOf(tabCounter))))) + AndroidUtilities.dp(6.0f);
            }
            return Math.max(AndroidUtilities.dp(40.0f), iCeil);
        }
    }

    public class TabView extends View {
        public boolean animateChange;
        public boolean animateCounterChange;
        private float animateFromCountWidth;
        private float animateFromCounterWidth;
        int animateFromTabCount;
        private float animateFromTabWidth;
        float animateFromTextX;
        private int animateFromTitleWidth;
        private float animateFromWidth;
        boolean animateTabCounter;
        private boolean animateTabWidth;
        private boolean animateTextChange;
        private boolean animateTextChangeOut;
        boolean animateTextX;
        public ValueAnimator changeAnimator;
        public float changeProgress;
        private int currentPosition;
        private Tab currentTab;
        private String currentText;
        StaticLayout inCounter;
        private int lastCountWidth;
        private float lastCounterWidth;
        int lastTabCount;
        private float lastTabWidth;
        float lastTextX;
        String lastTitle;
        StaticLayout lastTitleLayout;
        private int lastTitleWidth;
        private float lastWidth;
        StaticLayout outCounter;
        private RectF rect;
        StaticLayout stableCounter;
        private int tabWidth;
        private int textHeight;
        private StaticLayout textLayout;
        private int textOffsetX;
        private StaticLayout titleAnimateInLayout;
        private StaticLayout titleAnimateOutLayout;
        private StaticLayout titleAnimateStableLayout;
        private float titleXOffset;

        public TabView(Context context) {
            super(context);
            this.rect = new RectF();
            this.lastTabCount = -1;
        }

        public void setTab(Tab tab, int position) {
            this.currentTab = tab;
            this.currentPosition = position;
            setContentDescription(tab.title + " " + this.currentTab.counter + " " + LocaleController.getString("FilterUnread", R.string.FilterUnread));
            requestLayout();
        }

        @Override // android.view.View
        public int getId() {
            return this.currentTab.id;
        }

        @Override // android.view.View
        protected void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            this.animateChange = false;
            this.animateTabCounter = false;
            this.animateCounterChange = false;
            this.animateTextChange = false;
            this.animateTextX = false;
            this.animateTabWidth = false;
            ValueAnimator valueAnimator = this.changeAnimator;
            if (valueAnimator != null) {
                valueAnimator.removeAllListeners();
                this.changeAnimator.removeAllUpdateListeners();
                this.changeAnimator.cancel();
                this.changeAnimator = null;
            }
            invalidate();
        }

        @Override // android.view.View
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            setMeasuredDimension(this.currentTab.getWidth(false) + AndroidUtilities.dp(32.0f) + FilterTabsView.this.additionalTabWidth, View.MeasureSpec.getSize(heightMeasureSpec));
        }

        /* JADX WARN: Removed duplicated region for block: B:170:0x04fc  */
        /* JADX WARN: Removed duplicated region for block: B:196:0x05a1  */
        /* JADX WARN: Removed duplicated region for block: B:197:0x05ac  */
        /* JADX WARN: Removed duplicated region for block: B:200:0x05b2  */
        /* JADX WARN: Removed duplicated region for block: B:203:0x05f1  */
        /* JADX WARN: Removed duplicated region for block: B:206:0x0631  */
        @Override // android.view.View
        @android.annotation.SuppressLint({"DrawAllocation"})
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        protected void onDraw(android.graphics.Canvas r30) {
            /*
                Method dump skipped, instructions count: 1922
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Components.FilterTabsView.TabView.onDraw(android.graphics.Canvas):void");
        }

        public boolean animateChange() {
            boolean z;
            String str;
            int iMax;
            String str2;
            String str3;
            boolean z2;
            int i = this.currentTab.counter;
            int i2 = this.lastTabCount;
            if (i != i2) {
                this.animateTabCounter = true;
                this.animateFromTabCount = i2;
                this.animateFromCountWidth = this.lastCountWidth;
                this.animateFromCounterWidth = this.lastCounterWidth;
                if (i2 > 0 && i > 0) {
                    String strFixNumbers = LocaleController.isRTL ? AndroidUtilities.fixNumbers(String.valueOf(i2)) : String.valueOf(i2);
                    String strFixNumbers2 = LocaleController.isRTL ? AndroidUtilities.fixNumbers(String.valueOf(this.currentTab.counter)) : String.valueOf(this.currentTab.counter);
                    if (strFixNumbers.length() == strFixNumbers2.length()) {
                        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(strFixNumbers);
                        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(strFixNumbers2);
                        SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder(strFixNumbers2);
                        for (int i3 = 0; i3 < strFixNumbers.length(); i3++) {
                            if (strFixNumbers.charAt(i3) == strFixNumbers2.charAt(i3)) {
                                int i4 = i3 + 1;
                                spannableStringBuilder.setSpan(new EmptyStubSpan(), i3, i4, 0);
                                spannableStringBuilder2.setSpan(new EmptyStubSpan(), i3, i4, 0);
                            } else {
                                spannableStringBuilder3.setSpan(new EmptyStubSpan(), i3, i3 + 1, 0);
                            }
                        }
                        int iCeil = (int) Math.ceil(Theme.dialogs_countTextPaint.measureText(strFixNumbers));
                        this.outCounter = new StaticLayout(spannableStringBuilder, FilterTabsView.this.textCounterPaint, iCeil, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
                        this.stableCounter = new StaticLayout(spannableStringBuilder3, FilterTabsView.this.textCounterPaint, iCeil, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
                        this.inCounter = new StaticLayout(spannableStringBuilder2, FilterTabsView.this.textCounterPaint, iCeil, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
                    } else {
                        this.outCounter = new StaticLayout(strFixNumbers, FilterTabsView.this.textCounterPaint, (int) Math.ceil(Theme.dialogs_countTextPaint.measureText(strFixNumbers)), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
                        this.inCounter = new StaticLayout(strFixNumbers2, FilterTabsView.this.textCounterPaint, (int) Math.ceil(Theme.dialogs_countTextPaint.measureText(strFixNumbers2)), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
                    }
                }
                z = true;
            } else {
                z = false;
            }
            int i5 = this.currentTab.counter;
            if (i5 > 0) {
                str = String.format("%d", Integer.valueOf(i5));
                iMax = Math.max(AndroidUtilities.dp(10.0f), (int) Math.ceil(FilterTabsView.this.textCounterPaint.measureText(str))) + AndroidUtilities.dp(10.0f);
            } else {
                str = null;
                iMax = 0;
            }
            int iDp = this.currentTab.titleWidth + (iMax != 0 ? iMax + AndroidUtilities.dp((str != null ? 1.0f : FilterTabsView.this.editingStartAnimationProgress) * 6.0f) : 0);
            float measuredWidth = (getMeasuredWidth() - iDp) / 2;
            float f = this.lastTextX;
            if (measuredWidth != f) {
                this.animateTextX = true;
                this.animateFromTextX = f;
                z = true;
            }
            String str4 = this.lastTitle;
            if (str4 != null && !this.currentTab.title.equals(str4)) {
                if (this.lastTitle.length() > this.currentTab.title.length()) {
                    str2 = this.lastTitle;
                    str3 = this.currentTab.title;
                    z2 = true;
                } else {
                    str2 = this.currentTab.title;
                    str3 = this.lastTitle;
                    z2 = false;
                }
                int iIndexOf = str2.indexOf(str3);
                if (iIndexOf >= 0) {
                    CharSequence charSequenceReplaceEmoji = Emoji.replaceEmoji(str2, FilterTabsView.this.textPaint.getFontMetricsInt(), AndroidUtilities.dp(15.0f), false);
                    SpannableStringBuilder spannableStringBuilder4 = new SpannableStringBuilder(charSequenceReplaceEmoji);
                    SpannableStringBuilder spannableStringBuilder5 = new SpannableStringBuilder(charSequenceReplaceEmoji);
                    if (iIndexOf != 0) {
                        spannableStringBuilder5.setSpan(new EmptyStubSpan(), 0, iIndexOf, 0);
                    }
                    if (str3.length() + iIndexOf != str2.length()) {
                        spannableStringBuilder5.setSpan(new EmptyStubSpan(), str3.length() + iIndexOf, str2.length(), 0);
                    }
                    spannableStringBuilder4.setSpan(new EmptyStubSpan(), iIndexOf, str3.length() + iIndexOf, 0);
                    this.titleAnimateInLayout = new StaticLayout(spannableStringBuilder4, FilterTabsView.this.textPaint, AndroidUtilities.dp(400.0f), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
                    StaticLayout staticLayout = new StaticLayout(spannableStringBuilder5, FilterTabsView.this.textPaint, AndroidUtilities.dp(400.0f), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
                    this.titleAnimateStableLayout = staticLayout;
                    this.animateTextChange = true;
                    this.animateTextChangeOut = z2;
                    this.titleXOffset = iIndexOf != 0 ? -staticLayout.getPrimaryHorizontal(iIndexOf) : 0.0f;
                    this.animateFromTitleWidth = this.lastTitleWidth;
                    this.titleAnimateOutLayout = null;
                } else {
                    this.titleAnimateInLayout = new StaticLayout(this.currentTab.title, FilterTabsView.this.textPaint, AndroidUtilities.dp(400.0f), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
                    this.titleAnimateOutLayout = new StaticLayout(this.lastTitle, FilterTabsView.this.textPaint, AndroidUtilities.dp(400.0f), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
                    this.titleAnimateStableLayout = null;
                    this.animateTextChange = true;
                    this.titleXOffset = 0.0f;
                    this.animateFromTitleWidth = this.lastTitleWidth;
                }
                z = true;
            }
            if (iDp == this.lastTabWidth && getMeasuredWidth() == this.lastWidth) {
                return z;
            }
            this.animateTabWidth = true;
            this.animateFromTabWidth = this.lastTabWidth;
            this.animateFromWidth = this.lastWidth;
            return true;
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
            super.onInitializeAccessibilityNodeInfo(info);
            info.setSelected((this.currentTab == null || FilterTabsView.this.selectedTabId == -1 || this.currentTab.id != FilterTabsView.this.selectedTabId) ? false : true);
            info.addAction(16);
            if (Build.VERSION.SDK_INT >= 21) {
                info.addAction(new AccessibilityNodeInfo.AccessibilityAction(32, LocaleController.getString("AccDescrOpenMenu2", R.string.AccDescrOpenMenu2)));
            } else {
                info.addAction(32);
            }
        }

        public void clearTransitionParams() {
            this.animateChange = false;
            this.animateTabCounter = false;
            this.animateCounterChange = false;
            this.animateTextChange = false;
            this.animateTextX = false;
            this.animateTabWidth = false;
            this.changeAnimator = null;
            invalidate();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FilterTabsView(Context context) {
        super(context);
        this.textPaint = new TextPaint(1);
        this.textCounterPaint = new TextPaint(1);
        this.deletePaint = new TextPaint(1);
        this.counterPaint = new Paint(1);
        this.tabs = new ArrayList<>();
        this.selectedTabId = -1;
        this.manualScrollingToPosition = -1;
        this.manualScrollingToId = -1;
        this.scrollingToChild = -1;
        this.tabLineColorKey = "actionBarTabLine";
        this.activeTextColorKey = "actionBarTabActiveText";
        this.unactiveTextColorKey = "actionBarTabUnactiveText";
        this.selectorColorKey = "actionBarTabSelector";
        this.backgroundColorKey = "actionBarDefault";
        this.interpolator = CubicBezierInterpolator.EASE_OUT_QUINT;
        this.positionToId = new SparseIntArray(5);
        this.positionToStableId = new SparseIntArray(5);
        this.idToPosition = new SparseIntArray(5);
        this.positionToWidth = new SparseIntArray(5);
        this.positionToX = new SparseIntArray(5);
        this.animationRunnable = new Runnable() { // from class: ir.eitaa.ui.Components.FilterTabsView.1
            @Override // java.lang.Runnable
            public void run() {
                if (FilterTabsView.this.animatingIndicator) {
                    long jElapsedRealtime = SystemClock.elapsedRealtime() - FilterTabsView.this.lastAnimationTime;
                    if (jElapsedRealtime > 17) {
                        jElapsedRealtime = 17;
                    }
                    FilterTabsView.access$2316(FilterTabsView.this, jElapsedRealtime / 200.0f);
                    FilterTabsView filterTabsView = FilterTabsView.this;
                    filterTabsView.setAnimationIdicatorProgress(filterTabsView.interpolator.getInterpolation(FilterTabsView.this.animationTime));
                    if (FilterTabsView.this.animationTime > 1.0f) {
                        FilterTabsView.this.animationTime = 1.0f;
                    }
                    if (FilterTabsView.this.animationTime < 1.0f) {
                        AndroidUtilities.runOnUIThread(FilterTabsView.this.animationRunnable);
                        return;
                    }
                    FilterTabsView.this.animatingIndicator = false;
                    FilterTabsView.this.setEnabled(true);
                    if (FilterTabsView.this.delegate != null) {
                        FilterTabsView.this.delegate.onPageScrolled(1.0f);
                    }
                }
            }
        };
        this.COLORS = new AnimationProperties.FloatProperty<FilterTabsView>("animationValue") { // from class: ir.eitaa.ui.Components.FilterTabsView.2
            @Override // ir.eitaa.ui.Components.AnimationProperties.FloatProperty
            public void setValue(FilterTabsView object, float value) {
                FilterTabsView.this.animationValue = value;
                FilterTabsView.this.selectorDrawable.setColor(ColorUtils.blendARGB(Theme.getColor(FilterTabsView.this.tabLineColorKey), Theme.getColor(FilterTabsView.this.aTabLineColorKey), value));
                FilterTabsView.this.listView.invalidateViews();
                FilterTabsView.this.listView.invalidate();
                object.invalidate();
            }

            @Override // android.util.Property
            public Float get(FilterTabsView object) {
                return Float.valueOf(FilterTabsView.this.animationValue);
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
        RecyclerListView recyclerListView = new RecyclerListView(context) { // from class: ir.eitaa.ui.Components.FilterTabsView.3
            @Override // android.view.View
            public void setAlpha(float alpha) {
                super.setAlpha(alpha);
                FilterTabsView.this.invalidate();
            }

            @Override // ir.eitaa.ui.Components.RecyclerListView
            protected boolean allowSelectChildAtPosition(View child) {
                return FilterTabsView.this.isEnabled() && FilterTabsView.this.delegate.canPerformActions();
            }

            @Override // ir.eitaa.ui.Components.RecyclerListView
            protected boolean canHighlightChildAt(View child, float x, float y) {
                if (FilterTabsView.this.isEditing) {
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
        recyclerListView.setClipChildren(false);
        AnonymousClass4 anonymousClass4 = new AnonymousClass4();
        this.itemAnimator = anonymousClass4;
        anonymousClass4.setDelayAnimations(false);
        this.listView.setItemAnimator(this.itemAnimator);
        this.listView.setSelectorType(7);
        this.listView.setSelectorDrawableColor(Theme.getColor(this.selectorColorKey));
        RecyclerListView recyclerListView2 = this.listView;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, 0, 0 == true ? 1 : 0) { // from class: ir.eitaa.ui.Components.FilterTabsView.5
            @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
            public boolean supportsPredictiveItemAnimations() {
                return true;
            }

            @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
            public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int position) {
                LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(recyclerView.getContext()) { // from class: ir.eitaa.ui.Components.FilterTabsView.5.1
                    @Override // androidx.recyclerview.widget.LinearSmoothScroller, androidx.recyclerview.widget.RecyclerView.SmoothScroller
                    protected void onTargetFound(View targetView, RecyclerView.State state2, RecyclerView.SmoothScroller.Action action) {
                        int iCalculateDxToMakeVisible = calculateDxToMakeVisible(targetView, getHorizontalSnapPreference());
                        if (iCalculateDxToMakeVisible > 0 || (iCalculateDxToMakeVisible == 0 && targetView.getLeft() - AndroidUtilities.dp(21.0f) < 0)) {
                            iCalculateDxToMakeVisible += AndroidUtilities.dp(60.0f);
                        } else if (iCalculateDxToMakeVisible < 0 || (iCalculateDxToMakeVisible == 0 && targetView.getRight() + AndroidUtilities.dp(21.0f) > FilterTabsView.this.getMeasuredWidth())) {
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

            @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
            public int scrollHorizontallyBy(int dx, RecyclerView.Recycler recycler, RecyclerView.State state) {
                if (FilterTabsView.this.delegate.isTabMenuVisible()) {
                    dx = 0;
                }
                return super.scrollHorizontallyBy(dx, recycler, state);
            }
        };
        this.layoutManager = linearLayoutManager;
        recyclerListView2.setLayoutManager(linearLayoutManager);
        new ItemTouchHelper(new TouchHelperCallback()).attachToRecyclerView(this.listView);
        this.listView.setPadding(AndroidUtilities.dp(7.0f), 0, AndroidUtilities.dp(7.0f), 0);
        this.listView.setClipToPadding(false);
        this.listView.setDrawSelectorBehind(true);
        ListAdapter listAdapter = new ListAdapter(context);
        this.adapter = listAdapter;
        listAdapter.setHasStableIds(true);
        this.listView.setAdapter(this.adapter);
        this.listView.setOnItemClickListener(new RecyclerListView.OnItemClickListenerExtended() { // from class: ir.eitaa.ui.Components.-$$Lambda$FilterTabsView$n4Ot0jrn-_3XRdaS4knQGh16xX8
            @Override // ir.eitaa.ui.Components.RecyclerListView.OnItemClickListenerExtended
            public final void onItemClick(View view, int i, float f, float f2) {
                this.f$0.lambda$new$0$FilterTabsView(view, i, f, f2);
            }
        });
        this.listView.setOnItemLongClickListener(new RecyclerListView.OnItemLongClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$FilterTabsView$G343A9Zzu-9Ceuu6u_uaIoWi1Qg
            @Override // ir.eitaa.ui.Components.RecyclerListView.OnItemLongClickListener
            public final boolean onItemClick(View view, int i) {
                return this.f$0.lambda$new$1$FilterTabsView(view, i);
            }
        });
        this.listView.setOnScrollListener(new RecyclerView.OnScrollListener() { // from class: ir.eitaa.ui.Components.FilterTabsView.6
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                FilterTabsView.this.invalidate();
            }
        });
        addView(this.listView, LayoutHelper.createFrame(-1, -1.0f));
    }

    /* renamed from: ir.eitaa.ui.Components.FilterTabsView$4, reason: invalid class name */
    class AnonymousClass4 extends DefaultItemAnimator {
        AnonymousClass4() {
        }

        @Override // androidx.recyclerview.widget.DefaultItemAnimator, androidx.recyclerview.widget.RecyclerView.ItemAnimator
        public void runPendingAnimations() {
            boolean z = !this.mPendingRemovals.isEmpty();
            boolean z2 = !this.mPendingMoves.isEmpty();
            boolean z3 = !this.mPendingChanges.isEmpty();
            boolean z4 = !this.mPendingAdditions.isEmpty();
            if (z || z2 || z4 || z3) {
                ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.1f);
                valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$FilterTabsView$4$SWDhS-9RrPd0nySt1SoF9vgZxXM
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        this.f$0.lambda$runPendingAnimations$0$FilterTabsView$4(valueAnimator);
                    }
                });
                valueAnimatorOfFloat.setDuration(getMoveDuration());
                valueAnimatorOfFloat.start();
            }
            super.runPendingAnimations();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$runPendingAnimations$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$runPendingAnimations$0$FilterTabsView$4(ValueAnimator valueAnimator) {
            FilterTabsView.this.listView.invalidate();
            FilterTabsView.this.invalidate();
        }

        @Override // androidx.recyclerview.widget.DefaultItemAnimator, androidx.recyclerview.widget.SimpleItemAnimator
        public boolean animateMove(RecyclerView.ViewHolder holder, RecyclerView.ItemAnimator.ItemHolderInfo info, int fromX, int fromY, int toX, int toY) {
            View view = holder.itemView;
            if (view instanceof TabView) {
                int translationX = fromX + ((int) view.getTranslationX());
                int translationY = fromY + ((int) holder.itemView.getTranslationY());
                resetAnimation(holder);
                int i = toX - translationX;
                int i2 = toY - translationY;
                if (i != 0) {
                    view.setTranslationX(-i);
                }
                if (i2 != 0) {
                    view.setTranslationY(-i2);
                }
                TabView tabView = (TabView) holder.itemView;
                boolean zAnimateChange = tabView.animateChange();
                if (zAnimateChange) {
                    tabView.changeProgress = 0.0f;
                    tabView.animateChange = true;
                    FilterTabsView.this.invalidate();
                }
                if (i == 0 && i2 == 0 && !zAnimateChange) {
                    dispatchMoveFinished(holder);
                    return false;
                }
                this.mPendingMoves.add(new DefaultItemAnimator.MoveInfo(holder, translationX, translationY, toX, toY));
                return true;
            }
            return super.animateMove(holder, info, fromX, fromY, toX, toY);
        }

        @Override // androidx.recyclerview.widget.DefaultItemAnimator
        protected void animateMoveImpl(RecyclerView.ViewHolder holder, DefaultItemAnimator.MoveInfo moveInfo) {
            super.animateMoveImpl(holder, moveInfo);
            View view = holder.itemView;
            if (view instanceof TabView) {
                final TabView tabView = (TabView) view;
                if (tabView.animateChange) {
                    ValueAnimator valueAnimator = tabView.changeAnimator;
                    if (valueAnimator != null) {
                        valueAnimator.removeAllListeners();
                        tabView.changeAnimator.removeAllUpdateListeners();
                        tabView.changeAnimator.cancel();
                    }
                    ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
                    valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$FilterTabsView$4$kL_3S6gU5eVGIS0g_E4mzXl0TF8
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                            FilterTabsView.AnonymousClass4.lambda$animateMoveImpl$1(tabView, valueAnimator2);
                        }
                    });
                    valueAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.FilterTabsView.4.1
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animation) {
                            tabView.clearTransitionParams();
                        }
                    });
                    tabView.changeAnimator = valueAnimatorOfFloat;
                    valueAnimatorOfFloat.setDuration(getMoveDuration());
                    valueAnimatorOfFloat.start();
                }
            }
        }

        static /* synthetic */ void lambda$animateMoveImpl$1(TabView tabView, ValueAnimator valueAnimator) {
            tabView.changeProgress = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            tabView.invalidate();
        }

        @Override // androidx.recyclerview.widget.SimpleItemAnimator
        public void onMoveFinished(RecyclerView.ViewHolder item) {
            super.onMoveFinished(item);
            item.itemView.setTranslationX(0.0f);
            View view = item.itemView;
            if (view instanceof TabView) {
                ((TabView) view).clearTransitionParams();
            }
        }

        @Override // androidx.recyclerview.widget.DefaultItemAnimator, androidx.recyclerview.widget.RecyclerView.ItemAnimator
        public void endAnimation(RecyclerView.ViewHolder item) {
            super.endAnimation(item);
            item.itemView.setTranslationX(0.0f);
            View view = item.itemView;
            if (view instanceof TabView) {
                ((TabView) view).clearTransitionParams();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$0$FilterTabsView(View view, int i, float f, float f2) {
        FilterTabsViewDelegate filterTabsViewDelegate;
        if (this.delegate.canPerformActions()) {
            TabView tabView = (TabView) view;
            if (this.isEditing) {
                if (LocaleController.isRTL) {
                    if (i == this.tabs.size() - 1) {
                        return;
                    }
                } else if (i == 0) {
                    return;
                }
                float fDp = AndroidUtilities.dp(6.0f);
                if (tabView.rect.left - fDp >= f || tabView.rect.right + fDp <= f) {
                    return;
                }
                this.delegate.onDeletePressed(tabView.currentTab.id);
                return;
            }
            if (i != this.currentPosition || (filterTabsViewDelegate = this.delegate) == null) {
                scrollToTab(tabView.currentTab.id, i);
            } else {
                filterTabsViewDelegate.onSamePageSelected();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean lambda$new$1$FilterTabsView(View view, int i) {
        if (this.delegate.canPerformActions() && !this.isEditing) {
            if (this.delegate.didSelectTab((TabView) view, i == this.currentPosition)) {
                this.listView.hideSelector(true);
                return true;
            }
        }
        return false;
    }

    public void setDelegate(FilterTabsViewDelegate filterTabsViewDelegate) {
        this.delegate = filterTabsViewDelegate;
    }

    public boolean isAnimatingIndicator() {
        return this.animatingIndicator;
    }

    private void scrollToTab(int id, int position) {
        int i = this.currentPosition;
        boolean z = i < position;
        this.scrollingToChild = -1;
        this.previousPosition = i;
        this.previousId = this.selectedTabId;
        this.currentPosition = position;
        this.selectedTabId = id;
        if (this.animatingIndicator) {
            AndroidUtilities.cancelRunOnUIThread(this.animationRunnable);
            this.animatingIndicator = false;
        }
        this.animationTime = 0.0f;
        this.animatingIndicatorProgress = 0.0f;
        this.animatingIndicator = true;
        setEnabled(false);
        AndroidUtilities.runOnUIThread(this.animationRunnable, 16L);
        FilterTabsViewDelegate filterTabsViewDelegate = this.delegate;
        if (filterTabsViewDelegate != null) {
            filterTabsViewDelegate.onPageSelected(id, z);
        }
        scrollToChild(position);
    }

    public void selectFirstTab() {
        if (LocaleController.isRTL) {
            scrollToTab(ConnectionsManager.DEFAULT_DATACENTER_ID, 7);
        } else {
            scrollToTab(ConnectionsManager.DEFAULT_DATACENTER_ID, 0);
        }
    }

    public void setAnimationIdicatorProgress(float value) {
        this.animatingIndicatorProgress = value;
        this.listView.invalidateViews();
        invalidate();
        FilterTabsViewDelegate filterTabsViewDelegate = this.delegate;
        if (filterTabsViewDelegate != null) {
            filterTabsViewDelegate.onPageScrolled(value);
        }
    }

    public Drawable getSelectorDrawable() {
        return this.selectorDrawable;
    }

    public RecyclerListView getTabsContainer() {
        return this.listView;
    }

    public int getNextPageId(boolean forward) {
        return this.positionToId.get(this.currentPosition + (forward ? 1 : -1), -1);
    }

    public void removeTabs() {
        this.tabs.clear();
        this.positionToId.clear();
        this.idToPosition.clear();
        this.positionToWidth.clear();
        this.positionToX.clear();
        this.allTabsWidth = 0;
    }

    public void resetTabId() {
        this.selectedTabId = -1;
    }

    public void addTab(int id, int stableId, String text) {
        int size = this.tabs.size();
        if (size == 0 && this.selectedTabId == -1) {
            this.selectedTabId = ConnectionsManager.DEFAULT_DATACENTER_ID;
        }
        this.positionToId.put(size, id);
        this.positionToStableId.put(size, stableId);
        this.idToPosition.put(id, size);
        int i = this.selectedTabId;
        if (i != -1 && i == id) {
            this.currentPosition = size;
        }
        Tab tab = new Tab(id, text);
        this.allTabsWidth += tab.getWidth(true) + AndroidUtilities.dp(32.0f);
        this.tabs.add(tab);
    }

    public void finishAddingTabs(boolean animated) {
        this.listView.setItemAnimator(animated ? this.itemAnimator : null);
        this.adapter.notifyDataSetChanged();
    }

    public void animateColorsTo(String line, String active, String unactive, String selector, String background) {
        AnimatorSet animatorSet = this.colorChangeAnimator;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        this.aTabLineColorKey = line;
        this.aActiveTextColorKey = active;
        this.aUnactiveTextColorKey = unactive;
        this.aBackgroundColorKey = background;
        this.selectorColorKey = selector;
        this.listView.setSelectorDrawableColor(Theme.getColor(selector));
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.colorChangeAnimator = animatorSet2;
        animatorSet2.playTogether(ObjectAnimator.ofFloat(this, this.COLORS, 0.0f, 1.0f));
        this.colorChangeAnimator.setDuration(200L);
        this.colorChangeAnimator.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.FilterTabsView.7
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                FilterTabsView filterTabsView = FilterTabsView.this;
                filterTabsView.tabLineColorKey = filterTabsView.aTabLineColorKey;
                FilterTabsView filterTabsView2 = FilterTabsView.this;
                filterTabsView2.backgroundColorKey = filterTabsView2.aBackgroundColorKey;
                FilterTabsView filterTabsView3 = FilterTabsView.this;
                filterTabsView3.activeTextColorKey = filterTabsView3.aActiveTextColorKey;
                FilterTabsView filterTabsView4 = FilterTabsView.this;
                filterTabsView4.unactiveTextColorKey = filterTabsView4.aUnactiveTextColorKey;
                FilterTabsView.this.aTabLineColorKey = null;
                FilterTabsView.this.aActiveTextColorKey = null;
                FilterTabsView.this.aUnactiveTextColorKey = null;
                FilterTabsView.this.aBackgroundColorKey = null;
            }
        });
        this.colorChangeAnimator.start();
    }

    public int getCurrentTabId() {
        return this.selectedTabId;
    }

    public int getFirstTabId() {
        return this.positionToId.get(0, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabsWidths() {
        this.positionToX.clear();
        this.positionToWidth.clear();
        int iDp = AndroidUtilities.dp(7.0f);
        int size = this.tabs.size();
        for (int i = 0; i < size; i++) {
            int width = this.tabs.get(i).getWidth(false);
            this.positionToWidth.put(i, width);
            this.positionToX.put(i, (this.additionalTabWidth / 2) + iDp);
            iDp += width + AndroidUtilities.dp(32.0f) + this.additionalTabWidth;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01da  */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected boolean drawChild(android.graphics.Canvas r10, android.view.View r11, long r12) {
        /*
            Method dump skipped, instructions count: 486
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Components.FilterTabsView.drawChild(android.graphics.Canvas, android.view.View, long):boolean");
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (!this.tabs.isEmpty()) {
            int size = (View.MeasureSpec.getSize(widthMeasureSpec) - AndroidUtilities.dp(7.0f)) - AndroidUtilities.dp(7.0f);
            Tab tab = this.tabs.get(0);
            int width = (this.allTabsWidth - tab.getWidth(false)) + tab.getWidth(false);
            int i = this.additionalTabWidth;
            int size2 = width < size ? (size - width) / this.tabs.size() : 0;
            this.additionalTabWidth = size2;
            if (i != size2) {
                this.ignoreLayout = true;
                RecyclerView.ItemAnimator itemAnimator = this.listView.getItemAnimator();
                this.listView.setItemAnimator(null);
                this.adapter.notifyDataSetChanged();
                this.listView.setItemAnimator(itemAnimator);
                this.ignoreLayout = false;
            }
            updateTabsWidths();
            this.invalidated = false;
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
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
        this.listView.smoothScrollToPosition(position);
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
                FilterTabsViewDelegate filterTabsViewDelegate = this.delegate;
                if (filterTabsViewDelegate != null) {
                    filterTabsViewDelegate.onPageScrolled(1.0f);
                }
            }
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

    public boolean isEditing() {
        return this.isEditing;
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
        ConnectionsManager.getInstance(UserConfig.selectedAccount).sendRequest(tLRPC$TL_messages_updateDialogFiltersOrder, new RequestDelegate() { // from class: ir.eitaa.ui.Components.-$$Lambda$FilterTabsView$txdJZYMC-0NTp1Qd3BCz9yUomHw
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                FilterTabsView.lambda$setIsEditing$2(tLObject, tLRPC$TL_error);
            }
        });
        this.orderChanged = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void checkTabsCounter() {
        /*
            r9 = this;
            java.util.ArrayList<ir.eitaa.ui.Components.FilterTabsView$Tab> r0 = r9.tabs
            int r0 = r0.size()
            r1 = 0
            r2 = 0
            r3 = 0
        L9:
            r4 = 1
            if (r2 >= r0) goto L67
            java.util.ArrayList<ir.eitaa.ui.Components.FilterTabsView$Tab> r5 = r9.tabs
            java.lang.Object r5 = r5.get(r2)
            ir.eitaa.ui.Components.FilterTabsView$Tab r5 = (ir.eitaa.ui.Components.FilterTabsView.Tab) r5
            int r6 = r5.counter
            ir.eitaa.ui.Components.FilterTabsView$FilterTabsViewDelegate r7 = r9.delegate
            int r8 = r5.id
            int r7 = r7.getTabCounter(r8)
            if (r6 == r7) goto L64
            ir.eitaa.ui.Components.FilterTabsView$FilterTabsViewDelegate r6 = r9.delegate
            int r7 = r5.id
            int r6 = r6.getTabCounter(r7)
            if (r6 >= 0) goto L2b
            goto L64
        L2b:
            android.util.SparseIntArray r3 = r9.positionToWidth
            int r3 = r3.get(r2)
            int r5 = r5.getWidth(r4)
            if (r3 != r5) goto L3e
            boolean r3 = r9.invalidated
            if (r3 == 0) goto L3c
            goto L3e
        L3c:
            r3 = 1
            goto L64
        L3e:
            r9.invalidated = r4
            r9.requestLayout()
            r9.allTabsWidth = r1
        L45:
            if (r1 >= r0) goto L62
            int r2 = r9.allTabsWidth
            java.util.ArrayList<ir.eitaa.ui.Components.FilterTabsView$Tab> r3 = r9.tabs
            java.lang.Object r3 = r3.get(r1)
            ir.eitaa.ui.Components.FilterTabsView$Tab r3 = (ir.eitaa.ui.Components.FilterTabsView.Tab) r3
            int r3 = r3.getWidth(r4)
            r5 = 1107296256(0x42000000, float:32.0)
            int r5 = ir.eitaa.messenger.AndroidUtilities.dp(r5)
            int r3 = r3 + r5
            int r2 = r2 + r3
            r9.allTabsWidth = r2
            int r1 = r1 + 1
            goto L45
        L62:
            r3 = 1
            goto L67
        L64:
            int r2 = r2 + 1
            goto L9
        L67:
            if (r3 == 0) goto L75
            ir.eitaa.ui.Components.RecyclerListView r0 = r9.listView
            androidx.recyclerview.widget.DefaultItemAnimator r1 = r9.itemAnimator
            r0.setItemAnimator(r1)
            ir.eitaa.ui.Components.FilterTabsView$ListAdapter r0 = r9.adapter
            r0.notifyDataSetChanged()
        L75:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Components.FilterTabsView.checkTabsCounter():void");
    }

    public void notifyTabCounterChanged(int id) {
        int i = this.idToPosition.get(id, -1);
        if (i < 0 || i >= this.tabs.size()) {
            return;
        }
        Tab tab = this.tabs.get(i);
        if (tab.counter == this.delegate.getTabCounter(tab.id) || this.delegate.getTabCounter(tab.id) < 0) {
            return;
        }
        this.listView.invalidateViews();
        if (this.positionToWidth.get(i) != tab.getWidth(true) || this.invalidated) {
            this.invalidated = true;
            requestLayout();
            this.listView.setItemAnimator(this.itemAnimator);
            this.adapter.notifyDataSetChanged();
            this.allTabsWidth = 0;
            int size = this.tabs.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.allTabsWidth += this.tabs.get(i2).getWidth(true) + AndroidUtilities.dp(32.0f);
            }
        }
    }

    private class ListAdapter extends RecyclerListView.SelectionAdapter {
        private Context mContext;

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
            return FilterTabsView.this.tabs.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public long getItemId(int position) {
            return FilterTabsView.this.positionToStableId.get(position);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new RecyclerListView.Holder(FilterTabsView.this.new TabView(this.mContext));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            ((TabView) holder.itemView).setTab((Tab) FilterTabsView.this.tabs.get(position), position);
        }

        public void swapElements(int fromIndex, int toIndex) {
            int size;
            int i;
            int i2;
            if (!LocaleController.isRTL) {
                i = fromIndex - 1;
                i2 = toIndex - 1;
                size = FilterTabsView.this.tabs.size() - 1;
            } else {
                size = FilterTabsView.this.tabs.size();
                i = fromIndex;
                i2 = toIndex;
            }
            if (i < 0 || i2 < 0 || i >= size || i2 >= size) {
                return;
            }
            ArrayList<MessagesController.DialogFilter> arrayList = MessagesController.getInstance(UserConfig.selectedAccount).dialogFilters;
            if (LocaleController.isRTL) {
                Collections.reverse(arrayList);
            }
            MessagesController.DialogFilter dialogFilter = arrayList.get(i);
            MessagesController.DialogFilter dialogFilter2 = arrayList.get(i2);
            int i3 = dialogFilter.order;
            dialogFilter.order = dialogFilter2.order;
            dialogFilter2.order = i3;
            arrayList.set(i, dialogFilter2);
            arrayList.set(i2, dialogFilter);
            Tab tab = (Tab) FilterTabsView.this.tabs.get(fromIndex);
            Tab tab2 = (Tab) FilterTabsView.this.tabs.get(toIndex);
            int i4 = tab.id;
            tab.id = tab2.id;
            tab2.id = i4;
            int i5 = FilterTabsView.this.positionToStableId.get(fromIndex);
            FilterTabsView.this.positionToStableId.put(fromIndex, FilterTabsView.this.positionToStableId.get(toIndex));
            FilterTabsView.this.positionToStableId.put(toIndex, i5);
            FilterTabsView.this.delegate.onPageReorder(tab2.id, tab.id);
            if (FilterTabsView.this.currentPosition == fromIndex) {
                FilterTabsView.this.currentPosition = toIndex;
                FilterTabsView.this.selectedTabId = tab.id;
            } else if (FilterTabsView.this.currentPosition == toIndex) {
                FilterTabsView.this.currentPosition = fromIndex;
                FilterTabsView.this.selectedTabId = tab2.id;
            }
            if (FilterTabsView.this.previousPosition == fromIndex) {
                FilterTabsView.this.previousPosition = toIndex;
                FilterTabsView.this.previousId = tab.id;
            } else if (FilterTabsView.this.previousPosition == toIndex) {
                FilterTabsView.this.previousPosition = fromIndex;
                FilterTabsView.this.previousId = tab2.id;
            }
            FilterTabsView.this.tabs.set(fromIndex, tab2);
            FilterTabsView.this.tabs.set(toIndex, tab);
            FilterTabsView.this.updateTabsWidths();
            FilterTabsView.this.orderChanged = true;
            FilterTabsView.this.listView.setItemAnimator(FilterTabsView.this.itemAnimator);
            notifyItemMoved(fromIndex, toIndex);
            if (LocaleController.isRTL) {
                Collections.reverse(arrayList);
            }
        }
    }

    public class TouchHelperCallback extends ItemTouchHelper.Callback {
        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        }

        public TouchHelperCallback() {
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public boolean isLongPressDragEnabled() {
            return FilterTabsView.this.isEditing;
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            if (!FilterTabsView.this.isEditing || (!LocaleController.isRTL ? viewHolder.getAdapterPosition() == 0 : viewHolder.getAdapterPosition() == 7)) {
                return ItemTouchHelper.Callback.makeMovementFlags(0, 0);
            }
            return ItemTouchHelper.Callback.makeMovementFlags(12, 0);
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder source, RecyclerView.ViewHolder target) {
            int size = MessagesController.getInstance(UserConfig.selectedAccount).dialogFilters.size();
            if (LocaleController.isRTL) {
                if (source.getAdapterPosition() == size || target.getAdapterPosition() == size) {
                    return false;
                }
            } else if (source.getAdapterPosition() == 0 || target.getAdapterPosition() == 0) {
                return false;
            }
            FilterTabsView.this.adapter.swapElements(source.getAdapterPosition(), target.getAdapterPosition());
            return true;
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int actionState) {
            if (actionState != 0) {
                FilterTabsView.this.listView.cancelClickRunnables(false);
                viewHolder.itemView.setPressed(true);
                viewHolder.itemView.setBackgroundColor(Theme.getColor(FilterTabsView.this.backgroundColorKey));
            }
            super.onSelectedChanged(viewHolder, actionState);
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            super.clearView(recyclerView, viewHolder);
            viewHolder.itemView.setPressed(false);
            viewHolder.itemView.setBackground(null);
        }
    }

    public RecyclerListView getListView() {
        return this.listView;
    }
}
