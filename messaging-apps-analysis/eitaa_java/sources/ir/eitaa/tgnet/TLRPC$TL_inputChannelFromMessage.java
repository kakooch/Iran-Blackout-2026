package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_inputChannelFromMessage extends TLRPC$InputChannel {
    public static int constructor = 1536380829;
    public int msg_id;
    public TLRPC$InputPeer peer;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.peer = TLRPC$InputPeer.TLdeserialize(stream, stream.readInt32(exception), exception);
        this.msg_id = stream.readInt32(exception);
        this.channel_id = stream.readInt64(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.peer.serializeToStream(stream);
        stream.writeInt32(this.msg_id);
        stream.writeInt64(this.channel_id);
    }
}
