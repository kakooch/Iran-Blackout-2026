package ai.bale.proto;

import ai.bale.proto.PeersStruct$Peer;
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
public final class AbacusOuterClass$UpdateReactionsUpdate extends GeneratedMessageLite implements U64 {
    private static final AbacusOuterClass$UpdateReactionsUpdate DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int PEER_FIELD_NUMBER = 1;
    public static final int REACTIONS_FIELD_NUMBER = 3;
    public static final int REACTION_BY_ME_FIELD_NUMBER = 4;
    public static final int RID_FIELD_NUMBER = 2;
    private int bitField0_;
    private PeersStruct$Peer peer_;
    private boolean reactionByMe_;
    private B.j reactions_ = GeneratedMessageLite.emptyProtobufList();
    private long rid_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(AbacusOuterClass$UpdateReactionsUpdate.DEFAULT_INSTANCE);
        }
    }

    static {
        AbacusOuterClass$UpdateReactionsUpdate abacusOuterClass$UpdateReactionsUpdate = new AbacusOuterClass$UpdateReactionsUpdate();
        DEFAULT_INSTANCE = abacusOuterClass$UpdateReactionsUpdate;
        GeneratedMessageLite.registerDefaultInstance(AbacusOuterClass$UpdateReactionsUpdate.class, abacusOuterClass$UpdateReactionsUpdate);
    }

    private AbacusOuterClass$UpdateReactionsUpdate() {
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

    private void clearPeer() {
        this.peer_ = null;
        this.bitField0_ &= -2;
    }

    private void clearReactionByMe() {
        this.reactionByMe_ = false;
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

    public static AbacusOuterClass$UpdateReactionsUpdate getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergePeer(PeersStruct$Peer peersStruct$Peer) {
        peersStruct$Peer.getClass();
        PeersStruct$Peer peersStruct$Peer2 = this.peer_;
        if (peersStruct$Peer2 == null || peersStruct$Peer2 == PeersStruct$Peer.getDefaultInstance()) {
            this.peer_ = peersStruct$Peer;
        } else {
            this.peer_ = (PeersStruct$Peer) ((PeersStruct$Peer.a) PeersStruct$Peer.newBuilder(this.peer_).v(peersStruct$Peer)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AbacusOuterClass$UpdateReactionsUpdate parseDelimitedFrom(InputStream inputStream) {
        return (AbacusOuterClass$UpdateReactionsUpdate) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AbacusOuterClass$UpdateReactionsUpdate parseFrom(ByteBuffer byteBuffer) {
        return (AbacusOuterClass$UpdateReactionsUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeReactions(int i) {
        ensureReactionsIsMutable();
        this.reactions_.remove(i);
    }

    private void setPeer(PeersStruct$Peer peersStruct$Peer) {
        peersStruct$Peer.getClass();
        this.peer_ = peersStruct$Peer;
        this.bitField0_ |= 1;
    }

    private void setReactionByMe(boolean z) {
        this.reactionByMe_ = z;
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
        switch (AbstractC1837a.a[gVar.ordinal()]) {
            case 1:
                return new AbacusOuterClass$UpdateReactionsUpdate();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001ဉ\u0000\u0002\u0002\u0003\u001b\u0004\u0007", new Object[]{"bitField0_", "peer_", "rid_", "reactions_", MessagingStruct$MessageReaction.class, "reactionByMe_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AbacusOuterClass$UpdateReactionsUpdate.class) {
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

    public PeersStruct$Peer getPeer() {
        PeersStruct$Peer peersStruct$Peer = this.peer_;
        return peersStruct$Peer == null ? PeersStruct$Peer.getDefaultInstance() : peersStruct$Peer;
    }

    public boolean getReactionByMe() {
        return this.reactionByMe_;
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

    public boolean hasPeer() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(AbacusOuterClass$UpdateReactionsUpdate abacusOuterClass$UpdateReactionsUpdate) {
        return (a) DEFAULT_INSTANCE.createBuilder(abacusOuterClass$UpdateReactionsUpdate);
    }

    public static AbacusOuterClass$UpdateReactionsUpdate parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AbacusOuterClass$UpdateReactionsUpdate) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AbacusOuterClass$UpdateReactionsUpdate parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AbacusOuterClass$UpdateReactionsUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AbacusOuterClass$UpdateReactionsUpdate parseFrom(AbstractC2383g abstractC2383g) {
        return (AbacusOuterClass$UpdateReactionsUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addReactions(int i, MessagingStruct$MessageReaction messagingStruct$MessageReaction) {
        messagingStruct$MessageReaction.getClass();
        ensureReactionsIsMutable();
        this.reactions_.add(i, messagingStruct$MessageReaction);
    }

    public static AbacusOuterClass$UpdateReactionsUpdate parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AbacusOuterClass$UpdateReactionsUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AbacusOuterClass$UpdateReactionsUpdate parseFrom(byte[] bArr) {
        return (AbacusOuterClass$UpdateReactionsUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AbacusOuterClass$UpdateReactionsUpdate parseFrom(byte[] bArr, C2394s c2394s) {
        return (AbacusOuterClass$UpdateReactionsUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AbacusOuterClass$UpdateReactionsUpdate parseFrom(InputStream inputStream) {
        return (AbacusOuterClass$UpdateReactionsUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AbacusOuterClass$UpdateReactionsUpdate parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AbacusOuterClass$UpdateReactionsUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AbacusOuterClass$UpdateReactionsUpdate parseFrom(AbstractC2384h abstractC2384h) {
        return (AbacusOuterClass$UpdateReactionsUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AbacusOuterClass$UpdateReactionsUpdate parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AbacusOuterClass$UpdateReactionsUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
