package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_account_sendConfirmPhoneCode extends TLObject {
    public static int constructor = 457157256;
    public String hash;
    public TLRPC$TL_codeSettings settings;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$TL_auth_sentCode.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeString(this.hash);
        this.settings.serializeToStream(stream);
    }
}
