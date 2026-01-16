package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class PollOuterClass$RequestVote extends GeneratedMessageLite implements U64 {
    private static final PollOuterClass$RequestVote DEFAULT_INSTANCE;
    public static final int IS_RETRACT_FIELD_NUMBER = 2;
    public static final int OPTION_IDS_FIELD_NUMBER = 4;
    private static volatile KW4 PARSER = null;
    public static final int POLL_ID_FIELD_NUMBER = 1;
    public static final int VOTE_AT_FIELD_NUMBER = 3;
    private boolean isRetract_;
    private int optionIdsMemoizedSerializedSize = -1;
    private B.g optionIds_ = GeneratedMessageLite.emptyIntList();
    private long pollId_;
    private long voteAt_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(Iterable iterable) {
            q();
            ((PollOuterClass$RequestVote) this.b).addAllOptionIds(iterable);
            return this;
        }

        public a B(boolean z) {
            q();
            ((PollOuterClass$RequestVote) this.b).setIsRetract(z);
            return this;
        }

        public a C(long j) {
            q();
            ((PollOuterClass$RequestVote) this.b).setPollId(j);
            return this;
        }

        private a() {
            super(PollOuterClass$RequestVote.DEFAULT_INSTANCE);
        }
    }

    static {
        PollOuterClass$RequestVote pollOuterClass$RequestVote = new PollOuterClass$RequestVote();
        DEFAULT_INSTANCE = pollOuterClass$RequestVote;
        GeneratedMessageLite.registerDefaultInstance(PollOuterClass$RequestVote.class, pollOuterClass$RequestVote);
    }

    private PollOuterClass$RequestVote() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllOptionIds(Iterable<? extends Integer> iterable) {
        ensureOptionIdsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.optionIds_);
    }

    private void addOptionIds(int i) {
        ensureOptionIdsIsMutable();
        this.optionIds_.b1(i);
    }

    private void clearIsRetract() {
        this.isRetract_ = false;
    }

    private void clearOptionIds() {
        this.optionIds_ = GeneratedMessageLite.emptyIntList();
    }

    private void clearPollId() {
        this.pollId_ = 0L;
    }

    private void clearVoteAt() {
        this.voteAt_ = 0L;
    }

    private void ensureOptionIdsIsMutable() {
        B.g gVar = this.optionIds_;
        if (gVar.u()) {
            return;
        }
        this.optionIds_ = GeneratedMessageLite.mutableCopy(gVar);
    }

    public static PollOuterClass$RequestVote getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static PollOuterClass$RequestVote parseDelimitedFrom(InputStream inputStream) {
        return (PollOuterClass$RequestVote) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PollOuterClass$RequestVote parseFrom(ByteBuffer byteBuffer) {
        return (PollOuterClass$RequestVote) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIsRetract(boolean z) {
        this.isRetract_ = z;
    }

    private void setOptionIds(int i, int i2) {
        ensureOptionIdsIsMutable();
        this.optionIds_.U(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPollId(long j) {
        this.pollId_ = j;
    }

    private void setVoteAt(long j) {
        this.voteAt_ = j;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1854f1.a[gVar.ordinal()]) {
            case 1:
                return new PollOuterClass$RequestVote();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0001\u0000\u0001\u0002\u0002\u0007\u0003\u0002\u0004'", new Object[]{"pollId_", "isRetract_", "voteAt_", "optionIds_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (PollOuterClass$RequestVote.class) {
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

    public boolean getIsRetract() {
        return this.isRetract_;
    }

    public int getOptionIds(int i) {
        return this.optionIds_.getInt(i);
    }

    public int getOptionIdsCount() {
        return this.optionIds_.size();
    }

    public List<Integer> getOptionIdsList() {
        return this.optionIds_;
    }

    public long getPollId() {
        return this.pollId_;
    }

    @Deprecated
    public long getVoteAt() {
        return this.voteAt_;
    }

    public static a newBuilder(PollOuterClass$RequestVote pollOuterClass$RequestVote) {
        return (a) DEFAULT_INSTANCE.createBuilder(pollOuterClass$RequestVote);
    }

    public static PollOuterClass$RequestVote parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (PollOuterClass$RequestVote) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PollOuterClass$RequestVote parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (PollOuterClass$RequestVote) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static PollOuterClass$RequestVote parseFrom(AbstractC2383g abstractC2383g) {
        return (PollOuterClass$RequestVote) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static PollOuterClass$RequestVote parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (PollOuterClass$RequestVote) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static PollOuterClass$RequestVote parseFrom(byte[] bArr) {
        return (PollOuterClass$RequestVote) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PollOuterClass$RequestVote parseFrom(byte[] bArr, C2394s c2394s) {
        return (PollOuterClass$RequestVote) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static PollOuterClass$RequestVote parseFrom(InputStream inputStream) {
        return (PollOuterClass$RequestVote) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PollOuterClass$RequestVote parseFrom(InputStream inputStream, C2394s c2394s) {
        return (PollOuterClass$RequestVote) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PollOuterClass$RequestVote parseFrom(AbstractC2384h abstractC2384h) {
        return (PollOuterClass$RequestVote) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static PollOuterClass$RequestVote parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (PollOuterClass$RequestVote) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
