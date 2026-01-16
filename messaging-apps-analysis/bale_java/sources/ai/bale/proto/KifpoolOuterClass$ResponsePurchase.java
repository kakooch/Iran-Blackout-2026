package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class KifpoolOuterClass$ResponsePurchase extends GeneratedMessageLite implements U64 {
    private static final KifpoolOuterClass$ResponsePurchase DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(KifpoolOuterClass$ResponsePurchase.DEFAULT_INSTANCE);
        }
    }

    static {
        KifpoolOuterClass$ResponsePurchase kifpoolOuterClass$ResponsePurchase = new KifpoolOuterClass$ResponsePurchase();
        DEFAULT_INSTANCE = kifpoolOuterClass$ResponsePurchase;
        GeneratedMessageLite.registerDefaultInstance(KifpoolOuterClass$ResponsePurchase.class, kifpoolOuterClass$ResponsePurchase);
    }

    private KifpoolOuterClass$ResponsePurchase() {
    }

    public static KifpoolOuterClass$ResponsePurchase getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static KifpoolOuterClass$ResponsePurchase parseDelimitedFrom(InputStream inputStream) {
        return (KifpoolOuterClass$ResponsePurchase) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KifpoolOuterClass$ResponsePurchase parseFrom(ByteBuffer byteBuffer) {
        return (KifpoolOuterClass$ResponsePurchase) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1897u0.a[gVar.ordinal()]) {
            case 1:
                return new KifpoolOuterClass$ResponsePurchase();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0000", null);
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (KifpoolOuterClass$ResponsePurchase.class) {
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

    public static a newBuilder(KifpoolOuterClass$ResponsePurchase kifpoolOuterClass$ResponsePurchase) {
        return (a) DEFAULT_INSTANCE.createBuilder(kifpoolOuterClass$ResponsePurchase);
    }

    public static KifpoolOuterClass$ResponsePurchase parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (KifpoolOuterClass$ResponsePurchase) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KifpoolOuterClass$ResponsePurchase parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (KifpoolOuterClass$ResponsePurchase) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static KifpoolOuterClass$ResponsePurchase parseFrom(AbstractC2383g abstractC2383g) {
        return (KifpoolOuterClass$ResponsePurchase) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static KifpoolOuterClass$ResponsePurchase parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (KifpoolOuterClass$ResponsePurchase) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static KifpoolOuterClass$ResponsePurchase parseFrom(byte[] bArr) {
        return (KifpoolOuterClass$ResponsePurchase) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static KifpoolOuterClass$ResponsePurchase parseFrom(byte[] bArr, C2394s c2394s) {
        return (KifpoolOuterClass$ResponsePurchase) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static KifpoolOuterClass$ResponsePurchase parseFrom(InputStream inputStream) {
        return (KifpoolOuterClass$ResponsePurchase) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KifpoolOuterClass$ResponsePurchase parseFrom(InputStream inputStream, C2394s c2394s) {
        return (KifpoolOuterClass$ResponsePurchase) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KifpoolOuterClass$ResponsePurchase parseFrom(AbstractC2384h abstractC2384h) {
        return (KifpoolOuterClass$ResponsePurchase) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static KifpoolOuterClass$ResponsePurchase parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (KifpoolOuterClass$ResponsePurchase) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
