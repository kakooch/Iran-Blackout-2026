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
public final class PremiumOuterClass$ResponsePurchasePackage extends GeneratedMessageLite implements U64 {
    private static final PremiumOuterClass$ResponsePurchasePackage DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int SADAD_PAYMENT_TOKEN_FIELD_NUMBER = 1;
    private int paymentMethodCase_ = 0;
    private Object paymentMethod_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(PremiumOuterClass$ResponsePurchasePackage.DEFAULT_INSTANCE);
        }
    }

    public enum b {
        SADAD_PAYMENT_TOKEN(1),
        PAYMENTMETHOD_NOT_SET(0);

        private final int a;

        b(int i) {
            this.a = i;
        }

        public static b j(int i) {
            if (i == 0) {
                return PAYMENTMETHOD_NOT_SET;
            }
            if (i != 1) {
                return null;
            }
            return SADAD_PAYMENT_TOKEN;
        }
    }

    static {
        PremiumOuterClass$ResponsePurchasePackage premiumOuterClass$ResponsePurchasePackage = new PremiumOuterClass$ResponsePurchasePackage();
        DEFAULT_INSTANCE = premiumOuterClass$ResponsePurchasePackage;
        GeneratedMessageLite.registerDefaultInstance(PremiumOuterClass$ResponsePurchasePackage.class, premiumOuterClass$ResponsePurchasePackage);
    }

    private PremiumOuterClass$ResponsePurchasePackage() {
    }

    private void clearPaymentMethod() {
        this.paymentMethodCase_ = 0;
        this.paymentMethod_ = null;
    }

    private void clearSadadPaymentToken() {
        if (this.paymentMethodCase_ == 1) {
            this.paymentMethodCase_ = 0;
            this.paymentMethod_ = null;
        }
    }

    public static PremiumOuterClass$ResponsePurchasePackage getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static PremiumOuterClass$ResponsePurchasePackage parseDelimitedFrom(InputStream inputStream) {
        return (PremiumOuterClass$ResponsePurchasePackage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PremiumOuterClass$ResponsePurchasePackage parseFrom(ByteBuffer byteBuffer) {
        return (PremiumOuterClass$ResponsePurchasePackage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setSadadPaymentToken(String str) {
        str.getClass();
        this.paymentMethodCase_ = 1;
        this.paymentMethod_ = str;
    }

    private void setSadadPaymentTokenBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.paymentMethod_ = abstractC2383g.f0();
        this.paymentMethodCase_ = 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1860h1.a[gVar.ordinal()]) {
            case 1:
                return new PremiumOuterClass$ResponsePurchasePackage();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0001\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȼ\u0000", new Object[]{"paymentMethod_", "paymentMethodCase_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (PremiumOuterClass$ResponsePurchasePackage.class) {
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

    public b getPaymentMethodCase() {
        return b.j(this.paymentMethodCase_);
    }

    public String getSadadPaymentToken() {
        return this.paymentMethodCase_ == 1 ? (String) this.paymentMethod_ : "";
    }

    public AbstractC2383g getSadadPaymentTokenBytes() {
        return AbstractC2383g.N(this.paymentMethodCase_ == 1 ? (String) this.paymentMethod_ : "");
    }

    public boolean hasSadadPaymentToken() {
        return this.paymentMethodCase_ == 1;
    }

    public static a newBuilder(PremiumOuterClass$ResponsePurchasePackage premiumOuterClass$ResponsePurchasePackage) {
        return (a) DEFAULT_INSTANCE.createBuilder(premiumOuterClass$ResponsePurchasePackage);
    }

    public static PremiumOuterClass$ResponsePurchasePackage parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (PremiumOuterClass$ResponsePurchasePackage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PremiumOuterClass$ResponsePurchasePackage parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (PremiumOuterClass$ResponsePurchasePackage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static PremiumOuterClass$ResponsePurchasePackage parseFrom(AbstractC2383g abstractC2383g) {
        return (PremiumOuterClass$ResponsePurchasePackage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static PremiumOuterClass$ResponsePurchasePackage parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (PremiumOuterClass$ResponsePurchasePackage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static PremiumOuterClass$ResponsePurchasePackage parseFrom(byte[] bArr) {
        return (PremiumOuterClass$ResponsePurchasePackage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PremiumOuterClass$ResponsePurchasePackage parseFrom(byte[] bArr, C2394s c2394s) {
        return (PremiumOuterClass$ResponsePurchasePackage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static PremiumOuterClass$ResponsePurchasePackage parseFrom(InputStream inputStream) {
        return (PremiumOuterClass$ResponsePurchasePackage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PremiumOuterClass$ResponsePurchasePackage parseFrom(InputStream inputStream, C2394s c2394s) {
        return (PremiumOuterClass$ResponsePurchasePackage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PremiumOuterClass$ResponsePurchasePackage parseFrom(AbstractC2384h abstractC2384h) {
        return (PremiumOuterClass$ResponsePurchasePackage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static PremiumOuterClass$ResponsePurchasePackage parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (PremiumOuterClass$ResponsePurchasePackage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
