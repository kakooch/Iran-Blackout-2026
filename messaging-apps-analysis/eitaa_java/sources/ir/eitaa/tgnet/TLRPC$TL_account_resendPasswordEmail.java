package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_account_resendPasswordEmail extends TLObject {
    public static int constructor = 2055154197;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$Bool.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
    }
}
