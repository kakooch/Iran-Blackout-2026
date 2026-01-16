package org.rbmain.tgnet;

import java.util.ArrayList;

/* loaded from: classes4.dex */
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

    public static TLRPC$TL_stats_megagroupStats TLdeserialize(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        if (constructor != i) {
            if (z) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_stats_megagroupStats", Integer.valueOf(i)));
            }
            return null;
        }
        TLRPC$TL_stats_megagroupStats tLRPC$TL_stats_megagroupStats = new TLRPC$TL_stats_megagroupStats();
        tLRPC$TL_stats_megagroupStats.readParams(abstractSerializedData, z);
        return tLRPC$TL_stats_megagroupStats;
    }

    @Override // org.rbmain.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.period = TLRPC$TL_statsDateRangeDays.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
        this.members = TLRPC$TL_statsAbsValueAndPrev.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
        this.messages = TLRPC$TL_statsAbsValueAndPrev.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
        this.viewers = TLRPC$TL_statsAbsValueAndPrev.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
        this.posters = TLRPC$TL_statsAbsValueAndPrev.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
        this.growth_graph = TLRPC$StatsGraph.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
        this.members_graph = TLRPC$StatsGraph.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
        this.new_members_by_source_graph = TLRPC$StatsGraph.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
        this.languages_graph = TLRPC$StatsGraph.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
        this.messages_graph = TLRPC$StatsGraph.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
        this.actions_graph = TLRPC$StatsGraph.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
        this.top_hours_graph = TLRPC$StatsGraph.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
        this.weekdays_graph = TLRPC$StatsGraph.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
        int int32 = abstractSerializedData.readInt32(z);
        if (int32 != 481674261) {
            if (z) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
            }
            return;
        }
        int int322 = abstractSerializedData.readInt32(z);
        for (int i = 0; i < int322; i++) {
            TLRPC$TL_statsGroupTopPoster tLRPC$TL_statsGroupTopPosterTLdeserialize = TLRPC$TL_statsGroupTopPoster.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
            if (tLRPC$TL_statsGroupTopPosterTLdeserialize == null) {
                return;
            }
            this.top_posters.add(tLRPC$TL_statsGroupTopPosterTLdeserialize);
        }
        int int323 = abstractSerializedData.readInt32(z);
        if (int323 != 481674261) {
            if (z) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int323)));
            }
            return;
        }
        int int324 = abstractSerializedData.readInt32(z);
        for (int i2 = 0; i2 < int324; i2++) {
            TLRPC$TL_statsGroupTopAdmin tLRPC$TL_statsGroupTopAdminTLdeserialize = TLRPC$TL_statsGroupTopAdmin.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
            if (tLRPC$TL_statsGroupTopAdminTLdeserialize == null) {
                return;
            }
            this.top_admins.add(tLRPC$TL_statsGroupTopAdminTLdeserialize);
        }
        int int325 = abstractSerializedData.readInt32(z);
        if (int325 != 481674261) {
            if (z) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int325)));
            }
            return;
        }
        int int326 = abstractSerializedData.readInt32(z);
        for (int i3 = 0; i3 < int326; i3++) {
            TLRPC$TL_statsGroupTopInviter tLRPC$TL_statsGroupTopInviterTLdeserialize = TLRPC$TL_statsGroupTopInviter.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
            if (tLRPC$TL_statsGroupTopInviterTLdeserialize == null) {
                return;
            }
            this.top_inviters.add(tLRPC$TL_statsGroupTopInviterTLdeserialize);
        }
        int int327 = abstractSerializedData.readInt32(z);
        if (int327 != 481674261) {
            if (z) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int327)));
            }
            return;
        }
        int int328 = abstractSerializedData.readInt32(z);
        for (int i4 = 0; i4 < int328; i4++) {
            TLRPC$User tLRPC$UserTLdeserialize = TLRPC$User.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
            if (tLRPC$UserTLdeserialize == null) {
                return;
            }
            this.users.add(tLRPC$UserTLdeserialize);
        }
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        this.period.serializeToStream(abstractSerializedData);
        this.members.serializeToStream(abstractSerializedData);
        this.messages.serializeToStream(abstractSerializedData);
        this.viewers.serializeToStream(abstractSerializedData);
        this.posters.serializeToStream(abstractSerializedData);
        this.growth_graph.serializeToStream(abstractSerializedData);
        this.members_graph.serializeToStream(abstractSerializedData);
        this.new_members_by_source_graph.serializeToStream(abstractSerializedData);
        this.languages_graph.serializeToStream(abstractSerializedData);
        this.messages_graph.serializeToStream(abstractSerializedData);
        this.actions_graph.serializeToStream(abstractSerializedData);
        this.top_hours_graph.serializeToStream(abstractSerializedData);
        this.weekdays_graph.serializeToStream(abstractSerializedData);
        abstractSerializedData.writeInt32(481674261);
        int size = this.top_posters.size();
        abstractSerializedData.writeInt32(size);
        for (int i = 0; i < size; i++) {
            this.top_posters.get(i).serializeToStream(abstractSerializedData);
        }
        abstractSerializedData.writeInt32(481674261);
        int size2 = this.top_admins.size();
        abstractSerializedData.writeInt32(size2);
        for (int i2 = 0; i2 < size2; i2++) {
            this.top_admins.get(i2).serializeToStream(abstractSerializedData);
        }
        abstractSerializedData.writeInt32(481674261);
        int size3 = this.top_inviters.size();
        abstractSerializedData.writeInt32(size3);
        for (int i3 = 0; i3 < size3; i3++) {
            this.top_inviters.get(i3).serializeToStream(abstractSerializedData);
        }
        abstractSerializedData.writeInt32(481674261);
        int size4 = this.users.size();
        abstractSerializedData.writeInt32(size4);
        for (int i4 = 0; i4 < size4; i4++) {
            this.users.get(i4).serializeToStream(abstractSerializedData);
        }
    }
}
