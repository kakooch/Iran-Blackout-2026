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
public final class MiscStruct$Config extends GeneratedMessageLite implements U64 {
    private static final MiscStruct$Config DEFAULT_INSTANCE;
    public static final int MAX_GROUP_SIZE_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private int maxGroupSize_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MiscStruct$Config.DEFAULT_INSTANCE);
        }
    }

    static {
        MiscStruct$Config miscStruct$Config = new MiscStruct$Config();
        DEFAULT_INSTANCE = miscStruct$Config;
        GeneratedMessageLite.registerDefaultInstance(MiscStruct$Config.class, miscStruct$Config);
    }

    private MiscStruct$Config() {
    }

    private void clearMaxGroupSize() {
        this.maxGroupSize_ = 0;
    }

    public static MiscStruct$Config getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MiscStruct$Config parseDelimitedFrom(InputStream inputStream) {
        return (MiscStruct$Config) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MiscStruct$Config parseFrom(ByteBuffer byteBuffer) {
        return (MiscStruct$Config) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setMaxGroupSize(int i) {
        this.maxGroupSize_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (O0.a[gVar.ordinal()]) {
            case 1:
                return new MiscStruct$Config();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0004", new Object[]{"maxGroupSize_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MiscStruct$Config.class) {
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

    public int getMaxGroupSize() {
        return this.maxGroupSize_;
    }

    public static a newBuilder(MiscStruct$Config miscStruct$Config) {
        return (a) DEFAULT_INSTANCE.createBuilder(miscStruct$Config);
    }

    public static MiscStruct$Config parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MiscStruct$Config) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MiscStruct$Config parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MiscStruct$Config) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MiscStruct$Config parseFrom(AbstractC2383g abstractC2383g) {
        return (MiscStruct$Config) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MiscStruct$Config parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MiscStruct$Config) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MiscStruct$Config parseFrom(byte[] bArr) {
        return (MiscStruct$Config) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MiscStruct$Config parseFrom(byte[] bArr, C2394s c2394s) {
        return (MiscStruct$Config) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MiscStruct$Config parseFrom(InputStream inputStream) {
        return (MiscStruct$Config) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MiscStruct$Config parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MiscStruct$Config) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MiscStruct$Config parseFrom(AbstractC2384h abstractC2384h) {
        return (MiscStruct$Config) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MiscStruct$Config parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MiscStruct$Config) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
