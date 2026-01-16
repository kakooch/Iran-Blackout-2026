package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.StringValue;
import ir.nasim.InterfaceC9494a35;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class MessagingOuterClass$UpdateFolderEdited extends GeneratedMessageLite implements U64 {
    public static final int ADDED_PEERS_FIELD_NUMBER = 3;
    private static final MessagingOuterClass$UpdateFolderEdited DEFAULT_INSTANCE;
    public static final int DELETED_PEERS_FIELD_NUMBER = 4;
    public static final int FOLDER_ID_FIELD_NUMBER = 1;
    public static final int NEW_NAME_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int UNREAD_PEERS_FIELD_NUMBER = 5;
    private int bitField0_;
    private int folderId_;
    private StringValue newName_;
    private B.j addedPeers_ = GeneratedMessageLite.emptyProtobufList();
    private B.j deletedPeers_ = GeneratedMessageLite.emptyProtobufList();
    private B.j unreadPeers_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MessagingOuterClass$UpdateFolderEdited.DEFAULT_INSTANCE);
        }
    }

    static {
        MessagingOuterClass$UpdateFolderEdited messagingOuterClass$UpdateFolderEdited = new MessagingOuterClass$UpdateFolderEdited();
        DEFAULT_INSTANCE = messagingOuterClass$UpdateFolderEdited;
        GeneratedMessageLite.registerDefaultInstance(MessagingOuterClass$UpdateFolderEdited.class, messagingOuterClass$UpdateFolderEdited);
    }

    private MessagingOuterClass$UpdateFolderEdited() {
    }

    private void addAddedPeers(PeersStruct$ExPeer peersStruct$ExPeer) {
        peersStruct$ExPeer.getClass();
        ensureAddedPeersIsMutable();
        this.addedPeers_.add(peersStruct$ExPeer);
    }

    private void addAllAddedPeers(Iterable<? extends PeersStruct$ExPeer> iterable) {
        ensureAddedPeersIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.addedPeers_);
    }

    private void addAllDeletedPeers(Iterable<? extends PeersStruct$ExPeer> iterable) {
        ensureDeletedPeersIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.deletedPeers_);
    }

    private void addAllUnreadPeers(Iterable<? extends PeersStruct$ExPeer> iterable) {
        ensureUnreadPeersIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.unreadPeers_);
    }

    private void addDeletedPeers(PeersStruct$ExPeer peersStruct$ExPeer) {
        peersStruct$ExPeer.getClass();
        ensureDeletedPeersIsMutable();
        this.deletedPeers_.add(peersStruct$ExPeer);
    }

    private void addUnreadPeers(PeersStruct$ExPeer peersStruct$ExPeer) {
        peersStruct$ExPeer.getClass();
        ensureUnreadPeersIsMutable();
        this.unreadPeers_.add(peersStruct$ExPeer);
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

    private void clearNewName() {
        this.newName_ = null;
        this.bitField0_ &= -2;
    }

    private void clearUnreadPeers() {
        this.unreadPeers_ = GeneratedMessageLite.emptyProtobufList();
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

    private void ensureUnreadPeersIsMutable() {
        B.j jVar = this.unreadPeers_;
        if (jVar.u()) {
            return;
        }
        this.unreadPeers_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static MessagingOuterClass$UpdateFolderEdited getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeNewName(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.newName_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.newName_ = stringValue;
        } else {
            this.newName_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.newName_).v(stringValue)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MessagingOuterClass$UpdateFolderEdited parseDelimitedFrom(InputStream inputStream) {
        return (MessagingOuterClass$UpdateFolderEdited) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingOuterClass$UpdateFolderEdited parseFrom(ByteBuffer byteBuffer) {
        return (MessagingOuterClass$UpdateFolderEdited) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
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

    private void removeUnreadPeers(int i) {
        ensureUnreadPeersIsMutable();
        this.unreadPeers_.remove(i);
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

    private void setFolderId(int i) {
        this.folderId_ = i;
    }

    private void setNewName(StringValue stringValue) {
        stringValue.getClass();
        this.newName_ = stringValue;
        this.bitField0_ |= 1;
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
                return new MessagingOuterClass$UpdateFolderEdited();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0003\u0000\u0001\u0004\u0002ဉ\u0000\u0003\u001b\u0004\u001b\u0005\u001b", new Object[]{"bitField0_", "folderId_", "newName_", "addedPeers_", PeersStruct$ExPeer.class, "deletedPeers_", PeersStruct$ExPeer.class, "unreadPeers_", PeersStruct$ExPeer.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingOuterClass$UpdateFolderEdited.class) {
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

    public StringValue getNewName() {
        StringValue stringValue = this.newName_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
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

    public boolean hasNewName() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(MessagingOuterClass$UpdateFolderEdited messagingOuterClass$UpdateFolderEdited) {
        return (a) DEFAULT_INSTANCE.createBuilder(messagingOuterClass$UpdateFolderEdited);
    }

    public static MessagingOuterClass$UpdateFolderEdited parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingOuterClass$UpdateFolderEdited) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingOuterClass$UpdateFolderEdited parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingOuterClass$UpdateFolderEdited) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingOuterClass$UpdateFolderEdited parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingOuterClass$UpdateFolderEdited) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
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

    private void addUnreadPeers(int i, PeersStruct$ExPeer peersStruct$ExPeer) {
        peersStruct$ExPeer.getClass();
        ensureUnreadPeersIsMutable();
        this.unreadPeers_.add(i, peersStruct$ExPeer);
    }

    public static MessagingOuterClass$UpdateFolderEdited parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingOuterClass$UpdateFolderEdited) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingOuterClass$UpdateFolderEdited parseFrom(byte[] bArr) {
        return (MessagingOuterClass$UpdateFolderEdited) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingOuterClass$UpdateFolderEdited parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingOuterClass$UpdateFolderEdited) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MessagingOuterClass$UpdateFolderEdited parseFrom(InputStream inputStream) {
        return (MessagingOuterClass$UpdateFolderEdited) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingOuterClass$UpdateFolderEdited parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingOuterClass$UpdateFolderEdited) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingOuterClass$UpdateFolderEdited parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingOuterClass$UpdateFolderEdited) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingOuterClass$UpdateFolderEdited parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingOuterClass$UpdateFolderEdited) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
