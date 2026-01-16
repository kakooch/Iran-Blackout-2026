package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_account_password extends TLObject {
    public static int constructor = -1390001672;
    public TLRPC$PasswordKdfAlgo current_algo;
    public String email_unconfirmed_pattern;
    public int flags;
    public boolean has_password;
    public boolean has_recovery;
    public boolean has_secure_values;
    public String hint;
    public TLRPC$PasswordKdfAlgo new_algo;
    public TLRPC$SecurePasswordKdfAlgo new_secure_algo;
    public String no_recovery_alert;
    public byte[] secure_random;
    public byte[] srp_B;
    public long srp_id;

    public static TLRPC$TL_account_password TLdeserialize(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        if (constructor != i) {
            if (z) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_account_password", Integer.valueOf(i)));
            }
            return null;
        }
        TLRPC$TL_account_password tLRPC$TL_account_password = new TLRPC$TL_account_password();
        tLRPC$TL_account_password.readParams(abstractSerializedData, z);
        return tLRPC$TL_account_password;
    }

    @Override // org.rbmain.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        int int32 = abstractSerializedData.readInt32(z);
        this.flags = int32;
        this.has_recovery = (int32 & 1) != 0;
        this.has_secure_values = (int32 & 2) != 0;
        this.has_password = (int32 & 4) != 0;
        if ((int32 & 4) != 0) {
            this.current_algo = TLRPC$PasswordKdfAlgo.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
        }
        if ((this.flags & 4) != 0) {
            this.srp_B = abstractSerializedData.readByteArray(z);
        }
        if ((this.flags & 4) != 0) {
            this.srp_id = abstractSerializedData.readInt64(z);
        }
        if ((this.flags & 8) != 0) {
            this.hint = abstractSerializedData.readString(z);
        }
        if ((this.flags & 16) != 0) {
            this.email_unconfirmed_pattern = abstractSerializedData.readString(z);
        }
        this.new_algo = TLRPC$PasswordKdfAlgo.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
        this.new_secure_algo = TLRPC$SecurePasswordKdfAlgo.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
        this.secure_random = abstractSerializedData.readByteArray(z);
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        int i = this.has_recovery ? this.flags | 1 : this.flags & (-2);
        this.flags = i;
        int i2 = this.has_secure_values ? i | 2 : i & (-3);
        this.flags = i2;
        int i3 = this.has_password ? i2 | 4 : i2 & (-5);
        this.flags = i3;
        abstractSerializedData.writeInt32(i3);
        if ((this.flags & 4) != 0) {
            this.current_algo.serializeToStream(abstractSerializedData);
        }
        if ((this.flags & 4) != 0) {
            abstractSerializedData.writeByteArray(this.srp_B);
        }
        if ((this.flags & 4) != 0) {
            abstractSerializedData.writeInt64(this.srp_id);
        }
        if ((this.flags & 8) != 0) {
            abstractSerializedData.writeString(this.hint);
        }
        if ((this.flags & 16) != 0) {
            abstractSerializedData.writeString(this.email_unconfirmed_pattern);
        }
        this.new_algo.serializeToStream(abstractSerializedData);
        this.new_secure_algo.serializeToStream(abstractSerializedData);
        abstractSerializedData.writeByteArray(this.secure_random);
    }
}
