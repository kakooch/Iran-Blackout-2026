package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_inputFile extends TLRPC$InputFile {
    public static int constructor = -181407105;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.id = stream.readInt64(exception);
        this.parts = stream.readInt32(exception);
        this.name = stream.readString(exception);
        this.md5_checksum = stream.readString(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt64(this.id);
        stream.writeInt32(this.parts);
        stream.writeString(this.name);
        stream.writeString(this.md5_checksum);
    }
}
