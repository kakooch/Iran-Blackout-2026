package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC25153zp1;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class CouponCredit$ResponseGetAvailableGroupCoupons extends GeneratedMessageLite implements U64 {
    private static final CouponCredit$ResponseGetAvailableGroupCoupons DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int USER_COUPONS_FIELD_NUMBER = 1;
    private B.j userCoupons_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(CouponCredit$ResponseGetAvailableGroupCoupons.DEFAULT_INSTANCE);
        }
    }

    static {
        CouponCredit$ResponseGetAvailableGroupCoupons couponCredit$ResponseGetAvailableGroupCoupons = new CouponCredit$ResponseGetAvailableGroupCoupons();
        DEFAULT_INSTANCE = couponCredit$ResponseGetAvailableGroupCoupons;
        GeneratedMessageLite.registerDefaultInstance(CouponCredit$ResponseGetAvailableGroupCoupons.class, couponCredit$ResponseGetAvailableGroupCoupons);
    }

    private CouponCredit$ResponseGetAvailableGroupCoupons() {
    }

    private void addAllUserCoupons(Iterable<? extends CouponCreditStruct$UserCoupon> iterable) {
        ensureUserCouponsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.userCoupons_);
    }

    private void addUserCoupons(CouponCreditStruct$UserCoupon couponCreditStruct$UserCoupon) {
        couponCreditStruct$UserCoupon.getClass();
        ensureUserCouponsIsMutable();
        this.userCoupons_.add(couponCreditStruct$UserCoupon);
    }

    private void clearUserCoupons() {
        this.userCoupons_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureUserCouponsIsMutable() {
        B.j jVar = this.userCoupons_;
        if (jVar.u()) {
            return;
        }
        this.userCoupons_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static CouponCredit$ResponseGetAvailableGroupCoupons getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static CouponCredit$ResponseGetAvailableGroupCoupons parseDelimitedFrom(InputStream inputStream) {
        return (CouponCredit$ResponseGetAvailableGroupCoupons) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static CouponCredit$ResponseGetAvailableGroupCoupons parseFrom(ByteBuffer byteBuffer) {
        return (CouponCredit$ResponseGetAvailableGroupCoupons) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeUserCoupons(int i) {
        ensureUserCouponsIsMutable();
        this.userCoupons_.remove(i);
    }

    private void setUserCoupons(int i, CouponCreditStruct$UserCoupon couponCreditStruct$UserCoupon) {
        couponCreditStruct$UserCoupon.getClass();
        ensureUserCouponsIsMutable();
        this.userCoupons_.set(i, couponCreditStruct$UserCoupon);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (H.a[gVar.ordinal()]) {
            case 1:
                return new CouponCredit$ResponseGetAvailableGroupCoupons();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"userCoupons_", CouponCreditStruct$UserCoupon.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (CouponCredit$ResponseGetAvailableGroupCoupons.class) {
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

    public CouponCreditStruct$UserCoupon getUserCoupons(int i) {
        return (CouponCreditStruct$UserCoupon) this.userCoupons_.get(i);
    }

    public int getUserCouponsCount() {
        return this.userCoupons_.size();
    }

    public List<CouponCreditStruct$UserCoupon> getUserCouponsList() {
        return this.userCoupons_;
    }

    public InterfaceC25153zp1 getUserCouponsOrBuilder(int i) {
        return (InterfaceC25153zp1) this.userCoupons_.get(i);
    }

    public List<? extends InterfaceC25153zp1> getUserCouponsOrBuilderList() {
        return this.userCoupons_;
    }

    public static a newBuilder(CouponCredit$ResponseGetAvailableGroupCoupons couponCredit$ResponseGetAvailableGroupCoupons) {
        return (a) DEFAULT_INSTANCE.createBuilder(couponCredit$ResponseGetAvailableGroupCoupons);
    }

    public static CouponCredit$ResponseGetAvailableGroupCoupons parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (CouponCredit$ResponseGetAvailableGroupCoupons) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static CouponCredit$ResponseGetAvailableGroupCoupons parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (CouponCredit$ResponseGetAvailableGroupCoupons) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static CouponCredit$ResponseGetAvailableGroupCoupons parseFrom(AbstractC2383g abstractC2383g) {
        return (CouponCredit$ResponseGetAvailableGroupCoupons) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addUserCoupons(int i, CouponCreditStruct$UserCoupon couponCreditStruct$UserCoupon) {
        couponCreditStruct$UserCoupon.getClass();
        ensureUserCouponsIsMutable();
        this.userCoupons_.add(i, couponCreditStruct$UserCoupon);
    }

    public static CouponCredit$ResponseGetAvailableGroupCoupons parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (CouponCredit$ResponseGetAvailableGroupCoupons) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static CouponCredit$ResponseGetAvailableGroupCoupons parseFrom(byte[] bArr) {
        return (CouponCredit$ResponseGetAvailableGroupCoupons) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static CouponCredit$ResponseGetAvailableGroupCoupons parseFrom(byte[] bArr, C2394s c2394s) {
        return (CouponCredit$ResponseGetAvailableGroupCoupons) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static CouponCredit$ResponseGetAvailableGroupCoupons parseFrom(InputStream inputStream) {
        return (CouponCredit$ResponseGetAvailableGroupCoupons) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static CouponCredit$ResponseGetAvailableGroupCoupons parseFrom(InputStream inputStream, C2394s c2394s) {
        return (CouponCredit$ResponseGetAvailableGroupCoupons) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static CouponCredit$ResponseGetAvailableGroupCoupons parseFrom(AbstractC2384h abstractC2384h) {
        return (CouponCredit$ResponseGetAvailableGroupCoupons) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static CouponCredit$ResponseGetAvailableGroupCoupons parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (CouponCredit$ResponseGetAvailableGroupCoupons) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
