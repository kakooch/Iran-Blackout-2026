package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_account_resetPasswordFailedWait extends TLRPC$account_ResetPasswordResult {
    public static int constructor = -478701471;
    public int retry_date;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.retry_date = stream.readInt32(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt32(this.retry_date);
    }
}
