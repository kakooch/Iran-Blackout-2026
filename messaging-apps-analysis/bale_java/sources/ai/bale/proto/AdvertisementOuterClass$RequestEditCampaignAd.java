package ai.bale.proto;

import ai.bale.proto.AdvertisementStruct$CampaignAdData;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes8.dex */
public final class AdvertisementOuterClass$RequestEditCampaignAd extends GeneratedMessageLite implements U64 {
    public static final int AD_FIELD_NUMBER = 1;
    private static final AdvertisementOuterClass$RequestEditCampaignAd DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private AdvertisementStruct$CampaignAdData ad_;
    private int bitField0_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(AdvertisementOuterClass$RequestEditCampaignAd.DEFAULT_INSTANCE);
        }
    }

    static {
        AdvertisementOuterClass$RequestEditCampaignAd advertisementOuterClass$RequestEditCampaignAd = new AdvertisementOuterClass$RequestEditCampaignAd();
        DEFAULT_INSTANCE = advertisementOuterClass$RequestEditCampaignAd;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementOuterClass$RequestEditCampaignAd.class, advertisementOuterClass$RequestEditCampaignAd);
    }

    private AdvertisementOuterClass$RequestEditCampaignAd() {
    }

    private void clearAd() {
        this.ad_ = null;
        this.bitField0_ &= -2;
    }

    public static AdvertisementOuterClass$RequestEditCampaignAd getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeAd(AdvertisementStruct$CampaignAdData advertisementStruct$CampaignAdData) {
        advertisementStruct$CampaignAdData.getClass();
        AdvertisementStruct$CampaignAdData advertisementStruct$CampaignAdData2 = this.ad_;
        if (advertisementStruct$CampaignAdData2 == null || advertisementStruct$CampaignAdData2 == AdvertisementStruct$CampaignAdData.getDefaultInstance()) {
            this.ad_ = advertisementStruct$CampaignAdData;
        } else {
            this.ad_ = (AdvertisementStruct$CampaignAdData) ((AdvertisementStruct$CampaignAdData.a) AdvertisementStruct$CampaignAdData.newBuilder(this.ad_).v(advertisementStruct$CampaignAdData)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AdvertisementOuterClass$RequestEditCampaignAd parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$RequestEditCampaignAd) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$RequestEditCampaignAd parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementOuterClass$RequestEditCampaignAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAd(AdvertisementStruct$CampaignAdData advertisementStruct$CampaignAdData) {
        advertisementStruct$CampaignAdData.getClass();
        this.ad_ = advertisementStruct$CampaignAdData;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1840b.a[gVar.ordinal()]) {
            case 1:
                return new AdvertisementOuterClass$RequestEditCampaignAd();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "ad_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementOuterClass$RequestEditCampaignAd.class) {
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

    public AdvertisementStruct$CampaignAdData getAd() {
        AdvertisementStruct$CampaignAdData advertisementStruct$CampaignAdData = this.ad_;
        return advertisementStruct$CampaignAdData == null ? AdvertisementStruct$CampaignAdData.getDefaultInstance() : advertisementStruct$CampaignAdData;
    }

    public boolean hasAd() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(AdvertisementOuterClass$RequestEditCampaignAd advertisementOuterClass$RequestEditCampaignAd) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementOuterClass$RequestEditCampaignAd);
    }

    public static AdvertisementOuterClass$RequestEditCampaignAd parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestEditCampaignAd) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$RequestEditCampaignAd parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestEditCampaignAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementOuterClass$RequestEditCampaignAd parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementOuterClass$RequestEditCampaignAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AdvertisementOuterClass$RequestEditCampaignAd parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestEditCampaignAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementOuterClass$RequestEditCampaignAd parseFrom(byte[] bArr) {
        return (AdvertisementOuterClass$RequestEditCampaignAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementOuterClass$RequestEditCampaignAd parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestEditCampaignAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AdvertisementOuterClass$RequestEditCampaignAd parseFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$RequestEditCampaignAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$RequestEditCampaignAd parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestEditCampaignAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$RequestEditCampaignAd parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementOuterClass$RequestEditCampaignAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementOuterClass$RequestEditCampaignAd parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestEditCampaignAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
