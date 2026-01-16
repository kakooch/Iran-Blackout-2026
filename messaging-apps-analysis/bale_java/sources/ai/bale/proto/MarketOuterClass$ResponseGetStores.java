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
public final class MarketOuterClass$ResponseGetStores extends GeneratedMessageLite implements U64 {
    private static final MarketOuterClass$ResponseGetStores DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int STORES_FIELD_NUMBER = 1;
    public static final int VERSION_FIELD_NUMBER = 2;
    private String stores_ = "";
    private int version_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MarketOuterClass$ResponseGetStores.DEFAULT_INSTANCE);
        }
    }

    static {
        MarketOuterClass$ResponseGetStores marketOuterClass$ResponseGetStores = new MarketOuterClass$ResponseGetStores();
        DEFAULT_INSTANCE = marketOuterClass$ResponseGetStores;
        GeneratedMessageLite.registerDefaultInstance(MarketOuterClass$ResponseGetStores.class, marketOuterClass$ResponseGetStores);
    }

    private MarketOuterClass$ResponseGetStores() {
    }

    private void clearStores() {
        this.stores_ = getDefaultInstance().getStores();
    }

    private void clearVersion() {
        this.version_ = 0;
    }

    public static MarketOuterClass$ResponseGetStores getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MarketOuterClass$ResponseGetStores parseDelimitedFrom(InputStream inputStream) {
        return (MarketOuterClass$ResponseGetStores) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MarketOuterClass$ResponseGetStores parseFrom(ByteBuffer byteBuffer) {
        return (MarketOuterClass$ResponseGetStores) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setStores(String str) {
        str.getClass();
        this.stores_ = str;
    }

    private void setStoresBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.stores_ = abstractC2383g.f0();
    }

    private void setVersion(int i) {
        this.version_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (C0.a[gVar.ordinal()]) {
            case 1:
                return new MarketOuterClass$ResponseGetStores();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002\u0004", new Object[]{"stores_", "version_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MarketOuterClass$ResponseGetStores.class) {
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

    public String getStores() {
        return this.stores_;
    }

    public AbstractC2383g getStoresBytes() {
        return AbstractC2383g.N(this.stores_);
    }

    public int getVersion() {
        return this.version_;
    }

    public static a newBuilder(MarketOuterClass$ResponseGetStores marketOuterClass$ResponseGetStores) {
        return (a) DEFAULT_INSTANCE.createBuilder(marketOuterClass$ResponseGetStores);
    }

    public static MarketOuterClass$ResponseGetStores parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MarketOuterClass$ResponseGetStores) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MarketOuterClass$ResponseGetStores parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MarketOuterClass$ResponseGetStores) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MarketOuterClass$ResponseGetStores parseFrom(AbstractC2383g abstractC2383g) {
        return (MarketOuterClass$ResponseGetStores) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MarketOuterClass$ResponseGetStores parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MarketOuterClass$ResponseGetStores) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MarketOuterClass$ResponseGetStores parseFrom(byte[] bArr) {
        return (MarketOuterClass$ResponseGetStores) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MarketOuterClass$ResponseGetStores parseFrom(byte[] bArr, C2394s c2394s) {
        return (MarketOuterClass$ResponseGetStores) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MarketOuterClass$ResponseGetStores parseFrom(InputStream inputStream) {
        return (MarketOuterClass$ResponseGetStores) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MarketOuterClass$ResponseGetStores parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MarketOuterClass$ResponseGetStores) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MarketOuterClass$ResponseGetStores parseFrom(AbstractC2384h abstractC2384h) {
        return (MarketOuterClass$ResponseGetStores) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MarketOuterClass$ResponseGetStores parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MarketOuterClass$ResponseGetStores) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
