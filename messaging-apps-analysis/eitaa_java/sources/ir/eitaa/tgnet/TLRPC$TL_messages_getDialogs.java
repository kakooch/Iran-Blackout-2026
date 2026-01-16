package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_messages_getDialogs extends TLObject {
    public static int constructor = -1594569905;
    public boolean exclude_pinned;
    public int flags;
    public int folder_id;
    public long hash;
    public int limit;
    public int offset_date;
    public int offset_id;
    public TLRPC$InputPeer offset_peer;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$messages_Dialogs.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        int i = this.exclude_pinned ? this.flags | 1 : this.flags & (-2);
        this.flags = i;
        stream.writeInt32(i);
        if ((this.flags & 2) != 0) {
            stream.writeInt32(this.folder_id);
        }
        stream.writeInt32(this.offset_date);
        stream.writeInt32(this.offset_id);
        this.offset_peer.serializeToStream(stream);
        stream.writeInt32(this.limit);
        stream.writeInt64(this.hash);
    }
}
