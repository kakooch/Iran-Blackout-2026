package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC15720k35;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes.dex */
public final class Tasks$ResponseGetTasksVitrineStatus extends GeneratedMessageLite implements U64 {
    private static final Tasks$ResponseGetTasksVitrineStatus DEFAULT_INSTANCE;
    public static final int JOINED_PEERS_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private B.j joinedPeers_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Tasks$ResponseGetTasksVitrineStatus.DEFAULT_INSTANCE);
        }
    }

    static {
        Tasks$ResponseGetTasksVitrineStatus tasks$ResponseGetTasksVitrineStatus = new Tasks$ResponseGetTasksVitrineStatus();
        DEFAULT_INSTANCE = tasks$ResponseGetTasksVitrineStatus;
        GeneratedMessageLite.registerDefaultInstance(Tasks$ResponseGetTasksVitrineStatus.class, tasks$ResponseGetTasksVitrineStatus);
    }

    private Tasks$ResponseGetTasksVitrineStatus() {
    }

    private void addAllJoinedPeers(Iterable<? extends PeersStruct$Peer> iterable) {
        ensureJoinedPeersIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.joinedPeers_);
    }

    private void addJoinedPeers(PeersStruct$Peer peersStruct$Peer) {
        peersStruct$Peer.getClass();
        ensureJoinedPeersIsMutable();
        this.joinedPeers_.add(peersStruct$Peer);
    }

    private void clearJoinedPeers() {
        this.joinedPeers_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureJoinedPeersIsMutable() {
        B.j jVar = this.joinedPeers_;
        if (jVar.u()) {
            return;
        }
        this.joinedPeers_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static Tasks$ResponseGetTasksVitrineStatus getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Tasks$ResponseGetTasksVitrineStatus parseDelimitedFrom(InputStream inputStream) {
        return (Tasks$ResponseGetTasksVitrineStatus) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Tasks$ResponseGetTasksVitrineStatus parseFrom(ByteBuffer byteBuffer) {
        return (Tasks$ResponseGetTasksVitrineStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeJoinedPeers(int i) {
        ensureJoinedPeersIsMutable();
        this.joinedPeers_.remove(i);
    }

    private void setJoinedPeers(int i, PeersStruct$Peer peersStruct$Peer) {
        peersStruct$Peer.getClass();
        ensureJoinedPeersIsMutable();
        this.joinedPeers_.set(i, peersStruct$Peer);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (g2.a[gVar.ordinal()]) {
            case 1:
                return new Tasks$ResponseGetTasksVitrineStatus();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"joinedPeers_", PeersStruct$Peer.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Tasks$ResponseGetTasksVitrineStatus.class) {
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

    public PeersStruct$Peer getJoinedPeers(int i) {
        return (PeersStruct$Peer) this.joinedPeers_.get(i);
    }

    public int getJoinedPeersCount() {
        return this.joinedPeers_.size();
    }

    public List<PeersStruct$Peer> getJoinedPeersList() {
        return this.joinedPeers_;
    }

    public InterfaceC15720k35 getJoinedPeersOrBuilder(int i) {
        return (InterfaceC15720k35) this.joinedPeers_.get(i);
    }

    public List<? extends InterfaceC15720k35> getJoinedPeersOrBuilderList() {
        return this.joinedPeers_;
    }

    public static a newBuilder(Tasks$ResponseGetTasksVitrineStatus tasks$ResponseGetTasksVitrineStatus) {
        return (a) DEFAULT_INSTANCE.createBuilder(tasks$ResponseGetTasksVitrineStatus);
    }

    public static Tasks$ResponseGetTasksVitrineStatus parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Tasks$ResponseGetTasksVitrineStatus) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Tasks$ResponseGetTasksVitrineStatus parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Tasks$ResponseGetTasksVitrineStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Tasks$ResponseGetTasksVitrineStatus parseFrom(AbstractC2383g abstractC2383g) {
        return (Tasks$ResponseGetTasksVitrineStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addJoinedPeers(int i, PeersStruct$Peer peersStruct$Peer) {
        peersStruct$Peer.getClass();
        ensureJoinedPeersIsMutable();
        this.joinedPeers_.add(i, peersStruct$Peer);
    }

    public static Tasks$ResponseGetTasksVitrineStatus parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Tasks$ResponseGetTasksVitrineStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Tasks$ResponseGetTasksVitrineStatus parseFrom(byte[] bArr) {
        return (Tasks$ResponseGetTasksVitrineStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Tasks$ResponseGetTasksVitrineStatus parseFrom(byte[] bArr, C2394s c2394s) {
        return (Tasks$ResponseGetTasksVitrineStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Tasks$ResponseGetTasksVitrineStatus parseFrom(InputStream inputStream) {
        return (Tasks$ResponseGetTasksVitrineStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Tasks$ResponseGetTasksVitrineStatus parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Tasks$ResponseGetTasksVitrineStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Tasks$ResponseGetTasksVitrineStatus parseFrom(AbstractC2384h abstractC2384h) {
        return (Tasks$ResponseGetTasksVitrineStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Tasks$ResponseGetTasksVitrineStatus parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Tasks$ResponseGetTasksVitrineStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
