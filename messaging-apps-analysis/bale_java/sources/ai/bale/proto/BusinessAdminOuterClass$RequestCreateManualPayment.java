package ai.bale.proto;

import ai.bale.proto.BusinessStruct$ManualPayment;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class BusinessAdminOuterClass$RequestCreateManualPayment extends GeneratedMessageLite implements U64 {
    private static final BusinessAdminOuterClass$RequestCreateManualPayment DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int PAYMENT_FIELD_NUMBER = 1;
    private int bitField0_;
    private BusinessStruct$ManualPayment payment_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(BusinessAdminOuterClass$RequestCreateManualPayment.DEFAULT_INSTANCE);
        }
    }

    static {
        BusinessAdminOuterClass$RequestCreateManualPayment businessAdminOuterClass$RequestCreateManualPayment = new BusinessAdminOuterClass$RequestCreateManualPayment();
        DEFAULT_INSTANCE = businessAdminOuterClass$RequestCreateManualPayment;
        GeneratedMessageLite.registerDefaultInstance(BusinessAdminOuterClass$RequestCreateManualPayment.class, businessAdminOuterClass$RequestCreateManualPayment);
    }

    private BusinessAdminOuterClass$RequestCreateManualPayment() {
    }

    private void clearPayment() {
        this.payment_ = null;
        this.bitField0_ &= -2;
    }

    public static BusinessAdminOuterClass$RequestCreateManualPayment getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergePayment(BusinessStruct$ManualPayment businessStruct$ManualPayment) {
        businessStruct$ManualPayment.getClass();
        BusinessStruct$ManualPayment businessStruct$ManualPayment2 = this.payment_;
        if (businessStruct$ManualPayment2 == null || businessStruct$ManualPayment2 == BusinessStruct$ManualPayment.getDefaultInstance()) {
            this.payment_ = businessStruct$ManualPayment;
        } else {
            this.payment_ = (BusinessStruct$ManualPayment) ((BusinessStruct$ManualPayment.a) BusinessStruct$ManualPayment.newBuilder(this.payment_).v(businessStruct$ManualPayment)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static BusinessAdminOuterClass$RequestCreateManualPayment parseDelimitedFrom(InputStream inputStream) {
        return (BusinessAdminOuterClass$RequestCreateManualPayment) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BusinessAdminOuterClass$RequestCreateManualPayment parseFrom(ByteBuffer byteBuffer) {
        return (BusinessAdminOuterClass$RequestCreateManualPayment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setPayment(BusinessStruct$ManualPayment businessStruct$ManualPayment) {
        businessStruct$ManualPayment.getClass();
        this.payment_ = businessStruct$ManualPayment;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1893t.a[gVar.ordinal()]) {
            case 1:
                return new BusinessAdminOuterClass$RequestCreateManualPayment();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "payment_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (BusinessAdminOuterClass$RequestCreateManualPayment.class) {
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

    public BusinessStruct$ManualPayment getPayment() {
        BusinessStruct$ManualPayment businessStruct$ManualPayment = this.payment_;
        return businessStruct$ManualPayment == null ? BusinessStruct$ManualPayment.getDefaultInstance() : businessStruct$ManualPayment;
    }

    public boolean hasPayment() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(BusinessAdminOuterClass$RequestCreateManualPayment businessAdminOuterClass$RequestCreateManualPayment) {
        return (a) DEFAULT_INSTANCE.createBuilder(businessAdminOuterClass$RequestCreateManualPayment);
    }

    public static BusinessAdminOuterClass$RequestCreateManualPayment parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (BusinessAdminOuterClass$RequestCreateManualPayment) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BusinessAdminOuterClass$RequestCreateManualPayment parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (BusinessAdminOuterClass$RequestCreateManualPayment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static BusinessAdminOuterClass$RequestCreateManualPayment parseFrom(AbstractC2383g abstractC2383g) {
        return (BusinessAdminOuterClass$RequestCreateManualPayment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static BusinessAdminOuterClass$RequestCreateManualPayment parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (BusinessAdminOuterClass$RequestCreateManualPayment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static BusinessAdminOuterClass$RequestCreateManualPayment parseFrom(byte[] bArr) {
        return (BusinessAdminOuterClass$RequestCreateManualPayment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static BusinessAdminOuterClass$RequestCreateManualPayment parseFrom(byte[] bArr, C2394s c2394s) {
        return (BusinessAdminOuterClass$RequestCreateManualPayment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static BusinessAdminOuterClass$RequestCreateManualPayment parseFrom(InputStream inputStream) {
        return (BusinessAdminOuterClass$RequestCreateManualPayment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BusinessAdminOuterClass$RequestCreateManualPayment parseFrom(InputStream inputStream, C2394s c2394s) {
        return (BusinessAdminOuterClass$RequestCreateManualPayment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BusinessAdminOuterClass$RequestCreateManualPayment parseFrom(AbstractC2384h abstractC2384h) {
        return (BusinessAdminOuterClass$RequestCreateManualPayment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static BusinessAdminOuterClass$RequestCreateManualPayment parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (BusinessAdminOuterClass$RequestCreateManualPayment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
