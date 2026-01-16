package livekit;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.FE3;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes8.dex */
public final class LivekitInternal$NodeStatsRate extends GeneratedMessageLite implements FE3 {
    public static final int BYTES_IN_FIELD_NUMBER = 8;
    public static final int BYTES_OUT_FIELD_NUMBER = 9;
    public static final int CPU_LOAD_FIELD_NUMBER = 20;
    private static final LivekitInternal$NodeStatsRate DEFAULT_INSTANCE;
    public static final int DURATION_FIELD_NUMBER = 3;
    public static final int ENDED_AT_FIELD_NUMBER = 2;
    public static final int MEMORY_LOAD_FIELD_NUMBER = 21;
    public static final int MEMORY_TOTAL_FIELD_NUMBER = 23;
    public static final int MEMORY_USED_FIELD_NUMBER = 22;
    public static final int NACK_TOTAL_FIELD_NUMBER = 12;
    public static final int PACKETS_IN_FIELD_NUMBER = 10;
    public static final int PACKETS_OUT_FIELD_NUMBER = 11;
    private static volatile KW4 PARSER = null;
    public static final int PARTICIPANT_RTC_CONNECTED_FIELD_NUMBER = 18;
    public static final int PARTICIPANT_RTC_INIT_FIELD_NUMBER = 19;
    public static final int PARTICIPANT_SIGNAL_CONNECTED_FIELD_NUMBER = 17;
    public static final int RETRANSMIT_BYTES_OUT_FIELD_NUMBER = 15;
    public static final int RETRANSMIT_PACKETS_OUT_FIELD_NUMBER = 16;
    public static final int STARTED_AT_FIELD_NUMBER = 1;
    public static final int SYS_PACKETS_DROPPED_FIELD_NUMBER = 14;
    public static final int SYS_PACKETS_OUT_FIELD_NUMBER = 13;
    public static final int TRACK_PUBLISH_ATTEMPTS_FIELD_NUMBER = 4;
    public static final int TRACK_PUBLISH_SUCCESS_FIELD_NUMBER = 5;
    public static final int TRACK_SUBSCRIBE_ATTEMPTS_FIELD_NUMBER = 6;
    public static final int TRACK_SUBSCRIBE_SUCCESS_FIELD_NUMBER = 7;
    private float bytesIn_;
    private float bytesOut_;
    private float cpuLoad_;
    private long duration_;
    private long endedAt_;
    private float memoryLoad_;
    private float memoryTotal_;
    private float memoryUsed_;
    private float nackTotal_;
    private float packetsIn_;
    private float packetsOut_;
    private float participantRtcConnected_;
    private float participantRtcInit_;
    private float participantSignalConnected_;
    private float retransmitBytesOut_;
    private float retransmitPacketsOut_;
    private long startedAt_;
    private float sysPacketsDropped_;
    private float sysPacketsOut_;
    private float trackPublishAttempts_;
    private float trackPublishSuccess_;
    private float trackSubscribeAttempts_;
    private float trackSubscribeSuccess_;

    public static final class a extends GeneratedMessageLite.b implements FE3 {
        /* synthetic */ a(m mVar) {
            this();
        }

