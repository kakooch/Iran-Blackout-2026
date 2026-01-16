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
public final class OmreOuterClass$ResponseGetInitialOmreConfig extends GeneratedMessageLite implements U64 {
    private static final OmreOuterClass$ResponseGetInitialOmreConfig DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(OmreOuterClass$ResponseGetInitialOmreConfig.DEFAULT_INSTANCE);
        }
    }

    static {
        OmreOuterClass$ResponseGetInitialOmreConfig omreOuterClass$ResponseGetInitialOmreConfig = new OmreOuterClass$ResponseGetInitialOmreConfig();
        DEFAULT_INSTANCE = omreOuterClass$ResponseGetInitialOmreConfig;
        GeneratedMessageLite.registerDefaultInstance(OmreOuterClass$ResponseGetInitialOmreConfig.class, omreOuterClass$ResponseGetInitialOmreConfig);
    }

    private OmreOuterClass$ResponseGetInitialOmreConfig() {
    }

    public static OmreOuterClass$ResponseGetInitialOmreConfig getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static OmreOuterClass$ResponseGetInitialOmreConfig parseDelimitedFrom(InputStream inputStream) {
        return (OmreOuterClass$ResponseGetInitialOmreConfig) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static OmreOuterClass$ResponseGetInitialOmreConfig parseFrom(ByteBuffer byteBuffer) {
        return (OmreOuterClass$ResponseGetInitialOmreConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (U0.a[gVar.ordinal()]) {
            case 1:
                return new OmreOuterClass$ResponseGetInitialOmreConfig();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0000", null);
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (OmreOuterClass$ResponseGetInitialOmreConfig.class) {
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

    public static a newBuilder(OmreOuterClass$ResponseGetInitialOmreConfig omreOuterClass$ResponseGetInitialOmreConfig) {
        return (a) DEFAULT_INSTANCE.createBuilder(omreOuterClass$ResponseGetInitialOmreConfig);
    }

    public static OmreOuterClass$ResponseGetInitialOmreConfig parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (OmreOuterClass$ResponseGetInitialOmreConfig) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static OmreOuterClass$ResponseGetInitialOmreConfig parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (OmreOuterClass$ResponseGetInitialOmreConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static OmreOuterClass$ResponseGetInitialOmreConfig parseFrom(AbstractC2383g abstractC2383g) {
        return (OmreOuterClass$ResponseGetInitialOmreConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static OmreOuterClass$ResponseGetInitialOmreConfig parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (OmreOuterClass$ResponseGetInitialOmreConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static OmreOuterClass$ResponseGetInitialOmreConfig parseFrom(byte[] bArr) {
        return (OmreOuterClass$ResponseGetInitialOmreConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static OmreOuterClass$ResponseGetInitialOmreConfig parseFrom(byte[] bArr, C2394s c2394s) {
        return (OmreOuterClass$ResponseGetInitialOmreConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static OmreOuterClass$ResponseGetInitialOmreConfig parseFrom(InputStream inputStream) {
        return (OmreOuterClass$ResponseGetInitialOmreConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static OmreOuterClass$ResponseGetInitialOmreConfig parseFrom(InputStream inputStream, C2394s c2394s) {
        return (OmreOuterClass$ResponseGetInitialOmreConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static OmreOuterClass$ResponseGetInitialOmreConfig parseFrom(AbstractC2384h abstractC2384h) {
        return (OmreOuterClass$ResponseGetInitialOmreConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static OmreOuterClass$ResponseGetInitialOmreConfig parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (OmreOuterClass$ResponseGetInitialOmreConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
