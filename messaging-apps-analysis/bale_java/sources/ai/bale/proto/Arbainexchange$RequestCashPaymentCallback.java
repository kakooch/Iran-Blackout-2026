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
public final class Arbainexchange$RequestCashPaymentCallback extends GeneratedMessageLite implements U64 {
    private static final Arbainexchange$RequestCashPaymentCallback DEFAULT_INSTANCE;
    public static final int NATIONAL_CODE_FIELD_NUMBER = 2;
    public static final int ORDER_ID_FIELD_NUMBER = 4;
    private static volatile KW4 PARSER = null;
    public static final int PAYMENT_CODE_FIELD_NUMBER = 1;
    public static final int USER_ID_FIELD_NUMBER = 3;
    private int orderId_;
    private int userId_;
    private String paymentCode_ = "";
    private String nationalCode_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Arbainexchange$RequestCashPaymentCallback.DEFAULT_INSTANCE);
        }
    }

    static {
        Arbainexchange$RequestCashPaymentCallback arbainexchange$RequestCashPaymentCallback = new Arbainexchange$RequestCashPaymentCallback();
        DEFAULT_INSTANCE = arbainexchange$RequestCashPaymentCallback;
        GeneratedMessageLite.registerDefaultInstance(Arbainexchange$RequestCashPaymentCallback.class, arbainexchange$RequestCashPaymentCallback);
    }

    private Arbainexchange$RequestCashPaymentCallback() {
    }

    private void clearNationalCode() {
        this.nationalCode_ = getDefaultInstance().getNationalCode();
    }

    private void clearOrderId() {
        this.orderId_ = 0;
    }

    private void clearPaymentCode() {
        this.paymentCode_ = getDefaultInstance().getPaymentCode();
    }

    private void clearUserId() {
        this.userId_ = 0;
    }

    public static Arbainexchange$RequestCashPaymentCallback getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Arbainexchange$RequestCashPaymentCallback parseDelimitedFrom(InputStream inputStream) {
        return (Arbainexchange$RequestCashPaymentCallback) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Arbainexchange$RequestCashPaymentCallback parseFrom(ByteBuffer byteBuffer) {
        return (Arbainexchange$RequestCashPaymentCallback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setNationalCode(String str) {
        str.getClass();
        this.nationalCode_ = str;
    }

    private void setNationalCodeBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.nationalCode_ = abstractC2383g.f0();
    }

    private void setOrderId(int i) {
        this.orderId_ = i;
    }

    private void setPaymentCode(String str) {
        str.getClass();
        this.paymentCode_ = str;
    }

    private void setPaymentCodeBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.paymentCode_ = abstractC2383g.f0();
    }

    private void setUserId(int i) {
        this.userId_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1861i.a[gVar.ordinal()]) {
            case 1:
                return new Arbainexchange$RequestCashPaymentCallback();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\u0004\u0004\u0004", new Object[]{"paymentCode_", "nationalCode_", "userId_", "orderId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Arbainexchange$RequestCashPaymentCallback.class) {
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

    public String getNationalCode() {
        return this.nationalCode_;
    }

    public AbstractC2383g getNationalCodeBytes() {
        return AbstractC2383g.N(this.nationalCode_);
    }

    public int getOrderId() {
        return this.orderId_;
    }

    public String getPaymentCode() {
        return this.paymentCode_;
    }

    public AbstractC2383g getPaymentCodeBytes() {
        return AbstractC2383g.N(this.paymentCode_);
    }

    public int getUserId() {
        return this.userId_;
    }

    public static a newBuilder(Arbainexchange$RequestCashPaymentCallback arbainexchange$RequestCashPaymentCallback) {
        return (a) DEFAULT_INSTANCE.createBuilder(arbainexchange$RequestCashPaymentCallback);
    }

    public static Arbainexchange$RequestCashPaymentCallback parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Arbainexchange$RequestCashPaymentCallback) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Arbainexchange$RequestCashPaymentCallback parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Arbainexchange$RequestCashPaymentCallback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Arbainexchange$RequestCashPaymentCallback parseFrom(AbstractC2383g abstractC2383g) {
        return (Arbainexchange$RequestCashPaymentCallback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static Arbainexchange$RequestCashPaymentCallback parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Arbainexchange$RequestCashPaymentCallback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Arbainexchange$RequestCashPaymentCallback parseFrom(byte[] bArr) {
        return (Arbainexchange$RequestCashPaymentCallback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Arbainexchange$RequestCashPaymentCallback parseFrom(byte[] bArr, C2394s c2394s) {
        return (Arbainexchange$RequestCashPaymentCallback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Arbainexchange$RequestCashPaymentCallback parseFrom(InputStream inputStream) {
        return (Arbainexchange$RequestCashPaymentCallback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Arbainexchange$RequestCashPaymentCallback parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Arbainexchange$RequestCashPaymentCallback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Arbainexchange$RequestCashPaymentCallback parseFrom(AbstractC2384h abstractC2384h) {
        return (Arbainexchange$RequestCashPaymentCallback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Arbainexchange$RequestCashPaymentCallback parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Arbainexchange$RequestCashPaymentCallback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
