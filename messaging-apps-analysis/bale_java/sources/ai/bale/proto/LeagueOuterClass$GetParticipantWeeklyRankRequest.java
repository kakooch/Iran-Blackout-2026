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
public final class LeagueOuterClass$GetParticipantWeeklyRankRequest extends GeneratedMessageLite implements U64 {
    private static final LeagueOuterClass$GetParticipantWeeklyRankRequest DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int USER_ID_FIELD_NUMBER = 1;
    private int userId_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(LeagueOuterClass$GetParticipantWeeklyRankRequest.DEFAULT_INSTANCE);
        }
    }

    static {
        LeagueOuterClass$GetParticipantWeeklyRankRequest leagueOuterClass$GetParticipantWeeklyRankRequest = new LeagueOuterClass$GetParticipantWeeklyRankRequest();
        DEFAULT_INSTANCE = leagueOuterClass$GetParticipantWeeklyRankRequest;
        GeneratedMessageLite.registerDefaultInstance(LeagueOuterClass$GetParticipantWeeklyRankRequest.class, leagueOuterClass$GetParticipantWeeklyRankRequest);
    }

    private LeagueOuterClass$GetParticipantWeeklyRankRequest() {
    }

    private void clearUserId() {
        this.userId_ = 0;
    }

    public static LeagueOuterClass$GetParticipantWeeklyRankRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LeagueOuterClass$GetParticipantWeeklyRankRequest parseDelimitedFrom(InputStream inputStream) {
        return (LeagueOuterClass$GetParticipantWeeklyRankRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LeagueOuterClass$GetParticipantWeeklyRankRequest parseFrom(ByteBuffer byteBuffer) {
        return (LeagueOuterClass$GetParticipantWeeklyRankRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setUserId(int i) {
        this.userId_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1909y0.a[gVar.ordinal()]) {
            case 1:
                return new LeagueOuterClass$GetParticipantWeeklyRankRequest();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0004", new Object[]{"userId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LeagueOuterClass$GetParticipantWeeklyRankRequest.class) {
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

    public int getUserId() {
        return this.userId_;
    }

    public static a newBuilder(LeagueOuterClass$GetParticipantWeeklyRankRequest leagueOuterClass$GetParticipantWeeklyRankRequest) {
        return (a) DEFAULT_INSTANCE.createBuilder(leagueOuterClass$GetParticipantWeeklyRankRequest);
    }

    public static LeagueOuterClass$GetParticipantWeeklyRankRequest parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LeagueOuterClass$GetParticipantWeeklyRankRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LeagueOuterClass$GetParticipantWeeklyRankRequest parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LeagueOuterClass$GetParticipantWeeklyRankRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LeagueOuterClass$GetParticipantWeeklyRankRequest parseFrom(AbstractC2383g abstractC2383g) {
        return (LeagueOuterClass$GetParticipantWeeklyRankRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LeagueOuterClass$GetParticipantWeeklyRankRequest parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LeagueOuterClass$GetParticipantWeeklyRankRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LeagueOuterClass$GetParticipantWeeklyRankRequest parseFrom(byte[] bArr) {
        return (LeagueOuterClass$GetParticipantWeeklyRankRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LeagueOuterClass$GetParticipantWeeklyRankRequest parseFrom(byte[] bArr, C2394s c2394s) {
        return (LeagueOuterClass$GetParticipantWeeklyRankRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LeagueOuterClass$GetParticipantWeeklyRankRequest parseFrom(InputStream inputStream) {
        return (LeagueOuterClass$GetParticipantWeeklyRankRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LeagueOuterClass$GetParticipantWeeklyRankRequest parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LeagueOuterClass$GetParticipantWeeklyRankRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LeagueOuterClass$GetParticipantWeeklyRankRequest parseFrom(AbstractC2384h abstractC2384h) {
        return (LeagueOuterClass$GetParticipantWeeklyRankRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LeagueOuterClass$GetParticipantWeeklyRankRequest parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LeagueOuterClass$GetParticipantWeeklyRankRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
