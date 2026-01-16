package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_stats_messageStats extends TLObject {
    public static int constructor = -1986399595;
    public TLRPC$StatsGraph views_graph;

    public static TLRPC$TL_stats_messageStats TLdeserialize(AbstractSerializedData stream, int constructor2, boolean exception) {
        if (constructor != constructor2) {
            if (exception) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_stats_messageStats", Integer.valueOf(constructor2)));
            }
            return null;
        }
        TLRPC$TL_stats_messageStats tLRPC$TL_stats_messageStats = new TLRPC$TL_stats_messageStats();
        tLRPC$TL_stats_messageStats.readParams(stream, exception);
        return tLRPC$TL_stats_messageStats;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.views_graph = TLRPC$StatsGraph.TLdeserialize(stream, stream.readInt32(exception), exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.views_graph.serializeToStream(stream);
    }
}
