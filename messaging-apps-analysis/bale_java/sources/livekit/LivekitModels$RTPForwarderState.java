package livekit;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import ir.nasim.UE3;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;
import livekit.LivekitModels$RTPMungerState;
import livekit.LivekitModels$VP8MungerState;

/* loaded from: classes8.dex */
public final class LivekitModels$RTPForwarderState extends GeneratedMessageLite implements U64 {
    private static final LivekitModels$RTPForwarderState DEFAULT_INSTANCE;
    public static final int DUMMY_START_TIMESTAMP_OFFSET_FIELD_NUMBER = 5;
    public static final int EXT_FIRST_TIMESTAMP_FIELD_NUMBER = 4;
    private static volatile KW4 PARSER = null;
    public static final int PRE_START_TIME_FIELD_NUMBER = 3;
    public static final int REFERENCE_LAYER_SPATIAL_FIELD_NUMBER = 2;
    public static final int RTP_MUNGER_FIELD_NUMBER = 6;
    public static final int SENDER_REPORT_STATE_FIELD_NUMBER = 8;
    public static final int STARTED_FIELD_NUMBER = 1;
    public static final int VP8_MUNGER_FIELD_NUMBER = 7;
    private Object codecMunger_;
    private long dummyStartTimestampOffset_;
    private long extFirstTimestamp_;
    private long preStartTime_;
    private int referenceLayerSpatial_;
    private LivekitModels$RTPMungerState rtpMunger_;
    private boolean started_;
    private int codecMungerCase_ = 0;
    private B.j senderReportState_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(o oVar) {
            this();
        }

