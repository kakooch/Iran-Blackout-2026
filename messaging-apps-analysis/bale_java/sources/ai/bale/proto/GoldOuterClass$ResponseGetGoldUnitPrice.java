package ai.bale.proto;

import ai.bale.proto.GoldOuterClass$Price;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class GoldOuterClass$ResponseGetGoldUnitPrice extends GeneratedMessageLite implements U64 {
    public static final int BUY_UNIT_PRICE_FIELD_NUMBER = 1;
    private static final GoldOuterClass$ResponseGetGoldUnitPrice DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int SELL_UNIT_PRICE_FIELD_NUMBER = 2;
    private int bitField0_;
    private GoldOuterClass$Price buyUnitPrice_;
    private GoldOuterClass$Price sellUnitPrice_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(GoldOuterClass$ResponseGetGoldUnitPrice.DEFAULT_INSTANCE);
        }
    }

    static {
        GoldOuterClass$ResponseGetGoldUnitPrice goldOuterClass$ResponseGetGoldUnitPrice = new GoldOuterClass$ResponseGetGoldUnitPrice();
        DEFAULT_INSTANCE = goldOuterClass$ResponseGetGoldUnitPrice;
        GeneratedMessageLite.registerDefaultInstance(GoldOuterClass$ResponseGetGoldUnitPrice.class, goldOuterClass$ResponseGetGoldUnitPrice);
    }

    private GoldOuterClass$ResponseGetGoldUnitPrice() {
    }

    private void clearBuyUnitPrice() {
        this.buyUnitPrice_ = null;
        this.bitField0_ &= -2;
    }

    private void clearSellUnitPrice() {
        this.sellUnitPrice_ = null;
        this.bitField0_ &= -3;
    }

    public static GoldOuterClass$ResponseGetGoldUnitPrice getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeBuyUnitPrice(GoldOuterClass$Price goldOuterClass$Price) {
        goldOuterClass$Price.getClass();
        GoldOuterClass$Price goldOuterClass$Price2 = this.buyUnitPrice_;
        if (goldOuterClass$Price2 == null || goldOuterClass$Price2 == GoldOuterClass$Price.getDefaultInstance()) {
            this.buyUnitPrice_ = goldOuterClass$Price;
        } else {
            this.buyUnitPrice_ = (GoldOuterClass$Price) ((GoldOuterClass$Price.a) GoldOuterClass$Price.newBuilder(this.buyUnitPrice_).v(goldOuterClass$Price)).j();
        }
        this.bitField0_ |= 1;
    }

    private void mergeSellUnitPrice(GoldOuterClass$Price goldOuterClass$Price) {
        goldOuterClass$Price.getClass();
        GoldOuterClass$Price goldOuterClass$Price2 = this.sellUnitPrice_;
        if (goldOuterClass$Price2 == null || goldOuterClass$Price2 == GoldOuterClass$Price.getDefaultInstance()) {
            this.sellUnitPrice_ = goldOuterClass$Price;
        } else {
            this.sellUnitPrice_ = (GoldOuterClass$Price) ((GoldOuterClass$Price.a) GoldOuterClass$Price.newBuilder(this.sellUnitPrice_).v(goldOuterClass$Price)).j();
        }
        this.bitField0_ |= 2;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static GoldOuterClass$ResponseGetGoldUnitPrice parseDelimitedFrom(InputStream inputStream) {
        return (GoldOuterClass$ResponseGetGoldUnitPrice) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GoldOuterClass$ResponseGetGoldUnitPrice parseFrom(ByteBuffer byteBuffer) {
        return (GoldOuterClass$ResponseGetGoldUnitPrice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setBuyUnitPrice(GoldOuterClass$Price goldOuterClass$Price) {
        goldOuterClass$Price.getClass();
        this.buyUnitPrice_ = goldOuterClass$Price;
        this.bitField0_ |= 1;
    }

    private void setSellUnitPrice(GoldOuterClass$Price goldOuterClass$Price) {
        goldOuterClass$Price.getClass();
        this.sellUnitPrice_ = goldOuterClass$Price;
        this.bitField0_ |= 2;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1871l0.a[gVar.ordinal()]) {
            case 1:
                return new GoldOuterClass$ResponseGetGoldUnitPrice();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001", new Object[]{"bitField0_", "buyUnitPrice_", "sellUnitPrice_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (GoldOuterClass$ResponseGetGoldUnitPrice.class) {
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

    public GoldOuterClass$Price getBuyUnitPrice() {
        GoldOuterClass$Price goldOuterClass$Price = this.buyUnitPrice_;
        return goldOuterClass$Price == null ? GoldOuterClass$Price.getDefaultInstance() : goldOuterClass$Price;
    }

    public GoldOuterClass$Price getSellUnitPrice() {
        GoldOuterClass$Price goldOuterClass$Price = this.sellUnitPrice_;
        return goldOuterClass$Price == null ? GoldOuterClass$Price.getDefaultInstance() : goldOuterClass$Price;
    }

    public boolean hasBuyUnitPrice() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasSellUnitPrice() {
        return (this.bitField0_ & 2) != 0;
    }

    public static a newBuilder(GoldOuterClass$ResponseGetGoldUnitPrice goldOuterClass$ResponseGetGoldUnitPrice) {
        return (a) DEFAULT_INSTANCE.createBuilder(goldOuterClass$ResponseGetGoldUnitPrice);
    }

    public static GoldOuterClass$ResponseGetGoldUnitPrice parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (GoldOuterClass$ResponseGetGoldUnitPrice) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GoldOuterClass$ResponseGetGoldUnitPrice parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (GoldOuterClass$ResponseGetGoldUnitPrice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static GoldOuterClass$ResponseGetGoldUnitPrice parseFrom(AbstractC2383g abstractC2383g) {
        return (GoldOuterClass$ResponseGetGoldUnitPrice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static GoldOuterClass$ResponseGetGoldUnitPrice parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (GoldOuterClass$ResponseGetGoldUnitPrice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static GoldOuterClass$ResponseGetGoldUnitPrice parseFrom(byte[] bArr) {
        return (GoldOuterClass$ResponseGetGoldUnitPrice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GoldOuterClass$ResponseGetGoldUnitPrice parseFrom(byte[] bArr, C2394s c2394s) {
        return (GoldOuterClass$ResponseGetGoldUnitPrice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static GoldOuterClass$ResponseGetGoldUnitPrice parseFrom(InputStream inputStream) {
        return (GoldOuterClass$ResponseGetGoldUnitPrice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GoldOuterClass$ResponseGetGoldUnitPrice parseFrom(InputStream inputStream, C2394s c2394s) {
        return (GoldOuterClass$ResponseGetGoldUnitPrice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GoldOuterClass$ResponseGetGoldUnitPrice parseFrom(AbstractC2384h abstractC2384h) {
        return (GoldOuterClass$ResponseGetGoldUnitPrice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static GoldOuterClass$ResponseGetGoldUnitPrice parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (GoldOuterClass$ResponseGetGoldUnitPrice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
