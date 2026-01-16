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
public final class KetfOuterClass$RequestGetBotInfo extends GeneratedMessageLite implements U64 {
    public static final int BOT_USER_ID_FIELD_NUMBER = 1;
    private static final KetfOuterClass$RequestGetBotInfo DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private int botUserId_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(KetfOuterClass$RequestGetBotInfo.DEFAULT_INSTANCE);
        }
    }

    static {
        KetfOuterClass$RequestGetBotInfo ketfOuterClass$RequestGetBotInfo = new KetfOuterClass$RequestGetBotInfo();
        DEFAULT_INSTANCE = ketfOuterClass$RequestGetBotInfo;
        GeneratedMessageLite.registerDefaultInstance(KetfOuterClass$RequestGetBotInfo.class, ketfOuterClass$RequestGetBotInfo);
    }

    private KetfOuterClass$RequestGetBotInfo() {
    }

    private void clearBotUserId() {
        this.botUserId_ = 0;
    }

    public static KetfOuterClass$RequestGetBotInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static KetfOuterClass$RequestGetBotInfo parseDelimitedFrom(InputStream inputStream) {
        return (KetfOuterClass$RequestGetBotInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KetfOuterClass$RequestGetBotInfo parseFrom(ByteBuffer byteBuffer) {
        return (KetfOuterClass$RequestGetBotInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setBotUserId(int i) {
        this.botUserId_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1888r0.a[gVar.ordinal()]) {
            case 1:
                return new KetfOuterClass$RequestGetBotInfo();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0004", new Object[]{"botUserId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (KetfOuterClass$RequestGetBotInfo.class) {
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

    public static a newBuilder(KetfOuterClass$RequestGetBotInfo ketfOuterClass$RequestGetBotInfo) {
        return (a) DEFAULT_INSTANCE.createBuilder(ketfOuterClass$RequestGetBotInfo);
    }

    public static KetfOuterClass$RequestGetBotInfo parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (KetfOuterClass$RequestGetBotInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KetfOuterClass$RequestGetBotInfo parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (KetfOuterClass$RequestGetBotInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static KetfOuterClass$RequestGetBotInfo parseFrom(AbstractC2383g abstractC2383g) {
        return (KetfOuterClass$RequestGetBotInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static KetfOuterClass$RequestGetBotInfo parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (KetfOuterClass$RequestGetBotInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static KetfOuterClass$RequestGetBotInfo parseFrom(byte[] bArr) {
        return (KetfOuterClass$RequestGetBotInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static KetfOuterClass$RequestGetBotInfo parseFrom(byte[] bArr, C2394s c2394s) {
        return (KetfOuterClass$RequestGetBotInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static KetfOuterClass$RequestGetBotInfo parseFrom(InputStream inputStream) {
        return (KetfOuterClass$RequestGetBotInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KetfOuterClass$RequestGetBotInfo parseFrom(InputStream inputStream, C2394s c2394s) {
        return (KetfOuterClass$RequestGetBotInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KetfOuterClass$RequestGetBotInfo parseFrom(AbstractC2384h abstractC2384h) {
        return (KetfOuterClass$RequestGetBotInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static KetfOuterClass$RequestGetBotInfo parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (KetfOuterClass$RequestGetBotInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
