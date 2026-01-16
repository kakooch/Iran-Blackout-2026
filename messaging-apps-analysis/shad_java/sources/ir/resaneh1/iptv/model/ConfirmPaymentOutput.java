package ir.resaneh1.iptv.model;

/* loaded from: classes3.dex */
public class ConfirmPaymentOutput {
    public PaymentStatus payment_status;
    public String share_string;
    public String total_amount;
    public String track_code;
    public String user_message;

    public enum PaymentStatus {
        OK,
        NotPaid,
        LowWallet,
        Invalid,
        Expired,
        NoService,
        Error
    }
}
