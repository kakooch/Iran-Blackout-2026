package livekit;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC10808cE3;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes8.dex */
public final class LivekitAnalytics$AnalyticsStats extends GeneratedMessageLite implements U64 {
    private static final LivekitAnalytics$AnalyticsStats DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int STATS_FIELD_NUMBER = 1;
    private B.j stats_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(c cVar) {
            this();
        }

        private a() {
            super(LivekitAnalytics$AnalyticsStats.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitAnalytics$AnalyticsStats livekitAnalytics$AnalyticsStats = new LivekitAnalytics$AnalyticsStats();
        DEFAULT_INSTANCE = livekitAnalytics$AnalyticsStats;
        GeneratedMessageLite.registerDefaultInstance(LivekitAnalytics$AnalyticsStats.class, livekitAnalytics$AnalyticsStats);
    }

    private LivekitAnalytics$AnalyticsStats() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllStats(Iterable<? extends LivekitAnalytics$AnalyticsStat> iterable) {
        ensureStatsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.stats_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addStats(LivekitAnalytics$AnalyticsStat livekitAnalytics$AnalyticsStat) {
        livekitAnalytics$AnalyticsStat.getClass();
        ensureStatsIsMutable();
        this.stats_.add(livekitAnalytics$AnalyticsStat);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearStats() {
        this.stats_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureStatsIsMutable() {
        B.j jVar = this.stats_;
        if (jVar.u()) {
            return;
        }
        this.stats_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static LivekitAnalytics$AnalyticsStats getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitAnalytics$AnalyticsStats parseDelimitedFrom(InputStream inputStream) {
        return (LivekitAnalytics$AnalyticsStats) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitAnalytics$AnalyticsStats parseFrom(ByteBuffer byteBuffer) {
        return (LivekitAnalytics$AnalyticsStats) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeStats(int i) {
        ensureStatsIsMutable();
        this.stats_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStats(int i, LivekitAnalytics$AnalyticsStat livekitAnalytics$AnalyticsStat) {
        livekitAnalytics$AnalyticsStat.getClass();
        ensureStatsIsMutable();
        this.stats_.set(i, livekitAnalytics$AnalyticsStat);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        c cVar = null;
        switch (c.a[gVar.ordinal()]) {
            case 1:
                return new LivekitAnalytics$AnalyticsStats();
            case 2:
                return new a(cVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"stats_", LivekitAnalytics$AnalyticsStat.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar2 = PARSER;
                if (cVar2 == null) {
                    synchronized (LivekitAnalytics$AnalyticsStats.class) {
                        try {
                            cVar2 = PARSER;
                            if (cVar2 == null) {
                                cVar2 = new GeneratedMessageLite.c(DEFAULT_INSTANCE);
                                PARSER = cVar2;
                            }
                        } finally {
                        }
                    }
                }
                return cVar2;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public LivekitAnalytics$AnalyticsStat getStats(int i) {
        return (LivekitAnalytics$AnalyticsStat) this.stats_.get(i);
    }

    public int getStatsCount() {
        return this.stats_.size();
    }

    public List<LivekitAnalytics$AnalyticsStat> getStatsList() {
        return this.stats_;
    }

    public InterfaceC10808cE3 getStatsOrBuilder(int i) {
        return (InterfaceC10808cE3) this.stats_.get(i);
    }

    public List<? extends InterfaceC10808cE3> getStatsOrBuilderList() {
        return this.stats_;
    }

    public static a newBuilder(LivekitAnalytics$AnalyticsStats livekitAnalytics$AnalyticsStats) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitAnalytics$AnalyticsStats);
    }

    public static LivekitAnalytics$AnalyticsStats parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitAnalytics$AnalyticsStats) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitAnalytics$AnalyticsStats parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitAnalytics$AnalyticsStats) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitAnalytics$AnalyticsStats parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitAnalytics$AnalyticsStats) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addStats(int i, LivekitAnalytics$AnalyticsStat livekitAnalytics$AnalyticsStat) {
        livekitAnalytics$AnalyticsStat.getClass();
        ensureStatsIsMutable();
        this.stats_.add(i, livekitAnalytics$AnalyticsStat);
    }

    public static LivekitAnalytics$AnalyticsStats parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitAnalytics$AnalyticsStats) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitAnalytics$AnalyticsStats parseFrom(byte[] bArr) {
        return (LivekitAnalytics$AnalyticsStats) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitAnalytics$AnalyticsStats parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitAnalytics$AnalyticsStats) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitAnalytics$AnalyticsStats parseFrom(InputStream inputStream) {
        return (LivekitAnalytics$AnalyticsStats) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitAnalytics$AnalyticsStats parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitAnalytics$AnalyticsStats) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitAnalytics$AnalyticsStats parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitAnalytics$AnalyticsStats) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitAnalytics$AnalyticsStats parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitAnalytics$AnalyticsStats) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
