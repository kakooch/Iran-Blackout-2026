package ir.aaap.messengercore.model.api;

import ir.aaap.messengercore.model.StatsGraph;

/* loaded from: classes3.dex */
public class GetAllStatisticsOutput {
    public StatsPercentValue enabled_notifications;
    public StatsAbsValueAndPrev followers;
    public StatsGraph followers_graph;
    public StatsGraph growth_graph;
    public StatsGraph interactions_graph;
    public StatsGraph mute_graph;
    public StatsDateRangeDays period;
    public StatsAbsValueAndPrev shares_per_post;
    public StatsGraph views_graph;
    public StatsAbsValueAndPrev views_per_post;

    public static class StatsAbsValueAndPrev {
        public double current;
        public double previous;
    }

    public static class StatsDateRangeDays {
        public int max_date;
        public int min_date;
    }

    public static class StatsPercentValue {
        public double part;
        public double total;
    }
}
