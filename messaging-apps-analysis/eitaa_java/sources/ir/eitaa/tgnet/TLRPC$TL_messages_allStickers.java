package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_messages_allStickers extends TLRPC$messages_AllStickers {
    public static int constructor = -843329861;
    public long hash;

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
            TLRPC$StickerSet tLRPC$StickerSetTLdeserialize = TLRPC$StickerSet.TLdeserialize(stream, stream.readInt32(exception), exception);
            if (tLRPC$StickerSetTLdeserialize == null) {
                return;
            }
            this.sets.add(tLRPC$StickerSetTLdeserialize);
        }
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt64(this.hash);
        stream.writeInt32(481674261);
        int size = this.sets.size();
        stream.writeInt32(size);
        for (int i = 0; i < size; i++) {
            this.sets.get(i).serializeToStream(stream);
        }
    }
}
