package ai.bale.proto;

import ai.bale.proto.KetfStruct$BotInfo;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class KetfOuterClass$ResponseGetBotInfo extends GeneratedMessageLite implements U64 {
    public static final int BOT_INFO_FIELD_NUMBER = 1;
    private static final KetfOuterClass$ResponseGetBotInfo DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private KetfStruct$BotInfo botInfo_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(KetfOuterClass$ResponseGetBotInfo.DEFAULT_INSTANCE);
        }
    }

    static {
        KetfOuterClass$ResponseGetBotInfo ketfOuterClass$ResponseGetBotInfo = new KetfOuterClass$ResponseGetBotInfo();
        DEFAULT_INSTANCE = ketfOuterClass$ResponseGetBotInfo;
        GeneratedMessageLite.registerDefaultInstance(KetfOuterClass$ResponseGetBotInfo.class, ketfOuterClass$ResponseGetBotInfo);
    }

    private KetfOuterClass$ResponseGetBotInfo() {
    }

    private void clearBotInfo() {
        this.botInfo_ = null;
        this.bitField0_ &= -2;
    }

    public static KetfOuterClass$ResponseGetBotInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeBotInfo(KetfStruct$BotInfo ketfStruct$BotInfo) {
        ketfStruct$BotInfo.getClass();
        KetfStruct$BotInfo ketfStruct$BotInfo2 = this.botInfo_;
        if (ketfStruct$BotInfo2 == null || ketfStruct$BotInfo2 == KetfStruct$BotInfo.getDefaultInstance()) {
            this.botInfo_ = ketfStruct$BotInfo;
        } else {
            this.botInfo_ = (KetfStruct$BotInfo) ((KetfStruct$BotInfo.a) KetfStruct$BotInfo.newBuilder(this.botInfo_).v(ketfStruct$BotInfo)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static KetfOuterClass$ResponseGetBotInfo parseDelimitedFrom(InputStream inputStream) {
        return (KetfOuterClass$ResponseGetBotInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KetfOuterClass$ResponseGetBotInfo parseFrom(ByteBuffer byteBuffer) {
        return (KetfOuterClass$ResponseGetBotInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setBotInfo(KetfStruct$BotInfo ketfStruct$BotInfo) {
        ketfStruct$BotInfo.getClass();
        this.botInfo_ = ketfStruct$BotInfo;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1888r0.a[gVar.ordinal()]) {
            case 1:
                return new KetfOuterClass$ResponseGetBotInfo();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "botInfo_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (KetfOuterClass$ResponseGetBotInfo.class) {
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

    public KetfStruct$BotInfo getBotInfo() {
        KetfStruct$BotInfo ketfStruct$BotInfo = this.botInfo_;
        return ketfStruct$BotInfo == null ? KetfStruct$BotInfo.getDefaultInstance() : ketfStruct$BotInfo;
    }

    public boolean hasBotInfo() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(KetfOuterClass$ResponseGetBotInfo ketfOuterClass$ResponseGetBotInfo) {
        return (a) DEFAULT_INSTANCE.createBuilder(ketfOuterClass$ResponseGetBotInfo);
    }

    public static KetfOuterClass$ResponseGetBotInfo parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (KetfOuterClass$ResponseGetBotInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KetfOuterClass$ResponseGetBotInfo parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (KetfOuterClass$ResponseGetBotInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static KetfOuterClass$ResponseGetBotInfo parseFrom(AbstractC2383g abstractC2383g) {
        return (KetfOuterClass$ResponseGetBotInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static KetfOuterClass$ResponseGetBotInfo parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (KetfOuterClass$ResponseGetBotInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static KetfOuterClass$ResponseGetBotInfo parseFrom(byte[] bArr) {
        return (KetfOuterClass$ResponseGetBotInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static KetfOuterClass$ResponseGetBotInfo parseFrom(byte[] bArr, C2394s c2394s) {
        return (KetfOuterClass$ResponseGetBotInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static KetfOuterClass$ResponseGetBotInfo parseFrom(InputStream inputStream) {
        return (KetfOuterClass$ResponseGetBotInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KetfOuterClass$ResponseGetBotInfo parseFrom(InputStream inputStream, C2394s c2394s) {
        return (KetfOuterClass$ResponseGetBotInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KetfOuterClass$ResponseGetBotInfo parseFrom(AbstractC2384h abstractC2384h) {
        return (KetfOuterClass$ResponseGetBotInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static KetfOuterClass$ResponseGetBotInfo parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (KetfOuterClass$ResponseGetBotInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
