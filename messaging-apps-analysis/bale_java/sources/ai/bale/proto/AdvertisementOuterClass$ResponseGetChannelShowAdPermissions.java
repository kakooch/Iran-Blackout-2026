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
public final class AdvertisementOuterClass$ResponseGetChannelShowAdPermissions extends GeneratedMessageLite implements U64 {
    private static final AdvertisementOuterClass$ResponseGetChannelShowAdPermissions DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int SHOW_SPONSORED_AD_FIELD_NUMBER = 1;
    public static final int VERIFIED_USER_ID_FIELD_NUMBER = 2;
    private boolean showSponsoredAd_;
    private int verifiedUserId_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(AdvertisementOuterClass$ResponseGetChannelShowAdPermissions.DEFAULT_INSTANCE);
        }
    }

    static {
        AdvertisementOuterClass$ResponseGetChannelShowAdPermissions advertisementOuterClass$ResponseGetChannelShowAdPermissions = new AdvertisementOuterClass$ResponseGetChannelShowAdPermissions();
        DEFAULT_INSTANCE = advertisementOuterClass$ResponseGetChannelShowAdPermissions;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementOuterClass$ResponseGetChannelShowAdPermissions.class, advertisementOuterClass$ResponseGetChannelShowAdPermissions);
    }

    private AdvertisementOuterClass$ResponseGetChannelShowAdPermissions() {
    }

    private void clearShowSponsoredAd() {
        this.showSponsoredAd_ = false;
    }

    private void clearVerifiedUserId() {
        this.verifiedUserId_ = 0;
    }

    public static AdvertisementOuterClass$ResponseGetChannelShowAdPermissions getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AdvertisementOuterClass$ResponseGetChannelShowAdPermissions parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$ResponseGetChannelShowAdPermissions) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$ResponseGetChannelShowAdPermissions parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementOuterClass$ResponseGetChannelShowAdPermissions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setShowSponsoredAd(boolean z) {
        this.showSponsoredAd_ = z;
    }

    private void setVerifiedUserId(int i) {
        this.verifiedUserId_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1840b.a[gVar.ordinal()]) {
            case 1:
                return new AdvertisementOuterClass$ResponseGetChannelShowAdPermissions();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0007\u0002\u0004", new Object[]{"showSponsoredAd_", "verifiedUserId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementOuterClass$ResponseGetChannelShowAdPermissions.class) {
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

    public int getVerifiedUserId() {
        return this.verifiedUserId_;
    }

    public static a newBuilder(AdvertisementOuterClass$ResponseGetChannelShowAdPermissions advertisementOuterClass$ResponseGetChannelShowAdPermissions) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementOuterClass$ResponseGetChannelShowAdPermissions);
    }

    public static AdvertisementOuterClass$ResponseGetChannelShowAdPermissions parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetChannelShowAdPermissions) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetChannelShowAdPermissions parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetChannelShowAdPermissions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetChannelShowAdPermissions parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementOuterClass$ResponseGetChannelShowAdPermissions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AdvertisementOuterClass$ResponseGetChannelShowAdPermissions parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetChannelShowAdPermissions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetChannelShowAdPermissions parseFrom(byte[] bArr) {
        return (AdvertisementOuterClass$ResponseGetChannelShowAdPermissions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementOuterClass$ResponseGetChannelShowAdPermissions parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetChannelShowAdPermissions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetChannelShowAdPermissions parseFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$ResponseGetChannelShowAdPermissions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$ResponseGetChannelShowAdPermissions parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetChannelShowAdPermissions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetChannelShowAdPermissions parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementOuterClass$ResponseGetChannelShowAdPermissions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementOuterClass$ResponseGetChannelShowAdPermissions parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetChannelShowAdPermissions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
