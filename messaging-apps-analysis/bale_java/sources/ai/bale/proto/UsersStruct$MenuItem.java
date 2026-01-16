package ai.bale.proto;

import ai.bale.proto.FilesStruct$FileLocation;
import ai.bale.proto.UsersStruct$MainMenu;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC22513vM7;
import ir.nasim.InterfaceC24883zM7;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes.dex */
public final class UsersStruct$MenuItem extends GeneratedMessageLite implements InterfaceC24883zM7 {
    public static final int ACTIONS_FIELD_NUMBER = 5;
    private static final UsersStruct$MenuItem DEFAULT_INSTANCE;
    public static final int DISPLAY_TEXT_FIELD_NUMBER = 3;
    public static final int ITEM_TYPE_FIELD_NUMBER = 1;
    public static final int NESTED_MENU_FIELD_NUMBER = 6;
    public static final int OPT_FILE_LOCATION_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int VALUE_FIELD_NUMBER = 4;
    private int bitField0_;
    private int itemType_;
    private UsersStruct$MainMenu nestedMenu_;
    private FilesStruct$FileLocation optFileLocation_;
    private String displayText_ = "";
    private String value_ = "";
    private B.j actions_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements InterfaceC24883zM7 {
        private a() {
            super(UsersStruct$MenuItem.DEFAULT_INSTANCE);
        }
    }

    static {
        UsersStruct$MenuItem usersStruct$MenuItem = new UsersStruct$MenuItem();
        DEFAULT_INSTANCE = usersStruct$MenuItem;
        GeneratedMessageLite.registerDefaultInstance(UsersStruct$MenuItem.class, usersStruct$MenuItem);
    }

    private UsersStruct$MenuItem() {
    }

    private void addActions(String str) {
        str.getClass();
        ensureActionsIsMutable();
        this.actions_.add(str);
    }

