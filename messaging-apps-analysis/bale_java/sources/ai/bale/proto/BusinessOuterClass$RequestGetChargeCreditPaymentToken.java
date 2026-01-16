package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.StringValue;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class BusinessOuterClass$RequestGetChargeCreditPaymentToken extends GeneratedMessageLite implements U64 {
    public static final int AMOUNT_FIELD_NUMBER = 1;
    public static final int CALLBACK_SERVICE_ADDRESS_FIELD_NUMBER = 2;
    private static final BusinessOuterClass$RequestGetChargeCreditPaymentToken DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private long amount_;
    private int bitField0_;
    private StringValue callbackServiceAddress_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(BusinessOuterClass$RequestGetChargeCreditPaymentToken.DEFAULT_INSTANCE);
        }
    }

    static {
        BusinessOuterClass$RequestGetChargeCreditPaymentToken businessOuterClass$RequestGetChargeCreditPaymentToken = new BusinessOuterClass$RequestGetChargeCreditPaymentToken();
        DEFAULT_INSTANCE = businessOuterClass$RequestGetChargeCreditPaymentToken;
        GeneratedMessageLite.registerDefaultInstance(BusinessOuterClass$RequestGetChargeCreditPaymentToken.class, businessOuterClass$RequestGetChargeCreditPaymentToken);
    }

    private BusinessOuterClass$RequestGetChargeCreditPaymentToken() {
    }

    private void clearAmount() {
        this.amount_ = 0L;
    }

    private void clearCallbackServiceAddress() {
        this.callbackServiceAddress_ = null;
        this.bitField0_ &= -2;
    }

    public static BusinessOuterClass$RequestGetChargeCreditPaymentToken getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeCallbackServiceAddress(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.callbackServiceAddress_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.callbackServiceAddress_ = stringValue;
        } else {
            this.callbackServiceAddress_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.callbackServiceAddress_).v(stringValue)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static BusinessOuterClass$RequestGetChargeCreditPaymentToken parseDelimitedFrom(InputStream inputStream) {
        return (BusinessOuterClass$RequestGetChargeCreditPaymentToken) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BusinessOuterClass$RequestGetChargeCreditPaymentToken parseFrom(ByteBuffer byteBuffer) {
        return (BusinessOuterClass$RequestGetChargeCreditPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAmount(long j) {
        this.amount_ = j;
    }

    private void setCallbackServiceAddress(StringValue stringValue) {
        stringValue.getClass();
        this.callbackServiceAddress_ = stringValue;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1896u.a[gVar.ordinal()]) {
            case 1:
                return new BusinessOuterClass$RequestGetChargeCreditPaymentToken();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0002\u0002ဉ\u0000", new Object[]{"bitField0_", "amount_", "callbackServiceAddress_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (BusinessOuterClass$RequestGetChargeCreditPaymentToken.class) {
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

    public long getAmount() {
        return this.amount_;
    }

    public StringValue getCallbackServiceAddress() {
        StringValue stringValue = this.callbackServiceAddress_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public boolean hasCallbackServiceAddress() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(BusinessOuterClass$RequestGetChargeCreditPaymentToken businessOuterClass$RequestGetChargeCreditPaymentToken) {
        return (a) DEFAULT_INSTANCE.createBuilder(businessOuterClass$RequestGetChargeCreditPaymentToken);
    }

    public static BusinessOuterClass$RequestGetChargeCreditPaymentToken parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (BusinessOuterClass$RequestGetChargeCreditPaymentToken) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BusinessOuterClass$RequestGetChargeCreditPaymentToken parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (BusinessOuterClass$RequestGetChargeCreditPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static BusinessOuterClass$RequestGetChargeCreditPaymentToken parseFrom(AbstractC2383g abstractC2383g) {
        return (BusinessOuterClass$RequestGetChargeCreditPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static BusinessOuterClass$RequestGetChargeCreditPaymentToken parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (BusinessOuterClass$RequestGetChargeCreditPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static BusinessOuterClass$RequestGetChargeCreditPaymentToken parseFrom(byte[] bArr) {
        return (BusinessOuterClass$RequestGetChargeCreditPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static BusinessOuterClass$RequestGetChargeCreditPaymentToken parseFrom(byte[] bArr, C2394s c2394s) {
        return (BusinessOuterClass$RequestGetChargeCreditPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static BusinessOuterClass$RequestGetChargeCreditPaymentToken parseFrom(InputStream inputStream) {
        return (BusinessOuterClass$RequestGetChargeCreditPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BusinessOuterClass$RequestGetChargeCreditPaymentToken parseFrom(InputStream inputStream, C2394s c2394s) {
        return (BusinessOuterClass$RequestGetChargeCreditPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BusinessOuterClass$RequestGetChargeCreditPaymentToken parseFrom(AbstractC2384h abstractC2384h) {
        return (BusinessOuterClass$RequestGetChargeCreditPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static BusinessOuterClass$RequestGetChargeCreditPaymentToken parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (BusinessOuterClass$RequestGetChargeCreditPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
