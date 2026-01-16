package ir.resaneh1.iptv.model;

/* loaded from: classes3.dex */
public class InstaSetOrderPaymentInput extends InstaInput {
    public String post_id;
    public String post_profile_id;
    public Integer product_count;
    public String product_type;

    public InstaSetOrderPaymentInput(String str, String str2) {
        this.post_id = str;
        this.post_profile_id = str2;
    }
}
