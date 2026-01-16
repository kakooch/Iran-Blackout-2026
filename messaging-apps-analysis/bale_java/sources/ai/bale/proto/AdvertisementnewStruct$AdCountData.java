package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class AdvertisementnewStruct$AdCountData extends GeneratedMessageLite implements U64 {
    public static final int AD_ID_FIELD_NUMBER = 1;
    public static final int CLICK_COUNT_FIELD_NUMBER = 3;
    public static final int CLICK_SEGMENT_FIELD_NUMBER = 5;
    private static final AdvertisementnewStruct$AdCountData DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int START_TIME_FIELD_NUMBER = 6;
    public static final int VIEW_COUNT_FIELD_NUMBER = 2;
    public static final int VIEW_SEGMENT_FIELD_NUMBER = 4;
    private long clickCount_;
    private long startTime_;
    private long viewCount_;
    private int viewSegmentMemoizedSerializedSize = -1;
    private int clickSegmentMemoizedSerializedSize = -1;
    private String adId_ = "";
    private B.i viewSegment_ = GeneratedMessageLite.emptyLongList();
    private B.i clickSegment_ = GeneratedMessageLite.emptyLongList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(AdvertisementnewStruct$AdCountData.DEFAULT_INSTANCE);
        }
    }

    static {
        AdvertisementnewStruct$AdCountData advertisementnewStruct$AdCountData = new AdvertisementnewStruct$AdCountData();
        DEFAULT_INSTANCE = advertisementnewStruct$AdCountData;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementnewStruct$AdCountData.class, advertisementnewStruct$AdCountData);
    }

    private AdvertisementnewStruct$AdCountData() {
    }

    private void addAllClickSegment(Iterable<? extends Long> iterable) {
        ensureClickSegmentIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.clickSegment_);
    }

    private void addAllViewSegment(Iterable<? extends Long> iterable) {
        ensureViewSegmentIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.viewSegment_);
    }

    private void addClickSegment(long j) {
        ensureClickSegmentIsMutable();
        this.clickSegment_.l1(j);
    }

    private void addViewSegment(long j) {
        ensureViewSegmentIsMutable();
        this.viewSegment_.l1(j);
    }

    private void clearAdId() {
        this.adId_ = getDefaultInstance().getAdId();
    }

    private void clearClickCount() {
        this.clickCount_ = 0L;
    }

    private void clearClickSegment() {
        this.clickSegment_ = GeneratedMessageLite.emptyLongList();
    }

    private void clearStartTime() {
        this.startTime_ = 0L;
    }

    private void clearViewCount() {
        this.viewCount_ = 0L;
    }

    private void clearViewSegment() {
        this.viewSegment_ = GeneratedMessageLite.emptyLongList();
    }

    private void ensureClickSegmentIsMutable() {
        B.i iVar = this.clickSegment_;
        if (iVar.u()) {
            return;
        }
        this.clickSegment_ = GeneratedMessageLite.mutableCopy(iVar);
    }

    private void ensureViewSegmentIsMutable() {
        B.i iVar = this.viewSegment_;
        if (iVar.u()) {
            return;
        }
        this.viewSegment_ = GeneratedMessageLite.mutableCopy(iVar);
    }

    public static AdvertisementnewStruct$AdCountData getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AdvertisementnewStruct$AdCountData parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementnewStruct$AdCountData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementnewStruct$AdCountData parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementnewStruct$AdCountData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
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

    private void setClickSegment(int i, long j) {
        ensureClickSegmentIsMutable();
        this.clickSegment_.z1(i, j);
    }

    private void setStartTime(long j) {
        this.startTime_ = j;
    }

    private void setViewCount(long j) {
        this.viewCount_ = j;
    }

    private void setViewSegment(int i, long j) {
        ensureViewSegmentIsMutable();
        this.viewSegment_.z1(i, j);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1852f.a[gVar.ordinal()]) {
            case 1:
                return new AdvertisementnewStruct$AdCountData();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0006\u0000\u0000\u0001\u0006\u0006\u0000\u0002\u0000\u0001Ȉ\u0002\u0002\u0003\u0002\u0004%\u0005%\u0006\u0002", new Object[]{"adId_", "viewCount_", "clickCount_", "viewSegment_", "clickSegment_", "startTime_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementnewStruct$AdCountData.class) {
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

    public long getClickSegment(int i) {
        return this.clickSegment_.getLong(i);
    }

    public int getClickSegmentCount() {
        return this.clickSegment_.size();
    }

    public List<Long> getClickSegmentList() {
        return this.clickSegment_;
    }

    public long getStartTime() {
        return this.startTime_;
    }

    public long getViewCount() {
        return this.viewCount_;
    }

    public long getViewSegment(int i) {
        return this.viewSegment_.getLong(i);
    }

    public int getViewSegmentCount() {
        return this.viewSegment_.size();
    }

    public List<Long> getViewSegmentList() {
        return this.viewSegment_;
    }

    public static a newBuilder(AdvertisementnewStruct$AdCountData advertisementnewStruct$AdCountData) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementnewStruct$AdCountData);
    }

    public static AdvertisementnewStruct$AdCountData parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementnewStruct$AdCountData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementnewStruct$AdCountData parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementnewStruct$AdCountData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementnewStruct$AdCountData parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementnewStruct$AdCountData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AdvertisementnewStruct$AdCountData parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementnewStruct$AdCountData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementnewStruct$AdCountData parseFrom(byte[] bArr) {
        return (AdvertisementnewStruct$AdCountData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementnewStruct$AdCountData parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementnewStruct$AdCountData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AdvertisementnewStruct$AdCountData parseFrom(InputStream inputStream) {
        return (AdvertisementnewStruct$AdCountData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementnewStruct$AdCountData parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementnewStruct$AdCountData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementnewStruct$AdCountData parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementnewStruct$AdCountData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementnewStruct$AdCountData parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementnewStruct$AdCountData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
