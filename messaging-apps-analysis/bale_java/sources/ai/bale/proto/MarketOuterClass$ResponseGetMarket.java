package ai.bale.proto;

import ai.bale.proto.MarketStruct$MarketInfo;
import ai.bale.proto.MarketStruct$MarketJoinRequest;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class MarketOuterClass$ResponseGetMarket extends GeneratedMessageLite implements U64 {
    private static final MarketOuterClass$ResponseGetMarket DEFAULT_INSTANCE;
    public static final int LAST_REQUEST_FIELD_NUMBER = 2;
    public static final int MARKET_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private MarketStruct$MarketJoinRequest lastRequest_;
    private MarketStruct$MarketInfo market_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MarketOuterClass$ResponseGetMarket.DEFAULT_INSTANCE);
        }
    }

    static {
        MarketOuterClass$ResponseGetMarket marketOuterClass$ResponseGetMarket = new MarketOuterClass$ResponseGetMarket();
        DEFAULT_INSTANCE = marketOuterClass$ResponseGetMarket;
        GeneratedMessageLite.registerDefaultInstance(MarketOuterClass$ResponseGetMarket.class, marketOuterClass$ResponseGetMarket);
    }

    private MarketOuterClass$ResponseGetMarket() {
    }

    private void clearLastRequest() {
        this.lastRequest_ = null;
        this.bitField0_ &= -3;
    }

    private void clearMarket() {
        this.market_ = null;
        this.bitField0_ &= -2;
    }

    public static MarketOuterClass$ResponseGetMarket getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeLastRequest(MarketStruct$MarketJoinRequest marketStruct$MarketJoinRequest) {
        marketStruct$MarketJoinRequest.getClass();
        MarketStruct$MarketJoinRequest marketStruct$MarketJoinRequest2 = this.lastRequest_;
        if (marketStruct$MarketJoinRequest2 == null || marketStruct$MarketJoinRequest2 == MarketStruct$MarketJoinRequest.getDefaultInstance()) {
            this.lastRequest_ = marketStruct$MarketJoinRequest;
        } else {
            this.lastRequest_ = (MarketStruct$MarketJoinRequest) ((MarketStruct$MarketJoinRequest.a) MarketStruct$MarketJoinRequest.newBuilder(this.lastRequest_).v(marketStruct$MarketJoinRequest)).j();
        }
        this.bitField0_ |= 2;
    }

    private void mergeMarket(MarketStruct$MarketInfo marketStruct$MarketInfo) {
        marketStruct$MarketInfo.getClass();
        MarketStruct$MarketInfo marketStruct$MarketInfo2 = this.market_;
        if (marketStruct$MarketInfo2 == null || marketStruct$MarketInfo2 == MarketStruct$MarketInfo.getDefaultInstance()) {
            this.market_ = marketStruct$MarketInfo;
        } else {
            this.market_ = (MarketStruct$MarketInfo) ((MarketStruct$MarketInfo.a) MarketStruct$MarketInfo.newBuilder(this.market_).v(marketStruct$MarketInfo)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MarketOuterClass$ResponseGetMarket parseDelimitedFrom(InputStream inputStream) {
        return (MarketOuterClass$ResponseGetMarket) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MarketOuterClass$ResponseGetMarket parseFrom(ByteBuffer byteBuffer) {
        return (MarketOuterClass$ResponseGetMarket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setLastRequest(MarketStruct$MarketJoinRequest marketStruct$MarketJoinRequest) {
        marketStruct$MarketJoinRequest.getClass();
        this.lastRequest_ = marketStruct$MarketJoinRequest;
        this.bitField0_ |= 2;
    }

    private void setMarket(MarketStruct$MarketInfo marketStruct$MarketInfo) {
        marketStruct$MarketInfo.getClass();
        this.market_ = marketStruct$MarketInfo;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (C0.a[gVar.ordinal()]) {
            case 1:
                return new MarketOuterClass$ResponseGetMarket();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001", new Object[]{"bitField0_", "market_", "lastRequest_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MarketOuterClass$ResponseGetMarket.class) {
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

    public MarketStruct$MarketJoinRequest getLastRequest() {
        MarketStruct$MarketJoinRequest marketStruct$MarketJoinRequest = this.lastRequest_;
        return marketStruct$MarketJoinRequest == null ? MarketStruct$MarketJoinRequest.getDefaultInstance() : marketStruct$MarketJoinRequest;
    }

    public MarketStruct$MarketInfo getMarket() {
        MarketStruct$MarketInfo marketStruct$MarketInfo = this.market_;
        return marketStruct$MarketInfo == null ? MarketStruct$MarketInfo.getDefaultInstance() : marketStruct$MarketInfo;
    }

    public boolean hasLastRequest() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasMarket() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(MarketOuterClass$ResponseGetMarket marketOuterClass$ResponseGetMarket) {
        return (a) DEFAULT_INSTANCE.createBuilder(marketOuterClass$ResponseGetMarket);
    }

    public static MarketOuterClass$ResponseGetMarket parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MarketOuterClass$ResponseGetMarket) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MarketOuterClass$ResponseGetMarket parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MarketOuterClass$ResponseGetMarket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MarketOuterClass$ResponseGetMarket parseFrom(AbstractC2383g abstractC2383g) {
        return (MarketOuterClass$ResponseGetMarket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MarketOuterClass$ResponseGetMarket parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MarketOuterClass$ResponseGetMarket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MarketOuterClass$ResponseGetMarket parseFrom(byte[] bArr) {
        return (MarketOuterClass$ResponseGetMarket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MarketOuterClass$ResponseGetMarket parseFrom(byte[] bArr, C2394s c2394s) {
        return (MarketOuterClass$ResponseGetMarket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MarketOuterClass$ResponseGetMarket parseFrom(InputStream inputStream) {
        return (MarketOuterClass$ResponseGetMarket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MarketOuterClass$ResponseGetMarket parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MarketOuterClass$ResponseGetMarket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MarketOuterClass$ResponseGetMarket parseFrom(AbstractC2384h abstractC2384h) {
        return (MarketOuterClass$ResponseGetMarket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MarketOuterClass$ResponseGetMarket parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MarketOuterClass$ResponseGetMarket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
