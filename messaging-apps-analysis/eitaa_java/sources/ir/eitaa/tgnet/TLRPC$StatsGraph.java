package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public abstract class TLRPC$StatsGraph extends TLObject {
    public static TLRPC$StatsGraph TLdeserialize(AbstractSerializedData stream, int constructor, boolean exception) {
        TLRPC$StatsGraph tLRPC$TL_statsGraph;
        if (constructor == -1901828938) {
            tLRPC$TL_statsGraph = new TLRPC$TL_statsGraph();
        } else if (constructor != -1092839390) {
            tLRPC$TL_statsGraph = constructor != 1244130093 ? null : new TLRPC$TL_statsGraphAsync();
        } else {
            tLRPC$TL_statsGraph = new TLRPC$TL_statsGraphError();
        }
        if (tLRPC$TL_statsGraph == null && exception) {
            throw new RuntimeException(String.format("can't parse magic %x in StatsGraph", Integer.valueOf(constructor)));
        }
        if (tLRPC$TL_statsGraph != null) {
            tLRPC$TL_statsGraph.readParams(stream, exception);
        }
        return tLRPC$TL_statsGraph;
    }
}
