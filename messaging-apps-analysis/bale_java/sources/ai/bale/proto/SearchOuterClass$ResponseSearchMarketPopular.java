package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes.dex */
public final class SearchOuterClass$ResponseSearchMarketPopular extends GeneratedMessageLite implements U64 {
    private static final SearchOuterClass$ResponseSearchMarketPopular DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int POPULAR_RESULTS_FIELD_NUMBER = 1;
    private B.j popularResults_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(SearchOuterClass$ResponseSearchMarketPopular.DEFAULT_INSTANCE);
        }
    }

    static {
        SearchOuterClass$ResponseSearchMarketPopular searchOuterClass$ResponseSearchMarketPopular = new SearchOuterClass$ResponseSearchMarketPopular();
        DEFAULT_INSTANCE = searchOuterClass$ResponseSearchMarketPopular;
        GeneratedMessageLite.registerDefaultInstance(SearchOuterClass$ResponseSearchMarketPopular.class, searchOuterClass$ResponseSearchMarketPopular);
    }

    private SearchOuterClass$ResponseSearchMarketPopular() {
    }

    private void addAllPopularResults(Iterable<? extends SearchStruct$PopularResult> iterable) {
        ensurePopularResultsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.popularResults_);
    }

    private void addPopularResults(SearchStruct$PopularResult searchStruct$PopularResult) {
        searchStruct$PopularResult.getClass();
        ensurePopularResultsIsMutable();
        this.popularResults_.add(searchStruct$PopularResult);
    }

    private void clearPopularResults() {
        this.popularResults_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensurePopularResultsIsMutable() {
        B.j jVar = this.popularResults_;
        if (jVar.u()) {
            return;
        }
        this.popularResults_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static SearchOuterClass$ResponseSearchMarketPopular getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SearchOuterClass$ResponseSearchMarketPopular parseDelimitedFrom(InputStream inputStream) {
        return (SearchOuterClass$ResponseSearchMarketPopular) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SearchOuterClass$ResponseSearchMarketPopular parseFrom(ByteBuffer byteBuffer) {
        return (SearchOuterClass$ResponseSearchMarketPopular) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removePopularResults(int i) {
        ensurePopularResultsIsMutable();
        this.popularResults_.remove(i);
    }

    private void setPopularResults(int i, SearchStruct$PopularResult searchStruct$PopularResult) {
        searchStruct$PopularResult.getClass();
        ensurePopularResultsIsMutable();
        this.popularResults_.set(i, searchStruct$PopularResult);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (L1.a[gVar.ordinal()]) {
            case 1:
                return new SearchOuterClass$ResponseSearchMarketPopular();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"popularResults_", SearchStruct$PopularResult.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SearchOuterClass$ResponseSearchMarketPopular.class) {
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

    public SearchStruct$PopularResult getPopularResults(int i) {
        return (SearchStruct$PopularResult) this.popularResults_.get(i);
    }

    public int getPopularResultsCount() {
        return this.popularResults_.size();
    }

    public List<SearchStruct$PopularResult> getPopularResultsList() {
        return this.popularResults_;
    }

    public N1 getPopularResultsOrBuilder(int i) {
        return (N1) this.popularResults_.get(i);
    }

    public List<? extends N1> getPopularResultsOrBuilderList() {
        return this.popularResults_;
    }

    public static a newBuilder(SearchOuterClass$ResponseSearchMarketPopular searchOuterClass$ResponseSearchMarketPopular) {
        return (a) DEFAULT_INSTANCE.createBuilder(searchOuterClass$ResponseSearchMarketPopular);
    }

    public static SearchOuterClass$ResponseSearchMarketPopular parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SearchOuterClass$ResponseSearchMarketPopular) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SearchOuterClass$ResponseSearchMarketPopular parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SearchOuterClass$ResponseSearchMarketPopular) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SearchOuterClass$ResponseSearchMarketPopular parseFrom(AbstractC2383g abstractC2383g) {
        return (SearchOuterClass$ResponseSearchMarketPopular) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addPopularResults(int i, SearchStruct$PopularResult searchStruct$PopularResult) {
        searchStruct$PopularResult.getClass();
        ensurePopularResultsIsMutable();
        this.popularResults_.add(i, searchStruct$PopularResult);
    }

    public static SearchOuterClass$ResponseSearchMarketPopular parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SearchOuterClass$ResponseSearchMarketPopular) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SearchOuterClass$ResponseSearchMarketPopular parseFrom(byte[] bArr) {
        return (SearchOuterClass$ResponseSearchMarketPopular) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SearchOuterClass$ResponseSearchMarketPopular parseFrom(byte[] bArr, C2394s c2394s) {
        return (SearchOuterClass$ResponseSearchMarketPopular) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SearchOuterClass$ResponseSearchMarketPopular parseFrom(InputStream inputStream) {
        return (SearchOuterClass$ResponseSearchMarketPopular) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SearchOuterClass$ResponseSearchMarketPopular parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SearchOuterClass$ResponseSearchMarketPopular) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SearchOuterClass$ResponseSearchMarketPopular parseFrom(AbstractC2384h abstractC2384h) {
        return (SearchOuterClass$ResponseSearchMarketPopular) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SearchOuterClass$ResponseSearchMarketPopular parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SearchOuterClass$ResponseSearchMarketPopular) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
