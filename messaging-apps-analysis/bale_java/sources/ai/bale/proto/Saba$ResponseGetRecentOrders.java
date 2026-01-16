package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC12763f96;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes.dex */
public final class Saba$ResponseGetRecentOrders extends GeneratedMessageLite implements U64 {
    private static final Saba$ResponseGetRecentOrders DEFAULT_INSTANCE;
    public static final int ORDERS_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private B.j orders_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Saba$ResponseGetRecentOrders.DEFAULT_INSTANCE);
        }
    }

    static {
        Saba$ResponseGetRecentOrders saba$ResponseGetRecentOrders = new Saba$ResponseGetRecentOrders();
        DEFAULT_INSTANCE = saba$ResponseGetRecentOrders;
        GeneratedMessageLite.registerDefaultInstance(Saba$ResponseGetRecentOrders.class, saba$ResponseGetRecentOrders);
    }

    private Saba$ResponseGetRecentOrders() {
    }

    private void addAllOrders(Iterable<? extends SabaStruct$Order> iterable) {
        ensureOrdersIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.orders_);
    }

    private void addOrders(SabaStruct$Order sabaStruct$Order) {
        sabaStruct$Order.getClass();
        ensureOrdersIsMutable();
        this.orders_.add(sabaStruct$Order);
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

    public static Saba$ResponseGetRecentOrders getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Saba$ResponseGetRecentOrders parseDelimitedFrom(InputStream inputStream) {
        return (Saba$ResponseGetRecentOrders) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Saba$ResponseGetRecentOrders parseFrom(ByteBuffer byteBuffer) {
        return (Saba$ResponseGetRecentOrders) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeOrders(int i) {
        ensureOrdersIsMutable();
        this.orders_.remove(i);
    }

    private void setOrders(int i, SabaStruct$Order sabaStruct$Order) {
        sabaStruct$Order.getClass();
        ensureOrdersIsMutable();
        this.orders_.set(i, sabaStruct$Order);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (B1.a[gVar.ordinal()]) {
            case 1:
                return new Saba$ResponseGetRecentOrders();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"orders_", SabaStruct$Order.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Saba$ResponseGetRecentOrders.class) {
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

    public SabaStruct$Order getOrders(int i) {
        return (SabaStruct$Order) this.orders_.get(i);
    }

    public int getOrdersCount() {
        return this.orders_.size();
    }

    public List<SabaStruct$Order> getOrdersList() {
        return this.orders_;
    }

    public InterfaceC12763f96 getOrdersOrBuilder(int i) {
        return (InterfaceC12763f96) this.orders_.get(i);
    }

    public List<? extends InterfaceC12763f96> getOrdersOrBuilderList() {
        return this.orders_;
    }

    public static a newBuilder(Saba$ResponseGetRecentOrders saba$ResponseGetRecentOrders) {
        return (a) DEFAULT_INSTANCE.createBuilder(saba$ResponseGetRecentOrders);
    }

    public static Saba$ResponseGetRecentOrders parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Saba$ResponseGetRecentOrders) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Saba$ResponseGetRecentOrders parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Saba$ResponseGetRecentOrders) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Saba$ResponseGetRecentOrders parseFrom(AbstractC2383g abstractC2383g) {
        return (Saba$ResponseGetRecentOrders) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addOrders(int i, SabaStruct$Order sabaStruct$Order) {
        sabaStruct$Order.getClass();
        ensureOrdersIsMutable();
        this.orders_.add(i, sabaStruct$Order);
    }

    public static Saba$ResponseGetRecentOrders parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Saba$ResponseGetRecentOrders) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Saba$ResponseGetRecentOrders parseFrom(byte[] bArr) {
        return (Saba$ResponseGetRecentOrders) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Saba$ResponseGetRecentOrders parseFrom(byte[] bArr, C2394s c2394s) {
        return (Saba$ResponseGetRecentOrders) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Saba$ResponseGetRecentOrders parseFrom(InputStream inputStream) {
        return (Saba$ResponseGetRecentOrders) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Saba$ResponseGetRecentOrders parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Saba$ResponseGetRecentOrders) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Saba$ResponseGetRecentOrders parseFrom(AbstractC2384h abstractC2384h) {
        return (Saba$ResponseGetRecentOrders) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Saba$ResponseGetRecentOrders parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Saba$ResponseGetRecentOrders) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
