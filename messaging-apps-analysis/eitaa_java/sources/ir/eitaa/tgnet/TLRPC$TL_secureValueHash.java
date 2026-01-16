package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_secureValueHash extends TLObject {
    public static int constructor = -316748368;
    public byte[] hash;
    public TLRPC$SecureValueType type;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.type = TLRPC$SecureValueType.TLdeserialize(stream, stream.readInt32(exception), exception);
        this.hash = stream.readByteArray(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.type.serializeToStream(stream);
        stream.writeByteArray(this.hash);
    }
}
