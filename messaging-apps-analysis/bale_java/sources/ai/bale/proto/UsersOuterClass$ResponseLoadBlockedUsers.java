package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC18084o35;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes.dex */
public final class UsersOuterClass$ResponseLoadBlockedUsers extends GeneratedMessageLite implements U64 {
    private static final UsersOuterClass$ResponseLoadBlockedUsers DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int USER_PEERS_FIELD_NUMBER = 1;
    private B.j userPeers_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(UsersOuterClass$ResponseLoadBlockedUsers.DEFAULT_INSTANCE);
        }
    }

    static {
        UsersOuterClass$ResponseLoadBlockedUsers usersOuterClass$ResponseLoadBlockedUsers = new UsersOuterClass$ResponseLoadBlockedUsers();
        DEFAULT_INSTANCE = usersOuterClass$ResponseLoadBlockedUsers;
        GeneratedMessageLite.registerDefaultInstance(UsersOuterClass$ResponseLoadBlockedUsers.class, usersOuterClass$ResponseLoadBlockedUsers);
    }

    private UsersOuterClass$ResponseLoadBlockedUsers() {
    }

    private void addAllUserPeers(Iterable<? extends PeersStruct$UserOutPeer> iterable) {
        ensureUserPeersIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.userPeers_);
    }

    private void addUserPeers(PeersStruct$UserOutPeer peersStruct$UserOutPeer) {
        peersStruct$UserOutPeer.getClass();
        ensureUserPeersIsMutable();
        this.userPeers_.add(peersStruct$UserOutPeer);
    }

    private void clearUserPeers() {
        this.userPeers_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureUserPeersIsMutable() {
        B.j jVar = this.userPeers_;
        if (jVar.u()) {
            return;
        }
        this.userPeers_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static UsersOuterClass$ResponseLoadBlockedUsers getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static UsersOuterClass$ResponseLoadBlockedUsers parseDelimitedFrom(InputStream inputStream) {
        return (UsersOuterClass$ResponseLoadBlockedUsers) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UsersOuterClass$ResponseLoadBlockedUsers parseFrom(ByteBuffer byteBuffer) {
        return (UsersOuterClass$ResponseLoadBlockedUsers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeUserPeers(int i) {
        ensureUserPeersIsMutable();
        this.userPeers_.remove(i);
    }

    private void setUserPeers(int i, PeersStruct$UserOutPeer peersStruct$UserOutPeer) {
        peersStruct$UserOutPeer.getClass();
        ensureUserPeersIsMutable();
        this.userPeers_.set(i, peersStruct$UserOutPeer);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (p2.a[gVar.ordinal()]) {
            case 1:
                return new UsersOuterClass$ResponseLoadBlockedUsers();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"userPeers_", PeersStruct$UserOutPeer.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (UsersOuterClass$ResponseLoadBlockedUsers.class) {
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

    public PeersStruct$UserOutPeer getUserPeers(int i) {
        return (PeersStruct$UserOutPeer) this.userPeers_.get(i);
    }

    public int getUserPeersCount() {
        return this.userPeers_.size();
    }

    public List<PeersStruct$UserOutPeer> getUserPeersList() {
        return this.userPeers_;
    }

    public InterfaceC18084o35 getUserPeersOrBuilder(int i) {
        return (InterfaceC18084o35) this.userPeers_.get(i);
    }

    public List<? extends InterfaceC18084o35> getUserPeersOrBuilderList() {
        return this.userPeers_;
    }

    public static a newBuilder(UsersOuterClass$ResponseLoadBlockedUsers usersOuterClass$ResponseLoadBlockedUsers) {
        return (a) DEFAULT_INSTANCE.createBuilder(usersOuterClass$ResponseLoadBlockedUsers);
    }

    public static UsersOuterClass$ResponseLoadBlockedUsers parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (UsersOuterClass$ResponseLoadBlockedUsers) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static UsersOuterClass$ResponseLoadBlockedUsers parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (UsersOuterClass$ResponseLoadBlockedUsers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static UsersOuterClass$ResponseLoadBlockedUsers parseFrom(AbstractC2383g abstractC2383g) {
        return (UsersOuterClass$ResponseLoadBlockedUsers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addUserPeers(int i, PeersStruct$UserOutPeer peersStruct$UserOutPeer) {
        peersStruct$UserOutPeer.getClass();
        ensureUserPeersIsMutable();
        this.userPeers_.add(i, peersStruct$UserOutPeer);
    }

    public static UsersOuterClass$ResponseLoadBlockedUsers parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (UsersOuterClass$ResponseLoadBlockedUsers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static UsersOuterClass$ResponseLoadBlockedUsers parseFrom(byte[] bArr) {
        return (UsersOuterClass$ResponseLoadBlockedUsers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static UsersOuterClass$ResponseLoadBlockedUsers parseFrom(byte[] bArr, C2394s c2394s) {
        return (UsersOuterClass$ResponseLoadBlockedUsers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static UsersOuterClass$ResponseLoadBlockedUsers parseFrom(InputStream inputStream) {
        return (UsersOuterClass$ResponseLoadBlockedUsers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UsersOuterClass$ResponseLoadBlockedUsers parseFrom(InputStream inputStream, C2394s c2394s) {
        return (UsersOuterClass$ResponseLoadBlockedUsers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static UsersOuterClass$ResponseLoadBlockedUsers parseFrom(AbstractC2384h abstractC2384h) {
        return (UsersOuterClass$ResponseLoadBlockedUsers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static UsersOuterClass$ResponseLoadBlockedUsers parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (UsersOuterClass$ResponseLoadBlockedUsers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
