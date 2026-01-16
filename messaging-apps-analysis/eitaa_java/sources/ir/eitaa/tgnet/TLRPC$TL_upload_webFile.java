package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_upload_webFile extends TLObject {
    public static int constructor = 568808380;
    public NativeByteBuffer bytes;
    public TLRPC$storage_FileType file_type;
    public String mime_type;
    public int mtime;
    public int size;

    public static TLRPC$TL_upload_webFile TLdeserialize(AbstractSerializedData stream, int constructor2, boolean exception) {
        if (constructor != constructor2) {
            if (exception) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_upload_webFile", Integer.valueOf(constructor2)));
            }
            return null;
        }
        TLRPC$TL_upload_webFile tLRPC$TL_upload_webFile = new TLRPC$TL_upload_webFile();
        tLRPC$TL_upload_webFile.readParams(stream, exception);
        return tLRPC$TL_upload_webFile;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.size = stream.readInt32(exception);
        this.mime_type = stream.readString(exception);
        this.file_type = TLRPC$storage_FileType.TLdeserialize(stream, stream.readInt32(exception), exception);
        this.mtime = stream.readInt32(exception);
        this.bytes = stream.readByteBuffer(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt32(this.size);
        stream.writeString(this.mime_type);
        this.file_type.serializeToStream(stream);
        stream.writeInt32(this.mtime);
        stream.writeByteBuffer(this.bytes);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void freeResources() {
        NativeByteBuffer nativeByteBuffer;
        if (this.disableFree || (nativeByteBuffer = this.bytes) == null) {
            return;
        }
        nativeByteBuffer.reuse();
        this.bytes = null;
    }
}
