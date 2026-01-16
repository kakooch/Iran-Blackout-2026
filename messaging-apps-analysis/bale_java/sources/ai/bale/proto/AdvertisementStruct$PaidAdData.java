package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC24457yf;
import ir.nasim.EnumC3771Ch;
import ir.nasim.EnumC4938Hf;
import ir.nasim.InterfaceC25071zh;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class AdvertisementStruct$PaidAdData extends GeneratedMessageLite implements InterfaceC25071zh {
    public static final int ACCOUNT_TYPE_FIELD_NUMBER = 18;
    public static final int ADDRESS_FIELD_NUMBER = 20;
    public static final int CLICK_COUNT_FIELD_NUMBER = 9;
    public static final int CREATED_AT_FIELD_NUMBER = 10;
    private static final AdvertisementStruct$PaidAdData DEFAULT_INSTANCE;
    public static final int DESCRIPTION_FIELD_NUMBER = 4;
    public static final int FULL_NAME_FIELD_NUMBER = 25;
    public static final int ID_FIELD_NUMBER = 1;
    public static final int LINK_FIELD_NUMBER = 5;
    public static final int LINK_TITLE_FIELD_NUMBER = 6;
    public static final int MELLI_SHENASE_FIELD_NUMBER = 22;
    public static final int NAME_FIELD_NUMBER = 24;
    public static final int NATIONAL_CODE_FIELD_NUMBER = 21;
    public static final int OWNER_ID_FIELD_NUMBER = 7;
    public static final int OWNER_NAME_FIELD_NUMBER = 19;
    public static final int PAID_AT_FIELD_NUMBER = 11;
    private static volatile KW4 PARSER = null;
    public static final int PAYED_PRICE_FIELD_NUMBER = 15;
    public static final int PHONE_NO_FIELD_NUMBER = 16;
    public static final int PIC_URL_FIELD_NUMBER = 3;
    public static final int PLATFORM_FIELD_NUMBER = 13;
    public static final int POSTAL_CODE_FIELD_NUMBER = 23;
    public static final int PRICE_PER_UNIT_FIELD_NUMBER = 17;
    public static final int SPOT_FIELD_NUMBER = 12;
    public static final int TITLE_FIELD_NUMBER = 2;
    public static final int TOTAL_PRICE_FIELD_NUMBER = 14;
    public static final int VIEW_COUNT_FIELD_NUMBER = 8;
    private int accountType_;
    private int clickCount_;
    private long createdAt_;
    private int ownerId_;
    private long paidAt_;
    private long payedPrice_;
    private int platform_;
    private int pricePerUnit_;
    private int spot_;
    private long totalPrice_;
    private int viewCount_;
    private String id_ = "";
    private String title_ = "";
    private String picUrl_ = "";
    private String description_ = "";
    private String link_ = "";
    private String linkTitle_ = "";
    private String phoneNo_ = "";
    private String ownerName_ = "";
    private String address_ = "";
    private String nationalCode_ = "";
    private String melliShenase_ = "";
    private String postalCode_ = "";
    private String name_ = "";
    private String fullName_ = "";

    public static final class a extends GeneratedMessageLite.b implements InterfaceC25071zh {
        private a() {
            super(AdvertisementStruct$PaidAdData.DEFAULT_INSTANCE);
        }
    }

    static {
        AdvertisementStruct$PaidAdData advertisementStruct$PaidAdData = new AdvertisementStruct$PaidAdData();
        DEFAULT_INSTANCE = advertisementStruct$PaidAdData;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementStruct$PaidAdData.class, advertisementStruct$PaidAdData);
    }

    private AdvertisementStruct$PaidAdData() {
    }

    private void clearAccountType() {
        this.accountType_ = 0;
    }

    private void clearAddress() {
        this.address_ = getDefaultInstance().getAddress();
    }

    private void clearClickCount() {
        this.clickCount_ = 0;
    }

    private void clearCreatedAt() {
        this.createdAt_ = 0L;
    }

    private void clearDescription() {
        this.description_ = getDefaultInstance().getDescription();
    }

    private void clearFullName() {
        this.fullName_ = getDefaultInstance().getFullName();
    }

    private void clearId() {
        this.id_ = getDefaultInstance().getId();
    }

    private void clearLink() {
        this.link_ = getDefaultInstance().getLink();
    }

    private void clearLinkTitle() {
        this.linkTitle_ = getDefaultInstance().getLinkTitle();
    }

    private void clearMelliShenase() {
        this.melliShenase_ = getDefaultInstance().getMelliShenase();
    }

    private void clearName() {
        this.name_ = getDefaultInstance().getName();
    }

    private void clearNationalCode() {
        this.nationalCode_ = getDefaultInstance().getNationalCode();
    }

    private void clearOwnerId() {
        this.ownerId_ = 0;
    }

    private void clearOwnerName() {
        this.ownerName_ = getDefaultInstance().getOwnerName();
    }

    private void clearPaidAt() {
        this.paidAt_ = 0L;
    }

    private void clearPayedPrice() {
        this.payedPrice_ = 0L;
    }

    private void clearPhoneNo() {
        this.phoneNo_ = getDefaultInstance().getPhoneNo();
    }

    private void clearPicUrl() {
        this.picUrl_ = getDefaultInstance().getPicUrl();
    }

    private void clearPlatform() {
        this.platform_ = 0;
    }

    private void clearPostalCode() {
        this.postalCode_ = getDefaultInstance().getPostalCode();
    }

    private void clearPricePerUnit() {
        this.pricePerUnit_ = 0;
    }

    private void clearSpot() {
        this.spot_ = 0;
    }

    private void clearTitle() {
        this.title_ = getDefaultInstance().getTitle();
    }

    private void clearTotalPrice() {
        this.totalPrice_ = 0L;
    }

    private void clearViewCount() {
        this.viewCount_ = 0;
    }

    public static AdvertisementStruct$PaidAdData getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AdvertisementStruct$PaidAdData parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementStruct$PaidAdData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementStruct$PaidAdData parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementStruct$PaidAdData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAccountType(EnumC24457yf enumC24457yf) {
        this.accountType_ = enumC24457yf.getNumber();
    }

    private void setAccountTypeValue(int i) {
        this.accountType_ = i;
    }

    private void setAddress(String str) {
        str.getClass();
        this.address_ = str;
    }

    private void setAddressBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.address_ = abstractC2383g.f0();
    }

    private void setClickCount(int i) {
        this.clickCount_ = i;
    }

    private void setCreatedAt(long j) {
        this.createdAt_ = j;
    }

    private void setDescription(String str) {
        str.getClass();
        this.description_ = str;
    }

    private void setDescriptionBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.description_ = abstractC2383g.f0();
    }

    private void setFullName(String str) {
        str.getClass();
        this.fullName_ = str;
    }

    private void setFullNameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.fullName_ = abstractC2383g.f0();
    }

    private void setId(String str) {
        str.getClass();
        this.id_ = str;
    }

    private void setIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.id_ = abstractC2383g.f0();
    }

    private void setLink(String str) {
        str.getClass();
        this.link_ = str;
    }

    private void setLinkBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.link_ = abstractC2383g.f0();
    }

    private void setLinkTitle(String str) {
        str.getClass();
        this.linkTitle_ = str;
    }

    private void setLinkTitleBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.linkTitle_ = abstractC2383g.f0();
    }

    private void setMelliShenase(String str) {
        str.getClass();
        this.melliShenase_ = str;
    }

    private void setMelliShenaseBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.melliShenase_ = abstractC2383g.f0();
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

    private void setOwnerId(int i) {
        this.ownerId_ = i;
    }

    private void setOwnerName(String str) {
        str.getClass();
        this.ownerName_ = str;
    }

    private void setOwnerNameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.ownerName_ = abstractC2383g.f0();
    }

    private void setPaidAt(long j) {
        this.paidAt_ = j;
    }

    private void setPayedPrice(long j) {
        this.payedPrice_ = j;
    }

    private void setPhoneNo(String str) {
        str.getClass();
        this.phoneNo_ = str;
    }

    private void setPhoneNoBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.phoneNo_ = abstractC2383g.f0();
    }

    private void setPicUrl(String str) {
        str.getClass();
        this.picUrl_ = str;
    }

    private void setPicUrlBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.picUrl_ = abstractC2383g.f0();
    }

    private void setPlatform(EnumC3771Ch enumC3771Ch) {
        this.platform_ = enumC3771Ch.getNumber();
    }

    private void setPlatformValue(int i) {
        this.platform_ = i;
    }

    private void setPostalCode(String str) {
        str.getClass();
        this.postalCode_ = str;
    }

    private void setPostalCodeBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.postalCode_ = abstractC2383g.f0();
    }

    private void setPricePerUnit(int i) {
        this.pricePerUnit_ = i;
    }

    private void setSpot(EnumC4938Hf enumC4938Hf) {
        this.spot_ = enumC4938Hf.getNumber();
    }

    private void setSpotValue(int i) {
        this.spot_ = i;
    }

    private void setTitle(String str) {
        str.getClass();
        this.title_ = str;
    }

    private void setTitleBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.title_ = abstractC2383g.f0();
    }

    private void setTotalPrice(long j) {
        this.totalPrice_ = j;
    }

    private void setViewCount(int i) {
        this.viewCount_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1843c.a[gVar.ordinal()]) {
            case 1:
                return new AdvertisementStruct$PaidAdData();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0019\u0000\u0000\u0001\u0019\u0019\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004Ȉ\u0005Ȉ\u0006Ȉ\u0007\u0004\b\u0004\t\u0004\n\u0002\u000b\u0002\f\f\r\f\u000e\u0002\u000f\u0002\u0010Ȉ\u0011\u0004\u0012\f\u0013Ȉ\u0014Ȉ\u0015Ȉ\u0016Ȉ\u0017Ȉ\u0018Ȉ\u0019Ȉ", new Object[]{"id_", "title_", "picUrl_", "description_", "link_", "linkTitle_", "ownerId_", "viewCount_", "clickCount_", "createdAt_", "paidAt_", "spot_", "platform_", "totalPrice_", "payedPrice_", "phoneNo_", "pricePerUnit_", "accountType_", "ownerName_", "address_", "nationalCode_", "melliShenase_", "postalCode_", "name_", "fullName_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementStruct$PaidAdData.class) {
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

    public EnumC24457yf getAccountType() {
        EnumC24457yf enumC24457yfJ = EnumC24457yf.j(this.accountType_);
        return enumC24457yfJ == null ? EnumC24457yf.UNRECOGNIZED : enumC24457yfJ;
    }

    public int getAccountTypeValue() {
        return this.accountType_;
    }

    public String getAddress() {
        return this.address_;
    }

    public AbstractC2383g getAddressBytes() {
        return AbstractC2383g.N(this.address_);
    }

    public int getClickCount() {
        return this.clickCount_;
    }

    public long getCreatedAt() {
        return this.createdAt_;
    }

    public String getDescription() {
        return this.description_;
    }

    public AbstractC2383g getDescriptionBytes() {
        return AbstractC2383g.N(this.description_);
    }

    public String getFullName() {
        return this.fullName_;
    }

    public AbstractC2383g getFullNameBytes() {
        return AbstractC2383g.N(this.fullName_);
    }

    public String getId() {
        return this.id_;
    }

    public AbstractC2383g getIdBytes() {
        return AbstractC2383g.N(this.id_);
    }

    public String getLink() {
        return this.link_;
    }

    public AbstractC2383g getLinkBytes() {
        return AbstractC2383g.N(this.link_);
    }

    public String getLinkTitle() {
        return this.linkTitle_;
    }

    public AbstractC2383g getLinkTitleBytes() {
        return AbstractC2383g.N(this.linkTitle_);
    }

    public String getMelliShenase() {
        return this.melliShenase_;
    }

    public AbstractC2383g getMelliShenaseBytes() {
        return AbstractC2383g.N(this.melliShenase_);
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

    public int getOwnerId() {
        return this.ownerId_;
    }

    public String getOwnerName() {
        return this.ownerName_;
    }

    public AbstractC2383g getOwnerNameBytes() {
        return AbstractC2383g.N(this.ownerName_);
    }

    public long getPaidAt() {
        return this.paidAt_;
    }

    public long getPayedPrice() {
        return this.payedPrice_;
    }

    public String getPhoneNo() {
        return this.phoneNo_;
    }

    public AbstractC2383g getPhoneNoBytes() {
        return AbstractC2383g.N(this.phoneNo_);
    }

    public String getPicUrl() {
        return this.picUrl_;
    }

    public AbstractC2383g getPicUrlBytes() {
        return AbstractC2383g.N(this.picUrl_);
    }

    public EnumC3771Ch getPlatform() {
        EnumC3771Ch enumC3771ChJ = EnumC3771Ch.j(this.platform_);
        return enumC3771ChJ == null ? EnumC3771Ch.UNRECOGNIZED : enumC3771ChJ;
    }

    public int getPlatformValue() {
        return this.platform_;
    }

    public String getPostalCode() {
        return this.postalCode_;
    }

    public AbstractC2383g getPostalCodeBytes() {
        return AbstractC2383g.N(this.postalCode_);
    }

    public int getPricePerUnit() {
        return this.pricePerUnit_;
    }

    public EnumC4938Hf getSpot() {
        EnumC4938Hf enumC4938HfJ = EnumC4938Hf.j(this.spot_);
        return enumC4938HfJ == null ? EnumC4938Hf.UNRECOGNIZED : enumC4938HfJ;
    }

    public int getSpotValue() {
        return this.spot_;
    }

    public String getTitle() {
        return this.title_;
    }

    public AbstractC2383g getTitleBytes() {
        return AbstractC2383g.N(this.title_);
    }

    public long getTotalPrice() {
        return this.totalPrice_;
    }

    public int getViewCount() {
        return this.viewCount_;
    }

    public static a newBuilder(AdvertisementStruct$PaidAdData advertisementStruct$PaidAdData) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementStruct$PaidAdData);
    }

    public static AdvertisementStruct$PaidAdData parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementStruct$PaidAdData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementStruct$PaidAdData parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementStruct$PaidAdData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementStruct$PaidAdData parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementStruct$PaidAdData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AdvertisementStruct$PaidAdData parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementStruct$PaidAdData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementStruct$PaidAdData parseFrom(byte[] bArr) {
        return (AdvertisementStruct$PaidAdData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementStruct$PaidAdData parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementStruct$PaidAdData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AdvertisementStruct$PaidAdData parseFrom(InputStream inputStream) {
        return (AdvertisementStruct$PaidAdData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementStruct$PaidAdData parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementStruct$PaidAdData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementStruct$PaidAdData parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementStruct$PaidAdData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementStruct$PaidAdData parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementStruct$PaidAdData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
