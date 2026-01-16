package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_phoneCallDiscardReasonDisconnect extends TLRPC$PhoneCallDiscardReason {
    public static int constructor = -527056480;

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}
