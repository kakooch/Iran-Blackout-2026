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

/* loaded from: classes9.dex */
public final class AdvertisementStruct$YektanetAd extends GeneratedMessageLite implements U64 {
    private static final AdvertisementStruct$YektanetAd DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int PLACEMENT_ID_FIELD_NUMBER = 1;
    private String placementId_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(AdvertisementStruct$YektanetAd.DEFAULT_INSTANCE);
        }
    }

    static {
        AdvertisementStruct$YektanetAd advertisementStruct$YektanetAd = new AdvertisementStruct$YektanetAd();
        DEFAULT_INSTANCE = advertisementStruct$YektanetAd;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementStruct$YektanetAd.class, advertisementStruct$YektanetAd);
    }

    private AdvertisementStruct$YektanetAd() {
    }

    private void clearPlacementId() {
        this.placementId_ = getDefaultInstance().getPlacementId();
    }

    public static AdvertisementStruct$YektanetAd getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AdvertisementStruct$YektanetAd parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementStruct$YektanetAd) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementStruct$YektanetAd parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementStruct$YektanetAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setPlacementId(String str) {
        str.getClass();
        this.placementId_ = str;
    }

    private void setPlacementIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.placementId_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1843c.a[gVar.ordinal()]) {
            case 1:
                return new AdvertisementStruct$YektanetAd();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"placementId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementStruct$YektanetAd.class) {
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

    public String getPlacementId() {
        return this.placementId_;
    }

    public AbstractC2383g getPlacementIdBytes() {
        return AbstractC2383g.N(this.placementId_);
    }

    public static a newBuilder(AdvertisementStruct$YektanetAd advertisementStruct$YektanetAd) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementStruct$YektanetAd);
    }

    public static AdvertisementStruct$YektanetAd parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementStruct$YektanetAd) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementStruct$YektanetAd parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementStruct$YektanetAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementStruct$YektanetAd parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementStruct$YektanetAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AdvertisementStruct$YektanetAd parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementStruct$YektanetAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementStruct$YektanetAd parseFrom(byte[] bArr) {
        return (AdvertisementStruct$YektanetAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementStruct$YektanetAd parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementStruct$YektanetAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AdvertisementStruct$YektanetAd parseFrom(InputStream inputStream) {
        return (AdvertisementStruct$YektanetAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementStruct$YektanetAd parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementStruct$YektanetAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementStruct$YektanetAd parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementStruct$YektanetAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementStruct$YektanetAd parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementStruct$YektanetAd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
