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
public final class PremiumOuterClass$ResponseCalculateDiscountedPrice extends GeneratedMessageLite implements U64 {
    private static final PremiumOuterClass$ResponseCalculateDiscountedPrice DEFAULT_INSTANCE;
    public static final int DISCOUNTED_PRICE_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private long discountedPrice_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(PremiumOuterClass$ResponseCalculateDiscountedPrice.DEFAULT_INSTANCE);
        }
    }

    static {
        PremiumOuterClass$ResponseCalculateDiscountedPrice premiumOuterClass$ResponseCalculateDiscountedPrice = new PremiumOuterClass$ResponseCalculateDiscountedPrice();
        DEFAULT_INSTANCE = premiumOuterClass$ResponseCalculateDiscountedPrice;
        GeneratedMessageLite.registerDefaultInstance(PremiumOuterClass$ResponseCalculateDiscountedPrice.class, premiumOuterClass$ResponseCalculateDiscountedPrice);
    }

    private PremiumOuterClass$ResponseCalculateDiscountedPrice() {
    }

    private void clearDiscountedPrice() {
        this.discountedPrice_ = 0L;
    }

    public static PremiumOuterClass$ResponseCalculateDiscountedPrice getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static PremiumOuterClass$ResponseCalculateDiscountedPrice parseDelimitedFrom(InputStream inputStream) {
        return (PremiumOuterClass$ResponseCalculateDiscountedPrice) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PremiumOuterClass$ResponseCalculateDiscountedPrice parseFrom(ByteBuffer byteBuffer) {
        return (PremiumOuterClass$ResponseCalculateDiscountedPrice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setDiscountedPrice(long j) {
        this.discountedPrice_ = j;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1860h1.a[gVar.ordinal()]) {
            case 1:
                return new PremiumOuterClass$ResponseCalculateDiscountedPrice();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0002", new Object[]{"discountedPrice_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (PremiumOuterClass$ResponseCalculateDiscountedPrice.class) {
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

    public long getDiscountedPrice() {
        return this.discountedPrice_;
    }

    public static a newBuilder(PremiumOuterClass$ResponseCalculateDiscountedPrice premiumOuterClass$ResponseCalculateDiscountedPrice) {
        return (a) DEFAULT_INSTANCE.createBuilder(premiumOuterClass$ResponseCalculateDiscountedPrice);
    }

    public static PremiumOuterClass$ResponseCalculateDiscountedPrice parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (PremiumOuterClass$ResponseCalculateDiscountedPrice) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PremiumOuterClass$ResponseCalculateDiscountedPrice parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (PremiumOuterClass$ResponseCalculateDiscountedPrice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static PremiumOuterClass$ResponseCalculateDiscountedPrice parseFrom(AbstractC2383g abstractC2383g) {
        return (PremiumOuterClass$ResponseCalculateDiscountedPrice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static PremiumOuterClass$ResponseCalculateDiscountedPrice parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (PremiumOuterClass$ResponseCalculateDiscountedPrice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static PremiumOuterClass$ResponseCalculateDiscountedPrice parseFrom(byte[] bArr) {
        return (PremiumOuterClass$ResponseCalculateDiscountedPrice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PremiumOuterClass$ResponseCalculateDiscountedPrice parseFrom(byte[] bArr, C2394s c2394s) {
        return (PremiumOuterClass$ResponseCalculateDiscountedPrice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static PremiumOuterClass$ResponseCalculateDiscountedPrice parseFrom(InputStream inputStream) {
        return (PremiumOuterClass$ResponseCalculateDiscountedPrice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PremiumOuterClass$ResponseCalculateDiscountedPrice parseFrom(InputStream inputStream, C2394s c2394s) {
        return (PremiumOuterClass$ResponseCalculateDiscountedPrice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PremiumOuterClass$ResponseCalculateDiscountedPrice parseFrom(AbstractC2384h abstractC2384h) {
        return (PremiumOuterClass$ResponseCalculateDiscountedPrice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static PremiumOuterClass$ResponseCalculateDiscountedPrice parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (PremiumOuterClass$ResponseCalculateDiscountedPrice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
