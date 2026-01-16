package ai.bale.proto;

import ai.bale.proto.MiscStruct$Config;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class Misc$UpdateConfig extends GeneratedMessageLite implements U64 {
    public static final int CONFIG_FIELD_NUMBER = 1;
    private static final Misc$UpdateConfig DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private MiscStruct$Config config_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Misc$UpdateConfig.DEFAULT_INSTANCE);
        }
    }

    static {
        Misc$UpdateConfig misc$UpdateConfig = new Misc$UpdateConfig();
        DEFAULT_INSTANCE = misc$UpdateConfig;
        GeneratedMessageLite.registerDefaultInstance(Misc$UpdateConfig.class, misc$UpdateConfig);
    }

    private Misc$UpdateConfig() {
    }

    private void clearConfig() {
        this.config_ = null;
        this.bitField0_ &= -2;
    }

    public static Misc$UpdateConfig getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeConfig(MiscStruct$Config miscStruct$Config) {
        miscStruct$Config.getClass();
        MiscStruct$Config miscStruct$Config2 = this.config_;
        if (miscStruct$Config2 == null || miscStruct$Config2 == MiscStruct$Config.getDefaultInstance()) {
            this.config_ = miscStruct$Config;
        } else {
            this.config_ = (MiscStruct$Config) ((MiscStruct$Config.a) MiscStruct$Config.newBuilder(this.config_).v(miscStruct$Config)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Misc$UpdateConfig parseDelimitedFrom(InputStream inputStream) {
        return (Misc$UpdateConfig) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Misc$UpdateConfig parseFrom(ByteBuffer byteBuffer) {
        return (Misc$UpdateConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setConfig(MiscStruct$Config miscStruct$Config) {
        miscStruct$Config.getClass();
        this.config_ = miscStruct$Config;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (N0.a[gVar.ordinal()]) {
            case 1:
                return new Misc$UpdateConfig();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "config_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Misc$UpdateConfig.class) {
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

    public MiscStruct$Config getConfig() {
        MiscStruct$Config miscStruct$Config = this.config_;
        return miscStruct$Config == null ? MiscStruct$Config.getDefaultInstance() : miscStruct$Config;
    }

    public boolean hasConfig() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(Misc$UpdateConfig misc$UpdateConfig) {
        return (a) DEFAULT_INSTANCE.createBuilder(misc$UpdateConfig);
    }

    public static Misc$UpdateConfig parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Misc$UpdateConfig) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Misc$UpdateConfig parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Misc$UpdateConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Misc$UpdateConfig parseFrom(AbstractC2383g abstractC2383g) {
        return (Misc$UpdateConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static Misc$UpdateConfig parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Misc$UpdateConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Misc$UpdateConfig parseFrom(byte[] bArr) {
        return (Misc$UpdateConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Misc$UpdateConfig parseFrom(byte[] bArr, C2394s c2394s) {
        return (Misc$UpdateConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Misc$UpdateConfig parseFrom(InputStream inputStream) {
        return (Misc$UpdateConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Misc$UpdateConfig parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Misc$UpdateConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Misc$UpdateConfig parseFrom(AbstractC2384h abstractC2384h) {
        return (Misc$UpdateConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Misc$UpdateConfig parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Misc$UpdateConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
