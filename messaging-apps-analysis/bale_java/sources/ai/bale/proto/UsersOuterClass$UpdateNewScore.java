package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Int32Value;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class UsersOuterClass$UpdateNewScore extends GeneratedMessageLite implements U64 {
    private static final UsersOuterClass$UpdateNewScore DEFAULT_INSTANCE;
    public static final int NEW_FESTIVAL_SCORE_FIELD_NUMBER = 2;
    public static final int NEW_SCORE_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private Int32Value newFestivalScore_;
    private int newScore_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(UsersOuterClass$UpdateNewScore.DEFAULT_INSTANCE);
        }
    }

    static {
        UsersOuterClass$UpdateNewScore usersOuterClass$UpdateNewScore = new UsersOuterClass$UpdateNewScore();
        DEFAULT_INSTANCE = usersOuterClass$UpdateNewScore;
        GeneratedMessageLite.registerDefaultInstance(UsersOuterClass$UpdateNewScore.class, usersOuterClass$UpdateNewScore);
    }

    private UsersOuterClass$UpdateNewScore() {
    }

    private void clearNewFestivalScore() {
        this.newFestivalScore_ = null;
        this.bitField0_ &= -2;
    }

    private void clearNewScore() {
        this.newScore_ = 0;
    }

    public static UsersOuterClass$UpdateNewScore getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeNewFestivalScore(Int32Value int32Value) {
        int32Value.getClass();
        Int32Value int32Value2 = this.newFestivalScore_;
        if (int32Value2 == null || int32Value2 == Int32Value.getDefaultInstance()) {
            this.newFestivalScore_ = int32Value;
        } else {
            this.newFestivalScore_ = (Int32Value) ((Int32Value.b) Int32Value.newBuilder(this.newFestivalScore_).v(int32Value)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static UsersOuterClass$UpdateNewScore parseDelimitedFrom(InputStream inputStream) {
        return (UsersOuterClass$UpdateNewScore) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UsersOuterClass$UpdateNewScore parseFrom(ByteBuffer byteBuffer) {
        return (UsersOuterClass$UpdateNewScore) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setNewFestivalScore(Int32Value int32Value) {
        int32Value.getClass();
        this.newFestivalScore_ = int32Value;
        this.bitField0_ |= 1;
    }

    private void setNewScore(int i) {
        this.newScore_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (p2.a[gVar.ordinal()]) {
            case 1:
                return new UsersOuterClass$UpdateNewScore();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0004\u0002ဉ\u0000", new Object[]{"bitField0_", "newScore_", "newFestivalScore_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (UsersOuterClass$UpdateNewScore.class) {
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

    public Int32Value getNewFestivalScore() {
        Int32Value int32Value = this.newFestivalScore_;
        return int32Value == null ? Int32Value.getDefaultInstance() : int32Value;
    }

    public int getNewScore() {
        return this.newScore_;
    }

    public boolean hasNewFestivalScore() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(UsersOuterClass$UpdateNewScore usersOuterClass$UpdateNewScore) {
        return (a) DEFAULT_INSTANCE.createBuilder(usersOuterClass$UpdateNewScore);
    }

    public static UsersOuterClass$UpdateNewScore parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (UsersOuterClass$UpdateNewScore) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static UsersOuterClass$UpdateNewScore parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (UsersOuterClass$UpdateNewScore) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static UsersOuterClass$UpdateNewScore parseFrom(AbstractC2383g abstractC2383g) {
        return (UsersOuterClass$UpdateNewScore) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static UsersOuterClass$UpdateNewScore parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (UsersOuterClass$UpdateNewScore) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static UsersOuterClass$UpdateNewScore parseFrom(byte[] bArr) {
        return (UsersOuterClass$UpdateNewScore) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static UsersOuterClass$UpdateNewScore parseFrom(byte[] bArr, C2394s c2394s) {
        return (UsersOuterClass$UpdateNewScore) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static UsersOuterClass$UpdateNewScore parseFrom(InputStream inputStream) {
        return (UsersOuterClass$UpdateNewScore) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UsersOuterClass$UpdateNewScore parseFrom(InputStream inputStream, C2394s c2394s) {
        return (UsersOuterClass$UpdateNewScore) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static UsersOuterClass$UpdateNewScore parseFrom(AbstractC2384h abstractC2384h) {
        return (UsersOuterClass$UpdateNewScore) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static UsersOuterClass$UpdateNewScore parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (UsersOuterClass$UpdateNewScore) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
