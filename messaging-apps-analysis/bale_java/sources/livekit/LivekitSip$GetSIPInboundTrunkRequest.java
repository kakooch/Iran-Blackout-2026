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
public final class LivekitSip$GetSIPInboundTrunkRequest extends GeneratedMessageLite implements U64 {
    private static final LivekitSip$GetSIPInboundTrunkRequest DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int SIP_TRUNK_ID_FIELD_NUMBER = 1;
    private String sipTrunkId_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(t tVar) {
            this();
        }

        private a() {
            super(LivekitSip$GetSIPInboundTrunkRequest.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitSip$GetSIPInboundTrunkRequest livekitSip$GetSIPInboundTrunkRequest = new LivekitSip$GetSIPInboundTrunkRequest();
        DEFAULT_INSTANCE = livekitSip$GetSIPInboundTrunkRequest;
        GeneratedMessageLite.registerDefaultInstance(LivekitSip$GetSIPInboundTrunkRequest.class, livekitSip$GetSIPInboundTrunkRequest);
    }

    private LivekitSip$GetSIPInboundTrunkRequest() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSipTrunkId() {
        this.sipTrunkId_ = getDefaultInstance().getSipTrunkId();
    }

    public static LivekitSip$GetSIPInboundTrunkRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitSip$GetSIPInboundTrunkRequest parseDelimitedFrom(InputStream inputStream) {
        return (LivekitSip$GetSIPInboundTrunkRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitSip$GetSIPInboundTrunkRequest parseFrom(ByteBuffer byteBuffer) {
        return (LivekitSip$GetSIPInboundTrunkRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSipTrunkId(String str) {
        str.getClass();
        this.sipTrunkId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSipTrunkIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.sipTrunkId_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        t tVar = null;
        switch (t.a[gVar.ordinal()]) {
            case 1:
                return new LivekitSip$GetSIPInboundTrunkRequest();
            case 2:
                return new a(tVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"sipTrunkId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitSip$GetSIPInboundTrunkRequest.class) {
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

    public String getSipTrunkId() {
        return this.sipTrunkId_;
    }

    public AbstractC2383g getSipTrunkIdBytes() {
        return AbstractC2383g.N(this.sipTrunkId_);
    }

    public static a newBuilder(LivekitSip$GetSIPInboundTrunkRequest livekitSip$GetSIPInboundTrunkRequest) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitSip$GetSIPInboundTrunkRequest);
    }

    public static LivekitSip$GetSIPInboundTrunkRequest parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitSip$GetSIPInboundTrunkRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitSip$GetSIPInboundTrunkRequest parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitSip$GetSIPInboundTrunkRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitSip$GetSIPInboundTrunkRequest parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitSip$GetSIPInboundTrunkRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitSip$GetSIPInboundTrunkRequest parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitSip$GetSIPInboundTrunkRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitSip$GetSIPInboundTrunkRequest parseFrom(byte[] bArr) {
        return (LivekitSip$GetSIPInboundTrunkRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitSip$GetSIPInboundTrunkRequest parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitSip$GetSIPInboundTrunkRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitSip$GetSIPInboundTrunkRequest parseFrom(InputStream inputStream) {
        return (LivekitSip$GetSIPInboundTrunkRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitSip$GetSIPInboundTrunkRequest parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitSip$GetSIPInboundTrunkRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitSip$GetSIPInboundTrunkRequest parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitSip$GetSIPInboundTrunkRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitSip$GetSIPInboundTrunkRequest parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitSip$GetSIPInboundTrunkRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
