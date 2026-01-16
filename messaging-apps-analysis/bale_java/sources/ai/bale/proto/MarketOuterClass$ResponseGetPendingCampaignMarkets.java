package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.ET3;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class MarketOuterClass$ResponseGetPendingCampaignMarkets extends GeneratedMessageLite implements U64 {
    private static final MarketOuterClass$ResponseGetPendingCampaignMarkets DEFAULT_INSTANCE;
    public static final int MARKETS_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private B.j markets_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MarketOuterClass$ResponseGetPendingCampaignMarkets.DEFAULT_INSTANCE);
        }
    }

    static {
        MarketOuterClass$ResponseGetPendingCampaignMarkets marketOuterClass$ResponseGetPendingCampaignMarkets = new MarketOuterClass$ResponseGetPendingCampaignMarkets();
        DEFAULT_INSTANCE = marketOuterClass$ResponseGetPendingCampaignMarkets;
        GeneratedMessageLite.registerDefaultInstance(MarketOuterClass$ResponseGetPendingCampaignMarkets.class, marketOuterClass$ResponseGetPendingCampaignMarkets);
    }

    private MarketOuterClass$ResponseGetPendingCampaignMarkets() {
    }

    private void addAllMarkets(Iterable<? extends MarketStruct$MarketInfo> iterable) {
        ensureMarketsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.markets_);
    }

    private void addMarkets(MarketStruct$MarketInfo marketStruct$MarketInfo) {
        marketStruct$MarketInfo.getClass();
        ensureMarketsIsMutable();
        this.markets_.add(marketStruct$MarketInfo);
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

    public static MarketOuterClass$ResponseGetPendingCampaignMarkets getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MarketOuterClass$ResponseGetPendingCampaignMarkets parseDelimitedFrom(InputStream inputStream) {
        return (MarketOuterClass$ResponseGetPendingCampaignMarkets) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MarketOuterClass$ResponseGetPendingCampaignMarkets parseFrom(ByteBuffer byteBuffer) {
        return (MarketOuterClass$ResponseGetPendingCampaignMarkets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeMarkets(int i) {
        ensureMarketsIsMutable();
        this.markets_.remove(i);
    }

    private void setMarkets(int i, MarketStruct$MarketInfo marketStruct$MarketInfo) {
        marketStruct$MarketInfo.getClass();
        ensureMarketsIsMutable();
        this.markets_.set(i, marketStruct$MarketInfo);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (C0.a[gVar.ordinal()]) {
            case 1:
                return new MarketOuterClass$ResponseGetPendingCampaignMarkets();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"markets_", MarketStruct$MarketInfo.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MarketOuterClass$ResponseGetPendingCampaignMarkets.class) {
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

    public MarketStruct$MarketInfo getMarkets(int i) {
        return (MarketStruct$MarketInfo) this.markets_.get(i);
    }

    public int getMarketsCount() {
        return this.markets_.size();
    }

    public List<MarketStruct$MarketInfo> getMarketsList() {
        return this.markets_;
    }

    public ET3 getMarketsOrBuilder(int i) {
        return (ET3) this.markets_.get(i);
    }

    public List<? extends ET3> getMarketsOrBuilderList() {
        return this.markets_;
    }

    public static a newBuilder(MarketOuterClass$ResponseGetPendingCampaignMarkets marketOuterClass$ResponseGetPendingCampaignMarkets) {
        return (a) DEFAULT_INSTANCE.createBuilder(marketOuterClass$ResponseGetPendingCampaignMarkets);
    }

    public static MarketOuterClass$ResponseGetPendingCampaignMarkets parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MarketOuterClass$ResponseGetPendingCampaignMarkets) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MarketOuterClass$ResponseGetPendingCampaignMarkets parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MarketOuterClass$ResponseGetPendingCampaignMarkets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MarketOuterClass$ResponseGetPendingCampaignMarkets parseFrom(AbstractC2383g abstractC2383g) {
        return (MarketOuterClass$ResponseGetPendingCampaignMarkets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addMarkets(int i, MarketStruct$MarketInfo marketStruct$MarketInfo) {
        marketStruct$MarketInfo.getClass();
        ensureMarketsIsMutable();
        this.markets_.add(i, marketStruct$MarketInfo);
    }

    public static MarketOuterClass$ResponseGetPendingCampaignMarkets parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MarketOuterClass$ResponseGetPendingCampaignMarkets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MarketOuterClass$ResponseGetPendingCampaignMarkets parseFrom(byte[] bArr) {
        return (MarketOuterClass$ResponseGetPendingCampaignMarkets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MarketOuterClass$ResponseGetPendingCampaignMarkets parseFrom(byte[] bArr, C2394s c2394s) {
        return (MarketOuterClass$ResponseGetPendingCampaignMarkets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MarketOuterClass$ResponseGetPendingCampaignMarkets parseFrom(InputStream inputStream) {
        return (MarketOuterClass$ResponseGetPendingCampaignMarkets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MarketOuterClass$ResponseGetPendingCampaignMarkets parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MarketOuterClass$ResponseGetPendingCampaignMarkets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MarketOuterClass$ResponseGetPendingCampaignMarkets parseFrom(AbstractC2384h abstractC2384h) {
        return (MarketOuterClass$ResponseGetPendingCampaignMarkets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MarketOuterClass$ResponseGetPendingCampaignMarkets parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MarketOuterClass$ResponseGetPendingCampaignMarkets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
