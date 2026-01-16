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
public final class Advertisementnew$RequestCreateBonusCode extends GeneratedMessageLite implements U64 {
    public static final int DATA_FIELD_NUMBER = 1;
    private static final Advertisementnew$RequestCreateBonusCode DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private AdvertisementnewStruct$BonusCodeData data_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Advertisementnew$RequestCreateBonusCode.DEFAULT_INSTANCE);
        }
    }

    static {
        Advertisementnew$RequestCreateBonusCode advertisementnew$RequestCreateBonusCode = new Advertisementnew$RequestCreateBonusCode();
        DEFAULT_INSTANCE = advertisementnew$RequestCreateBonusCode;
        GeneratedMessageLite.registerDefaultInstance(Advertisementnew$RequestCreateBonusCode.class, advertisementnew$RequestCreateBonusCode);
    }

    private Advertisementnew$RequestCreateBonusCode() {
    }

    private void clearData() {
        this.data_ = null;
    }

    public static Advertisementnew$RequestCreateBonusCode getDefaultInstance() {
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

    public static Advertisementnew$RequestCreateBonusCode parseDelimitedFrom(InputStream inputStream) {
        return (Advertisementnew$RequestCreateBonusCode) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Advertisementnew$RequestCreateBonusCode parseFrom(ByteBuffer byteBuffer) {
        return (Advertisementnew$RequestCreateBonusCode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
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
                return new Advertisementnew$RequestCreateBonusCode();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\t", new Object[]{"data_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Advertisementnew$RequestCreateBonusCode.class) {
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

    public static a newBuilder(Advertisementnew$RequestCreateBonusCode advertisementnew$RequestCreateBonusCode) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementnew$RequestCreateBonusCode);
    }

    public static Advertisementnew$RequestCreateBonusCode parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Advertisementnew$RequestCreateBonusCode) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Advertisementnew$RequestCreateBonusCode parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Advertisementnew$RequestCreateBonusCode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Advertisementnew$RequestCreateBonusCode parseFrom(AbstractC2383g abstractC2383g) {
        return (Advertisementnew$RequestCreateBonusCode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static Advertisementnew$RequestCreateBonusCode parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Advertisementnew$RequestCreateBonusCode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Advertisementnew$RequestCreateBonusCode parseFrom(byte[] bArr) {
        return (Advertisementnew$RequestCreateBonusCode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Advertisementnew$RequestCreateBonusCode parseFrom(byte[] bArr, C2394s c2394s) {
        return (Advertisementnew$RequestCreateBonusCode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Advertisementnew$RequestCreateBonusCode parseFrom(InputStream inputStream) {
        return (Advertisementnew$RequestCreateBonusCode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Advertisementnew$RequestCreateBonusCode parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Advertisementnew$RequestCreateBonusCode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Advertisementnew$RequestCreateBonusCode parseFrom(AbstractC2384h abstractC2384h) {
        return (Advertisementnew$RequestCreateBonusCode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Advertisementnew$RequestCreateBonusCode parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Advertisementnew$RequestCreateBonusCode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
