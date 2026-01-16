package ai.bale.proto;

import ai.bale.proto.WarriorStruct$ScoreBoard;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC21082t48;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class WarriorOuterClass$ResponseGetScoreBoard extends GeneratedMessageLite implements U64 {
    private static final WarriorOuterClass$ResponseGetScoreBoard DEFAULT_INSTANCE;
    public static final int LEVEL_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int SCORE_BOARD_FIELD_NUMBER = 2;
    private int bitField0_;
    private int level_;
    private WarriorStruct$ScoreBoard scoreBoard_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(WarriorOuterClass$ResponseGetScoreBoard.DEFAULT_INSTANCE);
        }
    }

    static {
        WarriorOuterClass$ResponseGetScoreBoard warriorOuterClass$ResponseGetScoreBoard = new WarriorOuterClass$ResponseGetScoreBoard();
        DEFAULT_INSTANCE = warriorOuterClass$ResponseGetScoreBoard;
        GeneratedMessageLite.registerDefaultInstance(WarriorOuterClass$ResponseGetScoreBoard.class, warriorOuterClass$ResponseGetScoreBoard);
    }

    private WarriorOuterClass$ResponseGetScoreBoard() {
    }

    private void clearLevel() {
        this.level_ = 0;
    }

    private void clearScoreBoard() {
        this.scoreBoard_ = null;
        this.bitField0_ &= -2;
    }

    public static WarriorOuterClass$ResponseGetScoreBoard getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeScoreBoard(WarriorStruct$ScoreBoard warriorStruct$ScoreBoard) {
        warriorStruct$ScoreBoard.getClass();
        WarriorStruct$ScoreBoard warriorStruct$ScoreBoard2 = this.scoreBoard_;
        if (warriorStruct$ScoreBoard2 == null || warriorStruct$ScoreBoard2 == WarriorStruct$ScoreBoard.getDefaultInstance()) {
            this.scoreBoard_ = warriorStruct$ScoreBoard;
        } else {
            this.scoreBoard_ = (WarriorStruct$ScoreBoard) ((WarriorStruct$ScoreBoard.a) WarriorStruct$ScoreBoard.newBuilder(this.scoreBoard_).v(warriorStruct$ScoreBoard)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static WarriorOuterClass$ResponseGetScoreBoard parseDelimitedFrom(InputStream inputStream) {
        return (WarriorOuterClass$ResponseGetScoreBoard) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static WarriorOuterClass$ResponseGetScoreBoard parseFrom(ByteBuffer byteBuffer) {
        return (WarriorOuterClass$ResponseGetScoreBoard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setLevel(EnumC21082t48 enumC21082t48) {
        this.level_ = enumC21082t48.getNumber();
    }

    private void setLevelValue(int i) {
        this.level_ = i;
    }

    private void setScoreBoard(WarriorStruct$ScoreBoard warriorStruct$ScoreBoard) {
        warriorStruct$ScoreBoard.getClass();
        this.scoreBoard_ = warriorStruct$ScoreBoard;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (w2.a[gVar.ordinal()]) {
            case 1:
                return new WarriorOuterClass$ResponseGetScoreBoard();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0002ဉ\u0000", new Object[]{"bitField0_", "level_", "scoreBoard_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (WarriorOuterClass$ResponseGetScoreBoard.class) {
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

    public EnumC21082t48 getLevel() {
        EnumC21082t48 enumC21082t48J = EnumC21082t48.j(this.level_);
        return enumC21082t48J == null ? EnumC21082t48.UNRECOGNIZED : enumC21082t48J;
    }

    public int getLevelValue() {
        return this.level_;
    }

    public WarriorStruct$ScoreBoard getScoreBoard() {
        WarriorStruct$ScoreBoard warriorStruct$ScoreBoard = this.scoreBoard_;
        return warriorStruct$ScoreBoard == null ? WarriorStruct$ScoreBoard.getDefaultInstance() : warriorStruct$ScoreBoard;
    }

    public boolean hasScoreBoard() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(WarriorOuterClass$ResponseGetScoreBoard warriorOuterClass$ResponseGetScoreBoard) {
        return (a) DEFAULT_INSTANCE.createBuilder(warriorOuterClass$ResponseGetScoreBoard);
    }

    public static WarriorOuterClass$ResponseGetScoreBoard parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (WarriorOuterClass$ResponseGetScoreBoard) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static WarriorOuterClass$ResponseGetScoreBoard parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (WarriorOuterClass$ResponseGetScoreBoard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static WarriorOuterClass$ResponseGetScoreBoard parseFrom(AbstractC2383g abstractC2383g) {
        return (WarriorOuterClass$ResponseGetScoreBoard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static WarriorOuterClass$ResponseGetScoreBoard parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (WarriorOuterClass$ResponseGetScoreBoard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static WarriorOuterClass$ResponseGetScoreBoard parseFrom(byte[] bArr) {
        return (WarriorOuterClass$ResponseGetScoreBoard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static WarriorOuterClass$ResponseGetScoreBoard parseFrom(byte[] bArr, C2394s c2394s) {
        return (WarriorOuterClass$ResponseGetScoreBoard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static WarriorOuterClass$ResponseGetScoreBoard parseFrom(InputStream inputStream) {
        return (WarriorOuterClass$ResponseGetScoreBoard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static WarriorOuterClass$ResponseGetScoreBoard parseFrom(InputStream inputStream, C2394s c2394s) {
        return (WarriorOuterClass$ResponseGetScoreBoard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static WarriorOuterClass$ResponseGetScoreBoard parseFrom(AbstractC2384h abstractC2384h) {
        return (WarriorOuterClass$ResponseGetScoreBoard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static WarriorOuterClass$ResponseGetScoreBoard parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (WarriorOuterClass$ResponseGetScoreBoard) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
