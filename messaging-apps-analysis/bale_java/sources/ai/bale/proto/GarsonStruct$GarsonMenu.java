package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC19960rE2;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class GarsonStruct$GarsonMenu extends GeneratedMessageLite implements U64 {
    private static final GarsonStruct$GarsonMenu DEFAULT_INSTANCE;
    public static final int ITEMS_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private B.j items_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(GarsonStruct$GarsonMenu.DEFAULT_INSTANCE);
        }
    }

    static {
        GarsonStruct$GarsonMenu garsonStruct$GarsonMenu = new GarsonStruct$GarsonMenu();
        DEFAULT_INSTANCE = garsonStruct$GarsonMenu;
        GeneratedMessageLite.registerDefaultInstance(GarsonStruct$GarsonMenu.class, garsonStruct$GarsonMenu);
    }

    private GarsonStruct$GarsonMenu() {
    }

    private void addAllItems(Iterable<? extends GarsonStruct$GarsonMenuItem> iterable) {
        ensureItemsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.items_);
    }

    private void addItems(GarsonStruct$GarsonMenuItem garsonStruct$GarsonMenuItem) {
        garsonStruct$GarsonMenuItem.getClass();
        ensureItemsIsMutable();
        this.items_.add(garsonStruct$GarsonMenuItem);
    }

    private void clearItems() {
        this.items_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureItemsIsMutable() {
        B.j jVar = this.items_;
        if (jVar.u()) {
            return;
        }
        this.items_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static GarsonStruct$GarsonMenu getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static GarsonStruct$GarsonMenu parseDelimitedFrom(InputStream inputStream) {
        return (GarsonStruct$GarsonMenu) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GarsonStruct$GarsonMenu parseFrom(ByteBuffer byteBuffer) {
        return (GarsonStruct$GarsonMenu) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeItems(int i) {
        ensureItemsIsMutable();
        this.items_.remove(i);
    }

    private void setItems(int i, GarsonStruct$GarsonMenuItem garsonStruct$GarsonMenuItem) {
        garsonStruct$GarsonMenuItem.getClass();
        ensureItemsIsMutable();
        this.items_.set(i, garsonStruct$GarsonMenuItem);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1850e0.a[gVar.ordinal()]) {
            case 1:
                return new GarsonStruct$GarsonMenu();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"items_", GarsonStruct$GarsonMenuItem.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (GarsonStruct$GarsonMenu.class) {
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

    public GarsonStruct$GarsonMenuItem getItems(int i) {
        return (GarsonStruct$GarsonMenuItem) this.items_.get(i);
    }

    public int getItemsCount() {
        return this.items_.size();
    }

    public List<GarsonStruct$GarsonMenuItem> getItemsList() {
        return this.items_;
    }

    public InterfaceC19960rE2 getItemsOrBuilder(int i) {
        return (InterfaceC19960rE2) this.items_.get(i);
    }

    public List<? extends InterfaceC19960rE2> getItemsOrBuilderList() {
        return this.items_;
    }

    public static a newBuilder(GarsonStruct$GarsonMenu garsonStruct$GarsonMenu) {
        return (a) DEFAULT_INSTANCE.createBuilder(garsonStruct$GarsonMenu);
    }

    public static GarsonStruct$GarsonMenu parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (GarsonStruct$GarsonMenu) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GarsonStruct$GarsonMenu parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (GarsonStruct$GarsonMenu) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static GarsonStruct$GarsonMenu parseFrom(AbstractC2383g abstractC2383g) {
        return (GarsonStruct$GarsonMenu) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addItems(int i, GarsonStruct$GarsonMenuItem garsonStruct$GarsonMenuItem) {
        garsonStruct$GarsonMenuItem.getClass();
        ensureItemsIsMutable();
        this.items_.add(i, garsonStruct$GarsonMenuItem);
    }

    public static GarsonStruct$GarsonMenu parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (GarsonStruct$GarsonMenu) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static GarsonStruct$GarsonMenu parseFrom(byte[] bArr) {
        return (GarsonStruct$GarsonMenu) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GarsonStruct$GarsonMenu parseFrom(byte[] bArr, C2394s c2394s) {
        return (GarsonStruct$GarsonMenu) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static GarsonStruct$GarsonMenu parseFrom(InputStream inputStream) {
        return (GarsonStruct$GarsonMenu) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GarsonStruct$GarsonMenu parseFrom(InputStream inputStream, C2394s c2394s) {
        return (GarsonStruct$GarsonMenu) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GarsonStruct$GarsonMenu parseFrom(AbstractC2384h abstractC2384h) {
        return (GarsonStruct$GarsonMenu) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static GarsonStruct$GarsonMenu parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (GarsonStruct$GarsonMenu) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
