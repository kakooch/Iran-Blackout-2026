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
public final class PremiumOuterClass$RequestCalculateDiscountedPrice extends GeneratedMessageLite implements U64 {
    public static final int COUPON_CODE_FIELD_NUMBER = 2;
    private static final PremiumOuterClass$RequestCalculateDiscountedPrice DEFAULT_INSTANCE;
    public static final int PACKAGE_ID_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private String couponCode_ = "";
    private long packageId_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(String str) {
            q();
            ((PremiumOuterClass$RequestCalculateDiscountedPrice) this.b).setCouponCode(str);
            return this;
        }

        public a B(long j) {
            q();
            ((PremiumOuterClass$RequestCalculateDiscountedPrice) this.b).setPackageId(j);
            return this;
        }

        private a() {
            super(PremiumOuterClass$RequestCalculateDiscountedPrice.DEFAULT_INSTANCE);
        }
    }

    static {
        PremiumOuterClass$RequestCalculateDiscountedPrice premiumOuterClass$RequestCalculateDiscountedPrice = new PremiumOuterClass$RequestCalculateDiscountedPrice();
        DEFAULT_INSTANCE = premiumOuterClass$RequestCalculateDiscountedPrice;
        GeneratedMessageLite.registerDefaultInstance(PremiumOuterClass$RequestCalculateDiscountedPrice.class, premiumOuterClass$RequestCalculateDiscountedPrice);
    }

    private PremiumOuterClass$RequestCalculateDiscountedPrice() {
    }

    private void clearCouponCode() {
        this.couponCode_ = getDefaultInstance().getCouponCode();
    }

    private void clearPackageId() {
        this.packageId_ = 0L;
    }

    public static PremiumOuterClass$RequestCalculateDiscountedPrice getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static PremiumOuterClass$RequestCalculateDiscountedPrice parseDelimitedFrom(InputStream inputStream) {
        return (PremiumOuterClass$RequestCalculateDiscountedPrice) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PremiumOuterClass$RequestCalculateDiscountedPrice parseFrom(ByteBuffer byteBuffer) {
        return (PremiumOuterClass$RequestCalculateDiscountedPrice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCouponCode(String str) {
        str.getClass();
        this.couponCode_ = str;
    }

    private void setCouponCodeBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.couponCode_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPackageId(long j) {
        this.packageId_ = j;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1860h1.a[gVar.ordinal()]) {
            case 1:
                return new PremiumOuterClass$RequestCalculateDiscountedPrice();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0002\u0002Ȉ", new Object[]{"packageId_", "couponCode_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (PremiumOuterClass$RequestCalculateDiscountedPrice.class) {
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

    public String getCouponCode() {
        return this.couponCode_;
    }

    public AbstractC2383g getCouponCodeBytes() {
        return AbstractC2383g.N(this.couponCode_);
    }

    public long getPackageId() {
        return this.packageId_;
    }

    public static a newBuilder(PremiumOuterClass$RequestCalculateDiscountedPrice premiumOuterClass$RequestCalculateDiscountedPrice) {
        return (a) DEFAULT_INSTANCE.createBuilder(premiumOuterClass$RequestCalculateDiscountedPrice);
    }

    public static PremiumOuterClass$RequestCalculateDiscountedPrice parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (PremiumOuterClass$RequestCalculateDiscountedPrice) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PremiumOuterClass$RequestCalculateDiscountedPrice parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (PremiumOuterClass$RequestCalculateDiscountedPrice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static PremiumOuterClass$RequestCalculateDiscountedPrice parseFrom(AbstractC2383g abstractC2383g) {
        return (PremiumOuterClass$RequestCalculateDiscountedPrice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static PremiumOuterClass$RequestCalculateDiscountedPrice parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (PremiumOuterClass$RequestCalculateDiscountedPrice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static PremiumOuterClass$RequestCalculateDiscountedPrice parseFrom(byte[] bArr) {
        return (PremiumOuterClass$RequestCalculateDiscountedPrice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PremiumOuterClass$RequestCalculateDiscountedPrice parseFrom(byte[] bArr, C2394s c2394s) {
        return (PremiumOuterClass$RequestCalculateDiscountedPrice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static PremiumOuterClass$RequestCalculateDiscountedPrice parseFrom(InputStream inputStream) {
        return (PremiumOuterClass$RequestCalculateDiscountedPrice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PremiumOuterClass$RequestCalculateDiscountedPrice parseFrom(InputStream inputStream, C2394s c2394s) {
        return (PremiumOuterClass$RequestCalculateDiscountedPrice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PremiumOuterClass$RequestCalculateDiscountedPrice parseFrom(AbstractC2384h abstractC2384h) {
        return (PremiumOuterClass$RequestCalculateDiscountedPrice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static PremiumOuterClass$RequestCalculateDiscountedPrice parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (PremiumOuterClass$RequestCalculateDiscountedPrice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
