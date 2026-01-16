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
public final class BankOuterClass$ResponseGetSadadPSPPaymentToken extends GeneratedMessageLite implements U64 {
    private static final BankOuterClass$ResponseGetSadadPSPPaymentToken DEFAULT_INSTANCE;
    public static final int ENDPOINT_FIELD_NUMBER = 1;
    public static final int MERCHANT_CODE_FIELD_NUMBER = 4;
    private static volatile KW4 PARSER = null;
    public static final int TERMINAL_ID_FIELD_NUMBER = 3;
    public static final int TOKEN_FIELD_NUMBER = 2;
    private String endpoint_ = "";
    private String token_ = "";
    private String terminalId_ = "";
    private String merchantCode_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(BankOuterClass$ResponseGetSadadPSPPaymentToken.DEFAULT_INSTANCE);
        }
    }

    static {
        BankOuterClass$ResponseGetSadadPSPPaymentToken bankOuterClass$ResponseGetSadadPSPPaymentToken = new BankOuterClass$ResponseGetSadadPSPPaymentToken();
        DEFAULT_INSTANCE = bankOuterClass$ResponseGetSadadPSPPaymentToken;
        GeneratedMessageLite.registerDefaultInstance(BankOuterClass$ResponseGetSadadPSPPaymentToken.class, bankOuterClass$ResponseGetSadadPSPPaymentToken);
    }

    private BankOuterClass$ResponseGetSadadPSPPaymentToken() {
    }

    private void clearEndpoint() {
        this.endpoint_ = getDefaultInstance().getEndpoint();
    }

    private void clearMerchantCode() {
        this.merchantCode_ = getDefaultInstance().getMerchantCode();
    }

    private void clearTerminalId() {
        this.terminalId_ = getDefaultInstance().getTerminalId();
    }

    private void clearToken() {
        this.token_ = getDefaultInstance().getToken();
    }

    public static BankOuterClass$ResponseGetSadadPSPPaymentToken getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static BankOuterClass$ResponseGetSadadPSPPaymentToken parseDelimitedFrom(InputStream inputStream) {
        return (BankOuterClass$ResponseGetSadadPSPPaymentToken) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BankOuterClass$ResponseGetSadadPSPPaymentToken parseFrom(ByteBuffer byteBuffer) {
        return (BankOuterClass$ResponseGetSadadPSPPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
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

    private void setMerchantCode(String str) {
        str.getClass();
        this.merchantCode_ = str;
    }

    private void setMerchantCodeBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.merchantCode_ = abstractC2383g.f0();
    }

    private void setTerminalId(String str) {
        str.getClass();
        this.terminalId_ = str;
    }

    private void setTerminalIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.terminalId_ = abstractC2383g.f0();
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
                return new BankOuterClass$ResponseGetSadadPSPPaymentToken();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004Ȉ", new Object[]{"endpoint_", "token_", "terminalId_", "merchantCode_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (BankOuterClass$ResponseGetSadadPSPPaymentToken.class) {
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

    public String getMerchantCode() {
        return this.merchantCode_;
    }

    public AbstractC2383g getMerchantCodeBytes() {
        return AbstractC2383g.N(this.merchantCode_);
    }

    public String getTerminalId() {
        return this.terminalId_;
    }

    public AbstractC2383g getTerminalIdBytes() {
        return AbstractC2383g.N(this.terminalId_);
    }

    public String getToken() {
        return this.token_;
    }

    public AbstractC2383g getTokenBytes() {
        return AbstractC2383g.N(this.token_);
    }

    public static a newBuilder(BankOuterClass$ResponseGetSadadPSPPaymentToken bankOuterClass$ResponseGetSadadPSPPaymentToken) {
        return (a) DEFAULT_INSTANCE.createBuilder(bankOuterClass$ResponseGetSadadPSPPaymentToken);
    }

    public static BankOuterClass$ResponseGetSadadPSPPaymentToken parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (BankOuterClass$ResponseGetSadadPSPPaymentToken) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BankOuterClass$ResponseGetSadadPSPPaymentToken parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (BankOuterClass$ResponseGetSadadPSPPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static BankOuterClass$ResponseGetSadadPSPPaymentToken parseFrom(AbstractC2383g abstractC2383g) {
        return (BankOuterClass$ResponseGetSadadPSPPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static BankOuterClass$ResponseGetSadadPSPPaymentToken parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (BankOuterClass$ResponseGetSadadPSPPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static BankOuterClass$ResponseGetSadadPSPPaymentToken parseFrom(byte[] bArr) {
        return (BankOuterClass$ResponseGetSadadPSPPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static BankOuterClass$ResponseGetSadadPSPPaymentToken parseFrom(byte[] bArr, C2394s c2394s) {
        return (BankOuterClass$ResponseGetSadadPSPPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static BankOuterClass$ResponseGetSadadPSPPaymentToken parseFrom(InputStream inputStream) {
        return (BankOuterClass$ResponseGetSadadPSPPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BankOuterClass$ResponseGetSadadPSPPaymentToken parseFrom(InputStream inputStream, C2394s c2394s) {
        return (BankOuterClass$ResponseGetSadadPSPPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BankOuterClass$ResponseGetSadadPSPPaymentToken parseFrom(AbstractC2384h abstractC2384h) {
        return (BankOuterClass$ResponseGetSadadPSPPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static BankOuterClass$ResponseGetSadadPSPPaymentToken parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (BankOuterClass$ResponseGetSadadPSPPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
