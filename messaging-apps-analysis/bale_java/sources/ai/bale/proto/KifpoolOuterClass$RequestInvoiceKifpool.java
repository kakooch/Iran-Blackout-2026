package ai.bale.proto;

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
public final class KifpoolOuterClass$RequestInvoiceKifpool extends GeneratedMessageLite implements U64 {
    private static final KifpoolOuterClass$RequestInvoiceKifpool DEFAULT_INSTANCE;
    public static final int PAGE_NUMBER_FIELD_NUMBER = 3;
    public static final int PAGE_SIZE_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int TOKEN_FIELD_NUMBER = 1;
    private int pageNumber_;
    private int pageSize_;
    private String token_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(KifpoolOuterClass$RequestInvoiceKifpool.DEFAULT_INSTANCE);
        }
    }

    static {
        KifpoolOuterClass$RequestInvoiceKifpool kifpoolOuterClass$RequestInvoiceKifpool = new KifpoolOuterClass$RequestInvoiceKifpool();
        DEFAULT_INSTANCE = kifpoolOuterClass$RequestInvoiceKifpool;
        GeneratedMessageLite.registerDefaultInstance(KifpoolOuterClass$RequestInvoiceKifpool.class, kifpoolOuterClass$RequestInvoiceKifpool);
    }

    private KifpoolOuterClass$RequestInvoiceKifpool() {
    }

    private void clearPageNumber() {
        this.pageNumber_ = 0;
    }

    private void clearPageSize() {
        this.pageSize_ = 0;
    }

    private void clearToken() {
        this.token_ = getDefaultInstance().getToken();
    }

    public static KifpoolOuterClass$RequestInvoiceKifpool getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static KifpoolOuterClass$RequestInvoiceKifpool parseDelimitedFrom(InputStream inputStream) {
        return (KifpoolOuterClass$RequestInvoiceKifpool) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KifpoolOuterClass$RequestInvoiceKifpool parseFrom(ByteBuffer byteBuffer) {
        return (KifpoolOuterClass$RequestInvoiceKifpool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setPageNumber(int i) {
        this.pageNumber_ = i;
    }

    private void setPageSize(int i) {
        this.pageSize_ = i;
    }

    private void setToken(String str) {
        str.getClass();
        this.token_ = str;
    }

    private void setTokenBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.token_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1897u0.a[gVar.ordinal()]) {
            case 1:
                return new KifpoolOuterClass$RequestInvoiceKifpool();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\u0004\u0003\u0004", new Object[]{"token_", "pageSize_", "pageNumber_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (KifpoolOuterClass$RequestInvoiceKifpool.class) {
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

    public int getPageNumber() {
        return this.pageNumber_;
    }

    public int getPageSize() {
        return this.pageSize_;
    }

    public String getToken() {
        return this.token_;
    }

    public AbstractC2383g getTokenBytes() {
        return AbstractC2383g.N(this.token_);
    }

    public static a newBuilder(KifpoolOuterClass$RequestInvoiceKifpool kifpoolOuterClass$RequestInvoiceKifpool) {
        return (a) DEFAULT_INSTANCE.createBuilder(kifpoolOuterClass$RequestInvoiceKifpool);
    }

    public static KifpoolOuterClass$RequestInvoiceKifpool parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (KifpoolOuterClass$RequestInvoiceKifpool) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KifpoolOuterClass$RequestInvoiceKifpool parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (KifpoolOuterClass$RequestInvoiceKifpool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static KifpoolOuterClass$RequestInvoiceKifpool parseFrom(AbstractC2383g abstractC2383g) {
        return (KifpoolOuterClass$RequestInvoiceKifpool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static KifpoolOuterClass$RequestInvoiceKifpool parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (KifpoolOuterClass$RequestInvoiceKifpool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static KifpoolOuterClass$RequestInvoiceKifpool parseFrom(byte[] bArr) {
        return (KifpoolOuterClass$RequestInvoiceKifpool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static KifpoolOuterClass$RequestInvoiceKifpool parseFrom(byte[] bArr, C2394s c2394s) {
        return (KifpoolOuterClass$RequestInvoiceKifpool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static KifpoolOuterClass$RequestInvoiceKifpool parseFrom(InputStream inputStream) {
        return (KifpoolOuterClass$RequestInvoiceKifpool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KifpoolOuterClass$RequestInvoiceKifpool parseFrom(InputStream inputStream, C2394s c2394s) {
        return (KifpoolOuterClass$RequestInvoiceKifpool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KifpoolOuterClass$RequestInvoiceKifpool parseFrom(AbstractC2384h abstractC2384h) {
        return (KifpoolOuterClass$RequestInvoiceKifpool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static KifpoolOuterClass$RequestInvoiceKifpool parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (KifpoolOuterClass$RequestInvoiceKifpool) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