    private void addActionsBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        ensureActionsIsMutable();
        this.actions_.add(abstractC2383g.f0());
    }

    private void addAllActions(Iterable<String> iterable) {
        ensureActionsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.actions_);
    }

    private void clearActions() {
        this.actions_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearDisplayText() {
        this.displayText_ = getDefaultInstance().getDisplayText();
    }

    private void clearItemType() {
        this.itemType_ = 0;
    }

    private void clearNestedMenu() {
        this.nestedMenu_ = null;
        this.bitField0_ &= -3;
    }

    private void clearOptFileLocation() {
        this.optFileLocation_ = null;
        this.bitField0_ &= -2;
    }

    private void clearValue() {
        this.value_ = getDefaultInstance().getValue();
    }

    private void ensureActionsIsMutable() {
        B.j jVar = this.actions_;
        if (jVar.u()) {
            return;
        }
        this.actions_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static UsersStruct$MenuItem getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeNestedMenu(UsersStruct$MainMenu usersStruct$MainMenu) {
        usersStruct$MainMenu.getClass();
        UsersStruct$MainMenu usersStruct$MainMenu2 = this.nestedMenu_;
        if (usersStruct$MainMenu2 == null || usersStruct$MainMenu2 == UsersStruct$MainMenu.getDefaultInstance()) {
            this.nestedMenu_ = usersStruct$MainMenu;
        } else {
            this.nestedMenu_ = (UsersStruct$MainMenu) ((UsersStruct$MainMenu.a) UsersStruct$MainMenu.newBuilder(this.nestedMenu_).v(usersStruct$MainMenu)).j();
        }
        this.bitField0_ |= 2;
    }

    private void mergeOptFileLocation(FilesStruct$FileLocation filesStruct$FileLocation) {
        filesStruct$FileLocation.getClass();
        FilesStruct$FileLocation filesStruct$FileLocation2 = this.optFileLocation_;
        if (filesStruct$FileLocation2 == null || filesStruct$FileLocation2 == FilesStruct$FileLocation.getDefaultInstance()) {
            this.optFileLocation_ = filesStruct$FileLocation;
        } else {
            this.optFileLocation_ = (FilesStruct$FileLocation) ((FilesStruct$FileLocation.a) FilesStruct$FileLocation.newBuilder(this.optFileLocation_).v(filesStruct$FileLocation)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static UsersStruct$MenuItem parseDelimitedFrom(InputStream inputStream) {
        return (UsersStruct$MenuItem) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UsersStruct$MenuItem parseFrom(ByteBuffer byteBuffer) {
        return (UsersStruct$MenuItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setActions(int i, String str) {
        str.getClass();
        ensureActionsIsMutable();
        this.actions_.set(i, str);
    }

    private void setDisplayText(String str) {
        str.getClass();
        this.displayText_ = str;
    }

    private void setDisplayTextBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.displayText_ = abstractC2383g.f0();
    }

    private void setItemType(EnumC22513vM7 enumC22513vM7) {
        this.itemType_ = enumC22513vM7.getNumber();
    }

    private void setItemTypeValue(int i) {
        this.itemType_ = i;
    }

    private void setNestedMenu(UsersStruct$MainMenu usersStruct$MainMenu) {
        usersStruct$MainMenu.getClass();
        this.nestedMenu_ = usersStruct$MainMenu;
        this.bitField0_ |= 2;
    }

    private void setOptFileLocation(FilesStruct$FileLocation filesStruct$FileLocation) {
        filesStruct$FileLocation.getClass();
        this.optFileLocation_ = filesStruct$FileLocation;
        this.bitField0_ |= 1;
    }

    private void setValue(String str) {
        str.getClass();
        this.value_ = str;
    }

    private void setValueBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.value_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (q2.a[gVar.ordinal()]) {
            case 1:
                return new UsersStruct$MenuItem();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0000\u0001\f\u0002ဉ\u0000\u0003Ȉ\u0004Ȉ\u0005Ț\u0006ဉ\u0001", new Object[]{"bitField0_", "itemType_", "optFileLocation_", "displayText_", "value_", "actions_", "nestedMenu_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (UsersStruct$MenuItem.class) {
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

    public String getActions(int i) {
        return (String) this.actions_.get(i);
    }

    public AbstractC2383g getActionsBytes(int i) {
        return AbstractC2383g.N((String) this.actions_.get(i));
    }

    public int getActionsCount() {
        return this.actions_.size();
    }

    public List<String> getActionsList() {
        return this.actions_;
    }

    public String getDisplayText() {
        return this.displayText_;
    }

    public AbstractC2383g getDisplayTextBytes() {
        return AbstractC2383g.N(this.displayText_);
    }

    public EnumC22513vM7 getItemType() {
        EnumC22513vM7 enumC22513vM7J = EnumC22513vM7.j(this.itemType_);
        return enumC22513vM7J == null ? EnumC22513vM7.UNRECOGNIZED : enumC22513vM7J;
    }

    public int getItemTypeValue() {
        return this.itemType_;
    }

    public UsersStruct$MainMenu getNestedMenu() {
        UsersStruct$MainMenu usersStruct$MainMenu = this.nestedMenu_;
        return usersStruct$MainMenu == null ? UsersStruct$MainMenu.getDefaultInstance() : usersStruct$MainMenu;
    }

    public FilesStruct$FileLocation getOptFileLocation() {
        FilesStruct$FileLocation filesStruct$FileLocation = this.optFileLocation_;
        return filesStruct$FileLocation == null ? FilesStruct$FileLocation.getDefaultInstance() : filesStruct$FileLocation;
    }

    public String getValue() {
        return this.value_;
    }

    public AbstractC2383g getValueBytes() {
        return AbstractC2383g.N(this.value_);
    }

    public boolean hasNestedMenu() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasOptFileLocation() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(UsersStruct$MenuItem usersStruct$MenuItem) {
        return (a) DEFAULT_INSTANCE.createBuilder(usersStruct$MenuItem);
    }

    public static UsersStruct$MenuItem parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (UsersStruct$MenuItem) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static UsersStruct$MenuItem parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (UsersStruct$MenuItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static UsersStruct$MenuItem parseFrom(AbstractC2383g abstractC2383g) {
        return (UsersStruct$MenuItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static UsersStruct$MenuItem parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (UsersStruct$MenuItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static UsersStruct$MenuItem parseFrom(byte[] bArr) {
        return (UsersStruct$MenuItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static UsersStruct$MenuItem parseFrom(byte[] bArr, C2394s c2394s) {
        return (UsersStruct$MenuItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static UsersStruct$MenuItem parseFrom(InputStream inputStream) {
        return (UsersStruct$MenuItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UsersStruct$MenuItem parseFrom(InputStream inputStream, C2394s c2394s) {
        return (UsersStruct$MenuItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static UsersStruct$MenuItem parseFrom(AbstractC2384h abstractC2384h) {
        return (UsersStruct$MenuItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static UsersStruct$MenuItem parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (UsersStruct$MenuItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
