package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_help_acceptTermsOfService extends TLObject {
    public static int constructor = -294455398;
    public TLRPC$TL_dataJSON id;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$Bool.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.id.serializeToStream(stream);
    }
}
