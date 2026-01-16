package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class TimcheOuterClass$RequestGetBotPage extends GeneratedMessageLite implements U64 {
    public static final int BOT_ID_FIELD_NUMBER = 1;
    private static final TimcheOuterClass$RequestGetBotPage DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private int botId_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(TimcheOuterClass$RequestGetBotPage.DEFAULT_INSTANCE);
        }
    }

    static {
        TimcheOuterClass$RequestGetBotPage timcheOuterClass$RequestGetBotPage = new TimcheOuterClass$RequestGetBotPage();
        DEFAULT_INSTANCE = timcheOuterClass$RequestGetBotPage;
        GeneratedMessageLite.registerDefaultInstance(TimcheOuterClass$RequestGetBotPage.class, timcheOuterClass$RequestGetBotPage);
    }

    private TimcheOuterClass$RequestGetBotPage() {
    }

    private void clearBotId() {
        this.botId_ = 0;
    }

    public static TimcheOuterClass$RequestGetBotPage getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static TimcheOuterClass$RequestGetBotPage parseDelimitedFrom(InputStream inputStream) {
        return (TimcheOuterClass$RequestGetBotPage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static TimcheOuterClass$RequestGetBotPage parseFrom(ByteBuffer byteBuffer) {
        return (TimcheOuterClass$RequestGetBotPage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setBotId(int i) {
        this.botId_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (i2.a[gVar.ordinal()]) {
            case 1:
                return new TimcheOuterClass$RequestGetBotPage();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0004", new Object[]{"botId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (TimcheOuterClass$RequestGetBotPage.class) {
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

    public static a newBuilder(TimcheOuterClass$RequestGetBotPage timcheOuterClass$RequestGetBotPage) {
        return (a) DEFAULT_INSTANCE.createBuilder(timcheOuterClass$RequestGetBotPage);
    }

    public static TimcheOuterClass$RequestGetBotPage parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (TimcheOuterClass$RequestGetBotPage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static TimcheOuterClass$RequestGetBotPage parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (TimcheOuterClass$RequestGetBotPage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static TimcheOuterClass$RequestGetBotPage parseFrom(AbstractC2383g abstractC2383g) {
        return (TimcheOuterClass$RequestGetBotPage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static TimcheOuterClass$RequestGetBotPage parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (TimcheOuterClass$RequestGetBotPage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static TimcheOuterClass$RequestGetBotPage parseFrom(byte[] bArr) {
        return (TimcheOuterClass$RequestGetBotPage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static TimcheOuterClass$RequestGetBotPage parseFrom(byte[] bArr, C2394s c2394s) {
        return (TimcheOuterClass$RequestGetBotPage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static TimcheOuterClass$RequestGetBotPage parseFrom(InputStream inputStream) {
        return (TimcheOuterClass$RequestGetBotPage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static TimcheOuterClass$RequestGetBotPage parseFrom(InputStream inputStream, C2394s c2394s) {
        return (TimcheOuterClass$RequestGetBotPage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static TimcheOuterClass$RequestGetBotPage parseFrom(AbstractC2384h abstractC2384h) {
        return (TimcheOuterClass$RequestGetBotPage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static TimcheOuterClass$RequestGetBotPage parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (TimcheOuterClass$RequestGetBotPage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
