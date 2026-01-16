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
public final class MessagingOuterClass$RequestEditFolder extends GeneratedMessageLite implements U64 {
    public static final int ADDED_PEERS_FIELD_NUMBER = 3;
    private static final MessagingOuterClass$RequestEditFolder DEFAULT_INSTANCE;
    public static final int DELETED_PEERS_FIELD_NUMBER = 4;
    public static final int FOLDER_ID_FIELD_NUMBER = 1;
    public static final int NAME_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER;
    private int folderId_;
    private String name_ = "";
    private B.j addedPeers_ = GeneratedMessageLite.emptyProtobufList();
    private B.j deletedPeers_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(Iterable iterable) {
            q();
            ((MessagingOuterClass$RequestEditFolder) this.b).addAllAddedPeers(iterable);
            return this;
        }

        public a B(Iterable iterable) {
            q();
            ((MessagingOuterClass$RequestEditFolder) this.b).addAllDeletedPeers(iterable);
            return this;
        }

        public a C(int i) {
            q();
            ((MessagingOuterClass$RequestEditFolder) this.b).setFolderId(i);
            return this;
        }

        public a D(String str) {
            q();
            ((MessagingOuterClass$RequestEditFolder) this.b).setName(str);
            return this;
        }

        private a() {
            super(MessagingOuterClass$RequestEditFolder.DEFAULT_INSTANCE);
        }
    }

    static {
        MessagingOuterClass$RequestEditFolder messagingOuterClass$RequestEditFolder = new MessagingOuterClass$RequestEditFolder();
        DEFAULT_INSTANCE = messagingOuterClass$RequestEditFolder;
        GeneratedMessageLite.registerDefaultInstance(MessagingOuterClass$RequestEditFolder.class, messagingOuterClass$RequestEditFolder);
    }

    private MessagingOuterClass$RequestEditFolder() {
    }

    private void addAddedPeers(PeersStruct$ExPeer peersStruct$ExPeer) {
        peersStruct$ExPeer.getClass();
        ensureAddedPeersIsMutable();
        this.addedPeers_.add(peersStruct$ExPeer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllAddedPeers(Iterable<? extends PeersStruct$ExPeer> iterable) {
        ensureAddedPeersIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.addedPeers_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllDeletedPeers(Iterable<? extends PeersStruct$ExPeer> iterable) {
        ensureDeletedPeersIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.deletedPeers_);
    }

    private void addDeletedPeers(PeersStruct$ExPeer peersStruct$ExPeer) {
        peersStruct$ExPeer.getClass();
        ensureDeletedPeersIsMutable();
        this.deletedPeers_.add(peersStruct$ExPeer);
    }

    private void clearAddedPeers() {
        this.addedPeers_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearDeletedPeers() {
        this.deletedPeers_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearFolderId() {
        this.folderId_ = 0;
    }

    private void clearName() {
        this.name_ = getDefaultInstance().getName();
    }

    private void ensureAddedPeersIsMutable() {
        B.j jVar = this.addedPeers_;
        if (jVar.u()) {
            return;
        }
        this.addedPeers_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    private void ensureDeletedPeersIsMutable() {
        B.j jVar = this.deletedPeers_;
        if (jVar.u()) {
            return;
        }
        this.deletedPeers_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static MessagingOuterClass$RequestEditFolder getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MessagingOuterClass$RequestEditFolder parseDelimitedFrom(InputStream inputStream) {
        return (MessagingOuterClass$RequestEditFolder) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingOuterClass$RequestEditFolder parseFrom(ByteBuffer byteBuffer) {
        return (MessagingOuterClass$RequestEditFolder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeAddedPeers(int i) {
        ensureAddedPeersIsMutable();
        this.addedPeers_.remove(i);
    }

    private void removeDeletedPeers(int i) {
        ensureDeletedPeersIsMutable();
        this.deletedPeers_.remove(i);
    }

    private void setAddedPeers(int i, PeersStruct$ExPeer peersStruct$ExPeer) {
        peersStruct$ExPeer.getClass();
        ensureAddedPeersIsMutable();
        this.addedPeers_.set(i, peersStruct$ExPeer);
    }

    private void setDeletedPeers(int i, PeersStruct$ExPeer peersStruct$ExPeer) {
        peersStruct$ExPeer.getClass();
        ensureDeletedPeersIsMutable();
        this.deletedPeers_.set(i, peersStruct$ExPeer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFolderId(int i) {
        this.folderId_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setName(String str) {
        str.getClass();
        this.name_ = str;
    }

    private void setNameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.name_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (K0.a[gVar.ordinal()]) {
            case 1:
                return new MessagingOuterClass$RequestEditFolder();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0002\u0000\u0001\u0004\u0002Ȉ\u0003\u001b\u0004\u001b", new Object[]{"folderId_", "name_", "addedPeers_", PeersStruct$ExPeer.class, "deletedPeers_", PeersStruct$ExPeer.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingOuterClass$RequestEditFolder.class) {
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

    public PeersStruct$ExPeer getAddedPeers(int i) {
        return (PeersStruct$ExPeer) this.addedPeers_.get(i);
    }

    public int getAddedPeersCount() {
        return this.addedPeers_.size();
    }

    public List<PeersStruct$ExPeer> getAddedPeersList() {
        return this.addedPeers_;
    }

    public InterfaceC9494a35 getAddedPeersOrBuilder(int i) {
        return (InterfaceC9494a35) this.addedPeers_.get(i);
    }

    public List<? extends InterfaceC9494a35> getAddedPeersOrBuilderList() {
        return this.addedPeers_;
    }

    public PeersStruct$ExPeer getDeletedPeers(int i) {
        return (PeersStruct$ExPeer) this.deletedPeers_.get(i);
    }

    public int getDeletedPeersCount() {
        return this.deletedPeers_.size();
    }

    public List<PeersStruct$ExPeer> getDeletedPeersList() {
        return this.deletedPeers_;
    }

    public InterfaceC9494a35 getDeletedPeersOrBuilder(int i) {
        return (InterfaceC9494a35) this.deletedPeers_.get(i);
    }

    public List<? extends InterfaceC9494a35> getDeletedPeersOrBuilderList() {
        return this.deletedPeers_;
    }

    public int getFolderId() {
        return this.folderId_;
    }

    public String getName() {
        return this.name_;
    }

    public AbstractC2383g getNameBytes() {
        return AbstractC2383g.N(this.name_);
    }

    public static a newBuilder(MessagingOuterClass$RequestEditFolder messagingOuterClass$RequestEditFolder) {
        return (a) DEFAULT_INSTANCE.createBuilder(messagingOuterClass$RequestEditFolder);
    }

    public static MessagingOuterClass$RequestEditFolder parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingOuterClass$RequestEditFolder) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingOuterClass$RequestEditFolder parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingOuterClass$RequestEditFolder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingOuterClass$RequestEditFolder parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingOuterClass$RequestEditFolder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addAddedPeers(int i, PeersStruct$ExPeer peersStruct$ExPeer) {
        peersStruct$ExPeer.getClass();
        ensureAddedPeersIsMutable();
        this.addedPeers_.add(i, peersStruct$ExPeer);
    }

    private void addDeletedPeers(int i, PeersStruct$ExPeer peersStruct$ExPeer) {
        peersStruct$ExPeer.getClass();
        ensureDeletedPeersIsMutable();
        this.deletedPeers_.add(i, peersStruct$ExPeer);
    }

    public static MessagingOuterClass$RequestEditFolder parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingOuterClass$RequestEditFolder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingOuterClass$RequestEditFolder parseFrom(byte[] bArr) {
        return (MessagingOuterClass$RequestEditFolder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingOuterClass$RequestEditFolder parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingOuterClass$RequestEditFolder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MessagingOuterClass$RequestEditFolder parseFrom(InputStream inputStream) {
        return (MessagingOuterClass$RequestEditFolder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingOuterClass$RequestEditFolder parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingOuterClass$RequestEditFolder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingOuterClass$RequestEditFolder parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingOuterClass$RequestEditFolder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingOuterClass$RequestEditFolder parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingOuterClass$RequestEditFolder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
