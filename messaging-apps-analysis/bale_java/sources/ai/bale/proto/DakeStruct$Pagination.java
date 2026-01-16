package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class DakeStruct$Pagination extends GeneratedMessageLite implements U64 {
    public static final int COUNT_FIELD_NUMBER = 1;
    private static final DakeStruct$Pagination DEFAULT_INSTANCE;
    public static final int PAGE_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER;
    private int count_;
    private int page_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(DakeStruct$Pagination.DEFAULT_INSTANCE);
        }
    }

    static {
        DakeStruct$Pagination dakeStruct$Pagination = new DakeStruct$Pagination();
        DEFAULT_INSTANCE = dakeStruct$Pagination;
        GeneratedMessageLite.registerDefaultInstance(DakeStruct$Pagination.class, dakeStruct$Pagination);
    }

    private DakeStruct$Pagination() {
    }

    private void clearCount() {
        this.count_ = 0;
    }

    private void clearPage() {
        this.page_ = 0;
    }

    public static DakeStruct$Pagination getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static DakeStruct$Pagination parseDelimitedFrom(InputStream inputStream) {
        return (DakeStruct$Pagination) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static DakeStruct$Pagination parseFrom(ByteBuffer byteBuffer) {
        return (DakeStruct$Pagination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setCount(int i) {
        this.count_ = i;
    }

    private void setPage(int i) {
        this.page_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (N.a[gVar.ordinal()]) {
            case 1:
                return new DakeStruct$Pagination();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0004\u0002\u0004", new Object[]{"count_", "page_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (DakeStruct$Pagination.class) {
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

    public int getCount() {
        return this.count_;
    }

    public int getPage() {
        return this.page_;
    }

    public static a newBuilder(DakeStruct$Pagination dakeStruct$Pagination) {
        return (a) DEFAULT_INSTANCE.createBuilder(dakeStruct$Pagination);
    }

    public static DakeStruct$Pagination parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (DakeStruct$Pagination) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static DakeStruct$Pagination parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (DakeStruct$Pagination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static DakeStruct$Pagination parseFrom(AbstractC2383g abstractC2383g) {
        return (DakeStruct$Pagination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static DakeStruct$Pagination parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (DakeStruct$Pagination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static DakeStruct$Pagination parseFrom(byte[] bArr) {
        return (DakeStruct$Pagination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static DakeStruct$Pagination parseFrom(byte[] bArr, C2394s c2394s) {
        return (DakeStruct$Pagination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static DakeStruct$Pagination parseFrom(InputStream inputStream) {
        return (DakeStruct$Pagination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static DakeStruct$Pagination parseFrom(InputStream inputStream, C2394s c2394s) {
        return (DakeStruct$Pagination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static DakeStruct$Pagination parseFrom(AbstractC2384h abstractC2384h) {
        return (DakeStruct$Pagination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static DakeStruct$Pagination parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (DakeStruct$Pagination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
