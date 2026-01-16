package ir.resaneh1.iptv.helper;

import android.content.DialogInterface;
import android.view.KeyEvent;
import ir.resaneh1.iptv.dialog.PayInfoDialog;
import ir.resaneh1.iptv.dialog.RubikaPaymentDialog;
import ir.resaneh1.iptv.fragment.WebFragmentPayment;
import ir.resaneh1.iptv.model.ChildLockCheck;
import ir.resaneh1.iptv.model.PaymentInfoObject;
import ir.resaneh1.iptv.model.PaymentManagerOutput;
import ir.resaneh1.iptv.model.PaymentOptionObject;
import ir.resaneh1.iptv.model.RubikaPaymentObject;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.ui.LaunchActivity;

/* loaded from: classes3.dex */
public class PaymentManager {
    public static PaymentManager instance;
    public LaunchActivity mainActivity = ApplicationLoader.applicationActivity;
    public PaymentManagerOutput output;

    public interface Listener {
        void onPayDone(PaymentManagerOutput paymentManagerOutput);

        void onPayFailed(PaymentManagerOutput paymentManagerOutput);
    }

    public interface PayDoneListener {
        void onDoneAfterDismiss();

        void onPayDone();

        void onPayFaild();
    }

    public static PaymentManager getInstance() {
        if (instance == null) {
            instance = new PaymentManager();
        }
        return instance;
    }

    public void pay(PaymentOptionObject paymentOptionObject, final Listener listener) {
        PaymentOptionObject.ProviderEnum providerEnum;
        PaymentOptionObject.TopOption topOption;
        if (ChildLockCheck.canPayWithAlert()) {
            PaymentManagerOutput paymentManagerOutput = new PaymentManagerOutput();
            this.output = paymentManagerOutput;
            if (paymentOptionObject != null && paymentOptionObject.provider == PaymentOptionObject.ProviderEnum.Top && (topOption = paymentOptionObject.top_options) != null) {
                paymentManagerOutput.token = topOption.token;
                if (this.mainActivity == null) {
                    listener.onPayFailed(paymentManagerOutput);
                    return;
                }
                String str = topOption.type;
                if (str == null || str.isEmpty()) {
                    paymentOptionObject.top_options.type = "1";
                }
                String str2 = paymentOptionObject.top_options.type;
                if (str2 == null || str2.equals("1") || paymentOptionObject.top_options.type.equals("2")) {
                    return;
                }
                paymentOptionObject.top_options.type.equals("3");
                return;
            }
            if (paymentOptionObject != null && paymentOptionObject.provider == PaymentOptionObject.ProviderEnum.Web && paymentOptionObject.web_options != null) {
                if (ApplicationLoader.applicationActivity != null) {
                    new WebFragmentPayment(ApplicationLoader.applicationActivity, paymentOptionObject.web_options.url, new WebFragmentPayment.Listener() { // from class: ir.resaneh1.iptv.helper.PaymentManager.1
                        @Override // ir.resaneh1.iptv.fragment.WebFragmentPayment.Listener
                        public void onSuccess() {
                            listener.onPayDone(PaymentManager.this.output);
                        }

                        @Override // ir.resaneh1.iptv.fragment.WebFragmentPayment.Listener
                        public void onFailed() {
                            listener.onPayFailed(PaymentManager.this.output);
                        }

                        @Override // ir.resaneh1.iptv.fragment.WebFragmentPayment.Listener
                        public void onCanceled() {
                            listener.onPayFailed(PaymentManager.this.output);
                        }
                    }).show();
                    return;
                }
                return;
            }
            if (paymentOptionObject != null && paymentOptionObject.provider == PaymentOptionObject.ProviderEnum.RubikaPayment && paymentOptionObject.rubika_payment_options != null) {
                if (ApplicationLoader.applicationActivity != null) {
                    showRubikaPaymentDialog(paymentOptionObject.rubika_payment_options.rubika_payment, new PayDoneListener() { // from class: ir.resaneh1.iptv.helper.PaymentManager.2
                        @Override // ir.resaneh1.iptv.helper.PaymentManager.PayDoneListener
                        public void onDoneAfterDismiss() {
                        }

                        @Override // ir.resaneh1.iptv.helper.PaymentManager.PayDoneListener
                        public void onPayDone() {
                            listener.onPayDone(PaymentManager.this.output);
                        }

                        @Override // ir.resaneh1.iptv.helper.PaymentManager.PayDoneListener
                        public void onPayFaild() {
                            listener.onPayFailed(PaymentManager.this.output);
                        }
                    });
                    return;
                }
                return;
            }
            if (paymentOptionObject != null && paymentOptionObject.provider == PaymentOptionObject.ProviderEnum.Wallet) {
                listener.onPayDone(paymentManagerOutput);
                return;
            }
            if (paymentOptionObject != null && (providerEnum = paymentOptionObject.provider) != null && providerEnum == PaymentOptionObject.ProviderEnum.Card2CardTop) {
                PaymentOptionObject.Card2CardTopOption card2CardTopOption = paymentOptionObject.card2cardtop_options;
                if (card2CardTopOption != null) {
                    String str3 = card2CardTopOption.token;
                }
                paymentManagerOutput.token = card2CardTopOption.token;
                return;
            }
            ToastiLikeSnack.showL(this.mainActivity, "برای دسترسی به این قابلیت به روزرسانی کنید");
            try {
                listener.onPayFailed(this.output);
            } catch (Exception unused) {
            }
        }
    }

