package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC16260ky3;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class LeagueOuterClass$Prediction extends GeneratedMessageLite implements InterfaceC16260ky3 {
    private static final LeagueOuterClass$Prediction DEFAULT_INSTANCE;
    public static final int GAINED_SCORE_FIELD_NUMBER = 6;
    public static final int MATCH_ID_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int TEAM1_SCORE_FIELD_NUMBER = 4;
    public static final int TEAM2_SCORE_FIELD_NUMBER = 5;
    public static final int USER_ID_FIELD_NUMBER = 1;
    private int gainedScore_;
    private int matchId_;
    private int team1Score_;
    private int team2Score_;
    private int userId_;

    public static final class a extends GeneratedMessageLite.b implements InterfaceC16260ky3 {
        private a() {
            super(LeagueOuterClass$Prediction.DEFAULT_INSTANCE);
        }
    }

    static {
        LeagueOuterClass$Prediction leagueOuterClass$Prediction = new LeagueOuterClass$Prediction();
        DEFAULT_INSTANCE = leagueOuterClass$Prediction;
        GeneratedMessageLite.registerDefaultInstance(LeagueOuterClass$Prediction.class, leagueOuterClass$Prediction);
    }

    private LeagueOuterClass$Prediction() {
    }

    private void clearGainedScore() {
        this.gainedScore_ = 0;
    }

    private void clearMatchId() {
        this.matchId_ = 0;
    }

    private void clearTeam1Score() {
        this.team1Score_ = 0;
    }

    private void clearTeam2Score() {
        this.team2Score_ = 0;
    }

    private void clearUserId() {
        this.userId_ = 0;
    }

    public static LeagueOuterClass$Prediction getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LeagueOuterClass$Prediction parseDelimitedFrom(InputStream inputStream) {
        return (LeagueOuterClass$Prediction) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LeagueOuterClass$Prediction parseFrom(ByteBuffer byteBuffer) {
        return (LeagueOuterClass$Prediction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setGainedScore(int i) {
        this.gainedScore_ = i;
    }

    private void setMatchId(int i) {
        this.matchId_ = i;
    }

    private void setTeam1Score(int i) {
        this.team1Score_ = i;
    }

    private void setTeam2Score(int i) {
        this.team2Score_ = i;
    }

    private void setUserId(int i) {
        this.userId_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1909y0.a[gVar.ordinal()]) {
            case 1:
                return new LeagueOuterClass$Prediction();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001\u0006\u0005\u0000\u0000\u0000\u0001\u0004\u0002\u0004\u0004\u0004\u0005\u0004\u0006\u0004", new Object[]{"userId_", "matchId_", "team1Score_", "team2Score_", "gainedScore_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LeagueOuterClass$Prediction.class) {
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

    public int getGainedScore() {
        return this.gainedScore_;
    }

    public int getMatchId() {
        return this.matchId_;
    }

    public int getTeam1Score() {
        return this.team1Score_;
    }

    public int getTeam2Score() {
        return this.team2Score_;
    }

    public int getUserId() {
        return this.userId_;
    }

    public static a newBuilder(LeagueOuterClass$Prediction leagueOuterClass$Prediction) {
        return (a) DEFAULT_INSTANCE.createBuilder(leagueOuterClass$Prediction);
    }

    public static LeagueOuterClass$Prediction parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LeagueOuterClass$Prediction) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LeagueOuterClass$Prediction parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LeagueOuterClass$Prediction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LeagueOuterClass$Prediction parseFrom(AbstractC2383g abstractC2383g) {
        return (LeagueOuterClass$Prediction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LeagueOuterClass$Prediction parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LeagueOuterClass$Prediction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LeagueOuterClass$Prediction parseFrom(byte[] bArr) {
        return (LeagueOuterClass$Prediction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LeagueOuterClass$Prediction parseFrom(byte[] bArr, C2394s c2394s) {
        return (LeagueOuterClass$Prediction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LeagueOuterClass$Prediction parseFrom(InputStream inputStream) {
        return (LeagueOuterClass$Prediction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LeagueOuterClass$Prediction parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LeagueOuterClass$Prediction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LeagueOuterClass$Prediction parseFrom(AbstractC2384h abstractC2384h) {
        return (LeagueOuterClass$Prediction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LeagueOuterClass$Prediction parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LeagueOuterClass$Prediction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
