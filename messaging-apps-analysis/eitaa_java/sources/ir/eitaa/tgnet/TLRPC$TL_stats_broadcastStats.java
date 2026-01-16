package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class TLRPC$TL_stats_broadcastStats extends TLObject {
    public static int constructor = -1107852396;
    public TLRPC$TL_statsPercentValue enabled_notifications;
    public TLRPC$TL_statsAbsValueAndPrev followers;
    public TLRPC$StatsGraph followers_graph;
    public TLRPC$StatsGraph growth_graph;
    public TLRPC$StatsGraph interactions_graph;
    public TLRPC$StatsGraph iv_interactions_graph;
    public TLRPC$StatsGraph languages_graph;
    public TLRPC$StatsGraph mute_graph;
    public TLRPC$StatsGraph new_followers_by_source_graph;
    public TLRPC$TL_statsDateRangeDays period;
    public ArrayList<TLRPC$TL_messageInteractionCounters> recent_message_interactions = new ArrayList<>();
    public TLRPC$TL_statsAbsValueAndPrev shares_per_post;
    public TLRPC$StatsGraph top_hours_graph;
    public TLRPC$StatsGraph views_by_source_graph;
    public TLRPC$TL_statsAbsValueAndPrev views_per_post;

    public static TLRPC$TL_stats_broadcastStats TLdeserialize(AbstractSerializedData stream, int constructor2, boolean exception) {
        if (constructor != constructor2) {
            if (exception) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_stats_broadcastStats", Integer.valueOf(constructor2)));
            }
            return null;
        }
        TLRPC$TL_stats_broadcastStats tLRPC$TL_stats_broadcastStats = new TLRPC$TL_stats_broadcastStats();
        tLRPC$TL_stats_broadcastStats.readParams(stream, exception);
        return tLRPC$TL_stats_broadcastStats;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.period = TLRPC$TL_statsDateRangeDays.TLdeserialize(stream, stream.readInt32(exception), exception);
        this.followers = TLRPC$TL_statsAbsValueAndPrev.TLdeserialize(stream, stream.readInt32(exception), exception);
        this.views_per_post = TLRPC$TL_statsAbsValueAndPrev.TLdeserialize(stream, stream.readInt32(exception), exception);
        this.shares_per_post = TLRPC$TL_statsAbsValueAndPrev.TLdeserialize(stream, stream.readInt32(exception), exception);
        this.enabled_notifications = TLRPC$TL_statsPercentValue.TLdeserialize(stream, stream.readInt32(exception), exception);
        this.growth_graph = TLRPC$StatsGraph.TLdeserialize(stream, stream.readInt32(exception), exception);
        this.followers_graph = TLRPC$StatsGraph.TLdeserialize(stream, stream.readInt32(exception), exception);
        this.mute_graph = TLRPC$StatsGraph.TLdeserialize(stream, stream.readInt32(exception), exception);
        this.top_hours_graph = TLRPC$StatsGraph.TLdeserialize(stream, stream.readInt32(exception), exception);
        this.interactions_graph = TLRPC$StatsGraph.TLdeserialize(stream, stream.readInt32(exception), exception);
        this.iv_interactions_graph = TLRPC$StatsGraph.TLdeserialize(stream, stream.readInt32(exception), exception);
        this.views_by_source_graph = TLRPC$StatsGraph.TLdeserialize(stream, stream.readInt32(exception), exception);
        this.new_followers_by_source_graph = TLRPC$StatsGraph.TLdeserialize(stream, stream.readInt32(exception), exception);
        this.languages_graph = TLRPC$StatsGraph.TLdeserialize(stream, stream.readInt32(exception), exception);
        int int32 = stream.readInt32(exception);
        if (int32 != 481674261) {
            if (exception) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
            }
            return;
        }
        int int322 = stream.readInt32(exception);
        for (int i = 0; i < int322; i++) {
            TLRPC$TL_messageInteractionCounters tLRPC$TL_messageInteractionCountersTLdeserialize = TLRPC$TL_messageInteractionCounters.TLdeserialize(stream, stream.readInt32(exception), exception);
            if (tLRPC$TL_messageInteractionCountersTLdeserialize == null) {
                return;
            }
            this.recent_message_interactions.add(tLRPC$TL_messageInteractionCountersTLdeserialize);
        }
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.period.serializeToStream(stream);
        this.followers.serializeToStream(stream);
        this.views_per_post.serializeToStream(stream);
        this.shares_per_post.serializeToStream(stream);
        this.enabled_notifications.serializeToStream(stream);
        this.growth_graph.serializeToStream(stream);
        this.followers_graph.serializeToStream(stream);
        this.mute_graph.serializeToStream(stream);
        this.top_hours_graph.serializeToStream(stream);
        this.interactions_graph.serializeToStream(stream);
        this.iv_interactions_graph.serializeToStream(stream);
        this.views_by_source_graph.serializeToStream(stream);
        this.new_followers_by_source_graph.serializeToStream(stream);
        this.languages_graph.serializeToStream(stream);
        stream.writeInt32(481674261);
        int size = this.recent_message_interactions.size();
        stream.writeInt32(size);
        for (int i = 0; i < size; i++) {
            this.recent_message_interactions.get(i).serializeToStream(stream);
        }
    }
}
