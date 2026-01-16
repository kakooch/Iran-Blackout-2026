package ir.resaneh1.iptv.fragment;

import android.app.Activity;
import android.view.View;
import ir.medu.shad.R;
import ir.resaneh1.iptv.PresenterFragment;
import ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger;
import ir.resaneh1.iptv.helper.NumberUtils;
import ir.resaneh1.iptv.model.BasketCategoryObject;
import ir.resaneh1.iptv.model.BasketItemObject;
import ir.resaneh1.iptv.model.BasketObject;
import ir.resaneh1.iptv.model.BasketPriceObject;
import ir.resaneh1.iptv.model.ButtonItem;
import ir.resaneh1.iptv.model.GetBasketInput;
import ir.resaneh1.iptv.model.GetBasketListOutput;
import ir.resaneh1.iptv.model.GetBasketOutput;
import ir.resaneh1.iptv.model.GetDefaultDeliveryInfoOutput;
import ir.resaneh1.iptv.model.MessangerOutput;
import ir.resaneh1.iptv.model.TitleObject;
import ir.resaneh1.iptv.presenter.MainClickHandler;
import ir.resaneh1.iptv.presenter.MainPresenterSelector;
import ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter;
import ir.resaneh1.iptv.presenter.abstracts.OnLoadMoreListener;
import ir.resaneh1.iptv.presenter.abstracts.OnPresenterItemClickListener;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItemType;
import ir.resaneh1.iptv.presenter.abstracts.PresenterSelector;
import ir.resaneh1.iptv.presenter.adapter.MainAdapter;
import ir.resaneh1.iptv.presenters.BasketAmountRowPresenter;
import ir.resaneh1.iptv.presenters.BasketCategroyRowPresenter;
import ir.resaneh1.iptv.presenters.BasketItemRowPresenter;
import ir.resaneh1.iptv.presenters.ButtonPresenter;
import java.util.ArrayList;
import java.util.Iterator;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.LocaleController;
import org.rbmain.ui.ActionBar.BaseFragment;
import retrofit2.Call;

