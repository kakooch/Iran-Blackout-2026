package ai.bale.proto;

import ai.bale.proto.AdvertisementnewStruct$BonusCodeData;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class Advertisementnew$ResponseGetBonusCodeData extends GeneratedMessageLite implements U64 {
    public static final int DATA_FIELD_NUMBER = 1;
    private static final Advertisementnew$ResponseGetBonusCodeData DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private AdvertisementnewStruct$BonusCodeData data_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Advertisementnew$ResponseGetBonusCodeData.DEFAULT_INSTANCE);
        }
    }

    static {
        Advertisementnew$ResponseGetBonusCodeData advertisementnew$ResponseGetBonusCodeData = new Advertisementnew$ResponseGetBonusCodeData();
        DEFAULT_INSTANCE = advertisementnew$ResponseGetBonusCodeData;
        GeneratedMessageLite.registerDefaultInstance(Advertisementnew$ResponseGetBonusCodeData.class, advertisementnew$ResponseGetBonusCodeData);
    }

    private Advertisementnew$ResponseGetBonusCodeData() {
    }

    private void clearData() {
        this.data_ = null;
    }

    public static Advertisementnew$ResponseGetBonusCodeData getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeData(AdvertisementnewStruct$BonusCodeData advertisementnewStruct$BonusCodeData) {
        advertisementnewStruct$BonusCodeData.getClass();
        AdvertisementnewStruct$BonusCodeData advertisementnewStruct$BonusCodeData2 = this.data_;
        if (advertisementnewStruct$BonusCodeData2 == null || advertisementnewStruct$BonusCodeData2 == AdvertisementnewStruct$BonusCodeData.getDefaultInstance()) {
            this.data_ = advertisementnewStruct$BonusCodeData;
        } else {
            this.data_ = (AdvertisementnewStruct$BonusCodeData) ((AdvertisementnewStruct$BonusCodeData.a) AdvertisementnewStruct$BonusCodeData.newBuilder(this.data_).v(advertisementnewStruct$BonusCodeData)).j();
        }
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Advertisementnew$ResponseGetBonusCodeData parseDelimitedFrom(InputStream inputStream) {
        return (Advertisementnew$ResponseGetBonusCodeData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Advertisementnew$ResponseGetBonusCodeData parseFrom(ByteBuffer byteBuffer) {
        return (Advertisementnew$ResponseGetBonusCodeData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setData(AdvertisementnewStruct$BonusCodeData advertisementnewStruct$BonusCodeData) {
        advertisementnewStruct$BonusCodeData.getClass();
        this.data_ = advertisementnewStruct$BonusCodeData;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1849e.a[gVar.ordinal()]) {
            case 1:
                return new Advertisementnew$ResponseGetBonusCodeData();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\t", new Object[]{"data_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Advertisementnew$ResponseGetBonusCodeData.class) {
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

    public AdvertisementnewStruct$BonusCodeData getData() {
        AdvertisementnewStruct$BonusCodeData advertisementnewStruct$BonusCodeData = this.data_;
        return advertisementnewStruct$BonusCodeData == null ? AdvertisementnewStruct$BonusCodeData.getDefaultInstance() : advertisementnewStruct$BonusCodeData;
    }

    public boolean hasData() {
        return this.data_ != null;
    }

    public static a newBuilder(Advertisementnew$ResponseGetBonusCodeData advertisementnew$ResponseGetBonusCodeData) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementnew$ResponseGetBonusCodeData);
    }

    public static Advertisementnew$ResponseGetBonusCodeData parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Advertisementnew$ResponseGetBonusCodeData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Advertisementnew$ResponseGetBonusCodeData parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Advertisementnew$ResponseGetBonusCodeData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Advertisementnew$ResponseGetBonusCodeData parseFrom(AbstractC2383g abstractC2383g) {
        return (Advertisementnew$ResponseGetBonusCodeData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static Advertisementnew$ResponseGetBonusCodeData parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Advertisementnew$ResponseGetBonusCodeData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Advertisementnew$ResponseGetBonusCodeData parseFrom(byte[] bArr) {
        return (Advertisementnew$ResponseGetBonusCodeData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Advertisementnew$ResponseGetBonusCodeData parseFrom(byte[] bArr, C2394s c2394s) {
        return (Advertisementnew$ResponseGetBonusCodeData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Advertisementnew$ResponseGetBonusCodeData parseFrom(InputStream inputStream) {
        return (Advertisementnew$ResponseGetBonusCodeData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Advertisementnew$ResponseGetBonusCodeData parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Advertisementnew$ResponseGetBonusCodeData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Advertisementnew$ResponseGetBonusCodeData parseFrom(AbstractC2384h abstractC2384h) {
        return (Advertisementnew$ResponseGetBonusCodeData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Advertisementnew$ResponseGetBonusCodeData parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Advertisementnew$ResponseGetBonusCodeData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
