package ai.bale.proto;

import ai.bale.proto.PushStruct$PushConfig;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class PushOuterClass$RequestSetConfig extends GeneratedMessageLite implements U64 {
    public static final int CONFIG_FIELD_NUMBER = 1;
    private static final PushOuterClass$RequestSetConfig DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private PushStruct$PushConfig config_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(PushOuterClass$RequestSetConfig.DEFAULT_INSTANCE);
        }
    }

    static {
        PushOuterClass$RequestSetConfig pushOuterClass$RequestSetConfig = new PushOuterClass$RequestSetConfig();
        DEFAULT_INSTANCE = pushOuterClass$RequestSetConfig;
        GeneratedMessageLite.registerDefaultInstance(PushOuterClass$RequestSetConfig.class, pushOuterClass$RequestSetConfig);
    }

    private PushOuterClass$RequestSetConfig() {
    }

    private void clearConfig() {
        this.config_ = null;
        this.bitField0_ &= -2;
    }

    public static PushOuterClass$RequestSetConfig getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeConfig(PushStruct$PushConfig pushStruct$PushConfig) {
        pushStruct$PushConfig.getClass();
        PushStruct$PushConfig pushStruct$PushConfig2 = this.config_;
        if (pushStruct$PushConfig2 == null || pushStruct$PushConfig2 == PushStruct$PushConfig.getDefaultInstance()) {
            this.config_ = pushStruct$PushConfig;
        } else {
            this.config_ = (PushStruct$PushConfig) ((PushStruct$PushConfig.a) PushStruct$PushConfig.newBuilder(this.config_).v(pushStruct$PushConfig)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static PushOuterClass$RequestSetConfig parseDelimitedFrom(InputStream inputStream) {
        return (PushOuterClass$RequestSetConfig) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PushOuterClass$RequestSetConfig parseFrom(ByteBuffer byteBuffer) {
        return (PushOuterClass$RequestSetConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setConfig(PushStruct$PushConfig pushStruct$PushConfig) {
        pushStruct$PushConfig.getClass();
        this.config_ = pushStruct$PushConfig;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1878n1.a[gVar.ordinal()]) {
            case 1:
                return new PushOuterClass$RequestSetConfig();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "config_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (PushOuterClass$RequestSetConfig.class) {
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

    public PushStruct$PushConfig getConfig() {
        PushStruct$PushConfig pushStruct$PushConfig = this.config_;
        return pushStruct$PushConfig == null ? PushStruct$PushConfig.getDefaultInstance() : pushStruct$PushConfig;
    }

    public boolean hasConfig() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(PushOuterClass$RequestSetConfig pushOuterClass$RequestSetConfig) {
        return (a) DEFAULT_INSTANCE.createBuilder(pushOuterClass$RequestSetConfig);
    }

    public static PushOuterClass$RequestSetConfig parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (PushOuterClass$RequestSetConfig) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PushOuterClass$RequestSetConfig parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (PushOuterClass$RequestSetConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static PushOuterClass$RequestSetConfig parseFrom(AbstractC2383g abstractC2383g) {
        return (PushOuterClass$RequestSetConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static PushOuterClass$RequestSetConfig parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (PushOuterClass$RequestSetConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static PushOuterClass$RequestSetConfig parseFrom(byte[] bArr) {
        return (PushOuterClass$RequestSetConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PushOuterClass$RequestSetConfig parseFrom(byte[] bArr, C2394s c2394s) {
        return (PushOuterClass$RequestSetConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static PushOuterClass$RequestSetConfig parseFrom(InputStream inputStream) {
        return (PushOuterClass$RequestSetConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PushOuterClass$RequestSetConfig parseFrom(InputStream inputStream, C2394s c2394s) {
        return (PushOuterClass$RequestSetConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PushOuterClass$RequestSetConfig parseFrom(AbstractC2384h abstractC2384h) {
        return (PushOuterClass$RequestSetConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static PushOuterClass$RequestSetConfig parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (PushOuterClass$RequestSetConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
