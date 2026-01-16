package ir.resaneh1.iptv.fragment.home;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import io.github.inflationx.calligraphy3.BuildConfig;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import ir.medu.shad.R;
import ir.resaneh1.iptv.apiMessanger.ApiRequestMessangerRx;
import ir.resaneh1.iptv.fragment.HomePageActivityNew;
import ir.resaneh1.iptv.helper.DimensionHelper;
import ir.resaneh1.iptv.helper.VisibilityHelper;
import ir.resaneh1.iptv.logger.MyLog;
import ir.resaneh1.iptv.model.HomePageModels;
import ir.resaneh1.iptv.model.MessangerOutput;
import java.util.ArrayList;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.UserConfig;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Components.LayoutHelper;
import org.rbmain.ui.Components.RecyclerListView;
import org.rbmain.ui.Components.ViewHelper;

/* loaded from: classes3.dex */
public class HomeCollectionInnerCell extends HomeCell {
    private ListAdapter adapter;
    private HomePageModels.CollectionItemObject collectionItemObject;
    private double columnCount;
    public CompositeDisposable compositeDisposable;
    private Delegate delegate;
    private DisposableObserver<MessangerOutput<HomePageModels.GetSectionDetailsOutput>> detailsDisposable;
    private Handler handler;
    private boolean isLoading;
    private int lastItemCount;
    private int leftMargin;
    private LinearLayout linearLayoutParent;
    private int movieHeightInDp;
    private int movieWidthInDp;
    public RecyclerListView recyclerListView;
    private int rightMargin;
    private String sectionId;
    private TextView textViewTitle;

    public interface Delegate {
        void onLoadMoreComplete(ArrayList<HomePageModels.SubCollectionItemObject> arrayList, boolean z, String str);
    }

