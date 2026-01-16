package ai.bale.proto;

import ai.bale.proto.AdvertisementStruct$EarnMoneyRequest;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes8.dex */
public final class AdvertisementOuterClass$RequestRegisterForEarnMoney extends GeneratedMessageLite implements U64 {
    private static final AdvertisementOuterClass$RequestRegisterForEarnMoney DEFAULT_INSTANCE;
    public static final int INFO_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private AdvertisementStruct$EarnMoneyRequest info_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(AdvertisementOuterClass$RequestRegisterForEarnMoney.DEFAULT_INSTANCE);
        }
    }

    static {
        AdvertisementOuterClass$RequestRegisterForEarnMoney advertisementOuterClass$RequestRegisterForEarnMoney = new AdvertisementOuterClass$RequestRegisterForEarnMoney();
        DEFAULT_INSTANCE = advertisementOuterClass$RequestRegisterForEarnMoney;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementOuterClass$RequestRegisterForEarnMoney.class, advertisementOuterClass$RequestRegisterForEarnMoney);
    }

    private AdvertisementOuterClass$RequestRegisterForEarnMoney() {
    }

    private void clearInfo() {
        this.info_ = null;
        this.bitField0_ &= -2;
    }

    public static AdvertisementOuterClass$RequestRegisterForEarnMoney getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeInfo(AdvertisementStruct$EarnMoneyRequest advertisementStruct$EarnMoneyRequest) {
        advertisementStruct$EarnMoneyRequest.getClass();
        AdvertisementStruct$EarnMoneyRequest advertisementStruct$EarnMoneyRequest2 = this.info_;
        if (advertisementStruct$EarnMoneyRequest2 == null || advertisementStruct$EarnMoneyRequest2 == AdvertisementStruct$EarnMoneyRequest.getDefaultInstance()) {
            this.info_ = advertisementStruct$EarnMoneyRequest;
        } else {
            this.info_ = (AdvertisementStruct$EarnMoneyRequest) ((AdvertisementStruct$EarnMoneyRequest.a) AdvertisementStruct$EarnMoneyRequest.newBuilder(this.info_).v(advertisementStruct$EarnMoneyRequest)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AdvertisementOuterClass$RequestRegisterForEarnMoney parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$RequestRegisterForEarnMoney) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$RequestRegisterForEarnMoney parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementOuterClass$RequestRegisterForEarnMoney) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setInfo(AdvertisementStruct$EarnMoneyRequest advertisementStruct$EarnMoneyRequest) {
        advertisementStruct$EarnMoneyRequest.getClass();
        this.info_ = advertisementStruct$EarnMoneyRequest;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1840b.a[gVar.ordinal()]) {
            case 1:
                return new AdvertisementOuterClass$RequestRegisterForEarnMoney();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "info_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementOuterClass$RequestRegisterForEarnMoney.class) {
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

    public AdvertisementStruct$EarnMoneyRequest getInfo() {
        AdvertisementStruct$EarnMoneyRequest advertisementStruct$EarnMoneyRequest = this.info_;
        return advertisementStruct$EarnMoneyRequest == null ? AdvertisementStruct$EarnMoneyRequest.getDefaultInstance() : advertisementStruct$EarnMoneyRequest;
    }

    public boolean hasInfo() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(AdvertisementOuterClass$RequestRegisterForEarnMoney advertisementOuterClass$RequestRegisterForEarnMoney) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementOuterClass$RequestRegisterForEarnMoney);
    }

    public static AdvertisementOuterClass$RequestRegisterForEarnMoney parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestRegisterForEarnMoney) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$RequestRegisterForEarnMoney parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestRegisterForEarnMoney) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementOuterClass$RequestRegisterForEarnMoney parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementOuterClass$RequestRegisterForEarnMoney) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AdvertisementOuterClass$RequestRegisterForEarnMoney parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestRegisterForEarnMoney) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementOuterClass$RequestRegisterForEarnMoney parseFrom(byte[] bArr) {
        return (AdvertisementOuterClass$RequestRegisterForEarnMoney) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementOuterClass$RequestRegisterForEarnMoney parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestRegisterForEarnMoney) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AdvertisementOuterClass$RequestRegisterForEarnMoney parseFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$RequestRegisterForEarnMoney) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$RequestRegisterForEarnMoney parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestRegisterForEarnMoney) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$RequestRegisterForEarnMoney parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementOuterClass$RequestRegisterForEarnMoney) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementOuterClass$RequestRegisterForEarnMoney parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestRegisterForEarnMoney) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
