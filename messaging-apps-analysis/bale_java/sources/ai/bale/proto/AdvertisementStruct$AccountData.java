package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC14297hh;
import ir.nasim.EnumC23867xf;
import ir.nasim.EnumC24457yf;
import ir.nasim.EnumC24467yg;
import ir.nasim.EnumC9277Zg;
import ir.nasim.InterfaceC23277wf;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes8.dex */
public final class AdvertisementStruct$AccountData extends GeneratedMessageLite implements InterfaceC23277wf {
    public static final int ADDRESS_FIELD_NUMBER = 12;
    public static final int ALLOWED_CONCURRENT_CAMPAIGN_FIELD_NUMBER = 27;
    public static final int CAMPAIGN_CLICK_COEF_FIELD_NUMBER = 25;
    public static final int CAMPAIGN_DAILY_CAPACITY_FIELD_NUMBER = 26;
    public static final int CAMPAIGN_PACKAGE_TYPE_FIELD_NUMBER = 29;
    public static final int CAMPAIGN_VIEW_COEF_FIELD_NUMBER = 24;
    public static final int CHANGES_FILE_ID_FIELD_NUMBER = 15;
    public static final int CREATED_AT_FIELD_NUMBER = 5;
    public static final int CREDIT_EXPIRE_TIME_FIELD_NUMBER = 22;
    public static final int CREDIT_FIELD_NUMBER = 21;
    public static final int CREDIT_START_DATE_FIELD_NUMBER = 28;
    public static final int CUSTOMER_TYPE_FIELD_NUMBER = 30;
    private static final AdvertisementStruct$AccountData DEFAULT_INSTANCE;
    public static final int ECONOMIC_NUMBER_FIELD_NUMBER = 10;
    public static final int ESTABLISHMENT_FILE_ID_FIELD_NUMBER = 14;
    public static final int FEATURE_SCOPES_FIELD_NUMBER = 23;
    public static final int FULL_NAME_FIELD_NUMBER = 8;
    public static final int ID_FIELD_NUMBER = 1;
    public static final int LANDLINE_PHONE_FIELD_NUMBER = 20;
    public static final int NAME_FIELD_NUMBER = 3;
    public static final int NATIONAL_CODE_FIELD_NUMBER = 18;
    public static final int OWNER_ID_FIELD_NUMBER = 2;
    public static final int OWNER_NAME_FIELD_NUMBER = 7;
    private static volatile KW4 PARSER = null;
    public static final int PERMISSION_FILE_ID_FIELD_NUMBER = 16;
    public static final int PHONE_FIELD_NUMBER = 11;
    public static final int REASON_FIELD_NUMBER = 19;
    public static final int SHAHKAR_VALIDATED_FIELD_NUMBER = 17;
    public static final int SHENASE_MELLI_FIELD_NUMBER = 9;
    public static final int STATE_FIELD_NUMBER = 6;
    public static final int TYPE_FIELD_NUMBER = 4;
    public static final int ZIP_CODE_FIELD_NUMBER = 13;
    private static final B.h.a featureScopes_converter_ = new a();
    private int allowedConcurrentCampaign_;
    private int campaignClickCoef_;
    private long campaignDailyCapacity_;
    private int campaignPackageType_;
    private int campaignViewCoef_;
    private long changesFileId_;
    private long createdAt_;
    private long creditExpireTime_;
    private long creditStartDate_;
    private long credit_;
    private int customerType_;
    private long establishmentFileId_;
    private int featureScopesMemoizedSerializedSize;
    private int ownerId_;
    private long permissionFileId_;
    private boolean shahkarValidated_;
    private int state_;
    private int type_;
    private String id_ = "";
    private String name_ = "";
    private String ownerName_ = "";
    private String fullName_ = "";
    private String shenaseMelli_ = "";
    private String economicNumber_ = "";
    private String phone_ = "";
    private String address_ = "";
    private String zipCode_ = "";
    private String nationalCode_ = "";
    private String reason_ = "";
    private String landlinePhone_ = "";
    private B.g featureScopes_ = GeneratedMessageLite.emptyIntList();

    class a implements B.h.a {
        a() {
        }

