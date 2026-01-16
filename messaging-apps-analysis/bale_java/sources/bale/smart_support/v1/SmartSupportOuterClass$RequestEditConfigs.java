package bale.smart_support.v1;

import bale.smart_support.v1.SmartSupportStruct$MessagePerDayLimitConfig;
import bale.smart_support.v1.SmartSupportStruct$OutageMessageConfig;
import bale.smart_support.v1.SmartSupportStruct$WelcomeMessageConfig;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public final class SmartSupportOuterClass$RequestEditConfigs extends GeneratedMessageLite implements U64 {
    public static final int BOT_ID_FIELD_NUMBER = 1;
    private static final SmartSupportOuterClass$RequestEditConfigs DEFAULT_INSTANCE;
    public static final int MESSAGE_PER_DAY_LIMIT_FIELD_NUMBER = 4;
    public static final int OUTAGE_MESSAGE_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER = null;
    public static final int WELCOME_MESSAGE_FIELD_NUMBER = 2;
    private int bitField0_;
    private int botId_;
    private SmartSupportStruct$MessagePerDayLimitConfig messagePerDayLimit_;
    private SmartSupportStruct$OutageMessageConfig outageMessage_;
    private SmartSupportStruct$WelcomeMessageConfig welcomeMessage_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(SmartSupportOuterClass$RequestEditConfigs.DEFAULT_INSTANCE);
        }
    }

    static {
        SmartSupportOuterClass$RequestEditConfigs smartSupportOuterClass$RequestEditConfigs = new SmartSupportOuterClass$RequestEditConfigs();
        DEFAULT_INSTANCE = smartSupportOuterClass$RequestEditConfigs;
        GeneratedMessageLite.registerDefaultInstance(SmartSupportOuterClass$RequestEditConfigs.class, smartSupportOuterClass$RequestEditConfigs);
    }

    private SmartSupportOuterClass$RequestEditConfigs() {
    }

    private void clearBotId() {
        this.botId_ = 0;
    }

    private void clearMessagePerDayLimit() {
        this.messagePerDayLimit_ = null;
        this.bitField0_ &= -5;
    }

    private void clearOutageMessage() {
        this.outageMessage_ = null;
        this.bitField0_ &= -3;
    }

    private void clearWelcomeMessage() {
        this.welcomeMessage_ = null;
        this.bitField0_ &= -2;
    }

    public static SmartSupportOuterClass$RequestEditConfigs getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeMessagePerDayLimit(SmartSupportStruct$MessagePerDayLimitConfig smartSupportStruct$MessagePerDayLimitConfig) {
        smartSupportStruct$MessagePerDayLimitConfig.getClass();
        SmartSupportStruct$MessagePerDayLimitConfig smartSupportStruct$MessagePerDayLimitConfig2 = this.messagePerDayLimit_;
        if (smartSupportStruct$MessagePerDayLimitConfig2 == null || smartSupportStruct$MessagePerDayLimitConfig2 == SmartSupportStruct$MessagePerDayLimitConfig.getDefaultInstance()) {
            this.messagePerDayLimit_ = smartSupportStruct$MessagePerDayLimitConfig;
        } else {
            this.messagePerDayLimit_ = (SmartSupportStruct$MessagePerDayLimitConfig) ((SmartSupportStruct$MessagePerDayLimitConfig.a) SmartSupportStruct$MessagePerDayLimitConfig.newBuilder(this.messagePerDayLimit_).v(smartSupportStruct$MessagePerDayLimitConfig)).j();
        }
        this.bitField0_ |= 4;
    }

    private void mergeOutageMessage(SmartSupportStruct$OutageMessageConfig smartSupportStruct$OutageMessageConfig) {
        smartSupportStruct$OutageMessageConfig.getClass();
        SmartSupportStruct$OutageMessageConfig smartSupportStruct$OutageMessageConfig2 = this.outageMessage_;
        if (smartSupportStruct$OutageMessageConfig2 == null || smartSupportStruct$OutageMessageConfig2 == SmartSupportStruct$OutageMessageConfig.getDefaultInstance()) {
            this.outageMessage_ = smartSupportStruct$OutageMessageConfig;
        } else {
            this.outageMessage_ = (SmartSupportStruct$OutageMessageConfig) ((SmartSupportStruct$OutageMessageConfig.a) SmartSupportStruct$OutageMessageConfig.newBuilder(this.outageMessage_).v(smartSupportStruct$OutageMessageConfig)).j();
        }
        this.bitField0_ |= 2;
    }

    private void mergeWelcomeMessage(SmartSupportStruct$WelcomeMessageConfig smartSupportStruct$WelcomeMessageConfig) {
        smartSupportStruct$WelcomeMessageConfig.getClass();
        SmartSupportStruct$WelcomeMessageConfig smartSupportStruct$WelcomeMessageConfig2 = this.welcomeMessage_;
        if (smartSupportStruct$WelcomeMessageConfig2 == null || smartSupportStruct$WelcomeMessageConfig2 == SmartSupportStruct$WelcomeMessageConfig.getDefaultInstance()) {
            this.welcomeMessage_ = smartSupportStruct$WelcomeMessageConfig;
        } else {
            this.welcomeMessage_ = (SmartSupportStruct$WelcomeMessageConfig) ((SmartSupportStruct$WelcomeMessageConfig.a) SmartSupportStruct$WelcomeMessageConfig.newBuilder(this.welcomeMessage_).v(smartSupportStruct$WelcomeMessageConfig)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SmartSupportOuterClass$RequestEditConfigs parseDelimitedFrom(InputStream inputStream) {
        return (SmartSupportOuterClass$RequestEditConfigs) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SmartSupportOuterClass$RequestEditConfigs parseFrom(ByteBuffer byteBuffer) {
        return (SmartSupportOuterClass$RequestEditConfigs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setBotId(int i) {
        this.botId_ = i;
    }

    private void setMessagePerDayLimit(SmartSupportStruct$MessagePerDayLimitConfig smartSupportStruct$MessagePerDayLimitConfig) {
        smartSupportStruct$MessagePerDayLimitConfig.getClass();
        this.messagePerDayLimit_ = smartSupportStruct$MessagePerDayLimitConfig;
        this.bitField0_ |= 4;
    }

    private void setOutageMessage(SmartSupportStruct$OutageMessageConfig smartSupportStruct$OutageMessageConfig) {
        smartSupportStruct$OutageMessageConfig.getClass();
        this.outageMessage_ = smartSupportStruct$OutageMessageConfig;
        this.bitField0_ |= 2;
    }

    private void setWelcomeMessage(SmartSupportStruct$WelcomeMessageConfig smartSupportStruct$WelcomeMessageConfig) {
        smartSupportStruct$WelcomeMessageConfig.getClass();
        this.welcomeMessage_ = smartSupportStruct$WelcomeMessageConfig;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (b.a[gVar.ordinal()]) {
            case 1:
                return new SmartSupportOuterClass$RequestEditConfigs();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u0004\u0002ဉ\u0000\u0003ဉ\u0001\u0004ဉ\u0002", new Object[]{"bitField0_", "botId_", "welcomeMessage_", "outageMessage_", "messagePerDayLimit_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SmartSupportOuterClass$RequestEditConfigs.class) {
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

    public SmartSupportStruct$MessagePerDayLimitConfig getMessagePerDayLimit() {
        SmartSupportStruct$MessagePerDayLimitConfig smartSupportStruct$MessagePerDayLimitConfig = this.messagePerDayLimit_;
        return smartSupportStruct$MessagePerDayLimitConfig == null ? SmartSupportStruct$MessagePerDayLimitConfig.getDefaultInstance() : smartSupportStruct$MessagePerDayLimitConfig;
    }

    public SmartSupportStruct$OutageMessageConfig getOutageMessage() {
        SmartSupportStruct$OutageMessageConfig smartSupportStruct$OutageMessageConfig = this.outageMessage_;
        return smartSupportStruct$OutageMessageConfig == null ? SmartSupportStruct$OutageMessageConfig.getDefaultInstance() : smartSupportStruct$OutageMessageConfig;
    }

    public SmartSupportStruct$WelcomeMessageConfig getWelcomeMessage() {
        SmartSupportStruct$WelcomeMessageConfig smartSupportStruct$WelcomeMessageConfig = this.welcomeMessage_;
        return smartSupportStruct$WelcomeMessageConfig == null ? SmartSupportStruct$WelcomeMessageConfig.getDefaultInstance() : smartSupportStruct$WelcomeMessageConfig;
    }

    public boolean hasMessagePerDayLimit() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasOutageMessage() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasWelcomeMessage() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(SmartSupportOuterClass$RequestEditConfigs smartSupportOuterClass$RequestEditConfigs) {
        return (a) DEFAULT_INSTANCE.createBuilder(smartSupportOuterClass$RequestEditConfigs);
    }

    public static SmartSupportOuterClass$RequestEditConfigs parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SmartSupportOuterClass$RequestEditConfigs) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SmartSupportOuterClass$RequestEditConfigs parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SmartSupportOuterClass$RequestEditConfigs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SmartSupportOuterClass$RequestEditConfigs parseFrom(AbstractC2383g abstractC2383g) {
        return (SmartSupportOuterClass$RequestEditConfigs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static SmartSupportOuterClass$RequestEditConfigs parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SmartSupportOuterClass$RequestEditConfigs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SmartSupportOuterClass$RequestEditConfigs parseFrom(byte[] bArr) {
        return (SmartSupportOuterClass$RequestEditConfigs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SmartSupportOuterClass$RequestEditConfigs parseFrom(byte[] bArr, C2394s c2394s) {
        return (SmartSupportOuterClass$RequestEditConfigs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SmartSupportOuterClass$RequestEditConfigs parseFrom(InputStream inputStream) {
        return (SmartSupportOuterClass$RequestEditConfigs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SmartSupportOuterClass$RequestEditConfigs parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SmartSupportOuterClass$RequestEditConfigs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SmartSupportOuterClass$RequestEditConfigs parseFrom(AbstractC2384h abstractC2384h) {
        return (SmartSupportOuterClass$RequestEditConfigs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SmartSupportOuterClass$RequestEditConfigs parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SmartSupportOuterClass$RequestEditConfigs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
