package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.StringValue;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class AppzarStruct$MiniAppThemeParams extends GeneratedMessageLite implements U64 {
    public static final int ACCENT_TEXT_COLOR_FIELD_NUMBER = 9;
    public static final int BG_COLOR_FIELD_NUMBER = 1;
    public static final int BOTTOM_BAR_BG_COLOR_FIELD_NUMBER = 15;
    public static final int BUTTON_COLOR_FIELD_NUMBER = 6;
    public static final int BUTTON_TEXT_COLOR_FIELD_NUMBER = 7;
    private static final AppzarStruct$MiniAppThemeParams DEFAULT_INSTANCE;
    public static final int DESTRUCTIVE_TEXT_COLOR_FIELD_NUMBER = 14;
    public static final int HEADER_BG_COLOR_FIELD_NUMBER = 8;
    public static final int HINT_COLOR_FIELD_NUMBER = 4;
    public static final int LINK_COLOR_FIELD_NUMBER = 5;
    private static volatile KW4 PARSER = null;
    public static final int SECONDARY_BG_COLOR_FIELD_NUMBER = 2;
    public static final int SECTION_BG_COLOR_FIELD_NUMBER = 10;
    public static final int SECTION_HEADER_TEXT_COLOR_FIELD_NUMBER = 11;
    public static final int SECTION_SEPARATOR_COLOR_FIELD_NUMBER = 12;
    public static final int SUBTITLE_TEXT_COLOR_FIELD_NUMBER = 13;
    public static final int TEXT_COLOR_FIELD_NUMBER = 3;
    private StringValue accentTextColor_;
    private StringValue bgColor_;
    private int bitField0_;
    private StringValue bottomBarBgColor_;
    private StringValue buttonColor_;
    private StringValue buttonTextColor_;
    private StringValue destructiveTextColor_;
    private StringValue headerBgColor_;
    private StringValue hintColor_;
    private StringValue linkColor_;
    private StringValue secondaryBgColor_;
    private StringValue sectionBgColor_;
    private StringValue sectionHeaderTextColor_;
    private StringValue sectionSeparatorColor_;
    private StringValue subtitleTextColor_;
    private StringValue textColor_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(StringValue stringValue) {
            q();
            ((AppzarStruct$MiniAppThemeParams) this.b).setAccentTextColor(stringValue);
            return this;
        }

        public a B(StringValue stringValue) {
            q();
            ((AppzarStruct$MiniAppThemeParams) this.b).setBgColor(stringValue);
            return this;
        }

        public a C(StringValue stringValue) {
            q();
            ((AppzarStruct$MiniAppThemeParams) this.b).setBottomBarBgColor(stringValue);
            return this;
        }

        public a D(StringValue stringValue) {
            q();
            ((AppzarStruct$MiniAppThemeParams) this.b).setButtonColor(stringValue);
            return this;
        }

        public a E(StringValue stringValue) {
            q();
            ((AppzarStruct$MiniAppThemeParams) this.b).setButtonTextColor(stringValue);
            return this;
        }

        public a F(StringValue stringValue) {
            q();
            ((AppzarStruct$MiniAppThemeParams) this.b).setDestructiveTextColor(stringValue);
            return this;
        }

        public a G(StringValue stringValue) {
            q();
            ((AppzarStruct$MiniAppThemeParams) this.b).setHeaderBgColor(stringValue);
            return this;
        }

        public a H(StringValue stringValue) {
            q();
            ((AppzarStruct$MiniAppThemeParams) this.b).setHintColor(stringValue);
            return this;
        }

        public a I(StringValue stringValue) {
            q();
            ((AppzarStruct$MiniAppThemeParams) this.b).setLinkColor(stringValue);
            return this;
        }

        public a J(StringValue stringValue) {
            q();
            ((AppzarStruct$MiniAppThemeParams) this.b).setSecondaryBgColor(stringValue);
            return this;
        }

        public a K(StringValue stringValue) {
            q();
            ((AppzarStruct$MiniAppThemeParams) this.b).setSectionBgColor(stringValue);
            return this;
        }

        public a L(StringValue stringValue) {
            q();
            ((AppzarStruct$MiniAppThemeParams) this.b).setSectionHeaderTextColor(stringValue);
            return this;
        }

        public a M(StringValue stringValue) {
            q();
            ((AppzarStruct$MiniAppThemeParams) this.b).setSubtitleTextColor(stringValue);
            return this;
        }

        public a N(StringValue stringValue) {
            q();
            ((AppzarStruct$MiniAppThemeParams) this.b).setTextColor(stringValue);
            return this;
        }

        private a() {
            super(AppzarStruct$MiniAppThemeParams.DEFAULT_INSTANCE);
        }
    }

    static {
        AppzarStruct$MiniAppThemeParams appzarStruct$MiniAppThemeParams = new AppzarStruct$MiniAppThemeParams();
        DEFAULT_INSTANCE = appzarStruct$MiniAppThemeParams;
        GeneratedMessageLite.registerDefaultInstance(AppzarStruct$MiniAppThemeParams.class, appzarStruct$MiniAppThemeParams);
    }

    private AppzarStruct$MiniAppThemeParams() {
    }

    private void clearAccentTextColor() {
        this.accentTextColor_ = null;
        this.bitField0_ &= -257;
    }

    private void clearBgColor() {
        this.bgColor_ = null;
        this.bitField0_ &= -2;
    }

    private void clearBottomBarBgColor() {
        this.bottomBarBgColor_ = null;
        this.bitField0_ &= -16385;
    }

    private void clearButtonColor() {
        this.buttonColor_ = null;
        this.bitField0_ &= -33;
    }

    private void clearButtonTextColor() {
        this.buttonTextColor_ = null;
        this.bitField0_ &= -65;
    }

    private void clearDestructiveTextColor() {
        this.destructiveTextColor_ = null;
        this.bitField0_ &= -8193;
    }

    private void clearHeaderBgColor() {
        this.headerBgColor_ = null;
        this.bitField0_ &= -129;
    }

    private void clearHintColor() {
        this.hintColor_ = null;
        this.bitField0_ &= -9;
    }

    private void clearLinkColor() {
        this.linkColor_ = null;
        this.bitField0_ &= -17;
    }

    private void clearSecondaryBgColor() {
        this.secondaryBgColor_ = null;
        this.bitField0_ &= -3;
    }

    private void clearSectionBgColor() {
        this.sectionBgColor_ = null;
        this.bitField0_ &= -513;
    }

    private void clearSectionHeaderTextColor() {
        this.sectionHeaderTextColor_ = null;
        this.bitField0_ &= -1025;
    }

    private void clearSectionSeparatorColor() {
        this.sectionSeparatorColor_ = null;
        this.bitField0_ &= -2049;
    }

    private void clearSubtitleTextColor() {
        this.subtitleTextColor_ = null;
        this.bitField0_ &= -4097;
    }

    private void clearTextColor() {
        this.textColor_ = null;
        this.bitField0_ &= -5;
    }

    public static AppzarStruct$MiniAppThemeParams getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeAccentTextColor(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.accentTextColor_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.accentTextColor_ = stringValue;
        } else {
            this.accentTextColor_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.accentTextColor_).v(stringValue)).j();
        }
        this.bitField0_ |= 256;
    }

    private void mergeBgColor(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.bgColor_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.bgColor_ = stringValue;
        } else {
            this.bgColor_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.bgColor_).v(stringValue)).j();
        }
        this.bitField0_ |= 1;
    }

    private void mergeBottomBarBgColor(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.bottomBarBgColor_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.bottomBarBgColor_ = stringValue;
        } else {
            this.bottomBarBgColor_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.bottomBarBgColor_).v(stringValue)).j();
        }
        this.bitField0_ |= 16384;
    }

    private void mergeButtonColor(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.buttonColor_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.buttonColor_ = stringValue;
        } else {
            this.buttonColor_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.buttonColor_).v(stringValue)).j();
        }
        this.bitField0_ |= 32;
    }

    private void mergeButtonTextColor(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.buttonTextColor_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.buttonTextColor_ = stringValue;
        } else {
            this.buttonTextColor_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.buttonTextColor_).v(stringValue)).j();
        }
        this.bitField0_ |= 64;
    }

    private void mergeDestructiveTextColor(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.destructiveTextColor_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.destructiveTextColor_ = stringValue;
        } else {
            this.destructiveTextColor_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.destructiveTextColor_).v(stringValue)).j();
        }
        this.bitField0_ |= 8192;
    }

    private void mergeHeaderBgColor(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.headerBgColor_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.headerBgColor_ = stringValue;
        } else {
            this.headerBgColor_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.headerBgColor_).v(stringValue)).j();
        }
        this.bitField0_ |= 128;
    }

    private void mergeHintColor(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.hintColor_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.hintColor_ = stringValue;
        } else {
            this.hintColor_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.hintColor_).v(stringValue)).j();
        }
        this.bitField0_ |= 8;
    }

    private void mergeLinkColor(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.linkColor_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.linkColor_ = stringValue;
        } else {
            this.linkColor_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.linkColor_).v(stringValue)).j();
        }
        this.bitField0_ |= 16;
    }

    private void mergeSecondaryBgColor(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.secondaryBgColor_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.secondaryBgColor_ = stringValue;
        } else {
            this.secondaryBgColor_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.secondaryBgColor_).v(stringValue)).j();
        }
        this.bitField0_ |= 2;
    }

    private void mergeSectionBgColor(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.sectionBgColor_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.sectionBgColor_ = stringValue;
        } else {
            this.sectionBgColor_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.sectionBgColor_).v(stringValue)).j();
        }
        this.bitField0_ |= 512;
    }

    private void mergeSectionHeaderTextColor(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.sectionHeaderTextColor_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.sectionHeaderTextColor_ = stringValue;
        } else {
            this.sectionHeaderTextColor_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.sectionHeaderTextColor_).v(stringValue)).j();
        }
        this.bitField0_ |= 1024;
    }

    private void mergeSectionSeparatorColor(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.sectionSeparatorColor_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.sectionSeparatorColor_ = stringValue;
        } else {
            this.sectionSeparatorColor_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.sectionSeparatorColor_).v(stringValue)).j();
        }
        this.bitField0_ |= 2048;
    }

    private void mergeSubtitleTextColor(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.subtitleTextColor_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.subtitleTextColor_ = stringValue;
        } else {
            this.subtitleTextColor_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.subtitleTextColor_).v(stringValue)).j();
        }
        this.bitField0_ |= 4096;
    }

    private void mergeTextColor(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.textColor_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.textColor_ = stringValue;
        } else {
            this.textColor_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.textColor_).v(stringValue)).j();
        }
        this.bitField0_ |= 4;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AppzarStruct$MiniAppThemeParams parseDelimitedFrom(InputStream inputStream) {
        return (AppzarStruct$MiniAppThemeParams) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AppzarStruct$MiniAppThemeParams parseFrom(ByteBuffer byteBuffer) {
        return (AppzarStruct$MiniAppThemeParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAccentTextColor(StringValue stringValue) {
        stringValue.getClass();
        this.accentTextColor_ = stringValue;
        this.bitField0_ |= 256;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBgColor(StringValue stringValue) {
        stringValue.getClass();
        this.bgColor_ = stringValue;
        this.bitField0_ |= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBottomBarBgColor(StringValue stringValue) {
        stringValue.getClass();
        this.bottomBarBgColor_ = stringValue;
        this.bitField0_ |= 16384;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setButtonColor(StringValue stringValue) {
        stringValue.getClass();
        this.buttonColor_ = stringValue;
        this.bitField0_ |= 32;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setButtonTextColor(StringValue stringValue) {
        stringValue.getClass();
        this.buttonTextColor_ = stringValue;
        this.bitField0_ |= 64;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDestructiveTextColor(StringValue stringValue) {
        stringValue.getClass();
        this.destructiveTextColor_ = stringValue;
        this.bitField0_ |= 8192;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHeaderBgColor(StringValue stringValue) {
        stringValue.getClass();
        this.headerBgColor_ = stringValue;
        this.bitField0_ |= 128;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHintColor(StringValue stringValue) {
        stringValue.getClass();
        this.hintColor_ = stringValue;
        this.bitField0_ |= 8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLinkColor(StringValue stringValue) {
        stringValue.getClass();
        this.linkColor_ = stringValue;
        this.bitField0_ |= 16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSecondaryBgColor(StringValue stringValue) {
        stringValue.getClass();
        this.secondaryBgColor_ = stringValue;
        this.bitField0_ |= 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSectionBgColor(StringValue stringValue) {
        stringValue.getClass();
        this.sectionBgColor_ = stringValue;
        this.bitField0_ |= 512;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSectionHeaderTextColor(StringValue stringValue) {
        stringValue.getClass();
        this.sectionHeaderTextColor_ = stringValue;
        this.bitField0_ |= 1024;
    }

    private void setSectionSeparatorColor(StringValue stringValue) {
        stringValue.getClass();
        this.sectionSeparatorColor_ = stringValue;
        this.bitField0_ |= 2048;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSubtitleTextColor(StringValue stringValue) {
        stringValue.getClass();
        this.subtitleTextColor_ = stringValue;
        this.bitField0_ |= 4096;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTextColor(StringValue stringValue) {
        stringValue.getClass();
        this.textColor_ = stringValue;
        this.bitField0_ |= 4;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1858h.a[gVar.ordinal()]) {
            case 1:
                return new AppzarStruct$MiniAppThemeParams();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u000f\u0000\u0001\u0001\u000f\u000f\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ဉ\u0003\u0005ဉ\u0004\u0006ဉ\u0005\u0007ဉ\u0006\bဉ\u0007\tဉ\b\nဉ\t\u000bဉ\n\fဉ\u000b\rဉ\f\u000eဉ\r\u000fဉ\u000e", new Object[]{"bitField0_", "bgColor_", "secondaryBgColor_", "textColor_", "hintColor_", "linkColor_", "buttonColor_", "buttonTextColor_", "headerBgColor_", "accentTextColor_", "sectionBgColor_", "sectionHeaderTextColor_", "sectionSeparatorColor_", "subtitleTextColor_", "destructiveTextColor_", "bottomBarBgColor_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AppzarStruct$MiniAppThemeParams.class) {
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

    public StringValue getAccentTextColor() {
        StringValue stringValue = this.accentTextColor_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public StringValue getBgColor() {
        StringValue stringValue = this.bgColor_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public StringValue getBottomBarBgColor() {
        StringValue stringValue = this.bottomBarBgColor_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public StringValue getButtonColor() {
        StringValue stringValue = this.buttonColor_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public StringValue getButtonTextColor() {
        StringValue stringValue = this.buttonTextColor_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public StringValue getDestructiveTextColor() {
        StringValue stringValue = this.destructiveTextColor_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public StringValue getHeaderBgColor() {
        StringValue stringValue = this.headerBgColor_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public StringValue getHintColor() {
        StringValue stringValue = this.hintColor_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public StringValue getLinkColor() {
        StringValue stringValue = this.linkColor_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public StringValue getSecondaryBgColor() {
        StringValue stringValue = this.secondaryBgColor_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public StringValue getSectionBgColor() {
        StringValue stringValue = this.sectionBgColor_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public StringValue getSectionHeaderTextColor() {
        StringValue stringValue = this.sectionHeaderTextColor_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public StringValue getSectionSeparatorColor() {
        StringValue stringValue = this.sectionSeparatorColor_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public StringValue getSubtitleTextColor() {
        StringValue stringValue = this.subtitleTextColor_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public StringValue getTextColor() {
        StringValue stringValue = this.textColor_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public boolean hasAccentTextColor() {
        return (this.bitField0_ & 256) != 0;
    }

    public boolean hasBgColor() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasBottomBarBgColor() {
        return (this.bitField0_ & 16384) != 0;
    }

    public boolean hasButtonColor() {
        return (this.bitField0_ & 32) != 0;
    }

    public boolean hasButtonTextColor() {
        return (this.bitField0_ & 64) != 0;
    }

    public boolean hasDestructiveTextColor() {
        return (this.bitField0_ & 8192) != 0;
    }

    public boolean hasHeaderBgColor() {
        return (this.bitField0_ & 128) != 0;
    }

    public boolean hasHintColor() {
        return (this.bitField0_ & 8) != 0;
    }

    public boolean hasLinkColor() {
        return (this.bitField0_ & 16) != 0;
    }

    public boolean hasSecondaryBgColor() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasSectionBgColor() {
        return (this.bitField0_ & 512) != 0;
    }

    public boolean hasSectionHeaderTextColor() {
        return (this.bitField0_ & 1024) != 0;
    }

    public boolean hasSectionSeparatorColor() {
        return (this.bitField0_ & 2048) != 0;
    }

    public boolean hasSubtitleTextColor() {
        return (this.bitField0_ & 4096) != 0;
    }

    public boolean hasTextColor() {
        return (this.bitField0_ & 4) != 0;
    }

    public static a newBuilder(AppzarStruct$MiniAppThemeParams appzarStruct$MiniAppThemeParams) {
        return (a) DEFAULT_INSTANCE.createBuilder(appzarStruct$MiniAppThemeParams);
    }

    public static AppzarStruct$MiniAppThemeParams parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AppzarStruct$MiniAppThemeParams) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AppzarStruct$MiniAppThemeParams parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AppzarStruct$MiniAppThemeParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AppzarStruct$MiniAppThemeParams parseFrom(AbstractC2383g abstractC2383g) {
        return (AppzarStruct$MiniAppThemeParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AppzarStruct$MiniAppThemeParams parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AppzarStruct$MiniAppThemeParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AppzarStruct$MiniAppThemeParams parseFrom(byte[] bArr) {
        return (AppzarStruct$MiniAppThemeParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AppzarStruct$MiniAppThemeParams parseFrom(byte[] bArr, C2394s c2394s) {
        return (AppzarStruct$MiniAppThemeParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AppzarStruct$MiniAppThemeParams parseFrom(InputStream inputStream) {
        return (AppzarStruct$MiniAppThemeParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AppzarStruct$MiniAppThemeParams parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AppzarStruct$MiniAppThemeParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AppzarStruct$MiniAppThemeParams parseFrom(AbstractC2384h abstractC2384h) {
        return (AppzarStruct$MiniAppThemeParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AppzarStruct$MiniAppThemeParams parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AppzarStruct$MiniAppThemeParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
