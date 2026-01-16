package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_inputUserEmpty extends TLRPC$InputUser {
    public static int constructor = -1182234929;

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}
