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
public final class RamzOuterClass$ResponseCheckPassword extends GeneratedMessageLite implements U64 {
    private static final RamzOuterClass$ResponseCheckPassword DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int TOKEN_FIELD_NUMBER = 1;
    private String token_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(RamzOuterClass$ResponseCheckPassword.DEFAULT_INSTANCE);
        }
    }

    static {
        RamzOuterClass$ResponseCheckPassword ramzOuterClass$ResponseCheckPassword = new RamzOuterClass$ResponseCheckPassword();
        DEFAULT_INSTANCE = ramzOuterClass$ResponseCheckPassword;
        GeneratedMessageLite.registerDefaultInstance(RamzOuterClass$ResponseCheckPassword.class, ramzOuterClass$ResponseCheckPassword);
    }

    private RamzOuterClass$ResponseCheckPassword() {
    }

    private void clearToken() {
        this.token_ = getDefaultInstance().getToken();
    }

    public static RamzOuterClass$ResponseCheckPassword getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static RamzOuterClass$ResponseCheckPassword parseDelimitedFrom(InputStream inputStream) {
        return (RamzOuterClass$ResponseCheckPassword) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static RamzOuterClass$ResponseCheckPassword parseFrom(ByteBuffer byteBuffer) {
        return (RamzOuterClass$ResponseCheckPassword) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
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
        switch (AbstractC1887q1.a[gVar.ordinal()]) {
            case 1:
                return new RamzOuterClass$ResponseCheckPassword();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"token_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (RamzOuterClass$ResponseCheckPassword.class) {
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

    public String getToken() {
        return this.token_;
    }

    public AbstractC2383g getTokenBytes() {
        return AbstractC2383g.N(this.token_);
    }

    public static a newBuilder(RamzOuterClass$ResponseCheckPassword ramzOuterClass$ResponseCheckPassword) {
        return (a) DEFAULT_INSTANCE.createBuilder(ramzOuterClass$ResponseCheckPassword);
    }

    public static RamzOuterClass$ResponseCheckPassword parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (RamzOuterClass$ResponseCheckPassword) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static RamzOuterClass$ResponseCheckPassword parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (RamzOuterClass$ResponseCheckPassword) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static RamzOuterClass$ResponseCheckPassword parseFrom(AbstractC2383g abstractC2383g) {
        return (RamzOuterClass$ResponseCheckPassword) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static RamzOuterClass$ResponseCheckPassword parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (RamzOuterClass$ResponseCheckPassword) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static RamzOuterClass$ResponseCheckPassword parseFrom(byte[] bArr) {
        return (RamzOuterClass$ResponseCheckPassword) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static RamzOuterClass$ResponseCheckPassword parseFrom(byte[] bArr, C2394s c2394s) {
        return (RamzOuterClass$ResponseCheckPassword) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static RamzOuterClass$ResponseCheckPassword parseFrom(InputStream inputStream) {
        return (RamzOuterClass$ResponseCheckPassword) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static RamzOuterClass$ResponseCheckPassword parseFrom(InputStream inputStream, C2394s c2394s) {
        return (RamzOuterClass$ResponseCheckPassword) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static RamzOuterClass$ResponseCheckPassword parseFrom(AbstractC2384h abstractC2384h) {
        return (RamzOuterClass$ResponseCheckPassword) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static RamzOuterClass$ResponseCheckPassword parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (RamzOuterClass$ResponseCheckPassword) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
