package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class TLRPC$TL_messages_stickerSet extends TLObject {
    public static int constructor = -1240849242;
    public TLRPC$StickerSet set;
    public ArrayList<TLRPC$TL_stickerPack> packs = new ArrayList<>();
    public ArrayList<TLRPC$Document> documents = new ArrayList<>();

    public static TLRPC$TL_messages_stickerSet TLdeserialize(AbstractSerializedData stream, int constructor2, boolean exception) {
        if (constructor != constructor2) {
            if (exception) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_messages_stickerSet", Integer.valueOf(constructor2)));
            }
            return null;
        }
        TLRPC$TL_messages_stickerSet tLRPC$TL_messages_stickerSet = new TLRPC$TL_messages_stickerSet();
        tLRPC$TL_messages_stickerSet.readParams(stream, exception);
        return tLRPC$TL_messages_stickerSet;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.set = TLRPC$StickerSet.TLdeserialize(stream, stream.readInt32(exception), exception);
        int int32 = stream.readInt32(exception);
        if (int32 != 481674261) {
            if (exception) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
            }
            return;
        }
        int int322 = stream.readInt32(exception);
        for (int i = 0; i < int322; i++) {
            TLRPC$TL_stickerPack tLRPC$TL_stickerPackTLdeserialize = TLRPC$TL_stickerPack.TLdeserialize(stream, stream.readInt32(exception), exception);
            if (tLRPC$TL_stickerPackTLdeserialize == null) {
                return;
            }
            this.packs.add(tLRPC$TL_stickerPackTLdeserialize);
        }
        int int323 = stream.readInt32(exception);
        if (int323 != 481674261) {
            if (exception) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int323)));
            }
            return;
        }
        int int324 = stream.readInt32(exception);
        for (int i2 = 0; i2 < int324; i2++) {
            TLRPC$Document tLRPC$DocumentTLdeserialize = TLRPC$Document.TLdeserialize(stream, stream.readInt32(exception), exception);
            if (tLRPC$DocumentTLdeserialize == null) {
                return;
            }
            this.documents.add(tLRPC$DocumentTLdeserialize);
        }
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.set.serializeToStream(stream);
        stream.writeInt32(481674261);
        int size = this.packs.size();
        stream.writeInt32(size);
        for (int i = 0; i < size; i++) {
            this.packs.get(i).serializeToStream(stream);
        }
        stream.writeInt32(481674261);
        int size2 = this.documents.size();
        stream.writeInt32(size2);
        for (int i2 = 0; i2 < size2; i2++) {
            this.documents.get(i2).serializeToStream(stream);
        }
    }
}
