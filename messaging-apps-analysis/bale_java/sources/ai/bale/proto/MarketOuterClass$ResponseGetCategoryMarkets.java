package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.GT3;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class MarketOuterClass$ResponseGetCategoryMarkets extends GeneratedMessageLite implements U64 {
    private static final MarketOuterClass$ResponseGetCategoryMarkets DEFAULT_INSTANCE;
    public static final int MARKETS_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int VERSION_FIELD_NUMBER = 2;
    private B.j markets_ = GeneratedMessageLite.emptyProtobufList();
    private int version_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MarketOuterClass$ResponseGetCategoryMarkets.DEFAULT_INSTANCE);
        }
    }

    static {
        MarketOuterClass$ResponseGetCategoryMarkets marketOuterClass$ResponseGetCategoryMarkets = new MarketOuterClass$ResponseGetCategoryMarkets();
        DEFAULT_INSTANCE = marketOuterClass$ResponseGetCategoryMarkets;
        GeneratedMessageLite.registerDefaultInstance(MarketOuterClass$ResponseGetCategoryMarkets.class, marketOuterClass$ResponseGetCategoryMarkets);
    }

    private MarketOuterClass$ResponseGetCategoryMarkets() {
    }

    private void addAllMarkets(Iterable<? extends MarketStruct$MarketItem> iterable) {
        ensureMarketsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.markets_);
    }

    private void addMarkets(MarketStruct$MarketItem marketStruct$MarketItem) {
        marketStruct$MarketItem.getClass();
        ensureMarketsIsMutable();
        this.markets_.add(marketStruct$MarketItem);
    }

    private void clearMarkets() {
        this.markets_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearVersion() {
        this.version_ = 0;
    }

    private void ensureMarketsIsMutable() {
        B.j jVar = this.markets_;
        if (jVar.u()) {
            return;
        }
        this.markets_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static MarketOuterClass$ResponseGetCategoryMarkets getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MarketOuterClass$ResponseGetCategoryMarkets parseDelimitedFrom(InputStream inputStream) {
        return (MarketOuterClass$ResponseGetCategoryMarkets) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MarketOuterClass$ResponseGetCategoryMarkets parseFrom(ByteBuffer byteBuffer) {
        return (MarketOuterClass$ResponseGetCategoryMarkets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeMarkets(int i) {
        ensureMarketsIsMutable();
        this.markets_.remove(i);
    }

    private void setMarkets(int i, MarketStruct$MarketItem marketStruct$MarketItem) {
        marketStruct$MarketItem.getClass();
        ensureMarketsIsMutable();
        this.markets_.set(i, marketStruct$MarketItem);
    }

    private void setVersion(int i) {
        this.version_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (C0.a[gVar.ordinal()]) {
            case 1:
                return new MarketOuterClass$ResponseGetCategoryMarkets();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001b\u0002\u0004", new Object[]{"markets_", MarketStruct$MarketItem.class, "version_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MarketOuterClass$ResponseGetCategoryMarkets.class) {
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

    public MarketStruct$MarketItem getMarkets(int i) {
        return (MarketStruct$MarketItem) this.markets_.get(i);
    }

    public int getMarketsCount() {
        return this.markets_.size();
    }

    public List<MarketStruct$MarketItem> getMarketsList() {
        return this.markets_;
    }

    public GT3 getMarketsOrBuilder(int i) {
        return (GT3) this.markets_.get(i);
    }

    public List<? extends GT3> getMarketsOrBuilderList() {
        return this.markets_;
    }

    public int getVersion() {
        return this.version_;
    }

    public static a newBuilder(MarketOuterClass$ResponseGetCategoryMarkets marketOuterClass$ResponseGetCategoryMarkets) {
        return (a) DEFAULT_INSTANCE.createBuilder(marketOuterClass$ResponseGetCategoryMarkets);
    }

    public static MarketOuterClass$ResponseGetCategoryMarkets parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MarketOuterClass$ResponseGetCategoryMarkets) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MarketOuterClass$ResponseGetCategoryMarkets parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MarketOuterClass$ResponseGetCategoryMarkets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MarketOuterClass$ResponseGetCategoryMarkets parseFrom(AbstractC2383g abstractC2383g) {
        return (MarketOuterClass$ResponseGetCategoryMarkets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addMarkets(int i, MarketStruct$MarketItem marketStruct$MarketItem) {
        marketStruct$MarketItem.getClass();
        ensureMarketsIsMutable();
        this.markets_.add(i, marketStruct$MarketItem);
    }

    public static MarketOuterClass$ResponseGetCategoryMarkets parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MarketOuterClass$ResponseGetCategoryMarkets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MarketOuterClass$ResponseGetCategoryMarkets parseFrom(byte[] bArr) {
        return (MarketOuterClass$ResponseGetCategoryMarkets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MarketOuterClass$ResponseGetCategoryMarkets parseFrom(byte[] bArr, C2394s c2394s) {
        return (MarketOuterClass$ResponseGetCategoryMarkets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MarketOuterClass$ResponseGetCategoryMarkets parseFrom(InputStream inputStream) {
        return (MarketOuterClass$ResponseGetCategoryMarkets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MarketOuterClass$ResponseGetCategoryMarkets parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MarketOuterClass$ResponseGetCategoryMarkets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MarketOuterClass$ResponseGetCategoryMarkets parseFrom(AbstractC2384h abstractC2384h) {
        return (MarketOuterClass$ResponseGetCategoryMarkets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MarketOuterClass$ResponseGetCategoryMarkets parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MarketOuterClass$ResponseGetCategoryMarkets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
