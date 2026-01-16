package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_auth_cancelCode extends TLObject {
    public static int constructor = 520357240;
    public String phone_code_hash;
    public String phone_number;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$Bool.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeString(this.phone_number);
        stream.writeString(this.phone_code_hash);
    }
}
