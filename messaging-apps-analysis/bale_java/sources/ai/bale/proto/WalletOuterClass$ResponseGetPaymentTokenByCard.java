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
public final class WalletOuterClass$ResponseGetPaymentTokenByCard extends GeneratedMessageLite implements U64 {
    private static final WalletOuterClass$ResponseGetPaymentTokenByCard DEFAULT_INSTANCE;
    public static final int ENDPOINT_FIELD_NUMBER = 2;
    public static final int MERCHANT_ID_FIELD_NUMBER = 4;
    private static volatile KW4 PARSER = null;
    public static final int TERMINAL_ID_FIELD_NUMBER = 3;
    public static final int TOKEN_FIELD_NUMBER = 1;
    private String token_ = "";
    private String endpoint_ = "";
    private String terminalId_ = "";
    private String merchantId_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(WalletOuterClass$ResponseGetPaymentTokenByCard.DEFAULT_INSTANCE);
        }
    }

    static {
        WalletOuterClass$ResponseGetPaymentTokenByCard walletOuterClass$ResponseGetPaymentTokenByCard = new WalletOuterClass$ResponseGetPaymentTokenByCard();
        DEFAULT_INSTANCE = walletOuterClass$ResponseGetPaymentTokenByCard;
        GeneratedMessageLite.registerDefaultInstance(WalletOuterClass$ResponseGetPaymentTokenByCard.class, walletOuterClass$ResponseGetPaymentTokenByCard);
    }

    private WalletOuterClass$ResponseGetPaymentTokenByCard() {
    }

    private void clearEndpoint() {
        this.endpoint_ = getDefaultInstance().getEndpoint();
    }

    private void clearMerchantId() {
        this.merchantId_ = getDefaultInstance().getMerchantId();
    }

    private void clearTerminalId() {
        this.terminalId_ = getDefaultInstance().getTerminalId();
    }

    private void clearToken() {
        this.token_ = getDefaultInstance().getToken();
    }

    public static WalletOuterClass$ResponseGetPaymentTokenByCard getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static WalletOuterClass$ResponseGetPaymentTokenByCard parseDelimitedFrom(InputStream inputStream) {
        return (WalletOuterClass$ResponseGetPaymentTokenByCard) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static WalletOuterClass$ResponseGetPaymentTokenByCard parseFrom(ByteBuffer byteBuffer) {
        return (WalletOuterClass$ResponseGetPaymentTokenByCard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
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

    private void setMerchantId(String str) {
        str.getClass();
        this.merchantId_ = str;
    }

    private void setMerchantIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.merchantId_ = abstractC2383g.f0();
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
        switch (u2.a[gVar.ordinal()]) {
            case 1:
                return new WalletOuterClass$ResponseGetPaymentTokenByCard();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004Ȉ", new Object[]{"token_", "endpoint_", "terminalId_", "merchantId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (WalletOuterClass$ResponseGetPaymentTokenByCard.class) {
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

    public String getMerchantId() {
        return this.merchantId_;
    }

    public AbstractC2383g getMerchantIdBytes() {
        return AbstractC2383g.N(this.merchantId_);
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

    public static a newBuilder(WalletOuterClass$ResponseGetPaymentTokenByCard walletOuterClass$ResponseGetPaymentTokenByCard) {
        return (a) DEFAULT_INSTANCE.createBuilder(walletOuterClass$ResponseGetPaymentTokenByCard);
    }

    public static WalletOuterClass$ResponseGetPaymentTokenByCard parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (WalletOuterClass$ResponseGetPaymentTokenByCard) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static WalletOuterClass$ResponseGetPaymentTokenByCard parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (WalletOuterClass$ResponseGetPaymentTokenByCard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static WalletOuterClass$ResponseGetPaymentTokenByCard parseFrom(AbstractC2383g abstractC2383g) {
        return (WalletOuterClass$ResponseGetPaymentTokenByCard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static WalletOuterClass$ResponseGetPaymentTokenByCard parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (WalletOuterClass$ResponseGetPaymentTokenByCard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static WalletOuterClass$ResponseGetPaymentTokenByCard parseFrom(byte[] bArr) {
        return (WalletOuterClass$ResponseGetPaymentTokenByCard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static WalletOuterClass$ResponseGetPaymentTokenByCard parseFrom(byte[] bArr, C2394s c2394s) {
        return (WalletOuterClass$ResponseGetPaymentTokenByCard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static WalletOuterClass$ResponseGetPaymentTokenByCard parseFrom(InputStream inputStream) {
        return (WalletOuterClass$ResponseGetPaymentTokenByCard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static WalletOuterClass$ResponseGetPaymentTokenByCard parseFrom(InputStream inputStream, C2394s c2394s) {
        return (WalletOuterClass$ResponseGetPaymentTokenByCard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static WalletOuterClass$ResponseGetPaymentTokenByCard parseFrom(AbstractC2384h abstractC2384h) {
        return (WalletOuterClass$ResponseGetPaymentTokenByCard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static WalletOuterClass$ResponseGetPaymentTokenByCard parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (WalletOuterClass$ResponseGetPaymentTokenByCard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
