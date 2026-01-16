package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_boolTrue extends TLRPC$Bool {
    public static int constructor = -1720552011;

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}
