package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_updateChannelUserTyping extends TLRPC$Update {
    public static int constructor = -1937192669;
    public TLRPC$SendMessageAction action;
    public long channel_id;
    public int flags;
    public TLRPC$Peer from_id;
    public int top_msg_id;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.flags = stream.readInt32(exception);
        this.channel_id = stream.readInt64(exception);
        if ((this.flags & 1) != 0) {
            this.top_msg_id = stream.readInt32(exception);
        }
        this.from_id = TLRPC$Peer.TLdeserialize(stream, stream.readInt32(exception), exception);
        this.action = TLRPC$SendMessageAction.TLdeserialize(stream, stream.readInt32(exception), exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt32(this.flags);
        stream.writeInt64(this.channel_id);
        if ((this.flags & 1) != 0) {
            stream.writeInt32(this.top_msg_id);
        }
        this.from_id.serializeToStream(stream);
        this.action.serializeToStream(stream);
    }
}
