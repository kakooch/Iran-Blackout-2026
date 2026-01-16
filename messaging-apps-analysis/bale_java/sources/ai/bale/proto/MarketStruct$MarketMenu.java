package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.NT3;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class MarketStruct$MarketMenu extends GeneratedMessageLite implements U64 {
    private static final MarketStruct$MarketMenu DEFAULT_INSTANCE;
    public static final int ITEMS_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int TITLE_FIELD_NUMBER = 1;
    private String title_ = "";
    private B.j items_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MarketStruct$MarketMenu.DEFAULT_INSTANCE);
        }
    }

    static {
        MarketStruct$MarketMenu marketStruct$MarketMenu = new MarketStruct$MarketMenu();
        DEFAULT_INSTANCE = marketStruct$MarketMenu;
        GeneratedMessageLite.registerDefaultInstance(MarketStruct$MarketMenu.class, marketStruct$MarketMenu);
    }

    private MarketStruct$MarketMenu() {
    }

    private void addAllItems(Iterable<? extends MarketStruct$MarketMenuItem> iterable) {
        ensureItemsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.items_);
    }

    private void addItems(MarketStruct$MarketMenuItem marketStruct$MarketMenuItem) {
        marketStruct$MarketMenuItem.getClass();
        ensureItemsIsMutable();
        this.items_.add(marketStruct$MarketMenuItem);
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

    public static MarketStruct$MarketMenu getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MarketStruct$MarketMenu parseDelimitedFrom(InputStream inputStream) {
        return (MarketStruct$MarketMenu) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MarketStruct$MarketMenu parseFrom(ByteBuffer byteBuffer) {
        return (MarketStruct$MarketMenu) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeItems(int i) {
        ensureItemsIsMutable();
        this.items_.remove(i);
    }

    private void setItems(int i, MarketStruct$MarketMenuItem marketStruct$MarketMenuItem) {
        marketStruct$MarketMenuItem.getClass();
        ensureItemsIsMutable();
        this.items_.set(i, marketStruct$MarketMenuItem);
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
                return new MarketStruct$MarketMenu();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001Ȉ\u0002\u001b", new Object[]{"title_", "items_", MarketStruct$MarketMenuItem.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MarketStruct$MarketMenu.class) {
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

    public MarketStruct$MarketMenuItem getItems(int i) {
        return (MarketStruct$MarketMenuItem) this.items_.get(i);
    }

    public int getItemsCount() {
        return this.items_.size();
    }

    public List<MarketStruct$MarketMenuItem> getItemsList() {
        return this.items_;
    }

    public NT3 getItemsOrBuilder(int i) {
        return (NT3) this.items_.get(i);
    }

    public List<? extends NT3> getItemsOrBuilderList() {
        return this.items_;
    }

    public String getTitle() {
        return this.title_;
    }

    public AbstractC2383g getTitleBytes() {
        return AbstractC2383g.N(this.title_);
    }

    public static a newBuilder(MarketStruct$MarketMenu marketStruct$MarketMenu) {
        return (a) DEFAULT_INSTANCE.createBuilder(marketStruct$MarketMenu);
    }

    public static MarketStruct$MarketMenu parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MarketStruct$MarketMenu) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MarketStruct$MarketMenu parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MarketStruct$MarketMenu) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MarketStruct$MarketMenu parseFrom(AbstractC2383g abstractC2383g) {
        return (MarketStruct$MarketMenu) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addItems(int i, MarketStruct$MarketMenuItem marketStruct$MarketMenuItem) {
        marketStruct$MarketMenuItem.getClass();
        ensureItemsIsMutable();
        this.items_.add(i, marketStruct$MarketMenuItem);
    }

    public static MarketStruct$MarketMenu parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MarketStruct$MarketMenu) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MarketStruct$MarketMenu parseFrom(byte[] bArr) {
        return (MarketStruct$MarketMenu) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MarketStruct$MarketMenu parseFrom(byte[] bArr, C2394s c2394s) {
        return (MarketStruct$MarketMenu) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MarketStruct$MarketMenu parseFrom(InputStream inputStream) {
        return (MarketStruct$MarketMenu) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MarketStruct$MarketMenu parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MarketStruct$MarketMenu) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MarketStruct$MarketMenu parseFrom(AbstractC2384h abstractC2384h) {
        return (MarketStruct$MarketMenu) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MarketStruct$MarketMenu parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MarketStruct$MarketMenu) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
