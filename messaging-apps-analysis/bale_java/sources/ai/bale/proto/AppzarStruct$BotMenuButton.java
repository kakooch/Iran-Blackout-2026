package ai.bale.proto;

import ai.bale.proto.AppzarStruct$CommandsButton;
import ai.bale.proto.AppzarStruct$MiniAppButton;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class AppzarStruct$BotMenuButton extends GeneratedMessageLite implements U64 {
    public static final int COMMANDS_FIELD_NUMBER = 1;
    private static final AppzarStruct$BotMenuButton DEFAULT_INSTANCE;
    public static final int MINI_APP_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER;
    private int buttonCase_ = 0;
    private Object button_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(AppzarStruct$BotMenuButton.DEFAULT_INSTANCE);
        }
    }

    public enum b {
        COMMANDS(1),
        MINI_APP(2),
        BUTTON_NOT_SET(0);

        private final int a;

        b(int i) {
            this.a = i;
        }

        public static b j(int i) {
            if (i == 0) {
                return BUTTON_NOT_SET;
            }
            if (i == 1) {
                return COMMANDS;
            }
            if (i != 2) {
                return null;
            }
            return MINI_APP;
        }
    }

    static {
        AppzarStruct$BotMenuButton appzarStruct$BotMenuButton = new AppzarStruct$BotMenuButton();
        DEFAULT_INSTANCE = appzarStruct$BotMenuButton;
        GeneratedMessageLite.registerDefaultInstance(AppzarStruct$BotMenuButton.class, appzarStruct$BotMenuButton);
    }

    private AppzarStruct$BotMenuButton() {
    }

    private void clearButton() {
        this.buttonCase_ = 0;
        this.button_ = null;
    }

    private void clearCommands() {
        if (this.buttonCase_ == 1) {
            this.buttonCase_ = 0;
            this.button_ = null;
        }
    }

    private void clearMiniApp() {
        if (this.buttonCase_ == 2) {
            this.buttonCase_ = 0;
            this.button_ = null;
        }
    }

    public static AppzarStruct$BotMenuButton getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeCommands(AppzarStruct$CommandsButton appzarStruct$CommandsButton) {
        appzarStruct$CommandsButton.getClass();
        if (this.buttonCase_ != 1 || this.button_ == AppzarStruct$CommandsButton.getDefaultInstance()) {
            this.button_ = appzarStruct$CommandsButton;
        } else {
            this.button_ = ((AppzarStruct$CommandsButton.a) AppzarStruct$CommandsButton.newBuilder((AppzarStruct$CommandsButton) this.button_).v(appzarStruct$CommandsButton)).j();
        }
        this.buttonCase_ = 1;
    }

    private void mergeMiniApp(AppzarStruct$MiniAppButton appzarStruct$MiniAppButton) {
        appzarStruct$MiniAppButton.getClass();
        if (this.buttonCase_ != 2 || this.button_ == AppzarStruct$MiniAppButton.getDefaultInstance()) {
            this.button_ = appzarStruct$MiniAppButton;
        } else {
            this.button_ = ((AppzarStruct$MiniAppButton.a) AppzarStruct$MiniAppButton.newBuilder((AppzarStruct$MiniAppButton) this.button_).v(appzarStruct$MiniAppButton)).j();
        }
        this.buttonCase_ = 2;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AppzarStruct$BotMenuButton parseDelimitedFrom(InputStream inputStream) {
        return (AppzarStruct$BotMenuButton) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AppzarStruct$BotMenuButton parseFrom(ByteBuffer byteBuffer) {
        return (AppzarStruct$BotMenuButton) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setCommands(AppzarStruct$CommandsButton appzarStruct$CommandsButton) {
        appzarStruct$CommandsButton.getClass();
        this.button_ = appzarStruct$CommandsButton;
        this.buttonCase_ = 1;
    }

    private void setMiniApp(AppzarStruct$MiniAppButton appzarStruct$MiniAppButton) {
        appzarStruct$MiniAppButton.getClass();
        this.button_ = appzarStruct$MiniAppButton;
        this.buttonCase_ = 2;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1858h.a[gVar.ordinal()]) {
            case 1:
                return new AppzarStruct$BotMenuButton();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0001\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001<\u0000\u0002<\u0000", new Object[]{"button_", "buttonCase_", AppzarStruct$CommandsButton.class, AppzarStruct$MiniAppButton.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AppzarStruct$BotMenuButton.class) {
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

    public b getButtonCase() {
        return b.j(this.buttonCase_);
    }

    public AppzarStruct$CommandsButton getCommands() {
        return this.buttonCase_ == 1 ? (AppzarStruct$CommandsButton) this.button_ : AppzarStruct$CommandsButton.getDefaultInstance();
    }

    public AppzarStruct$MiniAppButton getMiniApp() {
        return this.buttonCase_ == 2 ? (AppzarStruct$MiniAppButton) this.button_ : AppzarStruct$MiniAppButton.getDefaultInstance();
    }

    public boolean hasCommands() {
        return this.buttonCase_ == 1;
    }

    public boolean hasMiniApp() {
        return this.buttonCase_ == 2;
    }

    public static a newBuilder(AppzarStruct$BotMenuButton appzarStruct$BotMenuButton) {
        return (a) DEFAULT_INSTANCE.createBuilder(appzarStruct$BotMenuButton);
    }

    public static AppzarStruct$BotMenuButton parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AppzarStruct$BotMenuButton) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AppzarStruct$BotMenuButton parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AppzarStruct$BotMenuButton) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AppzarStruct$BotMenuButton parseFrom(AbstractC2383g abstractC2383g) {
        return (AppzarStruct$BotMenuButton) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AppzarStruct$BotMenuButton parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AppzarStruct$BotMenuButton) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AppzarStruct$BotMenuButton parseFrom(byte[] bArr) {
        return (AppzarStruct$BotMenuButton) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AppzarStruct$BotMenuButton parseFrom(byte[] bArr, C2394s c2394s) {
        return (AppzarStruct$BotMenuButton) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AppzarStruct$BotMenuButton parseFrom(InputStream inputStream) {
        return (AppzarStruct$BotMenuButton) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AppzarStruct$BotMenuButton parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AppzarStruct$BotMenuButton) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AppzarStruct$BotMenuButton parseFrom(AbstractC2384h abstractC2384h) {
        return (AppzarStruct$BotMenuButton) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AppzarStruct$BotMenuButton parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AppzarStruct$BotMenuButton) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
