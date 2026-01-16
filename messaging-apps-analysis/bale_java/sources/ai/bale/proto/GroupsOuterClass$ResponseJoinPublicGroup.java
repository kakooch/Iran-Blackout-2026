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
public final class GroupsOuterClass$ResponseJoinPublicGroup extends GeneratedMessageLite implements U64 {
    public static final int DATE_FIELD_NUMBER = 4;
    private static final GroupsOuterClass$ResponseJoinPublicGroup DEFAULT_INSTANCE;
    public static final int GROUP_FIELD_NUMBER = 1;
    public static final int GROUP_SEQ_FIELD_NUMBER = 9;
    public static final int INVITER_USER_ID_FIELD_NUMBER = 8;
    private static volatile KW4 PARSER = null;
    public static final int RID_FIELD_NUMBER = 6;
    public static final int SEQ_FIELD_NUMBER = 2;
    public static final int STATE_FIELD_NUMBER = 3;
    public static final int USERS_FIELD_NUMBER = 5;
    public static final int USER_PEERS_FIELD_NUMBER = 7;
    private int bitField0_;
    private long date_;
    private int groupSeq_;
    private GroupsStruct$Group group_;
    private int inviterUserId_;
    private long rid_;
    private int seq_;
    private B.j users_ = GeneratedMessageLite.emptyProtobufList();
    private B.j userPeers_ = GeneratedMessageLite.emptyProtobufList();
    private AbstractC2383g state_ = AbstractC2383g.b;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(GroupsOuterClass$ResponseJoinPublicGroup.DEFAULT_INSTANCE);
        }
    }

    static {
        GroupsOuterClass$ResponseJoinPublicGroup groupsOuterClass$ResponseJoinPublicGroup = new GroupsOuterClass$ResponseJoinPublicGroup();
        DEFAULT_INSTANCE = groupsOuterClass$ResponseJoinPublicGroup;
        GeneratedMessageLite.registerDefaultInstance(GroupsOuterClass$ResponseJoinPublicGroup.class, groupsOuterClass$ResponseJoinPublicGroup);
    }

    private GroupsOuterClass$ResponseJoinPublicGroup() {
    }

    private void addAllUserPeers(Iterable<? extends PeersStruct$UserOutPeer> iterable) {
        ensureUserPeersIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.userPeers_);
    }

    private void addAllUsers(Iterable<? extends UsersStruct$User> iterable) {
        ensureUsersIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.users_);
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

    private void clearDate() {
        this.date_ = 0L;
    }

    private void clearGroup() {
        this.group_ = null;
        this.bitField0_ &= -2;
    }

    private void clearGroupSeq() {
        this.groupSeq_ = 0;
    }

    private void clearInviterUserId() {
        this.inviterUserId_ = 0;
    }

    private void clearRid() {
        this.rid_ = 0L;
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

    public static GroupsOuterClass$ResponseJoinPublicGroup getDefaultInstance() {
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

    public static GroupsOuterClass$ResponseJoinPublicGroup parseDelimitedFrom(InputStream inputStream) {
        return (GroupsOuterClass$ResponseJoinPublicGroup) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GroupsOuterClass$ResponseJoinPublicGroup parseFrom(ByteBuffer byteBuffer) {
        return (GroupsOuterClass$ResponseJoinPublicGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeUserPeers(int i) {
        ensureUserPeersIsMutable();
        this.userPeers_.remove(i);
    }

    private void removeUsers(int i) {
        ensureUsersIsMutable();
        this.users_.remove(i);
    }

    private void setDate(long j) {
        this.date_ = j;
    }

    private void setGroup(GroupsStruct$Group groupsStruct$Group) {
        groupsStruct$Group.getClass();
        this.group_ = groupsStruct$Group;
        this.bitField0_ |= 1;
    }

    private void setGroupSeq(int i) {
        this.groupSeq_ = i;
    }

    private void setInviterUserId(int i) {
        this.inviterUserId_ = i;
    }

    private void setRid(long j) {
        this.rid_ = j;
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
                return new GroupsOuterClass$ResponseJoinPublicGroup();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\t\u0000\u0001\u0001\t\t\u0000\u0002\u0000\u0001ဉ\u0000\u0002\u0004\u0003\n\u0004\u0002\u0005\u001b\u0006\u0002\u0007\u001b\b\u0004\t\u0004", new Object[]{"bitField0_", "group_", "seq_", "state_", "date_", "users_", UsersStruct$User.class, "rid_", "userPeers_", PeersStruct$UserOutPeer.class, "inviterUserId_", "groupSeq_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (GroupsOuterClass$ResponseJoinPublicGroup.class) {
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

    public long getDate() {
        return this.date_;
    }

    public GroupsStruct$Group getGroup() {
        GroupsStruct$Group groupsStruct$Group = this.group_;
        return groupsStruct$Group == null ? GroupsStruct$Group.getDefaultInstance() : groupsStruct$Group;
    }

    public int getGroupSeq() {
        return this.groupSeq_;
    }

    public int getInviterUserId() {
        return this.inviterUserId_;
    }

    public long getRid() {
        return this.rid_;
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

    public static a newBuilder(GroupsOuterClass$ResponseJoinPublicGroup groupsOuterClass$ResponseJoinPublicGroup) {
        return (a) DEFAULT_INSTANCE.createBuilder(groupsOuterClass$ResponseJoinPublicGroup);
    }

    public static GroupsOuterClass$ResponseJoinPublicGroup parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (GroupsOuterClass$ResponseJoinPublicGroup) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GroupsOuterClass$ResponseJoinPublicGroup parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (GroupsOuterClass$ResponseJoinPublicGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static GroupsOuterClass$ResponseJoinPublicGroup parseFrom(AbstractC2383g abstractC2383g) {
        return (GroupsOuterClass$ResponseJoinPublicGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
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

    public static GroupsOuterClass$ResponseJoinPublicGroup parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (GroupsOuterClass$ResponseJoinPublicGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static GroupsOuterClass$ResponseJoinPublicGroup parseFrom(byte[] bArr) {
        return (GroupsOuterClass$ResponseJoinPublicGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GroupsOuterClass$ResponseJoinPublicGroup parseFrom(byte[] bArr, C2394s c2394s) {
        return (GroupsOuterClass$ResponseJoinPublicGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static GroupsOuterClass$ResponseJoinPublicGroup parseFrom(InputStream inputStream) {
        return (GroupsOuterClass$ResponseJoinPublicGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GroupsOuterClass$ResponseJoinPublicGroup parseFrom(InputStream inputStream, C2394s c2394s) {
        return (GroupsOuterClass$ResponseJoinPublicGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GroupsOuterClass$ResponseJoinPublicGroup parseFrom(AbstractC2384h abstractC2384h) {
        return (GroupsOuterClass$ResponseJoinPublicGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static GroupsOuterClass$ResponseJoinPublicGroup parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (GroupsOuterClass$ResponseJoinPublicGroup) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
