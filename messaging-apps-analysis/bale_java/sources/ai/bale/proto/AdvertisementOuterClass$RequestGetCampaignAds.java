package ai.bale.proto;

import ai.bale.proto.AdvertisementStruct$PagingData;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC25061zg;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes8.dex */
public final class AdvertisementOuterClass$RequestGetCampaignAds extends GeneratedMessageLite implements U64 {
    private static final AdvertisementOuterClass$RequestGetCampaignAds DEFAULT_INSTANCE;
    public static final int PAGING_DATA_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int STATE_FIELD_NUMBER = 2;
    private int bitField0_;
    private AdvertisementStruct$PagingData pagingData_;
    private int state_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(AdvertisementOuterClass$RequestGetCampaignAds.DEFAULT_INSTANCE);
        }
    }

    static {
        AdvertisementOuterClass$RequestGetCampaignAds advertisementOuterClass$RequestGetCampaignAds = new AdvertisementOuterClass$RequestGetCampaignAds();
        DEFAULT_INSTANCE = advertisementOuterClass$RequestGetCampaignAds;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementOuterClass$RequestGetCampaignAds.class, advertisementOuterClass$RequestGetCampaignAds);
    }

    private AdvertisementOuterClass$RequestGetCampaignAds() {
    }

    private void clearPagingData() {
        this.pagingData_ = null;
        this.bitField0_ &= -2;
    }

    private void clearState() {
        this.state_ = 0;
    }

    public static AdvertisementOuterClass$RequestGetCampaignAds getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergePagingData(AdvertisementStruct$PagingData advertisementStruct$PagingData) {
        advertisementStruct$PagingData.getClass();
        AdvertisementStruct$PagingData advertisementStruct$PagingData2 = this.pagingData_;
        if (advertisementStruct$PagingData2 == null || advertisementStruct$PagingData2 == AdvertisementStruct$PagingData.getDefaultInstance()) {
            this.pagingData_ = advertisementStruct$PagingData;
        } else {
            this.pagingData_ = (AdvertisementStruct$PagingData) ((AdvertisementStruct$PagingData.a) AdvertisementStruct$PagingData.newBuilder(this.pagingData_).v(advertisementStruct$PagingData)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AdvertisementOuterClass$RequestGetCampaignAds parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$RequestGetCampaignAds) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$RequestGetCampaignAds parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementOuterClass$RequestGetCampaignAds) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setPagingData(AdvertisementStruct$PagingData advertisementStruct$PagingData) {
        advertisementStruct$PagingData.getClass();
        this.pagingData_ = advertisementStruct$PagingData;
        this.bitField0_ |= 1;
    }

    private void setState(EnumC25061zg enumC25061zg) {
        this.state_ = enumC25061zg.getNumber();
    }

    private void setStateValue(int i) {
        this.state_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1840b.a[gVar.ordinal()]) {
            case 1:
                return new AdvertisementOuterClass$RequestGetCampaignAds();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002\f", new Object[]{"bitField0_", "pagingData_", "state_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementOuterClass$RequestGetCampaignAds.class) {
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

    public AdvertisementStruct$PagingData getPagingData() {
        AdvertisementStruct$PagingData advertisementStruct$PagingData = this.pagingData_;
        return advertisementStruct$PagingData == null ? AdvertisementStruct$PagingData.getDefaultInstance() : advertisementStruct$PagingData;
    }

    public EnumC25061zg getState() {
        EnumC25061zg enumC25061zgJ = EnumC25061zg.j(this.state_);
        return enumC25061zgJ == null ? EnumC25061zg.UNRECOGNIZED : enumC25061zgJ;
    }

    public int getStateValue() {
        return this.state_;
    }

    public boolean hasPagingData() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(AdvertisementOuterClass$RequestGetCampaignAds advertisementOuterClass$RequestGetCampaignAds) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementOuterClass$RequestGetCampaignAds);
    }

    public static AdvertisementOuterClass$RequestGetCampaignAds parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestGetCampaignAds) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$RequestGetCampaignAds parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestGetCampaignAds) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementOuterClass$RequestGetCampaignAds parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementOuterClass$RequestGetCampaignAds) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AdvertisementOuterClass$RequestGetCampaignAds parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestGetCampaignAds) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementOuterClass$RequestGetCampaignAds parseFrom(byte[] bArr) {
        return (AdvertisementOuterClass$RequestGetCampaignAds) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementOuterClass$RequestGetCampaignAds parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestGetCampaignAds) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AdvertisementOuterClass$RequestGetCampaignAds parseFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$RequestGetCampaignAds) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$RequestGetCampaignAds parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestGetCampaignAds) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$RequestGetCampaignAds parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementOuterClass$RequestGetCampaignAds) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementOuterClass$RequestGetCampaignAds parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestGetCampaignAds) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
