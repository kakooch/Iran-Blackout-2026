package ai.bale.proto;

import ai.bale.proto.AdvertisementStruct$BusinessAdData;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes8.dex */
public final class AdvertisementOuterClass$RequestUpdateBusinessAd extends GeneratedMessageLite implements U64 {
    private static final AdvertisementOuterClass$RequestUpdateBusinessAd DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int UPDATED_AD_FIELD_NUMBER = 1;
    private int bitField0_;
    private AdvertisementStruct$BusinessAdData updatedAd_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(AdvertisementOuterClass$RequestUpdateBusinessAd.DEFAULT_INSTANCE);
        }
    }

    static {
        AdvertisementOuterClass$RequestUpdateBusinessAd advertisementOuterClass$RequestUpdateBusinessAd = new AdvertisementOuterClass$RequestUpdateBusinessAd();
        DEFAULT_INSTANCE = advertisementOuterClass$RequestUpdateBusinessAd;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementOuterClass$RequestUpdateBusinessAd.class, advertisementOuterClass$RequestUpdateBusinessAd);
    }

    private AdvertisementOuterClass$RequestUpdateBusinessAd() {
    }

    private void clearUpdatedAd() {
        this.updatedAd_ = null;
        this.bitField0_ &= -2;
    }

    public static AdvertisementOuterClass$RequestUpdateBusinessAd getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeUpdatedAd(AdvertisementStruct$BusinessAdData advertisementStruct$BusinessAdData) {
        advertisementStruct$BusinessAdData.getClass();
        AdvertisementStruct$BusinessAdData advertisementStruct$BusinessAdData2 = this.updatedAd_;
        if (advertisementStruct$BusinessAdData2 == null || advertisementStruct$BusinessAdData2 == AdvertisementStruct$BusinessAdData.getDefaultInstance()) {
            this.updatedAd_ = advertisementStruct$BusinessAdData;
        } else {
            this.updatedAd_ = (AdvertisementStruct$BusinessAdData) ((AdvertisementStruct$BusinessAdData.a) AdvertisementStruct$BusinessAdData.newBuilder(this.updatedAd_).v(advertisementStruct$BusinessAdData)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AdvertisementOuterClass$RequestUpdateBusinessAd parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$RequestUpdateBusinessAd) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$RequestUpdateBusinessAd parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementOuterClass$RequestUpdateBusinessAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setUpdatedAd(AdvertisementStruct$BusinessAdData advertisementStruct$BusinessAdData) {
        advertisementStruct$BusinessAdData.getClass();
        this.updatedAd_ = advertisementStruct$BusinessAdData;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1840b.a[gVar.ordinal()]) {
            case 1:
                return new AdvertisementOuterClass$RequestUpdateBusinessAd();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "updatedAd_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementOuterClass$RequestUpdateBusinessAd.class) {
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

    public AdvertisementStruct$BusinessAdData getUpdatedAd() {
        AdvertisementStruct$BusinessAdData advertisementStruct$BusinessAdData = this.updatedAd_;
        return advertisementStruct$BusinessAdData == null ? AdvertisementStruct$BusinessAdData.getDefaultInstance() : advertisementStruct$BusinessAdData;
    }

    public boolean hasUpdatedAd() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(AdvertisementOuterClass$RequestUpdateBusinessAd advertisementOuterClass$RequestUpdateBusinessAd) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementOuterClass$RequestUpdateBusinessAd);
    }

    public static AdvertisementOuterClass$RequestUpdateBusinessAd parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestUpdateBusinessAd) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$RequestUpdateBusinessAd parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestUpdateBusinessAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementOuterClass$RequestUpdateBusinessAd parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementOuterClass$RequestUpdateBusinessAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AdvertisementOuterClass$RequestUpdateBusinessAd parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestUpdateBusinessAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementOuterClass$RequestUpdateBusinessAd parseFrom(byte[] bArr) {
        return (AdvertisementOuterClass$RequestUpdateBusinessAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementOuterClass$RequestUpdateBusinessAd parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestUpdateBusinessAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AdvertisementOuterClass$RequestUpdateBusinessAd parseFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$RequestUpdateBusinessAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$RequestUpdateBusinessAd parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestUpdateBusinessAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$RequestUpdateBusinessAd parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementOuterClass$RequestUpdateBusinessAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementOuterClass$RequestUpdateBusinessAd parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestUpdateBusinessAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
