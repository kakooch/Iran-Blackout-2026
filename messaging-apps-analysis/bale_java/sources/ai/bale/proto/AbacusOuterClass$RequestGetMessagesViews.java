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
public final class AbacusOuterClass$RequestGetMessagesViews extends GeneratedMessageLite implements U64 {
    public static final int CORRECT_MIDS_FIELD_NUMBER = 4;
    private static final AbacusOuterClass$RequestGetMessagesViews DEFAULT_INSTANCE;
    public static final int INCREMENT_FIELD_NUMBER = 3;
    public static final int MIDS_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int PEER_FIELD_NUMBER = 1;
    private int bitField0_;
    private boolean increment_;
    private PeersStruct$OutPeer peer_;
    private B.j mids_ = GeneratedMessageLite.emptyProtobufList();
    private B.j correctMids_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(Iterable iterable) {
            q();
            ((AbacusOuterClass$RequestGetMessagesViews) this.b).addAllCorrectMids(iterable);
            return this;
        }

        public a B(Iterable iterable) {
            q();
            ((AbacusOuterClass$RequestGetMessagesViews) this.b).addAllMids(iterable);
            return this;
        }

        public a C(boolean z) {
            q();
            ((AbacusOuterClass$RequestGetMessagesViews) this.b).setIncrement(z);
            return this;
        }

        public a D(PeersStruct$OutPeer peersStruct$OutPeer) {
            q();
            ((AbacusOuterClass$RequestGetMessagesViews) this.b).setPeer(peersStruct$OutPeer);
            return this;
        }

