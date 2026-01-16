package ir.resaneh1.iptv.fragment.home.live;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidMessenger.utilites.NumberUtils;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.resaneh1.iptv.fragment.HomePageActivityNew;
import ir.resaneh1.iptv.fragment.home.HomeCell;
import ir.resaneh1.iptv.helper.VisibilityHelper;
import ir.resaneh1.iptv.model.HomePageModels;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.ui.Components.LayoutHelper;
import org.rbmain.ui.Components.RecyclerListView;

/* compiled from: HomeLiveCell.kt */
/* loaded from: classes3.dex */
public final class HomeLiveCell extends HomeCell {
    private HomeLiveAdapter adapter;
    private HomeLiveEmptyCell emptyCell;
    private int emptyRow;
    private final boolean hideSectionInfo;
    private final ArrayList<HomePageModels.LiveSectionItem> items;
    private RecyclerListView listView;
    private int liveEndRow;
    private HomePageModels.LiveSectionObject liveSection;
    private int liveStartRow;
    private int maxItemCount;
    private ProgressBar progressBar;
    private boolean refreshOnAttach;
    private int rowCount;
    private final HomeLiveClickListener sectionInfoClickListener;
    private String section_id;
    private View singleLineView;
    private final String tag;

    /* compiled from: HomeLiveCell.kt */
    public interface HomeLiveClickListener {
        void onClick(String str, String str2, String str3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomeLiveCell(Context context, String tag, HomeLiveClickListener homeLiveClickListener, boolean z) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(tag, "tag");
        new LinkedHashMap();
        this.tag = tag;
        this.sectionInfoClickListener = homeLiveClickListener;
        this.hideSectionInfo = z;
        this.items = new ArrayList<>();
        this.liveStartRow = -1;
        this.liveEndRow = -1;
        this.emptyRow = -1;
        this.section_id = BuildConfig.FLAVOR;
        View[] viewArr = new View[1];
        View view = this.singleLineView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("singleLineView");
            view = null;
        }
        viewArr[0] = view;
        VisibilityHelper.hideViews(viewArr);
        startLoading();
    }

    public final boolean getRefreshOnAttach() {
        return this.refreshOnAttach;
    }

    public final void setRefreshOnAttach(boolean z) {
        this.refreshOnAttach = z;
    }

    public final String getSection_id() {
        return this.section_id;
    }

    public final void setSection_id(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.section_id = str;
    }

    public final int getMaxItemCount() {
        return this.maxItemCount;
    }

    public final void setMaxItemCount(int i) {
        this.maxItemCount = i;
    }

