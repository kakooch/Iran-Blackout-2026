package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_account_sendVerifyPhoneCode extends TLObject {
    public static int constructor = -1516022023;
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
        this.settings.serializeToStream(stream);
    }
}
