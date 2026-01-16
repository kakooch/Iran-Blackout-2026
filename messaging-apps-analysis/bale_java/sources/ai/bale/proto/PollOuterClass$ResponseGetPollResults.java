package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC8049Uh5;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class PollOuterClass$ResponseGetPollResults extends GeneratedMessageLite implements U64 {
    private static final PollOuterClass$ResponseGetPollResults DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int POLL_RESULTS_FIELD_NUMBER = 1;
    private B.j pollResults_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(PollOuterClass$ResponseGetPollResults.DEFAULT_INSTANCE);
        }
    }

    static {
        PollOuterClass$ResponseGetPollResults pollOuterClass$ResponseGetPollResults = new PollOuterClass$ResponseGetPollResults();
        DEFAULT_INSTANCE = pollOuterClass$ResponseGetPollResults;
        GeneratedMessageLite.registerDefaultInstance(PollOuterClass$ResponseGetPollResults.class, pollOuterClass$ResponseGetPollResults);
    }

    private PollOuterClass$ResponseGetPollResults() {
    }

    private void addAllPollResults(Iterable<? extends PollStruct$PollResult> iterable) {
        ensurePollResultsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.pollResults_);
    }

    private void addPollResults(PollStruct$PollResult pollStruct$PollResult) {
        pollStruct$PollResult.getClass();
        ensurePollResultsIsMutable();
        this.pollResults_.add(pollStruct$PollResult);
    }

    private void clearPollResults() {
        this.pollResults_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensurePollResultsIsMutable() {
        B.j jVar = this.pollResults_;
        if (jVar.u()) {
            return;
        }
        this.pollResults_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static PollOuterClass$ResponseGetPollResults getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static PollOuterClass$ResponseGetPollResults parseDelimitedFrom(InputStream inputStream) {
        return (PollOuterClass$ResponseGetPollResults) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PollOuterClass$ResponseGetPollResults parseFrom(ByteBuffer byteBuffer) {
        return (PollOuterClass$ResponseGetPollResults) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removePollResults(int i) {
        ensurePollResultsIsMutable();
        this.pollResults_.remove(i);
    }

    private void setPollResults(int i, PollStruct$PollResult pollStruct$PollResult) {
        pollStruct$PollResult.getClass();
        ensurePollResultsIsMutable();
        this.pollResults_.set(i, pollStruct$PollResult);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1854f1.a[gVar.ordinal()]) {
            case 1:
                return new PollOuterClass$ResponseGetPollResults();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"pollResults_", PollStruct$PollResult.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (PollOuterClass$ResponseGetPollResults.class) {
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

    public PollStruct$PollResult getPollResults(int i) {
        return (PollStruct$PollResult) this.pollResults_.get(i);
    }

    public int getPollResultsCount() {
        return this.pollResults_.size();
    }

    public List<PollStruct$PollResult> getPollResultsList() {
        return this.pollResults_;
    }

    public InterfaceC8049Uh5 getPollResultsOrBuilder(int i) {
        return (InterfaceC8049Uh5) this.pollResults_.get(i);
    }

    public List<? extends InterfaceC8049Uh5> getPollResultsOrBuilderList() {
        return this.pollResults_;
    }

    public static a newBuilder(PollOuterClass$ResponseGetPollResults pollOuterClass$ResponseGetPollResults) {
        return (a) DEFAULT_INSTANCE.createBuilder(pollOuterClass$ResponseGetPollResults);
    }

    public static PollOuterClass$ResponseGetPollResults parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (PollOuterClass$ResponseGetPollResults) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PollOuterClass$ResponseGetPollResults parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (PollOuterClass$ResponseGetPollResults) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static PollOuterClass$ResponseGetPollResults parseFrom(AbstractC2383g abstractC2383g) {
        return (PollOuterClass$ResponseGetPollResults) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addPollResults(int i, PollStruct$PollResult pollStruct$PollResult) {
        pollStruct$PollResult.getClass();
        ensurePollResultsIsMutable();
        this.pollResults_.add(i, pollStruct$PollResult);
    }

    public static PollOuterClass$ResponseGetPollResults parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (PollOuterClass$ResponseGetPollResults) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static PollOuterClass$ResponseGetPollResults parseFrom(byte[] bArr) {
        return (PollOuterClass$ResponseGetPollResults) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PollOuterClass$ResponseGetPollResults parseFrom(byte[] bArr, C2394s c2394s) {
        return (PollOuterClass$ResponseGetPollResults) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static PollOuterClass$ResponseGetPollResults parseFrom(InputStream inputStream) {
        return (PollOuterClass$ResponseGetPollResults) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PollOuterClass$ResponseGetPollResults parseFrom(InputStream inputStream, C2394s c2394s) {
        return (PollOuterClass$ResponseGetPollResults) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PollOuterClass$ResponseGetPollResults parseFrom(AbstractC2384h abstractC2384h) {
        return (PollOuterClass$ResponseGetPollResults) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static PollOuterClass$ResponseGetPollResults parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (PollOuterClass$ResponseGetPollResults) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
