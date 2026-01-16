package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_twoStep_verifyCode extends TLObject {
    public static int constructor = 1470999061;
    public String phone_code;
    public String phone_code_hash;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$Bool.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeString(this.phone_code_hash);
        stream.writeString(this.phone_code);
    }
}
