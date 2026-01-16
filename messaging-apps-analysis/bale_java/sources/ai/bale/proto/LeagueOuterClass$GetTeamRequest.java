package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class LeagueOuterClass$GetTeamRequest extends GeneratedMessageLite implements U64 {
    private static final LeagueOuterClass$GetTeamRequest DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int TEAM_ID_FIELD_NUMBER = 1;
    private int teamId_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(LeagueOuterClass$GetTeamRequest.DEFAULT_INSTANCE);
        }
    }

    static {
        LeagueOuterClass$GetTeamRequest leagueOuterClass$GetTeamRequest = new LeagueOuterClass$GetTeamRequest();
        DEFAULT_INSTANCE = leagueOuterClass$GetTeamRequest;
        GeneratedMessageLite.registerDefaultInstance(LeagueOuterClass$GetTeamRequest.class, leagueOuterClass$GetTeamRequest);
    }

    private LeagueOuterClass$GetTeamRequest() {
    }

    private void clearTeamId() {
        this.teamId_ = 0;
    }

    public static LeagueOuterClass$GetTeamRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LeagueOuterClass$GetTeamRequest parseDelimitedFrom(InputStream inputStream) {
        return (LeagueOuterClass$GetTeamRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LeagueOuterClass$GetTeamRequest parseFrom(ByteBuffer byteBuffer) {
        return (LeagueOuterClass$GetTeamRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setTeamId(int i) {
        this.teamId_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1909y0.a[gVar.ordinal()]) {
            case 1:
                return new LeagueOuterClass$GetTeamRequest();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0004", new Object[]{"teamId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LeagueOuterClass$GetTeamRequest.class) {
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

    public static a newBuilder(LeagueOuterClass$GetTeamRequest leagueOuterClass$GetTeamRequest) {
        return (a) DEFAULT_INSTANCE.createBuilder(leagueOuterClass$GetTeamRequest);
    }

    public static LeagueOuterClass$GetTeamRequest parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LeagueOuterClass$GetTeamRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LeagueOuterClass$GetTeamRequest parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LeagueOuterClass$GetTeamRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LeagueOuterClass$GetTeamRequest parseFrom(AbstractC2383g abstractC2383g) {
        return (LeagueOuterClass$GetTeamRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LeagueOuterClass$GetTeamRequest parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LeagueOuterClass$GetTeamRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LeagueOuterClass$GetTeamRequest parseFrom(byte[] bArr) {
        return (LeagueOuterClass$GetTeamRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LeagueOuterClass$GetTeamRequest parseFrom(byte[] bArr, C2394s c2394s) {
        return (LeagueOuterClass$GetTeamRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LeagueOuterClass$GetTeamRequest parseFrom(InputStream inputStream) {
        return (LeagueOuterClass$GetTeamRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LeagueOuterClass$GetTeamRequest parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LeagueOuterClass$GetTeamRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LeagueOuterClass$GetTeamRequest parseFrom(AbstractC2384h abstractC2384h) {
        return (LeagueOuterClass$GetTeamRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LeagueOuterClass$GetTeamRequest parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LeagueOuterClass$GetTeamRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
