package ai.bale.proto;

import ai.bale.proto.CollectionsStruct$Int32Value;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.CT3;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class MarketOuterClass$ResponseGetCategories extends GeneratedMessageLite implements U64 {
    public static final int CATEGORIES_FIELD_NUMBER = 1;
    private static final MarketOuterClass$ResponseGetCategories DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int VERSION_FIELD_NUMBER = 2;
    private int bitField0_;
    private B.j categories_ = GeneratedMessageLite.emptyProtobufList();
    private CollectionsStruct$Int32Value version_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MarketOuterClass$ResponseGetCategories.DEFAULT_INSTANCE);
        }
    }

    static {
        MarketOuterClass$ResponseGetCategories marketOuterClass$ResponseGetCategories = new MarketOuterClass$ResponseGetCategories();
        DEFAULT_INSTANCE = marketOuterClass$ResponseGetCategories;
        GeneratedMessageLite.registerDefaultInstance(MarketOuterClass$ResponseGetCategories.class, marketOuterClass$ResponseGetCategories);
    }

    private MarketOuterClass$ResponseGetCategories() {
    }

    private void addAllCategories(Iterable<? extends MarketStruct$MarketCategory> iterable) {
        ensureCategoriesIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.categories_);
    }

    private void addCategories(MarketStruct$MarketCategory marketStruct$MarketCategory) {
        marketStruct$MarketCategory.getClass();
        ensureCategoriesIsMutable();
        this.categories_.add(marketStruct$MarketCategory);
    }

    private void clearCategories() {
        this.categories_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearVersion() {
        this.version_ = null;
        this.bitField0_ &= -2;
    }

    private void ensureCategoriesIsMutable() {
        B.j jVar = this.categories_;
        if (jVar.u()) {
            return;
        }
        this.categories_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static MarketOuterClass$ResponseGetCategories getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeVersion(CollectionsStruct$Int32Value collectionsStruct$Int32Value) {
        collectionsStruct$Int32Value.getClass();
        CollectionsStruct$Int32Value collectionsStruct$Int32Value2 = this.version_;
        if (collectionsStruct$Int32Value2 == null || collectionsStruct$Int32Value2 == CollectionsStruct$Int32Value.getDefaultInstance()) {
            this.version_ = collectionsStruct$Int32Value;
        } else {
            this.version_ = (CollectionsStruct$Int32Value) ((CollectionsStruct$Int32Value.a) CollectionsStruct$Int32Value.newBuilder(this.version_).v(collectionsStruct$Int32Value)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MarketOuterClass$ResponseGetCategories parseDelimitedFrom(InputStream inputStream) {
        return (MarketOuterClass$ResponseGetCategories) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MarketOuterClass$ResponseGetCategories parseFrom(ByteBuffer byteBuffer) {
        return (MarketOuterClass$ResponseGetCategories) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeCategories(int i) {
        ensureCategoriesIsMutable();
        this.categories_.remove(i);
    }

    private void setCategories(int i, MarketStruct$MarketCategory marketStruct$MarketCategory) {
        marketStruct$MarketCategory.getClass();
        ensureCategoriesIsMutable();
        this.categories_.set(i, marketStruct$MarketCategory);
    }

    private void setVersion(CollectionsStruct$Int32Value collectionsStruct$Int32Value) {
        collectionsStruct$Int32Value.getClass();
        this.version_ = collectionsStruct$Int32Value;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (C0.a[gVar.ordinal()]) {
            case 1:
                return new MarketOuterClass$ResponseGetCategories();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001b\u0002ဉ\u0000", new Object[]{"bitField0_", "categories_", MarketStruct$MarketCategory.class, "version_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MarketOuterClass$ResponseGetCategories.class) {
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

    public MarketStruct$MarketCategory getCategories(int i) {
        return (MarketStruct$MarketCategory) this.categories_.get(i);
    }

    public int getCategoriesCount() {
        return this.categories_.size();
    }

    public List<MarketStruct$MarketCategory> getCategoriesList() {
        return this.categories_;
    }

    public CT3 getCategoriesOrBuilder(int i) {
        return (CT3) this.categories_.get(i);
    }

    public List<? extends CT3> getCategoriesOrBuilderList() {
        return this.categories_;
    }

    public CollectionsStruct$Int32Value getVersion() {
        CollectionsStruct$Int32Value collectionsStruct$Int32Value = this.version_;
        return collectionsStruct$Int32Value == null ? CollectionsStruct$Int32Value.getDefaultInstance() : collectionsStruct$Int32Value;
    }

    public boolean hasVersion() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(MarketOuterClass$ResponseGetCategories marketOuterClass$ResponseGetCategories) {
        return (a) DEFAULT_INSTANCE.createBuilder(marketOuterClass$ResponseGetCategories);
    }

    public static MarketOuterClass$ResponseGetCategories parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MarketOuterClass$ResponseGetCategories) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MarketOuterClass$ResponseGetCategories parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MarketOuterClass$ResponseGetCategories) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MarketOuterClass$ResponseGetCategories parseFrom(AbstractC2383g abstractC2383g) {
        return (MarketOuterClass$ResponseGetCategories) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addCategories(int i, MarketStruct$MarketCategory marketStruct$MarketCategory) {
        marketStruct$MarketCategory.getClass();
        ensureCategoriesIsMutable();
        this.categories_.add(i, marketStruct$MarketCategory);
    }

    public static MarketOuterClass$ResponseGetCategories parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MarketOuterClass$ResponseGetCategories) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MarketOuterClass$ResponseGetCategories parseFrom(byte[] bArr) {
        return (MarketOuterClass$ResponseGetCategories) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MarketOuterClass$ResponseGetCategories parseFrom(byte[] bArr, C2394s c2394s) {
        return (MarketOuterClass$ResponseGetCategories) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MarketOuterClass$ResponseGetCategories parseFrom(InputStream inputStream) {
        return (MarketOuterClass$ResponseGetCategories) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MarketOuterClass$ResponseGetCategories parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MarketOuterClass$ResponseGetCategories) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MarketOuterClass$ResponseGetCategories parseFrom(AbstractC2384h abstractC2384h) {
        return (MarketOuterClass$ResponseGetCategories) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MarketOuterClass$ResponseGetCategories parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MarketOuterClass$ResponseGetCategories) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
