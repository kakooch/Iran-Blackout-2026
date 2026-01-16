package ai.bale.proto;

import ai.bale.proto.KetfStruct$BotInlineMessageMediaAuto;
import ai.bale.proto.KetfStruct$BotInlineMessageText;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class KetfStruct$BotInlineMessage extends GeneratedMessageLite implements U64 {
    public static final int BOT_INLINE_MESSAGE_MEDIA_AUTO_FIELD_NUMBER = 2;
    public static final int BOT_INLINE_MESSAGE_TEXT_FIELD_NUMBER = 1;
    private static final KetfStruct$BotInlineMessage DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private int eCase_ = 0;
    private Object e_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(KetfStruct$BotInlineMessage.DEFAULT_INSTANCE);
        }
    }

    public enum b {
        BOT_INLINE_MESSAGE_TEXT(1),
        BOT_INLINE_MESSAGE_MEDIA_AUTO(2),
        E_NOT_SET(0);

        private final int a;

        b(int i) {
            this.a = i;
        }

        public static b j(int i) {
            if (i == 0) {
                return E_NOT_SET;
            }
            if (i == 1) {
                return BOT_INLINE_MESSAGE_TEXT;
            }
            if (i != 2) {
                return null;
            }
            return BOT_INLINE_MESSAGE_MEDIA_AUTO;
        }
    }

    static {
        KetfStruct$BotInlineMessage ketfStruct$BotInlineMessage = new KetfStruct$BotInlineMessage();
        DEFAULT_INSTANCE = ketfStruct$BotInlineMessage;
        GeneratedMessageLite.registerDefaultInstance(KetfStruct$BotInlineMessage.class, ketfStruct$BotInlineMessage);
    }

    private KetfStruct$BotInlineMessage() {
    }

    private void clearBotInlineMessageMediaAuto() {
        if (this.eCase_ == 2) {
            this.eCase_ = 0;
            this.e_ = null;
        }
    }

    private void clearBotInlineMessageText() {
        if (this.eCase_ == 1) {
            this.eCase_ = 0;
            this.e_ = null;
        }
    }

    private void clearE() {
        this.eCase_ = 0;
        this.e_ = null;
    }

    public static KetfStruct$BotInlineMessage getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeBotInlineMessageMediaAuto(KetfStruct$BotInlineMessageMediaAuto ketfStruct$BotInlineMessageMediaAuto) {
        ketfStruct$BotInlineMessageMediaAuto.getClass();
        if (this.eCase_ != 2 || this.e_ == KetfStruct$BotInlineMessageMediaAuto.getDefaultInstance()) {
            this.e_ = ketfStruct$BotInlineMessageMediaAuto;
        } else {
            this.e_ = ((KetfStruct$BotInlineMessageMediaAuto.a) KetfStruct$BotInlineMessageMediaAuto.newBuilder((KetfStruct$BotInlineMessageMediaAuto) this.e_).v(ketfStruct$BotInlineMessageMediaAuto)).j();
        }
        this.eCase_ = 2;
    }

    private void mergeBotInlineMessageText(KetfStruct$BotInlineMessageText ketfStruct$BotInlineMessageText) {
        ketfStruct$BotInlineMessageText.getClass();
        if (this.eCase_ != 1 || this.e_ == KetfStruct$BotInlineMessageText.getDefaultInstance()) {
            this.e_ = ketfStruct$BotInlineMessageText;
        } else {
            this.e_ = ((KetfStruct$BotInlineMessageText.a) KetfStruct$BotInlineMessageText.newBuilder((KetfStruct$BotInlineMessageText) this.e_).v(ketfStruct$BotInlineMessageText)).j();
        }
        this.eCase_ = 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static KetfStruct$BotInlineMessage parseDelimitedFrom(InputStream inputStream) {
        return (KetfStruct$BotInlineMessage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KetfStruct$BotInlineMessage parseFrom(ByteBuffer byteBuffer) {
        return (KetfStruct$BotInlineMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setBotInlineMessageMediaAuto(KetfStruct$BotInlineMessageMediaAuto ketfStruct$BotInlineMessageMediaAuto) {
        ketfStruct$BotInlineMessageMediaAuto.getClass();
        this.e_ = ketfStruct$BotInlineMessageMediaAuto;
        this.eCase_ = 2;
    }

    private void setBotInlineMessageText(KetfStruct$BotInlineMessageText ketfStruct$BotInlineMessageText) {
        ketfStruct$BotInlineMessageText.getClass();
        this.e_ = ketfStruct$BotInlineMessageText;
        this.eCase_ = 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1891s0.a[gVar.ordinal()]) {
            case 1:
                return new KetfStruct$BotInlineMessage();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0001\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001<\u0000\u0002<\u0000", new Object[]{"e_", "eCase_", KetfStruct$BotInlineMessageText.class, KetfStruct$BotInlineMessageMediaAuto.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (KetfStruct$BotInlineMessage.class) {
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

    public KetfStruct$BotInlineMessageMediaAuto getBotInlineMessageMediaAuto() {
        return this.eCase_ == 2 ? (KetfStruct$BotInlineMessageMediaAuto) this.e_ : KetfStruct$BotInlineMessageMediaAuto.getDefaultInstance();
    }

    public KetfStruct$BotInlineMessageText getBotInlineMessageText() {
        return this.eCase_ == 1 ? (KetfStruct$BotInlineMessageText) this.e_ : KetfStruct$BotInlineMessageText.getDefaultInstance();
    }

    public b getECase() {
        return b.j(this.eCase_);
    }

    public boolean hasBotInlineMessageMediaAuto() {
        return this.eCase_ == 2;
    }

    public boolean hasBotInlineMessageText() {
        return this.eCase_ == 1;
    }

    public static a newBuilder(KetfStruct$BotInlineMessage ketfStruct$BotInlineMessage) {
        return (a) DEFAULT_INSTANCE.createBuilder(ketfStruct$BotInlineMessage);
    }

    public static KetfStruct$BotInlineMessage parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (KetfStruct$BotInlineMessage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KetfStruct$BotInlineMessage parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (KetfStruct$BotInlineMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static KetfStruct$BotInlineMessage parseFrom(AbstractC2383g abstractC2383g) {
        return (KetfStruct$BotInlineMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static KetfStruct$BotInlineMessage parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (KetfStruct$BotInlineMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static KetfStruct$BotInlineMessage parseFrom(byte[] bArr) {
        return (KetfStruct$BotInlineMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static KetfStruct$BotInlineMessage parseFrom(byte[] bArr, C2394s c2394s) {
        return (KetfStruct$BotInlineMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static KetfStruct$BotInlineMessage parseFrom(InputStream inputStream) {
        return (KetfStruct$BotInlineMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KetfStruct$BotInlineMessage parseFrom(InputStream inputStream, C2394s c2394s) {
        return (KetfStruct$BotInlineMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KetfStruct$BotInlineMessage parseFrom(AbstractC2384h abstractC2384h) {
        return (KetfStruct$BotInlineMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static KetfStruct$BotInlineMessage parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (KetfStruct$BotInlineMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
