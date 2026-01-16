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
public final class LeagueOuterClass$GetPredictionsByMatchIdRequest extends GeneratedMessageLite implements U64 {
    private static final LeagueOuterClass$GetPredictionsByMatchIdRequest DEFAULT_INSTANCE;
    public static final int MATCH_ID_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private int matchId_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(LeagueOuterClass$GetPredictionsByMatchIdRequest.DEFAULT_INSTANCE);
        }
    }

    static {
        LeagueOuterClass$GetPredictionsByMatchIdRequest leagueOuterClass$GetPredictionsByMatchIdRequest = new LeagueOuterClass$GetPredictionsByMatchIdRequest();
        DEFAULT_INSTANCE = leagueOuterClass$GetPredictionsByMatchIdRequest;
        GeneratedMessageLite.registerDefaultInstance(LeagueOuterClass$GetPredictionsByMatchIdRequest.class, leagueOuterClass$GetPredictionsByMatchIdRequest);
    }

    private LeagueOuterClass$GetPredictionsByMatchIdRequest() {
    }

    private void clearMatchId() {
        this.matchId_ = 0;
    }

    public static LeagueOuterClass$GetPredictionsByMatchIdRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LeagueOuterClass$GetPredictionsByMatchIdRequest parseDelimitedFrom(InputStream inputStream) {
        return (LeagueOuterClass$GetPredictionsByMatchIdRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LeagueOuterClass$GetPredictionsByMatchIdRequest parseFrom(ByteBuffer byteBuffer) {
        return (LeagueOuterClass$GetPredictionsByMatchIdRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setMatchId(int i) {
        this.matchId_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1909y0.a[gVar.ordinal()]) {
            case 1:
                return new LeagueOuterClass$GetPredictionsByMatchIdRequest();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0004", new Object[]{"matchId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LeagueOuterClass$GetPredictionsByMatchIdRequest.class) {
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

    public int getMatchId() {
        return this.matchId_;
    }

    public static a newBuilder(LeagueOuterClass$GetPredictionsByMatchIdRequest leagueOuterClass$GetPredictionsByMatchIdRequest) {
        return (a) DEFAULT_INSTANCE.createBuilder(leagueOuterClass$GetPredictionsByMatchIdRequest);
    }

    public static LeagueOuterClass$GetPredictionsByMatchIdRequest parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LeagueOuterClass$GetPredictionsByMatchIdRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LeagueOuterClass$GetPredictionsByMatchIdRequest parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LeagueOuterClass$GetPredictionsByMatchIdRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LeagueOuterClass$GetPredictionsByMatchIdRequest parseFrom(AbstractC2383g abstractC2383g) {
        return (LeagueOuterClass$GetPredictionsByMatchIdRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LeagueOuterClass$GetPredictionsByMatchIdRequest parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LeagueOuterClass$GetPredictionsByMatchIdRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LeagueOuterClass$GetPredictionsByMatchIdRequest parseFrom(byte[] bArr) {
        return (LeagueOuterClass$GetPredictionsByMatchIdRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LeagueOuterClass$GetPredictionsByMatchIdRequest parseFrom(byte[] bArr, C2394s c2394s) {
        return (LeagueOuterClass$GetPredictionsByMatchIdRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LeagueOuterClass$GetPredictionsByMatchIdRequest parseFrom(InputStream inputStream) {
        return (LeagueOuterClass$GetPredictionsByMatchIdRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LeagueOuterClass$GetPredictionsByMatchIdRequest parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LeagueOuterClass$GetPredictionsByMatchIdRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LeagueOuterClass$GetPredictionsByMatchIdRequest parseFrom(AbstractC2384h abstractC2384h) {
        return (LeagueOuterClass$GetPredictionsByMatchIdRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LeagueOuterClass$GetPredictionsByMatchIdRequest parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LeagueOuterClass$GetPredictionsByMatchIdRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
