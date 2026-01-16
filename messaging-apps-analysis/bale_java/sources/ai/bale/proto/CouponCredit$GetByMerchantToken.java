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
public final class CouponCredit$GetByMerchantToken extends GeneratedMessageLite implements U64 {
    private static final CouponCredit$GetByMerchantToken DEFAULT_INSTANCE;
    public static final int MERCHANT_TOKEN_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private String merchantToken_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(CouponCredit$GetByMerchantToken.DEFAULT_INSTANCE);
        }
    }

    static {
        CouponCredit$GetByMerchantToken couponCredit$GetByMerchantToken = new CouponCredit$GetByMerchantToken();
        DEFAULT_INSTANCE = couponCredit$GetByMerchantToken;
        GeneratedMessageLite.registerDefaultInstance(CouponCredit$GetByMerchantToken.class, couponCredit$GetByMerchantToken);
    }

    private CouponCredit$GetByMerchantToken() {
    }

    private void clearMerchantToken() {
        this.merchantToken_ = getDefaultInstance().getMerchantToken();
    }

    public static CouponCredit$GetByMerchantToken getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static CouponCredit$GetByMerchantToken parseDelimitedFrom(InputStream inputStream) {
        return (CouponCredit$GetByMerchantToken) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static CouponCredit$GetByMerchantToken parseFrom(ByteBuffer byteBuffer) {
        return (CouponCredit$GetByMerchantToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setMerchantToken(String str) {
        str.getClass();
        this.merchantToken_ = str;
    }

    private void setMerchantTokenBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.merchantToken_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (H.a[gVar.ordinal()]) {
            case 1:
                return new CouponCredit$GetByMerchantToken();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"merchantToken_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (CouponCredit$GetByMerchantToken.class) {
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

    public String getMerchantToken() {
        return this.merchantToken_;
    }

    public AbstractC2383g getMerchantTokenBytes() {
        return AbstractC2383g.N(this.merchantToken_);
    }

    public static a newBuilder(CouponCredit$GetByMerchantToken couponCredit$GetByMerchantToken) {
        return (a) DEFAULT_INSTANCE.createBuilder(couponCredit$GetByMerchantToken);
    }

    public static CouponCredit$GetByMerchantToken parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (CouponCredit$GetByMerchantToken) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static CouponCredit$GetByMerchantToken parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (CouponCredit$GetByMerchantToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static CouponCredit$GetByMerchantToken parseFrom(AbstractC2383g abstractC2383g) {
        return (CouponCredit$GetByMerchantToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static CouponCredit$GetByMerchantToken parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (CouponCredit$GetByMerchantToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static CouponCredit$GetByMerchantToken parseFrom(byte[] bArr) {
        return (CouponCredit$GetByMerchantToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static CouponCredit$GetByMerchantToken parseFrom(byte[] bArr, C2394s c2394s) {
        return (CouponCredit$GetByMerchantToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static CouponCredit$GetByMerchantToken parseFrom(InputStream inputStream) {
        return (CouponCredit$GetByMerchantToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static CouponCredit$GetByMerchantToken parseFrom(InputStream inputStream, C2394s c2394s) {
        return (CouponCredit$GetByMerchantToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static CouponCredit$GetByMerchantToken parseFrom(AbstractC2384h abstractC2384h) {
        return (CouponCredit$GetByMerchantToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static CouponCredit$GetByMerchantToken parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (CouponCredit$GetByMerchantToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
