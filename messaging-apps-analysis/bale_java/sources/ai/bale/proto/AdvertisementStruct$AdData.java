package ai.bale.proto;

import ai.bale.proto.AdvertisementStruct$AdTargeting;
import ai.bale.proto.AdvertisementStruct$SponsoredMessageOption;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC3771Ch;
import ir.nasim.EnumC4704Gf;
import ir.nasim.EnumC4938Hf;
import ir.nasim.EnumC5640Kf;
import ir.nasim.EnumC6346Nf;
import ir.nasim.InterfaceC4455Ff;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes8.dex */
public final class AdvertisementStruct$AdData extends GeneratedMessageLite implements InterfaceC4455Ff {
    public static final int AUTO_FINISH_FIELD_NUMBER = 19;
    public static final int CLICK_COUNT_FIELD_NUMBER = 9;
    public static final int CREATED_AT_FIELD_NUMBER = 10;
    private static final AdvertisementStruct$AdData DEFAULT_INSTANCE;
    public static final int DESCRIPTION_FIELD_NUMBER = 4;
    public static final int DESIRED_START_TIME_FIELD_NUMBER = 11;
    public static final int DISCOUNT_CODE_FIELD_NUMBER = 22;
    public static final int FINISH_TIME_FIELD_NUMBER = 13;
    public static final int ID_FIELD_NUMBER = 1;
    public static final int IS_INSTANT_FIELD_NUMBER = 30;
    public static final int IS_ONLY_TARGETED_FIELD_NUMBER = 33;
    public static final int LINK_FIELD_NUMBER = 5;
    public static final int LINK_TITLE_FIELD_NUMBER = 6;
    public static final int OWNER_ID_FIELD_NUMBER = 7;
    public static final int OWNER_TYPE_FIELD_NUMBER = 29;
    private static volatile KW4 PARSER = null;
    public static final int PAYED_PRICE_FIELD_NUMBER = 24;
    public static final int PHONE_NO_FIELD_NUMBER = 25;
    public static final int PIC_URL_FIELD_NUMBER = 3;
    public static final int PLATFORM_FIELD_NUMBER = 16;
    public static final int REJECTION_REASON_FIELD_NUMBER = 18;
    public static final int SET_CLICK_FIELD_NUMBER = 21;
    public static final int SET_VIEW_FIELD_NUMBER = 20;
    public static final int SPONSORED_MESSAGE_OPTION_FIELD_NUMBER = 26;
    public static final int SPOT_FIELD_NUMBER = 15;
    public static final int START_TIME_FIELD_NUMBER = 12;
    public static final int STATE_FIELD_NUMBER = 14;
    public static final int TAG1_FIELD_NUMBER = 27;
    public static final int TAG2_FIELD_NUMBER = 28;
    public static final int TARGETING_FIELD_NUMBER = 34;
    public static final int TARGET_IDS_FIELD_NUMBER = 32;
    public static final int TARGET_TYPE_FIELD_NUMBER = 31;
    public static final int TITLE_FIELD_NUMBER = 2;
    public static final int TOPIC_FIELD_NUMBER = 17;
    public static final int TOTAL_PRICE_FIELD_NUMBER = 23;
    public static final int VIEW_COUNT_FIELD_NUMBER = 8;
    private boolean autoFinish_;
    private int bitField0_;
    private int clickCount_;
    private long createdAt_;
    private long desiredStartTime_;
    private long finishTime_;
    private boolean isInstant_;
    private boolean isOnlyTargeted_;
    private int ownerId_;
    private int ownerType_;
    private long payedPrice_;
    private int platform_;
    private int setClick_;
    private int setView_;
    private AdvertisementStruct$SponsoredMessageOption sponsoredMessageOption_;
    private int spot_;
    private long startTime_;
    private int state_;
    private int tag1_;
    private int tag2_;
    private int targetType_;
    private AdvertisementStruct$AdTargeting targeting_;
    private int topic_;
    private long totalPrice_;
    private int viewCount_;
    private int targetIdsMemoizedSerializedSize = -1;
    private String id_ = "";
    private String title_ = "";
    private String picUrl_ = "";
    private String description_ = "";
    private String link_ = "";
    private String linkTitle_ = "";
    private String rejectionReason_ = "";
    private String discountCode_ = "";
    private String phoneNo_ = "";
    private B.g targetIds_ = GeneratedMessageLite.emptyIntList();

    public static final class a extends GeneratedMessageLite.b implements InterfaceC4455Ff {
        private a() {
            super(AdvertisementStruct$AdData.DEFAULT_INSTANCE);
        }
    }

