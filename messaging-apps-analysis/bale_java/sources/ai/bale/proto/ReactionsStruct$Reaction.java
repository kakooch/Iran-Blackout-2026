package ai.bale.proto;

import ai.bale.proto.MessagingStruct$HistoryMessageIdentifier;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC19408qI5;
import ir.nasim.KW4;
import ir.nasim.X60;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class ReactionsStruct$Reaction extends GeneratedMessageLite implements InterfaceC19408qI5 {
    private static final ReactionsStruct$Reaction DEFAULT_INSTANCE;
    public static final int MSG_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int REACTION_STATE_FIELD_NUMBER = 2;
    private int bitField0_;
    private MessagingStruct$HistoryMessageIdentifier msg_;
    private B.j reactionState_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements InterfaceC19408qI5 {
        private a() {
            super(ReactionsStruct$Reaction.DEFAULT_INSTANCE);
        }
    }

    static {
        ReactionsStruct$Reaction reactionsStruct$Reaction = new ReactionsStruct$Reaction();
        DEFAULT_INSTANCE = reactionsStruct$Reaction;
        GeneratedMessageLite.registerDefaultInstance(ReactionsStruct$Reaction.class, reactionsStruct$Reaction);
    }

    private ReactionsStruct$Reaction() {
    }

    private void addAllReactionState(Iterable<? extends BankStruct$ReactionEntity> iterable) {
        ensureReactionStateIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.reactionState_);
    }

    private void addReactionState(BankStruct$ReactionEntity bankStruct$ReactionEntity) {
        bankStruct$ReactionEntity.getClass();
        ensureReactionStateIsMutable();
        this.reactionState_.add(bankStruct$ReactionEntity);
    }

    private void clearMsg() {
        this.msg_ = null;
        this.bitField0_ &= -2;
    }

    private void clearReactionState() {
        this.reactionState_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureReactionStateIsMutable() {
        B.j jVar = this.reactionState_;
        if (jVar.u()) {
            return;
        }
        this.reactionState_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static ReactionsStruct$Reaction getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeMsg(MessagingStruct$HistoryMessageIdentifier messagingStruct$HistoryMessageIdentifier) {
        messagingStruct$HistoryMessageIdentifier.getClass();
        MessagingStruct$HistoryMessageIdentifier messagingStruct$HistoryMessageIdentifier2 = this.msg_;
        if (messagingStruct$HistoryMessageIdentifier2 == null || messagingStruct$HistoryMessageIdentifier2 == MessagingStruct$HistoryMessageIdentifier.getDefaultInstance()) {
            this.msg_ = messagingStruct$HistoryMessageIdentifier;
        } else {
            this.msg_ = (MessagingStruct$HistoryMessageIdentifier) ((MessagingStruct$HistoryMessageIdentifier.a) MessagingStruct$HistoryMessageIdentifier.newBuilder(this.msg_).v(messagingStruct$HistoryMessageIdentifier)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static ReactionsStruct$Reaction parseDelimitedFrom(InputStream inputStream) {
        return (ReactionsStruct$Reaction) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ReactionsStruct$Reaction parseFrom(ByteBuffer byteBuffer) {
        return (ReactionsStruct$Reaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeReactionState(int i) {
        ensureReactionStateIsMutable();
        this.reactionState_.remove(i);
    }

    private void setMsg(MessagingStruct$HistoryMessageIdentifier messagingStruct$HistoryMessageIdentifier) {
        messagingStruct$HistoryMessageIdentifier.getClass();
        this.msg_ = messagingStruct$HistoryMessageIdentifier;
        this.bitField0_ |= 1;
    }

    private void setReactionState(int i, BankStruct$ReactionEntity bankStruct$ReactionEntity) {
        bankStruct$ReactionEntity.getClass();
        ensureReactionStateIsMutable();
        this.reactionState_.set(i, bankStruct$ReactionEntity);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1892s1.a[gVar.ordinal()]) {
            case 1:
                return new ReactionsStruct$Reaction();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဉ\u0000\u0002\u001b", new Object[]{"bitField0_", "msg_", "reactionState_", BankStruct$ReactionEntity.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (ReactionsStruct$Reaction.class) {
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

    public MessagingStruct$HistoryMessageIdentifier getMsg() {
        MessagingStruct$HistoryMessageIdentifier messagingStruct$HistoryMessageIdentifier = this.msg_;
        return messagingStruct$HistoryMessageIdentifier == null ? MessagingStruct$HistoryMessageIdentifier.getDefaultInstance() : messagingStruct$HistoryMessageIdentifier;
    }

    public BankStruct$ReactionEntity getReactionState(int i) {
        return (BankStruct$ReactionEntity) this.reactionState_.get(i);
    }

    public int getReactionStateCount() {
        return this.reactionState_.size();
    }

    public List<BankStruct$ReactionEntity> getReactionStateList() {
        return this.reactionState_;
    }

    public X60 getReactionStateOrBuilder(int i) {
        return (X60) this.reactionState_.get(i);
    }

    public List<? extends X60> getReactionStateOrBuilderList() {
        return this.reactionState_;
    }

    public boolean hasMsg() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(ReactionsStruct$Reaction reactionsStruct$Reaction) {
        return (a) DEFAULT_INSTANCE.createBuilder(reactionsStruct$Reaction);
    }

    public static ReactionsStruct$Reaction parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (ReactionsStruct$Reaction) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static ReactionsStruct$Reaction parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (ReactionsStruct$Reaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static ReactionsStruct$Reaction parseFrom(AbstractC2383g abstractC2383g) {
        return (ReactionsStruct$Reaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addReactionState(int i, BankStruct$ReactionEntity bankStruct$ReactionEntity) {
        bankStruct$ReactionEntity.getClass();
        ensureReactionStateIsMutable();
        this.reactionState_.add(i, bankStruct$ReactionEntity);
    }

    public static ReactionsStruct$Reaction parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (ReactionsStruct$Reaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static ReactionsStruct$Reaction parseFrom(byte[] bArr) {
        return (ReactionsStruct$Reaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static ReactionsStruct$Reaction parseFrom(byte[] bArr, C2394s c2394s) {
        return (ReactionsStruct$Reaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static ReactionsStruct$Reaction parseFrom(InputStream inputStream) {
        return (ReactionsStruct$Reaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ReactionsStruct$Reaction parseFrom(InputStream inputStream, C2394s c2394s) {
        return (ReactionsStruct$Reaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static ReactionsStruct$Reaction parseFrom(AbstractC2384h abstractC2384h) {
        return (ReactionsStruct$Reaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static ReactionsStruct$Reaction parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (ReactionsStruct$Reaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
