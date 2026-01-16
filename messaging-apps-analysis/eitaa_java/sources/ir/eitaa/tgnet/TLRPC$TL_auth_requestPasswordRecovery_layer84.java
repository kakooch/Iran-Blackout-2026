package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_auth_requestPasswordRecovery_layer84 extends TLObject {
    public static int constructor = -267583977;
    public int flags;
    public String phone_code;
    public String phone_number;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$TL_auth_passwordRecovery.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt32(this.flags);
        if ((this.flags & 1) != 0) {
            stream.writeString(this.phone_code);
        }
        if ((this.flags & 2) != 0) {
            stream.writeString(this.phone_number);
        }
    }
}
