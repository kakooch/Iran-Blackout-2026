package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC15452jc4;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes6.dex */
public final class AbacusOuterClass$ResponseReactionsResponse extends GeneratedMessageLite implements U64 {
    private static final AbacusOuterClass$ResponseReactionsResponse DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int REACTIONS_FIELD_NUMBER = 2;
    public static final int SEQ_FIELD_NUMBER = 1;
    public static final int STATE_FIELD_NUMBER = 3;
    private int seq_;
    private B.j reactions_ = GeneratedMessageLite.emptyProtobufList();
    private AbstractC2383g state_ = AbstractC2383g.b;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(AbacusOuterClass$ResponseReactionsResponse.DEFAULT_INSTANCE);
        }
    }

    static {
        AbacusOuterClass$ResponseReactionsResponse abacusOuterClass$ResponseReactionsResponse = new AbacusOuterClass$ResponseReactionsResponse();
        DEFAULT_INSTANCE = abacusOuterClass$ResponseReactionsResponse;
        GeneratedMessageLite.registerDefaultInstance(AbacusOuterClass$ResponseReactionsResponse.class, abacusOuterClass$ResponseReactionsResponse);
    }

    private AbacusOuterClass$ResponseReactionsResponse() {
    }

    private void addAllReactions(Iterable<? extends MessagingStruct$MessageReaction> iterable) {
        ensureReactionsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.reactions_);
    }

    private void addReactions(MessagingStruct$MessageReaction messagingStruct$MessageReaction) {
        messagingStruct$MessageReaction.getClass();
        ensureReactionsIsMutable();
        this.reactions_.add(messagingStruct$MessageReaction);
    }

    private void clearReactions() {
        this.reactions_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearSeq() {
        this.seq_ = 0;
    }

    private void clearState() {
        this.state_ = getDefaultInstance().getState();
    }

    private void ensureReactionsIsMutable() {
        B.j jVar = this.reactions_;
        if (jVar.u()) {
            return;
        }
        this.reactions_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static AbacusOuterClass$ResponseReactionsResponse getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AbacusOuterClass$ResponseReactionsResponse parseDelimitedFrom(InputStream inputStream) {
        return (AbacusOuterClass$ResponseReactionsResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AbacusOuterClass$ResponseReactionsResponse parseFrom(ByteBuffer byteBuffer) {
        return (AbacusOuterClass$ResponseReactionsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeReactions(int i) {
        ensureReactionsIsMutable();
        this.reactions_.remove(i);
    }

    private void setReactions(int i, MessagingStruct$MessageReaction messagingStruct$MessageReaction) {
        messagingStruct$MessageReaction.getClass();
        ensureReactionsIsMutable();
        this.reactions_.set(i, messagingStruct$MessageReaction);
    }

    private void setSeq(int i) {
        this.seq_ = i;
    }

    private void setState(AbstractC2383g abstractC2383g) {
        abstractC2383g.getClass();
        this.state_ = abstractC2383g;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1837a.a[gVar.ordinal()]) {
            case 1:
                return new AbacusOuterClass$ResponseReactionsResponse();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0001\u0000\u0001\u0004\u0002\u001b\u0003\n", new Object[]{"seq_", "reactions_", MessagingStruct$MessageReaction.class, "state_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AbacusOuterClass$ResponseReactionsResponse.class) {
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

    public MessagingStruct$MessageReaction getReactions(int i) {
        return (MessagingStruct$MessageReaction) this.reactions_.get(i);
    }

    public int getReactionsCount() {
        return this.reactions_.size();
    }

    public List<MessagingStruct$MessageReaction> getReactionsList() {
        return this.reactions_;
    }

    public InterfaceC15452jc4 getReactionsOrBuilder(int i) {
        return (InterfaceC15452jc4) this.reactions_.get(i);
    }

    public List<? extends InterfaceC15452jc4> getReactionsOrBuilderList() {
        return this.reactions_;
    }

    public int getSeq() {
        return this.seq_;
    }

    public AbstractC2383g getState() {
        return this.state_;
    }

    public static a newBuilder(AbacusOuterClass$ResponseReactionsResponse abacusOuterClass$ResponseReactionsResponse) {
        return (a) DEFAULT_INSTANCE.createBuilder(abacusOuterClass$ResponseReactionsResponse);
    }

    public static AbacusOuterClass$ResponseReactionsResponse parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AbacusOuterClass$ResponseReactionsResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AbacusOuterClass$ResponseReactionsResponse parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AbacusOuterClass$ResponseReactionsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AbacusOuterClass$ResponseReactionsResponse parseFrom(AbstractC2383g abstractC2383g) {
        return (AbacusOuterClass$ResponseReactionsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addReactions(int i, MessagingStruct$MessageReaction messagingStruct$MessageReaction) {
        messagingStruct$MessageReaction.getClass();
        ensureReactionsIsMutable();
        this.reactions_.add(i, messagingStruct$MessageReaction);
    }

    public static AbacusOuterClass$ResponseReactionsResponse parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AbacusOuterClass$ResponseReactionsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AbacusOuterClass$ResponseReactionsResponse parseFrom(byte[] bArr) {
        return (AbacusOuterClass$ResponseReactionsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AbacusOuterClass$ResponseReactionsResponse parseFrom(byte[] bArr, C2394s c2394s) {
        return (AbacusOuterClass$ResponseReactionsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AbacusOuterClass$ResponseReactionsResponse parseFrom(InputStream inputStream) {
        return (AbacusOuterClass$ResponseReactionsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AbacusOuterClass$ResponseReactionsResponse parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AbacusOuterClass$ResponseReactionsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AbacusOuterClass$ResponseReactionsResponse parseFrom(AbstractC2384h abstractC2384h) {
        return (AbacusOuterClass$ResponseReactionsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AbacusOuterClass$ResponseReactionsResponse parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AbacusOuterClass$ResponseReactionsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
