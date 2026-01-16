package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_replyKeyboardHide extends TLRPC$ReplyMarkup {
    public static int constructor = -1606526075;

    @Override // org.rbmain.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        int int32 = abstractSerializedData.readInt32(z);
        this.flags = int32;
        this.selective = (int32 & 4) != 0;
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        int i = this.selective ? this.flags | 4 : this.flags & (-5);
        this.flags = i;
        abstractSerializedData.writeInt32(i);
    }
}
