package ir.resaneh1.iptv.fragment;

import android.app.Activity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.cardview.widget.CardView;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.medu.shad.R;
import ir.resaneh1.iptv.PresenterFragment;
import ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger;
import ir.resaneh1.iptv.dialog.LoadingDialog;
import ir.resaneh1.iptv.dialog.PresenterItemPickerDialog;
import ir.resaneh1.iptv.fragment.DeliveryInfosListFragment;
import ir.resaneh1.iptv.helper.BasketHelper;
import ir.resaneh1.iptv.helper.ItemListRequest;
import ir.resaneh1.iptv.helper.ToastiLikeSnack;
import ir.resaneh1.iptv.model.BasketObject;
import ir.resaneh1.iptv.model.ButtonItem;
import ir.resaneh1.iptv.model.CreateBasketOrderInput;
import ir.resaneh1.iptv.model.CreateBasketOrderOutput;
import ir.resaneh1.iptv.model.DeliveryInfoObject;
import ir.resaneh1.iptv.model.DeliveryTimeObject;
import ir.resaneh1.iptv.model.DeliveryTypeObject;
import ir.resaneh1.iptv.model.EditTextItem;
import ir.resaneh1.iptv.model.GetDeliveryTimesInput;
import ir.resaneh1.iptv.model.GetListOutput;
import ir.resaneh1.iptv.model.ListInput;
import ir.resaneh1.iptv.model.MessangerOutput;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItem;
import ir.resaneh1.iptv.presenters.AddressPresenter;
import ir.resaneh1.iptv.presenters.ButtonPresenter;
import ir.resaneh1.iptv.presenters.TextLikeEditTextPresenter;
import java.util.ArrayList;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.LocaleController;
import org.rbmain.ui.ActionBar.BaseFragment;
import retrofit2.Call;

