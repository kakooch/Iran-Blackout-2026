package ai.bale.proto;

import ai.bale.proto.AdvertisementStruct$AdContentV2;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes8.dex */
public final class AdvertisementOuterClass$ResponseGetAdsBySpotAndPlatform extends GeneratedMessageLite implements U64 {
    public static final int DATA_FIELD_NUMBER = 1;
    private static final AdvertisementOuterClass$ResponseGetAdsBySpotAndPlatform DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private AdvertisementStruct$AdContentV2 data_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(AdvertisementOuterClass$ResponseGetAdsBySpotAndPlatform.DEFAULT_INSTANCE);
        }
    }

    static {
        AdvertisementOuterClass$ResponseGetAdsBySpotAndPlatform advertisementOuterClass$ResponseGetAdsBySpotAndPlatform = new AdvertisementOuterClass$ResponseGetAdsBySpotAndPlatform();
        DEFAULT_INSTANCE = advertisementOuterClass$ResponseGetAdsBySpotAndPlatform;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementOuterClass$ResponseGetAdsBySpotAndPlatform.class, advertisementOuterClass$ResponseGetAdsBySpotAndPlatform);
    }

    private AdvertisementOuterClass$ResponseGetAdsBySpotAndPlatform() {
    }

    private void clearData() {
        this.data_ = null;
        this.bitField0_ &= -2;
    }

    public static AdvertisementOuterClass$ResponseGetAdsBySpotAndPlatform getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeData(AdvertisementStruct$AdContentV2 advertisementStruct$AdContentV2) {
        advertisementStruct$AdContentV2.getClass();
        AdvertisementStruct$AdContentV2 advertisementStruct$AdContentV22 = this.data_;
        if (advertisementStruct$AdContentV22 == null || advertisementStruct$AdContentV22 == AdvertisementStruct$AdContentV2.getDefaultInstance()) {
            this.data_ = advertisementStruct$AdContentV2;
        } else {
            this.data_ = (AdvertisementStruct$AdContentV2) ((AdvertisementStruct$AdContentV2.a) AdvertisementStruct$AdContentV2.newBuilder(this.data_).v(advertisementStruct$AdContentV2)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AdvertisementOuterClass$ResponseGetAdsBySpotAndPlatform parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$ResponseGetAdsBySpotAndPlatform) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$ResponseGetAdsBySpotAndPlatform parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementOuterClass$ResponseGetAdsBySpotAndPlatform) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setData(AdvertisementStruct$AdContentV2 advertisementStruct$AdContentV2) {
        advertisementStruct$AdContentV2.getClass();
        this.data_ = advertisementStruct$AdContentV2;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1840b.a[gVar.ordinal()]) {
            case 1:
                return new AdvertisementOuterClass$ResponseGetAdsBySpotAndPlatform();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "data_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementOuterClass$ResponseGetAdsBySpotAndPlatform.class) {
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

    public AdvertisementStruct$AdContentV2 getData() {
        AdvertisementStruct$AdContentV2 advertisementStruct$AdContentV2 = this.data_;
        return advertisementStruct$AdContentV2 == null ? AdvertisementStruct$AdContentV2.getDefaultInstance() : advertisementStruct$AdContentV2;
    }

    public boolean hasData() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(AdvertisementOuterClass$ResponseGetAdsBySpotAndPlatform advertisementOuterClass$ResponseGetAdsBySpotAndPlatform) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementOuterClass$ResponseGetAdsBySpotAndPlatform);
    }

    public static AdvertisementOuterClass$ResponseGetAdsBySpotAndPlatform parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetAdsBySpotAndPlatform) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetAdsBySpotAndPlatform parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetAdsBySpotAndPlatform) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetAdsBySpotAndPlatform parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementOuterClass$ResponseGetAdsBySpotAndPlatform) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AdvertisementOuterClass$ResponseGetAdsBySpotAndPlatform parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetAdsBySpotAndPlatform) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetAdsBySpotAndPlatform parseFrom(byte[] bArr) {
        return (AdvertisementOuterClass$ResponseGetAdsBySpotAndPlatform) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementOuterClass$ResponseGetAdsBySpotAndPlatform parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetAdsBySpotAndPlatform) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetAdsBySpotAndPlatform parseFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$ResponseGetAdsBySpotAndPlatform) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$ResponseGetAdsBySpotAndPlatform parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetAdsBySpotAndPlatform) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetAdsBySpotAndPlatform parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementOuterClass$ResponseGetAdsBySpotAndPlatform) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementOuterClass$ResponseGetAdsBySpotAndPlatform parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetAdsBySpotAndPlatform) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
