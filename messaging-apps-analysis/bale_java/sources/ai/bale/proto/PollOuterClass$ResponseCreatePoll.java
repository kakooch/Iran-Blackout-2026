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
public final class PollOuterClass$ResponseCreatePoll extends GeneratedMessageLite implements U64 {
    private static final PollOuterClass$ResponseCreatePoll DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int POLL_ID_FIELD_NUMBER = 1;
    private long pollId_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(PollOuterClass$ResponseCreatePoll.DEFAULT_INSTANCE);
        }
    }

    static {
        PollOuterClass$ResponseCreatePoll pollOuterClass$ResponseCreatePoll = new PollOuterClass$ResponseCreatePoll();
        DEFAULT_INSTANCE = pollOuterClass$ResponseCreatePoll;
        GeneratedMessageLite.registerDefaultInstance(PollOuterClass$ResponseCreatePoll.class, pollOuterClass$ResponseCreatePoll);
    }

    private PollOuterClass$ResponseCreatePoll() {
    }

    private void clearPollId() {
        this.pollId_ = 0L;
    }

    public static PollOuterClass$ResponseCreatePoll getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static PollOuterClass$ResponseCreatePoll parseDelimitedFrom(InputStream inputStream) {
        return (PollOuterClass$ResponseCreatePoll) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PollOuterClass$ResponseCreatePoll parseFrom(ByteBuffer byteBuffer) {
        return (PollOuterClass$ResponseCreatePoll) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setPollId(long j) {
        this.pollId_ = j;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1854f1.a[gVar.ordinal()]) {
            case 1:
                return new PollOuterClass$ResponseCreatePoll();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0002", new Object[]{"pollId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (PollOuterClass$ResponseCreatePoll.class) {
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

    public static a newBuilder(PollOuterClass$ResponseCreatePoll pollOuterClass$ResponseCreatePoll) {
        return (a) DEFAULT_INSTANCE.createBuilder(pollOuterClass$ResponseCreatePoll);
    }

    public static PollOuterClass$ResponseCreatePoll parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (PollOuterClass$ResponseCreatePoll) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PollOuterClass$ResponseCreatePoll parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (PollOuterClass$ResponseCreatePoll) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static PollOuterClass$ResponseCreatePoll parseFrom(AbstractC2383g abstractC2383g) {
        return (PollOuterClass$ResponseCreatePoll) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static PollOuterClass$ResponseCreatePoll parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (PollOuterClass$ResponseCreatePoll) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static PollOuterClass$ResponseCreatePoll parseFrom(byte[] bArr) {
        return (PollOuterClass$ResponseCreatePoll) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PollOuterClass$ResponseCreatePoll parseFrom(byte[] bArr, C2394s c2394s) {
        return (PollOuterClass$ResponseCreatePoll) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static PollOuterClass$ResponseCreatePoll parseFrom(InputStream inputStream) {
        return (PollOuterClass$ResponseCreatePoll) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PollOuterClass$ResponseCreatePoll parseFrom(InputStream inputStream, C2394s c2394s) {
        return (PollOuterClass$ResponseCreatePoll) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PollOuterClass$ResponseCreatePoll parseFrom(AbstractC2384h abstractC2384h) {
        return (PollOuterClass$ResponseCreatePoll) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static PollOuterClass$ResponseCreatePoll parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (PollOuterClass$ResponseCreatePoll) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
