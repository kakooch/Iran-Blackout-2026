package ai.bale.proto;

import ai.bale.proto.CollectionsStruct$Int32Value;
import ai.bale.proto.CollectionsStruct$StringValue;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC18972pZ7;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes.dex */
public final class VitrineOuterClass$BannerSection extends GeneratedMessageLite implements U64 {
    public static final int CATEGORY_NAME_FIELD_NUMBER = 4;
    private static final VitrineOuterClass$BannerSection DEFAULT_INSTANCE;
    public static final int ID_FIELD_NUMBER = 2;
    public static final int ITEMS_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int TITLE_FIELD_NUMBER = 3;
    private int bitField0_;
    private CollectionsStruct$Int32Value id_;
    private CollectionsStruct$StringValue title_;
    private B.j items_ = GeneratedMessageLite.emptyProtobufList();
    private String categoryName_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(VitrineOuterClass$BannerSection.DEFAULT_INSTANCE);
        }
    }

    static {
        VitrineOuterClass$BannerSection vitrineOuterClass$BannerSection = new VitrineOuterClass$BannerSection();
        DEFAULT_INSTANCE = vitrineOuterClass$BannerSection;
        GeneratedMessageLite.registerDefaultInstance(VitrineOuterClass$BannerSection.class, vitrineOuterClass$BannerSection);
    }

    private VitrineOuterClass$BannerSection() {
    }

    private void addAllItems(Iterable<? extends VitrineOuterClass$BannerItem> iterable) {
        ensureItemsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.items_);
    }

    private void addItems(VitrineOuterClass$BannerItem vitrineOuterClass$BannerItem) {
        vitrineOuterClass$BannerItem.getClass();
        ensureItemsIsMutable();
        this.items_.add(vitrineOuterClass$BannerItem);
    }

    private void clearCategoryName() {
        this.categoryName_ = getDefaultInstance().getCategoryName();
    }

    private void clearId() {
        this.id_ = null;
        this.bitField0_ &= -2;
    }

    private void clearItems() {
        this.items_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearTitle() {
        this.title_ = null;
        this.bitField0_ &= -3;
    }

    private void ensureItemsIsMutable() {
        B.j jVar = this.items_;
        if (jVar.u()) {
            return;
        }
        this.items_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static VitrineOuterClass$BannerSection getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeId(CollectionsStruct$Int32Value collectionsStruct$Int32Value) {
        collectionsStruct$Int32Value.getClass();
        CollectionsStruct$Int32Value collectionsStruct$Int32Value2 = this.id_;
        if (collectionsStruct$Int32Value2 == null || collectionsStruct$Int32Value2 == CollectionsStruct$Int32Value.getDefaultInstance()) {
            this.id_ = collectionsStruct$Int32Value;
        } else {
            this.id_ = (CollectionsStruct$Int32Value) ((CollectionsStruct$Int32Value.a) CollectionsStruct$Int32Value.newBuilder(this.id_).v(collectionsStruct$Int32Value)).j();
        }
        this.bitField0_ |= 1;
    }

    private void mergeTitle(CollectionsStruct$StringValue collectionsStruct$StringValue) {
        collectionsStruct$StringValue.getClass();
        CollectionsStruct$StringValue collectionsStruct$StringValue2 = this.title_;
        if (collectionsStruct$StringValue2 == null || collectionsStruct$StringValue2 == CollectionsStruct$StringValue.getDefaultInstance()) {
            this.title_ = collectionsStruct$StringValue;
        } else {
            this.title_ = (CollectionsStruct$StringValue) ((CollectionsStruct$StringValue.a) CollectionsStruct$StringValue.newBuilder(this.title_).v(collectionsStruct$StringValue)).j();
        }
        this.bitField0_ |= 2;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static VitrineOuterClass$BannerSection parseDelimitedFrom(InputStream inputStream) {
        return (VitrineOuterClass$BannerSection) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static VitrineOuterClass$BannerSection parseFrom(ByteBuffer byteBuffer) {
        return (VitrineOuterClass$BannerSection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeItems(int i) {
        ensureItemsIsMutable();
        this.items_.remove(i);
    }

    private void setCategoryName(String str) {
        str.getClass();
        this.categoryName_ = str;
    }

    private void setCategoryNameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.categoryName_ = abstractC2383g.f0();
    }

    private void setId(CollectionsStruct$Int32Value collectionsStruct$Int32Value) {
        collectionsStruct$Int32Value.getClass();
        this.id_ = collectionsStruct$Int32Value;
        this.bitField0_ |= 1;
    }

    private void setItems(int i, VitrineOuterClass$BannerItem vitrineOuterClass$BannerItem) {
        vitrineOuterClass$BannerItem.getClass();
        ensureItemsIsMutable();
        this.items_.set(i, vitrineOuterClass$BannerItem);
    }

    private void setTitle(CollectionsStruct$StringValue collectionsStruct$StringValue) {
        collectionsStruct$StringValue.getClass();
        this.title_ = collectionsStruct$StringValue;
        this.bitField0_ |= 2;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (r2.a[gVar.ordinal()]) {
            case 1:
                return new VitrineOuterClass$BannerSection();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001\u001b\u0002ဉ\u0000\u0003ဉ\u0001\u0004Ȉ", new Object[]{"bitField0_", "items_", VitrineOuterClass$BannerItem.class, "id_", "title_", "categoryName_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (VitrineOuterClass$BannerSection.class) {
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

    public String getCategoryName() {
        return this.categoryName_;
    }

    public AbstractC2383g getCategoryNameBytes() {
        return AbstractC2383g.N(this.categoryName_);
    }

    public CollectionsStruct$Int32Value getId() {
        CollectionsStruct$Int32Value collectionsStruct$Int32Value = this.id_;
        return collectionsStruct$Int32Value == null ? CollectionsStruct$Int32Value.getDefaultInstance() : collectionsStruct$Int32Value;
    }

    public VitrineOuterClass$BannerItem getItems(int i) {
        return (VitrineOuterClass$BannerItem) this.items_.get(i);
    }

    public int getItemsCount() {
        return this.items_.size();
    }

    public List<VitrineOuterClass$BannerItem> getItemsList() {
        return this.items_;
    }

    public InterfaceC18972pZ7 getItemsOrBuilder(int i) {
        return (InterfaceC18972pZ7) this.items_.get(i);
    }

    public List<? extends InterfaceC18972pZ7> getItemsOrBuilderList() {
        return this.items_;
    }

    public CollectionsStruct$StringValue getTitle() {
        CollectionsStruct$StringValue collectionsStruct$StringValue = this.title_;
        return collectionsStruct$StringValue == null ? CollectionsStruct$StringValue.getDefaultInstance() : collectionsStruct$StringValue;
    }

    public boolean hasId() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasTitle() {
        return (this.bitField0_ & 2) != 0;
    }

    public static a newBuilder(VitrineOuterClass$BannerSection vitrineOuterClass$BannerSection) {
        return (a) DEFAULT_INSTANCE.createBuilder(vitrineOuterClass$BannerSection);
    }

    public static VitrineOuterClass$BannerSection parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (VitrineOuterClass$BannerSection) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static VitrineOuterClass$BannerSection parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (VitrineOuterClass$BannerSection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static VitrineOuterClass$BannerSection parseFrom(AbstractC2383g abstractC2383g) {
        return (VitrineOuterClass$BannerSection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addItems(int i, VitrineOuterClass$BannerItem vitrineOuterClass$BannerItem) {
        vitrineOuterClass$BannerItem.getClass();
        ensureItemsIsMutable();
        this.items_.add(i, vitrineOuterClass$BannerItem);
    }

    public static VitrineOuterClass$BannerSection parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (VitrineOuterClass$BannerSection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static VitrineOuterClass$BannerSection parseFrom(byte[] bArr) {
        return (VitrineOuterClass$BannerSection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static VitrineOuterClass$BannerSection parseFrom(byte[] bArr, C2394s c2394s) {
        return (VitrineOuterClass$BannerSection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static VitrineOuterClass$BannerSection parseFrom(InputStream inputStream) {
        return (VitrineOuterClass$BannerSection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static VitrineOuterClass$BannerSection parseFrom(InputStream inputStream, C2394s c2394s) {
        return (VitrineOuterClass$BannerSection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static VitrineOuterClass$BannerSection parseFrom(AbstractC2384h abstractC2384h) {
        return (VitrineOuterClass$BannerSection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static VitrineOuterClass$BannerSection parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (VitrineOuterClass$BannerSection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
