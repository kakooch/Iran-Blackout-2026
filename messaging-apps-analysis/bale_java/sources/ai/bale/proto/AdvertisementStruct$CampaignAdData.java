package ai.bale.proto;

import ai.bale.proto.AdvertisementStruct$AdTargeting;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC22691vg;
import ir.nasim.EnumC3771Ch;
import ir.nasim.EnumC4938Hf;
import ir.nasim.InterfaceC22101ug;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes8.dex */
public final class AdvertisementStruct$CampaignAdData extends GeneratedMessageLite implements InterfaceC22101ug {
    public static final int CAMPAIGN_ID_FIELD_NUMBER = 1;
    public static final int CLICK_COUNT_FIELD_NUMBER = 10;
    public static final int COST_FIELD_NUMBER = 14;
    private static final AdvertisementStruct$CampaignAdData DEFAULT_INSTANCE;
    public static final int DESCRIPTION_FIELD_NUMBER = 5;
    public static final int ID_FIELD_NUMBER = 2;
    public static final int IS_ONLY_TARGETED_FIELD_NUMBER = 18;
    public static final int LINK_FIELD_NUMBER = 6;
    public static final int LINK_TITLE_FIELD_NUMBER = 7;
    private static volatile KW4 PARSER = null;
    public static final int PIC_URL_FIELD_NUMBER = 4;
    public static final int PLATFORM_FIELD_NUMBER = 12;
    public static final int SPOT_FIELD_NUMBER = 11;
    public static final int TAG1_FIELD_NUMBER = 15;
    public static final int TAG2_FIELD_NUMBER = 16;
    public static final int TARGETING_FIELD_NUMBER = 17;
    public static final int TITLE_FIELD_NUMBER = 3;
    public static final int TOPIC_FIELD_NUMBER = 13;
    public static final int TYPE_FIELD_NUMBER = 8;
    public static final int VIEW_COUNT_FIELD_NUMBER = 9;
    private int bitField0_;
    private long clickCount_;
    private long cost_;
    private boolean isOnlyTargeted_;
    private int platform_;
    private int spot_;
    private int tag1_;
    private int tag2_;
    private AdvertisementStruct$AdTargeting targeting_;
    private int topic_;
    private int type_;
    private long viewCount_;
    private String campaignId_ = "";
    private String id_ = "";
    private String title_ = "";
    private String picUrl_ = "";
    private String description_ = "";
    private String link_ = "";
    private String linkTitle_ = "";

    public static final class a extends GeneratedMessageLite.b implements InterfaceC22101ug {
        private a() {
            super(AdvertisementStruct$CampaignAdData.DEFAULT_INSTANCE);
        }
    }

