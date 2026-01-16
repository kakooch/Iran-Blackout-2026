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
public final class Bcms$RequestGetSearchFilterTokens extends GeneratedMessageLite implements U64 {
    private static final Bcms$RequestGetSearchFilterTokens DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Bcms$RequestGetSearchFilterTokens.DEFAULT_INSTANCE);
        }
    }

    static {
        Bcms$RequestGetSearchFilterTokens bcms$RequestGetSearchFilterTokens = new Bcms$RequestGetSearchFilterTokens();
        DEFAULT_INSTANCE = bcms$RequestGetSearchFilterTokens;
        GeneratedMessageLite.registerDefaultInstance(Bcms$RequestGetSearchFilterTokens.class, bcms$RequestGetSearchFilterTokens);
    }

    private Bcms$RequestGetSearchFilterTokens() {
    }

    public static Bcms$RequestGetSearchFilterTokens getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Bcms$RequestGetSearchFilterTokens parseDelimitedFrom(InputStream inputStream) {
        return (Bcms$RequestGetSearchFilterTokens) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Bcms$RequestGetSearchFilterTokens parseFrom(ByteBuffer byteBuffer) {
        return (Bcms$RequestGetSearchFilterTokens) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1882p.a[gVar.ordinal()]) {
            case 1:
                return new Bcms$RequestGetSearchFilterTokens();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0000", null);
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Bcms$RequestGetSearchFilterTokens.class) {
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

    public static a newBuilder(Bcms$RequestGetSearchFilterTokens bcms$RequestGetSearchFilterTokens) {
        return (a) DEFAULT_INSTANCE.createBuilder(bcms$RequestGetSearchFilterTokens);
    }

    public static Bcms$RequestGetSearchFilterTokens parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Bcms$RequestGetSearchFilterTokens) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Bcms$RequestGetSearchFilterTokens parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Bcms$RequestGetSearchFilterTokens) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Bcms$RequestGetSearchFilterTokens parseFrom(AbstractC2383g abstractC2383g) {
        return (Bcms$RequestGetSearchFilterTokens) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static Bcms$RequestGetSearchFilterTokens parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Bcms$RequestGetSearchFilterTokens) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Bcms$RequestGetSearchFilterTokens parseFrom(byte[] bArr) {
        return (Bcms$RequestGetSearchFilterTokens) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Bcms$RequestGetSearchFilterTokens parseFrom(byte[] bArr, C2394s c2394s) {
        return (Bcms$RequestGetSearchFilterTokens) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Bcms$RequestGetSearchFilterTokens parseFrom(InputStream inputStream) {
        return (Bcms$RequestGetSearchFilterTokens) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Bcms$RequestGetSearchFilterTokens parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Bcms$RequestGetSearchFilterTokens) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Bcms$RequestGetSearchFilterTokens parseFrom(AbstractC2384h abstractC2384h) {
        return (Bcms$RequestGetSearchFilterTokens) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Bcms$RequestGetSearchFilterTokens parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Bcms$RequestGetSearchFilterTokens) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
