package livekit;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.I;
import com.google.protobuf.J;
import com.google.protobuf.Timestamp;
import com.google.protobuf.r0;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Map;
import livekit.LivekitModels$RTPDrift;

/* loaded from: classes8.dex */
public final class LivekitModels$RTPStats extends GeneratedMessageLite implements U64 {
    public static final int BITRATE_DUPLICATE_FIELD_NUMBER = 14;
    public static final int BITRATE_FIELD_NUMBER = 7;
    public static final int BITRATE_PADDING_FIELD_NUMBER = 18;
    public static final int BYTES_DUPLICATE_FIELD_NUMBER = 13;
    public static final int BYTES_FIELD_NUMBER = 6;
    public static final int BYTES_PADDING_FIELD_NUMBER = 17;
    private static final LivekitModels$RTPStats DEFAULT_INSTANCE;
    public static final int DURATION_FIELD_NUMBER = 3;
    public static final int END_TIME_FIELD_NUMBER = 2;
    public static final int FIRS_FIELD_NUMBER = 29;
    public static final int FRAMES_FIELD_NUMBER = 20;
    public static final int FRAME_RATE_FIELD_NUMBER = 21;
    public static final int GAP_HISTOGRAM_FIELD_NUMBER = 24;
    public static final int HEADER_BYTES_DUPLICATE_FIELD_NUMBER = 40;
    public static final int HEADER_BYTES_FIELD_NUMBER = 39;
    public static final int HEADER_BYTES_PADDING_FIELD_NUMBER = 41;
    public static final int JITTER_CURRENT_FIELD_NUMBER = 22;
    public static final int JITTER_MAX_FIELD_NUMBER = 23;
    public static final int KEY_FRAMES_FIELD_NUMBER = 33;
    public static final int LAST_FIR_FIELD_NUMBER = 30;
    public static final int LAST_KEY_FRAME_FIELD_NUMBER = 34;
    public static final int LAST_LAYER_LOCK_PLI_FIELD_NUMBER = 36;
    public static final int LAST_PLI_FIELD_NUMBER = 28;
    public static final int LAYER_LOCK_PLIS_FIELD_NUMBER = 35;
    public static final int NACKS_FIELD_NUMBER = 25;
    public static final int NACK_ACKS_FIELD_NUMBER = 37;
    public static final int NACK_MISSES_FIELD_NUMBER = 26;
    public static final int NACK_REPEATED_FIELD_NUMBER = 38;
    public static final int NTP_REPORT_DRIFT_FIELD_NUMBER = 45;
    public static final int PACKETS_DUPLICATE_FIELD_NUMBER = 11;
    public static final int PACKETS_FIELD_NUMBER = 4;
    public static final int PACKETS_LOST_FIELD_NUMBER = 8;
    public static final int PACKETS_OUT_OF_ORDER_FIELD_NUMBER = 19;
    public static final int PACKETS_PADDING_FIELD_NUMBER = 15;
    public static final int PACKET_DRIFT_FIELD_NUMBER = 44;
    public static final int PACKET_DUPLICATE_RATE_FIELD_NUMBER = 12;
    public static final int PACKET_LOSS_PERCENTAGE_FIELD_NUMBER = 10;
    public static final int PACKET_LOSS_RATE_FIELD_NUMBER = 9;
    public static final int PACKET_PADDING_RATE_FIELD_NUMBER = 16;
    public static final int PACKET_RATE_FIELD_NUMBER = 5;
    private static volatile KW4 PARSER = null;
    public static final int PLIS_FIELD_NUMBER = 27;
    public static final int REBASED_REPORT_DRIFT_FIELD_NUMBER = 46;
    public static final int RECEIVED_REPORT_DRIFT_FIELD_NUMBER = 47;
    public static final int RTT_CURRENT_FIELD_NUMBER = 31;
    public static final int RTT_MAX_FIELD_NUMBER = 32;
    public static final int START_TIME_FIELD_NUMBER = 1;
    private double bitrateDuplicate_;
    private double bitratePadding_;
    private double bitrate_;
    private long bytesDuplicate_;
    private long bytesPadding_;
    private long bytes_;
    private double duration_;
    private Timestamp endTime_;
    private int firs_;
    private double frameRate_;
    private int frames_;
    private J gapHistogram_ = J.e();
    private long headerBytesDuplicate_;
    private long headerBytesPadding_;
    private long headerBytes_;
    private double jitterCurrent_;
    private double jitterMax_;
    private int keyFrames_;
    private Timestamp lastFir_;
    private Timestamp lastKeyFrame_;
    private Timestamp lastLayerLockPli_;
    private Timestamp lastPli_;
    private int layerLockPlis_;
    private int nackAcks_;
    private int nackMisses_;
    private int nackRepeated_;
    private int nacks_;
    private LivekitModels$RTPDrift ntpReportDrift_;
    private LivekitModels$RTPDrift packetDrift_;
    private double packetDuplicateRate_;
    private float packetLossPercentage_;
    private double packetLossRate_;
    private double packetPaddingRate_;
    private double packetRate_;
    private int packetsDuplicate_;
    private int packetsLost_;
    private int packetsOutOfOrder_;
    private int packetsPadding_;
    private int packets_;
    private int plis_;
    private LivekitModels$RTPDrift rebasedReportDrift_;
    private LivekitModels$RTPDrift receivedReportDrift_;
    private int rttCurrent_;
    private int rttMax_;
    private Timestamp startTime_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(o oVar) {
            this();
        }

