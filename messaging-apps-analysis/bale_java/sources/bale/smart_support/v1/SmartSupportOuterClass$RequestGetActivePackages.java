package bale.smart_support.v1;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public final class SmartSupportOuterClass$RequestGetActivePackages extends GeneratedMessageLite implements U64 {
    private static final SmartSupportOuterClass$RequestGetActivePackages DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(SmartSupportOuterClass$RequestGetActivePackages.DEFAULT_INSTANCE);
        }
    }

    static {
        SmartSupportOuterClass$RequestGetActivePackages smartSupportOuterClass$RequestGetActivePackages = new SmartSupportOuterClass$RequestGetActivePackages();
        DEFAULT_INSTANCE = smartSupportOuterClass$RequestGetActivePackages;
        GeneratedMessageLite.registerDefaultInstance(SmartSupportOuterClass$RequestGetActivePackages.class, smartSupportOuterClass$RequestGetActivePackages);
    }

    private SmartSupportOuterClass$RequestGetActivePackages() {
    }

    public static SmartSupportOuterClass$RequestGetActivePackages getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SmartSupportOuterClass$RequestGetActivePackages parseDelimitedFrom(InputStream inputStream) {
        return (SmartSupportOuterClass$RequestGetActivePackages) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SmartSupportOuterClass$RequestGetActivePackages parseFrom(ByteBuffer byteBuffer) {
        return (SmartSupportOuterClass$RequestGetActivePackages) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (b.a[gVar.ordinal()]) {
            case 1:
                return new SmartSupportOuterClass$RequestGetActivePackages();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0000", null);
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SmartSupportOuterClass$RequestGetActivePackages.class) {
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

    public static a newBuilder(SmartSupportOuterClass$RequestGetActivePackages smartSupportOuterClass$RequestGetActivePackages) {
        return (a) DEFAULT_INSTANCE.createBuilder(smartSupportOuterClass$RequestGetActivePackages);
    }

    public static SmartSupportOuterClass$RequestGetActivePackages parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SmartSupportOuterClass$RequestGetActivePackages) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SmartSupportOuterClass$RequestGetActivePackages parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SmartSupportOuterClass$RequestGetActivePackages) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SmartSupportOuterClass$RequestGetActivePackages parseFrom(AbstractC2383g abstractC2383g) {
        return (SmartSupportOuterClass$RequestGetActivePackages) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static SmartSupportOuterClass$RequestGetActivePackages parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SmartSupportOuterClass$RequestGetActivePackages) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SmartSupportOuterClass$RequestGetActivePackages parseFrom(byte[] bArr) {
        return (SmartSupportOuterClass$RequestGetActivePackages) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SmartSupportOuterClass$RequestGetActivePackages parseFrom(byte[] bArr, C2394s c2394s) {
        return (SmartSupportOuterClass$RequestGetActivePackages) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SmartSupportOuterClass$RequestGetActivePackages parseFrom(InputStream inputStream) {
        return (SmartSupportOuterClass$RequestGetActivePackages) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SmartSupportOuterClass$RequestGetActivePackages parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SmartSupportOuterClass$RequestGetActivePackages) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SmartSupportOuterClass$RequestGetActivePackages parseFrom(AbstractC2384h abstractC2384h) {
        return (SmartSupportOuterClass$RequestGetActivePackages) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SmartSupportOuterClass$RequestGetActivePackages parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SmartSupportOuterClass$RequestGetActivePackages) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
