package livekit;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import livekit.LivekitSip$SIPOutboundTrunkInfo;

/* loaded from: classes8.dex */
public final class LivekitSip$CreateSIPOutboundTrunkRequest extends GeneratedMessageLite implements U64 {
    private static final LivekitSip$CreateSIPOutboundTrunkRequest DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int TRUNK_FIELD_NUMBER = 1;
    private LivekitSip$SIPOutboundTrunkInfo trunk_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(t tVar) {
            this();
        }

        private a() {
            super(LivekitSip$CreateSIPOutboundTrunkRequest.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitSip$CreateSIPOutboundTrunkRequest livekitSip$CreateSIPOutboundTrunkRequest = new LivekitSip$CreateSIPOutboundTrunkRequest();
        DEFAULT_INSTANCE = livekitSip$CreateSIPOutboundTrunkRequest;
        GeneratedMessageLite.registerDefaultInstance(LivekitSip$CreateSIPOutboundTrunkRequest.class, livekitSip$CreateSIPOutboundTrunkRequest);
    }

    private LivekitSip$CreateSIPOutboundTrunkRequest() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTrunk() {
        this.trunk_ = null;
    }

    public static LivekitSip$CreateSIPOutboundTrunkRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeTrunk(LivekitSip$SIPOutboundTrunkInfo livekitSip$SIPOutboundTrunkInfo) {
        livekitSip$SIPOutboundTrunkInfo.getClass();
        LivekitSip$SIPOutboundTrunkInfo livekitSip$SIPOutboundTrunkInfo2 = this.trunk_;
        if (livekitSip$SIPOutboundTrunkInfo2 == null || livekitSip$SIPOutboundTrunkInfo2 == LivekitSip$SIPOutboundTrunkInfo.getDefaultInstance()) {
            this.trunk_ = livekitSip$SIPOutboundTrunkInfo;
        } else {
            this.trunk_ = (LivekitSip$SIPOutboundTrunkInfo) ((LivekitSip$SIPOutboundTrunkInfo.b) LivekitSip$SIPOutboundTrunkInfo.newBuilder(this.trunk_).v(livekitSip$SIPOutboundTrunkInfo)).j();
        }
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitSip$CreateSIPOutboundTrunkRequest parseDelimitedFrom(InputStream inputStream) {
        return (LivekitSip$CreateSIPOutboundTrunkRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitSip$CreateSIPOutboundTrunkRequest parseFrom(ByteBuffer byteBuffer) {
        return (LivekitSip$CreateSIPOutboundTrunkRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTrunk(LivekitSip$SIPOutboundTrunkInfo livekitSip$SIPOutboundTrunkInfo) {
        livekitSip$SIPOutboundTrunkInfo.getClass();
        this.trunk_ = livekitSip$SIPOutboundTrunkInfo;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        t tVar = null;
        switch (t.a[gVar.ordinal()]) {
            case 1:
                return new LivekitSip$CreateSIPOutboundTrunkRequest();
            case 2:
                return new a(tVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\t", new Object[]{"trunk_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitSip$CreateSIPOutboundTrunkRequest.class) {
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

    public LivekitSip$SIPOutboundTrunkInfo getTrunk() {
        LivekitSip$SIPOutboundTrunkInfo livekitSip$SIPOutboundTrunkInfo = this.trunk_;
        return livekitSip$SIPOutboundTrunkInfo == null ? LivekitSip$SIPOutboundTrunkInfo.getDefaultInstance() : livekitSip$SIPOutboundTrunkInfo;
    }

    public boolean hasTrunk() {
        return this.trunk_ != null;
    }

    public static a newBuilder(LivekitSip$CreateSIPOutboundTrunkRequest livekitSip$CreateSIPOutboundTrunkRequest) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitSip$CreateSIPOutboundTrunkRequest);
    }

    public static LivekitSip$CreateSIPOutboundTrunkRequest parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitSip$CreateSIPOutboundTrunkRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitSip$CreateSIPOutboundTrunkRequest parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitSip$CreateSIPOutboundTrunkRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitSip$CreateSIPOutboundTrunkRequest parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitSip$CreateSIPOutboundTrunkRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitSip$CreateSIPOutboundTrunkRequest parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitSip$CreateSIPOutboundTrunkRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitSip$CreateSIPOutboundTrunkRequest parseFrom(byte[] bArr) {
        return (LivekitSip$CreateSIPOutboundTrunkRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitSip$CreateSIPOutboundTrunkRequest parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitSip$CreateSIPOutboundTrunkRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitSip$CreateSIPOutboundTrunkRequest parseFrom(InputStream inputStream) {
        return (LivekitSip$CreateSIPOutboundTrunkRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitSip$CreateSIPOutboundTrunkRequest parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitSip$CreateSIPOutboundTrunkRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitSip$CreateSIPOutboundTrunkRequest parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitSip$CreateSIPOutboundTrunkRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitSip$CreateSIPOutboundTrunkRequest parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitSip$CreateSIPOutboundTrunkRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
