package org.rbmain.tgnet;

import java.util.ArrayList;

/* loaded from: classes4.dex */
public abstract class TLRPC$StickerSetCovered extends TLObject {
    public TLRPC$Document cover;
    public ArrayList<TLRPC$Document> covers = new ArrayList<>();
    public TLRPC$StickerSet set;

    public static TLRPC$StickerSetCovered TLdeserialize(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        TLRPC$StickerSetCovered tLRPC$TL_stickerSetCovered;
        if (i == 872932635) {
            tLRPC$TL_stickerSetCovered = new TLRPC$StickerSetCovered() { // from class: org.rbmain.tgnet.TLRPC$TL_stickerSetMultiCovered
                public static int constructor = 872932635;

                @Override // org.rbmain.tgnet.TLObject
                public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                    this.set = TLRPC$StickerSet.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                    int int32 = abstractSerializedData2.readInt32(z2);
                    if (int32 != 481674261) {
                        if (z2) {
                            throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
                        }
                        return;
                    }
                    int int322 = abstractSerializedData2.readInt32(z2);
                    for (int i2 = 0; i2 < int322; i2++) {
                        TLRPC$Document tLRPC$DocumentTLdeserialize = TLRPC$Document.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        if (tLRPC$DocumentTLdeserialize == null) {
                            return;
                        }
                        this.covers.add(tLRPC$DocumentTLdeserialize);
                    }
                }

                @Override // org.rbmain.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                    abstractSerializedData2.writeInt32(constructor);
                    this.set.serializeToStream(abstractSerializedData2);
                    abstractSerializedData2.writeInt32(481674261);
                    int size = this.covers.size();
                    abstractSerializedData2.writeInt32(size);
                    for (int i2 = 0; i2 < size; i2++) {
                        this.covers.get(i2).serializeToStream(abstractSerializedData2);
                    }
                }
            };
        } else {
            tLRPC$TL_stickerSetCovered = i != 1678812626 ? null : new TLRPC$TL_stickerSetCovered();
        }
        if (tLRPC$TL_stickerSetCovered == null && z) {
            throw new RuntimeException(String.format("can't parse magic %x in StickerSetCovered", Integer.valueOf(i)));
        }
        if (tLRPC$TL_stickerSetCovered != null) {
            tLRPC$TL_stickerSetCovered.readParams(abstractSerializedData, z);
        }
        return tLRPC$TL_stickerSetCovered;
    }
}
