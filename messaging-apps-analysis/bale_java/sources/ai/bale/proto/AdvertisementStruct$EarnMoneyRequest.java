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
public final class AdvertisementStruct$EarnMoneyRequest extends GeneratedMessageLite implements U64 {
    public static final int ACCEPT_DATE_FIELD_NUMBER = 4;
    public static final int ADDRESS_FIELD_NUMBER = 11;
    public static final int ASSOCIATED_GROUP_ID_FIELD_NUMBER = 13;
    public static final int CARD_IMAGE_FIELD_NUMBER = 12;
    private static final AdvertisementStruct$EarnMoneyRequest DEFAULT_INSTANCE;
    public static final int FAMILY_FIELD_NUMBER = 7;
    public static final int NAME_FIELD_NUMBER = 6;
    public static final int NATIONAL_CODE_FIELD_NUMBER = 8;
    private static volatile KW4 PARSER = null;
    public static final int PHONE_FIELD_NUMBER = 10;
    public static final int POSTAL_CODE_FIELD_NUMBER = 9;
    public static final int REJECT_REASON_FIELD_NUMBER = 5;
    public static final int REQUEST_DATE_FIELD_NUMBER = 3;
    public static final int STATUS_FIELD_NUMBER = 2;
    public static final int USER_ID_FIELD_NUMBER = 1;
    private long acceptDate_;
    private int associatedGroupId_;
    private long requestDate_;
    private int status_;
    private int userId_;
    private String rejectReason_ = "";
    private String name_ = "";
    private String family_ = "";
    private String nationalCode_ = "";
    private String postalCode_ = "";
    private String phone_ = "";
    private String address_ = "";
    private String cardImage_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(AdvertisementStruct$EarnMoneyRequest.DEFAULT_INSTANCE);
        }
    }

    static {
        AdvertisementStruct$EarnMoneyRequest advertisementStruct$EarnMoneyRequest = new AdvertisementStruct$EarnMoneyRequest();
        DEFAULT_INSTANCE = advertisementStruct$EarnMoneyRequest;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementStruct$EarnMoneyRequest.class, advertisementStruct$EarnMoneyRequest);
    }

    private AdvertisementStruct$EarnMoneyRequest() {
    }

    private void clearAcceptDate() {
        this.acceptDate_ = 0L;
    }

    private void clearAddress() {
        this.address_ = getDefaultInstance().getAddress();
    }

    private void clearAssociatedGroupId() {
        this.associatedGroupId_ = 0;
    }

    private void clearCardImage() {
        this.cardImage_ = getDefaultInstance().getCardImage();
    }

    private void clearFamily() {
        this.family_ = getDefaultInstance().getFamily();
    }

    private void clearName() {
        this.name_ = getDefaultInstance().getName();
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

    private void clearRejectReason() {
        this.rejectReason_ = getDefaultInstance().getRejectReason();
    }

    private void clearRequestDate() {
        this.requestDate_ = 0L;
    }

    private void clearStatus() {
        this.status_ = 0;
    }

    private void clearUserId() {
        this.userId_ = 0;
    }

    public static AdvertisementStruct$EarnMoneyRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AdvertisementStruct$EarnMoneyRequest parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementStruct$EarnMoneyRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementStruct$EarnMoneyRequest parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementStruct$EarnMoneyRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAcceptDate(long j) {
        this.acceptDate_ = j;
    }

    private void setAddress(String str) {
        str.getClass();
        this.address_ = str;
    }

    private void setAddressBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.address_ = abstractC2383g.f0();
    }

    private void setAssociatedGroupId(int i) {
        this.associatedGroupId_ = i;
    }

    private void setCardImage(String str) {
        str.getClass();
        this.cardImage_ = str;
    }

    private void setCardImageBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.cardImage_ = abstractC2383g.f0();
    }

    private void setFamily(String str) {
        str.getClass();
        this.family_ = str;
    }

    private void setFamilyBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.family_ = abstractC2383g.f0();
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

    private void setRejectReason(String str) {
        str.getClass();
        this.rejectReason_ = str;
    }

    private void setRejectReasonBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.rejectReason_ = abstractC2383g.f0();
    }

    private void setRequestDate(long j) {
        this.requestDate_ = j;
    }

    private void setStatus(int i) {
        this.status_ = i;
    }

    private void setUserId(int i) {
        this.userId_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1843c.a[gVar.ordinal()]) {
            case 1:
                return new AdvertisementStruct$EarnMoneyRequest();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\r\u0000\u0000\u0001\r\r\u0000\u0000\u0000\u0001\u0004\u0002\u0004\u0003\u0002\u0004\u0002\u0005Ȉ\u0006Ȉ\u0007Ȉ\bȈ\tȈ\nȈ\u000bȈ\fȈ\r\u0004", new Object[]{"userId_", "status_", "requestDate_", "acceptDate_", "rejectReason_", "name_", "family_", "nationalCode_", "postalCode_", "phone_", "address_", "cardImage_", "associatedGroupId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementStruct$EarnMoneyRequest.class) {
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

    public long getAcceptDate() {
        return this.acceptDate_;
    }

    public String getAddress() {
        return this.address_;
    }

    public AbstractC2383g getAddressBytes() {
        return AbstractC2383g.N(this.address_);
    }

    public int getAssociatedGroupId() {
        return this.associatedGroupId_;
    }

    public String getCardImage() {
        return this.cardImage_;
    }

    public AbstractC2383g getCardImageBytes() {
        return AbstractC2383g.N(this.cardImage_);
    }

    public String getFamily() {
        return this.family_;
    }

    public AbstractC2383g getFamilyBytes() {
        return AbstractC2383g.N(this.family_);
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

    public String getRejectReason() {
        return this.rejectReason_;
    }

    public AbstractC2383g getRejectReasonBytes() {
        return AbstractC2383g.N(this.rejectReason_);
    }

    public long getRequestDate() {
        return this.requestDate_;
    }

    public int getStatus() {
        return this.status_;
    }

    public int getUserId() {
        return this.userId_;
    }

    public static a newBuilder(AdvertisementStruct$EarnMoneyRequest advertisementStruct$EarnMoneyRequest) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementStruct$EarnMoneyRequest);
    }

    public static AdvertisementStruct$EarnMoneyRequest parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementStruct$EarnMoneyRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementStruct$EarnMoneyRequest parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementStruct$EarnMoneyRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementStruct$EarnMoneyRequest parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementStruct$EarnMoneyRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AdvertisementStruct$EarnMoneyRequest parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementStruct$EarnMoneyRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementStruct$EarnMoneyRequest parseFrom(byte[] bArr) {
        return (AdvertisementStruct$EarnMoneyRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementStruct$EarnMoneyRequest parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementStruct$EarnMoneyRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AdvertisementStruct$EarnMoneyRequest parseFrom(InputStream inputStream) {
        return (AdvertisementStruct$EarnMoneyRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementStruct$EarnMoneyRequest parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementStruct$EarnMoneyRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementStruct$EarnMoneyRequest parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementStruct$EarnMoneyRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementStruct$EarnMoneyRequest parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementStruct$EarnMoneyRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
