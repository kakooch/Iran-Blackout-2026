package ir.resaneh1.iptv.fragment.home;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.graphics.ColorUtils;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.stetho.websocket.CloseCodes;
import io.github.inflationx.calligraphy3.BuildConfig;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DefaultObserver;
import io.reactivex.observers.DisposableObserver;
import ir.medu.shad.R;
import ir.resaneh1.iptv.apiMessanger.ApiRequestMessangerRx;
import ir.resaneh1.iptv.fragment.HomePageActivityNew;
import ir.resaneh1.iptv.fragment.home.helper.ViewUpdateHelper;
import ir.resaneh1.iptv.helper.CustomTextView;
import ir.resaneh1.iptv.helper.DimensionHelper;
import ir.resaneh1.iptv.helper.GlideHelper;
import ir.resaneh1.iptv.helper.VisibilityHelper;
import ir.resaneh1.iptv.logger.MyLog;
import ir.resaneh1.iptv.model.HomePageModels;
import ir.resaneh1.iptv.model.MessangerOutput;
import java.util.ArrayList;
import java.util.List;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.UserConfig;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Components.LayoutHelper;
import org.rbmain.ui.Components.RecyclerListView;

/* loaded from: classes3.dex */
public class HomeSliderCell extends HomeCell {
    public ImageView backgroundImageFilterView;
    public ImageView backgroundImageView;
    private double columnCount;
    public CompositeDisposable compositeDisposable;
    private Delegate delegate;
    private DisposableObserver<MessangerOutput<HomePageModels.GetSectionDetailsOutput>> detailsDisposable;
    private String fontColor;
    private FrameLayout frameLayout;
    private boolean hasContinue;
    private String imageUrl;
    private boolean isLoading;
    private List<HomePageModels.SliderItemObject> items;
    private int lastItemCount;
    public RecyclerListView listView;
    public SliderAdapter listViewAdapter;
    private final Context mContext;
    private final float minBackgroundImageTranslationX;
    private int movieImageHeightInDp;
    private int movieWidthInDp;
    private LinearLayout parentLinearLayout;
    private String sectionId;
    private HomePageModels.SliderSectionObject sliderSectionObject;
    private List<String> textRVList;
    private TextView titleTextView;

