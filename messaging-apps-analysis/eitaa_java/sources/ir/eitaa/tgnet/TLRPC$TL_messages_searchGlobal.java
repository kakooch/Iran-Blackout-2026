package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_messages_searchGlobal extends TLObject {
    public static int constructor = 1271290010;
    public TLRPC$MessagesFilter filter;
    public int flags;
    public int folder_id;
    public int limit;
    public int max_date;
    public int min_date;
    public int offset_id;
    public TLRPC$InputPeer offset_peer;
    public int offset_rate;
    public String q;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$messages_Messages.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt32(this.flags);
        if ((this.flags & 1) != 0) {
            stream.writeInt32(this.folder_id);
        }
        stream.writeString(this.q);
        TLRPC$MessagesFilter tLRPC$MessagesFilter = this.filter;
        if (tLRPC$MessagesFilter != null) {
            tLRPC$MessagesFilter.serializeToStream(stream);
        }
        stream.writeInt32(this.min_date);
        stream.writeInt32(this.max_date);
        stream.writeInt32(this.offset_rate);
        this.offset_peer.serializeToStream(stream);
        stream.writeInt32(this.offset_id);
        stream.writeInt32(this.limit);
    }
}
