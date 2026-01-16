package livekit;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Timestamp;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes8.dex */
public final class LivekitModels$RTPDrift extends GeneratedMessageLite implements U64 {
    public static final int CLOCK_RATE_FIELD_NUMBER = 9;
    private static final LivekitModels$RTPDrift DEFAULT_INSTANCE;
    public static final int DRIFT_MS_FIELD_NUMBER = 8;
    public static final int DRIFT_SAMPLES_FIELD_NUMBER = 7;
    public static final int DURATION_FIELD_NUMBER = 3;
    public static final int END_TIMESTAMP_FIELD_NUMBER = 5;
    public static final int END_TIME_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int RTP_CLOCK_TICKS_FIELD_NUMBER = 6;
    public static final int START_TIMESTAMP_FIELD_NUMBER = 4;
    public static final int START_TIME_FIELD_NUMBER = 1;
    private double clockRate_;
    private double driftMs_;
    private long driftSamples_;
    private double duration_;
    private Timestamp endTime_;
    private long endTimestamp_;
    private long rtpClockTicks_;
    private Timestamp startTime_;
    private long startTimestamp_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(o oVar) {
            this();
        }

        private a() {
            super(LivekitModels$RTPDrift.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitModels$RTPDrift livekitModels$RTPDrift = new LivekitModels$RTPDrift();
        DEFAULT_INSTANCE = livekitModels$RTPDrift;
        GeneratedMessageLite.registerDefaultInstance(LivekitModels$RTPDrift.class, livekitModels$RTPDrift);
    }

    private LivekitModels$RTPDrift() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearClockRate() {
        this.clockRate_ = 0.0d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDriftMs() {
        this.driftMs_ = 0.0d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDriftSamples() {
        this.driftSamples_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDuration() {
        this.duration_ = 0.0d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearEndTime() {
        this.endTime_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearEndTimestamp() {
        this.endTimestamp_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRtpClockTicks() {
        this.rtpClockTicks_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearStartTime() {
        this.startTime_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearStartTimestamp() {
        this.startTimestamp_ = 0L;
    }

    public static LivekitModels$RTPDrift getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeEndTime(Timestamp timestamp) {
        timestamp.getClass();
        Timestamp timestamp2 = this.endTime_;
        if (timestamp2 == null || timestamp2 == Timestamp.getDefaultInstance()) {
            this.endTime_ = timestamp;
        } else {
            this.endTime_ = (Timestamp) ((Timestamp.b) Timestamp.newBuilder(this.endTime_).v(timestamp)).j();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeStartTime(Timestamp timestamp) {
        timestamp.getClass();
        Timestamp timestamp2 = this.startTime_;
        if (timestamp2 == null || timestamp2 == Timestamp.getDefaultInstance()) {
            this.startTime_ = timestamp;
        } else {
            this.startTime_ = (Timestamp) ((Timestamp.b) Timestamp.newBuilder(this.startTime_).v(timestamp)).j();
        }
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitModels$RTPDrift parseDelimitedFrom(InputStream inputStream) {
        return (LivekitModels$RTPDrift) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitModels$RTPDrift parseFrom(ByteBuffer byteBuffer) {
        return (LivekitModels$RTPDrift) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setClockRate(double d) {
        this.clockRate_ = d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDriftMs(double d) {
        this.driftMs_ = d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDriftSamples(long j) {
        this.driftSamples_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDuration(double d) {
        this.duration_ = d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEndTime(Timestamp timestamp) {
        timestamp.getClass();
        this.endTime_ = timestamp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEndTimestamp(long j) {
        this.endTimestamp_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRtpClockTicks(long j) {
        this.rtpClockTicks_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStartTime(Timestamp timestamp) {
        timestamp.getClass();
        this.startTime_ = timestamp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStartTimestamp(long j) {
        this.startTimestamp_ = j;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        o oVar = null;
        switch (o.a[gVar.ordinal()]) {
            case 1:
                return new LivekitModels$RTPDrift();
            case 2:
                return new a(oVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\t\u0000\u0000\u0001\t\t\u0000\u0000\u0000\u0001\t\u0002\t\u0003\u0000\u0004\u0003\u0005\u0003\u0006\u0003\u0007\u0002\b\u0000\t\u0000", new Object[]{"startTime_", "endTime_", "duration_", "startTimestamp_", "endTimestamp_", "rtpClockTicks_", "driftSamples_", "driftMs_", "clockRate_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitModels$RTPDrift.class) {
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

    public double getClockRate() {
        return this.clockRate_;
    }

    public double getDriftMs() {
        return this.driftMs_;
    }

    public long getDriftSamples() {
        return this.driftSamples_;
    }

    public double getDuration() {
        return this.duration_;
    }

    public Timestamp getEndTime() {
        Timestamp timestamp = this.endTime_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    public long getEndTimestamp() {
        return this.endTimestamp_;
    }

    public long getRtpClockTicks() {
        return this.rtpClockTicks_;
    }

    public Timestamp getStartTime() {
        Timestamp timestamp = this.startTime_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    public long getStartTimestamp() {
        return this.startTimestamp_;
    }

    public boolean hasEndTime() {
        return this.endTime_ != null;
    }

    public boolean hasStartTime() {
        return this.startTime_ != null;
    }

    public static a newBuilder(LivekitModels$RTPDrift livekitModels$RTPDrift) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitModels$RTPDrift);
    }

    public static LivekitModels$RTPDrift parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitModels$RTPDrift) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitModels$RTPDrift parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitModels$RTPDrift) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitModels$RTPDrift parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitModels$RTPDrift) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitModels$RTPDrift parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitModels$RTPDrift) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitModels$RTPDrift parseFrom(byte[] bArr) {
        return (LivekitModels$RTPDrift) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitModels$RTPDrift parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitModels$RTPDrift) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitModels$RTPDrift parseFrom(InputStream inputStream) {
        return (LivekitModels$RTPDrift) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitModels$RTPDrift parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitModels$RTPDrift) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitModels$RTPDrift parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitModels$RTPDrift) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitModels$RTPDrift parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitModels$RTPDrift) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
