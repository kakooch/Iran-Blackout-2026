package bale.smart_support.v1;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public final class SmartSupportOuterClass$RequestValidateBotInfo extends GeneratedMessageLite implements U64 {
    public static final int BOT_NAME_FIELD_NUMBER = 2;
    public static final int BOT_NICKNAME_FIELD_NUMBER = 3;
    private static final SmartSupportOuterClass$RequestValidateBotInfo DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private String botName_ = "";
    private String botNickname_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(SmartSupportOuterClass$RequestValidateBotInfo.DEFAULT_INSTANCE);
        }
    }

    static {
        SmartSupportOuterClass$RequestValidateBotInfo smartSupportOuterClass$RequestValidateBotInfo = new SmartSupportOuterClass$RequestValidateBotInfo();
        DEFAULT_INSTANCE = smartSupportOuterClass$RequestValidateBotInfo;
        GeneratedMessageLite.registerDefaultInstance(SmartSupportOuterClass$RequestValidateBotInfo.class, smartSupportOuterClass$RequestValidateBotInfo);
    }

    private SmartSupportOuterClass$RequestValidateBotInfo() {
    }

    private void clearBotName() {
        this.botName_ = getDefaultInstance().getBotName();
    }

    private void clearBotNickname() {
        this.botNickname_ = getDefaultInstance().getBotNickname();
    }

    public static SmartSupportOuterClass$RequestValidateBotInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SmartSupportOuterClass$RequestValidateBotInfo parseDelimitedFrom(InputStream inputStream) {
        return (SmartSupportOuterClass$RequestValidateBotInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SmartSupportOuterClass$RequestValidateBotInfo parseFrom(ByteBuffer byteBuffer) {
        return (SmartSupportOuterClass$RequestValidateBotInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setBotName(String str) {
        str.getClass();
        this.botName_ = str;
    }

    private void setBotNameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.botName_ = abstractC2383g.f0();
    }

    private void setBotNickname(String str) {
        str.getClass();
        this.botNickname_ = str;
    }

    private void setBotNicknameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.botNickname_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (b.a[gVar.ordinal()]) {
            case 1:
                return new SmartSupportOuterClass$RequestValidateBotInfo();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0002\u0003\u0002\u0000\u0000\u0000\u0002Ȉ\u0003Ȉ", new Object[]{"botName_", "botNickname_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SmartSupportOuterClass$RequestValidateBotInfo.class) {
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

    public String getBotName() {
        return this.botName_;
    }

    public AbstractC2383g getBotNameBytes() {
        return AbstractC2383g.N(this.botName_);
    }

    public String getBotNickname() {
        return this.botNickname_;
    }

    public AbstractC2383g getBotNicknameBytes() {
        return AbstractC2383g.N(this.botNickname_);
    }

    public static a newBuilder(SmartSupportOuterClass$RequestValidateBotInfo smartSupportOuterClass$RequestValidateBotInfo) {
        return (a) DEFAULT_INSTANCE.createBuilder(smartSupportOuterClass$RequestValidateBotInfo);
    }

    public static SmartSupportOuterClass$RequestValidateBotInfo parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SmartSupportOuterClass$RequestValidateBotInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SmartSupportOuterClass$RequestValidateBotInfo parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SmartSupportOuterClass$RequestValidateBotInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SmartSupportOuterClass$RequestValidateBotInfo parseFrom(AbstractC2383g abstractC2383g) {
        return (SmartSupportOuterClass$RequestValidateBotInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static SmartSupportOuterClass$RequestValidateBotInfo parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SmartSupportOuterClass$RequestValidateBotInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SmartSupportOuterClass$RequestValidateBotInfo parseFrom(byte[] bArr) {
        return (SmartSupportOuterClass$RequestValidateBotInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SmartSupportOuterClass$RequestValidateBotInfo parseFrom(byte[] bArr, C2394s c2394s) {
        return (SmartSupportOuterClass$RequestValidateBotInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SmartSupportOuterClass$RequestValidateBotInfo parseFrom(InputStream inputStream) {
        return (SmartSupportOuterClass$RequestValidateBotInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SmartSupportOuterClass$RequestValidateBotInfo parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SmartSupportOuterClass$RequestValidateBotInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SmartSupportOuterClass$RequestValidateBotInfo parseFrom(AbstractC2384h abstractC2384h) {
        return (SmartSupportOuterClass$RequestValidateBotInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SmartSupportOuterClass$RequestValidateBotInfo parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SmartSupportOuterClass$RequestValidateBotInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
