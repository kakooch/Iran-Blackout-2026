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
public final class MarketStruct$MarketPagination extends GeneratedMessageLite implements U64 {
    private static final MarketStruct$MarketPagination DEFAULT_INSTANCE;
    public static final int LIMIT_FIELD_NUMBER = 2;
    public static final int PAGE_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private int limit_;
    private int page_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(int i) {
            q();
            ((MarketStruct$MarketPagination) this.b).setLimit(i);
            return this;
        }

        public a B(int i) {
            q();
            ((MarketStruct$MarketPagination) this.b).setPage(i);
            return this;
        }

        private a() {
            super(MarketStruct$MarketPagination.DEFAULT_INSTANCE);
        }
    }

    static {
        MarketStruct$MarketPagination marketStruct$MarketPagination = new MarketStruct$MarketPagination();
        DEFAULT_INSTANCE = marketStruct$MarketPagination;
        GeneratedMessageLite.registerDefaultInstance(MarketStruct$MarketPagination.class, marketStruct$MarketPagination);
    }

    private MarketStruct$MarketPagination() {
    }

    private void clearLimit() {
        this.limit_ = 0;
    }

    private void clearPage() {
        this.page_ = 0;
    }

    public static MarketStruct$MarketPagination getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MarketStruct$MarketPagination parseDelimitedFrom(InputStream inputStream) {
        return (MarketStruct$MarketPagination) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MarketStruct$MarketPagination parseFrom(ByteBuffer byteBuffer) {
        return (MarketStruct$MarketPagination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
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
        switch (D0.a[gVar.ordinal()]) {
            case 1:
                return new MarketStruct$MarketPagination();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0004\u0002\u0004", new Object[]{"page_", "limit_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MarketStruct$MarketPagination.class) {
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

    public static a newBuilder(MarketStruct$MarketPagination marketStruct$MarketPagination) {
        return (a) DEFAULT_INSTANCE.createBuilder(marketStruct$MarketPagination);
    }

    public static MarketStruct$MarketPagination parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MarketStruct$MarketPagination) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MarketStruct$MarketPagination parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MarketStruct$MarketPagination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MarketStruct$MarketPagination parseFrom(AbstractC2383g abstractC2383g) {
        return (MarketStruct$MarketPagination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MarketStruct$MarketPagination parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MarketStruct$MarketPagination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MarketStruct$MarketPagination parseFrom(byte[] bArr) {
        return (MarketStruct$MarketPagination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MarketStruct$MarketPagination parseFrom(byte[] bArr, C2394s c2394s) {
        return (MarketStruct$MarketPagination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MarketStruct$MarketPagination parseFrom(InputStream inputStream) {
        return (MarketStruct$MarketPagination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MarketStruct$MarketPagination parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MarketStruct$MarketPagination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MarketStruct$MarketPagination parseFrom(AbstractC2384h abstractC2384h) {
        return (MarketStruct$MarketPagination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MarketStruct$MarketPagination parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MarketStruct$MarketPagination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
