package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_messages_setTyping extends TLObject {
    public static int constructor = 1486110434;
    public TLRPC$SendMessageAction action;
    public int flags;
    public TLRPC$InputPeer peer;
    public int top_msg_id;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$Bool.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt32(this.flags);
        this.peer.serializeToStream(stream);
        if ((this.flags & 1) != 0) {
            stream.writeInt32(this.top_msg_id);
        }
        this.action.serializeToStream(stream);
    }
}
