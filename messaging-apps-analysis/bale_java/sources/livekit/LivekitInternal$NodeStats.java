package livekit;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.FE3;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes8.dex */
public final class LivekitInternal$NodeStats extends GeneratedMessageLite implements U64 {
    public static final int BYTES_IN_FIELD_NUMBER = 7;
    public static final int BYTES_IN_PER_SEC_FIELD_NUMBER = 12;
    public static final int BYTES_OUT_FIELD_NUMBER = 8;
    public static final int BYTES_OUT_PER_SEC_FIELD_NUMBER = 13;
    public static final int CPU_LOAD_FIELD_NUMBER = 21;
    private static final LivekitInternal$NodeStats DEFAULT_INSTANCE;
    public static final int FORWARD_JITTER_FIELD_NUMBER = 49;
    public static final int FORWARD_LATENCY_FIELD_NUMBER = 48;
    public static final int LOAD_AVG_LAST15MIN_FIELD_NUMBER = 20;
    public static final int LOAD_AVG_LAST1MIN_FIELD_NUMBER = 18;
    public static final int LOAD_AVG_LAST5MIN_FIELD_NUMBER = 19;
    public static final int MEMORY_LOAD_FIELD_NUMBER = 33;
    public static final int MEMORY_TOTAL_FIELD_NUMBER = 34;
    public static final int MEMORY_USED_FIELD_NUMBER = 35;
    public static final int NACK_PER_SEC_FIELD_NUMBER = 16;
    public static final int NACK_TOTAL_FIELD_NUMBER = 11;
    public static final int NUM_CLIENTS_FIELD_NUMBER = 4;
    public static final int NUM_CPUS_FIELD_NUMBER = 17;
    public static final int NUM_ROOMS_FIELD_NUMBER = 3;
    public static final int NUM_TRACKS_IN_FIELD_NUMBER = 5;
    public static final int NUM_TRACKS_OUT_FIELD_NUMBER = 6;
    public static final int NUM_TRACK_PUBLISH_ATTEMPTS_FIELD_NUMBER = 36;
    public static final int NUM_TRACK_PUBLISH_SUCCESS_FIELD_NUMBER = 38;
    public static final int NUM_TRACK_SUBSCRIBE_ATTEMPTS_FIELD_NUMBER = 40;
    public static final int NUM_TRACK_SUBSCRIBE_SUCCESS_FIELD_NUMBER = 42;
    public static final int PACKETS_IN_FIELD_NUMBER = 9;
    public static final int PACKETS_IN_PER_SEC_FIELD_NUMBER = 14;
    public static final int PACKETS_OUT_FIELD_NUMBER = 10;
    public static final int PACKETS_OUT_PER_SEC_FIELD_NUMBER = 15;
    private static volatile KW4 PARSER = null;
    public static final int PARTICIPANT_RTC_CONNECTED_FIELD_NUMBER = 44;
    public static final int PARTICIPANT_RTC_CONNECTED_PER_SEC_FIELD_NUMBER = 45;
    public static final int PARTICIPANT_RTC_INIT_FIELD_NUMBER = 46;
    public static final int PARTICIPANT_RTC_INIT_PER_SEC_FIELD_NUMBER = 47;
    public static final int PARTICIPANT_SIGNAL_CONNECTED_FIELD_NUMBER = 26;
    public static final int PARTICIPANT_SIGNAL_CONNECTED_PER_SEC_FIELD_NUMBER = 27;
    public static final int RATES_FIELD_NUMBER = 50;
    public static final int RETRANSMIT_BYTES_OUT_FIELD_NUMBER = 22;
    public static final int RETRANSMIT_BYTES_OUT_PER_SEC_FIELD_NUMBER = 24;
    public static final int RETRANSMIT_PACKETS_OUT_FIELD_NUMBER = 23;
    public static final int RETRANSMIT_PACKETS_OUT_PER_SEC_FIELD_NUMBER = 25;
    public static final int STARTED_AT_FIELD_NUMBER = 1;
    public static final int SYS_PACKETS_DROPPED_FIELD_NUMBER = 29;
    public static final int SYS_PACKETS_DROPPED_PCT_PER_SEC_FIELD_NUMBER = 32;
    public static final int SYS_PACKETS_DROPPED_PER_SEC_FIELD_NUMBER = 31;
    public static final int SYS_PACKETS_OUT_FIELD_NUMBER = 28;
    public static final int SYS_PACKETS_OUT_PER_SEC_FIELD_NUMBER = 30;
    public static final int TRACK_PUBLISH_ATTEMPTS_PER_SEC_FIELD_NUMBER = 37;
    public static final int TRACK_PUBLISH_SUCCESS_PER_SEC_FIELD_NUMBER = 39;
    public static final int TRACK_SUBSCRIBE_ATTEMPTS_PER_SEC_FIELD_NUMBER = 41;
    public static final int TRACK_SUBSCRIBE_SUCCESS_PER_SEC_FIELD_NUMBER = 43;
    public static final int UPDATED_AT_FIELD_NUMBER = 2;
    private float bytesInPerSec_;
    private long bytesIn_;
    private float bytesOutPerSec_;
    private long bytesOut_;
    private float cpuLoad_;
    private int forwardJitter_;
    private int forwardLatency_;
    private float loadAvgLast15Min_;
    private float loadAvgLast1Min_;
    private float loadAvgLast5Min_;
    private float memoryLoad_;
    private long memoryTotal_;
    private long memoryUsed_;
    private float nackPerSec_;
    private long nackTotal_;
    private int numClients_;
    private int numCpus_;
    private int numRooms_;
    private int numTrackPublishAttempts_;
    private int numTrackPublishSuccess_;
    private int numTrackSubscribeAttempts_;
    private int numTrackSubscribeSuccess_;
    private int numTracksIn_;
    private int numTracksOut_;
    private float packetsInPerSec_;
    private long packetsIn_;
    private float packetsOutPerSec_;
    private long packetsOut_;
    private float participantRtcConnectedPerSec_;
    private long participantRtcConnected_;
    private float participantRtcInitPerSec_;
    private long participantRtcInit_;
    private float participantSignalConnectedPerSec_;
    private long participantSignalConnected_;
    private B.j rates_ = GeneratedMessageLite.emptyProtobufList();
    private float retransmitBytesOutPerSec_;
    private long retransmitBytesOut_;
    private float retransmitPacketsOutPerSec_;
    private long retransmitPacketsOut_;
    private long startedAt_;
    private float sysPacketsDroppedPctPerSec_;
    private float sysPacketsDroppedPerSec_;
    private int sysPacketsDropped_;
    private float sysPacketsOutPerSec_;
    private int sysPacketsOut_;
    private float trackPublishAttemptsPerSec_;
    private float trackPublishSuccessPerSec_;
    private float trackSubscribeAttemptsPerSec_;
    private float trackSubscribeSuccessPerSec_;
    private long updatedAt_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(m mVar) {
            this();
        }

