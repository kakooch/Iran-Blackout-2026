package ai.bale.proto;

import ai.bale.proto.DakeStruct$Pagination;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC4160Dy1;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class DakeOuterClass$ResponseGetNewsByCategory extends GeneratedMessageLite implements U64 {
    private static final DakeOuterClass$ResponseGetNewsByCategory DEFAULT_INSTANCE;
    public static final int NEWS_FIELD_NUMBER = 1;
    public static final int PAGINATION_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private B.j news_ = GeneratedMessageLite.emptyProtobufList();
    private DakeStruct$Pagination pagination_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(DakeOuterClass$ResponseGetNewsByCategory.DEFAULT_INSTANCE);
        }
    }

    static {
        DakeOuterClass$ResponseGetNewsByCategory dakeOuterClass$ResponseGetNewsByCategory = new DakeOuterClass$ResponseGetNewsByCategory();
        DEFAULT_INSTANCE = dakeOuterClass$ResponseGetNewsByCategory;
        GeneratedMessageLite.registerDefaultInstance(DakeOuterClass$ResponseGetNewsByCategory.class, dakeOuterClass$ResponseGetNewsByCategory);
    }

    private DakeOuterClass$ResponseGetNewsByCategory() {
    }

    private void addAllNews(Iterable<? extends DakeStruct$NewsInfo> iterable) {
        ensureNewsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.news_);
    }

    private void addNews(DakeStruct$NewsInfo dakeStruct$NewsInfo) {
        dakeStruct$NewsInfo.getClass();
        ensureNewsIsMutable();
        this.news_.add(dakeStruct$NewsInfo);
    }

    private void clearNews() {
        this.news_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearPagination() {
        this.pagination_ = null;
        this.bitField0_ &= -2;
    }

    private void ensureNewsIsMutable() {
        B.j jVar = this.news_;
        if (jVar.u()) {
            return;
        }
        this.news_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static DakeOuterClass$ResponseGetNewsByCategory getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergePagination(DakeStruct$Pagination dakeStruct$Pagination) {
        dakeStruct$Pagination.getClass();
        DakeStruct$Pagination dakeStruct$Pagination2 = this.pagination_;
        if (dakeStruct$Pagination2 == null || dakeStruct$Pagination2 == DakeStruct$Pagination.getDefaultInstance()) {
            this.pagination_ = dakeStruct$Pagination;
        } else {
            this.pagination_ = (DakeStruct$Pagination) ((DakeStruct$Pagination.a) DakeStruct$Pagination.newBuilder(this.pagination_).v(dakeStruct$Pagination)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static DakeOuterClass$ResponseGetNewsByCategory parseDelimitedFrom(InputStream inputStream) {
        return (DakeOuterClass$ResponseGetNewsByCategory) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static DakeOuterClass$ResponseGetNewsByCategory parseFrom(ByteBuffer byteBuffer) {
        return (DakeOuterClass$ResponseGetNewsByCategory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeNews(int i) {
        ensureNewsIsMutable();
        this.news_.remove(i);
    }

    private void setNews(int i, DakeStruct$NewsInfo dakeStruct$NewsInfo) {
        dakeStruct$NewsInfo.getClass();
        ensureNewsIsMutable();
        this.news_.set(i, dakeStruct$NewsInfo);
    }

    private void setPagination(DakeStruct$Pagination dakeStruct$Pagination) {
        dakeStruct$Pagination.getClass();
        this.pagination_ = dakeStruct$Pagination;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (M.a[gVar.ordinal()]) {
            case 1:
                return new DakeOuterClass$ResponseGetNewsByCategory();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001b\u0002ဉ\u0000", new Object[]{"bitField0_", "news_", DakeStruct$NewsInfo.class, "pagination_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (DakeOuterClass$ResponseGetNewsByCategory.class) {
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

    public DakeStruct$NewsInfo getNews(int i) {
        return (DakeStruct$NewsInfo) this.news_.get(i);
    }

    public int getNewsCount() {
        return this.news_.size();
    }

    public List<DakeStruct$NewsInfo> getNewsList() {
        return this.news_;
    }

    public InterfaceC4160Dy1 getNewsOrBuilder(int i) {
        return (InterfaceC4160Dy1) this.news_.get(i);
    }

    public List<? extends InterfaceC4160Dy1> getNewsOrBuilderList() {
        return this.news_;
    }

    public DakeStruct$Pagination getPagination() {
        DakeStruct$Pagination dakeStruct$Pagination = this.pagination_;
        return dakeStruct$Pagination == null ? DakeStruct$Pagination.getDefaultInstance() : dakeStruct$Pagination;
    }

    public boolean hasPagination() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(DakeOuterClass$ResponseGetNewsByCategory dakeOuterClass$ResponseGetNewsByCategory) {
        return (a) DEFAULT_INSTANCE.createBuilder(dakeOuterClass$ResponseGetNewsByCategory);
    }

    public static DakeOuterClass$ResponseGetNewsByCategory parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (DakeOuterClass$ResponseGetNewsByCategory) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static DakeOuterClass$ResponseGetNewsByCategory parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (DakeOuterClass$ResponseGetNewsByCategory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static DakeOuterClass$ResponseGetNewsByCategory parseFrom(AbstractC2383g abstractC2383g) {
        return (DakeOuterClass$ResponseGetNewsByCategory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addNews(int i, DakeStruct$NewsInfo dakeStruct$NewsInfo) {
        dakeStruct$NewsInfo.getClass();
        ensureNewsIsMutable();
        this.news_.add(i, dakeStruct$NewsInfo);
    }

    public static DakeOuterClass$ResponseGetNewsByCategory parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (DakeOuterClass$ResponseGetNewsByCategory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static DakeOuterClass$ResponseGetNewsByCategory parseFrom(byte[] bArr) {
        return (DakeOuterClass$ResponseGetNewsByCategory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static DakeOuterClass$ResponseGetNewsByCategory parseFrom(byte[] bArr, C2394s c2394s) {
        return (DakeOuterClass$ResponseGetNewsByCategory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static DakeOuterClass$ResponseGetNewsByCategory parseFrom(InputStream inputStream) {
        return (DakeOuterClass$ResponseGetNewsByCategory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static DakeOuterClass$ResponseGetNewsByCategory parseFrom(InputStream inputStream, C2394s c2394s) {
        return (DakeOuterClass$ResponseGetNewsByCategory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static DakeOuterClass$ResponseGetNewsByCategory parseFrom(AbstractC2384h abstractC2384h) {
        return (DakeOuterClass$ResponseGetNewsByCategory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static DakeOuterClass$ResponseGetNewsByCategory parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (DakeOuterClass$ResponseGetNewsByCategory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