    static {
        AdvertisementStruct$CampaignAdData advertisementStruct$CampaignAdData = new AdvertisementStruct$CampaignAdData();
        DEFAULT_INSTANCE = advertisementStruct$CampaignAdData;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementStruct$CampaignAdData.class, advertisementStruct$CampaignAdData);
    }

    private AdvertisementStruct$CampaignAdData() {
    }

    private void clearCampaignId() {
        this.campaignId_ = getDefaultInstance().getCampaignId();
    }

    private void clearClickCount() {
        this.clickCount_ = 0L;
    }

    private void clearCost() {
        this.cost_ = 0L;
    }

    private void clearDescription() {
        this.description_ = getDefaultInstance().getDescription();
    }

    private void clearId() {
        this.id_ = getDefaultInstance().getId();
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

    private void clearPicUrl() {
        this.picUrl_ = getDefaultInstance().getPicUrl();
    }

    private void clearPlatform() {
        this.platform_ = 0;
    }

    private void clearSpot() {
        this.spot_ = 0;
    }

    private void clearTag1() {
        this.tag1_ = 0;
    }

    private void clearTag2() {
        this.tag2_ = 0;
    }

    private void clearTargeting() {
        this.targeting_ = null;
        this.bitField0_ &= -2;
    }

    private void clearTitle() {
        this.title_ = getDefaultInstance().getTitle();
    }

    private void clearTopic() {
        this.topic_ = 0;
    }

    private void clearType() {
        this.type_ = 0;
    }

    private void clearViewCount() {
        this.viewCount_ = 0L;
    }

    public static AdvertisementStruct$CampaignAdData getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeTargeting(AdvertisementStruct$AdTargeting advertisementStruct$AdTargeting) {
        advertisementStruct$AdTargeting.getClass();
        AdvertisementStruct$AdTargeting advertisementStruct$AdTargeting2 = this.targeting_;
        if (advertisementStruct$AdTargeting2 == null || advertisementStruct$AdTargeting2 == AdvertisementStruct$AdTargeting.getDefaultInstance()) {
            this.targeting_ = advertisementStruct$AdTargeting;
        } else {
            this.targeting_ = (AdvertisementStruct$AdTargeting) ((AdvertisementStruct$AdTargeting.a) AdvertisementStruct$AdTargeting.newBuilder(this.targeting_).v(advertisementStruct$AdTargeting)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AdvertisementStruct$CampaignAdData parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementStruct$CampaignAdData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementStruct$CampaignAdData parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementStruct$CampaignAdData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setCampaignId(String str) {
        str.getClass();
        this.campaignId_ = str;
    }

    private void setCampaignIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.campaignId_ = abstractC2383g.f0();
    }

    private void setClickCount(long j) {
        this.clickCount_ = j;
    }

    private void setCost(long j) {
        this.cost_ = j;
    }

    private void setDescription(String str) {
        str.getClass();
        this.description_ = str;
    }

    private void setDescriptionBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.description_ = abstractC2383g.f0();
    }

    private void setId(String str) {
        str.getClass();
        this.id_ = str;
    }

    private void setIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.id_ = abstractC2383g.f0();
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

    private void setSpot(EnumC4938Hf enumC4938Hf) {
        this.spot_ = enumC4938Hf.getNumber();
    }

    private void setSpotValue(int i) {
        this.spot_ = i;
    }

    private void setTag1(int i) {
        this.tag1_ = i;
    }

    private void setTag2(int i) {
        this.tag2_ = i;
    }

    private void setTargeting(AdvertisementStruct$AdTargeting advertisementStruct$AdTargeting) {
        advertisementStruct$AdTargeting.getClass();
        this.targeting_ = advertisementStruct$AdTargeting;
        this.bitField0_ |= 1;
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

    private void setType(EnumC22691vg enumC22691vg) {
        this.type_ = enumC22691vg.getNumber();
    }

    private void setTypeValue(int i) {
        this.type_ = i;
    }

    private void setViewCount(long j) {
        this.viewCount_ = j;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1843c.a[gVar.ordinal()]) {
            case 1:
                return new AdvertisementStruct$CampaignAdData();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0012\u0000\u0001\u0001\u0012\u0012\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004Ȉ\u0005Ȉ\u0006Ȉ\u0007Ȉ\b\f\t\u0002\n\u0002\u000b\f\f\f\r\u0004\u000e\u0002\u000f\u0004\u0010\u0004\u0011ဉ\u0000\u0012\u0007", new Object[]{"bitField0_", "campaignId_", "id_", "title_", "picUrl_", "description_", "link_", "linkTitle_", "type_", "viewCount_", "clickCount_", "spot_", "platform_", "topic_", "cost_", "tag1_", "tag2_", "targeting_", "isOnlyTargeted_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementStruct$CampaignAdData.class) {
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

    public String getCampaignId() {
        return this.campaignId_;
    }

    public AbstractC2383g getCampaignIdBytes() {
        return AbstractC2383g.N(this.campaignId_);
    }

    public long getClickCount() {
        return this.clickCount_;
    }

    public long getCost() {
        return this.cost_;
    }

    public String getDescription() {
        return this.description_;
    }

    public AbstractC2383g getDescriptionBytes() {
        return AbstractC2383g.N(this.description_);
    }

    public String getId() {
        return this.id_;
    }

    public AbstractC2383g getIdBytes() {
        return AbstractC2383g.N(this.id_);
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

    public EnumC4938Hf getSpot() {
        EnumC4938Hf enumC4938HfJ = EnumC4938Hf.j(this.spot_);
        return enumC4938HfJ == null ? EnumC4938Hf.UNRECOGNIZED : enumC4938HfJ;
    }

    public int getSpotValue() {
        return this.spot_;
    }

    public int getTag1() {
        return this.tag1_;
    }

    public int getTag2() {
        return this.tag2_;
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

    public EnumC22691vg getType() {
        EnumC22691vg enumC22691vgJ = EnumC22691vg.j(this.type_);
        return enumC22691vgJ == null ? EnumC22691vg.UNRECOGNIZED : enumC22691vgJ;
    }

    public int getTypeValue() {
        return this.type_;
    }

    public long getViewCount() {
        return this.viewCount_;
    }

    public boolean hasTargeting() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(AdvertisementStruct$CampaignAdData advertisementStruct$CampaignAdData) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementStruct$CampaignAdData);
    }

    public static AdvertisementStruct$CampaignAdData parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementStruct$CampaignAdData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementStruct$CampaignAdData parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementStruct$CampaignAdData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementStruct$CampaignAdData parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementStruct$CampaignAdData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AdvertisementStruct$CampaignAdData parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementStruct$CampaignAdData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementStruct$CampaignAdData parseFrom(byte[] bArr) {
        return (AdvertisementStruct$CampaignAdData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementStruct$CampaignAdData parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementStruct$CampaignAdData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AdvertisementStruct$CampaignAdData parseFrom(InputStream inputStream) {
        return (AdvertisementStruct$CampaignAdData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementStruct$CampaignAdData parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementStruct$CampaignAdData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementStruct$CampaignAdData parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementStruct$CampaignAdData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementStruct$CampaignAdData parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementStruct$CampaignAdData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
