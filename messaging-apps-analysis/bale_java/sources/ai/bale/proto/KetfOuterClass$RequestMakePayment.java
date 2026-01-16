package ai.bale.proto;

import ai.bale.proto.KetfStruct$GatewayPaymentParams;
import ai.bale.proto.KetfStruct$WalletPaymentParams;
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
public final class KetfOuterClass$RequestMakePayment extends GeneratedMessageLite implements U64 {
    private static final KetfOuterClass$RequestMakePayment DEFAULT_INSTANCE;
    public static final int GATEWAY_FIELD_NUMBER = 4;
    private static volatile KW4 PARSER = null;
    public static final int PAYMENT_OPTION_ID_FIELD_NUMBER = 2;
    public static final int PAYMENT_SESSION_ID_FIELD_NUMBER = 1;
    public static final int WALLET_FIELD_NUMBER = 3;
    private Object paymentParams_;
    private int paymentParamsCase_ = 0;
    private String paymentSessionId_ = "";
    private String paymentOptionId_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(KetfOuterClass$RequestMakePayment.DEFAULT_INSTANCE);
        }
    }

    public enum b {
        WALLET(3),
        GATEWAY(4),
        PAYMENTPARAMS_NOT_SET(0);

        private final int a;

        b(int i) {
            this.a = i;
        }

        public static b j(int i) {
            if (i == 0) {
                return PAYMENTPARAMS_NOT_SET;
            }
            if (i == 3) {
                return WALLET;
            }
            if (i != 4) {
                return null;
            }
            return GATEWAY;
        }
    }

    static {
        KetfOuterClass$RequestMakePayment ketfOuterClass$RequestMakePayment = new KetfOuterClass$RequestMakePayment();
        DEFAULT_INSTANCE = ketfOuterClass$RequestMakePayment;
        GeneratedMessageLite.registerDefaultInstance(KetfOuterClass$RequestMakePayment.class, ketfOuterClass$RequestMakePayment);
    }

    private KetfOuterClass$RequestMakePayment() {
    }

    private void clearGateway() {
        if (this.paymentParamsCase_ == 4) {
            this.paymentParamsCase_ = 0;
            this.paymentParams_ = null;
        }
    }

    private void clearPaymentOptionId() {
        this.paymentOptionId_ = getDefaultInstance().getPaymentOptionId();
    }

    private void clearPaymentParams() {
        this.paymentParamsCase_ = 0;
        this.paymentParams_ = null;
    }

    private void clearPaymentSessionId() {
        this.paymentSessionId_ = getDefaultInstance().getPaymentSessionId();
    }

    private void clearWallet() {
        if (this.paymentParamsCase_ == 3) {
            this.paymentParamsCase_ = 0;
            this.paymentParams_ = null;
        }
    }

    public static KetfOuterClass$RequestMakePayment getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeGateway(KetfStruct$GatewayPaymentParams ketfStruct$GatewayPaymentParams) {
        ketfStruct$GatewayPaymentParams.getClass();
        if (this.paymentParamsCase_ != 4 || this.paymentParams_ == KetfStruct$GatewayPaymentParams.getDefaultInstance()) {
            this.paymentParams_ = ketfStruct$GatewayPaymentParams;
        } else {
            this.paymentParams_ = ((KetfStruct$GatewayPaymentParams.a) KetfStruct$GatewayPaymentParams.newBuilder((KetfStruct$GatewayPaymentParams) this.paymentParams_).v(ketfStruct$GatewayPaymentParams)).j();
        }
        this.paymentParamsCase_ = 4;
    }

    private void mergeWallet(KetfStruct$WalletPaymentParams ketfStruct$WalletPaymentParams) {
        ketfStruct$WalletPaymentParams.getClass();
        if (this.paymentParamsCase_ != 3 || this.paymentParams_ == KetfStruct$WalletPaymentParams.getDefaultInstance()) {
            this.paymentParams_ = ketfStruct$WalletPaymentParams;
        } else {
            this.paymentParams_ = ((KetfStruct$WalletPaymentParams.a) KetfStruct$WalletPaymentParams.newBuilder((KetfStruct$WalletPaymentParams) this.paymentParams_).v(ketfStruct$WalletPaymentParams)).j();
        }
        this.paymentParamsCase_ = 3;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static KetfOuterClass$RequestMakePayment parseDelimitedFrom(InputStream inputStream) {
        return (KetfOuterClass$RequestMakePayment) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KetfOuterClass$RequestMakePayment parseFrom(ByteBuffer byteBuffer) {
        return (KetfOuterClass$RequestMakePayment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setGateway(KetfStruct$GatewayPaymentParams ketfStruct$GatewayPaymentParams) {
        ketfStruct$GatewayPaymentParams.getClass();
        this.paymentParams_ = ketfStruct$GatewayPaymentParams;
        this.paymentParamsCase_ = 4;
    }

    private void setPaymentOptionId(String str) {
        str.getClass();
        this.paymentOptionId_ = str;
    }

    private void setPaymentOptionIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.paymentOptionId_ = abstractC2383g.f0();
    }

    private void setPaymentSessionId(String str) {
        str.getClass();
        this.paymentSessionId_ = str;
    }

    private void setPaymentSessionIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.paymentSessionId_ = abstractC2383g.f0();
    }

    private void setWallet(KetfStruct$WalletPaymentParams ketfStruct$WalletPaymentParams) {
        ketfStruct$WalletPaymentParams.getClass();
        this.paymentParams_ = ketfStruct$WalletPaymentParams;
        this.paymentParamsCase_ = 3;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1888r0.a[gVar.ordinal()]) {
            case 1:
                return new KetfOuterClass$RequestMakePayment();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0001\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003<\u0000\u0004<\u0000", new Object[]{"paymentParams_", "paymentParamsCase_", "paymentSessionId_", "paymentOptionId_", KetfStruct$WalletPaymentParams.class, KetfStruct$GatewayPaymentParams.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (KetfOuterClass$RequestMakePayment.class) {
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

    public KetfStruct$GatewayPaymentParams getGateway() {
        return this.paymentParamsCase_ == 4 ? (KetfStruct$GatewayPaymentParams) this.paymentParams_ : KetfStruct$GatewayPaymentParams.getDefaultInstance();
    }

    public String getPaymentOptionId() {
        return this.paymentOptionId_;
    }

    public AbstractC2383g getPaymentOptionIdBytes() {
        return AbstractC2383g.N(this.paymentOptionId_);
    }

    public b getPaymentParamsCase() {
        return b.j(this.paymentParamsCase_);
    }

    public String getPaymentSessionId() {
        return this.paymentSessionId_;
    }

    public AbstractC2383g getPaymentSessionIdBytes() {
        return AbstractC2383g.N(this.paymentSessionId_);
    }

    public KetfStruct$WalletPaymentParams getWallet() {
        return this.paymentParamsCase_ == 3 ? (KetfStruct$WalletPaymentParams) this.paymentParams_ : KetfStruct$WalletPaymentParams.getDefaultInstance();
    }

    public boolean hasGateway() {
        return this.paymentParamsCase_ == 4;
    }

    public boolean hasWallet() {
        return this.paymentParamsCase_ == 3;
    }

    public static a newBuilder(KetfOuterClass$RequestMakePayment ketfOuterClass$RequestMakePayment) {
        return (a) DEFAULT_INSTANCE.createBuilder(ketfOuterClass$RequestMakePayment);
    }

    public static KetfOuterClass$RequestMakePayment parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (KetfOuterClass$RequestMakePayment) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KetfOuterClass$RequestMakePayment parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (KetfOuterClass$RequestMakePayment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static KetfOuterClass$RequestMakePayment parseFrom(AbstractC2383g abstractC2383g) {
        return (KetfOuterClass$RequestMakePayment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static KetfOuterClass$RequestMakePayment parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (KetfOuterClass$RequestMakePayment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static KetfOuterClass$RequestMakePayment parseFrom(byte[] bArr) {
        return (KetfOuterClass$RequestMakePayment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static KetfOuterClass$RequestMakePayment parseFrom(byte[] bArr, C2394s c2394s) {
        return (KetfOuterClass$RequestMakePayment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static KetfOuterClass$RequestMakePayment parseFrom(InputStream inputStream) {
        return (KetfOuterClass$RequestMakePayment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KetfOuterClass$RequestMakePayment parseFrom(InputStream inputStream, C2394s c2394s) {
        return (KetfOuterClass$RequestMakePayment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KetfOuterClass$RequestMakePayment parseFrom(AbstractC2384h abstractC2384h) {
        return (KetfOuterClass$RequestMakePayment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static KetfOuterClass$RequestMakePayment parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (KetfOuterClass$RequestMakePayment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
