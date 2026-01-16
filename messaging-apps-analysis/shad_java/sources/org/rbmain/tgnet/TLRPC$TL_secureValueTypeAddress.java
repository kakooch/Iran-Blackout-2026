package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_secureValueTypeAddress extends TLRPC$SecureValueType {
    public static int constructor = -874308058;

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}