/* loaded from: classes3.dex */
public class BasketDetailsFragment extends PresenterFragment {
    private BasketAmountRowPresenter basketAmountRowPresenter;
    private BasketCategroyRowPresenter basketCategoryRowPresenter;
    String basketId;
    private BasketItemRowPresenter basketItemPresenter;
    public BasketObject basketObject;
    View.OnClickListener onClickListener = new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.BasketDetailsFragment.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            final ButtonPresenter.MyViewHolder myViewHolder = (ButtonPresenter.MyViewHolder) view.getTag();
            myViewHolder.showLoading();
            ApiRequestMessanger.getInstance(((BaseFragment) BasketDetailsFragment.this).currentAccount).getDefaultDeliveryInfo(new ApiRequestMessanger.Listener() { // from class: ir.resaneh1.iptv.fragment.BasketDetailsFragment.7.1
                @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
                public void onResponse(Call call, Object obj) {
                    myViewHolder.hideLoading();
                    GetDefaultDeliveryInfoOutput getDefaultDeliveryInfoOutput = (GetDefaultDeliveryInfoOutput) obj;
                    if (getDefaultDeliveryInfoOutput.delivery_info != null) {
                        BasketDetailsFragment.this.presentFragment(new BasketDeliveryTypeAndTimeFragment(BasketDetailsFragment.this.basketObject, getDefaultDeliveryInfoOutput.delivery_info));
                    } else {
                        BasketDetailsFragment.this.presentFragment(new AddOrEditDeliveryInfoFragment(BasketDetailsFragment.this.basketObject));
                    }
                }

                @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
                public void onFailure(Call call, Throwable th) {
                    myViewHolder.hideLoading();
                }

                @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
                public void onError(MessangerOutput messangerOutput) {
                    myViewHolder.hideLoading();
                }
            });
        }
    };
    private BasketPriceObject totalAmountObject;

    @Override // ir.resaneh1.iptv.PresenterFragment
    public int getLayoutId() {
        return R.layout.activity_presenter_base_with_just_recyclerview;
    }

    public BasketDetailsFragment(String str) {
        this.basketId = str;
        this.fragmentName = "BasketDetailsFragment";
    }

    public BasketDetailsFragment(BasketObject basketObject) {
        this.basketObject = basketObject;
        this.basketId = basketObject.basket_id;
        this.fragmentName = "BasketDetailsFragment";
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
        OnPresenterItemClickListener onPresenterItemClickListener = new OnPresenterItemClickListener() { // from class: ir.resaneh1.iptv.fragment.BasketDetailsFragment.1
            @Override // ir.resaneh1.iptv.presenter.abstracts.OnPresenterItemClickListener
            public void onClick(AbstractPresenter.AbstractViewHolder abstractViewHolder) {
                new MainClickHandler().onClick(BasketDetailsFragment.this.baseFragment, abstractViewHolder);
            }
        };
        BasketItemRowPresenter basketItemRowPresenter = new BasketItemRowPresenter(this.mContext, this.basketObject);
        this.basketItemPresenter = basketItemRowPresenter;
        basketItemRowPresenter.changeBasketListener = new BasketItemRowPresenter.ChangeBasketListener() { // from class: ir.resaneh1.iptv.fragment.BasketDetailsFragment.2
            @Override // ir.resaneh1.iptv.presenters.BasketItemRowPresenter.ChangeBasketListener
            public void changeBasket(BasketObject basketObject) {
                BasketDetailsFragment basketDetailsFragment = BasketDetailsFragment.this;
                basketDetailsFragment.basketObject = basketObject;
                if (basketDetailsFragment.totalAmountObject != null) {
                    BasketDetailsFragment basketDetailsFragment2 = BasketDetailsFragment.this;
                    int iIndexOf = basketDetailsFragment2.mainArrayList.indexOf(basketDetailsFragment2.totalAmountObject);
                    if (iIndexOf > 0) {
                        BasketDetailsFragment.this.totalAmountObject.price = NumberUtils.getPriceStringWithToman(basketObject.getTotalAmount(), false);
                        BasketDetailsFragment.this.mainAdapter.notifyItemChanged(iIndexOf);
                    }
                }
                BasketDetailsFragment.this.updateLastFragmentIfNeeded();
            }

            @Override // ir.resaneh1.iptv.presenters.BasketItemRowPresenter.ChangeBasketListener
            public void dropBasket() {
                BasketDetailsFragment.this.updateLastFragmentIfNeeded();
                if (ApplicationLoader.applicationActivity != null) {
                    ApplicationLoader.applicationActivity.onBackPressed();
                }
            }

            @Override // ir.resaneh1.iptv.presenters.BasketItemRowPresenter.ChangeBasketListener
            public void onItemRemoved(BasketItemObject basketItemObject) {
                BasketDetailsFragment.this.updateLastFragmentIfNeeded();
                int i = 0;
                while (true) {
                    if (i >= BasketDetailsFragment.this.mainArrayList.size()) {
                        i = -1;
                        break;
                    } else if ((BasketDetailsFragment.this.mainArrayList.get(i) instanceof BasketItemObject) && ((BasketItemObject) BasketDetailsFragment.this.mainArrayList.get(i)).item_id.equals(basketItemObject.item_id)) {
                        break;
                    } else {
                        i++;
                    }
                }
                if (i >= 0) {
                    BasketDetailsFragment.this.mainArrayList.remove(i);
                    BasketDetailsFragment.this.mainAdapter.notifyItemRemoved(i);
                }
            }
        };
        this.basketCategoryRowPresenter = new BasketCategroyRowPresenter(this.mContext);
        this.basketAmountRowPresenter = new BasketAmountRowPresenter(this.mContext);
        MainAdapter mainAdapter = new MainAdapter(this.mContext, this.mainArrayList, new PresenterSelector() { // from class: ir.resaneh1.iptv.fragment.BasketDetailsFragment.3
            @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterSelector
            public AbstractPresenter getPresenter(PresenterItemType presenterItemType) {
                if (presenterItemType == PresenterItemType.product) {
                    return BasketDetailsFragment.this.basketItemPresenter;
                }
                if (presenterItemType == PresenterItemType.basketPrice) {
                    return BasketDetailsFragment.this.basketAmountRowPresenter;
                }
                if (presenterItemType == PresenterItemType.title) {
                    return BasketDetailsFragment.this.basketCategoryRowPresenter;
                }
                return MainPresenterSelector.getInstance(BasketDetailsFragment.this.mContext).getPresenter(presenterItemType);
            }
        }, onPresenterItemClickListener, new OnLoadMoreListener() { // from class: ir.resaneh1.iptv.fragment.BasketDetailsFragment.4
            @Override // ir.resaneh1.iptv.presenter.abstracts.OnLoadMoreListener
            public void loadMore(int i) {
                BasketDetailsFragment.this.loadItems();
            }
        });
        this.mainAdapter = mainAdapter;
        this.mainRecyclerView.setAdapter(mainAdapter);
        this.fragmentView.setBackgroundColor(this.mContext.getResources().getColor(R.color.backgroundColorGrey));
        this.mainAdapter.isWantLoadMore = false;
        BasketObject basketObject = this.basketObject;
        if (basketObject == null || !basketObject.basket_id.equals(this.basketId)) {
            callGetObject();
        } else {
            makeLayout();
        }
    }

    public void updateLastFragmentIfNeeded() {
        BaseFragment secondLastFragment = ApplicationLoader.applicationActivity.getSecondLastFragment();
        if (secondLastFragment instanceof BasketListFragment) {
            ((BasketListFragment) secondLastFragment).refreshOnResume = true;
        }
    }

    @Override // ir.resaneh1.iptv.PresenterFragment, org.rbmain.ui.ActionBar.BaseFragment
    public void onResume() {
        super.onResume();
    }

    @Override // ir.resaneh1.iptv.PresenterFragment, org.rbmain.ui.ActionBar.BaseFragment
    public void onFragmentDestroy() {
        super.onFragmentDestroy();
        try {
            boolean z = ApplicationLoader.applicationActivity.getSecondLastFragment() instanceof BasketListFragment;
        } catch (Exception unused) {
        }
    }

    private void callGetObject() {
        String str = this.basketId;
        if (str == null || str.isEmpty()) {
            this.progressBar.setVisibility(0);
            ApiRequestMessanger.getInstance(this.currentAccount).getBasketList(new ApiRequestMessanger.Listener() { // from class: ir.resaneh1.iptv.fragment.BasketDetailsFragment.5
                @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
                public void onResponse(Call call, Object obj) {
                    BasketDetailsFragment.this.progressBar.setVisibility(4);
                    GetBasketListOutput getBasketListOutput = (GetBasketListOutput) obj;
                    ArrayList<BasketObject> arrayList = getBasketListOutput.baskets;
                    if (arrayList == null || arrayList.size() <= 0) {
                        return;
                    }
                    BasketDetailsFragment.this.basketObject = getBasketListOutput.baskets.get(0);
                    BasketItemRowPresenter basketItemRowPresenter = BasketDetailsFragment.this.basketItemPresenter;
                    BasketDetailsFragment basketDetailsFragment = BasketDetailsFragment.this;
                    BasketObject basketObject = basketDetailsFragment.basketObject;
                    basketItemRowPresenter.basketObject = basketObject;
                    basketDetailsFragment.basketId = basketObject.basket_id;
                    basketDetailsFragment.setToolbar();
                    BasketDetailsFragment.this.makeLayout();
                }

                @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
                public void onFailure(Call call, Throwable th) {
                    BasketDetailsFragment.this.showRetryLayout();
                    BasketDetailsFragment.this.progressBar.setVisibility(4);
                }

                @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
                public void onError(MessangerOutput messangerOutput) {
                    BasketDetailsFragment.this.showRetryLayout();
                    BasketDetailsFragment.this.progressBar.setVisibility(4);
                }
            });
        } else {
            this.progressBar.setVisibility(0);
            ApiRequestMessanger.getInstance(this.currentAccount).getBasket(new GetBasketInput(this.basketId), new ApiRequestMessanger.Listener() { // from class: ir.resaneh1.iptv.fragment.BasketDetailsFragment.6
                @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
                public void onResponse(Call call, Object obj) {
                    BasketDetailsFragment.this.progressBar.setVisibility(4);
                    GetBasketOutput getBasketOutput = (GetBasketOutput) obj;
                    if (getBasketOutput != null) {
                        BasketDetailsFragment basketDetailsFragment = BasketDetailsFragment.this;
                        basketDetailsFragment.basketObject = getBasketOutput.basket;
                        BasketItemRowPresenter basketItemRowPresenter = basketDetailsFragment.basketItemPresenter;
                        BasketDetailsFragment basketDetailsFragment2 = BasketDetailsFragment.this;
                        basketItemRowPresenter.basketObject = basketDetailsFragment2.basketObject;
                        basketDetailsFragment2.setToolbar();
                        BasketDetailsFragment.this.makeLayout();
                    }
                }

                @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
                public void onFailure(Call call, Throwable th) {
                    BasketDetailsFragment.this.showRetryLayout();
                    BasketDetailsFragment.this.progressBar.setVisibility(4);
                }

                @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
                public void onError(MessangerOutput messangerOutput) {
                    BasketDetailsFragment.this.showRetryLayout();
                    BasketDetailsFragment.this.progressBar.setVisibility(4);
                }
            });
        }
    }

    @Override // ir.resaneh1.iptv.PresenterFragment
    public void retryCall() {
        callGetObject();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void makeLayout() {
        this.progressBar.setVisibility(4);
        this.notFoundLayout.setVisibility(4);
        BasketObject basketObject = this.basketObject;
        if (basketObject == null || basketObject.items == null) {
            this.notFoundLayout.setVisibility(0);
            return;
        }
        this.mainArrayList.clear();
        this.mainAdapter.notifyDataSetChanged();
        ArrayList<BasketCategoryObject> arrayList = this.basketObject.categories;
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<BasketCategoryObject> it = this.basketObject.categories.iterator();
            while (it.hasNext()) {
                BasketCategoryObject next = it.next();
                this.mainArrayList.add(new TitleObject(next.title));
                Iterator<BasketItemObject> it2 = this.basketObject.items.iterator();
                while (it2.hasNext()) {
                    BasketItemObject next2 = it2.next();
                    if (next2.category_id.equals(next.category_id)) {
                        this.mainArrayList.add(next2);
                    }
                }
            }
        } else {
            this.mainArrayList.addAll(this.basketObject.items);
        }
        BasketPriceObject basketPriceObject = new BasketPriceObject(NumberUtils.getPriceStringWithToman(this.basketObject.getTotalAmount(), false));
        this.totalAmountObject = basketPriceObject;
        this.mainArrayList.add(basketPriceObject);
        this.mainArrayList.add(new ButtonItem(LocaleController.getString(R.string.complete_purchase), this.onClickListener));
        this.mainAdapter.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setToolbar() {
        this.toolbarMaker.clearToolbar();
        BasketObject basketObject = this.basketObject;
        if (basketObject != null && basketObject.provider_title != null) {
            this.toolbarMaker.setToolbarWithBackButtonAndTextGrey((Activity) this.mContext, LocaleController.getString(R.string.cart_with_space) + this.basketObject.provider_title);
            return;
        }
        this.toolbarMaker.setToolbarWithBackButtonAndTextGrey((Activity) this.mContext, LocaleController.getString(R.string.cart));
    }
}
