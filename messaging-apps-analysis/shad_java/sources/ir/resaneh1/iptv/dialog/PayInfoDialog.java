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
import ir.resaneh1.iptv.model.ConfirmPaymentInput;
import ir.resaneh1.iptv.model.ConfirmPaymentOutput;
import ir.resaneh1.iptv.model.GetPaymentOptionInput;
import ir.resaneh1.iptv.model.GetPaymentOptionOutput;
import ir.resaneh1.iptv.model.MessangerOutput;
import ir.resaneh1.iptv.model.PaymentInfoObject;
import ir.resaneh1.iptv.model.PaymentManagerOutput;
import ir.resaneh1.iptv.presenter.MainClickHandler;
import ir.resaneh1.iptv.presenters.EditTextCostPresenter;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.UserConfig;
import retrofit2.Call;

/* loaded from: classes3.dex */
public class PayInfoDialog extends Dialog {
    Context context;
    private int currentAccount;
    public FrameLayout frameLayoutWallet;
    public ImageView imageViewClose;
    public ImageView imageViewShare;
    public ImageView imageViewStatus;
    public ImageView imageViewTop;
    private final boolean isForMessenger;
    boolean isPayClicked;
    public boolean isSuccess;
    Call lastCall;
    View.OnClickListener onBackOrCloseClick;
    CompoundButton.OnCheckedChangeListener onCheckedChangeListener;
    View.OnClickListener onPayClick;
    public PaymentManager.PayDoneListener payDoneListener;
    PaymentInfoObject paymentInfoObject;
    public FrameLayout progressContainer;
    public FrameLayout progressViewButton;
    public View resultView;
    public View retryView;
    private final String successPaymentReturnText;
    public SwitchCompat switchView;
    public TextView textViewAmount;
    public TextView textViewButton;
    public TextView textViewPayDescription;
    public TextView textViewProviderTitle;
    public TextView textViewResultTotalAmont;
    public TextView textViewResultTrackCode;
    public TextView textViewStatus;
    public TextView textViewWalletAmount;
    public View totalAmountView;

