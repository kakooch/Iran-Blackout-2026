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
public final class WarriorOuterClass$ResponseGetUserScore extends GeneratedMessageLite implements U64 {
    private static final WarriorOuterClass$ResponseGetUserScore DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int SCORE_FIELD_NUMBER = 1;
    private int score_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(WarriorOuterClass$ResponseGetUserScore.DEFAULT_INSTANCE);
        }
    }

    static {
        WarriorOuterClass$ResponseGetUserScore warriorOuterClass$ResponseGetUserScore = new WarriorOuterClass$ResponseGetUserScore();
        DEFAULT_INSTANCE = warriorOuterClass$ResponseGetUserScore;
        GeneratedMessageLite.registerDefaultInstance(WarriorOuterClass$ResponseGetUserScore.class, warriorOuterClass$ResponseGetUserScore);
    }

    private WarriorOuterClass$ResponseGetUserScore() {
    }

    private void clearScore() {
        this.score_ = 0;
    }

    public static WarriorOuterClass$ResponseGetUserScore getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static WarriorOuterClass$ResponseGetUserScore parseDelimitedFrom(InputStream inputStream) {
        return (WarriorOuterClass$ResponseGetUserScore) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static WarriorOuterClass$ResponseGetUserScore parseFrom(ByteBuffer byteBuffer) {
        return (WarriorOuterClass$ResponseGetUserScore) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setScore(int i) {
        this.score_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (w2.a[gVar.ordinal()]) {
            case 1:
                return new WarriorOuterClass$ResponseGetUserScore();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0004", new Object[]{"score_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (WarriorOuterClass$ResponseGetUserScore.class) {
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

    public int getScore() {
        return this.score_;
    }

    public static a newBuilder(WarriorOuterClass$ResponseGetUserScore warriorOuterClass$ResponseGetUserScore) {
        return (a) DEFAULT_INSTANCE.createBuilder(warriorOuterClass$ResponseGetUserScore);
    }

    public static WarriorOuterClass$ResponseGetUserScore parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (WarriorOuterClass$ResponseGetUserScore) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static WarriorOuterClass$ResponseGetUserScore parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (WarriorOuterClass$ResponseGetUserScore) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static WarriorOuterClass$ResponseGetUserScore parseFrom(AbstractC2383g abstractC2383g) {
        return (WarriorOuterClass$ResponseGetUserScore) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static WarriorOuterClass$ResponseGetUserScore parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (WarriorOuterClass$ResponseGetUserScore) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static WarriorOuterClass$ResponseGetUserScore parseFrom(byte[] bArr) {
        return (WarriorOuterClass$ResponseGetUserScore) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static WarriorOuterClass$ResponseGetUserScore parseFrom(byte[] bArr, C2394s c2394s) {
        return (WarriorOuterClass$ResponseGetUserScore) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static WarriorOuterClass$ResponseGetUserScore parseFrom(InputStream inputStream) {
        return (WarriorOuterClass$ResponseGetUserScore) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static WarriorOuterClass$ResponseGetUserScore parseFrom(InputStream inputStream, C2394s c2394s) {
        return (WarriorOuterClass$ResponseGetUserScore) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static WarriorOuterClass$ResponseGetUserScore parseFrom(AbstractC2384h abstractC2384h) {
        return (WarriorOuterClass$ResponseGetUserScore) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static WarriorOuterClass$ResponseGetUserScore parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (WarriorOuterClass$ResponseGetUserScore) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
