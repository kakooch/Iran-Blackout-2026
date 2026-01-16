package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_account_sendVerifyEmailCode extends TLObject {
    public static int constructor = 1880182943;
    public String email;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$TL_account_sentEmailCode.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeString(this.email);
    }
}
