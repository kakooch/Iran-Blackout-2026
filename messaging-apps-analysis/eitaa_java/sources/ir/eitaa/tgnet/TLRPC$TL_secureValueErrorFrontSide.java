package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_secureValueErrorFrontSide extends TLRPC$SecureValueError {
    public static int constructor = 12467706;
    public byte[] file_hash;
    public String text;
    public TLRPC$SecureValueType type;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.type = TLRPC$SecureValueType.TLdeserialize(stream, stream.readInt32(exception), exception);
        this.file_hash = stream.readByteArray(exception);
        this.text = stream.readString(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.type.serializeToStream(stream);
        stream.writeByteArray(this.file_hash);
        stream.writeString(this.text);
    }
}
