package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_auth_passwordRecovery extends TLObject {
    public static int constructor = 326715557;
    public String email_pattern;

    public static TLRPC$TL_auth_passwordRecovery TLdeserialize(AbstractSerializedData stream, int constructor2, boolean exception) {
        if (constructor != constructor2) {
            if (exception) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_auth_passwordRecovery", Integer.valueOf(constructor2)));
            }
            return null;
        }
        TLRPC$TL_auth_passwordRecovery tLRPC$TL_auth_passwordRecovery = new TLRPC$TL_auth_passwordRecovery();
        tLRPC$TL_auth_passwordRecovery.readParams(stream, exception);
        return tLRPC$TL_auth_passwordRecovery;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.email_pattern = stream.readString(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeString(this.email_pattern);
    }
}
