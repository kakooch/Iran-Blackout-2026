package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_payments_paymentResult extends TLRPC$payments_PaymentResult {
    public static int constructor = 1314881805;
    public TLRPC$Updates updates;

    @Override // org.rbmain.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.updates = TLRPC$Updates.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        this.updates.serializeToStream(abstractSerializedData);
    }
}
