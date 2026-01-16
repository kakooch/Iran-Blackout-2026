package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_null extends TLObject {
    public static int constructor = 1450380236;

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}
