package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_messages_getUnreadMentions extends TLObject {
    public static int constructor = 1180140658;
    public int add_offset;
    public int limit;
    public int max_id;
    public int min_id;
    public int offset_id;
    public TLRPC$InputPeer peer;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$messages_Messages.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.peer.serializeToStream(stream);
        stream.writeInt32(this.offset_id);
        stream.writeInt32(this.add_offset);
        stream.writeInt32(this.limit);
        stream.writeInt32(this.max_id);
        stream.writeInt32(this.min_id);
    }
}