        private a() {
            super(AbacusOuterClass$RequestGetMessagesViews.DEFAULT_INSTANCE);
        }
    }

    static {
        AbacusOuterClass$RequestGetMessagesViews abacusOuterClass$RequestGetMessagesViews = new AbacusOuterClass$RequestGetMessagesViews();
        DEFAULT_INSTANCE = abacusOuterClass$RequestGetMessagesViews;
        GeneratedMessageLite.registerDefaultInstance(AbacusOuterClass$RequestGetMessagesViews.class, abacusOuterClass$RequestGetMessagesViews);
    }

    private AbacusOuterClass$RequestGetMessagesViews() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllCorrectMids(Iterable<? extends MessagingStruct$MessageId> iterable) {
        ensureCorrectMidsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.correctMids_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllMids(Iterable<? extends MessagingStruct$MessageId> iterable) {
        ensureMidsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.mids_);
    }

    private void addCorrectMids(MessagingStruct$MessageId messagingStruct$MessageId) {
        messagingStruct$MessageId.getClass();
        ensureCorrectMidsIsMutable();
        this.correctMids_.add(messagingStruct$MessageId);
    }

    private void addMids(MessagingStruct$MessageId messagingStruct$MessageId) {
        messagingStruct$MessageId.getClass();
        ensureMidsIsMutable();
        this.mids_.add(messagingStruct$MessageId);
    }

    private void clearCorrectMids() {
        this.correctMids_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearIncrement() {
        this.increment_ = false;
    }

    private void clearMids() {
        this.mids_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearPeer() {
        this.peer_ = null;
        this.bitField0_ &= -2;
    }

    private void ensureCorrectMidsIsMutable() {
        B.j jVar = this.correctMids_;
        if (jVar.u()) {
            return;
        }
        this.correctMids_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    private void ensureMidsIsMutable() {
        B.j jVar = this.mids_;
        if (jVar.u()) {
            return;
        }
        this.mids_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static AbacusOuterClass$RequestGetMessagesViews getDefaultInstance() {
        return DEFAULT_INSTANCE;
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

    public static AbacusOuterClass$RequestGetMessagesViews parseDelimitedFrom(InputStream inputStream) {
        return (AbacusOuterClass$RequestGetMessagesViews) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AbacusOuterClass$RequestGetMessagesViews parseFrom(ByteBuffer byteBuffer) {
        return (AbacusOuterClass$RequestGetMessagesViews) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeCorrectMids(int i) {
        ensureCorrectMidsIsMutable();
        this.correctMids_.remove(i);
    }

    private void removeMids(int i) {
        ensureMidsIsMutable();
        this.mids_.remove(i);
    }

    private void setCorrectMids(int i, MessagingStruct$MessageId messagingStruct$MessageId) {
        messagingStruct$MessageId.getClass();
        ensureCorrectMidsIsMutable();
        this.correctMids_.set(i, messagingStruct$MessageId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIncrement(boolean z) {
        this.increment_ = z;
    }

    private void setMids(int i, MessagingStruct$MessageId messagingStruct$MessageId) {
        messagingStruct$MessageId.getClass();
        ensureMidsIsMutable();
        this.mids_.set(i, messagingStruct$MessageId);
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
                return new AbacusOuterClass$RequestGetMessagesViews();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0002\u0000\u0001ဉ\u0000\u0002\u001b\u0003\u0007\u0004\u001b", new Object[]{"bitField0_", "peer_", "mids_", MessagingStruct$MessageId.class, "increment_", "correctMids_", MessagingStruct$MessageId.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AbacusOuterClass$RequestGetMessagesViews.class) {
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

    public MessagingStruct$MessageId getCorrectMids(int i) {
        return (MessagingStruct$MessageId) this.correctMids_.get(i);
    }

    public int getCorrectMidsCount() {
        return this.correctMids_.size();
    }

    public List<MessagingStruct$MessageId> getCorrectMidsList() {
        return this.correctMids_;
    }

    public InterfaceC13043fc4 getCorrectMidsOrBuilder(int i) {
        return (InterfaceC13043fc4) this.correctMids_.get(i);
    }

    public List<? extends InterfaceC13043fc4> getCorrectMidsOrBuilderList() {
        return this.correctMids_;
    }

    public boolean getIncrement() {
        return this.increment_;
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

    public PeersStruct$OutPeer getPeer() {
        PeersStruct$OutPeer peersStruct$OutPeer = this.peer_;
        return peersStruct$OutPeer == null ? PeersStruct$OutPeer.getDefaultInstance() : peersStruct$OutPeer;
    }

    public boolean hasPeer() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(AbacusOuterClass$RequestGetMessagesViews abacusOuterClass$RequestGetMessagesViews) {
        return (a) DEFAULT_INSTANCE.createBuilder(abacusOuterClass$RequestGetMessagesViews);
    }

    public static AbacusOuterClass$RequestGetMessagesViews parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AbacusOuterClass$RequestGetMessagesViews) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AbacusOuterClass$RequestGetMessagesViews parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AbacusOuterClass$RequestGetMessagesViews) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AbacusOuterClass$RequestGetMessagesViews parseFrom(AbstractC2383g abstractC2383g) {
        return (AbacusOuterClass$RequestGetMessagesViews) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addCorrectMids(int i, MessagingStruct$MessageId messagingStruct$MessageId) {
        messagingStruct$MessageId.getClass();
        ensureCorrectMidsIsMutable();
        this.correctMids_.add(i, messagingStruct$MessageId);
    }

    private void addMids(int i, MessagingStruct$MessageId messagingStruct$MessageId) {
        messagingStruct$MessageId.getClass();
        ensureMidsIsMutable();
        this.mids_.add(i, messagingStruct$MessageId);
    }

    public static AbacusOuterClass$RequestGetMessagesViews parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AbacusOuterClass$RequestGetMessagesViews) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AbacusOuterClass$RequestGetMessagesViews parseFrom(byte[] bArr) {
        return (AbacusOuterClass$RequestGetMessagesViews) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AbacusOuterClass$RequestGetMessagesViews parseFrom(byte[] bArr, C2394s c2394s) {
        return (AbacusOuterClass$RequestGetMessagesViews) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AbacusOuterClass$RequestGetMessagesViews parseFrom(InputStream inputStream) {
        return (AbacusOuterClass$RequestGetMessagesViews) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AbacusOuterClass$RequestGetMessagesViews parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AbacusOuterClass$RequestGetMessagesViews) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AbacusOuterClass$RequestGetMessagesViews parseFrom(AbstractC2384h abstractC2384h) {
        return (AbacusOuterClass$RequestGetMessagesViews) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AbacusOuterClass$RequestGetMessagesViews parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AbacusOuterClass$RequestGetMessagesViews) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
