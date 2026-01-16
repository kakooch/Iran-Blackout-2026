package ai.bale.proto;

import ai.bale.proto.GroupsStruct$Group;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC18084o35;
import ir.nasim.KW4;
import ir.nasim.OM7;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class GroupsOuterClass$ResponseCreateGroup extends GeneratedMessageLite implements U64 {
    private static final GroupsOuterClass$ResponseCreateGroup DEFAULT_INSTANCE;
    public static final int GROUP_FIELD_NUMBER = 3;
    public static final int INVITE_LINK_FIELD_NUMBER = 7;
    public static final int NOT_ADDED_USER_PEERS_FIELD_NUMBER = 6;
    private static volatile KW4 PARSER = null;
    public static final int SEQ_FIELD_NUMBER = 1;
    public static final int STATE_FIELD_NUMBER = 2;
    public static final int USERS_FIELD_NUMBER = 4;
    public static final int USER_PEERS_FIELD_NUMBER = 5;
    private int bitField0_;
    private GroupsStruct$Group group_;
    private int seq_;
    private AbstractC2383g state_ = AbstractC2383g.b;
    private B.j users_ = GeneratedMessageLite.emptyProtobufList();
    private B.j userPeers_ = GeneratedMessageLite.emptyProtobufList();
    private B.j notAddedUserPeers_ = GeneratedMessageLite.emptyProtobufList();
    private String inviteLink_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(GroupsOuterClass$ResponseCreateGroup.DEFAULT_INSTANCE);
        }
    }

    static {
        GroupsOuterClass$ResponseCreateGroup groupsOuterClass$ResponseCreateGroup = new GroupsOuterClass$ResponseCreateGroup();
        DEFAULT_INSTANCE = groupsOuterClass$ResponseCreateGroup;
        GeneratedMessageLite.registerDefaultInstance(GroupsOuterClass$ResponseCreateGroup.class, groupsOuterClass$ResponseCreateGroup);
    }

    private GroupsOuterClass$ResponseCreateGroup() {
    }

    private void addAllNotAddedUserPeers(Iterable<? extends PeersStruct$UserOutPeer> iterable) {
        ensureNotAddedUserPeersIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.notAddedUserPeers_);
    }

    private void addAllUserPeers(Iterable<? extends PeersStruct$UserOutPeer> iterable) {
        ensureUserPeersIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.userPeers_);
    }

    private void addAllUsers(Iterable<? extends UsersStruct$User> iterable) {
        ensureUsersIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.users_);
    }

    private void addNotAddedUserPeers(PeersStruct$UserOutPeer peersStruct$UserOutPeer) {
        peersStruct$UserOutPeer.getClass();
        ensureNotAddedUserPeersIsMutable();
        this.notAddedUserPeers_.add(peersStruct$UserOutPeer);
    }

    private void addUserPeers(PeersStruct$UserOutPeer peersStruct$UserOutPeer) {
        peersStruct$UserOutPeer.getClass();
        ensureUserPeersIsMutable();
        this.userPeers_.add(peersStruct$UserOutPeer);
    }

    private void addUsers(UsersStruct$User usersStruct$User) {
        usersStruct$User.getClass();
        ensureUsersIsMutable();
        this.users_.add(usersStruct$User);
    }

    private void clearGroup() {
        this.group_ = null;
        this.bitField0_ &= -2;
    }

    private void clearInviteLink() {
        this.inviteLink_ = getDefaultInstance().getInviteLink();
    }

    private void clearNotAddedUserPeers() {
        this.notAddedUserPeers_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearSeq() {
        this.seq_ = 0;
    }

    private void clearState() {
        this.state_ = getDefaultInstance().getState();
    }

    private void clearUserPeers() {
        this.userPeers_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearUsers() {
        this.users_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureNotAddedUserPeersIsMutable() {
        B.j jVar = this.notAddedUserPeers_;
        if (jVar.u()) {
            return;
        }
        this.notAddedUserPeers_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    private void ensureUserPeersIsMutable() {
        B.j jVar = this.userPeers_;
        if (jVar.u()) {
            return;
        }
        this.userPeers_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    private void ensureUsersIsMutable() {
        B.j jVar = this.users_;
        if (jVar.u()) {
            return;
        }
        this.users_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static GroupsOuterClass$ResponseCreateGroup getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeGroup(GroupsStruct$Group groupsStruct$Group) {
        groupsStruct$Group.getClass();
        GroupsStruct$Group groupsStruct$Group2 = this.group_;
        if (groupsStruct$Group2 == null || groupsStruct$Group2 == GroupsStruct$Group.getDefaultInstance()) {
            this.group_ = groupsStruct$Group;
        } else {
            this.group_ = (GroupsStruct$Group) ((GroupsStruct$Group.a) GroupsStruct$Group.newBuilder(this.group_).v(groupsStruct$Group)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static GroupsOuterClass$ResponseCreateGroup parseDelimitedFrom(InputStream inputStream) {
        return (GroupsOuterClass$ResponseCreateGroup) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GroupsOuterClass$ResponseCreateGroup parseFrom(ByteBuffer byteBuffer) {
        return (GroupsOuterClass$ResponseCreateGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeNotAddedUserPeers(int i) {
        ensureNotAddedUserPeersIsMutable();
        this.notAddedUserPeers_.remove(i);
    }

    private void removeUserPeers(int i) {
        ensureUserPeersIsMutable();
        this.userPeers_.remove(i);
    }

    private void removeUsers(int i) {
        ensureUsersIsMutable();
        this.users_.remove(i);
    }

    private void setGroup(GroupsStruct$Group groupsStruct$Group) {
        groupsStruct$Group.getClass();
        this.group_ = groupsStruct$Group;
        this.bitField0_ |= 1;
    }

    private void setInviteLink(String str) {
        str.getClass();
        this.inviteLink_ = str;
    }

    private void setInviteLinkBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.inviteLink_ = abstractC2383g.f0();
    }

    private void setNotAddedUserPeers(int i, PeersStruct$UserOutPeer peersStruct$UserOutPeer) {
        peersStruct$UserOutPeer.getClass();
        ensureNotAddedUserPeersIsMutable();
        this.notAddedUserPeers_.set(i, peersStruct$UserOutPeer);
    }

    private void setSeq(int i) {
        this.seq_ = i;
    }

    private void setState(AbstractC2383g abstractC2383g) {
        abstractC2383g.getClass();
        this.state_ = abstractC2383g;
    }

    private void setUserPeers(int i, PeersStruct$UserOutPeer peersStruct$UserOutPeer) {
        peersStruct$UserOutPeer.getClass();
        ensureUserPeersIsMutable();
        this.userPeers_.set(i, peersStruct$UserOutPeer);
    }

    private void setUsers(int i, UsersStruct$User usersStruct$User) {
        usersStruct$User.getClass();
        ensureUsersIsMutable();
        this.users_.set(i, usersStruct$User);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1874m0.a[gVar.ordinal()]) {
            case 1:
                return new GroupsOuterClass$ResponseCreateGroup();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0003\u0000\u0001\u0004\u0002\n\u0003ဉ\u0000\u0004\u001b\u0005\u001b\u0006\u001b\u0007Ȉ", new Object[]{"bitField0_", "seq_", "state_", "group_", "users_", UsersStruct$User.class, "userPeers_", PeersStruct$UserOutPeer.class, "notAddedUserPeers_", PeersStruct$UserOutPeer.class, "inviteLink_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (GroupsOuterClass$ResponseCreateGroup.class) {
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

    public GroupsStruct$Group getGroup() {
        GroupsStruct$Group groupsStruct$Group = this.group_;
        return groupsStruct$Group == null ? GroupsStruct$Group.getDefaultInstance() : groupsStruct$Group;
    }

    public String getInviteLink() {
        return this.inviteLink_;
    }

    public AbstractC2383g getInviteLinkBytes() {
        return AbstractC2383g.N(this.inviteLink_);
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

    public int getSeq() {
        return this.seq_;
    }

    public AbstractC2383g getState() {
        return this.state_;
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

    public UsersStruct$User getUsers(int i) {
        return (UsersStruct$User) this.users_.get(i);
    }

    public int getUsersCount() {
        return this.users_.size();
    }

    public List<UsersStruct$User> getUsersList() {
        return this.users_;
    }

    public OM7 getUsersOrBuilder(int i) {
        return (OM7) this.users_.get(i);
    }

    public List<? extends OM7> getUsersOrBuilderList() {
        return this.users_;
    }

    public boolean hasGroup() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(GroupsOuterClass$ResponseCreateGroup groupsOuterClass$ResponseCreateGroup) {
        return (a) DEFAULT_INSTANCE.createBuilder(groupsOuterClass$ResponseCreateGroup);
    }

    public static GroupsOuterClass$ResponseCreateGroup parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (GroupsOuterClass$ResponseCreateGroup) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GroupsOuterClass$ResponseCreateGroup parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (GroupsOuterClass$ResponseCreateGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static GroupsOuterClass$ResponseCreateGroup parseFrom(AbstractC2383g abstractC2383g) {
        return (GroupsOuterClass$ResponseCreateGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addNotAddedUserPeers(int i, PeersStruct$UserOutPeer peersStruct$UserOutPeer) {
        peersStruct$UserOutPeer.getClass();
        ensureNotAddedUserPeersIsMutable();
        this.notAddedUserPeers_.add(i, peersStruct$UserOutPeer);
    }

    private void addUserPeers(int i, PeersStruct$UserOutPeer peersStruct$UserOutPeer) {
        peersStruct$UserOutPeer.getClass();
        ensureUserPeersIsMutable();
        this.userPeers_.add(i, peersStruct$UserOutPeer);
    }

    private void addUsers(int i, UsersStruct$User usersStruct$User) {
        usersStruct$User.getClass();
        ensureUsersIsMutable();
        this.users_.add(i, usersStruct$User);
    }

    public static GroupsOuterClass$ResponseCreateGroup parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (GroupsOuterClass$ResponseCreateGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static GroupsOuterClass$ResponseCreateGroup parseFrom(byte[] bArr) {
        return (GroupsOuterClass$ResponseCreateGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GroupsOuterClass$ResponseCreateGroup parseFrom(byte[] bArr, C2394s c2394s) {
        return (GroupsOuterClass$ResponseCreateGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static GroupsOuterClass$ResponseCreateGroup parseFrom(InputStream inputStream) {
        return (GroupsOuterClass$ResponseCreateGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GroupsOuterClass$ResponseCreateGroup parseFrom(InputStream inputStream, C2394s c2394s) {
        return (GroupsOuterClass$ResponseCreateGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GroupsOuterClass$ResponseCreateGroup parseFrom(AbstractC2384h abstractC2384h) {
        return (GroupsOuterClass$ResponseCreateGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static GroupsOuterClass$ResponseCreateGroup parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (GroupsOuterClass$ResponseCreateGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
