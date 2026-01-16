package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_updateMessageReactions extends TLRPC$Update {
    public static int constructor = 357013699;
    public int msg_id;
    public TLRPC$Peer peer;
    public TLRPC$TL_messageReactions reactions;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.peer = TLRPC$Peer.TLdeserialize(stream, stream.readInt32(exception), exception);
        this.msg_id = stream.readInt32(exception);
        this.reactions = TLRPC$TL_messageReactions.TLdeserialize(stream, stream.readInt32(exception), exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.peer.serializeToStream(stream);
        stream.writeInt32(this.msg_id);
        this.reactions.serializeToStream(stream);
    }
}
