package livekit;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Timestamp;
import ir.nasim.HE3;
import ir.nasim.KE3;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes8.dex */
public final class LivekitMetrics$MetricsBatch extends GeneratedMessageLite implements U64 {
    private static final LivekitMetrics$MetricsBatch DEFAULT_INSTANCE;
    public static final int EVENTS_FIELD_NUMBER = 5;
    public static final int NORMALIZED_TIMESTAMP_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int STR_DATA_FIELD_NUMBER = 3;
    public static final int TIMESTAMP_MS_FIELD_NUMBER = 1;
    public static final int TIME_SERIES_FIELD_NUMBER = 4;
    private Timestamp normalizedTimestamp_;
    private long timestampMs_;
    private B.j strData_ = GeneratedMessageLite.emptyProtobufList();
    private B.j timeSeries_ = GeneratedMessageLite.emptyProtobufList();
    private B.j events_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(n nVar) {
            this();
        }

        public a A(Iterable iterable) {
            q();
            ((LivekitMetrics$MetricsBatch) this.b).addAllStrData(iterable);
            return this;
        }

        public a B(Iterable iterable) {
            q();
            ((LivekitMetrics$MetricsBatch) this.b).addAllTimeSeries(iterable);
            return this;
        }

        public a C(long j) {
            q();
            ((LivekitMetrics$MetricsBatch) this.b).setTimestampMs(j);
            return this;
        }

