package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_photo extends TLRPC$Photo {
    public static int constructor = -82216347;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        int int32 = stream.readInt32(exception);
        this.flags = int32;
        this.has_stickers = (int32 & 1) != 0;
        this.id = stream.readInt64(exception);
        this.access_hash = stream.readInt64(exception);
        this.file_reference = stream.readByteArray(exception);
        this.date = stream.readInt32(exception);
        int int322 = stream.readInt32(exception);
        if (int322 != 481674261) {
            if (exception) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
            }
            return;
        }
        int int323 = stream.readInt32(exception);
        for (int i = 0; i < int323; i++) {
            TLRPC$PhotoSize tLRPC$PhotoSizeTLdeserialize = TLRPC$PhotoSize.TLdeserialize(this.id, 0L, 0L, stream, stream.readInt32(exception), exception);
            if (tLRPC$PhotoSizeTLdeserialize == null) {
                return;
            }
            this.sizes.add(tLRPC$PhotoSizeTLdeserialize);
        }
        if ((this.flags & 2) != 0) {
            int int324 = stream.readInt32(exception);
            if (int324 != 481674261) {
                if (exception) {
                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int324)));
                }
                return;
            }
            int int325 = stream.readInt32(exception);
            for (int i2 = 0; i2 < int325; i2++) {
                TLRPC$VideoSize tLRPC$VideoSizeTLdeserialize = TLRPC$VideoSize.TLdeserialize(this.id, 0L, stream, stream.readInt32(exception), exception);
                if (tLRPC$VideoSizeTLdeserialize == null) {
                    return;
                }
                this.video_sizes.add(tLRPC$VideoSizeTLdeserialize);
            }
        }
        this.dc_id = stream.readInt32(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        int i = this.has_stickers ? this.flags | 1 : this.flags & (-2);
        this.flags = i;
        stream.writeInt32(i);
        stream.writeInt64(this.id);
        stream.writeInt64(this.access_hash);
        stream.writeByteArray(this.file_reference);
        stream.writeInt32(this.date);
        stream.writeInt32(481674261);
        int size = this.sizes.size();
        stream.writeInt32(size);
        for (int i2 = 0; i2 < size; i2++) {
            this.sizes.get(i2).serializeToStream(stream);
        }
        if ((this.flags & 2) != 0) {
            stream.writeInt32(481674261);
            int size2 = this.video_sizes.size();
            stream.writeInt32(size2);
            for (int i3 = 0; i3 < size2; i3++) {
                this.video_sizes.get(i3).serializeToStream(stream);
            }
        }
        stream.writeInt32(this.dc_id);
    }
}
