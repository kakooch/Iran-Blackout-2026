package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_phone_acceptCall extends TLObject {
    public static int constructor = 1003664544;
    public byte[] g_b;
    public TLRPC$TL_inputPhoneCall peer;
    public TLRPC$TL_phoneCallProtocol protocol;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$TL_phone_phoneCall.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.peer.serializeToStream(stream);
        stream.writeByteArray(this.g_b);
        this.protocol.serializeToStream(stream);
    }
}
