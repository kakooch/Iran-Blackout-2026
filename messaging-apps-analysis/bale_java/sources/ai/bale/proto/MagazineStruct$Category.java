package ai.bale.proto;

import ai.bale.proto.CollectionsStruct$MultiLanguageTag;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC22509vM3;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class MagazineStruct$Category extends GeneratedMessageLite implements InterfaceC22509vM3 {
    public static final int CATEGORY_ID_FIELD_NUMBER = 1;
    private static final MagazineStruct$Category DEFAULT_INSTANCE;
    public static final int NAME_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private int categoryId_;
    private CollectionsStruct$MultiLanguageTag name_;

    public static final class a extends GeneratedMessageLite.b implements InterfaceC22509vM3 {
        @Override // ir.nasim.InterfaceC22509vM3
        public int getCategoryId() {
            return ((MagazineStruct$Category) this.b).getCategoryId();
        }

        @Override // ir.nasim.InterfaceC22509vM3
        public CollectionsStruct$MultiLanguageTag getName() {
            return ((MagazineStruct$Category) this.b).getName();
        }

        private a() {
            super(MagazineStruct$Category.DEFAULT_INSTANCE);
        }
    }

    static {
        MagazineStruct$Category magazineStruct$Category = new MagazineStruct$Category();
        DEFAULT_INSTANCE = magazineStruct$Category;
        GeneratedMessageLite.registerDefaultInstance(MagazineStruct$Category.class, magazineStruct$Category);
    }

    private MagazineStruct$Category() {
    }

    private void clearCategoryId() {
        this.categoryId_ = 0;
    }

    private void clearName() {
        this.name_ = null;
        this.bitField0_ &= -2;
    }

    public static MagazineStruct$Category getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeName(CollectionsStruct$MultiLanguageTag collectionsStruct$MultiLanguageTag) {
        collectionsStruct$MultiLanguageTag.getClass();
        CollectionsStruct$MultiLanguageTag collectionsStruct$MultiLanguageTag2 = this.name_;
        if (collectionsStruct$MultiLanguageTag2 == null || collectionsStruct$MultiLanguageTag2 == CollectionsStruct$MultiLanguageTag.getDefaultInstance()) {
            this.name_ = collectionsStruct$MultiLanguageTag;
        } else {
            this.name_ = (CollectionsStruct$MultiLanguageTag) ((CollectionsStruct$MultiLanguageTag.a) CollectionsStruct$MultiLanguageTag.newBuilder(this.name_).v(collectionsStruct$MultiLanguageTag)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MagazineStruct$Category parseDelimitedFrom(InputStream inputStream) {
        return (MagazineStruct$Category) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MagazineStruct$Category parseFrom(ByteBuffer byteBuffer) {
        return (MagazineStruct$Category) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setCategoryId(int i) {
        this.categoryId_ = i;
    }

    private void setName(CollectionsStruct$MultiLanguageTag collectionsStruct$MultiLanguageTag) {
        collectionsStruct$MultiLanguageTag.getClass();
        this.name_ = collectionsStruct$MultiLanguageTag;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (B0.a[gVar.ordinal()]) {
            case 1:
                return new MagazineStruct$Category();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0004\u0002ဉ\u0000", new Object[]{"bitField0_", "categoryId_", "name_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MagazineStruct$Category.class) {
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

    @Override // ir.nasim.InterfaceC22509vM3
    public int getCategoryId() {
        return this.categoryId_;
    }

    @Override // ir.nasim.InterfaceC22509vM3
    public CollectionsStruct$MultiLanguageTag getName() {
        CollectionsStruct$MultiLanguageTag collectionsStruct$MultiLanguageTag = this.name_;
        return collectionsStruct$MultiLanguageTag == null ? CollectionsStruct$MultiLanguageTag.getDefaultInstance() : collectionsStruct$MultiLanguageTag;
    }

    public boolean hasName() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(MagazineStruct$Category magazineStruct$Category) {
        return (a) DEFAULT_INSTANCE.createBuilder(magazineStruct$Category);
    }

    public static MagazineStruct$Category parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MagazineStruct$Category) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MagazineStruct$Category parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MagazineStruct$Category) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MagazineStruct$Category parseFrom(AbstractC2383g abstractC2383g) {
        return (MagazineStruct$Category) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MagazineStruct$Category parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MagazineStruct$Category) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MagazineStruct$Category parseFrom(byte[] bArr) {
        return (MagazineStruct$Category) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MagazineStruct$Category parseFrom(byte[] bArr, C2394s c2394s) {
        return (MagazineStruct$Category) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MagazineStruct$Category parseFrom(InputStream inputStream) {
        return (MagazineStruct$Category) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MagazineStruct$Category parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MagazineStruct$Category) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MagazineStruct$Category parseFrom(AbstractC2384h abstractC2384h) {
        return (MagazineStruct$Category) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MagazineStruct$Category parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MagazineStruct$Category) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
