package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC17814nc2;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class ExchangeOuterClass$ResponseGetTravelCurrencyOrderDetail extends GeneratedMessageLite implements U64 {
    private static final ExchangeOuterClass$ResponseGetTravelCurrencyOrderDetail DEFAULT_INSTANCE;
    public static final int ORDERS_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private B.j orders_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(ExchangeOuterClass$ResponseGetTravelCurrencyOrderDetail.DEFAULT_INSTANCE);
        }
    }

    static {
        ExchangeOuterClass$ResponseGetTravelCurrencyOrderDetail exchangeOuterClass$ResponseGetTravelCurrencyOrderDetail = new ExchangeOuterClass$ResponseGetTravelCurrencyOrderDetail();
        DEFAULT_INSTANCE = exchangeOuterClass$ResponseGetTravelCurrencyOrderDetail;
        GeneratedMessageLite.registerDefaultInstance(ExchangeOuterClass$ResponseGetTravelCurrencyOrderDetail.class, exchangeOuterClass$ResponseGetTravelCurrencyOrderDetail);
    }

    private ExchangeOuterClass$ResponseGetTravelCurrencyOrderDetail() {
    }

    private void addAllOrders(Iterable<? extends ExchangeOuterClass$OrdersDetail> iterable) {
        ensureOrdersIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.orders_);
    }

    private void addOrders(ExchangeOuterClass$OrdersDetail exchangeOuterClass$OrdersDetail) {
        exchangeOuterClass$OrdersDetail.getClass();
        ensureOrdersIsMutable();
        this.orders_.add(exchangeOuterClass$OrdersDetail);
    }

    private void clearOrders() {
        this.orders_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureOrdersIsMutable() {
        B.j jVar = this.orders_;
        if (jVar.u()) {
            return;
        }
        this.orders_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static ExchangeOuterClass$ResponseGetTravelCurrencyOrderDetail getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static ExchangeOuterClass$ResponseGetTravelCurrencyOrderDetail parseDelimitedFrom(InputStream inputStream) {
        return (ExchangeOuterClass$ResponseGetTravelCurrencyOrderDetail) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ExchangeOuterClass$ResponseGetTravelCurrencyOrderDetail parseFrom(ByteBuffer byteBuffer) {
        return (ExchangeOuterClass$ResponseGetTravelCurrencyOrderDetail) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeOrders(int i) {
        ensureOrdersIsMutable();
        this.orders_.remove(i);
    }

    private void setOrders(int i, ExchangeOuterClass$OrdersDetail exchangeOuterClass$OrdersDetail) {
        exchangeOuterClass$OrdersDetail.getClass();
        ensureOrdersIsMutable();
        this.orders_.set(i, exchangeOuterClass$OrdersDetail);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (U.a[gVar.ordinal()]) {
            case 1:
                return new ExchangeOuterClass$ResponseGetTravelCurrencyOrderDetail();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"orders_", ExchangeOuterClass$OrdersDetail.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (ExchangeOuterClass$ResponseGetTravelCurrencyOrderDetail.class) {
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

    public ExchangeOuterClass$OrdersDetail getOrders(int i) {
        return (ExchangeOuterClass$OrdersDetail) this.orders_.get(i);
    }

    public int getOrdersCount() {
        return this.orders_.size();
    }

    public List<ExchangeOuterClass$OrdersDetail> getOrdersList() {
        return this.orders_;
    }

    public InterfaceC17814nc2 getOrdersOrBuilder(int i) {
        return (InterfaceC17814nc2) this.orders_.get(i);
    }

    public List<? extends InterfaceC17814nc2> getOrdersOrBuilderList() {
        return this.orders_;
    }

    public static a newBuilder(ExchangeOuterClass$ResponseGetTravelCurrencyOrderDetail exchangeOuterClass$ResponseGetTravelCurrencyOrderDetail) {
        return (a) DEFAULT_INSTANCE.createBuilder(exchangeOuterClass$ResponseGetTravelCurrencyOrderDetail);
    }

    public static ExchangeOuterClass$ResponseGetTravelCurrencyOrderDetail parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (ExchangeOuterClass$ResponseGetTravelCurrencyOrderDetail) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static ExchangeOuterClass$ResponseGetTravelCurrencyOrderDetail parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (ExchangeOuterClass$ResponseGetTravelCurrencyOrderDetail) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static ExchangeOuterClass$ResponseGetTravelCurrencyOrderDetail parseFrom(AbstractC2383g abstractC2383g) {
        return (ExchangeOuterClass$ResponseGetTravelCurrencyOrderDetail) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addOrders(int i, ExchangeOuterClass$OrdersDetail exchangeOuterClass$OrdersDetail) {
        exchangeOuterClass$OrdersDetail.getClass();
        ensureOrdersIsMutable();
        this.orders_.add(i, exchangeOuterClass$OrdersDetail);
    }

    public static ExchangeOuterClass$ResponseGetTravelCurrencyOrderDetail parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (ExchangeOuterClass$ResponseGetTravelCurrencyOrderDetail) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static ExchangeOuterClass$ResponseGetTravelCurrencyOrderDetail parseFrom(byte[] bArr) {
        return (ExchangeOuterClass$ResponseGetTravelCurrencyOrderDetail) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static ExchangeOuterClass$ResponseGetTravelCurrencyOrderDetail parseFrom(byte[] bArr, C2394s c2394s) {
        return (ExchangeOuterClass$ResponseGetTravelCurrencyOrderDetail) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static ExchangeOuterClass$ResponseGetTravelCurrencyOrderDetail parseFrom(InputStream inputStream) {
        return (ExchangeOuterClass$ResponseGetTravelCurrencyOrderDetail) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ExchangeOuterClass$ResponseGetTravelCurrencyOrderDetail parseFrom(InputStream inputStream, C2394s c2394s) {
        return (ExchangeOuterClass$ResponseGetTravelCurrencyOrderDetail) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static ExchangeOuterClass$ResponseGetTravelCurrencyOrderDetail parseFrom(AbstractC2384h abstractC2384h) {
        return (ExchangeOuterClass$ResponseGetTravelCurrencyOrderDetail) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static ExchangeOuterClass$ResponseGetTravelCurrencyOrderDetail parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (ExchangeOuterClass$ResponseGetTravelCurrencyOrderDetail) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
