package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_updateReadChannelDiscussionInbox extends TLRPC$Update {
    public static int constructor = -693004986;
    public long broadcast_id;
    public int broadcast_post;
    public long channel_id;
    public int flags;
    public int read_max_id;
    public int top_msg_id;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.flags = stream.readInt32(exception);
        this.channel_id = stream.readInt64(exception);
        this.top_msg_id = stream.readInt32(exception);
        this.read_max_id = stream.readInt32(exception);
        if ((this.flags & 1) != 0) {
            this.broadcast_id = stream.readInt64(exception);
        }
        if ((this.flags & 1) != 0) {
            this.broadcast_post = stream.readInt32(exception);
        }
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt32(this.flags);
        stream.writeInt64(this.channel_id);
        stream.writeInt32(this.top_msg_id);
        stream.writeInt32(this.read_max_id);
        if ((this.flags & 1) != 0) {
            stream.writeInt64(this.broadcast_id);
        }
        if ((this.flags & 1) != 0) {
            stream.writeInt32(this.broadcast_post);
        }
    }
}
