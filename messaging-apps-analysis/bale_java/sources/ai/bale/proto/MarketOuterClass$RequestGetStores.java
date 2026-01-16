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
public final class MarketOuterClass$RequestGetStores extends GeneratedMessageLite implements U64 {
    private static final MarketOuterClass$RequestGetStores DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int VERSION_FIELD_NUMBER = 1;
    private int version_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MarketOuterClass$RequestGetStores.DEFAULT_INSTANCE);
        }
    }

    static {
        MarketOuterClass$RequestGetStores marketOuterClass$RequestGetStores = new MarketOuterClass$RequestGetStores();
        DEFAULT_INSTANCE = marketOuterClass$RequestGetStores;
        GeneratedMessageLite.registerDefaultInstance(MarketOuterClass$RequestGetStores.class, marketOuterClass$RequestGetStores);
    }

    private MarketOuterClass$RequestGetStores() {
    }

    private void clearVersion() {
        this.version_ = 0;
    }

    public static MarketOuterClass$RequestGetStores getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MarketOuterClass$RequestGetStores parseDelimitedFrom(InputStream inputStream) {
        return (MarketOuterClass$RequestGetStores) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MarketOuterClass$RequestGetStores parseFrom(ByteBuffer byteBuffer) {
        return (MarketOuterClass$RequestGetStores) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setVersion(int i) {
        this.version_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (C0.a[gVar.ordinal()]) {
            case 1:
                return new MarketOuterClass$RequestGetStores();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0004", new Object[]{"version_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MarketOuterClass$RequestGetStores.class) {
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

    public int getVersion() {
        return this.version_;
    }

    public static a newBuilder(MarketOuterClass$RequestGetStores marketOuterClass$RequestGetStores) {
        return (a) DEFAULT_INSTANCE.createBuilder(marketOuterClass$RequestGetStores);
    }

    public static MarketOuterClass$RequestGetStores parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MarketOuterClass$RequestGetStores) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MarketOuterClass$RequestGetStores parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MarketOuterClass$RequestGetStores) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MarketOuterClass$RequestGetStores parseFrom(AbstractC2383g abstractC2383g) {
        return (MarketOuterClass$RequestGetStores) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MarketOuterClass$RequestGetStores parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MarketOuterClass$RequestGetStores) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MarketOuterClass$RequestGetStores parseFrom(byte[] bArr) {
        return (MarketOuterClass$RequestGetStores) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MarketOuterClass$RequestGetStores parseFrom(byte[] bArr, C2394s c2394s) {
        return (MarketOuterClass$RequestGetStores) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MarketOuterClass$RequestGetStores parseFrom(InputStream inputStream) {
        return (MarketOuterClass$RequestGetStores) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MarketOuterClass$RequestGetStores parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MarketOuterClass$RequestGetStores) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MarketOuterClass$RequestGetStores parseFrom(AbstractC2384h abstractC2384h) {
        return (MarketOuterClass$RequestGetStores) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MarketOuterClass$RequestGetStores parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MarketOuterClass$RequestGetStores) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
