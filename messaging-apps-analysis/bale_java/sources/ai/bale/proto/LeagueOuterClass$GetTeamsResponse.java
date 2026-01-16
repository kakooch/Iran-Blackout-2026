package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC17442my3;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class LeagueOuterClass$GetTeamsResponse extends GeneratedMessageLite implements U64 {
    private static final LeagueOuterClass$GetTeamsResponse DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int TEAMS_FIELD_NUMBER = 1;
    private B.j teams_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(LeagueOuterClass$GetTeamsResponse.DEFAULT_INSTANCE);
        }
    }

    static {
        LeagueOuterClass$GetTeamsResponse leagueOuterClass$GetTeamsResponse = new LeagueOuterClass$GetTeamsResponse();
        DEFAULT_INSTANCE = leagueOuterClass$GetTeamsResponse;
        GeneratedMessageLite.registerDefaultInstance(LeagueOuterClass$GetTeamsResponse.class, leagueOuterClass$GetTeamsResponse);
    }

    private LeagueOuterClass$GetTeamsResponse() {
    }

    private void addAllTeams(Iterable<? extends LeagueOuterClass$Team> iterable) {
        ensureTeamsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.teams_);
    }

    private void addTeams(LeagueOuterClass$Team leagueOuterClass$Team) {
        leagueOuterClass$Team.getClass();
        ensureTeamsIsMutable();
        this.teams_.add(leagueOuterClass$Team);
    }

    private void clearTeams() {
        this.teams_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureTeamsIsMutable() {
        B.j jVar = this.teams_;
        if (jVar.u()) {
            return;
        }
        this.teams_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static LeagueOuterClass$GetTeamsResponse getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LeagueOuterClass$GetTeamsResponse parseDelimitedFrom(InputStream inputStream) {
        return (LeagueOuterClass$GetTeamsResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LeagueOuterClass$GetTeamsResponse parseFrom(ByteBuffer byteBuffer) {
        return (LeagueOuterClass$GetTeamsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeTeams(int i) {
        ensureTeamsIsMutable();
        this.teams_.remove(i);
    }

    private void setTeams(int i, LeagueOuterClass$Team leagueOuterClass$Team) {
        leagueOuterClass$Team.getClass();
        ensureTeamsIsMutable();
        this.teams_.set(i, leagueOuterClass$Team);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1909y0.a[gVar.ordinal()]) {
            case 1:
                return new LeagueOuterClass$GetTeamsResponse();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"teams_", LeagueOuterClass$Team.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LeagueOuterClass$GetTeamsResponse.class) {
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

    public LeagueOuterClass$Team getTeams(int i) {
        return (LeagueOuterClass$Team) this.teams_.get(i);
    }

    public int getTeamsCount() {
        return this.teams_.size();
    }

    public List<LeagueOuterClass$Team> getTeamsList() {
        return this.teams_;
    }

    public InterfaceC17442my3 getTeamsOrBuilder(int i) {
        return (InterfaceC17442my3) this.teams_.get(i);
    }

    public List<? extends InterfaceC17442my3> getTeamsOrBuilderList() {
        return this.teams_;
    }

    public static a newBuilder(LeagueOuterClass$GetTeamsResponse leagueOuterClass$GetTeamsResponse) {
        return (a) DEFAULT_INSTANCE.createBuilder(leagueOuterClass$GetTeamsResponse);
    }

    public static LeagueOuterClass$GetTeamsResponse parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LeagueOuterClass$GetTeamsResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LeagueOuterClass$GetTeamsResponse parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LeagueOuterClass$GetTeamsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LeagueOuterClass$GetTeamsResponse parseFrom(AbstractC2383g abstractC2383g) {
        return (LeagueOuterClass$GetTeamsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addTeams(int i, LeagueOuterClass$Team leagueOuterClass$Team) {
        leagueOuterClass$Team.getClass();
        ensureTeamsIsMutable();
        this.teams_.add(i, leagueOuterClass$Team);
    }

    public static LeagueOuterClass$GetTeamsResponse parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LeagueOuterClass$GetTeamsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LeagueOuterClass$GetTeamsResponse parseFrom(byte[] bArr) {
        return (LeagueOuterClass$GetTeamsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LeagueOuterClass$GetTeamsResponse parseFrom(byte[] bArr, C2394s c2394s) {
        return (LeagueOuterClass$GetTeamsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LeagueOuterClass$GetTeamsResponse parseFrom(InputStream inputStream) {
        return (LeagueOuterClass$GetTeamsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LeagueOuterClass$GetTeamsResponse parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LeagueOuterClass$GetTeamsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LeagueOuterClass$GetTeamsResponse parseFrom(AbstractC2384h abstractC2384h) {
        return (LeagueOuterClass$GetTeamsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LeagueOuterClass$GetTeamsResponse parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LeagueOuterClass$GetTeamsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