        private a() {
            super(LivekitModels$RTPForwarderState.DEFAULT_INSTANCE);
        }
    }

    public enum b {
        VP8_MUNGER(7),
        CODECMUNGER_NOT_SET(0);

        private final int a;

        b(int i) {
            this.a = i;
        }

        public static b j(int i) {
            if (i == 0) {
                return CODECMUNGER_NOT_SET;
            }
            if (i != 7) {
                return null;
            }
            return VP8_MUNGER;
        }
    }

    static {
        LivekitModels$RTPForwarderState livekitModels$RTPForwarderState = new LivekitModels$RTPForwarderState();
        DEFAULT_INSTANCE = livekitModels$RTPForwarderState;
        GeneratedMessageLite.registerDefaultInstance(LivekitModels$RTPForwarderState.class, livekitModels$RTPForwarderState);
    }

    private LivekitModels$RTPForwarderState() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllSenderReportState(Iterable<? extends LivekitModels$RTCPSenderReportState> iterable) {
        ensureSenderReportStateIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.senderReportState_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addSenderReportState(LivekitModels$RTCPSenderReportState livekitModels$RTCPSenderReportState) {
        livekitModels$RTCPSenderReportState.getClass();
        ensureSenderReportStateIsMutable();
        this.senderReportState_.add(livekitModels$RTCPSenderReportState);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCodecMunger() {
        this.codecMungerCase_ = 0;
        this.codecMunger_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDummyStartTimestampOffset() {
        this.dummyStartTimestampOffset_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearExtFirstTimestamp() {
        this.extFirstTimestamp_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPreStartTime() {
        this.preStartTime_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearReferenceLayerSpatial() {
        this.referenceLayerSpatial_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRtpMunger() {
        this.rtpMunger_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSenderReportState() {
        this.senderReportState_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearStarted() {
        this.started_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearVp8Munger() {
        if (this.codecMungerCase_ == 7) {
            this.codecMungerCase_ = 0;
            this.codecMunger_ = null;
        }
    }

    private void ensureSenderReportStateIsMutable() {
        B.j jVar = this.senderReportState_;
        if (jVar.u()) {
            return;
        }
        this.senderReportState_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static LivekitModels$RTPForwarderState getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeRtpMunger(LivekitModels$RTPMungerState livekitModels$RTPMungerState) {
        livekitModels$RTPMungerState.getClass();
        LivekitModels$RTPMungerState livekitModels$RTPMungerState2 = this.rtpMunger_;
        if (livekitModels$RTPMungerState2 == null || livekitModels$RTPMungerState2 == LivekitModels$RTPMungerState.getDefaultInstance()) {
            this.rtpMunger_ = livekitModels$RTPMungerState;
        } else {
            this.rtpMunger_ = (LivekitModels$RTPMungerState) ((LivekitModels$RTPMungerState.a) LivekitModels$RTPMungerState.newBuilder(this.rtpMunger_).v(livekitModels$RTPMungerState)).j();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeVp8Munger(LivekitModels$VP8MungerState livekitModels$VP8MungerState) {
        livekitModels$VP8MungerState.getClass();
        if (this.codecMungerCase_ != 7 || this.codecMunger_ == LivekitModels$VP8MungerState.getDefaultInstance()) {
            this.codecMunger_ = livekitModels$VP8MungerState;
        } else {
            this.codecMunger_ = ((LivekitModels$VP8MungerState.a) LivekitModels$VP8MungerState.newBuilder((LivekitModels$VP8MungerState) this.codecMunger_).v(livekitModels$VP8MungerState)).j();
        }
        this.codecMungerCase_ = 7;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitModels$RTPForwarderState parseDelimitedFrom(InputStream inputStream) {
        return (LivekitModels$RTPForwarderState) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitModels$RTPForwarderState parseFrom(ByteBuffer byteBuffer) {
        return (LivekitModels$RTPForwarderState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeSenderReportState(int i) {
        ensureSenderReportStateIsMutable();
        this.senderReportState_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDummyStartTimestampOffset(long j) {
        this.dummyStartTimestampOffset_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setExtFirstTimestamp(long j) {
        this.extFirstTimestamp_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPreStartTime(long j) {
        this.preStartTime_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setReferenceLayerSpatial(int i) {
        this.referenceLayerSpatial_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRtpMunger(LivekitModels$RTPMungerState livekitModels$RTPMungerState) {
        livekitModels$RTPMungerState.getClass();
        this.rtpMunger_ = livekitModels$RTPMungerState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSenderReportState(int i, LivekitModels$RTCPSenderReportState livekitModels$RTCPSenderReportState) {
        livekitModels$RTCPSenderReportState.getClass();
        ensureSenderReportStateIsMutable();
        this.senderReportState_.set(i, livekitModels$RTCPSenderReportState);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStarted(boolean z) {
        this.started_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVp8Munger(LivekitModels$VP8MungerState livekitModels$VP8MungerState) {
        livekitModels$VP8MungerState.getClass();
        this.codecMunger_ = livekitModels$VP8MungerState;
        this.codecMungerCase_ = 7;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        o oVar = null;
        switch (o.a[gVar.ordinal()]) {
            case 1:
                return new LivekitModels$RTPForwarderState();
            case 2:
                return new a(oVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\b\u0001\u0000\u0001\b\b\u0000\u0001\u0000\u0001\u0007\u0002\u0004\u0003\u0002\u0004\u0003\u0005\u0003\u0006\t\u0007<\u0000\b\u001b", new Object[]{"codecMunger_", "codecMungerCase_", "started_", "referenceLayerSpatial_", "preStartTime_", "extFirstTimestamp_", "dummyStartTimestampOffset_", "rtpMunger_", LivekitModels$VP8MungerState.class, "senderReportState_", LivekitModels$RTCPSenderReportState.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitModels$RTPForwarderState.class) {
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

    public b getCodecMungerCase() {
        return b.j(this.codecMungerCase_);
    }

    public long getDummyStartTimestampOffset() {
        return this.dummyStartTimestampOffset_;
    }

    public long getExtFirstTimestamp() {
        return this.extFirstTimestamp_;
    }

    public long getPreStartTime() {
        return this.preStartTime_;
    }

    public int getReferenceLayerSpatial() {
        return this.referenceLayerSpatial_;
    }

    public LivekitModels$RTPMungerState getRtpMunger() {
        LivekitModels$RTPMungerState livekitModels$RTPMungerState = this.rtpMunger_;
        return livekitModels$RTPMungerState == null ? LivekitModels$RTPMungerState.getDefaultInstance() : livekitModels$RTPMungerState;
    }

    public LivekitModels$RTCPSenderReportState getSenderReportState(int i) {
        return (LivekitModels$RTCPSenderReportState) this.senderReportState_.get(i);
    }

    public int getSenderReportStateCount() {
        return this.senderReportState_.size();
    }

    public List<LivekitModels$RTCPSenderReportState> getSenderReportStateList() {
        return this.senderReportState_;
    }

    public UE3 getSenderReportStateOrBuilder(int i) {
        return (UE3) this.senderReportState_.get(i);
    }

    public List<? extends UE3> getSenderReportStateOrBuilderList() {
        return this.senderReportState_;
    }

    public boolean getStarted() {
        return this.started_;
    }

    public LivekitModels$VP8MungerState getVp8Munger() {
        return this.codecMungerCase_ == 7 ? (LivekitModels$VP8MungerState) this.codecMunger_ : LivekitModels$VP8MungerState.getDefaultInstance();
    }

    public boolean hasRtpMunger() {
        return this.rtpMunger_ != null;
    }

    public boolean hasVp8Munger() {
        return this.codecMungerCase_ == 7;
    }

    public static a newBuilder(LivekitModels$RTPForwarderState livekitModels$RTPForwarderState) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitModels$RTPForwarderState);
    }

    public static LivekitModels$RTPForwarderState parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitModels$RTPForwarderState) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitModels$RTPForwarderState parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitModels$RTPForwarderState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitModels$RTPForwarderState parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitModels$RTPForwarderState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addSenderReportState(int i, LivekitModels$RTCPSenderReportState livekitModels$RTCPSenderReportState) {
        livekitModels$RTCPSenderReportState.getClass();
        ensureSenderReportStateIsMutable();
        this.senderReportState_.add(i, livekitModels$RTCPSenderReportState);
    }

    public static LivekitModels$RTPForwarderState parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitModels$RTPForwarderState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitModels$RTPForwarderState parseFrom(byte[] bArr) {
        return (LivekitModels$RTPForwarderState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitModels$RTPForwarderState parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitModels$RTPForwarderState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitModels$RTPForwarderState parseFrom(InputStream inputStream) {
        return (LivekitModels$RTPForwarderState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitModels$RTPForwarderState parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitModels$RTPForwarderState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitModels$RTPForwarderState parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitModels$RTPForwarderState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitModels$RTPForwarderState parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitModels$RTPForwarderState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
