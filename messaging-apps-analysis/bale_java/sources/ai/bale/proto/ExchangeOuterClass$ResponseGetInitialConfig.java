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
public final class ExchangeOuterClass$ResponseGetInitialConfig extends GeneratedMessageLite implements U64 {
    private static final ExchangeOuterClass$ResponseGetInitialConfig DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(ExchangeOuterClass$ResponseGetInitialConfig.DEFAULT_INSTANCE);
        }
    }

    static {
        ExchangeOuterClass$ResponseGetInitialConfig exchangeOuterClass$ResponseGetInitialConfig = new ExchangeOuterClass$ResponseGetInitialConfig();
        DEFAULT_INSTANCE = exchangeOuterClass$ResponseGetInitialConfig;
        GeneratedMessageLite.registerDefaultInstance(ExchangeOuterClass$ResponseGetInitialConfig.class, exchangeOuterClass$ResponseGetInitialConfig);
    }

    private ExchangeOuterClass$ResponseGetInitialConfig() {
    }

    public static ExchangeOuterClass$ResponseGetInitialConfig getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static ExchangeOuterClass$ResponseGetInitialConfig parseDelimitedFrom(InputStream inputStream) {
        return (ExchangeOuterClass$ResponseGetInitialConfig) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ExchangeOuterClass$ResponseGetInitialConfig parseFrom(ByteBuffer byteBuffer) {
        return (ExchangeOuterClass$ResponseGetInitialConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (U.a[gVar.ordinal()]) {
            case 1:
                return new ExchangeOuterClass$ResponseGetInitialConfig();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0000", null);
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (ExchangeOuterClass$ResponseGetInitialConfig.class) {
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

    public static a newBuilder(ExchangeOuterClass$ResponseGetInitialConfig exchangeOuterClass$ResponseGetInitialConfig) {
        return (a) DEFAULT_INSTANCE.createBuilder(exchangeOuterClass$ResponseGetInitialConfig);
    }

    public static ExchangeOuterClass$ResponseGetInitialConfig parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (ExchangeOuterClass$ResponseGetInitialConfig) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static ExchangeOuterClass$ResponseGetInitialConfig parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (ExchangeOuterClass$ResponseGetInitialConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static ExchangeOuterClass$ResponseGetInitialConfig parseFrom(AbstractC2383g abstractC2383g) {
        return (ExchangeOuterClass$ResponseGetInitialConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static ExchangeOuterClass$ResponseGetInitialConfig parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (ExchangeOuterClass$ResponseGetInitialConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static ExchangeOuterClass$ResponseGetInitialConfig parseFrom(byte[] bArr) {
        return (ExchangeOuterClass$ResponseGetInitialConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static ExchangeOuterClass$ResponseGetInitialConfig parseFrom(byte[] bArr, C2394s c2394s) {
        return (ExchangeOuterClass$ResponseGetInitialConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static ExchangeOuterClass$ResponseGetInitialConfig parseFrom(InputStream inputStream) {
        return (ExchangeOuterClass$ResponseGetInitialConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ExchangeOuterClass$ResponseGetInitialConfig parseFrom(InputStream inputStream, C2394s c2394s) {
        return (ExchangeOuterClass$ResponseGetInitialConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static ExchangeOuterClass$ResponseGetInitialConfig parseFrom(AbstractC2384h abstractC2384h) {
        return (ExchangeOuterClass$ResponseGetInitialConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static ExchangeOuterClass$ResponseGetInitialConfig parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (ExchangeOuterClass$ResponseGetInitialConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
