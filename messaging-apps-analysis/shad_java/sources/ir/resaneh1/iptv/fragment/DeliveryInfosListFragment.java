package ir.resaneh1.iptv.fragment;

import android.app.Activity;
import android.content.DialogInterface;
import android.graphics.PorterDuff;
import android.text.SpannableString;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import io.github.inflationx.calligraphy3.BuildConfig;
import io.reactivex.observers.DisposableObserver;
import ir.medu.shad.R;
import ir.resaneh1.iptv.PresenterFragment;
import ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger;
import ir.resaneh1.iptv.dialog.LoadingDialog;
import ir.resaneh1.iptv.dialog.ThreeButtonDialog;
import ir.resaneh1.iptv.helper.SpanHelper;
import ir.resaneh1.iptv.logger.MyLog;
import ir.resaneh1.iptv.model.DeliveryInfoObject;
import ir.resaneh1.iptv.model.ListInput;
import ir.resaneh1.iptv.model.MessangerOutput;
import ir.resaneh1.iptv.model.RemoveDeliveryInfoInput;
import ir.resaneh1.iptv.model.SetDefaultDeliveryInfoInput;
import ir.resaneh1.iptv.presenter.MainClickHandler;
import ir.resaneh1.iptv.presenter.MainPresenterSelector;
import ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter;
import ir.resaneh1.iptv.presenter.abstracts.OnLoadMoreListener;
import ir.resaneh1.iptv.presenter.abstracts.OnPresenterItemClickListener;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItem;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItemType;
import ir.resaneh1.iptv.presenter.abstracts.PresenterSelector;
import ir.resaneh1.iptv.presenter.adapter.MainAdapter;
import ir.resaneh1.iptv.presenters.AddressPresenter;
import ir.resaneh1.iptv.toolbar.ToolbarImageViewIcon;
import java.util.Iterator;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.ui.ActionBar.BaseFragment;
import org.rbmain.ui.ActionBar.Theme;
import retrofit2.Call;

/* loaded from: classes3.dex */
public class DeliveryInfosListFragment extends PresenterFragment {
    public DeliveryInfoObject deliveryInfoObjectLastEditedOrAdded;
    public DeliveryInfoObject deliveryInfoObjectSelected;
    private boolean hasSelectButton;
    private SelectButtonTypeEnum selectButtonType;

    public enum SelectButtonTypeEnum {
        selectToBuy,
        selectToSetDefault
    }

    private void makeLayout() {
    }

    @Override // ir.resaneh1.iptv.PresenterFragment
    public int getLayoutId() {
        return R.layout.activity_presenter_base_with_fixed_linearlayout_and_recycler;
    }

    public DeliveryInfosListFragment(DeliveryInfoObject deliveryInfoObject, boolean z, SelectButtonTypeEnum selectButtonTypeEnum) {
        this.deliveryInfoObjectSelected = deliveryInfoObject;
        this.hasSelectButton = z;
        this.selectButtonType = selectButtonTypeEnum;
        this.fragmentName = "DeliveryInfosListFragment";
    }

    public DeliveryInfosListFragment(boolean z, SelectButtonTypeEnum selectButtonTypeEnum) {
        this.hasSelectButton = z;
        this.selectButtonType = selectButtonTypeEnum;
        this.fragmentName = "DeliveryInfosListFragment";
    }

    @Override // ir.resaneh1.iptv.PresenterFragment
    protected void findView() {
        super.findView();
    }

