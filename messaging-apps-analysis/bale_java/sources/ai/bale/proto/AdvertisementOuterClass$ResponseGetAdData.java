package ai.bale.proto;

import ai.bale.proto.AdvertisementStruct$AdData;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes8.dex */
public final class AdvertisementOuterClass$ResponseGetAdData extends GeneratedMessageLite implements U64 {
    public static final int AD_DATA_FIELD_NUMBER = 1;
    private static final AdvertisementOuterClass$ResponseGetAdData DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private AdvertisementStruct$AdData adData_;
    private int bitField0_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(AdvertisementOuterClass$ResponseGetAdData.DEFAULT_INSTANCE);
        }
    }

    static {
        AdvertisementOuterClass$ResponseGetAdData advertisementOuterClass$ResponseGetAdData = new AdvertisementOuterClass$ResponseGetAdData();
        DEFAULT_INSTANCE = advertisementOuterClass$ResponseGetAdData;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementOuterClass$ResponseGetAdData.class, advertisementOuterClass$ResponseGetAdData);
    }

    private AdvertisementOuterClass$ResponseGetAdData() {
    }

    private void clearAdData() {
        this.adData_ = null;
        this.bitField0_ &= -2;
    }

    public static AdvertisementOuterClass$ResponseGetAdData getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeAdData(AdvertisementStruct$AdData advertisementStruct$AdData) {
        advertisementStruct$AdData.getClass();
        AdvertisementStruct$AdData advertisementStruct$AdData2 = this.adData_;
        if (advertisementStruct$AdData2 == null || advertisementStruct$AdData2 == AdvertisementStruct$AdData.getDefaultInstance()) {
            this.adData_ = advertisementStruct$AdData;
        } else {
            this.adData_ = (AdvertisementStruct$AdData) ((AdvertisementStruct$AdData.a) AdvertisementStruct$AdData.newBuilder(this.adData_).v(advertisementStruct$AdData)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AdvertisementOuterClass$ResponseGetAdData parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$ResponseGetAdData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$ResponseGetAdData parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementOuterClass$ResponseGetAdData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAdData(AdvertisementStruct$AdData advertisementStruct$AdData) {
        advertisementStruct$AdData.getClass();
        this.adData_ = advertisementStruct$AdData;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1840b.a[gVar.ordinal()]) {
            case 1:
                return new AdvertisementOuterClass$ResponseGetAdData();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "adData_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementOuterClass$ResponseGetAdData.class) {
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

    public AdvertisementStruct$AdData getAdData() {
        AdvertisementStruct$AdData advertisementStruct$AdData = this.adData_;
        return advertisementStruct$AdData == null ? AdvertisementStruct$AdData.getDefaultInstance() : advertisementStruct$AdData;
    }

    public boolean hasAdData() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(AdvertisementOuterClass$ResponseGetAdData advertisementOuterClass$ResponseGetAdData) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementOuterClass$ResponseGetAdData);
    }

    public static AdvertisementOuterClass$ResponseGetAdData parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetAdData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetAdData parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetAdData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetAdData parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementOuterClass$ResponseGetAdData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AdvertisementOuterClass$ResponseGetAdData parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetAdData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetAdData parseFrom(byte[] bArr) {
        return (AdvertisementOuterClass$ResponseGetAdData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementOuterClass$ResponseGetAdData parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetAdData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetAdData parseFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$ResponseGetAdData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$ResponseGetAdData parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetAdData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetAdData parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementOuterClass$ResponseGetAdData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementOuterClass$ResponseGetAdData parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetAdData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