    public interface Delegate {
        void onLoadMoreComplete(ArrayList<HomePageModels.SliderItemObject> arrayList, boolean z, String str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Float scaleValue(Float f, Float f2, Float f3, Float f4, Float f5) {
        return Float.valueOf((((f.floatValue() - f2.floatValue()) * (f5.floatValue() - f4.floatValue())) / (f3.floatValue() - f2.floatValue())) + f4.floatValue());
    }

    public HomeSliderCell(Context context) {
        super(context);
        this.items = new ArrayList();
        this.compositeDisposable = new CompositeDisposable();
        this.isLoading = false;
        this.fontColor = "#ffffff";
        this.movieImageHeightInDp = 90;
        this.columnCount = 3.2d;
        this.movieWidthInDp = 60;
        this.minBackgroundImageTranslationX = AndroidUtilities.dp(-57.0f);
        this.columnCount = 4.2d;
        double screenMinDimension = DimensionHelper.getScreenMinDimension((Activity) context);
        double d = this.columnCount;
        Double.isNaN(screenMinDimension);
        int iPxToDp = DimensionHelper.pxToDp(context, (float) (screenMinDimension / d)) - 8;
        this.movieWidthInDp = iPxToDp;
        double d2 = iPxToDp;
        Double.isNaN(d2);
        this.movieImageHeightInDp = (int) (d2 * 1.5d);
        this.mContext = context;
        resetState();
        this.listView.setOnItemClickListener(new RecyclerListView.OnItemClickListener() { // from class: ir.resaneh1.iptv.fragment.home.HomeSliderCell$$ExternalSyntheticLambda1
            @Override // org.rbmain.ui.Components.RecyclerListView.OnItemClickListener
            public final void onItemClick(View view, int i) {
                this.f$0.lambda$new$0(view, i);
            }
        });
        setViewLayouts();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(View view, int i) {
        HomePageModels.SliderSectionObject sliderSectionObject;
        if (!(view instanceof HomeMovieCell) || (sliderSectionObject = this.sliderSectionObject) == null) {
            return;
        }
        HomePageActivityNew.onLinkClick(sliderSectionObject.slider_items_list.get(i).action_link);
    }

    @Override // ir.resaneh1.iptv.fragment.home.HomeCell
    public View createMainView(Context context) {
        FrameLayout frameLayout = new FrameLayout(context);
        LinearLayout linearLayout = new LinearLayout(context);
        this.parentLinearLayout = linearLayout;
        linearLayout.setOrientation(1);
        ImageView imageView = new ImageView(context);
        this.backgroundImageView = imageView;
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        addView(this.backgroundImageView, LayoutHelper.createFrame(-1, -1, 5));
        ImageView imageView2 = new ImageView(context);
        this.backgroundImageFilterView = imageView2;
        imageView2.setScaleType(ImageView.ScaleType.FIT_XY);
        addView(this.backgroundImageFilterView, LayoutHelper.createFrame(-1, -1.0f));
        this.backgroundImageFilterView.setVisibility(0);
        RecyclerListView recyclerListView = new RecyclerListView(context);
        this.listView = recyclerListView;
        recyclerListView.setLayoutManager(new LinearLayoutManager(context, 0, true));
        RecyclerListView recyclerListView2 = this.listView;
        SliderAdapter sliderAdapter = new SliderAdapter(context);
        this.listViewAdapter = sliderAdapter;
        recyclerListView2.setAdapter(sliderAdapter);
        this.listView.setClipToPadding(false);
        this.listView.setNestedScrollingEnabled(false);
        FrameLayout frameLayout2 = new FrameLayout(context);
        this.frameLayout = frameLayout2;
        frameLayout2.addView(this.listView, LayoutHelper.createFrame(-1, this.movieImageHeightInDp + 60 + 4, 3));
        this.parentLinearLayout.addView(this.frameLayout, LayoutHelper.createFrame(-1, this.movieImageHeightInDp + 60 + 24));
        frameLayout.addView(this.parentLinearLayout, LayoutHelper.createFrame(-1, this.movieImageHeightInDp + 60 + 32, 48));
        setLayoutParams(LayoutHelper.createFrame(-1, this.movieImageHeightInDp + 60 + 32));
        ArrayList arrayList = new ArrayList();
        this.textRVList = arrayList;
        arrayList.add(BuildConfig.FLAVOR);
        this.textRVList.add(BuildConfig.FLAVOR);
        this.textRVList.add(BuildConfig.FLAVOR);
        TextView textViewBuild = new CustomTextView.Builder(context).setText(BuildConfig.FLAVOR).setBackgroundResource((Drawable) null).setBackgroundColor(0).isBold(true).setGravity(17).setTextSize(14).setTextColor(Color.parseColor("#ffffff")).build();
        this.titleTextView = textViewBuild;
        frameLayout.addView(textViewBuild, LayoutHelper.createFrame(-2, -2, 53));
        return frameLayout;
    }

    public void setData(HomePageModels.HomePageSectionObject homePageSectionObject) {
        HomePageModels.HeaderInfoObject headerInfoObject;
        resetState();
        if (!dataIsValid(homePageSectionObject)) {
            VisibilityHelper.hideViews(this);
            return;
        }
        VisibilityHelper.showViews(this);
        setSectionInfoData(homePageSectionObject.common_section_data, homePageSectionObject.type);
        HomePageModels.CommonSectionDataObject commonSectionDataObject = homePageSectionObject.common_section_data;
        if (commonSectionDataObject != null && (headerInfoObject = commonSectionDataObject.header_info) != null) {
            this.textRVList.set(1, headerInfoObject.title);
            String str = homePageSectionObject.common_section_data.header_info.title;
            if (str != null) {
                this.titleTextView.setText(str);
            }
            String str2 = homePageSectionObject.common_section_data.header_info.title_color_code;
            if (str2 != null) {
                this.titleTextView.setTextColor(Color.parseColor(str2));
            }
            if (!HomeSliderCell$$ExternalSyntheticBackport0.m(Float.valueOf(homePageSectionObject.common_section_data.header_info.title_size))) {
                ViewUpdateHelper.INSTANCE.updateTextSize(this.titleTextView, Float.valueOf(homePageSectionObject.common_section_data.header_info.title_size));
            }
        }
        this.sectionId = homePageSectionObject.id;
        HomePageModels.SliderSectionObject sliderSectionObject = homePageSectionObject.slider_section;
        this.sliderSectionObject = sliderSectionObject;
        if (sliderSectionObject == null) {
            setVisibility(8);
        }
        this.listViewAdapter.setData(this.sliderSectionObject.slider_items_list);
        setBackgroundImage(this.sliderSectionObject.image_url);
        this.hasContinue = this.sliderSectionObject.has_continue;
        MyLog.e("HomeSliderCell", " column is :" + this.sliderSectionObject.column);
        float f = this.sliderSectionObject.column;
        if (f < 1.0f) {
            this.columnCount = 1.0d;
        } else {
            this.columnCount = f;
        }
        Context context = this.mContext;
        double screenMinDimension = DimensionHelper.getScreenMinDimension((Activity) context);
        double d = this.columnCount;
        Double.isNaN(screenMinDimension);
        int iPxToDp = DimensionHelper.pxToDp(context, (float) (screenMinDimension / d)) - 8;
        this.movieWidthInDp = iPxToDp;
        double d2 = iPxToDp;
        Double.isNaN(d2);
        this.movieImageHeightInDp = (int) (d2 * 1.5d);
        this.listView.setPadding(0, 0, this.titleTextView.getMeasuredWidth() + AndroidUtilities.dp(33.0f), 0);
        setViewLayouts();
    }

    private boolean dataIsValid(HomePageModels.HomePageSectionObject homePageSectionObject) {
        HomePageModels.SliderSectionObject sliderSectionObject;
        return (homePageSectionObject == null || (sliderSectionObject = homePageSectionObject.slider_section) == null || sliderSectionObject.slider_items_list.isEmpty()) ? false : true;
    }

    private void setViewLayouts() {
        MyLog.e("HomeSliderCell", "SetViewLayouts : ");
        Context context = this.mContext;
        double screenMinDimension = DimensionHelper.getScreenMinDimension((Activity) context);
        double d = this.columnCount;
        Double.isNaN(screenMinDimension);
        int iPxToDp = DimensionHelper.pxToDp(context, (float) (screenMinDimension / d)) - 8;
        this.movieWidthInDp = iPxToDp;
        double d2 = iPxToDp;
        Double.isNaN(d2);
        this.movieImageHeightInDp = (int) (d2 * 1.5d);
        this.listView.setLayoutParams(LayoutHelper.createFrame(-2, r0 + 60 + 4, 5, 0.0f, 64.0f, 0.0f, 0.0f));
        this.frameLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, AndroidUtilities.dp(this.movieImageHeightInDp + 60 + 24)));
        this.parentLinearLayout.setLayoutParams(LayoutHelper.createFrame(-1, this.movieImageHeightInDp + 60 + 32));
        setLayoutParams(LayoutHelper.createFrame(-1, -2.0f, 48, 0.0f, 6.0f, 0.0f, 6.0f));
    }

