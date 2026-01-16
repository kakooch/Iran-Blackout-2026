package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_stats_getBroadcastStats extends TLObject {
    public static int constructor = -1421720550;
    public TLRPC$InputChannel channel;
    public boolean dark;
    public int flags;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$TL_stats_broadcastStats.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        int i = this.dark ? this.flags | 1 : this.flags & (-2);
        this.flags = i;
        stream.writeInt32(i);
        this.channel.serializeToStream(stream);
    }
}
