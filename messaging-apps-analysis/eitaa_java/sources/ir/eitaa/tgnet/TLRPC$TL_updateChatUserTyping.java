package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_updateChatUserTyping extends TLRPC$Update {
    public static int constructor = -2092401936;
    public TLRPC$SendMessageAction action;
    public long chat_id;
    public TLRPC$Peer from_id;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.chat_id = stream.readInt64(exception);
        this.from_id = TLRPC$Peer.TLdeserialize(stream, stream.readInt32(exception), exception);
        this.action = TLRPC$SendMessageAction.TLdeserialize(stream, stream.readInt32(exception), exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt64(this.chat_id);
        this.from_id.serializeToStream(stream);
        this.action.serializeToStream(stream);
    }
}