        @Override // com.google.protobuf.B.h.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC14297hh a(Integer num) {
            EnumC14297hh enumC14297hhJ = EnumC14297hh.j(num.intValue());
            return enumC14297hhJ == null ? EnumC14297hh.UNRECOGNIZED : enumC14297hhJ;
        }
    }

    public static final class b extends GeneratedMessageLite.b implements InterfaceC23277wf {
        private b() {
            super(AdvertisementStruct$AccountData.DEFAULT_INSTANCE);
        }
    }

    static {
        AdvertisementStruct$AccountData advertisementStruct$AccountData = new AdvertisementStruct$AccountData();
        DEFAULT_INSTANCE = advertisementStruct$AccountData;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementStruct$AccountData.class, advertisementStruct$AccountData);
    }

    private AdvertisementStruct$AccountData() {
    }

    private void addAllFeatureScopes(Iterable<? extends EnumC14297hh> iterable) {
        ensureFeatureScopesIsMutable();
        Iterator<? extends EnumC14297hh> it = iterable.iterator();
        while (it.hasNext()) {
            this.featureScopes_.b1(it.next().getNumber());
        }
    }

    private void addAllFeatureScopesValue(Iterable<Integer> iterable) {
        ensureFeatureScopesIsMutable();
        Iterator<Integer> it = iterable.iterator();
        while (it.hasNext()) {
            this.featureScopes_.b1(it.next().intValue());
        }
    }

    private void addFeatureScopes(EnumC14297hh enumC14297hh) {
        enumC14297hh.getClass();
        ensureFeatureScopesIsMutable();
        this.featureScopes_.b1(enumC14297hh.getNumber());
    }

    private void addFeatureScopesValue(int i) {
        ensureFeatureScopesIsMutable();
        this.featureScopes_.b1(i);
    }

    private void clearAddress() {
        this.address_ = getDefaultInstance().getAddress();
    }

    private void clearAllowedConcurrentCampaign() {
        this.allowedConcurrentCampaign_ = 0;
    }

    private void clearCampaignClickCoef() {
        this.campaignClickCoef_ = 0;
    }

    private void clearCampaignDailyCapacity() {
        this.campaignDailyCapacity_ = 0L;
    }

    private void clearCampaignPackageType() {
        this.campaignPackageType_ = 0;
    }

    private void clearCampaignViewCoef() {
        this.campaignViewCoef_ = 0;
    }

    private void clearChangesFileId() {
        this.changesFileId_ = 0L;
    }

    private void clearCreatedAt() {
        this.createdAt_ = 0L;
    }

    private void clearCredit() {
        this.credit_ = 0L;
    }

    private void clearCreditExpireTime() {
        this.creditExpireTime_ = 0L;
    }

    private void clearCreditStartDate() {
        this.creditStartDate_ = 0L;
    }

    private void clearCustomerType() {
        this.customerType_ = 0;
    }

    private void clearEconomicNumber() {
        this.economicNumber_ = getDefaultInstance().getEconomicNumber();
    }

    private void clearEstablishmentFileId() {
        this.establishmentFileId_ = 0L;
    }

    private void clearFeatureScopes() {
        this.featureScopes_ = GeneratedMessageLite.emptyIntList();
    }

    private void clearFullName() {
        this.fullName_ = getDefaultInstance().getFullName();
    }

    private void clearId() {
        this.id_ = getDefaultInstance().getId();
    }

    private void clearLandlinePhone() {
        this.landlinePhone_ = getDefaultInstance().getLandlinePhone();
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

    private void clearPermissionFileId() {
        this.permissionFileId_ = 0L;
    }

    private void clearPhone() {
        this.phone_ = getDefaultInstance().getPhone();
    }

    private void clearReason() {
        this.reason_ = getDefaultInstance().getReason();
    }

    private void clearShahkarValidated() {
        this.shahkarValidated_ = false;
    }

    private void clearShenaseMelli() {
        this.shenaseMelli_ = getDefaultInstance().getShenaseMelli();
    }

    private void clearState() {
        this.state_ = 0;
    }

    private void clearType() {
        this.type_ = 0;
    }

    private void clearZipCode() {
        this.zipCode_ = getDefaultInstance().getZipCode();
    }

    private void ensureFeatureScopesIsMutable() {
        B.g gVar = this.featureScopes_;
        if (gVar.u()) {
            return;
        }
        this.featureScopes_ = GeneratedMessageLite.mutableCopy(gVar);
    }

    public static AdvertisementStruct$AccountData getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static b newBuilder() {
        return (b) DEFAULT_INSTANCE.createBuilder();
    }

    public static AdvertisementStruct$AccountData parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementStruct$AccountData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementStruct$AccountData parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementStruct$AccountData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
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

    private void setAllowedConcurrentCampaign(int i) {
        this.allowedConcurrentCampaign_ = i;
    }

    private void setCampaignClickCoef(int i) {
        this.campaignClickCoef_ = i;
    }

    private void setCampaignDailyCapacity(long j) {
        this.campaignDailyCapacity_ = j;
    }

    private void setCampaignPackageType(EnumC24467yg enumC24467yg) {
        this.campaignPackageType_ = enumC24467yg.getNumber();
    }

    private void setCampaignPackageTypeValue(int i) {
        this.campaignPackageType_ = i;
    }

    private void setCampaignViewCoef(int i) {
        this.campaignViewCoef_ = i;
    }

    private void setChangesFileId(long j) {
        this.changesFileId_ = j;
    }

    private void setCreatedAt(long j) {
        this.createdAt_ = j;
    }

    private void setCredit(long j) {
        this.credit_ = j;
    }

    private void setCreditExpireTime(long j) {
        this.creditExpireTime_ = j;
    }

    private void setCreditStartDate(long j) {
        this.creditStartDate_ = j;
    }

    private void setCustomerType(EnumC9277Zg enumC9277Zg) {
        this.customerType_ = enumC9277Zg.getNumber();
    }

    private void setCustomerTypeValue(int i) {
        this.customerType_ = i;
    }

    private void setEconomicNumber(String str) {
        str.getClass();
        this.economicNumber_ = str;
    }

    private void setEconomicNumberBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.economicNumber_ = abstractC2383g.f0();
    }

    private void setEstablishmentFileId(long j) {
        this.establishmentFileId_ = j;
    }

    private void setFeatureScopes(int i, EnumC14297hh enumC14297hh) {
        enumC14297hh.getClass();
        ensureFeatureScopesIsMutable();
        this.featureScopes_.U(i, enumC14297hh.getNumber());
    }

    private void setFeatureScopesValue(int i, int i2) {
        ensureFeatureScopesIsMutable();
        this.featureScopes_.U(i, i2);
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

    private void setLandlinePhone(String str) {
        str.getClass();
        this.landlinePhone_ = str;
    }

    private void setLandlinePhoneBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.landlinePhone_ = abstractC2383g.f0();
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

    private void setPermissionFileId(long j) {
        this.permissionFileId_ = j;
    }

    private void setPhone(String str) {
        str.getClass();
        this.phone_ = str;
    }

    private void setPhoneBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.phone_ = abstractC2383g.f0();
    }

    private void setReason(String str) {
        str.getClass();
        this.reason_ = str;
    }

    private void setReasonBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.reason_ = abstractC2383g.f0();
    }

    private void setShahkarValidated(boolean z) {
        this.shahkarValidated_ = z;
    }

    private void setShenaseMelli(String str) {
        str.getClass();
        this.shenaseMelli_ = str;
    }

    private void setShenaseMelliBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.shenaseMelli_ = abstractC2383g.f0();
    }

    private void setState(EnumC23867xf enumC23867xf) {
        this.state_ = enumC23867xf.getNumber();
    }

    private void setStateValue(int i) {
        this.state_ = i;
    }

    private void setType(EnumC24457yf enumC24457yf) {
        this.type_ = enumC24457yf.getNumber();
    }

    private void setTypeValue(int i) {
        this.type_ = i;
    }

    private void setZipCode(String str) {
        str.getClass();
        this.zipCode_ = str;
    }

    private void setZipCodeBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.zipCode_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1843c.a[gVar.ordinal()]) {
            case 1:
                return new AdvertisementStruct$AccountData();
            case 2:
                return new b();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u001e\u0000\u0000\u0001\u001e\u001e\u0000\u0001\u0000\u0001Ȉ\u0002\u0004\u0003Ȉ\u0004\f\u0005\u0002\u0006\f\u0007Ȉ\bȈ\tȈ\nȈ\u000bȈ\fȈ\rȈ\u000e\u0002\u000f\u0002\u0010\u0002\u0011\u0007\u0012Ȉ\u0013Ȉ\u0014Ȉ\u0015\u0002\u0016\u0002\u0017,\u0018\u0004\u0019\u0004\u001a\u0002\u001b\u0004\u001c\u0002\u001d\f\u001e\f", new Object[]{"id_", "ownerId_", "name_", "type_", "createdAt_", "state_", "ownerName_", "fullName_", "shenaseMelli_", "economicNumber_", "phone_", "address_", "zipCode_", "establishmentFileId_", "changesFileId_", "permissionFileId_", "shahkarValidated_", "nationalCode_", "reason_", "landlinePhone_", "credit_", "creditExpireTime_", "featureScopes_", "campaignViewCoef_", "campaignClickCoef_", "campaignDailyCapacity_", "allowedConcurrentCampaign_", "creditStartDate_", "campaignPackageType_", "customerType_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementStruct$AccountData.class) {
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

    public int getAllowedConcurrentCampaign() {
        return this.allowedConcurrentCampaign_;
    }

    public int getCampaignClickCoef() {
        return this.campaignClickCoef_;
    }

    public long getCampaignDailyCapacity() {
        return this.campaignDailyCapacity_;
    }

    public EnumC24467yg getCampaignPackageType() {
        EnumC24467yg enumC24467ygJ = EnumC24467yg.j(this.campaignPackageType_);
        return enumC24467ygJ == null ? EnumC24467yg.UNRECOGNIZED : enumC24467ygJ;
    }

    public int getCampaignPackageTypeValue() {
        return this.campaignPackageType_;
    }

    public int getCampaignViewCoef() {
        return this.campaignViewCoef_;
    }

    public long getChangesFileId() {
        return this.changesFileId_;
    }

    public long getCreatedAt() {
        return this.createdAt_;
    }

    public long getCredit() {
        return this.credit_;
    }

    public long getCreditExpireTime() {
        return this.creditExpireTime_;
    }

    public long getCreditStartDate() {
        return this.creditStartDate_;
    }

    public EnumC9277Zg getCustomerType() {
        EnumC9277Zg enumC9277ZgJ = EnumC9277Zg.j(this.customerType_);
        return enumC9277ZgJ == null ? EnumC9277Zg.UNRECOGNIZED : enumC9277ZgJ;
    }

    public int getCustomerTypeValue() {
        return this.customerType_;
    }

    public String getEconomicNumber() {
        return this.economicNumber_;
    }

    public AbstractC2383g getEconomicNumberBytes() {
        return AbstractC2383g.N(this.economicNumber_);
    }

    public long getEstablishmentFileId() {
        return this.establishmentFileId_;
    }

    public EnumC14297hh getFeatureScopes(int i) {
        EnumC14297hh enumC14297hhJ = EnumC14297hh.j(this.featureScopes_.getInt(i));
        return enumC14297hhJ == null ? EnumC14297hh.UNRECOGNIZED : enumC14297hhJ;
    }

    public int getFeatureScopesCount() {
        return this.featureScopes_.size();
    }

    public List<EnumC14297hh> getFeatureScopesList() {
        return new B.h(this.featureScopes_, featureScopes_converter_);
    }

    public int getFeatureScopesValue(int i) {
        return this.featureScopes_.getInt(i);
    }

    public List<Integer> getFeatureScopesValueList() {
        return this.featureScopes_;
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

    public String getLandlinePhone() {
        return this.landlinePhone_;
    }

    public AbstractC2383g getLandlinePhoneBytes() {
        return AbstractC2383g.N(this.landlinePhone_);
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

    public long getPermissionFileId() {
        return this.permissionFileId_;
    }

    public String getPhone() {
        return this.phone_;
    }

    public AbstractC2383g getPhoneBytes() {
        return AbstractC2383g.N(this.phone_);
    }

    public String getReason() {
        return this.reason_;
    }

    public AbstractC2383g getReasonBytes() {
        return AbstractC2383g.N(this.reason_);
    }

    public boolean getShahkarValidated() {
        return this.shahkarValidated_;
    }

    public String getShenaseMelli() {
        return this.shenaseMelli_;
    }

    public AbstractC2383g getShenaseMelliBytes() {
        return AbstractC2383g.N(this.shenaseMelli_);
    }

    public EnumC23867xf getState() {
        EnumC23867xf enumC23867xfJ = EnumC23867xf.j(this.state_);
        return enumC23867xfJ == null ? EnumC23867xf.UNRECOGNIZED : enumC23867xfJ;
    }

    public int getStateValue() {
        return this.state_;
    }

    public EnumC24457yf getType() {
        EnumC24457yf enumC24457yfJ = EnumC24457yf.j(this.type_);
        return enumC24457yfJ == null ? EnumC24457yf.UNRECOGNIZED : enumC24457yfJ;
    }

    public int getTypeValue() {
        return this.type_;
    }

    public String getZipCode() {
        return this.zipCode_;
    }

    public AbstractC2383g getZipCodeBytes() {
        return AbstractC2383g.N(this.zipCode_);
    }

    public static b newBuilder(AdvertisementStruct$AccountData advertisementStruct$AccountData) {
        return (b) DEFAULT_INSTANCE.createBuilder(advertisementStruct$AccountData);
    }

    public static AdvertisementStruct$AccountData parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementStruct$AccountData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementStruct$AccountData parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementStruct$AccountData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementStruct$AccountData parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementStruct$AccountData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AdvertisementStruct$AccountData parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementStruct$AccountData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementStruct$AccountData parseFrom(byte[] bArr) {
        return (AdvertisementStruct$AccountData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementStruct$AccountData parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementStruct$AccountData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AdvertisementStruct$AccountData parseFrom(InputStream inputStream) {
        return (AdvertisementStruct$AccountData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementStruct$AccountData parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementStruct$AccountData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementStruct$AccountData parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementStruct$AccountData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementStruct$AccountData parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementStruct$AccountData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