    @Override // ir.resaneh1.iptv.PresenterFragment
    protected void init() {
        super.init();
        this.progressBar.setVisibility(4);
        initWithVerticalLinearLayoutManager();
        setToolbar();
        OnPresenterItemClickListener onPresenterItemClickListener = new OnPresenterItemClickListener() { // from class: ir.resaneh1.iptv.fragment.DeliveryInfosListFragment.1
            @Override // ir.resaneh1.iptv.presenter.abstracts.OnPresenterItemClickListener
            public void onClick(AbstractPresenter.AbstractViewHolder abstractViewHolder) {
                new MainClickHandler().onClick(DeliveryInfosListFragment.this.baseFragment, abstractViewHolder);
            }
        };
        final AddressPresenter addressPresenter = new AddressPresenter(this.mContext, new AnonymousClass2());
        addressPresenter.isInList = true;
        addressPresenter.hasSelectButton = this.hasSelectButton;
        addressPresenter.selectButtonType = this.selectButtonType;
        MainAdapter mainAdapter = new MainAdapter(this.mContext, this.mainArrayList, new PresenterSelector() { // from class: ir.resaneh1.iptv.fragment.DeliveryInfosListFragment.3
            @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterSelector
            public AbstractPresenter getPresenter(PresenterItemType presenterItemType) {
                if (presenterItemType == PresenterItemType.AddressObject) {
                    return addressPresenter;
                }
                return MainPresenterSelector.getInstance(DeliveryInfosListFragment.this.mContext).getPresenter(presenterItemType);
            }
        }, onPresenterItemClickListener, new OnLoadMoreListener() { // from class: ir.resaneh1.iptv.fragment.DeliveryInfosListFragment.4
            @Override // ir.resaneh1.iptv.presenter.abstracts.OnLoadMoreListener
            public void loadMore(int i) {
                DeliveryInfosListFragment.this.loadItems();
            }
        });
        this.mainAdapter = mainAdapter;
        this.mainRecyclerView.setAdapter(mainAdapter);
        this.fragmentView.setBackgroundColor(this.mContext.getResources().getColor(R.color.backgroundColorGrey));
        this.mainAdapter.isWantLoadMore = false;
        makeLayout();
        this.listInput = new ListInput(ListInput.ItemType.deliveryInfos);
        addLoadMoreItem(true);
        loadItems();
    }

    /* renamed from: ir.resaneh1.iptv.fragment.DeliveryInfosListFragment$2, reason: invalid class name */
    class AnonymousClass2 implements AddressPresenter.Listener {
        @Override // ir.resaneh1.iptv.presenters.AddressPresenter.Listener
        public void onChangeAddressClick(AddressPresenter.MyViewHolder myViewHolder) {
        }

        AnonymousClass2() {
        }

        @Override // ir.resaneh1.iptv.presenters.AddressPresenter.Listener
        public void onEdit(AddressPresenter.MyViewHolder myViewHolder) {
            DeliveryInfosListFragment.this.presentFragment(new AddOrEditDeliveryInfoFragment((DeliveryInfoObject) myViewHolder.item));
        }