/* loaded from: classes3.dex */
public class BasketDeliveryTypeAndTimeFragment extends PresenterFragment {
    AddressPresenter addressPresenter;
    private final BasketObject basketObject;
    ButtonPresenter.MyViewHolder buttonHolder;
    public AddressPresenter.MyViewHolder deliveryInfoHolder;
    private DeliveryInfoObject deliveryInfoObject;
    private TextLikeEditTextPresenter.MyViewHolder deliveryTimeHolder;
    private TextLikeEditTextPresenter.MyViewHolder deliveryTypeHolder;
    public DeliveryTimeObject selectedDeliverTime;
    public DeliveryTypeObject selectedDeliveryType;
    public String orderId = BuildConfig.FLAVOR;
    View.OnClickListener onCreateClick = new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.BasketDeliveryTypeAndTimeFragment.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BasketDeliveryTypeAndTimeFragment basketDeliveryTypeAndTimeFragment = BasketDeliveryTypeAndTimeFragment.this;
            if (basketDeliveryTypeAndTimeFragment.selectedDeliveryType != null && basketDeliveryTypeAndTimeFragment.selectedDeliverTime != null) {
                basketDeliveryTypeAndTimeFragment.buttonHolder.showLoading();
                long totalAmount = BasketDeliveryTypeAndTimeFragment.this.basketObject.getTotalAmount();
                BasketDeliveryTypeAndTimeFragment basketDeliveryTypeAndTimeFragment2 = BasketDeliveryTypeAndTimeFragment.this;
                long j = totalAmount + basketDeliveryTypeAndTimeFragment2.selectedDeliveryType.amount;
                String str = basketDeliveryTypeAndTimeFragment2.basketObject.basket_id;
                String str2 = BasketDeliveryTypeAndTimeFragment.this.deliveryInfoObject.delivery_info_id;
                BasketDeliveryTypeAndTimeFragment basketDeliveryTypeAndTimeFragment3 = BasketDeliveryTypeAndTimeFragment.this;
                ApiRequestMessanger.getInstance(((BaseFragment) BasketDeliveryTypeAndTimeFragment.this).currentAccount).createBasketOrder(new CreateBasketOrderInput(str, str2, basketDeliveryTypeAndTimeFragment3.selectedDeliveryType.delivery_type_id, basketDeliveryTypeAndTimeFragment3.selectedDeliverTime.delivery_time_id, j), new ApiRequestMessanger.Listener() { // from class: ir.resaneh1.iptv.fragment.BasketDeliveryTypeAndTimeFragment.2.1
                    @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
                    public void onResponse(Call call, Object obj) {
                        CreateBasketOrderOutput createBasketOrderOutput = (CreateBasketOrderOutput) obj;
                        BasketDeliveryTypeAndTimeFragment.this.buttonHolder.hideLoading();
                        if (createBasketOrderOutput.is_expired) {
                            BasketHelper.backToBasket(((BaseFragment) BasketDeliveryTypeAndTimeFragment.this).currentAccount, BasketDeliveryTypeAndTimeFragment.this.basketObject.basket_id);
                            return;
                        }
                        String str3 = createBasketOrderOutput.order_id;
                        if (str3 != null) {
                            BasketDeliveryTypeAndTimeFragment basketDeliveryTypeAndTimeFragment4 = BasketDeliveryTypeAndTimeFragment.this;
                            basketDeliveryTypeAndTimeFragment4.orderId = str3;
                            basketDeliveryTypeAndTimeFragment4.presentFragment(new BasketFinalFragment(createBasketOrderOutput.basket, createBasketOrderOutput.delivery_info, createBasketOrderOutput.delivery_type, createBasketOrderOutput.delivery_time, BasketDeliveryTypeAndTimeFragment.this.orderId));
                        }
                    }

                    @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
                    public void onFailure(Call call, Throwable th) {
                        BasketDeliveryTypeAndTimeFragment.this.buttonHolder.hideLoading();
                    }

                    @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
                    public void onError(MessangerOutput messangerOutput) {
                        BasketDeliveryTypeAndTimeFragment.this.buttonHolder.hideLoading();
                    }
                });
                return;
            }
            ToastiLikeSnack.showL(basketDeliveryTypeAndTimeFragment.mContext, LocaleController.getString(R.string.select_shipment_and_date));
        }
    };
    View.OnClickListener onTypeClickListener = new AnonymousClass3();
    View.OnClickListener onTimeClickListener = new AnonymousClass4();

    @Override // ir.resaneh1.iptv.PresenterFragment
    public int getLayoutId() {
        return R.layout.activity_presenter_base_with_just_linearlayout;
    }

    public BasketDeliveryTypeAndTimeFragment(BasketObject basketObject, DeliveryInfoObject deliveryInfoObject) {
        this.deliveryInfoObject = deliveryInfoObject;
        this.basketObject = basketObject;
        this.fragmentName = "BasketDeliveryTypeAndTimeFragment";
    }

    private void setToolbar() {
        this.toolbarMaker.setToolbarWithBackButtonAndTextGrey((Activity) this.mContext, LocaleController.getString(R.string.select_shipment));
    }

    @Override // ir.resaneh1.iptv.PresenterFragment
    protected void init() {
        super.init();
        this.progressBar.setVisibility(4);
        this.fragmentView.setBackgroundColor(this.mContext.getResources().getColor(R.color.backgroundColorGrey));
        setToolbar();
        makeLayout();
    }

    private void makeLayout() {
        AddressPresenter addressPresenter = new AddressPresenter(this.mContext, new AddressPresenter.Listener() { // from class: ir.resaneh1.iptv.fragment.BasketDeliveryTypeAndTimeFragment.1
            @Override // ir.resaneh1.iptv.presenters.AddressPresenter.Listener
            public void onDelete(AddressPresenter.MyViewHolder myViewHolder) {
            }

            @Override // ir.resaneh1.iptv.presenters.AddressPresenter.Listener
            public void onEdit(AddressPresenter.MyViewHolder myViewHolder) {
            }

            @Override // ir.resaneh1.iptv.presenters.AddressPresenter.Listener
            public void onSelect(AddressPresenter.MyViewHolder myViewHolder) {
            }

            @Override // ir.resaneh1.iptv.presenters.AddressPresenter.Listener
            public void onChangeAddressClick(AddressPresenter.MyViewHolder myViewHolder) {
                BasketDeliveryTypeAndTimeFragment.this.presentFragment(new DeliveryInfosListFragment(BasketDeliveryTypeAndTimeFragment.this.deliveryInfoObject, true, DeliveryInfosListFragment.SelectButtonTypeEnum.selectToBuy));
            }
        });
        this.addressPresenter = addressPresenter;
        AddressPresenter.MyViewHolder myViewHolderCreateViewHolderAndBind = addressPresenter.createViewHolderAndBind(this.deliveryInfoObject);
        this.deliveryInfoHolder = myViewHolderCreateViewHolderAndBind;
        myViewHolderCreateViewHolderAndBind.cardView.setCardElevation(AndroidUtilities.dp(2.0f));
        this.deliveryInfoHolder.cardView.setMaxCardElevation(AndroidUtilities.dp(1.0f));
        this.linearLayout.addView(this.deliveryInfoHolder.itemView);
        ((LinearLayout.LayoutParams) this.deliveryInfoHolder.itemView.getLayoutParams()).setMargins(AndroidUtilities.dp(8.0f), AndroidUtilities.dp(8.0f), AndroidUtilities.dp(8.0f), 0);
        TextLikeEditTextPresenter textLikeEditTextPresenter = new TextLikeEditTextPresenter(this.mContext);
        EditTextItem editTextItem = new EditTextItem();
        editTextItem.hint = LocaleController.getString(R.string.shipment_way);
        editTextItem.onClickListener = this.onTypeClickListener;
        editTextItem.isEditable = false;
        TextLikeEditTextPresenter.MyViewHolder myViewHolderCreateViewHolderAndBind2 = textLikeEditTextPresenter.createViewHolderAndBind(editTextItem);
        this.deliveryTypeHolder = myViewHolderCreateViewHolderAndBind2;
        myViewHolderCreateViewHolderAndBind2.textView.setTextSize(1, 14.0f);
        CardView cardView = new CardView(this.mContext);
        ((FrameLayout.LayoutParams) this.deliveryTypeHolder.textView.getLayoutParams()).setMargins(0, 0, 0, 0);
        cardView.setCardBackgroundColor(-1);
        cardView.setPadding(0, 0, 0, 0);
        cardView.addView(this.deliveryTypeHolder.itemView);
        cardView.setCardElevation(AndroidUtilities.dp(1.0f));
        cardView.setMaxCardElevation(AndroidUtilities.dp(1.0f));
        this.linearLayout.addView(cardView);
        ((LinearLayout.LayoutParams) cardView.getLayoutParams()).setMargins(AndroidUtilities.dp(8.0f), AndroidUtilities.dp(8.0f), AndroidUtilities.dp(8.0f), 0);
        EditTextItem editTextItem2 = new EditTextItem();
        editTextItem2.hint = LocaleController.getString(R.string.shipment_date);
        editTextItem2.onClickListener = this.onTimeClickListener;
        TextLikeEditTextPresenter.MyViewHolder myViewHolderCreateViewHolderAndBind3 = textLikeEditTextPresenter.createViewHolderAndBind(editTextItem2);
        this.deliveryTimeHolder = myViewHolderCreateViewHolderAndBind3;
        myViewHolderCreateViewHolderAndBind3.textView.setTextSize(1, 14.0f);
        CardView cardView2 = new CardView(this.mContext);
        cardView2.addView(this.deliveryTimeHolder.itemView);
        ((FrameLayout.LayoutParams) this.deliveryTimeHolder.textView.getLayoutParams()).setMargins(0, 0, 0, 0);
        cardView2.setCardBackgroundColor(-1);
        cardView2.setPadding(0, 0, 0, 0);
        this.linearLayout.addView(cardView2);
        cardView2.setCardElevation(AndroidUtilities.dp(1.0f));
        cardView2.setMaxCardElevation(AndroidUtilities.dp(1.0f));
        ((LinearLayout.LayoutParams) cardView2.getLayoutParams()).setMargins(AndroidUtilities.dp(8.0f), AndroidUtilities.dp(8.0f), AndroidUtilities.dp(8.0f), AndroidUtilities.dp(8.0f));
        ButtonPresenter.MyViewHolder myViewHolderCreateViewHolderAndBind4 = new ButtonPresenter(this.mContext).createViewHolderAndBind(new ButtonItem(LocaleController.getString(R.string.complete_purchase), this.onCreateClick));
        this.buttonHolder = myViewHolderCreateViewHolderAndBind4;
        this.linearLayout.addView(myViewHolderCreateViewHolderAndBind4.itemView);
    }

    /* renamed from: ir.resaneh1.iptv.fragment.BasketDeliveryTypeAndTimeFragment$3, reason: invalid class name */
    class AnonymousClass3 implements View.OnClickListener {
        AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ListInput listInput = new ListInput(ListInput.ItemType.deliveryType);
            ListInput.DeliveryTypeInput deliveryTypeInput = new ListInput.DeliveryTypeInput();
            listInput.deliveryTypeInput = deliveryTypeInput;
            deliveryTypeInput.basket_id = BasketDeliveryTypeAndTimeFragment.this.basketObject.basket_id;
            listInput.deliveryTypeInput.delivery_info_id = BasketDeliveryTypeAndTimeFragment.this.deliveryInfoObject.delivery_info_id;
            final LoadingDialog loadingDialog = new LoadingDialog(BasketDeliveryTypeAndTimeFragment.this.getContext());
            new ItemListRequest().load(BasketDeliveryTypeAndTimeFragment.this.getContext(), listInput, new ItemListRequest.Listener() { // from class: ir.resaneh1.iptv.fragment.BasketDeliveryTypeAndTimeFragment.3.1
                @Override // ir.resaneh1.iptv.helper.ItemListRequest.Listener
                public void onFailure(Throwable th) {
                }

                @Override // ir.resaneh1.iptv.helper.ItemListRequest.Listener
                public void onResponse(ArrayList<? extends PresenterItem> arrayList, GetListOutput getListOutput) {
                    try {
                        if (loadingDialog.isShowing()) {
                            loadingDialog.dismiss();
                            new PresenterItemPickerDialog(LocaleController.getString(R.string.shipment_way), new ListInput(arrayList), new PresenterItemPickerDialog.Listener() { // from class: ir.resaneh1.iptv.fragment.BasketDeliveryTypeAndTimeFragment.3.1.1
                                @Override // ir.resaneh1.iptv.dialog.PresenterItemPickerDialog.Listener
                                public void onItemsSelected(PresenterItem presenterItem) {
                                    BasketDeliveryTypeAndTimeFragment.this.deliveryTypeHolder.textView.setText(presenterItem.getTitle());
                                    try {
                                        BasketDeliveryTypeAndTimeFragment.this.selectedDeliveryType = (DeliveryTypeObject) presenterItem;
                                    } catch (Exception unused) {
                                    }
                                    BasketDeliveryTypeAndTimeFragment basketDeliveryTypeAndTimeFragment = BasketDeliveryTypeAndTimeFragment.this;
                                    basketDeliveryTypeAndTimeFragment.selectedDeliverTime = null;
                                    basketDeliveryTypeAndTimeFragment.deliveryTimeHolder.textView.setText(BuildConfig.FLAVOR);
                                }
                            }, false).show();
                        }
                    } catch (Exception unused) {
                    }
                }
            });
        }
    }

    /* renamed from: ir.resaneh1.iptv.fragment.BasketDeliveryTypeAndTimeFragment$4, reason: invalid class name */
    class AnonymousClass4 implements View.OnClickListener {
        AnonymousClass4() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            DeliveryTypeObject deliveryTypeObject = BasketDeliveryTypeAndTimeFragment.this.selectedDeliveryType;
            if (deliveryTypeObject == null || (str = deliveryTypeObject.delivery_type_id) == null || str.isEmpty()) {
                ToastiLikeSnack.showL(BasketDeliveryTypeAndTimeFragment.this.mContext, LocaleController.getString(R.string.first_select_shipment_type));
                return;
            }
            ListInput listInput = new ListInput(ListInput.ItemType.deliveryTime);
            listInput.deliveryTimesInput = new GetDeliveryTimesInput(BasketDeliveryTypeAndTimeFragment.this.basketObject.basket_id, BasketDeliveryTypeAndTimeFragment.this.deliveryInfoObject.delivery_info_id, BasketDeliveryTypeAndTimeFragment.this.selectedDeliveryType.delivery_type_id);
            final LoadingDialog loadingDialog = new LoadingDialog(BasketDeliveryTypeAndTimeFragment.this.getContext());
            new ItemListRequest().load(BasketDeliveryTypeAndTimeFragment.this.getContext(), listInput, new ItemListRequest.Listener() { // from class: ir.resaneh1.iptv.fragment.BasketDeliveryTypeAndTimeFragment.4.1
                @Override // ir.resaneh1.iptv.helper.ItemListRequest.Listener
                public void onFailure(Throwable th) {
                }

                @Override // ir.resaneh1.iptv.helper.ItemListRequest.Listener
                public void onResponse(ArrayList<? extends PresenterItem> arrayList, GetListOutput getListOutput) {
                    try {
                        if (loadingDialog.isShowing()) {
                            loadingDialog.dismiss();
                            new PresenterItemPickerDialog(LocaleController.getString(R.string.shipment_date), new ListInput(arrayList), new PresenterItemPickerDialog.Listener() { // from class: ir.resaneh1.iptv.fragment.BasketDeliveryTypeAndTimeFragment.4.1.1
                                @Override // ir.resaneh1.iptv.dialog.PresenterItemPickerDialog.Listener
                                public void onItemsSelected(PresenterItem presenterItem) {
                                    BasketDeliveryTypeAndTimeFragment.this.deliveryTimeHolder.textView.setText(presenterItem.getTitle());
                                    try {
                                        BasketDeliveryTypeAndTimeFragment.this.selectedDeliverTime = (DeliveryTimeObject) presenterItem;
                                    } catch (Exception unused) {
                                    }
                                }
                            }, false).show();
                        }
                    } catch (Exception unused) {
                    }
                }
            });
        }
    }

    public void changeDeliveryInfoAndRefresh(DeliveryInfoObject deliveryInfoObject) {
        this.deliveryInfoObject = deliveryInfoObject;
        this.addressPresenter.onBindViewHolder(this.deliveryInfoHolder, deliveryInfoObject);
        this.selectedDeliverTime = null;
        this.selectedDeliveryType = null;
        ((EditTextItem) this.deliveryTypeHolder.item).text = BuildConfig.FLAVOR;
        ((EditTextItem) this.deliveryTimeHolder.item).text = BuildConfig.FLAVOR;
        TextLikeEditTextPresenter textLikeEditTextPresenter = new TextLikeEditTextPresenter(this.mContext);
        TextLikeEditTextPresenter.MyViewHolder myViewHolder = this.deliveryTypeHolder;
        textLikeEditTextPresenter.onBindViewHolder(myViewHolder, (EditTextItem) myViewHolder.item);
        TextLikeEditTextPresenter textLikeEditTextPresenter2 = new TextLikeEditTextPresenter(this.mContext);
        TextLikeEditTextPresenter.MyViewHolder myViewHolder2 = this.deliveryTimeHolder;
        textLikeEditTextPresenter2.onBindViewHolder(myViewHolder2, (EditTextItem) myViewHolder2.item);
    }
}
