package ai.bale.proto;

import ai.bale.proto.CollectionsStruct$Int32Value;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC22040uZ7;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes.dex */
public final class VitrineOuterClass$PeerCategorySection extends GeneratedMessageLite implements U64 {
    public static final int CATEGORY_NAME_FIELD_NUMBER = 4;
    private static final VitrineOuterClass$PeerCategorySection DEFAULT_INSTANCE;
    public static final int ID_FIELD_NUMBER = 3;
    public static final int ITEMS_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int TITLE_FIELD_NUMBER = 1;
    private int bitField0_;
    private CollectionsStruct$Int32Value id_;
    private String title_ = "";
    private B.j items_ = GeneratedMessageLite.emptyProtobufList();
    private String categoryName_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(VitrineOuterClass$PeerCategorySection.DEFAULT_INSTANCE);
        }
    }

    static {
        VitrineOuterClass$PeerCategorySection vitrineOuterClass$PeerCategorySection = new VitrineOuterClass$PeerCategorySection();
        DEFAULT_INSTANCE = vitrineOuterClass$PeerCategorySection;
        GeneratedMessageLite.registerDefaultInstance(VitrineOuterClass$PeerCategorySection.class, vitrineOuterClass$PeerCategorySection);
    }

    private VitrineOuterClass$PeerCategorySection() {
    }

    private void addAllItems(Iterable<? extends VitrineOuterClass$PeerItem> iterable) {
        ensureItemsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.items_);
    }

    private void addItems(VitrineOuterClass$PeerItem vitrineOuterClass$PeerItem) {
        vitrineOuterClass$PeerItem.getClass();
        ensureItemsIsMutable();
        this.items_.add(vitrineOuterClass$PeerItem);
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
        this.title_ = getDefaultInstance().getTitle();
    }

    private void ensureItemsIsMutable() {
        B.j jVar = this.items_;
        if (jVar.u()) {
            return;
        }
        this.items_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static VitrineOuterClass$PeerCategorySection getDefaultInstance() {
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

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static VitrineOuterClass$PeerCategorySection parseDelimitedFrom(InputStream inputStream) {
        return (VitrineOuterClass$PeerCategorySection) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static VitrineOuterClass$PeerCategorySection parseFrom(ByteBuffer byteBuffer) {
        return (VitrineOuterClass$PeerCategorySection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
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

    private void setItems(int i, VitrineOuterClass$PeerItem vitrineOuterClass$PeerItem) {
        vitrineOuterClass$PeerItem.getClass();
        ensureItemsIsMutable();
        this.items_.set(i, vitrineOuterClass$PeerItem);
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
        switch (r2.a[gVar.ordinal()]) {
            case 1:
                return new VitrineOuterClass$PeerCategorySection();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001Ȉ\u0002\u001b\u0003ဉ\u0000\u0004Ȉ", new Object[]{"bitField0_", "title_", "items_", VitrineOuterClass$PeerItem.class, "id_", "categoryName_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (VitrineOuterClass$PeerCategorySection.class) {
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

    public VitrineOuterClass$PeerItem getItems(int i) {
        return (VitrineOuterClass$PeerItem) this.items_.get(i);
    }

    public int getItemsCount() {
        return this.items_.size();
    }

    public List<VitrineOuterClass$PeerItem> getItemsList() {
        return this.items_;
    }

    public InterfaceC22040uZ7 getItemsOrBuilder(int i) {
        return (InterfaceC22040uZ7) this.items_.get(i);
    }

    public List<? extends InterfaceC22040uZ7> getItemsOrBuilderList() {
        return this.items_;
    }

    public String getTitle() {
        return this.title_;
    }

    public AbstractC2383g getTitleBytes() {
        return AbstractC2383g.N(this.title_);
    }

    public boolean hasId() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(VitrineOuterClass$PeerCategorySection vitrineOuterClass$PeerCategorySection) {
        return (a) DEFAULT_INSTANCE.createBuilder(vitrineOuterClass$PeerCategorySection);
    }

    public static VitrineOuterClass$PeerCategorySection parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (VitrineOuterClass$PeerCategorySection) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static VitrineOuterClass$PeerCategorySection parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (VitrineOuterClass$PeerCategorySection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static VitrineOuterClass$PeerCategorySection parseFrom(AbstractC2383g abstractC2383g) {
        return (VitrineOuterClass$PeerCategorySection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addItems(int i, VitrineOuterClass$PeerItem vitrineOuterClass$PeerItem) {
        vitrineOuterClass$PeerItem.getClass();
        ensureItemsIsMutable();
        this.items_.add(i, vitrineOuterClass$PeerItem);
    }

    public static VitrineOuterClass$PeerCategorySection parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (VitrineOuterClass$PeerCategorySection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static VitrineOuterClass$PeerCategorySection parseFrom(byte[] bArr) {
        return (VitrineOuterClass$PeerCategorySection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static VitrineOuterClass$PeerCategorySection parseFrom(byte[] bArr, C2394s c2394s) {
        return (VitrineOuterClass$PeerCategorySection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static VitrineOuterClass$PeerCategorySection parseFrom(InputStream inputStream) {
        return (VitrineOuterClass$PeerCategorySection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static VitrineOuterClass$PeerCategorySection parseFrom(InputStream inputStream, C2394s c2394s) {
        return (VitrineOuterClass$PeerCategorySection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static VitrineOuterClass$PeerCategorySection parseFrom(AbstractC2384h abstractC2384h) {
        return (VitrineOuterClass$PeerCategorySection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static VitrineOuterClass$PeerCategorySection parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (VitrineOuterClass$PeerCategorySection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
