package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_auth_acceptLoginToken extends TLObject {
    public static int constructor = -392909491;
    public byte[] token;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$TL_authorization.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeByteArray(this.token);
    }
}
