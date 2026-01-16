package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC25061zg;
import ir.nasim.InterfaceC22101ug;
import ir.nasim.InterfaceC23877xg;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes8.dex */
public final class AdvertisementStruct$CampaignData extends GeneratedMessageLite implements InterfaceC23877xg {
    public static final int ACCEPT_DATE_FIELD_NUMBER = 5;
    public static final int ADS_FIELD_NUMBER = 9;
    public static final int CREATED_AT_FIELD_NUMBER = 4;
    private static final AdvertisementStruct$CampaignData DEFAULT_INSTANCE;
    public static final int FINISH_TIME_FIELD_NUMBER = 8;
    public static final int ID_FIELD_NUMBER = 1;
    public static final int OWNER_ID_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int REJECTION_REASON_FIELD_NUMBER = 6;
    public static final int START_TIME_FIELD_NUMBER = 7;
    public static final int STATE_FIELD_NUMBER = 3;
    private long acceptDate_;
    private long createdAt_;
    private long finishTime_;
    private int ownerId_;
    private long startTime_;
    private int state_;
    private String id_ = "";
    private String rejectionReason_ = "";
    private B.j ads_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements InterfaceC23877xg {
        private a() {
            super(AdvertisementStruct$CampaignData.DEFAULT_INSTANCE);
        }
    }

    static {
        AdvertisementStruct$CampaignData advertisementStruct$CampaignData = new AdvertisementStruct$CampaignData();
        DEFAULT_INSTANCE = advertisementStruct$CampaignData;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementStruct$CampaignData.class, advertisementStruct$CampaignData);
    }

    private AdvertisementStruct$CampaignData() {
    }

    private void addAds(AdvertisementStruct$CampaignAdData advertisementStruct$CampaignAdData) {
        advertisementStruct$CampaignAdData.getClass();
        ensureAdsIsMutable();
        this.ads_.add(advertisementStruct$CampaignAdData);
    }

    private void addAllAds(Iterable<? extends AdvertisementStruct$CampaignAdData> iterable) {
        ensureAdsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.ads_);
    }

    private void clearAcceptDate() {
        this.acceptDate_ = 0L;
    }

    private void clearAds() {
        this.ads_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearCreatedAt() {
        this.createdAt_ = 0L;
    }

    private void clearFinishTime() {
        this.finishTime_ = 0L;
    }

    private void clearId() {
        this.id_ = getDefaultInstance().getId();
    }

    private void clearOwnerId() {
        this.ownerId_ = 0;
    }

    private void clearRejectionReason() {
        this.rejectionReason_ = getDefaultInstance().getRejectionReason();
    }

    private void clearStartTime() {
        this.startTime_ = 0L;
    }

    private void clearState() {
        this.state_ = 0;
    }

    private void ensureAdsIsMutable() {
        B.j jVar = this.ads_;
        if (jVar.u()) {
            return;
        }
        this.ads_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static AdvertisementStruct$CampaignData getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AdvertisementStruct$CampaignData parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementStruct$CampaignData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementStruct$CampaignData parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementStruct$CampaignData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeAds(int i) {
        ensureAdsIsMutable();
        this.ads_.remove(i);
    }

    private void setAcceptDate(long j) {
        this.acceptDate_ = j;
    }

    private void setAds(int i, AdvertisementStruct$CampaignAdData advertisementStruct$CampaignAdData) {
        advertisementStruct$CampaignAdData.getClass();
        ensureAdsIsMutable();
        this.ads_.set(i, advertisementStruct$CampaignAdData);
    }

    private void setCreatedAt(long j) {
        this.createdAt_ = j;
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

    private void setOwnerId(int i) {
        this.ownerId_ = i;
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

    private void setState(EnumC25061zg enumC25061zg) {
        this.state_ = enumC25061zg.getNumber();
    }

    private void setStateValue(int i) {
        this.state_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1843c.a[gVar.ordinal()]) {
            case 1:
                return new AdvertisementStruct$CampaignData();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\t\u0000\u0000\u0001\t\t\u0000\u0001\u0000\u0001Ȉ\u0002\u0004\u0003\f\u0004\u0002\u0005\u0002\u0006Ȉ\u0007\u0002\b\u0002\t\u001b", new Object[]{"id_", "ownerId_", "state_", "createdAt_", "acceptDate_", "rejectionReason_", "startTime_", "finishTime_", "ads_", AdvertisementStruct$CampaignAdData.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementStruct$CampaignData.class) {
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

    public AdvertisementStruct$CampaignAdData getAds(int i) {
        return (AdvertisementStruct$CampaignAdData) this.ads_.get(i);
    }

    public int getAdsCount() {
        return this.ads_.size();
    }

    public List<AdvertisementStruct$CampaignAdData> getAdsList() {
        return this.ads_;
    }

    public InterfaceC22101ug getAdsOrBuilder(int i) {
        return (InterfaceC22101ug) this.ads_.get(i);
    }

    public List<? extends InterfaceC22101ug> getAdsOrBuilderList() {
        return this.ads_;
    }

    public long getCreatedAt() {
        return this.createdAt_;
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

    public int getOwnerId() {
        return this.ownerId_;
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

    public EnumC25061zg getState() {
        EnumC25061zg enumC25061zgJ = EnumC25061zg.j(this.state_);
        return enumC25061zgJ == null ? EnumC25061zg.UNRECOGNIZED : enumC25061zgJ;
    }

    public int getStateValue() {
        return this.state_;
    }

    public static a newBuilder(AdvertisementStruct$CampaignData advertisementStruct$CampaignData) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementStruct$CampaignData);
    }

    public static AdvertisementStruct$CampaignData parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementStruct$CampaignData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementStruct$CampaignData parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementStruct$CampaignData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementStruct$CampaignData parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementStruct$CampaignData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addAds(int i, AdvertisementStruct$CampaignAdData advertisementStruct$CampaignAdData) {
        advertisementStruct$CampaignAdData.getClass();
        ensureAdsIsMutable();
        this.ads_.add(i, advertisementStruct$CampaignAdData);
    }

    public static AdvertisementStruct$CampaignData parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementStruct$CampaignData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementStruct$CampaignData parseFrom(byte[] bArr) {
        return (AdvertisementStruct$CampaignData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementStruct$CampaignData parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementStruct$CampaignData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AdvertisementStruct$CampaignData parseFrom(InputStream inputStream) {
        return (AdvertisementStruct$CampaignData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementStruct$CampaignData parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementStruct$CampaignData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementStruct$CampaignData parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementStruct$CampaignData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementStruct$CampaignData parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementStruct$CampaignData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
