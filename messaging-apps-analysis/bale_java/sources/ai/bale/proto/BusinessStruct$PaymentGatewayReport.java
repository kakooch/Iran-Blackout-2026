package ai.bale.proto;

import ai.bale.proto.BusinessStruct$OrganizationInfo;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC25132zn0;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class BusinessStruct$PaymentGatewayReport extends GeneratedMessageLite implements InterfaceC25132zn0 {
    public static final int AMOUNT_FIELD_NUMBER = 2;
    public static final int DATE_FIELD_NUMBER = 3;
    private static final BusinessStruct$PaymentGatewayReport DEFAULT_INSTANCE;
    public static final int ORGANIZATION_INFO_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private long amount_;
    private int bitField0_;
    private long date_;
    private BusinessStruct$OrganizationInfo organizationInfo_;

    public static final class a extends GeneratedMessageLite.b implements InterfaceC25132zn0 {
        private a() {
            super(BusinessStruct$PaymentGatewayReport.DEFAULT_INSTANCE);
        }
    }

    static {
        BusinessStruct$PaymentGatewayReport businessStruct$PaymentGatewayReport = new BusinessStruct$PaymentGatewayReport();
        DEFAULT_INSTANCE = businessStruct$PaymentGatewayReport;
        GeneratedMessageLite.registerDefaultInstance(BusinessStruct$PaymentGatewayReport.class, businessStruct$PaymentGatewayReport);
    }

    private BusinessStruct$PaymentGatewayReport() {
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

    public static BusinessStruct$PaymentGatewayReport getDefaultInstance() {
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

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static BusinessStruct$PaymentGatewayReport parseDelimitedFrom(InputStream inputStream) {
        return (BusinessStruct$PaymentGatewayReport) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BusinessStruct$PaymentGatewayReport parseFrom(ByteBuffer byteBuffer) {
        return (BusinessStruct$PaymentGatewayReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
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

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1899v.a[gVar.ordinal()]) {
            case 1:
                return new BusinessStruct$PaymentGatewayReport();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002\u0002\u0003\u0002", new Object[]{"bitField0_", "organizationInfo_", "amount_", "date_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (BusinessStruct$PaymentGatewayReport.class) {
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

    public boolean hasOrganizationInfo() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(BusinessStruct$PaymentGatewayReport businessStruct$PaymentGatewayReport) {
        return (a) DEFAULT_INSTANCE.createBuilder(businessStruct$PaymentGatewayReport);
    }

    public static BusinessStruct$PaymentGatewayReport parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (BusinessStruct$PaymentGatewayReport) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BusinessStruct$PaymentGatewayReport parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (BusinessStruct$PaymentGatewayReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static BusinessStruct$PaymentGatewayReport parseFrom(AbstractC2383g abstractC2383g) {
        return (BusinessStruct$PaymentGatewayReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static BusinessStruct$PaymentGatewayReport parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (BusinessStruct$PaymentGatewayReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static BusinessStruct$PaymentGatewayReport parseFrom(byte[] bArr) {
        return (BusinessStruct$PaymentGatewayReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static BusinessStruct$PaymentGatewayReport parseFrom(byte[] bArr, C2394s c2394s) {
        return (BusinessStruct$PaymentGatewayReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static BusinessStruct$PaymentGatewayReport parseFrom(InputStream inputStream) {
        return (BusinessStruct$PaymentGatewayReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BusinessStruct$PaymentGatewayReport parseFrom(InputStream inputStream, C2394s c2394s) {
        return (BusinessStruct$PaymentGatewayReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BusinessStruct$PaymentGatewayReport parseFrom(AbstractC2384h abstractC2384h) {
        return (BusinessStruct$PaymentGatewayReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static BusinessStruct$PaymentGatewayReport parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (BusinessStruct$PaymentGatewayReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
