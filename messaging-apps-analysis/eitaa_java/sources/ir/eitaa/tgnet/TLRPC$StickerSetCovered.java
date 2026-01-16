package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class TLRPC$StickerSetCovered extends TLObject {
    public TLRPC$Document cover;
    public ArrayList<TLRPC$Document> covers = new ArrayList<>();
    public TLRPC$StickerSet set;

    public static TLRPC$StickerSetCovered TLdeserialize(AbstractSerializedData stream, int constructor, boolean exception) {
        TLRPC$StickerSetCovered tLRPC$StickerSetCovered;
        if (constructor == 872932635) {
            tLRPC$StickerSetCovered = new TLRPC$StickerSetCovered() { // from class: ir.eitaa.tgnet.TLRPC$TL_stickerSetMultiCovered
                public static int constructor = 872932635;

                @Override // ir.eitaa.tgnet.TLObject
                public void readParams(AbstractSerializedData stream2, boolean exception2) {
                    this.set = TLRPC$StickerSet.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                    int int32 = stream2.readInt32(exception2);
                    if (int32 != 481674261) {
                        if (exception2) {
                            throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
                        }
                        return;
                    }
                    int int322 = stream2.readInt32(exception2);
                    for (int i = 0; i < int322; i++) {
                        TLRPC$Document tLRPC$DocumentTLdeserialize = TLRPC$Document.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        if (tLRPC$DocumentTLdeserialize == null) {
                            return;
                        }
                        this.covers.add(tLRPC$DocumentTLdeserialize);
                    }
                }

                @Override // ir.eitaa.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData stream2) {
                    stream2.writeInt32(constructor);
                    this.set.serializeToStream(stream2);
                    stream2.writeInt32(481674261);
                    int size = this.covers.size();
                    stream2.writeInt32(size);
                    for (int i = 0; i < size; i++) {
                        this.covers.get(i).serializeToStream(stream2);
                    }
                }
            };
        } else {
            tLRPC$StickerSetCovered = constructor != 1678812626 ? null : new TLRPC$StickerSetCovered() { // from class: ir.eitaa.tgnet.TLRPC$TL_stickerSetCovered
                public static int constructor = 1678812626;

                @Override // ir.eitaa.tgnet.TLObject
                public void readParams(AbstractSerializedData stream2, boolean exception2) {
                    this.set = TLRPC$StickerSet.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                    this.cover = TLRPC$Document.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                }

                @Override // ir.eitaa.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData stream2) {
                    stream2.writeInt32(constructor);
                    this.set.serializeToStream(stream2);
                    this.cover.serializeToStream(stream2);
                }
            };
        }
        if (tLRPC$StickerSetCovered == null && exception) {
            throw new RuntimeException(String.format("can't parse magic %x in StickerSetCovered", Integer.valueOf(constructor)));
        }
        if (tLRPC$StickerSetCovered != null) {
            tLRPC$StickerSetCovered.readParams(stream, exception);
        }
        return tLRPC$StickerSetCovered;
    }
}
