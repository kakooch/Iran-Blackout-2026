package ai.bale.proto;

import ai.bale.proto.PushStruct$GlobalConfig;
import ai.bale.proto.PushStruct$PeerConfig;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class PushStruct$PushConfig extends GeneratedMessageLite implements U64 {
    private static final PushStruct$PushConfig DEFAULT_INSTANCE;
    public static final int GLOBAL_CONFIG_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int PEER_CONFIG_FIELD_NUMBER = 2;
    private int traitCase_ = 0;
    private Object trait_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(PushStruct$PushConfig.DEFAULT_INSTANCE);
        }
    }

    public enum b {
        GLOBAL_CONFIG(1),
        PEER_CONFIG(2),
        TRAIT_NOT_SET(0);

        private final int a;

        b(int i) {
            this.a = i;
        }

        public static b j(int i) {
            if (i == 0) {
                return TRAIT_NOT_SET;
            }
            if (i == 1) {
                return GLOBAL_CONFIG;
            }
            if (i != 2) {
                return null;
            }
            return PEER_CONFIG;
        }
    }

    static {
        PushStruct$PushConfig pushStruct$PushConfig = new PushStruct$PushConfig();
        DEFAULT_INSTANCE = pushStruct$PushConfig;
        GeneratedMessageLite.registerDefaultInstance(PushStruct$PushConfig.class, pushStruct$PushConfig);
    }

    private PushStruct$PushConfig() {
    }

    private void clearGlobalConfig() {
        if (this.traitCase_ == 1) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearPeerConfig() {
        if (this.traitCase_ == 2) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearTrait() {
        this.traitCase_ = 0;
        this.trait_ = null;
    }

    public static PushStruct$PushConfig getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeGlobalConfig(PushStruct$GlobalConfig pushStruct$GlobalConfig) {
        pushStruct$GlobalConfig.getClass();
        if (this.traitCase_ != 1 || this.trait_ == PushStruct$GlobalConfig.getDefaultInstance()) {
            this.trait_ = pushStruct$GlobalConfig;
        } else {
            this.trait_ = ((PushStruct$GlobalConfig.a) PushStruct$GlobalConfig.newBuilder((PushStruct$GlobalConfig) this.trait_).v(pushStruct$GlobalConfig)).j();
        }
        this.traitCase_ = 1;
    }

    private void mergePeerConfig(PushStruct$PeerConfig pushStruct$PeerConfig) {
        pushStruct$PeerConfig.getClass();
        if (this.traitCase_ != 2 || this.trait_ == PushStruct$PeerConfig.getDefaultInstance()) {
            this.trait_ = pushStruct$PeerConfig;
        } else {
            this.trait_ = ((PushStruct$PeerConfig.a) PushStruct$PeerConfig.newBuilder((PushStruct$PeerConfig) this.trait_).v(pushStruct$PeerConfig)).j();
        }
        this.traitCase_ = 2;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static PushStruct$PushConfig parseDelimitedFrom(InputStream inputStream) {
        return (PushStruct$PushConfig) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PushStruct$PushConfig parseFrom(ByteBuffer byteBuffer) {
        return (PushStruct$PushConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setGlobalConfig(PushStruct$GlobalConfig pushStruct$GlobalConfig) {
        pushStruct$GlobalConfig.getClass();
        this.trait_ = pushStruct$GlobalConfig;
        this.traitCase_ = 1;
    }

    private void setPeerConfig(PushStruct$PeerConfig pushStruct$PeerConfig) {
        pushStruct$PeerConfig.getClass();
        this.trait_ = pushStruct$PeerConfig;
        this.traitCase_ = 2;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1881o1.a[gVar.ordinal()]) {
            case 1:
                return new PushStruct$PushConfig();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0001\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001<\u0000\u0002<\u0000", new Object[]{"trait_", "traitCase_", PushStruct$GlobalConfig.class, PushStruct$PeerConfig.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (PushStruct$PushConfig.class) {
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

    public PushStruct$GlobalConfig getGlobalConfig() {
        return this.traitCase_ == 1 ? (PushStruct$GlobalConfig) this.trait_ : PushStruct$GlobalConfig.getDefaultInstance();
    }

    public PushStruct$PeerConfig getPeerConfig() {
        return this.traitCase_ == 2 ? (PushStruct$PeerConfig) this.trait_ : PushStruct$PeerConfig.getDefaultInstance();
    }

    public b getTraitCase() {
        return b.j(this.traitCase_);
    }

    public boolean hasGlobalConfig() {
        return this.traitCase_ == 1;
    }

    public boolean hasPeerConfig() {
        return this.traitCase_ == 2;
    }

    public static a newBuilder(PushStruct$PushConfig pushStruct$PushConfig) {
        return (a) DEFAULT_INSTANCE.createBuilder(pushStruct$PushConfig);
    }

    public static PushStruct$PushConfig parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (PushStruct$PushConfig) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PushStruct$PushConfig parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (PushStruct$PushConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static PushStruct$PushConfig parseFrom(AbstractC2383g abstractC2383g) {
        return (PushStruct$PushConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static PushStruct$PushConfig parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (PushStruct$PushConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static PushStruct$PushConfig parseFrom(byte[] bArr) {
        return (PushStruct$PushConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PushStruct$PushConfig parseFrom(byte[] bArr, C2394s c2394s) {
        return (PushStruct$PushConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static PushStruct$PushConfig parseFrom(InputStream inputStream) {
        return (PushStruct$PushConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PushStruct$PushConfig parseFrom(InputStream inputStream, C2394s c2394s) {
        return (PushStruct$PushConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PushStruct$PushConfig parseFrom(AbstractC2384h abstractC2384h) {
        return (PushStruct$PushConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static PushStruct$PushConfig parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (PushStruct$PushConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
