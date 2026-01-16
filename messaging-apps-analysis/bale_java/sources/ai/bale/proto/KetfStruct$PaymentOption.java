package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC11319co3;
import ir.nasim.InterfaceC9110Yn3;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class KetfStruct$PaymentOption extends GeneratedMessageLite implements InterfaceC9110Yn3 {
    private static final KetfStruct$PaymentOption DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int PAYMENT_OPTION_ID_FIELD_NUMBER = 1;
    public static final int PAYMENT_TYPE_FIELD_NUMBER = 2;
    private String paymentOptionId_ = "";
    private int paymentType_;

    public static final class a extends GeneratedMessageLite.b implements InterfaceC9110Yn3 {
        private a() {
            super(KetfStruct$PaymentOption.DEFAULT_INSTANCE);
        }
    }

    static {
        KetfStruct$PaymentOption ketfStruct$PaymentOption = new KetfStruct$PaymentOption();
        DEFAULT_INSTANCE = ketfStruct$PaymentOption;
        GeneratedMessageLite.registerDefaultInstance(KetfStruct$PaymentOption.class, ketfStruct$PaymentOption);
    }

    private KetfStruct$PaymentOption() {
    }

    private void clearPaymentOptionId() {
        this.paymentOptionId_ = getDefaultInstance().getPaymentOptionId();
    }

    private void clearPaymentType() {
        this.paymentType_ = 0;
    }

    public static KetfStruct$PaymentOption getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static KetfStruct$PaymentOption parseDelimitedFrom(InputStream inputStream) {
        return (KetfStruct$PaymentOption) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KetfStruct$PaymentOption parseFrom(ByteBuffer byteBuffer) {
        return (KetfStruct$PaymentOption) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setPaymentOptionId(String str) {
        str.getClass();
        this.paymentOptionId_ = str;
    }

    private void setPaymentOptionIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.paymentOptionId_ = abstractC2383g.f0();
    }

    private void setPaymentType(EnumC11319co3 enumC11319co3) {
        this.paymentType_ = enumC11319co3.getNumber();
    }

    private void setPaymentTypeValue(int i) {
        this.paymentType_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1891s0.a[gVar.ordinal()]) {
            case 1:
                return new KetfStruct$PaymentOption();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002\f", new Object[]{"paymentOptionId_", "paymentType_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (KetfStruct$PaymentOption.class) {
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

    public String getPaymentOptionId() {
        return this.paymentOptionId_;
    }

    public AbstractC2383g getPaymentOptionIdBytes() {
        return AbstractC2383g.N(this.paymentOptionId_);
    }

    public EnumC11319co3 getPaymentType() {
        EnumC11319co3 enumC11319co3J = EnumC11319co3.j(this.paymentType_);
        return enumC11319co3J == null ? EnumC11319co3.UNRECOGNIZED : enumC11319co3J;
    }

    public int getPaymentTypeValue() {
        return this.paymentType_;
    }

    public static a newBuilder(KetfStruct$PaymentOption ketfStruct$PaymentOption) {
        return (a) DEFAULT_INSTANCE.createBuilder(ketfStruct$PaymentOption);
    }

    public static KetfStruct$PaymentOption parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (KetfStruct$PaymentOption) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KetfStruct$PaymentOption parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (KetfStruct$PaymentOption) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static KetfStruct$PaymentOption parseFrom(AbstractC2383g abstractC2383g) {
        return (KetfStruct$PaymentOption) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static KetfStruct$PaymentOption parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (KetfStruct$PaymentOption) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static KetfStruct$PaymentOption parseFrom(byte[] bArr) {
        return (KetfStruct$PaymentOption) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static KetfStruct$PaymentOption parseFrom(byte[] bArr, C2394s c2394s) {
        return (KetfStruct$PaymentOption) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static KetfStruct$PaymentOption parseFrom(InputStream inputStream) {
        return (KetfStruct$PaymentOption) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KetfStruct$PaymentOption parseFrom(InputStream inputStream, C2394s c2394s) {
        return (KetfStruct$PaymentOption) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KetfStruct$PaymentOption parseFrom(AbstractC2384h abstractC2384h) {
        return (KetfStruct$PaymentOption) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static KetfStruct$PaymentOption parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (KetfStruct$PaymentOption) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
