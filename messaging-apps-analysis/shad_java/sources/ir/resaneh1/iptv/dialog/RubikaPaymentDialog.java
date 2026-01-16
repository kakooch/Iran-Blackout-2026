package ir.resaneh1.iptv.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.medu.shad.R;
import ir.resaneh1.iptv.UIProgressBarNewStyle;
import ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger;
import ir.resaneh1.iptv.helper.GlideHelper;
import ir.resaneh1.iptv.helper.NumberUtils;
import ir.resaneh1.iptv.helper.PaymentManager;
import ir.resaneh1.iptv.helper.ToastiLikeSnack;
import ir.resaneh1.iptv.logger.MyLog;
import ir.resaneh1.iptv.model.GetRubikaPaymentOptionInput;
import ir.resaneh1.iptv.model.GetRubikaPaymentOptionOutput;
import ir.resaneh1.iptv.model.MessangerOutput;
import ir.resaneh1.iptv.model.PaymentManagerOutput;
import ir.resaneh1.iptv.model.RubikaPaymentObject;
import ir.resaneh1.iptv.presenters.EditTextCostPresenter;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.UserConfig;
import retrofit2.Call;

/* loaded from: classes3.dex */
public class RubikaPaymentDialog extends Dialog {
    Context context;
    private int currentAccount;
    public FrameLayout frameLayoutWallet;
    public ImageView imageViewClose;
    public ImageView imageViewShare;
    public ImageView imageViewStatus;
    public ImageView imageViewTop;
    boolean isPayClicked;
    Call lastCall;
    View.OnClickListener onBackOrCloseClick;
    CompoundButton.OnCheckedChangeListener onCheckedChangeListener;
    View.OnClickListener onPayClick;
    public PaymentManager.PayDoneListener payDoneListener;
    public FrameLayout progressContainer;
    public FrameLayout progressViewButton;
    public View resultView;
    public View retryView;
    RubikaPaymentObject rubikaPaymentObject;
    public SwitchCompat switchView;
    public TextView textViewAmount;
    public TextView textViewButton;
    public TextView textViewPayDescription;
    public TextView textViewProviderTitle;
    public TextView textViewStatus;
    public TextView textViewWalletAmount;
    public View totalAmountView;

