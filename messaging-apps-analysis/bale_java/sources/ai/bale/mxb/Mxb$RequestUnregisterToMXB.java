package ai.bale.mxb;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class Mxb$RequestUnregisterToMXB extends GeneratedMessageLite implements U64 {
    private static final Mxb$RequestUnregisterToMXB DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Mxb$RequestUnregisterToMXB.DEFAULT_INSTANCE);
        }
    }

    static {
        Mxb$RequestUnregisterToMXB mxb$RequestUnregisterToMXB = new Mxb$RequestUnregisterToMXB();
        DEFAULT_INSTANCE = mxb$RequestUnregisterToMXB;
        GeneratedMessageLite.registerDefaultInstance(Mxb$RequestUnregisterToMXB.class, mxb$RequestUnregisterToMXB);
    }

    private Mxb$RequestUnregisterToMXB() {
    }

    public static Mxb$RequestUnregisterToMXB getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Mxb$RequestUnregisterToMXB parseDelimitedFrom(InputStream inputStream) {
        return (Mxb$RequestUnregisterToMXB) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Mxb$RequestUnregisterToMXB parseFrom(ByteBuffer byteBuffer) {
        return (Mxb$RequestUnregisterToMXB) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (ai.bale.mxb.a.a[gVar.ordinal()]) {
            case 1:
                return new Mxb$RequestUnregisterToMXB();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0000", null);
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Mxb$RequestUnregisterToMXB.class) {
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

    public static a newBuilder(Mxb$RequestUnregisterToMXB mxb$RequestUnregisterToMXB) {
        return (a) DEFAULT_INSTANCE.createBuilder(mxb$RequestUnregisterToMXB);
    }

    public static Mxb$RequestUnregisterToMXB parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Mxb$RequestUnregisterToMXB) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Mxb$RequestUnregisterToMXB parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Mxb$RequestUnregisterToMXB) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Mxb$RequestUnregisterToMXB parseFrom(AbstractC2383g abstractC2383g) {
        return (Mxb$RequestUnregisterToMXB) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static Mxb$RequestUnregisterToMXB parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Mxb$RequestUnregisterToMXB) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Mxb$RequestUnregisterToMXB parseFrom(byte[] bArr) {
        return (Mxb$RequestUnregisterToMXB) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Mxb$RequestUnregisterToMXB parseFrom(byte[] bArr, C2394s c2394s) {
        return (Mxb$RequestUnregisterToMXB) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Mxb$RequestUnregisterToMXB parseFrom(InputStream inputStream) {
        return (Mxb$RequestUnregisterToMXB) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Mxb$RequestUnregisterToMXB parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Mxb$RequestUnregisterToMXB) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Mxb$RequestUnregisterToMXB parseFrom(AbstractC2384h abstractC2384h) {
        return (Mxb$RequestUnregisterToMXB) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Mxb$RequestUnregisterToMXB parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Mxb$RequestUnregisterToMXB) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
