package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_decryptedMessageMediaEmpty extends TLRPC$DecryptedMessageMedia {
    public static int constructor = 144661578;

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}
