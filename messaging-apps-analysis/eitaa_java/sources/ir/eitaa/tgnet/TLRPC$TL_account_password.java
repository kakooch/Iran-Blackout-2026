package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_account_password extends TLObject {
    public static int constructor = 408623183;
    public TLRPC$PasswordKdfAlgo current_algo;
    public String email_unconfirmed_pattern;
    public int flags;
    public boolean has_password;
    public boolean has_recovery;
    public boolean has_secure_values;
    public String hint;
    public TLRPC$PasswordKdfAlgo new_algo;
    public TLRPC$SecurePasswordKdfAlgo new_secure_algo;
    public int pending_reset_date;
    public byte[] secure_random;
    public byte[] srp_B;
    public long srp_id;

    public static TLRPC$TL_account_password TLdeserialize(AbstractSerializedData stream, int constructor2, boolean exception) {
        if (constructor != constructor2) {
            if (exception) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_account_password", Integer.valueOf(constructor2)));
            }
            return null;
        }
        TLRPC$TL_account_password tLRPC$TL_account_password = new TLRPC$TL_account_password();
        tLRPC$TL_account_password.readParams(stream, exception);
        return tLRPC$TL_account_password;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        int int32 = stream.readInt32(exception);
        this.flags = int32;
        this.has_recovery = (int32 & 1) != 0;
        this.has_secure_values = (int32 & 2) != 0;
        this.has_password = (int32 & 4) != 0;
        if ((int32 & 4) != 0) {
            this.current_algo = TLRPC$PasswordKdfAlgo.TLdeserialize(stream, stream.readInt32(exception), exception);
        }
        if ((this.flags & 4) != 0) {
            this.srp_B = stream.readByteArray(exception);
        }
        if ((this.flags & 4) != 0) {
            this.srp_id = stream.readInt64(exception);
        }
        if ((this.flags & 8) != 0) {
            this.hint = stream.readString(exception);
        }
        if ((this.flags & 16) != 0) {
            this.email_unconfirmed_pattern = stream.readString(exception);
        }
        this.new_algo = TLRPC$PasswordKdfAlgo.TLdeserialize(stream, stream.readInt32(exception), exception);
        this.new_secure_algo = TLRPC$SecurePasswordKdfAlgo.TLdeserialize(stream, stream.readInt32(exception), exception);
        this.secure_random = stream.readByteArray(exception);
        if ((this.flags & 32) != 0) {
            this.pending_reset_date = stream.readInt32(exception);
        }
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        int i = this.has_recovery ? this.flags | 1 : this.flags & (-2);
        this.flags = i;
        int i2 = this.has_secure_values ? i | 2 : i & (-3);
        this.flags = i2;
        int i3 = this.has_password ? i2 | 4 : i2 & (-5);
        this.flags = i3;
        stream.writeInt32(i3);
        if ((this.flags & 4) != 0) {
            this.current_algo.serializeToStream(stream);
        }
        if ((this.flags & 4) != 0) {
            stream.writeByteArray(this.srp_B);
        }
        if ((this.flags & 4) != 0) {
            stream.writeInt64(this.srp_id);
        }
        if ((this.flags & 8) != 0) {
            stream.writeString(this.hint);
        }
        if ((this.flags & 16) != 0) {
            stream.writeString(this.email_unconfirmed_pattern);
        }
        this.new_algo.serializeToStream(stream);
        this.new_secure_algo.serializeToStream(stream);
        stream.writeByteArray(this.secure_random);
        if ((this.flags & 32) != 0) {
            stream.writeInt32(this.pending_reset_date);
        }
    }
}
