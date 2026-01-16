package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.BoolValue;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Int32Value;
import ir.nasim.GT3;
import ir.nasim.InterfaceC9742aU3;
import ir.nasim.KW4;
import ir.nasim.YT3;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class MarketStruct$MarketItem extends GeneratedMessageLite implements GT3 {
    public static final int CATEGORY_ID_FIELD_NUMBER = 8;
    private static final MarketStruct$MarketItem DEFAULT_INSTANCE;
    public static final int DISCOUNT_FIELD_NUMBER = 5;
    public static final int ID_FIELD_NUMBER = 1;
    public static final int IS_ACTIVE_FIELD_NUMBER = 7;
    public static final int IS_BANNED_FIELD_NUMBER = 9;
    private static volatile KW4 PARSER = null;
    public static final int POSTS_FIELD_NUMBER = 4;
    public static final int PRODUCTS_FIELD_NUMBER = 6;
    public static final int TITLE_FIELD_NUMBER = 2;
    public static final int URL_FIELD_NUMBER = 3;
    private int bitField0_;
    private Int32Value categoryId_;
    private int discount_;
    private long id_;
    private BoolValue isActive_;
    private BoolValue isBanned_;
    private String title_ = "";
    private String url_ = "";
    private B.j posts_ = GeneratedMessageLite.emptyProtobufList();
    private B.j products_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements GT3 {
        private a() {
            super(MarketStruct$MarketItem.DEFAULT_INSTANCE);
        }
    }

    static {
        MarketStruct$MarketItem marketStruct$MarketItem = new MarketStruct$MarketItem();
        DEFAULT_INSTANCE = marketStruct$MarketItem;
        GeneratedMessageLite.registerDefaultInstance(MarketStruct$MarketItem.class, marketStruct$MarketItem);
    }

    private MarketStruct$MarketItem() {
    }

    private void addAllPosts(Iterable<? extends MarketStruct$Post> iterable) {
        ensurePostsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.posts_);
    }

    private void addAllProducts(Iterable<? extends MarketStruct$Product> iterable) {
        ensureProductsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.products_);
    }

    private void addPosts(MarketStruct$Post marketStruct$Post) {
        marketStruct$Post.getClass();
        ensurePostsIsMutable();
        this.posts_.add(marketStruct$Post);
    }

    private void addProducts(MarketStruct$Product marketStruct$Product) {
        marketStruct$Product.getClass();
        ensureProductsIsMutable();
        this.products_.add(marketStruct$Product);
    }

    private void clearCategoryId() {
        this.categoryId_ = null;
        this.bitField0_ &= -3;
    }

    private void clearDiscount() {
        this.discount_ = 0;
    }

    private void clearId() {
        this.id_ = 0L;
    }

    private void clearIsActive() {
        this.isActive_ = null;
        this.bitField0_ &= -2;
    }

    private void clearIsBanned() {
        this.isBanned_ = null;
        this.bitField0_ &= -5;
    }

    private void clearPosts() {
        this.posts_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearProducts() {
        this.products_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearTitle() {
        this.title_ = getDefaultInstance().getTitle();
    }

    private void clearUrl() {
        this.url_ = getDefaultInstance().getUrl();
    }

    private void ensurePostsIsMutable() {
        B.j jVar = this.posts_;
        if (jVar.u()) {
            return;
        }
        this.posts_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    private void ensureProductsIsMutable() {
        B.j jVar = this.products_;
        if (jVar.u()) {
            return;
        }
        this.products_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static MarketStruct$MarketItem getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeCategoryId(Int32Value int32Value) {
        int32Value.getClass();
        Int32Value int32Value2 = this.categoryId_;
        if (int32Value2 == null || int32Value2 == Int32Value.getDefaultInstance()) {
            this.categoryId_ = int32Value;
        } else {
            this.categoryId_ = (Int32Value) ((Int32Value.b) Int32Value.newBuilder(this.categoryId_).v(int32Value)).j();
        }
        this.bitField0_ |= 2;
    }

    private void mergeIsActive(BoolValue boolValue) {
        boolValue.getClass();
        BoolValue boolValue2 = this.isActive_;
        if (boolValue2 == null || boolValue2 == BoolValue.getDefaultInstance()) {
            this.isActive_ = boolValue;
        } else {
            this.isActive_ = (BoolValue) ((BoolValue.b) BoolValue.newBuilder(this.isActive_).v(boolValue)).j();
        }
        this.bitField0_ |= 1;
    }

    private void mergeIsBanned(BoolValue boolValue) {
        boolValue.getClass();
        BoolValue boolValue2 = this.isBanned_;
        if (boolValue2 == null || boolValue2 == BoolValue.getDefaultInstance()) {
            this.isBanned_ = boolValue;
        } else {
            this.isBanned_ = (BoolValue) ((BoolValue.b) BoolValue.newBuilder(this.isBanned_).v(boolValue)).j();
        }
        this.bitField0_ |= 4;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MarketStruct$MarketItem parseDelimitedFrom(InputStream inputStream) {
        return (MarketStruct$MarketItem) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MarketStruct$MarketItem parseFrom(ByteBuffer byteBuffer) {
        return (MarketStruct$MarketItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removePosts(int i) {
        ensurePostsIsMutable();
        this.posts_.remove(i);
    }

    private void removeProducts(int i) {
        ensureProductsIsMutable();
        this.products_.remove(i);
    }

    private void setCategoryId(Int32Value int32Value) {
        int32Value.getClass();
        this.categoryId_ = int32Value;
        this.bitField0_ |= 2;
    }

    private void setDiscount(int i) {
        this.discount_ = i;
    }

    private void setId(long j) {
        this.id_ = j;
    }

    private void setIsActive(BoolValue boolValue) {
        boolValue.getClass();
        this.isActive_ = boolValue;
        this.bitField0_ |= 1;
    }

    private void setIsBanned(BoolValue boolValue) {
        boolValue.getClass();
        this.isBanned_ = boolValue;
        this.bitField0_ |= 4;
    }

    private void setPosts(int i, MarketStruct$Post marketStruct$Post) {
        marketStruct$Post.getClass();
        ensurePostsIsMutable();
        this.posts_.set(i, marketStruct$Post);
    }

    private void setProducts(int i, MarketStruct$Product marketStruct$Product) {
        marketStruct$Product.getClass();
        ensureProductsIsMutable();
        this.products_.set(i, marketStruct$Product);
    }

    private void setTitle(String str) {
        str.getClass();
        this.title_ = str;
    }

    private void setTitleBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.title_ = abstractC2383g.f0();
    }

    private void setUrl(String str) {
        str.getClass();
        this.url_ = str;
    }

    private void setUrlBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.url_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (D0.a[gVar.ordinal()]) {
            case 1:
                return new MarketStruct$MarketItem();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\t\u0000\u0001\u0001\t\t\u0000\u0002\u0000\u0001\u0002\u0002Ȉ\u0003Ȉ\u0004\u001b\u0005\u0004\u0006\u001b\u0007ဉ\u0000\bဉ\u0001\tဉ\u0002", new Object[]{"bitField0_", "id_", "title_", "url_", "posts_", MarketStruct$Post.class, "discount_", "products_", MarketStruct$Product.class, "isActive_", "categoryId_", "isBanned_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MarketStruct$MarketItem.class) {
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

    public Int32Value getCategoryId() {
        Int32Value int32Value = this.categoryId_;
        return int32Value == null ? Int32Value.getDefaultInstance() : int32Value;
    }

    public int getDiscount() {
        return this.discount_;
    }

    public long getId() {
        return this.id_;
    }

    public BoolValue getIsActive() {
        BoolValue boolValue = this.isActive_;
        return boolValue == null ? BoolValue.getDefaultInstance() : boolValue;
    }

    public BoolValue getIsBanned() {
        BoolValue boolValue = this.isBanned_;
        return boolValue == null ? BoolValue.getDefaultInstance() : boolValue;
    }

    public MarketStruct$Post getPosts(int i) {
        return (MarketStruct$Post) this.posts_.get(i);
    }

    public int getPostsCount() {
        return this.posts_.size();
    }

    public List<MarketStruct$Post> getPostsList() {
        return this.posts_;
    }

    public YT3 getPostsOrBuilder(int i) {
        return (YT3) this.posts_.get(i);
    }

    public List<? extends YT3> getPostsOrBuilderList() {
        return this.posts_;
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

    public String getTitle() {
        return this.title_;
    }

    public AbstractC2383g getTitleBytes() {
        return AbstractC2383g.N(this.title_);
    }

    public String getUrl() {
        return this.url_;
    }

    public AbstractC2383g getUrlBytes() {
        return AbstractC2383g.N(this.url_);
    }

    public boolean hasCategoryId() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasIsActive() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasIsBanned() {
        return (this.bitField0_ & 4) != 0;
    }

    public static a newBuilder(MarketStruct$MarketItem marketStruct$MarketItem) {
        return (a) DEFAULT_INSTANCE.createBuilder(marketStruct$MarketItem);
    }

    public static MarketStruct$MarketItem parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MarketStruct$MarketItem) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MarketStruct$MarketItem parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MarketStruct$MarketItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MarketStruct$MarketItem parseFrom(AbstractC2383g abstractC2383g) {
        return (MarketStruct$MarketItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addPosts(int i, MarketStruct$Post marketStruct$Post) {
        marketStruct$Post.getClass();
        ensurePostsIsMutable();
        this.posts_.add(i, marketStruct$Post);
    }

    private void addProducts(int i, MarketStruct$Product marketStruct$Product) {
        marketStruct$Product.getClass();
        ensureProductsIsMutable();
        this.products_.add(i, marketStruct$Product);
    }

    public static MarketStruct$MarketItem parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MarketStruct$MarketItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MarketStruct$MarketItem parseFrom(byte[] bArr) {
        return (MarketStruct$MarketItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MarketStruct$MarketItem parseFrom(byte[] bArr, C2394s c2394s) {
        return (MarketStruct$MarketItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MarketStruct$MarketItem parseFrom(InputStream inputStream) {
        return (MarketStruct$MarketItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MarketStruct$MarketItem parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MarketStruct$MarketItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MarketStruct$MarketItem parseFrom(AbstractC2384h abstractC2384h) {
        return (MarketStruct$MarketItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MarketStruct$MarketItem parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MarketStruct$MarketItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
