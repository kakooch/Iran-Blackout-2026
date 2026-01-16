package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.BytesValue;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC5197Ih6;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes.dex */
public final class SearchOuterClass$ResponseSearchProduct extends GeneratedMessageLite implements U64 {
    private static final SearchOuterClass$ResponseSearchProduct DEFAULT_INSTANCE;
    public static final int LOAD_MORE_STATE_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int PRODUCT_RESULTS_FIELD_NUMBER = 1;
    public static final int RESULT_COUNT_FIELD_NUMBER = 3;
    private int bitField0_;
    private BytesValue loadMoreState_;
    private B.j productResults_ = GeneratedMessageLite.emptyProtobufList();
    private int resultCount_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(SearchOuterClass$ResponseSearchProduct.DEFAULT_INSTANCE);
        }
    }

    static {
        SearchOuterClass$ResponseSearchProduct searchOuterClass$ResponseSearchProduct = new SearchOuterClass$ResponseSearchProduct();
        DEFAULT_INSTANCE = searchOuterClass$ResponseSearchProduct;
        GeneratedMessageLite.registerDefaultInstance(SearchOuterClass$ResponseSearchProduct.class, searchOuterClass$ResponseSearchProduct);
    }

    private SearchOuterClass$ResponseSearchProduct() {
    }

    private void addAllProductResults(Iterable<? extends SearchStruct$ProductSearchResult> iterable) {
        ensureProductResultsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.productResults_);
    }

    private void addProductResults(SearchStruct$ProductSearchResult searchStruct$ProductSearchResult) {
        searchStruct$ProductSearchResult.getClass();
        ensureProductResultsIsMutable();
        this.productResults_.add(searchStruct$ProductSearchResult);
    }

    private void clearLoadMoreState() {
        this.loadMoreState_ = null;
        this.bitField0_ &= -2;
    }

    private void clearProductResults() {
        this.productResults_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearResultCount() {
        this.resultCount_ = 0;
    }

    private void ensureProductResultsIsMutable() {
        B.j jVar = this.productResults_;
        if (jVar.u()) {
            return;
        }
        this.productResults_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static SearchOuterClass$ResponseSearchProduct getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeLoadMoreState(BytesValue bytesValue) {
        bytesValue.getClass();
        BytesValue bytesValue2 = this.loadMoreState_;
        if (bytesValue2 == null || bytesValue2 == BytesValue.getDefaultInstance()) {
            this.loadMoreState_ = bytesValue;
        } else {
            this.loadMoreState_ = (BytesValue) ((BytesValue.b) BytesValue.newBuilder(this.loadMoreState_).v(bytesValue)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SearchOuterClass$ResponseSearchProduct parseDelimitedFrom(InputStream inputStream) {
        return (SearchOuterClass$ResponseSearchProduct) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SearchOuterClass$ResponseSearchProduct parseFrom(ByteBuffer byteBuffer) {
        return (SearchOuterClass$ResponseSearchProduct) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeProductResults(int i) {
        ensureProductResultsIsMutable();
        this.productResults_.remove(i);
    }

    private void setLoadMoreState(BytesValue bytesValue) {
        bytesValue.getClass();
        this.loadMoreState_ = bytesValue;
        this.bitField0_ |= 1;
    }

    private void setProductResults(int i, SearchStruct$ProductSearchResult searchStruct$ProductSearchResult) {
        searchStruct$ProductSearchResult.getClass();
        ensureProductResultsIsMutable();
        this.productResults_.set(i, searchStruct$ProductSearchResult);
    }

    private void setResultCount(int i) {
        this.resultCount_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (L1.a[gVar.ordinal()]) {
            case 1:
                return new SearchOuterClass$ResponseSearchProduct();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001\u001b\u0002ဉ\u0000\u0003\u0004", new Object[]{"bitField0_", "productResults_", SearchStruct$ProductSearchResult.class, "loadMoreState_", "resultCount_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SearchOuterClass$ResponseSearchProduct.class) {
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

    public BytesValue getLoadMoreState() {
        BytesValue bytesValue = this.loadMoreState_;
        return bytesValue == null ? BytesValue.getDefaultInstance() : bytesValue;
    }

    public SearchStruct$ProductSearchResult getProductResults(int i) {
        return (SearchStruct$ProductSearchResult) this.productResults_.get(i);
    }

    public int getProductResultsCount() {
        return this.productResults_.size();
    }

    public List<SearchStruct$ProductSearchResult> getProductResultsList() {
        return this.productResults_;
    }

    public InterfaceC5197Ih6 getProductResultsOrBuilder(int i) {
        return (InterfaceC5197Ih6) this.productResults_.get(i);
    }

    public List<? extends InterfaceC5197Ih6> getProductResultsOrBuilderList() {
        return this.productResults_;
    }

    public int getResultCount() {
        return this.resultCount_;
    }

    public boolean hasLoadMoreState() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(SearchOuterClass$ResponseSearchProduct searchOuterClass$ResponseSearchProduct) {
        return (a) DEFAULT_INSTANCE.createBuilder(searchOuterClass$ResponseSearchProduct);
    }

    public static SearchOuterClass$ResponseSearchProduct parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SearchOuterClass$ResponseSearchProduct) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SearchOuterClass$ResponseSearchProduct parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SearchOuterClass$ResponseSearchProduct) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SearchOuterClass$ResponseSearchProduct parseFrom(AbstractC2383g abstractC2383g) {
        return (SearchOuterClass$ResponseSearchProduct) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addProductResults(int i, SearchStruct$ProductSearchResult searchStruct$ProductSearchResult) {
        searchStruct$ProductSearchResult.getClass();
        ensureProductResultsIsMutable();
        this.productResults_.add(i, searchStruct$ProductSearchResult);
    }

    public static SearchOuterClass$ResponseSearchProduct parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SearchOuterClass$ResponseSearchProduct) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SearchOuterClass$ResponseSearchProduct parseFrom(byte[] bArr) {
        return (SearchOuterClass$ResponseSearchProduct) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SearchOuterClass$ResponseSearchProduct parseFrom(byte[] bArr, C2394s c2394s) {
        return (SearchOuterClass$ResponseSearchProduct) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SearchOuterClass$ResponseSearchProduct parseFrom(InputStream inputStream) {
        return (SearchOuterClass$ResponseSearchProduct) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SearchOuterClass$ResponseSearchProduct parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SearchOuterClass$ResponseSearchProduct) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SearchOuterClass$ResponseSearchProduct parseFrom(AbstractC2384h abstractC2384h) {
        return (SearchOuterClass$ResponseSearchProduct) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SearchOuterClass$ResponseSearchProduct parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SearchOuterClass$ResponseSearchProduct) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
