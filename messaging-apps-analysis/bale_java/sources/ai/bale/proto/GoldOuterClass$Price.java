package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.DJ2;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class GoldOuterClass$Price extends GeneratedMessageLite implements U64 {
    public static final int AMOUNT_FIELD_NUMBER = 1;
    public static final int CURRENCY_FIELD_NUMBER = 2;
    private static final GoldOuterClass$Price DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private long amount_;
    private int currency_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(GoldOuterClass$Price.DEFAULT_INSTANCE);
        }
    }

    static {
        GoldOuterClass$Price goldOuterClass$Price = new GoldOuterClass$Price();
        DEFAULT_INSTANCE = goldOuterClass$Price;
        GeneratedMessageLite.registerDefaultInstance(GoldOuterClass$Price.class, goldOuterClass$Price);
    }

    private GoldOuterClass$Price() {
    }

    private void clearAmount() {
        this.amount_ = 0L;
    }

    private void clearCurrency() {
        this.currency_ = 0;
    }

    public static GoldOuterClass$Price getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static GoldOuterClass$Price parseDelimitedFrom(InputStream inputStream) {
        return (GoldOuterClass$Price) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GoldOuterClass$Price parseFrom(ByteBuffer byteBuffer) {
        return (GoldOuterClass$Price) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAmount(long j) {
        this.amount_ = j;
    }

    private void setCurrency(DJ2 dj2) {
        this.currency_ = dj2.getNumber();
    }

    private void setCurrencyValue(int i) {
        this.currency_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1871l0.a[gVar.ordinal()]) {
            case 1:
                return new GoldOuterClass$Price();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0002\u0002\f", new Object[]{"amount_", "currency_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (GoldOuterClass$Price.class) {
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

    public long getAmount() {
        return this.amount_;
    }

    public DJ2 getCurrency() {
        DJ2 dj2J = DJ2.j(this.currency_);
        return dj2J == null ? DJ2.UNRECOGNIZED : dj2J;
    }

    public int getCurrencyValue() {
        return this.currency_;
    }

    public static a newBuilder(GoldOuterClass$Price goldOuterClass$Price) {
        return (a) DEFAULT_INSTANCE.createBuilder(goldOuterClass$Price);
    }

    public static GoldOuterClass$Price parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (GoldOuterClass$Price) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GoldOuterClass$Price parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (GoldOuterClass$Price) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static GoldOuterClass$Price parseFrom(AbstractC2383g abstractC2383g) {
        return (GoldOuterClass$Price) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static GoldOuterClass$Price parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (GoldOuterClass$Price) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static GoldOuterClass$Price parseFrom(byte[] bArr) {
        return (GoldOuterClass$Price) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GoldOuterClass$Price parseFrom(byte[] bArr, C2394s c2394s) {
        return (GoldOuterClass$Price) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static GoldOuterClass$Price parseFrom(InputStream inputStream) {
        return (GoldOuterClass$Price) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GoldOuterClass$Price parseFrom(InputStream inputStream, C2394s c2394s) {
        return (GoldOuterClass$Price) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GoldOuterClass$Price parseFrom(AbstractC2384h abstractC2384h) {
        return (GoldOuterClass$Price) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static GoldOuterClass$Price parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (GoldOuterClass$Price) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
