package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.GG0;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class CarStruct$FreewayBillInfo extends GeneratedMessageLite implements GG0 {
    public static final int AMOUNT_FIELD_NUMBER = 1;
    private static final CarStruct$FreewayBillInfo DEFAULT_INSTANCE;
    public static final int FEE_FIELD_NUMBER = 2;
    public static final int FREEWAY_FIELD_NUMBER = 4;
    public static final int ISSUE_DATE_TIME_FIELD_NUMBER = 5;
    private static volatile KW4 PARSER = null;
    public static final int PAYMENT_STATUS_FIELD_NUMBER = 8;
    public static final int PAYMENT_STATUS_NAME_FIELD_NUMBER = 9;
    public static final int TOTAL_AMOUNT_FIELD_NUMBER = 3;
    public static final int TRAVERSE_DATE_TIME_FIELD_NUMBER = 6;
    public static final int UNIQUE_ID_FIELD_NUMBER = 7;
    private long amount_;
    private long fee_;
    private long totalAmount_;
    private String freeway_ = "";
    private String issueDateTime_ = "";
    private String traverseDateTime_ = "";
    private String uniqueId_ = "";
    private String paymentStatus_ = "";
    private String paymentStatusName_ = "";

    public static final class a extends GeneratedMessageLite.b implements GG0 {
        private a() {
            super(CarStruct$FreewayBillInfo.DEFAULT_INSTANCE);
        }
    }

    static {
        CarStruct$FreewayBillInfo carStruct$FreewayBillInfo = new CarStruct$FreewayBillInfo();
        DEFAULT_INSTANCE = carStruct$FreewayBillInfo;
        GeneratedMessageLite.registerDefaultInstance(CarStruct$FreewayBillInfo.class, carStruct$FreewayBillInfo);
    }

    private CarStruct$FreewayBillInfo() {
    }

    private void clearAmount() {
        this.amount_ = 0L;
    }

    private void clearFee() {
        this.fee_ = 0L;
    }

    private void clearFreeway() {
        this.freeway_ = getDefaultInstance().getFreeway();
    }

    private void clearIssueDateTime() {
        this.issueDateTime_ = getDefaultInstance().getIssueDateTime();
    }

    private void clearPaymentStatus() {
        this.paymentStatus_ = getDefaultInstance().getPaymentStatus();
    }

    private void clearPaymentStatusName() {
        this.paymentStatusName_ = getDefaultInstance().getPaymentStatusName();
    }

    private void clearTotalAmount() {
        this.totalAmount_ = 0L;
    }

    private void clearTraverseDateTime() {
        this.traverseDateTime_ = getDefaultInstance().getTraverseDateTime();
    }

    private void clearUniqueId() {
        this.uniqueId_ = getDefaultInstance().getUniqueId();
    }

    public static CarStruct$FreewayBillInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static CarStruct$FreewayBillInfo parseDelimitedFrom(InputStream inputStream) {
        return (CarStruct$FreewayBillInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static CarStruct$FreewayBillInfo parseFrom(ByteBuffer byteBuffer) {
        return (CarStruct$FreewayBillInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAmount(long j) {
        this.amount_ = j;
    }

    private void setFee(long j) {
        this.fee_ = j;
    }

    private void setFreeway(String str) {
        str.getClass();
        this.freeway_ = str;
    }

    private void setFreewayBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.freeway_ = abstractC2383g.f0();
    }

    private void setIssueDateTime(String str) {
        str.getClass();
        this.issueDateTime_ = str;
    }

    private void setIssueDateTimeBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.issueDateTime_ = abstractC2383g.f0();
    }

    private void setPaymentStatus(String str) {
        str.getClass();
        this.paymentStatus_ = str;
    }

    private void setPaymentStatusBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.paymentStatus_ = abstractC2383g.f0();
    }

    private void setPaymentStatusName(String str) {
        str.getClass();
        this.paymentStatusName_ = str;
    }

    private void setPaymentStatusNameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.paymentStatusName_ = abstractC2383g.f0();
    }

    private void setTotalAmount(long j) {
        this.totalAmount_ = j;
    }

    private void setTraverseDateTime(String str) {
        str.getClass();
        this.traverseDateTime_ = str;
    }

    private void setTraverseDateTimeBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.traverseDateTime_ = abstractC2383g.f0();
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
                return new CarStruct$FreewayBillInfo();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\t\u0000\u0000\u0001\t\t\u0000\u0000\u0000\u0001\u0002\u0002\u0002\u0003\u0002\u0004Ȉ\u0005Ȉ\u0006Ȉ\u0007Ȉ\bȈ\tȈ", new Object[]{"amount_", "fee_", "totalAmount_", "freeway_", "issueDateTime_", "traverseDateTime_", "uniqueId_", "paymentStatus_", "paymentStatusName_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (CarStruct$FreewayBillInfo.class) {
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

    public long getFee() {
        return this.fee_;
    }

    public String getFreeway() {
        return this.freeway_;
    }

    public AbstractC2383g getFreewayBytes() {
        return AbstractC2383g.N(this.freeway_);
    }

    public String getIssueDateTime() {
        return this.issueDateTime_;
    }

    public AbstractC2383g getIssueDateTimeBytes() {
        return AbstractC2383g.N(this.issueDateTime_);
    }

    public String getPaymentStatus() {
        return this.paymentStatus_;
    }

    public AbstractC2383g getPaymentStatusBytes() {
        return AbstractC2383g.N(this.paymentStatus_);
    }

    public String getPaymentStatusName() {
        return this.paymentStatusName_;
    }

    public AbstractC2383g getPaymentStatusNameBytes() {
        return AbstractC2383g.N(this.paymentStatusName_);
    }

    public long getTotalAmount() {
        return this.totalAmount_;
    }

    public String getTraverseDateTime() {
        return this.traverseDateTime_;
    }

    public AbstractC2383g getTraverseDateTimeBytes() {
        return AbstractC2383g.N(this.traverseDateTime_);
    }

    public String getUniqueId() {
        return this.uniqueId_;
    }

    public AbstractC2383g getUniqueIdBytes() {
        return AbstractC2383g.N(this.uniqueId_);
    }

    public static a newBuilder(CarStruct$FreewayBillInfo carStruct$FreewayBillInfo) {
        return (a) DEFAULT_INSTANCE.createBuilder(carStruct$FreewayBillInfo);
    }

    public static CarStruct$FreewayBillInfo parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (CarStruct$FreewayBillInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static CarStruct$FreewayBillInfo parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (CarStruct$FreewayBillInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static CarStruct$FreewayBillInfo parseFrom(AbstractC2383g abstractC2383g) {
        return (CarStruct$FreewayBillInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static CarStruct$FreewayBillInfo parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (CarStruct$FreewayBillInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static CarStruct$FreewayBillInfo parseFrom(byte[] bArr) {
        return (CarStruct$FreewayBillInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static CarStruct$FreewayBillInfo parseFrom(byte[] bArr, C2394s c2394s) {
        return (CarStruct$FreewayBillInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static CarStruct$FreewayBillInfo parseFrom(InputStream inputStream) {
        return (CarStruct$FreewayBillInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static CarStruct$FreewayBillInfo parseFrom(InputStream inputStream, C2394s c2394s) {
        return (CarStruct$FreewayBillInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static CarStruct$FreewayBillInfo parseFrom(AbstractC2384h abstractC2384h) {
        return (CarStruct$FreewayBillInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static CarStruct$FreewayBillInfo parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (CarStruct$FreewayBillInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
