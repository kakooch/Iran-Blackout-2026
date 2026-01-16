package ai.bale.proto;

import ai.bale.proto.GarsonStruct$GarsonNavigation;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC12823fE2;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class GarsonStruct$GarsonExtraServicesSection extends GeneratedMessageLite implements U64 {
    public static final int BADGE_TYPE_FIELD_NUMBER = 4;
    public static final int BUTTON_NAVIGATION_FIELD_NUMBER = 2;
    public static final int BUTTON_TEXT_FIELD_NUMBER = 3;
    private static final GarsonStruct$GarsonExtraServicesSection DEFAULT_INSTANCE;
    public static final int ITEMS_FIELD_NUMBER = 5;
    private static volatile KW4 PARSER = null;
    public static final int TITLE_FIELD_NUMBER = 1;
    private int badgeType_;
    private int bitField0_;
    private GarsonStruct$GarsonNavigation buttonNavigation_;
    private String title_ = "";
    private String buttonText_ = "";
    private B.j items_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(GarsonStruct$GarsonExtraServicesSection.DEFAULT_INSTANCE);
        }
    }

    static {
        GarsonStruct$GarsonExtraServicesSection garsonStruct$GarsonExtraServicesSection = new GarsonStruct$GarsonExtraServicesSection();
        DEFAULT_INSTANCE = garsonStruct$GarsonExtraServicesSection;
        GeneratedMessageLite.registerDefaultInstance(GarsonStruct$GarsonExtraServicesSection.class, garsonStruct$GarsonExtraServicesSection);
    }

    private GarsonStruct$GarsonExtraServicesSection() {
    }

    private void addAllItems(Iterable<? extends GarsonStruct$GarsonItem> iterable) {
        ensureItemsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.items_);
    }

    private void addItems(GarsonStruct$GarsonItem garsonStruct$GarsonItem) {
        garsonStruct$GarsonItem.getClass();
        ensureItemsIsMutable();
        this.items_.add(garsonStruct$GarsonItem);
    }

    private void clearBadgeType() {
        this.badgeType_ = 0;
    }

    private void clearButtonNavigation() {
        this.buttonNavigation_ = null;
        this.bitField0_ &= -2;
    }

    private void clearButtonText() {
        this.buttonText_ = getDefaultInstance().getButtonText();
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

    public static GarsonStruct$GarsonExtraServicesSection getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeButtonNavigation(GarsonStruct$GarsonNavigation garsonStruct$GarsonNavigation) {
        garsonStruct$GarsonNavigation.getClass();
        GarsonStruct$GarsonNavigation garsonStruct$GarsonNavigation2 = this.buttonNavigation_;
        if (garsonStruct$GarsonNavigation2 == null || garsonStruct$GarsonNavigation2 == GarsonStruct$GarsonNavigation.getDefaultInstance()) {
            this.buttonNavigation_ = garsonStruct$GarsonNavigation;
        } else {
            this.buttonNavigation_ = (GarsonStruct$GarsonNavigation) ((GarsonStruct$GarsonNavigation.a) GarsonStruct$GarsonNavigation.newBuilder(this.buttonNavigation_).v(garsonStruct$GarsonNavigation)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static GarsonStruct$GarsonExtraServicesSection parseDelimitedFrom(InputStream inputStream) {
        return (GarsonStruct$GarsonExtraServicesSection) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GarsonStruct$GarsonExtraServicesSection parseFrom(ByteBuffer byteBuffer) {
        return (GarsonStruct$GarsonExtraServicesSection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeItems(int i) {
        ensureItemsIsMutable();
        this.items_.remove(i);
    }

    private void setBadgeType(EnumC12823fE2 enumC12823fE2) {
        this.badgeType_ = enumC12823fE2.getNumber();
    }

    private void setBadgeTypeValue(int i) {
        this.badgeType_ = i;
    }

    private void setButtonNavigation(GarsonStruct$GarsonNavigation garsonStruct$GarsonNavigation) {
        garsonStruct$GarsonNavigation.getClass();
        this.buttonNavigation_ = garsonStruct$GarsonNavigation;
        this.bitField0_ |= 1;
    }

    private void setButtonText(String str) {
        str.getClass();
        this.buttonText_ = str;
    }

    private void setButtonTextBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.buttonText_ = abstractC2383g.f0();
    }

    private void setItems(int i, GarsonStruct$GarsonItem garsonStruct$GarsonItem) {
        garsonStruct$GarsonItem.getClass();
        ensureItemsIsMutable();
        this.items_.set(i, garsonStruct$GarsonItem);
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
                return new GarsonStruct$GarsonExtraServicesSection();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001Ȉ\u0002ဉ\u0000\u0003Ȉ\u0004\f\u0005\u001b", new Object[]{"bitField0_", "title_", "buttonNavigation_", "buttonText_", "badgeType_", "items_", GarsonStruct$GarsonItem.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (GarsonStruct$GarsonExtraServicesSection.class) {
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

    public EnumC12823fE2 getBadgeType() {
        EnumC12823fE2 enumC12823fE2J = EnumC12823fE2.j(this.badgeType_);
        return enumC12823fE2J == null ? EnumC12823fE2.UNRECOGNIZED : enumC12823fE2J;
    }

    public int getBadgeTypeValue() {
        return this.badgeType_;
    }

    public GarsonStruct$GarsonNavigation getButtonNavigation() {
        GarsonStruct$GarsonNavigation garsonStruct$GarsonNavigation = this.buttonNavigation_;
        return garsonStruct$GarsonNavigation == null ? GarsonStruct$GarsonNavigation.getDefaultInstance() : garsonStruct$GarsonNavigation;
    }

    public String getButtonText() {
        return this.buttonText_;
    }

    public AbstractC2383g getButtonTextBytes() {
        return AbstractC2383g.N(this.buttonText_);
    }

    public GarsonStruct$GarsonItem getItems(int i) {
        return (GarsonStruct$GarsonItem) this.items_.get(i);
    }

    public int getItemsCount() {
        return this.items_.size();
    }

    public List<GarsonStruct$GarsonItem> getItemsList() {
        return this.items_;
    }

    public InterfaceC1856g0 getItemsOrBuilder(int i) {
        return (InterfaceC1856g0) this.items_.get(i);
    }

    public List<? extends InterfaceC1856g0> getItemsOrBuilderList() {
        return this.items_;
    }

    public String getTitle() {
        return this.title_;
    }

    public AbstractC2383g getTitleBytes() {
        return AbstractC2383g.N(this.title_);
    }

    public boolean hasButtonNavigation() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(GarsonStruct$GarsonExtraServicesSection garsonStruct$GarsonExtraServicesSection) {
        return (a) DEFAULT_INSTANCE.createBuilder(garsonStruct$GarsonExtraServicesSection);
    }

    public static GarsonStruct$GarsonExtraServicesSection parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (GarsonStruct$GarsonExtraServicesSection) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GarsonStruct$GarsonExtraServicesSection parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (GarsonStruct$GarsonExtraServicesSection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static GarsonStruct$GarsonExtraServicesSection parseFrom(AbstractC2383g abstractC2383g) {
        return (GarsonStruct$GarsonExtraServicesSection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addItems(int i, GarsonStruct$GarsonItem garsonStruct$GarsonItem) {
        garsonStruct$GarsonItem.getClass();
        ensureItemsIsMutable();
        this.items_.add(i, garsonStruct$GarsonItem);
    }

    public static GarsonStruct$GarsonExtraServicesSection parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (GarsonStruct$GarsonExtraServicesSection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static GarsonStruct$GarsonExtraServicesSection parseFrom(byte[] bArr) {
        return (GarsonStruct$GarsonExtraServicesSection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GarsonStruct$GarsonExtraServicesSection parseFrom(byte[] bArr, C2394s c2394s) {
        return (GarsonStruct$GarsonExtraServicesSection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static GarsonStruct$GarsonExtraServicesSection parseFrom(InputStream inputStream) {
        return (GarsonStruct$GarsonExtraServicesSection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GarsonStruct$GarsonExtraServicesSection parseFrom(InputStream inputStream, C2394s c2394s) {
        return (GarsonStruct$GarsonExtraServicesSection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GarsonStruct$GarsonExtraServicesSection parseFrom(AbstractC2384h abstractC2384h) {
        return (GarsonStruct$GarsonExtraServicesSection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static GarsonStruct$GarsonExtraServicesSection parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (GarsonStruct$GarsonExtraServicesSection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
