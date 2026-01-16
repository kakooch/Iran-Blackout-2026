package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_upload_saveBigFilePart extends TLObject {
    public static int constructor = -562337987;
    public byte[] bytes;
    public long file_id;
    public int file_part;
    public int file_total_parts;
    public int flags;
    public TLRPC$Peer peer;
    public long totalFileSize;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$Bool.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt64(this.file_id);
        stream.writeInt32(this.file_part);
        stream.writeInt32(this.file_total_parts);
        stream.writeByteArray(this.bytes);
        int i = this.flags | 2;
        this.flags = i;
        if (this.peer != null) {
            int i2 = i | 1;
            this.flags = i2;
            stream.writeInt32(i2);
            this.peer.serializeToStream(stream);
        } else {
            int i3 = i & (-2);
            this.flags = i3;
            stream.writeInt32(i3);
        }
        stream.writeInt64(this.totalFileSize);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void freeResources() {
        if (this.disableFree) {
        }
    }
}
