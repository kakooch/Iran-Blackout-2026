package ai.bale.proto;

import ai.bale.proto.AppzarStruct$BotMenuButton;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class AppzarOuterClass$ResponseGetMenuButton extends GeneratedMessageLite implements U64 {
    private static final AppzarOuterClass$ResponseGetMenuButton DEFAULT_INSTANCE;
    public static final int MENU_BUTTON_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private AppzarStruct$BotMenuButton menuButton_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(AppzarOuterClass$ResponseGetMenuButton.DEFAULT_INSTANCE);
        }
    }

    static {
        AppzarOuterClass$ResponseGetMenuButton appzarOuterClass$ResponseGetMenuButton = new AppzarOuterClass$ResponseGetMenuButton();
        DEFAULT_INSTANCE = appzarOuterClass$ResponseGetMenuButton;
        GeneratedMessageLite.registerDefaultInstance(AppzarOuterClass$ResponseGetMenuButton.class, appzarOuterClass$ResponseGetMenuButton);
    }

    private AppzarOuterClass$ResponseGetMenuButton() {
    }

    private void clearMenuButton() {
        this.menuButton_ = null;
        this.bitField0_ &= -2;
    }

    public static AppzarOuterClass$ResponseGetMenuButton getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeMenuButton(AppzarStruct$BotMenuButton appzarStruct$BotMenuButton) {
        appzarStruct$BotMenuButton.getClass();
        AppzarStruct$BotMenuButton appzarStruct$BotMenuButton2 = this.menuButton_;
        if (appzarStruct$BotMenuButton2 == null || appzarStruct$BotMenuButton2 == AppzarStruct$BotMenuButton.getDefaultInstance()) {
            this.menuButton_ = appzarStruct$BotMenuButton;
        } else {
            this.menuButton_ = (AppzarStruct$BotMenuButton) ((AppzarStruct$BotMenuButton.a) AppzarStruct$BotMenuButton.newBuilder(this.menuButton_).v(appzarStruct$BotMenuButton)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AppzarOuterClass$ResponseGetMenuButton parseDelimitedFrom(InputStream inputStream) {
        return (AppzarOuterClass$ResponseGetMenuButton) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AppzarOuterClass$ResponseGetMenuButton parseFrom(ByteBuffer byteBuffer) {
        return (AppzarOuterClass$ResponseGetMenuButton) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setMenuButton(AppzarStruct$BotMenuButton appzarStruct$BotMenuButton) {
        appzarStruct$BotMenuButton.getClass();
        this.menuButton_ = appzarStruct$BotMenuButton;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1855g.a[gVar.ordinal()]) {
            case 1:
                return new AppzarOuterClass$ResponseGetMenuButton();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "menuButton_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AppzarOuterClass$ResponseGetMenuButton.class) {
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

    public AppzarStruct$BotMenuButton getMenuButton() {
        AppzarStruct$BotMenuButton appzarStruct$BotMenuButton = this.menuButton_;
        return appzarStruct$BotMenuButton == null ? AppzarStruct$BotMenuButton.getDefaultInstance() : appzarStruct$BotMenuButton;
    }

    public boolean hasMenuButton() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(AppzarOuterClass$ResponseGetMenuButton appzarOuterClass$ResponseGetMenuButton) {
        return (a) DEFAULT_INSTANCE.createBuilder(appzarOuterClass$ResponseGetMenuButton);
    }

    public static AppzarOuterClass$ResponseGetMenuButton parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AppzarOuterClass$ResponseGetMenuButton) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AppzarOuterClass$ResponseGetMenuButton parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AppzarOuterClass$ResponseGetMenuButton) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AppzarOuterClass$ResponseGetMenuButton parseFrom(AbstractC2383g abstractC2383g) {
        return (AppzarOuterClass$ResponseGetMenuButton) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AppzarOuterClass$ResponseGetMenuButton parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AppzarOuterClass$ResponseGetMenuButton) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AppzarOuterClass$ResponseGetMenuButton parseFrom(byte[] bArr) {
        return (AppzarOuterClass$ResponseGetMenuButton) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AppzarOuterClass$ResponseGetMenuButton parseFrom(byte[] bArr, C2394s c2394s) {
        return (AppzarOuterClass$ResponseGetMenuButton) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AppzarOuterClass$ResponseGetMenuButton parseFrom(InputStream inputStream) {
        return (AppzarOuterClass$ResponseGetMenuButton) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AppzarOuterClass$ResponseGetMenuButton parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AppzarOuterClass$ResponseGetMenuButton) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AppzarOuterClass$ResponseGetMenuButton parseFrom(AbstractC2384h abstractC2384h) {
        return (AppzarOuterClass$ResponseGetMenuButton) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AppzarOuterClass$ResponseGetMenuButton parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AppzarOuterClass$ResponseGetMenuButton) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
