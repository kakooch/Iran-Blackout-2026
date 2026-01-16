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
public final class Arbainexchange$ResponseGetArbaeenCurrencyPrice extends GeneratedMessageLite implements U64 {
    public static final int CURRENCY_RATE_FIELD_NUMBER = 1;
    private static final Arbainexchange$ResponseGetArbaeenCurrencyPrice DEFAULT_INSTANCE;
    public static final int NEW_CURRENCY_RATE_FIELD_NUMBER = 3;
    public static final int ORDER_ID_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER;
    private int currencyRate_;
    private String newCurrencyRate_ = "";
    private int orderId_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Arbainexchange$ResponseGetArbaeenCurrencyPrice.DEFAULT_INSTANCE);
        }
    }

    static {
        Arbainexchange$ResponseGetArbaeenCurrencyPrice arbainexchange$ResponseGetArbaeenCurrencyPrice = new Arbainexchange$ResponseGetArbaeenCurrencyPrice();
        DEFAULT_INSTANCE = arbainexchange$ResponseGetArbaeenCurrencyPrice;
        GeneratedMessageLite.registerDefaultInstance(Arbainexchange$ResponseGetArbaeenCurrencyPrice.class, arbainexchange$ResponseGetArbaeenCurrencyPrice);
    }

    private Arbainexchange$ResponseGetArbaeenCurrencyPrice() {
    }

    private void clearCurrencyRate() {
        this.currencyRate_ = 0;
    }

    private void clearNewCurrencyRate() {
        this.newCurrencyRate_ = getDefaultInstance().getNewCurrencyRate();
    }

    private void clearOrderId() {
        this.orderId_ = 0;
    }

    public static Arbainexchange$ResponseGetArbaeenCurrencyPrice getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Arbainexchange$ResponseGetArbaeenCurrencyPrice parseDelimitedFrom(InputStream inputStream) {
        return (Arbainexchange$ResponseGetArbaeenCurrencyPrice) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Arbainexchange$ResponseGetArbaeenCurrencyPrice parseFrom(ByteBuffer byteBuffer) {
        return (Arbainexchange$ResponseGetArbaeenCurrencyPrice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setCurrencyRate(int i) {
        this.currencyRate_ = i;
    }

    private void setNewCurrencyRate(String str) {
        str.getClass();
        this.newCurrencyRate_ = str;
    }

    private void setNewCurrencyRateBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.newCurrencyRate_ = abstractC2383g.f0();
    }

    private void setOrderId(int i) {
        this.orderId_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1861i.a[gVar.ordinal()]) {
            case 1:
                return new Arbainexchange$ResponseGetArbaeenCurrencyPrice();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0004\u0002\u0004\u0003Ȉ", new Object[]{"currencyRate_", "orderId_", "newCurrencyRate_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Arbainexchange$ResponseGetArbaeenCurrencyPrice.class) {
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

    public int getCurrencyRate() {
        return this.currencyRate_;
    }

    public String getNewCurrencyRate() {
        return this.newCurrencyRate_;
    }

    public AbstractC2383g getNewCurrencyRateBytes() {
        return AbstractC2383g.N(this.newCurrencyRate_);
    }

    public int getOrderId() {
        return this.orderId_;
    }

    public static a newBuilder(Arbainexchange$ResponseGetArbaeenCurrencyPrice arbainexchange$ResponseGetArbaeenCurrencyPrice) {
        return (a) DEFAULT_INSTANCE.createBuilder(arbainexchange$ResponseGetArbaeenCurrencyPrice);
    }

    public static Arbainexchange$ResponseGetArbaeenCurrencyPrice parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Arbainexchange$ResponseGetArbaeenCurrencyPrice) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Arbainexchange$ResponseGetArbaeenCurrencyPrice parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Arbainexchange$ResponseGetArbaeenCurrencyPrice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Arbainexchange$ResponseGetArbaeenCurrencyPrice parseFrom(AbstractC2383g abstractC2383g) {
        return (Arbainexchange$ResponseGetArbaeenCurrencyPrice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static Arbainexchange$ResponseGetArbaeenCurrencyPrice parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Arbainexchange$ResponseGetArbaeenCurrencyPrice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Arbainexchange$ResponseGetArbaeenCurrencyPrice parseFrom(byte[] bArr) {
        return (Arbainexchange$ResponseGetArbaeenCurrencyPrice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Arbainexchange$ResponseGetArbaeenCurrencyPrice parseFrom(byte[] bArr, C2394s c2394s) {
        return (Arbainexchange$ResponseGetArbaeenCurrencyPrice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Arbainexchange$ResponseGetArbaeenCurrencyPrice parseFrom(InputStream inputStream) {
        return (Arbainexchange$ResponseGetArbaeenCurrencyPrice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Arbainexchange$ResponseGetArbaeenCurrencyPrice parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Arbainexchange$ResponseGetArbaeenCurrencyPrice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Arbainexchange$ResponseGetArbaeenCurrencyPrice parseFrom(AbstractC2384h abstractC2384h) {
        return (Arbainexchange$ResponseGetArbaeenCurrencyPrice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Arbainexchange$ResponseGetArbaeenCurrencyPrice parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Arbainexchange$ResponseGetArbaeenCurrencyPrice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
