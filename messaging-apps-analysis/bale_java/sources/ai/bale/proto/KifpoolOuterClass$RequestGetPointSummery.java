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
public final class KifpoolOuterClass$RequestGetPointSummery extends GeneratedMessageLite implements U64 {
    private static final KifpoolOuterClass$RequestGetPointSummery DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int TOKEN_FIELD_NUMBER = 1;
    private String token_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(KifpoolOuterClass$RequestGetPointSummery.DEFAULT_INSTANCE);
        }
    }

    static {
        KifpoolOuterClass$RequestGetPointSummery kifpoolOuterClass$RequestGetPointSummery = new KifpoolOuterClass$RequestGetPointSummery();
        DEFAULT_INSTANCE = kifpoolOuterClass$RequestGetPointSummery;
        GeneratedMessageLite.registerDefaultInstance(KifpoolOuterClass$RequestGetPointSummery.class, kifpoolOuterClass$RequestGetPointSummery);
    }

    private KifpoolOuterClass$RequestGetPointSummery() {
    }

    private void clearToken() {
        this.token_ = getDefaultInstance().getToken();
    }

    public static KifpoolOuterClass$RequestGetPointSummery getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static KifpoolOuterClass$RequestGetPointSummery parseDelimitedFrom(InputStream inputStream) {
        return (KifpoolOuterClass$RequestGetPointSummery) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KifpoolOuterClass$RequestGetPointSummery parseFrom(ByteBuffer byteBuffer) {
        return (KifpoolOuterClass$RequestGetPointSummery) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
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
                return new KifpoolOuterClass$RequestGetPointSummery();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"token_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (KifpoolOuterClass$RequestGetPointSummery.class) {
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

    public static a newBuilder(KifpoolOuterClass$RequestGetPointSummery kifpoolOuterClass$RequestGetPointSummery) {
        return (a) DEFAULT_INSTANCE.createBuilder(kifpoolOuterClass$RequestGetPointSummery);
    }

    public static KifpoolOuterClass$RequestGetPointSummery parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (KifpoolOuterClass$RequestGetPointSummery) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KifpoolOuterClass$RequestGetPointSummery parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (KifpoolOuterClass$RequestGetPointSummery) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static KifpoolOuterClass$RequestGetPointSummery parseFrom(AbstractC2383g abstractC2383g) {
        return (KifpoolOuterClass$RequestGetPointSummery) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static KifpoolOuterClass$RequestGetPointSummery parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (KifpoolOuterClass$RequestGetPointSummery) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static KifpoolOuterClass$RequestGetPointSummery parseFrom(byte[] bArr) {
        return (KifpoolOuterClass$RequestGetPointSummery) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static KifpoolOuterClass$RequestGetPointSummery parseFrom(byte[] bArr, C2394s c2394s) {
        return (KifpoolOuterClass$RequestGetPointSummery) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static KifpoolOuterClass$RequestGetPointSummery parseFrom(InputStream inputStream) {
        return (KifpoolOuterClass$RequestGetPointSummery) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KifpoolOuterClass$RequestGetPointSummery parseFrom(InputStream inputStream, C2394s c2394s) {
        return (KifpoolOuterClass$RequestGetPointSummery) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KifpoolOuterClass$RequestGetPointSummery parseFrom(AbstractC2384h abstractC2384h) {
        return (KifpoolOuterClass$RequestGetPointSummery) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static KifpoolOuterClass$RequestGetPointSummery parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (KifpoolOuterClass$RequestGetPointSummery) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
