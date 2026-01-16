package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC3280Af;
import ir.nasim.InterfaceC6107Mf;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes8.dex */
public final class AdvertisementStruct$AdCategoryStatus extends GeneratedMessageLite implements InterfaceC3280Af {
    private static final AdvertisementStruct$AdCategoryStatus DEFAULT_INSTANCE;
    public static final int ID_FIELD_NUMBER = 1;
    public static final int IS_ACTIVE_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER = null;
    public static final int SUBCATEGORIES_FIELD_NUMBER = 4;
    public static final int TITLE_FIELD_NUMBER = 2;
    private int id_;
    private boolean isActive_;
    private String title_ = "";
    private B.j subcategories_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements InterfaceC3280Af {
        private a() {
            super(AdvertisementStruct$AdCategoryStatus.DEFAULT_INSTANCE);
        }
    }

    static {
        AdvertisementStruct$AdCategoryStatus advertisementStruct$AdCategoryStatus = new AdvertisementStruct$AdCategoryStatus();
        DEFAULT_INSTANCE = advertisementStruct$AdCategoryStatus;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementStruct$AdCategoryStatus.class, advertisementStruct$AdCategoryStatus);
    }

    private AdvertisementStruct$AdCategoryStatus() {
    }

    private void addAllSubcategories(Iterable<? extends AdvertisementStruct$AdSubCategory> iterable) {
        ensureSubcategoriesIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.subcategories_);
    }

    private void addSubcategories(AdvertisementStruct$AdSubCategory advertisementStruct$AdSubCategory) {
        advertisementStruct$AdSubCategory.getClass();
        ensureSubcategoriesIsMutable();
        this.subcategories_.add(advertisementStruct$AdSubCategory);
    }

    private void clearId() {
        this.id_ = 0;
    }

    private void clearIsActive() {
        this.isActive_ = false;
    }

    private void clearSubcategories() {
        this.subcategories_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearTitle() {
        this.title_ = getDefaultInstance().getTitle();
    }

    private void ensureSubcategoriesIsMutable() {
        B.j jVar = this.subcategories_;
        if (jVar.u()) {
            return;
        }
        this.subcategories_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static AdvertisementStruct$AdCategoryStatus getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AdvertisementStruct$AdCategoryStatus parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementStruct$AdCategoryStatus) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementStruct$AdCategoryStatus parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementStruct$AdCategoryStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeSubcategories(int i) {
        ensureSubcategoriesIsMutable();
        this.subcategories_.remove(i);
    }

    private void setId(int i) {
        this.id_ = i;
    }

    private void setIsActive(boolean z) {
        this.isActive_ = z;
    }

    private void setSubcategories(int i, AdvertisementStruct$AdSubCategory advertisementStruct$AdSubCategory) {
        advertisementStruct$AdSubCategory.getClass();
        ensureSubcategoriesIsMutable();
        this.subcategories_.set(i, advertisementStruct$AdSubCategory);
    }

    private void setTitle(String str) {
        str.getClass();
        this.title_ = str;
    }

    private void setTitleBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.title_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1843c.a[gVar.ordinal()]) {
            case 1:
                return new AdvertisementStruct$AdCategoryStatus();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0001\u0000\u0001\u0004\u0002Ȉ\u0003\u0007\u0004\u001b", new Object[]{"id_", "title_", "isActive_", "subcategories_", AdvertisementStruct$AdSubCategory.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementStruct$AdCategoryStatus.class) {
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

    public int getId() {
        return this.id_;
    }

    public boolean getIsActive() {
        return this.isActive_;
    }

    public AdvertisementStruct$AdSubCategory getSubcategories(int i) {
        return (AdvertisementStruct$AdSubCategory) this.subcategories_.get(i);
    }

    public int getSubcategoriesCount() {
        return this.subcategories_.size();
    }

    public List<AdvertisementStruct$AdSubCategory> getSubcategoriesList() {
        return this.subcategories_;
    }

    public InterfaceC6107Mf getSubcategoriesOrBuilder(int i) {
        return (InterfaceC6107Mf) this.subcategories_.get(i);
    }

    public List<? extends InterfaceC6107Mf> getSubcategoriesOrBuilderList() {
        return this.subcategories_;
    }

    public String getTitle() {
        return this.title_;
    }

    public AbstractC2383g getTitleBytes() {
        return AbstractC2383g.N(this.title_);
    }

    public static a newBuilder(AdvertisementStruct$AdCategoryStatus advertisementStruct$AdCategoryStatus) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementStruct$AdCategoryStatus);
    }

    public static AdvertisementStruct$AdCategoryStatus parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementStruct$AdCategoryStatus) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementStruct$AdCategoryStatus parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementStruct$AdCategoryStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementStruct$AdCategoryStatus parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementStruct$AdCategoryStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addSubcategories(int i, AdvertisementStruct$AdSubCategory advertisementStruct$AdSubCategory) {
        advertisementStruct$AdSubCategory.getClass();
        ensureSubcategoriesIsMutable();
        this.subcategories_.add(i, advertisementStruct$AdSubCategory);
    }

    public static AdvertisementStruct$AdCategoryStatus parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementStruct$AdCategoryStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementStruct$AdCategoryStatus parseFrom(byte[] bArr) {
        return (AdvertisementStruct$AdCategoryStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementStruct$AdCategoryStatus parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementStruct$AdCategoryStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AdvertisementStruct$AdCategoryStatus parseFrom(InputStream inputStream) {
        return (AdvertisementStruct$AdCategoryStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementStruct$AdCategoryStatus parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementStruct$AdCategoryStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementStruct$AdCategoryStatus parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementStruct$AdCategoryStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementStruct$AdCategoryStatus parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementStruct$AdCategoryStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
