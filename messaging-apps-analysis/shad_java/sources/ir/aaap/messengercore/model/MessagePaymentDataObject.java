package ir.aaap.messengercore.model;

import java.util.Map;

/* loaded from: classes3.dex */
public class MessagePaymentDataObject {
    public Map<String, String> amount_details;
    public long expire_time;
    public String payment_id;
    public Status status;
    public long total_amount;

    public enum Status {
        Paid,
        InProgress,
        Ready,
        NotPaid,
        Expired,
        Reversed
    }
}
