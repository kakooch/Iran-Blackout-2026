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
public final class GarsonStruct$GarsonPagination extends GeneratedMessageLite implements U64 {
    private static final GarsonStruct$GarsonPagination DEFAULT_INSTANCE;
    public static final int LIMIT_FIELD_NUMBER = 2;
    public static final int PAGE_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private int limit_;
    private int page_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(int i) {
            q();
            ((GarsonStruct$GarsonPagination) this.b).setLimit(i);
            return this;
        }

        public a B(int i) {
            q();
            ((GarsonStruct$GarsonPagination) this.b).setPage(i);
            return this;
        }

        private a() {
            super(GarsonStruct$GarsonPagination.DEFAULT_INSTANCE);
        }
    }

    static {
        GarsonStruct$GarsonPagination garsonStruct$GarsonPagination = new GarsonStruct$GarsonPagination();
        DEFAULT_INSTANCE = garsonStruct$GarsonPagination;
        GeneratedMessageLite.registerDefaultInstance(GarsonStruct$GarsonPagination.class, garsonStruct$GarsonPagination);
    }

    private GarsonStruct$GarsonPagination() {
    }

    private void clearLimit() {
        this.limit_ = 0;
    }

    private void clearPage() {
        this.page_ = 0;
    }

    public static GarsonStruct$GarsonPagination getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static GarsonStruct$GarsonPagination parseDelimitedFrom(InputStream inputStream) {
        return (GarsonStruct$GarsonPagination) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GarsonStruct$GarsonPagination parseFrom(ByteBuffer byteBuffer) {
        return (GarsonStruct$GarsonPagination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLimit(int i) {
        this.limit_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPage(int i) {
        this.page_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1850e0.a[gVar.ordinal()]) {
            case 1:
                return new GarsonStruct$GarsonPagination();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0004\u0002\u0004", new Object[]{"page_", "limit_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (GarsonStruct$GarsonPagination.class) {
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

    public static a newBuilder(GarsonStruct$GarsonPagination garsonStruct$GarsonPagination) {
        return (a) DEFAULT_INSTANCE.createBuilder(garsonStruct$GarsonPagination);
    }

    public static GarsonStruct$GarsonPagination parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (GarsonStruct$GarsonPagination) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GarsonStruct$GarsonPagination parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (GarsonStruct$GarsonPagination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static GarsonStruct$GarsonPagination parseFrom(AbstractC2383g abstractC2383g) {
        return (GarsonStruct$GarsonPagination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static GarsonStruct$GarsonPagination parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (GarsonStruct$GarsonPagination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static GarsonStruct$GarsonPagination parseFrom(byte[] bArr) {
        return (GarsonStruct$GarsonPagination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GarsonStruct$GarsonPagination parseFrom(byte[] bArr, C2394s c2394s) {
        return (GarsonStruct$GarsonPagination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static GarsonStruct$GarsonPagination parseFrom(InputStream inputStream) {
        return (GarsonStruct$GarsonPagination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GarsonStruct$GarsonPagination parseFrom(InputStream inputStream, C2394s c2394s) {
        return (GarsonStruct$GarsonPagination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GarsonStruct$GarsonPagination parseFrom(AbstractC2384h abstractC2384h) {
        return (GarsonStruct$GarsonPagination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static GarsonStruct$GarsonPagination parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (GarsonStruct$GarsonPagination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
