package ir.resaneh1.iptv.model;

/* loaded from: classes3.dex */
public class GetOrderPaymentInfoInput {
    public String order_id;
    public long total_amount;

    public GetOrderPaymentInfoInput(String str, long j) {
        this.order_id = str;
        this.total_amount = j;
    }
}
