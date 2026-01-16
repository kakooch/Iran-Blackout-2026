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
public final class SapOuterClass$RequestGetCards extends GeneratedMessageLite implements U64 {
    private static final SapOuterClass$RequestGetCards DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(SapOuterClass$RequestGetCards.DEFAULT_INSTANCE);
        }
    }

    static {
        SapOuterClass$RequestGetCards sapOuterClass$RequestGetCards = new SapOuterClass$RequestGetCards();
        DEFAULT_INSTANCE = sapOuterClass$RequestGetCards;
        GeneratedMessageLite.registerDefaultInstance(SapOuterClass$RequestGetCards.class, sapOuterClass$RequestGetCards);
    }

    private SapOuterClass$RequestGetCards() {
    }

    public static SapOuterClass$RequestGetCards getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SapOuterClass$RequestGetCards parseDelimitedFrom(InputStream inputStream) {
        return (SapOuterClass$RequestGetCards) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SapOuterClass$RequestGetCards parseFrom(ByteBuffer byteBuffer) {
        return (SapOuterClass$RequestGetCards) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (H1.a[gVar.ordinal()]) {
            case 1:
                return new SapOuterClass$RequestGetCards();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0000", null);
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SapOuterClass$RequestGetCards.class) {
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

    public static a newBuilder(SapOuterClass$RequestGetCards sapOuterClass$RequestGetCards) {
        return (a) DEFAULT_INSTANCE.createBuilder(sapOuterClass$RequestGetCards);
    }

    public static SapOuterClass$RequestGetCards parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SapOuterClass$RequestGetCards) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SapOuterClass$RequestGetCards parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SapOuterClass$RequestGetCards) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SapOuterClass$RequestGetCards parseFrom(AbstractC2383g abstractC2383g) {
        return (SapOuterClass$RequestGetCards) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static SapOuterClass$RequestGetCards parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SapOuterClass$RequestGetCards) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SapOuterClass$RequestGetCards parseFrom(byte[] bArr) {
        return (SapOuterClass$RequestGetCards) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SapOuterClass$RequestGetCards parseFrom(byte[] bArr, C2394s c2394s) {
        return (SapOuterClass$RequestGetCards) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SapOuterClass$RequestGetCards parseFrom(InputStream inputStream) {
        return (SapOuterClass$RequestGetCards) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SapOuterClass$RequestGetCards parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SapOuterClass$RequestGetCards) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SapOuterClass$RequestGetCards parseFrom(AbstractC2384h abstractC2384h) {
        return (SapOuterClass$RequestGetCards) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SapOuterClass$RequestGetCards parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SapOuterClass$RequestGetCards) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
