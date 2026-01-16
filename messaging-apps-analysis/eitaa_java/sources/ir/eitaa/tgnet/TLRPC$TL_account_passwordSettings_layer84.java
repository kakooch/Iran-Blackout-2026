package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_account_passwordSettings_layer84 extends TLObject {
    public static int constructor = 2077869041;
    public String email;
    public byte[] secure_salt;
    public byte[] secure_secret;
    public long secure_secret_id;

    public static TLRPC$TL_account_passwordSettings_layer84 TLdeserialize(AbstractSerializedData stream, int constructor2, boolean exception) {
        if (constructor != constructor2) {
            if (exception) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_account_passwordSettings_layer84", Integer.valueOf(constructor2)));
            }
            return null;
        }
        TLRPC$TL_account_passwordSettings_layer84 tLRPC$TL_account_passwordSettings_layer84 = new TLRPC$TL_account_passwordSettings_layer84();
        tLRPC$TL_account_passwordSettings_layer84.readParams(stream, exception);
        return tLRPC$TL_account_passwordSettings_layer84;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.email = stream.readString(exception);
        this.secure_salt = stream.readByteArray(exception);
        this.secure_secret = stream.readByteArray(exception);
        this.secure_secret_id = stream.readInt64(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeString(this.email);
        stream.writeByteArray(this.secure_salt);
        stream.writeByteArray(this.secure_secret);
        stream.writeInt64(this.secure_secret_id);
    }
}
