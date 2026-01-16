package livekit;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Timestamp;
import ir.nasim.HE3;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes8.dex */
public final class LivekitMetrics$EventMetric extends GeneratedMessageLite implements HE3 {
    private static final LivekitMetrics$EventMetric DEFAULT_INSTANCE;
    public static final int END_TIMESTAMP_MS_FIELD_NUMBER = 5;
    public static final int LABEL_FIELD_NUMBER = 1;
    public static final int METADATA_FIELD_NUMBER = 8;
    public static final int NORMALIZED_END_TIMESTAMP_FIELD_NUMBER = 7;
    public static final int NORMALIZED_START_TIMESTAMP_FIELD_NUMBER = 6;
    private static volatile KW4 PARSER = null;
    public static final int PARTICIPANT_IDENTITY_FIELD_NUMBER = 2;
    public static final int RID_FIELD_NUMBER = 9;
    public static final int START_TIMESTAMP_MS_FIELD_NUMBER = 4;
    public static final int TRACK_SID_FIELD_NUMBER = 3;
    private int bitField0_;
    private long endTimestampMs_;
    private int label_;
    private String metadata_ = "";
    private Timestamp normalizedEndTimestamp_;
    private Timestamp normalizedStartTimestamp_;
    private int participantIdentity_;
    private int rid_;
    private long startTimestampMs_;
    private int trackSid_;

    public static final class a extends GeneratedMessageLite.b implements HE3 {
        /* synthetic */ a(n nVar) {
            this();
        }

        private a() {
            super(LivekitMetrics$EventMetric.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitMetrics$EventMetric livekitMetrics$EventMetric = new LivekitMetrics$EventMetric();
        DEFAULT_INSTANCE = livekitMetrics$EventMetric;
        GeneratedMessageLite.registerDefaultInstance(LivekitMetrics$EventMetric.class, livekitMetrics$EventMetric);
    }

    private LivekitMetrics$EventMetric() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearEndTimestampMs() {
        this.bitField0_ &= -2;
        this.endTimestampMs_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearLabel() {
        this.label_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMetadata() {
        this.metadata_ = getDefaultInstance().getMetadata();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearNormalizedEndTimestamp() {
        this.normalizedEndTimestamp_ = null;
        this.bitField0_ &= -3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearNormalizedStartTimestamp() {
        this.normalizedStartTimestamp_ = null;
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
    public void clearStartTimestampMs() {
        this.startTimestampMs_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTrackSid() {
        this.trackSid_ = 0;
    }

    public static LivekitMetrics$EventMetric getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeNormalizedEndTimestamp(Timestamp timestamp) {
        timestamp.getClass();
        Timestamp timestamp2 = this.normalizedEndTimestamp_;
        if (timestamp2 == null || timestamp2 == Timestamp.getDefaultInstance()) {
            this.normalizedEndTimestamp_ = timestamp;
        } else {
            this.normalizedEndTimestamp_ = (Timestamp) ((Timestamp.b) Timestamp.newBuilder(this.normalizedEndTimestamp_).v(timestamp)).j();
        }
        this.bitField0_ |= 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeNormalizedStartTimestamp(Timestamp timestamp) {
        timestamp.getClass();
        Timestamp timestamp2 = this.normalizedStartTimestamp_;
        if (timestamp2 == null || timestamp2 == Timestamp.getDefaultInstance()) {
            this.normalizedStartTimestamp_ = timestamp;
        } else {
            this.normalizedStartTimestamp_ = (Timestamp) ((Timestamp.b) Timestamp.newBuilder(this.normalizedStartTimestamp_).v(timestamp)).j();
        }
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitMetrics$EventMetric parseDelimitedFrom(InputStream inputStream) {
        return (LivekitMetrics$EventMetric) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitMetrics$EventMetric parseFrom(ByteBuffer byteBuffer) {
        return (LivekitMetrics$EventMetric) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEndTimestampMs(long j) {
        this.bitField0_ |= 1;
        this.endTimestampMs_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLabel(int i) {
        this.label_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMetadata(String str) {
        str.getClass();
        this.metadata_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMetadataBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.metadata_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNormalizedEndTimestamp(Timestamp timestamp) {
        timestamp.getClass();
        this.normalizedEndTimestamp_ = timestamp;
        this.bitField0_ |= 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNormalizedStartTimestamp(Timestamp timestamp) {
        timestamp.getClass();
        this.normalizedStartTimestamp_ = timestamp;
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
    public void setStartTimestampMs(long j) {
        this.startTimestampMs_ = j;
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
                return new LivekitMetrics$EventMetric();
            case 2:
                return new a(nVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\t\u0000\u0001\u0001\t\t\u0000\u0000\u0000\u0001\u000b\u0002\u000b\u0003\u000b\u0004\u0002\u0005ဂ\u0000\u0006\t\u0007ဉ\u0001\bȈ\t\u000b", new Object[]{"bitField0_", "label_", "participantIdentity_", "trackSid_", "startTimestampMs_", "endTimestampMs_", "normalizedStartTimestamp_", "normalizedEndTimestamp_", "metadata_", "rid_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitMetrics$EventMetric.class) {
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

    public long getEndTimestampMs() {
        return this.endTimestampMs_;
    }

    public int getLabel() {
        return this.label_;
    }

    public String getMetadata() {
        return this.metadata_;
    }

    public AbstractC2383g getMetadataBytes() {
        return AbstractC2383g.N(this.metadata_);
    }

    public Timestamp getNormalizedEndTimestamp() {
        Timestamp timestamp = this.normalizedEndTimestamp_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    public Timestamp getNormalizedStartTimestamp() {
        Timestamp timestamp = this.normalizedStartTimestamp_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    public int getParticipantIdentity() {
        return this.participantIdentity_;
    }

    public int getRid() {
        return this.rid_;
    }

    public long getStartTimestampMs() {
        return this.startTimestampMs_;
    }

    public int getTrackSid() {
        return this.trackSid_;
    }

    public boolean hasEndTimestampMs() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasNormalizedEndTimestamp() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasNormalizedStartTimestamp() {
        return this.normalizedStartTimestamp_ != null;
    }

    public static a newBuilder(LivekitMetrics$EventMetric livekitMetrics$EventMetric) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitMetrics$EventMetric);
    }

    public static LivekitMetrics$EventMetric parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitMetrics$EventMetric) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitMetrics$EventMetric parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitMetrics$EventMetric) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitMetrics$EventMetric parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitMetrics$EventMetric) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitMetrics$EventMetric parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitMetrics$EventMetric) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitMetrics$EventMetric parseFrom(byte[] bArr) {
        return (LivekitMetrics$EventMetric) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitMetrics$EventMetric parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitMetrics$EventMetric) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitMetrics$EventMetric parseFrom(InputStream inputStream) {
        return (LivekitMetrics$EventMetric) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitMetrics$EventMetric parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitMetrics$EventMetric) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitMetrics$EventMetric parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitMetrics$EventMetric) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitMetrics$EventMetric parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitMetrics$EventMetric) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
