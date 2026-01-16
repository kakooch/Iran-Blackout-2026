package ai.bale.proto;

import ai.bale.proto.PeersStruct$Peer;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import ir.nasim.X60;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class BankOuterClass$UpdateMessageCardinalityReaction extends GeneratedMessageLite implements U64 {
    public static final int DATE_FIELD_NUMBER = 3;
    private static final BankOuterClass$UpdateMessageCardinalityReaction DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int PEER_FIELD_NUMBER = 1;
    public static final int RANDOM_ID_FIELD_NUMBER = 2;
    public static final int REACTION_STATE_FIELD_NUMBER = 4;
    private int bitField0_;
    private long date_;
    private PeersStruct$Peer peer_;
    private long randomId_;
    private B.j reactionState_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(BankOuterClass$UpdateMessageCardinalityReaction.DEFAULT_INSTANCE);
        }
    }

    static {
        BankOuterClass$UpdateMessageCardinalityReaction bankOuterClass$UpdateMessageCardinalityReaction = new BankOuterClass$UpdateMessageCardinalityReaction();
        DEFAULT_INSTANCE = bankOuterClass$UpdateMessageCardinalityReaction;
        GeneratedMessageLite.registerDefaultInstance(BankOuterClass$UpdateMessageCardinalityReaction.class, bankOuterClass$UpdateMessageCardinalityReaction);
    }

    private BankOuterClass$UpdateMessageCardinalityReaction() {
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

    private void clearDate() {
        this.date_ = 0L;
    }

    private void clearPeer() {
        this.peer_ = null;
        this.bitField0_ &= -2;
    }

    private void clearRandomId() {
        this.randomId_ = 0L;
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

    public static BankOuterClass$UpdateMessageCardinalityReaction getDefaultInstance() {
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

    public static BankOuterClass$UpdateMessageCardinalityReaction parseDelimitedFrom(InputStream inputStream) {
        return (BankOuterClass$UpdateMessageCardinalityReaction) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BankOuterClass$UpdateMessageCardinalityReaction parseFrom(ByteBuffer byteBuffer) {
        return (BankOuterClass$UpdateMessageCardinalityReaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeReactionState(int i) {
        ensureReactionStateIsMutable();
        this.reactionState_.remove(i);
    }

    private void setDate(long j) {
        this.date_ = j;
    }

    private void setPeer(PeersStruct$Peer peersStruct$Peer) {
        peersStruct$Peer.getClass();
        this.peer_ = peersStruct$Peer;
        this.bitField0_ |= 1;
    }

    private void setRandomId(long j) {
        this.randomId_ = j;
    }

    private void setReactionState(int i, BankStruct$ReactionEntity bankStruct$ReactionEntity) {
        bankStruct$ReactionEntity.getClass();
        ensureReactionStateIsMutable();
        this.reactionState_.set(i, bankStruct$ReactionEntity);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1876n.a[gVar.ordinal()]) {
            case 1:
                return new BankOuterClass$UpdateMessageCardinalityReaction();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001ဉ\u0000\u0002\u0002\u0003\u0002\u0004\u001b", new Object[]{"bitField0_", "peer_", "randomId_", "date_", "reactionState_", BankStruct$ReactionEntity.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (BankOuterClass$UpdateMessageCardinalityReaction.class) {
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

    public PeersStruct$Peer getPeer() {
        PeersStruct$Peer peersStruct$Peer = this.peer_;
        return peersStruct$Peer == null ? PeersStruct$Peer.getDefaultInstance() : peersStruct$Peer;
    }

    public long getRandomId() {
        return this.randomId_;
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

    public boolean hasPeer() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(BankOuterClass$UpdateMessageCardinalityReaction bankOuterClass$UpdateMessageCardinalityReaction) {
        return (a) DEFAULT_INSTANCE.createBuilder(bankOuterClass$UpdateMessageCardinalityReaction);
    }

    public static BankOuterClass$UpdateMessageCardinalityReaction parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (BankOuterClass$UpdateMessageCardinalityReaction) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BankOuterClass$UpdateMessageCardinalityReaction parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (BankOuterClass$UpdateMessageCardinalityReaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static BankOuterClass$UpdateMessageCardinalityReaction parseFrom(AbstractC2383g abstractC2383g) {
        return (BankOuterClass$UpdateMessageCardinalityReaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addReactionState(int i, BankStruct$ReactionEntity bankStruct$ReactionEntity) {
        bankStruct$ReactionEntity.getClass();
        ensureReactionStateIsMutable();
        this.reactionState_.add(i, bankStruct$ReactionEntity);
    }

    public static BankOuterClass$UpdateMessageCardinalityReaction parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (BankOuterClass$UpdateMessageCardinalityReaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static BankOuterClass$UpdateMessageCardinalityReaction parseFrom(byte[] bArr) {
        return (BankOuterClass$UpdateMessageCardinalityReaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static BankOuterClass$UpdateMessageCardinalityReaction parseFrom(byte[] bArr, C2394s c2394s) {
        return (BankOuterClass$UpdateMessageCardinalityReaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static BankOuterClass$UpdateMessageCardinalityReaction parseFrom(InputStream inputStream) {
        return (BankOuterClass$UpdateMessageCardinalityReaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BankOuterClass$UpdateMessageCardinalityReaction parseFrom(InputStream inputStream, C2394s c2394s) {
        return (BankOuterClass$UpdateMessageCardinalityReaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BankOuterClass$UpdateMessageCardinalityReaction parseFrom(AbstractC2384h abstractC2384h) {
        return (BankOuterClass$UpdateMessageCardinalityReaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static BankOuterClass$UpdateMessageCardinalityReaction parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (BankOuterClass$UpdateMessageCardinalityReaction) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
