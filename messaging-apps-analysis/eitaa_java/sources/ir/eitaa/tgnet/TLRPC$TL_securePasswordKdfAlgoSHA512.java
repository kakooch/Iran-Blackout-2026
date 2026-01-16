package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_securePasswordKdfAlgoSHA512 extends TLRPC$SecurePasswordKdfAlgo {
    public static int constructor = -2042159726;
    public byte[] salt;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.salt = stream.readByteArray(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeByteArray(this.salt);
    }
}
