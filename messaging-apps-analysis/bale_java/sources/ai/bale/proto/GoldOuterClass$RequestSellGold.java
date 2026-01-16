package ai.bale.proto;

import ai.bale.proto.GoldOuterClass$Gold;
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
public final class GoldOuterClass$RequestSellGold extends GeneratedMessageLite implements U64 {
    private static final GoldOuterClass$RequestSellGold DEFAULT_INSTANCE;
    public static final int GOLD_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int UNIT_PRICE_FIELD_NUMBER = 1;
    private int bitField0_;
    private GoldOuterClass$Gold gold_;
    private GoldOuterClass$Price unitPrice_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(GoldOuterClass$RequestSellGold.DEFAULT_INSTANCE);
        }
    }

    static {
        GoldOuterClass$RequestSellGold goldOuterClass$RequestSellGold = new GoldOuterClass$RequestSellGold();
        DEFAULT_INSTANCE = goldOuterClass$RequestSellGold;
        GeneratedMessageLite.registerDefaultInstance(GoldOuterClass$RequestSellGold.class, goldOuterClass$RequestSellGold);
    }

    private GoldOuterClass$RequestSellGold() {
    }

    private void clearGold() {
        this.gold_ = null;
        this.bitField0_ &= -3;
    }

    private void clearUnitPrice() {
        this.unitPrice_ = null;
        this.bitField0_ &= -2;
    }

    public static GoldOuterClass$RequestSellGold getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeGold(GoldOuterClass$Gold goldOuterClass$Gold) {
        goldOuterClass$Gold.getClass();
        GoldOuterClass$Gold goldOuterClass$Gold2 = this.gold_;
        if (goldOuterClass$Gold2 == null || goldOuterClass$Gold2 == GoldOuterClass$Gold.getDefaultInstance()) {
            this.gold_ = goldOuterClass$Gold;
        } else {
            this.gold_ = (GoldOuterClass$Gold) ((GoldOuterClass$Gold.a) GoldOuterClass$Gold.newBuilder(this.gold_).v(goldOuterClass$Gold)).j();
        }
        this.bitField0_ |= 2;
    }

    private void mergeUnitPrice(GoldOuterClass$Price goldOuterClass$Price) {
        goldOuterClass$Price.getClass();
        GoldOuterClass$Price goldOuterClass$Price2 = this.unitPrice_;
        if (goldOuterClass$Price2 == null || goldOuterClass$Price2 == GoldOuterClass$Price.getDefaultInstance()) {
            this.unitPrice_ = goldOuterClass$Price;
        } else {
            this.unitPrice_ = (GoldOuterClass$Price) ((GoldOuterClass$Price.a) GoldOuterClass$Price.newBuilder(this.unitPrice_).v(goldOuterClass$Price)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static GoldOuterClass$RequestSellGold parseDelimitedFrom(InputStream inputStream) {
        return (GoldOuterClass$RequestSellGold) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GoldOuterClass$RequestSellGold parseFrom(ByteBuffer byteBuffer) {
        return (GoldOuterClass$RequestSellGold) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setGold(GoldOuterClass$Gold goldOuterClass$Gold) {
        goldOuterClass$Gold.getClass();
        this.gold_ = goldOuterClass$Gold;
        this.bitField0_ |= 2;
    }

    private void setUnitPrice(GoldOuterClass$Price goldOuterClass$Price) {
        goldOuterClass$Price.getClass();
        this.unitPrice_ = goldOuterClass$Price;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1871l0.a[gVar.ordinal()]) {
            case 1:
                return new GoldOuterClass$RequestSellGold();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001", new Object[]{"bitField0_", "unitPrice_", "gold_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (GoldOuterClass$RequestSellGold.class) {
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

    public GoldOuterClass$Gold getGold() {
        GoldOuterClass$Gold goldOuterClass$Gold = this.gold_;
        return goldOuterClass$Gold == null ? GoldOuterClass$Gold.getDefaultInstance() : goldOuterClass$Gold;
    }

    public GoldOuterClass$Price getUnitPrice() {
        GoldOuterClass$Price goldOuterClass$Price = this.unitPrice_;
        return goldOuterClass$Price == null ? GoldOuterClass$Price.getDefaultInstance() : goldOuterClass$Price;
    }

    public boolean hasGold() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasUnitPrice() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(GoldOuterClass$RequestSellGold goldOuterClass$RequestSellGold) {
        return (a) DEFAULT_INSTANCE.createBuilder(goldOuterClass$RequestSellGold);
    }

    public static GoldOuterClass$RequestSellGold parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (GoldOuterClass$RequestSellGold) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GoldOuterClass$RequestSellGold parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (GoldOuterClass$RequestSellGold) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static GoldOuterClass$RequestSellGold parseFrom(AbstractC2383g abstractC2383g) {
        return (GoldOuterClass$RequestSellGold) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static GoldOuterClass$RequestSellGold parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (GoldOuterClass$RequestSellGold) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static GoldOuterClass$RequestSellGold parseFrom(byte[] bArr) {
        return (GoldOuterClass$RequestSellGold) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GoldOuterClass$RequestSellGold parseFrom(byte[] bArr, C2394s c2394s) {
        return (GoldOuterClass$RequestSellGold) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static GoldOuterClass$RequestSellGold parseFrom(InputStream inputStream) {
        return (GoldOuterClass$RequestSellGold) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GoldOuterClass$RequestSellGold parseFrom(InputStream inputStream, C2394s c2394s) {
        return (GoldOuterClass$RequestSellGold) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GoldOuterClass$RequestSellGold parseFrom(AbstractC2384h abstractC2384h) {
        return (GoldOuterClass$RequestSellGold) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static GoldOuterClass$RequestSellGold parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (GoldOuterClass$RequestSellGold) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
