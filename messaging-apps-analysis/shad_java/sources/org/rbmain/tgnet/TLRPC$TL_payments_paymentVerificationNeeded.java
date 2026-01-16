package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_payments_paymentVerificationNeeded extends TLRPC$payments_PaymentResult {
    public static int constructor = -666824391;
    public String url;

    @Override // org.rbmain.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.url = abstractSerializedData.readString(z);
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeString(this.url);
    }
}
