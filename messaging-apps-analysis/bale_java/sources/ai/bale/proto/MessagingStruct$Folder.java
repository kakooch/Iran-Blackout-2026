package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC4190Eb4;
import ir.nasim.InterfaceC9494a35;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class MessagingStruct$Folder extends GeneratedMessageLite implements InterfaceC4190Eb4 {
    private static final MessagingStruct$Folder DEFAULT_INSTANCE;
    public static final int ID_FIELD_NUMBER = 1;
    public static final int IS_RESERVED_FIELD_NUMBER = 5;
    public static final int NAME_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int PEERS_FIELD_NUMBER = 3;
    public static final int UNREAD_PEERS_FIELD_NUMBER = 4;
    private int id_;
    private boolean isReserved_;
    private String name_ = "";
    private B.j peers_ = GeneratedMessageLite.emptyProtobufList();
    private B.j unreadPeers_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements InterfaceC4190Eb4 {
        private a() {
            super(MessagingStruct$Folder.DEFAULT_INSTANCE);
        }
    }

    static {
        MessagingStruct$Folder messagingStruct$Folder = new MessagingStruct$Folder();
        DEFAULT_INSTANCE = messagingStruct$Folder;
        GeneratedMessageLite.registerDefaultInstance(MessagingStruct$Folder.class, messagingStruct$Folder);
    }

    private MessagingStruct$Folder() {
    }

    private void addAllPeers(Iterable<? extends PeersStruct$ExPeer> iterable) {
        ensurePeersIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.peers_);
    }

    private void addAllUnreadPeers(Iterable<? extends PeersStruct$ExPeer> iterable) {
        ensureUnreadPeersIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.unreadPeers_);
    }

    private void addPeers(int i, PeersStruct$ExPeer peersStruct$ExPeer) {
        peersStruct$ExPeer.getClass();
        ensurePeersIsMutable();
        this.peers_.add(i, peersStruct$ExPeer);
    }

    private void addUnreadPeers(int i, PeersStruct$ExPeer peersStruct$ExPeer) {
        peersStruct$ExPeer.getClass();
        ensureUnreadPeersIsMutable();
        this.unreadPeers_.add(i, peersStruct$ExPeer);
    }

    private void clearId() {
        this.id_ = 0;
    }

    private void clearIsReserved() {
        this.isReserved_ = false;
    }

    private void clearName() {
        this.name_ = getDefaultInstance().getName();
    }

    private void clearPeers() {
        this.peers_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearUnreadPeers() {
        this.unreadPeers_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensurePeersIsMutable() {
        B.j jVar = this.peers_;
        if (jVar.u()) {
            return;
        }
        this.peers_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    private void ensureUnreadPeersIsMutable() {
        B.j jVar = this.unreadPeers_;
        if (jVar.u()) {
            return;
        }
        this.unreadPeers_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static MessagingStruct$Folder getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MessagingStruct$Folder parseDelimitedFrom(InputStream inputStream) {
        return (MessagingStruct$Folder) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$Folder parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingStruct$Folder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removePeers(int i) {
        ensurePeersIsMutable();
        this.peers_.remove(i);
    }

    private void removeUnreadPeers(int i) {
        ensureUnreadPeersIsMutable();
        this.unreadPeers_.remove(i);
    }

    private void setId(int i) {
        this.id_ = i;
    }

    private void setIsReserved(boolean z) {
        this.isReserved_ = z;
    }

    private void setName(String str) {
        str.getClass();
        this.name_ = str;
    }

    private void setNameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.name_ = abstractC2383g.f0();
    }

    private void setPeers(int i, PeersStruct$ExPeer peersStruct$ExPeer) {
        peersStruct$ExPeer.getClass();
        ensurePeersIsMutable();
        this.peers_.set(i, peersStruct$ExPeer);
    }

    private void setUnreadPeers(int i, PeersStruct$ExPeer peersStruct$ExPeer) {
        peersStruct$ExPeer.getClass();
        ensureUnreadPeersIsMutable();
        this.unreadPeers_.set(i, peersStruct$ExPeer);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (L0.a[gVar.ordinal()]) {
            case 1:
                return new MessagingStruct$Folder();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0002\u0000\u0001\u0004\u0002Ȉ\u0003\u001b\u0004\u001b\u0005\u0007", new Object[]{"id_", "name_", "peers_", PeersStruct$ExPeer.class, "unreadPeers_", PeersStruct$ExPeer.class, "isReserved_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingStruct$Folder.class) {
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

    public int getId() {
        return this.id_;
    }

    public boolean getIsReserved() {
        return this.isReserved_;
    }

    public String getName() {
        return this.name_;
    }

    public AbstractC2383g getNameBytes() {
        return AbstractC2383g.N(this.name_);
    }

    public PeersStruct$ExPeer getPeers(int i) {
        return (PeersStruct$ExPeer) this.peers_.get(i);
    }

    public int getPeersCount() {
        return this.peers_.size();
    }

    public List<PeersStruct$ExPeer> getPeersList() {
        return this.peers_;
    }

    public InterfaceC9494a35 getPeersOrBuilder(int i) {
        return (InterfaceC9494a35) this.peers_.get(i);
    }

    public List<? extends InterfaceC9494a35> getPeersOrBuilderList() {
        return this.peers_;
    }

    @Deprecated
    public PeersStruct$ExPeer getUnreadPeers(int i) {
        return (PeersStruct$ExPeer) this.unreadPeers_.get(i);
    }

    @Deprecated
    public int getUnreadPeersCount() {
        return this.unreadPeers_.size();
    }

    @Deprecated
    public List<PeersStruct$ExPeer> getUnreadPeersList() {
        return this.unreadPeers_;
    }

    @Deprecated
    public InterfaceC9494a35 getUnreadPeersOrBuilder(int i) {
        return (InterfaceC9494a35) this.unreadPeers_.get(i);
    }

    @Deprecated
    public List<? extends InterfaceC9494a35> getUnreadPeersOrBuilderList() {
        return this.unreadPeers_;
    }

    private void addPeers(PeersStruct$ExPeer peersStruct$ExPeer) {
        peersStruct$ExPeer.getClass();
        ensurePeersIsMutable();
        this.peers_.add(peersStruct$ExPeer);
    }

    private void addUnreadPeers(PeersStruct$ExPeer peersStruct$ExPeer) {
        peersStruct$ExPeer.getClass();
        ensureUnreadPeersIsMutable();
        this.unreadPeers_.add(peersStruct$ExPeer);
    }

    public static a newBuilder(MessagingStruct$Folder messagingStruct$Folder) {
        return (a) DEFAULT_INSTANCE.createBuilder(messagingStruct$Folder);
    }

    public static MessagingStruct$Folder parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$Folder) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$Folder parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingStruct$Folder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingStruct$Folder parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingStruct$Folder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingStruct$Folder parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingStruct$Folder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }

    public static MessagingStruct$Folder parseFrom(InputStream inputStream) {
        return (MessagingStruct$Folder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$Folder parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$Folder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$Folder parseFrom(ByteBuffer byteBuffer) {
        return (MessagingStruct$Folder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static MessagingStruct$Folder parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingStruct$Folder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingStruct$Folder parseFrom(byte[] bArr) {
        return (MessagingStruct$Folder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingStruct$Folder parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingStruct$Folder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }
}
