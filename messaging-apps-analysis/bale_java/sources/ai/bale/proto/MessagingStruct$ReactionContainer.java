package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC15452jc4;
import ir.nasim.InterfaceC5384Jc4;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class MessagingStruct$ReactionContainer extends GeneratedMessageLite implements InterfaceC5384Jc4 {
    public static final int DATE_FIELD_NUMBER = 2;
    private static final MessagingStruct$ReactionContainer DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int REACTIONS_FIELD_NUMBER = 3;
    public static final int RID_FIELD_NUMBER = 1;
    private long date_;
    private B.j reactions_ = GeneratedMessageLite.emptyProtobufList();
    private long rid_;

    public static final class a extends GeneratedMessageLite.b implements InterfaceC5384Jc4 {
        private a() {
            super(MessagingStruct$ReactionContainer.DEFAULT_INSTANCE);
        }
    }

    static {
        MessagingStruct$ReactionContainer messagingStruct$ReactionContainer = new MessagingStruct$ReactionContainer();
        DEFAULT_INSTANCE = messagingStruct$ReactionContainer;
        GeneratedMessageLite.registerDefaultInstance(MessagingStruct$ReactionContainer.class, messagingStruct$ReactionContainer);
    }

    private MessagingStruct$ReactionContainer() {
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

    private void clearDate() {
        this.date_ = 0L;
    }

    private void clearReactions() {
        this.reactions_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearRid() {
        this.rid_ = 0L;
    }

    private void ensureReactionsIsMutable() {
        B.j jVar = this.reactions_;
        if (jVar.u()) {
            return;
        }
        this.reactions_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static MessagingStruct$ReactionContainer getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MessagingStruct$ReactionContainer parseDelimitedFrom(InputStream inputStream) {
        return (MessagingStruct$ReactionContainer) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$ReactionContainer parseFrom(ByteBuffer byteBuffer) {
        return (MessagingStruct$ReactionContainer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeReactions(int i) {
        ensureReactionsIsMutable();
        this.reactions_.remove(i);
    }

    private void setDate(long j) {
        this.date_ = j;
    }

    private void setReactions(int i, MessagingStruct$MessageReaction messagingStruct$MessageReaction) {
        messagingStruct$MessageReaction.getClass();
        ensureReactionsIsMutable();
        this.reactions_.set(i, messagingStruct$MessageReaction);
    }

    private void setRid(long j) {
        this.rid_ = j;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (L0.a[gVar.ordinal()]) {
            case 1:
                return new MessagingStruct$ReactionContainer();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0001\u0000\u0001\u0002\u0002\u0002\u0003\u001b", new Object[]{"rid_", "date_", "reactions_", MessagingStruct$MessageReaction.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingStruct$ReactionContainer.class) {
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

    public long getDate() {
        return this.date_;
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

    public long getRid() {
        return this.rid_;
    }

    public static a newBuilder(MessagingStruct$ReactionContainer messagingStruct$ReactionContainer) {
        return (a) DEFAULT_INSTANCE.createBuilder(messagingStruct$ReactionContainer);
    }

    public static MessagingStruct$ReactionContainer parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$ReactionContainer) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$ReactionContainer parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingStruct$ReactionContainer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingStruct$ReactionContainer parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingStruct$ReactionContainer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addReactions(int i, MessagingStruct$MessageReaction messagingStruct$MessageReaction) {
        messagingStruct$MessageReaction.getClass();
        ensureReactionsIsMutable();
        this.reactions_.add(i, messagingStruct$MessageReaction);
    }

    public static MessagingStruct$ReactionContainer parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingStruct$ReactionContainer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingStruct$ReactionContainer parseFrom(byte[] bArr) {
        return (MessagingStruct$ReactionContainer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingStruct$ReactionContainer parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingStruct$ReactionContainer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MessagingStruct$ReactionContainer parseFrom(InputStream inputStream) {
        return (MessagingStruct$ReactionContainer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$ReactionContainer parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$ReactionContainer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$ReactionContainer parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingStruct$ReactionContainer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingStruct$ReactionContainer parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingStruct$ReactionContainer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
