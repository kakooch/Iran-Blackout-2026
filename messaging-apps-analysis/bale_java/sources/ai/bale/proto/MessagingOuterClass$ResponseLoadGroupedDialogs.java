package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.BoolValue;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC11468d35;
import ir.nasim.InterfaceC17806nb4;
import ir.nasim.InterfaceC18084o35;
import ir.nasim.InterfaceC23748xS2;
import ir.nasim.KW4;
import ir.nasim.OM7;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class MessagingOuterClass$ResponseLoadGroupedDialogs extends GeneratedMessageLite implements U64 {
    private static final MessagingOuterClass$ResponseLoadGroupedDialogs DEFAULT_INSTANCE;
    public static final int DIALOGS_FIELD_NUMBER = 1;
    public static final int GROUPS_FIELD_NUMBER = 3;
    public static final int GROUP_PEERS_FIELD_NUMBER = 7;
    private static volatile KW4 PARSER = null;
    public static final int SHOW_ARCHIVED_FIELD_NUMBER = 4;
    public static final int SHOW_INVITE_FIELD_NUMBER = 5;
    public static final int USERS_FIELD_NUMBER = 2;
    public static final int USER_PEERS_FIELD_NUMBER = 6;
    private int bitField0_;
    private BoolValue showArchived_;
    private BoolValue showInvite_;
    private B.j dialogs_ = GeneratedMessageLite.emptyProtobufList();
    private B.j users_ = GeneratedMessageLite.emptyProtobufList();
    private B.j groups_ = GeneratedMessageLite.emptyProtobufList();
    private B.j userPeers_ = GeneratedMessageLite.emptyProtobufList();
    private B.j groupPeers_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MessagingOuterClass$ResponseLoadGroupedDialogs.DEFAULT_INSTANCE);
        }
    }

    static {
        MessagingOuterClass$ResponseLoadGroupedDialogs messagingOuterClass$ResponseLoadGroupedDialogs = new MessagingOuterClass$ResponseLoadGroupedDialogs();
        DEFAULT_INSTANCE = messagingOuterClass$ResponseLoadGroupedDialogs;
        GeneratedMessageLite.registerDefaultInstance(MessagingOuterClass$ResponseLoadGroupedDialogs.class, messagingOuterClass$ResponseLoadGroupedDialogs);
    }

    private MessagingOuterClass$ResponseLoadGroupedDialogs() {
    }

    private void addAllDialogs(Iterable<? extends MessagingStruct$DialogGroup> iterable) {
        ensureDialogsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.dialogs_);
    }

    private void addAllGroupPeers(Iterable<? extends PeersStruct$GroupOutPeer> iterable) {
        ensureGroupPeersIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.groupPeers_);
    }

    private void addAllGroups(Iterable<? extends GroupsStruct$Group> iterable) {
        ensureGroupsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.groups_);
    }

    private void addAllUserPeers(Iterable<? extends PeersStruct$UserOutPeer> iterable) {
        ensureUserPeersIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.userPeers_);
    }

    private void addAllUsers(Iterable<? extends UsersStruct$User> iterable) {
        ensureUsersIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.users_);
    }

    private void addDialogs(MessagingStruct$DialogGroup messagingStruct$DialogGroup) {
        messagingStruct$DialogGroup.getClass();
        ensureDialogsIsMutable();
        this.dialogs_.add(messagingStruct$DialogGroup);
    }

    private void addGroupPeers(PeersStruct$GroupOutPeer peersStruct$GroupOutPeer) {
        peersStruct$GroupOutPeer.getClass();
        ensureGroupPeersIsMutable();
        this.groupPeers_.add(peersStruct$GroupOutPeer);
    }

    private void addGroups(GroupsStruct$Group groupsStruct$Group) {
        groupsStruct$Group.getClass();
        ensureGroupsIsMutable();
        this.groups_.add(groupsStruct$Group);
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

    private void clearDialogs() {
        this.dialogs_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearGroupPeers() {
        this.groupPeers_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearGroups() {
        this.groups_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearShowArchived() {
        this.showArchived_ = null;
        this.bitField0_ &= -2;
    }

    private void clearShowInvite() {
        this.showInvite_ = null;
        this.bitField0_ &= -3;
    }

    private void clearUserPeers() {
        this.userPeers_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearUsers() {
        this.users_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureDialogsIsMutable() {
        B.j jVar = this.dialogs_;
        if (jVar.u()) {
            return;
        }
        this.dialogs_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    private void ensureGroupPeersIsMutable() {
        B.j jVar = this.groupPeers_;
        if (jVar.u()) {
            return;
        }
        this.groupPeers_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    private void ensureGroupsIsMutable() {
        B.j jVar = this.groups_;
        if (jVar.u()) {
            return;
        }
        this.groups_ = GeneratedMessageLite.mutableCopy(jVar);
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

    public static MessagingOuterClass$ResponseLoadGroupedDialogs getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeShowArchived(BoolValue boolValue) {
        boolValue.getClass();
        BoolValue boolValue2 = this.showArchived_;
        if (boolValue2 == null || boolValue2 == BoolValue.getDefaultInstance()) {
            this.showArchived_ = boolValue;
        } else {
            this.showArchived_ = (BoolValue) ((BoolValue.b) BoolValue.newBuilder(this.showArchived_).v(boolValue)).j();
        }
        this.bitField0_ |= 1;
    }

    private void mergeShowInvite(BoolValue boolValue) {
        boolValue.getClass();
        BoolValue boolValue2 = this.showInvite_;
        if (boolValue2 == null || boolValue2 == BoolValue.getDefaultInstance()) {
            this.showInvite_ = boolValue;
        } else {
            this.showInvite_ = (BoolValue) ((BoolValue.b) BoolValue.newBuilder(this.showInvite_).v(boolValue)).j();
        }
        this.bitField0_ |= 2;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MessagingOuterClass$ResponseLoadGroupedDialogs parseDelimitedFrom(InputStream inputStream) {
        return (MessagingOuterClass$ResponseLoadGroupedDialogs) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingOuterClass$ResponseLoadGroupedDialogs parseFrom(ByteBuffer byteBuffer) {
        return (MessagingOuterClass$ResponseLoadGroupedDialogs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeDialogs(int i) {
        ensureDialogsIsMutable();
        this.dialogs_.remove(i);
    }

    private void removeGroupPeers(int i) {
        ensureGroupPeersIsMutable();
        this.groupPeers_.remove(i);
    }

    private void removeGroups(int i) {
        ensureGroupsIsMutable();
        this.groups_.remove(i);
    }

    private void removeUserPeers(int i) {
        ensureUserPeersIsMutable();
        this.userPeers_.remove(i);
    }

    private void removeUsers(int i) {
        ensureUsersIsMutable();
        this.users_.remove(i);
    }

    private void setDialogs(int i, MessagingStruct$DialogGroup messagingStruct$DialogGroup) {
        messagingStruct$DialogGroup.getClass();
        ensureDialogsIsMutable();
        this.dialogs_.set(i, messagingStruct$DialogGroup);
    }

    private void setGroupPeers(int i, PeersStruct$GroupOutPeer peersStruct$GroupOutPeer) {
        peersStruct$GroupOutPeer.getClass();
        ensureGroupPeersIsMutable();
        this.groupPeers_.set(i, peersStruct$GroupOutPeer);
    }

    private void setGroups(int i, GroupsStruct$Group groupsStruct$Group) {
        groupsStruct$Group.getClass();
        ensureGroupsIsMutable();
        this.groups_.set(i, groupsStruct$Group);
    }

    private void setShowArchived(BoolValue boolValue) {
        boolValue.getClass();
        this.showArchived_ = boolValue;
        this.bitField0_ |= 1;
    }

    private void setShowInvite(BoolValue boolValue) {
        boolValue.getClass();
        this.showInvite_ = boolValue;
        this.bitField0_ |= 2;
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
        switch (K0.a[gVar.ordinal()]) {
            case 1:
                return new MessagingOuterClass$ResponseLoadGroupedDialogs();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0005\u0000\u0001\u001b\u0002\u001b\u0003\u001b\u0004ဉ\u0000\u0005ဉ\u0001\u0006\u001b\u0007\u001b", new Object[]{"bitField0_", "dialogs_", MessagingStruct$DialogGroup.class, "users_", UsersStruct$User.class, "groups_", GroupsStruct$Group.class, "showArchived_", "showInvite_", "userPeers_", PeersStruct$UserOutPeer.class, "groupPeers_", PeersStruct$GroupOutPeer.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingOuterClass$ResponseLoadGroupedDialogs.class) {
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

    public MessagingStruct$DialogGroup getDialogs(int i) {
        return (MessagingStruct$DialogGroup) this.dialogs_.get(i);
    }

    public int getDialogsCount() {
        return this.dialogs_.size();
    }

    public List<MessagingStruct$DialogGroup> getDialogsList() {
        return this.dialogs_;
    }

    public InterfaceC17806nb4 getDialogsOrBuilder(int i) {
        return (InterfaceC17806nb4) this.dialogs_.get(i);
    }

    public List<? extends InterfaceC17806nb4> getDialogsOrBuilderList() {
        return this.dialogs_;
    }

    public PeersStruct$GroupOutPeer getGroupPeers(int i) {
        return (PeersStruct$GroupOutPeer) this.groupPeers_.get(i);
    }

    public int getGroupPeersCount() {
        return this.groupPeers_.size();
    }

    public List<PeersStruct$GroupOutPeer> getGroupPeersList() {
        return this.groupPeers_;
    }

    public InterfaceC11468d35 getGroupPeersOrBuilder(int i) {
        return (InterfaceC11468d35) this.groupPeers_.get(i);
    }

    public List<? extends InterfaceC11468d35> getGroupPeersOrBuilderList() {
        return this.groupPeers_;
    }

    public GroupsStruct$Group getGroups(int i) {
        return (GroupsStruct$Group) this.groups_.get(i);
    }

    public int getGroupsCount() {
        return this.groups_.size();
    }

    public List<GroupsStruct$Group> getGroupsList() {
        return this.groups_;
    }

    public InterfaceC23748xS2 getGroupsOrBuilder(int i) {
        return (InterfaceC23748xS2) this.groups_.get(i);
    }

    public List<? extends InterfaceC23748xS2> getGroupsOrBuilderList() {
        return this.groups_;
    }

    public BoolValue getShowArchived() {
        BoolValue boolValue = this.showArchived_;
        return boolValue == null ? BoolValue.getDefaultInstance() : boolValue;
    }

    public BoolValue getShowInvite() {
        BoolValue boolValue = this.showInvite_;
        return boolValue == null ? BoolValue.getDefaultInstance() : boolValue;
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

    public boolean hasShowArchived() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasShowInvite() {
        return (this.bitField0_ & 2) != 0;
    }

    public static a newBuilder(MessagingOuterClass$ResponseLoadGroupedDialogs messagingOuterClass$ResponseLoadGroupedDialogs) {
        return (a) DEFAULT_INSTANCE.createBuilder(messagingOuterClass$ResponseLoadGroupedDialogs);
    }

    public static MessagingOuterClass$ResponseLoadGroupedDialogs parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingOuterClass$ResponseLoadGroupedDialogs) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingOuterClass$ResponseLoadGroupedDialogs parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingOuterClass$ResponseLoadGroupedDialogs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingOuterClass$ResponseLoadGroupedDialogs parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingOuterClass$ResponseLoadGroupedDialogs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addDialogs(int i, MessagingStruct$DialogGroup messagingStruct$DialogGroup) {
        messagingStruct$DialogGroup.getClass();
        ensureDialogsIsMutable();
        this.dialogs_.add(i, messagingStruct$DialogGroup);
    }

    private void addGroupPeers(int i, PeersStruct$GroupOutPeer peersStruct$GroupOutPeer) {
        peersStruct$GroupOutPeer.getClass();
        ensureGroupPeersIsMutable();
        this.groupPeers_.add(i, peersStruct$GroupOutPeer);
    }

    private void addGroups(int i, GroupsStruct$Group groupsStruct$Group) {
        groupsStruct$Group.getClass();
        ensureGroupsIsMutable();
        this.groups_.add(i, groupsStruct$Group);
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

    public static MessagingOuterClass$ResponseLoadGroupedDialogs parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingOuterClass$ResponseLoadGroupedDialogs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingOuterClass$ResponseLoadGroupedDialogs parseFrom(byte[] bArr) {
        return (MessagingOuterClass$ResponseLoadGroupedDialogs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingOuterClass$ResponseLoadGroupedDialogs parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingOuterClass$ResponseLoadGroupedDialogs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MessagingOuterClass$ResponseLoadGroupedDialogs parseFrom(InputStream inputStream) {
        return (MessagingOuterClass$ResponseLoadGroupedDialogs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingOuterClass$ResponseLoadGroupedDialogs parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingOuterClass$ResponseLoadGroupedDialogs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingOuterClass$ResponseLoadGroupedDialogs parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingOuterClass$ResponseLoadGroupedDialogs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingOuterClass$ResponseLoadGroupedDialogs parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingOuterClass$ResponseLoadGroupedDialogs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
