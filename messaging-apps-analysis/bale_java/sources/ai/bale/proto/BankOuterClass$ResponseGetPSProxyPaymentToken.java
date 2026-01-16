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
public final class BankOuterClass$ResponseGetPSProxyPaymentToken extends GeneratedMessageLite implements U64 {
    private static final BankOuterClass$ResponseGetPSProxyPaymentToken DEFAULT_INSTANCE;
    public static final int ENDPOINT_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int TOKEN_FIELD_NUMBER = 2;
    private String endpoint_ = "";
    private String token_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(BankOuterClass$ResponseGetPSProxyPaymentToken.DEFAULT_INSTANCE);
        }
    }

    static {
        BankOuterClass$ResponseGetPSProxyPaymentToken bankOuterClass$ResponseGetPSProxyPaymentToken = new BankOuterClass$ResponseGetPSProxyPaymentToken();
        DEFAULT_INSTANCE = bankOuterClass$ResponseGetPSProxyPaymentToken;
        GeneratedMessageLite.registerDefaultInstance(BankOuterClass$ResponseGetPSProxyPaymentToken.class, bankOuterClass$ResponseGetPSProxyPaymentToken);
    }

    private BankOuterClass$ResponseGetPSProxyPaymentToken() {
    }

    private void clearEndpoint() {
        this.endpoint_ = getDefaultInstance().getEndpoint();
    }

    private void clearToken() {
        this.token_ = getDefaultInstance().getToken();
    }

    public static BankOuterClass$ResponseGetPSProxyPaymentToken getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static BankOuterClass$ResponseGetPSProxyPaymentToken parseDelimitedFrom(InputStream inputStream) {
        return (BankOuterClass$ResponseGetPSProxyPaymentToken) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BankOuterClass$ResponseGetPSProxyPaymentToken parseFrom(ByteBuffer byteBuffer) {
        return (BankOuterClass$ResponseGetPSProxyPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setEndpoint(String str) {
        str.getClass();
        this.endpoint_ = str;
    }

    private void setEndpointBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.endpoint_ = abstractC2383g.f0();
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
        switch (AbstractC1876n.a[gVar.ordinal()]) {
            case 1:
                return new BankOuterClass$ResponseGetPSProxyPaymentToken();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ", new Object[]{"endpoint_", "token_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (BankOuterClass$ResponseGetPSProxyPaymentToken.class) {
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

    public String getEndpoint() {
        return this.endpoint_;
    }

    public AbstractC2383g getEndpointBytes() {
        return AbstractC2383g.N(this.endpoint_);
    }

    public String getToken() {
        return this.token_;
    }

    public AbstractC2383g getTokenBytes() {
        return AbstractC2383g.N(this.token_);
    }

    public static a newBuilder(BankOuterClass$ResponseGetPSProxyPaymentToken bankOuterClass$ResponseGetPSProxyPaymentToken) {
        return (a) DEFAULT_INSTANCE.createBuilder(bankOuterClass$ResponseGetPSProxyPaymentToken);
    }

    public static BankOuterClass$ResponseGetPSProxyPaymentToken parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (BankOuterClass$ResponseGetPSProxyPaymentToken) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BankOuterClass$ResponseGetPSProxyPaymentToken parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (BankOuterClass$ResponseGetPSProxyPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static BankOuterClass$ResponseGetPSProxyPaymentToken parseFrom(AbstractC2383g abstractC2383g) {
        return (BankOuterClass$ResponseGetPSProxyPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static BankOuterClass$ResponseGetPSProxyPaymentToken parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (BankOuterClass$ResponseGetPSProxyPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static BankOuterClass$ResponseGetPSProxyPaymentToken parseFrom(byte[] bArr) {
        return (BankOuterClass$ResponseGetPSProxyPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static BankOuterClass$ResponseGetPSProxyPaymentToken parseFrom(byte[] bArr, C2394s c2394s) {
        return (BankOuterClass$ResponseGetPSProxyPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static BankOuterClass$ResponseGetPSProxyPaymentToken parseFrom(InputStream inputStream) {
        return (BankOuterClass$ResponseGetPSProxyPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BankOuterClass$ResponseGetPSProxyPaymentToken parseFrom(InputStream inputStream, C2394s c2394s) {
        return (BankOuterClass$ResponseGetPSProxyPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BankOuterClass$ResponseGetPSProxyPaymentToken parseFrom(AbstractC2384h abstractC2384h) {
        return (BankOuterClass$ResponseGetPSProxyPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static BankOuterClass$ResponseGetPSProxyPaymentToken parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (BankOuterClass$ResponseGetPSProxyPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
