package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC3528Bg;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes8.dex */
public final class AdvertisementStruct$ChannelAdOrder extends GeneratedMessageLite implements InterfaceC3528Bg {
    public static final int AD_ID_FIELD_NUMBER = 1;
    public static final int CLICK_COUNT_FIELD_NUMBER = 6;
    public static final int CLICK_RATE_FIELD_NUMBER = 13;
    public static final int CREATED_AT_FIELD_NUMBER = 9;
    private static final AdvertisementStruct$ChannelAdOrder DEFAULT_INSTANCE;
    public static final int DESCRIPTION_FIELD_NUMBER = 3;
    public static final int END_TIME_FIELD_NUMBER = 12;
    public static final int EXPIRATION_DATE_FIELD_NUMBER = 11;
    public static final int LINK_FIELD_NUMBER = 4;
    private static volatile KW4 PARSER = null;
    public static final int PHONE_NUMBER_FIELD_NUMBER = 15;
    public static final int REJECTION_REASON_FIELD_NUMBER = 10;
    public static final int START_TIME_FIELD_NUMBER = 8;
    public static final int STATUS_FIELD_NUMBER = 7;
    public static final int TITLE_FIELD_NUMBER = 2;
    public static final int VIEW_COUNT_FIELD_NUMBER = 5;
    public static final int VIEW_RATE_FIELD_NUMBER = 14;
    private long clickCount_;
    private long clickRate_;
    private long createdAt_;
    private long endTime_;
    private long expirationDate_;
    private long startTime_;
    private int status_;
    private long viewCount_;
    private long viewRate_;
    private String adId_ = "";
    private String title_ = "";
    private String description_ = "";
    private String link_ = "";
    private String rejectionReason_ = "";
    private String phoneNumber_ = "";

    public static final class a extends GeneratedMessageLite.b implements InterfaceC3528Bg {
        private a() {
            super(AdvertisementStruct$ChannelAdOrder.DEFAULT_INSTANCE);
        }
    }

