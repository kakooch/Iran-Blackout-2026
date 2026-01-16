package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.StringValue;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class PremiumOuterClass$RequestPurchasePackage extends GeneratedMessageLite implements U64 {
    public static final int COUPON_CODE_FIELD_NUMBER = 2;
    private static final PremiumOuterClass$RequestPurchasePackage DEFAULT_INSTANCE;
    public static final int PACKAGE_ID_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private StringValue couponCode_;
    private long packageId_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(StringValue stringValue) {
            q();
            ((PremiumOuterClass$RequestPurchasePackage) this.b).setCouponCode(stringValue);
            return this;
        }

        public a B(long j) {
            q();
            ((PremiumOuterClass$RequestPurchasePackage) this.b).setPackageId(j);
            return this;
        }

        private a() {
            super(PremiumOuterClass$RequestPurchasePackage.DEFAULT_INSTANCE);
        }
    }

    static {
        PremiumOuterClass$RequestPurchasePackage premiumOuterClass$RequestPurchasePackage = new PremiumOuterClass$RequestPurchasePackage();
        DEFAULT_INSTANCE = premiumOuterClass$RequestPurchasePackage;
        GeneratedMessageLite.registerDefaultInstance(PremiumOuterClass$RequestPurchasePackage.class, premiumOuterClass$RequestPurchasePackage);
    }

    private PremiumOuterClass$RequestPurchasePackage() {
    }

    private void clearCouponCode() {
        this.couponCode_ = null;
        this.bitField0_ &= -2;
    }

    private void clearPackageId() {
        this.packageId_ = 0L;
    }

    public static PremiumOuterClass$RequestPurchasePackage getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeCouponCode(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.couponCode_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.couponCode_ = stringValue;
        } else {
            this.couponCode_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.couponCode_).v(stringValue)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static PremiumOuterClass$RequestPurchasePackage parseDelimitedFrom(InputStream inputStream) {
        return (PremiumOuterClass$RequestPurchasePackage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PremiumOuterClass$RequestPurchasePackage parseFrom(ByteBuffer byteBuffer) {
        return (PremiumOuterClass$RequestPurchasePackage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCouponCode(StringValue stringValue) {
        stringValue.getClass();
        this.couponCode_ = stringValue;
        this.bitField0_ |= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPackageId(long j) {
        this.packageId_ = j;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1860h1.a[gVar.ordinal()]) {
            case 1:
                return new PremiumOuterClass$RequestPurchasePackage();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0002\u0002ဉ\u0000", new Object[]{"bitField0_", "packageId_", "couponCode_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (PremiumOuterClass$RequestPurchasePackage.class) {
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

    public StringValue getCouponCode() {
        StringValue stringValue = this.couponCode_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public long getPackageId() {
        return this.packageId_;
    }

    public boolean hasCouponCode() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(PremiumOuterClass$RequestPurchasePackage premiumOuterClass$RequestPurchasePackage) {
        return (a) DEFAULT_INSTANCE.createBuilder(premiumOuterClass$RequestPurchasePackage);
    }

    public static PremiumOuterClass$RequestPurchasePackage parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (PremiumOuterClass$RequestPurchasePackage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PremiumOuterClass$RequestPurchasePackage parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (PremiumOuterClass$RequestPurchasePackage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static PremiumOuterClass$RequestPurchasePackage parseFrom(AbstractC2383g abstractC2383g) {
        return (PremiumOuterClass$RequestPurchasePackage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static PremiumOuterClass$RequestPurchasePackage parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (PremiumOuterClass$RequestPurchasePackage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static PremiumOuterClass$RequestPurchasePackage parseFrom(byte[] bArr) {
        return (PremiumOuterClass$RequestPurchasePackage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PremiumOuterClass$RequestPurchasePackage parseFrom(byte[] bArr, C2394s c2394s) {
        return (PremiumOuterClass$RequestPurchasePackage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static PremiumOuterClass$RequestPurchasePackage parseFrom(InputStream inputStream) {
        return (PremiumOuterClass$RequestPurchasePackage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PremiumOuterClass$RequestPurchasePackage parseFrom(InputStream inputStream, C2394s c2394s) {
        return (PremiumOuterClass$RequestPurchasePackage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PremiumOuterClass$RequestPurchasePackage parseFrom(AbstractC2384h abstractC2384h) {
        return (PremiumOuterClass$RequestPurchasePackage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static PremiumOuterClass$RequestPurchasePackage parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (PremiumOuterClass$RequestPurchasePackage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
