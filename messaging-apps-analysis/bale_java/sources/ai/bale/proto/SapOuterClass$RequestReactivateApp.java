package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class SapOuterClass$RequestReactivateApp extends GeneratedMessageLite implements U64 {
    private static final SapOuterClass$RequestReactivateApp DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(SapOuterClass$RequestReactivateApp.DEFAULT_INSTANCE);
        }
    }

    static {
        SapOuterClass$RequestReactivateApp sapOuterClass$RequestReactivateApp = new SapOuterClass$RequestReactivateApp();
        DEFAULT_INSTANCE = sapOuterClass$RequestReactivateApp;
        GeneratedMessageLite.registerDefaultInstance(SapOuterClass$RequestReactivateApp.class, sapOuterClass$RequestReactivateApp);
    }

    private SapOuterClass$RequestReactivateApp() {
    }

    public static SapOuterClass$RequestReactivateApp getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SapOuterClass$RequestReactivateApp parseDelimitedFrom(InputStream inputStream) {
        return (SapOuterClass$RequestReactivateApp) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SapOuterClass$RequestReactivateApp parseFrom(ByteBuffer byteBuffer) {
        return (SapOuterClass$RequestReactivateApp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (H1.a[gVar.ordinal()]) {
            case 1:
                return new SapOuterClass$RequestReactivateApp();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0000", null);
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SapOuterClass$RequestReactivateApp.class) {
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

    public static a newBuilder(SapOuterClass$RequestReactivateApp sapOuterClass$RequestReactivateApp) {
        return (a) DEFAULT_INSTANCE.createBuilder(sapOuterClass$RequestReactivateApp);
    }

    public static SapOuterClass$RequestReactivateApp parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SapOuterClass$RequestReactivateApp) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SapOuterClass$RequestReactivateApp parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SapOuterClass$RequestReactivateApp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SapOuterClass$RequestReactivateApp parseFrom(AbstractC2383g abstractC2383g) {
        return (SapOuterClass$RequestReactivateApp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static SapOuterClass$RequestReactivateApp parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SapOuterClass$RequestReactivateApp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SapOuterClass$RequestReactivateApp parseFrom(byte[] bArr) {
        return (SapOuterClass$RequestReactivateApp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SapOuterClass$RequestReactivateApp parseFrom(byte[] bArr, C2394s c2394s) {
        return (SapOuterClass$RequestReactivateApp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SapOuterClass$RequestReactivateApp parseFrom(InputStream inputStream) {
        return (SapOuterClass$RequestReactivateApp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SapOuterClass$RequestReactivateApp parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SapOuterClass$RequestReactivateApp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SapOuterClass$RequestReactivateApp parseFrom(AbstractC2384h abstractC2384h) {
        return (SapOuterClass$RequestReactivateApp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SapOuterClass$RequestReactivateApp parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SapOuterClass$RequestReactivateApp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
