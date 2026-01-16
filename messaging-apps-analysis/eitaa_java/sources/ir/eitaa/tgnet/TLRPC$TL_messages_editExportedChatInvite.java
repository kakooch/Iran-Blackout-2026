package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_messages_editExportedChatInvite extends TLObject {
    public static int constructor = 48562110;
    public int expire_date;
    public int flags;
    public String link;
    public TLRPC$InputPeer peer;
    public boolean revoked;
    public int usage_limit;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$messages_ExportedChatInvite.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        int i = this.revoked ? this.flags | 4 : this.flags & (-5);
        this.flags = i;
        stream.writeInt32(i);
        this.peer.serializeToStream(stream);
        stream.writeString(this.link);
        if ((this.flags & 1) != 0) {
            stream.writeInt32(this.expire_date);
        }
        if ((this.flags & 2) != 0) {
            stream.writeInt32(this.usage_limit);
        }
    }
}
