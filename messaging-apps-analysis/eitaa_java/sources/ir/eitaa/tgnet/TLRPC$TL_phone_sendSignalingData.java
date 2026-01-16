package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_phone_sendSignalingData extends TLObject {
    public static int constructor = -8744061;
    public byte[] data;
    public TLRPC$TL_inputPhoneCall peer;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$Bool.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.peer.serializeToStream(stream);
        stream.writeByteArray(this.data);
    }
}
