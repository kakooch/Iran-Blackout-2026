package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_auth_checkPassword_layer84 extends TLObject {
    public static int constructor = -1987323361;
    public int flags;
    public byte[] password_hash;
    public String phone_code;
    public String phone_number;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$auth_Authorization.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeByteArray(this.password_hash);
        stream.writeInt32(this.flags);
        if ((this.flags & 1) != 0) {
            stream.writeString(this.phone_code);
        }
        if ((this.flags & 2) != 0) {
            stream.writeString(this.phone_number);
        }
    }
}
