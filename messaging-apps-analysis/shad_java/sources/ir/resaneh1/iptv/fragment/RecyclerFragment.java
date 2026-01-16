package ir.resaneh1.iptv.fragment;

import android.app.Activity;
import ir.medu.shad.R;
import ir.resaneh1.iptv.PresenterFragment;
import ir.resaneh1.iptv.helper.DimensionHelper;
import ir.resaneh1.iptv.model.ListInput;
import ir.resaneh1.iptv.presenter.MainClickHandler;
import ir.resaneh1.iptv.presenter.MainPresenterSelector;
import ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter;
import ir.resaneh1.iptv.presenter.abstracts.OnLoadMoreListener;
import ir.resaneh1.iptv.presenter.abstracts.OnPresenterItemClickListener;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItemType;
import ir.resaneh1.iptv.presenter.abstracts.PresenterSelector;
import ir.resaneh1.iptv.presenter.adapter.MainAdapter;
import ir.resaneh1.iptv.presenters.JJMatchRowPresenter;
import ir.resaneh1.iptv.presenters.NewsAdverOrEventRowPresenter;
import ir.resaneh1.iptv.presenters.NewsRowPresenter;
import org.rbmain.ui.LaunchActivity;

/* loaded from: classes3.dex */
public class RecyclerFragment extends PresenterFragment {
    public boolean isWantLoadMore = true;

    @Override // ir.resaneh1.iptv.PresenterFragment
    public int getLayoutId() {
        return R.layout.activity_presenter_base_just_recycler;
    }

    public RecyclerFragment(ListInput listInput) {
        this.listInput = listInput;
    }

    @Override // ir.resaneh1.iptv.PresenterFragment
    protected void init() {
        super.init();
        this.progressBar.setVisibility(4);
        initWithVerticalLinearLayoutManager();
        this.mainRecyclerView.getLayoutParams().width = DimensionHelper.getScreenMinDimension((Activity) this.mContext);
        getFragmentView().setBackgroundColor(this.mContext.getResources().getColor(R.color.grey_300));
        OnPresenterItemClickListener onPresenterItemClickListener = new OnPresenterItemClickListener() { // from class: ir.resaneh1.iptv.fragment.RecyclerFragment.1
            @Override // ir.resaneh1.iptv.presenter.abstracts.OnPresenterItemClickListener
            public void onClick(AbstractPresenter.AbstractViewHolder abstractViewHolder) {
                new MainClickHandler().onClick(((LaunchActivity) RecyclerFragment.this.mContext).getLastFragment(), abstractViewHolder);
            }
        };
        OnLoadMoreListener onLoadMoreListener = new OnLoadMoreListener() { // from class: ir.resaneh1.iptv.fragment.RecyclerFragment.2
            @Override // ir.resaneh1.iptv.presenter.abstracts.OnLoadMoreListener
            public void loadMore(int i) {
                RecyclerFragment.this.loadItems();
            }
        };
        MainAdapter mainAdapter = new MainAdapter(this.mContext, this.mainArrayList, new PresenterSelector() { // from class: ir.resaneh1.iptv.fragment.RecyclerFragment.3
            @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterSelector
            public AbstractPresenter getPresenter(PresenterItemType presenterItemType) {
                if (presenterItemType == PresenterItemType.news) {
                    return new NewsRowPresenter(RecyclerFragment.this.mContext);
                }
                if (presenterItemType == PresenterItemType.newsAdver || presenterItemType == PresenterItemType.newsEvent) {
                    return new NewsAdverOrEventRowPresenter(RecyclerFragment.this.mContext);
                }
                if (presenterItemType == PresenterItemType.jjMatch) {
                    return new JJMatchRowPresenter(RecyclerFragment.this.mContext);
                }
                return MainPresenterSelector.getInstance(RecyclerFragment.this.mContext).getPresenter(presenterItemType);
            }
        }, onPresenterItemClickListener, onLoadMoreListener);
        this.mainAdapter = mainAdapter;
        mainAdapter.isWantLoadMore = this.isWantLoadMore;
        this.mainRecyclerView.setAdapter(mainAdapter);
        if (this.mainAdapter.isLoadMoreAuto) {
            addLoadMoreItem(true);
        } else {
            addLoadMoreItem(false);
        }
        loadItems();
    }

    @Override // ir.resaneh1.iptv.PresenterFragment, org.rbmain.ui.ActionBar.BaseFragment
    public void onResume() {
        super.onResume();
    }

    @Override // ir.resaneh1.iptv.PresenterFragment
    public void retryCall() {
        loadItems();
    }
}
