package livekit;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.JE3;
import ir.nasim.KE3;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes8.dex */
public final class LivekitMetrics$TimeSeriesMetric extends GeneratedMessageLite implements KE3 {
    private static final LivekitMetrics$TimeSeriesMetric DEFAULT_INSTANCE;
    public static final int LABEL_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int PARTICIPANT_IDENTITY_FIELD_NUMBER = 2;
    public static final int RID_FIELD_NUMBER = 5;
    public static final int SAMPLES_FIELD_NUMBER = 4;
    public static final int TRACK_SID_FIELD_NUMBER = 3;
    private int label_;
    private int participantIdentity_;
    private int rid_;
    private B.j samples_ = GeneratedMessageLite.emptyProtobufList();
    private int trackSid_;

    public static final class a extends GeneratedMessageLite.b implements KE3 {
        /* synthetic */ a(n nVar) {
            this();
        }

        public a A(Iterable iterable) {
            q();
            ((LivekitMetrics$TimeSeriesMetric) this.b).addAllSamples(iterable);
            return this;
        }

        public a B(int i) {
            q();
            ((LivekitMetrics$TimeSeriesMetric) this.b).setLabel(i);
            return this;
        }

        public a C(int i) {
            q();
            ((LivekitMetrics$TimeSeriesMetric) this.b).setParticipantIdentity(i);
            return this;
        }

        public a D(int i) {
            q();
            ((LivekitMetrics$TimeSeriesMetric) this.b).setRid(i);
            return this;
        }

        public a E(int i) {
            q();
            ((LivekitMetrics$TimeSeriesMetric) this.b).setTrackSid(i);
            return this;
        }

        private a() {
            super(LivekitMetrics$TimeSeriesMetric.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitMetrics$TimeSeriesMetric livekitMetrics$TimeSeriesMetric = new LivekitMetrics$TimeSeriesMetric();
        DEFAULT_INSTANCE = livekitMetrics$TimeSeriesMetric;
        GeneratedMessageLite.registerDefaultInstance(LivekitMetrics$TimeSeriesMetric.class, livekitMetrics$TimeSeriesMetric);
    }

    private LivekitMetrics$TimeSeriesMetric() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllSamples(Iterable<? extends LivekitMetrics$MetricSample> iterable) {
        ensureSamplesIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.samples_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addSamples(LivekitMetrics$MetricSample livekitMetrics$MetricSample) {
        livekitMetrics$MetricSample.getClass();
        ensureSamplesIsMutable();
        this.samples_.add(livekitMetrics$MetricSample);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearLabel() {
        this.label_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearParticipantIdentity() {
        this.participantIdentity_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRid() {
        this.rid_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSamples() {
        this.samples_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTrackSid() {
        this.trackSid_ = 0;
    }

    private void ensureSamplesIsMutable() {
        B.j jVar = this.samples_;
        if (jVar.u()) {
            return;
        }
        this.samples_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static LivekitMetrics$TimeSeriesMetric getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitMetrics$TimeSeriesMetric parseDelimitedFrom(InputStream inputStream) {
        return (LivekitMetrics$TimeSeriesMetric) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitMetrics$TimeSeriesMetric parseFrom(ByteBuffer byteBuffer) {
        return (LivekitMetrics$TimeSeriesMetric) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeSamples(int i) {
        ensureSamplesIsMutable();
        this.samples_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLabel(int i) {
        this.label_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setParticipantIdentity(int i) {
        this.participantIdentity_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRid(int i) {
        this.rid_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSamples(int i, LivekitMetrics$MetricSample livekitMetrics$MetricSample) {
        livekitMetrics$MetricSample.getClass();
        ensureSamplesIsMutable();
        this.samples_.set(i, livekitMetrics$MetricSample);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTrackSid(int i) {
        this.trackSid_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        n nVar = null;
        switch (n.a[gVar.ordinal()]) {
            case 1:
                return new LivekitMetrics$TimeSeriesMetric();
            case 2:
                return new a(nVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0001\u0000\u0001\u000b\u0002\u000b\u0003\u000b\u0004\u001b\u0005\u000b", new Object[]{"label_", "participantIdentity_", "trackSid_", "samples_", LivekitMetrics$MetricSample.class, "rid_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitMetrics$TimeSeriesMetric.class) {
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

    public int getLabel() {
        return this.label_;
    }

    public int getParticipantIdentity() {
        return this.participantIdentity_;
    }

    public int getRid() {
        return this.rid_;
    }

    public LivekitMetrics$MetricSample getSamples(int i) {
        return (LivekitMetrics$MetricSample) this.samples_.get(i);
    }

    public int getSamplesCount() {
        return this.samples_.size();
    }

    public List<LivekitMetrics$MetricSample> getSamplesList() {
        return this.samples_;
    }

    public JE3 getSamplesOrBuilder(int i) {
        return (JE3) this.samples_.get(i);
    }

    public List<? extends JE3> getSamplesOrBuilderList() {
        return this.samples_;
    }

    public int getTrackSid() {
        return this.trackSid_;
    }

    public static a newBuilder(LivekitMetrics$TimeSeriesMetric livekitMetrics$TimeSeriesMetric) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitMetrics$TimeSeriesMetric);
    }

    public static LivekitMetrics$TimeSeriesMetric parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitMetrics$TimeSeriesMetric) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitMetrics$TimeSeriesMetric parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitMetrics$TimeSeriesMetric) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitMetrics$TimeSeriesMetric parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitMetrics$TimeSeriesMetric) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addSamples(int i, LivekitMetrics$MetricSample livekitMetrics$MetricSample) {
        livekitMetrics$MetricSample.getClass();
        ensureSamplesIsMutable();
        this.samples_.add(i, livekitMetrics$MetricSample);
    }

    public static LivekitMetrics$TimeSeriesMetric parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitMetrics$TimeSeriesMetric) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitMetrics$TimeSeriesMetric parseFrom(byte[] bArr) {
        return (LivekitMetrics$TimeSeriesMetric) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitMetrics$TimeSeriesMetric parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitMetrics$TimeSeriesMetric) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitMetrics$TimeSeriesMetric parseFrom(InputStream inputStream) {
        return (LivekitMetrics$TimeSeriesMetric) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitMetrics$TimeSeriesMetric parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitMetrics$TimeSeriesMetric) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitMetrics$TimeSeriesMetric parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitMetrics$TimeSeriesMetric) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitMetrics$TimeSeriesMetric parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitMetrics$TimeSeriesMetric) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
