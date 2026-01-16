package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes8.dex */
public final class AdvertisementOuterClass$RequestShowAds extends GeneratedMessageLite implements U64 {
    private static final AdvertisementOuterClass$RequestShowAds DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int SHOW_SPONSORED_AD_FIELD_NUMBER = 1;
    private boolean showSponsoredAd_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(AdvertisementOuterClass$RequestShowAds.DEFAULT_INSTANCE);
        }
    }

    static {
        AdvertisementOuterClass$RequestShowAds advertisementOuterClass$RequestShowAds = new AdvertisementOuterClass$RequestShowAds();
        DEFAULT_INSTANCE = advertisementOuterClass$RequestShowAds;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementOuterClass$RequestShowAds.class, advertisementOuterClass$RequestShowAds);
    }

    private AdvertisementOuterClass$RequestShowAds() {
    }

    private void clearShowSponsoredAd() {
        this.showSponsoredAd_ = false;
    }

    public static AdvertisementOuterClass$RequestShowAds getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AdvertisementOuterClass$RequestShowAds parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$RequestShowAds) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$RequestShowAds parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementOuterClass$RequestShowAds) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setShowSponsoredAd(boolean z) {
        this.showSponsoredAd_ = z;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1840b.a[gVar.ordinal()]) {
            case 1:
                return new AdvertisementOuterClass$RequestShowAds();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0007", new Object[]{"showSponsoredAd_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementOuterClass$RequestShowAds.class) {
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

    public boolean getShowSponsoredAd() {
        return this.showSponsoredAd_;
    }

    public static a newBuilder(AdvertisementOuterClass$RequestShowAds advertisementOuterClass$RequestShowAds) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementOuterClass$RequestShowAds);
    }

    public static AdvertisementOuterClass$RequestShowAds parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestShowAds) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$RequestShowAds parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestShowAds) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementOuterClass$RequestShowAds parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementOuterClass$RequestShowAds) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AdvertisementOuterClass$RequestShowAds parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestShowAds) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementOuterClass$RequestShowAds parseFrom(byte[] bArr) {
        return (AdvertisementOuterClass$RequestShowAds) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementOuterClass$RequestShowAds parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestShowAds) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AdvertisementOuterClass$RequestShowAds parseFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$RequestShowAds) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$RequestShowAds parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestShowAds) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$RequestShowAds parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementOuterClass$RequestShowAds) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementOuterClass$RequestShowAds parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestShowAds) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
