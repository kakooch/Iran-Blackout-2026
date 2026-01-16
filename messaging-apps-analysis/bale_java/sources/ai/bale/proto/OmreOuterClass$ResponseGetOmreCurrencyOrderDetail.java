package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.PH4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class OmreOuterClass$ResponseGetOmreCurrencyOrderDetail extends GeneratedMessageLite implements U64 {
    private static final OmreOuterClass$ResponseGetOmreCurrencyOrderDetail DEFAULT_INSTANCE;
    public static final int ORDERS_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private B.j orders_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(OmreOuterClass$ResponseGetOmreCurrencyOrderDetail.DEFAULT_INSTANCE);
        }
    }

    static {
        OmreOuterClass$ResponseGetOmreCurrencyOrderDetail omreOuterClass$ResponseGetOmreCurrencyOrderDetail = new OmreOuterClass$ResponseGetOmreCurrencyOrderDetail();
        DEFAULT_INSTANCE = omreOuterClass$ResponseGetOmreCurrencyOrderDetail;
        GeneratedMessageLite.registerDefaultInstance(OmreOuterClass$ResponseGetOmreCurrencyOrderDetail.class, omreOuterClass$ResponseGetOmreCurrencyOrderDetail);
    }

    private OmreOuterClass$ResponseGetOmreCurrencyOrderDetail() {
    }

    private void addAllOrders(Iterable<? extends OmreOuterClass$OmreOrdersDetail> iterable) {
        ensureOrdersIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.orders_);
    }

    private void addOrders(OmreOuterClass$OmreOrdersDetail omreOuterClass$OmreOrdersDetail) {
        omreOuterClass$OmreOrdersDetail.getClass();
        ensureOrdersIsMutable();
        this.orders_.add(omreOuterClass$OmreOrdersDetail);
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

    public static OmreOuterClass$ResponseGetOmreCurrencyOrderDetail getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static OmreOuterClass$ResponseGetOmreCurrencyOrderDetail parseDelimitedFrom(InputStream inputStream) {
        return (OmreOuterClass$ResponseGetOmreCurrencyOrderDetail) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static OmreOuterClass$ResponseGetOmreCurrencyOrderDetail parseFrom(ByteBuffer byteBuffer) {
        return (OmreOuterClass$ResponseGetOmreCurrencyOrderDetail) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeOrders(int i) {
        ensureOrdersIsMutable();
        this.orders_.remove(i);
    }

    private void setOrders(int i, OmreOuterClass$OmreOrdersDetail omreOuterClass$OmreOrdersDetail) {
        omreOuterClass$OmreOrdersDetail.getClass();
        ensureOrdersIsMutable();
        this.orders_.set(i, omreOuterClass$OmreOrdersDetail);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (U0.a[gVar.ordinal()]) {
            case 1:
                return new OmreOuterClass$ResponseGetOmreCurrencyOrderDetail();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"orders_", OmreOuterClass$OmreOrdersDetail.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (OmreOuterClass$ResponseGetOmreCurrencyOrderDetail.class) {
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

    public OmreOuterClass$OmreOrdersDetail getOrders(int i) {
        return (OmreOuterClass$OmreOrdersDetail) this.orders_.get(i);
    }

    public int getOrdersCount() {
        return this.orders_.size();
    }

    public List<OmreOuterClass$OmreOrdersDetail> getOrdersList() {
        return this.orders_;
    }

    public PH4 getOrdersOrBuilder(int i) {
        return (PH4) this.orders_.get(i);
    }

    public List<? extends PH4> getOrdersOrBuilderList() {
        return this.orders_;
    }

    public static a newBuilder(OmreOuterClass$ResponseGetOmreCurrencyOrderDetail omreOuterClass$ResponseGetOmreCurrencyOrderDetail) {
        return (a) DEFAULT_INSTANCE.createBuilder(omreOuterClass$ResponseGetOmreCurrencyOrderDetail);
    }

    public static OmreOuterClass$ResponseGetOmreCurrencyOrderDetail parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (OmreOuterClass$ResponseGetOmreCurrencyOrderDetail) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static OmreOuterClass$ResponseGetOmreCurrencyOrderDetail parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (OmreOuterClass$ResponseGetOmreCurrencyOrderDetail) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static OmreOuterClass$ResponseGetOmreCurrencyOrderDetail parseFrom(AbstractC2383g abstractC2383g) {
        return (OmreOuterClass$ResponseGetOmreCurrencyOrderDetail) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addOrders(int i, OmreOuterClass$OmreOrdersDetail omreOuterClass$OmreOrdersDetail) {
        omreOuterClass$OmreOrdersDetail.getClass();
        ensureOrdersIsMutable();
        this.orders_.add(i, omreOuterClass$OmreOrdersDetail);
    }

    public static OmreOuterClass$ResponseGetOmreCurrencyOrderDetail parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (OmreOuterClass$ResponseGetOmreCurrencyOrderDetail) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static OmreOuterClass$ResponseGetOmreCurrencyOrderDetail parseFrom(byte[] bArr) {
        return (OmreOuterClass$ResponseGetOmreCurrencyOrderDetail) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static OmreOuterClass$ResponseGetOmreCurrencyOrderDetail parseFrom(byte[] bArr, C2394s c2394s) {
        return (OmreOuterClass$ResponseGetOmreCurrencyOrderDetail) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static OmreOuterClass$ResponseGetOmreCurrencyOrderDetail parseFrom(InputStream inputStream) {
        return (OmreOuterClass$ResponseGetOmreCurrencyOrderDetail) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static OmreOuterClass$ResponseGetOmreCurrencyOrderDetail parseFrom(InputStream inputStream, C2394s c2394s) {
        return (OmreOuterClass$ResponseGetOmreCurrencyOrderDetail) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static OmreOuterClass$ResponseGetOmreCurrencyOrderDetail parseFrom(AbstractC2384h abstractC2384h) {
        return (OmreOuterClass$ResponseGetOmreCurrencyOrderDetail) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static OmreOuterClass$ResponseGetOmreCurrencyOrderDetail parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (OmreOuterClass$ResponseGetOmreCurrencyOrderDetail) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
