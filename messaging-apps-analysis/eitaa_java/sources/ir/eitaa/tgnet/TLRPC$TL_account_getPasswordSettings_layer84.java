package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_account_getPasswordSettings_layer84 extends TLObject {
    public static int constructor = -1131605573;
    public byte[] current_password_hash;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$TL_account_passwordSettings_layer84.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeByteArray(this.current_password_hash);
    }
}
