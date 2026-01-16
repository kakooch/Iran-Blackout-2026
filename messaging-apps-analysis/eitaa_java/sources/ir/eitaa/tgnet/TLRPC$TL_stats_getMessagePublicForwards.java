package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_stats_getMessagePublicForwards extends TLObject {
    public static int constructor = 1445996571;
    public TLRPC$InputChannel channel;
    public int limit;
    public int msg_id;
    public int offset_id;
    public TLRPC$InputPeer offset_peer;
    public int offset_rate;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$messages_Messages.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.channel.serializeToStream(stream);
        stream.writeInt32(this.msg_id);
        stream.writeInt32(this.offset_rate);
        this.offset_peer.serializeToStream(stream);
        stream.writeInt32(this.offset_id);
        stream.writeInt32(this.limit);
    }
}
