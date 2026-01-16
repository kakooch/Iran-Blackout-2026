package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_messages_getExportedChatInvites extends TLObject {
    public static int constructor = -1565154314;
    public TLRPC$InputUser admin_id;
    public int flags;
    public int limit;
    public int offset_date;
    public String offset_link;
    public TLRPC$InputPeer peer;
    public boolean revoked;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$TL_messages_exportedChatInvites.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        int i = this.revoked ? this.flags | 8 : this.flags & (-9);
        this.flags = i;
        stream.writeInt32(i);
        this.peer.serializeToStream(stream);
        this.admin_id.serializeToStream(stream);
        if ((this.flags & 4) != 0) {
            stream.writeInt32(this.offset_date);
        }
        if ((this.flags & 4) != 0) {
            stream.writeString(this.offset_link);
        }
        stream.writeInt32(this.limit);
    }
}
