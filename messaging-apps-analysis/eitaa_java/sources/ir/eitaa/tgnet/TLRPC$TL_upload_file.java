package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_upload_file extends TLRPC$upload_File {
    public static int constructor = 157948117;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.type = TLRPC$storage_FileType.TLdeserialize(stream, stream.readInt32(exception), exception);
        this.mtime = stream.readInt32(exception);
        this.bytes = stream.readByteBuffer(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.type.serializeToStream(stream);
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
