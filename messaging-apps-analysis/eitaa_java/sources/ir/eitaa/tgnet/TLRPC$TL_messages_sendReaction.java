package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_messages_sendReaction extends TLObject {
    public static int constructor = 627641572;
    public int flags;
    public int msg_id;
    public TLRPC$InputPeer peer;
    public String reaction;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$Updates.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt32(this.flags);
        this.peer.serializeToStream(stream);
        stream.writeInt32(this.msg_id);
        if ((this.flags & 1) != 0) {
            stream.writeString(this.reaction);
        }
    }
}
