package livekit;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Timestamp;
import ir.nasim.JE3;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes8.dex */
public final class LivekitMetrics$MetricSample extends GeneratedMessageLite implements JE3 {
    private static final LivekitMetrics$MetricSample DEFAULT_INSTANCE;
    public static final int NORMALIZED_TIMESTAMP_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int TIMESTAMP_MS_FIELD_NUMBER = 1;
    public static final int VALUE_FIELD_NUMBER = 3;
    private Timestamp normalizedTimestamp_;
    private long timestampMs_;
    private float value_;

    public static final class a extends GeneratedMessageLite.b implements JE3 {
        /* synthetic */ a(n nVar) {
            this();
        }

        public a A(long j) {
            q();
            ((LivekitMetrics$MetricSample) this.b).setTimestampMs(j);
            return this;
        }

        public a B(float f) {
            q();
            ((LivekitMetrics$MetricSample) this.b).setValue(f);
            return this;
        }

        private a() {
            super(LivekitMetrics$MetricSample.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitMetrics$MetricSample livekitMetrics$MetricSample = new LivekitMetrics$MetricSample();
        DEFAULT_INSTANCE = livekitMetrics$MetricSample;
        GeneratedMessageLite.registerDefaultInstance(LivekitMetrics$MetricSample.class, livekitMetrics$MetricSample);
    }

    private LivekitMetrics$MetricSample() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearNormalizedTimestamp() {
        this.normalizedTimestamp_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTimestampMs() {
        this.timestampMs_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearValue() {
        this.value_ = 0.0f;
    }

    public static LivekitMetrics$MetricSample getDefaultInstance() {
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

    public static LivekitMetrics$MetricSample parseDelimitedFrom(InputStream inputStream) {
        return (LivekitMetrics$MetricSample) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitMetrics$MetricSample parseFrom(ByteBuffer byteBuffer) {
        return (LivekitMetrics$MetricSample) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNormalizedTimestamp(Timestamp timestamp) {
        timestamp.getClass();
        this.normalizedTimestamp_ = timestamp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTimestampMs(long j) {
        this.timestampMs_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setValue(float f) {
        this.value_ = f;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        n nVar = null;
        switch (n.a[gVar.ordinal()]) {
            case 1:
                return new LivekitMetrics$MetricSample();
            case 2:
                return new a(nVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0002\u0002\t\u0003\u0001", new Object[]{"timestampMs_", "normalizedTimestamp_", "value_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitMetrics$MetricSample.class) {
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

    public Timestamp getNormalizedTimestamp() {
        Timestamp timestamp = this.normalizedTimestamp_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    public long getTimestampMs() {
        return this.timestampMs_;
    }

    public float getValue() {
        return this.value_;
    }

    public boolean hasNormalizedTimestamp() {
        return this.normalizedTimestamp_ != null;
    }

    public static a newBuilder(LivekitMetrics$MetricSample livekitMetrics$MetricSample) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitMetrics$MetricSample);
    }

    public static LivekitMetrics$MetricSample parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitMetrics$MetricSample) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitMetrics$MetricSample parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitMetrics$MetricSample) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitMetrics$MetricSample parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitMetrics$MetricSample) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitMetrics$MetricSample parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitMetrics$MetricSample) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitMetrics$MetricSample parseFrom(byte[] bArr) {
        return (LivekitMetrics$MetricSample) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitMetrics$MetricSample parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitMetrics$MetricSample) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitMetrics$MetricSample parseFrom(InputStream inputStream) {
        return (LivekitMetrics$MetricSample) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitMetrics$MetricSample parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitMetrics$MetricSample) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitMetrics$MetricSample parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitMetrics$MetricSample) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitMetrics$MetricSample parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitMetrics$MetricSample) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
