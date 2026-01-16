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
public final class MarketOuterClass$RequestGetIndexedProducts extends GeneratedMessageLite implements U64 {
    public static final int CATEGORY_ID_FIELD_NUMBER = 3;
    private static final MarketOuterClass$RequestGetIndexedProducts DEFAULT_INSTANCE;
    public static final int END_DATE_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int START_DATE_FIELD_NUMBER = 1;
    private int categoryId_;
    private long endDate_;
    private long startDate_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MarketOuterClass$RequestGetIndexedProducts.DEFAULT_INSTANCE);
        }
    }

    static {
        MarketOuterClass$RequestGetIndexedProducts marketOuterClass$RequestGetIndexedProducts = new MarketOuterClass$RequestGetIndexedProducts();
        DEFAULT_INSTANCE = marketOuterClass$RequestGetIndexedProducts;
        GeneratedMessageLite.registerDefaultInstance(MarketOuterClass$RequestGetIndexedProducts.class, marketOuterClass$RequestGetIndexedProducts);
    }

    private MarketOuterClass$RequestGetIndexedProducts() {
    }

    private void clearCategoryId() {
        this.categoryId_ = 0;
    }

    private void clearEndDate() {
        this.endDate_ = 0L;
    }

    private void clearStartDate() {
        this.startDate_ = 0L;
    }

    public static MarketOuterClass$RequestGetIndexedProducts getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MarketOuterClass$RequestGetIndexedProducts parseDelimitedFrom(InputStream inputStream) {
        return (MarketOuterClass$RequestGetIndexedProducts) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MarketOuterClass$RequestGetIndexedProducts parseFrom(ByteBuffer byteBuffer) {
        return (MarketOuterClass$RequestGetIndexedProducts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setCategoryId(int i) {
        this.categoryId_ = i;
    }

    private void setEndDate(long j) {
        this.endDate_ = j;
    }

    private void setStartDate(long j) {
        this.startDate_ = j;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (C0.a[gVar.ordinal()]) {
            case 1:
                return new MarketOuterClass$RequestGetIndexedProducts();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0002\u0002\u0002\u0003\u0004", new Object[]{"startDate_", "endDate_", "categoryId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MarketOuterClass$RequestGetIndexedProducts.class) {
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

    public long getEndDate() {
        return this.endDate_;
    }

    public long getStartDate() {
        return this.startDate_;
    }

    public static a newBuilder(MarketOuterClass$RequestGetIndexedProducts marketOuterClass$RequestGetIndexedProducts) {
        return (a) DEFAULT_INSTANCE.createBuilder(marketOuterClass$RequestGetIndexedProducts);
    }

    public static MarketOuterClass$RequestGetIndexedProducts parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MarketOuterClass$RequestGetIndexedProducts) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MarketOuterClass$RequestGetIndexedProducts parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MarketOuterClass$RequestGetIndexedProducts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MarketOuterClass$RequestGetIndexedProducts parseFrom(AbstractC2383g abstractC2383g) {
        return (MarketOuterClass$RequestGetIndexedProducts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MarketOuterClass$RequestGetIndexedProducts parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MarketOuterClass$RequestGetIndexedProducts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MarketOuterClass$RequestGetIndexedProducts parseFrom(byte[] bArr) {
        return (MarketOuterClass$RequestGetIndexedProducts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MarketOuterClass$RequestGetIndexedProducts parseFrom(byte[] bArr, C2394s c2394s) {
        return (MarketOuterClass$RequestGetIndexedProducts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MarketOuterClass$RequestGetIndexedProducts parseFrom(InputStream inputStream) {
        return (MarketOuterClass$RequestGetIndexedProducts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MarketOuterClass$RequestGetIndexedProducts parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MarketOuterClass$RequestGetIndexedProducts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MarketOuterClass$RequestGetIndexedProducts parseFrom(AbstractC2384h abstractC2384h) {
        return (MarketOuterClass$RequestGetIndexedProducts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MarketOuterClass$RequestGetIndexedProducts parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MarketOuterClass$RequestGetIndexedProducts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
