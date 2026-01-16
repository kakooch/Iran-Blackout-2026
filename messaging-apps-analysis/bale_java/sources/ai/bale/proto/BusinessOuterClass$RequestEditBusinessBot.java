package ai.bale.proto;

import ai.bale.proto.BusinessStruct$BotInformation;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class BusinessOuterClass$RequestEditBusinessBot extends GeneratedMessageLite implements U64 {
    public static final int CONFIG_FIELD_NUMBER = 1;
    private static final BusinessOuterClass$RequestEditBusinessBot DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private BusinessStruct$BotInformation config_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(BusinessOuterClass$RequestEditBusinessBot.DEFAULT_INSTANCE);
        }
    }

    static {
        BusinessOuterClass$RequestEditBusinessBot businessOuterClass$RequestEditBusinessBot = new BusinessOuterClass$RequestEditBusinessBot();
        DEFAULT_INSTANCE = businessOuterClass$RequestEditBusinessBot;
        GeneratedMessageLite.registerDefaultInstance(BusinessOuterClass$RequestEditBusinessBot.class, businessOuterClass$RequestEditBusinessBot);
    }

    private BusinessOuterClass$RequestEditBusinessBot() {
    }

    private void clearConfig() {
        this.config_ = null;
        this.bitField0_ &= -2;
    }

    public static BusinessOuterClass$RequestEditBusinessBot getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeConfig(BusinessStruct$BotInformation businessStruct$BotInformation) {
        businessStruct$BotInformation.getClass();
        BusinessStruct$BotInformation businessStruct$BotInformation2 = this.config_;
        if (businessStruct$BotInformation2 == null || businessStruct$BotInformation2 == BusinessStruct$BotInformation.getDefaultInstance()) {
            this.config_ = businessStruct$BotInformation;
        } else {
            this.config_ = (BusinessStruct$BotInformation) ((BusinessStruct$BotInformation.a) BusinessStruct$BotInformation.newBuilder(this.config_).v(businessStruct$BotInformation)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static BusinessOuterClass$RequestEditBusinessBot parseDelimitedFrom(InputStream inputStream) {
        return (BusinessOuterClass$RequestEditBusinessBot) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BusinessOuterClass$RequestEditBusinessBot parseFrom(ByteBuffer byteBuffer) {
        return (BusinessOuterClass$RequestEditBusinessBot) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setConfig(BusinessStruct$BotInformation businessStruct$BotInformation) {
        businessStruct$BotInformation.getClass();
        this.config_ = businessStruct$BotInformation;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1896u.a[gVar.ordinal()]) {
            case 1:
                return new BusinessOuterClass$RequestEditBusinessBot();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "config_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (BusinessOuterClass$RequestEditBusinessBot.class) {
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

    public BusinessStruct$BotInformation getConfig() {
        BusinessStruct$BotInformation businessStruct$BotInformation = this.config_;
        return businessStruct$BotInformation == null ? BusinessStruct$BotInformation.getDefaultInstance() : businessStruct$BotInformation;
    }

    public boolean hasConfig() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(BusinessOuterClass$RequestEditBusinessBot businessOuterClass$RequestEditBusinessBot) {
        return (a) DEFAULT_INSTANCE.createBuilder(businessOuterClass$RequestEditBusinessBot);
    }

    public static BusinessOuterClass$RequestEditBusinessBot parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (BusinessOuterClass$RequestEditBusinessBot) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BusinessOuterClass$RequestEditBusinessBot parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (BusinessOuterClass$RequestEditBusinessBot) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static BusinessOuterClass$RequestEditBusinessBot parseFrom(AbstractC2383g abstractC2383g) {
        return (BusinessOuterClass$RequestEditBusinessBot) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static BusinessOuterClass$RequestEditBusinessBot parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (BusinessOuterClass$RequestEditBusinessBot) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static BusinessOuterClass$RequestEditBusinessBot parseFrom(byte[] bArr) {
        return (BusinessOuterClass$RequestEditBusinessBot) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static BusinessOuterClass$RequestEditBusinessBot parseFrom(byte[] bArr, C2394s c2394s) {
        return (BusinessOuterClass$RequestEditBusinessBot) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static BusinessOuterClass$RequestEditBusinessBot parseFrom(InputStream inputStream) {
        return (BusinessOuterClass$RequestEditBusinessBot) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BusinessOuterClass$RequestEditBusinessBot parseFrom(InputStream inputStream, C2394s c2394s) {
        return (BusinessOuterClass$RequestEditBusinessBot) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BusinessOuterClass$RequestEditBusinessBot parseFrom(AbstractC2384h abstractC2384h) {
        return (BusinessOuterClass$RequestEditBusinessBot) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static BusinessOuterClass$RequestEditBusinessBot parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (BusinessOuterClass$RequestEditBusinessBot) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
