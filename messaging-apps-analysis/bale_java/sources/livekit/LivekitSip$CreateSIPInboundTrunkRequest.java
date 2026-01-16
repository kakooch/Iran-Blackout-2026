package livekit;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import livekit.LivekitSip$SIPInboundTrunkInfo;

/* loaded from: classes8.dex */
public final class LivekitSip$CreateSIPInboundTrunkRequest extends GeneratedMessageLite implements U64 {
    private static final LivekitSip$CreateSIPInboundTrunkRequest DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int TRUNK_FIELD_NUMBER = 1;
    private LivekitSip$SIPInboundTrunkInfo trunk_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(t tVar) {
            this();
        }

        private a() {
            super(LivekitSip$CreateSIPInboundTrunkRequest.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitSip$CreateSIPInboundTrunkRequest livekitSip$CreateSIPInboundTrunkRequest = new LivekitSip$CreateSIPInboundTrunkRequest();
        DEFAULT_INSTANCE = livekitSip$CreateSIPInboundTrunkRequest;
        GeneratedMessageLite.registerDefaultInstance(LivekitSip$CreateSIPInboundTrunkRequest.class, livekitSip$CreateSIPInboundTrunkRequest);
    }

    private LivekitSip$CreateSIPInboundTrunkRequest() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTrunk() {
        this.trunk_ = null;
    }

    public static LivekitSip$CreateSIPInboundTrunkRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeTrunk(LivekitSip$SIPInboundTrunkInfo livekitSip$SIPInboundTrunkInfo) {
        livekitSip$SIPInboundTrunkInfo.getClass();
        LivekitSip$SIPInboundTrunkInfo livekitSip$SIPInboundTrunkInfo2 = this.trunk_;
        if (livekitSip$SIPInboundTrunkInfo2 == null || livekitSip$SIPInboundTrunkInfo2 == LivekitSip$SIPInboundTrunkInfo.getDefaultInstance()) {
            this.trunk_ = livekitSip$SIPInboundTrunkInfo;
        } else {
            this.trunk_ = (LivekitSip$SIPInboundTrunkInfo) ((LivekitSip$SIPInboundTrunkInfo.b) LivekitSip$SIPInboundTrunkInfo.newBuilder(this.trunk_).v(livekitSip$SIPInboundTrunkInfo)).j();
        }
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitSip$CreateSIPInboundTrunkRequest parseDelimitedFrom(InputStream inputStream) {
        return (LivekitSip$CreateSIPInboundTrunkRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitSip$CreateSIPInboundTrunkRequest parseFrom(ByteBuffer byteBuffer) {
        return (LivekitSip$CreateSIPInboundTrunkRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTrunk(LivekitSip$SIPInboundTrunkInfo livekitSip$SIPInboundTrunkInfo) {
        livekitSip$SIPInboundTrunkInfo.getClass();
        this.trunk_ = livekitSip$SIPInboundTrunkInfo;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        t tVar = null;
        switch (t.a[gVar.ordinal()]) {
            case 1:
                return new LivekitSip$CreateSIPInboundTrunkRequest();
            case 2:
                return new a(tVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\t", new Object[]{"trunk_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitSip$CreateSIPInboundTrunkRequest.class) {
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

    public LivekitSip$SIPInboundTrunkInfo getTrunk() {
        LivekitSip$SIPInboundTrunkInfo livekitSip$SIPInboundTrunkInfo = this.trunk_;
        return livekitSip$SIPInboundTrunkInfo == null ? LivekitSip$SIPInboundTrunkInfo.getDefaultInstance() : livekitSip$SIPInboundTrunkInfo;
    }

    public boolean hasTrunk() {
        return this.trunk_ != null;
    }

    public static a newBuilder(LivekitSip$CreateSIPInboundTrunkRequest livekitSip$CreateSIPInboundTrunkRequest) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitSip$CreateSIPInboundTrunkRequest);
    }

    public static LivekitSip$CreateSIPInboundTrunkRequest parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitSip$CreateSIPInboundTrunkRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitSip$CreateSIPInboundTrunkRequest parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitSip$CreateSIPInboundTrunkRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitSip$CreateSIPInboundTrunkRequest parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitSip$CreateSIPInboundTrunkRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitSip$CreateSIPInboundTrunkRequest parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitSip$CreateSIPInboundTrunkRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitSip$CreateSIPInboundTrunkRequest parseFrom(byte[] bArr) {
        return (LivekitSip$CreateSIPInboundTrunkRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitSip$CreateSIPInboundTrunkRequest parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitSip$CreateSIPInboundTrunkRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitSip$CreateSIPInboundTrunkRequest parseFrom(InputStream inputStream) {
        return (LivekitSip$CreateSIPInboundTrunkRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitSip$CreateSIPInboundTrunkRequest parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitSip$CreateSIPInboundTrunkRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitSip$CreateSIPInboundTrunkRequest parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitSip$CreateSIPInboundTrunkRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitSip$CreateSIPInboundTrunkRequest parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitSip$CreateSIPInboundTrunkRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
