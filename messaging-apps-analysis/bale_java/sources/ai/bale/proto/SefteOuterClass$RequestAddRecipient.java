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

/* loaded from: classes.dex */
public final class SefteOuterClass$RequestAddRecipient extends GeneratedMessageLite implements U64 {
    public static final int ACCOUNT_NUMBER_FIELD_NUMBER = 1;
    public static final int ADDRESS_FIELD_NUMBER = 2;
    private static final SefteOuterClass$RequestAddRecipient DEFAULT_INSTANCE;
    public static final int FULL_NAME_FIELD_NUMBER = 3;
    public static final int IS_LEGAL_FIELD_NUMBER = 4;
    public static final int MOBILE_NUMBER_FIELD_NUMBER = 5;
    public static final int NATIONAL_CODE_FIELD_NUMBER = 6;
    private static volatile KW4 PARSER = null;
    public static final int POSTAL_CODE_FIELD_NUMBER = 7;
    public static final int SANA_CODE_FIELD_NUMBER = 8;
    private boolean isLegal_;
    private String accountNumber_ = "";
    private String address_ = "";
    private String fullName_ = "";
    private String mobileNumber_ = "";
    private String nationalCode_ = "";
    private String postalCode_ = "";
    private String sanaCode_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(SefteOuterClass$RequestAddRecipient.DEFAULT_INSTANCE);
        }
    }

    static {
        SefteOuterClass$RequestAddRecipient sefteOuterClass$RequestAddRecipient = new SefteOuterClass$RequestAddRecipient();
        DEFAULT_INSTANCE = sefteOuterClass$RequestAddRecipient;
        GeneratedMessageLite.registerDefaultInstance(SefteOuterClass$RequestAddRecipient.class, sefteOuterClass$RequestAddRecipient);
    }

    private SefteOuterClass$RequestAddRecipient() {
    }

    private void clearAccountNumber() {
        this.accountNumber_ = getDefaultInstance().getAccountNumber();
    }

    private void clearAddress() {
        this.address_ = getDefaultInstance().getAddress();
    }

    private void clearFullName() {
        this.fullName_ = getDefaultInstance().getFullName();
    }

    private void clearIsLegal() {
        this.isLegal_ = false;
    }

    private void clearMobileNumber() {
        this.mobileNumber_ = getDefaultInstance().getMobileNumber();
    }

    private void clearNationalCode() {
        this.nationalCode_ = getDefaultInstance().getNationalCode();
    }

    private void clearPostalCode() {
        this.postalCode_ = getDefaultInstance().getPostalCode();
    }

    private void clearSanaCode() {
        this.sanaCode_ = getDefaultInstance().getSanaCode();
    }

    public static SefteOuterClass$RequestAddRecipient getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SefteOuterClass$RequestAddRecipient parseDelimitedFrom(InputStream inputStream) {
        return (SefteOuterClass$RequestAddRecipient) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SefteOuterClass$RequestAddRecipient parseFrom(ByteBuffer byteBuffer) {
        return (SefteOuterClass$RequestAddRecipient) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAccountNumber(String str) {
        str.getClass();
        this.accountNumber_ = str;
    }

    private void setAccountNumberBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.accountNumber_ = abstractC2383g.f0();
    }

    private void setAddress(String str) {
        str.getClass();
        this.address_ = str;
    }

    private void setAddressBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.address_ = abstractC2383g.f0();
    }

    private void setFullName(String str) {
        str.getClass();
        this.fullName_ = str;
    }

    private void setFullNameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.fullName_ = abstractC2383g.f0();
    }

    private void setIsLegal(boolean z) {
        this.isLegal_ = z;
    }

    private void setMobileNumber(String str) {
        str.getClass();
        this.mobileNumber_ = str;
    }

    private void setMobileNumberBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.mobileNumber_ = abstractC2383g.f0();
    }

    private void setNationalCode(String str) {
        str.getClass();
        this.nationalCode_ = str;
    }

    private void setNationalCodeBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.nationalCode_ = abstractC2383g.f0();
    }

    private void setPostalCode(String str) {
        str.getClass();
        this.postalCode_ = str;
    }

    private void setPostalCodeBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.postalCode_ = abstractC2383g.f0();
    }

    private void setSanaCode(String str) {
        str.getClass();
        this.sanaCode_ = str;
    }

    private void setSanaCodeBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.sanaCode_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (P1.a[gVar.ordinal()]) {
            case 1:
                return new SefteOuterClass$RequestAddRecipient();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\b\u0000\u0000\u0001\b\b\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004\u0007\u0005Ȉ\u0006Ȉ\u0007Ȉ\bȈ", new Object[]{"accountNumber_", "address_", "fullName_", "isLegal_", "mobileNumber_", "nationalCode_", "postalCode_", "sanaCode_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SefteOuterClass$RequestAddRecipient.class) {
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

    public String getAccountNumber() {
        return this.accountNumber_;
    }

    public AbstractC2383g getAccountNumberBytes() {
        return AbstractC2383g.N(this.accountNumber_);
    }

    public String getAddress() {
        return this.address_;
    }

    public AbstractC2383g getAddressBytes() {
        return AbstractC2383g.N(this.address_);
    }

    public String getFullName() {
        return this.fullName_;
    }

    public AbstractC2383g getFullNameBytes() {
        return AbstractC2383g.N(this.fullName_);
    }

    public boolean getIsLegal() {
        return this.isLegal_;
    }

    public String getMobileNumber() {
        return this.mobileNumber_;
    }

    public AbstractC2383g getMobileNumberBytes() {
        return AbstractC2383g.N(this.mobileNumber_);
    }

    public String getNationalCode() {
        return this.nationalCode_;
    }

    public AbstractC2383g getNationalCodeBytes() {
        return AbstractC2383g.N(this.nationalCode_);
    }

    public String getPostalCode() {
        return this.postalCode_;
    }

    public AbstractC2383g getPostalCodeBytes() {
        return AbstractC2383g.N(this.postalCode_);
    }

    public String getSanaCode() {
        return this.sanaCode_;
    }

    public AbstractC2383g getSanaCodeBytes() {
        return AbstractC2383g.N(this.sanaCode_);
    }

    public static a newBuilder(SefteOuterClass$RequestAddRecipient sefteOuterClass$RequestAddRecipient) {
        return (a) DEFAULT_INSTANCE.createBuilder(sefteOuterClass$RequestAddRecipient);
    }

    public static SefteOuterClass$RequestAddRecipient parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SefteOuterClass$RequestAddRecipient) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SefteOuterClass$RequestAddRecipient parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SefteOuterClass$RequestAddRecipient) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SefteOuterClass$RequestAddRecipient parseFrom(AbstractC2383g abstractC2383g) {
        return (SefteOuterClass$RequestAddRecipient) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static SefteOuterClass$RequestAddRecipient parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SefteOuterClass$RequestAddRecipient) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SefteOuterClass$RequestAddRecipient parseFrom(byte[] bArr) {
        return (SefteOuterClass$RequestAddRecipient) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SefteOuterClass$RequestAddRecipient parseFrom(byte[] bArr, C2394s c2394s) {
        return (SefteOuterClass$RequestAddRecipient) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SefteOuterClass$RequestAddRecipient parseFrom(InputStream inputStream) {
        return (SefteOuterClass$RequestAddRecipient) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SefteOuterClass$RequestAddRecipient parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SefteOuterClass$RequestAddRecipient) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SefteOuterClass$RequestAddRecipient parseFrom(AbstractC2384h abstractC2384h) {
        return (SefteOuterClass$RequestAddRecipient) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SefteOuterClass$RequestAddRecipient parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SefteOuterClass$RequestAddRecipient) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
