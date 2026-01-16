package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_auth_recoverPassword extends TLObject {
    public static int constructor = 923364464;
    public String code;
    public int flags;
    public TLRPC$TL_account_passwordInputSettings new_settings;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$auth_Authorization.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt32(this.flags);
        stream.writeString(this.code);
        if ((this.flags & 1) != 0) {
            this.new_settings.serializeToStream(stream);
        }
    }
}
