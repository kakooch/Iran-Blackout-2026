package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class BusinessOuterClass$ResponseCreateBusinessBot extends GeneratedMessageLite implements U64 {
    public static final int BOT_ID_FIELD_NUMBER = 2;
    public static final int BOT_TOKEN_FIELD_NUMBER = 1;
    private static final BusinessOuterClass$ResponseCreateBusinessBot DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private int botId_;
    private String botToken_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(BusinessOuterClass$ResponseCreateBusinessBot.DEFAULT_INSTANCE);
        }
    }

    static {
        BusinessOuterClass$ResponseCreateBusinessBot businessOuterClass$ResponseCreateBusinessBot = new BusinessOuterClass$ResponseCreateBusinessBot();
        DEFAULT_INSTANCE = businessOuterClass$ResponseCreateBusinessBot;
        GeneratedMessageLite.registerDefaultInstance(BusinessOuterClass$ResponseCreateBusinessBot.class, businessOuterClass$ResponseCreateBusinessBot);
    }

    private BusinessOuterClass$ResponseCreateBusinessBot() {
    }

    private void clearBotId() {
        this.botId_ = 0;
    }

    private void clearBotToken() {
        this.botToken_ = getDefaultInstance().getBotToken();
    }

    public static BusinessOuterClass$ResponseCreateBusinessBot getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static BusinessOuterClass$ResponseCreateBusinessBot parseDelimitedFrom(InputStream inputStream) {
        return (BusinessOuterClass$ResponseCreateBusinessBot) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BusinessOuterClass$ResponseCreateBusinessBot parseFrom(ByteBuffer byteBuffer) {
        return (BusinessOuterClass$ResponseCreateBusinessBot) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setBotId(int i) {
        this.botId_ = i;
    }

    private void setBotToken(String str) {
        str.getClass();
        this.botToken_ = str;
    }

    private void setBotTokenBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.botToken_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1896u.a[gVar.ordinal()]) {
            case 1:
                return new BusinessOuterClass$ResponseCreateBusinessBot();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002\u0004", new Object[]{"botToken_", "botId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (BusinessOuterClass$ResponseCreateBusinessBot.class) {
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

    public int getBotId() {
        return this.botId_;
    }

    public String getBotToken() {
        return this.botToken_;
    }

    public AbstractC2383g getBotTokenBytes() {
        return AbstractC2383g.N(this.botToken_);
    }

    public static a newBuilder(BusinessOuterClass$ResponseCreateBusinessBot businessOuterClass$ResponseCreateBusinessBot) {
        return (a) DEFAULT_INSTANCE.createBuilder(businessOuterClass$ResponseCreateBusinessBot);
    }

    public static BusinessOuterClass$ResponseCreateBusinessBot parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (BusinessOuterClass$ResponseCreateBusinessBot) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BusinessOuterClass$ResponseCreateBusinessBot parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (BusinessOuterClass$ResponseCreateBusinessBot) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static BusinessOuterClass$ResponseCreateBusinessBot parseFrom(AbstractC2383g abstractC2383g) {
        return (BusinessOuterClass$ResponseCreateBusinessBot) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static BusinessOuterClass$ResponseCreateBusinessBot parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (BusinessOuterClass$ResponseCreateBusinessBot) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static BusinessOuterClass$ResponseCreateBusinessBot parseFrom(byte[] bArr) {
        return (BusinessOuterClass$ResponseCreateBusinessBot) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static BusinessOuterClass$ResponseCreateBusinessBot parseFrom(byte[] bArr, C2394s c2394s) {
        return (BusinessOuterClass$ResponseCreateBusinessBot) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static BusinessOuterClass$ResponseCreateBusinessBot parseFrom(InputStream inputStream) {
        return (BusinessOuterClass$ResponseCreateBusinessBot) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BusinessOuterClass$ResponseCreateBusinessBot parseFrom(InputStream inputStream, C2394s c2394s) {
        return (BusinessOuterClass$ResponseCreateBusinessBot) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BusinessOuterClass$ResponseCreateBusinessBot parseFrom(AbstractC2384h abstractC2384h) {
        return (BusinessOuterClass$ResponseCreateBusinessBot) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static BusinessOuterClass$ResponseCreateBusinessBot parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (BusinessOuterClass$ResponseCreateBusinessBot) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
