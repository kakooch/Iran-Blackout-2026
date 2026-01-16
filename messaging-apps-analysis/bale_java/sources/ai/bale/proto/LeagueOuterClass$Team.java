package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC17442my3;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class LeagueOuterClass$Team extends GeneratedMessageLite implements InterfaceC17442my3 {
    private static final LeagueOuterClass$Team DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int TEAM_ID_FIELD_NUMBER = 1;
    public static final int TEAM_NAME_FIELD_NUMBER = 2;
    public static final int TEAM_URL_FIELD_NUMBER = 3;
    private int teamId_;
    private String teamName_ = "";
    private String teamUrl_ = "";

    public static final class a extends GeneratedMessageLite.b implements InterfaceC17442my3 {
        private a() {
            super(LeagueOuterClass$Team.DEFAULT_INSTANCE);
        }
    }

    static {
        LeagueOuterClass$Team leagueOuterClass$Team = new LeagueOuterClass$Team();
        DEFAULT_INSTANCE = leagueOuterClass$Team;
        GeneratedMessageLite.registerDefaultInstance(LeagueOuterClass$Team.class, leagueOuterClass$Team);
    }

    private LeagueOuterClass$Team() {
    }

    private void clearTeamId() {
        this.teamId_ = 0;
    }

    private void clearTeamName() {
        this.teamName_ = getDefaultInstance().getTeamName();
    }

    private void clearTeamUrl() {
        this.teamUrl_ = getDefaultInstance().getTeamUrl();
    }

    public static LeagueOuterClass$Team getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LeagueOuterClass$Team parseDelimitedFrom(InputStream inputStream) {
        return (LeagueOuterClass$Team) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LeagueOuterClass$Team parseFrom(ByteBuffer byteBuffer) {
        return (LeagueOuterClass$Team) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setTeamId(int i) {
        this.teamId_ = i;
    }

    private void setTeamName(String str) {
        str.getClass();
        this.teamName_ = str;
    }

    private void setTeamNameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.teamName_ = abstractC2383g.f0();
    }

    private void setTeamUrl(String str) {
        str.getClass();
        this.teamUrl_ = str;
    }

    private void setTeamUrlBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.teamUrl_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1909y0.a[gVar.ordinal()]) {
            case 1:
                return new LeagueOuterClass$Team();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0004\u0002Ȉ\u0003Ȉ", new Object[]{"teamId_", "teamName_", "teamUrl_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LeagueOuterClass$Team.class) {
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

    public int getTeamId() {
        return this.teamId_;
    }

    public String getTeamName() {
        return this.teamName_;
    }

    public AbstractC2383g getTeamNameBytes() {
        return AbstractC2383g.N(this.teamName_);
    }

    public String getTeamUrl() {
        return this.teamUrl_;
    }

    public AbstractC2383g getTeamUrlBytes() {
        return AbstractC2383g.N(this.teamUrl_);
    }

    public static a newBuilder(LeagueOuterClass$Team leagueOuterClass$Team) {
        return (a) DEFAULT_INSTANCE.createBuilder(leagueOuterClass$Team);
    }

    public static LeagueOuterClass$Team parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LeagueOuterClass$Team) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LeagueOuterClass$Team parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LeagueOuterClass$Team) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LeagueOuterClass$Team parseFrom(AbstractC2383g abstractC2383g) {
        return (LeagueOuterClass$Team) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LeagueOuterClass$Team parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LeagueOuterClass$Team) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LeagueOuterClass$Team parseFrom(byte[] bArr) {
        return (LeagueOuterClass$Team) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LeagueOuterClass$Team parseFrom(byte[] bArr, C2394s c2394s) {
        return (LeagueOuterClass$Team) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LeagueOuterClass$Team parseFrom(InputStream inputStream) {
        return (LeagueOuterClass$Team) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LeagueOuterClass$Team parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LeagueOuterClass$Team) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LeagueOuterClass$Team parseFrom(AbstractC2384h abstractC2384h) {
        return (LeagueOuterClass$Team) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LeagueOuterClass$Team parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LeagueOuterClass$Team) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
