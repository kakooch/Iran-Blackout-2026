package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC7060Qc2;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class ExchangeOuterClass$ResponseGetExchangeOrderInfo extends GeneratedMessageLite implements U64 {
    private static final ExchangeOuterClass$ResponseGetExchangeOrderInfo DEFAULT_INSTANCE;
    public static final int ORDER_STATUS_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private int orderStatus_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(ExchangeOuterClass$ResponseGetExchangeOrderInfo.DEFAULT_INSTANCE);
        }
    }

    static {
        ExchangeOuterClass$ResponseGetExchangeOrderInfo exchangeOuterClass$ResponseGetExchangeOrderInfo = new ExchangeOuterClass$ResponseGetExchangeOrderInfo();
        DEFAULT_INSTANCE = exchangeOuterClass$ResponseGetExchangeOrderInfo;
        GeneratedMessageLite.registerDefaultInstance(ExchangeOuterClass$ResponseGetExchangeOrderInfo.class, exchangeOuterClass$ResponseGetExchangeOrderInfo);
    }

    private ExchangeOuterClass$ResponseGetExchangeOrderInfo() {
    }

    private void clearOrderStatus() {
        this.orderStatus_ = 0;
    }

    public static ExchangeOuterClass$ResponseGetExchangeOrderInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static ExchangeOuterClass$ResponseGetExchangeOrderInfo parseDelimitedFrom(InputStream inputStream) {
        return (ExchangeOuterClass$ResponseGetExchangeOrderInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ExchangeOuterClass$ResponseGetExchangeOrderInfo parseFrom(ByteBuffer byteBuffer) {
        return (ExchangeOuterClass$ResponseGetExchangeOrderInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setOrderStatus(EnumC7060Qc2 enumC7060Qc2) {
        this.orderStatus_ = enumC7060Qc2.getNumber();
    }

    private void setOrderStatusValue(int i) {
        this.orderStatus_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (U.a[gVar.ordinal()]) {
            case 1:
                return new ExchangeOuterClass$ResponseGetExchangeOrderInfo();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\f", new Object[]{"orderStatus_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (ExchangeOuterClass$ResponseGetExchangeOrderInfo.class) {
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

    public EnumC7060Qc2 getOrderStatus() {
        EnumC7060Qc2 enumC7060Qc2J = EnumC7060Qc2.j(this.orderStatus_);
        return enumC7060Qc2J == null ? EnumC7060Qc2.UNRECOGNIZED : enumC7060Qc2J;
    }

    public int getOrderStatusValue() {
        return this.orderStatus_;
    }

    public static a newBuilder(ExchangeOuterClass$ResponseGetExchangeOrderInfo exchangeOuterClass$ResponseGetExchangeOrderInfo) {
        return (a) DEFAULT_INSTANCE.createBuilder(exchangeOuterClass$ResponseGetExchangeOrderInfo);
    }

    public static ExchangeOuterClass$ResponseGetExchangeOrderInfo parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (ExchangeOuterClass$ResponseGetExchangeOrderInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static ExchangeOuterClass$ResponseGetExchangeOrderInfo parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (ExchangeOuterClass$ResponseGetExchangeOrderInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static ExchangeOuterClass$ResponseGetExchangeOrderInfo parseFrom(AbstractC2383g abstractC2383g) {
        return (ExchangeOuterClass$ResponseGetExchangeOrderInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static ExchangeOuterClass$ResponseGetExchangeOrderInfo parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (ExchangeOuterClass$ResponseGetExchangeOrderInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static ExchangeOuterClass$ResponseGetExchangeOrderInfo parseFrom(byte[] bArr) {
        return (ExchangeOuterClass$ResponseGetExchangeOrderInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static ExchangeOuterClass$ResponseGetExchangeOrderInfo parseFrom(byte[] bArr, C2394s c2394s) {
        return (ExchangeOuterClass$ResponseGetExchangeOrderInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static ExchangeOuterClass$ResponseGetExchangeOrderInfo parseFrom(InputStream inputStream) {
        return (ExchangeOuterClass$ResponseGetExchangeOrderInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ExchangeOuterClass$ResponseGetExchangeOrderInfo parseFrom(InputStream inputStream, C2394s c2394s) {
        return (ExchangeOuterClass$ResponseGetExchangeOrderInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static ExchangeOuterClass$ResponseGetExchangeOrderInfo parseFrom(AbstractC2384h abstractC2384h) {
        return (ExchangeOuterClass$ResponseGetExchangeOrderInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static ExchangeOuterClass$ResponseGetExchangeOrderInfo parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (ExchangeOuterClass$ResponseGetExchangeOrderInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
