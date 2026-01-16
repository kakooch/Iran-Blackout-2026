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
public final class EvexOuterClass$ResponseGetEvexPaymentToken extends GeneratedMessageLite implements U64 {
    private static final EvexOuterClass$ResponseGetEvexPaymentToken DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int PAYMENT_GATEWAY_PREFIX_FIELD_NUMBER = 2;
    public static final int TERMINAL_ID_FIELD_NUMBER = 3;
    public static final int TOKEN_FIELD_NUMBER = 1;
    private String token_ = "";
    private String paymentGatewayPrefix_ = "";
    private String terminalId_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(EvexOuterClass$ResponseGetEvexPaymentToken.DEFAULT_INSTANCE);
        }
    }

    static {
        EvexOuterClass$ResponseGetEvexPaymentToken evexOuterClass$ResponseGetEvexPaymentToken = new EvexOuterClass$ResponseGetEvexPaymentToken();
        DEFAULT_INSTANCE = evexOuterClass$ResponseGetEvexPaymentToken;
        GeneratedMessageLite.registerDefaultInstance(EvexOuterClass$ResponseGetEvexPaymentToken.class, evexOuterClass$ResponseGetEvexPaymentToken);
    }

    private EvexOuterClass$ResponseGetEvexPaymentToken() {
    }

    private void clearPaymentGatewayPrefix() {
        this.paymentGatewayPrefix_ = getDefaultInstance().getPaymentGatewayPrefix();
    }

    private void clearTerminalId() {
        this.terminalId_ = getDefaultInstance().getTerminalId();
    }

    private void clearToken() {
        this.token_ = getDefaultInstance().getToken();
    }

    public static EvexOuterClass$ResponseGetEvexPaymentToken getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static EvexOuterClass$ResponseGetEvexPaymentToken parseDelimitedFrom(InputStream inputStream) {
        return (EvexOuterClass$ResponseGetEvexPaymentToken) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static EvexOuterClass$ResponseGetEvexPaymentToken parseFrom(ByteBuffer byteBuffer) {
        return (EvexOuterClass$ResponseGetEvexPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setPaymentGatewayPrefix(String str) {
        str.getClass();
        this.paymentGatewayPrefix_ = str;
    }

    private void setPaymentGatewayPrefixBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.paymentGatewayPrefix_ = abstractC2383g.f0();
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
        switch (S.a[gVar.ordinal()]) {
            case 1:
                return new EvexOuterClass$ResponseGetEvexPaymentToken();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ", new Object[]{"token_", "paymentGatewayPrefix_", "terminalId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (EvexOuterClass$ResponseGetEvexPaymentToken.class) {
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

    public String getPaymentGatewayPrefix() {
        return this.paymentGatewayPrefix_;
    }

    public AbstractC2383g getPaymentGatewayPrefixBytes() {
        return AbstractC2383g.N(this.paymentGatewayPrefix_);
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

    public static a newBuilder(EvexOuterClass$ResponseGetEvexPaymentToken evexOuterClass$ResponseGetEvexPaymentToken) {
        return (a) DEFAULT_INSTANCE.createBuilder(evexOuterClass$ResponseGetEvexPaymentToken);
    }

    public static EvexOuterClass$ResponseGetEvexPaymentToken parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (EvexOuterClass$ResponseGetEvexPaymentToken) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static EvexOuterClass$ResponseGetEvexPaymentToken parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (EvexOuterClass$ResponseGetEvexPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static EvexOuterClass$ResponseGetEvexPaymentToken parseFrom(AbstractC2383g abstractC2383g) {
        return (EvexOuterClass$ResponseGetEvexPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static EvexOuterClass$ResponseGetEvexPaymentToken parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (EvexOuterClass$ResponseGetEvexPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static EvexOuterClass$ResponseGetEvexPaymentToken parseFrom(byte[] bArr) {
        return (EvexOuterClass$ResponseGetEvexPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static EvexOuterClass$ResponseGetEvexPaymentToken parseFrom(byte[] bArr, C2394s c2394s) {
        return (EvexOuterClass$ResponseGetEvexPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static EvexOuterClass$ResponseGetEvexPaymentToken parseFrom(InputStream inputStream) {
        return (EvexOuterClass$ResponseGetEvexPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static EvexOuterClass$ResponseGetEvexPaymentToken parseFrom(InputStream inputStream, C2394s c2394s) {
        return (EvexOuterClass$ResponseGetEvexPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static EvexOuterClass$ResponseGetEvexPaymentToken parseFrom(AbstractC2384h abstractC2384h) {
        return (EvexOuterClass$ResponseGetEvexPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static EvexOuterClass$ResponseGetEvexPaymentToken parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (EvexOuterClass$ResponseGetEvexPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
