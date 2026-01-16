package livekit;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC21856uF3;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;
import livekit.LivekitModels$TrackInfo;

/* loaded from: classes8.dex */
public final class LivekitRtc$TrackPublishedResponse extends GeneratedMessageLite implements InterfaceC21856uF3 {
    public static final int CID_FIELD_NUMBER = 1;
    private static final LivekitRtc$TrackPublishedResponse DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int TRACK_FIELD_NUMBER = 2;
    private String cid_ = "";
    private LivekitModels$TrackInfo track_;

    public static final class a extends GeneratedMessageLite.b implements InterfaceC21856uF3 {
        /* synthetic */ a(s sVar) {
            this();
        }

        public a A(String str) {
            q();
            ((LivekitRtc$TrackPublishedResponse) this.b).setCid(str);
            return this;
        }

        public a B(LivekitModels$TrackInfo livekitModels$TrackInfo) {
            q();
            ((LivekitRtc$TrackPublishedResponse) this.b).setTrack(livekitModels$TrackInfo);
            return this;
        }

        private a() {
            super(LivekitRtc$TrackPublishedResponse.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitRtc$TrackPublishedResponse livekitRtc$TrackPublishedResponse = new LivekitRtc$TrackPublishedResponse();
        DEFAULT_INSTANCE = livekitRtc$TrackPublishedResponse;
        GeneratedMessageLite.registerDefaultInstance(LivekitRtc$TrackPublishedResponse.class, livekitRtc$TrackPublishedResponse);
    }

    private LivekitRtc$TrackPublishedResponse() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCid() {
        this.cid_ = getDefaultInstance().getCid();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTrack() {
        this.track_ = null;
    }

    public static LivekitRtc$TrackPublishedResponse getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeTrack(LivekitModels$TrackInfo livekitModels$TrackInfo) {
        livekitModels$TrackInfo.getClass();
        LivekitModels$TrackInfo livekitModels$TrackInfo2 = this.track_;
        if (livekitModels$TrackInfo2 == null || livekitModels$TrackInfo2 == LivekitModels$TrackInfo.getDefaultInstance()) {
            this.track_ = livekitModels$TrackInfo;
        } else {
            this.track_ = (LivekitModels$TrackInfo) ((LivekitModels$TrackInfo.b) LivekitModels$TrackInfo.newBuilder(this.track_).v(livekitModels$TrackInfo)).j();
        }
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitRtc$TrackPublishedResponse parseDelimitedFrom(InputStream inputStream) {
        return (LivekitRtc$TrackPublishedResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitRtc$TrackPublishedResponse parseFrom(ByteBuffer byteBuffer) {
        return (LivekitRtc$TrackPublishedResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCid(String str) {
        str.getClass();
        this.cid_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCidBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.cid_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTrack(LivekitModels$TrackInfo livekitModels$TrackInfo) {
        livekitModels$TrackInfo.getClass();
        this.track_ = livekitModels$TrackInfo;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        s sVar = null;
        switch (s.a[gVar.ordinal()]) {
            case 1:
                return new LivekitRtc$TrackPublishedResponse();
            case 2:
                return new a(sVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002\t", new Object[]{"cid_", "track_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitRtc$TrackPublishedResponse.class) {
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

    public String getCid() {
        return this.cid_;
    }

    public AbstractC2383g getCidBytes() {
        return AbstractC2383g.N(this.cid_);
    }

    public LivekitModels$TrackInfo getTrack() {
        LivekitModels$TrackInfo livekitModels$TrackInfo = this.track_;
        return livekitModels$TrackInfo == null ? LivekitModels$TrackInfo.getDefaultInstance() : livekitModels$TrackInfo;
    }

    public boolean hasTrack() {
        return this.track_ != null;
    }

    public static a newBuilder(LivekitRtc$TrackPublishedResponse livekitRtc$TrackPublishedResponse) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitRtc$TrackPublishedResponse);
    }

    public static LivekitRtc$TrackPublishedResponse parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitRtc$TrackPublishedResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitRtc$TrackPublishedResponse parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitRtc$TrackPublishedResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitRtc$TrackPublishedResponse parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitRtc$TrackPublishedResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitRtc$TrackPublishedResponse parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitRtc$TrackPublishedResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitRtc$TrackPublishedResponse parseFrom(byte[] bArr) {
        return (LivekitRtc$TrackPublishedResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitRtc$TrackPublishedResponse parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitRtc$TrackPublishedResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitRtc$TrackPublishedResponse parseFrom(InputStream inputStream) {
        return (LivekitRtc$TrackPublishedResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitRtc$TrackPublishedResponse parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitRtc$TrackPublishedResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitRtc$TrackPublishedResponse parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitRtc$TrackPublishedResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitRtc$TrackPublishedResponse parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitRtc$TrackPublishedResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