        private a() {
            super(LivekitMetrics$MetricsBatch.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitMetrics$MetricsBatch livekitMetrics$MetricsBatch = new LivekitMetrics$MetricsBatch();
        DEFAULT_INSTANCE = livekitMetrics$MetricsBatch;
        GeneratedMessageLite.registerDefaultInstance(LivekitMetrics$MetricsBatch.class, livekitMetrics$MetricsBatch);
    }

    private LivekitMetrics$MetricsBatch() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllEvents(Iterable<? extends LivekitMetrics$EventMetric> iterable) {
        ensureEventsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.events_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllStrData(Iterable<String> iterable) {
        ensureStrDataIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.strData_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllTimeSeries(Iterable<? extends LivekitMetrics$TimeSeriesMetric> iterable) {
        ensureTimeSeriesIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.timeSeries_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addEvents(LivekitMetrics$EventMetric livekitMetrics$EventMetric) {
        livekitMetrics$EventMetric.getClass();
        ensureEventsIsMutable();
        this.events_.add(livekitMetrics$EventMetric);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addStrData(String str) {
        str.getClass();
        ensureStrDataIsMutable();
        this.strData_.add(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addStrDataBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        ensureStrDataIsMutable();
        this.strData_.add(abstractC2383g.f0());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addTimeSeries(LivekitMetrics$TimeSeriesMetric livekitMetrics$TimeSeriesMetric) {
        livekitMetrics$TimeSeriesMetric.getClass();
        ensureTimeSeriesIsMutable();
        this.timeSeries_.add(livekitMetrics$TimeSeriesMetric);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearEvents() {
        this.events_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearNormalizedTimestamp() {
        this.normalizedTimestamp_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearStrData() {
        this.strData_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTimeSeries() {
        this.timeSeries_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTimestampMs() {
        this.timestampMs_ = 0L;
    }

    private void ensureEventsIsMutable() {
        B.j jVar = this.events_;
        if (jVar.u()) {
            return;
        }
        this.events_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    private void ensureStrDataIsMutable() {
        B.j jVar = this.strData_;
        if (jVar.u()) {
            return;
        }
        this.strData_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    private void ensureTimeSeriesIsMutable() {
        B.j jVar = this.timeSeries_;
        if (jVar.u()) {
            return;
        }
        this.timeSeries_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static LivekitMetrics$MetricsBatch getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeNormalizedTimestamp(Timestamp timestamp) {
        timestamp.getClass();
        Timestamp timestamp2 = this.normalizedTimestamp_;
        if (timestamp2 == null || timestamp2 == Timestamp.getDefaultInstance()) {
            this.normalizedTimestamp_ = timestamp;
        } else {
            this.normalizedTimestamp_ = (Timestamp) ((Timestamp.b) Timestamp.newBuilder(this.normalizedTimestamp_).v(timestamp)).j();
        }
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitMetrics$MetricsBatch parseDelimitedFrom(InputStream inputStream) {
        return (LivekitMetrics$MetricsBatch) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitMetrics$MetricsBatch parseFrom(ByteBuffer byteBuffer) {
        return (LivekitMetrics$MetricsBatch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeEvents(int i) {
        ensureEventsIsMutable();
        this.events_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeTimeSeries(int i) {
        ensureTimeSeriesIsMutable();
        this.timeSeries_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEvents(int i, LivekitMetrics$EventMetric livekitMetrics$EventMetric) {
        livekitMetrics$EventMetric.getClass();
        ensureEventsIsMutable();
        this.events_.set(i, livekitMetrics$EventMetric);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNormalizedTimestamp(Timestamp timestamp) {
        timestamp.getClass();
        this.normalizedTimestamp_ = timestamp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStrData(int i, String str) {
        str.getClass();
        ensureStrDataIsMutable();
        this.strData_.set(i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTimeSeries(int i, LivekitMetrics$TimeSeriesMetric livekitMetrics$TimeSeriesMetric) {
        livekitMetrics$TimeSeriesMetric.getClass();
        ensureTimeSeriesIsMutable();
        this.timeSeries_.set(i, livekitMetrics$TimeSeriesMetric);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTimestampMs(long j) {
        this.timestampMs_ = j;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        n nVar = null;
        switch (n.a[gVar.ordinal()]) {
            case 1:
                return new LivekitMetrics$MetricsBatch();
            case 2:
                return new a(nVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0003\u0000\u0001\u0002\u0002\t\u0003Ț\u0004\u001b\u0005\u001b", new Object[]{"timestampMs_", "normalizedTimestamp_", "strData_", "timeSeries_", LivekitMetrics$TimeSeriesMetric.class, "events_", LivekitMetrics$EventMetric.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitMetrics$MetricsBatch.class) {
                        try {
                            cVar = PARSER;
                            if (cVar == null) {
                                cVar = new GeneratedMessageLite.c(DEFAULT_INSTANCE);
                                PARSER = cVar;
                            }
                        } finally {
                        }
                    }
                }
                return cVar;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public LivekitMetrics$EventMetric getEvents(int i) {
        return (LivekitMetrics$EventMetric) this.events_.get(i);
    }

    public int getEventsCount() {
        return this.events_.size();
    }

    public List<LivekitMetrics$EventMetric> getEventsList() {
        return this.events_;
    }

    public HE3 getEventsOrBuilder(int i) {
        return (HE3) this.events_.get(i);
    }

    public List<? extends HE3> getEventsOrBuilderList() {
        return this.events_;
    }

    public Timestamp getNormalizedTimestamp() {
        Timestamp timestamp = this.normalizedTimestamp_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    public String getStrData(int i) {
        return (String) this.strData_.get(i);
    }

    public AbstractC2383g getStrDataBytes(int i) {
        return AbstractC2383g.N((String) this.strData_.get(i));
    }

    public int getStrDataCount() {
        return this.strData_.size();
    }

    public List<String> getStrDataList() {
        return this.strData_;
    }

    public LivekitMetrics$TimeSeriesMetric getTimeSeries(int i) {
        return (LivekitMetrics$TimeSeriesMetric) this.timeSeries_.get(i);
    }

    public int getTimeSeriesCount() {
        return this.timeSeries_.size();
    }

    public List<LivekitMetrics$TimeSeriesMetric> getTimeSeriesList() {
        return this.timeSeries_;
    }

    public KE3 getTimeSeriesOrBuilder(int i) {
        return (KE3) this.timeSeries_.get(i);
    }

    public List<? extends KE3> getTimeSeriesOrBuilderList() {
        return this.timeSeries_;
    }

    public long getTimestampMs() {
        return this.timestampMs_;
    }

    public boolean hasNormalizedTimestamp() {
        return this.normalizedTimestamp_ != null;
    }

    public static a newBuilder(LivekitMetrics$MetricsBatch livekitMetrics$MetricsBatch) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitMetrics$MetricsBatch);
    }

    public static LivekitMetrics$MetricsBatch parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitMetrics$MetricsBatch) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitMetrics$MetricsBatch parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitMetrics$MetricsBatch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitMetrics$MetricsBatch parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitMetrics$MetricsBatch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addEvents(int i, LivekitMetrics$EventMetric livekitMetrics$EventMetric) {
        livekitMetrics$EventMetric.getClass();
        ensureEventsIsMutable();
        this.events_.add(i, livekitMetrics$EventMetric);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addTimeSeries(int i, LivekitMetrics$TimeSeriesMetric livekitMetrics$TimeSeriesMetric) {
        livekitMetrics$TimeSeriesMetric.getClass();
        ensureTimeSeriesIsMutable();
        this.timeSeries_.add(i, livekitMetrics$TimeSeriesMetric);
    }

    public static LivekitMetrics$MetricsBatch parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitMetrics$MetricsBatch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitMetrics$MetricsBatch parseFrom(byte[] bArr) {
        return (LivekitMetrics$MetricsBatch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitMetrics$MetricsBatch parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitMetrics$MetricsBatch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitMetrics$MetricsBatch parseFrom(InputStream inputStream) {
        return (LivekitMetrics$MetricsBatch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitMetrics$MetricsBatch parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitMetrics$MetricsBatch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitMetrics$MetricsBatch parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitMetrics$MetricsBatch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitMetrics$MetricsBatch parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitMetrics$MetricsBatch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
