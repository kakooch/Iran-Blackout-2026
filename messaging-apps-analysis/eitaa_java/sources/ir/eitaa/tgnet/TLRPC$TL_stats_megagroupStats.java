package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class TLRPC$TL_stats_megagroupStats extends TLObject {
    public static int constructor = -276825834;
    public TLRPC$StatsGraph actions_graph;
    public TLRPC$StatsGraph growth_graph;
    public TLRPC$StatsGraph languages_graph;
    public TLRPC$TL_statsAbsValueAndPrev members;
    public TLRPC$StatsGraph members_graph;
    public TLRPC$TL_statsAbsValueAndPrev messages;
    public TLRPC$StatsGraph messages_graph;
    public TLRPC$StatsGraph new_members_by_source_graph;
    public TLRPC$TL_statsDateRangeDays period;
    public TLRPC$TL_statsAbsValueAndPrev posters;
    public TLRPC$StatsGraph top_hours_graph;
    public TLRPC$TL_statsAbsValueAndPrev viewers;
    public TLRPC$StatsGraph weekdays_graph;
    public ArrayList<TLRPC$TL_statsGroupTopPoster> top_posters = new ArrayList<>();
    public ArrayList<TLRPC$TL_statsGroupTopAdmin> top_admins = new ArrayList<>();
    public ArrayList<TLRPC$TL_statsGroupTopInviter> top_inviters = new ArrayList<>();
    public ArrayList<TLRPC$User> users = new ArrayList<>();

    public static TLRPC$TL_stats_megagroupStats TLdeserialize(AbstractSerializedData stream, int constructor2, boolean exception) {
        if (constructor != constructor2) {
            if (exception) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_stats_megagroupStats", Integer.valueOf(constructor2)));
            }
            return null;
        }
        TLRPC$TL_stats_megagroupStats tLRPC$TL_stats_megagroupStats = new TLRPC$TL_stats_megagroupStats();
        tLRPC$TL_stats_megagroupStats.readParams(stream, exception);
        return tLRPC$TL_stats_megagroupStats;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.period = TLRPC$TL_statsDateRangeDays.TLdeserialize(stream, stream.readInt32(exception), exception);
        this.members = TLRPC$TL_statsAbsValueAndPrev.TLdeserialize(stream, stream.readInt32(exception), exception);
        this.messages = TLRPC$TL_statsAbsValueAndPrev.TLdeserialize(stream, stream.readInt32(exception), exception);
        this.viewers = TLRPC$TL_statsAbsValueAndPrev.TLdeserialize(stream, stream.readInt32(exception), exception);
        this.posters = TLRPC$TL_statsAbsValueAndPrev.TLdeserialize(stream, stream.readInt32(exception), exception);
        this.growth_graph = TLRPC$StatsGraph.TLdeserialize(stream, stream.readInt32(exception), exception);
        this.members_graph = TLRPC$StatsGraph.TLdeserialize(stream, stream.readInt32(exception), exception);
        this.new_members_by_source_graph = TLRPC$StatsGraph.TLdeserialize(stream, stream.readInt32(exception), exception);
        this.languages_graph = TLRPC$StatsGraph.TLdeserialize(stream, stream.readInt32(exception), exception);
        this.messages_graph = TLRPC$StatsGraph.TLdeserialize(stream, stream.readInt32(exception), exception);
        this.actions_graph = TLRPC$StatsGraph.TLdeserialize(stream, stream.readInt32(exception), exception);
        this.top_hours_graph = TLRPC$StatsGraph.TLdeserialize(stream, stream.readInt32(exception), exception);
        this.weekdays_graph = TLRPC$StatsGraph.TLdeserialize(stream, stream.readInt32(exception), exception);
        int int32 = stream.readInt32(exception);
        if (int32 != 481674261) {
            if (exception) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
            }
            return;
        }
        int int322 = stream.readInt32(exception);
        for (int i = 0; i < int322; i++) {
            TLRPC$TL_statsGroupTopPoster tLRPC$TL_statsGroupTopPosterTLdeserialize = TLRPC$TL_statsGroupTopPoster.TLdeserialize(stream, stream.readInt32(exception), exception);
            if (tLRPC$TL_statsGroupTopPosterTLdeserialize == null) {
                return;
            }
            this.top_posters.add(tLRPC$TL_statsGroupTopPosterTLdeserialize);
        }
        int int323 = stream.readInt32(exception);
        if (int323 != 481674261) {
            if (exception) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int323)));
            }
            return;
        }
        int int324 = stream.readInt32(exception);
        for (int i2 = 0; i2 < int324; i2++) {
            TLRPC$TL_statsGroupTopAdmin tLRPC$TL_statsGroupTopAdminTLdeserialize = TLRPC$TL_statsGroupTopAdmin.TLdeserialize(stream, stream.readInt32(exception), exception);
            if (tLRPC$TL_statsGroupTopAdminTLdeserialize == null) {
                return;
            }
            this.top_admins.add(tLRPC$TL_statsGroupTopAdminTLdeserialize);
        }
        int int325 = stream.readInt32(exception);
        if (int325 != 481674261) {
            if (exception) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int325)));
            }
            return;
        }
        int int326 = stream.readInt32(exception);
        for (int i3 = 0; i3 < int326; i3++) {
            TLRPC$TL_statsGroupTopInviter tLRPC$TL_statsGroupTopInviterTLdeserialize = TLRPC$TL_statsGroupTopInviter.TLdeserialize(stream, stream.readInt32(exception), exception);
            if (tLRPC$TL_statsGroupTopInviterTLdeserialize == null) {
                return;
            }
            this.top_inviters.add(tLRPC$TL_statsGroupTopInviterTLdeserialize);
        }
        int int327 = stream.readInt32(exception);
        if (int327 != 481674261) {
            if (exception) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int327)));
            }
            return;
        }
        int int328 = stream.readInt32(exception);
        for (int i4 = 0; i4 < int328; i4++) {
            TLRPC$User tLRPC$UserTLdeserialize = TLRPC$User.TLdeserialize(stream, stream.readInt32(exception), exception);
            if (tLRPC$UserTLdeserialize == null) {
                return;
            }
            this.users.add(tLRPC$UserTLdeserialize);
        }
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.period.serializeToStream(stream);
        this.members.serializeToStream(stream);
        this.messages.serializeToStream(stream);
        this.viewers.serializeToStream(stream);
        this.posters.serializeToStream(stream);
        this.growth_graph.serializeToStream(stream);
        this.members_graph.serializeToStream(stream);
        this.new_members_by_source_graph.serializeToStream(stream);
        this.languages_graph.serializeToStream(stream);
        this.messages_graph.serializeToStream(stream);
        this.actions_graph.serializeToStream(stream);
        this.top_hours_graph.serializeToStream(stream);
        this.weekdays_graph.serializeToStream(stream);
        stream.writeInt32(481674261);
        int size = this.top_posters.size();
        stream.writeInt32(size);
        for (int i = 0; i < size; i++) {
            this.top_posters.get(i).serializeToStream(stream);
        }
        stream.writeInt32(481674261);
        int size2 = this.top_admins.size();
        stream.writeInt32(size2);
        for (int i2 = 0; i2 < size2; i2++) {
            this.top_admins.get(i2).serializeToStream(stream);
        }
        stream.writeInt32(481674261);
        int size3 = this.top_inviters.size();
        stream.writeInt32(size3);
        for (int i3 = 0; i3 < size3; i3++) {
            this.top_inviters.get(i3).serializeToStream(stream);
        }
        stream.writeInt32(481674261);
        int size4 = this.users.size();
        stream.writeInt32(size4);
        for (int i4 = 0; i4 < size4; i4++) {
            this.users.get(i4).serializeToStream(stream);
        }
    }
}
