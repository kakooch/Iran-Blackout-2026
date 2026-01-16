package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_messages_search extends TLObject {
    public static int constructor = -1593989278;
    public TLRPC$MessagesFilter filter;
    public int flags;
    public TLRPC$InputPeer from_id;
    public int limit;
    public int max_date;
    public int max_id;
    public int min_date;
    public int offset_id;
    public TLRPC$InputPeer peer;
    public String q;
    public int top_msg_id;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$messages_Messages.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        this.max_id = this.offset_id;
        stream.writeInt32(constructor);
        stream.writeInt32(this.flags);
        this.peer.serializeToStream(stream);
        stream.writeString(this.q);
        if ((this.flags & 1) != 0) {
            this.from_id.serializeToStream(stream);
        }
        if ((this.flags & 2) != 0) {
            stream.writeInt32(this.top_msg_id);
        }
        this.filter.serializeToStream(stream);
        stream.writeInt32(this.min_date);
        stream.writeInt32(this.max_date);
        stream.writeInt32(this.offset_id);
        stream.writeInt32(this.max_id);
        stream.writeInt32(this.limit);
    }
}
