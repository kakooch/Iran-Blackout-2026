package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_messages_readDiscussion extends TLObject {
    public static int constructor = -147740172;
    public int msg_id;
    public TLRPC$InputPeer peer;
    public int read_max_id;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$Bool.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.peer.serializeToStream(stream);
        stream.writeInt32(this.msg_id);
        stream.writeInt32(this.read_max_id);
    }
}
