package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC13878gy3;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class LeagueOuterClass$GetMatchesResponse extends GeneratedMessageLite implements U64 {
    private static final LeagueOuterClass$GetMatchesResponse DEFAULT_INSTANCE;
    public static final int MATCHES_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private B.j matches_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(LeagueOuterClass$GetMatchesResponse.DEFAULT_INSTANCE);
        }
    }

    static {
        LeagueOuterClass$GetMatchesResponse leagueOuterClass$GetMatchesResponse = new LeagueOuterClass$GetMatchesResponse();
        DEFAULT_INSTANCE = leagueOuterClass$GetMatchesResponse;
        GeneratedMessageLite.registerDefaultInstance(LeagueOuterClass$GetMatchesResponse.class, leagueOuterClass$GetMatchesResponse);
    }

    private LeagueOuterClass$GetMatchesResponse() {
    }

    private void addAllMatches(Iterable<? extends LeagueOuterClass$Match> iterable) {
        ensureMatchesIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.matches_);
    }

    private void addMatches(LeagueOuterClass$Match leagueOuterClass$Match) {
        leagueOuterClass$Match.getClass();
        ensureMatchesIsMutable();
        this.matches_.add(leagueOuterClass$Match);
    }

    private void clearMatches() {
        this.matches_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureMatchesIsMutable() {
        B.j jVar = this.matches_;
        if (jVar.u()) {
            return;
        }
        this.matches_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static LeagueOuterClass$GetMatchesResponse getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LeagueOuterClass$GetMatchesResponse parseDelimitedFrom(InputStream inputStream) {
        return (LeagueOuterClass$GetMatchesResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LeagueOuterClass$GetMatchesResponse parseFrom(ByteBuffer byteBuffer) {
        return (LeagueOuterClass$GetMatchesResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeMatches(int i) {
        ensureMatchesIsMutable();
        this.matches_.remove(i);
    }

    private void setMatches(int i, LeagueOuterClass$Match leagueOuterClass$Match) {
        leagueOuterClass$Match.getClass();
        ensureMatchesIsMutable();
        this.matches_.set(i, leagueOuterClass$Match);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1909y0.a[gVar.ordinal()]) {
            case 1:
                return new LeagueOuterClass$GetMatchesResponse();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"matches_", LeagueOuterClass$Match.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LeagueOuterClass$GetMatchesResponse.class) {
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

    public LeagueOuterClass$Match getMatches(int i) {
        return (LeagueOuterClass$Match) this.matches_.get(i);
    }

    public int getMatchesCount() {
        return this.matches_.size();
    }

    public List<LeagueOuterClass$Match> getMatchesList() {
        return this.matches_;
    }

    public InterfaceC13878gy3 getMatchesOrBuilder(int i) {
        return (InterfaceC13878gy3) this.matches_.get(i);
    }

    public List<? extends InterfaceC13878gy3> getMatchesOrBuilderList() {
        return this.matches_;
    }

    public static a newBuilder(LeagueOuterClass$GetMatchesResponse leagueOuterClass$GetMatchesResponse) {
        return (a) DEFAULT_INSTANCE.createBuilder(leagueOuterClass$GetMatchesResponse);
    }

    public static LeagueOuterClass$GetMatchesResponse parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LeagueOuterClass$GetMatchesResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LeagueOuterClass$GetMatchesResponse parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LeagueOuterClass$GetMatchesResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LeagueOuterClass$GetMatchesResponse parseFrom(AbstractC2383g abstractC2383g) {
        return (LeagueOuterClass$GetMatchesResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addMatches(int i, LeagueOuterClass$Match leagueOuterClass$Match) {
        leagueOuterClass$Match.getClass();
        ensureMatchesIsMutable();
        this.matches_.add(i, leagueOuterClass$Match);
    }

    public static LeagueOuterClass$GetMatchesResponse parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LeagueOuterClass$GetMatchesResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LeagueOuterClass$GetMatchesResponse parseFrom(byte[] bArr) {
        return (LeagueOuterClass$GetMatchesResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LeagueOuterClass$GetMatchesResponse parseFrom(byte[] bArr, C2394s c2394s) {
        return (LeagueOuterClass$GetMatchesResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LeagueOuterClass$GetMatchesResponse parseFrom(InputStream inputStream) {
        return (LeagueOuterClass$GetMatchesResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LeagueOuterClass$GetMatchesResponse parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LeagueOuterClass$GetMatchesResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LeagueOuterClass$GetMatchesResponse parseFrom(AbstractC2384h abstractC2384h) {
        return (LeagueOuterClass$GetMatchesResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LeagueOuterClass$GetMatchesResponse parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LeagueOuterClass$GetMatchesResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
