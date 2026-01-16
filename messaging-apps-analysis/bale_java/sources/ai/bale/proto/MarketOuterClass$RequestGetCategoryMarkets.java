package ai.bale.proto;

import ai.bale.proto.MarketStruct$MarketPagination;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class MarketOuterClass$RequestGetCategoryMarkets extends GeneratedMessageLite implements U64 {
    public static final int CATEGORY_ID_FIELD_NUMBER = 1;
    private static final MarketOuterClass$RequestGetCategoryMarkets DEFAULT_INSTANCE;
    public static final int PAGINATION_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int VERSION_FIELD_NUMBER = 3;
    private int bitField0_;
    private int categoryId_;
    private MarketStruct$MarketPagination pagination_;
    private int version_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(int i) {
            q();
            ((MarketOuterClass$RequestGetCategoryMarkets) this.b).setCategoryId(i);
            return this;
        }

        public a B(MarketStruct$MarketPagination.a aVar) {
            q();
            ((MarketOuterClass$RequestGetCategoryMarkets) this.b).setPagination((MarketStruct$MarketPagination) aVar.a());
            return this;
        }

        private a() {
            super(MarketOuterClass$RequestGetCategoryMarkets.DEFAULT_INSTANCE);
        }
    }

    static {
        MarketOuterClass$RequestGetCategoryMarkets marketOuterClass$RequestGetCategoryMarkets = new MarketOuterClass$RequestGetCategoryMarkets();
        DEFAULT_INSTANCE = marketOuterClass$RequestGetCategoryMarkets;
        GeneratedMessageLite.registerDefaultInstance(MarketOuterClass$RequestGetCategoryMarkets.class, marketOuterClass$RequestGetCategoryMarkets);
    }

    private MarketOuterClass$RequestGetCategoryMarkets() {
    }

    private void clearCategoryId() {
        this.categoryId_ = 0;
    }

    private void clearPagination() {
        this.pagination_ = null;
        this.bitField0_ &= -2;
    }

    private void clearVersion() {
        this.version_ = 0;
    }

    public static MarketOuterClass$RequestGetCategoryMarkets getDefaultInstance() {
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

    public static MarketOuterClass$RequestGetCategoryMarkets parseDelimitedFrom(InputStream inputStream) {
        return (MarketOuterClass$RequestGetCategoryMarkets) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MarketOuterClass$RequestGetCategoryMarkets parseFrom(ByteBuffer byteBuffer) {
        return (MarketOuterClass$RequestGetCategoryMarkets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCategoryId(int i) {
        this.categoryId_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPagination(MarketStruct$MarketPagination marketStruct$MarketPagination) {
        marketStruct$MarketPagination.getClass();
        this.pagination_ = marketStruct$MarketPagination;
        this.bitField0_ |= 1;
    }

    private void setVersion(int i) {
        this.version_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (C0.a[gVar.ordinal()]) {
            case 1:
                return new MarketOuterClass$RequestGetCategoryMarkets();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0004\u0002ဉ\u0000\u0003\u0004", new Object[]{"bitField0_", "categoryId_", "pagination_", "version_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MarketOuterClass$RequestGetCategoryMarkets.class) {
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

    public int getCategoryId() {
        return this.categoryId_;
    }

    public MarketStruct$MarketPagination getPagination() {
        MarketStruct$MarketPagination marketStruct$MarketPagination = this.pagination_;
        return marketStruct$MarketPagination == null ? MarketStruct$MarketPagination.getDefaultInstance() : marketStruct$MarketPagination;
    }

    public int getVersion() {
        return this.version_;
    }

    public boolean hasPagination() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(MarketOuterClass$RequestGetCategoryMarkets marketOuterClass$RequestGetCategoryMarkets) {
        return (a) DEFAULT_INSTANCE.createBuilder(marketOuterClass$RequestGetCategoryMarkets);
    }

    public static MarketOuterClass$RequestGetCategoryMarkets parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MarketOuterClass$RequestGetCategoryMarkets) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MarketOuterClass$RequestGetCategoryMarkets parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MarketOuterClass$RequestGetCategoryMarkets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MarketOuterClass$RequestGetCategoryMarkets parseFrom(AbstractC2383g abstractC2383g) {
        return (MarketOuterClass$RequestGetCategoryMarkets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MarketOuterClass$RequestGetCategoryMarkets parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MarketOuterClass$RequestGetCategoryMarkets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MarketOuterClass$RequestGetCategoryMarkets parseFrom(byte[] bArr) {
        return (MarketOuterClass$RequestGetCategoryMarkets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MarketOuterClass$RequestGetCategoryMarkets parseFrom(byte[] bArr, C2394s c2394s) {
        return (MarketOuterClass$RequestGetCategoryMarkets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MarketOuterClass$RequestGetCategoryMarkets parseFrom(InputStream inputStream) {
        return (MarketOuterClass$RequestGetCategoryMarkets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MarketOuterClass$RequestGetCategoryMarkets parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MarketOuterClass$RequestGetCategoryMarkets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MarketOuterClass$RequestGetCategoryMarkets parseFrom(AbstractC2384h abstractC2384h) {
        return (MarketOuterClass$RequestGetCategoryMarkets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MarketOuterClass$RequestGetCategoryMarkets parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MarketOuterClass$RequestGetCategoryMarkets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
