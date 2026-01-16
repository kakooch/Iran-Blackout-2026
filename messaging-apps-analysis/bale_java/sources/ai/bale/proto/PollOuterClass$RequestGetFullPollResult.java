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
public final class PollOuterClass$RequestGetFullPollResult extends GeneratedMessageLite implements U64 {
    private static final PollOuterClass$RequestGetFullPollResult DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int POLL_ID_FIELD_NUMBER = 1;
    private long pollId_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(long j) {
            q();
            ((PollOuterClass$RequestGetFullPollResult) this.b).setPollId(j);
            return this;
        }

        private a() {
            super(PollOuterClass$RequestGetFullPollResult.DEFAULT_INSTANCE);
        }
    }

    static {
        PollOuterClass$RequestGetFullPollResult pollOuterClass$RequestGetFullPollResult = new PollOuterClass$RequestGetFullPollResult();
        DEFAULT_INSTANCE = pollOuterClass$RequestGetFullPollResult;
        GeneratedMessageLite.registerDefaultInstance(PollOuterClass$RequestGetFullPollResult.class, pollOuterClass$RequestGetFullPollResult);
    }

    private PollOuterClass$RequestGetFullPollResult() {
    }

    private void clearPollId() {
        this.pollId_ = 0L;
    }

    public static PollOuterClass$RequestGetFullPollResult getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static PollOuterClass$RequestGetFullPollResult parseDelimitedFrom(InputStream inputStream) {
        return (PollOuterClass$RequestGetFullPollResult) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PollOuterClass$RequestGetFullPollResult parseFrom(ByteBuffer byteBuffer) {
        return (PollOuterClass$RequestGetFullPollResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPollId(long j) {
        this.pollId_ = j;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1854f1.a[gVar.ordinal()]) {
            case 1:
                return new PollOuterClass$RequestGetFullPollResult();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0002", new Object[]{"pollId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (PollOuterClass$RequestGetFullPollResult.class) {
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

    public long getPollId() {
        return this.pollId_;
    }

    public static a newBuilder(PollOuterClass$RequestGetFullPollResult pollOuterClass$RequestGetFullPollResult) {
        return (a) DEFAULT_INSTANCE.createBuilder(pollOuterClass$RequestGetFullPollResult);
    }

    public static PollOuterClass$RequestGetFullPollResult parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (PollOuterClass$RequestGetFullPollResult) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PollOuterClass$RequestGetFullPollResult parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (PollOuterClass$RequestGetFullPollResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static PollOuterClass$RequestGetFullPollResult parseFrom(AbstractC2383g abstractC2383g) {
        return (PollOuterClass$RequestGetFullPollResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static PollOuterClass$RequestGetFullPollResult parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (PollOuterClass$RequestGetFullPollResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static PollOuterClass$RequestGetFullPollResult parseFrom(byte[] bArr) {
        return (PollOuterClass$RequestGetFullPollResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PollOuterClass$RequestGetFullPollResult parseFrom(byte[] bArr, C2394s c2394s) {
        return (PollOuterClass$RequestGetFullPollResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static PollOuterClass$RequestGetFullPollResult parseFrom(InputStream inputStream) {
        return (PollOuterClass$RequestGetFullPollResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PollOuterClass$RequestGetFullPollResult parseFrom(InputStream inputStream, C2394s c2394s) {
        return (PollOuterClass$RequestGetFullPollResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PollOuterClass$RequestGetFullPollResult parseFrom(AbstractC2384h abstractC2384h) {
        return (PollOuterClass$RequestGetFullPollResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static PollOuterClass$RequestGetFullPollResult parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (PollOuterClass$RequestGetFullPollResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
