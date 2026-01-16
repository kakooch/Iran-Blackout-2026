package ir.resaneh1.iptv.model;

/* loaded from: classes3.dex */
public class InstaSetFinalPaymentInput extends InstaInput {
    public boolean done;
    public String order_id;

    public InstaSetFinalPaymentInput(String str, boolean z) {
        this.order_id = str;
        this.done = z;
    }
}
