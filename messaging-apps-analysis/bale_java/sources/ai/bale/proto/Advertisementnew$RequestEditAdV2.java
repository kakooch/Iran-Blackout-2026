package ai.bale.proto;

import ai.bale.proto.AdvertisementnewStruct$AdData;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class Advertisementnew$RequestEditAdV2 extends GeneratedMessageLite implements U64 {
    public static final int AD_FIELD_NUMBER = 1;
    private static final Advertisementnew$RequestEditAdV2 DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private AdvertisementnewStruct$AdData ad_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Advertisementnew$RequestEditAdV2.DEFAULT_INSTANCE);
        }
    }

    static {
        Advertisementnew$RequestEditAdV2 advertisementnew$RequestEditAdV2 = new Advertisementnew$RequestEditAdV2();
        DEFAULT_INSTANCE = advertisementnew$RequestEditAdV2;
        GeneratedMessageLite.registerDefaultInstance(Advertisementnew$RequestEditAdV2.class, advertisementnew$RequestEditAdV2);
    }

    private Advertisementnew$RequestEditAdV2() {
    }

    private void clearAd() {
        this.ad_ = null;
    }

    public static Advertisementnew$RequestEditAdV2 getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeAd(AdvertisementnewStruct$AdData advertisementnewStruct$AdData) {
        advertisementnewStruct$AdData.getClass();
        AdvertisementnewStruct$AdData advertisementnewStruct$AdData2 = this.ad_;
        if (advertisementnewStruct$AdData2 == null || advertisementnewStruct$AdData2 == AdvertisementnewStruct$AdData.getDefaultInstance()) {
            this.ad_ = advertisementnewStruct$AdData;
        } else {
            this.ad_ = (AdvertisementnewStruct$AdData) ((AdvertisementnewStruct$AdData.a) AdvertisementnewStruct$AdData.newBuilder(this.ad_).v(advertisementnewStruct$AdData)).j();
        }
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Advertisementnew$RequestEditAdV2 parseDelimitedFrom(InputStream inputStream) {
        return (Advertisementnew$RequestEditAdV2) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Advertisementnew$RequestEditAdV2 parseFrom(ByteBuffer byteBuffer) {
        return (Advertisementnew$RequestEditAdV2) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAd(AdvertisementnewStruct$AdData advertisementnewStruct$AdData) {
        advertisementnewStruct$AdData.getClass();
        this.ad_ = advertisementnewStruct$AdData;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1849e.a[gVar.ordinal()]) {
            case 1:
                return new Advertisementnew$RequestEditAdV2();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\t", new Object[]{"ad_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Advertisementnew$RequestEditAdV2.class) {
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

    public AdvertisementnewStruct$AdData getAd() {
        AdvertisementnewStruct$AdData advertisementnewStruct$AdData = this.ad_;
        return advertisementnewStruct$AdData == null ? AdvertisementnewStruct$AdData.getDefaultInstance() : advertisementnewStruct$AdData;
    }

    public boolean hasAd() {
        return this.ad_ != null;
    }

    public static a newBuilder(Advertisementnew$RequestEditAdV2 advertisementnew$RequestEditAdV2) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementnew$RequestEditAdV2);
    }

    public static Advertisementnew$RequestEditAdV2 parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Advertisementnew$RequestEditAdV2) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Advertisementnew$RequestEditAdV2 parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Advertisementnew$RequestEditAdV2) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Advertisementnew$RequestEditAdV2 parseFrom(AbstractC2383g abstractC2383g) {
        return (Advertisementnew$RequestEditAdV2) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static Advertisementnew$RequestEditAdV2 parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Advertisementnew$RequestEditAdV2) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Advertisementnew$RequestEditAdV2 parseFrom(byte[] bArr) {
        return (Advertisementnew$RequestEditAdV2) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Advertisementnew$RequestEditAdV2 parseFrom(byte[] bArr, C2394s c2394s) {
        return (Advertisementnew$RequestEditAdV2) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Advertisementnew$RequestEditAdV2 parseFrom(InputStream inputStream) {
        return (Advertisementnew$RequestEditAdV2) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Advertisementnew$RequestEditAdV2 parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Advertisementnew$RequestEditAdV2) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Advertisementnew$RequestEditAdV2 parseFrom(AbstractC2384h abstractC2384h) {
        return (Advertisementnew$RequestEditAdV2) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Advertisementnew$RequestEditAdV2 parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Advertisementnew$RequestEditAdV2) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
