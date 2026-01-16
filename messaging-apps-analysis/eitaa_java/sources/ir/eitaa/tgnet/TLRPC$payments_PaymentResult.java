package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public abstract class TLRPC$payments_PaymentResult extends TLObject {
    public static TLRPC$payments_PaymentResult TLdeserialize(AbstractSerializedData stream, int constructor, boolean exception) {
        TLRPC$payments_PaymentResult tLRPC$TL_payments_paymentVerificationNeeded;
        if (constructor == -666824391) {
            tLRPC$TL_payments_paymentVerificationNeeded = new TLRPC$TL_payments_paymentVerificationNeeded();
        } else {
            tLRPC$TL_payments_paymentVerificationNeeded = constructor != 1314881805 ? null : new TLRPC$TL_payments_paymentResult();
        }
        if (tLRPC$TL_payments_paymentVerificationNeeded == null && exception) {
            throw new RuntimeException(String.format("can't parse magic %x in payments_PaymentResult", Integer.valueOf(constructor)));
        }
        if (tLRPC$TL_payments_paymentVerificationNeeded != null) {
            tLRPC$TL_payments_paymentVerificationNeeded.readParams(stream, exception);
        }
        return tLRPC$TL_payments_paymentVerificationNeeded;
    }
}
