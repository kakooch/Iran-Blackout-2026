package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_stats_loadAsyncGraph extends TLObject {
    public static int constructor = 1646092192;
    public int flags;
    public String token;
    public long x;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$StatsGraph.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt32(this.flags);
        stream.writeString(this.token);
        if ((this.flags & 1) != 0) {
            stream.writeInt64(this.x);
        }
    }
}
