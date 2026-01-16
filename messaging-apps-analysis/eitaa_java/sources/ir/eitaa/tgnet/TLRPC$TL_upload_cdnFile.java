package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_upload_cdnFile extends TLRPC$upload_CdnFile {
    public static int constructor = -1449145777;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.bytes = stream.readByteBuffer(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
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
