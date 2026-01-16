package ai.bale.proto;

import ai.bale.proto.KetfStruct$GatewayRedirect;
import ai.bale.proto.KetfStruct$PaymentReceipt;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class KetfOuterClass$ResponseMakePayment extends GeneratedMessageLite implements U64 {
    private static final KetfOuterClass$ResponseMakePayment DEFAULT_INSTANCE;
    public static final int GATEWAY_REDIRECT_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int PAYMENT_RECEIPT_FIELD_NUMBER = 2;
    private int resultCase_ = 0;
    private Object result_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(KetfOuterClass$ResponseMakePayment.DEFAULT_INSTANCE);
        }
    }

    public enum b {
        GATEWAY_REDIRECT(1),
        PAYMENT_RECEIPT(2),
        RESULT_NOT_SET(0);

        private final int a;

        b(int i) {
            this.a = i;
        }

        public static b j(int i) {
            if (i == 0) {
                return RESULT_NOT_SET;
            }
            if (i == 1) {
                return GATEWAY_REDIRECT;
            }
            if (i != 2) {
                return null;
            }
            return PAYMENT_RECEIPT;
        }
    }

    static {
        KetfOuterClass$ResponseMakePayment ketfOuterClass$ResponseMakePayment = new KetfOuterClass$ResponseMakePayment();
        DEFAULT_INSTANCE = ketfOuterClass$ResponseMakePayment;
        GeneratedMessageLite.registerDefaultInstance(KetfOuterClass$ResponseMakePayment.class, ketfOuterClass$ResponseMakePayment);
    }

    private KetfOuterClass$ResponseMakePayment() {
    }

    private void clearGatewayRedirect() {
        if (this.resultCase_ == 1) {
            this.resultCase_ = 0;
            this.result_ = null;
        }
    }

    private void clearPaymentReceipt() {
        if (this.resultCase_ == 2) {
            this.resultCase_ = 0;
            this.result_ = null;
        }
    }

    private void clearResult() {
        this.resultCase_ = 0;
        this.result_ = null;
    }

    public static KetfOuterClass$ResponseMakePayment getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeGatewayRedirect(KetfStruct$GatewayRedirect ketfStruct$GatewayRedirect) {
        ketfStruct$GatewayRedirect.getClass();
        if (this.resultCase_ != 1 || this.result_ == KetfStruct$GatewayRedirect.getDefaultInstance()) {
            this.result_ = ketfStruct$GatewayRedirect;
        } else {
            this.result_ = ((KetfStruct$GatewayRedirect.a) KetfStruct$GatewayRedirect.newBuilder((KetfStruct$GatewayRedirect) this.result_).v(ketfStruct$GatewayRedirect)).j();
        }
        this.resultCase_ = 1;
    }

    private void mergePaymentReceipt(KetfStruct$PaymentReceipt ketfStruct$PaymentReceipt) {
        ketfStruct$PaymentReceipt.getClass();
        if (this.resultCase_ != 2 || this.result_ == KetfStruct$PaymentReceipt.getDefaultInstance()) {
            this.result_ = ketfStruct$PaymentReceipt;
        } else {
            this.result_ = ((KetfStruct$PaymentReceipt.a) KetfStruct$PaymentReceipt.newBuilder((KetfStruct$PaymentReceipt) this.result_).v(ketfStruct$PaymentReceipt)).j();
        }
        this.resultCase_ = 2;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static KetfOuterClass$ResponseMakePayment parseDelimitedFrom(InputStream inputStream) {
        return (KetfOuterClass$ResponseMakePayment) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KetfOuterClass$ResponseMakePayment parseFrom(ByteBuffer byteBuffer) {
        return (KetfOuterClass$ResponseMakePayment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setGatewayRedirect(KetfStruct$GatewayRedirect ketfStruct$GatewayRedirect) {
        ketfStruct$GatewayRedirect.getClass();
        this.result_ = ketfStruct$GatewayRedirect;
        this.resultCase_ = 1;
    }

    private void setPaymentReceipt(KetfStruct$PaymentReceipt ketfStruct$PaymentReceipt) {
        ketfStruct$PaymentReceipt.getClass();
        this.result_ = ketfStruct$PaymentReceipt;
        this.resultCase_ = 2;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1888r0.a[gVar.ordinal()]) {
            case 1:
                return new KetfOuterClass$ResponseMakePayment();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0001\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001<\u0000\u0002<\u0000", new Object[]{"result_", "resultCase_", KetfStruct$GatewayRedirect.class, KetfStruct$PaymentReceipt.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (KetfOuterClass$ResponseMakePayment.class) {
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

    public KetfStruct$GatewayRedirect getGatewayRedirect() {
        return this.resultCase_ == 1 ? (KetfStruct$GatewayRedirect) this.result_ : KetfStruct$GatewayRedirect.getDefaultInstance();
    }

    public KetfStruct$PaymentReceipt getPaymentReceipt() {
        return this.resultCase_ == 2 ? (KetfStruct$PaymentReceipt) this.result_ : KetfStruct$PaymentReceipt.getDefaultInstance();
    }

    public b getResultCase() {
        return b.j(this.resultCase_);
    }

    public boolean hasGatewayRedirect() {
        return this.resultCase_ == 1;
    }

    public boolean hasPaymentReceipt() {
        return this.resultCase_ == 2;
    }

    public static a newBuilder(KetfOuterClass$ResponseMakePayment ketfOuterClass$ResponseMakePayment) {
        return (a) DEFAULT_INSTANCE.createBuilder(ketfOuterClass$ResponseMakePayment);
    }

    public static KetfOuterClass$ResponseMakePayment parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (KetfOuterClass$ResponseMakePayment) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KetfOuterClass$ResponseMakePayment parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (KetfOuterClass$ResponseMakePayment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static KetfOuterClass$ResponseMakePayment parseFrom(AbstractC2383g abstractC2383g) {
        return (KetfOuterClass$ResponseMakePayment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static KetfOuterClass$ResponseMakePayment parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (KetfOuterClass$ResponseMakePayment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static KetfOuterClass$ResponseMakePayment parseFrom(byte[] bArr) {
        return (KetfOuterClass$ResponseMakePayment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static KetfOuterClass$ResponseMakePayment parseFrom(byte[] bArr, C2394s c2394s) {
        return (KetfOuterClass$ResponseMakePayment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static KetfOuterClass$ResponseMakePayment parseFrom(InputStream inputStream) {
        return (KetfOuterClass$ResponseMakePayment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KetfOuterClass$ResponseMakePayment parseFrom(InputStream inputStream, C2394s c2394s) {
        return (KetfOuterClass$ResponseMakePayment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KetfOuterClass$ResponseMakePayment parseFrom(AbstractC2384h abstractC2384h) {
        return (KetfOuterClass$ResponseMakePayment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static KetfOuterClass$ResponseMakePayment parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (KetfOuterClass$ResponseMakePayment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
