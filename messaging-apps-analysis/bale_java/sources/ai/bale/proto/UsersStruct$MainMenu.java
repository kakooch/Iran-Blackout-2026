package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC24883zM7;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes.dex */
public final class UsersStruct$MainMenu extends GeneratedMessageLite implements U64 {
    private static final UsersStruct$MainMenu DEFAULT_INSTANCE;
    public static final int ITEMS_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private B.j items_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(UsersStruct$MainMenu.DEFAULT_INSTANCE);
        }
    }

    static {
        UsersStruct$MainMenu usersStruct$MainMenu = new UsersStruct$MainMenu();
        DEFAULT_INSTANCE = usersStruct$MainMenu;
        GeneratedMessageLite.registerDefaultInstance(UsersStruct$MainMenu.class, usersStruct$MainMenu);
    }

    private UsersStruct$MainMenu() {
    }

    private void addAllItems(Iterable<? extends UsersStruct$MenuItem> iterable) {
        ensureItemsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.items_);
    }

    private void addItems(UsersStruct$MenuItem usersStruct$MenuItem) {
        usersStruct$MenuItem.getClass();
        ensureItemsIsMutable();
        this.items_.add(usersStruct$MenuItem);
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

    public static UsersStruct$MainMenu getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static UsersStruct$MainMenu parseDelimitedFrom(InputStream inputStream) {
        return (UsersStruct$MainMenu) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UsersStruct$MainMenu parseFrom(ByteBuffer byteBuffer) {
        return (UsersStruct$MainMenu) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeItems(int i) {
        ensureItemsIsMutable();
        this.items_.remove(i);
    }

    private void setItems(int i, UsersStruct$MenuItem usersStruct$MenuItem) {
        usersStruct$MenuItem.getClass();
        ensureItemsIsMutable();
        this.items_.set(i, usersStruct$MenuItem);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (q2.a[gVar.ordinal()]) {
            case 1:
                return new UsersStruct$MainMenu();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"items_", UsersStruct$MenuItem.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (UsersStruct$MainMenu.class) {
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

    public UsersStruct$MenuItem getItems(int i) {
        return (UsersStruct$MenuItem) this.items_.get(i);
    }

    public int getItemsCount() {
        return this.items_.size();
    }

    public List<UsersStruct$MenuItem> getItemsList() {
        return this.items_;
    }

    public InterfaceC24883zM7 getItemsOrBuilder(int i) {
        return (InterfaceC24883zM7) this.items_.get(i);
    }

    public List<? extends InterfaceC24883zM7> getItemsOrBuilderList() {
        return this.items_;
    }

    public static a newBuilder(UsersStruct$MainMenu usersStruct$MainMenu) {
        return (a) DEFAULT_INSTANCE.createBuilder(usersStruct$MainMenu);
    }

    public static UsersStruct$MainMenu parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (UsersStruct$MainMenu) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static UsersStruct$MainMenu parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (UsersStruct$MainMenu) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static UsersStruct$MainMenu parseFrom(AbstractC2383g abstractC2383g) {
        return (UsersStruct$MainMenu) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addItems(int i, UsersStruct$MenuItem usersStruct$MenuItem) {
        usersStruct$MenuItem.getClass();
        ensureItemsIsMutable();
        this.items_.add(i, usersStruct$MenuItem);
    }

    public static UsersStruct$MainMenu parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (UsersStruct$MainMenu) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static UsersStruct$MainMenu parseFrom(byte[] bArr) {
        return (UsersStruct$MainMenu) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static UsersStruct$MainMenu parseFrom(byte[] bArr, C2394s c2394s) {
        return (UsersStruct$MainMenu) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static UsersStruct$MainMenu parseFrom(InputStream inputStream) {
        return (UsersStruct$MainMenu) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UsersStruct$MainMenu parseFrom(InputStream inputStream, C2394s c2394s) {
        return (UsersStruct$MainMenu) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static UsersStruct$MainMenu parseFrom(AbstractC2384h abstractC2384h) {
        return (UsersStruct$MainMenu) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static UsersStruct$MainMenu parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (UsersStruct$MainMenu) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
