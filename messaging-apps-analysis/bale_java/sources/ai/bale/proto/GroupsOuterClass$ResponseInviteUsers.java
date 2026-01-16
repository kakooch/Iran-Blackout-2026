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

/* loaded from: classes9.dex */
public final class GroupsOuterClass$ResponseInviteUsers extends GeneratedMessageLite implements U64 {
    private static final GroupsOuterClass$ResponseInviteUsers DEFAULT_INSTANCE;
    public static final int NOT_ADDED_USER_PEERS_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private B.j notAddedUserPeers_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(GroupsOuterClass$ResponseInviteUsers.DEFAULT_INSTANCE);
        }
    }

    static {
        GroupsOuterClass$ResponseInviteUsers groupsOuterClass$ResponseInviteUsers = new GroupsOuterClass$ResponseInviteUsers();
        DEFAULT_INSTANCE = groupsOuterClass$ResponseInviteUsers;
        GeneratedMessageLite.registerDefaultInstance(GroupsOuterClass$ResponseInviteUsers.class, groupsOuterClass$ResponseInviteUsers);
    }

    private GroupsOuterClass$ResponseInviteUsers() {
    }

    private void addAllNotAddedUserPeers(Iterable<? extends PeersStruct$UserOutPeer> iterable) {
        ensureNotAddedUserPeersIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.notAddedUserPeers_);
    }

    private void addNotAddedUserPeers(PeersStruct$UserOutPeer peersStruct$UserOutPeer) {
        peersStruct$UserOutPeer.getClass();
        ensureNotAddedUserPeersIsMutable();
        this.notAddedUserPeers_.add(peersStruct$UserOutPeer);
    }

    private void clearNotAddedUserPeers() {
        this.notAddedUserPeers_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureNotAddedUserPeersIsMutable() {
        B.j jVar = this.notAddedUserPeers_;
        if (jVar.u()) {
            return;
        }
        this.notAddedUserPeers_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static GroupsOuterClass$ResponseInviteUsers getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static GroupsOuterClass$ResponseInviteUsers parseDelimitedFrom(InputStream inputStream) {
        return (GroupsOuterClass$ResponseInviteUsers) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GroupsOuterClass$ResponseInviteUsers parseFrom(ByteBuffer byteBuffer) {
        return (GroupsOuterClass$ResponseInviteUsers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeNotAddedUserPeers(int i) {
        ensureNotAddedUserPeersIsMutable();
        this.notAddedUserPeers_.remove(i);
    }

    private void setNotAddedUserPeers(int i, PeersStruct$UserOutPeer peersStruct$UserOutPeer) {
        peersStruct$UserOutPeer.getClass();
        ensureNotAddedUserPeersIsMutable();
        this.notAddedUserPeers_.set(i, peersStruct$UserOutPeer);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1874m0.a[gVar.ordinal()]) {
            case 1:
                return new GroupsOuterClass$ResponseInviteUsers();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"notAddedUserPeers_", PeersStruct$UserOutPeer.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (GroupsOuterClass$ResponseInviteUsers.class) {
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

    public PeersStruct$UserOutPeer getNotAddedUserPeers(int i) {
        return (PeersStruct$UserOutPeer) this.notAddedUserPeers_.get(i);
    }

    public int getNotAddedUserPeersCount() {
        return this.notAddedUserPeers_.size();
    }

    public List<PeersStruct$UserOutPeer> getNotAddedUserPeersList() {
        return this.notAddedUserPeers_;
    }

    public InterfaceC18084o35 getNotAddedUserPeersOrBuilder(int i) {
        return (InterfaceC18084o35) this.notAddedUserPeers_.get(i);
    }

    public List<? extends InterfaceC18084o35> getNotAddedUserPeersOrBuilderList() {
        return this.notAddedUserPeers_;
    }

    public static a newBuilder(GroupsOuterClass$ResponseInviteUsers groupsOuterClass$ResponseInviteUsers) {
        return (a) DEFAULT_INSTANCE.createBuilder(groupsOuterClass$ResponseInviteUsers);
    }

    public static GroupsOuterClass$ResponseInviteUsers parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (GroupsOuterClass$ResponseInviteUsers) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GroupsOuterClass$ResponseInviteUsers parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (GroupsOuterClass$ResponseInviteUsers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static GroupsOuterClass$ResponseInviteUsers parseFrom(AbstractC2383g abstractC2383g) {
        return (GroupsOuterClass$ResponseInviteUsers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addNotAddedUserPeers(int i, PeersStruct$UserOutPeer peersStruct$UserOutPeer) {
        peersStruct$UserOutPeer.getClass();
        ensureNotAddedUserPeersIsMutable();
        this.notAddedUserPeers_.add(i, peersStruct$UserOutPeer);
    }

    public static GroupsOuterClass$ResponseInviteUsers parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (GroupsOuterClass$ResponseInviteUsers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static GroupsOuterClass$ResponseInviteUsers parseFrom(byte[] bArr) {
        return (GroupsOuterClass$ResponseInviteUsers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GroupsOuterClass$ResponseInviteUsers parseFrom(byte[] bArr, C2394s c2394s) {
        return (GroupsOuterClass$ResponseInviteUsers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static GroupsOuterClass$ResponseInviteUsers parseFrom(InputStream inputStream) {
        return (GroupsOuterClass$ResponseInviteUsers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GroupsOuterClass$ResponseInviteUsers parseFrom(InputStream inputStream, C2394s c2394s) {
        return (GroupsOuterClass$ResponseInviteUsers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GroupsOuterClass$ResponseInviteUsers parseFrom(AbstractC2384h abstractC2384h) {
        return (GroupsOuterClass$ResponseInviteUsers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static GroupsOuterClass$ResponseInviteUsers parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (GroupsOuterClass$ResponseInviteUsers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
