package ir.resaneh1.iptv.fragment;

import android.app.Activity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.medu.shad.R;
import ir.resaneh1.iptv.PresenterFragment;
import ir.resaneh1.iptv.UIView.UIApplyDiscountCode;
import ir.resaneh1.iptv.UIView.UIOrderFinalPricesView;
import ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger;
import ir.resaneh1.iptv.helper.BasketHelper;
import ir.resaneh1.iptv.helper.NumberUtils;
import ir.resaneh1.iptv.helper.PaymentManager;
import ir.resaneh1.iptv.helper.ToastiLikeSnack;
import ir.resaneh1.iptv.model.ApplyOrderDiscountCodeInput;
import ir.resaneh1.iptv.model.ApplyOrderDiscountCodeOutput;
import ir.resaneh1.iptv.model.BasketObject;
import ir.resaneh1.iptv.model.ButtonItem;
import ir.resaneh1.iptv.model.DeliveryInfoObject;
import ir.resaneh1.iptv.model.DeliveryTimeObject;
import ir.resaneh1.iptv.model.DeliveryTypeObject;
import ir.resaneh1.iptv.model.GetOrderPaymentInfoInput;
import ir.resaneh1.iptv.model.GetOrderPaymentInfoOutput;
import ir.resaneh1.iptv.model.MessangerOutput;
import ir.resaneh1.iptv.presenters.AddressBriefPresenter;
import ir.resaneh1.iptv.presenters.BasketPresenter;
import ir.resaneh1.iptv.presenters.ButtonPresenter;
import ir.resaneh1.iptv.presenters.EditTextCostPresenter;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.LocaleController;
import org.rbmain.ui.ActionBar.BaseFragment;
import retrofit2.Call;

