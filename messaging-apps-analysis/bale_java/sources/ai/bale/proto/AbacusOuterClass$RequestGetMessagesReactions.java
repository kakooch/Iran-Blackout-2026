package ai.bale.proto;

import ai.bale.proto.PeersStruct$OutPeer;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC13043fc4;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes6.dex */
public final class AbacusOuterClass$RequestGetMessagesReactions extends GeneratedMessageLite implements U64 {
    private static final AbacusOuterClass$RequestGetMessagesReactions DEFAULT_INSTANCE;
    public static final int MIDS_FIELD_NUMBER = 2;
    public static final int ORIGIN_MIDS_FIELD_NUMBER = 4;
    public static final int ORIGIN_PEER_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER = null;
    public static final int PEER_FIELD_NUMBER = 1;
    private int bitField0_;
    private B.j mids_ = GeneratedMessageLite.emptyProtobufList();
    private B.j originMids_ = GeneratedMessageLite.emptyProtobufList();
    private PeersStruct$OutPeer originPeer_;
    private PeersStruct$OutPeer peer_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(Iterable iterable) {
            q();
            ((AbacusOuterClass$RequestGetMessagesReactions) this.b).addAllMids(iterable);
            return this;
        }

        public a B(Iterable iterable) {
            q();
            ((AbacusOuterClass$RequestGetMessagesReactions) this.b).addAllOriginMids(iterable);
            return this;
        }

        public a C(PeersStruct$OutPeer peersStruct$OutPeer) {
            q();
            ((AbacusOuterClass$RequestGetMessagesReactions) this.b).setOriginPeer(peersStruct$OutPeer);
            return this;
        }

        public a D(PeersStruct$OutPeer peersStruct$OutPeer) {
            q();
            ((AbacusOuterClass$RequestGetMessagesReactions) this.b).setPeer(peersStruct$OutPeer);
            return this;
        }

