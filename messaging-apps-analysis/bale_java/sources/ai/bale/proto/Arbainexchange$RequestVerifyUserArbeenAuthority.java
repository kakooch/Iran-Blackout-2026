package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC23065wI;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class Arbainexchange$RequestVerifyUserArbeenAuthority extends GeneratedMessageLite implements U64 {
    public static final int BANK_TYPE_FIELD_NUMBER = 9;
    public static final int BIRTH_DATE_FIELD_NUMBER = 6;
    private static final Arbainexchange$RequestVerifyUserArbeenAuthority DEFAULT_INSTANCE;
    public static final int FATHER_NAME_FIELD_NUMBER = 7;
    public static final int FIRST_NAME_FIELD_NUMBER = 1;
    public static final int LAST_NAME_FIELD_NUMBER = 2;
    public static final int NATIONAL_CODE_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER = null;
    public static final int PASSPORT_CODE_FIELD_NUMBER = 4;
    public static final int PHONE_NUMBER_FIELD_NUMBER = 10;
    public static final int POSTAL_CODE_FIELD_NUMBER = 5;
    public static final int SH_ID_FIELD_NUMBER = 8;
    private int bankType_;
    private int bitField0_;
    private String firstName_ = "";
    private String lastName_ = "";
    private String nationalCode_ = "";
    private String passportCode_ = "";
    private String postalCode_ = "";
    private String birthDate_ = "";
    private String fatherName_ = "";
    private String shId_ = "";
    private String phoneNumber_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Arbainexchange$RequestVerifyUserArbeenAuthority.DEFAULT_INSTANCE);
        }
    }

    static {
        Arbainexchange$RequestVerifyUserArbeenAuthority arbainexchange$RequestVerifyUserArbeenAuthority = new Arbainexchange$RequestVerifyUserArbeenAuthority();
        DEFAULT_INSTANCE = arbainexchange$RequestVerifyUserArbeenAuthority;
        GeneratedMessageLite.registerDefaultInstance(Arbainexchange$RequestVerifyUserArbeenAuthority.class, arbainexchange$RequestVerifyUserArbeenAuthority);
    }

    private Arbainexchange$RequestVerifyUserArbeenAuthority() {
    }

    private void clearBankType() {
        this.bankType_ = 0;
    }

    private void clearBirthDate() {
        this.birthDate_ = getDefaultInstance().getBirthDate();
    }

    private void clearFatherName() {
        this.fatherName_ = getDefaultInstance().getFatherName();
    }

    private void clearFirstName() {
        this.firstName_ = getDefaultInstance().getFirstName();
    }

    private void clearLastName() {
        this.lastName_ = getDefaultInstance().getLastName();
    }

    private void clearNationalCode() {
        this.nationalCode_ = getDefaultInstance().getNationalCode();
    }

    private void clearPassportCode() {
        this.passportCode_ = getDefaultInstance().getPassportCode();
    }

    private void clearPhoneNumber() {
        this.bitField0_ &= -2;
        this.phoneNumber_ = getDefaultInstance().getPhoneNumber();
    }

    private void clearPostalCode() {
        this.postalCode_ = getDefaultInstance().getPostalCode();
    }

    private void clearShId() {
        this.shId_ = getDefaultInstance().getShId();
    }

    public static Arbainexchange$RequestVerifyUserArbeenAuthority getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Arbainexchange$RequestVerifyUserArbeenAuthority parseDelimitedFrom(InputStream inputStream) {
        return (Arbainexchange$RequestVerifyUserArbeenAuthority) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Arbainexchange$RequestVerifyUserArbeenAuthority parseFrom(ByteBuffer byteBuffer) {
        return (Arbainexchange$RequestVerifyUserArbeenAuthority) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setBankType(EnumC23065wI enumC23065wI) {
        this.bankType_ = enumC23065wI.getNumber();
    }

    private void setBankTypeValue(int i) {
        this.bankType_ = i;
    }

    private void setBirthDate(String str) {
        str.getClass();
        this.birthDate_ = str;
    }

    private void setBirthDateBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.birthDate_ = abstractC2383g.f0();
    }

    private void setFatherName(String str) {
        str.getClass();
        this.fatherName_ = str;
    }

    private void setFatherNameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.fatherName_ = abstractC2383g.f0();
    }

    private void setFirstName(String str) {
        str.getClass();
        this.firstName_ = str;
    }

    private void setFirstNameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.firstName_ = abstractC2383g.f0();
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

    private void setPassportCode(String str) {
        str.getClass();
        this.passportCode_ = str;
    }

    private void setPassportCodeBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.passportCode_ = abstractC2383g.f0();
    }

    private void setPhoneNumber(String str) {
        str.getClass();
        this.bitField0_ |= 1;
        this.phoneNumber_ = str;
    }

    private void setPhoneNumberBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.phoneNumber_ = abstractC2383g.f0();
        this.bitField0_ |= 1;
    }

    private void setPostalCode(String str) {
        str.getClass();
        this.postalCode_ = str;
    }

    private void setPostalCodeBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.postalCode_ = abstractC2383g.f0();
    }

    private void setShId(String str) {
        str.getClass();
        this.shId_ = str;
    }

    private void setShIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.shId_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1861i.a[gVar.ordinal()]) {
            case 1:
                return new Arbainexchange$RequestVerifyUserArbeenAuthority();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\n\u0000\u0001\u0001\n\n\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004Ȉ\u0005Ȉ\u0006Ȉ\u0007Ȉ\bȈ\t\f\nለ\u0000", new Object[]{"bitField0_", "firstName_", "lastName_", "nationalCode_", "passportCode_", "postalCode_", "birthDate_", "fatherName_", "shId_", "bankType_", "phoneNumber_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Arbainexchange$RequestVerifyUserArbeenAuthority.class) {
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

    public EnumC23065wI getBankType() {
        EnumC23065wI enumC23065wIJ = EnumC23065wI.j(this.bankType_);
        return enumC23065wIJ == null ? EnumC23065wI.UNRECOGNIZED : enumC23065wIJ;
    }

    public int getBankTypeValue() {
        return this.bankType_;
    }

    public String getBirthDate() {
        return this.birthDate_;
    }

    public AbstractC2383g getBirthDateBytes() {
        return AbstractC2383g.N(this.birthDate_);
    }

    public String getFatherName() {
        return this.fatherName_;
    }

    public AbstractC2383g getFatherNameBytes() {
        return AbstractC2383g.N(this.fatherName_);
    }

    public String getFirstName() {
        return this.firstName_;
    }

    public AbstractC2383g getFirstNameBytes() {
        return AbstractC2383g.N(this.firstName_);
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

    public String getPassportCode() {
        return this.passportCode_;
    }

    public AbstractC2383g getPassportCodeBytes() {
        return AbstractC2383g.N(this.passportCode_);
    }

    public String getPhoneNumber() {
        return this.phoneNumber_;
    }

    public AbstractC2383g getPhoneNumberBytes() {
        return AbstractC2383g.N(this.phoneNumber_);
    }

    public String getPostalCode() {
        return this.postalCode_;
    }

    public AbstractC2383g getPostalCodeBytes() {
        return AbstractC2383g.N(this.postalCode_);
    }

    public String getShId() {
        return this.shId_;
    }

    public AbstractC2383g getShIdBytes() {
        return AbstractC2383g.N(this.shId_);
    }

    public boolean hasPhoneNumber() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(Arbainexchange$RequestVerifyUserArbeenAuthority arbainexchange$RequestVerifyUserArbeenAuthority) {
        return (a) DEFAULT_INSTANCE.createBuilder(arbainexchange$RequestVerifyUserArbeenAuthority);
    }

    public static Arbainexchange$RequestVerifyUserArbeenAuthority parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Arbainexchange$RequestVerifyUserArbeenAuthority) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Arbainexchange$RequestVerifyUserArbeenAuthority parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Arbainexchange$RequestVerifyUserArbeenAuthority) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Arbainexchange$RequestVerifyUserArbeenAuthority parseFrom(AbstractC2383g abstractC2383g) {
        return (Arbainexchange$RequestVerifyUserArbeenAuthority) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static Arbainexchange$RequestVerifyUserArbeenAuthority parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Arbainexchange$RequestVerifyUserArbeenAuthority) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Arbainexchange$RequestVerifyUserArbeenAuthority parseFrom(byte[] bArr) {
        return (Arbainexchange$RequestVerifyUserArbeenAuthority) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Arbainexchange$RequestVerifyUserArbeenAuthority parseFrom(byte[] bArr, C2394s c2394s) {
        return (Arbainexchange$RequestVerifyUserArbeenAuthority) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Arbainexchange$RequestVerifyUserArbeenAuthority parseFrom(InputStream inputStream) {
        return (Arbainexchange$RequestVerifyUserArbeenAuthority) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Arbainexchange$RequestVerifyUserArbeenAuthority parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Arbainexchange$RequestVerifyUserArbeenAuthority) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Arbainexchange$RequestVerifyUserArbeenAuthority parseFrom(AbstractC2384h abstractC2384h) {
        return (Arbainexchange$RequestVerifyUserArbeenAuthority) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Arbainexchange$RequestVerifyUserArbeenAuthority parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Arbainexchange$RequestVerifyUserArbeenAuthority) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
