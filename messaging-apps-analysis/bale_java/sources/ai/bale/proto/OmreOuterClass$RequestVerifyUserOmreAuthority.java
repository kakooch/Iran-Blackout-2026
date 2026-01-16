package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class OmreOuterClass$RequestVerifyUserOmreAuthority extends GeneratedMessageLite implements U64 {
    public static final int BIRTH_DATE_FIELD_NUMBER = 6;
    private static final OmreOuterClass$RequestVerifyUserOmreAuthority DEFAULT_INSTANCE;
    public static final int FATHER_NAME_FIELD_NUMBER = 7;
    public static final int FIRST_NAME_FIELD_NUMBER = 1;
    public static final int IS_VALID_FIELD_NUMBER = 9;
    public static final int LAST_NAME_FIELD_NUMBER = 2;
    public static final int NATIONAL_CODE_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER = null;
    public static final int PASSPORT_CODE_FIELD_NUMBER = 4;
    public static final int POSTAL_CODE_FIELD_NUMBER = 5;
    public static final int SH_ID_FIELD_NUMBER = 8;
    private boolean isValid_;
    private String firstName_ = "";
    private String lastName_ = "";
    private String nationalCode_ = "";
    private String passportCode_ = "";
    private String postalCode_ = "";
    private String birthDate_ = "";
    private String fatherName_ = "";
    private String shId_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(OmreOuterClass$RequestVerifyUserOmreAuthority.DEFAULT_INSTANCE);
        }
    }

    static {
        OmreOuterClass$RequestVerifyUserOmreAuthority omreOuterClass$RequestVerifyUserOmreAuthority = new OmreOuterClass$RequestVerifyUserOmreAuthority();
        DEFAULT_INSTANCE = omreOuterClass$RequestVerifyUserOmreAuthority;
        GeneratedMessageLite.registerDefaultInstance(OmreOuterClass$RequestVerifyUserOmreAuthority.class, omreOuterClass$RequestVerifyUserOmreAuthority);
    }

    private OmreOuterClass$RequestVerifyUserOmreAuthority() {
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

    private void clearIsValid() {
        this.isValid_ = false;
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

    private void clearPostalCode() {
        this.postalCode_ = getDefaultInstance().getPostalCode();
    }

    private void clearShId() {
        this.shId_ = getDefaultInstance().getShId();
    }

    public static OmreOuterClass$RequestVerifyUserOmreAuthority getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static OmreOuterClass$RequestVerifyUserOmreAuthority parseDelimitedFrom(InputStream inputStream) {
        return (OmreOuterClass$RequestVerifyUserOmreAuthority) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static OmreOuterClass$RequestVerifyUserOmreAuthority parseFrom(ByteBuffer byteBuffer) {
        return (OmreOuterClass$RequestVerifyUserOmreAuthority) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
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

    private void setIsValid(boolean z) {
        this.isValid_ = z;
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
        switch (U0.a[gVar.ordinal()]) {
            case 1:
                return new OmreOuterClass$RequestVerifyUserOmreAuthority();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\t\u0000\u0000\u0001\t\t\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004Ȉ\u0005Ȉ\u0006Ȉ\u0007Ȉ\bȈ\t\u0007", new Object[]{"firstName_", "lastName_", "nationalCode_", "passportCode_", "postalCode_", "birthDate_", "fatherName_", "shId_", "isValid_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (OmreOuterClass$RequestVerifyUserOmreAuthority.class) {
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

    public boolean getIsValid() {
        return this.isValid_;
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

    public static a newBuilder(OmreOuterClass$RequestVerifyUserOmreAuthority omreOuterClass$RequestVerifyUserOmreAuthority) {
        return (a) DEFAULT_INSTANCE.createBuilder(omreOuterClass$RequestVerifyUserOmreAuthority);
    }

    public static OmreOuterClass$RequestVerifyUserOmreAuthority parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (OmreOuterClass$RequestVerifyUserOmreAuthority) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static OmreOuterClass$RequestVerifyUserOmreAuthority parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (OmreOuterClass$RequestVerifyUserOmreAuthority) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static OmreOuterClass$RequestVerifyUserOmreAuthority parseFrom(AbstractC2383g abstractC2383g) {
        return (OmreOuterClass$RequestVerifyUserOmreAuthority) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static OmreOuterClass$RequestVerifyUserOmreAuthority parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (OmreOuterClass$RequestVerifyUserOmreAuthority) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static OmreOuterClass$RequestVerifyUserOmreAuthority parseFrom(byte[] bArr) {
        return (OmreOuterClass$RequestVerifyUserOmreAuthority) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static OmreOuterClass$RequestVerifyUserOmreAuthority parseFrom(byte[] bArr, C2394s c2394s) {
        return (OmreOuterClass$RequestVerifyUserOmreAuthority) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static OmreOuterClass$RequestVerifyUserOmreAuthority parseFrom(InputStream inputStream) {
        return (OmreOuterClass$RequestVerifyUserOmreAuthority) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static OmreOuterClass$RequestVerifyUserOmreAuthority parseFrom(InputStream inputStream, C2394s c2394s) {
        return (OmreOuterClass$RequestVerifyUserOmreAuthority) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static OmreOuterClass$RequestVerifyUserOmreAuthority parseFrom(AbstractC2384h abstractC2384h) {
        return (OmreOuterClass$RequestVerifyUserOmreAuthority) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static OmreOuterClass$RequestVerifyUserOmreAuthority parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (OmreOuterClass$RequestVerifyUserOmreAuthority) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
