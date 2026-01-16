package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_messages_savedGifs extends TLRPC$messages_SavedGifs {
    public static int constructor = 772213157;

    @Override // org.rbmain.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.hash = abstractSerializedData.readInt32(z);
        int int32 = abstractSerializedData.readInt32(z);
        if (int32 != 481674261) {
            if (z) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
            }
            return;
        }
        int int322 = abstractSerializedData.readInt32(z);
        for (int i = 0; i < int322; i++) {
            TLRPC$Document tLRPC$DocumentTLdeserialize = TLRPC$Document.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
            if (tLRPC$DocumentTLdeserialize == null) {
                return;
            }
            this.gifs.add(tLRPC$DocumentTLdeserialize);
        }
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeInt32(this.hash);
        abstractSerializedData.writeInt32(481674261);
        int size = this.gifs.size();
        abstractSerializedData.writeInt32(size);
        for (int i = 0; i < size; i++) {
            this.gifs.get(i).serializeToStream(abstractSerializedData);
        }
    }
}
