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
public final class Car$ResponseFreewayPayment extends GeneratedMessageLite implements U64 {
    private static final Car$ResponseFreewayPayment DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int PAYMENT_KEY_FIELD_NUMBER = 2;
    public static final int PAYMENT_LINK_FIELD_NUMBER = 1;
    private String paymentLink_ = "";
    private String paymentKey_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Car$ResponseFreewayPayment.DEFAULT_INSTANCE);
        }
    }

    static {
        Car$ResponseFreewayPayment car$ResponseFreewayPayment = new Car$ResponseFreewayPayment();
        DEFAULT_INSTANCE = car$ResponseFreewayPayment;
        GeneratedMessageLite.registerDefaultInstance(Car$ResponseFreewayPayment.class, car$ResponseFreewayPayment);
    }

    private Car$ResponseFreewayPayment() {
    }

    private void clearPaymentKey() {
        this.paymentKey_ = getDefaultInstance().getPaymentKey();
    }

    private void clearPaymentLink() {
        this.paymentLink_ = getDefaultInstance().getPaymentLink();
    }

    public static Car$ResponseFreewayPayment getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Car$ResponseFreewayPayment parseDelimitedFrom(InputStream inputStream) {
        return (Car$ResponseFreewayPayment) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Car$ResponseFreewayPayment parseFrom(ByteBuffer byteBuffer) {
        return (Car$ResponseFreewayPayment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setPaymentKey(String str) {
        str.getClass();
        this.paymentKey_ = str;
    }

    private void setPaymentKeyBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.paymentKey_ = abstractC2383g.f0();
    }

    private void setPaymentLink(String str) {
        str.getClass();
        this.paymentLink_ = str;
    }

    private void setPaymentLinkBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.paymentLink_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1905x.a[gVar.ordinal()]) {
            case 1:
                return new Car$ResponseFreewayPayment();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ", new Object[]{"paymentLink_", "paymentKey_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Car$ResponseFreewayPayment.class) {
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

    public String getPaymentKey() {
        return this.paymentKey_;
    }

    public AbstractC2383g getPaymentKeyBytes() {
        return AbstractC2383g.N(this.paymentKey_);
    }

    public String getPaymentLink() {
        return this.paymentLink_;
    }

    public AbstractC2383g getPaymentLinkBytes() {
        return AbstractC2383g.N(this.paymentLink_);
    }

    public static a newBuilder(Car$ResponseFreewayPayment car$ResponseFreewayPayment) {
        return (a) DEFAULT_INSTANCE.createBuilder(car$ResponseFreewayPayment);
    }

    public static Car$ResponseFreewayPayment parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Car$ResponseFreewayPayment) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Car$ResponseFreewayPayment parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Car$ResponseFreewayPayment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Car$ResponseFreewayPayment parseFrom(AbstractC2383g abstractC2383g) {
        return (Car$ResponseFreewayPayment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static Car$ResponseFreewayPayment parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Car$ResponseFreewayPayment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Car$ResponseFreewayPayment parseFrom(byte[] bArr) {
        return (Car$ResponseFreewayPayment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Car$ResponseFreewayPayment parseFrom(byte[] bArr, C2394s c2394s) {
        return (Car$ResponseFreewayPayment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Car$ResponseFreewayPayment parseFrom(InputStream inputStream) {
        return (Car$ResponseFreewayPayment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Car$ResponseFreewayPayment parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Car$ResponseFreewayPayment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Car$ResponseFreewayPayment parseFrom(AbstractC2384h abstractC2384h) {
        return (Car$ResponseFreewayPayment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Car$ResponseFreewayPayment parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Car$ResponseFreewayPayment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
