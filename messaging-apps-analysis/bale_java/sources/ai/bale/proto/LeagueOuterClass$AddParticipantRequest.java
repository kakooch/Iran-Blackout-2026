package ai.bale.proto;

import ai.bale.proto.LeagueOuterClass$Participant;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class LeagueOuterClass$AddParticipantRequest extends GeneratedMessageLite implements U64 {
    private static final LeagueOuterClass$AddParticipantRequest DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int PARTICIPANT_FIELD_NUMBER = 1;
    private int bitField0_;
    private LeagueOuterClass$Participant participant_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(LeagueOuterClass$AddParticipantRequest.DEFAULT_INSTANCE);
        }
    }

    static {
        LeagueOuterClass$AddParticipantRequest leagueOuterClass$AddParticipantRequest = new LeagueOuterClass$AddParticipantRequest();
        DEFAULT_INSTANCE = leagueOuterClass$AddParticipantRequest;
        GeneratedMessageLite.registerDefaultInstance(LeagueOuterClass$AddParticipantRequest.class, leagueOuterClass$AddParticipantRequest);
    }

    private LeagueOuterClass$AddParticipantRequest() {
    }

    private void clearParticipant() {
        this.participant_ = null;
        this.bitField0_ &= -2;
    }

    public static LeagueOuterClass$AddParticipantRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeParticipant(LeagueOuterClass$Participant leagueOuterClass$Participant) {
        leagueOuterClass$Participant.getClass();
        LeagueOuterClass$Participant leagueOuterClass$Participant2 = this.participant_;
        if (leagueOuterClass$Participant2 == null || leagueOuterClass$Participant2 == LeagueOuterClass$Participant.getDefaultInstance()) {
            this.participant_ = leagueOuterClass$Participant;
        } else {
            this.participant_ = (LeagueOuterClass$Participant) ((LeagueOuterClass$Participant.a) LeagueOuterClass$Participant.newBuilder(this.participant_).v(leagueOuterClass$Participant)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LeagueOuterClass$AddParticipantRequest parseDelimitedFrom(InputStream inputStream) {
        return (LeagueOuterClass$AddParticipantRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LeagueOuterClass$AddParticipantRequest parseFrom(ByteBuffer byteBuffer) {
        return (LeagueOuterClass$AddParticipantRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setParticipant(LeagueOuterClass$Participant leagueOuterClass$Participant) {
        leagueOuterClass$Participant.getClass();
        this.participant_ = leagueOuterClass$Participant;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1909y0.a[gVar.ordinal()]) {
            case 1:
                return new LeagueOuterClass$AddParticipantRequest();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "participant_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LeagueOuterClass$AddParticipantRequest.class) {
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

    public LeagueOuterClass$Participant getParticipant() {
        LeagueOuterClass$Participant leagueOuterClass$Participant = this.participant_;
        return leagueOuterClass$Participant == null ? LeagueOuterClass$Participant.getDefaultInstance() : leagueOuterClass$Participant;
    }

    public boolean hasParticipant() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(LeagueOuterClass$AddParticipantRequest leagueOuterClass$AddParticipantRequest) {
        return (a) DEFAULT_INSTANCE.createBuilder(leagueOuterClass$AddParticipantRequest);
    }

    public static LeagueOuterClass$AddParticipantRequest parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LeagueOuterClass$AddParticipantRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LeagueOuterClass$AddParticipantRequest parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LeagueOuterClass$AddParticipantRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LeagueOuterClass$AddParticipantRequest parseFrom(AbstractC2383g abstractC2383g) {
        return (LeagueOuterClass$AddParticipantRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LeagueOuterClass$AddParticipantRequest parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LeagueOuterClass$AddParticipantRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LeagueOuterClass$AddParticipantRequest parseFrom(byte[] bArr) {
        return (LeagueOuterClass$AddParticipantRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LeagueOuterClass$AddParticipantRequest parseFrom(byte[] bArr, C2394s c2394s) {
        return (LeagueOuterClass$AddParticipantRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LeagueOuterClass$AddParticipantRequest parseFrom(InputStream inputStream) {
        return (LeagueOuterClass$AddParticipantRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LeagueOuterClass$AddParticipantRequest parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LeagueOuterClass$AddParticipantRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LeagueOuterClass$AddParticipantRequest parseFrom(AbstractC2384h abstractC2384h) {
        return (LeagueOuterClass$AddParticipantRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LeagueOuterClass$AddParticipantRequest parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LeagueOuterClass$AddParticipantRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
