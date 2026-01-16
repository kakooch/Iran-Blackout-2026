package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_passwordKdfAlgoSHA256SHA256PBKDF2HMACSHA512iter100000SHA256ModPow extends TLRPC$PasswordKdfAlgo {
    public static int constructor = 982592842;
    public int g;
    public byte[] p;
    public byte[] salt1;
    public byte[] salt2;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.salt1 = stream.readByteArray(exception);
        this.salt2 = stream.readByteArray(exception);
        this.g = stream.readInt32(exception);
        this.p = stream.readByteArray(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeByteArray(this.salt1);
        stream.writeByteArray(this.salt2);
        stream.writeInt32(this.g);
        stream.writeByteArray(this.p);
    }
}
