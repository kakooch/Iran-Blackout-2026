package ai.bale.proto;

import ai.bale.proto.GarsonStruct$GarsonBannersSection;
import ai.bale.proto.GarsonStruct$GarsonBotsVitrineSection;
import ai.bale.proto.GarsonStruct$GarsonCustomItems;
import ai.bale.proto.GarsonStruct$GarsonExtraServicesSection;
import ai.bale.proto.GarsonStruct$GarsonKnownSection;
import ai.bale.proto.GarsonStruct$GarsonShortcutsSection;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC23032wE2;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class GarsonStruct$GarsonSection extends GeneratedMessageLite implements InterfaceC1859h0 {
    public static final int BANNERS_FIELD_NUMBER = 5;
    public static final int BOTS_VITRINE_FIELD_NUMBER = 6;
    public static final int CUSTOM_SERVICES_FIELD_NUMBER = 4;
    private static final GarsonStruct$GarsonSection DEFAULT_INSTANCE;
    public static final int EXTRA_FIELD_NUMBER = 7;
    public static final int KNOWN_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int SECTION_ID_FIELD_NUMBER = 8;
    public static final int SHORTCUTS_FIELD_NUMBER = 3;
    public static final int TYPE_FIELD_NUMBER = 1;
    private int sectionCase_ = 0;
    private int sectionId_;
    private Object section_;
    private int type_;

    public static final class a extends GeneratedMessageLite.b implements InterfaceC1859h0 {
        private a() {
            super(GarsonStruct$GarsonSection.DEFAULT_INSTANCE);
        }
    }

    public enum b {
        KNOWN(2),
        SHORTCUTS(3),
        CUSTOM_SERVICES(4),
        BANNERS(5),
        BOTS_VITRINE(6),
        EXTRA(7),
        SECTION_NOT_SET(0);

        private final int a;

        b(int i2) {
            this.a = i2;
        }

        public static b j(int i2) {
            if (i2 == 0) {
                return SECTION_NOT_SET;
            }
            switch (i2) {
                case 2:
                    return KNOWN;
                case 3:
                    return SHORTCUTS;
                case 4:
                    return CUSTOM_SERVICES;
                case 5:
                    return BANNERS;
                case 6:
                    return BOTS_VITRINE;
                case 7:
                    return EXTRA;
                default:
                    return null;
            }
        }
    }

    static {
        GarsonStruct$GarsonSection garsonStruct$GarsonSection = new GarsonStruct$GarsonSection();
        DEFAULT_INSTANCE = garsonStruct$GarsonSection;
        GeneratedMessageLite.registerDefaultInstance(GarsonStruct$GarsonSection.class, garsonStruct$GarsonSection);
    }

    private GarsonStruct$GarsonSection() {
    }

    private void clearBanners() {
        if (this.sectionCase_ == 5) {
            this.sectionCase_ = 0;
            this.section_ = null;
        }
    }

    private void clearBotsVitrine() {
        if (this.sectionCase_ == 6) {
            this.sectionCase_ = 0;
            this.section_ = null;
        }
    }

    private void clearCustomServices() {
        if (this.sectionCase_ == 4) {
            this.sectionCase_ = 0;
            this.section_ = null;
        }
    }

    private void clearExtra() {
        if (this.sectionCase_ == 7) {
            this.sectionCase_ = 0;
            this.section_ = null;
        }
    }

    private void clearKnown() {
        if (this.sectionCase_ == 2) {
            this.sectionCase_ = 0;
            this.section_ = null;
        }
    }

    private void clearSection() {
        this.sectionCase_ = 0;
        this.section_ = null;
    }

    private void clearSectionId() {
        this.sectionId_ = 0;
    }

    private void clearShortcuts() {
        if (this.sectionCase_ == 3) {
            this.sectionCase_ = 0;
            this.section_ = null;
        }
    }

    private void clearType() {
        this.type_ = 0;
    }

    public static GarsonStruct$GarsonSection getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeBanners(GarsonStruct$GarsonBannersSection garsonStruct$GarsonBannersSection) {
        garsonStruct$GarsonBannersSection.getClass();
        if (this.sectionCase_ != 5 || this.section_ == GarsonStruct$GarsonBannersSection.getDefaultInstance()) {
            this.section_ = garsonStruct$GarsonBannersSection;
        } else {
            this.section_ = ((GarsonStruct$GarsonBannersSection.a) GarsonStruct$GarsonBannersSection.newBuilder((GarsonStruct$GarsonBannersSection) this.section_).v(garsonStruct$GarsonBannersSection)).j();
        }
        this.sectionCase_ = 5;
    }

    private void mergeBotsVitrine(GarsonStruct$GarsonBotsVitrineSection garsonStruct$GarsonBotsVitrineSection) {
        garsonStruct$GarsonBotsVitrineSection.getClass();
        if (this.sectionCase_ != 6 || this.section_ == GarsonStruct$GarsonBotsVitrineSection.getDefaultInstance()) {
            this.section_ = garsonStruct$GarsonBotsVitrineSection;
        } else {
            this.section_ = ((GarsonStruct$GarsonBotsVitrineSection.a) GarsonStruct$GarsonBotsVitrineSection.newBuilder((GarsonStruct$GarsonBotsVitrineSection) this.section_).v(garsonStruct$GarsonBotsVitrineSection)).j();
        }
        this.sectionCase_ = 6;
    }

    private void mergeCustomServices(GarsonStruct$GarsonCustomItems garsonStruct$GarsonCustomItems) {
        garsonStruct$GarsonCustomItems.getClass();
        if (this.sectionCase_ != 4 || this.section_ == GarsonStruct$GarsonCustomItems.getDefaultInstance()) {
            this.section_ = garsonStruct$GarsonCustomItems;
        } else {
            this.section_ = ((GarsonStruct$GarsonCustomItems.a) GarsonStruct$GarsonCustomItems.newBuilder((GarsonStruct$GarsonCustomItems) this.section_).v(garsonStruct$GarsonCustomItems)).j();
        }
        this.sectionCase_ = 4;
    }

    private void mergeExtra(GarsonStruct$GarsonExtraServicesSection garsonStruct$GarsonExtraServicesSection) {
        garsonStruct$GarsonExtraServicesSection.getClass();
        if (this.sectionCase_ != 7 || this.section_ == GarsonStruct$GarsonExtraServicesSection.getDefaultInstance()) {
            this.section_ = garsonStruct$GarsonExtraServicesSection;
        } else {
            this.section_ = ((GarsonStruct$GarsonExtraServicesSection.a) GarsonStruct$GarsonExtraServicesSection.newBuilder((GarsonStruct$GarsonExtraServicesSection) this.section_).v(garsonStruct$GarsonExtraServicesSection)).j();
        }
        this.sectionCase_ = 7;
    }

    private void mergeKnown(GarsonStruct$GarsonKnownSection garsonStruct$GarsonKnownSection) {
        garsonStruct$GarsonKnownSection.getClass();
        if (this.sectionCase_ != 2 || this.section_ == GarsonStruct$GarsonKnownSection.getDefaultInstance()) {
            this.section_ = garsonStruct$GarsonKnownSection;
        } else {
            this.section_ = ((GarsonStruct$GarsonKnownSection.a) GarsonStruct$GarsonKnownSection.newBuilder((GarsonStruct$GarsonKnownSection) this.section_).v(garsonStruct$GarsonKnownSection)).j();
        }
        this.sectionCase_ = 2;
    }

    private void mergeShortcuts(GarsonStruct$GarsonShortcutsSection garsonStruct$GarsonShortcutsSection) {
        garsonStruct$GarsonShortcutsSection.getClass();
        if (this.sectionCase_ != 3 || this.section_ == GarsonStruct$GarsonShortcutsSection.getDefaultInstance()) {
            this.section_ = garsonStruct$GarsonShortcutsSection;
        } else {
            this.section_ = ((GarsonStruct$GarsonShortcutsSection.a) GarsonStruct$GarsonShortcutsSection.newBuilder((GarsonStruct$GarsonShortcutsSection) this.section_).v(garsonStruct$GarsonShortcutsSection)).j();
        }
        this.sectionCase_ = 3;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static GarsonStruct$GarsonSection parseDelimitedFrom(InputStream inputStream) {
        return (GarsonStruct$GarsonSection) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GarsonStruct$GarsonSection parseFrom(ByteBuffer byteBuffer) {
        return (GarsonStruct$GarsonSection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setBanners(GarsonStruct$GarsonBannersSection garsonStruct$GarsonBannersSection) {
        garsonStruct$GarsonBannersSection.getClass();
        this.section_ = garsonStruct$GarsonBannersSection;
        this.sectionCase_ = 5;
    }

    private void setBotsVitrine(GarsonStruct$GarsonBotsVitrineSection garsonStruct$GarsonBotsVitrineSection) {
        garsonStruct$GarsonBotsVitrineSection.getClass();
        this.section_ = garsonStruct$GarsonBotsVitrineSection;
        this.sectionCase_ = 6;
    }

    private void setCustomServices(GarsonStruct$GarsonCustomItems garsonStruct$GarsonCustomItems) {
        garsonStruct$GarsonCustomItems.getClass();
        this.section_ = garsonStruct$GarsonCustomItems;
        this.sectionCase_ = 4;
    }

    private void setExtra(GarsonStruct$GarsonExtraServicesSection garsonStruct$GarsonExtraServicesSection) {
        garsonStruct$GarsonExtraServicesSection.getClass();
        this.section_ = garsonStruct$GarsonExtraServicesSection;
        this.sectionCase_ = 7;
    }

    private void setKnown(GarsonStruct$GarsonKnownSection garsonStruct$GarsonKnownSection) {
        garsonStruct$GarsonKnownSection.getClass();
        this.section_ = garsonStruct$GarsonKnownSection;
        this.sectionCase_ = 2;
    }

    private void setSectionId(int i) {
        this.sectionId_ = i;
    }

    private void setShortcuts(GarsonStruct$GarsonShortcutsSection garsonStruct$GarsonShortcutsSection) {
        garsonStruct$GarsonShortcutsSection.getClass();
        this.section_ = garsonStruct$GarsonShortcutsSection;
        this.sectionCase_ = 3;
    }

    private void setType(EnumC23032wE2 enumC23032wE2) {
        this.type_ = enumC23032wE2.getNumber();
    }

    private void setTypeValue(int i) {
        this.type_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1850e0.a[gVar.ordinal()]) {
            case 1:
                return new GarsonStruct$GarsonSection();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\b\u0001\u0000\u0001\b\b\u0000\u0000\u0000\u0001\f\u0002<\u0000\u0003<\u0000\u0004<\u0000\u0005<\u0000\u0006<\u0000\u0007<\u0000\b\u0004", new Object[]{"section_", "sectionCase_", "type_", GarsonStruct$GarsonKnownSection.class, GarsonStruct$GarsonShortcutsSection.class, GarsonStruct$GarsonCustomItems.class, GarsonStruct$GarsonBannersSection.class, GarsonStruct$GarsonBotsVitrineSection.class, GarsonStruct$GarsonExtraServicesSection.class, "sectionId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (GarsonStruct$GarsonSection.class) {
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

    public GarsonStruct$GarsonBannersSection getBanners() {
        return this.sectionCase_ == 5 ? (GarsonStruct$GarsonBannersSection) this.section_ : GarsonStruct$GarsonBannersSection.getDefaultInstance();
    }

    public GarsonStruct$GarsonBotsVitrineSection getBotsVitrine() {
        return this.sectionCase_ == 6 ? (GarsonStruct$GarsonBotsVitrineSection) this.section_ : GarsonStruct$GarsonBotsVitrineSection.getDefaultInstance();
    }

    public GarsonStruct$GarsonCustomItems getCustomServices() {
        return this.sectionCase_ == 4 ? (GarsonStruct$GarsonCustomItems) this.section_ : GarsonStruct$GarsonCustomItems.getDefaultInstance();
    }

    public GarsonStruct$GarsonExtraServicesSection getExtra() {
        return this.sectionCase_ == 7 ? (GarsonStruct$GarsonExtraServicesSection) this.section_ : GarsonStruct$GarsonExtraServicesSection.getDefaultInstance();
    }

    public GarsonStruct$GarsonKnownSection getKnown() {
        return this.sectionCase_ == 2 ? (GarsonStruct$GarsonKnownSection) this.section_ : GarsonStruct$GarsonKnownSection.getDefaultInstance();
    }

    public b getSectionCase() {
        return b.j(this.sectionCase_);
    }

    public int getSectionId() {
        return this.sectionId_;
    }

    public GarsonStruct$GarsonShortcutsSection getShortcuts() {
        return this.sectionCase_ == 3 ? (GarsonStruct$GarsonShortcutsSection) this.section_ : GarsonStruct$GarsonShortcutsSection.getDefaultInstance();
    }

    public EnumC23032wE2 getType() {
        EnumC23032wE2 enumC23032wE2J = EnumC23032wE2.j(this.type_);
        return enumC23032wE2J == null ? EnumC23032wE2.UNRECOGNIZED : enumC23032wE2J;
    }

    public int getTypeValue() {
        return this.type_;
    }

    public boolean hasBanners() {
        return this.sectionCase_ == 5;
    }

    public boolean hasBotsVitrine() {
        return this.sectionCase_ == 6;
    }

    public boolean hasCustomServices() {
        return this.sectionCase_ == 4;
    }

    public boolean hasExtra() {
        return this.sectionCase_ == 7;
    }

    public boolean hasKnown() {
        return this.sectionCase_ == 2;
    }

    public boolean hasShortcuts() {
        return this.sectionCase_ == 3;
    }

    public static a newBuilder(GarsonStruct$GarsonSection garsonStruct$GarsonSection) {
        return (a) DEFAULT_INSTANCE.createBuilder(garsonStruct$GarsonSection);
    }

    public static GarsonStruct$GarsonSection parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (GarsonStruct$GarsonSection) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GarsonStruct$GarsonSection parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (GarsonStruct$GarsonSection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static GarsonStruct$GarsonSection parseFrom(AbstractC2383g abstractC2383g) {
        return (GarsonStruct$GarsonSection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static GarsonStruct$GarsonSection parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (GarsonStruct$GarsonSection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static GarsonStruct$GarsonSection parseFrom(byte[] bArr) {
        return (GarsonStruct$GarsonSection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GarsonStruct$GarsonSection parseFrom(byte[] bArr, C2394s c2394s) {
        return (GarsonStruct$GarsonSection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static GarsonStruct$GarsonSection parseFrom(InputStream inputStream) {
        return (GarsonStruct$GarsonSection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GarsonStruct$GarsonSection parseFrom(InputStream inputStream, C2394s c2394s) {
        return (GarsonStruct$GarsonSection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GarsonStruct$GarsonSection parseFrom(AbstractC2384h abstractC2384h) {
        return (GarsonStruct$GarsonSection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static GarsonStruct$GarsonSection parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (GarsonStruct$GarsonSection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
