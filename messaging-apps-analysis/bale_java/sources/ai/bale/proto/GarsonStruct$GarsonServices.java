package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.BE2;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class GarsonStruct$GarsonServices extends GeneratedMessageLite implements U64 {
    public static final int CATEGORIES_FIELD_NUMBER = 1;
    private static final GarsonStruct$GarsonServices DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private B.j categories_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(GarsonStruct$GarsonServices.DEFAULT_INSTANCE);
        }
    }

    static {
        GarsonStruct$GarsonServices garsonStruct$GarsonServices = new GarsonStruct$GarsonServices();
        DEFAULT_INSTANCE = garsonStruct$GarsonServices;
        GeneratedMessageLite.registerDefaultInstance(GarsonStruct$GarsonServices.class, garsonStruct$GarsonServices);
    }

    private GarsonStruct$GarsonServices() {
    }

    private void addAllCategories(Iterable<? extends GarsonStruct$GarsonServicesCategory> iterable) {
        ensureCategoriesIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.categories_);
    }

    private void addCategories(GarsonStruct$GarsonServicesCategory garsonStruct$GarsonServicesCategory) {
        garsonStruct$GarsonServicesCategory.getClass();
        ensureCategoriesIsMutable();
        this.categories_.add(garsonStruct$GarsonServicesCategory);
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

    public static GarsonStruct$GarsonServices getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static GarsonStruct$GarsonServices parseDelimitedFrom(InputStream inputStream) {
        return (GarsonStruct$GarsonServices) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GarsonStruct$GarsonServices parseFrom(ByteBuffer byteBuffer) {
        return (GarsonStruct$GarsonServices) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeCategories(int i) {
        ensureCategoriesIsMutable();
        this.categories_.remove(i);
    }

    private void setCategories(int i, GarsonStruct$GarsonServicesCategory garsonStruct$GarsonServicesCategory) {
        garsonStruct$GarsonServicesCategory.getClass();
        ensureCategoriesIsMutable();
        this.categories_.set(i, garsonStruct$GarsonServicesCategory);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1850e0.a[gVar.ordinal()]) {
            case 1:
                return new GarsonStruct$GarsonServices();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"categories_", GarsonStruct$GarsonServicesCategory.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (GarsonStruct$GarsonServices.class) {
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

    public GarsonStruct$GarsonServicesCategory getCategories(int i) {
        return (GarsonStruct$GarsonServicesCategory) this.categories_.get(i);
    }

    public int getCategoriesCount() {
        return this.categories_.size();
    }

    public List<GarsonStruct$GarsonServicesCategory> getCategoriesList() {
        return this.categories_;
    }

    public BE2 getCategoriesOrBuilder(int i) {
        return (BE2) this.categories_.get(i);
    }

    public List<? extends BE2> getCategoriesOrBuilderList() {
        return this.categories_;
    }

    public static a newBuilder(GarsonStruct$GarsonServices garsonStruct$GarsonServices) {
        return (a) DEFAULT_INSTANCE.createBuilder(garsonStruct$GarsonServices);
    }

    public static GarsonStruct$GarsonServices parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (GarsonStruct$GarsonServices) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GarsonStruct$GarsonServices parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (GarsonStruct$GarsonServices) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static GarsonStruct$GarsonServices parseFrom(AbstractC2383g abstractC2383g) {
        return (GarsonStruct$GarsonServices) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addCategories(int i, GarsonStruct$GarsonServicesCategory garsonStruct$GarsonServicesCategory) {
        garsonStruct$GarsonServicesCategory.getClass();
        ensureCategoriesIsMutable();
        this.categories_.add(i, garsonStruct$GarsonServicesCategory);
    }

    public static GarsonStruct$GarsonServices parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (GarsonStruct$GarsonServices) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static GarsonStruct$GarsonServices parseFrom(byte[] bArr) {
        return (GarsonStruct$GarsonServices) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GarsonStruct$GarsonServices parseFrom(byte[] bArr, C2394s c2394s) {
        return (GarsonStruct$GarsonServices) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static GarsonStruct$GarsonServices parseFrom(InputStream inputStream) {
        return (GarsonStruct$GarsonServices) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GarsonStruct$GarsonServices parseFrom(InputStream inputStream, C2394s c2394s) {
        return (GarsonStruct$GarsonServices) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GarsonStruct$GarsonServices parseFrom(AbstractC2384h abstractC2384h) {
        return (GarsonStruct$GarsonServices) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static GarsonStruct$GarsonServices parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (GarsonStruct$GarsonServices) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
