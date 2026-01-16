package ai.bale.proto;

import ai.bale.proto.AppzarStruct$DirectLinkMiniAppParams;
import ai.bale.proto.AppzarStruct$KeyboardButtonMiniAppParams;
import ai.bale.proto.AppzarStruct$MainMiniAppParams;
import ai.bale.proto.AppzarStruct$MenuButtonMiniAppParams;
import ai.bale.proto.AppzarStruct$MiniAppThemeParams;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.CG;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class AppzarOuterClass$RequestGetMiniAppUrl extends GeneratedMessageLite implements U64 {
    public static final int BOT_USER_ID_FIELD_NUMBER = 1;
    private static final AppzarOuterClass$RequestGetMiniAppUrl DEFAULT_INSTANCE;
    public static final int DIRECT_LINK_FIELD_NUMBER = 7;
    public static final int KEYBOARD_BUTTON_FIELD_NUMBER = 6;
    public static final int MAIN_FIELD_NUMBER = 4;
    public static final int MENU_BUTTON_FIELD_NUMBER = 5;
    private static volatile KW4 PARSER = null;
    public static final int SCREEN_MODE_FIELD_NUMBER = 2;
    public static final int THEME_PARAMS_FIELD_NUMBER = 3;
    private int bitField0_;
    private int botUserId_;
    private int paramsCase_ = 0;
    private Object params_;
    private int screenMode_;
    private AppzarStruct$MiniAppThemeParams themeParams_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(int i) {
            q();
            ((AppzarOuterClass$RequestGetMiniAppUrl) this.b).setBotUserId(i);
            return this;
        }

        public a B(AppzarStruct$DirectLinkMiniAppParams appzarStruct$DirectLinkMiniAppParams) {
            q();
            ((AppzarOuterClass$RequestGetMiniAppUrl) this.b).setDirectLink(appzarStruct$DirectLinkMiniAppParams);
            return this;
        }

        public a C(AppzarStruct$KeyboardButtonMiniAppParams appzarStruct$KeyboardButtonMiniAppParams) {
            q();
            ((AppzarOuterClass$RequestGetMiniAppUrl) this.b).setKeyboardButton(appzarStruct$KeyboardButtonMiniAppParams);
            return this;
        }

        public a D(AppzarStruct$MainMiniAppParams appzarStruct$MainMiniAppParams) {
            q();
            ((AppzarOuterClass$RequestGetMiniAppUrl) this.b).setMain(appzarStruct$MainMiniAppParams);
            return this;
        }

        public a E(AppzarStruct$MenuButtonMiniAppParams appzarStruct$MenuButtonMiniAppParams) {
            q();
            ((AppzarOuterClass$RequestGetMiniAppUrl) this.b).setMenuButton(appzarStruct$MenuButtonMiniAppParams);
            return this;
        }

        public a F(CG cg) {
            q();
            ((AppzarOuterClass$RequestGetMiniAppUrl) this.b).setScreenMode(cg);
            return this;
        }

        public a G(AppzarStruct$MiniAppThemeParams appzarStruct$MiniAppThemeParams) {
            q();
            ((AppzarOuterClass$RequestGetMiniAppUrl) this.b).setThemeParams(appzarStruct$MiniAppThemeParams);
            return this;
        }

        private a() {
            super(AppzarOuterClass$RequestGetMiniAppUrl.DEFAULT_INSTANCE);
        }
    }

    public enum b {
        MAIN(4),
        MENU_BUTTON(5),
        KEYBOARD_BUTTON(6),
        DIRECT_LINK(7),
        PARAMS_NOT_SET(0);

        private final int a;

        b(int i) {
            this.a = i;
        }

        public static b j(int i) {
            if (i == 0) {
                return PARAMS_NOT_SET;
            }
            if (i == 4) {
                return MAIN;
            }
            if (i == 5) {
                return MENU_BUTTON;
            }
            if (i == 6) {
                return KEYBOARD_BUTTON;
            }
            if (i != 7) {
                return null;
            }
            return DIRECT_LINK;
        }
    }

    static {
        AppzarOuterClass$RequestGetMiniAppUrl appzarOuterClass$RequestGetMiniAppUrl = new AppzarOuterClass$RequestGetMiniAppUrl();
        DEFAULT_INSTANCE = appzarOuterClass$RequestGetMiniAppUrl;
        GeneratedMessageLite.registerDefaultInstance(AppzarOuterClass$RequestGetMiniAppUrl.class, appzarOuterClass$RequestGetMiniAppUrl);
    }

    private AppzarOuterClass$RequestGetMiniAppUrl() {
    }

    private void clearBotUserId() {
        this.botUserId_ = 0;
    }

    private void clearDirectLink() {
        if (this.paramsCase_ == 7) {
            this.paramsCase_ = 0;
            this.params_ = null;
        }
    }

    private void clearKeyboardButton() {
        if (this.paramsCase_ == 6) {
            this.paramsCase_ = 0;
            this.params_ = null;
        }
    }

    private void clearMain() {
        if (this.paramsCase_ == 4) {
            this.paramsCase_ = 0;
            this.params_ = null;
        }
    }

    private void clearMenuButton() {
        if (this.paramsCase_ == 5) {
            this.paramsCase_ = 0;
            this.params_ = null;
        }
    }

    private void clearParams() {
        this.paramsCase_ = 0;
        this.params_ = null;
    }

    private void clearScreenMode() {
        this.screenMode_ = 0;
    }

    private void clearThemeParams() {
        this.themeParams_ = null;
        this.bitField0_ &= -2;
    }

    public static AppzarOuterClass$RequestGetMiniAppUrl getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeDirectLink(AppzarStruct$DirectLinkMiniAppParams appzarStruct$DirectLinkMiniAppParams) {
        appzarStruct$DirectLinkMiniAppParams.getClass();
        if (this.paramsCase_ != 7 || this.params_ == AppzarStruct$DirectLinkMiniAppParams.getDefaultInstance()) {
            this.params_ = appzarStruct$DirectLinkMiniAppParams;
        } else {
            this.params_ = ((AppzarStruct$DirectLinkMiniAppParams.a) AppzarStruct$DirectLinkMiniAppParams.newBuilder((AppzarStruct$DirectLinkMiniAppParams) this.params_).v(appzarStruct$DirectLinkMiniAppParams)).j();
        }
        this.paramsCase_ = 7;
    }

    private void mergeKeyboardButton(AppzarStruct$KeyboardButtonMiniAppParams appzarStruct$KeyboardButtonMiniAppParams) {
        appzarStruct$KeyboardButtonMiniAppParams.getClass();
        if (this.paramsCase_ != 6 || this.params_ == AppzarStruct$KeyboardButtonMiniAppParams.getDefaultInstance()) {
            this.params_ = appzarStruct$KeyboardButtonMiniAppParams;
        } else {
            this.params_ = ((AppzarStruct$KeyboardButtonMiniAppParams.a) AppzarStruct$KeyboardButtonMiniAppParams.newBuilder((AppzarStruct$KeyboardButtonMiniAppParams) this.params_).v(appzarStruct$KeyboardButtonMiniAppParams)).j();
        }
        this.paramsCase_ = 6;
    }

    private void mergeMain(AppzarStruct$MainMiniAppParams appzarStruct$MainMiniAppParams) {
        appzarStruct$MainMiniAppParams.getClass();
        if (this.paramsCase_ != 4 || this.params_ == AppzarStruct$MainMiniAppParams.getDefaultInstance()) {
            this.params_ = appzarStruct$MainMiniAppParams;
        } else {
            this.params_ = ((AppzarStruct$MainMiniAppParams.a) AppzarStruct$MainMiniAppParams.newBuilder((AppzarStruct$MainMiniAppParams) this.params_).v(appzarStruct$MainMiniAppParams)).j();
        }
        this.paramsCase_ = 4;
    }

    private void mergeMenuButton(AppzarStruct$MenuButtonMiniAppParams appzarStruct$MenuButtonMiniAppParams) {
        appzarStruct$MenuButtonMiniAppParams.getClass();
        if (this.paramsCase_ != 5 || this.params_ == AppzarStruct$MenuButtonMiniAppParams.getDefaultInstance()) {
            this.params_ = appzarStruct$MenuButtonMiniAppParams;
        } else {
            this.params_ = ((AppzarStruct$MenuButtonMiniAppParams.a) AppzarStruct$MenuButtonMiniAppParams.newBuilder((AppzarStruct$MenuButtonMiniAppParams) this.params_).v(appzarStruct$MenuButtonMiniAppParams)).j();
        }
        this.paramsCase_ = 5;
    }

    private void mergeThemeParams(AppzarStruct$MiniAppThemeParams appzarStruct$MiniAppThemeParams) {
        appzarStruct$MiniAppThemeParams.getClass();
        AppzarStruct$MiniAppThemeParams appzarStruct$MiniAppThemeParams2 = this.themeParams_;
        if (appzarStruct$MiniAppThemeParams2 == null || appzarStruct$MiniAppThemeParams2 == AppzarStruct$MiniAppThemeParams.getDefaultInstance()) {
            this.themeParams_ = appzarStruct$MiniAppThemeParams;
        } else {
            this.themeParams_ = (AppzarStruct$MiniAppThemeParams) ((AppzarStruct$MiniAppThemeParams.a) AppzarStruct$MiniAppThemeParams.newBuilder(this.themeParams_).v(appzarStruct$MiniAppThemeParams)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AppzarOuterClass$RequestGetMiniAppUrl parseDelimitedFrom(InputStream inputStream) {
        return (AppzarOuterClass$RequestGetMiniAppUrl) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AppzarOuterClass$RequestGetMiniAppUrl parseFrom(ByteBuffer byteBuffer) {
        return (AppzarOuterClass$RequestGetMiniAppUrl) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBotUserId(int i) {
        this.botUserId_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDirectLink(AppzarStruct$DirectLinkMiniAppParams appzarStruct$DirectLinkMiniAppParams) {
        appzarStruct$DirectLinkMiniAppParams.getClass();
        this.params_ = appzarStruct$DirectLinkMiniAppParams;
        this.paramsCase_ = 7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setKeyboardButton(AppzarStruct$KeyboardButtonMiniAppParams appzarStruct$KeyboardButtonMiniAppParams) {
        appzarStruct$KeyboardButtonMiniAppParams.getClass();
        this.params_ = appzarStruct$KeyboardButtonMiniAppParams;
        this.paramsCase_ = 6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMain(AppzarStruct$MainMiniAppParams appzarStruct$MainMiniAppParams) {
        appzarStruct$MainMiniAppParams.getClass();
        this.params_ = appzarStruct$MainMiniAppParams;
        this.paramsCase_ = 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMenuButton(AppzarStruct$MenuButtonMiniAppParams appzarStruct$MenuButtonMiniAppParams) {
        appzarStruct$MenuButtonMiniAppParams.getClass();
        this.params_ = appzarStruct$MenuButtonMiniAppParams;
        this.paramsCase_ = 5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setScreenMode(CG cg) {
        this.screenMode_ = cg.getNumber();
    }

    private void setScreenModeValue(int i) {
        this.screenMode_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setThemeParams(AppzarStruct$MiniAppThemeParams appzarStruct$MiniAppThemeParams) {
        appzarStruct$MiniAppThemeParams.getClass();
        this.themeParams_ = appzarStruct$MiniAppThemeParams;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1855g.a[gVar.ordinal()]) {
            case 1:
                return new AppzarOuterClass$RequestGetMiniAppUrl();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0007\u0001\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001\u0004\u0002\f\u0003ဉ\u0000\u0004<\u0000\u0005<\u0000\u0006<\u0000\u0007<\u0000", new Object[]{"params_", "paramsCase_", "bitField0_", "botUserId_", "screenMode_", "themeParams_", AppzarStruct$MainMiniAppParams.class, AppzarStruct$MenuButtonMiniAppParams.class, AppzarStruct$KeyboardButtonMiniAppParams.class, AppzarStruct$DirectLinkMiniAppParams.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AppzarOuterClass$RequestGetMiniAppUrl.class) {
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

    public int getBotUserId() {
        return this.botUserId_;
    }

    public AppzarStruct$DirectLinkMiniAppParams getDirectLink() {
        return this.paramsCase_ == 7 ? (AppzarStruct$DirectLinkMiniAppParams) this.params_ : AppzarStruct$DirectLinkMiniAppParams.getDefaultInstance();
    }

    public AppzarStruct$KeyboardButtonMiniAppParams getKeyboardButton() {
        return this.paramsCase_ == 6 ? (AppzarStruct$KeyboardButtonMiniAppParams) this.params_ : AppzarStruct$KeyboardButtonMiniAppParams.getDefaultInstance();
    }

    public AppzarStruct$MainMiniAppParams getMain() {
        return this.paramsCase_ == 4 ? (AppzarStruct$MainMiniAppParams) this.params_ : AppzarStruct$MainMiniAppParams.getDefaultInstance();
    }

    public AppzarStruct$MenuButtonMiniAppParams getMenuButton() {
        return this.paramsCase_ == 5 ? (AppzarStruct$MenuButtonMiniAppParams) this.params_ : AppzarStruct$MenuButtonMiniAppParams.getDefaultInstance();
    }

    public b getParamsCase() {
        return b.j(this.paramsCase_);
    }

    public CG getScreenMode() {
        CG cgJ = CG.j(this.screenMode_);
        return cgJ == null ? CG.UNRECOGNIZED : cgJ;
    }

    public int getScreenModeValue() {
        return this.screenMode_;
    }

    public AppzarStruct$MiniAppThemeParams getThemeParams() {
        AppzarStruct$MiniAppThemeParams appzarStruct$MiniAppThemeParams = this.themeParams_;
        return appzarStruct$MiniAppThemeParams == null ? AppzarStruct$MiniAppThemeParams.getDefaultInstance() : appzarStruct$MiniAppThemeParams;
    }

    public boolean hasDirectLink() {
        return this.paramsCase_ == 7;
    }

    public boolean hasKeyboardButton() {
        return this.paramsCase_ == 6;
    }

    public boolean hasMain() {
        return this.paramsCase_ == 4;
    }

    public boolean hasMenuButton() {
        return this.paramsCase_ == 5;
    }

    public boolean hasThemeParams() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(AppzarOuterClass$RequestGetMiniAppUrl appzarOuterClass$RequestGetMiniAppUrl) {
        return (a) DEFAULT_INSTANCE.createBuilder(appzarOuterClass$RequestGetMiniAppUrl);
    }

    public static AppzarOuterClass$RequestGetMiniAppUrl parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AppzarOuterClass$RequestGetMiniAppUrl) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AppzarOuterClass$RequestGetMiniAppUrl parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AppzarOuterClass$RequestGetMiniAppUrl) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AppzarOuterClass$RequestGetMiniAppUrl parseFrom(AbstractC2383g abstractC2383g) {
        return (AppzarOuterClass$RequestGetMiniAppUrl) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AppzarOuterClass$RequestGetMiniAppUrl parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AppzarOuterClass$RequestGetMiniAppUrl) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AppzarOuterClass$RequestGetMiniAppUrl parseFrom(byte[] bArr) {
        return (AppzarOuterClass$RequestGetMiniAppUrl) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AppzarOuterClass$RequestGetMiniAppUrl parseFrom(byte[] bArr, C2394s c2394s) {
        return (AppzarOuterClass$RequestGetMiniAppUrl) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AppzarOuterClass$RequestGetMiniAppUrl parseFrom(InputStream inputStream) {
        return (AppzarOuterClass$RequestGetMiniAppUrl) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AppzarOuterClass$RequestGetMiniAppUrl parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AppzarOuterClass$RequestGetMiniAppUrl) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AppzarOuterClass$RequestGetMiniAppUrl parseFrom(AbstractC2384h abstractC2384h) {
        return (AppzarOuterClass$RequestGetMiniAppUrl) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AppzarOuterClass$RequestGetMiniAppUrl parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AppzarOuterClass$RequestGetMiniAppUrl) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
