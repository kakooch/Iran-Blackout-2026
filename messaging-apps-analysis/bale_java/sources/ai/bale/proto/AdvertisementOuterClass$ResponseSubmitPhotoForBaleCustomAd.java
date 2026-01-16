package ai.bale.proto;

import ai.bale.proto.AdvertisementStruct$BaleCustomAdManage;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes8.dex */
public final class AdvertisementOuterClass$ResponseSubmitPhotoForBaleCustomAd extends GeneratedMessageLite implements U64 {
    public static final int AD_FIELD_NUMBER = 1;
    private static final AdvertisementOuterClass$ResponseSubmitPhotoForBaleCustomAd DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private AdvertisementStruct$BaleCustomAdManage ad_;
    private int bitField0_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(AdvertisementOuterClass$ResponseSubmitPhotoForBaleCustomAd.DEFAULT_INSTANCE);
        }
    }

    static {
        AdvertisementOuterClass$ResponseSubmitPhotoForBaleCustomAd advertisementOuterClass$ResponseSubmitPhotoForBaleCustomAd = new AdvertisementOuterClass$ResponseSubmitPhotoForBaleCustomAd();
        DEFAULT_INSTANCE = advertisementOuterClass$ResponseSubmitPhotoForBaleCustomAd;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementOuterClass$ResponseSubmitPhotoForBaleCustomAd.class, advertisementOuterClass$ResponseSubmitPhotoForBaleCustomAd);
    }

    private AdvertisementOuterClass$ResponseSubmitPhotoForBaleCustomAd() {
    }

    private void clearAd() {
        this.ad_ = null;
        this.bitField0_ &= -2;
    }

    public static AdvertisementOuterClass$ResponseSubmitPhotoForBaleCustomAd getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeAd(AdvertisementStruct$BaleCustomAdManage advertisementStruct$BaleCustomAdManage) {
        advertisementStruct$BaleCustomAdManage.getClass();
        AdvertisementStruct$BaleCustomAdManage advertisementStruct$BaleCustomAdManage2 = this.ad_;
        if (advertisementStruct$BaleCustomAdManage2 == null || advertisementStruct$BaleCustomAdManage2 == AdvertisementStruct$BaleCustomAdManage.getDefaultInstance()) {
            this.ad_ = advertisementStruct$BaleCustomAdManage;
        } else {
            this.ad_ = (AdvertisementStruct$BaleCustomAdManage) ((AdvertisementStruct$BaleCustomAdManage.a) AdvertisementStruct$BaleCustomAdManage.newBuilder(this.ad_).v(advertisementStruct$BaleCustomAdManage)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AdvertisementOuterClass$ResponseSubmitPhotoForBaleCustomAd parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$ResponseSubmitPhotoForBaleCustomAd) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$ResponseSubmitPhotoForBaleCustomAd parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementOuterClass$ResponseSubmitPhotoForBaleCustomAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAd(AdvertisementStruct$BaleCustomAdManage advertisementStruct$BaleCustomAdManage) {
        advertisementStruct$BaleCustomAdManage.getClass();
        this.ad_ = advertisementStruct$BaleCustomAdManage;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1840b.a[gVar.ordinal()]) {
            case 1:
                return new AdvertisementOuterClass$ResponseSubmitPhotoForBaleCustomAd();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "ad_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementOuterClass$ResponseSubmitPhotoForBaleCustomAd.class) {
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

    public AdvertisementStruct$BaleCustomAdManage getAd() {
        AdvertisementStruct$BaleCustomAdManage advertisementStruct$BaleCustomAdManage = this.ad_;
        return advertisementStruct$BaleCustomAdManage == null ? AdvertisementStruct$BaleCustomAdManage.getDefaultInstance() : advertisementStruct$BaleCustomAdManage;
    }

    public boolean hasAd() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(AdvertisementOuterClass$ResponseSubmitPhotoForBaleCustomAd advertisementOuterClass$ResponseSubmitPhotoForBaleCustomAd) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementOuterClass$ResponseSubmitPhotoForBaleCustomAd);
    }

    public static AdvertisementOuterClass$ResponseSubmitPhotoForBaleCustomAd parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseSubmitPhotoForBaleCustomAd) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$ResponseSubmitPhotoForBaleCustomAd parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseSubmitPhotoForBaleCustomAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementOuterClass$ResponseSubmitPhotoForBaleCustomAd parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementOuterClass$ResponseSubmitPhotoForBaleCustomAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AdvertisementOuterClass$ResponseSubmitPhotoForBaleCustomAd parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseSubmitPhotoForBaleCustomAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementOuterClass$ResponseSubmitPhotoForBaleCustomAd parseFrom(byte[] bArr) {
        return (AdvertisementOuterClass$ResponseSubmitPhotoForBaleCustomAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementOuterClass$ResponseSubmitPhotoForBaleCustomAd parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseSubmitPhotoForBaleCustomAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AdvertisementOuterClass$ResponseSubmitPhotoForBaleCustomAd parseFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$ResponseSubmitPhotoForBaleCustomAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$ResponseSubmitPhotoForBaleCustomAd parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseSubmitPhotoForBaleCustomAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$ResponseSubmitPhotoForBaleCustomAd parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementOuterClass$ResponseSubmitPhotoForBaleCustomAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementOuterClass$ResponseSubmitPhotoForBaleCustomAd parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseSubmitPhotoForBaleCustomAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
