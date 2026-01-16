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
public final class MessagingOuterClass$UpdateDialogsUnpinned extends GeneratedMessageLite implements U64 {
    private static final MessagingOuterClass$UpdateDialogsUnpinned DEFAULT_INSTANCE;
    public static final int FOLDER_ID_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int UNPINNED_PEERS_FIELD_NUMBER = 3;
    private int folderId_;
    private B.j unpinnedPeers_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MessagingOuterClass$UpdateDialogsUnpinned.DEFAULT_INSTANCE);
        }
    }

    static {
        MessagingOuterClass$UpdateDialogsUnpinned messagingOuterClass$UpdateDialogsUnpinned = new MessagingOuterClass$UpdateDialogsUnpinned();
        DEFAULT_INSTANCE = messagingOuterClass$UpdateDialogsUnpinned;
        GeneratedMessageLite.registerDefaultInstance(MessagingOuterClass$UpdateDialogsUnpinned.class, messagingOuterClass$UpdateDialogsUnpinned);
    }

    private MessagingOuterClass$UpdateDialogsUnpinned() {
    }

    private void addAllUnpinnedPeers(Iterable<? extends PeersStruct$ExPeer> iterable) {
        ensureUnpinnedPeersIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.unpinnedPeers_);
    }

    private void addUnpinnedPeers(PeersStruct$ExPeer peersStruct$ExPeer) {
        peersStruct$ExPeer.getClass();
        ensureUnpinnedPeersIsMutable();
        this.unpinnedPeers_.add(peersStruct$ExPeer);
    }

    private void clearFolderId() {
        this.folderId_ = 0;
    }

    private void clearUnpinnedPeers() {
        this.unpinnedPeers_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureUnpinnedPeersIsMutable() {
        B.j jVar = this.unpinnedPeers_;
        if (jVar.u()) {
            return;
        }
        this.unpinnedPeers_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static MessagingOuterClass$UpdateDialogsUnpinned getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MessagingOuterClass$UpdateDialogsUnpinned parseDelimitedFrom(InputStream inputStream) {
        return (MessagingOuterClass$UpdateDialogsUnpinned) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingOuterClass$UpdateDialogsUnpinned parseFrom(ByteBuffer byteBuffer) {
        return (MessagingOuterClass$UpdateDialogsUnpinned) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeUnpinnedPeers(int i) {
        ensureUnpinnedPeersIsMutable();
        this.unpinnedPeers_.remove(i);
    }

    private void setFolderId(int i) {
        this.folderId_ = i;
    }

    private void setUnpinnedPeers(int i, PeersStruct$ExPeer peersStruct$ExPeer) {
        peersStruct$ExPeer.getClass();
        ensureUnpinnedPeersIsMutable();
        this.unpinnedPeers_.set(i, peersStruct$ExPeer);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (K0.a[gVar.ordinal()]) {
            case 1:
                return new MessagingOuterClass$UpdateDialogsUnpinned();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0003\u0002\u0000\u0001\u0000\u0001\u0004\u0003\u001b", new Object[]{"folderId_", "unpinnedPeers_", PeersStruct$ExPeer.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingOuterClass$UpdateDialogsUnpinned.class) {
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

    public int getFolderId() {
        return this.folderId_;
    }

    public PeersStruct$ExPeer getUnpinnedPeers(int i) {
        return (PeersStruct$ExPeer) this.unpinnedPeers_.get(i);
    }

    public int getUnpinnedPeersCount() {
        return this.unpinnedPeers_.size();
    }

    public List<PeersStruct$ExPeer> getUnpinnedPeersList() {
        return this.unpinnedPeers_;
    }

    public InterfaceC9494a35 getUnpinnedPeersOrBuilder(int i) {
        return (InterfaceC9494a35) this.unpinnedPeers_.get(i);
    }

    public List<? extends InterfaceC9494a35> getUnpinnedPeersOrBuilderList() {
        return this.unpinnedPeers_;
    }

    public static a newBuilder(MessagingOuterClass$UpdateDialogsUnpinned messagingOuterClass$UpdateDialogsUnpinned) {
        return (a) DEFAULT_INSTANCE.createBuilder(messagingOuterClass$UpdateDialogsUnpinned);
    }

    public static MessagingOuterClass$UpdateDialogsUnpinned parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingOuterClass$UpdateDialogsUnpinned) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingOuterClass$UpdateDialogsUnpinned parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingOuterClass$UpdateDialogsUnpinned) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingOuterClass$UpdateDialogsUnpinned parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingOuterClass$UpdateDialogsUnpinned) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addUnpinnedPeers(int i, PeersStruct$ExPeer peersStruct$ExPeer) {
        peersStruct$ExPeer.getClass();
        ensureUnpinnedPeersIsMutable();
        this.unpinnedPeers_.add(i, peersStruct$ExPeer);
    }

    public static MessagingOuterClass$UpdateDialogsUnpinned parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingOuterClass$UpdateDialogsUnpinned) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingOuterClass$UpdateDialogsUnpinned parseFrom(byte[] bArr) {
        return (MessagingOuterClass$UpdateDialogsUnpinned) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingOuterClass$UpdateDialogsUnpinned parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingOuterClass$UpdateDialogsUnpinned) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MessagingOuterClass$UpdateDialogsUnpinned parseFrom(InputStream inputStream) {
        return (MessagingOuterClass$UpdateDialogsUnpinned) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingOuterClass$UpdateDialogsUnpinned parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingOuterClass$UpdateDialogsUnpinned) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingOuterClass$UpdateDialogsUnpinned parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingOuterClass$UpdateDialogsUnpinned) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingOuterClass$UpdateDialogsUnpinned parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingOuterClass$UpdateDialogsUnpinned) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
