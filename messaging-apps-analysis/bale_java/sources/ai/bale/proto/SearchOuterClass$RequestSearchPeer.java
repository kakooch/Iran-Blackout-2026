package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
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
public final class SearchOuterClass$RequestSearchPeer extends GeneratedMessageLite implements U64 {
    private static final SearchOuterClass$RequestSearchPeer DEFAULT_INSTANCE;
    public static final int OPTIMIZATIONS_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int QUERY_FIELD_NUMBER = 1;
    private static final B.h.a optimizations_converter_ = new a();
    private int optimizationsMemoizedSerializedSize;
    private B.j query_ = GeneratedMessageLite.emptyProtobufList();
    private B.g optimizations_ = GeneratedMessageLite.emptyIntList();

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
            ((SearchOuterClass$RequestSearchPeer) this.b).addAllOptimizations(iterable);
            return this;
        }

        public b B(Iterable iterable) {
            q();
            ((SearchOuterClass$RequestSearchPeer) this.b).addAllQuery(iterable);
            return this;
        }

        private b() {
            super(SearchOuterClass$RequestSearchPeer.DEFAULT_INSTANCE);
        }
    }

    static {
        SearchOuterClass$RequestSearchPeer searchOuterClass$RequestSearchPeer = new SearchOuterClass$RequestSearchPeer();
        DEFAULT_INSTANCE = searchOuterClass$RequestSearchPeer;
        GeneratedMessageLite.registerDefaultInstance(SearchOuterClass$RequestSearchPeer.class, searchOuterClass$RequestSearchPeer);
    }

    private SearchOuterClass$RequestSearchPeer() {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllQuery(Iterable<? extends SearchStruct$SearchCondition> iterable) {
        ensureQueryIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.query_);
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

    private void addQuery(SearchStruct$SearchCondition searchStruct$SearchCondition) {
        searchStruct$SearchCondition.getClass();
        ensureQueryIsMutable();
        this.query_.add(searchStruct$SearchCondition);
    }

    private void clearOptimizations() {
        this.optimizations_ = GeneratedMessageLite.emptyIntList();
    }

    private void clearQuery() {
        this.query_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureOptimizationsIsMutable() {
        B.g gVar = this.optimizations_;
        if (gVar.u()) {
            return;
        }
        this.optimizations_ = GeneratedMessageLite.mutableCopy(gVar);
    }

    private void ensureQueryIsMutable() {
        B.j jVar = this.query_;
        if (jVar.u()) {
            return;
        }
        this.query_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static SearchOuterClass$RequestSearchPeer getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static b newBuilder() {
        return (b) DEFAULT_INSTANCE.createBuilder();
    }

    public static SearchOuterClass$RequestSearchPeer parseDelimitedFrom(InputStream inputStream) {
        return (SearchOuterClass$RequestSearchPeer) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SearchOuterClass$RequestSearchPeer parseFrom(ByteBuffer byteBuffer) {
        return (SearchOuterClass$RequestSearchPeer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeQuery(int i) {
        ensureQueryIsMutable();
        this.query_.remove(i);
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

    private void setQuery(int i, SearchStruct$SearchCondition searchStruct$SearchCondition) {
        searchStruct$SearchCondition.getClass();
        ensureQueryIsMutable();
        this.query_.set(i, searchStruct$SearchCondition);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (L1.a[gVar.ordinal()]) {
            case 1:
                return new SearchOuterClass$RequestSearchPeer();
            case 2:
                return new b();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0002\u0000\u0001\u001b\u0002,", new Object[]{"query_", SearchStruct$SearchCondition.class, "optimizations_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SearchOuterClass$RequestSearchPeer.class) {
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

    public SearchStruct$SearchCondition getQuery(int i) {
        return (SearchStruct$SearchCondition) this.query_.get(i);
    }

    public int getQueryCount() {
        return this.query_.size();
    }

    public List<SearchStruct$SearchCondition> getQueryList() {
        return this.query_;
    }

    public O1 getQueryOrBuilder(int i) {
        return (O1) this.query_.get(i);
    }

    public List<? extends O1> getQueryOrBuilderList() {
        return this.query_;
    }

    public static b newBuilder(SearchOuterClass$RequestSearchPeer searchOuterClass$RequestSearchPeer) {
        return (b) DEFAULT_INSTANCE.createBuilder(searchOuterClass$RequestSearchPeer);
    }

    public static SearchOuterClass$RequestSearchPeer parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SearchOuterClass$RequestSearchPeer) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SearchOuterClass$RequestSearchPeer parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SearchOuterClass$RequestSearchPeer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SearchOuterClass$RequestSearchPeer parseFrom(AbstractC2383g abstractC2383g) {
        return (SearchOuterClass$RequestSearchPeer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addQuery(int i, SearchStruct$SearchCondition searchStruct$SearchCondition) {
        searchStruct$SearchCondition.getClass();
        ensureQueryIsMutable();
        this.query_.add(i, searchStruct$SearchCondition);
    }

    public static SearchOuterClass$RequestSearchPeer parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SearchOuterClass$RequestSearchPeer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SearchOuterClass$RequestSearchPeer parseFrom(byte[] bArr) {
        return (SearchOuterClass$RequestSearchPeer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SearchOuterClass$RequestSearchPeer parseFrom(byte[] bArr, C2394s c2394s) {
        return (SearchOuterClass$RequestSearchPeer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SearchOuterClass$RequestSearchPeer parseFrom(InputStream inputStream) {
        return (SearchOuterClass$RequestSearchPeer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SearchOuterClass$RequestSearchPeer parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SearchOuterClass$RequestSearchPeer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SearchOuterClass$RequestSearchPeer parseFrom(AbstractC2384h abstractC2384h) {
        return (SearchOuterClass$RequestSearchPeer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SearchOuterClass$RequestSearchPeer parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SearchOuterClass$RequestSearchPeer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
