package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_account_changePhone extends TLObject {
    public static int constructor = 1891839707;
    public String phone_code;
    public String phone_code_hash;
    public String phone_number;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$User.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeString(this.phone_number);
        stream.writeString(this.phone_code_hash);
        stream.writeString(this.phone_code);
    }
}
