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
public final class MarketOuterClass$ResponseGetNumberOfSales extends GeneratedMessageLite implements U64 {
    private static final MarketOuterClass$ResponseGetNumberOfSales DEFAULT_INSTANCE;
    public static final int IS_MARKET_FIELD_NUMBER = 2;
    public static final int NUMBER_OF_SALES_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private boolean isMarket_;
    private long numberOfSales_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MarketOuterClass$ResponseGetNumberOfSales.DEFAULT_INSTANCE);
        }
    }

    static {
        MarketOuterClass$ResponseGetNumberOfSales marketOuterClass$ResponseGetNumberOfSales = new MarketOuterClass$ResponseGetNumberOfSales();
        DEFAULT_INSTANCE = marketOuterClass$ResponseGetNumberOfSales;
        GeneratedMessageLite.registerDefaultInstance(MarketOuterClass$ResponseGetNumberOfSales.class, marketOuterClass$ResponseGetNumberOfSales);
    }

    private MarketOuterClass$ResponseGetNumberOfSales() {
    }

    private void clearIsMarket() {
        this.isMarket_ = false;
    }

    private void clearNumberOfSales() {
        this.numberOfSales_ = 0L;
    }

    public static MarketOuterClass$ResponseGetNumberOfSales getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MarketOuterClass$ResponseGetNumberOfSales parseDelimitedFrom(InputStream inputStream) {
        return (MarketOuterClass$ResponseGetNumberOfSales) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MarketOuterClass$ResponseGetNumberOfSales parseFrom(ByteBuffer byteBuffer) {
        return (MarketOuterClass$ResponseGetNumberOfSales) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setIsMarket(boolean z) {
        this.isMarket_ = z;
    }

    private void setNumberOfSales(long j) {
        this.numberOfSales_ = j;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (C0.a[gVar.ordinal()]) {
            case 1:
                return new MarketOuterClass$ResponseGetNumberOfSales();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0002\u0002\u0007", new Object[]{"numberOfSales_", "isMarket_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MarketOuterClass$ResponseGetNumberOfSales.class) {
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

    public boolean getIsMarket() {
        return this.isMarket_;
    }

    public long getNumberOfSales() {
        return this.numberOfSales_;
    }

    public static a newBuilder(MarketOuterClass$ResponseGetNumberOfSales marketOuterClass$ResponseGetNumberOfSales) {
        return (a) DEFAULT_INSTANCE.createBuilder(marketOuterClass$ResponseGetNumberOfSales);
    }

    public static MarketOuterClass$ResponseGetNumberOfSales parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MarketOuterClass$ResponseGetNumberOfSales) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MarketOuterClass$ResponseGetNumberOfSales parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MarketOuterClass$ResponseGetNumberOfSales) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MarketOuterClass$ResponseGetNumberOfSales parseFrom(AbstractC2383g abstractC2383g) {
        return (MarketOuterClass$ResponseGetNumberOfSales) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MarketOuterClass$ResponseGetNumberOfSales parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MarketOuterClass$ResponseGetNumberOfSales) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MarketOuterClass$ResponseGetNumberOfSales parseFrom(byte[] bArr) {
        return (MarketOuterClass$ResponseGetNumberOfSales) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MarketOuterClass$ResponseGetNumberOfSales parseFrom(byte[] bArr, C2394s c2394s) {
        return (MarketOuterClass$ResponseGetNumberOfSales) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MarketOuterClass$ResponseGetNumberOfSales parseFrom(InputStream inputStream) {
        return (MarketOuterClass$ResponseGetNumberOfSales) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MarketOuterClass$ResponseGetNumberOfSales parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MarketOuterClass$ResponseGetNumberOfSales) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MarketOuterClass$ResponseGetNumberOfSales parseFrom(AbstractC2384h abstractC2384h) {
        return (MarketOuterClass$ResponseGetNumberOfSales) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MarketOuterClass$ResponseGetNumberOfSales parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MarketOuterClass$ResponseGetNumberOfSales) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
