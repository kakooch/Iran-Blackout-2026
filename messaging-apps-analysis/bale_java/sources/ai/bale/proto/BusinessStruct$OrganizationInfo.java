package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.StringValue;
import ir.nasim.InterfaceC23948xn0;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class BusinessStruct$OrganizationInfo extends GeneratedMessageLite implements InterfaceC23948xn0 {
    public static final int ADDRESS_FIELD_NUMBER = 9;
    public static final int CREATED_AT_FIELD_NUMBER = 4;
    public static final int CREDIT_FIELD_NUMBER = 5;
    private static final BusinessStruct$OrganizationInfo DEFAULT_INSTANCE;
    public static final int ECONOMIC_NUMBER_FIELD_NUMBER = 7;
    public static final int ID_FIELD_NUMBER = 1;
    public static final int LANDLINE_NUMBER_FIELD_NUMBER = 8;
    public static final int NAME_FIELD_NUMBER = 3;
    public static final int NATIONAL_NUMBER_FIELD_NUMBER = 6;
    public static final int OWNER_PHONE_NUMBER_FIELD_NUMBER = 11;
    public static final int OWNER_USER_ID_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int POSTAL_CODE_FIELD_NUMBER = 10;
    public static final int TAG_FIELD_NUMBER = 12;
    private StringValue address_;
    private int bitField0_;
    private long createdAt_;
    private long credit_;
    private StringValue economicNumber_;
    private int id_;
    private StringValue landlineNumber_;
    private String name_ = "";
    private StringValue nationalNumber_;
    private long ownerPhoneNumber_;
    private int ownerUserId_;
    private StringValue postalCode_;
    private StringValue tag_;

    public static final class a extends GeneratedMessageLite.b implements InterfaceC23948xn0 {
        private a() {
            super(BusinessStruct$OrganizationInfo.DEFAULT_INSTANCE);
        }
    }

    static {
        BusinessStruct$OrganizationInfo businessStruct$OrganizationInfo = new BusinessStruct$OrganizationInfo();
        DEFAULT_INSTANCE = businessStruct$OrganizationInfo;
        GeneratedMessageLite.registerDefaultInstance(BusinessStruct$OrganizationInfo.class, businessStruct$OrganizationInfo);
    }

    private BusinessStruct$OrganizationInfo() {
    }

    private void clearAddress() {
        this.address_ = null;
        this.bitField0_ &= -9;
    }

    private void clearCreatedAt() {
        this.createdAt_ = 0L;
    }

    private void clearCredit() {
        this.credit_ = 0L;
    }

    private void clearEconomicNumber() {
        this.economicNumber_ = null;
        this.bitField0_ &= -3;
    }

    private void clearId() {
        this.id_ = 0;
    }

    private void clearLandlineNumber() {
        this.landlineNumber_ = null;
        this.bitField0_ &= -5;
    }

    private void clearName() {
        this.name_ = getDefaultInstance().getName();
    }

    private void clearNationalNumber() {
        this.nationalNumber_ = null;
        this.bitField0_ &= -2;
    }

    private void clearOwnerPhoneNumber() {
        this.ownerPhoneNumber_ = 0L;
    }

    private void clearOwnerUserId() {
        this.ownerUserId_ = 0;
    }

    private void clearPostalCode() {
        this.postalCode_ = null;
        this.bitField0_ &= -17;
    }

    private void clearTag() {
        this.tag_ = null;
        this.bitField0_ &= -33;
    }

    public static BusinessStruct$OrganizationInfo getDefaultInstance() {
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
        this.bitField0_ |= 8;
    }

    private void mergeEconomicNumber(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.economicNumber_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.economicNumber_ = stringValue;
        } else {
            this.economicNumber_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.economicNumber_).v(stringValue)).j();
        }
        this.bitField0_ |= 2;
    }

    private void mergeLandlineNumber(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.landlineNumber_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.landlineNumber_ = stringValue;
        } else {
            this.landlineNumber_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.landlineNumber_).v(stringValue)).j();
        }
        this.bitField0_ |= 4;
    }

    private void mergeNationalNumber(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.nationalNumber_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.nationalNumber_ = stringValue;
        } else {
            this.nationalNumber_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.nationalNumber_).v(stringValue)).j();
        }
        this.bitField0_ |= 1;
    }

    private void mergePostalCode(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.postalCode_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.postalCode_ = stringValue;
        } else {
            this.postalCode_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.postalCode_).v(stringValue)).j();
        }
        this.bitField0_ |= 16;
    }

    private void mergeTag(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.tag_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.tag_ = stringValue;
        } else {
            this.tag_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.tag_).v(stringValue)).j();
        }
        this.bitField0_ |= 32;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static BusinessStruct$OrganizationInfo parseDelimitedFrom(InputStream inputStream) {
        return (BusinessStruct$OrganizationInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BusinessStruct$OrganizationInfo parseFrom(ByteBuffer byteBuffer) {
        return (BusinessStruct$OrganizationInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAddress(StringValue stringValue) {
        stringValue.getClass();
        this.address_ = stringValue;
        this.bitField0_ |= 8;
    }

    private void setCreatedAt(long j) {
        this.createdAt_ = j;
    }

    private void setCredit(long j) {
        this.credit_ = j;
    }

    private void setEconomicNumber(StringValue stringValue) {
        stringValue.getClass();
        this.economicNumber_ = stringValue;
        this.bitField0_ |= 2;
    }

    private void setId(int i) {
        this.id_ = i;
    }

    private void setLandlineNumber(StringValue stringValue) {
        stringValue.getClass();
        this.landlineNumber_ = stringValue;
        this.bitField0_ |= 4;
    }

    private void setName(String str) {
        str.getClass();
        this.name_ = str;
    }

    private void setNameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.name_ = abstractC2383g.f0();
    }

    private void setNationalNumber(StringValue stringValue) {
        stringValue.getClass();
        this.nationalNumber_ = stringValue;
        this.bitField0_ |= 1;
    }

    private void setOwnerPhoneNumber(long j) {
        this.ownerPhoneNumber_ = j;
    }

    private void setOwnerUserId(int i) {
        this.ownerUserId_ = i;
    }

    private void setPostalCode(StringValue stringValue) {
        stringValue.getClass();
        this.postalCode_ = stringValue;
        this.bitField0_ |= 16;
    }

    private void setTag(StringValue stringValue) {
        stringValue.getClass();
        this.tag_ = stringValue;
        this.bitField0_ |= 32;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1899v.a[gVar.ordinal()]) {
            case 1:
                return new BusinessStruct$OrganizationInfo();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\f\u0000\u0001\u0001\f\f\u0000\u0000\u0000\u0001\u0004\u0002\u0004\u0003Ȉ\u0004\u0002\u0005\u0002\u0006ဉ\u0000\u0007ဉ\u0001\bဉ\u0002\tဉ\u0003\nဉ\u0004\u000b\u0002\fဉ\u0005", new Object[]{"bitField0_", "id_", "ownerUserId_", "name_", "createdAt_", "credit_", "nationalNumber_", "economicNumber_", "landlineNumber_", "address_", "postalCode_", "ownerPhoneNumber_", "tag_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (BusinessStruct$OrganizationInfo.class) {
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

    public long getCredit() {
        return this.credit_;
    }

    public StringValue getEconomicNumber() {
        StringValue stringValue = this.economicNumber_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public int getId() {
        return this.id_;
    }

    public StringValue getLandlineNumber() {
        StringValue stringValue = this.landlineNumber_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public String getName() {
        return this.name_;
    }

    public AbstractC2383g getNameBytes() {
        return AbstractC2383g.N(this.name_);
    }

    public StringValue getNationalNumber() {
        StringValue stringValue = this.nationalNumber_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public long getOwnerPhoneNumber() {
        return this.ownerPhoneNumber_;
    }

    public int getOwnerUserId() {
        return this.ownerUserId_;
    }

    public StringValue getPostalCode() {
        StringValue stringValue = this.postalCode_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public StringValue getTag() {
        StringValue stringValue = this.tag_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public boolean hasAddress() {
        return (this.bitField0_ & 8) != 0;
    }

    public boolean hasEconomicNumber() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasLandlineNumber() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasNationalNumber() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasPostalCode() {
        return (this.bitField0_ & 16) != 0;
    }

    public boolean hasTag() {
        return (this.bitField0_ & 32) != 0;
    }

    public static a newBuilder(BusinessStruct$OrganizationInfo businessStruct$OrganizationInfo) {
        return (a) DEFAULT_INSTANCE.createBuilder(businessStruct$OrganizationInfo);
    }

    public static BusinessStruct$OrganizationInfo parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (BusinessStruct$OrganizationInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BusinessStruct$OrganizationInfo parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (BusinessStruct$OrganizationInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static BusinessStruct$OrganizationInfo parseFrom(AbstractC2383g abstractC2383g) {
        return (BusinessStruct$OrganizationInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static BusinessStruct$OrganizationInfo parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (BusinessStruct$OrganizationInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static BusinessStruct$OrganizationInfo parseFrom(byte[] bArr) {
        return (BusinessStruct$OrganizationInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static BusinessStruct$OrganizationInfo parseFrom(byte[] bArr, C2394s c2394s) {
        return (BusinessStruct$OrganizationInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static BusinessStruct$OrganizationInfo parseFrom(InputStream inputStream) {
        return (BusinessStruct$OrganizationInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BusinessStruct$OrganizationInfo parseFrom(InputStream inputStream, C2394s c2394s) {
        return (BusinessStruct$OrganizationInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BusinessStruct$OrganizationInfo parseFrom(AbstractC2384h abstractC2384h) {
        return (BusinessStruct$OrganizationInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static BusinessStruct$OrganizationInfo parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (BusinessStruct$OrganizationInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
