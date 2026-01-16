package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_secureCredentialsEncrypted extends TLObject {
    public static int constructor = 871426631;
    public byte[] data;
    public byte[] hash;
    public byte[] secret;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.data = stream.readByteArray(exception);
        this.hash = stream.readByteArray(exception);
        this.secret = stream.readByteArray(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeByteArray(this.data);
        stream.writeByteArray(this.hash);
        stream.writeByteArray(this.secret);
    }
}
