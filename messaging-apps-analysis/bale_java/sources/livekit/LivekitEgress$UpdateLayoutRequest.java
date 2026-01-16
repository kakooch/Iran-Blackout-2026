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
public final class LivekitEgress$UpdateLayoutRequest extends GeneratedMessageLite implements U64 {
    private static final LivekitEgress$UpdateLayoutRequest DEFAULT_INSTANCE;
    public static final int EGRESS_ID_FIELD_NUMBER = 1;
    public static final int LAYOUT_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER;
    private String egressId_ = "";
    private String layout_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(f fVar) {
            this();
        }

        private a() {
            super(LivekitEgress$UpdateLayoutRequest.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitEgress$UpdateLayoutRequest livekitEgress$UpdateLayoutRequest = new LivekitEgress$UpdateLayoutRequest();
        DEFAULT_INSTANCE = livekitEgress$UpdateLayoutRequest;
        GeneratedMessageLite.registerDefaultInstance(LivekitEgress$UpdateLayoutRequest.class, livekitEgress$UpdateLayoutRequest);
    }

    private LivekitEgress$UpdateLayoutRequest() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearEgressId() {
        this.egressId_ = getDefaultInstance().getEgressId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearLayout() {
        this.layout_ = getDefaultInstance().getLayout();
    }

    public static LivekitEgress$UpdateLayoutRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitEgress$UpdateLayoutRequest parseDelimitedFrom(InputStream inputStream) {
        return (LivekitEgress$UpdateLayoutRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitEgress$UpdateLayoutRequest parseFrom(ByteBuffer byteBuffer) {
        return (LivekitEgress$UpdateLayoutRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void setLayout(String str) {
        str.getClass();
        this.layout_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLayoutBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.layout_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        f fVar = null;
        switch (f.a[gVar.ordinal()]) {
            case 1:
                return new LivekitEgress$UpdateLayoutRequest();
            case 2:
                return new a(fVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ", new Object[]{"egressId_", "layout_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitEgress$UpdateLayoutRequest.class) {
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

    public String getLayout() {
        return this.layout_;
    }

    public AbstractC2383g getLayoutBytes() {
        return AbstractC2383g.N(this.layout_);
    }

    public static a newBuilder(LivekitEgress$UpdateLayoutRequest livekitEgress$UpdateLayoutRequest) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitEgress$UpdateLayoutRequest);
    }

    public static LivekitEgress$UpdateLayoutRequest parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitEgress$UpdateLayoutRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitEgress$UpdateLayoutRequest parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitEgress$UpdateLayoutRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitEgress$UpdateLayoutRequest parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitEgress$UpdateLayoutRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitEgress$UpdateLayoutRequest parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitEgress$UpdateLayoutRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitEgress$UpdateLayoutRequest parseFrom(byte[] bArr) {
        return (LivekitEgress$UpdateLayoutRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitEgress$UpdateLayoutRequest parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitEgress$UpdateLayoutRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitEgress$UpdateLayoutRequest parseFrom(InputStream inputStream) {
        return (LivekitEgress$UpdateLayoutRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitEgress$UpdateLayoutRequest parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitEgress$UpdateLayoutRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitEgress$UpdateLayoutRequest parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitEgress$UpdateLayoutRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitEgress$UpdateLayoutRequest parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitEgress$UpdateLayoutRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
