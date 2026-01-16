package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_phoneCallDiscardReasonMissed extends TLRPC$PhoneCallDiscardReason {
    public static int constructor = -2048646399;

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}
