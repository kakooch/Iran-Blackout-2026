package livekit;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes8.dex */
public final class LivekitModels$Pagination extends GeneratedMessageLite implements U64 {
    public static final int AFTER_ID_FIELD_NUMBER = 1;
    private static final LivekitModels$Pagination DEFAULT_INSTANCE;
    public static final int LIMIT_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER;
    private String afterId_ = "";
    private int limit_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        /* synthetic */ a(o oVar) {
            this();
        }

        private a() {
            super(LivekitModels$Pagination.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitModels$Pagination livekitModels$Pagination = new LivekitModels$Pagination();
        DEFAULT_INSTANCE = livekitModels$Pagination;
        GeneratedMessageLite.registerDefaultInstance(LivekitModels$Pagination.class, livekitModels$Pagination);
    }

    private LivekitModels$Pagination() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAfterId() {
        this.afterId_ = getDefaultInstance().getAfterId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearLimit() {
        this.limit_ = 0;
    }

    public static LivekitModels$Pagination getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitModels$Pagination parseDelimitedFrom(InputStream inputStream) {
        return (LivekitModels$Pagination) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitModels$Pagination parseFrom(ByteBuffer byteBuffer) {
        return (LivekitModels$Pagination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAfterId(String str) {
        str.getClass();
        this.afterId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAfterIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.afterId_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLimit(int i) {
        this.limit_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        o oVar = null;
        switch (o.a[gVar.ordinal()]) {
            case 1:
                return new LivekitModels$Pagination();
            case 2:
                return new a(oVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002\u0004", new Object[]{"afterId_", "limit_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitModels$Pagination.class) {
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

    public String getAfterId() {
        return this.afterId_;
    }

    public AbstractC2383g getAfterIdBytes() {
        return AbstractC2383g.N(this.afterId_);
    }

    public int getLimit() {
        return this.limit_;
    }

    public static a newBuilder(LivekitModels$Pagination livekitModels$Pagination) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitModels$Pagination);
    }

    public static LivekitModels$Pagination parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitModels$Pagination) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitModels$Pagination parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitModels$Pagination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitModels$Pagination parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitModels$Pagination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitModels$Pagination parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitModels$Pagination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitModels$Pagination parseFrom(byte[] bArr) {
        return (LivekitModels$Pagination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitModels$Pagination parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitModels$Pagination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitModels$Pagination parseFrom(InputStream inputStream) {
        return (LivekitModels$Pagination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitModels$Pagination parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitModels$Pagination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitModels$Pagination parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitModels$Pagination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitModels$Pagination parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitModels$Pagination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
