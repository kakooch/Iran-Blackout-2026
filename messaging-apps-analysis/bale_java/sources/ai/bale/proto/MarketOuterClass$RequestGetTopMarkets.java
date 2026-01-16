package ai.bale.proto;

import ai.bale.proto.MarketStruct$MarketPagination;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.QT3;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class MarketOuterClass$RequestGetTopMarkets extends GeneratedMessageLite implements U64 {
    private static final MarketOuterClass$RequestGetTopMarkets DEFAULT_INSTANCE;
    public static final int PAGINATION_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int RATING_TYPE_FIELD_NUMBER = 1;
    private int bitField0_;
    private MarketStruct$MarketPagination pagination_;
    private int ratingType_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MarketOuterClass$RequestGetTopMarkets.DEFAULT_INSTANCE);
        }
    }

    static {
        MarketOuterClass$RequestGetTopMarkets marketOuterClass$RequestGetTopMarkets = new MarketOuterClass$RequestGetTopMarkets();
        DEFAULT_INSTANCE = marketOuterClass$RequestGetTopMarkets;
        GeneratedMessageLite.registerDefaultInstance(MarketOuterClass$RequestGetTopMarkets.class, marketOuterClass$RequestGetTopMarkets);
    }

    private MarketOuterClass$RequestGetTopMarkets() {
    }

    private void clearPagination() {
        this.pagination_ = null;
        this.bitField0_ &= -2;
    }

    private void clearRatingType() {
        this.ratingType_ = 0;
    }

    public static MarketOuterClass$RequestGetTopMarkets getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergePagination(MarketStruct$MarketPagination marketStruct$MarketPagination) {
        marketStruct$MarketPagination.getClass();
        MarketStruct$MarketPagination marketStruct$MarketPagination2 = this.pagination_;
        if (marketStruct$MarketPagination2 == null || marketStruct$MarketPagination2 == MarketStruct$MarketPagination.getDefaultInstance()) {
            this.pagination_ = marketStruct$MarketPagination;
        } else {
            this.pagination_ = (MarketStruct$MarketPagination) ((MarketStruct$MarketPagination.a) MarketStruct$MarketPagination.newBuilder(this.pagination_).v(marketStruct$MarketPagination)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MarketOuterClass$RequestGetTopMarkets parseDelimitedFrom(InputStream inputStream) {
        return (MarketOuterClass$RequestGetTopMarkets) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MarketOuterClass$RequestGetTopMarkets parseFrom(ByteBuffer byteBuffer) {
        return (MarketOuterClass$RequestGetTopMarkets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setPagination(MarketStruct$MarketPagination marketStruct$MarketPagination) {
        marketStruct$MarketPagination.getClass();
        this.pagination_ = marketStruct$MarketPagination;
        this.bitField0_ |= 1;
    }

    private void setRatingType(QT3 qt3) {
        this.ratingType_ = qt3.getNumber();
    }

    private void setRatingTypeValue(int i) {
        this.ratingType_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (C0.a[gVar.ordinal()]) {
            case 1:
                return new MarketOuterClass$RequestGetTopMarkets();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0002ဉ\u0000", new Object[]{"bitField0_", "ratingType_", "pagination_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MarketOuterClass$RequestGetTopMarkets.class) {
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

    public MarketStruct$MarketPagination getPagination() {
        MarketStruct$MarketPagination marketStruct$MarketPagination = this.pagination_;
        return marketStruct$MarketPagination == null ? MarketStruct$MarketPagination.getDefaultInstance() : marketStruct$MarketPagination;
    }

    public QT3 getRatingType() {
        QT3 qt3J = QT3.j(this.ratingType_);
        return qt3J == null ? QT3.UNRECOGNIZED : qt3J;
    }

    public int getRatingTypeValue() {
        return this.ratingType_;
    }

    public boolean hasPagination() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(MarketOuterClass$RequestGetTopMarkets marketOuterClass$RequestGetTopMarkets) {
        return (a) DEFAULT_INSTANCE.createBuilder(marketOuterClass$RequestGetTopMarkets);
    }

    public static MarketOuterClass$RequestGetTopMarkets parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MarketOuterClass$RequestGetTopMarkets) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MarketOuterClass$RequestGetTopMarkets parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MarketOuterClass$RequestGetTopMarkets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MarketOuterClass$RequestGetTopMarkets parseFrom(AbstractC2383g abstractC2383g) {
        return (MarketOuterClass$RequestGetTopMarkets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MarketOuterClass$RequestGetTopMarkets parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MarketOuterClass$RequestGetTopMarkets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MarketOuterClass$RequestGetTopMarkets parseFrom(byte[] bArr) {
        return (MarketOuterClass$RequestGetTopMarkets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MarketOuterClass$RequestGetTopMarkets parseFrom(byte[] bArr, C2394s c2394s) {
        return (MarketOuterClass$RequestGetTopMarkets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MarketOuterClass$RequestGetTopMarkets parseFrom(InputStream inputStream) {
        return (MarketOuterClass$RequestGetTopMarkets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MarketOuterClass$RequestGetTopMarkets parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MarketOuterClass$RequestGetTopMarkets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MarketOuterClass$RequestGetTopMarkets parseFrom(AbstractC2384h abstractC2384h) {
        return (MarketOuterClass$RequestGetTopMarkets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MarketOuterClass$RequestGetTopMarkets parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MarketOuterClass$RequestGetTopMarkets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
