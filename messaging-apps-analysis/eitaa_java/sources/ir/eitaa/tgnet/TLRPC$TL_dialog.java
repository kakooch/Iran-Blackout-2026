package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_dialog extends TLRPC$Dialog {
    public static int constructor = 739712882;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        int int32 = stream.readInt32(exception);
        this.flags = int32;
        this.pinned = (int32 & 4) != 0;
        this.isLocked = (1048576 & int32) != 0;
        this.unread_mark = (int32 & 8) != 0;
        this.peer = TLRPC$Peer.TLdeserialize(stream, stream.readInt32(exception), exception);
        this.top_message = stream.readInt32(exception);
        this.read_inbox_max_id = stream.readInt32(exception);
        this.read_outbox_max_id = stream.readInt32(exception);
        this.unread_count = stream.readInt32(exception);
        this.unread_mentions_count = stream.readInt32(exception);
        this.notify_settings = TLRPC$PeerNotifySettings.TLdeserialize(stream, stream.readInt32(exception), exception);
        if ((this.flags & 1) != 0) {
            this.pts = stream.readInt32(exception);
        }
        if ((this.flags & 2) != 0) {
            this.draft = TLRPC$DraftMessage.TLdeserialize(stream, stream.readInt32(exception), exception);
        }
        if ((this.flags & 16) != 0) {
            this.folder_id = stream.readInt32(exception);
        }
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        int i = this.pinned ? this.flags | 4 : this.flags & (-5);
        this.flags = i;
        int i2 = this.isLocked ? i | 1048576 : i & (-1048577);
        this.flags = i2;
        int i3 = this.unread_mark ? i2 | 8 : i2 & (-9);
        this.flags = i3;
        stream.writeInt32(i3);
        this.peer.serializeToStream(stream);
        stream.writeInt32(this.top_message);
        stream.writeInt32(this.read_inbox_max_id);
        stream.writeInt32(this.read_outbox_max_id);
        stream.writeInt32(this.unread_count);
        stream.writeInt32(this.unread_mentions_count);
        this.notify_settings.serializeToStream(stream);
        if ((this.flags & 1) != 0) {
            stream.writeInt32(this.pts);
        }
        if ((this.flags & 2) != 0) {
            this.draft.serializeToStream(stream);
        }
        if ((this.flags & 16) != 0) {
            stream.writeInt32(this.folder_id);
        }
    }
}
