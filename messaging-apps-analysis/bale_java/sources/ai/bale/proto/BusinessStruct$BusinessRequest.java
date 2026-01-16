package ai.bale.proto;

import ai.bale.proto.BusinessStruct$SafirRequest;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.StringValue;
import ir.nasim.EnumC3353An0;
import ir.nasim.EnumC3592Bn0;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class BusinessStruct$BusinessRequest extends GeneratedMessageLite implements InterfaceC1902w {
    public static final int ADDRESS_FIELD_NUMBER = 11;
    public static final int CREATED_AT_FIELD_NUMBER = 3;
    public static final int CREATOR_USER_ID_FIELD_NUMBER = 13;
    private static final BusinessStruct$BusinessRequest DEFAULT_INSTANCE;
    public static final int ECONOMIC_NUMBER_FIELD_NUMBER = 9;
    public static final int LANDLINE_NUMBER_FIELD_NUMBER = 10;
    public static final int NATIONAL_NUMBER_FIELD_NUMBER = 8;
    public static final int ORGANIZATION_ID_FIELD_NUMBER = 2;
    public static final int ORG_NAME_FIELD_NUMBER = 7;
    private static volatile KW4 PARSER = null;
    public static final int POSTAL_CODE_FIELD_NUMBER = 12;
    public static final int REJECTION_REASON_FIELD_NUMBER = 6;
    public static final int REQUEST_ID_FIELD_NUMBER = 1;
    public static final int REQUEST_STATUS_FIELD_NUMBER = 4;
    public static final int REQUEST_TYPE_FIELD_NUMBER = 5;
    public static final int SAFIR_REQUEST_FIELD_NUMBER = 101;
    private StringValue address_;
    private int bitField0_;
    private long createdAt_;
    private int creatorUserId_;
    private StringValue economicNumber_;
    private StringValue landlineNumber_;
    private StringValue nationalNumber_;
    private StringValue orgName_;
    private int organizationId_;
    private StringValue postalCode_;
    private StringValue rejectionReason_;
    private int requestId_;
    private int requestStatus_;
    private int requestType_;
    private int traitCase_ = 0;
    private Object trait_;

    public static final class a extends GeneratedMessageLite.b implements InterfaceC1902w {
        private a() {
            super(BusinessStruct$BusinessRequest.DEFAULT_INSTANCE);
        }
    }

    public enum b {
        SAFIR_REQUEST(101),
        TRAIT_NOT_SET(0);

        private final int a;

        b(int i) {
            this.a = i;
        }

        public static b j(int i) {
            if (i == 0) {
                return TRAIT_NOT_SET;
            }
            if (i != 101) {
                return null;
            }
            return SAFIR_REQUEST;
        }
    }

    static {
        BusinessStruct$BusinessRequest businessStruct$BusinessRequest = new BusinessStruct$BusinessRequest();
        DEFAULT_INSTANCE = businessStruct$BusinessRequest;
        GeneratedMessageLite.registerDefaultInstance(BusinessStruct$BusinessRequest.class, businessStruct$BusinessRequest);
    }

    private BusinessStruct$BusinessRequest() {
    }

    private void clearAddress() {
        this.address_ = null;
        this.bitField0_ &= -33;
    }

    private void clearCreatedAt() {
        this.createdAt_ = 0L;
    }

    private void clearCreatorUserId() {
        this.creatorUserId_ = 0;
    }

    private void clearEconomicNumber() {
        this.economicNumber_ = null;
        this.bitField0_ &= -9;
    }

    private void clearLandlineNumber() {
        this.landlineNumber_ = null;
        this.bitField0_ &= -17;
    }

    private void clearNationalNumber() {
        this.nationalNumber_ = null;
        this.bitField0_ &= -5;
    }

    private void clearOrgName() {
        this.orgName_ = null;
        this.bitField0_ &= -3;
    }

    private void clearOrganizationId() {
        this.organizationId_ = 0;
    }

    private void clearPostalCode() {
        this.postalCode_ = null;
        this.bitField0_ &= -65;
    }

    private void clearRejectionReason() {
        this.rejectionReason_ = null;
        this.bitField0_ &= -2;
    }

    private void clearRequestId() {
        this.requestId_ = 0;
    }

    private void clearRequestStatus() {
        this.requestStatus_ = 0;
    }

    private void clearRequestType() {
        this.requestType_ = 0;
    }

    private void clearSafirRequest() {
        if (this.traitCase_ == 101) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearTrait() {
        this.traitCase_ = 0;
        this.trait_ = null;
    }

    public static BusinessStruct$BusinessRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeAddress(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.address_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.address_ = stringValue;
        } else {
            this.address_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.address_).v(stringValue)).j();
        }
        this.bitField0_ |= 32;
    }

    private void mergeEconomicNumber(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.economicNumber_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.economicNumber_ = stringValue;
        } else {
            this.economicNumber_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.economicNumber_).v(stringValue)).j();
        }
        this.bitField0_ |= 8;
    }

    private void mergeLandlineNumber(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.landlineNumber_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.landlineNumber_ = stringValue;
        } else {
            this.landlineNumber_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.landlineNumber_).v(stringValue)).j();
        }
        this.bitField0_ |= 16;
    }

    private void mergeNationalNumber(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.nationalNumber_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.nationalNumber_ = stringValue;
        } else {
            this.nationalNumber_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.nationalNumber_).v(stringValue)).j();
        }
        this.bitField0_ |= 4;
    }

    private void mergeOrgName(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.orgName_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.orgName_ = stringValue;
        } else {
            this.orgName_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.orgName_).v(stringValue)).j();
        }
        this.bitField0_ |= 2;
    }

    private void mergePostalCode(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.postalCode_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.postalCode_ = stringValue;
        } else {
            this.postalCode_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.postalCode_).v(stringValue)).j();
        }
        this.bitField0_ |= 64;
    }

    private void mergeRejectionReason(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.rejectionReason_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.rejectionReason_ = stringValue;
        } else {
            this.rejectionReason_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.rejectionReason_).v(stringValue)).j();
        }
        this.bitField0_ |= 1;
    }

    private void mergeSafirRequest(BusinessStruct$SafirRequest businessStruct$SafirRequest) {
        businessStruct$SafirRequest.getClass();
        if (this.traitCase_ != 101 || this.trait_ == BusinessStruct$SafirRequest.getDefaultInstance()) {
            this.trait_ = businessStruct$SafirRequest;
        } else {
            this.trait_ = ((BusinessStruct$SafirRequest.a) BusinessStruct$SafirRequest.newBuilder((BusinessStruct$SafirRequest) this.trait_).v(businessStruct$SafirRequest)).j();
        }
        this.traitCase_ = 101;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static BusinessStruct$BusinessRequest parseDelimitedFrom(InputStream inputStream) {
        return (BusinessStruct$BusinessRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BusinessStruct$BusinessRequest parseFrom(ByteBuffer byteBuffer) {
        return (BusinessStruct$BusinessRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAddress(StringValue stringValue) {
        stringValue.getClass();
        this.address_ = stringValue;
        this.bitField0_ |= 32;
    }

    private void setCreatedAt(long j) {
        this.createdAt_ = j;
    }

    private void setCreatorUserId(int i) {
        this.creatorUserId_ = i;
    }

    private void setEconomicNumber(StringValue stringValue) {
        stringValue.getClass();
        this.economicNumber_ = stringValue;
        this.bitField0_ |= 8;
    }

    private void setLandlineNumber(StringValue stringValue) {
        stringValue.getClass();
        this.landlineNumber_ = stringValue;
        this.bitField0_ |= 16;
    }

    private void setNationalNumber(StringValue stringValue) {
        stringValue.getClass();
        this.nationalNumber_ = stringValue;
        this.bitField0_ |= 4;
    }

    private void setOrgName(StringValue stringValue) {
        stringValue.getClass();
        this.orgName_ = stringValue;
        this.bitField0_ |= 2;
    }

    private void setOrganizationId(int i) {
        this.organizationId_ = i;
    }

    private void setPostalCode(StringValue stringValue) {
        stringValue.getClass();
        this.postalCode_ = stringValue;
        this.bitField0_ |= 64;
    }

    private void setRejectionReason(StringValue stringValue) {
        stringValue.getClass();
        this.rejectionReason_ = stringValue;
        this.bitField0_ |= 1;
    }

    private void setRequestId(int i) {
        this.requestId_ = i;
    }

    private void setRequestStatus(EnumC3353An0 enumC3353An0) {
        this.requestStatus_ = enumC3353An0.getNumber();
    }

    private void setRequestStatusValue(int i) {
        this.requestStatus_ = i;
    }

    private void setRequestType(EnumC3592Bn0 enumC3592Bn0) {
        this.requestType_ = enumC3592Bn0.getNumber();
    }

    private void setRequestTypeValue(int i) {
        this.requestType_ = i;
    }

    private void setSafirRequest(BusinessStruct$SafirRequest businessStruct$SafirRequest) {
        businessStruct$SafirRequest.getClass();
        this.trait_ = businessStruct$SafirRequest;
        this.traitCase_ = 101;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1899v.a[gVar.ordinal()]) {
            case 1:
                return new BusinessStruct$BusinessRequest();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u000e\u0001\u0001\u0001e\u000e\u0000\u0000\u0000\u0001\u0004\u0002\u0004\u0003\u0002\u0004\f\u0005\f\u0006ဉ\u0000\u0007ဉ\u0001\bဉ\u0002\tဉ\u0003\nဉ\u0004\u000bဉ\u0005\fဉ\u0006\r\u0004e<\u0000", new Object[]{"trait_", "traitCase_", "bitField0_", "requestId_", "organizationId_", "createdAt_", "requestStatus_", "requestType_", "rejectionReason_", "orgName_", "nationalNumber_", "economicNumber_", "landlineNumber_", "address_", "postalCode_", "creatorUserId_", BusinessStruct$SafirRequest.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (BusinessStruct$BusinessRequest.class) {
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

    public StringValue getAddress() {
        StringValue stringValue = this.address_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public long getCreatedAt() {
        return this.createdAt_;
    }

    public int getCreatorUserId() {
        return this.creatorUserId_;
    }

    public StringValue getEconomicNumber() {
        StringValue stringValue = this.economicNumber_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public StringValue getLandlineNumber() {
        StringValue stringValue = this.landlineNumber_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public StringValue getNationalNumber() {
        StringValue stringValue = this.nationalNumber_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public StringValue getOrgName() {
        StringValue stringValue = this.orgName_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public int getOrganizationId() {
        return this.organizationId_;
    }

    public StringValue getPostalCode() {
        StringValue stringValue = this.postalCode_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public StringValue getRejectionReason() {
        StringValue stringValue = this.rejectionReason_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public int getRequestId() {
        return this.requestId_;
    }

    public EnumC3353An0 getRequestStatus() {
        EnumC3353An0 enumC3353An0J = EnumC3353An0.j(this.requestStatus_);
        return enumC3353An0J == null ? EnumC3353An0.UNRECOGNIZED : enumC3353An0J;
    }

    public int getRequestStatusValue() {
        return this.requestStatus_;
    }

    public EnumC3592Bn0 getRequestType() {
        EnumC3592Bn0 enumC3592Bn0J = EnumC3592Bn0.j(this.requestType_);
        return enumC3592Bn0J == null ? EnumC3592Bn0.UNRECOGNIZED : enumC3592Bn0J;
    }

    public int getRequestTypeValue() {
        return this.requestType_;
    }

    public BusinessStruct$SafirRequest getSafirRequest() {
        return this.traitCase_ == 101 ? (BusinessStruct$SafirRequest) this.trait_ : BusinessStruct$SafirRequest.getDefaultInstance();
    }

    public b getTraitCase() {
        return b.j(this.traitCase_);
    }

    public boolean hasAddress() {
        return (this.bitField0_ & 32) != 0;
    }

    public boolean hasEconomicNumber() {
        return (this.bitField0_ & 8) != 0;
    }

    public boolean hasLandlineNumber() {
        return (this.bitField0_ & 16) != 0;
    }

    public boolean hasNationalNumber() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasOrgName() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasPostalCode() {
        return (this.bitField0_ & 64) != 0;
    }

    public boolean hasRejectionReason() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasSafirRequest() {
        return this.traitCase_ == 101;
    }

    public static a newBuilder(BusinessStruct$BusinessRequest businessStruct$BusinessRequest) {
        return (a) DEFAULT_INSTANCE.createBuilder(businessStruct$BusinessRequest);
    }

    public static BusinessStruct$BusinessRequest parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (BusinessStruct$BusinessRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BusinessStruct$BusinessRequest parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (BusinessStruct$BusinessRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static BusinessStruct$BusinessRequest parseFrom(AbstractC2383g abstractC2383g) {
        return (BusinessStruct$BusinessRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static BusinessStruct$BusinessRequest parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (BusinessStruct$BusinessRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static BusinessStruct$BusinessRequest parseFrom(byte[] bArr) {
        return (BusinessStruct$BusinessRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static BusinessStruct$BusinessRequest parseFrom(byte[] bArr, C2394s c2394s) {
        return (BusinessStruct$BusinessRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static BusinessStruct$BusinessRequest parseFrom(InputStream inputStream) {
        return (BusinessStruct$BusinessRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BusinessStruct$BusinessRequest parseFrom(InputStream inputStream, C2394s c2394s) {
        return (BusinessStruct$BusinessRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BusinessStruct$BusinessRequest parseFrom(AbstractC2384h abstractC2384h) {
        return (BusinessStruct$BusinessRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static BusinessStruct$BusinessRequest parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (BusinessStruct$BusinessRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
