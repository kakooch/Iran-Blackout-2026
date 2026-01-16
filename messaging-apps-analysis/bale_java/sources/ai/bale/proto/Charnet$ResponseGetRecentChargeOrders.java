package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.PK0;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class Charnet$ResponseGetRecentChargeOrders extends GeneratedMessageLite implements U64 {
    private static final Charnet$ResponseGetRecentChargeOrders DEFAULT_INSTANCE;
    public static final int ORDERS_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private B.j orders_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Charnet$ResponseGetRecentChargeOrders.DEFAULT_INSTANCE);
        }
    }

    static {
        Charnet$ResponseGetRecentChargeOrders charnet$ResponseGetRecentChargeOrders = new Charnet$ResponseGetRecentChargeOrders();
        DEFAULT_INSTANCE = charnet$ResponseGetRecentChargeOrders;
        GeneratedMessageLite.registerDefaultInstance(Charnet$ResponseGetRecentChargeOrders.class, charnet$ResponseGetRecentChargeOrders);
    }

    private Charnet$ResponseGetRecentChargeOrders() {
    }

    private void addAllOrders(Iterable<? extends CharnetStruct$ChargeOrder> iterable) {
        ensureOrdersIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.orders_);
    }

    private void addOrders(CharnetStruct$ChargeOrder charnetStruct$ChargeOrder) {
        charnetStruct$ChargeOrder.getClass();
        ensureOrdersIsMutable();
        this.orders_.add(charnetStruct$ChargeOrder);
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

    public static Charnet$ResponseGetRecentChargeOrders getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Charnet$ResponseGetRecentChargeOrders parseDelimitedFrom(InputStream inputStream) {
        return (Charnet$ResponseGetRecentChargeOrders) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Charnet$ResponseGetRecentChargeOrders parseFrom(ByteBuffer byteBuffer) {
        return (Charnet$ResponseGetRecentChargeOrders) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeOrders(int i) {
        ensureOrdersIsMutable();
        this.orders_.remove(i);
    }

    private void setOrders(int i, CharnetStruct$ChargeOrder charnetStruct$ChargeOrder) {
        charnetStruct$ChargeOrder.getClass();
        ensureOrdersIsMutable();
        this.orders_.set(i, charnetStruct$ChargeOrder);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1911z.a[gVar.ordinal()]) {
            case 1:
                return new Charnet$ResponseGetRecentChargeOrders();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"orders_", CharnetStruct$ChargeOrder.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Charnet$ResponseGetRecentChargeOrders.class) {
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

    public CharnetStruct$ChargeOrder getOrders(int i) {
        return (CharnetStruct$ChargeOrder) this.orders_.get(i);
    }

    public int getOrdersCount() {
        return this.orders_.size();
    }

    public List<CharnetStruct$ChargeOrder> getOrdersList() {
        return this.orders_;
    }

    public PK0 getOrdersOrBuilder(int i) {
        return (PK0) this.orders_.get(i);
    }

    public List<? extends PK0> getOrdersOrBuilderList() {
        return this.orders_;
    }

    public static a newBuilder(Charnet$ResponseGetRecentChargeOrders charnet$ResponseGetRecentChargeOrders) {
        return (a) DEFAULT_INSTANCE.createBuilder(charnet$ResponseGetRecentChargeOrders);
    }

    public static Charnet$ResponseGetRecentChargeOrders parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Charnet$ResponseGetRecentChargeOrders) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Charnet$ResponseGetRecentChargeOrders parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Charnet$ResponseGetRecentChargeOrders) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Charnet$ResponseGetRecentChargeOrders parseFrom(AbstractC2383g abstractC2383g) {
        return (Charnet$ResponseGetRecentChargeOrders) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addOrders(int i, CharnetStruct$ChargeOrder charnetStruct$ChargeOrder) {
        charnetStruct$ChargeOrder.getClass();
        ensureOrdersIsMutable();
        this.orders_.add(i, charnetStruct$ChargeOrder);
    }

    public static Charnet$ResponseGetRecentChargeOrders parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Charnet$ResponseGetRecentChargeOrders) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Charnet$ResponseGetRecentChargeOrders parseFrom(byte[] bArr) {
        return (Charnet$ResponseGetRecentChargeOrders) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Charnet$ResponseGetRecentChargeOrders parseFrom(byte[] bArr, C2394s c2394s) {
        return (Charnet$ResponseGetRecentChargeOrders) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Charnet$ResponseGetRecentChargeOrders parseFrom(InputStream inputStream) {
        return (Charnet$ResponseGetRecentChargeOrders) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Charnet$ResponseGetRecentChargeOrders parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Charnet$ResponseGetRecentChargeOrders) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Charnet$ResponseGetRecentChargeOrders parseFrom(AbstractC2384h abstractC2384h) {
        return (Charnet$ResponseGetRecentChargeOrders) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Charnet$ResponseGetRecentChargeOrders parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Charnet$ResponseGetRecentChargeOrders) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
