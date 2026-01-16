package ir.resaneh1.iptv.model;

/* loaded from: classes3.dex */
public class GetPaymentOptionOutput {
    public PaymentOptionObject payment_option;
    public TokenStatusEnum token_status;

    public enum TokenStatusEnum {
        OK,
        Invalid,
        Expired
    }
}
