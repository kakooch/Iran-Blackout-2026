package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC13696gg;
import ir.nasim.EnumC15487jg;
import ir.nasim.EnumC16078kg;
import ir.nasim.InterfaceC14897ig;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes8.dex */
public final class AdvertisementStruct$BonusCodeData extends GeneratedMessageLite implements InterfaceC14897ig {
    public static final int AD_ID_FIELD_NUMBER = 6;
    public static final int ALLOWED_USERS_FIELD_NUMBER = 11;
    public static final int AUDIENCE_ID_FIELD_NUMBER = 18;
    public static final int CODE_FIELD_NUMBER = 3;
    public static final int CONDITION_FIELD_NUMBER = 14;
    public static final int CREATE_TIME_FIELD_NUMBER = 7;
    private static final AdvertisementStruct$BonusCodeData DEFAULT_INSTANCE;
    public static final int DISCOUNT_CELLING_FIELD_NUMBER = 20;
    public static final int DOES_EXPIRE_FIELD_NUMBER = 13;
    public static final int EXP_DATE_FIELD_NUMBER = 9;
    public static final int ID_FIELD_NUMBER = 1;
    public static final int IS_SPECIAL_FIELD_NUMBER = 10;
    public static final int MAX_MEMBER_COUNT_FIELD_NUMBER = 19;
    public static final int OWNER_ID_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int PRICE_THRESHOLD_FIELD_NUMBER = 15;
    public static final int STATE_FIELD_NUMBER = 8;
    public static final int TIME_PERIOD_BEGIN_FIELD_NUMBER = 16;
    public static final int TIME_PERIOD_END_FIELD_NUMBER = 17;
    public static final int TYPE_FIELD_NUMBER = 4;
    public static final int USE_COUNTS_FIELD_NUMBER = 12;
    public static final int VALUE_FIELD_NUMBER = 5;
    private int audienceId_;
    private int condition_;
    private long createTime_;
    private long discountCelling_;
    private boolean doesExpire_;
    private long expDate_;
    private boolean isSpecial_;
    private int maxMemberCount_;
    private int ownerId_;
    private long priceThreshold_;
    private int state_;
    private long timePeriodBegin_;
    private long timePeriodEnd_;
    private int type_;
    private int useCounts_;
    private int value_;
    private int allowedUsersMemoizedSerializedSize = -1;
    private String id_ = "";
    private String code_ = "";
    private String adId_ = "";
    private B.g allowedUsers_ = GeneratedMessageLite.emptyIntList();

    public static final class a extends GeneratedMessageLite.b implements InterfaceC14897ig {
        private a() {
            super(AdvertisementStruct$BonusCodeData.DEFAULT_INSTANCE);
        }
    }

