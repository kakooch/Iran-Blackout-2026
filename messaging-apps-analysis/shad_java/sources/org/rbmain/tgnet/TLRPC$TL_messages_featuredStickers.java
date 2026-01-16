package org.rbmain.tgnet;

import java.util.ArrayList;

/* loaded from: classes4.dex */
public class TLRPC$TL_messages_featuredStickers extends TLRPC$messages_FeaturedStickers {
    public static int constructor = -1230257343;
    public int count;
    public boolean hasContinue;
    public int hash;
    public String nextStartId;
    public ArrayList<TLRPC$StickerSetCovered> sets = new ArrayList<>();
    public ArrayList<Long> unread = new ArrayList<>();

    @Override // org.rbmain.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.hash = abstractSerializedData.readInt32(z);
        this.count = abstractSerializedData.readInt32(z);
        int int32 = abstractSerializedData.readInt32(z);
        if (int32 != 481674261) {
            if (z) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
            }
            return;
        }
        int int322 = abstractSerializedData.readInt32(z);
        for (int i = 0; i < int322; i++) {
            TLRPC$StickerSetCovered tLRPC$StickerSetCoveredTLdeserialize = TLRPC$StickerSetCovered.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
            if (tLRPC$StickerSetCoveredTLdeserialize == null) {
                return;
            }
            this.sets.add(tLRPC$StickerSetCoveredTLdeserialize);
        }
        int int323 = abstractSerializedData.readInt32(z);
        if (int323 != 481674261) {
            if (z) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int323)));
            }
        } else {
            int int324 = abstractSerializedData.readInt32(z);
            for (int i2 = 0; i2 < int324; i2++) {
                this.unread.add(Long.valueOf(abstractSerializedData.readInt64(z)));
            }
        }
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeInt32(this.hash);
        abstractSerializedData.writeInt32(this.count);
        abstractSerializedData.writeInt32(481674261);
        int size = this.sets.size();
        abstractSerializedData.writeInt32(size);
        for (int i = 0; i < size; i++) {
            this.sets.get(i).serializeToStream(abstractSerializedData);
        }
        abstractSerializedData.writeInt32(481674261);
        int size2 = this.unread.size();
        abstractSerializedData.writeInt32(size2);
        for (int i2 = 0; i2 < size2; i2++) {
            abstractSerializedData.writeInt64(this.unread.get(i2).longValue());
        }
    }
}
