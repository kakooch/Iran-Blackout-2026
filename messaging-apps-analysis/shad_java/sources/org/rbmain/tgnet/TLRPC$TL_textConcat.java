package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_textConcat extends TLRPC$RichText {
    public static int constructor = 2120376535;

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
            TLRPC$RichText tLRPC$RichTextTLdeserialize = TLRPC$RichText.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
            if (tLRPC$RichTextTLdeserialize == null) {
                return;
            }
            this.texts.add(tLRPC$RichTextTLdeserialize);
        }
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeInt32(481674261);
        int size = this.texts.size();
        abstractSerializedData.writeInt32(size);
        for (int i = 0; i < size; i++) {
            this.texts.get(i).serializeToStream(abstractSerializedData);
        }
    }
}
