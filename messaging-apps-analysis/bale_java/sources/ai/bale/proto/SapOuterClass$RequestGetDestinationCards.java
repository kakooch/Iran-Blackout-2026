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
public final class SapOuterClass$RequestGetDestinationCards extends GeneratedMessageLite implements U64 {
    private static final SapOuterClass$RequestGetDestinationCards DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(SapOuterClass$RequestGetDestinationCards.DEFAULT_INSTANCE);
        }
    }

    static {
        SapOuterClass$RequestGetDestinationCards sapOuterClass$RequestGetDestinationCards = new SapOuterClass$RequestGetDestinationCards();
        DEFAULT_INSTANCE = sapOuterClass$RequestGetDestinationCards;
        GeneratedMessageLite.registerDefaultInstance(SapOuterClass$RequestGetDestinationCards.class, sapOuterClass$RequestGetDestinationCards);
    }

    private SapOuterClass$RequestGetDestinationCards() {
    }

    public static SapOuterClass$RequestGetDestinationCards getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SapOuterClass$RequestGetDestinationCards parseDelimitedFrom(InputStream inputStream) {
        return (SapOuterClass$RequestGetDestinationCards) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SapOuterClass$RequestGetDestinationCards parseFrom(ByteBuffer byteBuffer) {
        return (SapOuterClass$RequestGetDestinationCards) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (H1.a[gVar.ordinal()]) {
            case 1:
                return new SapOuterClass$RequestGetDestinationCards();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0000", null);
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SapOuterClass$RequestGetDestinationCards.class) {
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

    public static a newBuilder(SapOuterClass$RequestGetDestinationCards sapOuterClass$RequestGetDestinationCards) {
        return (a) DEFAULT_INSTANCE.createBuilder(sapOuterClass$RequestGetDestinationCards);
    }

    public static SapOuterClass$RequestGetDestinationCards parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SapOuterClass$RequestGetDestinationCards) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SapOuterClass$RequestGetDestinationCards parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SapOuterClass$RequestGetDestinationCards) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SapOuterClass$RequestGetDestinationCards parseFrom(AbstractC2383g abstractC2383g) {
        return (SapOuterClass$RequestGetDestinationCards) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static SapOuterClass$RequestGetDestinationCards parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SapOuterClass$RequestGetDestinationCards) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SapOuterClass$RequestGetDestinationCards parseFrom(byte[] bArr) {
        return (SapOuterClass$RequestGetDestinationCards) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SapOuterClass$RequestGetDestinationCards parseFrom(byte[] bArr, C2394s c2394s) {
        return (SapOuterClass$RequestGetDestinationCards) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SapOuterClass$RequestGetDestinationCards parseFrom(InputStream inputStream) {
        return (SapOuterClass$RequestGetDestinationCards) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SapOuterClass$RequestGetDestinationCards parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SapOuterClass$RequestGetDestinationCards) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SapOuterClass$RequestGetDestinationCards parseFrom(AbstractC2384h abstractC2384h) {
        return (SapOuterClass$RequestGetDestinationCards) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SapOuterClass$RequestGetDestinationCards parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SapOuterClass$RequestGetDestinationCards) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
