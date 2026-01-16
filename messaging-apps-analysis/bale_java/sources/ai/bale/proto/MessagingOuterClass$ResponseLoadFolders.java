package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC4190Eb4;
import ir.nasim.InterfaceC7071Qd4;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class MessagingOuterClass$ResponseLoadFolders extends GeneratedMessageLite implements U64 {
    private static final MessagingOuterClass$ResponseLoadFolders DEFAULT_INSTANCE;
    public static final int FOLDERS_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int UNREAD_PEERS_FIELD_NUMBER = 2;
    private B.j folders_ = GeneratedMessageLite.emptyProtobufList();
    private B.j unreadPeers_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MessagingOuterClass$ResponseLoadFolders.DEFAULT_INSTANCE);
        }
    }

    static {
        MessagingOuterClass$ResponseLoadFolders messagingOuterClass$ResponseLoadFolders = new MessagingOuterClass$ResponseLoadFolders();
        DEFAULT_INSTANCE = messagingOuterClass$ResponseLoadFolders;
        GeneratedMessageLite.registerDefaultInstance(MessagingOuterClass$ResponseLoadFolders.class, messagingOuterClass$ResponseLoadFolders);
    }

    private MessagingOuterClass$ResponseLoadFolders() {
    }

    private void addAllFolders(Iterable<? extends MessagingStruct$Folder> iterable) {
        ensureFoldersIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.folders_);
    }

    private void addAllUnreadPeers(Iterable<? extends MessagingStruct$UnreadPeer> iterable) {
        ensureUnreadPeersIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.unreadPeers_);
    }

    private void addFolders(MessagingStruct$Folder messagingStruct$Folder) {
        messagingStruct$Folder.getClass();
        ensureFoldersIsMutable();
        this.folders_.add(messagingStruct$Folder);
    }

    private void addUnreadPeers(MessagingStruct$UnreadPeer messagingStruct$UnreadPeer) {
        messagingStruct$UnreadPeer.getClass();
        ensureUnreadPeersIsMutable();
        this.unreadPeers_.add(messagingStruct$UnreadPeer);
    }

    private void clearFolders() {
        this.folders_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearUnreadPeers() {
        this.unreadPeers_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureFoldersIsMutable() {
        B.j jVar = this.folders_;
        if (jVar.u()) {
            return;
        }
        this.folders_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    private void ensureUnreadPeersIsMutable() {
        B.j jVar = this.unreadPeers_;
        if (jVar.u()) {
            return;
        }
        this.unreadPeers_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static MessagingOuterClass$ResponseLoadFolders getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MessagingOuterClass$ResponseLoadFolders parseDelimitedFrom(InputStream inputStream) {
        return (MessagingOuterClass$ResponseLoadFolders) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingOuterClass$ResponseLoadFolders parseFrom(ByteBuffer byteBuffer) {
        return (MessagingOuterClass$ResponseLoadFolders) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeFolders(int i) {
        ensureFoldersIsMutable();
        this.folders_.remove(i);
    }

    private void removeUnreadPeers(int i) {
        ensureUnreadPeersIsMutable();
        this.unreadPeers_.remove(i);
    }

    private void setFolders(int i, MessagingStruct$Folder messagingStruct$Folder) {
        messagingStruct$Folder.getClass();
        ensureFoldersIsMutable();
        this.folders_.set(i, messagingStruct$Folder);
    }

    private void setUnreadPeers(int i, MessagingStruct$UnreadPeer messagingStruct$UnreadPeer) {
        messagingStruct$UnreadPeer.getClass();
        ensureUnreadPeersIsMutable();
        this.unreadPeers_.set(i, messagingStruct$UnreadPeer);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (K0.a[gVar.ordinal()]) {
            case 1:
                return new MessagingOuterClass$ResponseLoadFolders();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0002\u0000\u0001\u001b\u0002\u001b", new Object[]{"folders_", MessagingStruct$Folder.class, "unreadPeers_", MessagingStruct$UnreadPeer.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingOuterClass$ResponseLoadFolders.class) {
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

    public MessagingStruct$Folder getFolders(int i) {
        return (MessagingStruct$Folder) this.folders_.get(i);
    }

    public int getFoldersCount() {
        return this.folders_.size();
    }

    public List<MessagingStruct$Folder> getFoldersList() {
        return this.folders_;
    }

    public InterfaceC4190Eb4 getFoldersOrBuilder(int i) {
        return (InterfaceC4190Eb4) this.folders_.get(i);
    }

    public List<? extends InterfaceC4190Eb4> getFoldersOrBuilderList() {
        return this.folders_;
    }

    public MessagingStruct$UnreadPeer getUnreadPeers(int i) {
        return (MessagingStruct$UnreadPeer) this.unreadPeers_.get(i);
    }

    public int getUnreadPeersCount() {
        return this.unreadPeers_.size();
    }

    public List<MessagingStruct$UnreadPeer> getUnreadPeersList() {
        return this.unreadPeers_;
    }

    public InterfaceC7071Qd4 getUnreadPeersOrBuilder(int i) {
        return (InterfaceC7071Qd4) this.unreadPeers_.get(i);
    }

    public List<? extends InterfaceC7071Qd4> getUnreadPeersOrBuilderList() {
        return this.unreadPeers_;
    }

    public static a newBuilder(MessagingOuterClass$ResponseLoadFolders messagingOuterClass$ResponseLoadFolders) {
        return (a) DEFAULT_INSTANCE.createBuilder(messagingOuterClass$ResponseLoadFolders);
    }

    public static MessagingOuterClass$ResponseLoadFolders parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingOuterClass$ResponseLoadFolders) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingOuterClass$ResponseLoadFolders parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingOuterClass$ResponseLoadFolders) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingOuterClass$ResponseLoadFolders parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingOuterClass$ResponseLoadFolders) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addFolders(int i, MessagingStruct$Folder messagingStruct$Folder) {
        messagingStruct$Folder.getClass();
        ensureFoldersIsMutable();
        this.folders_.add(i, messagingStruct$Folder);
    }

    private void addUnreadPeers(int i, MessagingStruct$UnreadPeer messagingStruct$UnreadPeer) {
        messagingStruct$UnreadPeer.getClass();
        ensureUnreadPeersIsMutable();
        this.unreadPeers_.add(i, messagingStruct$UnreadPeer);
    }

    public static MessagingOuterClass$ResponseLoadFolders parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingOuterClass$ResponseLoadFolders) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingOuterClass$ResponseLoadFolders parseFrom(byte[] bArr) {
        return (MessagingOuterClass$ResponseLoadFolders) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingOuterClass$ResponseLoadFolders parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingOuterClass$ResponseLoadFolders) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MessagingOuterClass$ResponseLoadFolders parseFrom(InputStream inputStream) {
        return (MessagingOuterClass$ResponseLoadFolders) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingOuterClass$ResponseLoadFolders parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingOuterClass$ResponseLoadFolders) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingOuterClass$ResponseLoadFolders parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingOuterClass$ResponseLoadFolders) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingOuterClass$ResponseLoadFolders parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingOuterClass$ResponseLoadFolders) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
