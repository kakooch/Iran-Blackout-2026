package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public abstract class TLRPC$account_Password extends TLObject {
    public byte[] current_salt;
    public String email_unconfirmed_pattern;
    public int flags;
    public boolean has_recovery;
    public boolean has_secure_values;
    public String hint;
    public byte[] new_salt;
    public byte[] new_secure_salt;
    public byte[] secure_random;

    public static TLRPC$account_Password TLdeserialize(AbstractSerializedData stream, int constructor, boolean exception) {
        TLRPC$account_Password tLRPC$account_Password;
        if (constructor == -902187961) {
            tLRPC$account_Password = new TLRPC$account_Password() { // from class: ir.eitaa.tgnet.TLRPC$TL_account_password_layer84
                public static int constructor = -902187961;

                @Override // ir.eitaa.tgnet.TLObject
                public void readParams(AbstractSerializedData stream2, boolean exception2) {
                    int int32 = stream2.readInt32(exception2);
                    this.flags = int32;
                    this.has_recovery = (int32 & 1) != 0;
                    this.has_secure_values = (int32 & 2) != 0;
                    this.current_salt = stream2.readByteArray(exception2);
                    this.new_salt = stream2.readByteArray(exception2);
                    this.new_secure_salt = stream2.readByteArray(exception2);
                    this.secure_random = stream2.readByteArray(exception2);
                    this.hint = stream2.readString(exception2);
                    this.email_unconfirmed_pattern = stream2.readString(exception2);
                }

                @Override // ir.eitaa.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData stream2) {
                    stream2.writeInt32(constructor);
                    int i = this.has_recovery ? this.flags | 1 : this.flags & (-2);
                    this.flags = i;
                    int i2 = this.has_secure_values ? i | 2 : i & (-3);
                    this.flags = i2;
                    stream2.writeInt32(i2);
                    stream2.writeByteArray(this.current_salt);
                    stream2.writeByteArray(this.new_salt);
                    stream2.writeByteArray(this.new_secure_salt);
                    stream2.writeByteArray(this.secure_random);
                    stream2.writeString(this.hint);
                    stream2.writeString(this.email_unconfirmed_pattern);
                }
            };
        } else {
            tLRPC$account_Password = constructor != 1587643126 ? null : new TLRPC$account_Password() { // from class: ir.eitaa.tgnet.TLRPC$TL_account_noPassword
                public static int constructor = 1587643126;

                @Override // ir.eitaa.tgnet.TLObject
                public void readParams(AbstractSerializedData stream2, boolean exception2) {
                    this.new_salt = stream2.readByteArray(exception2);
                    this.new_secure_salt = stream2.readByteArray(exception2);
                    this.secure_random = stream2.readByteArray(exception2);
                    this.email_unconfirmed_pattern = stream2.readString(exception2);
                }

                @Override // ir.eitaa.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData stream2) {
                    stream2.writeInt32(constructor);
                    stream2.writeByteArray(this.new_salt);
                    stream2.writeByteArray(this.new_secure_salt);
                    stream2.writeByteArray(this.secure_random);
                    stream2.writeString(this.email_unconfirmed_pattern);
                }
            };
        }
        if (tLRPC$account_Password == null && exception) {
            throw new RuntimeException(String.format("can't parse magic %x in account_Password", Integer.valueOf(constructor)));
        }
        if (tLRPC$account_Password != null) {
            tLRPC$account_Password.readParams(stream, exception);
        }
        return tLRPC$account_Password;
    }
}
