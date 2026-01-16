package ai.bale.proto;

import ai.bale.proto.PeersStruct$GroupOutPeer;
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
public final class GroupsOuterClass$RequestInviteUsers extends GeneratedMessageLite implements U64 {
    private static final GroupsOuterClass$RequestInviteUsers DEFAULT_INSTANCE;
    public static final int GROUP_PEER_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int RID_FIELD_NUMBER = 2;
    public static final int USERS_FIELD_NUMBER = 3;
    private int bitField0_;
    private PeersStruct$GroupOutPeer groupPeer_;
    private long rid_;
    private B.j users_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(Iterable iterable) {
            q();
            ((GroupsOuterClass$RequestInviteUsers) this.b).addAllUsers(iterable);
            return this;
        }

        public a B(PeersStruct$GroupOutPeer peersStruct$GroupOutPeer) {
            q();
            ((GroupsOuterClass$RequestInviteUsers) this.b).setGroupPeer(peersStruct$GroupOutPeer);
            return this;
        }

        public a C(long j) {
            q();
            ((GroupsOuterClass$RequestInviteUsers) this.b).setRid(j);
            return this;
        }

        private a() {
            super(GroupsOuterClass$RequestInviteUsers.DEFAULT_INSTANCE);
        }
    }

    static {
        GroupsOuterClass$RequestInviteUsers groupsOuterClass$RequestInviteUsers = new GroupsOuterClass$RequestInviteUsers();
        DEFAULT_INSTANCE = groupsOuterClass$RequestInviteUsers;
        GeneratedMessageLite.registerDefaultInstance(GroupsOuterClass$RequestInviteUsers.class, groupsOuterClass$RequestInviteUsers);
    }

    private GroupsOuterClass$RequestInviteUsers() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllUsers(Iterable<? extends PeersStruct$UserOutPeer> iterable) {
        ensureUsersIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.users_);
    }

    private void addUsers(PeersStruct$UserOutPeer peersStruct$UserOutPeer) {
        peersStruct$UserOutPeer.getClass();
        ensureUsersIsMutable();
        this.users_.add(peersStruct$UserOutPeer);
    }

    private void clearGroupPeer() {
        this.groupPeer_ = null;
        this.bitField0_ &= -2;
    }

    private void clearRid() {
        this.rid_ = 0L;
    }

    private void clearUsers() {
        this.users_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureUsersIsMutable() {
        B.j jVar = this.users_;
        if (jVar.u()) {
            return;
        }
        this.users_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static GroupsOuterClass$RequestInviteUsers getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeGroupPeer(PeersStruct$GroupOutPeer peersStruct$GroupOutPeer) {
        peersStruct$GroupOutPeer.getClass();
        PeersStruct$GroupOutPeer peersStruct$GroupOutPeer2 = this.groupPeer_;
        if (peersStruct$GroupOutPeer2 == null || peersStruct$GroupOutPeer2 == PeersStruct$GroupOutPeer.getDefaultInstance()) {
            this.groupPeer_ = peersStruct$GroupOutPeer;
        } else {
            this.groupPeer_ = (PeersStruct$GroupOutPeer) ((PeersStruct$GroupOutPeer.a) PeersStruct$GroupOutPeer.newBuilder(this.groupPeer_).v(peersStruct$GroupOutPeer)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static GroupsOuterClass$RequestInviteUsers parseDelimitedFrom(InputStream inputStream) {
        return (GroupsOuterClass$RequestInviteUsers) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GroupsOuterClass$RequestInviteUsers parseFrom(ByteBuffer byteBuffer) {
        return (GroupsOuterClass$RequestInviteUsers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeUsers(int i) {
        ensureUsersIsMutable();
        this.users_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setGroupPeer(PeersStruct$GroupOutPeer peersStruct$GroupOutPeer) {
        peersStruct$GroupOutPeer.getClass();
        this.groupPeer_ = peersStruct$GroupOutPeer;
        this.bitField0_ |= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRid(long j) {
        this.rid_ = j;
    }

    private void setUsers(int i, PeersStruct$UserOutPeer peersStruct$UserOutPeer) {
        peersStruct$UserOutPeer.getClass();
        ensureUsersIsMutable();
        this.users_.set(i, peersStruct$UserOutPeer);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1874m0.a[gVar.ordinal()]) {
            case 1:
                return new GroupsOuterClass$RequestInviteUsers();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001ဉ\u0000\u0002\u0002\u0003\u001b", new Object[]{"bitField0_", "groupPeer_", "rid_", "users_", PeersStruct$UserOutPeer.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (GroupsOuterClass$RequestInviteUsers.class) {
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

    public PeersStruct$GroupOutPeer getGroupPeer() {
        PeersStruct$GroupOutPeer peersStruct$GroupOutPeer = this.groupPeer_;
        return peersStruct$GroupOutPeer == null ? PeersStruct$GroupOutPeer.getDefaultInstance() : peersStruct$GroupOutPeer;
    }

    public long getRid() {
        return this.rid_;
    }

    public PeersStruct$UserOutPeer getUsers(int i) {
        return (PeersStruct$UserOutPeer) this.users_.get(i);
    }

    public int getUsersCount() {
        return this.users_.size();
    }

    public List<PeersStruct$UserOutPeer> getUsersList() {
        return this.users_;
    }

    public InterfaceC18084o35 getUsersOrBuilder(int i) {
        return (InterfaceC18084o35) this.users_.get(i);
    }

    public List<? extends InterfaceC18084o35> getUsersOrBuilderList() {
        return this.users_;
    }

    public boolean hasGroupPeer() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(GroupsOuterClass$RequestInviteUsers groupsOuterClass$RequestInviteUsers) {
        return (a) DEFAULT_INSTANCE.createBuilder(groupsOuterClass$RequestInviteUsers);
    }

    public static GroupsOuterClass$RequestInviteUsers parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (GroupsOuterClass$RequestInviteUsers) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GroupsOuterClass$RequestInviteUsers parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (GroupsOuterClass$RequestInviteUsers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static GroupsOuterClass$RequestInviteUsers parseFrom(AbstractC2383g abstractC2383g) {
        return (GroupsOuterClass$RequestInviteUsers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addUsers(int i, PeersStruct$UserOutPeer peersStruct$UserOutPeer) {
        peersStruct$UserOutPeer.getClass();
        ensureUsersIsMutable();
        this.users_.add(i, peersStruct$UserOutPeer);
    }

    public static GroupsOuterClass$RequestInviteUsers parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (GroupsOuterClass$RequestInviteUsers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static GroupsOuterClass$RequestInviteUsers parseFrom(byte[] bArr) {
        return (GroupsOuterClass$RequestInviteUsers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GroupsOuterClass$RequestInviteUsers parseFrom(byte[] bArr, C2394s c2394s) {
        return (GroupsOuterClass$RequestInviteUsers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static GroupsOuterClass$RequestInviteUsers parseFrom(InputStream inputStream) {
        return (GroupsOuterClass$RequestInviteUsers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GroupsOuterClass$RequestInviteUsers parseFrom(InputStream inputStream, C2394s c2394s) {
        return (GroupsOuterClass$RequestInviteUsers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GroupsOuterClass$RequestInviteUsers parseFrom(AbstractC2384h abstractC2384h) {
        return (GroupsOuterClass$RequestInviteUsers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static GroupsOuterClass$RequestInviteUsers parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (GroupsOuterClass$RequestInviteUsers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
