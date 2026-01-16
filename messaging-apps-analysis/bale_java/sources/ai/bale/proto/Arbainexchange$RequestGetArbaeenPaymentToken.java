package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class Arbainexchange$RequestGetArbaeenPaymentToken extends GeneratedMessageLite implements U64 {
    private static final Arbainexchange$RequestGetArbaeenPaymentToken DEFAULT_INSTANCE;
    public static final int ORDER_ID_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private int orderId_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Arbainexchange$RequestGetArbaeenPaymentToken.DEFAULT_INSTANCE);
        }
    }

    static {
        Arbainexchange$RequestGetArbaeenPaymentToken arbainexchange$RequestGetArbaeenPaymentToken = new Arbainexchange$RequestGetArbaeenPaymentToken();
        DEFAULT_INSTANCE = arbainexchange$RequestGetArbaeenPaymentToken;
        GeneratedMessageLite.registerDefaultInstance(Arbainexchange$RequestGetArbaeenPaymentToken.class, arbainexchange$RequestGetArbaeenPaymentToken);
    }

    private Arbainexchange$RequestGetArbaeenPaymentToken() {
    }

    private void clearOrderId() {
        this.orderId_ = 0;
    }

    public static Arbainexchange$RequestGetArbaeenPaymentToken getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Arbainexchange$RequestGetArbaeenPaymentToken parseDelimitedFrom(InputStream inputStream) {
        return (Arbainexchange$RequestGetArbaeenPaymentToken) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Arbainexchange$RequestGetArbaeenPaymentToken parseFrom(ByteBuffer byteBuffer) {
        return (Arbainexchange$RequestGetArbaeenPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setOrderId(int i) {
        this.orderId_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1861i.a[gVar.ordinal()]) {
            case 1:
                return new Arbainexchange$RequestGetArbaeenPaymentToken();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0004", new Object[]{"orderId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Arbainexchange$RequestGetArbaeenPaymentToken.class) {
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

    public int getOrderId() {
        return this.orderId_;
    }

    public static a newBuilder(Arbainexchange$RequestGetArbaeenPaymentToken arbainexchange$RequestGetArbaeenPaymentToken) {
        return (a) DEFAULT_INSTANCE.createBuilder(arbainexchange$RequestGetArbaeenPaymentToken);
    }

    public static Arbainexchange$RequestGetArbaeenPaymentToken parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Arbainexchange$RequestGetArbaeenPaymentToken) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Arbainexchange$RequestGetArbaeenPaymentToken parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Arbainexchange$RequestGetArbaeenPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Arbainexchange$RequestGetArbaeenPaymentToken parseFrom(AbstractC2383g abstractC2383g) {
        return (Arbainexchange$RequestGetArbaeenPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static Arbainexchange$RequestGetArbaeenPaymentToken parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Arbainexchange$RequestGetArbaeenPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Arbainexchange$RequestGetArbaeenPaymentToken parseFrom(byte[] bArr) {
        return (Arbainexchange$RequestGetArbaeenPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Arbainexchange$RequestGetArbaeenPaymentToken parseFrom(byte[] bArr, C2394s c2394s) {
        return (Arbainexchange$RequestGetArbaeenPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Arbainexchange$RequestGetArbaeenPaymentToken parseFrom(InputStream inputStream) {
        return (Arbainexchange$RequestGetArbaeenPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Arbainexchange$RequestGetArbaeenPaymentToken parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Arbainexchange$RequestGetArbaeenPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Arbainexchange$RequestGetArbaeenPaymentToken parseFrom(AbstractC2384h abstractC2384h) {
        return (Arbainexchange$RequestGetArbaeenPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Arbainexchange$RequestGetArbaeenPaymentToken parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Arbainexchange$RequestGetArbaeenPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
