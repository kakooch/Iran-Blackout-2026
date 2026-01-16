package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC15078iy3;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class LeagueOuterClass$GetParticipantTotalRankResponse extends GeneratedMessageLite implements U64 {
    private static final LeagueOuterClass$GetParticipantTotalRankResponse DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int PARTICIPANTS_FIELD_NUMBER = 1;
    private B.j participants_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(LeagueOuterClass$GetParticipantTotalRankResponse.DEFAULT_INSTANCE);
        }
    }

    static {
        LeagueOuterClass$GetParticipantTotalRankResponse leagueOuterClass$GetParticipantTotalRankResponse = new LeagueOuterClass$GetParticipantTotalRankResponse();
        DEFAULT_INSTANCE = leagueOuterClass$GetParticipantTotalRankResponse;
        GeneratedMessageLite.registerDefaultInstance(LeagueOuterClass$GetParticipantTotalRankResponse.class, leagueOuterClass$GetParticipantTotalRankResponse);
    }

    private LeagueOuterClass$GetParticipantTotalRankResponse() {
    }

    private void addAllParticipants(Iterable<? extends LeagueOuterClass$Participant> iterable) {
        ensureParticipantsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.participants_);
    }

    private void addParticipants(LeagueOuterClass$Participant leagueOuterClass$Participant) {
        leagueOuterClass$Participant.getClass();
        ensureParticipantsIsMutable();
        this.participants_.add(leagueOuterClass$Participant);
    }

    private void clearParticipants() {
        this.participants_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureParticipantsIsMutable() {
        B.j jVar = this.participants_;
        if (jVar.u()) {
            return;
        }
        this.participants_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static LeagueOuterClass$GetParticipantTotalRankResponse getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LeagueOuterClass$GetParticipantTotalRankResponse parseDelimitedFrom(InputStream inputStream) {
        return (LeagueOuterClass$GetParticipantTotalRankResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LeagueOuterClass$GetParticipantTotalRankResponse parseFrom(ByteBuffer byteBuffer) {
        return (LeagueOuterClass$GetParticipantTotalRankResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeParticipants(int i) {
        ensureParticipantsIsMutable();
        this.participants_.remove(i);
    }

    private void setParticipants(int i, LeagueOuterClass$Participant leagueOuterClass$Participant) {
        leagueOuterClass$Participant.getClass();
        ensureParticipantsIsMutable();
        this.participants_.set(i, leagueOuterClass$Participant);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1909y0.a[gVar.ordinal()]) {
            case 1:
                return new LeagueOuterClass$GetParticipantTotalRankResponse();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"participants_", LeagueOuterClass$Participant.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LeagueOuterClass$GetParticipantTotalRankResponse.class) {
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

    public LeagueOuterClass$Participant getParticipants(int i) {
        return (LeagueOuterClass$Participant) this.participants_.get(i);
    }

    public int getParticipantsCount() {
        return this.participants_.size();
    }

    public List<LeagueOuterClass$Participant> getParticipantsList() {
        return this.participants_;
    }

    public InterfaceC15078iy3 getParticipantsOrBuilder(int i) {
        return (InterfaceC15078iy3) this.participants_.get(i);
    }

    public List<? extends InterfaceC15078iy3> getParticipantsOrBuilderList() {
        return this.participants_;
    }

    public static a newBuilder(LeagueOuterClass$GetParticipantTotalRankResponse leagueOuterClass$GetParticipantTotalRankResponse) {
        return (a) DEFAULT_INSTANCE.createBuilder(leagueOuterClass$GetParticipantTotalRankResponse);
    }

    public static LeagueOuterClass$GetParticipantTotalRankResponse parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LeagueOuterClass$GetParticipantTotalRankResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LeagueOuterClass$GetParticipantTotalRankResponse parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LeagueOuterClass$GetParticipantTotalRankResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LeagueOuterClass$GetParticipantTotalRankResponse parseFrom(AbstractC2383g abstractC2383g) {
        return (LeagueOuterClass$GetParticipantTotalRankResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addParticipants(int i, LeagueOuterClass$Participant leagueOuterClass$Participant) {
        leagueOuterClass$Participant.getClass();
        ensureParticipantsIsMutable();
        this.participants_.add(i, leagueOuterClass$Participant);
    }

    public static LeagueOuterClass$GetParticipantTotalRankResponse parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LeagueOuterClass$GetParticipantTotalRankResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LeagueOuterClass$GetParticipantTotalRankResponse parseFrom(byte[] bArr) {
        return (LeagueOuterClass$GetParticipantTotalRankResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LeagueOuterClass$GetParticipantTotalRankResponse parseFrom(byte[] bArr, C2394s c2394s) {
        return (LeagueOuterClass$GetParticipantTotalRankResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LeagueOuterClass$GetParticipantTotalRankResponse parseFrom(InputStream inputStream) {
        return (LeagueOuterClass$GetParticipantTotalRankResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LeagueOuterClass$GetParticipantTotalRankResponse parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LeagueOuterClass$GetParticipantTotalRankResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LeagueOuterClass$GetParticipantTotalRankResponse parseFrom(AbstractC2384h abstractC2384h) {
        return (LeagueOuterClass$GetParticipantTotalRankResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LeagueOuterClass$GetParticipantTotalRankResponse parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LeagueOuterClass$GetParticipantTotalRankResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
