package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_inputMediaUploadedDocument extends TLRPC$InputMedia {
    public static int constructor = 1530447553;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        int int32 = stream.readInt32(exception);
        this.flags = int32;
        this.nosound_video = (int32 & 8) != 0;
        this.force_file = (int32 & 16) != 0;
        this.file = TLRPC$InputFile.TLdeserialize(stream, stream.readInt32(exception), exception);
        if ((this.flags & 4) != 0) {
            this.thumb = TLRPC$InputFile.TLdeserialize(stream, stream.readInt32(exception), exception);
        }
        this.mime_type = stream.readString(exception);
        int int322 = stream.readInt32(exception);
        if (int322 != 481674261) {
            if (exception) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
            }
            return;
        }
        int int323 = stream.readInt32(exception);
        for (int i = 0; i < int323; i++) {
            TLRPC$DocumentAttribute tLRPC$DocumentAttributeTLdeserialize = TLRPC$DocumentAttribute.TLdeserialize(stream, stream.readInt32(exception), exception);
            if (tLRPC$DocumentAttributeTLdeserialize == null) {
                return;
            }
            this.attributes.add(tLRPC$DocumentAttributeTLdeserialize);
        }
        if ((this.flags & 1) != 0) {
            int int324 = stream.readInt32(exception);
            if (int324 != 481674261) {
                if (exception) {
                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int324)));
                }
                return;
            }
            int int325 = stream.readInt32(exception);
            for (int i2 = 0; i2 < int325; i2++) {
                TLRPC$InputDocument tLRPC$InputDocumentTLdeserialize = TLRPC$InputDocument.TLdeserialize(stream, stream.readInt32(exception), exception);
                if (tLRPC$InputDocumentTLdeserialize == null) {
                    return;
                }
                this.stickers.add(tLRPC$InputDocumentTLdeserialize);
            }
        }
        if ((this.flags & 2) != 0) {
            this.ttl_seconds = stream.readInt32(exception);
        }
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        int i = this.nosound_video ? this.flags | 8 : this.flags & (-9);
        this.flags = i;
        int i2 = this.force_file ? i | 16 : i & (-17);
        this.flags = i2;
        stream.writeInt32(i2);
        this.file.serializeToStream(stream);
        if ((this.flags & 4) != 0) {
            this.thumb.serializeToStream(stream);
        }
        stream.writeString(this.mime_type);
        stream.writeInt32(481674261);
        int size = this.attributes.size();
        stream.writeInt32(size);
        for (int i3 = 0; i3 < size; i3++) {
            this.attributes.get(i3).serializeToStream(stream);
        }
        if ((this.flags & 1) != 0) {
            stream.writeInt32(481674261);
            int size2 = this.stickers.size();
            stream.writeInt32(size2);
            for (int i4 = 0; i4 < size2; i4++) {
                this.stickers.get(i4).serializeToStream(stream);
            }
        }
        if ((this.flags & 2) != 0) {
            stream.writeInt32(this.ttl_seconds);
        }
    }
}
