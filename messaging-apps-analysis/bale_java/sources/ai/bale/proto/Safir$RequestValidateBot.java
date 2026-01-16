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

/* loaded from: classes.dex */
public final class Safir$RequestValidateBot extends GeneratedMessageLite implements U64 {
    public static final int BOT_TOKE_FIELD_NUMBER = 1;
    private static final Safir$RequestValidateBot DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private String botToke_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Safir$RequestValidateBot.DEFAULT_INSTANCE);
        }
    }

    static {
        Safir$RequestValidateBot safir$RequestValidateBot = new Safir$RequestValidateBot();
        DEFAULT_INSTANCE = safir$RequestValidateBot;
        GeneratedMessageLite.registerDefaultInstance(Safir$RequestValidateBot.class, safir$RequestValidateBot);
    }

    private Safir$RequestValidateBot() {
    }

    private void clearBotToke() {
        this.botToke_ = getDefaultInstance().getBotToke();
    }

    public static Safir$RequestValidateBot getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Safir$RequestValidateBot parseDelimitedFrom(InputStream inputStream) {
        return (Safir$RequestValidateBot) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Safir$RequestValidateBot parseFrom(ByteBuffer byteBuffer) {
        return (Safir$RequestValidateBot) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setBotToke(String str) {
        str.getClass();
        this.botToke_ = str;
    }

    private void setBotTokeBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.botToke_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (D1.a[gVar.ordinal()]) {
            case 1:
                return new Safir$RequestValidateBot();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"botToke_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Safir$RequestValidateBot.class) {
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

    public String getBotToke() {
        return this.botToke_;
    }

    public AbstractC2383g getBotTokeBytes() {
        return AbstractC2383g.N(this.botToke_);
    }

    public static a newBuilder(Safir$RequestValidateBot safir$RequestValidateBot) {
        return (a) DEFAULT_INSTANCE.createBuilder(safir$RequestValidateBot);
    }

    public static Safir$RequestValidateBot parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Safir$RequestValidateBot) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Safir$RequestValidateBot parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Safir$RequestValidateBot) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Safir$RequestValidateBot parseFrom(AbstractC2383g abstractC2383g) {
        return (Safir$RequestValidateBot) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static Safir$RequestValidateBot parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Safir$RequestValidateBot) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Safir$RequestValidateBot parseFrom(byte[] bArr) {
        return (Safir$RequestValidateBot) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Safir$RequestValidateBot parseFrom(byte[] bArr, C2394s c2394s) {
        return (Safir$RequestValidateBot) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Safir$RequestValidateBot parseFrom(InputStream inputStream) {
        return (Safir$RequestValidateBot) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Safir$RequestValidateBot parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Safir$RequestValidateBot) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Safir$RequestValidateBot parseFrom(AbstractC2384h abstractC2384h) {
        return (Safir$RequestValidateBot) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Safir$RequestValidateBot parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Safir$RequestValidateBot) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