    public void resetState() {
        MyLog.e("HomeSliderCell", "resetState : ");
        this.backgroundImageView.layout((int) this.minBackgroundImageTranslationX, 0, 0, 0);
        this.backgroundImageFilterView.layout((int) this.minBackgroundImageTranslationX, 0, 0, 0);
        GlideHelper.loadWithoutCrop(this.mContext, this.backgroundImageView, this.imageUrl);
    }

    private void setBackgroundImage(String str) {
        this.imageUrl = str;
        GlideHelper.loadWithoutCrop(this.mContext, this.backgroundImageView, str);
    }

    public class SliderAdapter extends RecyclerListView.SelectionAdapter {
        private Context mContext;

        @Override // org.rbmain.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder viewHolder) {
            return false;
        }

        public SliderAdapter(Context context) {
            HomeSliderCell.this.lastItemCount = 0;
            this.mContext = context;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            int size = HomeSliderCell.this.items != null ? 0 + HomeSliderCell.this.items.size() : 0;
            return HomeSliderCell.this.hasContinue ? size + 1 : size;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r7v5, types: [ir.resaneh1.iptv.fragment.home.HomeLoadingCell] */
        /* JADX WARN: Type inference failed for: r7v6, types: [android.view.View] */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            HomeMovieCell homeMovieCell;
            if (i == 1001) {
                homeMovieCell = new HomeMovieCell(this.mContext, Color.parseColor(HomeSliderCell.this.fontColor), HomeSliderCell.this.movieWidthInDp, HomeSliderCell.this.movieImageHeightInDp, 4);
            } else if (i == 1002) {
                ?? homeLoadingCell = new HomeLoadingCell(this.mContext, 32);
                homeLoadingCell.setProgressBarColor(Theme.getColor(Theme.key_dialogTextBlack));
                homeMovieCell = homeLoadingCell;
            } else {
                homeMovieCell = new View(this.mContext);
            }
            return new RecyclerListView.Holder(homeMovieCell);
        }

