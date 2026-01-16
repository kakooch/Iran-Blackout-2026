package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_phone_discardCall extends TLObject {
    public static int constructor = -1295269440;
    public long connection_id;
    public int duration;
    public int flags;
    public TLRPC$TL_inputPhoneCall peer;
    public TLRPC$PhoneCallDiscardReason reason;
    public boolean video;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$Updates.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        int i = this.video ? this.flags | 1 : this.flags & (-2);
        this.flags = i;
        stream.writeInt32(i);
        this.peer.serializeToStream(stream);
        stream.writeInt32(this.duration);
        this.reason.serializeToStream(stream);
        stream.writeInt64(this.connection_id);
    }
}