        @Override // ir.resaneh1.iptv.presenters.AddressPresenter.Listener
        public void onDelete(final AddressPresenter.MyViewHolder myViewHolder) {
            final ThreeButtonDialog threeButtonDialog = new ThreeButtonDialog(DeliveryInfosListFragment.this.mContext, "آیا می خواهید آدرس را حذف کنید؟");
            threeButtonDialog.button1.setText("بله");
            threeButtonDialog.button2.setText("خیر");
            threeButtonDialog.button2.setOnClickListener(new View.OnClickListener(this) { // from class: ir.resaneh1.iptv.fragment.DeliveryInfosListFragment.2.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    threeButtonDialog.dismiss();
                }
            });
            threeButtonDialog.button1.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.DeliveryInfosListFragment.2.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    threeButtonDialog.dismiss();
                    final LoadingDialog loadingDialog = new LoadingDialog(DeliveryInfosListFragment.this.mContext);
                    RemoveDeliveryInfoInput removeDeliveryInfoInput = new RemoveDeliveryInfoInput();
                    removeDeliveryInfoInput.delivery_info_id = ((DeliveryInfoObject) myViewHolder.item).delivery_info_id;
                    loadingDialog.show();
                    ApiRequestMessanger.getInstance(((BaseFragment) DeliveryInfosListFragment.this).currentAccount).removeDeliveryInfo(removeDeliveryInfoInput, new ApiRequestMessanger.Listener() { // from class: ir.resaneh1.iptv.fragment.DeliveryInfosListFragment.2.2.1
                        @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
                        public void onResponse(Call call, Object obj) {
                            loadingDialog.dismiss();
                            DeliveryInfosListFragment.this.refresh();
                        }

                        @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
                        public void onFailure(Call call, Throwable th) {
                            loadingDialog.dismiss();
                        }

                        @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
                        public void onError(MessangerOutput messangerOutput) {
                            loadingDialog.dismiss();
                        }
                    });
                    loadingDialog.setCancelable(false);
                }
            });
        }

        @Override // ir.resaneh1.iptv.presenters.AddressPresenter.Listener
        public void onSelect(AddressPresenter.MyViewHolder myViewHolder) {
            if (ApplicationLoader.applicationActivity == null) {
                return;
            }
            if (DeliveryInfosListFragment.this.selectButtonType == SelectButtonTypeEnum.selectToBuy) {
                DeliveryInfosListFragment.this.callSetDefaultAddress((DeliveryInfoObject) myViewHolder.item);
                if (ApplicationLoader.applicationActivity.getSecondLastFragment() instanceof BasketDeliveryTypeAndTimeFragment) {
                    DeliveryInfosListFragment.this.deliveryInfoObjectSelected = (DeliveryInfoObject) myViewHolder.item;
                    ApplicationLoader.applicationActivity.onBackPressed();
                    return;
                }
                return;
            }
            if (DeliveryInfosListFragment.this.selectButtonType == SelectButtonTypeEnum.selectToSetDefault) {
                Titem titem = myViewHolder.item;
                if (((DeliveryInfoObject) titem).is_default) {
                    return;
                }
                DeliveryInfosListFragment.this.callSetDefaultAddress((DeliveryInfoObject) titem);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callSetDefaultAddress(final DeliveryInfoObject deliveryInfoObject) {
        final LoadingDialog loadingDialog = new LoadingDialog(this.mContext);
        final DisposableObserver disposableObserver = (DisposableObserver) getApiRequestMessangerRx().setDefaultDeliveryInfo(new SetDefaultDeliveryInfoInput(deliveryInfoObject.delivery_info_id)).subscribeWith(new DisposableObserver<MessangerOutput>() { // from class: ir.resaneh1.iptv.fragment.DeliveryInfosListFragment.5
            @Override // io.reactivex.Observer
            public void onComplete() {
            }

            @Override // io.reactivex.Observer
            public void onNext(MessangerOutput messangerOutput) {
                if (DeliveryInfosListFragment.this.selectButtonType == SelectButtonTypeEnum.selectToSetDefault) {
                    Iterator<PresenterItem> it = DeliveryInfosListFragment.this.mainArrayList.iterator();
                    while (it.hasNext()) {
                        PresenterItem next = it.next();
                        if (next instanceof DeliveryInfoObject) {
                            DeliveryInfoObject deliveryInfoObject2 = (DeliveryInfoObject) next;
                            String str = deliveryInfoObject2.delivery_info_id;
                            if (str != null && str.equals(deliveryInfoObject.delivery_info_id)) {
                                deliveryInfoObject2.is_default = true;
                            } else {
                                deliveryInfoObject2.is_default = false;
                            }
                        }
                    }
                    DeliveryInfosListFragment.this.mainAdapter.notifyDataSetChanged();
                }
                loadingDialog.dismiss();
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
                loadingDialog.dismiss();
            }
        });
        ((PresenterFragment) this).compositeDisposable.add(disposableObserver);
        loadingDialog.setOnCancelListener(new DialogInterface.OnCancelListener(this) { // from class: ir.resaneh1.iptv.fragment.DeliveryInfosListFragment.6
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                DisposableObserver disposableObserver2 = disposableObserver;
                if (disposableObserver2 != null) {
                    disposableObserver2.dispose();
                }
            }
        });
    }

    @Override // ir.resaneh1.iptv.PresenterFragment, org.rbmain.ui.ActionBar.BaseFragment
    public void onResume() {
        super.onResume();
        if (this.refreshOnResume) {
            refresh();
        }
    }

    public void refresh() {
        this.notFoundLayout.setVisibility(8);
        this.isStopLoading = false;
        this.mainArrayList.clear();
        MainAdapter mainAdapter = this.mainAdapter;
        if (mainAdapter != null) {
            mainAdapter.notifyDataSetChanged();
        }
        addLoadMoreItem(true);
        loadItems();
        this.refreshOnResume = false;
    }

    private void setToolbar() {
        this.toolbarMaker.clearToolbar();
        this.toolbarMaker.setToolbarWithBackButtonAndTextGrey((Activity) this.mContext, "آدرس ها");
        ToolbarImageViewIcon toolbarImageViewIcon = new ToolbarImageViewIcon();
        toolbarImageViewIcon.createView((Activity) this.mContext, R.drawable.add_grey);
        toolbarImageViewIcon.imageView.setColorFilter(Theme.getColor(Theme.key_actionBarDefaultIcon), PorterDuff.Mode.MULTIPLY);
        toolbarImageViewIcon.view.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.DeliveryInfosListFragment.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DeliveryInfosListFragment.this.presentFragment(new AddOrEditDeliveryInfoFragment());
            }
        });
        this.toolbarMaker.addViewToLeftLayout(toolbarImageViewIcon.view);
        ((LinearLayout.LayoutParams) toolbarImageViewIcon.view.getLayoutParams()).setMargins(AndroidUtilities.dp(8.0f), 0, 0, 0);
    }

    @Override // ir.resaneh1.iptv.PresenterFragment, org.rbmain.ui.ActionBar.BaseFragment
    public boolean onBackPressed() {
        if (ApplicationLoader.applicationActivity.getSecondLastFragment() instanceof BasketDeliveryTypeAndTimeFragment) {
            BasketDeliveryTypeAndTimeFragment basketDeliveryTypeAndTimeFragment = (BasketDeliveryTypeAndTimeFragment) ApplicationLoader.applicationActivity.getSecondLastFragment();
            try {
                if (this.deliveryInfoObjectSelected != null) {
                    for (int i = 0; i < this.mainArrayList.size(); i++) {
                        if ((this.mainArrayList.get(i) instanceof DeliveryInfoObject) && ((DeliveryInfoObject) this.mainArrayList.get(i)).delivery_info_id.equals(this.deliveryInfoObjectSelected.delivery_info_id)) {
                            basketDeliveryTypeAndTimeFragment.changeDeliveryInfoAndRefresh((DeliveryInfoObject) this.mainArrayList.get(i));
                            return super.onBackPressed();
                        }
                    }
                }
            } catch (Exception e) {
                MyLog.handleException(e);
            }
            try {
                if (this.deliveryInfoObjectLastEditedOrAdded != null) {
                    for (int i2 = 0; i2 < this.mainArrayList.size(); i2++) {
                        if ((this.mainArrayList.get(i2) instanceof DeliveryInfoObject) && ((DeliveryInfoObject) this.mainArrayList.get(i2)).delivery_info_id.equals(this.deliveryInfoObjectLastEditedOrAdded.delivery_info_id)) {
                            basketDeliveryTypeAndTimeFragment.changeDeliveryInfoAndRefresh((DeliveryInfoObject) this.mainArrayList.get(i2));
                            return super.onBackPressed();
                        }
                    }
                }
            } catch (Exception e2) {
                MyLog.handleException(e2);
            }
            for (int i3 = 0; i3 < this.mainArrayList.size(); i3++) {
                try {
                    if (this.mainArrayList.get(i3) instanceof DeliveryInfoObject) {
                        basketDeliveryTypeAndTimeFragment.changeDeliveryInfoAndRefresh((DeliveryInfoObject) this.mainArrayList.get(i3));
                        return super.onBackPressed();
                    }
                } catch (Exception e3) {
                    MyLog.handleException(e3);
                }
            }
            basketDeliveryTypeAndTimeFragment.removeSelfFromStack();
            return super.onBackPressed();
        }
        return super.onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.resaneh1.iptv.PresenterFragment
    public void setNotFoundLayout() {
        super.setNotFoundLayout();
        View view = this.notFoundLayout;
        if (view != null) {
            view.setVisibility(0);
            this.progressBar.setVisibility(4);
            TextView textView = (TextView) this.notFoundLayout.findViewById(R.id.textView);
            SpannableString spannableString = new SpannableString("آدرسی ندارید");
            SpannableString spannableStringMakeWithColorAndRelativeSize = SpanHelper.makeWithColorAndRelativeSize(BuildConfig.FLAVOR, this.mContext.getResources().getColor(R.color.grey_900), 0.9f);
            textView.setText(spannableString);
            textView.append("\n");
            textView.append(spannableStringMakeWithColorAndRelativeSize);
        }
    }
}
