package ir.resaneh1.iptv.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.view.View;
import android.widget.LinearLayout;
import androidx.core.widget.NestedScrollView;
import com.google.android.material.appbar.AppBarLayout;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.iranlms.asemnavideoplayerlibrary.player.PlayerBaseFragment;
import ir.medu.shad.R;
import ir.resaneh1.iptv.PresenterFragment;
import ir.resaneh1.iptv.UIRowTextView;
import ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV;
import ir.resaneh1.iptv.helper.DimensionHelper;
import ir.resaneh1.iptv.model.GetNewsInput;
import ir.resaneh1.iptv.model.GetNewsListOutput;
import ir.resaneh1.iptv.model.GetNewsOutput;
import ir.resaneh1.iptv.model.GetRelatedNewsInput;
import ir.resaneh1.iptv.model.NewsHighlightObject;
import ir.resaneh1.iptv.model.NewsObject;
import ir.resaneh1.iptv.model.PlayerPresenterItem;
import ir.resaneh1.iptv.presenter.MainClickHandler;
import ir.resaneh1.iptv.presenter.MainPresenterSelector;
import ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter;
import ir.resaneh1.iptv.presenter.abstracts.OnPresenterItemClickListener;
import ir.resaneh1.iptv.presenter.adapter.MainAdapter;
import ir.resaneh1.iptv.presenters.NewsBodyPresenter;
import ir.resaneh1.iptv.presenters.NewsDetailHeaderPresenter;
import ir.resaneh1.iptv.presenters.PlayerPresenter;
import ir.resaneh1.iptv.toolbar.ToolbarImageView;
import java.util.ArrayList;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.ui.ActionBar.BaseFragment;
import retrofit2.Call;
import retrofit2.Response;

