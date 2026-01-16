package ai.bale.proto;

import ai.bale.proto.AdvertisementnewStruct$AdContentV2;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class Advertisementnew$ResponseGetAdsBySpotAndPlatform extends GeneratedMessageLite implements U64 {
    public static final int DATA_FIELD_NUMBER = 1;
    private static final Advertisementnew$ResponseGetAdsBySpotAndPlatform DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private AdvertisementnewStruct$AdContentV2 data_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Advertisementnew$ResponseGetAdsBySpotAndPlatform.DEFAULT_INSTANCE);
        }
    }

    static {
        Advertisementnew$ResponseGetAdsBySpotAndPlatform advertisementnew$ResponseGetAdsBySpotAndPlatform = new Advertisementnew$ResponseGetAdsBySpotAndPlatform();
        DEFAULT_INSTANCE = advertisementnew$ResponseGetAdsBySpotAndPlatform;
        GeneratedMessageLite.registerDefaultInstance(Advertisementnew$ResponseGetAdsBySpotAndPlatform.class, advertisementnew$ResponseGetAdsBySpotAndPlatform);
    }

    private Advertisementnew$ResponseGetAdsBySpotAndPlatform() {
    }

    private void clearData() {
        this.data_ = null;
    }

    public static Advertisementnew$ResponseGetAdsBySpotAndPlatform getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeData(AdvertisementnewStruct$AdContentV2 advertisementnewStruct$AdContentV2) {
        advertisementnewStruct$AdContentV2.getClass();
        AdvertisementnewStruct$AdContentV2 advertisementnewStruct$AdContentV22 = this.data_;
        if (advertisementnewStruct$AdContentV22 == null || advertisementnewStruct$AdContentV22 == AdvertisementnewStruct$AdContentV2.getDefaultInstance()) {
            this.data_ = advertisementnewStruct$AdContentV2;
        } else {
            this.data_ = (AdvertisementnewStruct$AdContentV2) ((AdvertisementnewStruct$AdContentV2.a) AdvertisementnewStruct$AdContentV2.newBuilder(this.data_).v(advertisementnewStruct$AdContentV2)).j();
        }
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Advertisementnew$ResponseGetAdsBySpotAndPlatform parseDelimitedFrom(InputStream inputStream) {
        return (Advertisementnew$ResponseGetAdsBySpotAndPlatform) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Advertisementnew$ResponseGetAdsBySpotAndPlatform parseFrom(ByteBuffer byteBuffer) {
        return (Advertisementnew$ResponseGetAdsBySpotAndPlatform) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setData(AdvertisementnewStruct$AdContentV2 advertisementnewStruct$AdContentV2) {
        advertisementnewStruct$AdContentV2.getClass();
        this.data_ = advertisementnewStruct$AdContentV2;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1849e.a[gVar.ordinal()]) {
            case 1:
                return new Advertisementnew$ResponseGetAdsBySpotAndPlatform();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\t", new Object[]{"data_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Advertisementnew$ResponseGetAdsBySpotAndPlatform.class) {
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

    public AdvertisementnewStruct$AdContentV2 getData() {
        AdvertisementnewStruct$AdContentV2 advertisementnewStruct$AdContentV2 = this.data_;
        return advertisementnewStruct$AdContentV2 == null ? AdvertisementnewStruct$AdContentV2.getDefaultInstance() : advertisementnewStruct$AdContentV2;
    }

    public boolean hasData() {
        return this.data_ != null;
    }

    public static a newBuilder(Advertisementnew$ResponseGetAdsBySpotAndPlatform advertisementnew$ResponseGetAdsBySpotAndPlatform) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementnew$ResponseGetAdsBySpotAndPlatform);
    }

    public static Advertisementnew$ResponseGetAdsBySpotAndPlatform parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Advertisementnew$ResponseGetAdsBySpotAndPlatform) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Advertisementnew$ResponseGetAdsBySpotAndPlatform parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Advertisementnew$ResponseGetAdsBySpotAndPlatform) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Advertisementnew$ResponseGetAdsBySpotAndPlatform parseFrom(AbstractC2383g abstractC2383g) {
        return (Advertisementnew$ResponseGetAdsBySpotAndPlatform) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static Advertisementnew$ResponseGetAdsBySpotAndPlatform parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Advertisementnew$ResponseGetAdsBySpotAndPlatform) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Advertisementnew$ResponseGetAdsBySpotAndPlatform parseFrom(byte[] bArr) {
        return (Advertisementnew$ResponseGetAdsBySpotAndPlatform) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Advertisementnew$ResponseGetAdsBySpotAndPlatform parseFrom(byte[] bArr, C2394s c2394s) {
        return (Advertisementnew$ResponseGetAdsBySpotAndPlatform) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Advertisementnew$ResponseGetAdsBySpotAndPlatform parseFrom(InputStream inputStream) {
        return (Advertisementnew$ResponseGetAdsBySpotAndPlatform) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Advertisementnew$ResponseGetAdsBySpotAndPlatform parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Advertisementnew$ResponseGetAdsBySpotAndPlatform) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Advertisementnew$ResponseGetAdsBySpotAndPlatform parseFrom(AbstractC2384h abstractC2384h) {
        return (Advertisementnew$ResponseGetAdsBySpotAndPlatform) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Advertisementnew$ResponseGetAdsBySpotAndPlatform parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Advertisementnew$ResponseGetAdsBySpotAndPlatform) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
