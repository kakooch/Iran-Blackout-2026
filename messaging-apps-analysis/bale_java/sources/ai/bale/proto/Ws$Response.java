package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class Ws$Response extends GeneratedMessageLite implements U64 {
    private static final Ws$Response DEFAULT_INSTANCE;
    public static final int ERROR_FIELD_NUMBER = 1;
    public static final int INDEX_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER = null;
    public static final int RESPONSE_FIELD_NUMBER = 2;
    private long index_;
    private int traitCase_ = 0;
    private Object trait_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Ws$Response.DEFAULT_INSTANCE);
        }
    }

    public enum b {
        ERROR(1),
        RESPONSE(2),
        TRAIT_NOT_SET(0);

        private final int a;

        b(int i) {
            this.a = i;
        }

        public static b j(int i) {
            if (i == 0) {
                return TRAIT_NOT_SET;
            }
            if (i == 1) {
                return ERROR;
            }
            if (i != 2) {
                return null;
            }
            return RESPONSE;
        }
    }

    static {
        Ws$Response ws$Response = new Ws$Response();
        DEFAULT_INSTANCE = ws$Response;
        GeneratedMessageLite.registerDefaultInstance(Ws$Response.class, ws$Response);
    }

    private Ws$Response() {
    }

    private void clearError() {
        if (this.traitCase_ == 1) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearIndex() {
        this.index_ = 0L;
    }

    private void clearResponse() {
        if (this.traitCase_ == 2) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearTrait() {
        this.traitCase_ = 0;
        this.trait_ = null;
    }

    public static Ws$Response getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Ws$Response parseDelimitedFrom(InputStream inputStream) {
        return (Ws$Response) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Ws$Response parseFrom(ByteBuffer byteBuffer) {
        return (Ws$Response) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setError(AbstractC2383g abstractC2383g) {
        abstractC2383g.getClass();
        this.traitCase_ = 1;
        this.trait_ = abstractC2383g;
    }

    private void setIndex(long j) {
        this.index_ = j;
    }

    private void setResponse(AbstractC2383g abstractC2383g) {
        abstractC2383g.getClass();
        this.traitCase_ = 2;
        this.trait_ = abstractC2383g;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (y2.a[gVar.ordinal()]) {
            case 1:
                return new Ws$Response();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0001\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001=\u0000\u0002=\u0000\u0003\u0002", new Object[]{"trait_", "traitCase_", "index_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Ws$Response.class) {
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

    public AbstractC2383g getError() {
        return this.traitCase_ == 1 ? (AbstractC2383g) this.trait_ : AbstractC2383g.b;
    }

    public long getIndex() {
        return this.index_;
    }

    public AbstractC2383g getResponse() {
        return this.traitCase_ == 2 ? (AbstractC2383g) this.trait_ : AbstractC2383g.b;
    }

    public b getTraitCase() {
        return b.j(this.traitCase_);
    }

    public boolean hasError() {
        return this.traitCase_ == 1;
    }

    public boolean hasResponse() {
        return this.traitCase_ == 2;
    }

    public static a newBuilder(Ws$Response ws$Response) {
        return (a) DEFAULT_INSTANCE.createBuilder(ws$Response);
    }

    public static Ws$Response parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Ws$Response) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Ws$Response parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Ws$Response) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Ws$Response parseFrom(AbstractC2383g abstractC2383g) {
        return (Ws$Response) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static Ws$Response parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Ws$Response) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Ws$Response parseFrom(byte[] bArr) {
        return (Ws$Response) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Ws$Response parseFrom(byte[] bArr, C2394s c2394s) {
        return (Ws$Response) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Ws$Response parseFrom(InputStream inputStream) {
        return (Ws$Response) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Ws$Response parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Ws$Response) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Ws$Response parseFrom(AbstractC2384h abstractC2384h) {
        return (Ws$Response) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Ws$Response parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Ws$Response) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