        private a() {
            super(LivekitInternal$NodeStatsRate.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitInternal$NodeStatsRate livekitInternal$NodeStatsRate = new LivekitInternal$NodeStatsRate();
        DEFAULT_INSTANCE = livekitInternal$NodeStatsRate;
        GeneratedMessageLite.registerDefaultInstance(LivekitInternal$NodeStatsRate.class, livekitInternal$NodeStatsRate);
    }

    private LivekitInternal$NodeStatsRate() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearBytesIn() {
        this.bytesIn_ = 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearBytesOut() {
        this.bytesOut_ = 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCpuLoad() {
        this.cpuLoad_ = 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDuration() {
        this.duration_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearEndedAt() {
        this.endedAt_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMemoryLoad() {
        this.memoryLoad_ = 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMemoryTotal() {
        this.memoryTotal_ = 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMemoryUsed() {
        this.memoryUsed_ = 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearNackTotal() {
        this.nackTotal_ = 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPacketsIn() {
        this.packetsIn_ = 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPacketsOut() {
        this.packetsOut_ = 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearParticipantRtcConnected() {
        this.participantRtcConnected_ = 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearParticipantRtcInit() {
        this.participantRtcInit_ = 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearParticipantSignalConnected() {
        this.participantSignalConnected_ = 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRetransmitBytesOut() {
        this.retransmitBytesOut_ = 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRetransmitPacketsOut() {
        this.retransmitPacketsOut_ = 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearStartedAt() {
        this.startedAt_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSysPacketsDropped() {
        this.sysPacketsDropped_ = 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSysPacketsOut() {
        this.sysPacketsOut_ = 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTrackPublishAttempts() {
        this.trackPublishAttempts_ = 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTrackPublishSuccess() {
        this.trackPublishSuccess_ = 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTrackSubscribeAttempts() {
        this.trackSubscribeAttempts_ = 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTrackSubscribeSuccess() {
        this.trackSubscribeSuccess_ = 0.0f;
    }

    public static LivekitInternal$NodeStatsRate getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitInternal$NodeStatsRate parseDelimitedFrom(InputStream inputStream) {
        return (LivekitInternal$NodeStatsRate) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitInternal$NodeStatsRate parseFrom(ByteBuffer byteBuffer) {
        return (LivekitInternal$NodeStatsRate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBytesIn(float f) {
        this.bytesIn_ = f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBytesOut(float f) {
        this.bytesOut_ = f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCpuLoad(float f) {
        this.cpuLoad_ = f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDuration(long j) {
        this.duration_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEndedAt(long j) {
        this.endedAt_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMemoryLoad(float f) {
        this.memoryLoad_ = f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMemoryTotal(float f) {
        this.memoryTotal_ = f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMemoryUsed(float f) {
        this.memoryUsed_ = f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNackTotal(float f) {
        this.nackTotal_ = f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPacketsIn(float f) {
        this.packetsIn_ = f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPacketsOut(float f) {
        this.packetsOut_ = f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setParticipantRtcConnected(float f) {
        this.participantRtcConnected_ = f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setParticipantRtcInit(float f) {
        this.participantRtcInit_ = f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setParticipantSignalConnected(float f) {
        this.participantSignalConnected_ = f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRetransmitBytesOut(float f) {
        this.retransmitBytesOut_ = f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRetransmitPacketsOut(float f) {
        this.retransmitPacketsOut_ = f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStartedAt(long j) {
        this.startedAt_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSysPacketsDropped(float f) {
        this.sysPacketsDropped_ = f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSysPacketsOut(float f) {
        this.sysPacketsOut_ = f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTrackPublishAttempts(float f) {
        this.trackPublishAttempts_ = f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTrackPublishSuccess(float f) {
        this.trackPublishSuccess_ = f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTrackSubscribeAttempts(float f) {
        this.trackSubscribeAttempts_ = f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTrackSubscribeSuccess(float f) {
        this.trackSubscribeSuccess_ = f;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        m mVar = null;
        switch (m.a[gVar.ordinal()]) {
            case 1:
                return new LivekitInternal$NodeStatsRate();
            case 2:
                return new a(mVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0017\u0000\u0000\u0001\u0017\u0017\u0000\u0000\u0000\u0001\u0002\u0002\u0002\u0003\u0002\u0004\u0001\u0005\u0001\u0006\u0001\u0007\u0001\b\u0001\t\u0001\n\u0001\u000b\u0001\f\u0001\r\u0001\u000e\u0001\u000f\u0001\u0010\u0001\u0011\u0001\u0012\u0001\u0013\u0001\u0014\u0001\u0015\u0001\u0016\u0001\u0017\u0001", new Object[]{"startedAt_", "endedAt_", "duration_", "trackPublishAttempts_", "trackPublishSuccess_", "trackSubscribeAttempts_", "trackSubscribeSuccess_", "bytesIn_", "bytesOut_", "packetsIn_", "packetsOut_", "nackTotal_", "sysPacketsOut_", "sysPacketsDropped_", "retransmitBytesOut_", "retransmitPacketsOut_", "participantSignalConnected_", "participantRtcConnected_", "participantRtcInit_", "cpuLoad_", "memoryLoad_", "memoryUsed_", "memoryTotal_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitInternal$NodeStatsRate.class) {
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

    public float getBytesIn() {
        return this.bytesIn_;
    }

    public float getBytesOut() {
        return this.bytesOut_;
    }

    public float getCpuLoad() {
        return this.cpuLoad_;
    }

    public long getDuration() {
        return this.duration_;
    }

    public long getEndedAt() {
        return this.endedAt_;
    }

    public float getMemoryLoad() {
        return this.memoryLoad_;
    }

    public float getMemoryTotal() {
        return this.memoryTotal_;
    }

    public float getMemoryUsed() {
        return this.memoryUsed_;
    }

    public float getNackTotal() {
        return this.nackTotal_;
    }

    public float getPacketsIn() {
        return this.packetsIn_;
    }

    public float getPacketsOut() {
        return this.packetsOut_;
    }

    public float getParticipantRtcConnected() {
        return this.participantRtcConnected_;
    }

    public float getParticipantRtcInit() {
        return this.participantRtcInit_;
    }

    public float getParticipantSignalConnected() {
        return this.participantSignalConnected_;
    }

    public float getRetransmitBytesOut() {
        return this.retransmitBytesOut_;
    }

    public float getRetransmitPacketsOut() {
        return this.retransmitPacketsOut_;
    }

    public long getStartedAt() {
        return this.startedAt_;
    }

    public float getSysPacketsDropped() {
        return this.sysPacketsDropped_;
    }

    public float getSysPacketsOut() {
        return this.sysPacketsOut_;
    }

    public float getTrackPublishAttempts() {
        return this.trackPublishAttempts_;
    }

    public float getTrackPublishSuccess() {
        return this.trackPublishSuccess_;
    }

    public float getTrackSubscribeAttempts() {
        return this.trackSubscribeAttempts_;
    }

    public float getTrackSubscribeSuccess() {
        return this.trackSubscribeSuccess_;
    }

    public static a newBuilder(LivekitInternal$NodeStatsRate livekitInternal$NodeStatsRate) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitInternal$NodeStatsRate);
    }

    public static LivekitInternal$NodeStatsRate parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitInternal$NodeStatsRate) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitInternal$NodeStatsRate parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitInternal$NodeStatsRate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitInternal$NodeStatsRate parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitInternal$NodeStatsRate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitInternal$NodeStatsRate parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitInternal$NodeStatsRate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitInternal$NodeStatsRate parseFrom(byte[] bArr) {
        return (LivekitInternal$NodeStatsRate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitInternal$NodeStatsRate parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitInternal$NodeStatsRate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitInternal$NodeStatsRate parseFrom(InputStream inputStream) {
        return (LivekitInternal$NodeStatsRate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitInternal$NodeStatsRate parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitInternal$NodeStatsRate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitInternal$NodeStatsRate parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitInternal$NodeStatsRate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitInternal$NodeStatsRate parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitInternal$NodeStatsRate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
