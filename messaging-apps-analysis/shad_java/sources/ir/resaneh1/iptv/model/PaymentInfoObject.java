package ir.resaneh1.iptv.model;

import io.github.inflationx.calligraphy3.BuildConfig;
import ir.resaneh1.iptv.helper.NumberUtils;
import ir.resaneh1.iptv.presenters.EditTextCostPresenter;

/* loaded from: classes3.dex */
public class PaymentInfoObject {
    public long min_ebanking_amount;
    public long payment_amount;
    public String payment_description;
    public String payment_token;
    public String provider_image_url;
    public String provider_title;
    public long wallet_amount;

    public String getPaymentAmountString() {
        if (this.payment_amount <= 0) {
            return "رایگان";
        }
        return NumberUtils.toPersian(EditTextCostPresenter.setFormat(this.payment_amount + BuildConfig.FLAVOR) + " تومان");
    }
}
