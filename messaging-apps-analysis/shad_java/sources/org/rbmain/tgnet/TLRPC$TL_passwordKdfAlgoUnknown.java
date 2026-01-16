package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_passwordKdfAlgoUnknown extends TLRPC$PasswordKdfAlgo {
    public static int constructor = -732254058;

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}
