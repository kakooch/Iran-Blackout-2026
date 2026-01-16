package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_payments_validateRequestedInfo extends TLObject {
    public static int constructor = -619695760;
    public int flags;
    public TLRPC$TL_paymentRequestedInfo info;
    public int msg_id;
    public TLRPC$InputPeer peer;
    public boolean save;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$TL_payments_validatedRequestedInfo.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        int i = this.save ? this.flags | 1 : this.flags & (-2);
        this.flags = i;
        stream.writeInt32(i);
        this.peer.serializeToStream(stream);
        stream.writeInt32(this.msg_id);
        this.info.serializeToStream(stream);
    }
}
