package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_account_saveSecureValue extends TLObject {
    public static int constructor = -1986010339;
    public long secure_secret_id;
    public TLRPC$TL_inputSecureValue value;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$TL_secureValue.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.value.serializeToStream(stream);
        stream.writeInt64(this.secure_secret_id);
    }
}
