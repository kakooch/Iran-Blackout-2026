package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC7108Qh5;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class PollStruct$OptionResult extends GeneratedMessageLite implements InterfaceC7108Qh5 {
    private static final PollStruct$OptionResult DEFAULT_INSTANCE;
    public static final int OPTION_ID_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int VOTES_COUNT_FIELD_NUMBER = 2;
    private int optionId_;
    private int votesCount_;

    public static final class a extends GeneratedMessageLite.b implements InterfaceC7108Qh5 {
        private a() {
            super(PollStruct$OptionResult.DEFAULT_INSTANCE);
        }
    }

    static {
        PollStruct$OptionResult pollStruct$OptionResult = new PollStruct$OptionResult();
        DEFAULT_INSTANCE = pollStruct$OptionResult;
        GeneratedMessageLite.registerDefaultInstance(PollStruct$OptionResult.class, pollStruct$OptionResult);
    }

    private PollStruct$OptionResult() {
    }

    private void clearOptionId() {
        this.optionId_ = 0;
    }

    private void clearVotesCount() {
        this.votesCount_ = 0;
    }

    public static PollStruct$OptionResult getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static PollStruct$OptionResult parseDelimitedFrom(InputStream inputStream) {
        return (PollStruct$OptionResult) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PollStruct$OptionResult parseFrom(ByteBuffer byteBuffer) {
        return (PollStruct$OptionResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setOptionId(int i) {
        this.optionId_ = i;
    }

    private void setVotesCount(int i) {
        this.votesCount_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1857g1.a[gVar.ordinal()]) {
            case 1:
                return new PollStruct$OptionResult();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0004\u0002\u0004", new Object[]{"optionId_", "votesCount_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (PollStruct$OptionResult.class) {
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

    public int getVotesCount() {
        return this.votesCount_;
    }

    public static a newBuilder(PollStruct$OptionResult pollStruct$OptionResult) {
        return (a) DEFAULT_INSTANCE.createBuilder(pollStruct$OptionResult);
    }

    public static PollStruct$OptionResult parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (PollStruct$OptionResult) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PollStruct$OptionResult parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (PollStruct$OptionResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static PollStruct$OptionResult parseFrom(AbstractC2383g abstractC2383g) {
        return (PollStruct$OptionResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static PollStruct$OptionResult parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (PollStruct$OptionResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static PollStruct$OptionResult parseFrom(byte[] bArr) {
        return (PollStruct$OptionResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PollStruct$OptionResult parseFrom(byte[] bArr, C2394s c2394s) {
        return (PollStruct$OptionResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static PollStruct$OptionResult parseFrom(InputStream inputStream) {
        return (PollStruct$OptionResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PollStruct$OptionResult parseFrom(InputStream inputStream, C2394s c2394s) {
        return (PollStruct$OptionResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PollStruct$OptionResult parseFrom(AbstractC2384h abstractC2384h) {
        return (PollStruct$OptionResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static PollStruct$OptionResult parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (PollStruct$OptionResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