        public void notifyItemsAdded() {
            MyLog.e("HomeSliderCell", "Notifying item add " + HomeSliderCell.this.hasContinue + " lasItemCount : " + HomeSliderCell.this.lastItemCount + " itemCount" + getItemCount());
            if (getItemCount() > HomeSliderCell.this.lastItemCount) {
                notifyItemRangeChanged(HomeSliderCell.this.lastItemCount - 1, getItemCount() - (HomeSliderCell.this.lastItemCount - 1));
            } else {
                notifyItemRemoved(getItemCount());
            }
            HomeSliderCell.this.lastItemCount = getItemCount();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            if (i < HomeSliderCell.this.items.size()) {
                return 1001;
            }
            return CloseCodes.PROTOCOL_ERROR;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            if (getItemViewType(i) == 1001) {
                HomePageModels.SliderItemObject sliderItemObject = (HomePageModels.SliderItemObject) HomeSliderCell.this.items.get(i);
                HomeMovieCell homeMovieCell = (HomeMovieCell) viewHolder.itemView;
                MyLog.e("HomeSliderCell", " resetting layout of :" + sliderItemObject.title + " width: " + HomeSliderCell.this.movieWidthInDp + " height " + HomeSliderCell.this.movieImageHeightInDp);
                homeMovieCell.resetLayouts(HomeSliderCell.this.movieWidthInDp, HomeSliderCell.this.movieImageHeightInDp);
                homeMovieCell.setUrlAndText(sliderItemObject.image_url, sliderItemObject.title);
            }
            MyLog.e("HomeSliderCell", " Should call load more ? " + HomeSliderCell.this.hasContinue);
            if (i < getItemCount() - 3 || !HomeSliderCell.this.hasContinue) {
                return;
            }
            MyLog.e("HomeSliderCell", " Should call load more ");
            HomeSliderCell.this.callGetSectionDetails();
        }

        public void setData(List<HomePageModels.SliderItemObject> list) {
            CompositeDisposable compositeDisposable = HomeSliderCell.this.compositeDisposable;
            if (compositeDisposable != null) {
                compositeDisposable.dispose();
            }
            HomeSliderCell.this.compositeDisposable = new CompositeDisposable();
            if (HomeSliderCell.this.items == null || !HomeSliderCell.this.items.equals(list)) {
                HomeSliderCell.this.items = list;
                SliderAdapter sliderAdapter = HomeSliderCell.this.listViewAdapter;
                if (sliderAdapter != null) {
                    sliderAdapter.notifyDataSetChanged();
                }
            }
        }
    }

