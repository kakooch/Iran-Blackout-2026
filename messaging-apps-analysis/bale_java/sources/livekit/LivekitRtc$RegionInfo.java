package livekit;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC17015mF3;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes8.dex */
public final class LivekitRtc$RegionInfo extends GeneratedMessageLite implements InterfaceC17015mF3 {
    private static final LivekitRtc$RegionInfo DEFAULT_INSTANCE;
    public static final int DISTANCE_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER = null;
    public static final int REGION_FIELD_NUMBER = 1;
    public static final int URL_FIELD_NUMBER = 2;
    private long distance_;
    private String region_ = "";
    private String url_ = "";

    public static final class a extends GeneratedMessageLite.b implements InterfaceC17015mF3 {
        /* synthetic */ a(s sVar) {
            this();
        }

        private a() {
            super(LivekitRtc$RegionInfo.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitRtc$RegionInfo livekitRtc$RegionInfo = new LivekitRtc$RegionInfo();
        DEFAULT_INSTANCE = livekitRtc$RegionInfo;
        GeneratedMessageLite.registerDefaultInstance(LivekitRtc$RegionInfo.class, livekitRtc$RegionInfo);
    }

    private LivekitRtc$RegionInfo() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDistance() {
        this.distance_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRegion() {
        this.region_ = getDefaultInstance().getRegion();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearUrl() {
        this.url_ = getDefaultInstance().getUrl();
    }

    public static LivekitRtc$RegionInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitRtc$RegionInfo parseDelimitedFrom(InputStream inputStream) {
        return (LivekitRtc$RegionInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitRtc$RegionInfo parseFrom(ByteBuffer byteBuffer) {
        return (LivekitRtc$RegionInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDistance(long j) {
        this.distance_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRegion(String str) {
        str.getClass();
        this.region_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRegionBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.region_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUrl(String str) {
        str.getClass();
        this.url_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUrlBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.url_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        s sVar = null;
        switch (s.a[gVar.ordinal()]) {
            case 1:
                return new LivekitRtc$RegionInfo();
            case 2:
                return new a(sVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\u0002", new Object[]{"region_", "url_", "distance_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitRtc$RegionInfo.class) {
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

    public long getDistance() {
        return this.distance_;
    }

    public String getRegion() {
        return this.region_;
    }

    public AbstractC2383g getRegionBytes() {
        return AbstractC2383g.N(this.region_);
    }

    public String getUrl() {
        return this.url_;
    }

    public AbstractC2383g getUrlBytes() {
        return AbstractC2383g.N(this.url_);
    }

    public static a newBuilder(LivekitRtc$RegionInfo livekitRtc$RegionInfo) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitRtc$RegionInfo);
    }

    public static LivekitRtc$RegionInfo parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitRtc$RegionInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitRtc$RegionInfo parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitRtc$RegionInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitRtc$RegionInfo parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitRtc$RegionInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitRtc$RegionInfo parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitRtc$RegionInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitRtc$RegionInfo parseFrom(byte[] bArr) {
        return (LivekitRtc$RegionInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitRtc$RegionInfo parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitRtc$RegionInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitRtc$RegionInfo parseFrom(InputStream inputStream) {
        return (LivekitRtc$RegionInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitRtc$RegionInfo parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitRtc$RegionInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitRtc$RegionInfo parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitRtc$RegionInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitRtc$RegionInfo parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitRtc$RegionInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
