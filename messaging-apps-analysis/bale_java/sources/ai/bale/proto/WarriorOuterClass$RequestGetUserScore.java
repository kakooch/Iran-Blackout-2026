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
public final class WarriorOuterClass$RequestGetUserScore extends GeneratedMessageLite implements U64 {
    private static final WarriorOuterClass$RequestGetUserScore DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(WarriorOuterClass$RequestGetUserScore.DEFAULT_INSTANCE);
        }
    }

    static {
        WarriorOuterClass$RequestGetUserScore warriorOuterClass$RequestGetUserScore = new WarriorOuterClass$RequestGetUserScore();
        DEFAULT_INSTANCE = warriorOuterClass$RequestGetUserScore;
        GeneratedMessageLite.registerDefaultInstance(WarriorOuterClass$RequestGetUserScore.class, warriorOuterClass$RequestGetUserScore);
    }

    private WarriorOuterClass$RequestGetUserScore() {
    }

    public static WarriorOuterClass$RequestGetUserScore getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static WarriorOuterClass$RequestGetUserScore parseDelimitedFrom(InputStream inputStream) {
        return (WarriorOuterClass$RequestGetUserScore) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static WarriorOuterClass$RequestGetUserScore parseFrom(ByteBuffer byteBuffer) {
        return (WarriorOuterClass$RequestGetUserScore) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (w2.a[gVar.ordinal()]) {
            case 1:
                return new WarriorOuterClass$RequestGetUserScore();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0000", null);
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (WarriorOuterClass$RequestGetUserScore.class) {
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

    public static a newBuilder(WarriorOuterClass$RequestGetUserScore warriorOuterClass$RequestGetUserScore) {
        return (a) DEFAULT_INSTANCE.createBuilder(warriorOuterClass$RequestGetUserScore);
    }

    public static WarriorOuterClass$RequestGetUserScore parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (WarriorOuterClass$RequestGetUserScore) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static WarriorOuterClass$RequestGetUserScore parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (WarriorOuterClass$RequestGetUserScore) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static WarriorOuterClass$RequestGetUserScore parseFrom(AbstractC2383g abstractC2383g) {
        return (WarriorOuterClass$RequestGetUserScore) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static WarriorOuterClass$RequestGetUserScore parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (WarriorOuterClass$RequestGetUserScore) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static WarriorOuterClass$RequestGetUserScore parseFrom(byte[] bArr) {
        return (WarriorOuterClass$RequestGetUserScore) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static WarriorOuterClass$RequestGetUserScore parseFrom(byte[] bArr, C2394s c2394s) {
        return (WarriorOuterClass$RequestGetUserScore) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static WarriorOuterClass$RequestGetUserScore parseFrom(InputStream inputStream) {
        return (WarriorOuterClass$RequestGetUserScore) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static WarriorOuterClass$RequestGetUserScore parseFrom(InputStream inputStream, C2394s c2394s) {
        return (WarriorOuterClass$RequestGetUserScore) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static WarriorOuterClass$RequestGetUserScore parseFrom(AbstractC2384h abstractC2384h) {
        return (WarriorOuterClass$RequestGetUserScore) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static WarriorOuterClass$RequestGetUserScore parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (WarriorOuterClass$RequestGetUserScore) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
