package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_messages_getHistory extends TLObject {
    public static int constructor = 1143203525;
    public int add_offset;
    public long hash;
    public int limit;
    public int max_id;
    public int min_id;
    public int offset_date;
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
        stream.writeInt32(this.offset_date);
        stream.writeInt32(this.add_offset);
        stream.writeInt32(this.limit);
        stream.writeInt32(this.max_id);
        stream.writeInt32(this.min_id);
        stream.writeInt64(this.hash);
    }
}
