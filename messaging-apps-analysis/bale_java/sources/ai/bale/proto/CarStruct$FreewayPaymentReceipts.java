package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.IG0;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class CarStruct$FreewayPaymentReceipts extends GeneratedMessageLite implements IG0 {
    public static final int AMOUNT_FIELD_NUMBER = 1;
    private static final CarStruct$FreewayPaymentReceipts DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int PAYMENT_CARD_PAN_FIELD_NUMBER = 3;
    public static final int PAYMENT_DATE_TIME_FIELD_NUMBER = 4;
    public static final int PAYMENT_STATUS_FIELD_NUMBER = 6;
    public static final int PAYMENT_TRACE_NUMBER_FIELD_NUMBER = 5;
    public static final int TOTAL_AMOUNT_FIELD_NUMBER = 2;
    public static final int TYPE_FIELD_NUMBER = 7;
    public static final int UNIQUE_ID_FIELD_NUMBER = 8;
    private long amount_;
    private long totalAmount_;
    private String paymentCardPan_ = "";
    private String paymentDateTime_ = "";
    private String paymentTraceNumber_ = "";
    private String paymentStatus_ = "";
    private String type_ = "";
    private String uniqueId_ = "";

    public static final class a extends GeneratedMessageLite.b implements IG0 {
        private a() {
            super(CarStruct$FreewayPaymentReceipts.DEFAULT_INSTANCE);
        }
    }

    static {
        CarStruct$FreewayPaymentReceipts carStruct$FreewayPaymentReceipts = new CarStruct$FreewayPaymentReceipts();
        DEFAULT_INSTANCE = carStruct$FreewayPaymentReceipts;
        GeneratedMessageLite.registerDefaultInstance(CarStruct$FreewayPaymentReceipts.class, carStruct$FreewayPaymentReceipts);
    }

    private CarStruct$FreewayPaymentReceipts() {
    }

    private void clearAmount() {
        this.amount_ = 0L;
    }

    private void clearPaymentCardPan() {
        this.paymentCardPan_ = getDefaultInstance().getPaymentCardPan();
    }

    private void clearPaymentDateTime() {
        this.paymentDateTime_ = getDefaultInstance().getPaymentDateTime();
    }

    private void clearPaymentStatus() {
        this.paymentStatus_ = getDefaultInstance().getPaymentStatus();
    }

    private void clearPaymentTraceNumber() {
        this.paymentTraceNumber_ = getDefaultInstance().getPaymentTraceNumber();
    }

    private void clearTotalAmount() {
        this.totalAmount_ = 0L;
    }

    private void clearType() {
        this.type_ = getDefaultInstance().getType();
    }

    private void clearUniqueId() {
        this.uniqueId_ = getDefaultInstance().getUniqueId();
    }

    public static CarStruct$FreewayPaymentReceipts getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static CarStruct$FreewayPaymentReceipts parseDelimitedFrom(InputStream inputStream) {
        return (CarStruct$FreewayPaymentReceipts) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static CarStruct$FreewayPaymentReceipts parseFrom(ByteBuffer byteBuffer) {
        return (CarStruct$FreewayPaymentReceipts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAmount(long j) {
        this.amount_ = j;
    }

    private void setPaymentCardPan(String str) {
        str.getClass();
        this.paymentCardPan_ = str;
    }

    private void setPaymentCardPanBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.paymentCardPan_ = abstractC2383g.f0();
    }

    private void setPaymentDateTime(String str) {
        str.getClass();
        this.paymentDateTime_ = str;
    }

    private void setPaymentDateTimeBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.paymentDateTime_ = abstractC2383g.f0();
    }

    private void setPaymentStatus(String str) {
        str.getClass();
        this.paymentStatus_ = str;
    }

    private void setPaymentStatusBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.paymentStatus_ = abstractC2383g.f0();
    }

    private void setPaymentTraceNumber(String str) {
        str.getClass();
        this.paymentTraceNumber_ = str;
    }

    private void setPaymentTraceNumberBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.paymentTraceNumber_ = abstractC2383g.f0();
    }

    private void setTotalAmount(long j) {
        this.totalAmount_ = j;
    }

    private void setType(String str) {
        str.getClass();
        this.type_ = str;
    }

    private void setTypeBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.type_ = abstractC2383g.f0();
    }

    private void setUniqueId(String str) {
        str.getClass();
        this.uniqueId_ = str;
    }

    private void setUniqueIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.uniqueId_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1908y.a[gVar.ordinal()]) {
            case 1:
                return new CarStruct$FreewayPaymentReceipts();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\b\u0000\u0000\u0001\b\b\u0000\u0000\u0000\u0001\u0002\u0002\u0002\u0003Ȉ\u0004Ȉ\u0005Ȉ\u0006Ȉ\u0007Ȉ\bȈ", new Object[]{"amount_", "totalAmount_", "paymentCardPan_", "paymentDateTime_", "paymentTraceNumber_", "paymentStatus_", "type_", "uniqueId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (CarStruct$FreewayPaymentReceipts.class) {
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

    public String getPaymentCardPan() {
        return this.paymentCardPan_;
    }

    public AbstractC2383g getPaymentCardPanBytes() {
        return AbstractC2383g.N(this.paymentCardPan_);
    }

    public String getPaymentDateTime() {
        return this.paymentDateTime_;
    }

    public AbstractC2383g getPaymentDateTimeBytes() {
        return AbstractC2383g.N(this.paymentDateTime_);
    }

    public String getPaymentStatus() {
        return this.paymentStatus_;
    }

    public AbstractC2383g getPaymentStatusBytes() {
        return AbstractC2383g.N(this.paymentStatus_);
    }

    public String getPaymentTraceNumber() {
        return this.paymentTraceNumber_;
    }

    public AbstractC2383g getPaymentTraceNumberBytes() {
        return AbstractC2383g.N(this.paymentTraceNumber_);
    }

    public long getTotalAmount() {
        return this.totalAmount_;
    }

    public String getType() {
        return this.type_;
    }

    public AbstractC2383g getTypeBytes() {
        return AbstractC2383g.N(this.type_);
    }

    public String getUniqueId() {
        return this.uniqueId_;
    }

    public AbstractC2383g getUniqueIdBytes() {
        return AbstractC2383g.N(this.uniqueId_);
    }

    public static a newBuilder(CarStruct$FreewayPaymentReceipts carStruct$FreewayPaymentReceipts) {
        return (a) DEFAULT_INSTANCE.createBuilder(carStruct$FreewayPaymentReceipts);
    }

    public static CarStruct$FreewayPaymentReceipts parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (CarStruct$FreewayPaymentReceipts) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static CarStruct$FreewayPaymentReceipts parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (CarStruct$FreewayPaymentReceipts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static CarStruct$FreewayPaymentReceipts parseFrom(AbstractC2383g abstractC2383g) {
        return (CarStruct$FreewayPaymentReceipts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static CarStruct$FreewayPaymentReceipts parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (CarStruct$FreewayPaymentReceipts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static CarStruct$FreewayPaymentReceipts parseFrom(byte[] bArr) {
        return (CarStruct$FreewayPaymentReceipts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static CarStruct$FreewayPaymentReceipts parseFrom(byte[] bArr, C2394s c2394s) {
        return (CarStruct$FreewayPaymentReceipts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static CarStruct$FreewayPaymentReceipts parseFrom(InputStream inputStream) {
        return (CarStruct$FreewayPaymentReceipts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static CarStruct$FreewayPaymentReceipts parseFrom(InputStream inputStream, C2394s c2394s) {
        return (CarStruct$FreewayPaymentReceipts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static CarStruct$FreewayPaymentReceipts parseFrom(AbstractC2384h abstractC2384h) {
        return (CarStruct$FreewayPaymentReceipts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static CarStruct$FreewayPaymentReceipts parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (CarStruct$FreewayPaymentReceipts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
