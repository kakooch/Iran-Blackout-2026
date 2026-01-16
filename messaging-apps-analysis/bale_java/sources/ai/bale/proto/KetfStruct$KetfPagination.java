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
public final class KetfStruct$KetfPagination extends GeneratedMessageLite implements U64 {
    private static final KetfStruct$KetfPagination DEFAULT_INSTANCE;
    public static final int LIMIT_FIELD_NUMBER = 2;
    public static final int PAGE_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private int limit_;
    private int page_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(KetfStruct$KetfPagination.DEFAULT_INSTANCE);
        }
    }

    static {
        KetfStruct$KetfPagination ketfStruct$KetfPagination = new KetfStruct$KetfPagination();
        DEFAULT_INSTANCE = ketfStruct$KetfPagination;
        GeneratedMessageLite.registerDefaultInstance(KetfStruct$KetfPagination.class, ketfStruct$KetfPagination);
    }

    private KetfStruct$KetfPagination() {
    }

    private void clearLimit() {
        this.limit_ = 0;
    }

    private void clearPage() {
        this.page_ = 0;
    }

    public static KetfStruct$KetfPagination getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static KetfStruct$KetfPagination parseDelimitedFrom(InputStream inputStream) {
        return (KetfStruct$KetfPagination) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KetfStruct$KetfPagination parseFrom(ByteBuffer byteBuffer) {
        return (KetfStruct$KetfPagination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setLimit(int i) {
        this.limit_ = i;
    }

    private void setPage(int i) {
        this.page_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1891s0.a[gVar.ordinal()]) {
            case 1:
                return new KetfStruct$KetfPagination();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0004\u0002\u0004", new Object[]{"page_", "limit_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (KetfStruct$KetfPagination.class) {
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

    public int getLimit() {
        return this.limit_;
    }

    public int getPage() {
        return this.page_;
    }

    public static a newBuilder(KetfStruct$KetfPagination ketfStruct$KetfPagination) {
        return (a) DEFAULT_INSTANCE.createBuilder(ketfStruct$KetfPagination);
    }

    public static KetfStruct$KetfPagination parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (KetfStruct$KetfPagination) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KetfStruct$KetfPagination parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (KetfStruct$KetfPagination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static KetfStruct$KetfPagination parseFrom(AbstractC2383g abstractC2383g) {
        return (KetfStruct$KetfPagination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static KetfStruct$KetfPagination parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (KetfStruct$KetfPagination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static KetfStruct$KetfPagination parseFrom(byte[] bArr) {
        return (KetfStruct$KetfPagination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static KetfStruct$KetfPagination parseFrom(byte[] bArr, C2394s c2394s) {
        return (KetfStruct$KetfPagination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static KetfStruct$KetfPagination parseFrom(InputStream inputStream) {
        return (KetfStruct$KetfPagination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KetfStruct$KetfPagination parseFrom(InputStream inputStream, C2394s c2394s) {
        return (KetfStruct$KetfPagination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KetfStruct$KetfPagination parseFrom(AbstractC2384h abstractC2384h) {
        return (KetfStruct$KetfPagination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static KetfStruct$KetfPagination parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (KetfStruct$KetfPagination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
