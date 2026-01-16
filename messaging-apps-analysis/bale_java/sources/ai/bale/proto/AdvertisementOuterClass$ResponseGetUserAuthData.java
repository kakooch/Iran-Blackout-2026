package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC5424Jh;
import ir.nasim.EnumC5658Kh;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes8.dex */
public final class AdvertisementOuterClass$ResponseGetUserAuthData extends GeneratedMessageLite implements U64 {
    public static final int ADDRESS_FIELD_NUMBER = 4;
    public static final int BIRTH_DATE_FIELD_NUMBER = 3;
    public static final int CHANNEL_NICK_FIELD_NUMBER = 12;
    private static final AdvertisementOuterClass$ResponseGetUserAuthData DEFAULT_INSTANCE;
    public static final int FIRST_NAME_FIELD_NUMBER = 7;
    public static final int LAST_NAME_FIELD_NUMBER = 8;
    public static final int MELLI_ACCOUNT_NUMBER_FIELD_NUMBER = 6;
    public static final int NATIONAL_CODE_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int PHONE_FIELD_NUMBER = 9;
    public static final int POSTAL_CODE_FIELD_NUMBER = 5;
    public static final int REASON_FIELD_NUMBER = 11;
    public static final int STATE_FIELD_NUMBER = 10;
    public static final int USER_ID_FIELD_NUMBER = 1;
    private int reason_;
    private int state_;
    private int userId_;
    private String nationalCode_ = "";
    private String birthDate_ = "";
    private String address_ = "";
    private String postalCode_ = "";
    private String melliAccountNumber_ = "";
    private String firstName_ = "";
    private String lastName_ = "";
    private String phone_ = "";
    private String channelNick_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(AdvertisementOuterClass$ResponseGetUserAuthData.DEFAULT_INSTANCE);
        }
    }

    static {
        AdvertisementOuterClass$ResponseGetUserAuthData advertisementOuterClass$ResponseGetUserAuthData = new AdvertisementOuterClass$ResponseGetUserAuthData();
        DEFAULT_INSTANCE = advertisementOuterClass$ResponseGetUserAuthData;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementOuterClass$ResponseGetUserAuthData.class, advertisementOuterClass$ResponseGetUserAuthData);
    }

    private AdvertisementOuterClass$ResponseGetUserAuthData() {
    }

    private void clearAddress() {
        this.address_ = getDefaultInstance().getAddress();
    }

    private void clearBirthDate() {
        this.birthDate_ = getDefaultInstance().getBirthDate();
    }

    private void clearChannelNick() {
        this.channelNick_ = getDefaultInstance().getChannelNick();
    }

    private void clearFirstName() {
        this.firstName_ = getDefaultInstance().getFirstName();
    }

    private void clearLastName() {
        this.lastName_ = getDefaultInstance().getLastName();
    }

    private void clearMelliAccountNumber() {
        this.melliAccountNumber_ = getDefaultInstance().getMelliAccountNumber();
    }

    private void clearNationalCode() {
        this.nationalCode_ = getDefaultInstance().getNationalCode();
    }

    private void clearPhone() {
        this.phone_ = getDefaultInstance().getPhone();
    }

    private void clearPostalCode() {
        this.postalCode_ = getDefaultInstance().getPostalCode();
    }

    private void clearReason() {
        this.reason_ = 0;
    }

    private void clearState() {
        this.state_ = 0;
    }

    private void clearUserId() {
        this.userId_ = 0;
    }

    public static AdvertisementOuterClass$ResponseGetUserAuthData getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AdvertisementOuterClass$ResponseGetUserAuthData parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$ResponseGetUserAuthData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$ResponseGetUserAuthData parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementOuterClass$ResponseGetUserAuthData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
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

    private void setBirthDate(String str) {
        str.getClass();
        this.birthDate_ = str;
    }

    private void setBirthDateBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.birthDate_ = abstractC2383g.f0();
    }

    private void setChannelNick(String str) {
        str.getClass();
        this.channelNick_ = str;
    }

    private void setChannelNickBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.channelNick_ = abstractC2383g.f0();
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

    private void setMelliAccountNumber(String str) {
        str.getClass();
        this.melliAccountNumber_ = str;
    }

    private void setMelliAccountNumberBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.melliAccountNumber_ = abstractC2383g.f0();
    }

    private void setNationalCode(String str) {
        str.getClass();
        this.nationalCode_ = str;
    }

    private void setNationalCodeBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.nationalCode_ = abstractC2383g.f0();
    }

    private void setPhone(String str) {
        str.getClass();
        this.phone_ = str;
    }

    private void setPhoneBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.phone_ = abstractC2383g.f0();
    }

    private void setPostalCode(String str) {
        str.getClass();
        this.postalCode_ = str;
    }

    private void setPostalCodeBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.postalCode_ = abstractC2383g.f0();
    }

    private void setReason(EnumC5424Jh enumC5424Jh) {
        this.reason_ = enumC5424Jh.getNumber();
    }

    private void setReasonValue(int i) {
        this.reason_ = i;
    }

    private void setState(EnumC5658Kh enumC5658Kh) {
        this.state_ = enumC5658Kh.getNumber();
    }

    private void setStateValue(int i) {
        this.state_ = i;
    }

    private void setUserId(int i) {
        this.userId_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1840b.a[gVar.ordinal()]) {
            case 1:
                return new AdvertisementOuterClass$ResponseGetUserAuthData();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\f\u0000\u0000\u0001\f\f\u0000\u0000\u0000\u0001\u0004\u0002Ȉ\u0003Ȉ\u0004Ȉ\u0005Ȉ\u0006Ȉ\u0007Ȉ\bȈ\tȈ\n\f\u000b\f\fȈ", new Object[]{"userId_", "nationalCode_", "birthDate_", "address_", "postalCode_", "melliAccountNumber_", "firstName_", "lastName_", "phone_", "state_", "reason_", "channelNick_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementOuterClass$ResponseGetUserAuthData.class) {
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

    public String getBirthDate() {
        return this.birthDate_;
    }

    public AbstractC2383g getBirthDateBytes() {
        return AbstractC2383g.N(this.birthDate_);
    }

    public String getChannelNick() {
        return this.channelNick_;
    }

    public AbstractC2383g getChannelNickBytes() {
        return AbstractC2383g.N(this.channelNick_);
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

    public String getMelliAccountNumber() {
        return this.melliAccountNumber_;
    }

    public AbstractC2383g getMelliAccountNumberBytes() {
        return AbstractC2383g.N(this.melliAccountNumber_);
    }

    public String getNationalCode() {
        return this.nationalCode_;
    }

    public AbstractC2383g getNationalCodeBytes() {
        return AbstractC2383g.N(this.nationalCode_);
    }

    public String getPhone() {
        return this.phone_;
    }

    public AbstractC2383g getPhoneBytes() {
        return AbstractC2383g.N(this.phone_);
    }

    public String getPostalCode() {
        return this.postalCode_;
    }

    public AbstractC2383g getPostalCodeBytes() {
        return AbstractC2383g.N(this.postalCode_);
    }

    public EnumC5424Jh getReason() {
        EnumC5424Jh enumC5424JhJ = EnumC5424Jh.j(this.reason_);
        return enumC5424JhJ == null ? EnumC5424Jh.UNRECOGNIZED : enumC5424JhJ;
    }

    public int getReasonValue() {
        return this.reason_;
    }

    public EnumC5658Kh getState() {
        EnumC5658Kh enumC5658KhJ = EnumC5658Kh.j(this.state_);
        return enumC5658KhJ == null ? EnumC5658Kh.UNRECOGNIZED : enumC5658KhJ;
    }

    public int getStateValue() {
        return this.state_;
    }

    public int getUserId() {
        return this.userId_;
    }

    public static a newBuilder(AdvertisementOuterClass$ResponseGetUserAuthData advertisementOuterClass$ResponseGetUserAuthData) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementOuterClass$ResponseGetUserAuthData);
    }

    public static AdvertisementOuterClass$ResponseGetUserAuthData parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetUserAuthData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetUserAuthData parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetUserAuthData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetUserAuthData parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementOuterClass$ResponseGetUserAuthData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AdvertisementOuterClass$ResponseGetUserAuthData parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetUserAuthData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetUserAuthData parseFrom(byte[] bArr) {
        return (AdvertisementOuterClass$ResponseGetUserAuthData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementOuterClass$ResponseGetUserAuthData parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetUserAuthData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetUserAuthData parseFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$ResponseGetUserAuthData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$ResponseGetUserAuthData parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetUserAuthData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetUserAuthData parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementOuterClass$ResponseGetUserAuthData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementOuterClass$ResponseGetUserAuthData parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetUserAuthData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
