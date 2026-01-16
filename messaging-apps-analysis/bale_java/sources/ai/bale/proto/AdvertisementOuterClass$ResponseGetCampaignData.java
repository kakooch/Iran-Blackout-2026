package ai.bale.proto;

import ai.bale.proto.AdvertisementStruct$CampaignData;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes8.dex */
public final class AdvertisementOuterClass$ResponseGetCampaignData extends GeneratedMessageLite implements U64 {
    public static final int DATA_FIELD_NUMBER = 1;
    private static final AdvertisementOuterClass$ResponseGetCampaignData DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private AdvertisementStruct$CampaignData data_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(AdvertisementOuterClass$ResponseGetCampaignData.DEFAULT_INSTANCE);
        }
    }

    static {
        AdvertisementOuterClass$ResponseGetCampaignData advertisementOuterClass$ResponseGetCampaignData = new AdvertisementOuterClass$ResponseGetCampaignData();
        DEFAULT_INSTANCE = advertisementOuterClass$ResponseGetCampaignData;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementOuterClass$ResponseGetCampaignData.class, advertisementOuterClass$ResponseGetCampaignData);
    }

    private AdvertisementOuterClass$ResponseGetCampaignData() {
    }

    private void clearData() {
        this.data_ = null;
        this.bitField0_ &= -2;
    }

    public static AdvertisementOuterClass$ResponseGetCampaignData getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeData(AdvertisementStruct$CampaignData advertisementStruct$CampaignData) {
        advertisementStruct$CampaignData.getClass();
        AdvertisementStruct$CampaignData advertisementStruct$CampaignData2 = this.data_;
        if (advertisementStruct$CampaignData2 == null || advertisementStruct$CampaignData2 == AdvertisementStruct$CampaignData.getDefaultInstance()) {
            this.data_ = advertisementStruct$CampaignData;
        } else {
            this.data_ = (AdvertisementStruct$CampaignData) ((AdvertisementStruct$CampaignData.a) AdvertisementStruct$CampaignData.newBuilder(this.data_).v(advertisementStruct$CampaignData)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AdvertisementOuterClass$ResponseGetCampaignData parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$ResponseGetCampaignData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$ResponseGetCampaignData parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementOuterClass$ResponseGetCampaignData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setData(AdvertisementStruct$CampaignData advertisementStruct$CampaignData) {
        advertisementStruct$CampaignData.getClass();
        this.data_ = advertisementStruct$CampaignData;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1840b.a[gVar.ordinal()]) {
            case 1:
                return new AdvertisementOuterClass$ResponseGetCampaignData();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "data_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementOuterClass$ResponseGetCampaignData.class) {
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

    public AdvertisementStruct$CampaignData getData() {
        AdvertisementStruct$CampaignData advertisementStruct$CampaignData = this.data_;
        return advertisementStruct$CampaignData == null ? AdvertisementStruct$CampaignData.getDefaultInstance() : advertisementStruct$CampaignData;
    }

    public boolean hasData() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(AdvertisementOuterClass$ResponseGetCampaignData advertisementOuterClass$ResponseGetCampaignData) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementOuterClass$ResponseGetCampaignData);
    }

    public static AdvertisementOuterClass$ResponseGetCampaignData parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetCampaignData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetCampaignData parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetCampaignData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetCampaignData parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementOuterClass$ResponseGetCampaignData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AdvertisementOuterClass$ResponseGetCampaignData parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetCampaignData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetCampaignData parseFrom(byte[] bArr) {
        return (AdvertisementOuterClass$ResponseGetCampaignData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementOuterClass$ResponseGetCampaignData parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetCampaignData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetCampaignData parseFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$ResponseGetCampaignData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$ResponseGetCampaignData parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetCampaignData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetCampaignData parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementOuterClass$ResponseGetCampaignData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementOuterClass$ResponseGetCampaignData parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetCampaignData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
