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
public final class LivekitSip$GetSIPOutboundTrunkResponse extends GeneratedMessageLite implements U64 {
    private static final LivekitSip$GetSIPOutboundTrunkResponse DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int TRUNK_FIELD_NUMBER = 1;
    private LivekitSip$SIPOutboundTrunkInfo trunk_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(t tVar) {
            this();
        }

        private a() {
            super(LivekitSip$GetSIPOutboundTrunkResponse.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitSip$GetSIPOutboundTrunkResponse livekitSip$GetSIPOutboundTrunkResponse = new LivekitSip$GetSIPOutboundTrunkResponse();
        DEFAULT_INSTANCE = livekitSip$GetSIPOutboundTrunkResponse;
        GeneratedMessageLite.registerDefaultInstance(LivekitSip$GetSIPOutboundTrunkResponse.class, livekitSip$GetSIPOutboundTrunkResponse);
    }

    private LivekitSip$GetSIPOutboundTrunkResponse() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTrunk() {
        this.trunk_ = null;
    }

    public static LivekitSip$GetSIPOutboundTrunkResponse getDefaultInstance() {
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

    public static LivekitSip$GetSIPOutboundTrunkResponse parseDelimitedFrom(InputStream inputStream) {
        return (LivekitSip$GetSIPOutboundTrunkResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitSip$GetSIPOutboundTrunkResponse parseFrom(ByteBuffer byteBuffer) {
        return (LivekitSip$GetSIPOutboundTrunkResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
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
                return new LivekitSip$GetSIPOutboundTrunkResponse();
            case 2:
                return new a(tVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\t", new Object[]{"trunk_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitSip$GetSIPOutboundTrunkResponse.class) {
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

    public static a newBuilder(LivekitSip$GetSIPOutboundTrunkResponse livekitSip$GetSIPOutboundTrunkResponse) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitSip$GetSIPOutboundTrunkResponse);
    }

    public static LivekitSip$GetSIPOutboundTrunkResponse parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitSip$GetSIPOutboundTrunkResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitSip$GetSIPOutboundTrunkResponse parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitSip$GetSIPOutboundTrunkResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitSip$GetSIPOutboundTrunkResponse parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitSip$GetSIPOutboundTrunkResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitSip$GetSIPOutboundTrunkResponse parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitSip$GetSIPOutboundTrunkResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitSip$GetSIPOutboundTrunkResponse parseFrom(byte[] bArr) {
        return (LivekitSip$GetSIPOutboundTrunkResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitSip$GetSIPOutboundTrunkResponse parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitSip$GetSIPOutboundTrunkResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitSip$GetSIPOutboundTrunkResponse parseFrom(InputStream inputStream) {
        return (LivekitSip$GetSIPOutboundTrunkResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitSip$GetSIPOutboundTrunkResponse parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitSip$GetSIPOutboundTrunkResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitSip$GetSIPOutboundTrunkResponse parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitSip$GetSIPOutboundTrunkResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitSip$GetSIPOutboundTrunkResponse parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitSip$GetSIPOutboundTrunkResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
