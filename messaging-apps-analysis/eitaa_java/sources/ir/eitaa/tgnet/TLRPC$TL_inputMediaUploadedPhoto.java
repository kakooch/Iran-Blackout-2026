package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_inputMediaUploadedPhoto extends TLRPC$InputMedia {
    public static int constructor = 505969924;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.flags = stream.readInt32(exception);
        this.file = TLRPC$InputFile.TLdeserialize(stream, stream.readInt32(exception), exception);
        if ((this.flags & 1) != 0) {
            int int32 = stream.readInt32(exception);
            if (int32 != 481674261) {
                if (exception) {
                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
                }
                return;
            }
            int int322 = stream.readInt32(exception);
            for (int i = 0; i < int322; i++) {
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
        stream.writeInt32(this.flags);
        this.file.serializeToStream(stream);
        if ((this.flags & 1) != 0) {
            stream.writeInt32(481674261);
            int size = this.stickers.size();
            stream.writeInt32(size);
            for (int i = 0; i < size; i++) {
                this.stickers.get(i).serializeToStream(stream);
            }
        }
        if ((this.flags & 2) != 0) {
            stream.writeInt32(this.ttl_seconds);
        }
    }
}
