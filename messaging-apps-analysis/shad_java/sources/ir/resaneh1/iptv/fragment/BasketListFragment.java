package ir.resaneh1.iptv.fragment;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import ir.medu.shad.R;
import ir.resaneh1.iptv.PresenterFragment;
import ir.resaneh1.iptv.helper.SpanHelper;
import ir.resaneh1.iptv.model.ListInput;
import ir.resaneh1.iptv.presenter.MainClickHandler;
import ir.resaneh1.iptv.presenter.MainPresenterSelector;
import ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter;
import ir.resaneh1.iptv.presenter.abstracts.OnDoneListener;
import ir.resaneh1.iptv.presenter.abstracts.OnLoadMoreListener;
import ir.resaneh1.iptv.presenter.abstracts.OnPresenterItemClickListener;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItemType;
import ir.resaneh1.iptv.presenter.abstracts.PresenterSelector;
import ir.resaneh1.iptv.presenter.adapter.MainAdapter;
import ir.resaneh1.iptv.presenters.BasketPresenter;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.LocaleController;

/* loaded from: classes3.dex */
public class BasketListFragment extends PresenterFragment {
    private boolean hideFloatingViewAfterDestroy;

    private void makeLayout() {
    }

    @Override // ir.resaneh1.iptv.PresenterFragment
    public int getLayoutId() {
        return R.layout.activity_presenter_base_with_fixed_linearlayout_and_recycler;
    }

    public BasketListFragment() {
        this.fragmentDebugName = "BasketListFragment";
    }

    @Override // ir.resaneh1.iptv.PresenterFragment
    protected void findView() {
        super.findView();
    }

    @Override // ir.resaneh1.iptv.PresenterFragment
    protected void init() {
        super.init();
        initWithVerticalLinearLayoutManager();
        setToolbar();
        this.progressBar.setVisibility(4);
        OnPresenterItemClickListener onPresenterItemClickListener = new OnPresenterItemClickListener() { // from class: ir.resaneh1.iptv.fragment.BasketListFragment.1
            @Override // ir.resaneh1.iptv.presenter.abstracts.OnPresenterItemClickListener
            public void onClick(AbstractPresenter.AbstractViewHolder abstractViewHolder) {
                BasketListFragment.this.mainArrayList.size();
                new MainClickHandler().onClick(BasketListFragment.this.baseFragment, abstractViewHolder);
                BasketListFragment.this.hideFloatingViewAfterDestroy = false;
                BasketListFragment.this.removeSelfFromStack();
            }
        };
        final BasketPresenter basketPresenter = new BasketPresenter(getContext());
        basketPresenter.onDeleteBasket = new OnDoneListener() { // from class: ir.resaneh1.iptv.fragment.BasketListFragment.2
            @Override // ir.resaneh1.iptv.presenter.abstracts.OnDoneListener
            public void onDone(AbstractPresenter.AbstractViewHolder abstractViewHolder) {
                BasketListFragment basketListFragment = BasketListFragment.this;
                if (basketListFragment.mainAdapter != null) {
                    try {
                        try {
                            int iIndexOf = basketListFragment.mainArrayList.indexOf(abstractViewHolder.item);
                            BasketListFragment.this.mainArrayList.remove(iIndexOf);
                            BasketListFragment.this.mainAdapter.notifyItemRemoved(iIndexOf);
                            if (BasketListFragment.this.mainArrayList.size() == 0) {
                                BasketListFragment.this.setNotFoundLayout();
                                BasketListFragment.this.notFoundLayout.setVisibility(0);
                            }
                        } catch (Exception unused) {
                        }
                    } catch (Exception unused2) {
                        BasketListFragment.this.mainArrayList.clear();
                        BasketListFragment.this.mainAdapter.notifyDataSetChanged();
                        ((PresenterFragment) BasketListFragment.this).isStopLoading = false;
                        BasketListFragment.this.loadItems();
                    }
                }
            }
        };
        MainAdapter mainAdapter = new MainAdapter(this.mContext, this.mainArrayList, new PresenterSelector() { // from class: ir.resaneh1.iptv.fragment.BasketListFragment.3
            @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterSelector
            public AbstractPresenter getPresenter(PresenterItemType presenterItemType) {
                if (presenterItemType == PresenterItemType.basket) {
                    return basketPresenter;
                }
                return MainPresenterSelector.getInstance(BasketListFragment.this.getContext()).getPresenter(presenterItemType);
            }
        }, onPresenterItemClickListener, new OnLoadMoreListener() { // from class: ir.resaneh1.iptv.fragment.BasketListFragment.4
            @Override // ir.resaneh1.iptv.presenter.abstracts.OnLoadMoreListener
            public void loadMore(int i) {
                BasketListFragment.this.loadItems();
            }
        });
        this.mainAdapter = mainAdapter;
        this.mainRecyclerView.setAdapter(mainAdapter);
        this.fragmentView.setBackgroundColor(this.mContext.getResources().getColor(R.color.backgroundColorGrey));
        this.mainAdapter.isWantLoadMore = false;
        makeLayout();
        this.listInput = new ListInput(ListInput.ItemType.basket);
        addLoadMoreItem(true);
        loadItems();
    }

    private void setToolbar() {
        this.toolbarMaker.clearToolbar();
        this.toolbarMaker.setToolbarWithBackButtonAndTextGrey((Activity) this.mContext, LocaleController.getString(R.string.basket_list));
    }

    @Override // ir.resaneh1.iptv.PresenterFragment, org.rbmain.ui.ActionBar.BaseFragment
    public void onResume() {
        super.onResume();
        if (this.refreshOnResume) {
            this.refreshOnResume = false;
            this.mainArrayList.clear();
            MainAdapter mainAdapter = this.mainAdapter;
            if (mainAdapter != null) {
                mainAdapter.notifyDataSetChanged();
            }
            this.notFoundLayout.setVisibility(4);
            addLoadMoreItem(true);
            loadItems();
        }
    }

    @Override // ir.resaneh1.iptv.PresenterFragment, org.rbmain.ui.ActionBar.BaseFragment
    public void onFragmentDestroy() {
        super.onFragmentDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.resaneh1.iptv.PresenterFragment
    public void setNotFoundLayout() {
        this.notFoundLayout.setVisibility(4);
        View view = this.notFoundLayout;
        if (view != null) {
            view.setVisibility(0);
            this.progressBar.setVisibility(4);
            ImageView imageView = (ImageView) this.notFoundLayout.findViewById(R.id.imageView);
            TextView textView = (TextView) this.notFoundLayout.findViewById(R.id.textView);
            imageView.setImageResource(R.drawable.ic_shop_cart);
            imageView.getLayoutParams().width = AndroidUtilities.dp(70.0f);
            imageView.getLayoutParams().height = AndroidUtilities.dp(70.0f);
            textView.setText(SpanHelper.makeBoldSpanWithColor(LocaleController.getString(R.string.empty_basket), this.mContext.getResources().getColor(R.color.grey_700)));
        }
        super.setNotFoundLayout();
    }
}
