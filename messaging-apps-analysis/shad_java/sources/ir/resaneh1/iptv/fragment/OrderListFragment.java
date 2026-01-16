package ir.resaneh1.iptv.fragment;

import android.app.Activity;
import ir.medu.shad.R;
import ir.resaneh1.iptv.PresenterFragment;
import ir.resaneh1.iptv.model.ListInput;
import ir.resaneh1.iptv.model.PaidOrdersInput;
import ir.resaneh1.iptv.presenter.MainClickHandler;
import ir.resaneh1.iptv.presenter.MainPresenterSelector;
import ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter;
import ir.resaneh1.iptv.presenter.abstracts.OnLoadMoreListener;
import ir.resaneh1.iptv.presenter.abstracts.OnPresenterItemClickListener;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItemType;
import ir.resaneh1.iptv.presenter.abstracts.PresenterSelector;
import ir.resaneh1.iptv.presenter.adapter.MainAdapter;
import ir.resaneh1.iptv.presenters.OrderPresenter;

/* loaded from: classes3.dex */
public class OrderListFragment extends PresenterFragment {
    public String type;

    private void makeLayout() {
    }

    @Override // ir.resaneh1.iptv.PresenterFragment
    public int getLayoutId() {
        return R.layout.activity_presenter_base_with_fixed_linearlayout_and_recycler;
    }

    public OrderListFragment(String str) {
        this.type = str;
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
        OnPresenterItemClickListener onPresenterItemClickListener = new OnPresenterItemClickListener() { // from class: ir.resaneh1.iptv.fragment.OrderListFragment.1
            @Override // ir.resaneh1.iptv.presenter.abstracts.OnPresenterItemClickListener
            public void onClick(AbstractPresenter.AbstractViewHolder abstractViewHolder) {
                new MainClickHandler().onClick(OrderListFragment.this.baseFragment, abstractViewHolder);
            }
        };
        final OrderPresenter orderPresenter = new OrderPresenter(this.mContext);
        MainAdapter mainAdapter = new MainAdapter(this.mContext, this.mainArrayList, new PresenterSelector() { // from class: ir.resaneh1.iptv.fragment.OrderListFragment.2
            @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterSelector
            public AbstractPresenter getPresenter(PresenterItemType presenterItemType) {
                if (presenterItemType == PresenterItemType.orderObject) {
                    return orderPresenter;
                }
                return MainPresenterSelector.getInstance(OrderListFragment.this.getContext()).getPresenter(presenterItemType);
            }
        }, onPresenterItemClickListener, new OnLoadMoreListener() { // from class: ir.resaneh1.iptv.fragment.OrderListFragment.3
            @Override // ir.resaneh1.iptv.presenter.abstracts.OnLoadMoreListener
            public void loadMore(int i) {
                OrderListFragment.this.loadItems();
            }
        });
        this.mainAdapter = mainAdapter;
        this.mainRecyclerView.setAdapter(mainAdapter);
        this.fragmentView.setBackgroundColor(this.mContext.getResources().getColor(R.color.backgroundColorGrey));
        this.mainAdapter.isWantLoadMore = false;
        makeLayout();
        ListInput listInput = new ListInput(ListInput.ItemType.paidOrder);
        this.listInput = listInput;
        listInput.paidOrdersInput = new PaidOrdersInput(this.type);
        addLoadMoreItem(true);
        loadItems();
    }

    private void setToolbar() {
        this.toolbarMaker.clearToolbar();
        this.toolbarMaker.setToolbarWithBackButtonAndTextGrey((Activity) this.mContext, "لیست سفارش ها");
    }
}
