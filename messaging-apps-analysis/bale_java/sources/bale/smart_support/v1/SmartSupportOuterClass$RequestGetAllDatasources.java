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
public final class SmartSupportOuterClass$RequestGetAllDatasources extends GeneratedMessageLite implements U64 {
    public static final int BOT_ID_FIELD_NUMBER = 1;
    private static final SmartSupportOuterClass$RequestGetAllDatasources DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private int botId_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(SmartSupportOuterClass$RequestGetAllDatasources.DEFAULT_INSTANCE);
        }
    }

    static {
        SmartSupportOuterClass$RequestGetAllDatasources smartSupportOuterClass$RequestGetAllDatasources = new SmartSupportOuterClass$RequestGetAllDatasources();
        DEFAULT_INSTANCE = smartSupportOuterClass$RequestGetAllDatasources;
        GeneratedMessageLite.registerDefaultInstance(SmartSupportOuterClass$RequestGetAllDatasources.class, smartSupportOuterClass$RequestGetAllDatasources);
    }

    private SmartSupportOuterClass$RequestGetAllDatasources() {
    }

    private void clearBotId() {
        this.botId_ = 0;
    }

    public static SmartSupportOuterClass$RequestGetAllDatasources getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SmartSupportOuterClass$RequestGetAllDatasources parseDelimitedFrom(InputStream inputStream) {
        return (SmartSupportOuterClass$RequestGetAllDatasources) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SmartSupportOuterClass$RequestGetAllDatasources parseFrom(ByteBuffer byteBuffer) {
        return (SmartSupportOuterClass$RequestGetAllDatasources) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
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
                return new SmartSupportOuterClass$RequestGetAllDatasources();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0004", new Object[]{"botId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SmartSupportOuterClass$RequestGetAllDatasources.class) {
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

    public static a newBuilder(SmartSupportOuterClass$RequestGetAllDatasources smartSupportOuterClass$RequestGetAllDatasources) {
        return (a) DEFAULT_INSTANCE.createBuilder(smartSupportOuterClass$RequestGetAllDatasources);
    }

    public static SmartSupportOuterClass$RequestGetAllDatasources parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SmartSupportOuterClass$RequestGetAllDatasources) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SmartSupportOuterClass$RequestGetAllDatasources parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SmartSupportOuterClass$RequestGetAllDatasources) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SmartSupportOuterClass$RequestGetAllDatasources parseFrom(AbstractC2383g abstractC2383g) {
        return (SmartSupportOuterClass$RequestGetAllDatasources) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static SmartSupportOuterClass$RequestGetAllDatasources parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SmartSupportOuterClass$RequestGetAllDatasources) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SmartSupportOuterClass$RequestGetAllDatasources parseFrom(byte[] bArr) {
        return (SmartSupportOuterClass$RequestGetAllDatasources) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SmartSupportOuterClass$RequestGetAllDatasources parseFrom(byte[] bArr, C2394s c2394s) {
        return (SmartSupportOuterClass$RequestGetAllDatasources) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SmartSupportOuterClass$RequestGetAllDatasources parseFrom(InputStream inputStream) {
        return (SmartSupportOuterClass$RequestGetAllDatasources) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SmartSupportOuterClass$RequestGetAllDatasources parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SmartSupportOuterClass$RequestGetAllDatasources) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SmartSupportOuterClass$RequestGetAllDatasources parseFrom(AbstractC2384h abstractC2384h) {
        return (SmartSupportOuterClass$RequestGetAllDatasources) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SmartSupportOuterClass$RequestGetAllDatasources parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SmartSupportOuterClass$RequestGetAllDatasources) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
