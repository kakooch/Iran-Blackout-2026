package ir.resaneh1.iptv.fragment.home.ad;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.stetho.websocket.CloseCodes;
import ir.resaneh1.iptv.UIView.CirclePagerIndicatorDecorationAdSection;
import ir.resaneh1.iptv.fragment.home.HomeCell;
import ir.resaneh1.iptv.fragment.rubino.RvUtilKt;
import ir.resaneh1.iptv.helper.VisibilityHelper;
import ir.resaneh1.iptv.logger.MyLog;
import ir.resaneh1.iptv.model.HomePageModels;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.Utilities;
import org.rbmain.ui.Components.LayoutHelper;
import org.rbmain.ui.Components.RecyclerListView;

/* compiled from: AdSectionCell.kt */
/* loaded from: classes3.dex */
public final class AdSectionCell extends HomeCell {
    private HomePageModels.HomePageSectionObject adSectionObject;
    private GridLayoutManager gridLayoutManager;
    public CirclePagerIndicatorDecorationAdSection indicator;
    private RecyclerListView listView;
    private AdSectionAdapter listViewAdapter;
    private int rowCount;
    private RecyclerView.OnScrollListener scrollListener;
    private final Runnable scrollRunnable;
    private PagerSnapHelper snapHelper;

    /* compiled from: AdSectionCell.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[HomePageModels.IndicatorSizeType.values().length];
            iArr[HomePageModels.IndicatorSizeType.Big.ordinal()] = 1;
            iArr[HomePageModels.IndicatorSizeType.Small.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    static {
        new Companion(null);
    }

    private final void resetPortrait() {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdSectionCell(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        new LinkedHashMap();
        this.rowCount = 1;
        this.scrollRunnable = new Runnable() { // from class: ir.resaneh1.iptv.fragment.home.ad.AdSectionCell$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                AdSectionCell.m454scrollRunnable$lambda9(this.f$0);
            }
        };
    }

    /* compiled from: AdSectionCell.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final CirclePagerIndicatorDecorationAdSection getIndicator() {
        CirclePagerIndicatorDecorationAdSection circlePagerIndicatorDecorationAdSection = this.indicator;
        if (circlePagerIndicatorDecorationAdSection != null) {
            return circlePagerIndicatorDecorationAdSection;
        }
        Intrinsics.throwUninitializedPropertyAccessException("indicator");
        return null;
    }

    public final void setIndicator(CirclePagerIndicatorDecorationAdSection circlePagerIndicatorDecorationAdSection) {
        Intrinsics.checkNotNullParameter(circlePagerIndicatorDecorationAdSection, "<set-?>");
        this.indicator = circlePagerIndicatorDecorationAdSection;
    }

    @Override // ir.resaneh1.iptv.fragment.home.HomeCell
    public View createMainView(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        setRadius(0.0f);
        if (Build.VERSION.SDK_INT >= 21) {
            setElevation(0.0f);
        }
        FrameLayout frameLayout = new FrameLayout(context);
        setWillNotDraw(false);
        initViews(context);
        RecyclerListView recyclerListView = this.listView;
        if (recyclerListView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listView");
            recyclerListView = null;
        }
        frameLayout.addView(recyclerListView, LayoutHelper.createFrame(-1, -2, 17));
        setBackgroundColor(0);
        return frameLayout;
    }

    private final void initViews(Context context) {
        this.listView = new RecyclerListView(context);
        this.gridLayoutManager = new GridLayoutManager(context, 1, 0, true);
        this.listViewAdapter = new AdSectionAdapter(context);
        RecyclerListView recyclerListView = this.listView;
        RecyclerView.OnScrollListener onScrollListener = null;
        if (recyclerListView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listView");
            recyclerListView = null;
        }
        AdSectionAdapter adSectionAdapter = this.listViewAdapter;
        if (adSectionAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listViewAdapter");
            adSectionAdapter = null;
        }
        recyclerListView.setAdapter(adSectionAdapter);
        GridLayoutManager gridLayoutManager = this.gridLayoutManager;
        if (gridLayoutManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gridLayoutManager");
            gridLayoutManager = null;
        }
        recyclerListView.setLayoutManager(gridLayoutManager);
        recyclerListView.setNestedScrollingEnabled(false);
        this.scrollListener = new RecyclerView.OnScrollListener() { // from class: ir.resaneh1.iptv.fragment.home.ad.AdSectionCell.initViews.2
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
                super.onScrollStateChanged(recyclerView, i);
                if (i == 0) {
                    AdSectionCell.this.startScroll();
                } else {
                    if (i != 1) {
                        return;
                    }
                    AdSectionCell.this.stopScroll();
                }
            }
        };
        CirclePagerIndicatorDecorationAdSection circlePagerIndicatorDecorationAdSection = new CirclePagerIndicatorDecorationAdSection();
        circlePagerIndicatorDecorationAdSection.setColorActive(Color.parseColor("#4a1e73"));
        circlePagerIndicatorDecorationAdSection.setColorInactive(Color.parseColor("#334a1e73"));
        circlePagerIndicatorDecorationAdSection.setRtlLayout(true);
        circlePagerIndicatorDecorationAdSection.setIndicatorItemSize(AndroidUtilities.dp(8.0f));
        circlePagerIndicatorDecorationAdSection.setIndicatorItemPadding(AndroidUtilities.dp(6.0f));
        setIndicator(circlePagerIndicatorDecorationAdSection);
        this.snapHelper = new PagerSnapHelper();
        RecyclerListView recyclerListView2 = this.listView;
        if (recyclerListView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listView");
            recyclerListView2 = null;
        }
        RecyclerView.OnScrollListener onScrollListener2 = this.scrollListener;
        if (onScrollListener2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scrollListener");
        } else {
            onScrollListener = onScrollListener2;
        }
        recyclerListView2.setOnScrollListener(onScrollListener);
    }

    public final void setData(HomePageModels.HomePageSectionObject data) {
        Intrinsics.checkNotNullParameter(data, "data");
        resetData();
        if (dataIsValid(data)) {
            VisibilityHelper.showViews(this);
            this.adSectionObject = data;
            HomePageModels.AdSectionObject adSectionObject = data.ad_section;
            ArrayList<HomePageModels.AdItemObject> arrayList = adSectionObject.ad_items_list;
            if (arrayList != null) {
                RecyclerListView recyclerListView = null;
                if (adSectionObject.row > arrayList.size()) {
                    GridLayoutManager gridLayoutManager = this.gridLayoutManager;
                    if (gridLayoutManager == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("gridLayoutManager");
                        gridLayoutManager = null;
                    }
                    gridLayoutManager.setSpanCount(data.ad_section.ad_items_list.size());
                    RecyclerListView recyclerListView2 = this.listView;
                    if (recyclerListView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("listView");
                        recyclerListView2 = null;
                    }
                    recyclerListView2.addItemDecoration(getIndicator());
                    getIndicator().setColumn(1);
                } else {
                    int i = data.ad_section.row;
                    this.rowCount = i > 0 ? i : 1;
                    GridLayoutManager gridLayoutManager2 = this.gridLayoutManager;
                    if (gridLayoutManager2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("gridLayoutManager");
                        gridLayoutManager2 = null;
                    }
                    gridLayoutManager2.setSpanCount(this.rowCount);
                    if (this.rowCount < data.ad_section.ad_items_list.size()) {
                        RecyclerListView recyclerListView3 = this.listView;
                        if (recyclerListView3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("listView");
                            recyclerListView3 = null;
                        }
                        recyclerListView3.addItemDecoration(getIndicator());
                        getIndicator().setColumn((int) Math.ceil(data.ad_section.ad_items_list.size() / this.rowCount));
                        getIndicator().setSizeList(this.rowCount);
                    }
                }
                RecyclerListView recyclerListView4 = this.listView;
                if (recyclerListView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("listView");
                    recyclerListView4 = null;
                }
                recyclerListView4.getRecycledViewPool().clear();
                AdSectionAdapter adSectionAdapter = this.listViewAdapter;
                if (adSectionAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("listViewAdapter");
                    adSectionAdapter = null;
                }
                ArrayList<HomePageModels.AdItemObject> arrayList2 = data.ad_section.ad_items_list;
                Intrinsics.checkNotNullExpressionValue(arrayList2, "data.ad_section.ad_items_list");
                Float fValueOf = Float.valueOf(data.ad_section.w_h_ratio);
                HomePageModels.CommonSectionDataObject commonSectionDataObject = data.common_section_data;
                adSectionAdapter.setData(arrayList2, fValueOf, commonSectionDataObject == null ? null : commonSectionDataObject.margin_info);
                PagerSnapHelper pagerSnapHelper = this.snapHelper;
                if (pagerSnapHelper == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("snapHelper");
                    pagerSnapHelper = null;
                }
                RecyclerListView recyclerListView5 = this.listView;
                if (recyclerListView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("listView");
                } else {
                    recyclerListView = recyclerListView5;
                }
                pagerSnapHelper.attachToRecyclerView(recyclerListView);
                setIndicatorData(data);
            }
            checkOrientation();
            setSectionInfoData(data.common_section_data, data.type);
            return;
        }
        VisibilityHelper.hideViews(this);
    }

    private final void setIndicatorData(HomePageModels.HomePageSectionObject homePageSectionObject) {
        HomePageModels.IndicatorInfoObject indicatorInfoObject;
        HomePageModels.CommonSectionDataObject commonSectionDataObject = homePageSectionObject.common_section_data;
        if (commonSectionDataObject == null || (indicatorInfoObject = commonSectionDataObject.indicator_info) == null) {
            return;
        }
        HomePageModels.IndicatorInfoType indicatorInfoType = indicatorInfoObject.position;
        if (indicatorInfoType != null) {
            if (indicatorInfoType == HomePageModels.IndicatorInfoType.Inside) {
                getIndicator().setInside(true);
            } else {
                getIndicator().setInside(false);
            }
        }
        String str = indicatorInfoObject.selected_color_code;
        if (str != null) {
            getIndicator().setColorActive(Color.parseColor(str));
        }
        String str2 = indicatorInfoObject.unselected_color_code;
        if (str2 != null) {
            getIndicator().setColorInactive(Color.parseColor(str2));
        }
        HomePageModels.IndicatorSizeType indicatorSizeType = indicatorInfoObject.size;
        int i = indicatorSizeType == null ? -1 : WhenMappings.$EnumSwitchMapping$0[indicatorSizeType.ordinal()];
        getIndicator().setIndicatorItemSize(AndroidUtilities.dp(i != 1 ? i != 2 ? 8.0f : 6.0f : 10.0f));
    }

    private final void resetData() {
        this.rowCount = 0;
        AdSectionAdapter adSectionAdapter = this.listViewAdapter;
        if (adSectionAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listViewAdapter");
            adSectionAdapter = null;
        }
        adSectionAdapter.clearData();
        GridLayoutManager gridLayoutManager = this.gridLayoutManager;
        if (gridLayoutManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gridLayoutManager");
            gridLayoutManager = null;
        }
        gridLayoutManager.setSpanCount(1);
        RecyclerListView recyclerListView = this.listView;
        if (recyclerListView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listView");
            recyclerListView = null;
        }
        recyclerListView.removeItemDecoration(getIndicator());
        getIndicator().setInside(false);
        CirclePagerIndicatorDecorationAdSection indicator = getIndicator();
        indicator.setColorActive(Color.parseColor("#4a1e73"));
        indicator.setColorInactive(Color.parseColor("#334a1e73"));
        indicator.setIndicatorItemSize(AndroidUtilities.dp(8.0f));
        stopScroll();
        this.adSectionObject = null;
    }

    private final boolean dataIsValid(HomePageModels.HomePageSectionObject homePageSectionObject) {
        HomePageModels.AdSectionObject adSectionObject;
        ArrayList<HomePageModels.AdItemObject> arrayList;
        return (homePageSectionObject == null || (adSectionObject = homePageSectionObject.ad_section) == null || (arrayList = adSectionObject.ad_items_list) == null || arrayList.isEmpty()) ? false : true;
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) throws IllegalStateException {
        super.onConfigurationChanged(configuration);
        HomePageModels.HomePageSectionObject homePageSectionObject = this.adSectionObject;
        if (homePageSectionObject != null) {
            setData(homePageSectionObject);
        }
        checkOrientation();
    }

    private final void checkOrientation() throws IllegalStateException {
        if (getResources().getConfiguration().orientation == 2) {
            resetLandscape();
        } else {
            resetPortrait();
        }
    }

    private final void resetLandscape() throws IllegalStateException {
        RecyclerListView recyclerListView = this.listView;
        if (recyclerListView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listView");
            recyclerListView = null;
        }
        recyclerListView.removeItemDecoration(getIndicator());
        PagerSnapHelper pagerSnapHelper = this.snapHelper;
        if (pagerSnapHelper == null) {
            Intrinsics.throwUninitializedPropertyAccessException("snapHelper");
            pagerSnapHelper = null;
        }
        pagerSnapHelper.attachToRecyclerView(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: scrollRunnable$lambda-9, reason: not valid java name */
    public static final void m454scrollRunnable$lambda9(final AdSectionCell this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.resaneh1.iptv.fragment.home.ad.AdSectionCell$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                AdSectionCell.m455scrollRunnable$lambda9$lambda8(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: scrollRunnable$lambda-9$lambda-8, reason: not valid java name */
    public static final void m455scrollRunnable$lambda9$lambda8(AdSectionCell this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            RecyclerListView recyclerListView = this$0.listView;
            AdSectionAdapter adSectionAdapter = null;
            if (recyclerListView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("listView");
                recyclerListView = null;
            }
            PagerSnapHelper pagerSnapHelper = this$0.snapHelper;
            if (pagerSnapHelper == null) {
                Intrinsics.throwUninitializedPropertyAccessException("snapHelper");
                pagerSnapHelper = null;
            }
            RecyclerListView recyclerListView2 = this$0.listView;
            if (recyclerListView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("listView");
                recyclerListView2 = null;
            }
            int snapPosition = RvUtilKt.getSnapPosition(pagerSnapHelper, recyclerListView2) + this$0.rowCount;
            AdSectionAdapter adSectionAdapter2 = this$0.listViewAdapter;
            if (adSectionAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("listViewAdapter");
            } else {
                adSectionAdapter = adSectionAdapter2;
            }
            recyclerListView.smoothScrollToPosition(snapPosition % adSectionAdapter.getItemCount());
        } catch (Exception e) {
            MyLog.e("AdSectionCell", e.getLocalizedMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startScroll() {
        if (isValidForAutoScroll()) {
            Utilities.stageQueue.cancelRunnable(this.scrollRunnable);
            Utilities.stageQueue.postRunnable(this.scrollRunnable, getScrollTime());
        }
    }

    private final long getScrollTime() {
        HomePageModels.AdSectionObject adSectionObject;
        int i;
        HomePageModels.HomePageSectionObject homePageSectionObject = this.adSectionObject;
        if (homePageSectionObject == null || (adSectionObject = homePageSectionObject.ad_section) == null || (i = adSectionObject.scroll_time) <= 0) {
            return 3000L;
        }
        return i * CloseCodes.NORMAL_CLOSURE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void stopScroll() {
        Utilities.stageQueue.cancelRunnable(this.scrollRunnable);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        startScroll();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopScroll();
    }

    private final boolean isValidForAutoScroll() {
        HomePageModels.AdSectionObject adSectionObject;
        HomePageModels.HomePageSectionObject homePageSectionObject = this.adSectionObject;
        return (homePageSectionObject == null || (adSectionObject = homePageSectionObject.ad_section) == null || adSectionObject.ad_items_list.size() < 2 || adSectionObject.scroll_time == 0) ? false : true;
    }
}
