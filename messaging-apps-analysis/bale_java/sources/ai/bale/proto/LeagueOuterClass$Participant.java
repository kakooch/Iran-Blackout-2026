package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC15078iy3;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class LeagueOuterClass$Participant extends GeneratedMessageLite implements InterfaceC15078iy3 {
    private static final LeagueOuterClass$Participant DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int PHONE_NUMBER_FIELD_NUMBER = 2;
    public static final int TOTAL_RANK_FIELD_NUMBER = 6;
    public static final int TOTAL_SCORE_FIELD_NUMBER = 4;
    public static final int USER_ID_FIELD_NUMBER = 1;
    public static final int WEEKLY_RANK_FIELD_NUMBER = 5;
    public static final int WEEKLY_SCORE_FIELD_NUMBER = 3;
    private String phoneNumber_ = "";
    private int totalRank_;
    private int totalScore_;
    private int userId_;
    private int weeklyRank_;
    private int weeklyScore_;

    public static final class a extends GeneratedMessageLite.b implements InterfaceC15078iy3 {
        private a() {
            super(LeagueOuterClass$Participant.DEFAULT_INSTANCE);
        }
    }

    static {
        LeagueOuterClass$Participant leagueOuterClass$Participant = new LeagueOuterClass$Participant();
        DEFAULT_INSTANCE = leagueOuterClass$Participant;
        GeneratedMessageLite.registerDefaultInstance(LeagueOuterClass$Participant.class, leagueOuterClass$Participant);
    }

    private LeagueOuterClass$Participant() {
    }

    private void clearPhoneNumber() {
        this.phoneNumber_ = getDefaultInstance().getPhoneNumber();
    }

    private void clearTotalRank() {
        this.totalRank_ = 0;
    }

    private void clearTotalScore() {
        this.totalScore_ = 0;
    }

    private void clearUserId() {
        this.userId_ = 0;
    }

    private void clearWeeklyRank() {
        this.weeklyRank_ = 0;
    }

    private void clearWeeklyScore() {
        this.weeklyScore_ = 0;
    }

    public static LeagueOuterClass$Participant getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LeagueOuterClass$Participant parseDelimitedFrom(InputStream inputStream) {
        return (LeagueOuterClass$Participant) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LeagueOuterClass$Participant parseFrom(ByteBuffer byteBuffer) {
        return (LeagueOuterClass$Participant) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setPhoneNumber(String str) {
        str.getClass();
        this.phoneNumber_ = str;
    }

    private void setPhoneNumberBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.phoneNumber_ = abstractC2383g.f0();
    }

    private void setTotalRank(int i) {
        this.totalRank_ = i;
    }

    private void setTotalScore(int i) {
        this.totalScore_ = i;
    }

    private void setUserId(int i) {
        this.userId_ = i;
    }

    private void setWeeklyRank(int i) {
        this.weeklyRank_ = i;
    }

    private void setWeeklyScore(int i) {
        this.weeklyScore_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1909y0.a[gVar.ordinal()]) {
            case 1:
                return new LeagueOuterClass$Participant();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0006\u0000\u0000\u0001\u0006\u0006\u0000\u0000\u0000\u0001\u0004\u0002Ȉ\u0003\u0004\u0004\u0004\u0005\u0004\u0006\u0004", new Object[]{"userId_", "phoneNumber_", "weeklyScore_", "totalScore_", "weeklyRank_", "totalRank_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LeagueOuterClass$Participant.class) {
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

    public String getPhoneNumber() {
        return this.phoneNumber_;
    }

    public AbstractC2383g getPhoneNumberBytes() {
        return AbstractC2383g.N(this.phoneNumber_);
    }

    public int getTotalRank() {
        return this.totalRank_;
    }

    public int getTotalScore() {
        return this.totalScore_;
    }

    public int getUserId() {
        return this.userId_;
    }

    public int getWeeklyRank() {
        return this.weeklyRank_;
    }

    public int getWeeklyScore() {
        return this.weeklyScore_;
    }

    public static a newBuilder(LeagueOuterClass$Participant leagueOuterClass$Participant) {
        return (a) DEFAULT_INSTANCE.createBuilder(leagueOuterClass$Participant);
    }

    public static LeagueOuterClass$Participant parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LeagueOuterClass$Participant) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LeagueOuterClass$Participant parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LeagueOuterClass$Participant) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LeagueOuterClass$Participant parseFrom(AbstractC2383g abstractC2383g) {
        return (LeagueOuterClass$Participant) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LeagueOuterClass$Participant parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LeagueOuterClass$Participant) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LeagueOuterClass$Participant parseFrom(byte[] bArr) {
        return (LeagueOuterClass$Participant) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LeagueOuterClass$Participant parseFrom(byte[] bArr, C2394s c2394s) {
        return (LeagueOuterClass$Participant) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LeagueOuterClass$Participant parseFrom(InputStream inputStream) {
        return (LeagueOuterClass$Participant) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LeagueOuterClass$Participant parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LeagueOuterClass$Participant) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LeagueOuterClass$Participant parseFrom(AbstractC2384h abstractC2384h) {
        return (LeagueOuterClass$Participant) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LeagueOuterClass$Participant parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LeagueOuterClass$Participant) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
