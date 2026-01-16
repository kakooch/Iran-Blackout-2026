package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_updateReadChannelDiscussionOutbox extends TLRPC$Update {
    public static int constructor = 1767677564;
    public long channel_id;
    public int read_max_id;
    public int top_msg_id;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.channel_id = stream.readInt64(exception);
        this.top_msg_id = stream.readInt32(exception);
        this.read_max_id = stream.readInt32(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt64(this.channel_id);
        stream.writeInt32(this.top_msg_id);
        stream.writeInt32(this.read_max_id);
    }
}
