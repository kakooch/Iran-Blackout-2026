package ir.resaneh1.iptv.activity;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.medu.shad.R;
import ir.resaneh1.iptv.PresenterFragment;
import ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV;
import ir.resaneh1.iptv.fragment.ListFragment;
import ir.resaneh1.iptv.helper.DimensionHelper;
import ir.resaneh1.iptv.logger.MyLog;
import ir.resaneh1.iptv.model.GetPageInput;
import ir.resaneh1.iptv.model.GetPageOutput;
import ir.resaneh1.iptv.model.ListInput;
import ir.resaneh1.iptv.model.RecyclerViewListObject;
import ir.resaneh1.iptv.model.ScrollViewListObject;
import ir.resaneh1.iptv.model.TagObject;
import ir.resaneh1.iptv.presenter.MainClickHandler;
import ir.resaneh1.iptv.presenter.MainPresenterSelector;
import ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter;
import ir.resaneh1.iptv.presenter.abstracts.OnPresenterItemClickListener;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItemType;
import ir.resaneh1.iptv.presenter.abstracts.PresenterSelector;
import ir.resaneh1.iptv.presenter.adapter.MainAdapter;
import ir.resaneh1.iptv.presenters.BannerItemPresenter;
import ir.resaneh1.iptv.toolbar.ToolbarImageView;
import java.util.ArrayList;
import java.util.Iterator;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Components.EditTextBoldCursor;
import retrofit2.Call;
import retrofit2.Response;

/* loaded from: classes3.dex */
public class HomeFragment extends PresenterFragment {
    private View clearSearchBarIcon;
    private String lastSearchedText;
    private EditTextBoldCursor searchEditText;
    private String page = "homeandroid2";
    public boolean isHome = false;
    public boolean isForSearch = false;
    private Handler handler = new Handler();
    public boolean isLastPortrait = true;
    Runnable runnable = new Runnable() { // from class: ir.resaneh1.iptv.activity.HomeFragment.5
        @Override // java.lang.Runnable
        public void run() {
            HomeFragment.this.onSearchClick();
        }
    };

    @Override // ir.resaneh1.iptv.PresenterFragment
    public int getLayoutId() {
        return R.layout.activity_presenter_base_with_just_recyclerview;
    }

    public void setPage(String str) {
        this.page = str;
    }

    @Override // ir.resaneh1.iptv.PresenterFragment
    protected void findView() {
        super.findView();
    }

    @Override // ir.resaneh1.iptv.PresenterFragment
    protected void init() {
        super.init();
        this.swipeBackEnabled = false;
        initWithVerticalLinearLayoutManager();
        setToolbar();
        this.progressBar.setVisibility(4);
        getFragmentView().setBackgroundColor(this.mContext.getResources().getColor(R.color.backgroundColorGrey));
        Context context = this.mContext;
        MainAdapter mainAdapter = new MainAdapter(context, this.mainArrayList, MainPresenterSelector.getInstance(context), null, null);
        this.mainAdapter = mainAdapter;
        this.mainRecyclerView.setAdapter(mainAdapter);
        if (this.isForSearch) {
            return;
        }
        getPageRequest(new GetPageInput(this.page, new ArrayList(), BuildConfig.FLAVOR));
    }

    private void setToolbar() {
        if (!this.isForSearch) {
            this.toolbarMaker.setToolbarForHomeFragment(!this.isHome);
        } else {
            setSearchToolbar();
        }
    }

