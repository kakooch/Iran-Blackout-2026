package livekit;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes8.dex */
public final class LivekitRtc$TrackUnpublishedResponse extends GeneratedMessageLite implements U64 {
    private static final LivekitRtc$TrackUnpublishedResponse DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int TRACK_SID_FIELD_NUMBER = 1;
    private String trackSid_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(s sVar) {
            this();
        }

        private a() {
            super(LivekitRtc$TrackUnpublishedResponse.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitRtc$TrackUnpublishedResponse livekitRtc$TrackUnpublishedResponse = new LivekitRtc$TrackUnpublishedResponse();
        DEFAULT_INSTANCE = livekitRtc$TrackUnpublishedResponse;
        GeneratedMessageLite.registerDefaultInstance(LivekitRtc$TrackUnpublishedResponse.class, livekitRtc$TrackUnpublishedResponse);
    }

    private LivekitRtc$TrackUnpublishedResponse() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTrackSid() {
        this.trackSid_ = getDefaultInstance().getTrackSid();
    }

    public static LivekitRtc$TrackUnpublishedResponse getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitRtc$TrackUnpublishedResponse parseDelimitedFrom(InputStream inputStream) {
        return (LivekitRtc$TrackUnpublishedResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitRtc$TrackUnpublishedResponse parseFrom(ByteBuffer byteBuffer) {
        return (LivekitRtc$TrackUnpublishedResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTrackSid(String str) {
        str.getClass();
        this.trackSid_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTrackSidBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.trackSid_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        s sVar = null;
        switch (s.a[gVar.ordinal()]) {
            case 1:
                return new LivekitRtc$TrackUnpublishedResponse();
            case 2:
                return new a(sVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"trackSid_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitRtc$TrackUnpublishedResponse.class) {
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

    public String getTrackSid() {
        return this.trackSid_;
    }

    public AbstractC2383g getTrackSidBytes() {
        return AbstractC2383g.N(this.trackSid_);
    }

    public static a newBuilder(LivekitRtc$TrackUnpublishedResponse livekitRtc$TrackUnpublishedResponse) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitRtc$TrackUnpublishedResponse);
    }

    public static LivekitRtc$TrackUnpublishedResponse parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitRtc$TrackUnpublishedResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitRtc$TrackUnpublishedResponse parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitRtc$TrackUnpublishedResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitRtc$TrackUnpublishedResponse parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitRtc$TrackUnpublishedResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitRtc$TrackUnpublishedResponse parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitRtc$TrackUnpublishedResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitRtc$TrackUnpublishedResponse parseFrom(byte[] bArr) {
        return (LivekitRtc$TrackUnpublishedResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitRtc$TrackUnpublishedResponse parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitRtc$TrackUnpublishedResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitRtc$TrackUnpublishedResponse parseFrom(InputStream inputStream) {
        return (LivekitRtc$TrackUnpublishedResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitRtc$TrackUnpublishedResponse parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitRtc$TrackUnpublishedResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitRtc$TrackUnpublishedResponse parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitRtc$TrackUnpublishedResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitRtc$TrackUnpublishedResponse parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitRtc$TrackUnpublishedResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
