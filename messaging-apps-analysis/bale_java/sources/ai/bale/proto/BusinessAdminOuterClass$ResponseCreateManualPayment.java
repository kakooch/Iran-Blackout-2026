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
public final class BusinessAdminOuterClass$ResponseCreateManualPayment extends GeneratedMessageLite implements U64 {
    private static final BusinessAdminOuterClass$ResponseCreateManualPayment DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int PAYMENT_ID_FIELD_NUMBER = 1;
    private String paymentId_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(BusinessAdminOuterClass$ResponseCreateManualPayment.DEFAULT_INSTANCE);
        }
    }

    static {
        BusinessAdminOuterClass$ResponseCreateManualPayment businessAdminOuterClass$ResponseCreateManualPayment = new BusinessAdminOuterClass$ResponseCreateManualPayment();
        DEFAULT_INSTANCE = businessAdminOuterClass$ResponseCreateManualPayment;
        GeneratedMessageLite.registerDefaultInstance(BusinessAdminOuterClass$ResponseCreateManualPayment.class, businessAdminOuterClass$ResponseCreateManualPayment);
    }

    private BusinessAdminOuterClass$ResponseCreateManualPayment() {
    }

    private void clearPaymentId() {
        this.paymentId_ = getDefaultInstance().getPaymentId();
    }

    public static BusinessAdminOuterClass$ResponseCreateManualPayment getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static BusinessAdminOuterClass$ResponseCreateManualPayment parseDelimitedFrom(InputStream inputStream) {
        return (BusinessAdminOuterClass$ResponseCreateManualPayment) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BusinessAdminOuterClass$ResponseCreateManualPayment parseFrom(ByteBuffer byteBuffer) {
        return (BusinessAdminOuterClass$ResponseCreateManualPayment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setPaymentId(String str) {
        str.getClass();
        this.paymentId_ = str;
    }

    private void setPaymentIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.paymentId_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1893t.a[gVar.ordinal()]) {
            case 1:
                return new BusinessAdminOuterClass$ResponseCreateManualPayment();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"paymentId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (BusinessAdminOuterClass$ResponseCreateManualPayment.class) {
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

    public String getPaymentId() {
        return this.paymentId_;
    }

    public AbstractC2383g getPaymentIdBytes() {
        return AbstractC2383g.N(this.paymentId_);
    }

    public static a newBuilder(BusinessAdminOuterClass$ResponseCreateManualPayment businessAdminOuterClass$ResponseCreateManualPayment) {
        return (a) DEFAULT_INSTANCE.createBuilder(businessAdminOuterClass$ResponseCreateManualPayment);
    }

    public static BusinessAdminOuterClass$ResponseCreateManualPayment parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (BusinessAdminOuterClass$ResponseCreateManualPayment) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BusinessAdminOuterClass$ResponseCreateManualPayment parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (BusinessAdminOuterClass$ResponseCreateManualPayment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static BusinessAdminOuterClass$ResponseCreateManualPayment parseFrom(AbstractC2383g abstractC2383g) {
        return (BusinessAdminOuterClass$ResponseCreateManualPayment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static BusinessAdminOuterClass$ResponseCreateManualPayment parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (BusinessAdminOuterClass$ResponseCreateManualPayment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static BusinessAdminOuterClass$ResponseCreateManualPayment parseFrom(byte[] bArr) {
        return (BusinessAdminOuterClass$ResponseCreateManualPayment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static BusinessAdminOuterClass$ResponseCreateManualPayment parseFrom(byte[] bArr, C2394s c2394s) {
        return (BusinessAdminOuterClass$ResponseCreateManualPayment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static BusinessAdminOuterClass$ResponseCreateManualPayment parseFrom(InputStream inputStream) {
        return (BusinessAdminOuterClass$ResponseCreateManualPayment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BusinessAdminOuterClass$ResponseCreateManualPayment parseFrom(InputStream inputStream, C2394s c2394s) {
        return (BusinessAdminOuterClass$ResponseCreateManualPayment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BusinessAdminOuterClass$ResponseCreateManualPayment parseFrom(AbstractC2384h abstractC2384h) {
        return (BusinessAdminOuterClass$ResponseCreateManualPayment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static BusinessAdminOuterClass$ResponseCreateManualPayment parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (BusinessAdminOuterClass$ResponseCreateManualPayment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
