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
public final class BankOuterClass$ResponseInvoiceGetToken extends GeneratedMessageLite implements U64 {
    private static final BankOuterClass$ResponseInvoiceGetToken DEFAULT_INSTANCE;
    public static final int ENDPOINT_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int TOKEN_FIELD_NUMBER = 2;
    private String endpoint_ = "";
    private String token_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(BankOuterClass$ResponseInvoiceGetToken.DEFAULT_INSTANCE);
        }
    }

    static {
        BankOuterClass$ResponseInvoiceGetToken bankOuterClass$ResponseInvoiceGetToken = new BankOuterClass$ResponseInvoiceGetToken();
        DEFAULT_INSTANCE = bankOuterClass$ResponseInvoiceGetToken;
        GeneratedMessageLite.registerDefaultInstance(BankOuterClass$ResponseInvoiceGetToken.class, bankOuterClass$ResponseInvoiceGetToken);
    }

    private BankOuterClass$ResponseInvoiceGetToken() {
    }

    private void clearEndpoint() {
        this.endpoint_ = getDefaultInstance().getEndpoint();
    }

    private void clearToken() {
        this.token_ = getDefaultInstance().getToken();
    }

    public static BankOuterClass$ResponseInvoiceGetToken getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static BankOuterClass$ResponseInvoiceGetToken parseDelimitedFrom(InputStream inputStream) {
        return (BankOuterClass$ResponseInvoiceGetToken) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BankOuterClass$ResponseInvoiceGetToken parseFrom(ByteBuffer byteBuffer) {
        return (BankOuterClass$ResponseInvoiceGetToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
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
                return new BankOuterClass$ResponseInvoiceGetToken();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ", new Object[]{"endpoint_", "token_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (BankOuterClass$ResponseInvoiceGetToken.class) {
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

    public static a newBuilder(BankOuterClass$ResponseInvoiceGetToken bankOuterClass$ResponseInvoiceGetToken) {
        return (a) DEFAULT_INSTANCE.createBuilder(bankOuterClass$ResponseInvoiceGetToken);
    }

    public static BankOuterClass$ResponseInvoiceGetToken parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (BankOuterClass$ResponseInvoiceGetToken) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BankOuterClass$ResponseInvoiceGetToken parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (BankOuterClass$ResponseInvoiceGetToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static BankOuterClass$ResponseInvoiceGetToken parseFrom(AbstractC2383g abstractC2383g) {
        return (BankOuterClass$ResponseInvoiceGetToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static BankOuterClass$ResponseInvoiceGetToken parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (BankOuterClass$ResponseInvoiceGetToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static BankOuterClass$ResponseInvoiceGetToken parseFrom(byte[] bArr) {
        return (BankOuterClass$ResponseInvoiceGetToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static BankOuterClass$ResponseInvoiceGetToken parseFrom(byte[] bArr, C2394s c2394s) {
        return (BankOuterClass$ResponseInvoiceGetToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static BankOuterClass$ResponseInvoiceGetToken parseFrom(InputStream inputStream) {
        return (BankOuterClass$ResponseInvoiceGetToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BankOuterClass$ResponseInvoiceGetToken parseFrom(InputStream inputStream, C2394s c2394s) {
        return (BankOuterClass$ResponseInvoiceGetToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BankOuterClass$ResponseInvoiceGetToken parseFrom(AbstractC2384h abstractC2384h) {
        return (BankOuterClass$ResponseInvoiceGetToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static BankOuterClass$ResponseInvoiceGetToken parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (BankOuterClass$ResponseInvoiceGetToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
