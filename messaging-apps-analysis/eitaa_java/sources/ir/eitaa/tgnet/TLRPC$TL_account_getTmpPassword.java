package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_account_getTmpPassword extends TLObject {
    public static int constructor = 1151208273;
    public TLRPC$InputCheckPasswordSRP password;
    public int period;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$TL_account_tmpPassword.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.password.serializeToStream(stream);
        stream.writeInt32(this.period);
    }
}