        private a() {
            super(LivekitModels$RTPStats.DEFAULT_INSTANCE);
        }
    }

    private static final class b {
        static final I a = I.d(r0.b.g, 0, r0.b.o, 0);
    }

    static {
        LivekitModels$RTPStats livekitModels$RTPStats = new LivekitModels$RTPStats();
        DEFAULT_INSTANCE = livekitModels$RTPStats;
        GeneratedMessageLite.registerDefaultInstance(LivekitModels$RTPStats.class, livekitModels$RTPStats);
    }

    private LivekitModels$RTPStats() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearBitrate() {
        this.bitrate_ = 0.0d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearBitrateDuplicate() {
        this.bitrateDuplicate_ = 0.0d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearBitratePadding() {
        this.bitratePadding_ = 0.0d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearBytes() {
        this.bytes_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearBytesDuplicate() {
        this.bytesDuplicate_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearBytesPadding() {
        this.bytesPadding_ = 0L;
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
    public void clearFirs() {
        this.firs_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearFrameRate() {
        this.frameRate_ = 0.0d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearFrames() {
        this.frames_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearHeaderBytes() {
        this.headerBytes_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearHeaderBytesDuplicate() {
        this.headerBytesDuplicate_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearHeaderBytesPadding() {
        this.headerBytesPadding_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearJitterCurrent() {
        this.jitterCurrent_ = 0.0d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearJitterMax() {
        this.jitterMax_ = 0.0d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearKeyFrames() {
        this.keyFrames_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearLastFir() {
        this.lastFir_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearLastKeyFrame() {
        this.lastKeyFrame_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearLastLayerLockPli() {
        this.lastLayerLockPli_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearLastPli() {
        this.lastPli_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearLayerLockPlis() {
        this.layerLockPlis_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearNackAcks() {
        this.nackAcks_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearNackMisses() {
        this.nackMisses_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearNackRepeated() {
        this.nackRepeated_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearNacks() {
        this.nacks_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearNtpReportDrift() {
        this.ntpReportDrift_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPacketDrift() {
        this.packetDrift_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPacketDuplicateRate() {
        this.packetDuplicateRate_ = 0.0d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPacketLossPercentage() {
        this.packetLossPercentage_ = 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPacketLossRate() {
        this.packetLossRate_ = 0.0d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPacketPaddingRate() {
        this.packetPaddingRate_ = 0.0d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPacketRate() {
        this.packetRate_ = 0.0d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPackets() {
        this.packets_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPacketsDuplicate() {
        this.packetsDuplicate_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPacketsLost() {
        this.packetsLost_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPacketsOutOfOrder() {
        this.packetsOutOfOrder_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPacketsPadding() {
        this.packetsPadding_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPlis() {
        this.plis_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRebasedReportDrift() {
        this.rebasedReportDrift_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearReceivedReportDrift() {
        this.receivedReportDrift_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRttCurrent() {
        this.rttCurrent_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRttMax() {
        this.rttMax_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearStartTime() {
        this.startTime_ = null;
    }

    public static LivekitModels$RTPStats getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<Integer, Integer> getMutableGapHistogramMap() {
        return internalGetMutableGapHistogram();
    }

    private J internalGetGapHistogram() {
        return this.gapHistogram_;
    }

    private J internalGetMutableGapHistogram() {
        if (!this.gapHistogram_.n()) {
            this.gapHistogram_ = this.gapHistogram_.s();
        }
        return this.gapHistogram_;
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
    public void mergeLastFir(Timestamp timestamp) {
        timestamp.getClass();
        Timestamp timestamp2 = this.lastFir_;
        if (timestamp2 == null || timestamp2 == Timestamp.getDefaultInstance()) {
            this.lastFir_ = timestamp;
        } else {
            this.lastFir_ = (Timestamp) ((Timestamp.b) Timestamp.newBuilder(this.lastFir_).v(timestamp)).j();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeLastKeyFrame(Timestamp timestamp) {
        timestamp.getClass();
        Timestamp timestamp2 = this.lastKeyFrame_;
        if (timestamp2 == null || timestamp2 == Timestamp.getDefaultInstance()) {
            this.lastKeyFrame_ = timestamp;
        } else {
            this.lastKeyFrame_ = (Timestamp) ((Timestamp.b) Timestamp.newBuilder(this.lastKeyFrame_).v(timestamp)).j();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeLastLayerLockPli(Timestamp timestamp) {
        timestamp.getClass();
        Timestamp timestamp2 = this.lastLayerLockPli_;
        if (timestamp2 == null || timestamp2 == Timestamp.getDefaultInstance()) {
            this.lastLayerLockPli_ = timestamp;
        } else {
            this.lastLayerLockPli_ = (Timestamp) ((Timestamp.b) Timestamp.newBuilder(this.lastLayerLockPli_).v(timestamp)).j();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeLastPli(Timestamp timestamp) {
        timestamp.getClass();
        Timestamp timestamp2 = this.lastPli_;
        if (timestamp2 == null || timestamp2 == Timestamp.getDefaultInstance()) {
            this.lastPli_ = timestamp;
        } else {
            this.lastPli_ = (Timestamp) ((Timestamp.b) Timestamp.newBuilder(this.lastPli_).v(timestamp)).j();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeNtpReportDrift(LivekitModels$RTPDrift livekitModels$RTPDrift) {
        livekitModels$RTPDrift.getClass();
        LivekitModels$RTPDrift livekitModels$RTPDrift2 = this.ntpReportDrift_;
        if (livekitModels$RTPDrift2 == null || livekitModels$RTPDrift2 == LivekitModels$RTPDrift.getDefaultInstance()) {
            this.ntpReportDrift_ = livekitModels$RTPDrift;
        } else {
            this.ntpReportDrift_ = (LivekitModels$RTPDrift) ((LivekitModels$RTPDrift.a) LivekitModels$RTPDrift.newBuilder(this.ntpReportDrift_).v(livekitModels$RTPDrift)).j();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergePacketDrift(LivekitModels$RTPDrift livekitModels$RTPDrift) {
        livekitModels$RTPDrift.getClass();
        LivekitModels$RTPDrift livekitModels$RTPDrift2 = this.packetDrift_;
        if (livekitModels$RTPDrift2 == null || livekitModels$RTPDrift2 == LivekitModels$RTPDrift.getDefaultInstance()) {
            this.packetDrift_ = livekitModels$RTPDrift;
        } else {
            this.packetDrift_ = (LivekitModels$RTPDrift) ((LivekitModels$RTPDrift.a) LivekitModels$RTPDrift.newBuilder(this.packetDrift_).v(livekitModels$RTPDrift)).j();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeRebasedReportDrift(LivekitModels$RTPDrift livekitModels$RTPDrift) {
        livekitModels$RTPDrift.getClass();
        LivekitModels$RTPDrift livekitModels$RTPDrift2 = this.rebasedReportDrift_;
        if (livekitModels$RTPDrift2 == null || livekitModels$RTPDrift2 == LivekitModels$RTPDrift.getDefaultInstance()) {
            this.rebasedReportDrift_ = livekitModels$RTPDrift;
        } else {
            this.rebasedReportDrift_ = (LivekitModels$RTPDrift) ((LivekitModels$RTPDrift.a) LivekitModels$RTPDrift.newBuilder(this.rebasedReportDrift_).v(livekitModels$RTPDrift)).j();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeReceivedReportDrift(LivekitModels$RTPDrift livekitModels$RTPDrift) {
        livekitModels$RTPDrift.getClass();
        LivekitModels$RTPDrift livekitModels$RTPDrift2 = this.receivedReportDrift_;
        if (livekitModels$RTPDrift2 == null || livekitModels$RTPDrift2 == LivekitModels$RTPDrift.getDefaultInstance()) {
            this.receivedReportDrift_ = livekitModels$RTPDrift;
        } else {
            this.receivedReportDrift_ = (LivekitModels$RTPDrift) ((LivekitModels$RTPDrift.a) LivekitModels$RTPDrift.newBuilder(this.receivedReportDrift_).v(livekitModels$RTPDrift)).j();
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

    public static LivekitModels$RTPStats parseDelimitedFrom(InputStream inputStream) {
        return (LivekitModels$RTPStats) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitModels$RTPStats parseFrom(ByteBuffer byteBuffer) {
        return (LivekitModels$RTPStats) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBitrate(double d) {
        this.bitrate_ = d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBitrateDuplicate(double d) {
        this.bitrateDuplicate_ = d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBitratePadding(double d) {
        this.bitratePadding_ = d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBytes(long j) {
        this.bytes_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBytesDuplicate(long j) {
        this.bytesDuplicate_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBytesPadding(long j) {
        this.bytesPadding_ = j;
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
    public void setFirs(int i) {
        this.firs_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFrameRate(double d) {
        this.frameRate_ = d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFrames(int i) {
        this.frames_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHeaderBytes(long j) {
        this.headerBytes_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHeaderBytesDuplicate(long j) {
        this.headerBytesDuplicate_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHeaderBytesPadding(long j) {
        this.headerBytesPadding_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setJitterCurrent(double d) {
        this.jitterCurrent_ = d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setJitterMax(double d) {
        this.jitterMax_ = d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setKeyFrames(int i) {
        this.keyFrames_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLastFir(Timestamp timestamp) {
        timestamp.getClass();
        this.lastFir_ = timestamp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLastKeyFrame(Timestamp timestamp) {
        timestamp.getClass();
        this.lastKeyFrame_ = timestamp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLastLayerLockPli(Timestamp timestamp) {
        timestamp.getClass();
        this.lastLayerLockPli_ = timestamp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLastPli(Timestamp timestamp) {
        timestamp.getClass();
        this.lastPli_ = timestamp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLayerLockPlis(int i) {
        this.layerLockPlis_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNackAcks(int i) {
        this.nackAcks_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNackMisses(int i) {
        this.nackMisses_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNackRepeated(int i) {
        this.nackRepeated_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNacks(int i) {
        this.nacks_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNtpReportDrift(LivekitModels$RTPDrift livekitModels$RTPDrift) {
        livekitModels$RTPDrift.getClass();
        this.ntpReportDrift_ = livekitModels$RTPDrift;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPacketDrift(LivekitModels$RTPDrift livekitModels$RTPDrift) {
        livekitModels$RTPDrift.getClass();
        this.packetDrift_ = livekitModels$RTPDrift;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPacketDuplicateRate(double d) {
        this.packetDuplicateRate_ = d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPacketLossPercentage(float f) {
        this.packetLossPercentage_ = f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPacketLossRate(double d) {
        this.packetLossRate_ = d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPacketPaddingRate(double d) {
        this.packetPaddingRate_ = d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPacketRate(double d) {
        this.packetRate_ = d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPackets(int i) {
        this.packets_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPacketsDuplicate(int i) {
        this.packetsDuplicate_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPacketsLost(int i) {
        this.packetsLost_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPacketsOutOfOrder(int i) {
        this.packetsOutOfOrder_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPacketsPadding(int i) {
        this.packetsPadding_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPlis(int i) {
        this.plis_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRebasedReportDrift(LivekitModels$RTPDrift livekitModels$RTPDrift) {
        livekitModels$RTPDrift.getClass();
        this.rebasedReportDrift_ = livekitModels$RTPDrift;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setReceivedReportDrift(LivekitModels$RTPDrift livekitModels$RTPDrift) {
        livekitModels$RTPDrift.getClass();
        this.receivedReportDrift_ = livekitModels$RTPDrift;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRttCurrent(int i) {
        this.rttCurrent_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRttMax(int i) {
        this.rttMax_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStartTime(Timestamp timestamp) {
        timestamp.getClass();
        this.startTime_ = timestamp;
    }

    public boolean containsGapHistogram(int i) {
        return internalGetGapHistogram().containsKey(Integer.valueOf(i));
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        o oVar = null;
        switch (o.a[gVar.ordinal()]) {
            case 1:
                return new LivekitModels$RTPStats();
            case 2:
                return new a(oVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000-\u0000\u0000\u0001/-\u0001\u0000\u0000\u0001\t\u0002\t\u0003\u0000\u0004\u000b\u0005\u0000\u0006\u0003\u0007\u0000\b\u000b\t\u0000\n\u0001\u000b\u000b\f\u0000\r\u0003\u000e\u0000\u000f\u000b\u0010\u0000\u0011\u0003\u0012\u0000\u0013\u000b\u0014\u000b\u0015\u0000\u0016\u0000\u0017\u0000\u00182\u0019\u000b\u001a\u000b\u001b\u000b\u001c\t\u001d\u000b\u001e\t\u001f\u000b \u000b!\u000b\"\t#\u000b$\t%\u000b&\u000b'\u0003(\u0003)\u0003,\t-\t.\t/\t", new Object[]{"startTime_", "endTime_", "duration_", "packets_", "packetRate_", "bytes_", "bitrate_", "packetsLost_", "packetLossRate_", "packetLossPercentage_", "packetsDuplicate_", "packetDuplicateRate_", "bytesDuplicate_", "bitrateDuplicate_", "packetsPadding_", "packetPaddingRate_", "bytesPadding_", "bitratePadding_", "packetsOutOfOrder_", "frames_", "frameRate_", "jitterCurrent_", "jitterMax_", "gapHistogram_", b.a, "nacks_", "nackMisses_", "plis_", "lastPli_", "firs_", "lastFir_", "rttCurrent_", "rttMax_", "keyFrames_", "lastKeyFrame_", "layerLockPlis_", "lastLayerLockPli_", "nackAcks_", "nackRepeated_", "headerBytes_", "headerBytesDuplicate_", "headerBytesPadding_", "packetDrift_", "ntpReportDrift_", "rebasedReportDrift_", "receivedReportDrift_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitModels$RTPStats.class) {
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

    public double getBitrate() {
        return this.bitrate_;
    }

    public double getBitrateDuplicate() {
        return this.bitrateDuplicate_;
    }

    public double getBitratePadding() {
        return this.bitratePadding_;
    }

    public long getBytes() {
        return this.bytes_;
    }

    public long getBytesDuplicate() {
        return this.bytesDuplicate_;
    }

    public long getBytesPadding() {
        return this.bytesPadding_;
    }

    public double getDuration() {
        return this.duration_;
    }

    public Timestamp getEndTime() {
        Timestamp timestamp = this.endTime_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    public int getFirs() {
        return this.firs_;
    }

    public double getFrameRate() {
        return this.frameRate_;
    }

    public int getFrames() {
        return this.frames_;
    }

    @Deprecated
    public Map<Integer, Integer> getGapHistogram() {
        return getGapHistogramMap();
    }

    public int getGapHistogramCount() {
        return internalGetGapHistogram().size();
    }

    public Map<Integer, Integer> getGapHistogramMap() {
        return Collections.unmodifiableMap(internalGetGapHistogram());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int getGapHistogramOrDefault(int i, int i2) {
        J jInternalGetGapHistogram = internalGetGapHistogram();
        return jInternalGetGapHistogram.containsKey(Integer.valueOf(i)) ? ((Integer) jInternalGetGapHistogram.get(Integer.valueOf(i))).intValue() : i2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int getGapHistogramOrThrow(int i) {
        J jInternalGetGapHistogram = internalGetGapHistogram();
        if (jInternalGetGapHistogram.containsKey(Integer.valueOf(i))) {
            return ((Integer) jInternalGetGapHistogram.get(Integer.valueOf(i))).intValue();
        }
        throw new IllegalArgumentException();
    }

    public long getHeaderBytes() {
        return this.headerBytes_;
    }

    public long getHeaderBytesDuplicate() {
        return this.headerBytesDuplicate_;
    }

    public long getHeaderBytesPadding() {
        return this.headerBytesPadding_;
    }

    public double getJitterCurrent() {
        return this.jitterCurrent_;
    }

    public double getJitterMax() {
        return this.jitterMax_;
    }

    public int getKeyFrames() {
        return this.keyFrames_;
    }

    public Timestamp getLastFir() {
        Timestamp timestamp = this.lastFir_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    public Timestamp getLastKeyFrame() {
        Timestamp timestamp = this.lastKeyFrame_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    public Timestamp getLastLayerLockPli() {
        Timestamp timestamp = this.lastLayerLockPli_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    public Timestamp getLastPli() {
        Timestamp timestamp = this.lastPli_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    public int getLayerLockPlis() {
        return this.layerLockPlis_;
    }

    public int getNackAcks() {
        return this.nackAcks_;
    }

    public int getNackMisses() {
        return this.nackMisses_;
    }

    public int getNackRepeated() {
        return this.nackRepeated_;
    }

    public int getNacks() {
        return this.nacks_;
    }

    public LivekitModels$RTPDrift getNtpReportDrift() {
        LivekitModels$RTPDrift livekitModels$RTPDrift = this.ntpReportDrift_;
        return livekitModels$RTPDrift == null ? LivekitModels$RTPDrift.getDefaultInstance() : livekitModels$RTPDrift;
    }

    public LivekitModels$RTPDrift getPacketDrift() {
        LivekitModels$RTPDrift livekitModels$RTPDrift = this.packetDrift_;
        return livekitModels$RTPDrift == null ? LivekitModels$RTPDrift.getDefaultInstance() : livekitModels$RTPDrift;
    }

    public double getPacketDuplicateRate() {
        return this.packetDuplicateRate_;
    }

    public float getPacketLossPercentage() {
        return this.packetLossPercentage_;
    }

    public double getPacketLossRate() {
        return this.packetLossRate_;
    }

    public double getPacketPaddingRate() {
        return this.packetPaddingRate_;
    }

    public double getPacketRate() {
        return this.packetRate_;
    }

    public int getPackets() {
        return this.packets_;
    }

    public int getPacketsDuplicate() {
        return this.packetsDuplicate_;
    }

    public int getPacketsLost() {
        return this.packetsLost_;
    }

    public int getPacketsOutOfOrder() {
        return this.packetsOutOfOrder_;
    }

    public int getPacketsPadding() {
        return this.packetsPadding_;
    }

    public int getPlis() {
        return this.plis_;
    }

    public LivekitModels$RTPDrift getRebasedReportDrift() {
        LivekitModels$RTPDrift livekitModels$RTPDrift = this.rebasedReportDrift_;
        return livekitModels$RTPDrift == null ? LivekitModels$RTPDrift.getDefaultInstance() : livekitModels$RTPDrift;
    }

    public LivekitModels$RTPDrift getReceivedReportDrift() {
        LivekitModels$RTPDrift livekitModels$RTPDrift = this.receivedReportDrift_;
        return livekitModels$RTPDrift == null ? LivekitModels$RTPDrift.getDefaultInstance() : livekitModels$RTPDrift;
    }

    public int getRttCurrent() {
        return this.rttCurrent_;
    }

    public int getRttMax() {
        return this.rttMax_;
    }

    public Timestamp getStartTime() {
        Timestamp timestamp = this.startTime_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    public boolean hasEndTime() {
        return this.endTime_ != null;
    }

    public boolean hasLastFir() {
        return this.lastFir_ != null;
    }

    public boolean hasLastKeyFrame() {
        return this.lastKeyFrame_ != null;
    }

    public boolean hasLastLayerLockPli() {
        return this.lastLayerLockPli_ != null;
    }

    public boolean hasLastPli() {
        return this.lastPli_ != null;
    }

    public boolean hasNtpReportDrift() {
        return this.ntpReportDrift_ != null;
    }

    public boolean hasPacketDrift() {
        return this.packetDrift_ != null;
    }

    public boolean hasRebasedReportDrift() {
        return this.rebasedReportDrift_ != null;
    }

    public boolean hasReceivedReportDrift() {
        return this.receivedReportDrift_ != null;
    }

    public boolean hasStartTime() {
        return this.startTime_ != null;
    }

    public static a newBuilder(LivekitModels$RTPStats livekitModels$RTPStats) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitModels$RTPStats);
    }

    public static LivekitModels$RTPStats parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitModels$RTPStats) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitModels$RTPStats parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitModels$RTPStats) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitModels$RTPStats parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitModels$RTPStats) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitModels$RTPStats parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitModels$RTPStats) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitModels$RTPStats parseFrom(byte[] bArr) {
        return (LivekitModels$RTPStats) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitModels$RTPStats parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitModels$RTPStats) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitModels$RTPStats parseFrom(InputStream inputStream) {
        return (LivekitModels$RTPStats) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitModels$RTPStats parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitModels$RTPStats) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitModels$RTPStats parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitModels$RTPStats) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitModels$RTPStats parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitModels$RTPStats) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
