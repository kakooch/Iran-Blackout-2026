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
public final class LivekitEgress$StopEgressRequest extends GeneratedMessageLite implements U64 {
    private static final LivekitEgress$StopEgressRequest DEFAULT_INSTANCE;
    public static final int EGRESS_ID_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private String egressId_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(f fVar) {
            this();
        }

        private a() {
            super(LivekitEgress$StopEgressRequest.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitEgress$StopEgressRequest livekitEgress$StopEgressRequest = new LivekitEgress$StopEgressRequest();
        DEFAULT_INSTANCE = livekitEgress$StopEgressRequest;
        GeneratedMessageLite.registerDefaultInstance(LivekitEgress$StopEgressRequest.class, livekitEgress$StopEgressRequest);
    }

    private LivekitEgress$StopEgressRequest() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearEgressId() {
        this.egressId_ = getDefaultInstance().getEgressId();
    }

    public static LivekitEgress$StopEgressRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitEgress$StopEgressRequest parseDelimitedFrom(InputStream inputStream) {
        return (LivekitEgress$StopEgressRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitEgress$StopEgressRequest parseFrom(ByteBuffer byteBuffer) {
        return (LivekitEgress$StopEgressRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEgressId(String str) {
        str.getClass();
        this.egressId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEgressIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.egressId_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        f fVar = null;
        switch (f.a[gVar.ordinal()]) {
            case 1:
                return new LivekitEgress$StopEgressRequest();
            case 2:
                return new a(fVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"egressId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitEgress$StopEgressRequest.class) {
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

    public String getEgressId() {
        return this.egressId_;
    }

    public AbstractC2383g getEgressIdBytes() {
        return AbstractC2383g.N(this.egressId_);
    }

    public static a newBuilder(LivekitEgress$StopEgressRequest livekitEgress$StopEgressRequest) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitEgress$StopEgressRequest);
    }

    public static LivekitEgress$StopEgressRequest parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitEgress$StopEgressRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitEgress$StopEgressRequest parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitEgress$StopEgressRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitEgress$StopEgressRequest parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitEgress$StopEgressRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitEgress$StopEgressRequest parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitEgress$StopEgressRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitEgress$StopEgressRequest parseFrom(byte[] bArr) {
        return (LivekitEgress$StopEgressRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitEgress$StopEgressRequest parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitEgress$StopEgressRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitEgress$StopEgressRequest parseFrom(InputStream inputStream) {
        return (LivekitEgress$StopEgressRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitEgress$StopEgressRequest parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitEgress$StopEgressRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitEgress$StopEgressRequest parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitEgress$StopEgressRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitEgress$StopEgressRequest parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitEgress$StopEgressRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
