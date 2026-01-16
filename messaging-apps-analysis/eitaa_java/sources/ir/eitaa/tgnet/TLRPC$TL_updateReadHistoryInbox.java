package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_updateReadHistoryInbox extends TLRPC$Update {
    public static int constructor = -1667805217;
    public int flags;
    public int folder_id;
    public int max_id;
    public TLRPC$Peer peer;
    public int pts;
    public int pts_count;
    public int still_unread_count;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        int int32 = stream.readInt32(exception);
        this.flags = int32;
        if ((int32 & 1) != 0) {
            this.folder_id = stream.readInt32(exception);
        }
        this.peer = TLRPC$Peer.TLdeserialize(stream, stream.readInt32(exception), exception);
        this.max_id = stream.readInt32(exception);
        this.still_unread_count = stream.readInt32(exception);
        this.pts = stream.readInt32(exception);
        this.pts_count = stream.readInt32(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt32(this.flags);
        if ((this.flags & 1) != 0) {
            stream.writeInt32(this.folder_id);
        }
        this.peer.serializeToStream(stream);
        stream.writeInt32(this.max_id);
        stream.writeInt32(this.still_unread_count);
        stream.writeInt32(this.pts);
        stream.writeInt32(this.pts_count);
    }
}
