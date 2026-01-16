package ir.resaneh1.iptv.model;

import io.github.inflationx.calligraphy3.BuildConfig;

/* loaded from: classes3.dex */
public class GetRubikaPaymentOptionInput {
    public String payment_token;
    public String total_amount;
    public String wallet_portion;

    public GetRubikaPaymentOptionInput(String str, long j, long j2, long j3, boolean z) {
        this.payment_token = str;
        this.total_amount = j + BuildConfig.FLAVOR;
        if (!z) {
            this.wallet_portion = "0";
            return;
        }
        if (j2 >= j) {
            this.wallet_portion = j + BuildConfig.FLAVOR;
            return;
        }
        if (j - j2 >= j3) {
            this.wallet_portion = j2 + BuildConfig.FLAVOR;
            return;
        }
        long j4 = j - j3;
        if (j4 >= 0) {
            this.wallet_portion = j4 + BuildConfig.FLAVOR;
            return;
        }
        this.wallet_portion = "0";
    }
}
