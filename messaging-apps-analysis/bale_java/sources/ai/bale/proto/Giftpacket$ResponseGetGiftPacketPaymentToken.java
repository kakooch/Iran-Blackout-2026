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
public final class Giftpacket$ResponseGetGiftPacketPaymentToken extends GeneratedMessageLite implements U64 {
    private static final Giftpacket$ResponseGetGiftPacketPaymentToken DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int PAYMENT_TOKEN_FIELD_NUMBER = 1;
    private String paymentToken_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Giftpacket$ResponseGetGiftPacketPaymentToken.DEFAULT_INSTANCE);
        }
    }

    static {
        Giftpacket$ResponseGetGiftPacketPaymentToken giftpacket$ResponseGetGiftPacketPaymentToken = new Giftpacket$ResponseGetGiftPacketPaymentToken();
        DEFAULT_INSTANCE = giftpacket$ResponseGetGiftPacketPaymentToken;
        GeneratedMessageLite.registerDefaultInstance(Giftpacket$ResponseGetGiftPacketPaymentToken.class, giftpacket$ResponseGetGiftPacketPaymentToken);
    }

    private Giftpacket$ResponseGetGiftPacketPaymentToken() {
    }

    private void clearPaymentToken() {
        this.paymentToken_ = getDefaultInstance().getPaymentToken();
    }

    public static Giftpacket$ResponseGetGiftPacketPaymentToken getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Giftpacket$ResponseGetGiftPacketPaymentToken parseDelimitedFrom(InputStream inputStream) {
        return (Giftpacket$ResponseGetGiftPacketPaymentToken) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Giftpacket$ResponseGetGiftPacketPaymentToken parseFrom(ByteBuffer byteBuffer) {
        return (Giftpacket$ResponseGetGiftPacketPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
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
        switch (AbstractC1865j0.a[gVar.ordinal()]) {
            case 1:
                return new Giftpacket$ResponseGetGiftPacketPaymentToken();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"paymentToken_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Giftpacket$ResponseGetGiftPacketPaymentToken.class) {
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

    public static a newBuilder(Giftpacket$ResponseGetGiftPacketPaymentToken giftpacket$ResponseGetGiftPacketPaymentToken) {
        return (a) DEFAULT_INSTANCE.createBuilder(giftpacket$ResponseGetGiftPacketPaymentToken);
    }

    public static Giftpacket$ResponseGetGiftPacketPaymentToken parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Giftpacket$ResponseGetGiftPacketPaymentToken) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Giftpacket$ResponseGetGiftPacketPaymentToken parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Giftpacket$ResponseGetGiftPacketPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Giftpacket$ResponseGetGiftPacketPaymentToken parseFrom(AbstractC2383g abstractC2383g) {
        return (Giftpacket$ResponseGetGiftPacketPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static Giftpacket$ResponseGetGiftPacketPaymentToken parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Giftpacket$ResponseGetGiftPacketPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Giftpacket$ResponseGetGiftPacketPaymentToken parseFrom(byte[] bArr) {
        return (Giftpacket$ResponseGetGiftPacketPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Giftpacket$ResponseGetGiftPacketPaymentToken parseFrom(byte[] bArr, C2394s c2394s) {
        return (Giftpacket$ResponseGetGiftPacketPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Giftpacket$ResponseGetGiftPacketPaymentToken parseFrom(InputStream inputStream) {
        return (Giftpacket$ResponseGetGiftPacketPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Giftpacket$ResponseGetGiftPacketPaymentToken parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Giftpacket$ResponseGetGiftPacketPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Giftpacket$ResponseGetGiftPacketPaymentToken parseFrom(AbstractC2384h abstractC2384h) {
        return (Giftpacket$ResponseGetGiftPacketPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Giftpacket$ResponseGetGiftPacketPaymentToken parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Giftpacket$ResponseGetGiftPacketPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
