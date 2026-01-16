package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class TLRPC$messages_FavedStickers extends TLObject {
    public long hash;
    public ArrayList<TLRPC$TL_stickerPack> packs = new ArrayList<>();
    public ArrayList<TLRPC$Document> stickers = new ArrayList<>();

    public static TLRPC$messages_FavedStickers TLdeserialize(AbstractSerializedData stream, int constructor, boolean exception) {
        TLRPC$messages_FavedStickers tLRPC$messages_FavedStickers;
        if (constructor == -1634752813) {
            tLRPC$messages_FavedStickers = new TLRPC$messages_FavedStickers() { // from class: ir.eitaa.tgnet.TLRPC$TL_messages_favedStickersNotModified
                public static int constructor = -1634752813;

                @Override // ir.eitaa.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData stream2) {
                    stream2.writeInt32(constructor);
                }
            };
        } else {
            tLRPC$messages_FavedStickers = constructor != 750063767 ? null : new TLRPC$messages_FavedStickers() { // from class: ir.eitaa.tgnet.TLRPC$TL_messages_favedStickers
                public static int constructor = 750063767;

                @Override // ir.eitaa.tgnet.TLObject
                public void readParams(AbstractSerializedData stream2, boolean exception2) {
                    this.hash = stream2.readInt64(exception2);
                    int int32 = stream2.readInt32(exception2);
                    if (int32 != 481674261) {
                        if (exception2) {
                            throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
                        }
                        return;
                    }
                    int int322 = stream2.readInt32(exception2);
                    for (int i = 0; i < int322; i++) {
                        TLRPC$TL_stickerPack tLRPC$TL_stickerPackTLdeserialize = TLRPC$TL_stickerPack.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        if (tLRPC$TL_stickerPackTLdeserialize == null) {
                            return;
                        }
                        this.packs.add(tLRPC$TL_stickerPackTLdeserialize);
                    }
                    int int323 = stream2.readInt32(exception2);
                    if (int323 != 481674261) {
                        if (exception2) {
                            throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int323)));
                        }
                        return;
                    }
                    int int324 = stream2.readInt32(exception2);
                    for (int i2 = 0; i2 < int324; i2++) {
                        TLRPC$Document tLRPC$DocumentTLdeserialize = TLRPC$Document.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        if (tLRPC$DocumentTLdeserialize == null) {
                            return;
                        }
                        this.stickers.add(tLRPC$DocumentTLdeserialize);
                    }
                }

                @Override // ir.eitaa.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData stream2) {
                    stream2.writeInt32(constructor);
                    stream2.writeInt64(this.hash);
                    stream2.writeInt32(481674261);
                    int size = this.packs.size();
                    stream2.writeInt32(size);
                    for (int i = 0; i < size; i++) {
                        this.packs.get(i).serializeToStream(stream2);
                    }
                    stream2.writeInt32(481674261);
                    int size2 = this.stickers.size();
                    stream2.writeInt32(size2);
                    for (int i2 = 0; i2 < size2; i2++) {
                        this.stickers.get(i2).serializeToStream(stream2);
                    }
                }
            };
        }
        if (tLRPC$messages_FavedStickers == null && exception) {
            throw new RuntimeException(String.format("can't parse magic %x in messages_FavedStickers", Integer.valueOf(constructor)));
        }
        if (tLRPC$messages_FavedStickers != null) {
            tLRPC$messages_FavedStickers.readParams(stream, exception);
        }
        return tLRPC$messages_FavedStickers;
    }
}
