package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_phone_confirmCall extends TLObject {
    public static int constructor = 788404002;
    public byte[] g_a;
    public long key_fingerprint;
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
        stream.writeByteArray(this.g_a);
        stream.writeInt64(this.key_fingerprint);
        this.protocol.serializeToStream(stream);
    }
}