/* loaded from: classes3.dex */
public class NewsDetailFragment extends PresenterFragment {
    NewsDetailHeaderPresenter.MyViewHolder headerHolder;
    NewsDetailHeaderPresenter headerPresenter;
    public NewsHighlightObject highlightObject;
    private NewsObject newsObject;
    View.OnClickListener onPlayClick = new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.NewsDetailFragment.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            NewsDetailFragment.this.playVideo();
        }
    };
    private PlayerPresenter playerPresenter;
    PlayerPresenter.MyViewHolder playerPresenterHolder;
    ToolbarImageView toolbarImageViewShare;

    @Override // ir.resaneh1.iptv.PresenterFragment
    public int getLayoutId() {
        return R.layout.activity_presenter_base_with_header;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.resaneh1.iptv.PresenterFragment
    public void loadItems() {
    }

    public NewsDetailFragment(NewsObject newsObject) {
        this.newsObject = newsObject;
    }

    public NewsDetailFragment(NewsHighlightObject newsHighlightObject) {
        this.highlightObject = newsHighlightObject;
    }

    public NewsDetailFragment(String str) {
        NewsHighlightObject newsHighlightObject = new NewsHighlightObject();
        this.highlightObject = newsHighlightObject;
        newsHighlightObject.newsId = str;
    }

    @Override // ir.resaneh1.iptv.PresenterFragment
    protected void init() {
        super.init();
        setToolbarPrimary();
        this.playerPresenter = new PlayerPresenter((Activity) getContext());
        this.progressBar.setVisibility(4);
        getFragmentView().setBackgroundColor(this.mContext.getResources().getColor(R.color.backgroundColorGrey));
        initWithVerticalLinearLayoutManager();
        final MainClickHandler mainClickHandler = new MainClickHandler();
        OnPresenterItemClickListener onPresenterItemClickListener = new OnPresenterItemClickListener() { // from class: ir.resaneh1.iptv.fragment.NewsDetailFragment.1
            @Override // ir.resaneh1.iptv.presenter.abstracts.OnPresenterItemClickListener
            public void onClick(AbstractPresenter.AbstractViewHolder abstractViewHolder) {
                mainClickHandler.onClick(NewsDetailFragment.this.baseFragment, abstractViewHolder);
            }
        };
        Context context = this.mContext;
        MainAdapter mainAdapter = new MainAdapter(context, this.mainArrayList, MainPresenterSelector.getInstance(context), onPresenterItemClickListener, null);
        this.mainAdapter = mainAdapter;
        this.mainRecyclerView.setAdapter(mainAdapter);
        if (this.newsObject != null) {
            setHeader();
            getNews();
        } else {
            NewsHighlightObject newsHighlightObject = this.highlightObject;
            if (newsHighlightObject != null) {
                getNews(newsHighlightObject.newsId);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHeader() {
        setToolbar();
        LinearLayout linearLayout = this.headerContainer;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
            NewsDetailHeaderPresenter newsDetailHeaderPresenter = new NewsDetailHeaderPresenter(this.mContext);
            this.headerPresenter = newsDetailHeaderPresenter;
            NewsDetailHeaderPresenter.MyViewHolder myViewHolderCreateViewHolderAndBind = newsDetailHeaderPresenter.createViewHolderAndBind(this.newsObject);
            this.headerHolder = myViewHolderCreateViewHolderAndBind;
            myViewHolderCreateViewHolderAndBind.playImageView.setOnClickListener(this.onPlayClick);
            this.headerContainer.addView(this.headerHolder.itemView);
            this.headerContainer.getLayoutParams().height = DimensionHelper.getHeaderHeight(this.mContext);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setToolbar() {
        this.toolbarMaker.clearToolbar();
        this.toolbarMaker.setToolbarWithBackButtonAndTextWhite((Activity) this.mContext, "بازگشت");
        setShareImageToolbar();
    }

    public void setShareImageToolbar() {
        String str;
        if (this.toolbarImageViewShare == null) {
            ToolbarImageView toolbarImageView = new ToolbarImageView();
            this.toolbarImageViewShare = toolbarImageView;
            toolbarImageView.createView((Activity) this.mContext, R.drawable.ic_share_white);
            this.toolbarImageViewShare.imageView.setPadding(AndroidUtilities.dp(6.0f), AndroidUtilities.dp(16.0f), AndroidUtilities.dp(6.0f), AndroidUtilities.dp(16.0f));
            this.toolbarImageViewShare.view.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.NewsDetailFragment.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MainClickHandler mainClickHandler = new MainClickHandler();
                    NewsDetailFragment newsDetailFragment = NewsDetailFragment.this;
                    mainClickHandler.shareStringOrLink(newsDetailFragment.mContext, newsDetailFragment.newsObject.share_link);
                }
            });
        }
        NewsObject newsObject = this.newsObject;
        if (newsObject != null && (str = newsObject.share_link) != null && !str.isEmpty()) {
            this.toolbarImageViewShare.view.setVisibility(0);
        } else {
            this.toolbarImageViewShare.view.setVisibility(8);
        }
        this.toolbarMaker.addViewToLeftLayout(this.toolbarImageViewShare.view);
    }

    private void setToolbarPrimary() {
        this.toolbarMaker.clearToolbar();
        this.toolbarMaker.setToolbarWithBackButtonAndTextGrey((Activity) this.mContext, "بازگشت");
        setShareImageToolbar();
    }

    public void setLayout() {
        this.retryLayout.setVisibility(4);
        LinearLayout linearLayout = this.linearLayout;
        if (linearLayout == null) {
            return;
        }
        linearLayout.removeAllViews();
        this.linearLayout.setBackgroundColor(this.mContext.getResources().getColor(R.color.white));
        this.linearLayout.addView(new NewsBodyPresenter(this.mContext).createViewHolderAndBind(this.newsObject).itemView);
    }

    public void getNews() {
        NewsObject newsObject = this.newsObject;
        if (newsObject != null) {
            getNews(newsObject.id);
        }
    }

    public void getNews(String str) {
        this.retryLayout.setVisibility(4);
        this.progressBar.setVisibility(0);
        ApiRequestIPTV.getInstance(this.currentAccount).getNews(new GetNewsInput(str), new ApiRequestIPTV.Listener() { // from class: ir.resaneh1.iptv.fragment.NewsDetailFragment.3
            @Override // ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.Listener
            public void onResponse(Call call, Response response) {
                NewsDetailFragment.this.progressBar.setVisibility(4);
                NewsDetailFragment.this.retryLayout.setVisibility(4);
                GetNewsOutput getNewsOutput = (GetNewsOutput) response.body();
                NewsDetailFragment.this.newsObject = getNewsOutput.result.news;
                NewsDetailFragment newsDetailFragment = NewsDetailFragment.this;
                if (newsDetailFragment.highlightObject != null) {
                    newsDetailFragment.setHeader();
                } else {
                    newsDetailFragment.headerHolder.item = newsDetailFragment.newsObject;
                    NewsDetailFragment newsDetailFragment2 = NewsDetailFragment.this;
                    newsDetailFragment2.headerPresenter.refresh(newsDetailFragment2.headerHolder);
                }
                NewsDetailFragment.this.setLayout();
                NewsDetailFragment.this.getRelatedNews();
            }

            @Override // ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.Listener
            public void onFailure(Call call, Throwable th) {
                NewsDetailFragment.this.progressBar.setVisibility(4);
                NewsDetailFragment.this.showRetryLayout();
            }
        });
    }

    @Override // ir.resaneh1.iptv.PresenterFragment, org.rbmain.ui.ActionBar.BaseFragment
    public void onResume() {
        super.onResume();
    }

    public void getRelatedNews() {
        ApiRequestIPTV.getInstance(this.currentAccount).getRelatedNewsList(new GetRelatedNewsInput(this.newsObject.id, this.newsObject.category + BuildConfig.FLAVOR), new ApiRequestIPTV.Listener() { // from class: ir.resaneh1.iptv.fragment.NewsDetailFragment.4
            @Override // ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.Listener
            public void onFailure(Call call, Throwable th) {
            }

            @Override // ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.Listener
            public void onResponse(Call call, Response response) {
                GetNewsListOutput getNewsListOutput;
                GetNewsListOutput.NewsList newsList;
                ArrayList<NewsObject> arrayList;
                if (response.body() == null || (newsList = (getNewsListOutput = (GetNewsListOutput) response.body()).result) == null || (arrayList = newsList.newsList) == null || arrayList.size() <= 0) {
                    return;
                }
                NewsDetailFragment.this.linearLayout.addView(View.inflate(NewsDetailFragment.this.mContext, R.layout.row_space, null));
                NewsDetailFragment.this.linearLayout.addView(View.inflate(NewsDetailFragment.this.mContext, R.layout.row_space, null));
                UIRowTextView uIRowTextView = new UIRowTextView();
                uIRowTextView.createView((Activity) NewsDetailFragment.this.mContext, "مرتبط ها");
                uIRowTextView.textView.setTextSize(1, 14.0f);
                uIRowTextView.textView.setTextColor(NewsDetailFragment.this.mContext.getResources().getColor(R.color.grey_900));
                NewsDetailFragment.this.linearLayout.addView(uIRowTextView.view);
                NewsDetailFragment.this.mainArrayList.addAll(getNewsListOutput.result.newsList);
                NewsDetailFragment.this.mainAdapter.notifyItemRangeInserted(0, getNewsListOutput.result.newsList.size());
                ((NestedScrollView) NewsDetailFragment.this.findViewById(R.id.nastedScrollView)).smoothScrollBy(0, 0);
            }
        });
    }

    @Override // ir.resaneh1.iptv.PresenterFragment
    public void retryCall() {
        getNews();
    }

    @Override // ir.resaneh1.iptv.PresenterFragment, org.rbmain.ui.ActionBar.BaseFragment
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.headerPresenter.refresh(this.headerHolder);
    }

    void playVideo() {
        this.swipeBackEnabled = false;
        this.playerPresenterHolder = this.playerPresenter.createViewHolderAndBind(new PlayerPresenterItem(this.newsObject.streamUrl));
        this.headerHolder.frameLayout.removeAllViews();
        this.headerHolder.frameLayout.addView(this.playerPresenterHolder.itemView);
        findViewById(R.id.nastedScrollView).scrollTo(0, 0);
        ((AppBarLayout) findViewById(R.id.htab_appbar)).setExpanded(true);
        PlayerPresenter.destroyPlayer(getContext());
        setCloseToolbar();
        this.playerPresenter.playStream(this.playerPresenterHolder);
    }

    @Override // ir.resaneh1.iptv.PresenterFragment, org.rbmain.ui.ActionBar.BaseFragment
    public boolean onBackPressed() {
        PlayerBaseFragment playerBaseFragment;
        PlayerPresenter.MyViewHolder myViewHolder = this.playerPresenterHolder;
        if (myViewHolder == null || (playerBaseFragment = myViewHolder.playerFragment) == null || playerBaseFragment == null || !playerBaseFragment.consumeBackPress()) {
            return super.onBackPressed();
        }
        return false;
    }

    public void setCloseToolbar() {
        ToolbarImageView toolbarImageView = new ToolbarImageView();
        this.toolbarMaker.clearToolbar();
        this.toolbarMaker.addViewToRightLayout(toolbarImageView.createView((Activity) this.mContext, R.drawable.close_white));
        toolbarImageView.imageView.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.NewsDetailFragment.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NewsDetailFragment.this.setToolbar();
                PlayerPresenter.destroyPlayer(NewsDetailFragment.this.getContext());
                ((BaseFragment) NewsDetailFragment.this).swipeBackEnabled = true;
            }
        });
    }
}
