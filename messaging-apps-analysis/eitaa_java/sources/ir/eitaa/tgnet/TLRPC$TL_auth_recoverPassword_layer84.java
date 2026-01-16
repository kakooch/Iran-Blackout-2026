package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_auth_recoverPassword_layer84 extends TLObject {
    public static int constructor = -1365719131;
    public String code;
    public int flags;
    public String phone_code;
    public String phone_number;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$auth_Authorization.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeString(this.code);
        stream.writeInt32(this.flags);
        if ((this.flags & 1) != 0) {
            stream.writeString(this.phone_code);
        }
        if ((this.flags & 2) != 0) {
            stream.writeString(this.phone_number);
        }
    }
}
