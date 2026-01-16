package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC25153zp1;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class CouponCreditStruct$UserCoupon extends GeneratedMessageLite implements InterfaceC25153zp1 {
    public static final int CREDIT_FIELD_NUMBER = 2;
    private static final CouponCreditStruct$UserCoupon DEFAULT_INSTANCE;
    public static final int EXPIRATION_DATE_FIELD_NUMBER = 3;
    public static final int ID_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int TITLE_FIELD_NUMBER = 5;
    public static final int USAGE_PERCENT_FIELD_NUMBER = 4;
    private long credit_;
    private long expirationDate_;
    private int id_;
    private String title_ = "";
    private int usagePercent_;

    public static final class a extends GeneratedMessageLite.b implements InterfaceC25153zp1 {
        private a() {
            super(CouponCreditStruct$UserCoupon.DEFAULT_INSTANCE);
        }
    }

    static {
        CouponCreditStruct$UserCoupon couponCreditStruct$UserCoupon = new CouponCreditStruct$UserCoupon();
        DEFAULT_INSTANCE = couponCreditStruct$UserCoupon;
        GeneratedMessageLite.registerDefaultInstance(CouponCreditStruct$UserCoupon.class, couponCreditStruct$UserCoupon);
    }

    private CouponCreditStruct$UserCoupon() {
    }

    private void clearCredit() {
        this.credit_ = 0L;
    }

    private void clearExpirationDate() {
        this.expirationDate_ = 0L;
    }

    private void clearId() {
        this.id_ = 0;
    }

    private void clearTitle() {
        this.title_ = getDefaultInstance().getTitle();
    }

    private void clearUsagePercent() {
        this.usagePercent_ = 0;
    }

    public static CouponCreditStruct$UserCoupon getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static CouponCreditStruct$UserCoupon parseDelimitedFrom(InputStream inputStream) {
        return (CouponCreditStruct$UserCoupon) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static CouponCreditStruct$UserCoupon parseFrom(ByteBuffer byteBuffer) {
        return (CouponCreditStruct$UserCoupon) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setCredit(long j) {
        this.credit_ = j;
    }

    private void setExpirationDate(long j) {
        this.expirationDate_ = j;
    }

    private void setId(int i) {
        this.id_ = i;
    }

    private void setTitle(String str) {
        str.getClass();
        this.title_ = str;
    }

    private void setTitleBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.title_ = abstractC2383g.f0();
    }

    private void setUsagePercent(int i) {
        this.usagePercent_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (J.a[gVar.ordinal()]) {
            case 1:
                return new CouponCreditStruct$UserCoupon();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0000\u0000\u0001\u0004\u0002\u0002\u0003\u0002\u0004\u0004\u0005Ȉ", new Object[]{"id_", "credit_", "expirationDate_", "usagePercent_", "title_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (CouponCreditStruct$UserCoupon.class) {
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

    public long getCredit() {
        return this.credit_;
    }

    public long getExpirationDate() {
        return this.expirationDate_;
    }

    public int getId() {
        return this.id_;
    }

    public String getTitle() {
        return this.title_;
    }

    public AbstractC2383g getTitleBytes() {
        return AbstractC2383g.N(this.title_);
    }

    public int getUsagePercent() {
        return this.usagePercent_;
    }

    public static a newBuilder(CouponCreditStruct$UserCoupon couponCreditStruct$UserCoupon) {
        return (a) DEFAULT_INSTANCE.createBuilder(couponCreditStruct$UserCoupon);
    }

    public static CouponCreditStruct$UserCoupon parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (CouponCreditStruct$UserCoupon) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static CouponCreditStruct$UserCoupon parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (CouponCreditStruct$UserCoupon) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static CouponCreditStruct$UserCoupon parseFrom(AbstractC2383g abstractC2383g) {
        return (CouponCreditStruct$UserCoupon) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static CouponCreditStruct$UserCoupon parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (CouponCreditStruct$UserCoupon) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static CouponCreditStruct$UserCoupon parseFrom(byte[] bArr) {
        return (CouponCreditStruct$UserCoupon) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static CouponCreditStruct$UserCoupon parseFrom(byte[] bArr, C2394s c2394s) {
        return (CouponCreditStruct$UserCoupon) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static CouponCreditStruct$UserCoupon parseFrom(InputStream inputStream) {
        return (CouponCreditStruct$UserCoupon) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static CouponCreditStruct$UserCoupon parseFrom(InputStream inputStream, C2394s c2394s) {
        return (CouponCreditStruct$UserCoupon) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static CouponCreditStruct$UserCoupon parseFrom(AbstractC2384h abstractC2384h) {
        return (CouponCreditStruct$UserCoupon) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static CouponCreditStruct$UserCoupon parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (CouponCreditStruct$UserCoupon) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
