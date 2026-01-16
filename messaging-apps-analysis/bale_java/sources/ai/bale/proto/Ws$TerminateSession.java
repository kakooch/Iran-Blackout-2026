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
public final class Ws$TerminateSession extends GeneratedMessageLite implements U64 {
    private static final Ws$TerminateSession DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Ws$TerminateSession.DEFAULT_INSTANCE);
        }
    }

    static {
        Ws$TerminateSession ws$TerminateSession = new Ws$TerminateSession();
        DEFAULT_INSTANCE = ws$TerminateSession;
        GeneratedMessageLite.registerDefaultInstance(Ws$TerminateSession.class, ws$TerminateSession);
    }

    private Ws$TerminateSession() {
    }

    public static Ws$TerminateSession getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Ws$TerminateSession parseDelimitedFrom(InputStream inputStream) {
        return (Ws$TerminateSession) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Ws$TerminateSession parseFrom(ByteBuffer byteBuffer) {
        return (Ws$TerminateSession) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (y2.a[gVar.ordinal()]) {
            case 1:
                return new Ws$TerminateSession();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0000", null);
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Ws$TerminateSession.class) {
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

    public static a newBuilder(Ws$TerminateSession ws$TerminateSession) {
        return (a) DEFAULT_INSTANCE.createBuilder(ws$TerminateSession);
    }

    public static Ws$TerminateSession parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Ws$TerminateSession) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Ws$TerminateSession parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Ws$TerminateSession) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Ws$TerminateSession parseFrom(AbstractC2383g abstractC2383g) {
        return (Ws$TerminateSession) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static Ws$TerminateSession parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Ws$TerminateSession) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Ws$TerminateSession parseFrom(byte[] bArr) {
        return (Ws$TerminateSession) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Ws$TerminateSession parseFrom(byte[] bArr, C2394s c2394s) {
        return (Ws$TerminateSession) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Ws$TerminateSession parseFrom(InputStream inputStream) {
        return (Ws$TerminateSession) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Ws$TerminateSession parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Ws$TerminateSession) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Ws$TerminateSession parseFrom(AbstractC2384h abstractC2384h) {
        return (Ws$TerminateSession) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Ws$TerminateSession parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Ws$TerminateSession) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
