package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_decryptedMessageActionNoop extends TLRPC$DecryptedMessageAction {
    public static int constructor = -1473258141;

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}
