package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_account_passwordInputSettings_layer84 extends TLObject {
    public static int constructor = 570402317;
    public String email;
    public int flags;
    public String hint;
    public byte[] new_password_hash;
    public byte[] new_salt;
    public byte[] new_secure_salt;
    public byte[] new_secure_secret;
    public long new_secure_secret_id;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        int int32 = stream.readInt32(exception);
        this.flags = int32;
        if ((int32 & 1) != 0) {
            this.new_salt = stream.readByteArray(exception);
        }
        if ((this.flags & 1) != 0) {
            this.new_password_hash = stream.readByteArray(exception);
        }
        if ((this.flags & 1) != 0) {
            this.hint = stream.readString(exception);
        }
        if ((this.flags & 2) != 0) {
            this.email = stream.readString(exception);
        }
        if ((this.flags & 4) != 0) {
            this.new_secure_salt = stream.readByteArray(exception);
        }
        if ((this.flags & 4) != 0) {
            this.new_secure_secret = stream.readByteArray(exception);
        }
        if ((this.flags & 4) != 0) {
            this.new_secure_secret_id = stream.readInt64(exception);
        }
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt32(this.flags);
        if ((this.flags & 1) != 0) {
            stream.writeByteArray(this.new_salt);
        }
        if ((this.flags & 1) != 0) {
            stream.writeByteArray(this.new_password_hash);
        }
        if ((this.flags & 1) != 0) {
            stream.writeString(this.hint);
        }
        if ((this.flags & 2) != 0) {
            stream.writeString(this.email);
        }
        if ((this.flags & 4) != 0) {
            stream.writeByteArray(this.new_secure_salt);
        }
        if ((this.flags & 4) != 0) {
            stream.writeByteArray(this.new_secure_secret);
        }
        if ((this.flags & 4) != 0) {
            stream.writeInt64(this.new_secure_secret_id);
        }
    }
}
