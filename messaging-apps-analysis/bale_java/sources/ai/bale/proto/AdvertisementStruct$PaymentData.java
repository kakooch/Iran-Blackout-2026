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
public final class AdvertisementStruct$PaymentData extends GeneratedMessageLite implements U64 {
    public static final int AD_ID_FIELD_NUMBER = 1;
    public static final int CREATED_AT_FIELD_NUMBER = 5;
    private static final AdvertisementStruct$PaymentData DEFAULT_INSTANCE;
    public static final int DISCOUNT_FIXED_AMOUNT_FIELD_NUMBER = 3;
    public static final int DISCOUNT_PERCENT_FIELD_NUMBER = 4;
    private static volatile KW4 PARSER = null;
    public static final int RIAL_AMOUNT_FIELD_NUMBER = 2;
    public static final int SERIAL_NUMBER_FIELD_NUMBER = 6;
    private String adId_ = "";
    private long createdAt_;
    private long discountFixedAmount_;
    private int discountPercent_;
    private long rialAmount_;
    private int serialNumber_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(AdvertisementStruct$PaymentData.DEFAULT_INSTANCE);
        }
    }

    static {
        AdvertisementStruct$PaymentData advertisementStruct$PaymentData = new AdvertisementStruct$PaymentData();
        DEFAULT_INSTANCE = advertisementStruct$PaymentData;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementStruct$PaymentData.class, advertisementStruct$PaymentData);
    }

    private AdvertisementStruct$PaymentData() {
    }

    private void clearAdId() {
        this.adId_ = getDefaultInstance().getAdId();
    }

    private void clearCreatedAt() {
        this.createdAt_ = 0L;
    }

    private void clearDiscountFixedAmount() {
        this.discountFixedAmount_ = 0L;
    }

    private void clearDiscountPercent() {
        this.discountPercent_ = 0;
    }

    private void clearRialAmount() {
        this.rialAmount_ = 0L;
    }

    private void clearSerialNumber() {
        this.serialNumber_ = 0;
    }

    public static AdvertisementStruct$PaymentData getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AdvertisementStruct$PaymentData parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementStruct$PaymentData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementStruct$PaymentData parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementStruct$PaymentData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAdId(String str) {
        str.getClass();
        this.adId_ = str;
    }

    private void setAdIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.adId_ = abstractC2383g.f0();
    }

    private void setCreatedAt(long j) {
        this.createdAt_ = j;
    }

    private void setDiscountFixedAmount(long j) {
        this.discountFixedAmount_ = j;
    }

    private void setDiscountPercent(int i) {
        this.discountPercent_ = i;
    }

    private void setRialAmount(long j) {
        this.rialAmount_ = j;
    }

    private void setSerialNumber(int i) {
        this.serialNumber_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1843c.a[gVar.ordinal()]) {
            case 1:
                return new AdvertisementStruct$PaymentData();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0006\u0000\u0000\u0001\u0006\u0006\u0000\u0000\u0000\u0001Ȉ\u0002\u0002\u0003\u0002\u0004\u0004\u0005\u0002\u0006\u0004", new Object[]{"adId_", "rialAmount_", "discountFixedAmount_", "discountPercent_", "createdAt_", "serialNumber_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementStruct$PaymentData.class) {
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

    public String getAdId() {
        return this.adId_;
    }

    public AbstractC2383g getAdIdBytes() {
        return AbstractC2383g.N(this.adId_);
    }

    public long getCreatedAt() {
        return this.createdAt_;
    }

    public long getDiscountFixedAmount() {
        return this.discountFixedAmount_;
    }

    public int getDiscountPercent() {
        return this.discountPercent_;
    }

    public long getRialAmount() {
        return this.rialAmount_;
    }

    public int getSerialNumber() {
        return this.serialNumber_;
    }

    public static a newBuilder(AdvertisementStruct$PaymentData advertisementStruct$PaymentData) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementStruct$PaymentData);
    }

    public static AdvertisementStruct$PaymentData parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementStruct$PaymentData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementStruct$PaymentData parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementStruct$PaymentData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementStruct$PaymentData parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementStruct$PaymentData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AdvertisementStruct$PaymentData parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementStruct$PaymentData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementStruct$PaymentData parseFrom(byte[] bArr) {
        return (AdvertisementStruct$PaymentData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementStruct$PaymentData parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementStruct$PaymentData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AdvertisementStruct$PaymentData parseFrom(InputStream inputStream) {
        return (AdvertisementStruct$PaymentData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementStruct$PaymentData parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementStruct$PaymentData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementStruct$PaymentData parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementStruct$PaymentData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementStruct$PaymentData parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementStruct$PaymentData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
