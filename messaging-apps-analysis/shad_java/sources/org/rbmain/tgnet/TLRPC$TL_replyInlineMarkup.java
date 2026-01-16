package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_replyInlineMarkup extends TLRPC$ReplyMarkup {
    public static int constructor = 1218642516;

    @Override // org.rbmain.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        int int32 = abstractSerializedData.readInt32(z);
        if (int32 != 481674261) {
            if (z) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
            }
            return;
        }
        int int322 = abstractSerializedData.readInt32(z);
        for (int i = 0; i < int322; i++) {
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
        abstractSerializedData.writeInt32(481674261);
        int size = this.rows.size();
        abstractSerializedData.writeInt32(size);
        for (int i = 0; i < size; i++) {
            this.rows.get(i).serializeToStream(abstractSerializedData);
        }
    }
}
