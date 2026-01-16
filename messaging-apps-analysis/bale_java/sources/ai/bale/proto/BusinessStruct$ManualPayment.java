package ai.bale.proto;

import ai.bale.proto.BusinessStruct$OrganizationInfo;
import ai.bale.proto.FilesStruct$FileLocation;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC22762vn0;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class BusinessStruct$ManualPayment extends GeneratedMessageLite implements InterfaceC22762vn0 {
    public static final int AMOUNT_FIELD_NUMBER = 3;
    public static final int DATE_FIELD_NUMBER = 4;
    private static final BusinessStruct$ManualPayment DEFAULT_INSTANCE;
    public static final int ORGANIZATION_INFO_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int PAYMENT_ID_FIELD_NUMBER = 1;
    public static final int RECEIPT_FIELD_NUMBER = 6;
    public static final int TRACING_CODE_FIELD_NUMBER = 5;
    private long amount_;
    private int bitField0_;
    private long date_;
    private BusinessStruct$OrganizationInfo organizationInfo_;
    private FilesStruct$FileLocation receipt_;
    private String paymentId_ = "";
    private String tracingCode_ = "";

    public static final class a extends GeneratedMessageLite.b implements InterfaceC22762vn0 {
        private a() {
            super(BusinessStruct$ManualPayment.DEFAULT_INSTANCE);
        }
    }

    static {
        BusinessStruct$ManualPayment businessStruct$ManualPayment = new BusinessStruct$ManualPayment();
        DEFAULT_INSTANCE = businessStruct$ManualPayment;
        GeneratedMessageLite.registerDefaultInstance(BusinessStruct$ManualPayment.class, businessStruct$ManualPayment);
    }

    private BusinessStruct$ManualPayment() {
    }

    private void clearAmount() {
        this.amount_ = 0L;
    }

    private void clearDate() {
        this.date_ = 0L;
    }

    private void clearOrganizationInfo() {
        this.organizationInfo_ = null;
        this.bitField0_ &= -2;
    }

    private void clearPaymentId() {
        this.paymentId_ = getDefaultInstance().getPaymentId();
    }

    private void clearReceipt() {
        this.receipt_ = null;
        this.bitField0_ &= -3;
    }

    private void clearTracingCode() {
        this.tracingCode_ = getDefaultInstance().getTracingCode();
    }

    public static BusinessStruct$ManualPayment getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeOrganizationInfo(BusinessStruct$OrganizationInfo businessStruct$OrganizationInfo) {
        businessStruct$OrganizationInfo.getClass();
        BusinessStruct$OrganizationInfo businessStruct$OrganizationInfo2 = this.organizationInfo_;
        if (businessStruct$OrganizationInfo2 == null || businessStruct$OrganizationInfo2 == BusinessStruct$OrganizationInfo.getDefaultInstance()) {
            this.organizationInfo_ = businessStruct$OrganizationInfo;
        } else {
            this.organizationInfo_ = (BusinessStruct$OrganizationInfo) ((BusinessStruct$OrganizationInfo.a) BusinessStruct$OrganizationInfo.newBuilder(this.organizationInfo_).v(businessStruct$OrganizationInfo)).j();
        }
        this.bitField0_ |= 1;
    }

    private void mergeReceipt(FilesStruct$FileLocation filesStruct$FileLocation) {
        filesStruct$FileLocation.getClass();
        FilesStruct$FileLocation filesStruct$FileLocation2 = this.receipt_;
        if (filesStruct$FileLocation2 == null || filesStruct$FileLocation2 == FilesStruct$FileLocation.getDefaultInstance()) {
            this.receipt_ = filesStruct$FileLocation;
        } else {
            this.receipt_ = (FilesStruct$FileLocation) ((FilesStruct$FileLocation.a) FilesStruct$FileLocation.newBuilder(this.receipt_).v(filesStruct$FileLocation)).j();
        }
        this.bitField0_ |= 2;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static BusinessStruct$ManualPayment parseDelimitedFrom(InputStream inputStream) {
        return (BusinessStruct$ManualPayment) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BusinessStruct$ManualPayment parseFrom(ByteBuffer byteBuffer) {
        return (BusinessStruct$ManualPayment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAmount(long j) {
        this.amount_ = j;
    }

    private void setDate(long j) {
        this.date_ = j;
    }

    private void setOrganizationInfo(BusinessStruct$OrganizationInfo businessStruct$OrganizationInfo) {
        businessStruct$OrganizationInfo.getClass();
        this.organizationInfo_ = businessStruct$OrganizationInfo;
        this.bitField0_ |= 1;
    }

    private void setPaymentId(String str) {
        str.getClass();
        this.paymentId_ = str;
    }

    private void setPaymentIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.paymentId_ = abstractC2383g.f0();
    }

    private void setReceipt(FilesStruct$FileLocation filesStruct$FileLocation) {
        filesStruct$FileLocation.getClass();
        this.receipt_ = filesStruct$FileLocation;
        this.bitField0_ |= 2;
    }

    private void setTracingCode(String str) {
        str.getClass();
        this.tracingCode_ = str;
    }

    private void setTracingCodeBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.tracingCode_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1899v.a[gVar.ordinal()]) {
            case 1:
                return new BusinessStruct$ManualPayment();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001Ȉ\u0002ဉ\u0000\u0003\u0002\u0004\u0002\u0005Ȉ\u0006ဉ\u0001", new Object[]{"bitField0_", "paymentId_", "organizationInfo_", "amount_", "date_", "tracingCode_", "receipt_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (BusinessStruct$ManualPayment.class) {
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

    public long getDate() {
        return this.date_;
    }

    public BusinessStruct$OrganizationInfo getOrganizationInfo() {
        BusinessStruct$OrganizationInfo businessStruct$OrganizationInfo = this.organizationInfo_;
        return businessStruct$OrganizationInfo == null ? BusinessStruct$OrganizationInfo.getDefaultInstance() : businessStruct$OrganizationInfo;
    }

    public String getPaymentId() {
        return this.paymentId_;
    }

    public AbstractC2383g getPaymentIdBytes() {
        return AbstractC2383g.N(this.paymentId_);
    }

    public FilesStruct$FileLocation getReceipt() {
        FilesStruct$FileLocation filesStruct$FileLocation = this.receipt_;
        return filesStruct$FileLocation == null ? FilesStruct$FileLocation.getDefaultInstance() : filesStruct$FileLocation;
    }

    public String getTracingCode() {
        return this.tracingCode_;
    }

    public AbstractC2383g getTracingCodeBytes() {
        return AbstractC2383g.N(this.tracingCode_);
    }

    public boolean hasOrganizationInfo() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasReceipt() {
        return (this.bitField0_ & 2) != 0;
    }

    public static a newBuilder(BusinessStruct$ManualPayment businessStruct$ManualPayment) {
        return (a) DEFAULT_INSTANCE.createBuilder(businessStruct$ManualPayment);
    }

    public static BusinessStruct$ManualPayment parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (BusinessStruct$ManualPayment) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BusinessStruct$ManualPayment parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (BusinessStruct$ManualPayment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static BusinessStruct$ManualPayment parseFrom(AbstractC2383g abstractC2383g) {
        return (BusinessStruct$ManualPayment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static BusinessStruct$ManualPayment parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (BusinessStruct$ManualPayment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static BusinessStruct$ManualPayment parseFrom(byte[] bArr) {
        return (BusinessStruct$ManualPayment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static BusinessStruct$ManualPayment parseFrom(byte[] bArr, C2394s c2394s) {
        return (BusinessStruct$ManualPayment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static BusinessStruct$ManualPayment parseFrom(InputStream inputStream) {
        return (BusinessStruct$ManualPayment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BusinessStruct$ManualPayment parseFrom(InputStream inputStream, C2394s c2394s) {
        return (BusinessStruct$ManualPayment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BusinessStruct$ManualPayment parseFrom(AbstractC2384h abstractC2384h) {
        return (BusinessStruct$ManualPayment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static BusinessStruct$ManualPayment parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (BusinessStruct$ManualPayment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
