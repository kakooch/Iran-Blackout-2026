package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_account_updatePasswordSettings_layer84 extends TLObject {
    public static int constructor = -92517498;
    public byte[] current_password_hash;
    public TLRPC$TL_account_passwordInputSettings_layer84 new_settings;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$Bool.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeByteArray(this.current_password_hash);
        this.new_settings.serializeToStream(stream);
    }
}
