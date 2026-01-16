package ai.bale.proto;

import ai.bale.proto.CouponCreditOuterClass$GetByGroupMerchantIds;
import ai.bale.proto.CouponCreditOuterClass$GetByMerchantToken;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class CouponCreditOuterClass$RequestGetAvailableGroupCoupons extends GeneratedMessageLite implements U64 {
    private static final CouponCreditOuterClass$RequestGetAvailableGroupCoupons DEFAULT_INSTANCE;
    public static final int MERCHANT_IDS_FIELD_NUMBER = 1;
    public static final int MERCHANT_TOKEN_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER;
    private int traitCase_ = 0;
    private Object trait_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(CouponCreditOuterClass$RequestGetAvailableGroupCoupons.DEFAULT_INSTANCE);
        }
    }

    public enum b {
        MERCHANT_IDS(1),
        MERCHANT_TOKEN(2),
        TRAIT_NOT_SET(0);

        private final int a;

        b(int i) {
            this.a = i;
        }

        public static b j(int i) {
            if (i == 0) {
                return TRAIT_NOT_SET;
            }
            if (i == 1) {
                return MERCHANT_IDS;
            }
            if (i != 2) {
                return null;
            }
            return MERCHANT_TOKEN;
        }
    }

    static {
        CouponCreditOuterClass$RequestGetAvailableGroupCoupons couponCreditOuterClass$RequestGetAvailableGroupCoupons = new CouponCreditOuterClass$RequestGetAvailableGroupCoupons();
        DEFAULT_INSTANCE = couponCreditOuterClass$RequestGetAvailableGroupCoupons;
        GeneratedMessageLite.registerDefaultInstance(CouponCreditOuterClass$RequestGetAvailableGroupCoupons.class, couponCreditOuterClass$RequestGetAvailableGroupCoupons);
    }

    private CouponCreditOuterClass$RequestGetAvailableGroupCoupons() {
    }

    private void clearMerchantIds() {
        if (this.traitCase_ == 1) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearMerchantToken() {
        if (this.traitCase_ == 2) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearTrait() {
        this.traitCase_ = 0;
        this.trait_ = null;
    }

    public static CouponCreditOuterClass$RequestGetAvailableGroupCoupons getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeMerchantIds(CouponCreditOuterClass$GetByGroupMerchantIds couponCreditOuterClass$GetByGroupMerchantIds) {
        couponCreditOuterClass$GetByGroupMerchantIds.getClass();
        if (this.traitCase_ != 1 || this.trait_ == CouponCreditOuterClass$GetByGroupMerchantIds.getDefaultInstance()) {
            this.trait_ = couponCreditOuterClass$GetByGroupMerchantIds;
        } else {
            this.trait_ = ((CouponCreditOuterClass$GetByGroupMerchantIds.a) CouponCreditOuterClass$GetByGroupMerchantIds.newBuilder((CouponCreditOuterClass$GetByGroupMerchantIds) this.trait_).v(couponCreditOuterClass$GetByGroupMerchantIds)).j();
        }
        this.traitCase_ = 1;
    }

    private void mergeMerchantToken(CouponCreditOuterClass$GetByMerchantToken couponCreditOuterClass$GetByMerchantToken) {
        couponCreditOuterClass$GetByMerchantToken.getClass();
        if (this.traitCase_ != 2 || this.trait_ == CouponCreditOuterClass$GetByMerchantToken.getDefaultInstance()) {
            this.trait_ = couponCreditOuterClass$GetByMerchantToken;
        } else {
            this.trait_ = ((CouponCreditOuterClass$GetByMerchantToken.a) CouponCreditOuterClass$GetByMerchantToken.newBuilder((CouponCreditOuterClass$GetByMerchantToken) this.trait_).v(couponCreditOuterClass$GetByMerchantToken)).j();
        }
        this.traitCase_ = 2;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static CouponCreditOuterClass$RequestGetAvailableGroupCoupons parseDelimitedFrom(InputStream inputStream) {
        return (CouponCreditOuterClass$RequestGetAvailableGroupCoupons) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static CouponCreditOuterClass$RequestGetAvailableGroupCoupons parseFrom(ByteBuffer byteBuffer) {
        return (CouponCreditOuterClass$RequestGetAvailableGroupCoupons) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setMerchantIds(CouponCreditOuterClass$GetByGroupMerchantIds couponCreditOuterClass$GetByGroupMerchantIds) {
        couponCreditOuterClass$GetByGroupMerchantIds.getClass();
        this.trait_ = couponCreditOuterClass$GetByGroupMerchantIds;
        this.traitCase_ = 1;
    }

    private void setMerchantToken(CouponCreditOuterClass$GetByMerchantToken couponCreditOuterClass$GetByMerchantToken) {
        couponCreditOuterClass$GetByMerchantToken.getClass();
        this.trait_ = couponCreditOuterClass$GetByMerchantToken;
        this.traitCase_ = 2;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (I.a[gVar.ordinal()]) {
            case 1:
                return new CouponCreditOuterClass$RequestGetAvailableGroupCoupons();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0001\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001<\u0000\u0002<\u0000", new Object[]{"trait_", "traitCase_", CouponCreditOuterClass$GetByGroupMerchantIds.class, CouponCreditOuterClass$GetByMerchantToken.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (CouponCreditOuterClass$RequestGetAvailableGroupCoupons.class) {
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

    public CouponCreditOuterClass$GetByGroupMerchantIds getMerchantIds() {
        return this.traitCase_ == 1 ? (CouponCreditOuterClass$GetByGroupMerchantIds) this.trait_ : CouponCreditOuterClass$GetByGroupMerchantIds.getDefaultInstance();
    }

    public CouponCreditOuterClass$GetByMerchantToken getMerchantToken() {
        return this.traitCase_ == 2 ? (CouponCreditOuterClass$GetByMerchantToken) this.trait_ : CouponCreditOuterClass$GetByMerchantToken.getDefaultInstance();
    }

    public b getTraitCase() {
        return b.j(this.traitCase_);
    }

    public boolean hasMerchantIds() {
        return this.traitCase_ == 1;
    }

    public boolean hasMerchantToken() {
        return this.traitCase_ == 2;
    }

    public static a newBuilder(CouponCreditOuterClass$RequestGetAvailableGroupCoupons couponCreditOuterClass$RequestGetAvailableGroupCoupons) {
        return (a) DEFAULT_INSTANCE.createBuilder(couponCreditOuterClass$RequestGetAvailableGroupCoupons);
    }

    public static CouponCreditOuterClass$RequestGetAvailableGroupCoupons parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (CouponCreditOuterClass$RequestGetAvailableGroupCoupons) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static CouponCreditOuterClass$RequestGetAvailableGroupCoupons parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (CouponCreditOuterClass$RequestGetAvailableGroupCoupons) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static CouponCreditOuterClass$RequestGetAvailableGroupCoupons parseFrom(AbstractC2383g abstractC2383g) {
        return (CouponCreditOuterClass$RequestGetAvailableGroupCoupons) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static CouponCreditOuterClass$RequestGetAvailableGroupCoupons parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (CouponCreditOuterClass$RequestGetAvailableGroupCoupons) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static CouponCreditOuterClass$RequestGetAvailableGroupCoupons parseFrom(byte[] bArr) {
        return (CouponCreditOuterClass$RequestGetAvailableGroupCoupons) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static CouponCreditOuterClass$RequestGetAvailableGroupCoupons parseFrom(byte[] bArr, C2394s c2394s) {
        return (CouponCreditOuterClass$RequestGetAvailableGroupCoupons) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static CouponCreditOuterClass$RequestGetAvailableGroupCoupons parseFrom(InputStream inputStream) {
        return (CouponCreditOuterClass$RequestGetAvailableGroupCoupons) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static CouponCreditOuterClass$RequestGetAvailableGroupCoupons parseFrom(InputStream inputStream, C2394s c2394s) {
        return (CouponCreditOuterClass$RequestGetAvailableGroupCoupons) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static CouponCreditOuterClass$RequestGetAvailableGroupCoupons parseFrom(AbstractC2384h abstractC2384h) {
        return (CouponCreditOuterClass$RequestGetAvailableGroupCoupons) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static CouponCreditOuterClass$RequestGetAvailableGroupCoupons parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (CouponCreditOuterClass$RequestGetAvailableGroupCoupons) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
