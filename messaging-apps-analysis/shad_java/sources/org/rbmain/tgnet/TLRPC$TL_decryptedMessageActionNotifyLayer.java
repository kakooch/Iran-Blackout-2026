package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_decryptedMessageActionNotifyLayer extends TLRPC$DecryptedMessageAction {
    public static int constructor = -217806717;

    @Override // org.rbmain.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.layer = abstractSerializedData.readInt32(z);
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeInt32(this.layer);
    }
}
