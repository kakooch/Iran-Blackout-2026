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
public final class SearchStruct$SearchAndCondition extends GeneratedMessageLite implements U64 {
    public static final int AND_QUERY_FIELD_NUMBER = 1;
    private static final SearchStruct$SearchAndCondition DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private B.j andQuery_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(Iterable iterable) {
            q();
            ((SearchStruct$SearchAndCondition) this.b).addAllAndQuery(iterable);
            return this;
        }

        private a() {
            super(SearchStruct$SearchAndCondition.DEFAULT_INSTANCE);
        }
    }

    static {
        SearchStruct$SearchAndCondition searchStruct$SearchAndCondition = new SearchStruct$SearchAndCondition();
        DEFAULT_INSTANCE = searchStruct$SearchAndCondition;
        GeneratedMessageLite.registerDefaultInstance(SearchStruct$SearchAndCondition.class, searchStruct$SearchAndCondition);
    }

    private SearchStruct$SearchAndCondition() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllAndQuery(Iterable<? extends SearchStruct$SearchCondition> iterable) {
        ensureAndQueryIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.andQuery_);
    }

    private void addAndQuery(SearchStruct$SearchCondition searchStruct$SearchCondition) {
        searchStruct$SearchCondition.getClass();
        ensureAndQueryIsMutable();
        this.andQuery_.add(searchStruct$SearchCondition);
    }

    private void clearAndQuery() {
        this.andQuery_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureAndQueryIsMutable() {
        B.j jVar = this.andQuery_;
        if (jVar.u()) {
            return;
        }
        this.andQuery_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static SearchStruct$SearchAndCondition getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SearchStruct$SearchAndCondition parseDelimitedFrom(InputStream inputStream) {
        return (SearchStruct$SearchAndCondition) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SearchStruct$SearchAndCondition parseFrom(ByteBuffer byteBuffer) {
        return (SearchStruct$SearchAndCondition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeAndQuery(int i) {
        ensureAndQueryIsMutable();
        this.andQuery_.remove(i);
    }

    private void setAndQuery(int i, SearchStruct$SearchCondition searchStruct$SearchCondition) {
        searchStruct$SearchCondition.getClass();
        ensureAndQueryIsMutable();
        this.andQuery_.set(i, searchStruct$SearchCondition);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (M1.a[gVar.ordinal()]) {
            case 1:
                return new SearchStruct$SearchAndCondition();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"andQuery_", SearchStruct$SearchCondition.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SearchStruct$SearchAndCondition.class) {
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

    public SearchStruct$SearchCondition getAndQuery(int i) {
        return (SearchStruct$SearchCondition) this.andQuery_.get(i);
    }

    public int getAndQueryCount() {
        return this.andQuery_.size();
    }

    public List<SearchStruct$SearchCondition> getAndQueryList() {
        return this.andQuery_;
    }

    public O1 getAndQueryOrBuilder(int i) {
        return (O1) this.andQuery_.get(i);
    }

    public List<? extends O1> getAndQueryOrBuilderList() {
        return this.andQuery_;
    }

    public static a newBuilder(SearchStruct$SearchAndCondition searchStruct$SearchAndCondition) {
        return (a) DEFAULT_INSTANCE.createBuilder(searchStruct$SearchAndCondition);
    }

    public static SearchStruct$SearchAndCondition parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SearchStruct$SearchAndCondition) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SearchStruct$SearchAndCondition parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SearchStruct$SearchAndCondition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SearchStruct$SearchAndCondition parseFrom(AbstractC2383g abstractC2383g) {
        return (SearchStruct$SearchAndCondition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addAndQuery(int i, SearchStruct$SearchCondition searchStruct$SearchCondition) {
        searchStruct$SearchCondition.getClass();
        ensureAndQueryIsMutable();
        this.andQuery_.add(i, searchStruct$SearchCondition);
    }

    public static SearchStruct$SearchAndCondition parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SearchStruct$SearchAndCondition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SearchStruct$SearchAndCondition parseFrom(byte[] bArr) {
        return (SearchStruct$SearchAndCondition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SearchStruct$SearchAndCondition parseFrom(byte[] bArr, C2394s c2394s) {
        return (SearchStruct$SearchAndCondition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SearchStruct$SearchAndCondition parseFrom(InputStream inputStream) {
        return (SearchStruct$SearchAndCondition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SearchStruct$SearchAndCondition parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SearchStruct$SearchAndCondition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SearchStruct$SearchAndCondition parseFrom(AbstractC2384h abstractC2384h) {
        return (SearchStruct$SearchAndCondition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SearchStruct$SearchAndCondition parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SearchStruct$SearchAndCondition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
