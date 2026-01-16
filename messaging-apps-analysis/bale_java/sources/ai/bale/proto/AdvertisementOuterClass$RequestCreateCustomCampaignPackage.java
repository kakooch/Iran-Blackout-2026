package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes7.dex */
public final class AdvertisementOuterClass$RequestCreateCustomCampaignPackage extends GeneratedMessageLite implements U64 {
    public static final int ALLOWED_CONCURRENT_CAMPAIGN_FIELD_NUMBER = 5;
    public static final int AUDIENCE_ID_FIELD_NUMBER = 6;
    public static final int BASE_CREDIT_FIELD_NUMBER = 2;
    public static final int CAMPAIGN_CLICK_COEF_FIELD_NUMBER = 8;
    public static final int CAMPAIGN_DAILY_CAPACITY_FIELD_NUMBER = 4;
    public static final int CAMPAIGN_VIEW_COEF_FIELD_NUMBER = 7;
    public static final int CREDIT_EXPIRE_DAYS_FIELD_NUMBER = 3;
    private static final AdvertisementOuterClass$RequestCreateCustomCampaignPackage DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int USER_ID_FIELD_NUMBER = 1;
    private int allowedConcurrentCampaign_;
    private long baseCredit_;
    private int campaignClickCoef_;
    private long campaignDailyCapacity_;
    private int campaignViewCoef_;
    private int creditExpireDays_;
    private int idCase_ = 0;
    private Object id_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(AdvertisementOuterClass$RequestCreateCustomCampaignPackage.DEFAULT_INSTANCE);
        }
    }

    /* loaded from: classes8.dex */
    public enum b {
        USER_ID(1),
        AUDIENCE_ID(6),
        ID_NOT_SET(0);

        private final int a;

        b(int i) {
            this.a = i;
        }

        public static b j(int i) {
            if (i == 0) {
                return ID_NOT_SET;
            }
            if (i == 1) {
                return USER_ID;
            }
            if (i != 6) {
                return null;
            }
            return AUDIENCE_ID;
        }
    }

    static {
        AdvertisementOuterClass$RequestCreateCustomCampaignPackage advertisementOuterClass$RequestCreateCustomCampaignPackage = new AdvertisementOuterClass$RequestCreateCustomCampaignPackage();
        DEFAULT_INSTANCE = advertisementOuterClass$RequestCreateCustomCampaignPackage;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementOuterClass$RequestCreateCustomCampaignPackage.class, advertisementOuterClass$RequestCreateCustomCampaignPackage);
    }

    private AdvertisementOuterClass$RequestCreateCustomCampaignPackage() {
    }

    private void clearAllowedConcurrentCampaign() {
        this.allowedConcurrentCampaign_ = 0;
    }

    private void clearAudienceId() {
        if (this.idCase_ == 6) {
            this.idCase_ = 0;
            this.id_ = null;
        }
    }

    private void clearBaseCredit() {
        this.baseCredit_ = 0L;
    }

    private void clearCampaignClickCoef() {
        this.campaignClickCoef_ = 0;
    }

    private void clearCampaignDailyCapacity() {
        this.campaignDailyCapacity_ = 0L;
    }

    private void clearCampaignViewCoef() {
        this.campaignViewCoef_ = 0;
    }

    private void clearCreditExpireDays() {
        this.creditExpireDays_ = 0;
    }

    private void clearId() {
        this.idCase_ = 0;
        this.id_ = null;
    }

    private void clearUserId() {
        if (this.idCase_ == 1) {
            this.idCase_ = 0;
            this.id_ = null;
        }
    }

    public static AdvertisementOuterClass$RequestCreateCustomCampaignPackage getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AdvertisementOuterClass$RequestCreateCustomCampaignPackage parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$RequestCreateCustomCampaignPackage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$RequestCreateCustomCampaignPackage parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementOuterClass$RequestCreateCustomCampaignPackage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAllowedConcurrentCampaign(int i) {
        this.allowedConcurrentCampaign_ = i;
    }

    private void setAudienceId(int i) {
        this.idCase_ = 6;
        this.id_ = Integer.valueOf(i);
    }

    private void setBaseCredit(long j) {
        this.baseCredit_ = j;
    }

    private void setCampaignClickCoef(int i) {
        this.campaignClickCoef_ = i;
    }

    private void setCampaignDailyCapacity(long j) {
        this.campaignDailyCapacity_ = j;
    }

    private void setCampaignViewCoef(int i) {
        this.campaignViewCoef_ = i;
    }

    private void setCreditExpireDays(int i) {
        this.creditExpireDays_ = i;
    }

    private void setUserId(int i) {
        this.idCase_ = 1;
        this.id_ = Integer.valueOf(i);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1840b.a[gVar.ordinal()]) {
            case 1:
                return new AdvertisementOuterClass$RequestCreateCustomCampaignPackage();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\b\u0001\u0000\u0001\b\b\u0000\u0000\u0000\u00017\u0000\u0002\u0002\u0003\u0004\u0004\u0002\u0005\u0004\u00067\u0000\u0007\u0004\b\u0004", new Object[]{"id_", "idCase_", "baseCredit_", "creditExpireDays_", "campaignDailyCapacity_", "allowedConcurrentCampaign_", "campaignViewCoef_", "campaignClickCoef_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementOuterClass$RequestCreateCustomCampaignPackage.class) {
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

    public int getAllowedConcurrentCampaign() {
        return this.allowedConcurrentCampaign_;
    }

    public int getAudienceId() {
        if (this.idCase_ == 6) {
            return ((Integer) this.id_).intValue();
        }
        return 0;
    }

    public long getBaseCredit() {
        return this.baseCredit_;
    }

    public int getCampaignClickCoef() {
        return this.campaignClickCoef_;
    }

    public long getCampaignDailyCapacity() {
        return this.campaignDailyCapacity_;
    }

    public int getCampaignViewCoef() {
        return this.campaignViewCoef_;
    }

    public int getCreditExpireDays() {
        return this.creditExpireDays_;
    }

    public b getIdCase() {
        return b.j(this.idCase_);
    }

    public int getUserId() {
        if (this.idCase_ == 1) {
            return ((Integer) this.id_).intValue();
        }
        return 0;
    }

    public boolean hasAudienceId() {
        return this.idCase_ == 6;
    }

    public boolean hasUserId() {
        return this.idCase_ == 1;
    }

    public static a newBuilder(AdvertisementOuterClass$RequestCreateCustomCampaignPackage advertisementOuterClass$RequestCreateCustomCampaignPackage) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementOuterClass$RequestCreateCustomCampaignPackage);
    }

    public static AdvertisementOuterClass$RequestCreateCustomCampaignPackage parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestCreateCustomCampaignPackage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$RequestCreateCustomCampaignPackage parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestCreateCustomCampaignPackage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementOuterClass$RequestCreateCustomCampaignPackage parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementOuterClass$RequestCreateCustomCampaignPackage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementOuterClass$RequestCreateCustomCampaignPackage parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestCreateCustomCampaignPackage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }

    public static AdvertisementOuterClass$RequestCreateCustomCampaignPackage parseFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$RequestCreateCustomCampaignPackage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$RequestCreateCustomCampaignPackage parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestCreateCustomCampaignPackage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$RequestCreateCustomCampaignPackage parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementOuterClass$RequestCreateCustomCampaignPackage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static AdvertisementOuterClass$RequestCreateCustomCampaignPackage parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestCreateCustomCampaignPackage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementOuterClass$RequestCreateCustomCampaignPackage parseFrom(byte[] bArr) {
        return (AdvertisementOuterClass$RequestCreateCustomCampaignPackage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementOuterClass$RequestCreateCustomCampaignPackage parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestCreateCustomCampaignPackage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }
}
