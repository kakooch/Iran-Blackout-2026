package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.DJ2;
import ir.nasim.KW4;
import ir.nasim.PJ2;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class GoldOuterClass$RequestGetGoldUnitPrice extends GeneratedMessageLite implements U64 {
    public static final int CURRENCY_FIELD_NUMBER = 2;
    private static final GoldOuterClass$RequestGetGoldUnitPrice DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int UNIT_FIELD_NUMBER = 1;
    private int currency_;
    private int unit_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(GoldOuterClass$RequestGetGoldUnitPrice.DEFAULT_INSTANCE);
        }
    }

    static {
        GoldOuterClass$RequestGetGoldUnitPrice goldOuterClass$RequestGetGoldUnitPrice = new GoldOuterClass$RequestGetGoldUnitPrice();
        DEFAULT_INSTANCE = goldOuterClass$RequestGetGoldUnitPrice;
        GeneratedMessageLite.registerDefaultInstance(GoldOuterClass$RequestGetGoldUnitPrice.class, goldOuterClass$RequestGetGoldUnitPrice);
    }

    private GoldOuterClass$RequestGetGoldUnitPrice() {
    }

    private void clearCurrency() {
        this.currency_ = 0;
    }

    private void clearUnit() {
        this.unit_ = 0;
    }

    public static GoldOuterClass$RequestGetGoldUnitPrice getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static GoldOuterClass$RequestGetGoldUnitPrice parseDelimitedFrom(InputStream inputStream) {
        return (GoldOuterClass$RequestGetGoldUnitPrice) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GoldOuterClass$RequestGetGoldUnitPrice parseFrom(ByteBuffer byteBuffer) {
        return (GoldOuterClass$RequestGetGoldUnitPrice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setCurrency(DJ2 dj2) {
        this.currency_ = dj2.getNumber();
    }

    private void setCurrencyValue(int i) {
        this.currency_ = i;
    }

    private void setUnit(PJ2 pj2) {
        this.unit_ = pj2.getNumber();
    }

    private void setUnitValue(int i) {
        this.unit_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1871l0.a[gVar.ordinal()]) {
            case 1:
                return new GoldOuterClass$RequestGetGoldUnitPrice();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0002\f", new Object[]{"unit_", "currency_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (GoldOuterClass$RequestGetGoldUnitPrice.class) {
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

    public DJ2 getCurrency() {
        DJ2 dj2J = DJ2.j(this.currency_);
        return dj2J == null ? DJ2.UNRECOGNIZED : dj2J;
    }

    public int getCurrencyValue() {
        return this.currency_;
    }

    public PJ2 getUnit() {
        PJ2 pj2J = PJ2.j(this.unit_);
        return pj2J == null ? PJ2.UNRECOGNIZED : pj2J;
    }

    public int getUnitValue() {
        return this.unit_;
    }

    public static a newBuilder(GoldOuterClass$RequestGetGoldUnitPrice goldOuterClass$RequestGetGoldUnitPrice) {
        return (a) DEFAULT_INSTANCE.createBuilder(goldOuterClass$RequestGetGoldUnitPrice);
    }

    public static GoldOuterClass$RequestGetGoldUnitPrice parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (GoldOuterClass$RequestGetGoldUnitPrice) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GoldOuterClass$RequestGetGoldUnitPrice parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (GoldOuterClass$RequestGetGoldUnitPrice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static GoldOuterClass$RequestGetGoldUnitPrice parseFrom(AbstractC2383g abstractC2383g) {
        return (GoldOuterClass$RequestGetGoldUnitPrice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static GoldOuterClass$RequestGetGoldUnitPrice parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (GoldOuterClass$RequestGetGoldUnitPrice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static GoldOuterClass$RequestGetGoldUnitPrice parseFrom(byte[] bArr) {
        return (GoldOuterClass$RequestGetGoldUnitPrice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GoldOuterClass$RequestGetGoldUnitPrice parseFrom(byte[] bArr, C2394s c2394s) {
        return (GoldOuterClass$RequestGetGoldUnitPrice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static GoldOuterClass$RequestGetGoldUnitPrice parseFrom(InputStream inputStream) {
        return (GoldOuterClass$RequestGetGoldUnitPrice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GoldOuterClass$RequestGetGoldUnitPrice parseFrom(InputStream inputStream, C2394s c2394s) {
        return (GoldOuterClass$RequestGetGoldUnitPrice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GoldOuterClass$RequestGetGoldUnitPrice parseFrom(AbstractC2384h abstractC2384h) {
        return (GoldOuterClass$RequestGetGoldUnitPrice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static GoldOuterClass$RequestGetGoldUnitPrice parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (GoldOuterClass$RequestGetGoldUnitPrice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
