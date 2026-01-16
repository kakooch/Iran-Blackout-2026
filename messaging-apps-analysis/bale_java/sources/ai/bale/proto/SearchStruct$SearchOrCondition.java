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
public final class SearchStruct$SearchOrCondition extends GeneratedMessageLite implements U64 {
    private static final SearchStruct$SearchOrCondition DEFAULT_INSTANCE;
    public static final int OR_QUERY_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER;
    private B.j orQuery_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(SearchStruct$SearchOrCondition.DEFAULT_INSTANCE);
        }
    }

    static {
        SearchStruct$SearchOrCondition searchStruct$SearchOrCondition = new SearchStruct$SearchOrCondition();
        DEFAULT_INSTANCE = searchStruct$SearchOrCondition;
        GeneratedMessageLite.registerDefaultInstance(SearchStruct$SearchOrCondition.class, searchStruct$SearchOrCondition);
    }

    private SearchStruct$SearchOrCondition() {
    }

    private void addAllOrQuery(Iterable<? extends SearchStruct$SearchCondition> iterable) {
        ensureOrQueryIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.orQuery_);
    }

    private void addOrQuery(SearchStruct$SearchCondition searchStruct$SearchCondition) {
        searchStruct$SearchCondition.getClass();
        ensureOrQueryIsMutable();
        this.orQuery_.add(searchStruct$SearchCondition);
    }

    private void clearOrQuery() {
        this.orQuery_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureOrQueryIsMutable() {
        B.j jVar = this.orQuery_;
        if (jVar.u()) {
            return;
        }
        this.orQuery_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static SearchStruct$SearchOrCondition getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SearchStruct$SearchOrCondition parseDelimitedFrom(InputStream inputStream) {
        return (SearchStruct$SearchOrCondition) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SearchStruct$SearchOrCondition parseFrom(ByteBuffer byteBuffer) {
        return (SearchStruct$SearchOrCondition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeOrQuery(int i) {
        ensureOrQueryIsMutable();
        this.orQuery_.remove(i);
    }

    private void setOrQuery(int i, SearchStruct$SearchCondition searchStruct$SearchCondition) {
        searchStruct$SearchCondition.getClass();
        ensureOrQueryIsMutable();
        this.orQuery_.set(i, searchStruct$SearchCondition);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (M1.a[gVar.ordinal()]) {
            case 1:
                return new SearchStruct$SearchOrCondition();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0002\u0002\u0001\u0000\u0001\u0000\u0002\u001b", new Object[]{"orQuery_", SearchStruct$SearchCondition.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SearchStruct$SearchOrCondition.class) {
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

    public SearchStruct$SearchCondition getOrQuery(int i) {
        return (SearchStruct$SearchCondition) this.orQuery_.get(i);
    }

    public int getOrQueryCount() {
        return this.orQuery_.size();
    }

    public List<SearchStruct$SearchCondition> getOrQueryList() {
        return this.orQuery_;
    }

    public O1 getOrQueryOrBuilder(int i) {
        return (O1) this.orQuery_.get(i);
    }

    public List<? extends O1> getOrQueryOrBuilderList() {
        return this.orQuery_;
    }

    public static a newBuilder(SearchStruct$SearchOrCondition searchStruct$SearchOrCondition) {
        return (a) DEFAULT_INSTANCE.createBuilder(searchStruct$SearchOrCondition);
    }

    public static SearchStruct$SearchOrCondition parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SearchStruct$SearchOrCondition) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SearchStruct$SearchOrCondition parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SearchStruct$SearchOrCondition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SearchStruct$SearchOrCondition parseFrom(AbstractC2383g abstractC2383g) {
        return (SearchStruct$SearchOrCondition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addOrQuery(int i, SearchStruct$SearchCondition searchStruct$SearchCondition) {
        searchStruct$SearchCondition.getClass();
        ensureOrQueryIsMutable();
        this.orQuery_.add(i, searchStruct$SearchCondition);
    }

    public static SearchStruct$SearchOrCondition parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SearchStruct$SearchOrCondition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SearchStruct$SearchOrCondition parseFrom(byte[] bArr) {
        return (SearchStruct$SearchOrCondition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SearchStruct$SearchOrCondition parseFrom(byte[] bArr, C2394s c2394s) {
        return (SearchStruct$SearchOrCondition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SearchStruct$SearchOrCondition parseFrom(InputStream inputStream) {
        return (SearchStruct$SearchOrCondition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SearchStruct$SearchOrCondition parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SearchStruct$SearchOrCondition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SearchStruct$SearchOrCondition parseFrom(AbstractC2384h abstractC2384h) {
        return (SearchStruct$SearchOrCondition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SearchStruct$SearchOrCondition parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SearchStruct$SearchOrCondition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