        private a() {
            super(AbacusOuterClass$RequestGetMessagesReactions.DEFAULT_INSTANCE);
        }
    }

    static {
        AbacusOuterClass$RequestGetMessagesReactions abacusOuterClass$RequestGetMessagesReactions = new AbacusOuterClass$RequestGetMessagesReactions();
        DEFAULT_INSTANCE = abacusOuterClass$RequestGetMessagesReactions;
        GeneratedMessageLite.registerDefaultInstance(AbacusOuterClass$RequestGetMessagesReactions.class, abacusOuterClass$RequestGetMessagesReactions);
    }

    private AbacusOuterClass$RequestGetMessagesReactions() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllMids(Iterable<? extends MessagingStruct$MessageId> iterable) {
        ensureMidsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.mids_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllOriginMids(Iterable<? extends MessagingStruct$MessageId> iterable) {
        ensureOriginMidsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.originMids_);
    }

    private void addMids(MessagingStruct$MessageId messagingStruct$MessageId) {
        messagingStruct$MessageId.getClass();
        ensureMidsIsMutable();
        this.mids_.add(messagingStruct$MessageId);
    }

    private void addOriginMids(MessagingStruct$MessageId messagingStruct$MessageId) {
        messagingStruct$MessageId.getClass();
        ensureOriginMidsIsMutable();
        this.originMids_.add(messagingStruct$MessageId);
    }

    private void clearMids() {
        this.mids_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearOriginMids() {
        this.originMids_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearOriginPeer() {
        this.originPeer_ = null;
        this.bitField0_ &= -3;
    }

    private void clearPeer() {
        this.peer_ = null;
        this.bitField0_ &= -2;
    }

    private void ensureMidsIsMutable() {
        B.j jVar = this.mids_;
        if (jVar.u()) {
            return;
        }
        this.mids_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    private void ensureOriginMidsIsMutable() {
        B.j jVar = this.originMids_;
        if (jVar.u()) {
            return;
        }
        this.originMids_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static AbacusOuterClass$RequestGetMessagesReactions getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeOriginPeer(PeersStruct$OutPeer peersStruct$OutPeer) {
        peersStruct$OutPeer.getClass();
        PeersStruct$OutPeer peersStruct$OutPeer2 = this.originPeer_;
        if (peersStruct$OutPeer2 == null || peersStruct$OutPeer2 == PeersStruct$OutPeer.getDefaultInstance()) {
            this.originPeer_ = peersStruct$OutPeer;
        } else {
            this.originPeer_ = (PeersStruct$OutPeer) ((PeersStruct$OutPeer.a) PeersStruct$OutPeer.newBuilder(this.originPeer_).v(peersStruct$OutPeer)).j();
        }
        this.bitField0_ |= 2;
    }

    private void mergePeer(PeersStruct$OutPeer peersStruct$OutPeer) {
        peersStruct$OutPeer.getClass();
        PeersStruct$OutPeer peersStruct$OutPeer2 = this.peer_;
        if (peersStruct$OutPeer2 == null || peersStruct$OutPeer2 == PeersStruct$OutPeer.getDefaultInstance()) {
            this.peer_ = peersStruct$OutPeer;
        } else {
            this.peer_ = (PeersStruct$OutPeer) ((PeersStruct$OutPeer.a) PeersStruct$OutPeer.newBuilder(this.peer_).v(peersStruct$OutPeer)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AbacusOuterClass$RequestGetMessagesReactions parseDelimitedFrom(InputStream inputStream) {
        return (AbacusOuterClass$RequestGetMessagesReactions) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AbacusOuterClass$RequestGetMessagesReactions parseFrom(ByteBuffer byteBuffer) {
        return (AbacusOuterClass$RequestGetMessagesReactions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeMids(int i) {
        ensureMidsIsMutable();
        this.mids_.remove(i);
    }

    private void removeOriginMids(int i) {
        ensureOriginMidsIsMutable();
        this.originMids_.remove(i);
    }

    private void setMids(int i, MessagingStruct$MessageId messagingStruct$MessageId) {
        messagingStruct$MessageId.getClass();
        ensureMidsIsMutable();
        this.mids_.set(i, messagingStruct$MessageId);
    }

    private void setOriginMids(int i, MessagingStruct$MessageId messagingStruct$MessageId) {
        messagingStruct$MessageId.getClass();
        ensureOriginMidsIsMutable();
        this.originMids_.set(i, messagingStruct$MessageId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOriginPeer(PeersStruct$OutPeer peersStruct$OutPeer) {
        peersStruct$OutPeer.getClass();
        this.originPeer_ = peersStruct$OutPeer;
        this.bitField0_ |= 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPeer(PeersStruct$OutPeer peersStruct$OutPeer) {
        peersStruct$OutPeer.getClass();
        this.peer_ = peersStruct$OutPeer;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1837a.a[gVar.ordinal()]) {
            case 1:
                return new AbacusOuterClass$RequestGetMessagesReactions();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0002\u0000\u0001ဉ\u0000\u0002\u001b\u0003ဉ\u0001\u0004\u001b", new Object[]{"bitField0_", "peer_", "mids_", MessagingStruct$MessageId.class, "originPeer_", "originMids_", MessagingStruct$MessageId.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AbacusOuterClass$RequestGetMessagesReactions.class) {
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

    public MessagingStruct$MessageId getMids(int i) {
        return (MessagingStruct$MessageId) this.mids_.get(i);
    }

    public int getMidsCount() {
        return this.mids_.size();
    }

    public List<MessagingStruct$MessageId> getMidsList() {
        return this.mids_;
    }

    public InterfaceC13043fc4 getMidsOrBuilder(int i) {
        return (InterfaceC13043fc4) this.mids_.get(i);
    }

    public List<? extends InterfaceC13043fc4> getMidsOrBuilderList() {
        return this.mids_;
    }

    public MessagingStruct$MessageId getOriginMids(int i) {
        return (MessagingStruct$MessageId) this.originMids_.get(i);
    }

    public int getOriginMidsCount() {
        return this.originMids_.size();
    }

    public List<MessagingStruct$MessageId> getOriginMidsList() {
        return this.originMids_;
    }

    public InterfaceC13043fc4 getOriginMidsOrBuilder(int i) {
        return (InterfaceC13043fc4) this.originMids_.get(i);
    }

    public List<? extends InterfaceC13043fc4> getOriginMidsOrBuilderList() {
        return this.originMids_;
    }

    public PeersStruct$OutPeer getOriginPeer() {
        PeersStruct$OutPeer peersStruct$OutPeer = this.originPeer_;
        return peersStruct$OutPeer == null ? PeersStruct$OutPeer.getDefaultInstance() : peersStruct$OutPeer;
    }

    public PeersStruct$OutPeer getPeer() {
        PeersStruct$OutPeer peersStruct$OutPeer = this.peer_;
        return peersStruct$OutPeer == null ? PeersStruct$OutPeer.getDefaultInstance() : peersStruct$OutPeer;
    }

    public boolean hasOriginPeer() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasPeer() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(AbacusOuterClass$RequestGetMessagesReactions abacusOuterClass$RequestGetMessagesReactions) {
        return (a) DEFAULT_INSTANCE.createBuilder(abacusOuterClass$RequestGetMessagesReactions);
    }

    public static AbacusOuterClass$RequestGetMessagesReactions parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AbacusOuterClass$RequestGetMessagesReactions) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AbacusOuterClass$RequestGetMessagesReactions parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AbacusOuterClass$RequestGetMessagesReactions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AbacusOuterClass$RequestGetMessagesReactions parseFrom(AbstractC2383g abstractC2383g) {
        return (AbacusOuterClass$RequestGetMessagesReactions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addMids(int i, MessagingStruct$MessageId messagingStruct$MessageId) {
        messagingStruct$MessageId.getClass();
        ensureMidsIsMutable();
        this.mids_.add(i, messagingStruct$MessageId);
    }

    private void addOriginMids(int i, MessagingStruct$MessageId messagingStruct$MessageId) {
        messagingStruct$MessageId.getClass();
        ensureOriginMidsIsMutable();
        this.originMids_.add(i, messagingStruct$MessageId);
    }

    public static AbacusOuterClass$RequestGetMessagesReactions parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AbacusOuterClass$RequestGetMessagesReactions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AbacusOuterClass$RequestGetMessagesReactions parseFrom(byte[] bArr) {
        return (AbacusOuterClass$RequestGetMessagesReactions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AbacusOuterClass$RequestGetMessagesReactions parseFrom(byte[] bArr, C2394s c2394s) {
        return (AbacusOuterClass$RequestGetMessagesReactions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AbacusOuterClass$RequestGetMessagesReactions parseFrom(InputStream inputStream) {
        return (AbacusOuterClass$RequestGetMessagesReactions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AbacusOuterClass$RequestGetMessagesReactions parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AbacusOuterClass$RequestGetMessagesReactions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AbacusOuterClass$RequestGetMessagesReactions parseFrom(AbstractC2384h abstractC2384h) {
        return (AbacusOuterClass$RequestGetMessagesReactions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AbacusOuterClass$RequestGetMessagesReactions parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AbacusOuterClass$RequestGetMessagesReactions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
