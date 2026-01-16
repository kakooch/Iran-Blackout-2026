package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC7108Qh5;
import ir.nasim.InterfaceC8049Uh5;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class PollStruct$PollResult extends GeneratedMessageLite implements InterfaceC8049Uh5 {
    public static final int CHOSEN_OPTION_IDS_FIELD_NUMBER = 3;
    private static final PollStruct$PollResult DEFAULT_INSTANCE;
    public static final int IS_CLOSED_FIELD_NUMBER = 4;
    public static final int OPTION_RESULTS_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int POLL_ID_FIELD_NUMBER = 5;
    public static final int RECENT_VOTERS_FIELD_NUMBER = 2;
    public static final int VOTERS_COUNT_FIELD_NUMBER = 6;
    private boolean isClosed_;
    private long pollId_;
    private int votersCount_;
    private int recentVotersMemoizedSerializedSize = -1;
    private int chosenOptionIdsMemoizedSerializedSize = -1;
    private B.j optionResults_ = GeneratedMessageLite.emptyProtobufList();
    private B.i recentVoters_ = GeneratedMessageLite.emptyLongList();
    private B.i chosenOptionIds_ = GeneratedMessageLite.emptyLongList();

    public static final class a extends GeneratedMessageLite.b implements InterfaceC8049Uh5 {
        private a() {
            super(PollStruct$PollResult.DEFAULT_INSTANCE);
        }
    }

    static {
        PollStruct$PollResult pollStruct$PollResult = new PollStruct$PollResult();
        DEFAULT_INSTANCE = pollStruct$PollResult;
        GeneratedMessageLite.registerDefaultInstance(PollStruct$PollResult.class, pollStruct$PollResult);
    }

    private PollStruct$PollResult() {
    }

    private void addAllChosenOptionIds(Iterable<? extends Long> iterable) {
        ensureChosenOptionIdsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.chosenOptionIds_);
    }

    private void addAllOptionResults(Iterable<? extends PollStruct$OptionResult> iterable) {
        ensureOptionResultsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.optionResults_);
    }

    private void addAllRecentVoters(Iterable<? extends Long> iterable) {
        ensureRecentVotersIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.recentVoters_);
    }

    private void addChosenOptionIds(long j) {
        ensureChosenOptionIdsIsMutable();
        this.chosenOptionIds_.l1(j);
    }

    private void addOptionResults(PollStruct$OptionResult pollStruct$OptionResult) {
        pollStruct$OptionResult.getClass();
        ensureOptionResultsIsMutable();
        this.optionResults_.add(pollStruct$OptionResult);
    }

    private void addRecentVoters(long j) {
        ensureRecentVotersIsMutable();
        this.recentVoters_.l1(j);
    }

    private void clearChosenOptionIds() {
        this.chosenOptionIds_ = GeneratedMessageLite.emptyLongList();
    }

    private void clearIsClosed() {
        this.isClosed_ = false;
    }

    private void clearOptionResults() {
        this.optionResults_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearPollId() {
        this.pollId_ = 0L;
    }

    private void clearRecentVoters() {
        this.recentVoters_ = GeneratedMessageLite.emptyLongList();
    }

    private void clearVotersCount() {
        this.votersCount_ = 0;
    }

    private void ensureChosenOptionIdsIsMutable() {
        B.i iVar = this.chosenOptionIds_;
        if (iVar.u()) {
            return;
        }
        this.chosenOptionIds_ = GeneratedMessageLite.mutableCopy(iVar);
    }

    private void ensureOptionResultsIsMutable() {
        B.j jVar = this.optionResults_;
        if (jVar.u()) {
            return;
        }
        this.optionResults_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    private void ensureRecentVotersIsMutable() {
        B.i iVar = this.recentVoters_;
        if (iVar.u()) {
            return;
        }
        this.recentVoters_ = GeneratedMessageLite.mutableCopy(iVar);
    }

    public static PollStruct$PollResult getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static PollStruct$PollResult parseDelimitedFrom(InputStream inputStream) {
        return (PollStruct$PollResult) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PollStruct$PollResult parseFrom(ByteBuffer byteBuffer) {
        return (PollStruct$PollResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeOptionResults(int i) {
        ensureOptionResultsIsMutable();
        this.optionResults_.remove(i);
    }

    private void setChosenOptionIds(int i, long j) {
        ensureChosenOptionIdsIsMutable();
        this.chosenOptionIds_.z1(i, j);
    }

    private void setIsClosed(boolean z) {
        this.isClosed_ = z;
    }

    private void setOptionResults(int i, PollStruct$OptionResult pollStruct$OptionResult) {
        pollStruct$OptionResult.getClass();
        ensureOptionResultsIsMutable();
        this.optionResults_.set(i, pollStruct$OptionResult);
    }

    private void setPollId(long j) {
        this.pollId_ = j;
    }

    private void setRecentVoters(int i, long j) {
        ensureRecentVotersIsMutable();
        this.recentVoters_.z1(i, j);
    }

    private void setVotersCount(int i) {
        this.votersCount_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1857g1.a[gVar.ordinal()]) {
            case 1:
                return new PollStruct$PollResult();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0006\u0000\u0000\u0001\u0006\u0006\u0000\u0003\u0000\u0001\u001b\u0002%\u0003%\u0004\u0007\u0005\u0002\u0006\u0004", new Object[]{"optionResults_", PollStruct$OptionResult.class, "recentVoters_", "chosenOptionIds_", "isClosed_", "pollId_", "votersCount_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (PollStruct$PollResult.class) {
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

    public long getChosenOptionIds(int i) {
        return this.chosenOptionIds_.getLong(i);
    }

    public int getChosenOptionIdsCount() {
        return this.chosenOptionIds_.size();
    }

    public List<Long> getChosenOptionIdsList() {
        return this.chosenOptionIds_;
    }

    public boolean getIsClosed() {
        return this.isClosed_;
    }

    public PollStruct$OptionResult getOptionResults(int i) {
        return (PollStruct$OptionResult) this.optionResults_.get(i);
    }

    public int getOptionResultsCount() {
        return this.optionResults_.size();
    }

    public List<PollStruct$OptionResult> getOptionResultsList() {
        return this.optionResults_;
    }

    public InterfaceC7108Qh5 getOptionResultsOrBuilder(int i) {
        return (InterfaceC7108Qh5) this.optionResults_.get(i);
    }

    public List<? extends InterfaceC7108Qh5> getOptionResultsOrBuilderList() {
        return this.optionResults_;
    }

    public long getPollId() {
        return this.pollId_;
    }

    public long getRecentVoters(int i) {
        return this.recentVoters_.getLong(i);
    }

    public int getRecentVotersCount() {
        return this.recentVoters_.size();
    }

    public List<Long> getRecentVotersList() {
        return this.recentVoters_;
    }

    public int getVotersCount() {
        return this.votersCount_;
    }

    public static a newBuilder(PollStruct$PollResult pollStruct$PollResult) {
        return (a) DEFAULT_INSTANCE.createBuilder(pollStruct$PollResult);
    }

    public static PollStruct$PollResult parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (PollStruct$PollResult) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PollStruct$PollResult parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (PollStruct$PollResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static PollStruct$PollResult parseFrom(AbstractC2383g abstractC2383g) {
        return (PollStruct$PollResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addOptionResults(int i, PollStruct$OptionResult pollStruct$OptionResult) {
        pollStruct$OptionResult.getClass();
        ensureOptionResultsIsMutable();
        this.optionResults_.add(i, pollStruct$OptionResult);
    }

    public static PollStruct$PollResult parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (PollStruct$PollResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static PollStruct$PollResult parseFrom(byte[] bArr) {
        return (PollStruct$PollResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PollStruct$PollResult parseFrom(byte[] bArr, C2394s c2394s) {
        return (PollStruct$PollResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static PollStruct$PollResult parseFrom(InputStream inputStream) {
        return (PollStruct$PollResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PollStruct$PollResult parseFrom(InputStream inputStream, C2394s c2394s) {
        return (PollStruct$PollResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PollStruct$PollResult parseFrom(AbstractC2384h abstractC2384h) {
        return (PollStruct$PollResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static PollStruct$PollResult parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (PollStruct$PollResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
