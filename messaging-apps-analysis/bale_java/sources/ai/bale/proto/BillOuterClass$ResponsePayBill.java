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
public final class BillOuterClass$ResponsePayBill extends GeneratedMessageLite implements U64 {
    private static final BillOuterClass$ResponsePayBill DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int PAYMENT_TOKEN_FIELD_NUMBER = 1;
    private String paymentToken_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(BillOuterClass$ResponsePayBill.DEFAULT_INSTANCE);
        }
    }

    static {
        BillOuterClass$ResponsePayBill billOuterClass$ResponsePayBill = new BillOuterClass$ResponsePayBill();
        DEFAULT_INSTANCE = billOuterClass$ResponsePayBill;
        GeneratedMessageLite.registerDefaultInstance(BillOuterClass$ResponsePayBill.class, billOuterClass$ResponsePayBill);
    }

    private BillOuterClass$ResponsePayBill() {
    }

    private void clearPaymentToken() {
        this.paymentToken_ = getDefaultInstance().getPaymentToken();
    }

    public static BillOuterClass$ResponsePayBill getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static BillOuterClass$ResponsePayBill parseDelimitedFrom(InputStream inputStream) {
        return (BillOuterClass$ResponsePayBill) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BillOuterClass$ResponsePayBill parseFrom(ByteBuffer byteBuffer) {
        return (BillOuterClass$ResponsePayBill) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setPaymentToken(String str) {
        str.getClass();
        this.paymentToken_ = str;
    }

    private void setPaymentTokenBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.paymentToken_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (r.a[gVar.ordinal()]) {
            case 1:
                return new BillOuterClass$ResponsePayBill();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"paymentToken_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (BillOuterClass$ResponsePayBill.class) {
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

    public String getPaymentToken() {
        return this.paymentToken_;
    }

    public AbstractC2383g getPaymentTokenBytes() {
        return AbstractC2383g.N(this.paymentToken_);
    }

    public static a newBuilder(BillOuterClass$ResponsePayBill billOuterClass$ResponsePayBill) {
        return (a) DEFAULT_INSTANCE.createBuilder(billOuterClass$ResponsePayBill);
    }

    public static BillOuterClass$ResponsePayBill parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (BillOuterClass$ResponsePayBill) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BillOuterClass$ResponsePayBill parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (BillOuterClass$ResponsePayBill) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static BillOuterClass$ResponsePayBill parseFrom(AbstractC2383g abstractC2383g) {
        return (BillOuterClass$ResponsePayBill) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static BillOuterClass$ResponsePayBill parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (BillOuterClass$ResponsePayBill) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static BillOuterClass$ResponsePayBill parseFrom(byte[] bArr) {
        return (BillOuterClass$ResponsePayBill) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static BillOuterClass$ResponsePayBill parseFrom(byte[] bArr, C2394s c2394s) {
        return (BillOuterClass$ResponsePayBill) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static BillOuterClass$ResponsePayBill parseFrom(InputStream inputStream) {
        return (BillOuterClass$ResponsePayBill) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BillOuterClass$ResponsePayBill parseFrom(InputStream inputStream, C2394s c2394s) {
        return (BillOuterClass$ResponsePayBill) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BillOuterClass$ResponsePayBill parseFrom(AbstractC2384h abstractC2384h) {
        return (BillOuterClass$ResponsePayBill) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static BillOuterClass$ResponsePayBill parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (BillOuterClass$ResponsePayBill) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
