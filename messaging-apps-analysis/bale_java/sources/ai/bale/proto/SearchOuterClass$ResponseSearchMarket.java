package ai.bale.proto;

import ai.bale.proto.MarketStruct$MarketCategory;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.BytesValue;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC25078zh6;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes.dex */
public final class SearchOuterClass$ResponseSearchMarket extends GeneratedMessageLite implements U64 {
    public static final int CATEGORY_FIELD_NUMBER = 2;
    private static final SearchOuterClass$ResponseSearchMarket DEFAULT_INSTANCE;
    public static final int LOAD_MORE_STATE_FIELD_NUMBER = 3;
    public static final int MARKET_RESULTS_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int RESULT_COUNT_FIELD_NUMBER = 4;
    private int bitField0_;
    private MarketStruct$MarketCategory category_;
    private BytesValue loadMoreState_;
    private B.j marketResults_ = GeneratedMessageLite.emptyProtobufList();
    private int resultCount_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(SearchOuterClass$ResponseSearchMarket.DEFAULT_INSTANCE);
        }
    }

    static {
        SearchOuterClass$ResponseSearchMarket searchOuterClass$ResponseSearchMarket = new SearchOuterClass$ResponseSearchMarket();
        DEFAULT_INSTANCE = searchOuterClass$ResponseSearchMarket;
        GeneratedMessageLite.registerDefaultInstance(SearchOuterClass$ResponseSearchMarket.class, searchOuterClass$ResponseSearchMarket);
    }

    private SearchOuterClass$ResponseSearchMarket() {
    }

    private void addAllMarketResults(Iterable<? extends SearchStruct$MarketSearchResult> iterable) {
        ensureMarketResultsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.marketResults_);
    }

    private void addMarketResults(SearchStruct$MarketSearchResult searchStruct$MarketSearchResult) {
        searchStruct$MarketSearchResult.getClass();
        ensureMarketResultsIsMutable();
        this.marketResults_.add(searchStruct$MarketSearchResult);
    }

    private void clearCategory() {
        this.category_ = null;
        this.bitField0_ &= -2;
    }

    private void clearLoadMoreState() {
        this.loadMoreState_ = null;
        this.bitField0_ &= -3;
    }

    private void clearMarketResults() {
        this.marketResults_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearResultCount() {
        this.resultCount_ = 0;
    }

    private void ensureMarketResultsIsMutable() {
        B.j jVar = this.marketResults_;
        if (jVar.u()) {
            return;
        }
        this.marketResults_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static SearchOuterClass$ResponseSearchMarket getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeCategory(MarketStruct$MarketCategory marketStruct$MarketCategory) {
        marketStruct$MarketCategory.getClass();
        MarketStruct$MarketCategory marketStruct$MarketCategory2 = this.category_;
        if (marketStruct$MarketCategory2 == null || marketStruct$MarketCategory2 == MarketStruct$MarketCategory.getDefaultInstance()) {
            this.category_ = marketStruct$MarketCategory;
        } else {
            this.category_ = (MarketStruct$MarketCategory) ((MarketStruct$MarketCategory.a) MarketStruct$MarketCategory.newBuilder(this.category_).v(marketStruct$MarketCategory)).j();
        }
        this.bitField0_ |= 1;
    }

    private void mergeLoadMoreState(BytesValue bytesValue) {
        bytesValue.getClass();
        BytesValue bytesValue2 = this.loadMoreState_;
        if (bytesValue2 == null || bytesValue2 == BytesValue.getDefaultInstance()) {
            this.loadMoreState_ = bytesValue;
        } else {
            this.loadMoreState_ = (BytesValue) ((BytesValue.b) BytesValue.newBuilder(this.loadMoreState_).v(bytesValue)).j();
        }
        this.bitField0_ |= 2;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SearchOuterClass$ResponseSearchMarket parseDelimitedFrom(InputStream inputStream) {
        return (SearchOuterClass$ResponseSearchMarket) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SearchOuterClass$ResponseSearchMarket parseFrom(ByteBuffer byteBuffer) {
        return (SearchOuterClass$ResponseSearchMarket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeMarketResults(int i) {
        ensureMarketResultsIsMutable();
        this.marketResults_.remove(i);
    }

    private void setCategory(MarketStruct$MarketCategory marketStruct$MarketCategory) {
        marketStruct$MarketCategory.getClass();
        this.category_ = marketStruct$MarketCategory;
        this.bitField0_ |= 1;
    }

    private void setLoadMoreState(BytesValue bytesValue) {
        bytesValue.getClass();
        this.loadMoreState_ = bytesValue;
        this.bitField0_ |= 2;
    }

    private void setMarketResults(int i, SearchStruct$MarketSearchResult searchStruct$MarketSearchResult) {
        searchStruct$MarketSearchResult.getClass();
        ensureMarketResultsIsMutable();
        this.marketResults_.set(i, searchStruct$MarketSearchResult);
    }

    private void setResultCount(int i) {
        this.resultCount_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (L1.a[gVar.ordinal()]) {
            case 1:
                return new SearchOuterClass$ResponseSearchMarket();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001\u001b\u0002ဉ\u0000\u0003ဉ\u0001\u0004\u0004", new Object[]{"bitField0_", "marketResults_", SearchStruct$MarketSearchResult.class, "category_", "loadMoreState_", "resultCount_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SearchOuterClass$ResponseSearchMarket.class) {
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

    public MarketStruct$MarketCategory getCategory() {
        MarketStruct$MarketCategory marketStruct$MarketCategory = this.category_;
        return marketStruct$MarketCategory == null ? MarketStruct$MarketCategory.getDefaultInstance() : marketStruct$MarketCategory;
    }

    public BytesValue getLoadMoreState() {
        BytesValue bytesValue = this.loadMoreState_;
        return bytesValue == null ? BytesValue.getDefaultInstance() : bytesValue;
    }

    public SearchStruct$MarketSearchResult getMarketResults(int i) {
        return (SearchStruct$MarketSearchResult) this.marketResults_.get(i);
    }

    public int getMarketResultsCount() {
        return this.marketResults_.size();
    }

    public List<SearchStruct$MarketSearchResult> getMarketResultsList() {
        return this.marketResults_;
    }

    public InterfaceC25078zh6 getMarketResultsOrBuilder(int i) {
        return (InterfaceC25078zh6) this.marketResults_.get(i);
    }

    public List<? extends InterfaceC25078zh6> getMarketResultsOrBuilderList() {
        return this.marketResults_;
    }

    public int getResultCount() {
        return this.resultCount_;
    }

    public boolean hasCategory() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasLoadMoreState() {
        return (this.bitField0_ & 2) != 0;
    }

    public static a newBuilder(SearchOuterClass$ResponseSearchMarket searchOuterClass$ResponseSearchMarket) {
        return (a) DEFAULT_INSTANCE.createBuilder(searchOuterClass$ResponseSearchMarket);
    }

    public static SearchOuterClass$ResponseSearchMarket parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SearchOuterClass$ResponseSearchMarket) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SearchOuterClass$ResponseSearchMarket parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SearchOuterClass$ResponseSearchMarket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SearchOuterClass$ResponseSearchMarket parseFrom(AbstractC2383g abstractC2383g) {
        return (SearchOuterClass$ResponseSearchMarket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addMarketResults(int i, SearchStruct$MarketSearchResult searchStruct$MarketSearchResult) {
        searchStruct$MarketSearchResult.getClass();
        ensureMarketResultsIsMutable();
        this.marketResults_.add(i, searchStruct$MarketSearchResult);
    }

    public static SearchOuterClass$ResponseSearchMarket parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SearchOuterClass$ResponseSearchMarket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SearchOuterClass$ResponseSearchMarket parseFrom(byte[] bArr) {
        return (SearchOuterClass$ResponseSearchMarket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SearchOuterClass$ResponseSearchMarket parseFrom(byte[] bArr, C2394s c2394s) {
        return (SearchOuterClass$ResponseSearchMarket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SearchOuterClass$ResponseSearchMarket parseFrom(InputStream inputStream) {
        return (SearchOuterClass$ResponseSearchMarket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SearchOuterClass$ResponseSearchMarket parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SearchOuterClass$ResponseSearchMarket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SearchOuterClass$ResponseSearchMarket parseFrom(AbstractC2384h abstractC2384h) {
        return (SearchOuterClass$ResponseSearchMarket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SearchOuterClass$ResponseSearchMarket parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SearchOuterClass$ResponseSearchMarket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