    public PayInfoDialog(Context context, boolean z, PaymentInfoObject paymentInfoObject, String str, PaymentManager.PayDoneListener payDoneListener) {
        super(context);
        this.isPayClicked = false;
        this.isSuccess = false;
        this.currentAccount = UserConfig.selectedAccount;
        this.onCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() { // from class: ir.resaneh1.iptv.dialog.PayInfoDialog.2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                PayInfoDialog.this.setPayButton();
            }
        };
        this.onBackOrCloseClick = new View.OnClickListener() { // from class: ir.resaneh1.iptv.dialog.PayInfoDialog.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PayInfoDialog.this.checkAndClose();
            }
        };
        this.onPayClick = new View.OnClickListener() { // from class: ir.resaneh1.iptv.dialog.PayInfoDialog.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PayInfoDialog payInfoDialog = PayInfoDialog.this;
                if (payInfoDialog.isPayClicked) {
                    return;
                }
                payInfoDialog.isPayClicked = true;
                payInfoDialog.callGetPaymentOption();
            }
        };
        this.context = context;
        this.paymentInfoObject = paymentInfoObject;
        this.payDoneListener = payDoneListener;
        this.successPaymentReturnText = str;
        this.isForMessenger = z;
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
        this.textViewResultTrackCode = (TextView) findViewById(R.id.textViewRight);
        this.textViewResultTotalAmont = (TextView) findViewById(R.id.textViewLeft);
        this.imageViewStatus = (ImageView) findViewById(R.id.imageViewStatus);
        this.textViewStatus = (TextView) findViewById(R.id.textViewPayStatus);
        this.retryView = findViewById(R.id.retryView);
        this.totalAmountView = findViewById(R.id.totalAmountView);
        this.progressViewButton = (FrameLayout) findViewById(R.id.progressViewButton);
    }

    private void init() throws Resources.NotFoundException {
        UIProgressBarNewStyle.addToFrameWithWhiteBackground(ApplicationLoader.applicationActivity, this.progressContainer, 48);
        UIProgressBarNewStyle.addToFrameWhiteWithTransparentBackground(ApplicationLoader.applicationActivity, this.progressViewButton, 32);
        if (this.paymentInfoObject == null) {
            return;
        }
        this.resultView.setVisibility(8);
        this.progressContainer.setVisibility(8);
        this.imageViewShare.setVisibility(8);
        this.imageViewStatus.setVisibility(8);
        this.textViewStatus.setVisibility(8);
        this.retryView.setVisibility(8);
        this.totalAmountView.setVisibility(0);
        this.retryView.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.dialog.PayInfoDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PayInfoDialog.this.retryCall();
            }
        });
        this.switchView.setOnCheckedChangeListener(this.onCheckedChangeListener);
        GlideHelper.loadCircle(this.context, this.imageViewTop, this.paymentInfoObject.provider_image_url, R.drawable.circle_blue);
        this.textViewProviderTitle.setText(this.paymentInfoObject.provider_title);
        this.textViewPayDescription.setText(this.paymentInfoObject.payment_description);
        this.textViewAmount.setText(this.paymentInfoObject.getPaymentAmountString());
        if (this.paymentInfoObject.wallet_amount > 0) {
            this.frameLayoutWallet.setVisibility(0);
            TextView textView = this.textViewWalletAmount;
            StringBuilder sb = new StringBuilder();
            sb.append("(اعتبار : ");
            sb.append(NumberUtils.toPersian(EditTextCostPresenter.setFormat(this.paymentInfoObject.wallet_amount + BuildConfig.FLAVOR)));
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
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void retryCall() {
        callConfirm();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callGetPaymentOption() {
        setProgressButton();
        boolean zIsChecked = this.switchView.isChecked();
        PaymentInfoObject paymentInfoObject = this.paymentInfoObject;
        GetPaymentOptionInput getPaymentOptionInput = new GetPaymentOptionInput(paymentInfoObject.payment_token, paymentInfoObject.payment_amount, paymentInfoObject.wallet_amount, paymentInfoObject.min_ebanking_amount, zIsChecked);
        Call call = this.lastCall;
        if (call != null) {
            call.cancel();
        }
        this.lastCall = ApiRequestMessanger.getInstance(this.currentAccount).getPaymentOption(getPaymentOptionInput, new ApiRequestMessanger.Listener() { // from class: ir.resaneh1.iptv.dialog.PayInfoDialog.5
            @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
            public void onResponse(Call call2, Object obj) {
                if (call2.isCanceled()) {
                    return;
                }
                PayInfoDialog payInfoDialog = PayInfoDialog.this;
                payInfoDialog.lastCall = null;
                payInfoDialog.progressContainer.setVisibility(8);
                PayInfoDialog.this.hideButton();
                GetPaymentOptionOutput getPaymentOptionOutput = (GetPaymentOptionOutput) obj;
                if (getPaymentOptionOutput.token_status == GetPaymentOptionOutput.TokenStatusEnum.OK) {
                    if (getPaymentOptionOutput.payment_option != null) {
                        PaymentManager.getInstance().pay(getPaymentOptionOutput.payment_option, new PaymentManager.Listener() { // from class: ir.resaneh1.iptv.dialog.PayInfoDialog.5.1
                            @Override // ir.resaneh1.iptv.helper.PaymentManager.Listener
                            public void onPayDone(PaymentManagerOutput paymentManagerOutput) {
                                if (!PayInfoDialog.this.isForMessenger) {
                                    PayInfoDialog.this.callConfirm();
                                } else {
                                    PayInfoDialog.this.payDoneListener.onPayDone();
                                    PayInfoDialog.this.dismiss();
                                }
                            }

                            @Override // ir.resaneh1.iptv.helper.PaymentManager.Listener
                            public void onPayFailed(PaymentManagerOutput paymentManagerOutput) {
                                if (PayInfoDialog.this.isForMessenger) {
                                    PayInfoDialog.this.payDoneListener.onPayFaild();
                                    PayInfoDialog.this.dismiss();
                                } else {
                                    PayInfoDialog.this.setFailedView("پرداخت ناموفق");
                                }
                            }
                        });
                    }
                } else {
                    PayInfoDialog.this.setFailedView("لطفا مجدد تلاش نمایید");
                    PayInfoDialog.this.setBackButton(false);
                }
            }

            @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
            public void onFailure(Call call2, Throwable th) {
                PayInfoDialog.this.progressContainer.setVisibility(8);
                PayInfoDialog payInfoDialog = PayInfoDialog.this;
                payInfoDialog.isPayClicked = false;
                payInfoDialog.lastCall = null;
                payInfoDialog.setPayButton();
                ToastiLikeSnack.showNoInternet();
                MyLog.e("PayInfoDialog", "onfailur");
            }

            @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
            public void onError(MessangerOutput messangerOutput) {
                PayInfoDialog.this.progressContainer.setVisibility(8);
                PayInfoDialog payInfoDialog = PayInfoDialog.this;
                payInfoDialog.isPayClicked = false;
                payInfoDialog.lastCall = null;
                ToastiLikeSnack.showL(payInfoDialog.context, "خطا در فرآیند خرید");
                PayInfoDialog.this.dismiss();
                MyLog.e("PayInfoDialog", "onError");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callConfirm() {
        Call call = this.lastCall;
        if (call != null) {
            call.cancel();
        }
        setProgressView();
        this.lastCall = ApiRequestMessanger.getInstance(this.currentAccount).confirmPayment(new ConfirmPaymentInput(this.paymentInfoObject.payment_token), new ApiRequestMessanger.Listener() { // from class: ir.resaneh1.iptv.dialog.PayInfoDialog.6
            @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
            public void onResponse(Call call2, Object obj) {
                if (call2.isCanceled()) {
                    return;
                }
                PayInfoDialog payInfoDialog = PayInfoDialog.this;
                payInfoDialog.lastCall = null;
                payInfoDialog.progressContainer.setVisibility(8);
                ConfirmPaymentOutput confirmPaymentOutput = (ConfirmPaymentOutput) obj;
                if (confirmPaymentOutput == null) {
                    PayInfoDialog.this.retryView.setVisibility(0);
                    return;
                }
                PayInfoDialog.this.imageViewStatus.setVisibility(0);
                if (confirmPaymentOutput.payment_status == ConfirmPaymentOutput.PaymentStatus.OK) {
                    PayInfoDialog.this.setSuccessResultView(confirmPaymentOutput);
                    return;
                }
                String str = confirmPaymentOutput.user_message;
                if (str != null && !str.isEmpty()) {
                    PayInfoDialog.this.setFailedView(confirmPaymentOutput.user_message);
                } else {
                    PayInfoDialog.this.setFailedView("پرداخت ناموفق");
                }
            }

            @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
            public void onFailure(Call call2, Throwable th) {
                PayInfoDialog payInfoDialog = PayInfoDialog.this;
                payInfoDialog.lastCall = null;
                payInfoDialog.progressContainer.setVisibility(8);
                PayInfoDialog.this.retryView.setVisibility(0);
                MyLog.e("PayInfoDialog", "callConfirm onfailur");
            }

            @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
            public void onError(MessangerOutput messangerOutput) {
                PayInfoDialog payInfoDialog = PayInfoDialog.this;
                payInfoDialog.lastCall = null;
                payInfoDialog.progressContainer.setVisibility(8);
                PayInfoDialog.this.retryView.setVisibility(0);
                MyLog.e("PayInfoDialog", "callConfirm onError");
            }
        });
    }

    public void setFailedView(String str) {
        PaymentManager.PayDoneListener payDoneListener = this.payDoneListener;
        if (payDoneListener != null) {
            payDoneListener.onPayFaild();
        }
        this.resultView.setVisibility(8);
        this.progressContainer.setVisibility(8);
        this.imageViewShare.setVisibility(8);
        this.retryView.setVisibility(8);
        this.frameLayoutWallet.setVisibility(8);
        this.totalAmountView.setVisibility(8);
        this.imageViewStatus.setVisibility(0);
        this.textViewStatus.setVisibility(0);
        this.imageViewStatus.setImageResource(R.drawable.ic_cancel_red);
        this.textViewStatus.setTextColor(this.context.getResources().getColor(R.color.red_500));
        this.textViewStatus.setText(str);
        setBackButton(false);
    }

    public void setBackButton(boolean z) {
        String str;
        this.progressViewButton.setVisibility(4);
        this.isPayClicked = true;
        this.textViewButton.setVisibility(0);
        if (z && (str = this.successPaymentReturnText) != null && str.length() > 0) {
            this.textViewButton.setText(this.successPaymentReturnText);
        } else {
            this.textViewButton.setText("بازگشت");
        }
        this.textViewButton.setOnClickListener(this.onBackOrCloseClick);
    }

    public void setPayButton() {
        if (this.switchView.isChecked()) {
            PaymentInfoObject paymentInfoObject = this.paymentInfoObject;
            long j = paymentInfoObject.wallet_amount;
            long j2 = paymentInfoObject.payment_amount;
            if (j >= j2) {
                setPayButton("پرداخت از کیف پول");
                return;
            }
            long j3 = j2 - j;
            long j4 = paymentInfoObject.min_ebanking_amount;
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

    public void setProgressView() {
        this.resultView.setVisibility(8);
        this.imageViewShare.setVisibility(8);
        this.retryView.setVisibility(8);
        this.imageViewStatus.setVisibility(8);
        this.textViewStatus.setVisibility(8);
        this.frameLayoutWallet.setVisibility(8);
        this.totalAmountView.setVisibility(8);
        this.progressContainer.setVisibility(0);
        hideButton();
    }

    public void hideButton() {
        this.textViewButton.setVisibility(8);
        this.progressViewButton.setVisibility(8);
    }

    public void setSuccessResultView(final ConfirmPaymentOutput confirmPaymentOutput) {
        PaymentManager.PayDoneListener payDoneListener = this.payDoneListener;
        if (payDoneListener != null) {
            payDoneListener.onPayDone();
        }
        this.isSuccess = true;
        this.retryView.setVisibility(8);
        this.frameLayoutWallet.setVisibility(8);
        this.progressContainer.setVisibility(8);
        this.totalAmountView.setVisibility(8);
        this.imageViewStatus.setVisibility(0);
        this.textViewStatus.setVisibility(0);
        this.textViewButton.setVisibility(0);
        this.resultView.setVisibility(0);
        setBackButton(true);
        this.imageViewStatus.setImageResource(R.drawable.ic_check_circle_green);
        this.textViewStatus.setTextColor(this.context.getResources().getColor(R.color.green_500));
        String str = confirmPaymentOutput.user_message;
        if (str != null) {
            this.textViewStatus.setText(str);
        } else {
            this.textViewStatus.setText("پرداخت با موفقیت انجام شد");
        }
        String str2 = confirmPaymentOutput.share_string;
        if (str2 != null && !str2.isEmpty()) {
            this.imageViewShare.setVisibility(0);
            this.imageViewShare.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.dialog.PayInfoDialog.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PayInfoDialog.this.dismiss();
                    new MainClickHandler().shareStringOrLink(PayInfoDialog.this.context, confirmPaymentOutput.share_string);
                }
            });
        } else {
            this.imageViewShare.setVisibility(8);
        }
        String str3 = confirmPaymentOutput.total_amount;
        if (str3 != null) {
            this.textViewResultTotalAmont.setText(NumberUtils.toPersian(EditTextCostPresenter.setFormat(str3)));
        } else {
            this.textViewResultTotalAmont.setText("-");
        }
        String str4 = confirmPaymentOutput.track_code;
        if (str4 != null) {
            this.textViewResultTrackCode.setText(NumberUtils.toPersian(str4));
        } else {
            this.textViewResultTrackCode.setText("-");
        }
    }

    public void setProgressButton() {
        this.textViewButton.setText(BuildConfig.FLAVOR);
        this.textViewButton.setVisibility(0);
        this.progressViewButton.setVisibility(0);
        this.textViewButton.setOnClickListener(new View.OnClickListener(this) { // from class: ir.resaneh1.iptv.dialog.PayInfoDialog.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
    }
}
