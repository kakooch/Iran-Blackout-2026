package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_account_resetPasswordRequestedWait extends TLRPC$account_ResetPasswordResult {
    public static int constructor = -370148227;
    public int until_date;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.until_date = stream.readInt32(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt32(this.until_date);
    }
}
