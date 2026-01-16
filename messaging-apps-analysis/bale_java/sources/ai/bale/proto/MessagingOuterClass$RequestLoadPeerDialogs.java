package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC13929h35;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class MessagingOuterClass$RequestLoadPeerDialogs extends GeneratedMessageLite implements U64 {
    private static final MessagingOuterClass$RequestLoadPeerDialogs DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int PEERS_FIELD_NUMBER = 1;
    private B.j peers_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(Iterable iterable) {
            q();
            ((MessagingOuterClass$RequestLoadPeerDialogs) this.b).addAllPeers(iterable);
            return this;
        }

        private a() {
            super(MessagingOuterClass$RequestLoadPeerDialogs.DEFAULT_INSTANCE);
        }
    }

    static {
        MessagingOuterClass$RequestLoadPeerDialogs messagingOuterClass$RequestLoadPeerDialogs = new MessagingOuterClass$RequestLoadPeerDialogs();
        DEFAULT_INSTANCE = messagingOuterClass$RequestLoadPeerDialogs;
        GeneratedMessageLite.registerDefaultInstance(MessagingOuterClass$RequestLoadPeerDialogs.class, messagingOuterClass$RequestLoadPeerDialogs);
    }

    private MessagingOuterClass$RequestLoadPeerDialogs() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllPeers(Iterable<? extends PeersStruct$OutPeer> iterable) {
        ensurePeersIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.peers_);
    }

    private void addPeers(PeersStruct$OutPeer peersStruct$OutPeer) {
        peersStruct$OutPeer.getClass();
        ensurePeersIsMutable();
        this.peers_.add(peersStruct$OutPeer);
    }

    private void clearPeers() {
        this.peers_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensurePeersIsMutable() {
        B.j jVar = this.peers_;
        if (jVar.u()) {
            return;
        }
        this.peers_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static MessagingOuterClass$RequestLoadPeerDialogs getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MessagingOuterClass$RequestLoadPeerDialogs parseDelimitedFrom(InputStream inputStream) {
        return (MessagingOuterClass$RequestLoadPeerDialogs) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingOuterClass$RequestLoadPeerDialogs parseFrom(ByteBuffer byteBuffer) {
        return (MessagingOuterClass$RequestLoadPeerDialogs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removePeers(int i) {
        ensurePeersIsMutable();
        this.peers_.remove(i);
    }

    private void setPeers(int i, PeersStruct$OutPeer peersStruct$OutPeer) {
        peersStruct$OutPeer.getClass();
        ensurePeersIsMutable();
        this.peers_.set(i, peersStruct$OutPeer);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (K0.a[gVar.ordinal()]) {
            case 1:
                return new MessagingOuterClass$RequestLoadPeerDialogs();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"peers_", PeersStruct$OutPeer.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingOuterClass$RequestLoadPeerDialogs.class) {
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

    public PeersStruct$OutPeer getPeers(int i) {
        return (PeersStruct$OutPeer) this.peers_.get(i);
    }

    public int getPeersCount() {
        return this.peers_.size();
    }

    public List<PeersStruct$OutPeer> getPeersList() {
        return this.peers_;
    }

    public InterfaceC13929h35 getPeersOrBuilder(int i) {
        return (InterfaceC13929h35) this.peers_.get(i);
    }

    public List<? extends InterfaceC13929h35> getPeersOrBuilderList() {
        return this.peers_;
    }

    public static a newBuilder(MessagingOuterClass$RequestLoadPeerDialogs messagingOuterClass$RequestLoadPeerDialogs) {
        return (a) DEFAULT_INSTANCE.createBuilder(messagingOuterClass$RequestLoadPeerDialogs);
    }

    public static MessagingOuterClass$RequestLoadPeerDialogs parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingOuterClass$RequestLoadPeerDialogs) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingOuterClass$RequestLoadPeerDialogs parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingOuterClass$RequestLoadPeerDialogs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingOuterClass$RequestLoadPeerDialogs parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingOuterClass$RequestLoadPeerDialogs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addPeers(int i, PeersStruct$OutPeer peersStruct$OutPeer) {
        peersStruct$OutPeer.getClass();
        ensurePeersIsMutable();
        this.peers_.add(i, peersStruct$OutPeer);
    }

    public static MessagingOuterClass$RequestLoadPeerDialogs parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingOuterClass$RequestLoadPeerDialogs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingOuterClass$RequestLoadPeerDialogs parseFrom(byte[] bArr) {
        return (MessagingOuterClass$RequestLoadPeerDialogs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingOuterClass$RequestLoadPeerDialogs parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingOuterClass$RequestLoadPeerDialogs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MessagingOuterClass$RequestLoadPeerDialogs parseFrom(InputStream inputStream) {
        return (MessagingOuterClass$RequestLoadPeerDialogs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingOuterClass$RequestLoadPeerDialogs parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingOuterClass$RequestLoadPeerDialogs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingOuterClass$RequestLoadPeerDialogs parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingOuterClass$RequestLoadPeerDialogs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingOuterClass$RequestLoadPeerDialogs parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingOuterClass$RequestLoadPeerDialogs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
