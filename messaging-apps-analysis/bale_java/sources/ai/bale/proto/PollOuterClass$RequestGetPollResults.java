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
public final class PollOuterClass$RequestGetPollResults extends GeneratedMessageLite implements U64 {
    private static final PollOuterClass$RequestGetPollResults DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int POLL_IDS_FIELD_NUMBER = 1;
    private int pollIdsMemoizedSerializedSize = -1;
    private B.i pollIds_ = GeneratedMessageLite.emptyLongList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(Iterable iterable) {
            q();
            ((PollOuterClass$RequestGetPollResults) this.b).addAllPollIds(iterable);
            return this;
        }

        private a() {
            super(PollOuterClass$RequestGetPollResults.DEFAULT_INSTANCE);
        }
    }

    static {
        PollOuterClass$RequestGetPollResults pollOuterClass$RequestGetPollResults = new PollOuterClass$RequestGetPollResults();
        DEFAULT_INSTANCE = pollOuterClass$RequestGetPollResults;
        GeneratedMessageLite.registerDefaultInstance(PollOuterClass$RequestGetPollResults.class, pollOuterClass$RequestGetPollResults);
    }

    private PollOuterClass$RequestGetPollResults() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllPollIds(Iterable<? extends Long> iterable) {
        ensurePollIdsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.pollIds_);
    }

    private void addPollIds(long j) {
        ensurePollIdsIsMutable();
        this.pollIds_.l1(j);
    }

    private void clearPollIds() {
        this.pollIds_ = GeneratedMessageLite.emptyLongList();
    }

    private void ensurePollIdsIsMutable() {
        B.i iVar = this.pollIds_;
        if (iVar.u()) {
            return;
        }
        this.pollIds_ = GeneratedMessageLite.mutableCopy(iVar);
    }

    public static PollOuterClass$RequestGetPollResults getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static PollOuterClass$RequestGetPollResults parseDelimitedFrom(InputStream inputStream) {
        return (PollOuterClass$RequestGetPollResults) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PollOuterClass$RequestGetPollResults parseFrom(ByteBuffer byteBuffer) {
        return (PollOuterClass$RequestGetPollResults) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setPollIds(int i, long j) {
        ensurePollIdsIsMutable();
        this.pollIds_.z1(i, j);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1854f1.a[gVar.ordinal()]) {
            case 1:
                return new PollOuterClass$RequestGetPollResults();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001%", new Object[]{"pollIds_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (PollOuterClass$RequestGetPollResults.class) {
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

    public long getPollIds(int i) {
        return this.pollIds_.getLong(i);
    }

    public int getPollIdsCount() {
        return this.pollIds_.size();
    }

    public List<Long> getPollIdsList() {
        return this.pollIds_;
    }

    public static a newBuilder(PollOuterClass$RequestGetPollResults pollOuterClass$RequestGetPollResults) {
        return (a) DEFAULT_INSTANCE.createBuilder(pollOuterClass$RequestGetPollResults);
    }

    public static PollOuterClass$RequestGetPollResults parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (PollOuterClass$RequestGetPollResults) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PollOuterClass$RequestGetPollResults parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (PollOuterClass$RequestGetPollResults) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static PollOuterClass$RequestGetPollResults parseFrom(AbstractC2383g abstractC2383g) {
        return (PollOuterClass$RequestGetPollResults) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static PollOuterClass$RequestGetPollResults parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (PollOuterClass$RequestGetPollResults) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static PollOuterClass$RequestGetPollResults parseFrom(byte[] bArr) {
        return (PollOuterClass$RequestGetPollResults) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PollOuterClass$RequestGetPollResults parseFrom(byte[] bArr, C2394s c2394s) {
        return (PollOuterClass$RequestGetPollResults) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static PollOuterClass$RequestGetPollResults parseFrom(InputStream inputStream) {
        return (PollOuterClass$RequestGetPollResults) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PollOuterClass$RequestGetPollResults parseFrom(InputStream inputStream, C2394s c2394s) {
        return (PollOuterClass$RequestGetPollResults) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PollOuterClass$RequestGetPollResults parseFrom(AbstractC2384h abstractC2384h) {
        return (PollOuterClass$RequestGetPollResults) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static PollOuterClass$RequestGetPollResults parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (PollOuterClass$RequestGetPollResults) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
