package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_updateReadChannelInbox extends TLRPC$Update {
    public static int constructor = -1842450928;
    public long channel_id;
    public int flags;
    public int folder_id;
    public int max_id;
    public int pts;
    public int still_unread_count;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        int int32 = stream.readInt32(exception);
        this.flags = int32;
        if ((int32 & 1) != 0) {
            this.folder_id = stream.readInt32(exception);
        }
        this.channel_id = stream.readInt64(exception);
        this.max_id = stream.readInt32(exception);
        this.still_unread_count = stream.readInt32(exception);
        this.pts = stream.readInt32(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt32(this.flags);
        if ((this.flags & 1) != 0) {
            stream.writeInt32(this.folder_id);
        }
        stream.writeInt64(this.channel_id);
        stream.writeInt32(this.max_id);
        stream.writeInt32(this.still_unread_count);
        stream.writeInt32(this.pts);
    }
}