    @Override // ir.resaneh1.iptv.fragment.home.HomeCell
    public View createMainView(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        initViews(context);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.addView(createListView(context), LayoutHelper.createLinear(-1, -2, 17, 8, 8, 8, 0));
        View view = this.singleLineView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("singleLineView");
            view = null;
        }
        linearLayout.addView(view, LayoutHelper.createLinear(-1, 1, 17, 16, 0, 16, 8));
        return linearLayout;
    }

    private final void initViews(Context context) {
        this.progressBar = new ProgressBar(context);
        this.emptyCell = new HomeLiveEmptyCell(context);
        View viewCreateLine = VisibilityHelper.createLine(context);
        Intrinsics.checkNotNullExpressionValue(viewCreateLine, "createLine(context)");
        this.singleLineView = viewCreateLine;
        this.adapter = new HomeLiveAdapter(this, context);
        RecyclerListView recyclerListView = new RecyclerListView(context);
        this.listView = recyclerListView;
        recyclerListView.setLayoutManager(new LinearLayoutManager(context, 1, false));
        RecyclerListView recyclerListView2 = this.listView;
        HomeLiveAdapter homeLiveAdapter = null;
        if (recyclerListView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listView");
            recyclerListView2 = null;
        }
        HomeLiveAdapter homeLiveAdapter2 = this.adapter;
        if (homeLiveAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        } else {
            homeLiveAdapter = homeLiveAdapter2;
        }
        recyclerListView2.setAdapter(homeLiveAdapter);
    }

    private final FrameLayout createListView(Context context) {
        FrameLayout frameLayout = new FrameLayout(context);
        HomeLiveEmptyCell homeLiveEmptyCell = this.emptyCell;
        ProgressBar progressBar = null;
        if (homeLiveEmptyCell == null) {
            Intrinsics.throwUninitializedPropertyAccessException("emptyCell");
            homeLiveEmptyCell = null;
        }
        frameLayout.addView(homeLiveEmptyCell, LayoutHelper.createFrame(-1, -2, 17));
        RecyclerListView recyclerListView = this.listView;
        if (recyclerListView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listView");
            recyclerListView = null;
        }
        frameLayout.addView(recyclerListView, LayoutHelper.createFrame(-1, -2.0f, 48, 8.0f, 8.0f, 8.0f, 8.0f));
        ProgressBar progressBar2 = this.progressBar;
        if (progressBar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressBar");
        } else {
            progressBar = progressBar2;
        }
        frameLayout.addView(progressBar, LayoutHelper.createFrame(-1, -2.0f, 17, 0.0f, 8.0f, 0.0f, 8.0f));
        showEmptyView();
        return frameLayout;
    }

    public final void setData(HomePageModels.HomePageSectionObject homePageSectionObject) {
        resetData();
        this.liveSection = homePageSectionObject == null ? null : homePageSectionObject.live_section;
        if ((homePageSectionObject != null ? homePageSectionObject.live_section : null) != null) {
            VisibilityHelper.showViews(this);
            setSectionInfoData(homePageSectionObject.common_section_data, homePageSectionObject.type);
            this.maxItemCount = homePageSectionObject.live_section.main_item_count;
            String str = homePageSectionObject.id;
            Intrinsics.checkNotNullExpressionValue(str, "homePageSectionObject.id");
            this.section_id = str;
            ArrayList<HomePageModels.LiveSectionItem> arrayList = homePageSectionObject.live_section.liveSectionItems;
            if (arrayList != null) {
                Intrinsics.checkNotNull(arrayList);
                setItems(arrayList);
            } else {
                callGetItems(true);
            }
            setCommonInfoData(homePageSectionObject.common_section_data);
            return;
        }
        VisibilityHelper.hideViews(this);
    }

    private final void resetData() {
        this.maxItemCount = 0;
        this.section_id = BuildConfig.FLAVOR;
        this.liveSection = null;
        this.items.clear();
        endLoading();
        updateRows();
    }

    public final void callGetItems(final boolean z) {
        if ((this.tag.length() == 0) || (this.section_id.length() == 0)) {
            return;
        }
        if (z) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.resaneh1.iptv.fragment.home.live.HomeLiveCell$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    HomeLiveCell.m459callGetItems$lambda1(this.f$0);
                }
            });
        }
        HomePageModels.GetLiveSectionItemsInput getLiveSectionItemsInput = new HomePageModels.GetLiveSectionItemsInput();
        getLiveSectionItemsInput.section_id = this.section_id;
        getLiveSectionItemsInput.tag = this.tag;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: callGetItems$lambda-1, reason: not valid java name */
    public static final void m459callGetItems$lambda1(HomeLiveCell this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.startLoading();
    }

    public final void setItems(ArrayList<HomePageModels.LiveSectionItem> data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.items.clear();
        this.items.addAll(data.subList(0, RangesKt___RangesKt.coerceAtMost(data.size(), this.maxItemCount)));
        updateRows();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setCommonInfoData(final HomePageModels.CommonSectionDataObject commonSectionDataObject) {
        ArrayList<HomePageModels.LiveSectionItem> arrayList;
        View view = null;
        if (this.hideSectionInfo) {
            View[] viewArr = new View[1];
            View view2 = this.singleLineView;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("singleLineView");
            } else {
                view = view2;
            }
            viewArr[0] = view;
            VisibilityHelper.hideViews(viewArr);
            return;
        }
        View[] viewArr2 = new View[1];
        View view3 = this.singleLineView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("singleLineView");
            view3 = null;
        }
        viewArr2[0] = view3;
        VisibilityHelper.hideViews(viewArr2);
        VisibilityHelper.hideViews(getBottomInfoCell());
        if (commonSectionDataObject != null) {
            HomePageModels.BottomInfoObject bottomInfoObject = commonSectionDataObject.bottom_info;
            if ((bottomInfoObject == null ? null : bottomInfoObject.bottom_info_type) != HomePageModels.SectionInfoType.LoadMore) {
                VisibilityHelper.hideViews(getBottomInfoCell().loadMoreNumberTextView);
                return;
            }
            HomePageModels.LiveSectionObject liveSectionObject = this.liveSection;
            int size = ((liveSectionObject == null || (arrayList = liveSectionObject.liveSectionItems) == null) ? 0 : arrayList.size()) - this.maxItemCount;
            if (size < 1) {
                VisibilityHelper.hideViews(getBottomInfoCell().loadMoreNumberTextView);
            } else {
                View[] viewArr3 = new View[1];
                View view4 = this.singleLineView;
                if (view4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("singleLineView");
                } else {
                    view = view4;
                }
                viewArr3[0] = view;
                VisibilityHelper.showViews(viewArr3);
                getBottomInfoCell().setData(commonSectionDataObject.bottom_info);
                VisibilityHelper.showViews(getBottomInfoCell().loadMoreNumberTextView);
                getBottomInfoCell().loadMoreNumberTextView.setText("+ " + NumberUtils.toPersian(size));
            }
            getBottomInfoCell().setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.home.live.HomeLiveCell$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view5) {
                    HomeLiveCell.m460setCommonInfoData$lambda2(this.f$0, commonSectionDataObject, view5);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setCommonInfoData$lambda-2, reason: not valid java name */
    public static final void m460setCommonInfoData$lambda2(HomeLiveCell this$0, HomePageModels.CommonSectionDataObject commonSectionDataObject, View view) {
        HomePageModels.HeaderInfoObject headerInfoObject;
        String str;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        HomeLiveClickListener homeLiveClickListener = this$0.sectionInfoClickListener;
        if (homeLiveClickListener == null) {
            return;
        }
        String str2 = this$0.tag;
        String str3 = this$0.section_id;
        String str4 = BuildConfig.FLAVOR;
        if (commonSectionDataObject != null && (headerInfoObject = commonSectionDataObject.header_info) != null && (str = headerInfoObject.title) != null) {
            str4 = str;
        }
        homeLiveClickListener.onClick(str2, str3, str4);
    }

    private final void startLoading() {
        View[] viewArr = new View[1];
        ProgressBar progressBar = this.progressBar;
        HomeLiveEmptyCell homeLiveEmptyCell = null;
        if (progressBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressBar");
            progressBar = null;
        }
        viewArr[0] = progressBar;
        VisibilityHelper.showViews(viewArr);
        View[] viewArr2 = new View[1];
        RecyclerListView recyclerListView = this.listView;
        if (recyclerListView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listView");
            recyclerListView = null;
        }
        viewArr2[0] = recyclerListView;
        VisibilityHelper.hideViews(viewArr2);
        HomeLiveEmptyCell homeLiveEmptyCell2 = this.emptyCell;
        if (homeLiveEmptyCell2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("emptyCell");
        } else {
            homeLiveEmptyCell = homeLiveEmptyCell2;
        }
        homeLiveEmptyCell.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void endLoading() {
        ProgressBar progressBar = this.progressBar;
        RecyclerListView recyclerListView = null;
        if (progressBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressBar");
            progressBar = null;
        }
        if (progressBar.getVisibility() == 0) {
            View[] viewArr = new View[1];
            ProgressBar progressBar2 = this.progressBar;
            if (progressBar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("progressBar");
                progressBar2 = null;
            }
            viewArr[0] = progressBar2;
            VisibilityHelper.hideViews(viewArr);
            View[] viewArr2 = new View[1];
            RecyclerListView recyclerListView2 = this.listView;
            if (recyclerListView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("listView");
            } else {
                recyclerListView = recyclerListView2;
            }
            viewArr2[0] = recyclerListView;
            VisibilityHelper.showViews(viewArr2);
        }
    }

    private final void showEmptyView() {
        View[] viewArr = new View[1];
        RecyclerListView recyclerListView = this.listView;
        View view = null;
        if (recyclerListView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listView");
            recyclerListView = null;
        }
        viewArr[0] = recyclerListView;
        VisibilityHelper.hideViews(viewArr);
        HomeLiveEmptyCell homeLiveEmptyCell = this.emptyCell;
        if (homeLiveEmptyCell == null) {
            Intrinsics.throwUninitializedPropertyAccessException("emptyCell");
            homeLiveEmptyCell = null;
        }
        homeLiveEmptyCell.setVisibility(0);
        View[] viewArr2 = new View[1];
        View view2 = this.singleLineView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("singleLineView");
        } else {
            view = view2;
        }
        viewArr2[0] = view;
        VisibilityHelper.hideViews(viewArr2);
    }

    private final void hideEmptyView() {
        View[] viewArr = new View[1];
        RecyclerListView recyclerListView = this.listView;
        HomeLiveEmptyCell homeLiveEmptyCell = null;
        if (recyclerListView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listView");
            recyclerListView = null;
        }
        viewArr[0] = recyclerListView;
        VisibilityHelper.showViews(viewArr);
        HomeLiveEmptyCell homeLiveEmptyCell2 = this.emptyCell;
        if (homeLiveEmptyCell2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("emptyCell");
        } else {
            homeLiveEmptyCell = homeLiveEmptyCell2;
        }
        homeLiveEmptyCell.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateRows() {
        RecyclerView.ViewHolder viewHolderFindContainingViewHolder;
        boolean z = false;
        this.rowCount = 0;
        this.liveStartRow = -1;
        this.liveEndRow = -1;
        this.emptyRow = -1;
        HomePageModels.LiveSectionObject liveSectionObject = this.liveSection;
        if (liveSectionObject != null && !liveSectionObject.show_empty_live_section) {
            z = true;
        }
        HomeLiveAdapter homeLiveAdapter = null;
        if (z) {
            ViewParent parent = getParent();
            RecyclerListView recyclerListView = parent instanceof RecyclerListView ? (RecyclerListView) parent : null;
            RecyclerView.Adapter adapter = recyclerListView == null ? null : recyclerListView.getAdapter();
            HomePageActivityNew.ListAdapter listAdapter = adapter instanceof HomePageActivityNew.ListAdapter ? (HomePageActivityNew.ListAdapter) adapter : null;
            if (listAdapter != null) {
                ViewParent parent2 = getParent();
                RecyclerListView recyclerListView2 = parent2 instanceof RecyclerListView ? (RecyclerListView) parent2 : null;
                if (recyclerListView2 != null && (viewHolderFindContainingViewHolder = recyclerListView2.findContainingViewHolder(this)) != null) {
                    listAdapter.notifyItemChanged(viewHolderFindContainingViewHolder.getAdapterPosition());
                }
            }
        }
        if (this.items.isEmpty()) {
            showEmptyView();
        } else {
            hideEmptyView();
            int i = this.rowCount;
            this.liveStartRow = i;
            int size = i + this.items.size();
            this.rowCount = size;
            this.liveEndRow = size;
        }
        HomeLiveAdapter homeLiveAdapter2 = this.adapter;
        if (homeLiveAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        } else {
            homeLiveAdapter = homeLiveAdapter2;
        }
        homeLiveAdapter.notifyDataSetChanged();
    }

    /* compiled from: HomeLiveCell.kt */
    public enum TYPE {
        LIVE_CELL(0),
        EMPTY_CELL(1);

        private final int value;

        TYPE(int i) {
            this.value = i;
        }

        public final int getValue() {
            return this.value;
        }
    }

    /* compiled from: HomeLiveCell.kt */
    public final class HomeLiveAdapter extends RecyclerListView.SelectionAdapter {
        private final Context context;
        final /* synthetic */ HomeLiveCell this$0;

        @Override // org.rbmain.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder viewHolder) {
            return false;
        }

        public HomeLiveAdapter(HomeLiveCell this$0, Context context) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(context, "context");
            this.this$0 = this$0;
            this.context = context;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.this$0.rowCount;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
            View view;
            Intrinsics.checkNotNullParameter(parent, "parent");
            if (i == TYPE.LIVE_CELL.getValue()) {
                view = new HomeLiveItemCell(this.context);
            } else if (i == TYPE.EMPTY_CELL.getValue()) {
                view = new HomeLiveEmptyCell(this.context);
            } else {
                view = new View(this.context);
            }
            RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(-1, -2);
            layoutParams.setMargins(0, 10, 0, 10);
            view.setLayoutParams(layoutParams);
            return new RecyclerListView.Holder(view);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int i) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            if (getItemViewType(i) == TYPE.LIVE_CELL.getValue()) {
                HomeLiveItemCell homeLiveItemCell = (HomeLiveItemCell) holder.itemView;
                Object obj = this.this$0.items.get(i - this.this$0.liveStartRow);
                Intrinsics.checkNotNullExpressionValue(obj, "items[position - liveStartRow]");
                homeLiveItemCell.setData((HomePageModels.LiveSectionItem) obj, i == this.this$0.liveEndRow - 1);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            if (i == this.this$0.emptyRow) {
                return TYPE.EMPTY_CELL.getValue();
            }
            int i2 = this.this$0.liveStartRow;
            boolean z = false;
            if (i < this.this$0.liveEndRow && i2 <= i) {
                z = true;
            }
            if (z) {
                return TYPE.LIVE_CELL.getValue();
            }
            return -1;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.refreshOnAttach) {
            callGetItems(true);
        }
    }
}
