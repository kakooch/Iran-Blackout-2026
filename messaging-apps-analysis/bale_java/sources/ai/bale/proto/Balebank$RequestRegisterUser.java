package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC14507i20;
import ir.nasim.EnumC16296l20;
import ir.nasim.KM7;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class Balebank$RequestRegisterUser extends GeneratedMessageLite implements U64 {
    public static final int BIRTH_DATE_FIELD_NUMBER = 4;
    private static final Balebank$RequestRegisterUser DEFAULT_INSTANCE;
    public static final int EDUCATION_FIELD_NUMBER = 7;
    public static final int FAMILY_NAME_FIELD_NUMBER = 2;
    public static final int MARRIAGE_STATUS_FIELD_NUMBER = 6;
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int NATIONAL_CODE_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER = null;
    public static final int SEX_FIELD_NUMBER = 5;
    private long birthDate_;
    private int education_;
    private int marriageStatus_;
    private int sex_;
    private String name_ = "";
    private String familyName_ = "";
    private String nationalCode_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Balebank$RequestRegisterUser.DEFAULT_INSTANCE);
        }
    }

    static {
        Balebank$RequestRegisterUser balebank$RequestRegisterUser = new Balebank$RequestRegisterUser();
        DEFAULT_INSTANCE = balebank$RequestRegisterUser;
        GeneratedMessageLite.registerDefaultInstance(Balebank$RequestRegisterUser.class, balebank$RequestRegisterUser);
    }

    private Balebank$RequestRegisterUser() {
    }

    private void clearBirthDate() {
        this.birthDate_ = 0L;
    }

    private void clearEducation() {
        this.education_ = 0;
    }

    private void clearFamilyName() {
        this.familyName_ = getDefaultInstance().getFamilyName();
    }

    private void clearMarriageStatus() {
        this.marriageStatus_ = 0;
    }

    private void clearName() {
        this.name_ = getDefaultInstance().getName();
    }

    private void clearNationalCode() {
        this.nationalCode_ = getDefaultInstance().getNationalCode();
    }

    private void clearSex() {
        this.sex_ = 0;
    }

    public static Balebank$RequestRegisterUser getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Balebank$RequestRegisterUser parseDelimitedFrom(InputStream inputStream) {
        return (Balebank$RequestRegisterUser) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Balebank$RequestRegisterUser parseFrom(ByteBuffer byteBuffer) {
        return (Balebank$RequestRegisterUser) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setBirthDate(long j) {
        this.birthDate_ = j;
    }

    private void setEducation(EnumC14507i20 enumC14507i20) {
        this.education_ = enumC14507i20.getNumber();
    }

    private void setEducationValue(int i) {
        this.education_ = i;
    }

    private void setFamilyName(String str) {
        str.getClass();
        this.familyName_ = str;
    }

    private void setFamilyNameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.familyName_ = abstractC2383g.f0();
    }

    private void setMarriageStatus(EnumC16296l20 enumC16296l20) {
        this.marriageStatus_ = enumC16296l20.getNumber();
    }

    private void setMarriageStatusValue(int i) {
        this.marriageStatus_ = i;
    }

    private void setName(String str) {
        str.getClass();
        this.name_ = str;
    }

    private void setNameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.name_ = abstractC2383g.f0();
    }

    private void setNationalCode(String str) {
        str.getClass();
        this.nationalCode_ = str;
    }

    private void setNationalCodeBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.nationalCode_ = abstractC2383g.f0();
    }

    private void setSex(KM7 km7) {
        this.sex_ = km7.getNumber();
    }

    private void setSexValue(int i) {
        this.sex_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1873m.a[gVar.ordinal()]) {
            case 1:
                return new Balebank$RequestRegisterUser();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0007\u0000\u0000\u0001\u0007\u0007\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004\u0002\u0005\f\u0006\f\u0007\f", new Object[]{"name_", "familyName_", "nationalCode_", "birthDate_", "sex_", "marriageStatus_", "education_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Balebank$RequestRegisterUser.class) {
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

    public long getBirthDate() {
        return this.birthDate_;
    }

    public EnumC14507i20 getEducation() {
        EnumC14507i20 enumC14507i20J = EnumC14507i20.j(this.education_);
        return enumC14507i20J == null ? EnumC14507i20.UNRECOGNIZED : enumC14507i20J;
    }

    public int getEducationValue() {
        return this.education_;
    }

    public String getFamilyName() {
        return this.familyName_;
    }

    public AbstractC2383g getFamilyNameBytes() {
        return AbstractC2383g.N(this.familyName_);
    }

    public EnumC16296l20 getMarriageStatus() {
        EnumC16296l20 enumC16296l20J = EnumC16296l20.j(this.marriageStatus_);
        return enumC16296l20J == null ? EnumC16296l20.UNRECOGNIZED : enumC16296l20J;
    }

    public int getMarriageStatusValue() {
        return this.marriageStatus_;
    }

    public String getName() {
        return this.name_;
    }

    public AbstractC2383g getNameBytes() {
        return AbstractC2383g.N(this.name_);
    }

    public String getNationalCode() {
        return this.nationalCode_;
    }

    public AbstractC2383g getNationalCodeBytes() {
        return AbstractC2383g.N(this.nationalCode_);
    }

    public KM7 getSex() {
        KM7 km7J = KM7.j(this.sex_);
        return km7J == null ? KM7.UNRECOGNIZED : km7J;
    }

    public int getSexValue() {
        return this.sex_;
    }

    public static a newBuilder(Balebank$RequestRegisterUser balebank$RequestRegisterUser) {
        return (a) DEFAULT_INSTANCE.createBuilder(balebank$RequestRegisterUser);
    }

    public static Balebank$RequestRegisterUser parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Balebank$RequestRegisterUser) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Balebank$RequestRegisterUser parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Balebank$RequestRegisterUser) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Balebank$RequestRegisterUser parseFrom(AbstractC2383g abstractC2383g) {
        return (Balebank$RequestRegisterUser) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static Balebank$RequestRegisterUser parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Balebank$RequestRegisterUser) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Balebank$RequestRegisterUser parseFrom(byte[] bArr) {
        return (Balebank$RequestRegisterUser) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Balebank$RequestRegisterUser parseFrom(byte[] bArr, C2394s c2394s) {
        return (Balebank$RequestRegisterUser) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Balebank$RequestRegisterUser parseFrom(InputStream inputStream) {
        return (Balebank$RequestRegisterUser) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Balebank$RequestRegisterUser parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Balebank$RequestRegisterUser) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Balebank$RequestRegisterUser parseFrom(AbstractC2384h abstractC2384h) {
        return (Balebank$RequestRegisterUser) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Balebank$RequestRegisterUser parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Balebank$RequestRegisterUser) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
