package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class EvexOuterClass$ResponseGetEvexCurrencyPrice extends GeneratedMessageLite implements U64 {
    public static final int AMOUNT_TO_PAY_FIELD_NUMBER = 3;
    public static final int CURRENCY_RATE_FIELD_NUMBER = 1;
    private static final EvexOuterClass$ResponseGetEvexCurrencyPrice DEFAULT_INSTANCE;
    public static final int ICE_WAGE_FIELD_NUMBER = 6;
    public static final int MELLI_WAGE_FIELD_NUMBER = 5;
    public static final int ORDER_ID_FIELD_NUMBER = 2;
    public static final int OTHER_WAGES_FIELD_NUMBER = 7;
    private static volatile KW4 PARSER = null;
    public static final int RIAL_AMOUNT_FIELD_NUMBER = 4;
    private long amountToPay_;
    private int currencyRate_;
    private long iceWage_;
    private long melliWage_;
    private int orderId_;
    private long otherWages_;
    private long rialAmount_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(EvexOuterClass$ResponseGetEvexCurrencyPrice.DEFAULT_INSTANCE);
        }
    }

    static {
        EvexOuterClass$ResponseGetEvexCurrencyPrice evexOuterClass$ResponseGetEvexCurrencyPrice = new EvexOuterClass$ResponseGetEvexCurrencyPrice();
        DEFAULT_INSTANCE = evexOuterClass$ResponseGetEvexCurrencyPrice;
        GeneratedMessageLite.registerDefaultInstance(EvexOuterClass$ResponseGetEvexCurrencyPrice.class, evexOuterClass$ResponseGetEvexCurrencyPrice);
    }

    private EvexOuterClass$ResponseGetEvexCurrencyPrice() {
    }

    private void clearAmountToPay() {
        this.amountToPay_ = 0L;
    }

    private void clearCurrencyRate() {
        this.currencyRate_ = 0;
    }

    private void clearIceWage() {
        this.iceWage_ = 0L;
    }

    private void clearMelliWage() {
        this.melliWage_ = 0L;
    }

    private void clearOrderId() {
        this.orderId_ = 0;
    }

    private void clearOtherWages() {
        this.otherWages_ = 0L;
    }

    private void clearRialAmount() {
        this.rialAmount_ = 0L;
    }

    public static EvexOuterClass$ResponseGetEvexCurrencyPrice getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static EvexOuterClass$ResponseGetEvexCurrencyPrice parseDelimitedFrom(InputStream inputStream) {
        return (EvexOuterClass$ResponseGetEvexCurrencyPrice) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static EvexOuterClass$ResponseGetEvexCurrencyPrice parseFrom(ByteBuffer byteBuffer) {
        return (EvexOuterClass$ResponseGetEvexCurrencyPrice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAmountToPay(long j) {
        this.amountToPay_ = j;
    }

    private void setCurrencyRate(int i) {
        this.currencyRate_ = i;
    }

    private void setIceWage(long j) {
        this.iceWage_ = j;
    }

    private void setMelliWage(long j) {
        this.melliWage_ = j;
    }

    private void setOrderId(int i) {
        this.orderId_ = i;
    }

    private void setOtherWages(long j) {
        this.otherWages_ = j;
    }

    private void setRialAmount(long j) {
        this.rialAmount_ = j;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (S.a[gVar.ordinal()]) {
            case 1:
                return new EvexOuterClass$ResponseGetEvexCurrencyPrice();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0007\u0000\u0000\u0001\u0007\u0007\u0000\u0000\u0000\u0001\u0004\u0002\u0004\u0003\u0002\u0004\u0002\u0005\u0002\u0006\u0002\u0007\u0002", new Object[]{"currencyRate_", "orderId_", "amountToPay_", "rialAmount_", "melliWage_", "iceWage_", "otherWages_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (EvexOuterClass$ResponseGetEvexCurrencyPrice.class) {
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

    public long getAmountToPay() {
        return this.amountToPay_;
    }

    public int getCurrencyRate() {
        return this.currencyRate_;
    }

    public long getIceWage() {
        return this.iceWage_;
    }

    public long getMelliWage() {
        return this.melliWage_;
    }

    public int getOrderId() {
        return this.orderId_;
    }

    public long getOtherWages() {
        return this.otherWages_;
    }

    public long getRialAmount() {
        return this.rialAmount_;
    }

    public static a newBuilder(EvexOuterClass$ResponseGetEvexCurrencyPrice evexOuterClass$ResponseGetEvexCurrencyPrice) {
        return (a) DEFAULT_INSTANCE.createBuilder(evexOuterClass$ResponseGetEvexCurrencyPrice);
    }

    public static EvexOuterClass$ResponseGetEvexCurrencyPrice parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (EvexOuterClass$ResponseGetEvexCurrencyPrice) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static EvexOuterClass$ResponseGetEvexCurrencyPrice parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (EvexOuterClass$ResponseGetEvexCurrencyPrice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static EvexOuterClass$ResponseGetEvexCurrencyPrice parseFrom(AbstractC2383g abstractC2383g) {
        return (EvexOuterClass$ResponseGetEvexCurrencyPrice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static EvexOuterClass$ResponseGetEvexCurrencyPrice parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (EvexOuterClass$ResponseGetEvexCurrencyPrice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static EvexOuterClass$ResponseGetEvexCurrencyPrice parseFrom(byte[] bArr) {
        return (EvexOuterClass$ResponseGetEvexCurrencyPrice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static EvexOuterClass$ResponseGetEvexCurrencyPrice parseFrom(byte[] bArr, C2394s c2394s) {
        return (EvexOuterClass$ResponseGetEvexCurrencyPrice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static EvexOuterClass$ResponseGetEvexCurrencyPrice parseFrom(InputStream inputStream) {
        return (EvexOuterClass$ResponseGetEvexCurrencyPrice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static EvexOuterClass$ResponseGetEvexCurrencyPrice parseFrom(InputStream inputStream, C2394s c2394s) {
        return (EvexOuterClass$ResponseGetEvexCurrencyPrice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static EvexOuterClass$ResponseGetEvexCurrencyPrice parseFrom(AbstractC2384h abstractC2384h) {
        return (EvexOuterClass$ResponseGetEvexCurrencyPrice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static EvexOuterClass$ResponseGetEvexCurrencyPrice parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (EvexOuterClass$ResponseGetEvexCurrencyPrice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
