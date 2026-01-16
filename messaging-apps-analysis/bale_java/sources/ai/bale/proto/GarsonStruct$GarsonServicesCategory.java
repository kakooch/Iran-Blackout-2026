package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.BE2;
import ir.nasim.EnumC12823fE2;
import ir.nasim.InterfaceC24212yE2;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class GarsonStruct$GarsonServicesCategory extends GeneratedMessageLite implements BE2 {
    public static final int BADGE_FIELD_NUMBER = 4;
    public static final int BADGE_TYPE_FIELD_NUMBER = 3;
    private static final GarsonStruct$GarsonServicesCategory DEFAULT_INSTANCE;
    public static final int ID_FIELD_NUMBER = 1;
    public static final int ITEMS_FIELD_NUMBER = 5;
    private static volatile KW4 PARSER = null;
    public static final int TITLE_FIELD_NUMBER = 2;
    private int badgeType_;
    private int id_;
    private String title_ = "";
    private String badge_ = "";
    private B.j items_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements BE2 {
        private a() {
            super(GarsonStruct$GarsonServicesCategory.DEFAULT_INSTANCE);
        }
    }

    static {
        GarsonStruct$GarsonServicesCategory garsonStruct$GarsonServicesCategory = new GarsonStruct$GarsonServicesCategory();
        DEFAULT_INSTANCE = garsonStruct$GarsonServicesCategory;
        GeneratedMessageLite.registerDefaultInstance(GarsonStruct$GarsonServicesCategory.class, garsonStruct$GarsonServicesCategory);
    }

    private GarsonStruct$GarsonServicesCategory() {
    }

    private void addAllItems(Iterable<? extends GarsonStruct$GarsonServiceItem> iterable) {
        ensureItemsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.items_);
    }

    private void addItems(GarsonStruct$GarsonServiceItem garsonStruct$GarsonServiceItem) {
        garsonStruct$GarsonServiceItem.getClass();
        ensureItemsIsMutable();
        this.items_.add(garsonStruct$GarsonServiceItem);
    }

    private void clearBadge() {
        this.badge_ = getDefaultInstance().getBadge();
    }

    private void clearBadgeType() {
        this.badgeType_ = 0;
    }

    private void clearId() {
        this.id_ = 0;
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

    public static GarsonStruct$GarsonServicesCategory getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static GarsonStruct$GarsonServicesCategory parseDelimitedFrom(InputStream inputStream) {
        return (GarsonStruct$GarsonServicesCategory) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GarsonStruct$GarsonServicesCategory parseFrom(ByteBuffer byteBuffer) {
        return (GarsonStruct$GarsonServicesCategory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeItems(int i) {
        ensureItemsIsMutable();
        this.items_.remove(i);
    }

    private void setBadge(String str) {
        str.getClass();
        this.badge_ = str;
    }

    private void setBadgeBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.badge_ = abstractC2383g.f0();
    }

    private void setBadgeType(EnumC12823fE2 enumC12823fE2) {
        this.badgeType_ = enumC12823fE2.getNumber();
    }

    private void setBadgeTypeValue(int i) {
        this.badgeType_ = i;
    }

    private void setId(int i) {
        this.id_ = i;
    }

    private void setItems(int i, GarsonStruct$GarsonServiceItem garsonStruct$GarsonServiceItem) {
        garsonStruct$GarsonServiceItem.getClass();
        ensureItemsIsMutable();
        this.items_.set(i, garsonStruct$GarsonServiceItem);
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
        switch (AbstractC1850e0.a[gVar.ordinal()]) {
            case 1:
                return new GarsonStruct$GarsonServicesCategory();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0001\u0000\u0001\u0004\u0002Ȉ\u0003\f\u0004Ȉ\u0005\u001b", new Object[]{"id_", "title_", "badgeType_", "badge_", "items_", GarsonStruct$GarsonServiceItem.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (GarsonStruct$GarsonServicesCategory.class) {
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

    public String getBadge() {
        return this.badge_;
    }

    public AbstractC2383g getBadgeBytes() {
        return AbstractC2383g.N(this.badge_);
    }

    public EnumC12823fE2 getBadgeType() {
        EnumC12823fE2 enumC12823fE2J = EnumC12823fE2.j(this.badgeType_);
        return enumC12823fE2J == null ? EnumC12823fE2.UNRECOGNIZED : enumC12823fE2J;
    }

    public int getBadgeTypeValue() {
        return this.badgeType_;
    }

    public int getId() {
        return this.id_;
    }

    public GarsonStruct$GarsonServiceItem getItems(int i) {
        return (GarsonStruct$GarsonServiceItem) this.items_.get(i);
    }

    public int getItemsCount() {
        return this.items_.size();
    }

    public List<GarsonStruct$GarsonServiceItem> getItemsList() {
        return this.items_;
    }

    public InterfaceC24212yE2 getItemsOrBuilder(int i) {
        return (InterfaceC24212yE2) this.items_.get(i);
    }

    public List<? extends InterfaceC24212yE2> getItemsOrBuilderList() {
        return this.items_;
    }

    public String getTitle() {
        return this.title_;
    }

    public AbstractC2383g getTitleBytes() {
        return AbstractC2383g.N(this.title_);
    }

    public static a newBuilder(GarsonStruct$GarsonServicesCategory garsonStruct$GarsonServicesCategory) {
        return (a) DEFAULT_INSTANCE.createBuilder(garsonStruct$GarsonServicesCategory);
    }

    public static GarsonStruct$GarsonServicesCategory parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (GarsonStruct$GarsonServicesCategory) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GarsonStruct$GarsonServicesCategory parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (GarsonStruct$GarsonServicesCategory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static GarsonStruct$GarsonServicesCategory parseFrom(AbstractC2383g abstractC2383g) {
        return (GarsonStruct$GarsonServicesCategory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addItems(int i, GarsonStruct$GarsonServiceItem garsonStruct$GarsonServiceItem) {
        garsonStruct$GarsonServiceItem.getClass();
        ensureItemsIsMutable();
        this.items_.add(i, garsonStruct$GarsonServiceItem);
    }

    public static GarsonStruct$GarsonServicesCategory parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (GarsonStruct$GarsonServicesCategory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static GarsonStruct$GarsonServicesCategory parseFrom(byte[] bArr) {
        return (GarsonStruct$GarsonServicesCategory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GarsonStruct$GarsonServicesCategory parseFrom(byte[] bArr, C2394s c2394s) {
        return (GarsonStruct$GarsonServicesCategory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static GarsonStruct$GarsonServicesCategory parseFrom(InputStream inputStream) {
        return (GarsonStruct$GarsonServicesCategory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GarsonStruct$GarsonServicesCategory parseFrom(InputStream inputStream, C2394s c2394s) {
        return (GarsonStruct$GarsonServicesCategory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GarsonStruct$GarsonServicesCategory parseFrom(AbstractC2384h abstractC2384h) {
        return (GarsonStruct$GarsonServicesCategory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static GarsonStruct$GarsonServicesCategory parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (GarsonStruct$GarsonServicesCategory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
