package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_auth_sendCode extends TLObject {
    public static int constructor = -1502141361;
    public String api_hash;
    public int api_id;
    public String phone_number;
    public TLRPC$TL_codeSettings settings;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$TL_auth_sentCode.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeString(this.phone_number);
        stream.writeInt32(this.api_id);
        stream.writeString(this.api_hash);
        this.settings.serializeToStream(stream);
    }
}