        private a() {
            super(LivekitInternal$NodeStats.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitInternal$NodeStats livekitInternal$NodeStats = new LivekitInternal$NodeStats();
        DEFAULT_INSTANCE = livekitInternal$NodeStats;
        GeneratedMessageLite.registerDefaultInstance(LivekitInternal$NodeStats.class, livekitInternal$NodeStats);
    }

    private LivekitInternal$NodeStats() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllRates(Iterable<? extends LivekitInternal$NodeStatsRate> iterable) {
        ensureRatesIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.rates_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addRates(LivekitInternal$NodeStatsRate livekitInternal$NodeStatsRate) {
        livekitInternal$NodeStatsRate.getClass();
        ensureRatesIsMutable();
        this.rates_.add(livekitInternal$NodeStatsRate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearBytesIn() {
        this.bytesIn_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearBytesInPerSec() {
        this.bytesInPerSec_ = 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearBytesOut() {
        this.bytesOut_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearBytesOutPerSec() {
        this.bytesOutPerSec_ = 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCpuLoad() {
        this.cpuLoad_ = 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearForwardJitter() {
        this.forwardJitter_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearForwardLatency() {
        this.forwardLatency_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearLoadAvgLast15Min() {
        this.loadAvgLast15Min_ = 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearLoadAvgLast1Min() {
        this.loadAvgLast1Min_ = 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearLoadAvgLast5Min() {
        this.loadAvgLast5Min_ = 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMemoryLoad() {
        this.memoryLoad_ = 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMemoryTotal() {
        this.memoryTotal_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMemoryUsed() {
        this.memoryUsed_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearNackPerSec() {
        this.nackPerSec_ = 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearNackTotal() {
        this.nackTotal_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearNumClients() {
        this.numClients_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearNumCpus() {
        this.numCpus_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearNumRooms() {
        this.numRooms_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearNumTrackPublishAttempts() {
        this.numTrackPublishAttempts_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearNumTrackPublishSuccess() {
        this.numTrackPublishSuccess_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearNumTrackSubscribeAttempts() {
        this.numTrackSubscribeAttempts_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearNumTrackSubscribeSuccess() {
        this.numTrackSubscribeSuccess_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearNumTracksIn() {
        this.numTracksIn_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearNumTracksOut() {
        this.numTracksOut_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPacketsIn() {
        this.packetsIn_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPacketsInPerSec() {
        this.packetsInPerSec_ = 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPacketsOut() {
        this.packetsOut_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPacketsOutPerSec() {
        this.packetsOutPerSec_ = 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearParticipantRtcConnected() {
        this.participantRtcConnected_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearParticipantRtcConnectedPerSec() {
        this.participantRtcConnectedPerSec_ = 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearParticipantRtcInit() {
        this.participantRtcInit_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearParticipantRtcInitPerSec() {
        this.participantRtcInitPerSec_ = 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearParticipantSignalConnected() {
        this.participantSignalConnected_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearParticipantSignalConnectedPerSec() {
        this.participantSignalConnectedPerSec_ = 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRates() {
        this.rates_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRetransmitBytesOut() {
        this.retransmitBytesOut_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRetransmitBytesOutPerSec() {
        this.retransmitBytesOutPerSec_ = 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRetransmitPacketsOut() {
        this.retransmitPacketsOut_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRetransmitPacketsOutPerSec() {
        this.retransmitPacketsOutPerSec_ = 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearStartedAt() {
        this.startedAt_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSysPacketsDropped() {
        this.sysPacketsDropped_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSysPacketsDroppedPctPerSec() {
        this.sysPacketsDroppedPctPerSec_ = 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSysPacketsDroppedPerSec() {
        this.sysPacketsDroppedPerSec_ = 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSysPacketsOut() {
        this.sysPacketsOut_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSysPacketsOutPerSec() {
        this.sysPacketsOutPerSec_ = 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTrackPublishAttemptsPerSec() {
        this.trackPublishAttemptsPerSec_ = 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTrackPublishSuccessPerSec() {
        this.trackPublishSuccessPerSec_ = 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTrackSubscribeAttemptsPerSec() {
        this.trackSubscribeAttemptsPerSec_ = 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTrackSubscribeSuccessPerSec() {
        this.trackSubscribeSuccessPerSec_ = 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearUpdatedAt() {
        this.updatedAt_ = 0L;
    }

    private void ensureRatesIsMutable() {
        B.j jVar = this.rates_;
        if (jVar.u()) {
            return;
        }
        this.rates_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static LivekitInternal$NodeStats getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitInternal$NodeStats parseDelimitedFrom(InputStream inputStream) {
        return (LivekitInternal$NodeStats) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitInternal$NodeStats parseFrom(ByteBuffer byteBuffer) {
        return (LivekitInternal$NodeStats) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeRates(int i) {
        ensureRatesIsMutable();
        this.rates_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBytesIn(long j) {
        this.bytesIn_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBytesInPerSec(float f) {
        this.bytesInPerSec_ = f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBytesOut(long j) {
        this.bytesOut_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBytesOutPerSec(float f) {
        this.bytesOutPerSec_ = f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCpuLoad(float f) {
        this.cpuLoad_ = f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setForwardJitter(int i) {
        this.forwardJitter_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setForwardLatency(int i) {
        this.forwardLatency_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLoadAvgLast15Min(float f) {
        this.loadAvgLast15Min_ = f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLoadAvgLast1Min(float f) {
        this.loadAvgLast1Min_ = f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLoadAvgLast5Min(float f) {
        this.loadAvgLast5Min_ = f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMemoryLoad(float f) {
        this.memoryLoad_ = f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMemoryTotal(long j) {
        this.memoryTotal_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMemoryUsed(long j) {
        this.memoryUsed_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNackPerSec(float f) {
        this.nackPerSec_ = f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNackTotal(long j) {
        this.nackTotal_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNumClients(int i) {
        this.numClients_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNumCpus(int i) {
        this.numCpus_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNumRooms(int i) {
        this.numRooms_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNumTrackPublishAttempts(int i) {
        this.numTrackPublishAttempts_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNumTrackPublishSuccess(int i) {
        this.numTrackPublishSuccess_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNumTrackSubscribeAttempts(int i) {
        this.numTrackSubscribeAttempts_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNumTrackSubscribeSuccess(int i) {
        this.numTrackSubscribeSuccess_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNumTracksIn(int i) {
        this.numTracksIn_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNumTracksOut(int i) {
        this.numTracksOut_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPacketsIn(long j) {
        this.packetsIn_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPacketsInPerSec(float f) {
        this.packetsInPerSec_ = f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPacketsOut(long j) {
        this.packetsOut_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPacketsOutPerSec(float f) {
        this.packetsOutPerSec_ = f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setParticipantRtcConnected(long j) {
        this.participantRtcConnected_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setParticipantRtcConnectedPerSec(float f) {
        this.participantRtcConnectedPerSec_ = f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setParticipantRtcInit(long j) {
        this.participantRtcInit_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setParticipantRtcInitPerSec(float f) {
        this.participantRtcInitPerSec_ = f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setParticipantSignalConnected(long j) {
        this.participantSignalConnected_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setParticipantSignalConnectedPerSec(float f) {
        this.participantSignalConnectedPerSec_ = f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRates(int i, LivekitInternal$NodeStatsRate livekitInternal$NodeStatsRate) {
        livekitInternal$NodeStatsRate.getClass();
        ensureRatesIsMutable();
        this.rates_.set(i, livekitInternal$NodeStatsRate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRetransmitBytesOut(long j) {
        this.retransmitBytesOut_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRetransmitBytesOutPerSec(float f) {
        this.retransmitBytesOutPerSec_ = f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRetransmitPacketsOut(long j) {
        this.retransmitPacketsOut_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRetransmitPacketsOutPerSec(float f) {
        this.retransmitPacketsOutPerSec_ = f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStartedAt(long j) {
        this.startedAt_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSysPacketsDropped(int i) {
        this.sysPacketsDropped_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSysPacketsDroppedPctPerSec(float f) {
        this.sysPacketsDroppedPctPerSec_ = f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSysPacketsDroppedPerSec(float f) {
        this.sysPacketsDroppedPerSec_ = f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSysPacketsOut(int i) {
        this.sysPacketsOut_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSysPacketsOutPerSec(float f) {
        this.sysPacketsOutPerSec_ = f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTrackPublishAttemptsPerSec(float f) {
        this.trackPublishAttemptsPerSec_ = f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTrackPublishSuccessPerSec(float f) {
        this.trackPublishSuccessPerSec_ = f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTrackSubscribeAttemptsPerSec(float f) {
        this.trackSubscribeAttemptsPerSec_ = f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTrackSubscribeSuccessPerSec(float f) {
        this.trackSubscribeSuccessPerSec_ = f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUpdatedAt(long j) {
        this.updatedAt_ = j;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        m mVar = null;
        switch (m.a[gVar.ordinal()]) {
            case 1:
                return new LivekitInternal$NodeStats();
            case 2:
                return new a(mVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u00002\u0000\u0000\u000122\u0000\u0001\u0000\u0001\u0002\u0002\u0002\u0003\u0004\u0004\u0004\u0005\u0004\u0006\u0004\u0007\u0003\b\u0003\t\u0003\n\u0003\u000b\u0003\f\u0001\r\u0001\u000e\u0001\u000f\u0001\u0010\u0001\u0011\u000b\u0012\u0001\u0013\u0001\u0014\u0001\u0015\u0001\u0016\u0003\u0017\u0003\u0018\u0001\u0019\u0001\u001a\u0003\u001b\u0001\u001c\u000b\u001d\u000b\u001e\u0001\u001f\u0001 \u0001!\u0001\"\u0003#\u0003$\u0004%\u0001&\u0004'\u0001(\u0004)\u0001*\u0004+\u0001,\u0003-\u0001.\u0003/\u00010\u000b1\u000b2\u001b", new Object[]{"startedAt_", "updatedAt_", "numRooms_", "numClients_", "numTracksIn_", "numTracksOut_", "bytesIn_", "bytesOut_", "packetsIn_", "packetsOut_", "nackTotal_", "bytesInPerSec_", "bytesOutPerSec_", "packetsInPerSec_", "packetsOutPerSec_", "nackPerSec_", "numCpus_", "loadAvgLast1Min_", "loadAvgLast5Min_", "loadAvgLast15Min_", "cpuLoad_", "retransmitBytesOut_", "retransmitPacketsOut_", "retransmitBytesOutPerSec_", "retransmitPacketsOutPerSec_", "participantSignalConnected_", "participantSignalConnectedPerSec_", "sysPacketsOut_", "sysPacketsDropped_", "sysPacketsOutPerSec_", "sysPacketsDroppedPerSec_", "sysPacketsDroppedPctPerSec_", "memoryLoad_", "memoryTotal_", "memoryUsed_", "numTrackPublishAttempts_", "trackPublishAttemptsPerSec_", "numTrackPublishSuccess_", "trackPublishSuccessPerSec_", "numTrackSubscribeAttempts_", "trackSubscribeAttemptsPerSec_", "numTrackSubscribeSuccess_", "trackSubscribeSuccessPerSec_", "participantRtcConnected_", "participantRtcConnectedPerSec_", "participantRtcInit_", "participantRtcInitPerSec_", "forwardLatency_", "forwardJitter_", "rates_", LivekitInternal$NodeStatsRate.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitInternal$NodeStats.class) {
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

    public long getBytesIn() {
        return this.bytesIn_;
    }

    @Deprecated
    public float getBytesInPerSec() {
        return this.bytesInPerSec_;
    }

    public long getBytesOut() {
        return this.bytesOut_;
    }

    @Deprecated
    public float getBytesOutPerSec() {
        return this.bytesOutPerSec_;
    }

    public float getCpuLoad() {
        return this.cpuLoad_;
    }

    public int getForwardJitter() {
        return this.forwardJitter_;
    }

    public int getForwardLatency() {
        return this.forwardLatency_;
    }

    public float getLoadAvgLast15Min() {
        return this.loadAvgLast15Min_;
    }

    public float getLoadAvgLast1Min() {
        return this.loadAvgLast1Min_;
    }

    public float getLoadAvgLast5Min() {
        return this.loadAvgLast5Min_;
    }

    @Deprecated
    public float getMemoryLoad() {
        return this.memoryLoad_;
    }

    public long getMemoryTotal() {
        return this.memoryTotal_;
    }

    public long getMemoryUsed() {
        return this.memoryUsed_;
    }

    @Deprecated
    public float getNackPerSec() {
        return this.nackPerSec_;
    }

    public long getNackTotal() {
        return this.nackTotal_;
    }

    public int getNumClients() {
        return this.numClients_;
    }

    public int getNumCpus() {
        return this.numCpus_;
    }

    public int getNumRooms() {
        return this.numRooms_;
    }

    public int getNumTrackPublishAttempts() {
        return this.numTrackPublishAttempts_;
    }

    public int getNumTrackPublishSuccess() {
        return this.numTrackPublishSuccess_;
    }

    public int getNumTrackSubscribeAttempts() {
        return this.numTrackSubscribeAttempts_;
    }

    public int getNumTrackSubscribeSuccess() {
        return this.numTrackSubscribeSuccess_;
    }

    public int getNumTracksIn() {
        return this.numTracksIn_;
    }

    public int getNumTracksOut() {
        return this.numTracksOut_;
    }

    public long getPacketsIn() {
        return this.packetsIn_;
    }

    @Deprecated
    public float getPacketsInPerSec() {
        return this.packetsInPerSec_;
    }

    public long getPacketsOut() {
        return this.packetsOut_;
    }

    @Deprecated
    public float getPacketsOutPerSec() {
        return this.packetsOutPerSec_;
    }

    public long getParticipantRtcConnected() {
        return this.participantRtcConnected_;
    }

    @Deprecated
    public float getParticipantRtcConnectedPerSec() {
        return this.participantRtcConnectedPerSec_;
    }

    public long getParticipantRtcInit() {
        return this.participantRtcInit_;
    }

    @Deprecated
    public float getParticipantRtcInitPerSec() {
        return this.participantRtcInitPerSec_;
    }

    public long getParticipantSignalConnected() {
        return this.participantSignalConnected_;
    }

    @Deprecated
    public float getParticipantSignalConnectedPerSec() {
        return this.participantSignalConnectedPerSec_;
    }

    public LivekitInternal$NodeStatsRate getRates(int i) {
        return (LivekitInternal$NodeStatsRate) this.rates_.get(i);
    }

    public int getRatesCount() {
        return this.rates_.size();
    }

    public List<LivekitInternal$NodeStatsRate> getRatesList() {
        return this.rates_;
    }

    public FE3 getRatesOrBuilder(int i) {
        return (FE3) this.rates_.get(i);
    }

    public List<? extends FE3> getRatesOrBuilderList() {
        return this.rates_;
    }

    public long getRetransmitBytesOut() {
        return this.retransmitBytesOut_;
    }

    @Deprecated
    public float getRetransmitBytesOutPerSec() {
        return this.retransmitBytesOutPerSec_;
    }

    public long getRetransmitPacketsOut() {
        return this.retransmitPacketsOut_;
    }

    @Deprecated
    public float getRetransmitPacketsOutPerSec() {
        return this.retransmitPacketsOutPerSec_;
    }

    public long getStartedAt() {
        return this.startedAt_;
    }

    public int getSysPacketsDropped() {
        return this.sysPacketsDropped_;
    }

    @Deprecated
    public float getSysPacketsDroppedPctPerSec() {
        return this.sysPacketsDroppedPctPerSec_;
    }

    @Deprecated
    public float getSysPacketsDroppedPerSec() {
        return this.sysPacketsDroppedPerSec_;
    }

    public int getSysPacketsOut() {
        return this.sysPacketsOut_;
    }

    @Deprecated
    public float getSysPacketsOutPerSec() {
        return this.sysPacketsOutPerSec_;
    }

    @Deprecated
    public float getTrackPublishAttemptsPerSec() {
        return this.trackPublishAttemptsPerSec_;
    }

    @Deprecated
    public float getTrackPublishSuccessPerSec() {
        return this.trackPublishSuccessPerSec_;
    }

    @Deprecated
    public float getTrackSubscribeAttemptsPerSec() {
        return this.trackSubscribeAttemptsPerSec_;
    }

    @Deprecated
    public float getTrackSubscribeSuccessPerSec() {
        return this.trackSubscribeSuccessPerSec_;
    }

    public long getUpdatedAt() {
        return this.updatedAt_;
    }

    public static a newBuilder(LivekitInternal$NodeStats livekitInternal$NodeStats) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitInternal$NodeStats);
    }

    public static LivekitInternal$NodeStats parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitInternal$NodeStats) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitInternal$NodeStats parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitInternal$NodeStats) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitInternal$NodeStats parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitInternal$NodeStats) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addRates(int i, LivekitInternal$NodeStatsRate livekitInternal$NodeStatsRate) {
        livekitInternal$NodeStatsRate.getClass();
        ensureRatesIsMutable();
        this.rates_.add(i, livekitInternal$NodeStatsRate);
    }

    public static LivekitInternal$NodeStats parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitInternal$NodeStats) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitInternal$NodeStats parseFrom(byte[] bArr) {
        return (LivekitInternal$NodeStats) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitInternal$NodeStats parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitInternal$NodeStats) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitInternal$NodeStats parseFrom(InputStream inputStream) {
        return (LivekitInternal$NodeStats) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitInternal$NodeStats parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitInternal$NodeStats) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitInternal$NodeStats parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitInternal$NodeStats) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitInternal$NodeStats parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitInternal$NodeStats) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
