package ai.bale.proto;

import ai.bale.proto.PollStruct$PollResult;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC8283Vh5;
import ir.nasim.InterfaceC7576Sh5;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class MessagingStruct$PollMessage extends GeneratedMessageLite implements U64 {
    private static final MessagingStruct$PollMessage DEFAULT_INSTANCE;
    public static final int IS_ANONYMOUS_FIELD_NUMBER = 3;
    public static final int OPTIONS_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int POLL_ID_FIELD_NUMBER = 6;
    public static final int QUESTION_FIELD_NUMBER = 1;
    public static final int RESULT_FIELD_NUMBER = 5;
    public static final int TYPE_FIELD_NUMBER = 4;
    private int bitField0_;
    private boolean isAnonymous_;
    private long pollId_;
    private PollStruct$PollResult result_;
    private int type_;
    private String question_ = "";
    private B.j options_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MessagingStruct$PollMessage.DEFAULT_INSTANCE);
        }

        public a A(int i, PollStruct$PollOption pollStruct$PollOption) {
            q();
            ((MessagingStruct$PollMessage) this.b).addOptions(i, pollStruct$PollOption);
            return this;
        }

        public a B(boolean z) {
            q();
            ((MessagingStruct$PollMessage) this.b).setIsAnonymous(z);
            return this;
        }

        public a C(String str) {
            q();
            ((MessagingStruct$PollMessage) this.b).setQuestion(str);
            return this;
        }

        public a D(EnumC8283Vh5 enumC8283Vh5) {
            q();
            ((MessagingStruct$PollMessage) this.b).setType(enumC8283Vh5);
            return this;
        }
    }

    static {
        MessagingStruct$PollMessage messagingStruct$PollMessage = new MessagingStruct$PollMessage();
        DEFAULT_INSTANCE = messagingStruct$PollMessage;
        GeneratedMessageLite.registerDefaultInstance(MessagingStruct$PollMessage.class, messagingStruct$PollMessage);
    }

    private MessagingStruct$PollMessage() {
    }

    private void addAllOptions(Iterable<? extends PollStruct$PollOption> iterable) {
        ensureOptionsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.options_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addOptions(int i, PollStruct$PollOption pollStruct$PollOption) {
        pollStruct$PollOption.getClass();
        ensureOptionsIsMutable();
        this.options_.add(i, pollStruct$PollOption);
    }

    private void clearIsAnonymous() {
        this.isAnonymous_ = false;
    }

    private void clearOptions() {
        this.options_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearPollId() {
        this.pollId_ = 0L;
    }

    private void clearQuestion() {
        this.question_ = getDefaultInstance().getQuestion();
    }

    private void clearResult() {
        this.result_ = null;
        this.bitField0_ &= -2;
    }

    private void clearType() {
        this.type_ = 0;
    }

    private void ensureOptionsIsMutable() {
        B.j jVar = this.options_;
        if (jVar.u()) {
            return;
        }
        this.options_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static MessagingStruct$PollMessage getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeResult(PollStruct$PollResult pollStruct$PollResult) {
        pollStruct$PollResult.getClass();
        PollStruct$PollResult pollStruct$PollResult2 = this.result_;
        if (pollStruct$PollResult2 != null && pollStruct$PollResult2 != PollStruct$PollResult.getDefaultInstance()) {
            pollStruct$PollResult = (PollStruct$PollResult) ((PollStruct$PollResult.a) PollStruct$PollResult.newBuilder(this.result_).v(pollStruct$PollResult)).j();
        }
        this.result_ = pollStruct$PollResult;
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MessagingStruct$PollMessage parseDelimitedFrom(InputStream inputStream) {
        return (MessagingStruct$PollMessage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$PollMessage parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingStruct$PollMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeOptions(int i) {
        ensureOptionsIsMutable();
        this.options_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIsAnonymous(boolean z) {
        this.isAnonymous_ = z;
    }

    private void setOptions(int i, PollStruct$PollOption pollStruct$PollOption) {
        pollStruct$PollOption.getClass();
        ensureOptionsIsMutable();
        this.options_.set(i, pollStruct$PollOption);
    }

    private void setPollId(long j) {
        this.pollId_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setQuestion(String str) {
        str.getClass();
        this.question_ = str;
    }

    private void setQuestionBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.question_ = abstractC2383g.f0();
    }

    private void setResult(PollStruct$PollResult pollStruct$PollResult) {
        pollStruct$PollResult.getClass();
        this.result_ = pollStruct$PollResult;
        this.bitField0_ |= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setType(EnumC8283Vh5 enumC8283Vh5) {
        this.type_ = enumC8283Vh5.getNumber();
    }

    private void setTypeValue(int i) {
        this.type_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (L0.a[gVar.ordinal()]) {
            case 1:
                return new MessagingStruct$PollMessage();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0000\u0001Ȉ\u0002\u001b\u0003\u0007\u0004\f\u0005ဉ\u0000\u0006\u0002", new Object[]{"bitField0_", "question_", "options_", PollStruct$PollOption.class, "isAnonymous_", "type_", "result_", "pollId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingStruct$PollMessage.class) {
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

    public boolean getIsAnonymous() {
        return this.isAnonymous_;
    }

    public PollStruct$PollOption getOptions(int i) {
        return (PollStruct$PollOption) this.options_.get(i);
    }

    public int getOptionsCount() {
        return this.options_.size();
    }

    public List<PollStruct$PollOption> getOptionsList() {
        return this.options_;
    }

    public InterfaceC7576Sh5 getOptionsOrBuilder(int i) {
        return (InterfaceC7576Sh5) this.options_.get(i);
    }

    public List<? extends InterfaceC7576Sh5> getOptionsOrBuilderList() {
        return this.options_;
    }

    public long getPollId() {
        return this.pollId_;
    }

    public String getQuestion() {
        return this.question_;
    }

    public AbstractC2383g getQuestionBytes() {
        return AbstractC2383g.N(this.question_);
    }

    public PollStruct$PollResult getResult() {
        PollStruct$PollResult pollStruct$PollResult = this.result_;
        return pollStruct$PollResult == null ? PollStruct$PollResult.getDefaultInstance() : pollStruct$PollResult;
    }

    public EnumC8283Vh5 getType() {
        EnumC8283Vh5 enumC8283Vh5J = EnumC8283Vh5.j(this.type_);
        return enumC8283Vh5J == null ? EnumC8283Vh5.UNRECOGNIZED : enumC8283Vh5J;
    }

    public int getTypeValue() {
        return this.type_;
    }

    public boolean hasResult() {
        return (this.bitField0_ & 1) != 0;
    }

    private void addOptions(PollStruct$PollOption pollStruct$PollOption) {
        pollStruct$PollOption.getClass();
        ensureOptionsIsMutable();
        this.options_.add(pollStruct$PollOption);
    }

    public static a newBuilder(MessagingStruct$PollMessage messagingStruct$PollMessage) {
        return (a) DEFAULT_INSTANCE.createBuilder(messagingStruct$PollMessage);
    }

    public static MessagingStruct$PollMessage parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$PollMessage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$PollMessage parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingStruct$PollMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingStruct$PollMessage parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingStruct$PollMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingStruct$PollMessage parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingStruct$PollMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }

    public static MessagingStruct$PollMessage parseFrom(InputStream inputStream) {
        return (MessagingStruct$PollMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$PollMessage parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$PollMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$PollMessage parseFrom(ByteBuffer byteBuffer) {
        return (MessagingStruct$PollMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static MessagingStruct$PollMessage parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingStruct$PollMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingStruct$PollMessage parseFrom(byte[] bArr) {
        return (MessagingStruct$PollMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingStruct$PollMessage parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingStruct$PollMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }
}
