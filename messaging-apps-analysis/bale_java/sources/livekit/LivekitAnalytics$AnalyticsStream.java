package livekit;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Timestamp;
import ir.nasim.InterfaceC11572dE3;
import ir.nasim.InterfaceC12215eE3;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes8.dex */
public final class LivekitAnalytics$AnalyticsStream extends GeneratedMessageLite implements InterfaceC11572dE3 {
    private static final LivekitAnalytics$AnalyticsStream DEFAULT_INSTANCE;
    public static final int END_TIME_FIELD_NUMBER = 18;
    public static final int FIRS_FIELD_NUMBER = 14;
    public static final int FRAMES_FIELD_NUMBER = 9;
    public static final int JITTER_FIELD_NUMBER = 11;
    public static final int NACKS_FIELD_NUMBER = 12;
    public static final int PACKETS_LOST_FIELD_NUMBER = 8;
    public static final int PACKETS_OUT_OF_ORDER_FIELD_NUMBER = 19;
    public static final int PADDING_BYTES_FIELD_NUMBER = 7;
    public static final int PADDING_PACKETS_FIELD_NUMBER = 6;
    private static volatile KW4 PARSER = null;
    public static final int PLIS_FIELD_NUMBER = 13;
    public static final int PRIMARY_BYTES_FIELD_NUMBER = 3;
    public static final int PRIMARY_PACKETS_FIELD_NUMBER = 2;
    public static final int RETRANSMIT_BYTES_FIELD_NUMBER = 5;
    public static final int RETRANSMIT_PACKETS_FIELD_NUMBER = 4;
    public static final int RTT_FIELD_NUMBER = 10;
    public static final int SSRC_FIELD_NUMBER = 1;
    public static final int START_TIME_FIELD_NUMBER = 17;
    public static final int VIDEO_LAYERS_FIELD_NUMBER = 15;
    private Timestamp endTime_;
    private int firs_;
    private int frames_;
    private int jitter_;
    private int nacks_;
    private int packetsLost_;
    private int packetsOutOfOrder_;
    private long paddingBytes_;
    private int paddingPackets_;
    private int plis_;
    private long primaryBytes_;
    private int primaryPackets_;
    private long retransmitBytes_;
    private int retransmitPackets_;
    private int rtt_;
    private int ssrc_;
    private Timestamp startTime_;
    private B.j videoLayers_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements InterfaceC11572dE3 {
        /* synthetic */ a(c cVar) {
            this();
        }

        private a() {
            super(LivekitAnalytics$AnalyticsStream.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitAnalytics$AnalyticsStream livekitAnalytics$AnalyticsStream = new LivekitAnalytics$AnalyticsStream();
        DEFAULT_INSTANCE = livekitAnalytics$AnalyticsStream;
        GeneratedMessageLite.registerDefaultInstance(LivekitAnalytics$AnalyticsStream.class, livekitAnalytics$AnalyticsStream);
    }

    private LivekitAnalytics$AnalyticsStream() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllVideoLayers(Iterable<? extends LivekitAnalytics$AnalyticsVideoLayer> iterable) {
        ensureVideoLayersIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.videoLayers_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addVideoLayers(LivekitAnalytics$AnalyticsVideoLayer livekitAnalytics$AnalyticsVideoLayer) {
        livekitAnalytics$AnalyticsVideoLayer.getClass();
        ensureVideoLayersIsMutable();
        this.videoLayers_.add(livekitAnalytics$AnalyticsVideoLayer);
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
    public void clearFrames() {
        this.frames_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearJitter() {
        this.jitter_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearNacks() {
        this.nacks_ = 0;
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
    public void clearPaddingBytes() {
        this.paddingBytes_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPaddingPackets() {
        this.paddingPackets_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPlis() {
        this.plis_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPrimaryBytes() {
        this.primaryBytes_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPrimaryPackets() {
        this.primaryPackets_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRetransmitBytes() {
        this.retransmitBytes_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRetransmitPackets() {
        this.retransmitPackets_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRtt() {
        this.rtt_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSsrc() {
        this.ssrc_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearStartTime() {
        this.startTime_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearVideoLayers() {
        this.videoLayers_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureVideoLayersIsMutable() {
        B.j jVar = this.videoLayers_;
        if (jVar.u()) {
            return;
        }
        this.videoLayers_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static LivekitAnalytics$AnalyticsStream getDefaultInstance() {
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

    public static LivekitAnalytics$AnalyticsStream parseDelimitedFrom(InputStream inputStream) {
        return (LivekitAnalytics$AnalyticsStream) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitAnalytics$AnalyticsStream parseFrom(ByteBuffer byteBuffer) {
        return (LivekitAnalytics$AnalyticsStream) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeVideoLayers(int i) {
        ensureVideoLayersIsMutable();
        this.videoLayers_.remove(i);
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
    public void setFrames(int i) {
        this.frames_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setJitter(int i) {
        this.jitter_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNacks(int i) {
        this.nacks_ = i;
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
    public void setPaddingBytes(long j) {
        this.paddingBytes_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPaddingPackets(int i) {
        this.paddingPackets_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPlis(int i) {
        this.plis_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPrimaryBytes(long j) {
        this.primaryBytes_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPrimaryPackets(int i) {
        this.primaryPackets_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRetransmitBytes(long j) {
        this.retransmitBytes_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRetransmitPackets(int i) {
        this.retransmitPackets_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRtt(int i) {
        this.rtt_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSsrc(int i) {
        this.ssrc_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStartTime(Timestamp timestamp) {
        timestamp.getClass();
        this.startTime_ = timestamp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVideoLayers(int i, LivekitAnalytics$AnalyticsVideoLayer livekitAnalytics$AnalyticsVideoLayer) {
        livekitAnalytics$AnalyticsVideoLayer.getClass();
        ensureVideoLayersIsMutable();
        this.videoLayers_.set(i, livekitAnalytics$AnalyticsVideoLayer);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        c cVar = null;
        switch (c.a[gVar.ordinal()]) {
            case 1:
                return new LivekitAnalytics$AnalyticsStream();
            case 2:
                return new a(cVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0012\u0000\u0000\u0001\u0013\u0012\u0000\u0001\u0000\u0001\u000b\u0002\u000b\u0003\u0003\u0004\u000b\u0005\u0003\u0006\u000b\u0007\u0003\b\u000b\t\u000b\n\u000b\u000b\u000b\f\u000b\r\u000b\u000e\u000b\u000f\u001b\u0011\t\u0012\t\u0013\u000b", new Object[]{"ssrc_", "primaryPackets_", "primaryBytes_", "retransmitPackets_", "retransmitBytes_", "paddingPackets_", "paddingBytes_", "packetsLost_", "frames_", "rtt_", "jitter_", "nacks_", "plis_", "firs_", "videoLayers_", LivekitAnalytics$AnalyticsVideoLayer.class, "startTime_", "endTime_", "packetsOutOfOrder_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar2 = PARSER;
                if (cVar2 == null) {
                    synchronized (LivekitAnalytics$AnalyticsStream.class) {
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

    public Timestamp getEndTime() {
        Timestamp timestamp = this.endTime_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    public int getFirs() {
        return this.firs_;
    }

    public int getFrames() {
        return this.frames_;
    }

    public int getJitter() {
        return this.jitter_;
    }

    public int getNacks() {
        return this.nacks_;
    }

    public int getPacketsLost() {
        return this.packetsLost_;
    }

    public int getPacketsOutOfOrder() {
        return this.packetsOutOfOrder_;
    }

    public long getPaddingBytes() {
        return this.paddingBytes_;
    }

    public int getPaddingPackets() {
        return this.paddingPackets_;
    }

    public int getPlis() {
        return this.plis_;
    }

    public long getPrimaryBytes() {
        return this.primaryBytes_;
    }

    public int getPrimaryPackets() {
        return this.primaryPackets_;
    }

    public long getRetransmitBytes() {
        return this.retransmitBytes_;
    }

    public int getRetransmitPackets() {
        return this.retransmitPackets_;
    }

    public int getRtt() {
        return this.rtt_;
    }

    public int getSsrc() {
        return this.ssrc_;
    }

    public Timestamp getStartTime() {
        Timestamp timestamp = this.startTime_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    public LivekitAnalytics$AnalyticsVideoLayer getVideoLayers(int i) {
        return (LivekitAnalytics$AnalyticsVideoLayer) this.videoLayers_.get(i);
    }

    public int getVideoLayersCount() {
        return this.videoLayers_.size();
    }

    public List<LivekitAnalytics$AnalyticsVideoLayer> getVideoLayersList() {
        return this.videoLayers_;
    }

    public InterfaceC12215eE3 getVideoLayersOrBuilder(int i) {
        return (InterfaceC12215eE3) this.videoLayers_.get(i);
    }

    public List<? extends InterfaceC12215eE3> getVideoLayersOrBuilderList() {
        return this.videoLayers_;
    }

    public boolean hasEndTime() {
        return this.endTime_ != null;
    }

    public boolean hasStartTime() {
        return this.startTime_ != null;
    }

    public static a newBuilder(LivekitAnalytics$AnalyticsStream livekitAnalytics$AnalyticsStream) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitAnalytics$AnalyticsStream);
    }

    public static LivekitAnalytics$AnalyticsStream parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitAnalytics$AnalyticsStream) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitAnalytics$AnalyticsStream parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitAnalytics$AnalyticsStream) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitAnalytics$AnalyticsStream parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitAnalytics$AnalyticsStream) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addVideoLayers(int i, LivekitAnalytics$AnalyticsVideoLayer livekitAnalytics$AnalyticsVideoLayer) {
        livekitAnalytics$AnalyticsVideoLayer.getClass();
        ensureVideoLayersIsMutable();
        this.videoLayers_.add(i, livekitAnalytics$AnalyticsVideoLayer);
    }

    public static LivekitAnalytics$AnalyticsStream parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitAnalytics$AnalyticsStream) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitAnalytics$AnalyticsStream parseFrom(byte[] bArr) {
        return (LivekitAnalytics$AnalyticsStream) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitAnalytics$AnalyticsStream parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitAnalytics$AnalyticsStream) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitAnalytics$AnalyticsStream parseFrom(InputStream inputStream) {
        return (LivekitAnalytics$AnalyticsStream) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitAnalytics$AnalyticsStream parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitAnalytics$AnalyticsStream) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitAnalytics$AnalyticsStream parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitAnalytics$AnalyticsStream) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitAnalytics$AnalyticsStream parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitAnalytics$AnalyticsStream) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
