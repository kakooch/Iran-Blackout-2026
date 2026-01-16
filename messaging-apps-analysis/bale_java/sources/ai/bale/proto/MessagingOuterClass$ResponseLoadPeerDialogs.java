package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC11468d35;
import ir.nasim.InterfaceC18084o35;
import ir.nasim.InterfaceC18397ob4;
import ir.nasim.InterfaceC23748xS2;
import ir.nasim.KW4;
import ir.nasim.OM7;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class MessagingOuterClass$ResponseLoadPeerDialogs extends GeneratedMessageLite implements U64 {
    private static final MessagingOuterClass$ResponseLoadPeerDialogs DEFAULT_INSTANCE;
    public static final int DIALOGS_FIELD_NUMBER = 1;
    public static final int GROUPS_FIELD_NUMBER = 2;
    public static final int GROUP_PEERS_FIELD_NUMBER = 5;
    private static volatile KW4 PARSER = null;
    public static final int USERS_FIELD_NUMBER = 3;
    public static final int USER_PEERS_FIELD_NUMBER = 4;
    private B.j dialogs_ = GeneratedMessageLite.emptyProtobufList();
    private B.j groups_ = GeneratedMessageLite.emptyProtobufList();
    private B.j users_ = GeneratedMessageLite.emptyProtobufList();
    private B.j userPeers_ = GeneratedMessageLite.emptyProtobufList();
    private B.j groupPeers_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MessagingOuterClass$ResponseLoadPeerDialogs.DEFAULT_INSTANCE);
        }
    }

    static {
        MessagingOuterClass$ResponseLoadPeerDialogs messagingOuterClass$ResponseLoadPeerDialogs = new MessagingOuterClass$ResponseLoadPeerDialogs();
        DEFAULT_INSTANCE = messagingOuterClass$ResponseLoadPeerDialogs;
        GeneratedMessageLite.registerDefaultInstance(MessagingOuterClass$ResponseLoadPeerDialogs.class, messagingOuterClass$ResponseLoadPeerDialogs);
    }

    private MessagingOuterClass$ResponseLoadPeerDialogs() {
    }

    private void addAllDialogs(Iterable<? extends MessagingStruct$Dialog> iterable) {
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

    private void addDialogs(MessagingStruct$Dialog messagingStruct$Dialog) {
        messagingStruct$Dialog.getClass();
        ensureDialogsIsMutable();
        this.dialogs_.add(messagingStruct$Dialog);
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

    public static MessagingOuterClass$ResponseLoadPeerDialogs getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MessagingOuterClass$ResponseLoadPeerDialogs parseDelimitedFrom(InputStream inputStream) {
        return (MessagingOuterClass$ResponseLoadPeerDialogs) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingOuterClass$ResponseLoadPeerDialogs parseFrom(ByteBuffer byteBuffer) {
        return (MessagingOuterClass$ResponseLoadPeerDialogs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
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

    private void setDialogs(int i, MessagingStruct$Dialog messagingStruct$Dialog) {
        messagingStruct$Dialog.getClass();
        ensureDialogsIsMutable();
        this.dialogs_.set(i, messagingStruct$Dialog);
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
                return new MessagingOuterClass$ResponseLoadPeerDialogs();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0005\u0000\u0001\u001b\u0002\u001b\u0003\u001b\u0004\u001b\u0005\u001b", new Object[]{"dialogs_", MessagingStruct$Dialog.class, "groups_", GroupsStruct$Group.class, "users_", UsersStruct$User.class, "userPeers_", PeersStruct$UserOutPeer.class, "groupPeers_", PeersStruct$GroupOutPeer.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingOuterClass$ResponseLoadPeerDialogs.class) {
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

    public MessagingStruct$Dialog getDialogs(int i) {
        return (MessagingStruct$Dialog) this.dialogs_.get(i);
    }

    public int getDialogsCount() {
        return this.dialogs_.size();
    }

    public List<MessagingStruct$Dialog> getDialogsList() {
        return this.dialogs_;
    }

    public InterfaceC18397ob4 getDialogsOrBuilder(int i) {
        return (InterfaceC18397ob4) this.dialogs_.get(i);
    }

    public List<? extends InterfaceC18397ob4> getDialogsOrBuilderList() {
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

    public static a newBuilder(MessagingOuterClass$ResponseLoadPeerDialogs messagingOuterClass$ResponseLoadPeerDialogs) {
        return (a) DEFAULT_INSTANCE.createBuilder(messagingOuterClass$ResponseLoadPeerDialogs);
    }

    public static MessagingOuterClass$ResponseLoadPeerDialogs parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingOuterClass$ResponseLoadPeerDialogs) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingOuterClass$ResponseLoadPeerDialogs parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingOuterClass$ResponseLoadPeerDialogs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingOuterClass$ResponseLoadPeerDialogs parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingOuterClass$ResponseLoadPeerDialogs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addDialogs(int i, MessagingStruct$Dialog messagingStruct$Dialog) {
        messagingStruct$Dialog.getClass();
        ensureDialogsIsMutable();
        this.dialogs_.add(i, messagingStruct$Dialog);
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

    public static MessagingOuterClass$ResponseLoadPeerDialogs parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingOuterClass$ResponseLoadPeerDialogs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingOuterClass$ResponseLoadPeerDialogs parseFrom(byte[] bArr) {
        return (MessagingOuterClass$ResponseLoadPeerDialogs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingOuterClass$ResponseLoadPeerDialogs parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingOuterClass$ResponseLoadPeerDialogs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MessagingOuterClass$ResponseLoadPeerDialogs parseFrom(InputStream inputStream) {
        return (MessagingOuterClass$ResponseLoadPeerDialogs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingOuterClass$ResponseLoadPeerDialogs parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingOuterClass$ResponseLoadPeerDialogs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingOuterClass$ResponseLoadPeerDialogs parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingOuterClass$ResponseLoadPeerDialogs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingOuterClass$ResponseLoadPeerDialogs parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingOuterClass$ResponseLoadPeerDialogs) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
