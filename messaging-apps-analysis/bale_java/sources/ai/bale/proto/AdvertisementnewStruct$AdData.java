package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC20844si;
import ir.nasim.EnumC25081zi;
import ir.nasim.EnumC4938Hf;
import ir.nasim.InterfaceC20251ri;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class AdvertisementnewStruct$AdData extends GeneratedMessageLite implements InterfaceC20251ri {
    public static final int AUTO_FINISH_FIELD_NUMBER = 19;
    public static final int CLICK_COUNT_FIELD_NUMBER = 9;
    public static final int CREATED_AT_FIELD_NUMBER = 10;
    private static final AdvertisementnewStruct$AdData DEFAULT_INSTANCE;
    public static final int DESCRIPTION_FIELD_NUMBER = 4;
    public static final int DESIRED_START_TIME_FIELD_NUMBER = 11;
    public static final int FINISH_TIME_FIELD_NUMBER = 13;
    public static final int ID_FIELD_NUMBER = 1;
    public static final int LINK_FIELD_NUMBER = 5;
    public static final int LINK_TITLE_FIELD_NUMBER = 6;
    public static final int OWNER_ID_FIELD_NUMBER = 7;
    private static volatile KW4 PARSER = null;
    public static final int PIC_URL_FIELD_NUMBER = 3;
    public static final int PLATFORM_FIELD_NUMBER = 16;
    public static final int REJECTION_REASON_FIELD_NUMBER = 18;
    public static final int SPOT_FIELD_NUMBER = 15;
    public static final int START_TIME_FIELD_NUMBER = 12;
    public static final int STATE_FIELD_NUMBER = 14;
    public static final int TITLE_FIELD_NUMBER = 2;
    public static final int TOPIC_FIELD_NUMBER = 17;
    public static final int VIEW_COUNT_FIELD_NUMBER = 8;
    private boolean autoFinish_;
    private int clickCount_;
    private long createdAt_;
    private long desiredStartTime_;
    private long finishTime_;
    private int ownerId_;
    private int platform_;
    private int spot_;
    private long startTime_;
    private int state_;
    private int topic_;
    private int viewCount_;
    private String id_ = "";
    private String title_ = "";
    private String picUrl_ = "";
    private String description_ = "";
    private String link_ = "";
    private String linkTitle_ = "";
    private String rejectionReason_ = "";

    public static final class a extends GeneratedMessageLite.b implements InterfaceC20251ri {
        private a() {
            super(AdvertisementnewStruct$AdData.DEFAULT_INSTANCE);
        }
    }

    static {
        AdvertisementnewStruct$AdData advertisementnewStruct$AdData = new AdvertisementnewStruct$AdData();
        DEFAULT_INSTANCE = advertisementnewStruct$AdData;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementnewStruct$AdData.class, advertisementnewStruct$AdData);
    }

    private AdvertisementnewStruct$AdData() {
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

    private void clearFinishTime() {
        this.finishTime_ = 0L;
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

    private void clearOwnerId() {
        this.ownerId_ = 0;
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

    private void clearSpot() {
        this.spot_ = 0;
    }

    private void clearStartTime() {
        this.startTime_ = 0L;
    }

    private void clearState() {
        this.state_ = 0;
    }

    private void clearTitle() {
        this.title_ = getDefaultInstance().getTitle();
    }

    private void clearTopic() {
        this.topic_ = 0;
    }

    private void clearViewCount() {
        this.viewCount_ = 0;
    }

    public static AdvertisementnewStruct$AdData getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AdvertisementnewStruct$AdData parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementnewStruct$AdData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementnewStruct$AdData parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementnewStruct$AdData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
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

    private void setPicUrl(String str) {
        str.getClass();
        this.picUrl_ = str;
    }

    private void setPicUrlBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.picUrl_ = abstractC2383g.f0();
    }

    private void setPlatform(EnumC25081zi enumC25081zi) {
        this.platform_ = enumC25081zi.getNumber();
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

    private void setSpot(EnumC4938Hf enumC4938Hf) {
        this.spot_ = enumC4938Hf.getNumber();
    }

    private void setSpotValue(int i) {
        this.spot_ = i;
    }

    private void setStartTime(long j) {
        this.startTime_ = j;
    }

    private void setState(EnumC20844si enumC20844si) {
        this.state_ = enumC20844si.getNumber();
    }

    private void setStateValue(int i) {
        this.state_ = i;
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

    private void setViewCount(int i) {
        this.viewCount_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1852f.a[gVar.ordinal()]) {
            case 1:
                return new AdvertisementnewStruct$AdData();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0013\u0000\u0000\u0001\u0013\u0013\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004Ȉ\u0005Ȉ\u0006Ȉ\u0007\u0004\b\u0004\t\u0004\n\u0002\u000b\u0002\f\u0002\r\u0002\u000e\f\u000f\f\u0010\f\u0011\u0004\u0012Ȉ\u0013\u0007", new Object[]{"id_", "title_", "picUrl_", "description_", "link_", "linkTitle_", "ownerId_", "viewCount_", "clickCount_", "createdAt_", "desiredStartTime_", "startTime_", "finishTime_", "state_", "spot_", "platform_", "topic_", "rejectionReason_", "autoFinish_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementnewStruct$AdData.class) {
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

    public long getFinishTime() {
        return this.finishTime_;
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

    public int getOwnerId() {
        return this.ownerId_;
    }

    public String getPicUrl() {
        return this.picUrl_;
    }

    public AbstractC2383g getPicUrlBytes() {
        return AbstractC2383g.N(this.picUrl_);
    }

    public EnumC25081zi getPlatform() {
        EnumC25081zi enumC25081ziJ = EnumC25081zi.j(this.platform_);
        return enumC25081ziJ == null ? EnumC25081zi.UNRECOGNIZED : enumC25081ziJ;
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

    public EnumC20844si getState() {
        EnumC20844si enumC20844siJ = EnumC20844si.j(this.state_);
        return enumC20844siJ == null ? EnumC20844si.UNRECOGNIZED : enumC20844siJ;
    }

    public int getStateValue() {
        return this.state_;
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

    public int getViewCount() {
        return this.viewCount_;
    }

    public static a newBuilder(AdvertisementnewStruct$AdData advertisementnewStruct$AdData) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementnewStruct$AdData);
    }

    public static AdvertisementnewStruct$AdData parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementnewStruct$AdData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementnewStruct$AdData parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementnewStruct$AdData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementnewStruct$AdData parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementnewStruct$AdData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AdvertisementnewStruct$AdData parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementnewStruct$AdData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementnewStruct$AdData parseFrom(byte[] bArr) {
        return (AdvertisementnewStruct$AdData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementnewStruct$AdData parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementnewStruct$AdData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AdvertisementnewStruct$AdData parseFrom(InputStream inputStream) {
        return (AdvertisementnewStruct$AdData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementnewStruct$AdData parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementnewStruct$AdData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementnewStruct$AdData parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementnewStruct$AdData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementnewStruct$AdData parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementnewStruct$AdData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