    static {
        AdvertisementStruct$ChannelAdOrder advertisementStruct$ChannelAdOrder = new AdvertisementStruct$ChannelAdOrder();
        DEFAULT_INSTANCE = advertisementStruct$ChannelAdOrder;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementStruct$ChannelAdOrder.class, advertisementStruct$ChannelAdOrder);
    }

    private AdvertisementStruct$ChannelAdOrder() {
    }

    private void clearAdId() {
        this.adId_ = getDefaultInstance().getAdId();
    }

    private void clearClickCount() {
        this.clickCount_ = 0L;
    }

    private void clearClickRate() {
        this.clickRate_ = 0L;
    }

    private void clearCreatedAt() {
        this.createdAt_ = 0L;
    }

    private void clearDescription() {
        this.description_ = getDefaultInstance().getDescription();
    }

    private void clearEndTime() {
        this.endTime_ = 0L;
    }

    private void clearExpirationDate() {
        this.expirationDate_ = 0L;
    }

    private void clearLink() {
        this.link_ = getDefaultInstance().getLink();
    }

    private void clearPhoneNumber() {
        this.phoneNumber_ = getDefaultInstance().getPhoneNumber();
    }

    private void clearRejectionReason() {
        this.rejectionReason_ = getDefaultInstance().getRejectionReason();
    }

    private void clearStartTime() {
        this.startTime_ = 0L;
    }

    private void clearStatus() {
        this.status_ = 0;
    }

    private void clearTitle() {
        this.title_ = getDefaultInstance().getTitle();
    }

    private void clearViewCount() {
        this.viewCount_ = 0L;
    }

    private void clearViewRate() {
        this.viewRate_ = 0L;
    }

    public static AdvertisementStruct$ChannelAdOrder getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AdvertisementStruct$ChannelAdOrder parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementStruct$ChannelAdOrder) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementStruct$ChannelAdOrder parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementStruct$ChannelAdOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
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

    private void setClickCount(long j) {
        this.clickCount_ = j;
    }

    private void setClickRate(long j) {
        this.clickRate_ = j;
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

    private void setEndTime(long j) {
        this.endTime_ = j;
    }

    private void setExpirationDate(long j) {
        this.expirationDate_ = j;
    }

    private void setLink(String str) {
        str.getClass();
        this.link_ = str;
    }

    private void setLinkBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.link_ = abstractC2383g.f0();
    }

    private void setPhoneNumber(String str) {
        str.getClass();
        this.phoneNumber_ = str;
    }

    private void setPhoneNumberBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.phoneNumber_ = abstractC2383g.f0();
    }

    private void setRejectionReason(String str) {
        str.getClass();
        this.rejectionReason_ = str;
    }

    private void setRejectionReasonBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.rejectionReason_ = abstractC2383g.f0();
    }

    private void setStartTime(long j) {
        this.startTime_ = j;
    }

    private void setStatus(int i) {
        this.status_ = i;
    }

    private void setTitle(String str) {
        str.getClass();
        this.title_ = str;
    }

    private void setTitleBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.title_ = abstractC2383g.f0();
    }

    private void setViewCount(long j) {
        this.viewCount_ = j;
    }

    private void setViewRate(long j) {
        this.viewRate_ = j;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1843c.a[gVar.ordinal()]) {
            case 1:
                return new AdvertisementStruct$ChannelAdOrder();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u000f\u0000\u0000\u0001\u000f\u000f\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004Ȉ\u0005\u0002\u0006\u0002\u0007\u0004\b\u0002\t\u0002\nȈ\u000b\u0002\f\u0002\r\u0002\u000e\u0002\u000fȈ", new Object[]{"adId_", "title_", "description_", "link_", "viewCount_", "clickCount_", "status_", "startTime_", "createdAt_", "rejectionReason_", "expirationDate_", "endTime_", "clickRate_", "viewRate_", "phoneNumber_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementStruct$ChannelAdOrder.class) {
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

    public long getClickCount() {
        return this.clickCount_;
    }

    public long getClickRate() {
        return this.clickRate_;
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

    public long getEndTime() {
        return this.endTime_;
    }

    public long getExpirationDate() {
        return this.expirationDate_;
    }

    public String getLink() {
        return this.link_;
    }

    public AbstractC2383g getLinkBytes() {
        return AbstractC2383g.N(this.link_);
    }

    public String getPhoneNumber() {
        return this.phoneNumber_;
    }

    public AbstractC2383g getPhoneNumberBytes() {
        return AbstractC2383g.N(this.phoneNumber_);
    }

    public String getRejectionReason() {
        return this.rejectionReason_;
    }

    public AbstractC2383g getRejectionReasonBytes() {
        return AbstractC2383g.N(this.rejectionReason_);
    }

    public long getStartTime() {
        return this.startTime_;
    }

    public int getStatus() {
        return this.status_;
    }

    public String getTitle() {
        return this.title_;
    }

    public AbstractC2383g getTitleBytes() {
        return AbstractC2383g.N(this.title_);
    }

    public long getViewCount() {
        return this.viewCount_;
    }

    public long getViewRate() {
        return this.viewRate_;
    }

    public static a newBuilder(AdvertisementStruct$ChannelAdOrder advertisementStruct$ChannelAdOrder) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementStruct$ChannelAdOrder);
    }

    public static AdvertisementStruct$ChannelAdOrder parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementStruct$ChannelAdOrder) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementStruct$ChannelAdOrder parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementStruct$ChannelAdOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementStruct$ChannelAdOrder parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementStruct$ChannelAdOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AdvertisementStruct$ChannelAdOrder parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementStruct$ChannelAdOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementStruct$ChannelAdOrder parseFrom(byte[] bArr) {
        return (AdvertisementStruct$ChannelAdOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementStruct$ChannelAdOrder parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementStruct$ChannelAdOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AdvertisementStruct$ChannelAdOrder parseFrom(InputStream inputStream) {
        return (AdvertisementStruct$ChannelAdOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementStruct$ChannelAdOrder parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementStruct$ChannelAdOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementStruct$ChannelAdOrder parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementStruct$ChannelAdOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementStruct$ChannelAdOrder parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementStruct$ChannelAdOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
