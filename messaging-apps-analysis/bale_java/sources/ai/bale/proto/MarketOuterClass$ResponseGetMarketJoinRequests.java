package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.IT3;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class MarketOuterClass$ResponseGetMarketJoinRequests extends GeneratedMessageLite implements U64 {
    private static final MarketOuterClass$ResponseGetMarketJoinRequests DEFAULT_INSTANCE;
    public static final int MARKET_JOIN_REQUESTS_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private B.j marketJoinRequests_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MarketOuterClass$ResponseGetMarketJoinRequests.DEFAULT_INSTANCE);
        }
    }

    static {
        MarketOuterClass$ResponseGetMarketJoinRequests marketOuterClass$ResponseGetMarketJoinRequests = new MarketOuterClass$ResponseGetMarketJoinRequests();
        DEFAULT_INSTANCE = marketOuterClass$ResponseGetMarketJoinRequests;
        GeneratedMessageLite.registerDefaultInstance(MarketOuterClass$ResponseGetMarketJoinRequests.class, marketOuterClass$ResponseGetMarketJoinRequests);
    }

    private MarketOuterClass$ResponseGetMarketJoinRequests() {
    }

    private void addAllMarketJoinRequests(Iterable<? extends MarketStruct$MarketJoinRequest> iterable) {
        ensureMarketJoinRequestsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.marketJoinRequests_);
    }

    private void addMarketJoinRequests(MarketStruct$MarketJoinRequest marketStruct$MarketJoinRequest) {
        marketStruct$MarketJoinRequest.getClass();
        ensureMarketJoinRequestsIsMutable();
        this.marketJoinRequests_.add(marketStruct$MarketJoinRequest);
    }

    private void clearMarketJoinRequests() {
        this.marketJoinRequests_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureMarketJoinRequestsIsMutable() {
        B.j jVar = this.marketJoinRequests_;
        if (jVar.u()) {
            return;
        }
        this.marketJoinRequests_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static MarketOuterClass$ResponseGetMarketJoinRequests getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MarketOuterClass$ResponseGetMarketJoinRequests parseDelimitedFrom(InputStream inputStream) {
        return (MarketOuterClass$ResponseGetMarketJoinRequests) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MarketOuterClass$ResponseGetMarketJoinRequests parseFrom(ByteBuffer byteBuffer) {
        return (MarketOuterClass$ResponseGetMarketJoinRequests) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeMarketJoinRequests(int i) {
        ensureMarketJoinRequestsIsMutable();
        this.marketJoinRequests_.remove(i);
    }

    private void setMarketJoinRequests(int i, MarketStruct$MarketJoinRequest marketStruct$MarketJoinRequest) {
        marketStruct$MarketJoinRequest.getClass();
        ensureMarketJoinRequestsIsMutable();
        this.marketJoinRequests_.set(i, marketStruct$MarketJoinRequest);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (C0.a[gVar.ordinal()]) {
            case 1:
                return new MarketOuterClass$ResponseGetMarketJoinRequests();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"marketJoinRequests_", MarketStruct$MarketJoinRequest.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MarketOuterClass$ResponseGetMarketJoinRequests.class) {
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

    public MarketStruct$MarketJoinRequest getMarketJoinRequests(int i) {
        return (MarketStruct$MarketJoinRequest) this.marketJoinRequests_.get(i);
    }

    public int getMarketJoinRequestsCount() {
        return this.marketJoinRequests_.size();
    }

    public List<MarketStruct$MarketJoinRequest> getMarketJoinRequestsList() {
        return this.marketJoinRequests_;
    }

    public IT3 getMarketJoinRequestsOrBuilder(int i) {
        return (IT3) this.marketJoinRequests_.get(i);
    }

    public List<? extends IT3> getMarketJoinRequestsOrBuilderList() {
        return this.marketJoinRequests_;
    }

    public static a newBuilder(MarketOuterClass$ResponseGetMarketJoinRequests marketOuterClass$ResponseGetMarketJoinRequests) {
        return (a) DEFAULT_INSTANCE.createBuilder(marketOuterClass$ResponseGetMarketJoinRequests);
    }

    public static MarketOuterClass$ResponseGetMarketJoinRequests parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MarketOuterClass$ResponseGetMarketJoinRequests) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MarketOuterClass$ResponseGetMarketJoinRequests parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MarketOuterClass$ResponseGetMarketJoinRequests) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MarketOuterClass$ResponseGetMarketJoinRequests parseFrom(AbstractC2383g abstractC2383g) {
        return (MarketOuterClass$ResponseGetMarketJoinRequests) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addMarketJoinRequests(int i, MarketStruct$MarketJoinRequest marketStruct$MarketJoinRequest) {
        marketStruct$MarketJoinRequest.getClass();
        ensureMarketJoinRequestsIsMutable();
        this.marketJoinRequests_.add(i, marketStruct$MarketJoinRequest);
    }

    public static MarketOuterClass$ResponseGetMarketJoinRequests parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MarketOuterClass$ResponseGetMarketJoinRequests) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MarketOuterClass$ResponseGetMarketJoinRequests parseFrom(byte[] bArr) {
        return (MarketOuterClass$ResponseGetMarketJoinRequests) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MarketOuterClass$ResponseGetMarketJoinRequests parseFrom(byte[] bArr, C2394s c2394s) {
        return (MarketOuterClass$ResponseGetMarketJoinRequests) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MarketOuterClass$ResponseGetMarketJoinRequests parseFrom(InputStream inputStream) {
        return (MarketOuterClass$ResponseGetMarketJoinRequests) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MarketOuterClass$ResponseGetMarketJoinRequests parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MarketOuterClass$ResponseGetMarketJoinRequests) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MarketOuterClass$ResponseGetMarketJoinRequests parseFrom(AbstractC2384h abstractC2384h) {
        return (MarketOuterClass$ResponseGetMarketJoinRequests) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MarketOuterClass$ResponseGetMarketJoinRequests parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MarketOuterClass$ResponseGetMarketJoinRequests) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
