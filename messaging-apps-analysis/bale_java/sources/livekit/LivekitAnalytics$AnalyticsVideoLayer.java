package livekit;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC12215eE3;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes8.dex */
public final class LivekitAnalytics$AnalyticsVideoLayer extends GeneratedMessageLite implements InterfaceC12215eE3 {
    public static final int BYTES_FIELD_NUMBER = 3;
    private static final LivekitAnalytics$AnalyticsVideoLayer DEFAULT_INSTANCE;
    public static final int FRAMES_FIELD_NUMBER = 4;
    public static final int LAYER_FIELD_NUMBER = 1;
    public static final int PACKETS_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER;
    private long bytes_;
    private int frames_;
    private int layer_;
    private int packets_;

    public static final class a extends GeneratedMessageLite.b implements InterfaceC12215eE3 {
        /* synthetic */ a(c cVar) {
            this();
        }

        private a() {
            super(LivekitAnalytics$AnalyticsVideoLayer.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitAnalytics$AnalyticsVideoLayer livekitAnalytics$AnalyticsVideoLayer = new LivekitAnalytics$AnalyticsVideoLayer();
        DEFAULT_INSTANCE = livekitAnalytics$AnalyticsVideoLayer;
        GeneratedMessageLite.registerDefaultInstance(LivekitAnalytics$AnalyticsVideoLayer.class, livekitAnalytics$AnalyticsVideoLayer);
    }

    private LivekitAnalytics$AnalyticsVideoLayer() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearBytes() {
        this.bytes_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearFrames() {
        this.frames_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearLayer() {
        this.layer_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPackets() {
        this.packets_ = 0;
    }

    public static LivekitAnalytics$AnalyticsVideoLayer getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitAnalytics$AnalyticsVideoLayer parseDelimitedFrom(InputStream inputStream) {
        return (LivekitAnalytics$AnalyticsVideoLayer) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitAnalytics$AnalyticsVideoLayer parseFrom(ByteBuffer byteBuffer) {
        return (LivekitAnalytics$AnalyticsVideoLayer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBytes(long j) {
        this.bytes_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFrames(int i) {
        this.frames_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLayer(int i) {
        this.layer_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPackets(int i) {
        this.packets_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        c cVar = null;
        switch (c.a[gVar.ordinal()]) {
            case 1:
                return new LivekitAnalytics$AnalyticsVideoLayer();
            case 2:
                return new a(cVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u0004\u0002\u000b\u0003\u0003\u0004\u000b", new Object[]{"layer_", "packets_", "bytes_", "frames_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar2 = PARSER;
                if (cVar2 == null) {
                    synchronized (LivekitAnalytics$AnalyticsVideoLayer.class) {
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

    public long getBytes() {
        return this.bytes_;
    }

    public int getFrames() {
        return this.frames_;
    }

    public int getLayer() {
        return this.layer_;
    }

    public int getPackets() {
        return this.packets_;
    }

    public static a newBuilder(LivekitAnalytics$AnalyticsVideoLayer livekitAnalytics$AnalyticsVideoLayer) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitAnalytics$AnalyticsVideoLayer);
    }

    public static LivekitAnalytics$AnalyticsVideoLayer parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitAnalytics$AnalyticsVideoLayer) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitAnalytics$AnalyticsVideoLayer parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitAnalytics$AnalyticsVideoLayer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitAnalytics$AnalyticsVideoLayer parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitAnalytics$AnalyticsVideoLayer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitAnalytics$AnalyticsVideoLayer parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitAnalytics$AnalyticsVideoLayer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitAnalytics$AnalyticsVideoLayer parseFrom(byte[] bArr) {
        return (LivekitAnalytics$AnalyticsVideoLayer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitAnalytics$AnalyticsVideoLayer parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitAnalytics$AnalyticsVideoLayer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitAnalytics$AnalyticsVideoLayer parseFrom(InputStream inputStream) {
        return (LivekitAnalytics$AnalyticsVideoLayer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitAnalytics$AnalyticsVideoLayer parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitAnalytics$AnalyticsVideoLayer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitAnalytics$AnalyticsVideoLayer parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitAnalytics$AnalyticsVideoLayer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitAnalytics$AnalyticsVideoLayer parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitAnalytics$AnalyticsVideoLayer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
