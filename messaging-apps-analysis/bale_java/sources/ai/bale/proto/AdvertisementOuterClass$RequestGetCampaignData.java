package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes8.dex */
public final class AdvertisementOuterClass$RequestGetCampaignData extends GeneratedMessageLite implements U64 {
    public static final int CAMPAIGN_ID_FIELD_NUMBER = 1;
    private static final AdvertisementOuterClass$RequestGetCampaignData DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private String campaignId_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(AdvertisementOuterClass$RequestGetCampaignData.DEFAULT_INSTANCE);
        }
    }

    static {
        AdvertisementOuterClass$RequestGetCampaignData advertisementOuterClass$RequestGetCampaignData = new AdvertisementOuterClass$RequestGetCampaignData();
        DEFAULT_INSTANCE = advertisementOuterClass$RequestGetCampaignData;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementOuterClass$RequestGetCampaignData.class, advertisementOuterClass$RequestGetCampaignData);
    }

    private AdvertisementOuterClass$RequestGetCampaignData() {
    }

    private void clearCampaignId() {
        this.campaignId_ = getDefaultInstance().getCampaignId();
    }

    public static AdvertisementOuterClass$RequestGetCampaignData getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AdvertisementOuterClass$RequestGetCampaignData parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$RequestGetCampaignData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$RequestGetCampaignData parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementOuterClass$RequestGetCampaignData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
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

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1840b.a[gVar.ordinal()]) {
            case 1:
                return new AdvertisementOuterClass$RequestGetCampaignData();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"campaignId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementOuterClass$RequestGetCampaignData.class) {
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

    public static a newBuilder(AdvertisementOuterClass$RequestGetCampaignData advertisementOuterClass$RequestGetCampaignData) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementOuterClass$RequestGetCampaignData);
    }

    public static AdvertisementOuterClass$RequestGetCampaignData parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestGetCampaignData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$RequestGetCampaignData parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestGetCampaignData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementOuterClass$RequestGetCampaignData parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementOuterClass$RequestGetCampaignData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AdvertisementOuterClass$RequestGetCampaignData parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestGetCampaignData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementOuterClass$RequestGetCampaignData parseFrom(byte[] bArr) {
        return (AdvertisementOuterClass$RequestGetCampaignData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementOuterClass$RequestGetCampaignData parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestGetCampaignData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AdvertisementOuterClass$RequestGetCampaignData parseFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$RequestGetCampaignData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$RequestGetCampaignData parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestGetCampaignData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$RequestGetCampaignData parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementOuterClass$RequestGetCampaignData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementOuterClass$RequestGetCampaignData parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestGetCampaignData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
