package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_inputPhotoFileLocation extends TLRPC$InputFileLocation {
    public static int constructor = 1075322878;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.id = stream.readInt64(exception);
        this.access_hash = stream.readInt64(exception);
        this.file_reference = stream.readByteArray(exception);
        this.thumb_size = stream.readString(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt64(this.id);
        stream.writeInt64(this.access_hash);
        stream.writeByteArray(this.file_reference);
        stream.writeString(this.thumb_size);
    }
}