    public void payByPaymentInfoObject(PaymentInfoObject paymentInfoObject, String str, PayDoneListener payDoneListener) {
        showPayDialog(paymentInfoObject, false, str, payDoneListener);
    }

    public void showPayDialog(PaymentInfoObject paymentInfoObject, boolean z, String str, final PayDoneListener payDoneListener) {
        if (ApplicationLoader.applicationActivity != null && ChildLockCheck.canPayWithAlert()) {
            final PayInfoDialog payInfoDialog = new PayInfoDialog(ApplicationLoader.applicationActivity, z, paymentInfoObject, str, payDoneListener);
            payInfoDialog.setOnDismissListener(new DialogInterface.OnDismissListener(this) { // from class: ir.resaneh1.iptv.helper.PaymentManager.3
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    PayDoneListener payDoneListener2;
                    if (!payInfoDialog.isSuccess || (payDoneListener2 = payDoneListener) == null) {
                        return;
                    }
                    payDoneListener2.onDoneAfterDismiss();
                }
            });
            payInfoDialog.setOnKeyListener(new DialogInterface.OnKeyListener(this) { // from class: ir.resaneh1.iptv.helper.PaymentManager.4
                @Override // android.content.DialogInterface.OnKeyListener
                public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                    if (i == 4 && keyEvent.getAction() == 1) {
                        payInfoDialog.checkAndClose();
                    }
                    return true;
                }
            });
        }
    }

    public void showRubikaPaymentDialog(RubikaPaymentObject rubikaPaymentObject, PayDoneListener payDoneListener) {
        if (ApplicationLoader.applicationActivity != null && ChildLockCheck.canPayWithAlert()) {
            final RubikaPaymentDialog rubikaPaymentDialog = new RubikaPaymentDialog(ApplicationLoader.applicationActivity, rubikaPaymentObject, payDoneListener);
            rubikaPaymentDialog.setOnKeyListener(new DialogInterface.OnKeyListener(this) { // from class: ir.resaneh1.iptv.helper.PaymentManager.5
                @Override // android.content.DialogInterface.OnKeyListener
                public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                    if (i == 4 && keyEvent.getAction() == 1) {
                        rubikaPaymentDialog.checkAndClose();
                    }
                    return true;
                }
            });
        }
    }
}