    static {
        AdvertisementStruct$BonusCodeData advertisementStruct$BonusCodeData = new AdvertisementStruct$BonusCodeData();
        DEFAULT_INSTANCE = advertisementStruct$BonusCodeData;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementStruct$BonusCodeData.class, advertisementStruct$BonusCodeData);
    }

    private AdvertisementStruct$BonusCodeData() {
    }

    private void addAllAllowedUsers(Iterable<? extends Integer> iterable) {
        ensureAllowedUsersIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.allowedUsers_);
    }

    private void addAllowedUsers(int i) {
        ensureAllowedUsersIsMutable();
        this.allowedUsers_.b1(i);
    }

    private void clearAdId() {
        this.adId_ = getDefaultInstance().getAdId();
    }

    private void clearAllowedUsers() {
        this.allowedUsers_ = GeneratedMessageLite.emptyIntList();
    }

    private void clearAudienceId() {
        this.audienceId_ = 0;
    }

    private void clearCode() {
        this.code_ = getDefaultInstance().getCode();
    }

    private void clearCondition() {
        this.condition_ = 0;
    }

    private void clearCreateTime() {
        this.createTime_ = 0L;
    }

    private void clearDiscountCelling() {
        this.discountCelling_ = 0L;
    }

    private void clearDoesExpire() {
        this.doesExpire_ = false;
    }

    private void clearExpDate() {
        this.expDate_ = 0L;
    }

    private void clearId() {
        this.id_ = getDefaultInstance().getId();
    }

    private void clearIsSpecial() {
        this.isSpecial_ = false;
    }

    private void clearMaxMemberCount() {
        this.maxMemberCount_ = 0;
    }

    private void clearOwnerId() {
        this.ownerId_ = 0;
    }

    private void clearPriceThreshold() {
        this.priceThreshold_ = 0L;
    }

    private void clearState() {
        this.state_ = 0;
    }

    private void clearTimePeriodBegin() {
        this.timePeriodBegin_ = 0L;
    }

    private void clearTimePeriodEnd() {
        this.timePeriodEnd_ = 0L;
    }

    private void clearType() {
        this.type_ = 0;
    }

    private void clearUseCounts() {
        this.useCounts_ = 0;
    }

    private void clearValue() {
        this.value_ = 0;
    }

    private void ensureAllowedUsersIsMutable() {
        B.g gVar = this.allowedUsers_;
        if (gVar.u()) {
            return;
        }
        this.allowedUsers_ = GeneratedMessageLite.mutableCopy(gVar);
    }

    public static AdvertisementStruct$BonusCodeData getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AdvertisementStruct$BonusCodeData parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementStruct$BonusCodeData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementStruct$BonusCodeData parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementStruct$BonusCodeData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAdId(String str) {
        str.getClass();
        this.adId_ = str;
    }

    private void setAdIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.adId_ = abstractC2383g.f0();
    }

    private void setAllowedUsers(int i, int i2) {
        ensureAllowedUsersIsMutable();
        this.allowedUsers_.U(i, i2);
    }

    private void setAudienceId(int i) {
        this.audienceId_ = i;
    }

    private void setCode(String str) {
        str.getClass();
        this.code_ = str;
    }

    private void setCodeBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.code_ = abstractC2383g.f0();
    }

    private void setCondition(EnumC13696gg enumC13696gg) {
        this.condition_ = enumC13696gg.getNumber();
    }

    private void setConditionValue(int i) {
        this.condition_ = i;
    }

    private void setCreateTime(long j) {
        this.createTime_ = j;
    }

    private void setDiscountCelling(long j) {
        this.discountCelling_ = j;
    }

    private void setDoesExpire(boolean z) {
        this.doesExpire_ = z;
    }

    private void setExpDate(long j) {
        this.expDate_ = j;
    }

    private void setId(String str) {
        str.getClass();
        this.id_ = str;
    }

    private void setIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.id_ = abstractC2383g.f0();
    }

    private void setIsSpecial(boolean z) {
        this.isSpecial_ = z;
    }

    private void setMaxMemberCount(int i) {
        this.maxMemberCount_ = i;
    }

    private void setOwnerId(int i) {
        this.ownerId_ = i;
    }

    private void setPriceThreshold(long j) {
        this.priceThreshold_ = j;
    }

    private void setState(EnumC15487jg enumC15487jg) {
        this.state_ = enumC15487jg.getNumber();
    }

    private void setStateValue(int i) {
        this.state_ = i;
    }

    private void setTimePeriodBegin(long j) {
        this.timePeriodBegin_ = j;
    }

    private void setTimePeriodEnd(long j) {
        this.timePeriodEnd_ = j;
    }

    private void setType(EnumC16078kg enumC16078kg) {
        this.type_ = enumC16078kg.getNumber();
    }

    private void setTypeValue(int i) {
        this.type_ = i;
    }

    private void setUseCounts(int i) {
        this.useCounts_ = i;
    }

    private void setValue(int i) {
        this.value_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1843c.a[gVar.ordinal()]) {
            case 1:
                return new AdvertisementStruct$BonusCodeData();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0014\u0000\u0000\u0001\u0014\u0014\u0000\u0001\u0000\u0001Ȉ\u0002\u0004\u0003Ȉ\u0004\f\u0005\u0004\u0006Ȉ\u0007\u0002\b\f\t\u0002\n\u0007\u000b'\f\u0004\r\u0007\u000e\f\u000f\u0002\u0010\u0002\u0011\u0002\u0012\u0004\u0013\u0004\u0014\u0002", new Object[]{"id_", "ownerId_", "code_", "type_", "value_", "adId_", "createTime_", "state_", "expDate_", "isSpecial_", "allowedUsers_", "useCounts_", "doesExpire_", "condition_", "priceThreshold_", "timePeriodBegin_", "timePeriodEnd_", "audienceId_", "maxMemberCount_", "discountCelling_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementStruct$BonusCodeData.class) {
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

    public String getAdId() {
        return this.adId_;
    }

    public AbstractC2383g getAdIdBytes() {
        return AbstractC2383g.N(this.adId_);
    }

    public int getAllowedUsers(int i) {
        return this.allowedUsers_.getInt(i);
    }

    public int getAllowedUsersCount() {
        return this.allowedUsers_.size();
    }

    public List<Integer> getAllowedUsersList() {
        return this.allowedUsers_;
    }

    public int getAudienceId() {
        return this.audienceId_;
    }

    public String getCode() {
        return this.code_;
    }

    public AbstractC2383g getCodeBytes() {
        return AbstractC2383g.N(this.code_);
    }

    public EnumC13696gg getCondition() {
        EnumC13696gg enumC13696ggJ = EnumC13696gg.j(this.condition_);
        return enumC13696ggJ == null ? EnumC13696gg.UNRECOGNIZED : enumC13696ggJ;
    }

    public int getConditionValue() {
        return this.condition_;
    }

    public long getCreateTime() {
        return this.createTime_;
    }

    public long getDiscountCelling() {
        return this.discountCelling_;
    }

    public boolean getDoesExpire() {
        return this.doesExpire_;
    }

    public long getExpDate() {
        return this.expDate_;
    }

    public String getId() {
        return this.id_;
    }

    public AbstractC2383g getIdBytes() {
        return AbstractC2383g.N(this.id_);
    }

    public boolean getIsSpecial() {
        return this.isSpecial_;
    }

    public int getMaxMemberCount() {
        return this.maxMemberCount_;
    }

    public int getOwnerId() {
        return this.ownerId_;
    }

    public long getPriceThreshold() {
        return this.priceThreshold_;
    }

    public EnumC15487jg getState() {
        EnumC15487jg enumC15487jgJ = EnumC15487jg.j(this.state_);
        return enumC15487jgJ == null ? EnumC15487jg.UNRECOGNIZED : enumC15487jgJ;
    }

    public int getStateValue() {
        return this.state_;
    }

    public long getTimePeriodBegin() {
        return this.timePeriodBegin_;
    }

    public long getTimePeriodEnd() {
        return this.timePeriodEnd_;
    }

    public EnumC16078kg getType() {
        EnumC16078kg enumC16078kgJ = EnumC16078kg.j(this.type_);
        return enumC16078kgJ == null ? EnumC16078kg.UNRECOGNIZED : enumC16078kgJ;
    }

    public int getTypeValue() {
        return this.type_;
    }

    public int getUseCounts() {
        return this.useCounts_;
    }

    public int getValue() {
        return this.value_;
    }

    public static a newBuilder(AdvertisementStruct$BonusCodeData advertisementStruct$BonusCodeData) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementStruct$BonusCodeData);
    }

    public static AdvertisementStruct$BonusCodeData parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementStruct$BonusCodeData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementStruct$BonusCodeData parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementStruct$BonusCodeData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementStruct$BonusCodeData parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementStruct$BonusCodeData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AdvertisementStruct$BonusCodeData parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementStruct$BonusCodeData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementStruct$BonusCodeData parseFrom(byte[] bArr) {
        return (AdvertisementStruct$BonusCodeData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementStruct$BonusCodeData parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementStruct$BonusCodeData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AdvertisementStruct$BonusCodeData parseFrom(InputStream inputStream) {
        return (AdvertisementStruct$BonusCodeData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementStruct$BonusCodeData parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementStruct$BonusCodeData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementStruct$BonusCodeData parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementStruct$BonusCodeData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementStruct$BonusCodeData parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementStruct$BonusCodeData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
