package ai.bale.proto;

import ai.bale.proto.DakeStruct$Pagination;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class DakeOuterClass$RequestGetNewsCoverage extends GeneratedMessageLite implements U64 {
    private static final DakeOuterClass$RequestGetNewsCoverage DEFAULT_INSTANCE;
    public static final int HEADLINE_ID_FIELD_NUMBER = 1;
    public static final int PAGINATION_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private String headlineId_ = "";
    private DakeStruct$Pagination pagination_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(DakeOuterClass$RequestGetNewsCoverage.DEFAULT_INSTANCE);
        }
    }

    static {
        DakeOuterClass$RequestGetNewsCoverage dakeOuterClass$RequestGetNewsCoverage = new DakeOuterClass$RequestGetNewsCoverage();
        DEFAULT_INSTANCE = dakeOuterClass$RequestGetNewsCoverage;
        GeneratedMessageLite.registerDefaultInstance(DakeOuterClass$RequestGetNewsCoverage.class, dakeOuterClass$RequestGetNewsCoverage);
    }

    private DakeOuterClass$RequestGetNewsCoverage() {
    }

    private void clearHeadlineId() {
        this.headlineId_ = getDefaultInstance().getHeadlineId();
    }

    private void clearPagination() {
        this.pagination_ = null;
        this.bitField0_ &= -2;
    }

    public static DakeOuterClass$RequestGetNewsCoverage getDefaultInstance() {
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

    public static DakeOuterClass$RequestGetNewsCoverage parseDelimitedFrom(InputStream inputStream) {
        return (DakeOuterClass$RequestGetNewsCoverage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static DakeOuterClass$RequestGetNewsCoverage parseFrom(ByteBuffer byteBuffer) {
        return (DakeOuterClass$RequestGetNewsCoverage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setHeadlineId(String str) {
        str.getClass();
        this.headlineId_ = str;
    }

    private void setHeadlineIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.headlineId_ = abstractC2383g.f0();
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
                return new DakeOuterClass$RequestGetNewsCoverage();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002ဉ\u0000", new Object[]{"bitField0_", "headlineId_", "pagination_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (DakeOuterClass$RequestGetNewsCoverage.class) {
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

    public String getHeadlineId() {
        return this.headlineId_;
    }

    public AbstractC2383g getHeadlineIdBytes() {
        return AbstractC2383g.N(this.headlineId_);
    }

    public DakeStruct$Pagination getPagination() {
        DakeStruct$Pagination dakeStruct$Pagination = this.pagination_;
        return dakeStruct$Pagination == null ? DakeStruct$Pagination.getDefaultInstance() : dakeStruct$Pagination;
    }

    public boolean hasPagination() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(DakeOuterClass$RequestGetNewsCoverage dakeOuterClass$RequestGetNewsCoverage) {
        return (a) DEFAULT_INSTANCE.createBuilder(dakeOuterClass$RequestGetNewsCoverage);
    }

    public static DakeOuterClass$RequestGetNewsCoverage parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (DakeOuterClass$RequestGetNewsCoverage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static DakeOuterClass$RequestGetNewsCoverage parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (DakeOuterClass$RequestGetNewsCoverage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static DakeOuterClass$RequestGetNewsCoverage parseFrom(AbstractC2383g abstractC2383g) {
        return (DakeOuterClass$RequestGetNewsCoverage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static DakeOuterClass$RequestGetNewsCoverage parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (DakeOuterClass$RequestGetNewsCoverage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static DakeOuterClass$RequestGetNewsCoverage parseFrom(byte[] bArr) {
        return (DakeOuterClass$RequestGetNewsCoverage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static DakeOuterClass$RequestGetNewsCoverage parseFrom(byte[] bArr, C2394s c2394s) {
        return (DakeOuterClass$RequestGetNewsCoverage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static DakeOuterClass$RequestGetNewsCoverage parseFrom(InputStream inputStream) {
        return (DakeOuterClass$RequestGetNewsCoverage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static DakeOuterClass$RequestGetNewsCoverage parseFrom(InputStream inputStream, C2394s c2394s) {
        return (DakeOuterClass$RequestGetNewsCoverage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static DakeOuterClass$RequestGetNewsCoverage parseFrom(AbstractC2384h abstractC2384h) {
        return (DakeOuterClass$RequestGetNewsCoverage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static DakeOuterClass$RequestGetNewsCoverage parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (DakeOuterClass$RequestGetNewsCoverage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
