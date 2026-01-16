package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class TLRPC$TL_messages_recentStickers extends TLRPC$messages_RecentStickers {
    public static int constructor = -1999405994;
    public long hash;
    public ArrayList<TLRPC$TL_stickerPack> packs = new ArrayList<>();
    public ArrayList<TLRPC$Document> stickers = new ArrayList<>();
    public ArrayList<Integer> dates = new ArrayList<>();

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.hash = stream.readInt64(exception);
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
            this.stickers.add(tLRPC$DocumentTLdeserialize);
        }
        int int325 = stream.readInt32(exception);
        if (int325 != 481674261) {
            if (exception) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int325)));
            }
        } else {
            int int326 = stream.readInt32(exception);
            for (int i3 = 0; i3 < int326; i3++) {
                this.dates.add(Integer.valueOf(stream.readInt32(exception)));
            }
        }
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt64(this.hash);
        stream.writeInt32(481674261);
        int size = this.packs.size();
        stream.writeInt32(size);
        for (int i = 0; i < size; i++) {
            this.packs.get(i).serializeToStream(stream);
        }
        stream.writeInt32(481674261);
        int size2 = this.stickers.size();
        stream.writeInt32(size2);
        for (int i2 = 0; i2 < size2; i2++) {
            this.stickers.get(i2).serializeToStream(stream);
        }
        stream.writeInt32(481674261);
        int size3 = this.dates.size();
        stream.writeInt32(size3);
        for (int i3 = 0; i3 < size3; i3++) {
            stream.writeInt32(this.dates.get(i3).intValue());
        }
    }
}
