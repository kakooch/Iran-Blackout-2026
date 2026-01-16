package ai.bale.proto;

import ai.bale.proto.GarsonStruct$GarsonNavigation;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.DE2;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class GarsonStruct$GarsonShortcut extends GeneratedMessageLite implements DE2 {
    public static final int BG_COLOR_FIELD_NUMBER = 4;
    public static final int DARK_BG_COLOR_FIELD_NUMBER = 6;
    private static final GarsonStruct$GarsonShortcut DEFAULT_INSTANCE;
    public static final int ICON_FIELD_NUMBER = 3;
    public static final int NAVIGATION_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int SHORTCUT_ID_FIELD_NUMBER = 5;
    public static final int TITLE_FIELD_NUMBER = 2;
    private int bitField0_;
    private GarsonStruct$GarsonNavigation navigation_;
    private int shortcutId_;
    private String title_ = "";
    private String icon_ = "";
    private String bgColor_ = "";
    private String darkBgColor_ = "";

    public static final class a extends GeneratedMessageLite.b implements DE2 {
        private a() {
            super(GarsonStruct$GarsonShortcut.DEFAULT_INSTANCE);
        }
    }

    static {
        GarsonStruct$GarsonShortcut garsonStruct$GarsonShortcut = new GarsonStruct$GarsonShortcut();
        DEFAULT_INSTANCE = garsonStruct$GarsonShortcut;
        GeneratedMessageLite.registerDefaultInstance(GarsonStruct$GarsonShortcut.class, garsonStruct$GarsonShortcut);
    }

    private GarsonStruct$GarsonShortcut() {
    }

    private void clearBgColor() {
        this.bgColor_ = getDefaultInstance().getBgColor();
    }

    private void clearDarkBgColor() {
        this.darkBgColor_ = getDefaultInstance().getDarkBgColor();
    }

    private void clearIcon() {
        this.icon_ = getDefaultInstance().getIcon();
    }

    private void clearNavigation() {
        this.navigation_ = null;
        this.bitField0_ &= -2;
    }

    private void clearShortcutId() {
        this.shortcutId_ = 0;
    }

    private void clearTitle() {
        this.title_ = getDefaultInstance().getTitle();
    }

    public static GarsonStruct$GarsonShortcut getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeNavigation(GarsonStruct$GarsonNavigation garsonStruct$GarsonNavigation) {
        garsonStruct$GarsonNavigation.getClass();
        GarsonStruct$GarsonNavigation garsonStruct$GarsonNavigation2 = this.navigation_;
        if (garsonStruct$GarsonNavigation2 == null || garsonStruct$GarsonNavigation2 == GarsonStruct$GarsonNavigation.getDefaultInstance()) {
            this.navigation_ = garsonStruct$GarsonNavigation;
        } else {
            this.navigation_ = (GarsonStruct$GarsonNavigation) ((GarsonStruct$GarsonNavigation.a) GarsonStruct$GarsonNavigation.newBuilder(this.navigation_).v(garsonStruct$GarsonNavigation)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static GarsonStruct$GarsonShortcut parseDelimitedFrom(InputStream inputStream) {
        return (GarsonStruct$GarsonShortcut) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GarsonStruct$GarsonShortcut parseFrom(ByteBuffer byteBuffer) {
        return (GarsonStruct$GarsonShortcut) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setBgColor(String str) {
        str.getClass();
        this.bgColor_ = str;
    }

    private void setBgColorBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.bgColor_ = abstractC2383g.f0();
    }

    private void setDarkBgColor(String str) {
        str.getClass();
        this.darkBgColor_ = str;
    }

    private void setDarkBgColorBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.darkBgColor_ = abstractC2383g.f0();
    }

    private void setIcon(String str) {
        str.getClass();
        this.icon_ = str;
    }

    private void setIconBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.icon_ = abstractC2383g.f0();
    }

    private void setNavigation(GarsonStruct$GarsonNavigation garsonStruct$GarsonNavigation) {
        garsonStruct$GarsonNavigation.getClass();
        this.navigation_ = garsonStruct$GarsonNavigation;
        this.bitField0_ |= 1;
    }

    private void setShortcutId(int i) {
        this.shortcutId_ = i;
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
                return new GarsonStruct$GarsonShortcut();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဉ\u0000\u0002Ȉ\u0003Ȉ\u0004Ȉ\u0005\u0004\u0006Ȉ", new Object[]{"bitField0_", "navigation_", "title_", "icon_", "bgColor_", "shortcutId_", "darkBgColor_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (GarsonStruct$GarsonShortcut.class) {
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

    public String getBgColor() {
        return this.bgColor_;
    }

    public AbstractC2383g getBgColorBytes() {
        return AbstractC2383g.N(this.bgColor_);
    }

    public String getDarkBgColor() {
        return this.darkBgColor_;
    }

    public AbstractC2383g getDarkBgColorBytes() {
        return AbstractC2383g.N(this.darkBgColor_);
    }

    public String getIcon() {
        return this.icon_;
    }

    public AbstractC2383g getIconBytes() {
        return AbstractC2383g.N(this.icon_);
    }

    public GarsonStruct$GarsonNavigation getNavigation() {
        GarsonStruct$GarsonNavigation garsonStruct$GarsonNavigation = this.navigation_;
        return garsonStruct$GarsonNavigation == null ? GarsonStruct$GarsonNavigation.getDefaultInstance() : garsonStruct$GarsonNavigation;
    }

    public int getShortcutId() {
        return this.shortcutId_;
    }

    public String getTitle() {
        return this.title_;
    }

    public AbstractC2383g getTitleBytes() {
        return AbstractC2383g.N(this.title_);
    }

    public boolean hasNavigation() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(GarsonStruct$GarsonShortcut garsonStruct$GarsonShortcut) {
        return (a) DEFAULT_INSTANCE.createBuilder(garsonStruct$GarsonShortcut);
    }

    public static GarsonStruct$GarsonShortcut parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (GarsonStruct$GarsonShortcut) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GarsonStruct$GarsonShortcut parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (GarsonStruct$GarsonShortcut) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static GarsonStruct$GarsonShortcut parseFrom(AbstractC2383g abstractC2383g) {
        return (GarsonStruct$GarsonShortcut) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static GarsonStruct$GarsonShortcut parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (GarsonStruct$GarsonShortcut) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static GarsonStruct$GarsonShortcut parseFrom(byte[] bArr) {
        return (GarsonStruct$GarsonShortcut) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GarsonStruct$GarsonShortcut parseFrom(byte[] bArr, C2394s c2394s) {
        return (GarsonStruct$GarsonShortcut) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static GarsonStruct$GarsonShortcut parseFrom(InputStream inputStream) {
        return (GarsonStruct$GarsonShortcut) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GarsonStruct$GarsonShortcut parseFrom(InputStream inputStream, C2394s c2394s) {
        return (GarsonStruct$GarsonShortcut) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GarsonStruct$GarsonShortcut parseFrom(AbstractC2384h abstractC2384h) {
        return (GarsonStruct$GarsonShortcut) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static GarsonStruct$GarsonShortcut parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (GarsonStruct$GarsonShortcut) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
