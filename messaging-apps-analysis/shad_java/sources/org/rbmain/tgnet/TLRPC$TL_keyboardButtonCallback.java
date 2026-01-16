package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_keyboardButtonCallback extends TLRPC$KeyboardButton {
    public static int constructor = 901503851;

    @Override // org.rbmain.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        int int32 = abstractSerializedData.readInt32(z);
        this.flags = int32;
        this.requires_password = (int32 & 1) != 0;
        this.text = abstractSerializedData.readString(z);
        this.data = abstractSerializedData.readByteArray(z);
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        int i = this.requires_password ? this.flags | 1 : this.flags & (-2);
        this.flags = i;
        abstractSerializedData.writeInt32(i);
        abstractSerializedData.writeString(this.text);
        abstractSerializedData.writeByteArray(this.data);
    }
}
