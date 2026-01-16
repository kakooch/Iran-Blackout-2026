package ai.bale.proto;

import ai.bale.proto.LeagueOuterClass$Team;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class LeagueOuterClass$GetTeamResponse extends GeneratedMessageLite implements U64 {
    private static final LeagueOuterClass$GetTeamResponse DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int TEAM_FIELD_NUMBER = 1;
    private int bitField0_;
    private LeagueOuterClass$Team team_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(LeagueOuterClass$GetTeamResponse.DEFAULT_INSTANCE);
        }
    }

    static {
        LeagueOuterClass$GetTeamResponse leagueOuterClass$GetTeamResponse = new LeagueOuterClass$GetTeamResponse();
        DEFAULT_INSTANCE = leagueOuterClass$GetTeamResponse;
        GeneratedMessageLite.registerDefaultInstance(LeagueOuterClass$GetTeamResponse.class, leagueOuterClass$GetTeamResponse);
    }

    private LeagueOuterClass$GetTeamResponse() {
    }

    private void clearTeam() {
        this.team_ = null;
        this.bitField0_ &= -2;
    }

    public static LeagueOuterClass$GetTeamResponse getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeTeam(LeagueOuterClass$Team leagueOuterClass$Team) {
        leagueOuterClass$Team.getClass();
        LeagueOuterClass$Team leagueOuterClass$Team2 = this.team_;
        if (leagueOuterClass$Team2 == null || leagueOuterClass$Team2 == LeagueOuterClass$Team.getDefaultInstance()) {
            this.team_ = leagueOuterClass$Team;
        } else {
            this.team_ = (LeagueOuterClass$Team) ((LeagueOuterClass$Team.a) LeagueOuterClass$Team.newBuilder(this.team_).v(leagueOuterClass$Team)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LeagueOuterClass$GetTeamResponse parseDelimitedFrom(InputStream inputStream) {
        return (LeagueOuterClass$GetTeamResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LeagueOuterClass$GetTeamResponse parseFrom(ByteBuffer byteBuffer) {
        return (LeagueOuterClass$GetTeamResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setTeam(LeagueOuterClass$Team leagueOuterClass$Team) {
        leagueOuterClass$Team.getClass();
        this.team_ = leagueOuterClass$Team;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1909y0.a[gVar.ordinal()]) {
            case 1:
                return new LeagueOuterClass$GetTeamResponse();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "team_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LeagueOuterClass$GetTeamResponse.class) {
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

    public LeagueOuterClass$Team getTeam() {
        LeagueOuterClass$Team leagueOuterClass$Team = this.team_;
        return leagueOuterClass$Team == null ? LeagueOuterClass$Team.getDefaultInstance() : leagueOuterClass$Team;
    }

    public boolean hasTeam() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(LeagueOuterClass$GetTeamResponse leagueOuterClass$GetTeamResponse) {
        return (a) DEFAULT_INSTANCE.createBuilder(leagueOuterClass$GetTeamResponse);
    }

    public static LeagueOuterClass$GetTeamResponse parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LeagueOuterClass$GetTeamResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LeagueOuterClass$GetTeamResponse parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LeagueOuterClass$GetTeamResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LeagueOuterClass$GetTeamResponse parseFrom(AbstractC2383g abstractC2383g) {
        return (LeagueOuterClass$GetTeamResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LeagueOuterClass$GetTeamResponse parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LeagueOuterClass$GetTeamResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LeagueOuterClass$GetTeamResponse parseFrom(byte[] bArr) {
        return (LeagueOuterClass$GetTeamResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LeagueOuterClass$GetTeamResponse parseFrom(byte[] bArr, C2394s c2394s) {
        return (LeagueOuterClass$GetTeamResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LeagueOuterClass$GetTeamResponse parseFrom(InputStream inputStream) {
        return (LeagueOuterClass$GetTeamResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LeagueOuterClass$GetTeamResponse parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LeagueOuterClass$GetTeamResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LeagueOuterClass$GetTeamResponse parseFrom(AbstractC2384h abstractC2384h) {
        return (LeagueOuterClass$GetTeamResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LeagueOuterClass$GetTeamResponse parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LeagueOuterClass$GetTeamResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
