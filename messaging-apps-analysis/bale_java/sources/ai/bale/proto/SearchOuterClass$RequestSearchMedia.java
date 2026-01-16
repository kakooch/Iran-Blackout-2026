package ai.bale.proto;

import ai.bale.proto.CollectionsStruct$Int64Value;
import ai.bale.proto.SearchStruct$SearchCondition;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC16902m35;
import ir.nasim.EnumC6845Pf4;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class SearchOuterClass$RequestSearchMedia extends GeneratedMessageLite implements U64 {
    public static final int DATE_FIELD_NUMBER = 2;
    private static final SearchOuterClass$RequestSearchMedia DEFAULT_INSTANCE;
    public static final int LOAD_MODE_FIELD_NUMBER = 4;
    public static final int OPTIMIZATIONS_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER = null;
    public static final int QUERY_FIELD_NUMBER = 1;
    private static final B.h.a optimizations_converter_ = new a();
    private int bitField0_;
    private CollectionsStruct$Int64Value date_;
    private int loadMode_;
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
        private b() {
            super(SearchOuterClass$RequestSearchMedia.DEFAULT_INSTANCE);
        }
    }

    static {
        SearchOuterClass$RequestSearchMedia searchOuterClass$RequestSearchMedia = new SearchOuterClass$RequestSearchMedia();
        DEFAULT_INSTANCE = searchOuterClass$RequestSearchMedia;
        GeneratedMessageLite.registerDefaultInstance(SearchOuterClass$RequestSearchMedia.class, searchOuterClass$RequestSearchMedia);
    }

    private SearchOuterClass$RequestSearchMedia() {
    }

    private void addAllOptimizations(Iterable<? extends EnumC16902m35> iterable) {
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

    private void clearDate() {
        this.date_ = null;
        this.bitField0_ &= -3;
    }

    private void clearLoadMode() {
        this.loadMode_ = 0;
    }

    private void clearOptimizations() {
        this.optimizations_ = GeneratedMessageLite.emptyIntList();
    }

    private void clearQuery() {
        this.query_ = null;
        this.bitField0_ &= -2;
    }

    private void ensureOptimizationsIsMutable() {
        B.g gVar = this.optimizations_;
        if (gVar.u()) {
            return;
        }
        this.optimizations_ = GeneratedMessageLite.mutableCopy(gVar);
    }

    public static SearchOuterClass$RequestSearchMedia getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeDate(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        collectionsStruct$Int64Value.getClass();
        CollectionsStruct$Int64Value collectionsStruct$Int64Value2 = this.date_;
        if (collectionsStruct$Int64Value2 == null || collectionsStruct$Int64Value2 == CollectionsStruct$Int64Value.getDefaultInstance()) {
            this.date_ = collectionsStruct$Int64Value;
        } else {
            this.date_ = (CollectionsStruct$Int64Value) ((CollectionsStruct$Int64Value.a) CollectionsStruct$Int64Value.newBuilder(this.date_).v(collectionsStruct$Int64Value)).j();
        }
        this.bitField0_ |= 2;
    }

    private void mergeQuery(SearchStruct$SearchCondition searchStruct$SearchCondition) {
        searchStruct$SearchCondition.getClass();
        SearchStruct$SearchCondition searchStruct$SearchCondition2 = this.query_;
        if (searchStruct$SearchCondition2 == null || searchStruct$SearchCondition2 == SearchStruct$SearchCondition.getDefaultInstance()) {
            this.query_ = searchStruct$SearchCondition;
        } else {
            this.query_ = (SearchStruct$SearchCondition) ((SearchStruct$SearchCondition.a) SearchStruct$SearchCondition.newBuilder(this.query_).v(searchStruct$SearchCondition)).j();
        }
        this.bitField0_ |= 1;
    }

    public static b newBuilder() {
        return (b) DEFAULT_INSTANCE.createBuilder();
    }

    public static SearchOuterClass$RequestSearchMedia parseDelimitedFrom(InputStream inputStream) {
        return (SearchOuterClass$RequestSearchMedia) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SearchOuterClass$RequestSearchMedia parseFrom(ByteBuffer byteBuffer) {
        return (SearchOuterClass$RequestSearchMedia) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setDate(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        collectionsStruct$Int64Value.getClass();
        this.date_ = collectionsStruct$Int64Value;
        this.bitField0_ |= 2;
    }

    private void setLoadMode(EnumC6845Pf4 enumC6845Pf4) {
        this.loadMode_ = enumC6845Pf4.getNumber();
    }

    private void setLoadModeValue(int i) {
        this.loadMode_ = i;
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
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (L1.a[gVar.ordinal()]) {
            case 1:
                return new SearchOuterClass$RequestSearchMedia();
            case 2:
                return new b();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003,\u0004\f", new Object[]{"bitField0_", "query_", "date_", "optimizations_", "loadMode_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SearchOuterClass$RequestSearchMedia.class) {
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

    public CollectionsStruct$Int64Value getDate() {
        CollectionsStruct$Int64Value collectionsStruct$Int64Value = this.date_;
        return collectionsStruct$Int64Value == null ? CollectionsStruct$Int64Value.getDefaultInstance() : collectionsStruct$Int64Value;
    }

    public EnumC6845Pf4 getLoadMode() {
        EnumC6845Pf4 enumC6845Pf4J = EnumC6845Pf4.j(this.loadMode_);
        return enumC6845Pf4J == null ? EnumC6845Pf4.UNRECOGNIZED : enumC6845Pf4J;
    }

    public int getLoadModeValue() {
        return this.loadMode_;
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

    public boolean hasDate() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasQuery() {
        return (this.bitField0_ & 1) != 0;
    }

    public static b newBuilder(SearchOuterClass$RequestSearchMedia searchOuterClass$RequestSearchMedia) {
        return (b) DEFAULT_INSTANCE.createBuilder(searchOuterClass$RequestSearchMedia);
    }

    public static SearchOuterClass$RequestSearchMedia parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SearchOuterClass$RequestSearchMedia) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SearchOuterClass$RequestSearchMedia parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SearchOuterClass$RequestSearchMedia) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SearchOuterClass$RequestSearchMedia parseFrom(AbstractC2383g abstractC2383g) {
        return (SearchOuterClass$RequestSearchMedia) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static SearchOuterClass$RequestSearchMedia parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SearchOuterClass$RequestSearchMedia) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SearchOuterClass$RequestSearchMedia parseFrom(byte[] bArr) {
        return (SearchOuterClass$RequestSearchMedia) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SearchOuterClass$RequestSearchMedia parseFrom(byte[] bArr, C2394s c2394s) {
        return (SearchOuterClass$RequestSearchMedia) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SearchOuterClass$RequestSearchMedia parseFrom(InputStream inputStream) {
        return (SearchOuterClass$RequestSearchMedia) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SearchOuterClass$RequestSearchMedia parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SearchOuterClass$RequestSearchMedia) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SearchOuterClass$RequestSearchMedia parseFrom(AbstractC2384h abstractC2384h) {
        return (SearchOuterClass$RequestSearchMedia) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SearchOuterClass$RequestSearchMedia parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SearchOuterClass$RequestSearchMedia) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
