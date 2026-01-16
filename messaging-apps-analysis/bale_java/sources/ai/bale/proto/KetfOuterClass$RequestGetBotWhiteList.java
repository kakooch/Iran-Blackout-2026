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
public final class KetfOuterClass$RequestGetBotWhiteList extends GeneratedMessageLite implements U64 {
    public static final int BOT_USER_ID_FIELD_NUMBER = 1;
    private static final KetfOuterClass$RequestGetBotWhiteList DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private int botUserId_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(KetfOuterClass$RequestGetBotWhiteList.DEFAULT_INSTANCE);
        }
    }

    static {
        KetfOuterClass$RequestGetBotWhiteList ketfOuterClass$RequestGetBotWhiteList = new KetfOuterClass$RequestGetBotWhiteList();
        DEFAULT_INSTANCE = ketfOuterClass$RequestGetBotWhiteList;
        GeneratedMessageLite.registerDefaultInstance(KetfOuterClass$RequestGetBotWhiteList.class, ketfOuterClass$RequestGetBotWhiteList);
    }

    private KetfOuterClass$RequestGetBotWhiteList() {
    }

    private void clearBotUserId() {
        this.botUserId_ = 0;
    }

    public static KetfOuterClass$RequestGetBotWhiteList getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static KetfOuterClass$RequestGetBotWhiteList parseDelimitedFrom(InputStream inputStream) {
        return (KetfOuterClass$RequestGetBotWhiteList) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KetfOuterClass$RequestGetBotWhiteList parseFrom(ByteBuffer byteBuffer) {
        return (KetfOuterClass$RequestGetBotWhiteList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
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
                return new KetfOuterClass$RequestGetBotWhiteList();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0004", new Object[]{"botUserId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (KetfOuterClass$RequestGetBotWhiteList.class) {
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

    public static a newBuilder(KetfOuterClass$RequestGetBotWhiteList ketfOuterClass$RequestGetBotWhiteList) {
        return (a) DEFAULT_INSTANCE.createBuilder(ketfOuterClass$RequestGetBotWhiteList);
    }

    public static KetfOuterClass$RequestGetBotWhiteList parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (KetfOuterClass$RequestGetBotWhiteList) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KetfOuterClass$RequestGetBotWhiteList parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (KetfOuterClass$RequestGetBotWhiteList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static KetfOuterClass$RequestGetBotWhiteList parseFrom(AbstractC2383g abstractC2383g) {
        return (KetfOuterClass$RequestGetBotWhiteList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static KetfOuterClass$RequestGetBotWhiteList parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (KetfOuterClass$RequestGetBotWhiteList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static KetfOuterClass$RequestGetBotWhiteList parseFrom(byte[] bArr) {
        return (KetfOuterClass$RequestGetBotWhiteList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static KetfOuterClass$RequestGetBotWhiteList parseFrom(byte[] bArr, C2394s c2394s) {
        return (KetfOuterClass$RequestGetBotWhiteList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static KetfOuterClass$RequestGetBotWhiteList parseFrom(InputStream inputStream) {
        return (KetfOuterClass$RequestGetBotWhiteList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KetfOuterClass$RequestGetBotWhiteList parseFrom(InputStream inputStream, C2394s c2394s) {
        return (KetfOuterClass$RequestGetBotWhiteList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KetfOuterClass$RequestGetBotWhiteList parseFrom(AbstractC2384h abstractC2384h) {
        return (KetfOuterClass$RequestGetBotWhiteList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static KetfOuterClass$RequestGetBotWhiteList parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (KetfOuterClass$RequestGetBotWhiteList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
