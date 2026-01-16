package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_updateChannelTooLong extends TLRPC$Update {
    public static int constructor = 277713951;
    public long channel_id;
    public int flags;
    public int pts;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.flags = stream.readInt32(exception);
        this.channel_id = stream.readInt64(exception);
        if ((this.flags & 1) != 0) {
            this.pts = stream.readInt32(exception);
        }
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt32(this.flags);
        stream.writeInt64(this.channel_id);
        if ((this.flags & 1) != 0) {
            stream.writeInt32(this.pts);
        }
    }
}