    static {
        AdvertisementStruct$AdData advertisementStruct$AdData = new AdvertisementStruct$AdData();
        DEFAULT_INSTANCE = advertisementStruct$AdData;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementStruct$AdData.class, advertisementStruct$AdData);
    }

    private AdvertisementStruct$AdData() {
    }

    private void addAllTargetIds(Iterable<? extends Integer> iterable) {
        ensureTargetIdsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.targetIds_);
    }

    private void addTargetIds(int i) {
        ensureTargetIdsIsMutable();
        this.targetIds_.b1(i);
    }

    private void clearAutoFinish() {
        this.autoFinish_ = false;
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

    private void clearDesiredStartTime() {
        this.desiredStartTime_ = 0L;
    }

    private void clearDiscountCode() {
        this.discountCode_ = getDefaultInstance().getDiscountCode();
    }

    private void clearFinishTime() {
        this.finishTime_ = 0L;
    }

    private void clearId() {
        this.id_ = getDefaultInstance().getId();
    }

    private void clearIsInstant() {
        this.isInstant_ = false;
    }

    private void clearIsOnlyTargeted() {
        this.isOnlyTargeted_ = false;
    }

    private void clearLink() {
        this.link_ = getDefaultInstance().getLink();
    }

    private void clearLinkTitle() {
        this.linkTitle_ = getDefaultInstance().getLinkTitle();
    }

    private void clearOwnerId() {
        this.ownerId_ = 0;
    }

    private void clearOwnerType() {
        this.ownerType_ = 0;
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

    private void clearRejectionReason() {
        this.rejectionReason_ = getDefaultInstance().getRejectionReason();
    }

    private void clearSetClick() {
        this.setClick_ = 0;
    }

    private void clearSetView() {
        this.setView_ = 0;
    }

    private void clearSponsoredMessageOption() {
        this.sponsoredMessageOption_ = null;
        this.bitField0_ &= -2;
    }

    private void clearSpot() {
        this.spot_ = 0;
    }

    private void clearStartTime() {
        this.startTime_ = 0L;
    }

    private void clearState() {
        this.state_ = 0;
    }

    private void clearTag1() {
        this.tag1_ = 0;
    }

    private void clearTag2() {
        this.tag2_ = 0;
    }

    private void clearTargetIds() {
        this.targetIds_ = GeneratedMessageLite.emptyIntList();
    }

    private void clearTargetType() {
        this.targetType_ = 0;
    }

    private void clearTargeting() {
        this.targeting_ = null;
        this.bitField0_ &= -3;
    }

    private void clearTitle() {
        this.title_ = getDefaultInstance().getTitle();
    }

    private void clearTopic() {
        this.topic_ = 0;
    }

    private void clearTotalPrice() {
        this.totalPrice_ = 0L;
    }

    private void clearViewCount() {
        this.viewCount_ = 0;
    }

    private void ensureTargetIdsIsMutable() {
        B.g gVar = this.targetIds_;
        if (gVar.u()) {
            return;
        }
        this.targetIds_ = GeneratedMessageLite.mutableCopy(gVar);
    }

    public static AdvertisementStruct$AdData getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeSponsoredMessageOption(AdvertisementStruct$SponsoredMessageOption advertisementStruct$SponsoredMessageOption) {
        advertisementStruct$SponsoredMessageOption.getClass();
        AdvertisementStruct$SponsoredMessageOption advertisementStruct$SponsoredMessageOption2 = this.sponsoredMessageOption_;
        if (advertisementStruct$SponsoredMessageOption2 == null || advertisementStruct$SponsoredMessageOption2 == AdvertisementStruct$SponsoredMessageOption.getDefaultInstance()) {
            this.sponsoredMessageOption_ = advertisementStruct$SponsoredMessageOption;
        } else {
            this.sponsoredMessageOption_ = (AdvertisementStruct$SponsoredMessageOption) ((AdvertisementStruct$SponsoredMessageOption.a) AdvertisementStruct$SponsoredMessageOption.newBuilder(this.sponsoredMessageOption_).v(advertisementStruct$SponsoredMessageOption)).j();
        }
        this.bitField0_ |= 1;
    }

    private void mergeTargeting(AdvertisementStruct$AdTargeting advertisementStruct$AdTargeting) {
        advertisementStruct$AdTargeting.getClass();
        AdvertisementStruct$AdTargeting advertisementStruct$AdTargeting2 = this.targeting_;
        if (advertisementStruct$AdTargeting2 == null || advertisementStruct$AdTargeting2 == AdvertisementStruct$AdTargeting.getDefaultInstance()) {
            this.targeting_ = advertisementStruct$AdTargeting;
        } else {
            this.targeting_ = (AdvertisementStruct$AdTargeting) ((AdvertisementStruct$AdTargeting.a) AdvertisementStruct$AdTargeting.newBuilder(this.targeting_).v(advertisementStruct$AdTargeting)).j();
        }
        this.bitField0_ |= 2;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AdvertisementStruct$AdData parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementStruct$AdData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementStruct$AdData parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementStruct$AdData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAutoFinish(boolean z) {
        this.autoFinish_ = z;
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

    private void setDesiredStartTime(long j) {
        this.desiredStartTime_ = j;
    }

    private void setDiscountCode(String str) {
        str.getClass();
        this.discountCode_ = str;
    }

    private void setDiscountCodeBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.discountCode_ = abstractC2383g.f0();
    }

    private void setFinishTime(long j) {
        this.finishTime_ = j;
    }

    private void setId(String str) {
        str.getClass();
        this.id_ = str;
    }

    private void setIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.id_ = abstractC2383g.f0();
    }

    private void setIsInstant(boolean z) {
        this.isInstant_ = z;
    }

    private void setIsOnlyTargeted(boolean z) {
        this.isOnlyTargeted_ = z;
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

    private void setOwnerId(int i) {
        this.ownerId_ = i;
    }

    private void setOwnerType(EnumC4704Gf enumC4704Gf) {
        this.ownerType_ = enumC4704Gf.getNumber();
    }

    private void setOwnerTypeValue(int i) {
        this.ownerType_ = i;
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

    private void setRejectionReason(String str) {
        str.getClass();
        this.rejectionReason_ = str;
    }

    private void setRejectionReasonBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.rejectionReason_ = abstractC2383g.f0();
    }

    private void setSetClick(int i) {
        this.setClick_ = i;
    }

    private void setSetView(int i) {
        this.setView_ = i;
    }

    private void setSponsoredMessageOption(AdvertisementStruct$SponsoredMessageOption advertisementStruct$SponsoredMessageOption) {
        advertisementStruct$SponsoredMessageOption.getClass();
        this.sponsoredMessageOption_ = advertisementStruct$SponsoredMessageOption;
        this.bitField0_ |= 1;
    }

    private void setSpot(EnumC4938Hf enumC4938Hf) {
        this.spot_ = enumC4938Hf.getNumber();
    }

    private void setSpotValue(int i) {
        this.spot_ = i;
    }

    private void setStartTime(long j) {
        this.startTime_ = j;
    }

    private void setState(EnumC5640Kf enumC5640Kf) {
        this.state_ = enumC5640Kf.getNumber();
    }

    private void setStateValue(int i) {
        this.state_ = i;
    }

    private void setTag1(int i) {
        this.tag1_ = i;
    }

    private void setTag2(int i) {
        this.tag2_ = i;
    }

    private void setTargetIds(int i, int i2) {
        ensureTargetIdsIsMutable();
        this.targetIds_.U(i, i2);
    }

    private void setTargetType(EnumC6346Nf enumC6346Nf) {
        this.targetType_ = enumC6346Nf.getNumber();
    }

    private void setTargetTypeValue(int i) {
        this.targetType_ = i;
    }

    private void setTargeting(AdvertisementStruct$AdTargeting advertisementStruct$AdTargeting) {
        advertisementStruct$AdTargeting.getClass();
        this.targeting_ = advertisementStruct$AdTargeting;
        this.bitField0_ |= 2;
    }

    private void setTitle(String str) {
        str.getClass();
        this.title_ = str;
    }

    private void setTitleBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.title_ = abstractC2383g.f0();
    }

    private void setTopic(int i) {
        this.topic_ = i;
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
                return new AdvertisementStruct$AdData();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\"\u0000\u0001\u0001\"\"\u0000\u0001\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004Ȉ\u0005Ȉ\u0006Ȉ\u0007\u0004\b\u0004\t\u0004\n\u0002\u000b\u0002\f\u0002\r\u0002\u000e\f\u000f\f\u0010\f\u0011\u0004\u0012Ȉ\u0013\u0007\u0014\u0004\u0015\u0004\u0016Ȉ\u0017\u0002\u0018\u0002\u0019Ȉ\u001aဉ\u0000\u001b\u0004\u001c\u0004\u001d\f\u001e\u0007\u001f\f '!\u0007\"ဉ\u0001", new Object[]{"bitField0_", "id_", "title_", "picUrl_", "description_", "link_", "linkTitle_", "ownerId_", "viewCount_", "clickCount_", "createdAt_", "desiredStartTime_", "startTime_", "finishTime_", "state_", "spot_", "platform_", "topic_", "rejectionReason_", "autoFinish_", "setView_", "setClick_", "discountCode_", "totalPrice_", "payedPrice_", "phoneNo_", "sponsoredMessageOption_", "tag1_", "tag2_", "ownerType_", "isInstant_", "targetType_", "targetIds_", "isOnlyTargeted_", "targeting_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementStruct$AdData.class) {
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

    public boolean getAutoFinish() {
        return this.autoFinish_;
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

    public long getDesiredStartTime() {
        return this.desiredStartTime_;
    }

    public String getDiscountCode() {
        return this.discountCode_;
    }

    public AbstractC2383g getDiscountCodeBytes() {
        return AbstractC2383g.N(this.discountCode_);
    }

    public long getFinishTime() {
        return this.finishTime_;
    }

    public String getId() {
        return this.id_;
    }

    public AbstractC2383g getIdBytes() {
        return AbstractC2383g.N(this.id_);
    }

    public boolean getIsInstant() {
        return this.isInstant_;
    }

    public boolean getIsOnlyTargeted() {
        return this.isOnlyTargeted_;
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

    public int getOwnerId() {
        return this.ownerId_;
    }

    public EnumC4704Gf getOwnerType() {
        EnumC4704Gf enumC4704GfJ = EnumC4704Gf.j(this.ownerType_);
        return enumC4704GfJ == null ? EnumC4704Gf.UNRECOGNIZED : enumC4704GfJ;
    }

    public int getOwnerTypeValue() {
        return this.ownerType_;
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

    public String getRejectionReason() {
        return this.rejectionReason_;
    }

    public AbstractC2383g getRejectionReasonBytes() {
        return AbstractC2383g.N(this.rejectionReason_);
    }

    public int getSetClick() {
        return this.setClick_;
    }

    public int getSetView() {
        return this.setView_;
    }

    public AdvertisementStruct$SponsoredMessageOption getSponsoredMessageOption() {
        AdvertisementStruct$SponsoredMessageOption advertisementStruct$SponsoredMessageOption = this.sponsoredMessageOption_;
        return advertisementStruct$SponsoredMessageOption == null ? AdvertisementStruct$SponsoredMessageOption.getDefaultInstance() : advertisementStruct$SponsoredMessageOption;
    }

    public EnumC4938Hf getSpot() {
        EnumC4938Hf enumC4938HfJ = EnumC4938Hf.j(this.spot_);
        return enumC4938HfJ == null ? EnumC4938Hf.UNRECOGNIZED : enumC4938HfJ;
    }

    public int getSpotValue() {
        return this.spot_;
    }

    public long getStartTime() {
        return this.startTime_;
    }

    public EnumC5640Kf getState() {
        EnumC5640Kf enumC5640KfJ = EnumC5640Kf.j(this.state_);
        return enumC5640KfJ == null ? EnumC5640Kf.UNRECOGNIZED : enumC5640KfJ;
    }

    public int getStateValue() {
        return this.state_;
    }

    public int getTag1() {
        return this.tag1_;
    }

    public int getTag2() {
        return this.tag2_;
    }

    public int getTargetIds(int i) {
        return this.targetIds_.getInt(i);
    }

    public int getTargetIdsCount() {
        return this.targetIds_.size();
    }

    public List<Integer> getTargetIdsList() {
        return this.targetIds_;
    }

    public EnumC6346Nf getTargetType() {
        EnumC6346Nf enumC6346NfJ = EnumC6346Nf.j(this.targetType_);
        return enumC6346NfJ == null ? EnumC6346Nf.UNRECOGNIZED : enumC6346NfJ;
    }

    public int getTargetTypeValue() {
        return this.targetType_;
    }

    public AdvertisementStruct$AdTargeting getTargeting() {
        AdvertisementStruct$AdTargeting advertisementStruct$AdTargeting = this.targeting_;
        return advertisementStruct$AdTargeting == null ? AdvertisementStruct$AdTargeting.getDefaultInstance() : advertisementStruct$AdTargeting;
    }

    public String getTitle() {
        return this.title_;
    }

    public AbstractC2383g getTitleBytes() {
        return AbstractC2383g.N(this.title_);
    }

    public int getTopic() {
        return this.topic_;
    }

    public long getTotalPrice() {
        return this.totalPrice_;
    }

    public int getViewCount() {
        return this.viewCount_;
    }

    public boolean hasSponsoredMessageOption() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasTargeting() {
        return (this.bitField0_ & 2) != 0;
    }

    public static a newBuilder(AdvertisementStruct$AdData advertisementStruct$AdData) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementStruct$AdData);
    }

    public static AdvertisementStruct$AdData parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementStruct$AdData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementStruct$AdData parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementStruct$AdData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementStruct$AdData parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementStruct$AdData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AdvertisementStruct$AdData parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementStruct$AdData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementStruct$AdData parseFrom(byte[] bArr) {
        return (AdvertisementStruct$AdData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementStruct$AdData parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementStruct$AdData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AdvertisementStruct$AdData parseFrom(InputStream inputStream) {
        return (AdvertisementStruct$AdData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementStruct$AdData parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementStruct$AdData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementStruct$AdData parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementStruct$AdData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementStruct$AdData parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementStruct$AdData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
