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

/* loaded from: classes.dex */
public final class RpcEnvelopOuterClass$RpcError extends GeneratedMessageLite implements U64 {
    private static final RpcEnvelopOuterClass$RpcError DEFAULT_INSTANCE;
    public static final int ERROR_FIELD_NUMBER = 2;
    public static final int HEADER_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private String error_ = "";
    private int header_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(RpcEnvelopOuterClass$RpcError.DEFAULT_INSTANCE);
        }
    }

    static {
        RpcEnvelopOuterClass$RpcError rpcEnvelopOuterClass$RpcError = new RpcEnvelopOuterClass$RpcError();
        DEFAULT_INSTANCE = rpcEnvelopOuterClass$RpcError;
        GeneratedMessageLite.registerDefaultInstance(RpcEnvelopOuterClass$RpcError.class, rpcEnvelopOuterClass$RpcError);
    }

    private RpcEnvelopOuterClass$RpcError() {
    }

    private void clearError() {
        this.error_ = getDefaultInstance().getError();
    }

    private void clearHeader() {
        this.header_ = 0;
    }

    public static RpcEnvelopOuterClass$RpcError getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static RpcEnvelopOuterClass$RpcError parseDelimitedFrom(InputStream inputStream) {
        return (RpcEnvelopOuterClass$RpcError) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static RpcEnvelopOuterClass$RpcError parseFrom(ByteBuffer byteBuffer) {
        return (RpcEnvelopOuterClass$RpcError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setError(String str) {
        str.getClass();
        this.error_ = str;
    }

    private void setErrorBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.error_ = abstractC2383g.f0();
    }

    private void setHeader(int i) {
        this.header_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (A1.a[gVar.ordinal()]) {
            case 1:
                return new RpcEnvelopOuterClass$RpcError();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0004\u0002Ȉ", new Object[]{"header_", "error_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (RpcEnvelopOuterClass$RpcError.class) {
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

    public String getError() {
        return this.error_;
    }

    public AbstractC2383g getErrorBytes() {
        return AbstractC2383g.N(this.error_);
    }

    public int getHeader() {
        return this.header_;
    }

    public static a newBuilder(RpcEnvelopOuterClass$RpcError rpcEnvelopOuterClass$RpcError) {
        return (a) DEFAULT_INSTANCE.createBuilder(rpcEnvelopOuterClass$RpcError);
    }

    public static RpcEnvelopOuterClass$RpcError parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (RpcEnvelopOuterClass$RpcError) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static RpcEnvelopOuterClass$RpcError parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (RpcEnvelopOuterClass$RpcError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static RpcEnvelopOuterClass$RpcError parseFrom(AbstractC2383g abstractC2383g) {
        return (RpcEnvelopOuterClass$RpcError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static RpcEnvelopOuterClass$RpcError parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (RpcEnvelopOuterClass$RpcError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static RpcEnvelopOuterClass$RpcError parseFrom(byte[] bArr) {
        return (RpcEnvelopOuterClass$RpcError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static RpcEnvelopOuterClass$RpcError parseFrom(byte[] bArr, C2394s c2394s) {
        return (RpcEnvelopOuterClass$RpcError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static RpcEnvelopOuterClass$RpcError parseFrom(InputStream inputStream) {
        return (RpcEnvelopOuterClass$RpcError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static RpcEnvelopOuterClass$RpcError parseFrom(InputStream inputStream, C2394s c2394s) {
        return (RpcEnvelopOuterClass$RpcError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static RpcEnvelopOuterClass$RpcError parseFrom(AbstractC2384h abstractC2384h) {
        return (RpcEnvelopOuterClass$RpcError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static RpcEnvelopOuterClass$RpcError parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (RpcEnvelopOuterClass$RpcError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
