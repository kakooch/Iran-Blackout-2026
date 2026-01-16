package ai.bale.proto;

import ai.bale.proto.CouponCredit$GetByGroupMerchantIds;
import ai.bale.proto.CouponCredit$GetByMerchantToken;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class CouponCredit$RequestGetAvailableGroupCoupons extends GeneratedMessageLite implements U64 {
    private static final CouponCredit$RequestGetAvailableGroupCoupons DEFAULT_INSTANCE;
    public static final int MERCHANT_IDS_FIELD_NUMBER = 1;
    public static final int MERCHANT_TOKEN_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER;
    private int traitCase_ = 0;
    private Object trait_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(CouponCredit$RequestGetAvailableGroupCoupons.DEFAULT_INSTANCE);
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
        CouponCredit$RequestGetAvailableGroupCoupons couponCredit$RequestGetAvailableGroupCoupons = new CouponCredit$RequestGetAvailableGroupCoupons();
        DEFAULT_INSTANCE = couponCredit$RequestGetAvailableGroupCoupons;
        GeneratedMessageLite.registerDefaultInstance(CouponCredit$RequestGetAvailableGroupCoupons.class, couponCredit$RequestGetAvailableGroupCoupons);
    }

    private CouponCredit$RequestGetAvailableGroupCoupons() {
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

    public static CouponCredit$RequestGetAvailableGroupCoupons getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeMerchantIds(CouponCredit$GetByGroupMerchantIds couponCredit$GetByGroupMerchantIds) {
        couponCredit$GetByGroupMerchantIds.getClass();
        if (this.traitCase_ != 1 || this.trait_ == CouponCredit$GetByGroupMerchantIds.getDefaultInstance()) {
            this.trait_ = couponCredit$GetByGroupMerchantIds;
        } else {
            this.trait_ = ((CouponCredit$GetByGroupMerchantIds.a) CouponCredit$GetByGroupMerchantIds.newBuilder((CouponCredit$GetByGroupMerchantIds) this.trait_).v(couponCredit$GetByGroupMerchantIds)).j();
        }
        this.traitCase_ = 1;
    }

    private void mergeMerchantToken(CouponCredit$GetByMerchantToken couponCredit$GetByMerchantToken) {
        couponCredit$GetByMerchantToken.getClass();
        if (this.traitCase_ != 2 || this.trait_ == CouponCredit$GetByMerchantToken.getDefaultInstance()) {
            this.trait_ = couponCredit$GetByMerchantToken;
        } else {
            this.trait_ = ((CouponCredit$GetByMerchantToken.a) CouponCredit$GetByMerchantToken.newBuilder((CouponCredit$GetByMerchantToken) this.trait_).v(couponCredit$GetByMerchantToken)).j();
        }
        this.traitCase_ = 2;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static CouponCredit$RequestGetAvailableGroupCoupons parseDelimitedFrom(InputStream inputStream) {
        return (CouponCredit$RequestGetAvailableGroupCoupons) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static CouponCredit$RequestGetAvailableGroupCoupons parseFrom(ByteBuffer byteBuffer) {
        return (CouponCredit$RequestGetAvailableGroupCoupons) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setMerchantIds(CouponCredit$GetByGroupMerchantIds couponCredit$GetByGroupMerchantIds) {
        couponCredit$GetByGroupMerchantIds.getClass();
        this.trait_ = couponCredit$GetByGroupMerchantIds;
        this.traitCase_ = 1;
    }

    private void setMerchantToken(CouponCredit$GetByMerchantToken couponCredit$GetByMerchantToken) {
        couponCredit$GetByMerchantToken.getClass();
        this.trait_ = couponCredit$GetByMerchantToken;
        this.traitCase_ = 2;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (H.a[gVar.ordinal()]) {
            case 1:
                return new CouponCredit$RequestGetAvailableGroupCoupons();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0001\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001<\u0000\u0002<\u0000", new Object[]{"trait_", "traitCase_", CouponCredit$GetByGroupMerchantIds.class, CouponCredit$GetByMerchantToken.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (CouponCredit$RequestGetAvailableGroupCoupons.class) {
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

    public CouponCredit$GetByGroupMerchantIds getMerchantIds() {
        return this.traitCase_ == 1 ? (CouponCredit$GetByGroupMerchantIds) this.trait_ : CouponCredit$GetByGroupMerchantIds.getDefaultInstance();
    }

    public CouponCredit$GetByMerchantToken getMerchantToken() {
        return this.traitCase_ == 2 ? (CouponCredit$GetByMerchantToken) this.trait_ : CouponCredit$GetByMerchantToken.getDefaultInstance();
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

    public static a newBuilder(CouponCredit$RequestGetAvailableGroupCoupons couponCredit$RequestGetAvailableGroupCoupons) {
        return (a) DEFAULT_INSTANCE.createBuilder(couponCredit$RequestGetAvailableGroupCoupons);
    }

    public static CouponCredit$RequestGetAvailableGroupCoupons parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (CouponCredit$RequestGetAvailableGroupCoupons) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static CouponCredit$RequestGetAvailableGroupCoupons parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (CouponCredit$RequestGetAvailableGroupCoupons) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static CouponCredit$RequestGetAvailableGroupCoupons parseFrom(AbstractC2383g abstractC2383g) {
        return (CouponCredit$RequestGetAvailableGroupCoupons) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static CouponCredit$RequestGetAvailableGroupCoupons parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (CouponCredit$RequestGetAvailableGroupCoupons) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static CouponCredit$RequestGetAvailableGroupCoupons parseFrom(byte[] bArr) {
        return (CouponCredit$RequestGetAvailableGroupCoupons) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static CouponCredit$RequestGetAvailableGroupCoupons parseFrom(byte[] bArr, C2394s c2394s) {
        return (CouponCredit$RequestGetAvailableGroupCoupons) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static CouponCredit$RequestGetAvailableGroupCoupons parseFrom(InputStream inputStream) {
        return (CouponCredit$RequestGetAvailableGroupCoupons) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static CouponCredit$RequestGetAvailableGroupCoupons parseFrom(InputStream inputStream, C2394s c2394s) {
        return (CouponCredit$RequestGetAvailableGroupCoupons) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static CouponCredit$RequestGetAvailableGroupCoupons parseFrom(AbstractC2384h abstractC2384h) {
        return (CouponCredit$RequestGetAvailableGroupCoupons) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static CouponCredit$RequestGetAvailableGroupCoupons parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (CouponCredit$RequestGetAvailableGroupCoupons) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
