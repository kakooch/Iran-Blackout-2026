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
public final class TimcheOuterClass$RequestGetHomePage extends GeneratedMessageLite implements U64 {
    private static final TimcheOuterClass$RequestGetHomePage DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(TimcheOuterClass$RequestGetHomePage.DEFAULT_INSTANCE);
        }
    }

    static {
        TimcheOuterClass$RequestGetHomePage timcheOuterClass$RequestGetHomePage = new TimcheOuterClass$RequestGetHomePage();
        DEFAULT_INSTANCE = timcheOuterClass$RequestGetHomePage;
        GeneratedMessageLite.registerDefaultInstance(TimcheOuterClass$RequestGetHomePage.class, timcheOuterClass$RequestGetHomePage);
    }

    private TimcheOuterClass$RequestGetHomePage() {
    }

    public static TimcheOuterClass$RequestGetHomePage getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static TimcheOuterClass$RequestGetHomePage parseDelimitedFrom(InputStream inputStream) {
        return (TimcheOuterClass$RequestGetHomePage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static TimcheOuterClass$RequestGetHomePage parseFrom(ByteBuffer byteBuffer) {
        return (TimcheOuterClass$RequestGetHomePage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (i2.a[gVar.ordinal()]) {
            case 1:
                return new TimcheOuterClass$RequestGetHomePage();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0000", null);
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (TimcheOuterClass$RequestGetHomePage.class) {
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

    public static a newBuilder(TimcheOuterClass$RequestGetHomePage timcheOuterClass$RequestGetHomePage) {
        return (a) DEFAULT_INSTANCE.createBuilder(timcheOuterClass$RequestGetHomePage);
    }

    public static TimcheOuterClass$RequestGetHomePage parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (TimcheOuterClass$RequestGetHomePage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static TimcheOuterClass$RequestGetHomePage parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (TimcheOuterClass$RequestGetHomePage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static TimcheOuterClass$RequestGetHomePage parseFrom(AbstractC2383g abstractC2383g) {
        return (TimcheOuterClass$RequestGetHomePage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static TimcheOuterClass$RequestGetHomePage parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (TimcheOuterClass$RequestGetHomePage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static TimcheOuterClass$RequestGetHomePage parseFrom(byte[] bArr) {
        return (TimcheOuterClass$RequestGetHomePage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static TimcheOuterClass$RequestGetHomePage parseFrom(byte[] bArr, C2394s c2394s) {
        return (TimcheOuterClass$RequestGetHomePage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static TimcheOuterClass$RequestGetHomePage parseFrom(InputStream inputStream) {
        return (TimcheOuterClass$RequestGetHomePage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static TimcheOuterClass$RequestGetHomePage parseFrom(InputStream inputStream, C2394s c2394s) {
        return (TimcheOuterClass$RequestGetHomePage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static TimcheOuterClass$RequestGetHomePage parseFrom(AbstractC2384h abstractC2384h) {
        return (TimcheOuterClass$RequestGetHomePage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static TimcheOuterClass$RequestGetHomePage parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (TimcheOuterClass$RequestGetHomePage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
