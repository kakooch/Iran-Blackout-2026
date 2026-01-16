package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC19090pl6;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class SefteOuterClass$RequestInitP12 extends GeneratedMessageLite implements U64 {
    public static final int ADDRESS_FIELD_NUMBER = 10;
    public static final int BIRTHDATE_FIELD_NUMBER = 6;
    public static final int CITY_CODE_FIELD_NUMBER = 11;
    private static final SefteOuterClass$RequestInitP12 DEFAULT_INSTANCE;
    public static final int EMAIL_FIELD_NUMBER = 8;
    public static final int EN_FIRST_NAME_FIELD_NUMBER = 2;
    public static final int EN_LAST_NAME_FIELD_NUMBER = 4;
    public static final int FATHER_FIRSTNAME_FIELD_NUMBER = 13;
    public static final int FIRST_NAME_FIELD_NUMBER = 1;
    public static final int GENDER_FIELD_NUMBER = 5;
    public static final int JOB_TITLE_FIELD_NUMBER = 7;
    public static final int LAST_NAME_FIELD_NUMBER = 3;
    public static final int NATIONAL_CODE_FIELD_NUMBER = 14;
    private static volatile KW4 PARSER = null;
    public static final int PASSWORD_FIELD_NUMBER = 9;
    public static final int POSTAL_CODE_FIELD_NUMBER = 15;
    public static final int STATE_CODE_FIELD_NUMBER = 12;
    private int cityCode_;
    private int gender_;
    private int stateCode_;
    private String firstName_ = "";
    private String enFirstName_ = "";
    private String lastName_ = "";
    private String enLastName_ = "";
    private String birthdate_ = "";
    private String jobTitle_ = "";
    private String email_ = "";
    private String password_ = "";
    private String address_ = "";
    private String fatherFirstname_ = "";
    private String nationalCode_ = "";
    private String postalCode_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(SefteOuterClass$RequestInitP12.DEFAULT_INSTANCE);
        }
    }

    static {
        SefteOuterClass$RequestInitP12 sefteOuterClass$RequestInitP12 = new SefteOuterClass$RequestInitP12();
        DEFAULT_INSTANCE = sefteOuterClass$RequestInitP12;
        GeneratedMessageLite.registerDefaultInstance(SefteOuterClass$RequestInitP12.class, sefteOuterClass$RequestInitP12);
    }

    private SefteOuterClass$RequestInitP12() {
    }

    private void clearAddress() {
        this.address_ = getDefaultInstance().getAddress();
    }

    private void clearBirthdate() {
        this.birthdate_ = getDefaultInstance().getBirthdate();
    }

    private void clearCityCode() {
        this.cityCode_ = 0;
    }

    private void clearEmail() {
        this.email_ = getDefaultInstance().getEmail();
    }

    private void clearEnFirstName() {
        this.enFirstName_ = getDefaultInstance().getEnFirstName();
    }

    private void clearEnLastName() {
        this.enLastName_ = getDefaultInstance().getEnLastName();
    }

    private void clearFatherFirstname() {
        this.fatherFirstname_ = getDefaultInstance().getFatherFirstname();
    }

    private void clearFirstName() {
        this.firstName_ = getDefaultInstance().getFirstName();
    }

    private void clearGender() {
        this.gender_ = 0;
    }

    private void clearJobTitle() {
        this.jobTitle_ = getDefaultInstance().getJobTitle();
    }

    private void clearLastName() {
        this.lastName_ = getDefaultInstance().getLastName();
    }

    private void clearNationalCode() {
        this.nationalCode_ = getDefaultInstance().getNationalCode();
    }

    private void clearPassword() {
        this.password_ = getDefaultInstance().getPassword();
    }

    private void clearPostalCode() {
        this.postalCode_ = getDefaultInstance().getPostalCode();
    }

    private void clearStateCode() {
        this.stateCode_ = 0;
    }

    public static SefteOuterClass$RequestInitP12 getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SefteOuterClass$RequestInitP12 parseDelimitedFrom(InputStream inputStream) {
        return (SefteOuterClass$RequestInitP12) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SefteOuterClass$RequestInitP12 parseFrom(ByteBuffer byteBuffer) {
        return (SefteOuterClass$RequestInitP12) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAddress(String str) {
        str.getClass();
        this.address_ = str;
    }

    private void setAddressBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.address_ = abstractC2383g.f0();
    }

    private void setBirthdate(String str) {
        str.getClass();
        this.birthdate_ = str;
    }

    private void setBirthdateBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.birthdate_ = abstractC2383g.f0();
    }

    private void setCityCode(int i) {
        this.cityCode_ = i;
    }

    private void setEmail(String str) {
        str.getClass();
        this.email_ = str;
    }

    private void setEmailBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.email_ = abstractC2383g.f0();
    }

    private void setEnFirstName(String str) {
        str.getClass();
        this.enFirstName_ = str;
    }

    private void setEnFirstNameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.enFirstName_ = abstractC2383g.f0();
    }

    private void setEnLastName(String str) {
        str.getClass();
        this.enLastName_ = str;
    }

    private void setEnLastNameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.enLastName_ = abstractC2383g.f0();
    }

    private void setFatherFirstname(String str) {
        str.getClass();
        this.fatherFirstname_ = str;
    }

    private void setFatherFirstnameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.fatherFirstname_ = abstractC2383g.f0();
    }

    private void setFirstName(String str) {
        str.getClass();
        this.firstName_ = str;
    }

    private void setFirstNameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.firstName_ = abstractC2383g.f0();
    }

    private void setGender(EnumC19090pl6 enumC19090pl6) {
        this.gender_ = enumC19090pl6.getNumber();
    }

    private void setGenderValue(int i) {
        this.gender_ = i;
    }

    private void setJobTitle(String str) {
        str.getClass();
        this.jobTitle_ = str;
    }

    private void setJobTitleBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.jobTitle_ = abstractC2383g.f0();
    }

    private void setLastName(String str) {
        str.getClass();
        this.lastName_ = str;
    }

    private void setLastNameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.lastName_ = abstractC2383g.f0();
    }

    private void setNationalCode(String str) {
        str.getClass();
        this.nationalCode_ = str;
    }

    private void setNationalCodeBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.nationalCode_ = abstractC2383g.f0();
    }

    private void setPassword(String str) {
        str.getClass();
        this.password_ = str;
    }

    private void setPasswordBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.password_ = abstractC2383g.f0();
    }

    private void setPostalCode(String str) {
        str.getClass();
        this.postalCode_ = str;
    }

    private void setPostalCodeBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.postalCode_ = abstractC2383g.f0();
    }

    private void setStateCode(int i) {
        this.stateCode_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (P1.a[gVar.ordinal()]) {
            case 1:
                return new SefteOuterClass$RequestInitP12();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u000f\u0000\u0000\u0001\u000f\u000f\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004Ȉ\u0005\f\u0006Ȉ\u0007Ȉ\bȈ\tȈ\nȈ\u000b\u0004\f\u0004\rȈ\u000eȈ\u000fȈ", new Object[]{"firstName_", "enFirstName_", "lastName_", "enLastName_", "gender_", "birthdate_", "jobTitle_", "email_", "password_", "address_", "cityCode_", "stateCode_", "fatherFirstname_", "nationalCode_", "postalCode_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SefteOuterClass$RequestInitP12.class) {
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

    public String getAddress() {
        return this.address_;
    }

    public AbstractC2383g getAddressBytes() {
        return AbstractC2383g.N(this.address_);
    }

    public String getBirthdate() {
        return this.birthdate_;
    }

    public AbstractC2383g getBirthdateBytes() {
        return AbstractC2383g.N(this.birthdate_);
    }

    public int getCityCode() {
        return this.cityCode_;
    }

    public String getEmail() {
        return this.email_;
    }

    public AbstractC2383g getEmailBytes() {
        return AbstractC2383g.N(this.email_);
    }

    public String getEnFirstName() {
        return this.enFirstName_;
    }

    public AbstractC2383g getEnFirstNameBytes() {
        return AbstractC2383g.N(this.enFirstName_);
    }

    public String getEnLastName() {
        return this.enLastName_;
    }

    public AbstractC2383g getEnLastNameBytes() {
        return AbstractC2383g.N(this.enLastName_);
    }

    public String getFatherFirstname() {
        return this.fatherFirstname_;
    }

    public AbstractC2383g getFatherFirstnameBytes() {
        return AbstractC2383g.N(this.fatherFirstname_);
    }

    public String getFirstName() {
        return this.firstName_;
    }

    public AbstractC2383g getFirstNameBytes() {
        return AbstractC2383g.N(this.firstName_);
    }

    public EnumC19090pl6 getGender() {
        EnumC19090pl6 enumC19090pl6J = EnumC19090pl6.j(this.gender_);
        return enumC19090pl6J == null ? EnumC19090pl6.UNRECOGNIZED : enumC19090pl6J;
    }

    public int getGenderValue() {
        return this.gender_;
    }

    public String getJobTitle() {
        return this.jobTitle_;
    }

    public AbstractC2383g getJobTitleBytes() {
        return AbstractC2383g.N(this.jobTitle_);
    }

    public String getLastName() {
        return this.lastName_;
    }

    public AbstractC2383g getLastNameBytes() {
        return AbstractC2383g.N(this.lastName_);
    }

    public String getNationalCode() {
        return this.nationalCode_;
    }

    public AbstractC2383g getNationalCodeBytes() {
        return AbstractC2383g.N(this.nationalCode_);
    }

    public String getPassword() {
        return this.password_;
    }

    public AbstractC2383g getPasswordBytes() {
        return AbstractC2383g.N(this.password_);
    }

    public String getPostalCode() {
        return this.postalCode_;
    }

    public AbstractC2383g getPostalCodeBytes() {
        return AbstractC2383g.N(this.postalCode_);
    }

    public int getStateCode() {
        return this.stateCode_;
    }

    public static a newBuilder(SefteOuterClass$RequestInitP12 sefteOuterClass$RequestInitP12) {
        return (a) DEFAULT_INSTANCE.createBuilder(sefteOuterClass$RequestInitP12);
    }

    public static SefteOuterClass$RequestInitP12 parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SefteOuterClass$RequestInitP12) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SefteOuterClass$RequestInitP12 parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SefteOuterClass$RequestInitP12) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SefteOuterClass$RequestInitP12 parseFrom(AbstractC2383g abstractC2383g) {
        return (SefteOuterClass$RequestInitP12) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static SefteOuterClass$RequestInitP12 parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SefteOuterClass$RequestInitP12) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SefteOuterClass$RequestInitP12 parseFrom(byte[] bArr) {
        return (SefteOuterClass$RequestInitP12) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SefteOuterClass$RequestInitP12 parseFrom(byte[] bArr, C2394s c2394s) {
        return (SefteOuterClass$RequestInitP12) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SefteOuterClass$RequestInitP12 parseFrom(InputStream inputStream) {
        return (SefteOuterClass$RequestInitP12) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SefteOuterClass$RequestInitP12 parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SefteOuterClass$RequestInitP12) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SefteOuterClass$RequestInitP12 parseFrom(AbstractC2384h abstractC2384h) {
        return (SefteOuterClass$RequestInitP12) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SefteOuterClass$RequestInitP12 parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SefteOuterClass$RequestInitP12) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
