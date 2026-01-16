package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.BytesValue;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC22708vh6;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes.dex */
public final class SearchOuterClass$ResponseSearchContent extends GeneratedMessageLite implements U64 {
    public static final int CONTENT_RESULTS_FIELD_NUMBER = 1;
    private static final SearchOuterClass$ResponseSearchContent DEFAULT_INSTANCE;
    public static final int LOAD_MORE_STATE_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int RESULT_COUNT_FIELD_NUMBER = 3;
    private int bitField0_;
    private B.j contentResults_ = GeneratedMessageLite.emptyProtobufList();
    private BytesValue loadMoreState_;
    private int resultCount_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(SearchOuterClass$ResponseSearchContent.DEFAULT_INSTANCE);
        }
    }

    static {
        SearchOuterClass$ResponseSearchContent searchOuterClass$ResponseSearchContent = new SearchOuterClass$ResponseSearchContent();
        DEFAULT_INSTANCE = searchOuterClass$ResponseSearchContent;
        GeneratedMessageLite.registerDefaultInstance(SearchOuterClass$ResponseSearchContent.class, searchOuterClass$ResponseSearchContent);
    }

    private SearchOuterClass$ResponseSearchContent() {
    }

    private void addAllContentResults(Iterable<? extends SearchStruct$ContentSearchResult> iterable) {
        ensureContentResultsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.contentResults_);
    }

    private void addContentResults(SearchStruct$ContentSearchResult searchStruct$ContentSearchResult) {
        searchStruct$ContentSearchResult.getClass();
        ensureContentResultsIsMutable();
        this.contentResults_.add(searchStruct$ContentSearchResult);
    }

    private void clearContentResults() {
        this.contentResults_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearLoadMoreState() {
        this.loadMoreState_ = null;
        this.bitField0_ &= -2;
    }

    private void clearResultCount() {
        this.resultCount_ = 0;
    }

    private void ensureContentResultsIsMutable() {
        B.j jVar = this.contentResults_;
        if (jVar.u()) {
            return;
        }
        this.contentResults_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static SearchOuterClass$ResponseSearchContent getDefaultInstance() {
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

    public static SearchOuterClass$ResponseSearchContent parseDelimitedFrom(InputStream inputStream) {
        return (SearchOuterClass$ResponseSearchContent) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SearchOuterClass$ResponseSearchContent parseFrom(ByteBuffer byteBuffer) {
        return (SearchOuterClass$ResponseSearchContent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeContentResults(int i) {
        ensureContentResultsIsMutable();
        this.contentResults_.remove(i);
    }

    private void setContentResults(int i, SearchStruct$ContentSearchResult searchStruct$ContentSearchResult) {
        searchStruct$ContentSearchResult.getClass();
        ensureContentResultsIsMutable();
        this.contentResults_.set(i, searchStruct$ContentSearchResult);
    }

    private void setLoadMoreState(BytesValue bytesValue) {
        bytesValue.getClass();
        this.loadMoreState_ = bytesValue;
        this.bitField0_ |= 1;
    }

    private void setResultCount(int i) {
        this.resultCount_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (L1.a[gVar.ordinal()]) {
            case 1:
                return new SearchOuterClass$ResponseSearchContent();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001\u001b\u0002ဉ\u0000\u0003\u0004", new Object[]{"bitField0_", "contentResults_", SearchStruct$ContentSearchResult.class, "loadMoreState_", "resultCount_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SearchOuterClass$ResponseSearchContent.class) {
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

    public SearchStruct$ContentSearchResult getContentResults(int i) {
        return (SearchStruct$ContentSearchResult) this.contentResults_.get(i);
    }

    public int getContentResultsCount() {
        return this.contentResults_.size();
    }

    public List<SearchStruct$ContentSearchResult> getContentResultsList() {
        return this.contentResults_;
    }

    public InterfaceC22708vh6 getContentResultsOrBuilder(int i) {
        return (InterfaceC22708vh6) this.contentResults_.get(i);
    }

    public List<? extends InterfaceC22708vh6> getContentResultsOrBuilderList() {
        return this.contentResults_;
    }

    public BytesValue getLoadMoreState() {
        BytesValue bytesValue = this.loadMoreState_;
        return bytesValue == null ? BytesValue.getDefaultInstance() : bytesValue;
    }

    public int getResultCount() {
        return this.resultCount_;
    }

    public boolean hasLoadMoreState() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(SearchOuterClass$ResponseSearchContent searchOuterClass$ResponseSearchContent) {
        return (a) DEFAULT_INSTANCE.createBuilder(searchOuterClass$ResponseSearchContent);
    }

    public static SearchOuterClass$ResponseSearchContent parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SearchOuterClass$ResponseSearchContent) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SearchOuterClass$ResponseSearchContent parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SearchOuterClass$ResponseSearchContent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SearchOuterClass$ResponseSearchContent parseFrom(AbstractC2383g abstractC2383g) {
        return (SearchOuterClass$ResponseSearchContent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addContentResults(int i, SearchStruct$ContentSearchResult searchStruct$ContentSearchResult) {
        searchStruct$ContentSearchResult.getClass();
        ensureContentResultsIsMutable();
        this.contentResults_.add(i, searchStruct$ContentSearchResult);
    }

    public static SearchOuterClass$ResponseSearchContent parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SearchOuterClass$ResponseSearchContent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SearchOuterClass$ResponseSearchContent parseFrom(byte[] bArr) {
        return (SearchOuterClass$ResponseSearchContent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SearchOuterClass$ResponseSearchContent parseFrom(byte[] bArr, C2394s c2394s) {
        return (SearchOuterClass$ResponseSearchContent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SearchOuterClass$ResponseSearchContent parseFrom(InputStream inputStream) {
        return (SearchOuterClass$ResponseSearchContent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SearchOuterClass$ResponseSearchContent parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SearchOuterClass$ResponseSearchContent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SearchOuterClass$ResponseSearchContent parseFrom(AbstractC2384h abstractC2384h) {
        return (SearchOuterClass$ResponseSearchContent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SearchOuterClass$ResponseSearchContent parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SearchOuterClass$ResponseSearchContent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
