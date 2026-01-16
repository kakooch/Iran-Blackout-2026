package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class AppzarOuterClass$RequestGetMenuButton extends GeneratedMessageLite implements U64 {
    public static final int BOT_USER_ID_FIELD_NUMBER = 1;
    private static final AppzarOuterClass$RequestGetMenuButton DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private int botUserId_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(int i) {
            q();
            ((AppzarOuterClass$RequestGetMenuButton) this.b).setBotUserId(i);
            return this;
        }

        private a() {
            super(AppzarOuterClass$RequestGetMenuButton.DEFAULT_INSTANCE);
        }
    }

    static {
        AppzarOuterClass$RequestGetMenuButton appzarOuterClass$RequestGetMenuButton = new AppzarOuterClass$RequestGetMenuButton();
        DEFAULT_INSTANCE = appzarOuterClass$RequestGetMenuButton;
        GeneratedMessageLite.registerDefaultInstance(AppzarOuterClass$RequestGetMenuButton.class, appzarOuterClass$RequestGetMenuButton);
    }

    private AppzarOuterClass$RequestGetMenuButton() {
    }

    private void clearBotUserId() {
        this.botUserId_ = 0;
    }

    public static AppzarOuterClass$RequestGetMenuButton getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AppzarOuterClass$RequestGetMenuButton parseDelimitedFrom(InputStream inputStream) {
        return (AppzarOuterClass$RequestGetMenuButton) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AppzarOuterClass$RequestGetMenuButton parseFrom(ByteBuffer byteBuffer) {
        return (AppzarOuterClass$RequestGetMenuButton) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBotUserId(int i) {
        this.botUserId_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1855g.a[gVar.ordinal()]) {
            case 1:
                return new AppzarOuterClass$RequestGetMenuButton();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0004", new Object[]{"botUserId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AppzarOuterClass$RequestGetMenuButton.class) {
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

    public static a newBuilder(AppzarOuterClass$RequestGetMenuButton appzarOuterClass$RequestGetMenuButton) {
        return (a) DEFAULT_INSTANCE.createBuilder(appzarOuterClass$RequestGetMenuButton);
    }

    public static AppzarOuterClass$RequestGetMenuButton parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AppzarOuterClass$RequestGetMenuButton) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AppzarOuterClass$RequestGetMenuButton parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AppzarOuterClass$RequestGetMenuButton) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AppzarOuterClass$RequestGetMenuButton parseFrom(AbstractC2383g abstractC2383g) {
        return (AppzarOuterClass$RequestGetMenuButton) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AppzarOuterClass$RequestGetMenuButton parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AppzarOuterClass$RequestGetMenuButton) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AppzarOuterClass$RequestGetMenuButton parseFrom(byte[] bArr) {
        return (AppzarOuterClass$RequestGetMenuButton) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AppzarOuterClass$RequestGetMenuButton parseFrom(byte[] bArr, C2394s c2394s) {
        return (AppzarOuterClass$RequestGetMenuButton) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AppzarOuterClass$RequestGetMenuButton parseFrom(InputStream inputStream) {
        return (AppzarOuterClass$RequestGetMenuButton) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AppzarOuterClass$RequestGetMenuButton parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AppzarOuterClass$RequestGetMenuButton) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AppzarOuterClass$RequestGetMenuButton parseFrom(AbstractC2384h abstractC2384h) {
        return (AppzarOuterClass$RequestGetMenuButton) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AppzarOuterClass$RequestGetMenuButton parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AppzarOuterClass$RequestGetMenuButton) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
