package livekit;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.UE3;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes8.dex */
public final class LivekitModels$RTCPSenderReportState extends GeneratedMessageLite implements UE3 {
    public static final int AT_ADJUSTED_FIELD_NUMBER = 5;
    public static final int AT_FIELD_NUMBER = 4;
    private static final LivekitModels$RTCPSenderReportState DEFAULT_INSTANCE;
    public static final int NTP_TIMESTAMP_FIELD_NUMBER = 3;
    public static final int OCTETS_FIELD_NUMBER = 7;
    public static final int PACKETS_FIELD_NUMBER = 6;
    private static volatile KW4 PARSER = null;
    public static final int RTP_TIMESTAMP_EXT_FIELD_NUMBER = 2;
    public static final int RTP_TIMESTAMP_FIELD_NUMBER = 1;
    private long atAdjusted_;
    private long at_;
    private long ntpTimestamp_;
    private long octets_;
    private int packets_;
    private long rtpTimestampExt_;
    private int rtpTimestamp_;

    public static final class a extends GeneratedMessageLite.b implements UE3 {
        /* synthetic */ a(o oVar) {
            this();
        }

        private a() {
            super(LivekitModels$RTCPSenderReportState.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitModels$RTCPSenderReportState livekitModels$RTCPSenderReportState = new LivekitModels$RTCPSenderReportState();
        DEFAULT_INSTANCE = livekitModels$RTCPSenderReportState;
        GeneratedMessageLite.registerDefaultInstance(LivekitModels$RTCPSenderReportState.class, livekitModels$RTCPSenderReportState);
    }

    private LivekitModels$RTCPSenderReportState() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAt() {
        this.at_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAtAdjusted() {
        this.atAdjusted_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearNtpTimestamp() {
        this.ntpTimestamp_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearOctets() {
        this.octets_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPackets() {
        this.packets_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRtpTimestamp() {
        this.rtpTimestamp_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRtpTimestampExt() {
        this.rtpTimestampExt_ = 0L;
    }

    public static LivekitModels$RTCPSenderReportState getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitModels$RTCPSenderReportState parseDelimitedFrom(InputStream inputStream) {
        return (LivekitModels$RTCPSenderReportState) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitModels$RTCPSenderReportState parseFrom(ByteBuffer byteBuffer) {
        return (LivekitModels$RTCPSenderReportState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAt(long j) {
        this.at_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAtAdjusted(long j) {
        this.atAdjusted_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNtpTimestamp(long j) {
        this.ntpTimestamp_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOctets(long j) {
        this.octets_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPackets(int i) {
        this.packets_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRtpTimestamp(int i) {
        this.rtpTimestamp_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRtpTimestampExt(long j) {
        this.rtpTimestampExt_ = j;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        o oVar = null;
        switch (o.a[gVar.ordinal()]) {
            case 1:
                return new LivekitModels$RTCPSenderReportState();
            case 2:
                return new a(oVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0007\u0000\u0000\u0001\u0007\u0007\u0000\u0000\u0000\u0001\u000b\u0002\u0003\u0003\u0003\u0004\u0002\u0005\u0002\u0006\u000b\u0007\u0003", new Object[]{"rtpTimestamp_", "rtpTimestampExt_", "ntpTimestamp_", "at_", "atAdjusted_", "packets_", "octets_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitModels$RTCPSenderReportState.class) {
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

    public long getAt() {
        return this.at_;
    }

    public long getAtAdjusted() {
        return this.atAdjusted_;
    }

    public long getNtpTimestamp() {
        return this.ntpTimestamp_;
    }

    public long getOctets() {
        return this.octets_;
    }

    public int getPackets() {
        return this.packets_;
    }

    public int getRtpTimestamp() {
        return this.rtpTimestamp_;
    }

    public long getRtpTimestampExt() {
        return this.rtpTimestampExt_;
    }

    public static a newBuilder(LivekitModels$RTCPSenderReportState livekitModels$RTCPSenderReportState) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitModels$RTCPSenderReportState);
    }

    public static LivekitModels$RTCPSenderReportState parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitModels$RTCPSenderReportState) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitModels$RTCPSenderReportState parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitModels$RTCPSenderReportState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitModels$RTCPSenderReportState parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitModels$RTCPSenderReportState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitModels$RTCPSenderReportState parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitModels$RTCPSenderReportState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitModels$RTCPSenderReportState parseFrom(byte[] bArr) {
        return (LivekitModels$RTCPSenderReportState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitModels$RTCPSenderReportState parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitModels$RTCPSenderReportState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitModels$RTCPSenderReportState parseFrom(InputStream inputStream) {
        return (LivekitModels$RTCPSenderReportState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitModels$RTCPSenderReportState parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitModels$RTCPSenderReportState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitModels$RTCPSenderReportState parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitModels$RTCPSenderReportState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitModels$RTCPSenderReportState parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitModels$RTCPSenderReportState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
