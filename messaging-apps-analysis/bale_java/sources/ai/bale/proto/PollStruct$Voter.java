package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC8783Xh5;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class PollStruct$Voter extends GeneratedMessageLite implements InterfaceC8783Xh5 {
    private static final PollStruct$Voter DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int USER_ID_FIELD_NUMBER = 1;
    public static final int VOTED_AT_FIELD_NUMBER = 2;
    private int userId_;
    private long votedAt_;

    public static final class a extends GeneratedMessageLite.b implements InterfaceC8783Xh5 {
        private a() {
            super(PollStruct$Voter.DEFAULT_INSTANCE);
        }
    }

    static {
        PollStruct$Voter pollStruct$Voter = new PollStruct$Voter();
        DEFAULT_INSTANCE = pollStruct$Voter;
        GeneratedMessageLite.registerDefaultInstance(PollStruct$Voter.class, pollStruct$Voter);
    }

    private PollStruct$Voter() {
    }

    private void clearUserId() {
        this.userId_ = 0;
    }

    private void clearVotedAt() {
        this.votedAt_ = 0L;
    }

    public static PollStruct$Voter getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static PollStruct$Voter parseDelimitedFrom(InputStream inputStream) {
        return (PollStruct$Voter) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PollStruct$Voter parseFrom(ByteBuffer byteBuffer) {
        return (PollStruct$Voter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setUserId(int i) {
        this.userId_ = i;
    }

    private void setVotedAt(long j) {
        this.votedAt_ = j;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1857g1.a[gVar.ordinal()]) {
            case 1:
                return new PollStruct$Voter();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0004\u0002\u0002", new Object[]{"userId_", "votedAt_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (PollStruct$Voter.class) {
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

    public int getUserId() {
        return this.userId_;
    }

    public long getVotedAt() {
        return this.votedAt_;
    }

    public static a newBuilder(PollStruct$Voter pollStruct$Voter) {
        return (a) DEFAULT_INSTANCE.createBuilder(pollStruct$Voter);
    }

    public static PollStruct$Voter parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (PollStruct$Voter) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PollStruct$Voter parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (PollStruct$Voter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static PollStruct$Voter parseFrom(AbstractC2383g abstractC2383g) {
        return (PollStruct$Voter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static PollStruct$Voter parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (PollStruct$Voter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static PollStruct$Voter parseFrom(byte[] bArr) {
        return (PollStruct$Voter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PollStruct$Voter parseFrom(byte[] bArr, C2394s c2394s) {
        return (PollStruct$Voter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static PollStruct$Voter parseFrom(InputStream inputStream) {
        return (PollStruct$Voter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PollStruct$Voter parseFrom(InputStream inputStream, C2394s c2394s) {
        return (PollStruct$Voter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PollStruct$Voter parseFrom(AbstractC2384h abstractC2384h) {
        return (PollStruct$Voter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static PollStruct$Voter parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (PollStruct$Voter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
