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
public final class Advertisementnew$ResponseGetAdData extends GeneratedMessageLite implements U64 {
    public static final int AD_DATA_FIELD_NUMBER = 1;
    private static final Advertisementnew$ResponseGetAdData DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private AdvertisementnewStruct$AdData adData_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Advertisementnew$ResponseGetAdData.DEFAULT_INSTANCE);
        }
    }

    static {
        Advertisementnew$ResponseGetAdData advertisementnew$ResponseGetAdData = new Advertisementnew$ResponseGetAdData();
        DEFAULT_INSTANCE = advertisementnew$ResponseGetAdData;
        GeneratedMessageLite.registerDefaultInstance(Advertisementnew$ResponseGetAdData.class, advertisementnew$ResponseGetAdData);
    }

    private Advertisementnew$ResponseGetAdData() {
    }

    private void clearAdData() {
        this.adData_ = null;
    }

    public static Advertisementnew$ResponseGetAdData getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeAdData(AdvertisementnewStruct$AdData advertisementnewStruct$AdData) {
        advertisementnewStruct$AdData.getClass();
        AdvertisementnewStruct$AdData advertisementnewStruct$AdData2 = this.adData_;
        if (advertisementnewStruct$AdData2 == null || advertisementnewStruct$AdData2 == AdvertisementnewStruct$AdData.getDefaultInstance()) {
            this.adData_ = advertisementnewStruct$AdData;
        } else {
            this.adData_ = (AdvertisementnewStruct$AdData) ((AdvertisementnewStruct$AdData.a) AdvertisementnewStruct$AdData.newBuilder(this.adData_).v(advertisementnewStruct$AdData)).j();
        }
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Advertisementnew$ResponseGetAdData parseDelimitedFrom(InputStream inputStream) {
        return (Advertisementnew$ResponseGetAdData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Advertisementnew$ResponseGetAdData parseFrom(ByteBuffer byteBuffer) {
        return (Advertisementnew$ResponseGetAdData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAdData(AdvertisementnewStruct$AdData advertisementnewStruct$AdData) {
        advertisementnewStruct$AdData.getClass();
        this.adData_ = advertisementnewStruct$AdData;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1849e.a[gVar.ordinal()]) {
            case 1:
                return new Advertisementnew$ResponseGetAdData();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\t", new Object[]{"adData_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Advertisementnew$ResponseGetAdData.class) {
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

    public AdvertisementnewStruct$AdData getAdData() {
        AdvertisementnewStruct$AdData advertisementnewStruct$AdData = this.adData_;
        return advertisementnewStruct$AdData == null ? AdvertisementnewStruct$AdData.getDefaultInstance() : advertisementnewStruct$AdData;
    }

    public boolean hasAdData() {
        return this.adData_ != null;
    }

    public static a newBuilder(Advertisementnew$ResponseGetAdData advertisementnew$ResponseGetAdData) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementnew$ResponseGetAdData);
    }

    public static Advertisementnew$ResponseGetAdData parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Advertisementnew$ResponseGetAdData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Advertisementnew$ResponseGetAdData parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Advertisementnew$ResponseGetAdData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Advertisementnew$ResponseGetAdData parseFrom(AbstractC2383g abstractC2383g) {
        return (Advertisementnew$ResponseGetAdData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static Advertisementnew$ResponseGetAdData parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Advertisementnew$ResponseGetAdData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Advertisementnew$ResponseGetAdData parseFrom(byte[] bArr) {
        return (Advertisementnew$ResponseGetAdData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Advertisementnew$ResponseGetAdData parseFrom(byte[] bArr, C2394s c2394s) {
        return (Advertisementnew$ResponseGetAdData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Advertisementnew$ResponseGetAdData parseFrom(InputStream inputStream) {
        return (Advertisementnew$ResponseGetAdData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Advertisementnew$ResponseGetAdData parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Advertisementnew$ResponseGetAdData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Advertisementnew$ResponseGetAdData parseFrom(AbstractC2384h abstractC2384h) {
        return (Advertisementnew$ResponseGetAdData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Advertisementnew$ResponseGetAdData parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Advertisementnew$ResponseGetAdData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
