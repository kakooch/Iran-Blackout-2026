package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC3280Af;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes6.dex */
public final class AdvertisementOuterClass$RequestCategoryFilter extends GeneratedMessageLite implements U64 {
    public static final int CATEGORIES_FIELD_NUMBER = 1;
    private static final AdvertisementOuterClass$RequestCategoryFilter DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private B.j categories_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(AdvertisementOuterClass$RequestCategoryFilter.DEFAULT_INSTANCE);
        }
    }

    static {
        AdvertisementOuterClass$RequestCategoryFilter advertisementOuterClass$RequestCategoryFilter = new AdvertisementOuterClass$RequestCategoryFilter();
        DEFAULT_INSTANCE = advertisementOuterClass$RequestCategoryFilter;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementOuterClass$RequestCategoryFilter.class, advertisementOuterClass$RequestCategoryFilter);
    }

    private AdvertisementOuterClass$RequestCategoryFilter() {
    }

    private void addAllCategories(Iterable<? extends AdvertisementStruct$AdCategoryStatus> iterable) {
        ensureCategoriesIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.categories_);
    }

    private void addCategories(AdvertisementStruct$AdCategoryStatus advertisementStruct$AdCategoryStatus) {
        advertisementStruct$AdCategoryStatus.getClass();
        ensureCategoriesIsMutable();
        this.categories_.add(advertisementStruct$AdCategoryStatus);
    }

    private void clearCategories() {
        this.categories_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureCategoriesIsMutable() {
        B.j jVar = this.categories_;
        if (jVar.u()) {
            return;
        }
        this.categories_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static AdvertisementOuterClass$RequestCategoryFilter getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AdvertisementOuterClass$RequestCategoryFilter parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$RequestCategoryFilter) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$RequestCategoryFilter parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementOuterClass$RequestCategoryFilter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeCategories(int i) {
        ensureCategoriesIsMutable();
        this.categories_.remove(i);
    }

    private void setCategories(int i, AdvertisementStruct$AdCategoryStatus advertisementStruct$AdCategoryStatus) {
        advertisementStruct$AdCategoryStatus.getClass();
        ensureCategoriesIsMutable();
        this.categories_.set(i, advertisementStruct$AdCategoryStatus);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1840b.a[gVar.ordinal()]) {
            case 1:
                return new AdvertisementOuterClass$RequestCategoryFilter();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"categories_", AdvertisementStruct$AdCategoryStatus.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementOuterClass$RequestCategoryFilter.class) {
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

    public AdvertisementStruct$AdCategoryStatus getCategories(int i) {
        return (AdvertisementStruct$AdCategoryStatus) this.categories_.get(i);
    }

    public int getCategoriesCount() {
        return this.categories_.size();
    }

    public List<AdvertisementStruct$AdCategoryStatus> getCategoriesList() {
        return this.categories_;
    }

    public InterfaceC3280Af getCategoriesOrBuilder(int i) {
        return (InterfaceC3280Af) this.categories_.get(i);
    }

    public List<? extends InterfaceC3280Af> getCategoriesOrBuilderList() {
        return this.categories_;
    }

    public static a newBuilder(AdvertisementOuterClass$RequestCategoryFilter advertisementOuterClass$RequestCategoryFilter) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementOuterClass$RequestCategoryFilter);
    }

    public static AdvertisementOuterClass$RequestCategoryFilter parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestCategoryFilter) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$RequestCategoryFilter parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestCategoryFilter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementOuterClass$RequestCategoryFilter parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementOuterClass$RequestCategoryFilter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addCategories(int i, AdvertisementStruct$AdCategoryStatus advertisementStruct$AdCategoryStatus) {
        advertisementStruct$AdCategoryStatus.getClass();
        ensureCategoriesIsMutable();
        this.categories_.add(i, advertisementStruct$AdCategoryStatus);
    }

    public static AdvertisementOuterClass$RequestCategoryFilter parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestCategoryFilter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementOuterClass$RequestCategoryFilter parseFrom(byte[] bArr) {
        return (AdvertisementOuterClass$RequestCategoryFilter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementOuterClass$RequestCategoryFilter parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestCategoryFilter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AdvertisementOuterClass$RequestCategoryFilter parseFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$RequestCategoryFilter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$RequestCategoryFilter parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestCategoryFilter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$RequestCategoryFilter parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementOuterClass$RequestCategoryFilter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementOuterClass$RequestCategoryFilter parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestCategoryFilter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
