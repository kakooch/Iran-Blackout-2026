package bale.smart_support.v1;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public final class SmartSupportOuterClass$RequestGetBotSubjects extends GeneratedMessageLite implements U64 {
    public static final int BOT_ID_FIELD_NUMBER = 1;
    private static final SmartSupportOuterClass$RequestGetBotSubjects DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private int botId_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(SmartSupportOuterClass$RequestGetBotSubjects.DEFAULT_INSTANCE);
        }
    }

    static {
        SmartSupportOuterClass$RequestGetBotSubjects smartSupportOuterClass$RequestGetBotSubjects = new SmartSupportOuterClass$RequestGetBotSubjects();
        DEFAULT_INSTANCE = smartSupportOuterClass$RequestGetBotSubjects;
        GeneratedMessageLite.registerDefaultInstance(SmartSupportOuterClass$RequestGetBotSubjects.class, smartSupportOuterClass$RequestGetBotSubjects);
    }

    private SmartSupportOuterClass$RequestGetBotSubjects() {
    }

    private void clearBotId() {
        this.botId_ = 0;
    }

    public static SmartSupportOuterClass$RequestGetBotSubjects getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SmartSupportOuterClass$RequestGetBotSubjects parseDelimitedFrom(InputStream inputStream) {
        return (SmartSupportOuterClass$RequestGetBotSubjects) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SmartSupportOuterClass$RequestGetBotSubjects parseFrom(ByteBuffer byteBuffer) {
        return (SmartSupportOuterClass$RequestGetBotSubjects) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setBotId(int i) {
        this.botId_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (b.a[gVar.ordinal()]) {
            case 1:
                return new SmartSupportOuterClass$RequestGetBotSubjects();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0004", new Object[]{"botId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SmartSupportOuterClass$RequestGetBotSubjects.class) {
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

    public static a newBuilder(SmartSupportOuterClass$RequestGetBotSubjects smartSupportOuterClass$RequestGetBotSubjects) {
        return (a) DEFAULT_INSTANCE.createBuilder(smartSupportOuterClass$RequestGetBotSubjects);
    }

    public static SmartSupportOuterClass$RequestGetBotSubjects parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SmartSupportOuterClass$RequestGetBotSubjects) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SmartSupportOuterClass$RequestGetBotSubjects parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SmartSupportOuterClass$RequestGetBotSubjects) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SmartSupportOuterClass$RequestGetBotSubjects parseFrom(AbstractC2383g abstractC2383g) {
        return (SmartSupportOuterClass$RequestGetBotSubjects) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static SmartSupportOuterClass$RequestGetBotSubjects parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SmartSupportOuterClass$RequestGetBotSubjects) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SmartSupportOuterClass$RequestGetBotSubjects parseFrom(byte[] bArr) {
        return (SmartSupportOuterClass$RequestGetBotSubjects) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SmartSupportOuterClass$RequestGetBotSubjects parseFrom(byte[] bArr, C2394s c2394s) {
        return (SmartSupportOuterClass$RequestGetBotSubjects) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SmartSupportOuterClass$RequestGetBotSubjects parseFrom(InputStream inputStream) {
        return (SmartSupportOuterClass$RequestGetBotSubjects) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SmartSupportOuterClass$RequestGetBotSubjects parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SmartSupportOuterClass$RequestGetBotSubjects) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SmartSupportOuterClass$RequestGetBotSubjects parseFrom(AbstractC2384h abstractC2384h) {
        return (SmartSupportOuterClass$RequestGetBotSubjects) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SmartSupportOuterClass$RequestGetBotSubjects parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SmartSupportOuterClass$RequestGetBotSubjects) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
