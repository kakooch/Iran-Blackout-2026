package ai.bale.proto;

import ai.bale.proto.MarketStruct$MarketCategory;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class VitrineOuterClass$MarketCategorySection extends GeneratedMessageLite implements U64 {
    public static final int CATEGORY_NAME_FIELD_NUMBER = 2;
    private static final VitrineOuterClass$MarketCategorySection DEFAULT_INSTANCE;
    public static final int MARKET_CATEGORY_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private String categoryName_ = "";
    private MarketStruct$MarketCategory marketCategory_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(VitrineOuterClass$MarketCategorySection.DEFAULT_INSTANCE);
        }
    }

    static {
        VitrineOuterClass$MarketCategorySection vitrineOuterClass$MarketCategorySection = new VitrineOuterClass$MarketCategorySection();
        DEFAULT_INSTANCE = vitrineOuterClass$MarketCategorySection;
        GeneratedMessageLite.registerDefaultInstance(VitrineOuterClass$MarketCategorySection.class, vitrineOuterClass$MarketCategorySection);
    }

    private VitrineOuterClass$MarketCategorySection() {
    }

    private void clearCategoryName() {
        this.categoryName_ = getDefaultInstance().getCategoryName();
    }

    private void clearMarketCategory() {
        this.marketCategory_ = null;
        this.bitField0_ &= -2;
    }

    public static VitrineOuterClass$MarketCategorySection getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeMarketCategory(MarketStruct$MarketCategory marketStruct$MarketCategory) {
        marketStruct$MarketCategory.getClass();
        MarketStruct$MarketCategory marketStruct$MarketCategory2 = this.marketCategory_;
        if (marketStruct$MarketCategory2 == null || marketStruct$MarketCategory2 == MarketStruct$MarketCategory.getDefaultInstance()) {
            this.marketCategory_ = marketStruct$MarketCategory;
        } else {
            this.marketCategory_ = (MarketStruct$MarketCategory) ((MarketStruct$MarketCategory.a) MarketStruct$MarketCategory.newBuilder(this.marketCategory_).v(marketStruct$MarketCategory)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static VitrineOuterClass$MarketCategorySection parseDelimitedFrom(InputStream inputStream) {
        return (VitrineOuterClass$MarketCategorySection) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static VitrineOuterClass$MarketCategorySection parseFrom(ByteBuffer byteBuffer) {
        return (VitrineOuterClass$MarketCategorySection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setCategoryName(String str) {
        str.getClass();
        this.categoryName_ = str;
    }

    private void setCategoryNameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.categoryName_ = abstractC2383g.f0();
    }

    private void setMarketCategory(MarketStruct$MarketCategory marketStruct$MarketCategory) {
        marketStruct$MarketCategory.getClass();
        this.marketCategory_ = marketStruct$MarketCategory;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (r2.a[gVar.ordinal()]) {
            case 1:
                return new VitrineOuterClass$MarketCategorySection();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002Ȉ", new Object[]{"bitField0_", "marketCategory_", "categoryName_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (VitrineOuterClass$MarketCategorySection.class) {
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

    public String getCategoryName() {
        return this.categoryName_;
    }

    public AbstractC2383g getCategoryNameBytes() {
        return AbstractC2383g.N(this.categoryName_);
    }

    public MarketStruct$MarketCategory getMarketCategory() {
        MarketStruct$MarketCategory marketStruct$MarketCategory = this.marketCategory_;
        return marketStruct$MarketCategory == null ? MarketStruct$MarketCategory.getDefaultInstance() : marketStruct$MarketCategory;
    }

    public boolean hasMarketCategory() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(VitrineOuterClass$MarketCategorySection vitrineOuterClass$MarketCategorySection) {
        return (a) DEFAULT_INSTANCE.createBuilder(vitrineOuterClass$MarketCategorySection);
    }

    public static VitrineOuterClass$MarketCategorySection parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (VitrineOuterClass$MarketCategorySection) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static VitrineOuterClass$MarketCategorySection parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (VitrineOuterClass$MarketCategorySection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static VitrineOuterClass$MarketCategorySection parseFrom(AbstractC2383g abstractC2383g) {
        return (VitrineOuterClass$MarketCategorySection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static VitrineOuterClass$MarketCategorySection parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (VitrineOuterClass$MarketCategorySection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static VitrineOuterClass$MarketCategorySection parseFrom(byte[] bArr) {
        return (VitrineOuterClass$MarketCategorySection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static VitrineOuterClass$MarketCategorySection parseFrom(byte[] bArr, C2394s c2394s) {
        return (VitrineOuterClass$MarketCategorySection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static VitrineOuterClass$MarketCategorySection parseFrom(InputStream inputStream) {
        return (VitrineOuterClass$MarketCategorySection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static VitrineOuterClass$MarketCategorySection parseFrom(InputStream inputStream, C2394s c2394s) {
        return (VitrineOuterClass$MarketCategorySection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static VitrineOuterClass$MarketCategorySection parseFrom(AbstractC2384h abstractC2384h) {
        return (VitrineOuterClass$MarketCategorySection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static VitrineOuterClass$MarketCategorySection parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (VitrineOuterClass$MarketCategorySection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
