package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_account_getPasswordSettings extends TLObject {
    public static int constructor = -1663767815;
    public TLRPC$InputCheckPasswordSRP password;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$TL_account_passwordSettings.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.password.serializeToStream(stream);
    }
}
