package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC6630Oh5;
import ir.nasim.InterfaceC8783Xh5;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class PollStruct$FullOptionResult extends GeneratedMessageLite implements InterfaceC6630Oh5 {
    private static final PollStruct$FullOptionResult DEFAULT_INSTANCE;
    public static final int OPTION_ID_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int VOTERS_FIELD_NUMBER = 3;
    public static final int VOTES_COUNT_FIELD_NUMBER = 2;
    private int optionId_;
    private B.j voters_ = GeneratedMessageLite.emptyProtobufList();
    private int votesCount_;

    public static final class a extends GeneratedMessageLite.b implements InterfaceC6630Oh5 {
        private a() {
            super(PollStruct$FullOptionResult.DEFAULT_INSTANCE);
        }
    }

    static {
        PollStruct$FullOptionResult pollStruct$FullOptionResult = new PollStruct$FullOptionResult();
        DEFAULT_INSTANCE = pollStruct$FullOptionResult;
        GeneratedMessageLite.registerDefaultInstance(PollStruct$FullOptionResult.class, pollStruct$FullOptionResult);
    }

    private PollStruct$FullOptionResult() {
    }

    private void addAllVoters(Iterable<? extends PollStruct$Voter> iterable) {
        ensureVotersIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.voters_);
    }

    private void addVoters(PollStruct$Voter pollStruct$Voter) {
        pollStruct$Voter.getClass();
        ensureVotersIsMutable();
        this.voters_.add(pollStruct$Voter);
    }

    private void clearOptionId() {
        this.optionId_ = 0;
    }

    private void clearVoters() {
        this.voters_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearVotesCount() {
        this.votesCount_ = 0;
    }

    private void ensureVotersIsMutable() {
        B.j jVar = this.voters_;
        if (jVar.u()) {
            return;
        }
        this.voters_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static PollStruct$FullOptionResult getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static PollStruct$FullOptionResult parseDelimitedFrom(InputStream inputStream) {
        return (PollStruct$FullOptionResult) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PollStruct$FullOptionResult parseFrom(ByteBuffer byteBuffer) {
        return (PollStruct$FullOptionResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeVoters(int i) {
        ensureVotersIsMutable();
        this.voters_.remove(i);
    }

    private void setOptionId(int i) {
        this.optionId_ = i;
    }

    private void setVoters(int i, PollStruct$Voter pollStruct$Voter) {
        pollStruct$Voter.getClass();
        ensureVotersIsMutable();
        this.voters_.set(i, pollStruct$Voter);
    }

    private void setVotesCount(int i) {
        this.votesCount_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1857g1.a[gVar.ordinal()]) {
            case 1:
                return new PollStruct$FullOptionResult();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0001\u0000\u0001\u0004\u0002\u0004\u0003\u001b", new Object[]{"optionId_", "votesCount_", "voters_", PollStruct$Voter.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (PollStruct$FullOptionResult.class) {
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

    public int getOptionId() {
        return this.optionId_;
    }

    public PollStruct$Voter getVoters(int i) {
        return (PollStruct$Voter) this.voters_.get(i);
    }

    public int getVotersCount() {
        return this.voters_.size();
    }

    public List<PollStruct$Voter> getVotersList() {
        return this.voters_;
    }

    public InterfaceC8783Xh5 getVotersOrBuilder(int i) {
        return (InterfaceC8783Xh5) this.voters_.get(i);
    }

    public List<? extends InterfaceC8783Xh5> getVotersOrBuilderList() {
        return this.voters_;
    }

    public int getVotesCount() {
        return this.votesCount_;
    }

    public static a newBuilder(PollStruct$FullOptionResult pollStruct$FullOptionResult) {
        return (a) DEFAULT_INSTANCE.createBuilder(pollStruct$FullOptionResult);
    }

    public static PollStruct$FullOptionResult parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (PollStruct$FullOptionResult) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PollStruct$FullOptionResult parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (PollStruct$FullOptionResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static PollStruct$FullOptionResult parseFrom(AbstractC2383g abstractC2383g) {
        return (PollStruct$FullOptionResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addVoters(int i, PollStruct$Voter pollStruct$Voter) {
        pollStruct$Voter.getClass();
        ensureVotersIsMutable();
        this.voters_.add(i, pollStruct$Voter);
    }

    public static PollStruct$FullOptionResult parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (PollStruct$FullOptionResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static PollStruct$FullOptionResult parseFrom(byte[] bArr) {
        return (PollStruct$FullOptionResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PollStruct$FullOptionResult parseFrom(byte[] bArr, C2394s c2394s) {
        return (PollStruct$FullOptionResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static PollStruct$FullOptionResult parseFrom(InputStream inputStream) {
        return (PollStruct$FullOptionResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PollStruct$FullOptionResult parseFrom(InputStream inputStream, C2394s c2394s) {
        return (PollStruct$FullOptionResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PollStruct$FullOptionResult parseFrom(AbstractC2384h abstractC2384h) {
        return (PollStruct$FullOptionResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static PollStruct$FullOptionResult parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (PollStruct$FullOptionResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
