package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_document extends TLRPC$Document {
    public static int constructor = 512177195;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.flags = stream.readInt32(exception);
        this.id = stream.readInt64(exception);
        this.access_hash = stream.readInt64(exception);
        this.file_reference = stream.readByteArray(exception);
        this.date = stream.readInt32(exception);
        this.mime_type = stream.readString(exception);
        this.size = stream.readInt32(exception);
        if ((this.flags & 1) != 0) {
            int int32 = stream.readInt32(exception);
            if (int32 != 481674261) {
                if (exception) {
                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
                }
                return;
            }
            int int322 = stream.readInt32(exception);
            int i = 0;
            while (i < int322) {
                int i2 = i;
                TLRPC$PhotoSize tLRPC$PhotoSizeTLdeserialize = TLRPC$PhotoSize.TLdeserialize(0L, this.id, 0L, stream, stream.readInt32(exception), exception);
                if (tLRPC$PhotoSizeTLdeserialize == null) {
                    return;
                }
                this.thumbs.add(tLRPC$PhotoSizeTLdeserialize);
                i = i2 + 1;
            }
        }
        if ((this.flags & 2) != 0) {
            int int323 = stream.readInt32(exception);
            if (int323 != 481674261) {
                if (exception) {
                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int323)));
                }
                return;
            }
            int int324 = stream.readInt32(exception);
            for (int i3 = 0; i3 < int324; i3++) {
                TLRPC$VideoSize tLRPC$VideoSizeTLdeserialize = TLRPC$VideoSize.TLdeserialize(0L, this.id, stream, stream.readInt32(exception), exception);
                if (tLRPC$VideoSizeTLdeserialize == null) {
                    return;
                }
                this.video_thumbs.add(tLRPC$VideoSizeTLdeserialize);
            }
        }
        this.dc_id = stream.readInt32(exception);
        int int325 = stream.readInt32(exception);
        if (int325 != 481674261) {
            if (exception) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int325)));
            }
            return;
        }
        int int326 = stream.readInt32(exception);
        for (int i4 = 0; i4 < int326; i4++) {
            TLRPC$DocumentAttribute tLRPC$DocumentAttributeTLdeserialize = TLRPC$DocumentAttribute.TLdeserialize(stream, stream.readInt32(exception), exception);
            if (tLRPC$DocumentAttributeTLdeserialize == null) {
                return;
            }
            this.attributes.add(tLRPC$DocumentAttributeTLdeserialize);
        }
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt32(this.flags);
        stream.writeInt64(this.id);
        stream.writeInt64(this.access_hash);
        stream.writeByteArray(this.file_reference);
        stream.writeInt32(this.date);
        stream.writeString(this.mime_type);
        stream.writeInt32(this.size);
        if ((this.flags & 1) != 0) {
            stream.writeInt32(481674261);
            int size = this.thumbs.size();
            stream.writeInt32(size);
            for (int i = 0; i < size; i++) {
                this.thumbs.get(i).serializeToStream(stream);
            }
        }
        if ((this.flags & 2) != 0) {
            stream.writeInt32(481674261);
            int size2 = this.video_thumbs.size();
            stream.writeInt32(size2);
            for (int i2 = 0; i2 < size2; i2++) {
                this.video_thumbs.get(i2).serializeToStream(stream);
            }
        }
        stream.writeInt32(this.dc_id);
        stream.writeInt32(481674261);
        int size3 = this.attributes.size();
        stream.writeInt32(size3);
        for (int i3 = 0; i3 < size3; i3++) {
            this.attributes.get(i3).serializeToStream(stream);
        }
    }
}
