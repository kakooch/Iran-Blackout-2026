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
public final class AdvertisementOuterClass$RequestSubmitPhotoForBaleCustomAd extends GeneratedMessageLite implements U64 {
    public static final int AD_ID_FIELD_NUMBER = 1;
    private static final AdvertisementOuterClass$RequestSubmitPhotoForBaleCustomAd DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int PIC_FIELD_NUMBER = 2;
    private String adId_ = "";
    private String pic_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(AdvertisementOuterClass$RequestSubmitPhotoForBaleCustomAd.DEFAULT_INSTANCE);
        }
    }

    static {
        AdvertisementOuterClass$RequestSubmitPhotoForBaleCustomAd advertisementOuterClass$RequestSubmitPhotoForBaleCustomAd = new AdvertisementOuterClass$RequestSubmitPhotoForBaleCustomAd();
        DEFAULT_INSTANCE = advertisementOuterClass$RequestSubmitPhotoForBaleCustomAd;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementOuterClass$RequestSubmitPhotoForBaleCustomAd.class, advertisementOuterClass$RequestSubmitPhotoForBaleCustomAd);
    }

    private AdvertisementOuterClass$RequestSubmitPhotoForBaleCustomAd() {
    }

    private void clearAdId() {
        this.adId_ = getDefaultInstance().getAdId();
    }

    private void clearPic() {
        this.pic_ = getDefaultInstance().getPic();
    }

    public static AdvertisementOuterClass$RequestSubmitPhotoForBaleCustomAd getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AdvertisementOuterClass$RequestSubmitPhotoForBaleCustomAd parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$RequestSubmitPhotoForBaleCustomAd) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$RequestSubmitPhotoForBaleCustomAd parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementOuterClass$RequestSubmitPhotoForBaleCustomAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
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

    private void setPic(String str) {
        str.getClass();
        this.pic_ = str;
    }

    private void setPicBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.pic_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1840b.a[gVar.ordinal()]) {
            case 1:
                return new AdvertisementOuterClass$RequestSubmitPhotoForBaleCustomAd();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ", new Object[]{"adId_", "pic_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementOuterClass$RequestSubmitPhotoForBaleCustomAd.class) {
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

    public String getPic() {
        return this.pic_;
    }

    public AbstractC2383g getPicBytes() {
        return AbstractC2383g.N(this.pic_);
    }

    public static a newBuilder(AdvertisementOuterClass$RequestSubmitPhotoForBaleCustomAd advertisementOuterClass$RequestSubmitPhotoForBaleCustomAd) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementOuterClass$RequestSubmitPhotoForBaleCustomAd);
    }

    public static AdvertisementOuterClass$RequestSubmitPhotoForBaleCustomAd parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestSubmitPhotoForBaleCustomAd) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$RequestSubmitPhotoForBaleCustomAd parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestSubmitPhotoForBaleCustomAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementOuterClass$RequestSubmitPhotoForBaleCustomAd parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementOuterClass$RequestSubmitPhotoForBaleCustomAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AdvertisementOuterClass$RequestSubmitPhotoForBaleCustomAd parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestSubmitPhotoForBaleCustomAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementOuterClass$RequestSubmitPhotoForBaleCustomAd parseFrom(byte[] bArr) {
        return (AdvertisementOuterClass$RequestSubmitPhotoForBaleCustomAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementOuterClass$RequestSubmitPhotoForBaleCustomAd parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestSubmitPhotoForBaleCustomAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AdvertisementOuterClass$RequestSubmitPhotoForBaleCustomAd parseFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$RequestSubmitPhotoForBaleCustomAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$RequestSubmitPhotoForBaleCustomAd parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestSubmitPhotoForBaleCustomAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$RequestSubmitPhotoForBaleCustomAd parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementOuterClass$RequestSubmitPhotoForBaleCustomAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementOuterClass$RequestSubmitPhotoForBaleCustomAd parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestSubmitPhotoForBaleCustomAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
