package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_account_verifyEmail extends TLObject {
    public static int constructor = -323339813;
    public String code;
    public String email;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$Bool.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeString(this.email);
        stream.writeString(this.code);
    }
}
