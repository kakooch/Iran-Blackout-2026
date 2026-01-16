package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC10482bh;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class AdvertisementStruct$DayCapacityData extends GeneratedMessageLite implements InterfaceC10482bh {
    public static final int CAMPAIGN_RESERVED_VIEWS_FIELD_NUMBER = 6;
    public static final int CURRENT_RESERVED_VIEWS_FIELD_NUMBER = 4;
    public static final int DATE_FIELD_NUMBER = 1;
    private static final AdvertisementStruct$DayCapacityData DEFAULT_INSTANCE;
    public static final int MAX_ADDS_PER_SEGMENT_FIELD_NUMBER = 3;
    public static final int MAX_VIEWS_FIELD_NUMBER = 5;
    private static volatile KW4 PARSER = null;
    public static final int SEGMENT_CAPACITY_USED_FIELD_NUMBER = 2;
    public static final int SPONSORED_RESERVED_VIEWS_FIELD_NUMBER = 7;
    private int campaignReservedViews_;
    private int currentReservedViews_;
    private long date_;
    private int maxViews_;
    private int sponsoredReservedViews_;
    private int segmentCapacityUsedMemoizedSerializedSize = -1;
    private int maxAddsPerSegmentMemoizedSerializedSize = -1;
    private B.g segmentCapacityUsed_ = GeneratedMessageLite.emptyIntList();
    private B.g maxAddsPerSegment_ = GeneratedMessageLite.emptyIntList();

    public static final class a extends GeneratedMessageLite.b implements InterfaceC10482bh {
        private a() {
            super(AdvertisementStruct$DayCapacityData.DEFAULT_INSTANCE);
        }
    }

    static {
        AdvertisementStruct$DayCapacityData advertisementStruct$DayCapacityData = new AdvertisementStruct$DayCapacityData();
        DEFAULT_INSTANCE = advertisementStruct$DayCapacityData;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementStruct$DayCapacityData.class, advertisementStruct$DayCapacityData);
    }

    private AdvertisementStruct$DayCapacityData() {
    }

    private void addAllMaxAddsPerSegment(Iterable<? extends Integer> iterable) {
        ensureMaxAddsPerSegmentIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.maxAddsPerSegment_);
    }

    private void addAllSegmentCapacityUsed(Iterable<? extends Integer> iterable) {
        ensureSegmentCapacityUsedIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.segmentCapacityUsed_);
    }

    private void addMaxAddsPerSegment(int i) {
        ensureMaxAddsPerSegmentIsMutable();
        this.maxAddsPerSegment_.b1(i);
    }

    private void addSegmentCapacityUsed(int i) {
        ensureSegmentCapacityUsedIsMutable();
        this.segmentCapacityUsed_.b1(i);
    }

    private void clearCampaignReservedViews() {
        this.campaignReservedViews_ = 0;
    }

    private void clearCurrentReservedViews() {
        this.currentReservedViews_ = 0;
    }

    private void clearDate() {
        this.date_ = 0L;
    }

    private void clearMaxAddsPerSegment() {
        this.maxAddsPerSegment_ = GeneratedMessageLite.emptyIntList();
    }

    private void clearMaxViews() {
        this.maxViews_ = 0;
    }

    private void clearSegmentCapacityUsed() {
        this.segmentCapacityUsed_ = GeneratedMessageLite.emptyIntList();
    }

    private void clearSponsoredReservedViews() {
        this.sponsoredReservedViews_ = 0;
    }

    private void ensureMaxAddsPerSegmentIsMutable() {
        B.g gVar = this.maxAddsPerSegment_;
        if (gVar.u()) {
            return;
        }
        this.maxAddsPerSegment_ = GeneratedMessageLite.mutableCopy(gVar);
    }

    private void ensureSegmentCapacityUsedIsMutable() {
        B.g gVar = this.segmentCapacityUsed_;
        if (gVar.u()) {
            return;
        }
        this.segmentCapacityUsed_ = GeneratedMessageLite.mutableCopy(gVar);
    }

    public static AdvertisementStruct$DayCapacityData getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AdvertisementStruct$DayCapacityData parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementStruct$DayCapacityData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementStruct$DayCapacityData parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementStruct$DayCapacityData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setCampaignReservedViews(int i) {
        this.campaignReservedViews_ = i;
    }

    private void setCurrentReservedViews(int i) {
        this.currentReservedViews_ = i;
    }

    private void setDate(long j) {
        this.date_ = j;
    }

    private void setMaxAddsPerSegment(int i, int i2) {
        ensureMaxAddsPerSegmentIsMutable();
        this.maxAddsPerSegment_.U(i, i2);
    }

    private void setMaxViews(int i) {
        this.maxViews_ = i;
    }

    private void setSegmentCapacityUsed(int i, int i2) {
        ensureSegmentCapacityUsedIsMutable();
        this.segmentCapacityUsed_.U(i, i2);
    }

    private void setSponsoredReservedViews(int i) {
        this.sponsoredReservedViews_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1843c.a[gVar.ordinal()]) {
            case 1:
                return new AdvertisementStruct$DayCapacityData();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0007\u0000\u0000\u0001\u0007\u0007\u0000\u0002\u0000\u0001\u0002\u0002'\u0003'\u0004\u0004\u0005\u0004\u0006\u0004\u0007\u0004", new Object[]{"date_", "segmentCapacityUsed_", "maxAddsPerSegment_", "currentReservedViews_", "maxViews_", "campaignReservedViews_", "sponsoredReservedViews_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementStruct$DayCapacityData.class) {
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

    public int getCampaignReservedViews() {
        return this.campaignReservedViews_;
    }

    public int getCurrentReservedViews() {
        return this.currentReservedViews_;
    }

    public long getDate() {
        return this.date_;
    }

    public int getMaxAddsPerSegment(int i) {
        return this.maxAddsPerSegment_.getInt(i);
    }

    public int getMaxAddsPerSegmentCount() {
        return this.maxAddsPerSegment_.size();
    }

    public List<Integer> getMaxAddsPerSegmentList() {
        return this.maxAddsPerSegment_;
    }

    public int getMaxViews() {
        return this.maxViews_;
    }

    public int getSegmentCapacityUsed(int i) {
        return this.segmentCapacityUsed_.getInt(i);
    }

    public int getSegmentCapacityUsedCount() {
        return this.segmentCapacityUsed_.size();
    }

    public List<Integer> getSegmentCapacityUsedList() {
        return this.segmentCapacityUsed_;
    }

    public int getSponsoredReservedViews() {
        return this.sponsoredReservedViews_;
    }

    public static a newBuilder(AdvertisementStruct$DayCapacityData advertisementStruct$DayCapacityData) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementStruct$DayCapacityData);
    }

    public static AdvertisementStruct$DayCapacityData parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementStruct$DayCapacityData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementStruct$DayCapacityData parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementStruct$DayCapacityData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementStruct$DayCapacityData parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementStruct$DayCapacityData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AdvertisementStruct$DayCapacityData parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementStruct$DayCapacityData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementStruct$DayCapacityData parseFrom(byte[] bArr) {
        return (AdvertisementStruct$DayCapacityData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementStruct$DayCapacityData parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementStruct$DayCapacityData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AdvertisementStruct$DayCapacityData parseFrom(InputStream inputStream) {
        return (AdvertisementStruct$DayCapacityData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementStruct$DayCapacityData parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementStruct$DayCapacityData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementStruct$DayCapacityData parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementStruct$DayCapacityData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementStruct$DayCapacityData parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementStruct$DayCapacityData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
