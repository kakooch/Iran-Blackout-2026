package org.rbmain.tgnet;

import java.util.ArrayList;

/* loaded from: classes4.dex */
public class TLRPC$TL_messages_archivedStickers extends TLObject {
    public static int constructor = 1338747336;
    public int count;
    public boolean hasContinue;
    public String nextStartId;
    public ArrayList<TLRPC$StickerSetCovered> sets = new ArrayList<>();

    public static TLRPC$TL_messages_archivedStickers TLdeserialize(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        if (constructor != i) {
            if (z) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_messages_archivedStickers", Integer.valueOf(i)));
            }
            return null;
        }
        TLRPC$TL_messages_archivedStickers tLRPC$TL_messages_archivedStickers = new TLRPC$TL_messages_archivedStickers();
        tLRPC$TL_messages_archivedStickers.readParams(abstractSerializedData, z);
        return tLRPC$TL_messages_archivedStickers;
    }

    @Override // org.rbmain.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
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
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeInt32(this.count);
        abstractSerializedData.writeInt32(481674261);
        int size = this.sets.size();
        abstractSerializedData.writeInt32(size);
        for (int i = 0; i < size; i++) {
            this.sets.get(i).serializeToStream(abstractSerializedData);
        }
    }
}
