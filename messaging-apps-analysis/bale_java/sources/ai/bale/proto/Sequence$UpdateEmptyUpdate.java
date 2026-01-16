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
public final class Sequence$UpdateEmptyUpdate extends GeneratedMessageLite implements U64 {
    private static final Sequence$UpdateEmptyUpdate DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Sequence$UpdateEmptyUpdate.DEFAULT_INSTANCE);
        }
    }

    static {
        Sequence$UpdateEmptyUpdate sequence$UpdateEmptyUpdate = new Sequence$UpdateEmptyUpdate();
        DEFAULT_INSTANCE = sequence$UpdateEmptyUpdate;
        GeneratedMessageLite.registerDefaultInstance(Sequence$UpdateEmptyUpdate.class, sequence$UpdateEmptyUpdate);
    }

    private Sequence$UpdateEmptyUpdate() {
    }

    public static Sequence$UpdateEmptyUpdate getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Sequence$UpdateEmptyUpdate parseDelimitedFrom(InputStream inputStream) {
        return (Sequence$UpdateEmptyUpdate) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Sequence$UpdateEmptyUpdate parseFrom(ByteBuffer byteBuffer) {
        return (Sequence$UpdateEmptyUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (S1.a[gVar.ordinal()]) {
            case 1:
                return new Sequence$UpdateEmptyUpdate();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0000", null);
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Sequence$UpdateEmptyUpdate.class) {
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

    public static a newBuilder(Sequence$UpdateEmptyUpdate sequence$UpdateEmptyUpdate) {
        return (a) DEFAULT_INSTANCE.createBuilder(sequence$UpdateEmptyUpdate);
    }

    public static Sequence$UpdateEmptyUpdate parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Sequence$UpdateEmptyUpdate) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Sequence$UpdateEmptyUpdate parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Sequence$UpdateEmptyUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Sequence$UpdateEmptyUpdate parseFrom(AbstractC2383g abstractC2383g) {
        return (Sequence$UpdateEmptyUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static Sequence$UpdateEmptyUpdate parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Sequence$UpdateEmptyUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Sequence$UpdateEmptyUpdate parseFrom(byte[] bArr) {
        return (Sequence$UpdateEmptyUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Sequence$UpdateEmptyUpdate parseFrom(byte[] bArr, C2394s c2394s) {
        return (Sequence$UpdateEmptyUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Sequence$UpdateEmptyUpdate parseFrom(InputStream inputStream) {
        return (Sequence$UpdateEmptyUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Sequence$UpdateEmptyUpdate parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Sequence$UpdateEmptyUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Sequence$UpdateEmptyUpdate parseFrom(AbstractC2384h abstractC2384h) {
        return (Sequence$UpdateEmptyUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Sequence$UpdateEmptyUpdate parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Sequence$UpdateEmptyUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
