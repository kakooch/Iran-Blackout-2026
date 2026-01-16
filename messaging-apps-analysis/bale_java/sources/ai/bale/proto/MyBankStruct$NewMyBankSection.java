package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC23962xo4;
import ir.nasim.InterfaceC3366Ao4;
import ir.nasim.InterfaceC4307Eo4;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class MyBankStruct$NewMyBankSection extends GeneratedMessageLite implements InterfaceC4307Eo4 {
    public static final int BADGE_TYPE_FIELD_NUMBER = 4;
    private static final MyBankStruct$NewMyBankSection DEFAULT_INSTANCE;
    public static final int ID_FIELD_NUMBER = 1;
    public static final int IS_EDITABLE_FIELD_NUMBER = 3;
    public static final int ITEMS_FIELD_NUMBER = 5;
    private static volatile KW4 PARSER = null;
    public static final int TITLE_FIELD_NUMBER = 2;
    private int badgeType_;
    private int id_;
    private boolean isEditable_;
    private String title_ = "";
    private B.j items_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements InterfaceC4307Eo4 {
        private a() {
            super(MyBankStruct$NewMyBankSection.DEFAULT_INSTANCE);
        }
    }

    static {
        MyBankStruct$NewMyBankSection myBankStruct$NewMyBankSection = new MyBankStruct$NewMyBankSection();
        DEFAULT_INSTANCE = myBankStruct$NewMyBankSection;
        GeneratedMessageLite.registerDefaultInstance(MyBankStruct$NewMyBankSection.class, myBankStruct$NewMyBankSection);
    }

    private MyBankStruct$NewMyBankSection() {
    }

    private void addAllItems(Iterable<? extends MyBankStruct$NewMyBankItem> iterable) {
        ensureItemsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.items_);
    }

    private void addItems(MyBankStruct$NewMyBankItem myBankStruct$NewMyBankItem) {
        myBankStruct$NewMyBankItem.getClass();
        ensureItemsIsMutable();
        this.items_.add(myBankStruct$NewMyBankItem);
    }

    private void clearBadgeType() {
        this.badgeType_ = 0;
    }

    private void clearId() {
        this.id_ = 0;
    }

    private void clearIsEditable() {
        this.isEditable_ = false;
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

    public static MyBankStruct$NewMyBankSection getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MyBankStruct$NewMyBankSection parseDelimitedFrom(InputStream inputStream) {
        return (MyBankStruct$NewMyBankSection) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MyBankStruct$NewMyBankSection parseFrom(ByteBuffer byteBuffer) {
        return (MyBankStruct$NewMyBankSection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeItems(int i) {
        ensureItemsIsMutable();
        this.items_.remove(i);
    }

    private void setBadgeType(EnumC23962xo4 enumC23962xo4) {
        this.badgeType_ = enumC23962xo4.getNumber();
    }

    private void setBadgeTypeValue(int i) {
        this.badgeType_ = i;
    }

    private void setId(int i) {
        this.id_ = i;
    }

    private void setIsEditable(boolean z) {
        this.isEditable_ = z;
    }

    private void setItems(int i, MyBankStruct$NewMyBankItem myBankStruct$NewMyBankItem) {
        myBankStruct$NewMyBankItem.getClass();
        ensureItemsIsMutable();
        this.items_.set(i, myBankStruct$NewMyBankItem);
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
        switch (R0.a[gVar.ordinal()]) {
            case 1:
                return new MyBankStruct$NewMyBankSection();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0001\u0000\u0001\u0004\u0002Ȉ\u0003\u0007\u0004\f\u0005\u001b", new Object[]{"id_", "title_", "isEditable_", "badgeType_", "items_", MyBankStruct$NewMyBankItem.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MyBankStruct$NewMyBankSection.class) {
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

    public EnumC23962xo4 getBadgeType() {
        EnumC23962xo4 enumC23962xo4J = EnumC23962xo4.j(this.badgeType_);
        return enumC23962xo4J == null ? EnumC23962xo4.UNRECOGNIZED : enumC23962xo4J;
    }

    public int getBadgeTypeValue() {
        return this.badgeType_;
    }

    public int getId() {
        return this.id_;
    }

    public boolean getIsEditable() {
        return this.isEditable_;
    }

    public MyBankStruct$NewMyBankItem getItems(int i) {
        return (MyBankStruct$NewMyBankItem) this.items_.get(i);
    }

    public int getItemsCount() {
        return this.items_.size();
    }

    public List<MyBankStruct$NewMyBankItem> getItemsList() {
        return this.items_;
    }

    public InterfaceC3366Ao4 getItemsOrBuilder(int i) {
        return (InterfaceC3366Ao4) this.items_.get(i);
    }

    public List<? extends InterfaceC3366Ao4> getItemsOrBuilderList() {
        return this.items_;
    }

    public String getTitle() {
        return this.title_;
    }

    public AbstractC2383g getTitleBytes() {
        return AbstractC2383g.N(this.title_);
    }

    public static a newBuilder(MyBankStruct$NewMyBankSection myBankStruct$NewMyBankSection) {
        return (a) DEFAULT_INSTANCE.createBuilder(myBankStruct$NewMyBankSection);
    }

    public static MyBankStruct$NewMyBankSection parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MyBankStruct$NewMyBankSection) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MyBankStruct$NewMyBankSection parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MyBankStruct$NewMyBankSection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MyBankStruct$NewMyBankSection parseFrom(AbstractC2383g abstractC2383g) {
        return (MyBankStruct$NewMyBankSection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addItems(int i, MyBankStruct$NewMyBankItem myBankStruct$NewMyBankItem) {
        myBankStruct$NewMyBankItem.getClass();
        ensureItemsIsMutable();
        this.items_.add(i, myBankStruct$NewMyBankItem);
    }

    public static MyBankStruct$NewMyBankSection parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MyBankStruct$NewMyBankSection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MyBankStruct$NewMyBankSection parseFrom(byte[] bArr) {
        return (MyBankStruct$NewMyBankSection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MyBankStruct$NewMyBankSection parseFrom(byte[] bArr, C2394s c2394s) {
        return (MyBankStruct$NewMyBankSection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MyBankStruct$NewMyBankSection parseFrom(InputStream inputStream) {
        return (MyBankStruct$NewMyBankSection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MyBankStruct$NewMyBankSection parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MyBankStruct$NewMyBankSection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MyBankStruct$NewMyBankSection parseFrom(AbstractC2384h abstractC2384h) {
        return (MyBankStruct$NewMyBankSection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MyBankStruct$NewMyBankSection parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MyBankStruct$NewMyBankSection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
