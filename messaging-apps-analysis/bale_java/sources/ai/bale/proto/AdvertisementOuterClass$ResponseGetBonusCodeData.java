package ai.bale.proto;

import ai.bale.proto.AdvertisementStruct$BonusCodeData;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes8.dex */
public final class AdvertisementOuterClass$ResponseGetBonusCodeData extends GeneratedMessageLite implements U64 {
    public static final int DATA_FIELD_NUMBER = 1;
    private static final AdvertisementOuterClass$ResponseGetBonusCodeData DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private AdvertisementStruct$BonusCodeData data_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(AdvertisementOuterClass$ResponseGetBonusCodeData.DEFAULT_INSTANCE);
        }
    }

    static {
        AdvertisementOuterClass$ResponseGetBonusCodeData advertisementOuterClass$ResponseGetBonusCodeData = new AdvertisementOuterClass$ResponseGetBonusCodeData();
        DEFAULT_INSTANCE = advertisementOuterClass$ResponseGetBonusCodeData;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementOuterClass$ResponseGetBonusCodeData.class, advertisementOuterClass$ResponseGetBonusCodeData);
    }

    private AdvertisementOuterClass$ResponseGetBonusCodeData() {
    }

    private void clearData() {
        this.data_ = null;
        this.bitField0_ &= -2;
    }

    public static AdvertisementOuterClass$ResponseGetBonusCodeData getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeData(AdvertisementStruct$BonusCodeData advertisementStruct$BonusCodeData) {
        advertisementStruct$BonusCodeData.getClass();
        AdvertisementStruct$BonusCodeData advertisementStruct$BonusCodeData2 = this.data_;
        if (advertisementStruct$BonusCodeData2 == null || advertisementStruct$BonusCodeData2 == AdvertisementStruct$BonusCodeData.getDefaultInstance()) {
            this.data_ = advertisementStruct$BonusCodeData;
        } else {
            this.data_ = (AdvertisementStruct$BonusCodeData) ((AdvertisementStruct$BonusCodeData.a) AdvertisementStruct$BonusCodeData.newBuilder(this.data_).v(advertisementStruct$BonusCodeData)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AdvertisementOuterClass$ResponseGetBonusCodeData parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$ResponseGetBonusCodeData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$ResponseGetBonusCodeData parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementOuterClass$ResponseGetBonusCodeData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setData(AdvertisementStruct$BonusCodeData advertisementStruct$BonusCodeData) {
        advertisementStruct$BonusCodeData.getClass();
        this.data_ = advertisementStruct$BonusCodeData;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1840b.a[gVar.ordinal()]) {
            case 1:
                return new AdvertisementOuterClass$ResponseGetBonusCodeData();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "data_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementOuterClass$ResponseGetBonusCodeData.class) {
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

    public AdvertisementStruct$BonusCodeData getData() {
        AdvertisementStruct$BonusCodeData advertisementStruct$BonusCodeData = this.data_;
        return advertisementStruct$BonusCodeData == null ? AdvertisementStruct$BonusCodeData.getDefaultInstance() : advertisementStruct$BonusCodeData;
    }

    public boolean hasData() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(AdvertisementOuterClass$ResponseGetBonusCodeData advertisementOuterClass$ResponseGetBonusCodeData) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementOuterClass$ResponseGetBonusCodeData);
    }

    public static AdvertisementOuterClass$ResponseGetBonusCodeData parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetBonusCodeData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetBonusCodeData parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetBonusCodeData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetBonusCodeData parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementOuterClass$ResponseGetBonusCodeData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AdvertisementOuterClass$ResponseGetBonusCodeData parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetBonusCodeData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetBonusCodeData parseFrom(byte[] bArr) {
        return (AdvertisementOuterClass$ResponseGetBonusCodeData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementOuterClass$ResponseGetBonusCodeData parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetBonusCodeData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetBonusCodeData parseFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$ResponseGetBonusCodeData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$ResponseGetBonusCodeData parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetBonusCodeData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetBonusCodeData parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementOuterClass$ResponseGetBonusCodeData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementOuterClass$ResponseGetBonusCodeData parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetBonusCodeData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
