package ai.bale.proto;

import ai.bale.proto.MarketStruct$MarketMenuItemDialog;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.BoolValue;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.CT3;
import ir.nasim.EnumC21325tT3;
import ir.nasim.GT3;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class MarketStruct$MarketCategory extends GeneratedMessageLite implements CT3 {
    public static final int CATEGORY_ITEMS_TYPE_FIELD_NUMBER = 8;
    private static final MarketStruct$MarketCategory DEFAULT_INSTANCE;
    public static final int DIALOG_FIELD_NUMBER = 5;
    public static final int DRAWABLEID_FIELD_NUMBER = 3;
    public static final int ID_FIELD_NUMBER = 1;
    public static final int MARKETS_FIELD_NUMBER = 4;
    public static final int PARENTID_FIELD_NUMBER = 6;
    private static volatile KW4 PARSER = null;
    public static final int PINNED_FIELD_NUMBER = 7;
    public static final int TITLE_FIELD_NUMBER = 2;
    private int bitField0_;
    private int categoryItemsType_;
    private MarketStruct$MarketMenuItemDialog dialog_;
    private int id_;
    private int parentId_;
    private BoolValue pinned_;
    private String title_ = "";
    private String drawableId_ = "";
    private B.j markets_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements CT3 {
        private a() {
            super(MarketStruct$MarketCategory.DEFAULT_INSTANCE);
        }
    }

    static {
        MarketStruct$MarketCategory marketStruct$MarketCategory = new MarketStruct$MarketCategory();
        DEFAULT_INSTANCE = marketStruct$MarketCategory;
        GeneratedMessageLite.registerDefaultInstance(MarketStruct$MarketCategory.class, marketStruct$MarketCategory);
    }

    private MarketStruct$MarketCategory() {
    }

    private void addAllMarkets(Iterable<? extends MarketStruct$MarketItem> iterable) {
        ensureMarketsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.markets_);
    }

    private void addMarkets(MarketStruct$MarketItem marketStruct$MarketItem) {
        marketStruct$MarketItem.getClass();
        ensureMarketsIsMutable();
        this.markets_.add(marketStruct$MarketItem);
    }

    private void clearCategoryItemsType() {
        this.categoryItemsType_ = 0;
    }

    private void clearDialog() {
        this.dialog_ = null;
        this.bitField0_ &= -2;
    }

    private void clearDrawableId() {
        this.drawableId_ = getDefaultInstance().getDrawableId();
    }

    private void clearId() {
        this.id_ = 0;
    }

    private void clearMarkets() {
        this.markets_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearParentId() {
        this.parentId_ = 0;
    }

    private void clearPinned() {
        this.pinned_ = null;
        this.bitField0_ &= -3;
    }

    private void clearTitle() {
        this.title_ = getDefaultInstance().getTitle();
    }

    private void ensureMarketsIsMutable() {
        B.j jVar = this.markets_;
        if (jVar.u()) {
            return;
        }
        this.markets_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static MarketStruct$MarketCategory getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeDialog(MarketStruct$MarketMenuItemDialog marketStruct$MarketMenuItemDialog) {
        marketStruct$MarketMenuItemDialog.getClass();
        MarketStruct$MarketMenuItemDialog marketStruct$MarketMenuItemDialog2 = this.dialog_;
        if (marketStruct$MarketMenuItemDialog2 == null || marketStruct$MarketMenuItemDialog2 == MarketStruct$MarketMenuItemDialog.getDefaultInstance()) {
            this.dialog_ = marketStruct$MarketMenuItemDialog;
        } else {
            this.dialog_ = (MarketStruct$MarketMenuItemDialog) ((MarketStruct$MarketMenuItemDialog.a) MarketStruct$MarketMenuItemDialog.newBuilder(this.dialog_).v(marketStruct$MarketMenuItemDialog)).j();
        }
        this.bitField0_ |= 1;
    }

    private void mergePinned(BoolValue boolValue) {
        boolValue.getClass();
        BoolValue boolValue2 = this.pinned_;
        if (boolValue2 == null || boolValue2 == BoolValue.getDefaultInstance()) {
            this.pinned_ = boolValue;
        } else {
            this.pinned_ = (BoolValue) ((BoolValue.b) BoolValue.newBuilder(this.pinned_).v(boolValue)).j();
        }
        this.bitField0_ |= 2;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MarketStruct$MarketCategory parseDelimitedFrom(InputStream inputStream) {
        return (MarketStruct$MarketCategory) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MarketStruct$MarketCategory parseFrom(ByteBuffer byteBuffer) {
        return (MarketStruct$MarketCategory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeMarkets(int i) {
        ensureMarketsIsMutable();
        this.markets_.remove(i);
    }

    private void setCategoryItemsType(EnumC21325tT3 enumC21325tT3) {
        this.categoryItemsType_ = enumC21325tT3.getNumber();
    }

    private void setCategoryItemsTypeValue(int i) {
        this.categoryItemsType_ = i;
    }

    private void setDialog(MarketStruct$MarketMenuItemDialog marketStruct$MarketMenuItemDialog) {
        marketStruct$MarketMenuItemDialog.getClass();
        this.dialog_ = marketStruct$MarketMenuItemDialog;
        this.bitField0_ |= 1;
    }

    private void setDrawableId(String str) {
        str.getClass();
        this.drawableId_ = str;
    }

    private void setDrawableIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.drawableId_ = abstractC2383g.f0();
    }

    private void setId(int i) {
        this.id_ = i;
    }

    private void setMarkets(int i, MarketStruct$MarketItem marketStruct$MarketItem) {
        marketStruct$MarketItem.getClass();
        ensureMarketsIsMutable();
        this.markets_.set(i, marketStruct$MarketItem);
    }

    private void setParentId(int i) {
        this.parentId_ = i;
    }

    private void setPinned(BoolValue boolValue) {
        boolValue.getClass();
        this.pinned_ = boolValue;
        this.bitField0_ |= 2;
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
        switch (D0.a[gVar.ordinal()]) {
            case 1:
                return new MarketStruct$MarketCategory();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\b\u0000\u0001\u0001\b\b\u0000\u0001\u0000\u0001\u0004\u0002Ȉ\u0003Ȉ\u0004\u001b\u0005ဉ\u0000\u0006\u0004\u0007ဉ\u0001\b\f", new Object[]{"bitField0_", "id_", "title_", "drawableId_", "markets_", MarketStruct$MarketItem.class, "dialog_", "parentId_", "pinned_", "categoryItemsType_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MarketStruct$MarketCategory.class) {
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

    public EnumC21325tT3 getCategoryItemsType() {
        EnumC21325tT3 enumC21325tT3J = EnumC21325tT3.j(this.categoryItemsType_);
        return enumC21325tT3J == null ? EnumC21325tT3.UNRECOGNIZED : enumC21325tT3J;
    }

    public int getCategoryItemsTypeValue() {
        return this.categoryItemsType_;
    }

    public MarketStruct$MarketMenuItemDialog getDialog() {
        MarketStruct$MarketMenuItemDialog marketStruct$MarketMenuItemDialog = this.dialog_;
        return marketStruct$MarketMenuItemDialog == null ? MarketStruct$MarketMenuItemDialog.getDefaultInstance() : marketStruct$MarketMenuItemDialog;
    }

    public String getDrawableId() {
        return this.drawableId_;
    }

    public AbstractC2383g getDrawableIdBytes() {
        return AbstractC2383g.N(this.drawableId_);
    }

    public int getId() {
        return this.id_;
    }

    public MarketStruct$MarketItem getMarkets(int i) {
        return (MarketStruct$MarketItem) this.markets_.get(i);
    }

    public int getMarketsCount() {
        return this.markets_.size();
    }

    public List<MarketStruct$MarketItem> getMarketsList() {
        return this.markets_;
    }

    public GT3 getMarketsOrBuilder(int i) {
        return (GT3) this.markets_.get(i);
    }

    public List<? extends GT3> getMarketsOrBuilderList() {
        return this.markets_;
    }

    public int getParentId() {
        return this.parentId_;
    }

    public BoolValue getPinned() {
        BoolValue boolValue = this.pinned_;
        return boolValue == null ? BoolValue.getDefaultInstance() : boolValue;
    }

    public String getTitle() {
        return this.title_;
    }

    public AbstractC2383g getTitleBytes() {
        return AbstractC2383g.N(this.title_);
    }

    public boolean hasDialog() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasPinned() {
        return (this.bitField0_ & 2) != 0;
    }

    public static a newBuilder(MarketStruct$MarketCategory marketStruct$MarketCategory) {
        return (a) DEFAULT_INSTANCE.createBuilder(marketStruct$MarketCategory);
    }

    public static MarketStruct$MarketCategory parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MarketStruct$MarketCategory) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MarketStruct$MarketCategory parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MarketStruct$MarketCategory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MarketStruct$MarketCategory parseFrom(AbstractC2383g abstractC2383g) {
        return (MarketStruct$MarketCategory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addMarkets(int i, MarketStruct$MarketItem marketStruct$MarketItem) {
        marketStruct$MarketItem.getClass();
        ensureMarketsIsMutable();
        this.markets_.add(i, marketStruct$MarketItem);
    }

    public static MarketStruct$MarketCategory parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MarketStruct$MarketCategory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MarketStruct$MarketCategory parseFrom(byte[] bArr) {
        return (MarketStruct$MarketCategory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MarketStruct$MarketCategory parseFrom(byte[] bArr, C2394s c2394s) {
        return (MarketStruct$MarketCategory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MarketStruct$MarketCategory parseFrom(InputStream inputStream) {
        return (MarketStruct$MarketCategory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MarketStruct$MarketCategory parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MarketStruct$MarketCategory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MarketStruct$MarketCategory parseFrom(AbstractC2384h abstractC2384h) {
        return (MarketStruct$MarketCategory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MarketStruct$MarketCategory parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MarketStruct$MarketCategory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
