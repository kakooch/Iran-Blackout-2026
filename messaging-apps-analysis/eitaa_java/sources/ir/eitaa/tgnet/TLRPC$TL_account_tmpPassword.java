package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_account_tmpPassword extends TLObject {
    public static int constructor = -614138572;
    public byte[] tmp_password;
    public int valid_until;

    public static TLRPC$TL_account_tmpPassword TLdeserialize(AbstractSerializedData stream, int constructor2, boolean exception) {
        if (constructor != constructor2) {
            if (exception) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_account_tmpPassword", Integer.valueOf(constructor2)));
            }
            return null;
        }
        TLRPC$TL_account_tmpPassword tLRPC$TL_account_tmpPassword = new TLRPC$TL_account_tmpPassword();
        tLRPC$TL_account_tmpPassword.readParams(stream, exception);
        return tLRPC$TL_account_tmpPassword;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.tmp_password = stream.readByteArray(exception);
        this.valid_until = stream.readInt32(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeByteArray(this.tmp_password);
        stream.writeInt32(this.valid_until);
    }
}
