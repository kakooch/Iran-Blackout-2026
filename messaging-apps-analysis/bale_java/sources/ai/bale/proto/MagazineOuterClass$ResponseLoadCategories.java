package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC22509vM3;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class MagazineOuterClass$ResponseLoadCategories extends GeneratedMessageLite implements U64 {
    public static final int CATEGORIES_FIELD_NUMBER = 1;
    private static final MagazineOuterClass$ResponseLoadCategories DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private B.j categories_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MagazineOuterClass$ResponseLoadCategories.DEFAULT_INSTANCE);
        }
    }

    static {
        MagazineOuterClass$ResponseLoadCategories magazineOuterClass$ResponseLoadCategories = new MagazineOuterClass$ResponseLoadCategories();
        DEFAULT_INSTANCE = magazineOuterClass$ResponseLoadCategories;
        GeneratedMessageLite.registerDefaultInstance(MagazineOuterClass$ResponseLoadCategories.class, magazineOuterClass$ResponseLoadCategories);
    }

    private MagazineOuterClass$ResponseLoadCategories() {
    }

    private void addAllCategories(Iterable<? extends MagazineStruct$Category> iterable) {
        ensureCategoriesIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.categories_);
    }

    private void addCategories(MagazineStruct$Category magazineStruct$Category) {
        magazineStruct$Category.getClass();
        ensureCategoriesIsMutable();
        this.categories_.add(magazineStruct$Category);
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

    public static MagazineOuterClass$ResponseLoadCategories getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MagazineOuterClass$ResponseLoadCategories parseDelimitedFrom(InputStream inputStream) {
        return (MagazineOuterClass$ResponseLoadCategories) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MagazineOuterClass$ResponseLoadCategories parseFrom(ByteBuffer byteBuffer) {
        return (MagazineOuterClass$ResponseLoadCategories) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeCategories(int i) {
        ensureCategoriesIsMutable();
        this.categories_.remove(i);
    }

    private void setCategories(int i, MagazineStruct$Category magazineStruct$Category) {
        magazineStruct$Category.getClass();
        ensureCategoriesIsMutable();
        this.categories_.set(i, magazineStruct$Category);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (A0.a[gVar.ordinal()]) {
            case 1:
                return new MagazineOuterClass$ResponseLoadCategories();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"categories_", MagazineStruct$Category.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MagazineOuterClass$ResponseLoadCategories.class) {
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

    public MagazineStruct$Category getCategories(int i) {
        return (MagazineStruct$Category) this.categories_.get(i);
    }

    public int getCategoriesCount() {
        return this.categories_.size();
    }

    public List<MagazineStruct$Category> getCategoriesList() {
        return this.categories_;
    }

    public InterfaceC22509vM3 getCategoriesOrBuilder(int i) {
        return (InterfaceC22509vM3) this.categories_.get(i);
    }

    public List<? extends InterfaceC22509vM3> getCategoriesOrBuilderList() {
        return this.categories_;
    }

    public static a newBuilder(MagazineOuterClass$ResponseLoadCategories magazineOuterClass$ResponseLoadCategories) {
        return (a) DEFAULT_INSTANCE.createBuilder(magazineOuterClass$ResponseLoadCategories);
    }

    public static MagazineOuterClass$ResponseLoadCategories parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MagazineOuterClass$ResponseLoadCategories) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MagazineOuterClass$ResponseLoadCategories parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MagazineOuterClass$ResponseLoadCategories) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MagazineOuterClass$ResponseLoadCategories parseFrom(AbstractC2383g abstractC2383g) {
        return (MagazineOuterClass$ResponseLoadCategories) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addCategories(int i, MagazineStruct$Category magazineStruct$Category) {
        magazineStruct$Category.getClass();
        ensureCategoriesIsMutable();
        this.categories_.add(i, magazineStruct$Category);
    }

    public static MagazineOuterClass$ResponseLoadCategories parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MagazineOuterClass$ResponseLoadCategories) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MagazineOuterClass$ResponseLoadCategories parseFrom(byte[] bArr) {
        return (MagazineOuterClass$ResponseLoadCategories) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MagazineOuterClass$ResponseLoadCategories parseFrom(byte[] bArr, C2394s c2394s) {
        return (MagazineOuterClass$ResponseLoadCategories) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MagazineOuterClass$ResponseLoadCategories parseFrom(InputStream inputStream) {
        return (MagazineOuterClass$ResponseLoadCategories) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MagazineOuterClass$ResponseLoadCategories parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MagazineOuterClass$ResponseLoadCategories) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MagazineOuterClass$ResponseLoadCategories parseFrom(AbstractC2384h abstractC2384h) {
        return (MagazineOuterClass$ResponseLoadCategories) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MagazineOuterClass$ResponseLoadCategories parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MagazineOuterClass$ResponseLoadCategories) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
