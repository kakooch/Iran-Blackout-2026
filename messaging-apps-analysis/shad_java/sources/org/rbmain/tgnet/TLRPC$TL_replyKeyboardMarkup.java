package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_replyKeyboardMarkup extends TLRPC$ReplyMarkup {
    public static int constructor = 889353612;

    @Override // org.rbmain.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        int int32 = abstractSerializedData.readInt32(z);
        this.flags = int32;
        this.resize = (int32 & 1) != 0;
        this.single_use = (int32 & 2) != 0;
        this.selective = (int32 & 4) != 0;
        int int322 = abstractSerializedData.readInt32(z);
        if (int322 != 481674261) {
            if (z) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
            }
            return;
        }
        int int323 = abstractSerializedData.readInt32(z);
        for (int i = 0; i < int323; i++) {
            TLRPC$TL_keyboardButtonRow tLRPC$TL_keyboardButtonRowTLdeserialize = TLRPC$TL_keyboardButtonRow.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
            if (tLRPC$TL_keyboardButtonRowTLdeserialize == null) {
                return;
            }
            this.rows.add(tLRPC$TL_keyboardButtonRowTLdeserialize);
        }
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        int i = this.resize ? this.flags | 1 : this.flags & (-2);
        this.flags = i;
        int i2 = this.single_use ? i | 2 : i & (-3);
        this.flags = i2;
        int i3 = this.selective ? i2 | 4 : i2 & (-5);
        this.flags = i3;
        abstractSerializedData.writeInt32(i3);
        abstractSerializedData.writeInt32(481674261);
        int size = this.rows.size();
        abstractSerializedData.writeInt32(size);
        for (int i4 = 0; i4 < size; i4++) {
            this.rows.get(i4).serializeToStream(abstractSerializedData);
        }
    }
}
