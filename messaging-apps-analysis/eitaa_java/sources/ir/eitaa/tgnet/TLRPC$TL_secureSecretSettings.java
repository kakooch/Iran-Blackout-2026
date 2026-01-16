package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_secureSecretSettings extends TLObject {
    public static int constructor = 354925740;
    public TLRPC$SecurePasswordKdfAlgo secure_algo;
    public byte[] secure_secret;
    public long secure_secret_id;

    public static TLRPC$TL_secureSecretSettings TLdeserialize(AbstractSerializedData stream, int constructor2, boolean exception) {
        if (constructor != constructor2) {
            if (exception) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_secureSecretSettings", Integer.valueOf(constructor2)));
            }
            return null;
        }
        TLRPC$TL_secureSecretSettings tLRPC$TL_secureSecretSettings = new TLRPC$TL_secureSecretSettings();
        tLRPC$TL_secureSecretSettings.readParams(stream, exception);
        return tLRPC$TL_secureSecretSettings;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.secure_algo = TLRPC$SecurePasswordKdfAlgo.TLdeserialize(stream, stream.readInt32(exception), exception);
        this.secure_secret = stream.readByteArray(exception);
        this.secure_secret_id = stream.readInt64(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.secure_algo.serializeToStream(stream);
        stream.writeByteArray(this.secure_secret);
        stream.writeInt64(this.secure_secret_id);
    }
}
