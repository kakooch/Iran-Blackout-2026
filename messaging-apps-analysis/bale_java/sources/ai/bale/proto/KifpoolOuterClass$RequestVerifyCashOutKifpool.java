package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class KifpoolOuterClass$RequestVerifyCashOutKifpool extends GeneratedMessageLite implements U64 {
    private static final KifpoolOuterClass$RequestVerifyCashOutKifpool DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int TOKEN_FIELD_NUMBER = 1;
    private String token_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(KifpoolOuterClass$RequestVerifyCashOutKifpool.DEFAULT_INSTANCE);
        }
    }

    static {
        KifpoolOuterClass$RequestVerifyCashOutKifpool kifpoolOuterClass$RequestVerifyCashOutKifpool = new KifpoolOuterClass$RequestVerifyCashOutKifpool();
        DEFAULT_INSTANCE = kifpoolOuterClass$RequestVerifyCashOutKifpool;
        GeneratedMessageLite.registerDefaultInstance(KifpoolOuterClass$RequestVerifyCashOutKifpool.class, kifpoolOuterClass$RequestVerifyCashOutKifpool);
    }

    private KifpoolOuterClass$RequestVerifyCashOutKifpool() {
    }

    private void clearToken() {
        this.token_ = getDefaultInstance().getToken();
    }

    public static KifpoolOuterClass$RequestVerifyCashOutKifpool getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static KifpoolOuterClass$RequestVerifyCashOutKifpool parseDelimitedFrom(InputStream inputStream) {
        return (KifpoolOuterClass$RequestVerifyCashOutKifpool) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KifpoolOuterClass$RequestVerifyCashOutKifpool parseFrom(ByteBuffer byteBuffer) {
        return (KifpoolOuterClass$RequestVerifyCashOutKifpool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setToken(String str) {
        str.getClass();
        this.token_ = str;
    }

    private void setTokenBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.token_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1897u0.a[gVar.ordinal()]) {
            case 1:
                return new KifpoolOuterClass$RequestVerifyCashOutKifpool();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"token_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (KifpoolOuterClass$RequestVerifyCashOutKifpool.class) {
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

    public String getToken() {
        return this.token_;
    }

    public AbstractC2383g getTokenBytes() {
        return AbstractC2383g.N(this.token_);
    }

    public static a newBuilder(KifpoolOuterClass$RequestVerifyCashOutKifpool kifpoolOuterClass$RequestVerifyCashOutKifpool) {
        return (a) DEFAULT_INSTANCE.createBuilder(kifpoolOuterClass$RequestVerifyCashOutKifpool);
    }

    public static KifpoolOuterClass$RequestVerifyCashOutKifpool parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (KifpoolOuterClass$RequestVerifyCashOutKifpool) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KifpoolOuterClass$RequestVerifyCashOutKifpool parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (KifpoolOuterClass$RequestVerifyCashOutKifpool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static KifpoolOuterClass$RequestVerifyCashOutKifpool parseFrom(AbstractC2383g abstractC2383g) {
        return (KifpoolOuterClass$RequestVerifyCashOutKifpool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static KifpoolOuterClass$RequestVerifyCashOutKifpool parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (KifpoolOuterClass$RequestVerifyCashOutKifpool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static KifpoolOuterClass$RequestVerifyCashOutKifpool parseFrom(byte[] bArr) {
        return (KifpoolOuterClass$RequestVerifyCashOutKifpool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static KifpoolOuterClass$RequestVerifyCashOutKifpool parseFrom(byte[] bArr, C2394s c2394s) {
        return (KifpoolOuterClass$RequestVerifyCashOutKifpool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static KifpoolOuterClass$RequestVerifyCashOutKifpool parseFrom(InputStream inputStream) {
        return (KifpoolOuterClass$RequestVerifyCashOutKifpool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KifpoolOuterClass$RequestVerifyCashOutKifpool parseFrom(InputStream inputStream, C2394s c2394s) {
        return (KifpoolOuterClass$RequestVerifyCashOutKifpool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KifpoolOuterClass$RequestVerifyCashOutKifpool parseFrom(AbstractC2384h abstractC2384h) {
        return (KifpoolOuterClass$RequestVerifyCashOutKifpool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static KifpoolOuterClass$RequestVerifyCashOutKifpool parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (KifpoolOuterClass$RequestVerifyCashOutKifpool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
