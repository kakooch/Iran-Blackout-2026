package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_messages_searchGlobalExt extends TLObject {
    public static int constructor = 711765008;
    public int flags;
    public int limit;
    public int offset_date;
    public int offset_id;
    public TLRPC$InputPeer offset_peer;
    public String q;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$messages_Messages.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt32(this.flags);
        stream.writeString(this.q);
        stream.writeInt32(this.offset_date);
        this.offset_peer.serializeToStream(stream);
        stream.writeInt32(this.offset_id);
        stream.writeInt32(this.limit);
    }
}
