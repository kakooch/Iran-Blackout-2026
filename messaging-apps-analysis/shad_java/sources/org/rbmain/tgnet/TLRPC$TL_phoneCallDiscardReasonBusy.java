package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_phoneCallDiscardReasonBusy extends TLRPC$PhoneCallDiscardReason {
    public static int constructor = -84416311;

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}
