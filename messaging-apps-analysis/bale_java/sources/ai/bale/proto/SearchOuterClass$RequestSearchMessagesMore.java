package ai.bale.proto;

import ai.bale.proto.SearchStruct$SearchCondition;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.BytesValue;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC16902m35;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class SearchOuterClass$RequestSearchMessagesMore extends GeneratedMessageLite implements U64 {
    private static final SearchOuterClass$RequestSearchMessagesMore DEFAULT_INSTANCE;
    public static final int LOAD_MORE_STATE_FIELD_NUMBER = 1;
    public static final int OPTIMIZATIONS_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER = null;
    public static final int QUERY_FIELD_NUMBER = 2;
    private static final B.h.a optimizations_converter_ = new a();
    private int bitField0_;
    private BytesValue loadMoreState_;
    private int optimizationsMemoizedSerializedSize;
    private B.g optimizations_ = GeneratedMessageLite.emptyIntList();
    private SearchStruct$SearchCondition query_;

    class a implements B.h.a {
        a() {
        }

        @Override // com.google.protobuf.B.h.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC16902m35 a(Integer num) {
            EnumC16902m35 enumC16902m35J = EnumC16902m35.j(num.intValue());
            return enumC16902m35J == null ? EnumC16902m35.UNRECOGNIZED : enumC16902m35J;
        }
    }

    public static final class b extends GeneratedMessageLite.b implements U64 {
        public b A(Iterable iterable) {
            q();
            ((SearchOuterClass$RequestSearchMessagesMore) this.b).addAllOptimizations(iterable);
            return this;
        }

        public b B(BytesValue bytesValue) {
            q();
            ((SearchOuterClass$RequestSearchMessagesMore) this.b).setLoadMoreState(bytesValue);
            return this;
        }

        private b() {
            super(SearchOuterClass$RequestSearchMessagesMore.DEFAULT_INSTANCE);
        }
    }

    static {
        SearchOuterClass$RequestSearchMessagesMore searchOuterClass$RequestSearchMessagesMore = new SearchOuterClass$RequestSearchMessagesMore();
        DEFAULT_INSTANCE = searchOuterClass$RequestSearchMessagesMore;
        GeneratedMessageLite.registerDefaultInstance(SearchOuterClass$RequestSearchMessagesMore.class, searchOuterClass$RequestSearchMessagesMore);
    }

    private SearchOuterClass$RequestSearchMessagesMore() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllOptimizations(Iterable<? extends EnumC16902m35> iterable) {
        ensureOptimizationsIsMutable();
        Iterator<? extends EnumC16902m35> it = iterable.iterator();
        while (it.hasNext()) {
            this.optimizations_.b1(it.next().getNumber());
        }
    }

    private void addAllOptimizationsValue(Iterable<Integer> iterable) {
        ensureOptimizationsIsMutable();
        Iterator<Integer> it = iterable.iterator();
        while (it.hasNext()) {
            this.optimizations_.b1(it.next().intValue());
        }
    }

    private void addOptimizations(EnumC16902m35 enumC16902m35) {
        enumC16902m35.getClass();
        ensureOptimizationsIsMutable();
        this.optimizations_.b1(enumC16902m35.getNumber());
    }

    private void addOptimizationsValue(int i) {
        ensureOptimizationsIsMutable();
        this.optimizations_.b1(i);
    }

    private void clearLoadMoreState() {
        this.loadMoreState_ = null;
        this.bitField0_ &= -2;
    }

    private void clearOptimizations() {
        this.optimizations_ = GeneratedMessageLite.emptyIntList();
    }

    private void clearQuery() {
        this.query_ = null;
        this.bitField0_ &= -3;
    }

    private void ensureOptimizationsIsMutable() {
        B.g gVar = this.optimizations_;
        if (gVar.u()) {
            return;
        }
        this.optimizations_ = GeneratedMessageLite.mutableCopy(gVar);
    }

    public static SearchOuterClass$RequestSearchMessagesMore getDefaultInstance() {
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

    private void mergeQuery(SearchStruct$SearchCondition searchStruct$SearchCondition) {
        searchStruct$SearchCondition.getClass();
        SearchStruct$SearchCondition searchStruct$SearchCondition2 = this.query_;
        if (searchStruct$SearchCondition2 == null || searchStruct$SearchCondition2 == SearchStruct$SearchCondition.getDefaultInstance()) {
            this.query_ = searchStruct$SearchCondition;
        } else {
            this.query_ = (SearchStruct$SearchCondition) ((SearchStruct$SearchCondition.a) SearchStruct$SearchCondition.newBuilder(this.query_).v(searchStruct$SearchCondition)).j();
        }
        this.bitField0_ |= 2;
    }

    public static b newBuilder() {
        return (b) DEFAULT_INSTANCE.createBuilder();
    }

    public static SearchOuterClass$RequestSearchMessagesMore parseDelimitedFrom(InputStream inputStream) {
        return (SearchOuterClass$RequestSearchMessagesMore) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SearchOuterClass$RequestSearchMessagesMore parseFrom(ByteBuffer byteBuffer) {
        return (SearchOuterClass$RequestSearchMessagesMore) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLoadMoreState(BytesValue bytesValue) {
        bytesValue.getClass();
        this.loadMoreState_ = bytesValue;
        this.bitField0_ |= 1;
    }

    private void setOptimizations(int i, EnumC16902m35 enumC16902m35) {
        enumC16902m35.getClass();
        ensureOptimizationsIsMutable();
        this.optimizations_.U(i, enumC16902m35.getNumber());
    }

    private void setOptimizationsValue(int i, int i2) {
        ensureOptimizationsIsMutable();
        this.optimizations_.U(i, i2);
    }

    private void setQuery(SearchStruct$SearchCondition searchStruct$SearchCondition) {
        searchStruct$SearchCondition.getClass();
        this.query_ = searchStruct$SearchCondition;
        this.bitField0_ |= 2;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (L1.a[gVar.ordinal()]) {
            case 1:
                return new SearchOuterClass$RequestSearchMessagesMore();
            case 2:
                return new b();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003,", new Object[]{"bitField0_", "loadMoreState_", "query_", "optimizations_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SearchOuterClass$RequestSearchMessagesMore.class) {
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

    public EnumC16902m35 getOptimizations(int i) {
        EnumC16902m35 enumC16902m35J = EnumC16902m35.j(this.optimizations_.getInt(i));
        return enumC16902m35J == null ? EnumC16902m35.UNRECOGNIZED : enumC16902m35J;
    }

    public int getOptimizationsCount() {
        return this.optimizations_.size();
    }

    public List<EnumC16902m35> getOptimizationsList() {
        return new B.h(this.optimizations_, optimizations_converter_);
    }

    public int getOptimizationsValue(int i) {
        return this.optimizations_.getInt(i);
    }

    public List<Integer> getOptimizationsValueList() {
        return this.optimizations_;
    }

    public SearchStruct$SearchCondition getQuery() {
        SearchStruct$SearchCondition searchStruct$SearchCondition = this.query_;
        return searchStruct$SearchCondition == null ? SearchStruct$SearchCondition.getDefaultInstance() : searchStruct$SearchCondition;
    }

    public boolean hasLoadMoreState() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasQuery() {
        return (this.bitField0_ & 2) != 0;
    }

    public static b newBuilder(SearchOuterClass$RequestSearchMessagesMore searchOuterClass$RequestSearchMessagesMore) {
        return (b) DEFAULT_INSTANCE.createBuilder(searchOuterClass$RequestSearchMessagesMore);
    }

    public static SearchOuterClass$RequestSearchMessagesMore parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SearchOuterClass$RequestSearchMessagesMore) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SearchOuterClass$RequestSearchMessagesMore parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SearchOuterClass$RequestSearchMessagesMore) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SearchOuterClass$RequestSearchMessagesMore parseFrom(AbstractC2383g abstractC2383g) {
        return (SearchOuterClass$RequestSearchMessagesMore) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static SearchOuterClass$RequestSearchMessagesMore parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SearchOuterClass$RequestSearchMessagesMore) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SearchOuterClass$RequestSearchMessagesMore parseFrom(byte[] bArr) {
        return (SearchOuterClass$RequestSearchMessagesMore) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SearchOuterClass$RequestSearchMessagesMore parseFrom(byte[] bArr, C2394s c2394s) {
        return (SearchOuterClass$RequestSearchMessagesMore) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SearchOuterClass$RequestSearchMessagesMore parseFrom(InputStream inputStream) {
        return (SearchOuterClass$RequestSearchMessagesMore) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SearchOuterClass$RequestSearchMessagesMore parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SearchOuterClass$RequestSearchMessagesMore) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SearchOuterClass$RequestSearchMessagesMore parseFrom(AbstractC2384h abstractC2384h) {
        return (SearchOuterClass$RequestSearchMessagesMore) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SearchOuterClass$RequestSearchMessagesMore parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SearchOuterClass$RequestSearchMessagesMore) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
