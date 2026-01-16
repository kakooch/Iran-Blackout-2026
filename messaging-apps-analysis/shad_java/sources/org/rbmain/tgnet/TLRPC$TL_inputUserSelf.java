package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_inputUserSelf extends TLRPC$InputUser {
    public static int constructor = -138301121;

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}