/* loaded from: classes3.dex */
public class BasketFinalFragment extends PresenterFragment {
    private final BasketObject basketObject;
    private final DeliveryInfoObject deliveryInfoObject;
    public DeliveryTimeObject deliveryTime;
    private DeliveryTypeObject deliveryType;
    public Call lastCall;
    public String orderId;
    public ButtonPresenter.MyViewHolder payButtonHolder;
    public UIApplyDiscountCode uiApplyDiscountCode;
    private UIOrderFinalPricesView uiOrderFinalPricesView;
    public long afterDiscountAmount = -1;
    public long discountAmount = 0;
    public boolean isLoading = false;
    View.OnClickListener onApplyDiscountClick = new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.BasketFinalFragment.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AndroidUtilities.hideKeyboard(view);
            BasketFinalFragment.this.callApplyDiscount(BasketFinalFragment.this.uiApplyDiscountCode.editText.getText().toString());
        }
    };
    View.OnClickListener onDeleteDiscountClick = new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.BasketFinalFragment.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AndroidUtilities.hideKeyboard(view);
            BasketFinalFragment.this.callApplyDiscount(null);
        }
    };
    View.OnClickListener onPayClick = new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.BasketFinalFragment.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BasketFinalFragment.this.callGetPaymentInfo();
        }
    };

    @Override // ir.resaneh1.iptv.PresenterFragment
    public int getLayoutId() {
        return R.layout.activity_presenter_base_with_just_linearlayout;
    }

    public BasketFinalFragment(BasketObject basketObject, DeliveryInfoObject deliveryInfoObject, DeliveryTypeObject deliveryTypeObject, DeliveryTimeObject deliveryTimeObject, String str) {
        this.basketObject = basketObject;
        this.deliveryInfoObject = deliveryInfoObject;
        this.deliveryType = deliveryTypeObject;
        this.deliveryTime = deliveryTimeObject;
        this.orderId = str;
        this.fragmentName = "BasketFinalFragment";
    }

    private void setToolbar() {
        this.toolbarMaker.setToolbarWithBackButtonAndTextGrey((Activity) this.mContext, LocaleController.getString(R.string.final_purchase));
    }

    @Override // ir.resaneh1.iptv.PresenterFragment
    protected void init() {
        super.init();
        this.progressBar.setVisibility(4);
        this.fragmentView.setBackgroundColor(this.mContext.getResources().getColor(R.color.backgroundColorGrey));
        setToolbar();
        makeLayout();
    }

    @Override // ir.resaneh1.iptv.PresenterFragment, org.rbmain.ui.ActionBar.BaseFragment
    public void onPause() {
        Call call = this.lastCall;
        if (call != null) {
            call.cancel();
            this.lastCall = null;
        }
        super.onPause();
    }

    private void makeLayout() {
        BasketPresenter basketPresenter = new BasketPresenter(this.mContext);
        basketPresenter.hasButton = false;
        BasketPresenter.MyViewHolder myViewHolderCreateViewHolderAndBind = basketPresenter.createViewHolderAndBind(this.basketObject);
        myViewHolderCreateViewHolderAndBind.textViewTitle.setVisibility(8);
        myViewHolderCreateViewHolderAndBind.progressBarContainer.setVisibility(8);
        this.linearLayout.addView(myViewHolderCreateViewHolderAndBind.itemView);
        ((LinearLayout.LayoutParams) myViewHolderCreateViewHolderAndBind.itemView.getLayoutParams()).setMargins(AndroidUtilities.dp(8.0f), AndroidUtilities.dp(8.0f), AndroidUtilities.dp(8.0f), AndroidUtilities.dp(4.0f));
        AddressBriefPresenter addressBriefPresenter = new AddressBriefPresenter(this.mContext);
        AddressBriefPresenter.MyViewHolder myViewHolderCreateViewHolderAndBind2 = addressBriefPresenter.createViewHolderAndBind(this.deliveryInfoObject);
        this.linearLayout.addView(myViewHolderCreateViewHolderAndBind2.itemView);
        ((LinearLayout.LayoutParams) myViewHolderCreateViewHolderAndBind2.itemView.getLayoutParams()).setMargins(AndroidUtilities.dp(8.0f), AndroidUtilities.dp(4.0f), AndroidUtilities.dp(8.0f), AndroidUtilities.dp(4.0f));
        addressBriefPresenter.bindDeliveryTime(myViewHolderCreateViewHolderAndBind2, this.deliveryTime);
        UIApplyDiscountCode uIApplyDiscountCode = new UIApplyDiscountCode();
        this.uiApplyDiscountCode = uIApplyDiscountCode;
        uIApplyDiscountCode.createView((Activity) this.mContext);
        this.uiApplyDiscountCode.textViewDescription.setVisibility(8);
        this.uiApplyDiscountCode.buttonHolder.button.setOnClickListener(this.onApplyDiscountClick);
        this.uiApplyDiscountCode.imageViewClose.setOnClickListener(this.onDeleteDiscountClick);
        this.uiApplyDiscountCode.editText.addTextChangedListener(new TextWatcher() { // from class: ir.resaneh1.iptv.fragment.BasketFinalFragment.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                BasketFinalFragment.this.uiApplyDiscountCode.hideCloseView();
                BasketFinalFragment.this.uiApplyDiscountCode.buttonHolder.itemView.setVisibility(0);
                BasketFinalFragment.this.uiApplyDiscountCode.textViewDescription.setVisibility(8);
            }
        });
        this.linearLayout.addView(this.uiApplyDiscountCode.view);
        ((LinearLayout.LayoutParams) this.uiApplyDiscountCode.view.getLayoutParams()).setMargins(AndroidUtilities.dp(8.0f), AndroidUtilities.dp(4.0f), AndroidUtilities.dp(8.0f), AndroidUtilities.dp(4.0f));
        UIOrderFinalPricesView uIOrderFinalPricesView = new UIOrderFinalPricesView();
        this.uiOrderFinalPricesView = uIOrderFinalPricesView;
        uIOrderFinalPricesView.createView((Activity) this.mContext);
        this.uiOrderFinalPricesView.textViewBasketAmount.setText(NumberUtils.getPriceStringWithToman(this.basketObject.getTotalAmount(), false));
        this.uiOrderFinalPricesView.textViewShiping.setText(NumberUtils.getPriceStringWithToman(this.deliveryType.amount, false));
        this.uiOrderFinalPricesView.textViewTotalAmount.setText(NumberUtils.getPriceStringWithToman(this.basketObject.getTotalAmount() + this.deliveryType.amount, false));
        this.linearLayout.addView(this.uiOrderFinalPricesView.view);
        ((LinearLayout.LayoutParams) this.uiOrderFinalPricesView.view.getLayoutParams()).setMargins(AndroidUtilities.dp(8.0f), AndroidUtilities.dp(4.0f), AndroidUtilities.dp(8.0f), AndroidUtilities.dp(4.0f));
        ButtonPresenter.MyViewHolder myViewHolderCreateViewHolderAndBind3 = new ButtonPresenter(this.mContext).createViewHolderAndBind(new ButtonItem(LocaleController.getString(R.string.pay), this.onPayClick));
        this.payButtonHolder = myViewHolderCreateViewHolderAndBind3;
        this.linearLayout.addView(myViewHolderCreateViewHolderAndBind3.itemView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callApplyDiscount(String str) {
        if (this.isLoading) {
            return;
        }
        if (str != null && str.isEmpty()) {
            ToastiLikeSnack.showL(this.mContext, LocaleController.getString(R.string.enter_off_code));
            return;
        }
        if (this.orderId.isEmpty()) {
            return;
        }
        this.isLoading = true;
        this.uiApplyDiscountCode.buttonHolder.showLoading();
        this.uiApplyDiscountCode.showCloseProgress();
        ApiRequestMessanger.getInstance(this.currentAccount).applyOrderDiscountCode(new ApplyOrderDiscountCodeInput(this.orderId, str), new ApiRequestMessanger.Listener() { // from class: ir.resaneh1.iptv.fragment.BasketFinalFragment.4
            @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
            public void onResponse(Call call, Object obj) {
                BasketFinalFragment basketFinalFragment = BasketFinalFragment.this;
                basketFinalFragment.isLoading = false;
                basketFinalFragment.uiApplyDiscountCode.buttonHolder.hideLoading();
                ApplyOrderDiscountCodeOutput applyOrderDiscountCodeOutput = (ApplyOrderDiscountCodeOutput) obj;
                if (applyOrderDiscountCodeOutput.is_valid) {
                    BasketFinalFragment basketFinalFragment2 = BasketFinalFragment.this;
                    basketFinalFragment2.afterDiscountAmount = applyOrderDiscountCodeOutput.new_amount;
                    TextView textView = basketFinalFragment2.uiOrderFinalPricesView.textViewTotalAmount;
                    StringBuilder sb = new StringBuilder();
                    sb.append(NumberUtils.toPersian(EditTextCostPresenter.setFormat(BasketFinalFragment.this.afterDiscountAmount + BuildConfig.FLAVOR)));
                    sb.append(" تومان");
                    textView.setText(sb.toString());
                    BasketFinalFragment basketFinalFragment3 = BasketFinalFragment.this;
                    long totalAmount = basketFinalFragment3.basketObject.getTotalAmount() + BasketFinalFragment.this.deliveryType.amount;
                    BasketFinalFragment basketFinalFragment4 = BasketFinalFragment.this;
                    basketFinalFragment3.discountAmount = totalAmount - basketFinalFragment4.afterDiscountAmount;
                    if (basketFinalFragment4.discountAmount > 0) {
                        basketFinalFragment4.uiApplyDiscountCode.buttonHolder.itemView.setVisibility(8);
                        BasketFinalFragment.this.uiApplyDiscountCode.imageViewClose.setVisibility(0);
                        BasketFinalFragment.this.uiApplyDiscountCode.hideCloseProgress();
                        BasketFinalFragment.this.uiApplyDiscountCode.editText.setEnabled(false);
                        BasketFinalFragment.this.uiApplyDiscountCode.textViewDescription.setVisibility(0);
                        BasketFinalFragment.this.uiApplyDiscountCode.textViewDescription.setText(NumberUtils.getPriceString(BasketFinalFragment.this.discountAmount) + " تومان تخفیف اعمال می شود");
                        BasketFinalFragment.this.uiOrderFinalPricesView.textViewDiscountAmount.setText(NumberUtils.getPriceStringWithToman(BasketFinalFragment.this.discountAmount, false));
                        BasketFinalFragment.this.uiOrderFinalPricesView.discountAmountContainer.setVisibility(0);
                        return;
                    }
                    basketFinalFragment4.uiApplyDiscountCode.buttonHolder.button.setVisibility(0);
                    BasketFinalFragment.this.uiApplyDiscountCode.hideCloseView();
                    BasketFinalFragment.this.uiApplyDiscountCode.editText.setEnabled(true);
                    BasketFinalFragment.this.uiApplyDiscountCode.textViewDescription.setVisibility(8);
                    BasketFinalFragment.this.uiApplyDiscountCode.editText.setText(BuildConfig.FLAVOR);
                    BasketFinalFragment.this.uiOrderFinalPricesView.discountAmountContainer.setVisibility(8);
                    return;
                }
                BasketFinalFragment.this.uiApplyDiscountCode.textViewDescription.setVisibility(0);
                BasketFinalFragment.this.uiApplyDiscountCode.textViewDescription.setText(LocaleController.getString(R.string.wrong_code));
            }

            @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
            public void onFailure(Call call, Throwable th) {
                BasketFinalFragment basketFinalFragment = BasketFinalFragment.this;
                basketFinalFragment.isLoading = false;
                basketFinalFragment.uiApplyDiscountCode.buttonHolder.hideLoading();
                BasketFinalFragment.this.uiApplyDiscountCode.hideCloseProgress();
            }

            @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
            public void onError(MessangerOutput messangerOutput) {
                BasketFinalFragment basketFinalFragment = BasketFinalFragment.this;
                basketFinalFragment.isLoading = false;
                basketFinalFragment.uiApplyDiscountCode.buttonHolder.hideLoading();
                BasketFinalFragment.this.uiApplyDiscountCode.hideCloseProgress();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callGetPaymentInfo() {
        String str;
        if (this.isLoading || (str = this.orderId) == null || str.isEmpty()) {
            return;
        }
        long totalAmount = this.basketObject.getTotalAmount() + this.deliveryType.amount;
        long j = this.afterDiscountAmount;
        if (j >= 0) {
            totalAmount = j;
        }
        this.payButtonHolder.showLoading();
        this.lastCall = ApiRequestMessanger.getInstance(this.currentAccount).getOrderPaymentInfo(new GetOrderPaymentInfoInput(this.orderId, totalAmount), new ApiRequestMessanger.Listener() { // from class: ir.resaneh1.iptv.fragment.BasketFinalFragment.5
            @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
            public void onResponse(Call call, Object obj) {
                BasketFinalFragment.this.payButtonHolder.hideLoading();
                if (call.isCanceled()) {
                    return;
                }
                GetOrderPaymentInfoOutput getOrderPaymentInfoOutput = (GetOrderPaymentInfoOutput) obj;
                boolean z = getOrderPaymentInfoOutput.is_expired;
                if (!z && getOrderPaymentInfoOutput.payment_info != null) {
                    PaymentManager.getInstance().payByPaymentInfoObject(getOrderPaymentInfoOutput.payment_info, null, new PaymentManager.PayDoneListener(this) { // from class: ir.resaneh1.iptv.fragment.BasketFinalFragment.5.1
                        @Override // ir.resaneh1.iptv.helper.PaymentManager.PayDoneListener
                        public void onPayDone() {
                        }

                        @Override // ir.resaneh1.iptv.helper.PaymentManager.PayDoneListener
                        public void onPayFaild() {
                        }

                        @Override // ir.resaneh1.iptv.helper.PaymentManager.PayDoneListener
                        public void onDoneAfterDismiss() {
                            BasketHelper.openOrderListAndCloseBasketFragments();
                        }
                    });
                } else if (z) {
                    BasketHelper.backToBasket(((BaseFragment) BasketFinalFragment.this).currentAccount, BasketFinalFragment.this.basketObject.basket_id);
                }
            }

            @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
            public void onFailure(Call call, Throwable th) {
                BasketFinalFragment.this.payButtonHolder.hideLoading();
            }

            @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
            public void onError(MessangerOutput messangerOutput) {
                BasketFinalFragment.this.payButtonHolder.hideLoading();
            }
        });
    }
}
