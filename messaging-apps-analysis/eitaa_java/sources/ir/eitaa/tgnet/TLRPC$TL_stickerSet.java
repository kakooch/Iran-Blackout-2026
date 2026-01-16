package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_stickerSet extends TLRPC$StickerSet {
    public static int constructor = -673242758;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        int int32 = stream.readInt32(exception);
        this.flags = int32;
        this.archived = (int32 & 2) != 0;
        this.official = (int32 & 4) != 0;
        this.masks = (int32 & 8) != 0;
        this.animated = (int32 & 32) != 0;
        if ((int32 & 1) != 0) {
            this.installed_date = stream.readInt32(exception);
        }
        this.id = stream.readInt64(exception);
        this.access_hash = stream.readInt64(exception);
        this.title = stream.readString(exception);
        this.short_name = stream.readString(exception);
        if ((this.flags & 16) != 0) {
            int int322 = stream.readInt32(exception);
            if (int322 != 481674261) {
                if (exception) {
                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
                }
                return;
            }
            int int323 = stream.readInt32(exception);
            for (int i = 0; i < int323; i++) {
                TLRPC$PhotoSize tLRPC$PhotoSizeTLdeserialize = TLRPC$PhotoSize.TLdeserialize(0L, 0L, this.id, stream, stream.readInt32(exception), exception);
                if (tLRPC$PhotoSizeTLdeserialize == null) {
                    return;
                }
                this.thumbs.add(tLRPC$PhotoSizeTLdeserialize);
            }
        }
        if ((this.flags & 16) != 0) {
            this.thumb_dc_id = stream.readInt32(exception);
        }
        if ((this.flags & 16) != 0) {
            this.thumb_version = stream.readInt32(exception);
        }
        this.count = stream.readInt32(exception);
        this.hash = stream.readInt32(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        int i = this.archived ? this.flags | 2 : this.flags & (-3);
        this.flags = i;
        int i2 = this.official ? i | 4 : i & (-5);
        this.flags = i2;
        int i3 = this.masks ? i2 | 8 : i2 & (-9);
        this.flags = i3;
        int i4 = this.animated ? i3 | 32 : i3 & (-33);
        this.flags = i4;
        stream.writeInt32(i4);
        if ((this.flags & 1) != 0) {
            stream.writeInt32(this.installed_date);
        }
        stream.writeInt64(this.id);
        stream.writeInt64(this.access_hash);
        stream.writeString(this.title);
        stream.writeString(this.short_name);
        if ((this.flags & 16) != 0) {
            stream.writeInt32(481674261);
            int size = this.thumbs.size();
            stream.writeInt32(size);
            for (int i5 = 0; i5 < size; i5++) {
                this.thumbs.get(i5).serializeToStream(stream);
            }
        }
        if ((this.flags & 16) != 0) {
            stream.writeInt32(this.thumb_dc_id);
        }
        if ((this.flags & 16) != 0) {
            stream.writeInt32(this.thumb_version);
        }
        stream.writeInt32(this.count);
        stream.writeInt32(this.hash);
    }
}
