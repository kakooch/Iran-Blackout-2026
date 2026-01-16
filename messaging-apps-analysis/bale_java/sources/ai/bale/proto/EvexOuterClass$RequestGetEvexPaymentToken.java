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
public final class EvexOuterClass$RequestGetEvexPaymentToken extends GeneratedMessageLite implements U64 {
    private static final EvexOuterClass$RequestGetEvexPaymentToken DEFAULT_INSTANCE;
    public static final int ORDER_ID_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private int orderId_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(EvexOuterClass$RequestGetEvexPaymentToken.DEFAULT_INSTANCE);
        }
    }

    static {
        EvexOuterClass$RequestGetEvexPaymentToken evexOuterClass$RequestGetEvexPaymentToken = new EvexOuterClass$RequestGetEvexPaymentToken();
        DEFAULT_INSTANCE = evexOuterClass$RequestGetEvexPaymentToken;
        GeneratedMessageLite.registerDefaultInstance(EvexOuterClass$RequestGetEvexPaymentToken.class, evexOuterClass$RequestGetEvexPaymentToken);
    }

    private EvexOuterClass$RequestGetEvexPaymentToken() {
    }

    private void clearOrderId() {
        this.orderId_ = 0;
    }

    public static EvexOuterClass$RequestGetEvexPaymentToken getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static EvexOuterClass$RequestGetEvexPaymentToken parseDelimitedFrom(InputStream inputStream) {
        return (EvexOuterClass$RequestGetEvexPaymentToken) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static EvexOuterClass$RequestGetEvexPaymentToken parseFrom(ByteBuffer byteBuffer) {
        return (EvexOuterClass$RequestGetEvexPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setOrderId(int i) {
        this.orderId_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (S.a[gVar.ordinal()]) {
            case 1:
                return new EvexOuterClass$RequestGetEvexPaymentToken();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0004", new Object[]{"orderId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (EvexOuterClass$RequestGetEvexPaymentToken.class) {
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

    public static a newBuilder(EvexOuterClass$RequestGetEvexPaymentToken evexOuterClass$RequestGetEvexPaymentToken) {
        return (a) DEFAULT_INSTANCE.createBuilder(evexOuterClass$RequestGetEvexPaymentToken);
    }

    public static EvexOuterClass$RequestGetEvexPaymentToken parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (EvexOuterClass$RequestGetEvexPaymentToken) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static EvexOuterClass$RequestGetEvexPaymentToken parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (EvexOuterClass$RequestGetEvexPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static EvexOuterClass$RequestGetEvexPaymentToken parseFrom(AbstractC2383g abstractC2383g) {
        return (EvexOuterClass$RequestGetEvexPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static EvexOuterClass$RequestGetEvexPaymentToken parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (EvexOuterClass$RequestGetEvexPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static EvexOuterClass$RequestGetEvexPaymentToken parseFrom(byte[] bArr) {
        return (EvexOuterClass$RequestGetEvexPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static EvexOuterClass$RequestGetEvexPaymentToken parseFrom(byte[] bArr, C2394s c2394s) {
        return (EvexOuterClass$RequestGetEvexPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static EvexOuterClass$RequestGetEvexPaymentToken parseFrom(InputStream inputStream) {
        return (EvexOuterClass$RequestGetEvexPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static EvexOuterClass$RequestGetEvexPaymentToken parseFrom(InputStream inputStream, C2394s c2394s) {
        return (EvexOuterClass$RequestGetEvexPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static EvexOuterClass$RequestGetEvexPaymentToken parseFrom(AbstractC2384h abstractC2384h) {
        return (EvexOuterClass$RequestGetEvexPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static EvexOuterClass$RequestGetEvexPaymentToken parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (EvexOuterClass$RequestGetEvexPaymentToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
