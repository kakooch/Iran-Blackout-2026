package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_decryptedMessageActionFlushHistory extends TLRPC$DecryptedMessageAction {
    public static int constructor = 1729750108;

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}
