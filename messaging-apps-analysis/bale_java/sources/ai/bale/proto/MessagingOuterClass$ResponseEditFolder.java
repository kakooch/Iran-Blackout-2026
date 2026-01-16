package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC9494a35;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class MessagingOuterClass$ResponseEditFolder extends GeneratedMessageLite implements U64 {
    private static final MessagingOuterClass$ResponseEditFolder DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int UNREAD_PEERS_FIELD_NUMBER = 1;
    private B.j unreadPeers_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MessagingOuterClass$ResponseEditFolder.DEFAULT_INSTANCE);
        }
    }

    static {
        MessagingOuterClass$ResponseEditFolder messagingOuterClass$ResponseEditFolder = new MessagingOuterClass$ResponseEditFolder();
        DEFAULT_INSTANCE = messagingOuterClass$ResponseEditFolder;
        GeneratedMessageLite.registerDefaultInstance(MessagingOuterClass$ResponseEditFolder.class, messagingOuterClass$ResponseEditFolder);
    }

    private MessagingOuterClass$ResponseEditFolder() {
    }

    private void addAllUnreadPeers(Iterable<? extends PeersStruct$ExPeer> iterable) {
        ensureUnreadPeersIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.unreadPeers_);
    }

    private void addUnreadPeers(PeersStruct$ExPeer peersStruct$ExPeer) {
        peersStruct$ExPeer.getClass();
        ensureUnreadPeersIsMutable();
        this.unreadPeers_.add(peersStruct$ExPeer);
    }

    private void clearUnreadPeers() {
        this.unreadPeers_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureUnreadPeersIsMutable() {
        B.j jVar = this.unreadPeers_;
        if (jVar.u()) {
            return;
        }
        this.unreadPeers_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static MessagingOuterClass$ResponseEditFolder getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MessagingOuterClass$ResponseEditFolder parseDelimitedFrom(InputStream inputStream) {
        return (MessagingOuterClass$ResponseEditFolder) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingOuterClass$ResponseEditFolder parseFrom(ByteBuffer byteBuffer) {
        return (MessagingOuterClass$ResponseEditFolder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeUnreadPeers(int i) {
        ensureUnreadPeersIsMutable();
        this.unreadPeers_.remove(i);
    }

    private void setUnreadPeers(int i, PeersStruct$ExPeer peersStruct$ExPeer) {
        peersStruct$ExPeer.getClass();
        ensureUnreadPeersIsMutable();
        this.unreadPeers_.set(i, peersStruct$ExPeer);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (K0.a[gVar.ordinal()]) {
            case 1:
                return new MessagingOuterClass$ResponseEditFolder();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"unreadPeers_", PeersStruct$ExPeer.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingOuterClass$ResponseEditFolder.class) {
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

    public PeersStruct$ExPeer getUnreadPeers(int i) {
        return (PeersStruct$ExPeer) this.unreadPeers_.get(i);
    }

    public int getUnreadPeersCount() {
        return this.unreadPeers_.size();
    }

    public List<PeersStruct$ExPeer> getUnreadPeersList() {
        return this.unreadPeers_;
    }

    public InterfaceC9494a35 getUnreadPeersOrBuilder(int i) {
        return (InterfaceC9494a35) this.unreadPeers_.get(i);
    }

    public List<? extends InterfaceC9494a35> getUnreadPeersOrBuilderList() {
        return this.unreadPeers_;
    }

    public static a newBuilder(MessagingOuterClass$ResponseEditFolder messagingOuterClass$ResponseEditFolder) {
        return (a) DEFAULT_INSTANCE.createBuilder(messagingOuterClass$ResponseEditFolder);
    }

    public static MessagingOuterClass$ResponseEditFolder parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingOuterClass$ResponseEditFolder) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingOuterClass$ResponseEditFolder parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingOuterClass$ResponseEditFolder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingOuterClass$ResponseEditFolder parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingOuterClass$ResponseEditFolder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addUnreadPeers(int i, PeersStruct$ExPeer peersStruct$ExPeer) {
        peersStruct$ExPeer.getClass();
        ensureUnreadPeersIsMutable();
        this.unreadPeers_.add(i, peersStruct$ExPeer);
    }

    public static MessagingOuterClass$ResponseEditFolder parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingOuterClass$ResponseEditFolder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingOuterClass$ResponseEditFolder parseFrom(byte[] bArr) {
        return (MessagingOuterClass$ResponseEditFolder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingOuterClass$ResponseEditFolder parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingOuterClass$ResponseEditFolder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MessagingOuterClass$ResponseEditFolder parseFrom(InputStream inputStream) {
        return (MessagingOuterClass$ResponseEditFolder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingOuterClass$ResponseEditFolder parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingOuterClass$ResponseEditFolder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingOuterClass$ResponseEditFolder parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingOuterClass$ResponseEditFolder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingOuterClass$ResponseEditFolder parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingOuterClass$ResponseEditFolder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