    public RubikaPaymentDialog(Context context, RubikaPaymentObject rubikaPaymentObject, PaymentManager.PayDoneListener payDoneListener) {
        super(context);
        this.isPayClicked = false;
        this.currentAccount = UserConfig.selectedAccount;
        this.onCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() { // from class: ir.resaneh1.iptv.dialog.RubikaPaymentDialog.2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                RubikaPaymentDialog.this.setPayButton();
            }
        };
        this.onBackOrCloseClick = new View.OnClickListener() { // from class: ir.resaneh1.iptv.dialog.RubikaPaymentDialog.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                RubikaPaymentDialog.this.checkAndClose();
            }
        };
        this.onPayClick = new View.OnClickListener() { // from class: ir.resaneh1.iptv.dialog.RubikaPaymentDialog.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                RubikaPaymentDialog rubikaPaymentDialog = RubikaPaymentDialog.this;
                if (rubikaPaymentDialog.isPayClicked) {
                    return;
                }
                rubikaPaymentDialog.isPayClicked = true;
                rubikaPaymentDialog.callGetPaymentOption();
            }
        };
        this.context = context;
        this.rubikaPaymentObject = rubikaPaymentObject;
        this.payDoneListener = payDoneListener;
        show();
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) throws Resources.NotFoundException {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        setContentView(R.layout.pay_info_dialog);
        getWindow().setLayout(-1, -1);
        findViews();
        init();
    }

    private void findViews() {
        this.textViewProviderTitle = (TextView) findViewById(R.id.textView1);
        this.textViewPayDescription = (TextView) findViewById(R.id.textView2);
        this.textViewAmount = (TextView) findViewById(R.id.textView4);
        this.textViewWalletAmount = (TextView) findViewById(R.id.textView6);
        this.textViewButton = (TextView) findViewById(R.id.textViewButton);
        this.switchView = (SwitchCompat) findViewById(R.id.switchView);
        this.imageViewClose = (ImageView) findViewById(R.id.imageViewClose);
        this.imageViewShare = (ImageView) findViewById(R.id.imageViewShare);
        this.imageViewTop = (ImageView) findViewById(R.id.imageViewTop);
        this.progressContainer = (FrameLayout) findViewById(R.id.progressBarContainer);
        this.frameLayoutWallet = (FrameLayout) findViewById(R.id.frameLayoutWallet);
        this.resultView = findViewById(R.id.resultView);
        this.imageViewStatus = (ImageView) findViewById(R.id.imageViewStatus);
        this.textViewStatus = (TextView) findViewById(R.id.textViewPayStatus);
        this.retryView = findViewById(R.id.retryView);
        this.totalAmountView = findViewById(R.id.totalAmountView);
        this.progressViewButton = (FrameLayout) findViewById(R.id.progressViewButton);
    }

    private void init() throws Resources.NotFoundException {
        UIProgressBarNewStyle.addToFrameWithWhiteBackground(ApplicationLoader.applicationActivity, this.progressContainer, 48);
        UIProgressBarNewStyle.addToFrameWhiteWithTransparentBackground(ApplicationLoader.applicationActivity, this.progressViewButton, 32);
        if (this.rubikaPaymentObject == null) {
            return;
        }
        this.resultView.setVisibility(8);
        this.progressContainer.setVisibility(8);
        this.imageViewShare.setVisibility(8);
        this.imageViewStatus.setVisibility(8);
        this.textViewStatus.setVisibility(8);
        this.retryView.setVisibility(8);
        this.totalAmountView.setVisibility(0);
        this.retryView.setOnClickListener(new View.OnClickListener(this) { // from class: ir.resaneh1.iptv.dialog.RubikaPaymentDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        this.switchView.setOnCheckedChangeListener(this.onCheckedChangeListener);
        GlideHelper.loadCircle(this.context, this.imageViewTop, this.rubikaPaymentObject.provider_image_url, R.drawable.circle_blue);
        this.textViewProviderTitle.setText(this.rubikaPaymentObject.provider_title);
        this.textViewPayDescription.setText(this.rubikaPaymentObject.payment_description);
        this.textViewAmount.setText(this.rubikaPaymentObject.getPaymentAmountString());
        if (this.rubikaPaymentObject.wallet_amount > 0) {
            this.frameLayoutWallet.setVisibility(0);
            TextView textView = this.textViewWalletAmount;
            StringBuilder sb = new StringBuilder();
            sb.append("(اعتبار : ");
            sb.append(NumberUtils.toPersian(EditTextCostPresenter.setFormat(this.rubikaPaymentObject.wallet_amount + BuildConfig.FLAVOR)));
            sb.append(" تومان)");
            textView.setText(sb.toString());
            this.switchView.setChecked(true);
        } else {
            this.frameLayoutWallet.setVisibility(8);
        }
        setPayButton();
        this.imageViewClose.setOnClickListener(this.onBackOrCloseClick);
    }

    public void checkAndClose() {
        if (ApplicationLoader.applicationActivity == null) {
            return;
        }
        Call call = this.lastCall;
        if (call != null) {
            call.cancel();
        }
        PaymentManager.PayDoneListener payDoneListener = this.payDoneListener;
        if (payDoneListener != null) {
            payDoneListener.onPayFaild();
        }
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callGetPaymentOption() {
        setProgressButton();
        boolean zIsChecked = this.switchView.isChecked();
        RubikaPaymentObject rubikaPaymentObject = this.rubikaPaymentObject;
        GetRubikaPaymentOptionInput getRubikaPaymentOptionInput = new GetRubikaPaymentOptionInput(rubikaPaymentObject.payment_token, rubikaPaymentObject.payment_amount, rubikaPaymentObject.wallet_amount, rubikaPaymentObject.min_ebanking_amount, zIsChecked);
        Call call = this.lastCall;
        if (call != null) {
            call.cancel();
        }
        this.lastCall = ApiRequestMessanger.getInstance(this.currentAccount).getRubikaPaymentOption(getRubikaPaymentOptionInput, new ApiRequestMessanger.Listener() { // from class: ir.resaneh1.iptv.dialog.RubikaPaymentDialog.5
            @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
            public void onResponse(Call call2, Object obj) {
                if (call2.isCanceled()) {
                    return;
                }
                RubikaPaymentDialog rubikaPaymentDialog = RubikaPaymentDialog.this;
                rubikaPaymentDialog.lastCall = null;
                rubikaPaymentDialog.progressContainer.setVisibility(8);
                RubikaPaymentDialog.this.hideButton();
                GetRubikaPaymentOptionOutput getRubikaPaymentOptionOutput = (GetRubikaPaymentOptionOutput) obj;
                if (getRubikaPaymentOptionOutput.token_status == GetRubikaPaymentOptionOutput.TokenStatusEnum.OK) {
                    if (getRubikaPaymentOptionOutput.payment_option != null) {
                        PaymentManager.getInstance().pay(getRubikaPaymentOptionOutput.payment_option, new PaymentManager.Listener() { // from class: ir.resaneh1.iptv.dialog.RubikaPaymentDialog.5.1
                            @Override // ir.resaneh1.iptv.helper.PaymentManager.Listener
                            public void onPayDone(PaymentManagerOutput paymentManagerOutput) {
                                PaymentManager.PayDoneListener payDoneListener = RubikaPaymentDialog.this.payDoneListener;
                                if (payDoneListener != null) {
                                    payDoneListener.onPayDone();
                                }
                                RubikaPaymentDialog.this.dismiss();
                            }

                            @Override // ir.resaneh1.iptv.helper.PaymentManager.Listener
                            public void onPayFailed(PaymentManagerOutput paymentManagerOutput) {
                                PaymentManager.PayDoneListener payDoneListener = RubikaPaymentDialog.this.payDoneListener;
                                if (payDoneListener != null) {
                                    payDoneListener.onPayFaild();
                                }
                                RubikaPaymentDialog.this.dismiss();
                            }
                        });
                    }
                } else {
                    ToastiLikeSnack.showMessageLikeToastLong("لطفا مجددا تلاش نمایید.");
                    PaymentManager.PayDoneListener payDoneListener = RubikaPaymentDialog.this.payDoneListener;
                    if (payDoneListener != null) {
                        payDoneListener.onPayFaild();
                    }
                    RubikaPaymentDialog.this.dismiss();
                }
            }

            @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
            public void onFailure(Call call2, Throwable th) {
                RubikaPaymentDialog.this.progressContainer.setVisibility(8);
                RubikaPaymentDialog rubikaPaymentDialog = RubikaPaymentDialog.this;
                rubikaPaymentDialog.isPayClicked = false;
                rubikaPaymentDialog.lastCall = null;
                rubikaPaymentDialog.setPayButton();
                ToastiLikeSnack.showNoInternet();
                MyLog.e("PayInfoDialog", "onfailur");
            }

            @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
            public void onError(MessangerOutput messangerOutput) {
                RubikaPaymentDialog.this.progressContainer.setVisibility(8);
                RubikaPaymentDialog rubikaPaymentDialog = RubikaPaymentDialog.this;
                rubikaPaymentDialog.isPayClicked = false;
                rubikaPaymentDialog.lastCall = null;
                ToastiLikeSnack.showL(rubikaPaymentDialog.context, "خطا در فرآیند خرید");
                PaymentManager.PayDoneListener payDoneListener = RubikaPaymentDialog.this.payDoneListener;
                if (payDoneListener != null) {
                    payDoneListener.onPayFaild();
                }
                RubikaPaymentDialog.this.dismiss();
                MyLog.e("PayInfoDialog", "onError");
            }
        });
    }

    public void setPayButton() {
        if (this.switchView.isChecked()) {
            RubikaPaymentObject rubikaPaymentObject = this.rubikaPaymentObject;
            long j = rubikaPaymentObject.wallet_amount;
            long j2 = rubikaPaymentObject.payment_amount;
            if (j >= j2) {
                setPayButton("پرداخت از کیف پول");
                return;
            }
            long j3 = j2 - j;
            long j4 = rubikaPaymentObject.min_ebanking_amount;
            if (j3 >= j4) {
                j4 = j2 - j;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("پرداخت (");
            sb.append(NumberUtils.toPersian(EditTextCostPresenter.setFormat(j4 + BuildConfig.FLAVOR)));
            sb.append(" تومان)");
            setPayButton(sb.toString());
            return;
        }
        setPayButton("پرداخت");
    }

    public void setPayButton(String str) {
        this.progressViewButton.setVisibility(4);
        this.textViewButton.setVisibility(0);
        this.textViewButton.setText(str);
        this.isPayClicked = false;
        this.textViewButton.setOnClickListener(this.onPayClick);
    }

    public void hideButton() {
        this.textViewButton.setVisibility(8);
        this.progressViewButton.setVisibility(8);
    }

    public void setProgressButton() {
        this.textViewButton.setText(BuildConfig.FLAVOR);
        this.textViewButton.setVisibility(0);
        this.progressViewButton.setVisibility(0);
        this.textViewButton.setOnClickListener(new View.OnClickListener(this) { // from class: ir.resaneh1.iptv.dialog.RubikaPaymentDialog.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
    }
}