    @Override // ir.resaneh1.iptv.fragment.home.HomeCell
    public View createMainView(Context context) {
        this.columnCount = 1.0d;
        calculateLayouts(context);
        LinearLayout linearLayout = new LinearLayout(context);
        this.linearLayoutParent = linearLayout;
        linearLayout.setOrientation(1);
        this.recyclerListView = new RecyclerListView(context);
        ListAdapter listAdapter = new ListAdapter(getContext());
        this.adapter = listAdapter;
        this.recyclerListView.setAdapter(listAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, 0, true);
        linearLayoutManager.setItemPrefetchEnabled(true);
        linearLayoutManager.setInitialPrefetchItemCount(4);
        this.recyclerListView.setLayoutManager(linearLayoutManager);
        this.recyclerListView.setNestedScrollingEnabled(false);
        this.recyclerListView.setClipToPadding(false);
        this.recyclerListView.setPadding(AndroidUtilities.dp(4.0f), 0, AndroidUtilities.dp(4.0f), 0);
        TextView textViewCreateTextView = ViewHelper.createTextView(context, 14, Theme.getColor(Theme.key_dialogTextBlack), true);
        this.textViewTitle = textViewCreateTextView;
        textViewCreateTextView.setPadding(AndroidUtilities.dp(8.0f), 0, AndroidUtilities.dp(8.0f), AndroidUtilities.dp(8.0f));
        this.linearLayoutParent.setPadding(0, 0, 0, 0);
        this.linearLayoutParent.addView(this.textViewTitle);
        this.linearLayoutParent.addView(this.recyclerListView, LayoutHelper.createLinear(-1, this.movieHeightInDp + 60));
        this.recyclerListView.setOnItemClickListener(new RecyclerListView.OnItemClickListener() { // from class: ir.resaneh1.iptv.fragment.home.HomeCollectionInnerCell$$ExternalSyntheticLambda1
            @Override // org.rbmain.ui.Components.RecyclerListView.OnItemClickListener
            public final void onItemClick(View view, int i) {
                this.f$0.lambda$createMainView$0(view, i);
            }
        });
        return this.linearLayoutParent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createMainView$0(View view, int i) {
        HomePageModels.CollectionItemObject collectionItemObject;
        if (!(view instanceof HomeMovieCell) || (collectionItemObject = this.collectionItemObject) == null) {
            return;
        }
        HomePageActivityNew.onLinkClick(collectionItemObject.sub_collection_items_list.get(i).action_link);
    }

    public HomeCollectionInnerCell(Context context) {
        super(context);
        this.isLoading = false;
        this.compositeDisposable = new CompositeDisposable();
        this.movieHeightInDp = 90;
        this.movieWidthInDp = 60;
        this.handler = new Handler();
    }

    private void calculateLayouts(Context context) {
        double dPxToDp = ((DimensionHelper.pxToDp(context, DimensionHelper.getScreenMinDimension((Activity) context)) - this.leftMargin) - this.rightMargin) - 8;
        double d = this.columnCount;
        Double.isNaN(dPxToDp);
        int i = (int) ((dPxToDp / d) - 8.0d);
        this.movieWidthInDp = i;
        double d2 = i;
        Double.isNaN(d2);
        this.movieHeightInDp = (int) (d2 * 1.5d);
    }

    private void setLayouts() {
        this.recyclerListView.setLayoutParams(new LinearLayout.LayoutParams(-1, AndroidUtilities.dp(this.movieHeightInDp + 60 + 4)));
        this.linearLayoutParent.setLayoutParams(LayoutHelper.createLinear(-1, this.movieHeightInDp + 60 + 32));
    }

    private Drawable getDrawable(int i) throws Resources.NotFoundException {
        Drawable drawable = getContext().getResources().getDrawable(i);
        drawable.setColorFilter(Theme.getColor(Theme.key_windowBackgroundWhite), PorterDuff.Mode.MULTIPLY);
        return drawable;
    }

    public void setData(HomePageModels.HomePageSectionObject homePageSectionObject, String str, double d, int i, int i2) {
        int i3;
        int i4;
        HomePageModels.MarginInfoObject marginInfoObject;
        resetData();
        if (!dataIsValid(homePageSectionObject)) {
            VisibilityHelper.hideViews(this);
            return;
        }
        VisibilityHelper.showViews(this);
        final HomePageModels.CollectionItemObject collectionItemObject = homePageSectionObject.collection_section.collection_items_list.get(i);
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        if (compositeDisposable != null) {
            compositeDisposable.dispose();
        }
        this.compositeDisposable = new CompositeDisposable();
        this.isLoading = false;
        MyLog.e("RubikaCollectionRow", " inner index is :" + i + " row count :" + i2);
        this.leftMargin = 8;
        this.rightMargin = 8;
        HomePageModels.CommonSectionDataObject commonSectionDataObject = homePageSectionObject.common_section_data;
        if (commonSectionDataObject == null || (marginInfoObject = commonSectionDataObject.margin_info) == null) {
            i3 = 6;
            i4 = 6;
        } else {
            this.leftMargin = (int) (marginInfoObject.left * 100.0f);
            this.rightMargin = (int) (marginInfoObject.right * 100.0f);
            int i5 = (int) (marginInfoObject.bottom * 100.0f);
            i3 = (int) (marginInfoObject.top * 100.0f);
            i4 = i5;
        }
        if (d != this.columnCount) {
            this.columnCount = d;
            if (d <= 0.0d) {
                this.columnCount = 1.0d;
            }
            calculateLayouts(getContext());
            setLayouts();
        }
        if (i == 0 && i2 == 1) {
            this.linearLayoutParent.setPadding(0, AndroidUtilities.dp(8.0f), 0, 0);
            setBackground(getDrawable(R.drawable.home_bg_rectangle_white_rounded));
            setLayoutParams(LayoutHelper.createLinear(-1, -2, 17.0f, this.leftMargin, i3, this.rightMargin, i4));
            setCollectionInfo(homePageSectionObject.common_section_data, true, true);
        } else if (i == 0) {
            this.linearLayoutParent.setPadding(0, AndroidUtilities.dp(8.0f), 0, 0);
            setBackground(getDrawable(R.drawable.home_bg_rectangle_white_top_rounded));
            setLayoutParams(LayoutHelper.createLinear(-1, -2, 48, this.leftMargin, i3, this.rightMargin, 0));
            setCollectionInfo(homePageSectionObject.common_section_data, true, false);
        } else if (i == i2 - 1) {
            setBackground(getDrawable(R.drawable.home_bg_rectangle_white_bottom_rounded));
            setLayoutParams(LayoutHelper.createLinear(-1, -2, 17.0f, this.leftMargin, 0, this.rightMargin, i4));
            setCollectionInfo(homePageSectionObject.common_section_data, false, true);
        } else {
            Drawable drawable = getContext().getResources().getDrawable(R.drawable.home_bg_rectangle_white);
            drawable.setColorFilter(Theme.getColor(Theme.key_windowBackgroundWhite), PorterDuff.Mode.MULTIPLY);
            setBackground(drawable);
            setLayoutParams(LayoutHelper.createLinear(-1, -2, 17.0f, this.leftMargin, 0, this.rightMargin, 0));
        }
        this.handler.postDelayed(new Runnable() { // from class: ir.resaneh1.iptv.fragment.home.HomeCollectionInnerCell$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$setData$1(collectionItemObject);
            }
        }, 30L);
        this.textViewTitle.setText(collectionItemObject.title);
        this.collectionItemObject = collectionItemObject;
        this.sectionId = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setData$1(HomePageModels.CollectionItemObject collectionItemObject) {
        ListAdapter listAdapter = this.adapter;
        if (listAdapter != null) {
            listAdapter.setItems(collectionItemObject);
            this.adapter.hasContinue = collectionItemObject.has_continue;
            return;
        }
        MyLog.e("RubikaCollectionRow", " oops! adapter was null");
    }

    private void resetData() {
        this.textViewTitle.setText(BuildConfig.FLAVOR);
        this.collectionItemObject = null;
        this.sectionId = BuildConfig.FLAVOR;
        this.adapter.setItems(null);
        this.rightMargin = 8;
        this.leftMargin = 8;
    }

    private boolean dataIsValid(HomePageModels.HomePageSectionObject homePageSectionObject) {
        HomePageModels.CollectionSectionObject collectionSectionObject;
        return (homePageSectionObject == null || (collectionSectionObject = homePageSectionObject.collection_section) == null || collectionSectionObject.collection_items_list.isEmpty()) ? false : true;
    }

    public ListAdapter getAdapter() {
        return this.adapter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callGetSectionDetails() {
        if (this.isLoading) {
            this.isLoading = false;
            return;
        }
        this.isLoading = true;
        DisposableObserver<MessangerOutput<HomePageModels.GetSectionDetailsOutput>> disposableObserver = this.detailsDisposable;
        if (disposableObserver != null) {
            disposableObserver.dispose();
        }
        this.lastItemCount = this.adapter.getItemCount();
        HomePageModels.GetSectionDetailsInput getSectionDetailsInput = new HomePageModels.GetSectionDetailsInput();
        HomePageModels.CollectionItemObject collectionItemObject = this.collectionItemObject;
        String str = collectionItemObject.next_start_id;
        getSectionDetailsInput.start_id = str;
        String str2 = this.sectionId;
        getSectionDetailsInput.section_id = str2;
        String str3 = collectionItemObject.id;
        getSectionDetailsInput.section_item_id = str3;
        if (str == null || str2 == null || str3 == null) {
            this.isLoading = false;
            return;
        }
        DisposableObserver<MessangerOutput<HomePageModels.GetSectionDetailsOutput>> disposableObserver2 = (DisposableObserver) ApiRequestMessangerRx.getInstance(UserConfig.selectedAccount).getSectionDetails(getSectionDetailsInput).subscribeWith(new DisposableObserver<MessangerOutput<HomePageModels.GetSectionDetailsOutput>>() { // from class: ir.resaneh1.iptv.fragment.home.HomeCollectionInnerCell.1
            @Override // io.reactivex.Observer
            public void onComplete() {
            }

            @Override // io.reactivex.Observer
            public void onNext(MessangerOutput<HomePageModels.GetSectionDetailsOutput> messangerOutput) {
                if (messangerOutput.data != null) {
                    HomeCollectionInnerCell.this.adapter.hasContinue = messangerOutput.data.has_continue;
                    HomeCollectionInnerCell.this.collectionItemObject.next_start_id = messangerOutput.data.next_start_id;
                    Delegate delegate = HomeCollectionInnerCell.this.delegate;
                    HomePageModels.GetSectionDetailsOutput getSectionDetailsOutput = messangerOutput.data;
                    delegate.onLoadMoreComplete(getSectionDetailsOutput.sub_section_items.sub_collection_items_list, getSectionDetailsOutput.has_continue, getSectionDetailsOutput.next_start_id);
                    HomeCollectionInnerCell.this.isLoading = false;
                }
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
                HomeCollectionInnerCell.this.adapter.hasContinue = false;
                HomeCollectionInnerCell.this.delegate.onLoadMoreComplete(new ArrayList<>(), HomeCollectionInnerCell.this.adapter.hasContinue, HomeCollectionInnerCell.this.collectionItemObject.next_start_id);
                HomeCollectionInnerCell.this.isLoading = false;
            }
        });
        this.detailsDisposable = disposableObserver2;
        this.compositeDisposable.add(disposableObserver2);
    }

    public void setDelegate(Delegate delegate) {
        this.delegate = delegate;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        if (compositeDisposable == null || compositeDisposable.isDisposed()) {
            this.compositeDisposable = new CompositeDisposable();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        if (compositeDisposable != null) {
            compositeDisposable.dispose();
        }
    }

    public class ListAdapter extends RecyclerListView.SelectionAdapter {
        private HomePageModels.CollectionItemObject collection;
        public boolean hasContinue;
        private Context mContext;

        @Override // org.rbmain.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder viewHolder) {
            return false;
        }

        public ListAdapter(Context context) {
            HomeCollectionInnerCell.this.lastItemCount = 0;
            this.mContext = context;
        }

        public void setItems(HomePageModels.CollectionItemObject collectionItemObject) {
            if (collectionItemObject == null) {
                return;
            }
            HomePageModels.CollectionItemObject collectionItemObject2 = this.collection;
            if (collectionItemObject2 == null || !collectionItemObject2.equals(collectionItemObject)) {
                this.collection = collectionItemObject;
                notifyDataSetChanged();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            HomePageModels.CollectionItemObject collectionItemObject = this.collection;
            if (collectionItemObject == null || collectionItemObject.sub_collection_items_list.isEmpty()) {
                return 0;
            }
            int size = this.collection.sub_collection_items_list.size();
            return this.hasContinue ? size + 1 : size;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View homeMovieCell;
            if (i == 0) {
                homeMovieCell = new HomeMovieCell(this.mContext, Theme.getColor(Theme.key_dialogTextBlack), HomeCollectionInnerCell.this.movieWidthInDp, HomeCollectionInnerCell.this.movieHeightInDp, 4);
            } else {
                HomeLoadingCell homeLoadingCell = new HomeLoadingCell(this.mContext, 32);
                homeLoadingCell.setProgressBarColor(Theme.getColor(Theme.key_dialogTextBlack));
                homeMovieCell = homeLoadingCell;
            }
            return new RecyclerListView.Holder(homeMovieCell);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            if (getItemViewType(i) == 0) {
                HomePageModels.SubCollectionItemObject subCollectionItemObject = this.collection.sub_collection_items_list.get(i);
                HomeMovieCell homeMovieCell = (HomeMovieCell) viewHolder.itemView;
                homeMovieCell.resetLayouts(HomeCollectionInnerCell.this.movieWidthInDp, HomeCollectionInnerCell.this.movieHeightInDp);
                homeMovieCell.setUrlAndText(subCollectionItemObject.image_url, subCollectionItemObject.title);
                if (i < getItemCount() - 2 || !this.hasContinue) {
                    return;
                }
                HomeCollectionInnerCell.this.callGetSectionDetails();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            return i < this.collection.sub_collection_items_list.size() ? 0 : 1;
        }

        public void notifyItemsAdded() {
            if (getItemCount() > HomeCollectionInnerCell.this.lastItemCount) {
                notifyItemRangeChanged(HomeCollectionInnerCell.this.lastItemCount - 1, getItemCount() - (HomeCollectionInnerCell.this.lastItemCount - 1));
            } else {
                notifyItemRemoved(getItemCount());
            }
            HomeCollectionInnerCell.this.lastItemCount = getItemCount();
        }
    }
}
