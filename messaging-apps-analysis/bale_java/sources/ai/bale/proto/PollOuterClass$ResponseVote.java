package ai.bale.proto;

import ai.bale.proto.PollStruct$PollResult;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class PollOuterClass$ResponseVote extends GeneratedMessageLite implements U64 {
    private static final PollOuterClass$ResponseVote DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int POLL_RESULT_FIELD_NUMBER = 1;
    private int bitField0_;
    private PollStruct$PollResult pollResult_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(PollOuterClass$ResponseVote.DEFAULT_INSTANCE);
        }
    }

    static {
        PollOuterClass$ResponseVote pollOuterClass$ResponseVote = new PollOuterClass$ResponseVote();
        DEFAULT_INSTANCE = pollOuterClass$ResponseVote;
        GeneratedMessageLite.registerDefaultInstance(PollOuterClass$ResponseVote.class, pollOuterClass$ResponseVote);
    }

    private PollOuterClass$ResponseVote() {
    }

    private void clearPollResult() {
        this.pollResult_ = null;
        this.bitField0_ &= -2;
    }

    public static PollOuterClass$ResponseVote getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergePollResult(PollStruct$PollResult pollStruct$PollResult) {
        pollStruct$PollResult.getClass();
        PollStruct$PollResult pollStruct$PollResult2 = this.pollResult_;
        if (pollStruct$PollResult2 == null || pollStruct$PollResult2 == PollStruct$PollResult.getDefaultInstance()) {
            this.pollResult_ = pollStruct$PollResult;
        } else {
            this.pollResult_ = (PollStruct$PollResult) ((PollStruct$PollResult.a) PollStruct$PollResult.newBuilder(this.pollResult_).v(pollStruct$PollResult)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static PollOuterClass$ResponseVote parseDelimitedFrom(InputStream inputStream) {
        return (PollOuterClass$ResponseVote) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PollOuterClass$ResponseVote parseFrom(ByteBuffer byteBuffer) {
        return (PollOuterClass$ResponseVote) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setPollResult(PollStruct$PollResult pollStruct$PollResult) {
        pollStruct$PollResult.getClass();
        this.pollResult_ = pollStruct$PollResult;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1854f1.a[gVar.ordinal()]) {
            case 1:
                return new PollOuterClass$ResponseVote();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "pollResult_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (PollOuterClass$ResponseVote.class) {
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

    public PollStruct$PollResult getPollResult() {
        PollStruct$PollResult pollStruct$PollResult = this.pollResult_;
        return pollStruct$PollResult == null ? PollStruct$PollResult.getDefaultInstance() : pollStruct$PollResult;
    }

    public boolean hasPollResult() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(PollOuterClass$ResponseVote pollOuterClass$ResponseVote) {
        return (a) DEFAULT_INSTANCE.createBuilder(pollOuterClass$ResponseVote);
    }

    public static PollOuterClass$ResponseVote parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (PollOuterClass$ResponseVote) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PollOuterClass$ResponseVote parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (PollOuterClass$ResponseVote) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static PollOuterClass$ResponseVote parseFrom(AbstractC2383g abstractC2383g) {
        return (PollOuterClass$ResponseVote) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static PollOuterClass$ResponseVote parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (PollOuterClass$ResponseVote) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static PollOuterClass$ResponseVote parseFrom(byte[] bArr) {
        return (PollOuterClass$ResponseVote) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PollOuterClass$ResponseVote parseFrom(byte[] bArr, C2394s c2394s) {
        return (PollOuterClass$ResponseVote) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static PollOuterClass$ResponseVote parseFrom(InputStream inputStream) {
        return (PollOuterClass$ResponseVote) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PollOuterClass$ResponseVote parseFrom(InputStream inputStream, C2394s c2394s) {
        return (PollOuterClass$ResponseVote) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PollOuterClass$ResponseVote parseFrom(AbstractC2384h abstractC2384h) {
        return (PollOuterClass$ResponseVote) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static PollOuterClass$ResponseVote parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (PollOuterClass$ResponseVote) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