    public void setDelegate(Delegate delegate) {
        this.delegate = delegate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callGetSectionDetails() {
        if (this.isLoading) {
            return;
        }
        this.isLoading = true;
        DisposableObserver<MessangerOutput<HomePageModels.GetSectionDetailsOutput>> disposableObserver = this.detailsDisposable;
        if (disposableObserver != null) {
            disposableObserver.dispose();
        }
        this.lastItemCount = this.listViewAdapter.getItemCount();
        HomePageModels.GetSectionDetailsInput getSectionDetailsInput = new HomePageModels.GetSectionDetailsInput();
        getSectionDetailsInput.start_id = this.sliderSectionObject.next_start_id;
        getSectionDetailsInput.section_id = this.sectionId;
        MyLog.e("HomeSliderCell", "Sending Details Req : start_id : " + getSectionDetailsInput.start_id + " section_id " + getSectionDetailsInput.section_id);
        if (getSectionDetailsInput.start_id == null || getSectionDetailsInput.section_id == null) {
            this.isLoading = false;
        } else {
            ApiRequestMessangerRx.getInstance(UserConfig.selectedAccount).getSectionDetails(getSectionDetailsInput).subscribe(new DefaultObserver<MessangerOutput<HomePageModels.GetSectionDetailsOutput>>() { // from class: ir.resaneh1.iptv.fragment.home.HomeSliderCell.1
                @Override // io.reactivex.Observer
                public void onComplete() {
                }

                @Override // io.reactivex.Observer
                public void onNext(MessangerOutput<HomePageModels.GetSectionDetailsOutput> messangerOutput) {
                    if (messangerOutput.data != null) {
                        MyLog.e("HomeSliderCell", "Sent req back : section_item_id :" + HomeSliderCell.this.sectionId + " output hasContinue is : " + messangerOutput.data.has_continue);
                        HomeSliderCell.this.hasContinue = messangerOutput.data.has_continue;
                        HomeSliderCell.this.sliderSectionObject.next_start_id = messangerOutput.data.next_start_id;
                        Delegate delegate = HomeSliderCell.this.delegate;
                        HomePageModels.GetSectionDetailsOutput getSectionDetailsOutput = messangerOutput.data;
                        delegate.onLoadMoreComplete(getSectionDetailsOutput.section_items.slider_items_list, getSectionDetailsOutput.has_continue, getSectionDetailsOutput.next_start_id);
                        HomeSliderCell.this.isLoading = false;
                    }
                }

                @Override // io.reactivex.Observer
                public void onError(Throwable th) {
                    if (MyLog.isDebugAble) {
                        Toast.makeText(HomeSliderCell.this.mContext, th.getLocalizedMessage(), 1).show();
                    }
                }
            });
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        if (compositeDisposable == null || compositeDisposable.isDisposed()) {
            this.compositeDisposable = new CompositeDisposable();
        }
        this.listView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: ir.resaneh1.iptv.fragment.home.HomeSliderCell.2
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                int right;
                super.onScrolled(recyclerView, i, i2);
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                float fComputeHorizontalScrollOffset = recyclerView.computeHorizontalScrollOffset() / (recyclerView.computeHorizontalScrollRange() - recyclerView.computeVerticalScrollExtent());
                float f = ((0.0f - HomeSliderCell.this.minBackgroundImageTranslationX) * fComputeHorizontalScrollOffset) + HomeSliderCell.this.minBackgroundImageTranslationX;
                if (recyclerView.getMeasuredWidth() >= HomeSliderCell.this.frameLayout.getMeasuredWidth()) {
                    HomeSliderCell.this.backgroundImageView.setTranslationX(-f);
                }
                float fAbs = (200 * (1.0f - Math.abs(fComputeHorizontalScrollOffset))) + 0.0f;
                HomeSliderCell homeSliderCell = HomeSliderCell.this;
                homeSliderCell.backgroundImageFilterView.setBackgroundColor(ColorUtils.setAlphaComponent(homeSliderCell.mContext.getResources().getColor(R.color.black), (int) fAbs));
                if (Math.abs(i) >= AndroidUtilities.dp(27.0f)) {
                    if (i <= 0) {
                        HomeSliderCell.this.titleTextView.setY(AndroidUtilities.dp(3.0f));
                        return;
                    } else {
                        if (linearLayoutManager == null || linearLayoutManager.findFirstVisibleItemPosition() != 0) {
                            return;
                        }
                        HomeSliderCell.this.titleTextView.setY(recyclerView.getTop() + AndroidUtilities.dp(9.0f));
                        return;
                    }
                }
                if (recyclerView.getChildAt(0) == null) {
                    right = HomeSliderCell.this.backgroundImageView.getRight();
                } else {
                    right = recyclerView.getChildAt(0).getRight();
                }
                if (right <= (HomeSliderCell.this.backgroundImageView.getRight() - (HomeSliderCell.this.titleTextView.getMeasuredWidth() + AndroidUtilities.dp(33.0f))) - AndroidUtilities.dp(8.0f) || right >= (HomeSliderCell.this.backgroundImageView.getRight() - ((HomeSliderCell.this.titleTextView.getMeasuredWidth() + AndroidUtilities.dp(33.0f)) / 2)) - AndroidUtilities.dp(8.0f) || i == 0) {
                    return;
                }
                HomeSliderCell.this.titleTextView.setY(HomeSliderCell.this.scaleValue(Float.valueOf(right), Float.valueOf((HomeSliderCell.this.backgroundImageView.getRight() - (HomeSliderCell.this.titleTextView.getMeasuredWidth() + AndroidUtilities.dp(33.0f))) - AndroidUtilities.dp(8.0f)), Float.valueOf((HomeSliderCell.this.backgroundImageView.getRight() - ((HomeSliderCell.this.titleTextView.getMeasuredWidth() + AndroidUtilities.dp(33.0f)) / 2)) - AndroidUtilities.dp(8.0f)), Float.valueOf(recyclerView.getTop() + AndroidUtilities.dp(9.0f)), Float.valueOf(AndroidUtilities.dp(3.0f))).floatValue());
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        if (compositeDisposable != null) {
            compositeDisposable.dispose();
        }
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.backgroundImageView.layout((int) this.minBackgroundImageTranslationX, 0, 0, 0);
        this.backgroundImageFilterView.layout((int) this.minBackgroundImageTranslationX, 0, 0, 0);
        GlideHelper.loadWithoutCrop(this.mContext, this.backgroundImageView, this.imageUrl);
    }

    @Override // androidx.cardview.widget.CardView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i + AndroidUtilities.dp(0.0f)), 1073741824), View.MeasureSpec.makeMeasureSpec(DimensionHelper.dpToPx(this.mContext, this.movieImageHeightInDp + 60 + 32), 1073741824));
        updateViewMarginsAndPaddings();
    }

    private void updateViewMarginsAndPaddings() {
        ir.appp.common.utils.LayoutHelper.setMargins(this.listView, 0, AndroidUtilities.dp(30.0f), 0, 0);
        ir.appp.common.utils.LayoutHelper.setMargins(this.titleTextView, 0, this.listView.getTop() + AndroidUtilities.dp(9.0f), 0, 0);
        this.listView.setPadding(0, 0, this.titleTextView.getMeasuredWidth() + AndroidUtilities.dp(33.0f), 0);
        this.titleTextView.setPadding(0, 0, AndroidUtilities.dp(9.0f), 0);
        ir.appp.common.utils.LayoutHelper.setMargins(this.backgroundImageFilterView, (int) this.minBackgroundImageTranslationX, 0, 0, 0);
        ir.appp.common.utils.LayoutHelper.setMargins(this.backgroundImageView, (int) this.minBackgroundImageTranslationX, 0, 0, 0);
    }
}
