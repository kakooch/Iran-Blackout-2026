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
public final class KifpoolOuterClass$ResponseGetChargePaymentToken extends GeneratedMessageLite implements U64 {
    private static final KifpoolOuterClass$ResponseGetChargePaymentToken DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int PAYMENT_TOKEN_FIELD_NUMBER = 1;
    private String paymentToken_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(KifpoolOuterClass$ResponseGetChargePaymentToken.DEFAULT_INSTANCE);
        }
    }

    static {
        KifpoolOuterClass$ResponseGetChargePaymentToken kifpoolOuterClass$ResponseGetChargePaymentToken = new KifpoolOuterClass$ResponseGetChargePaymentToken();
        DEFAULT_INSTANCE = kifpoolOuterClass$ResponseGetChargePaymentToken;
        GeneratedMessageLite.registerDefaultInstance(KifpoolOuterClass$ResponseGetChargePaymentToken.class, kifpoolOuterClass$ResponseGetChargePaymentToken);
    }

    private KifpoolOuterClass$ResponseGetChargePaymentToken() {
    }

    private void clearPaymentToken() {
        this.paymentToken_ = getDefaultInstance().getPaymentToken();
    }

    public static KifpoolOuterClass$ResponseGetChargePaymentToken getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static KifpoolOuterClass$ResponseGetChargePaymentToken parseDelimitedFrom(InputStream inputStream) {
        return (KifpoolOuterClass$ResponseGetChargePaymentToken) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KifpoolOuterClass$ResponseGetChargePaymentToken parseFrom(ByteBuffer byteBuffer) {
        return (KifpoolOuterClass$ResponseGetChargePaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
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
        switch (AbstractC1897u0.a[gVar.ordinal()]) {
            case 1:
                return new KifpoolOuterClass$ResponseGetChargePaymentToken();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"paymentToken_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (KifpoolOuterClass$ResponseGetChargePaymentToken.class) {
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

    public static a newBuilder(KifpoolOuterClass$ResponseGetChargePaymentToken kifpoolOuterClass$ResponseGetChargePaymentToken) {
        return (a) DEFAULT_INSTANCE.createBuilder(kifpoolOuterClass$ResponseGetChargePaymentToken);
    }

    public static KifpoolOuterClass$ResponseGetChargePaymentToken parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (KifpoolOuterClass$ResponseGetChargePaymentToken) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KifpoolOuterClass$ResponseGetChargePaymentToken parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (KifpoolOuterClass$ResponseGetChargePaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static KifpoolOuterClass$ResponseGetChargePaymentToken parseFrom(AbstractC2383g abstractC2383g) {
        return (KifpoolOuterClass$ResponseGetChargePaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static KifpoolOuterClass$ResponseGetChargePaymentToken parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (KifpoolOuterClass$ResponseGetChargePaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static KifpoolOuterClass$ResponseGetChargePaymentToken parseFrom(byte[] bArr) {
        return (KifpoolOuterClass$ResponseGetChargePaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static KifpoolOuterClass$ResponseGetChargePaymentToken parseFrom(byte[] bArr, C2394s c2394s) {
        return (KifpoolOuterClass$ResponseGetChargePaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static KifpoolOuterClass$ResponseGetChargePaymentToken parseFrom(InputStream inputStream) {
        return (KifpoolOuterClass$ResponseGetChargePaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KifpoolOuterClass$ResponseGetChargePaymentToken parseFrom(InputStream inputStream, C2394s c2394s) {
        return (KifpoolOuterClass$ResponseGetChargePaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KifpoolOuterClass$ResponseGetChargePaymentToken parseFrom(AbstractC2384h abstractC2384h) {
        return (KifpoolOuterClass$ResponseGetChargePaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static KifpoolOuterClass$ResponseGetChargePaymentToken parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (KifpoolOuterClass$ResponseGetChargePaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
