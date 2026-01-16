package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_payments_paymentVerificationNeeded extends TLRPC$payments_PaymentResult {
    public static int constructor = -666824391;
    public String url;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.url = stream.readString(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeString(this.url);
    }
}
