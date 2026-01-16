package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC9742aU3;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class MarketOuterClass$ResponseGetIndexedProducts extends GeneratedMessageLite implements U64 {
    private static final MarketOuterClass$ResponseGetIndexedProducts DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int PRODUCTS_FIELD_NUMBER = 1;
    private B.j products_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MarketOuterClass$ResponseGetIndexedProducts.DEFAULT_INSTANCE);
        }
    }

    static {
        MarketOuterClass$ResponseGetIndexedProducts marketOuterClass$ResponseGetIndexedProducts = new MarketOuterClass$ResponseGetIndexedProducts();
        DEFAULT_INSTANCE = marketOuterClass$ResponseGetIndexedProducts;
        GeneratedMessageLite.registerDefaultInstance(MarketOuterClass$ResponseGetIndexedProducts.class, marketOuterClass$ResponseGetIndexedProducts);
    }

    private MarketOuterClass$ResponseGetIndexedProducts() {
    }

    private void addAllProducts(Iterable<? extends MarketStruct$Product> iterable) {
        ensureProductsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.products_);
    }

    private void addProducts(MarketStruct$Product marketStruct$Product) {
        marketStruct$Product.getClass();
        ensureProductsIsMutable();
        this.products_.add(marketStruct$Product);
    }

    private void clearProducts() {
        this.products_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureProductsIsMutable() {
        B.j jVar = this.products_;
        if (jVar.u()) {
            return;
        }
        this.products_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static MarketOuterClass$ResponseGetIndexedProducts getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MarketOuterClass$ResponseGetIndexedProducts parseDelimitedFrom(InputStream inputStream) {
        return (MarketOuterClass$ResponseGetIndexedProducts) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MarketOuterClass$ResponseGetIndexedProducts parseFrom(ByteBuffer byteBuffer) {
        return (MarketOuterClass$ResponseGetIndexedProducts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeProducts(int i) {
        ensureProductsIsMutable();
        this.products_.remove(i);
    }

    private void setProducts(int i, MarketStruct$Product marketStruct$Product) {
        marketStruct$Product.getClass();
        ensureProductsIsMutable();
        this.products_.set(i, marketStruct$Product);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (C0.a[gVar.ordinal()]) {
            case 1:
                return new MarketOuterClass$ResponseGetIndexedProducts();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"products_", MarketStruct$Product.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MarketOuterClass$ResponseGetIndexedProducts.class) {
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

    public MarketStruct$Product getProducts(int i) {
        return (MarketStruct$Product) this.products_.get(i);
    }

    public int getProductsCount() {
        return this.products_.size();
    }

    public List<MarketStruct$Product> getProductsList() {
        return this.products_;
    }

    public InterfaceC9742aU3 getProductsOrBuilder(int i) {
        return (InterfaceC9742aU3) this.products_.get(i);
    }

    public List<? extends InterfaceC9742aU3> getProductsOrBuilderList() {
        return this.products_;
    }

    public static a newBuilder(MarketOuterClass$ResponseGetIndexedProducts marketOuterClass$ResponseGetIndexedProducts) {
        return (a) DEFAULT_INSTANCE.createBuilder(marketOuterClass$ResponseGetIndexedProducts);
    }

    public static MarketOuterClass$ResponseGetIndexedProducts parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MarketOuterClass$ResponseGetIndexedProducts) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MarketOuterClass$ResponseGetIndexedProducts parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MarketOuterClass$ResponseGetIndexedProducts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MarketOuterClass$ResponseGetIndexedProducts parseFrom(AbstractC2383g abstractC2383g) {
        return (MarketOuterClass$ResponseGetIndexedProducts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addProducts(int i, MarketStruct$Product marketStruct$Product) {
        marketStruct$Product.getClass();
        ensureProductsIsMutable();
        this.products_.add(i, marketStruct$Product);
    }

    public static MarketOuterClass$ResponseGetIndexedProducts parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MarketOuterClass$ResponseGetIndexedProducts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MarketOuterClass$ResponseGetIndexedProducts parseFrom(byte[] bArr) {
        return (MarketOuterClass$ResponseGetIndexedProducts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MarketOuterClass$ResponseGetIndexedProducts parseFrom(byte[] bArr, C2394s c2394s) {
        return (MarketOuterClass$ResponseGetIndexedProducts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MarketOuterClass$ResponseGetIndexedProducts parseFrom(InputStream inputStream) {
        return (MarketOuterClass$ResponseGetIndexedProducts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MarketOuterClass$ResponseGetIndexedProducts parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MarketOuterClass$ResponseGetIndexedProducts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MarketOuterClass$ResponseGetIndexedProducts parseFrom(AbstractC2384h abstractC2384h) {
        return (MarketOuterClass$ResponseGetIndexedProducts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MarketOuterClass$ResponseGetIndexedProducts parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MarketOuterClass$ResponseGetIndexedProducts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
