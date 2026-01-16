package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_dialogFolder extends TLRPC$Dialog {
    public static int constructor = 1908216652;
    public TLRPC$TL_folder folder;
    public int unread_muted_messages_count;
    public int unread_muted_peers_count;
    public int unread_unmuted_messages_count;
    public int unread_unmuted_peers_count;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        int int32 = stream.readInt32(exception);
        this.flags = int32;
        this.pinned = (int32 & 4) != 0;
        this.folder = TLRPC$TL_folder.TLdeserialize(stream, stream.readInt32(exception), exception);
        this.peer = TLRPC$Peer.TLdeserialize(stream, stream.readInt32(exception), exception);
        this.top_message = stream.readInt32(exception);
        this.unread_muted_peers_count = stream.readInt32(exception);
        this.unread_unmuted_peers_count = stream.readInt32(exception);
        this.unread_muted_messages_count = stream.readInt32(exception);
        this.unread_unmuted_messages_count = stream.readInt32(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        int i = this.pinned ? this.flags | 4 : this.flags & (-5);
        this.flags = i;
        stream.writeInt32(i);
        this.folder.serializeToStream(stream);
        this.peer.serializeToStream(stream);
        stream.writeInt32(this.top_message);
        stream.writeInt32(this.unread_muted_peers_count);
        stream.writeInt32(this.unread_unmuted_peers_count);
        stream.writeInt32(this.unread_muted_messages_count);
        stream.writeInt32(this.unread_unmuted_messages_count);
    }
}
