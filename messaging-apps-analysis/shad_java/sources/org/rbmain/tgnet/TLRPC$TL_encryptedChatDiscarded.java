package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_encryptedChatDiscarded extends TLRPC$EncryptedChat {
    public static int constructor = 505183301;

    @Override // org.rbmain.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        int int32 = abstractSerializedData.readInt32(z);
        this.flags = int32;
        this.history_deleted = (int32 & 1) != 0;
        this.id = abstractSerializedData.readInt32(z);
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        int i = this.history_deleted ? this.flags | 1 : this.flags & (-2);
        this.flags = i;
        abstractSerializedData.writeInt32(i);
        abstractSerializedData.writeInt32(this.id);
    }
}
