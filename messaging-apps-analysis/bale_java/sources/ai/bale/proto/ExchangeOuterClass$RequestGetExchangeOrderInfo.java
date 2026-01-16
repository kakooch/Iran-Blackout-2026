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
public final class ExchangeOuterClass$RequestGetExchangeOrderInfo extends GeneratedMessageLite implements U64 {
    private static final ExchangeOuterClass$RequestGetExchangeOrderInfo DEFAULT_INSTANCE;
    public static final int ORDER_ID_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private int orderId_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(ExchangeOuterClass$RequestGetExchangeOrderInfo.DEFAULT_INSTANCE);
        }
    }

    static {
        ExchangeOuterClass$RequestGetExchangeOrderInfo exchangeOuterClass$RequestGetExchangeOrderInfo = new ExchangeOuterClass$RequestGetExchangeOrderInfo();
        DEFAULT_INSTANCE = exchangeOuterClass$RequestGetExchangeOrderInfo;
        GeneratedMessageLite.registerDefaultInstance(ExchangeOuterClass$RequestGetExchangeOrderInfo.class, exchangeOuterClass$RequestGetExchangeOrderInfo);
    }

    private ExchangeOuterClass$RequestGetExchangeOrderInfo() {
    }

    private void clearOrderId() {
        this.orderId_ = 0;
    }

    public static ExchangeOuterClass$RequestGetExchangeOrderInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static ExchangeOuterClass$RequestGetExchangeOrderInfo parseDelimitedFrom(InputStream inputStream) {
        return (ExchangeOuterClass$RequestGetExchangeOrderInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ExchangeOuterClass$RequestGetExchangeOrderInfo parseFrom(ByteBuffer byteBuffer) {
        return (ExchangeOuterClass$RequestGetExchangeOrderInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setOrderId(int i) {
        this.orderId_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (U.a[gVar.ordinal()]) {
            case 1:
                return new ExchangeOuterClass$RequestGetExchangeOrderInfo();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0004", new Object[]{"orderId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (ExchangeOuterClass$RequestGetExchangeOrderInfo.class) {
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

    public static a newBuilder(ExchangeOuterClass$RequestGetExchangeOrderInfo exchangeOuterClass$RequestGetExchangeOrderInfo) {
        return (a) DEFAULT_INSTANCE.createBuilder(exchangeOuterClass$RequestGetExchangeOrderInfo);
    }

    public static ExchangeOuterClass$RequestGetExchangeOrderInfo parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (ExchangeOuterClass$RequestGetExchangeOrderInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static ExchangeOuterClass$RequestGetExchangeOrderInfo parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (ExchangeOuterClass$RequestGetExchangeOrderInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static ExchangeOuterClass$RequestGetExchangeOrderInfo parseFrom(AbstractC2383g abstractC2383g) {
        return (ExchangeOuterClass$RequestGetExchangeOrderInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static ExchangeOuterClass$RequestGetExchangeOrderInfo parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (ExchangeOuterClass$RequestGetExchangeOrderInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static ExchangeOuterClass$RequestGetExchangeOrderInfo parseFrom(byte[] bArr) {
        return (ExchangeOuterClass$RequestGetExchangeOrderInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static ExchangeOuterClass$RequestGetExchangeOrderInfo parseFrom(byte[] bArr, C2394s c2394s) {
        return (ExchangeOuterClass$RequestGetExchangeOrderInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static ExchangeOuterClass$RequestGetExchangeOrderInfo parseFrom(InputStream inputStream) {
        return (ExchangeOuterClass$RequestGetExchangeOrderInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ExchangeOuterClass$RequestGetExchangeOrderInfo parseFrom(InputStream inputStream, C2394s c2394s) {
        return (ExchangeOuterClass$RequestGetExchangeOrderInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static ExchangeOuterClass$RequestGetExchangeOrderInfo parseFrom(AbstractC2384h abstractC2384h) {
        return (ExchangeOuterClass$RequestGetExchangeOrderInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static ExchangeOuterClass$RequestGetExchangeOrderInfo parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (ExchangeOuterClass$RequestGetExchangeOrderInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
