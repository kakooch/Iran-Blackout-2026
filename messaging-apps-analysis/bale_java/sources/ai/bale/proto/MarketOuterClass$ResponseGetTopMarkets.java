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
public final class MarketOuterClass$ResponseGetTopMarkets extends GeneratedMessageLite implements U64 {
    private static final MarketOuterClass$ResponseGetTopMarkets DEFAULT_INSTANCE;
    public static final int MARKETS_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private B.j markets_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MarketOuterClass$ResponseGetTopMarkets.DEFAULT_INSTANCE);
        }
    }

    static {
        MarketOuterClass$ResponseGetTopMarkets marketOuterClass$ResponseGetTopMarkets = new MarketOuterClass$ResponseGetTopMarkets();
        DEFAULT_INSTANCE = marketOuterClass$ResponseGetTopMarkets;
        GeneratedMessageLite.registerDefaultInstance(MarketOuterClass$ResponseGetTopMarkets.class, marketOuterClass$ResponseGetTopMarkets);
    }

    private MarketOuterClass$ResponseGetTopMarkets() {
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

    private void ensureMarketsIsMutable() {
        B.j jVar = this.markets_;
        if (jVar.u()) {
            return;
        }
        this.markets_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static MarketOuterClass$ResponseGetTopMarkets getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MarketOuterClass$ResponseGetTopMarkets parseDelimitedFrom(InputStream inputStream) {
        return (MarketOuterClass$ResponseGetTopMarkets) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MarketOuterClass$ResponseGetTopMarkets parseFrom(ByteBuffer byteBuffer) {
        return (MarketOuterClass$ResponseGetTopMarkets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
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

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (C0.a[gVar.ordinal()]) {
            case 1:
                return new MarketOuterClass$ResponseGetTopMarkets();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"markets_", MarketStruct$MarketItem.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MarketOuterClass$ResponseGetTopMarkets.class) {
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

    public static a newBuilder(MarketOuterClass$ResponseGetTopMarkets marketOuterClass$ResponseGetTopMarkets) {
        return (a) DEFAULT_INSTANCE.createBuilder(marketOuterClass$ResponseGetTopMarkets);
    }

    public static MarketOuterClass$ResponseGetTopMarkets parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MarketOuterClass$ResponseGetTopMarkets) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MarketOuterClass$ResponseGetTopMarkets parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MarketOuterClass$ResponseGetTopMarkets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MarketOuterClass$ResponseGetTopMarkets parseFrom(AbstractC2383g abstractC2383g) {
        return (MarketOuterClass$ResponseGetTopMarkets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addMarkets(int i, MarketStruct$MarketItem marketStruct$MarketItem) {
        marketStruct$MarketItem.getClass();
        ensureMarketsIsMutable();
        this.markets_.add(i, marketStruct$MarketItem);
    }

    public static MarketOuterClass$ResponseGetTopMarkets parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MarketOuterClass$ResponseGetTopMarkets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MarketOuterClass$ResponseGetTopMarkets parseFrom(byte[] bArr) {
        return (MarketOuterClass$ResponseGetTopMarkets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MarketOuterClass$ResponseGetTopMarkets parseFrom(byte[] bArr, C2394s c2394s) {
        return (MarketOuterClass$ResponseGetTopMarkets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MarketOuterClass$ResponseGetTopMarkets parseFrom(InputStream inputStream) {
        return (MarketOuterClass$ResponseGetTopMarkets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MarketOuterClass$ResponseGetTopMarkets parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MarketOuterClass$ResponseGetTopMarkets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MarketOuterClass$ResponseGetTopMarkets parseFrom(AbstractC2384h abstractC2384h) {
        return (MarketOuterClass$ResponseGetTopMarkets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MarketOuterClass$ResponseGetTopMarkets parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MarketOuterClass$ResponseGetTopMarkets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