    void setSearchToolbar() {
        this.toolbarMaker.setToolbarWithBackButtonAndTextGrey((Activity) this.mContext, BuildConfig.FLAVOR);
        View viewCreateView = new ToolbarImageView().createView((Activity) this.mContext, R.drawable.ic_close_grey, Integer.valueOf(Theme.getColor(Theme.key_actionBarDefaultIcon)));
        this.clearSearchBarIcon = viewCreateView;
        this.toolbarMaker.addViewToLeftLayout(viewCreateView);
        this.clearSearchBarIcon.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.activity.HomeFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HomeFragment.this.searchEditText.setText(BuildConfig.FLAVOR);
                HomeFragment.this.cancelTimer();
                HomeFragment.this.lastSearchedText = BuildConfig.FLAVOR;
                HomeFragment.this.notFoundLayout.setVisibility(4);
                HomeFragment.this.clearSearchBarIcon.setVisibility(4);
            }
        });
        this.clearSearchBarIcon.setVisibility(4);
        EditTextBoldCursor editTextBoldCursor = new EditTextBoldCursor(this.mContext);
        this.searchEditText = editTextBoldCursor;
        editTextBoldCursor.setTextSize(1, 18.0f);
        this.searchEditText.setHintTextColor(this.mContext.getResources().getColor(R.color.grey_500));
        this.searchEditText.setTextColor(this.mContext.getResources().getColor(R.color.grey_900));
        this.searchEditText.setMaxLines(1);
        this.searchEditText.setTypeface(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM));
        this.searchEditText.setPadding(AndroidUtilities.dp(56.0f), 0, 0, 0);
        this.searchEditText.setGravity(21);
        this.searchEditText.setImeOptions(268435456);
        this.searchEditText.setInputType(16385);
        this.searchEditText.setImeOptions(3);
        this.searchEditText.setMinHeight(AndroidUtilities.dp(56.0f));
        this.searchEditText.setHint("دنبال چی میگردی؟");
        this.searchEditText.setCursorColor(this.mContext.getResources().getColor(R.color.grey_900));
        this.searchEditText.setCursorSize(AndroidUtilities.dp(20.0f));
        this.searchEditText.setCursorWidth(1.5f);
        this.searchEditText.setBackgroundColor(this.mContext.getResources().getColor(R.color.transparent));
        this.searchEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: ir.resaneh1.iptv.activity.HomeFragment.2
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i != 3) {
                    return false;
                }
                AndroidUtilities.hideKeyboard(HomeFragment.this.searchEditText);
                HomeFragment.this.onSearchClick();
                return true;
            }
        });
        this.searchEditText.addTextChangedListener(new TextWatcher() { // from class: ir.resaneh1.iptv.activity.HomeFragment.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (HomeFragment.this.searchEditText.getText().toString().length() > 0) {
                    HomeFragment.this.clearSearchBarIcon.setVisibility(0);
                } else {
                    HomeFragment.this.clearSearchBarIcon.setVisibility(4);
                }
                HomeFragment.this.cancelTimer();
                HomeFragment.this.startTimer();
            }
        });
        this.searchEditText.requestFocus();
        this.toolbarMaker.addViewToRightLayout(this.searchEditText);
        this.searchEditText.getLayoutParams().width = DimensionHelper.getScreenWidth((Activity) this.mContext) - AndroidUtilities.dp(56.0f);
    }

    public void getPageRequest(GetPageInput getPageInput) {
        this.mainArrayList.clear();
        View view = this.notFoundLayout;
        if (view != null) {
            view.setVisibility(4);
        }
        View view2 = this.retryLayout;
        if (view2 != null) {
            view2.setVisibility(4);
        }
        this.progressBar.setVisibility(0);
        ApiRequestIPTV.getInstance(this.currentAccount).getPage(getPageInput, new ApiRequestIPTV.Listener() { // from class: ir.resaneh1.iptv.activity.HomeFragment.4
            @Override // ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.Listener
            public void onResponse(Call call, Response response) {
                HomeFragment.this.progressBar.setVisibility(4);
                GetPageOutput getPageOutput = (GetPageOutput) response.body();
                ArrayList<TagObject> arrayList = getPageOutput.results;
                if (arrayList != null) {
                    Iterator<TagObject> it = arrayList.iterator();
                    while (it.hasNext()) {
                        TagObject next = it.next();
                        TagObject.TagType tagType = next.type;
                        if (tagType == TagObject.TagType.virtual_channel || tagType == TagObject.TagType.vod_film || tagType == TagObject.TagType.aod_track || tagType == TagObject.TagType.course || tagType == TagObject.TagType.tv_episode || tagType == TagObject.TagType.tv_channel || tagType == TagObject.TagType.operator || tagType == TagObject.TagType.item_link || tagType == TagObject.TagType.app) {
                            final ListInput listInput = new ListInput(next);
                            listInput.title = next.name;
                            RecyclerViewListObject recyclerViewListObject = new RecyclerViewListObject(listInput, MainPresenterSelector.getInstance(HomeFragment.this.mContext), HomeFragment.this.baseFragment);
                            recyclerViewListObject.onMoreTextClickListener = new OnPresenterItemClickListener() { // from class: ir.resaneh1.iptv.activity.HomeFragment.4.1
                                @Override // ir.resaneh1.iptv.presenter.abstracts.OnPresenterItemClickListener
                                public void onClick(AbstractPresenter.AbstractViewHolder abstractViewHolder) {
                                    HomeFragment.this.presentFragment(new ListFragment(listInput));
                                }
                            };
                            if (next.type == TagObject.TagType.operator) {
                                recyclerViewListObject.setGrid();
                                recyclerViewListObject.hasMoreText = false;
                            }
                            HomeFragment.this.mainArrayList.add(recyclerViewListObject);
                        } else if (tagType == TagObject.TagType.large_banner) {
                            ScrollViewListObject scrollViewListObject = new ScrollViewListObject(new ListInput(next), MainPresenterSelector.getInstance(HomeFragment.this.mContext));
                            scrollViewListObject.itemHeight = new BannerItemPresenter(HomeFragment.this.mContext).getHeight();
                            scrollViewListObject.hasLoadMore = false;
                            scrollViewListObject.onPresenterItemClickListener = new OnPresenterItemClickListener() { // from class: ir.resaneh1.iptv.activity.HomeFragment.4.2
                                @Override // ir.resaneh1.iptv.presenter.abstracts.OnPresenterItemClickListener
                                public void onClick(AbstractPresenter.AbstractViewHolder abstractViewHolder) {
                                    new MainClickHandler().onClick(HomeFragment.this.baseFragment, abstractViewHolder);
                                }
                            };
                            HomeFragment.this.mainArrayList.add(scrollViewListObject);
                        } else if (tagType == TagObject.TagType.small_banner) {
                            ListInput listInput2 = new ListInput(next);
                            final BannerItemPresenter bannerItemPresenter = new BannerItemPresenter(HomeFragment.this.mContext);
                            bannerItemPresenter.isSmall = true;
                            ScrollViewListObject scrollViewListObject2 = new ScrollViewListObject(listInput2, new PresenterSelector() { // from class: ir.resaneh1.iptv.activity.HomeFragment.4.3
                                @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterSelector
                                public AbstractPresenter getPresenter(PresenterItemType presenterItemType) {
                                    if (presenterItemType == PresenterItemType.Banner) {
                                        return bannerItemPresenter;
                                    }
                                    return MainPresenterSelector.getInstance(HomeFragment.this.mContext).getPresenter(presenterItemType);
                                }
                            });
                            scrollViewListObject2.itemHeight = bannerItemPresenter.getHeight();
                            scrollViewListObject2.hasLoadMore = false;
                            scrollViewListObject2.onPresenterItemClickListener = new OnPresenterItemClickListener() { // from class: ir.resaneh1.iptv.activity.HomeFragment.4.4
                                @Override // ir.resaneh1.iptv.presenter.abstracts.OnPresenterItemClickListener
                                public void onClick(AbstractPresenter.AbstractViewHolder abstractViewHolder) {
                                    new MainClickHandler().onClick(HomeFragment.this.baseFragment, abstractViewHolder);
                                }
                            };
                            HomeFragment.this.mainArrayList.add(scrollViewListObject2);
                        }
                    }
                    HomeFragment.this.mainAdapter.notifyDataSetChanged();
                    if (getPageOutput.results.size() == 0) {
                        HomeFragment homeFragment = HomeFragment.this;
                        if (homeFragment.isForSearch) {
                            homeFragment.notFoundLayout.setVisibility(0);
                            return;
                        }
                    }
                    HomeFragment.this.notFoundLayout.setVisibility(4);
                }
            }

            @Override // ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.Listener
            public void onFailure(Call call, Throwable th) {
                HomeFragment.this.progressBar.setVisibility(4);
                HomeFragment.this.lastSearchedText = BuildConfig.FLAVOR;
                HomeFragment.this.mainArrayList.clear();
                HomeFragment.this.mainAdapter.notifyDataSetChanged();
                HomeFragment.this.showRetryLayout();
            }
        });
    }

    @Override // ir.resaneh1.iptv.PresenterFragment
    public void retryCall() {
        super.retryCall();
        if (!this.isForSearch) {
            getPageRequest(new GetPageInput(this.page, new ArrayList(), BuildConfig.FLAVOR));
        } else {
            onSearchClick();
        }
    }

    @Override // ir.resaneh1.iptv.PresenterFragment, org.rbmain.ui.ActionBar.BaseFragment
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        MyLog.e("HomeFragment", "onConfigurationChanged: ");
        this.mainAdapter.notifyDataSetChanged();
    }

    public void startTimer() {
        this.handler.postDelayed(this.runnable, 900L);
    }

    public void cancelTimer() {
        this.handler.removeCallbacks(this.runnable);
    }

    @Override // ir.resaneh1.iptv.PresenterFragment, org.rbmain.ui.ActionBar.BaseFragment
    public void onResume() {
        super.onResume();
        MyLog.e("homeFragment", "onResume: ");
        MyLog.e("homeFragment", "onResume: isFirstTime");
        if (this.isLastPortrait != isPortrait()) {
            MyLog.e("homeFragment", "onResume: isFirstTime" + this.isLastPortrait + isPortrait());
            this.mainAdapter.notifyDataSetChanged();
        }
    }

    @Override // ir.resaneh1.iptv.PresenterFragment, org.rbmain.ui.ActionBar.BaseFragment
    public void onPause() {
        super.onPause();
        cancelTimer();
        this.isLastPortrait = isPortrait();
    }

    public void onSearchClick() {
        String string = this.searchEditText.getText().toString();
        if (string == null || string.equals(BuildConfig.FLAVOR) || string.equals(this.lastSearchedText)) {
            return;
        }
        this.lastSearchedText = string;
        getPageRequest(new GetPageInput("search_" + this.page, new ArrayList(), string));
    }

    @Override // ir.resaneh1.iptv.PresenterFragment
    public boolean isPortrait() {
        return this.mContext.getResources().getConfiguration().orientation == 1;
    }
}
