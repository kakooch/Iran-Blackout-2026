package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Timestamp;
import ir.nasim.InterfaceC13878gy3;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class LeagueOuterClass$Match extends GeneratedMessageLite implements InterfaceC13878gy3 {
    private static final LeagueOuterClass$Match DEFAULT_INSTANCE;
    public static final int IS_FINISHED_FIELD_NUMBER = 7;
    public static final int MATCH_ID_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int TEAM1_ID_FIELD_NUMBER = 2;
    public static final int TEAM1_SCORE_FIELD_NUMBER = 4;
    public static final int TEAM2_ID_FIELD_NUMBER = 3;
    public static final int TEAM2_SCORE_FIELD_NUMBER = 5;
    public static final int TIME_FIELD_NUMBER = 6;
    private int bitField0_;
    private boolean isFinished_;
    private int matchId_;
    private int team1Id_;
    private int team1Score_;
    private int team2Id_;
    private int team2Score_;
    private Timestamp time_;

    public static final class a extends GeneratedMessageLite.b implements InterfaceC13878gy3 {
        private a() {
            super(LeagueOuterClass$Match.DEFAULT_INSTANCE);
        }
    }

    static {
        LeagueOuterClass$Match leagueOuterClass$Match = new LeagueOuterClass$Match();
        DEFAULT_INSTANCE = leagueOuterClass$Match;
        GeneratedMessageLite.registerDefaultInstance(LeagueOuterClass$Match.class, leagueOuterClass$Match);
    }

    private LeagueOuterClass$Match() {
    }

    private void clearIsFinished() {
        this.isFinished_ = false;
    }

    private void clearMatchId() {
        this.matchId_ = 0;
    }

    private void clearTeam1Id() {
        this.team1Id_ = 0;
    }

    private void clearTeam1Score() {
        this.team1Score_ = 0;
    }

    private void clearTeam2Id() {
        this.team2Id_ = 0;
    }

    private void clearTeam2Score() {
        this.team2Score_ = 0;
    }

    private void clearTime() {
        this.time_ = null;
        this.bitField0_ &= -2;
    }

    public static LeagueOuterClass$Match getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeTime(Timestamp timestamp) {
        timestamp.getClass();
        Timestamp timestamp2 = this.time_;
        if (timestamp2 == null || timestamp2 == Timestamp.getDefaultInstance()) {
            this.time_ = timestamp;
        } else {
            this.time_ = (Timestamp) ((Timestamp.b) Timestamp.newBuilder(this.time_).v(timestamp)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LeagueOuterClass$Match parseDelimitedFrom(InputStream inputStream) {
        return (LeagueOuterClass$Match) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LeagueOuterClass$Match parseFrom(ByteBuffer byteBuffer) {
        return (LeagueOuterClass$Match) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setIsFinished(boolean z) {
        this.isFinished_ = z;
    }

    private void setMatchId(int i) {
        this.matchId_ = i;
    }

    private void setTeam1Id(int i) {
        this.team1Id_ = i;
    }

    private void setTeam1Score(int i) {
        this.team1Score_ = i;
    }

    private void setTeam2Id(int i) {
        this.team2Id_ = i;
    }

    private void setTeam2Score(int i) {
        this.team2Score_ = i;
    }

    private void setTime(Timestamp timestamp) {
        timestamp.getClass();
        this.time_ = timestamp;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1909y0.a[gVar.ordinal()]) {
            case 1:
                return new LeagueOuterClass$Match();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001\u0004\u0002\u0004\u0003\u0004\u0004\u0004\u0005\u0004\u0006ဉ\u0000\u0007\u0007", new Object[]{"bitField0_", "matchId_", "team1Id_", "team2Id_", "team1Score_", "team2Score_", "time_", "isFinished_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LeagueOuterClass$Match.class) {
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

    public boolean getIsFinished() {
        return this.isFinished_;
    }

    public int getMatchId() {
        return this.matchId_;
    }

    public int getTeam1Id() {
        return this.team1Id_;
    }

    public int getTeam1Score() {
        return this.team1Score_;
    }

    public int getTeam2Id() {
        return this.team2Id_;
    }

    public int getTeam2Score() {
        return this.team2Score_;
    }

    public Timestamp getTime() {
        Timestamp timestamp = this.time_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    public boolean hasTime() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(LeagueOuterClass$Match leagueOuterClass$Match) {
        return (a) DEFAULT_INSTANCE.createBuilder(leagueOuterClass$Match);
    }

    public static LeagueOuterClass$Match parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LeagueOuterClass$Match) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LeagueOuterClass$Match parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LeagueOuterClass$Match) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LeagueOuterClass$Match parseFrom(AbstractC2383g abstractC2383g) {
        return (LeagueOuterClass$Match) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LeagueOuterClass$Match parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LeagueOuterClass$Match) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LeagueOuterClass$Match parseFrom(byte[] bArr) {
        return (LeagueOuterClass$Match) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LeagueOuterClass$Match parseFrom(byte[] bArr, C2394s c2394s) {
        return (LeagueOuterClass$Match) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LeagueOuterClass$Match parseFrom(InputStream inputStream) {
        return (LeagueOuterClass$Match) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LeagueOuterClass$Match parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LeagueOuterClass$Match) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LeagueOuterClass$Match parseFrom(AbstractC2384h abstractC2384h) {
        return (LeagueOuterClass$Match) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LeagueOuterClass$Match parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LeagueOuterClass$Match) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
