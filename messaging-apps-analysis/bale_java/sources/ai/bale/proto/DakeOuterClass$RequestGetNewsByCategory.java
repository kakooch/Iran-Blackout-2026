package ai.bale.proto;

import ai.bale.proto.DakeStruct$Pagination;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC3692By1;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class DakeOuterClass$RequestGetNewsByCategory extends GeneratedMessageLite implements U64 {
    public static final int CATEGORY_FIELD_NUMBER = 1;
    private static final DakeOuterClass$RequestGetNewsByCategory DEFAULT_INSTANCE;
    public static final int PAGINATION_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private int category_;
    private DakeStruct$Pagination pagination_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(DakeOuterClass$RequestGetNewsByCategory.DEFAULT_INSTANCE);
        }
    }

    static {
        DakeOuterClass$RequestGetNewsByCategory dakeOuterClass$RequestGetNewsByCategory = new DakeOuterClass$RequestGetNewsByCategory();
        DEFAULT_INSTANCE = dakeOuterClass$RequestGetNewsByCategory;
        GeneratedMessageLite.registerDefaultInstance(DakeOuterClass$RequestGetNewsByCategory.class, dakeOuterClass$RequestGetNewsByCategory);
    }

    private DakeOuterClass$RequestGetNewsByCategory() {
    }

    private void clearCategory() {
        this.category_ = 0;
    }

    private void clearPagination() {
        this.pagination_ = null;
        this.bitField0_ &= -2;
    }

    public static DakeOuterClass$RequestGetNewsByCategory getDefaultInstance() {
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

    public static DakeOuterClass$RequestGetNewsByCategory parseDelimitedFrom(InputStream inputStream) {
        return (DakeOuterClass$RequestGetNewsByCategory) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static DakeOuterClass$RequestGetNewsByCategory parseFrom(ByteBuffer byteBuffer) {
        return (DakeOuterClass$RequestGetNewsByCategory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setCategory(EnumC3692By1 enumC3692By1) {
        this.category_ = enumC3692By1.getNumber();
    }

    private void setCategoryValue(int i) {
        this.category_ = i;
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
                return new DakeOuterClass$RequestGetNewsByCategory();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0002ဉ\u0000", new Object[]{"bitField0_", "category_", "pagination_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (DakeOuterClass$RequestGetNewsByCategory.class) {
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

    public EnumC3692By1 getCategory() {
        EnumC3692By1 enumC3692By1J = EnumC3692By1.j(this.category_);
        return enumC3692By1J == null ? EnumC3692By1.UNRECOGNIZED : enumC3692By1J;
    }

    public int getCategoryValue() {
        return this.category_;
    }

    public DakeStruct$Pagination getPagination() {
        DakeStruct$Pagination dakeStruct$Pagination = this.pagination_;
        return dakeStruct$Pagination == null ? DakeStruct$Pagination.getDefaultInstance() : dakeStruct$Pagination;
    }

    public boolean hasPagination() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(DakeOuterClass$RequestGetNewsByCategory dakeOuterClass$RequestGetNewsByCategory) {
        return (a) DEFAULT_INSTANCE.createBuilder(dakeOuterClass$RequestGetNewsByCategory);
    }

    public static DakeOuterClass$RequestGetNewsByCategory parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (DakeOuterClass$RequestGetNewsByCategory) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static DakeOuterClass$RequestGetNewsByCategory parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (DakeOuterClass$RequestGetNewsByCategory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static DakeOuterClass$RequestGetNewsByCategory parseFrom(AbstractC2383g abstractC2383g) {
        return (DakeOuterClass$RequestGetNewsByCategory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static DakeOuterClass$RequestGetNewsByCategory parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (DakeOuterClass$RequestGetNewsByCategory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static DakeOuterClass$RequestGetNewsByCategory parseFrom(byte[] bArr) {
        return (DakeOuterClass$RequestGetNewsByCategory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static DakeOuterClass$RequestGetNewsByCategory parseFrom(byte[] bArr, C2394s c2394s) {
        return (DakeOuterClass$RequestGetNewsByCategory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static DakeOuterClass$RequestGetNewsByCategory parseFrom(InputStream inputStream) {
        return (DakeOuterClass$RequestGetNewsByCategory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static DakeOuterClass$RequestGetNewsByCategory parseFrom(InputStream inputStream, C2394s c2394s) {
        return (DakeOuterClass$RequestGetNewsByCategory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static DakeOuterClass$RequestGetNewsByCategory parseFrom(AbstractC2384h abstractC2384h) {
        return (DakeOuterClass$RequestGetNewsByCategory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static DakeOuterClass$RequestGetNewsByCategory parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (DakeOuterClass$RequestGetNewsByCategory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
