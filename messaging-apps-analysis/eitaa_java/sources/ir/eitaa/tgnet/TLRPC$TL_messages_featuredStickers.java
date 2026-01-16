package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class TLRPC$TL_messages_featuredStickers extends TLRPC$messages_FeaturedStickers {
    public static int constructor = -2067782896;
    public int count;
    public long hash;
    public ArrayList<TLRPC$StickerSetCovered> sets = new ArrayList<>();
    public ArrayList<Long> unread = new ArrayList<>();

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.hash = stream.readInt64(exception);
        this.count = stream.readInt32(exception);
        int int32 = stream.readInt32(exception);
        if (int32 != 481674261) {
            if (exception) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
            }
            return;
        }
        int int322 = stream.readInt32(exception);
        for (int i = 0; i < int322; i++) {
            TLRPC$StickerSetCovered tLRPC$StickerSetCoveredTLdeserialize = TLRPC$StickerSetCovered.TLdeserialize(stream, stream.readInt32(exception), exception);
            if (tLRPC$StickerSetCoveredTLdeserialize == null) {
                return;
            }
            this.sets.add(tLRPC$StickerSetCoveredTLdeserialize);
        }
        int int323 = stream.readInt32(exception);
        if (int323 != 481674261) {
            if (exception) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int323)));
            }
        } else {
            int int324 = stream.readInt32(exception);
            for (int i2 = 0; i2 < int324; i2++) {
                this.unread.add(Long.valueOf(stream.readInt64(exception)));
            }
        }
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt64(this.hash);
        stream.writeInt32(this.count);
        stream.writeInt32(481674261);
        int size = this.sets.size();
        stream.writeInt32(size);
        for (int i = 0; i < size; i++) {
            this.sets.get(i).serializeToStream(stream);
        }
        stream.writeInt32(481674261);
        int size2 = this.unread.size();
        stream.writeInt32(size2);
        for (int i2 = 0; i2 < size2; i2++) {
            stream.writeInt64(this.unread.get(i2).longValue());
        }
    }
}
