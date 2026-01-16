package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC11468d35;
import ir.nasim.InterfaceC18084o35;
import ir.nasim.InterfaceC23748xS2;
import ir.nasim.InterfaceC7888Tp6;
import ir.nasim.KW4;
import ir.nasim.OM7;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes.dex */
public final class Sequence$ResponseGetGroupDifference extends GeneratedMessageLite implements U64 {
    private static final Sequence$ResponseGetGroupDifference DEFAULT_INSTANCE;
    public static final int GROUPS_FIELD_NUMBER = 5;
    public static final int GROUPS_REFS_FIELD_NUMBER = 8;
    private static volatile KW4 PARSER = null;
    public static final int UPDATES_FIELD_NUMBER = 1;
    public static final int USERS_FIELD_NUMBER = 4;
    public static final int USERS_REFS_FIELD_NUMBER = 7;
    private B.j updates_ = GeneratedMessageLite.emptyProtobufList();
    private B.j usersRefs_ = GeneratedMessageLite.emptyProtobufList();
    private B.j groupsRefs_ = GeneratedMessageLite.emptyProtobufList();
    private B.j users_ = GeneratedMessageLite.emptyProtobufList();
    private B.j groups_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Sequence$ResponseGetGroupDifference.DEFAULT_INSTANCE);
        }
    }

    static {
        Sequence$ResponseGetGroupDifference sequence$ResponseGetGroupDifference = new Sequence$ResponseGetGroupDifference();
        DEFAULT_INSTANCE = sequence$ResponseGetGroupDifference;
        GeneratedMessageLite.registerDefaultInstance(Sequence$ResponseGetGroupDifference.class, sequence$ResponseGetGroupDifference);
    }

    private Sequence$ResponseGetGroupDifference() {
    }

    private void addAllGroups(Iterable<? extends GroupsStruct$Group> iterable) {
        ensureGroupsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.groups_);
    }

    private void addAllGroupsRefs(Iterable<? extends PeersStruct$GroupOutPeer> iterable) {
        ensureGroupsRefsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.groupsRefs_);
    }

    private void addAllUpdates(Iterable<? extends SequenceStruct$GroupUpdateContainer> iterable) {
        ensureUpdatesIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.updates_);
    }

    private void addAllUsers(Iterable<? extends UsersStruct$User> iterable) {
        ensureUsersIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.users_);
    }

    private void addAllUsersRefs(Iterable<? extends PeersStruct$UserOutPeer> iterable) {
        ensureUsersRefsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.usersRefs_);
    }

    private void addGroups(GroupsStruct$Group groupsStruct$Group) {
        groupsStruct$Group.getClass();
        ensureGroupsIsMutable();
        this.groups_.add(groupsStruct$Group);
    }

    private void addGroupsRefs(PeersStruct$GroupOutPeer peersStruct$GroupOutPeer) {
        peersStruct$GroupOutPeer.getClass();
        ensureGroupsRefsIsMutable();
        this.groupsRefs_.add(peersStruct$GroupOutPeer);
    }

    private void addUpdates(SequenceStruct$GroupUpdateContainer sequenceStruct$GroupUpdateContainer) {
        sequenceStruct$GroupUpdateContainer.getClass();
        ensureUpdatesIsMutable();
        this.updates_.add(sequenceStruct$GroupUpdateContainer);
    }

    private void addUsers(UsersStruct$User usersStruct$User) {
        usersStruct$User.getClass();
        ensureUsersIsMutable();
        this.users_.add(usersStruct$User);
    }

    private void addUsersRefs(PeersStruct$UserOutPeer peersStruct$UserOutPeer) {
        peersStruct$UserOutPeer.getClass();
        ensureUsersRefsIsMutable();
        this.usersRefs_.add(peersStruct$UserOutPeer);
    }

    private void clearGroups() {
        this.groups_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearGroupsRefs() {
        this.groupsRefs_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearUpdates() {
        this.updates_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearUsers() {
        this.users_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearUsersRefs() {
        this.usersRefs_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureGroupsIsMutable() {
        B.j jVar = this.groups_;
        if (jVar.u()) {
            return;
        }
        this.groups_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    private void ensureGroupsRefsIsMutable() {
        B.j jVar = this.groupsRefs_;
        if (jVar.u()) {
            return;
        }
        this.groupsRefs_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    private void ensureUpdatesIsMutable() {
        B.j jVar = this.updates_;
        if (jVar.u()) {
            return;
        }
        this.updates_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    private void ensureUsersIsMutable() {
        B.j jVar = this.users_;
        if (jVar.u()) {
            return;
        }
        this.users_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    private void ensureUsersRefsIsMutable() {
        B.j jVar = this.usersRefs_;
        if (jVar.u()) {
            return;
        }
        this.usersRefs_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static Sequence$ResponseGetGroupDifference getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Sequence$ResponseGetGroupDifference parseDelimitedFrom(InputStream inputStream) {
        return (Sequence$ResponseGetGroupDifference) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Sequence$ResponseGetGroupDifference parseFrom(ByteBuffer byteBuffer) {
        return (Sequence$ResponseGetGroupDifference) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeGroups(int i) {
        ensureGroupsIsMutable();
        this.groups_.remove(i);
    }

    private void removeGroupsRefs(int i) {
        ensureGroupsRefsIsMutable();
        this.groupsRefs_.remove(i);
    }

    private void removeUpdates(int i) {
        ensureUpdatesIsMutable();
        this.updates_.remove(i);
    }

    private void removeUsers(int i) {
        ensureUsersIsMutable();
        this.users_.remove(i);
    }

    private void removeUsersRefs(int i) {
        ensureUsersRefsIsMutable();
        this.usersRefs_.remove(i);
    }

    private void setGroups(int i, GroupsStruct$Group groupsStruct$Group) {
        groupsStruct$Group.getClass();
        ensureGroupsIsMutable();
        this.groups_.set(i, groupsStruct$Group);
    }

    private void setGroupsRefs(int i, PeersStruct$GroupOutPeer peersStruct$GroupOutPeer) {
        peersStruct$GroupOutPeer.getClass();
        ensureGroupsRefsIsMutable();
        this.groupsRefs_.set(i, peersStruct$GroupOutPeer);
    }

    private void setUpdates(int i, SequenceStruct$GroupUpdateContainer sequenceStruct$GroupUpdateContainer) {
        sequenceStruct$GroupUpdateContainer.getClass();
        ensureUpdatesIsMutable();
        this.updates_.set(i, sequenceStruct$GroupUpdateContainer);
    }

    private void setUsers(int i, UsersStruct$User usersStruct$User) {
        usersStruct$User.getClass();
        ensureUsersIsMutable();
        this.users_.set(i, usersStruct$User);
    }

    private void setUsersRefs(int i, PeersStruct$UserOutPeer peersStruct$UserOutPeer) {
        peersStruct$UserOutPeer.getClass();
        ensureUsersRefsIsMutable();
        this.usersRefs_.set(i, peersStruct$UserOutPeer);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (S1.a[gVar.ordinal()]) {
            case 1:
                return new Sequence$ResponseGetGroupDifference();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001\b\u0005\u0000\u0005\u0000\u0001\u001b\u0004\u001b\u0005\u001b\u0007\u001b\b\u001b", new Object[]{"updates_", SequenceStruct$GroupUpdateContainer.class, "users_", UsersStruct$User.class, "groups_", GroupsStruct$Group.class, "usersRefs_", PeersStruct$UserOutPeer.class, "groupsRefs_", PeersStruct$GroupOutPeer.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Sequence$ResponseGetGroupDifference.class) {
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

    public PeersStruct$GroupOutPeer getGroupsRefs(int i) {
        return (PeersStruct$GroupOutPeer) this.groupsRefs_.get(i);
    }

    public int getGroupsRefsCount() {
        return this.groupsRefs_.size();
    }

    public List<PeersStruct$GroupOutPeer> getGroupsRefsList() {
        return this.groupsRefs_;
    }

    public InterfaceC11468d35 getGroupsRefsOrBuilder(int i) {
        return (InterfaceC11468d35) this.groupsRefs_.get(i);
    }

    public List<? extends InterfaceC11468d35> getGroupsRefsOrBuilderList() {
        return this.groupsRefs_;
    }

    public SequenceStruct$GroupUpdateContainer getUpdates(int i) {
        return (SequenceStruct$GroupUpdateContainer) this.updates_.get(i);
    }

    public int getUpdatesCount() {
        return this.updates_.size();
    }

    public List<SequenceStruct$GroupUpdateContainer> getUpdatesList() {
        return this.updates_;
    }

    public InterfaceC7888Tp6 getUpdatesOrBuilder(int i) {
        return (InterfaceC7888Tp6) this.updates_.get(i);
    }

    public List<? extends InterfaceC7888Tp6> getUpdatesOrBuilderList() {
        return this.updates_;
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

    public PeersStruct$UserOutPeer getUsersRefs(int i) {
        return (PeersStruct$UserOutPeer) this.usersRefs_.get(i);
    }

    public int getUsersRefsCount() {
        return this.usersRefs_.size();
    }

    public List<PeersStruct$UserOutPeer> getUsersRefsList() {
        return this.usersRefs_;
    }

    public InterfaceC18084o35 getUsersRefsOrBuilder(int i) {
        return (InterfaceC18084o35) this.usersRefs_.get(i);
    }

    public List<? extends InterfaceC18084o35> getUsersRefsOrBuilderList() {
        return this.usersRefs_;
    }

    public static a newBuilder(Sequence$ResponseGetGroupDifference sequence$ResponseGetGroupDifference) {
        return (a) DEFAULT_INSTANCE.createBuilder(sequence$ResponseGetGroupDifference);
    }

    public static Sequence$ResponseGetGroupDifference parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Sequence$ResponseGetGroupDifference) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Sequence$ResponseGetGroupDifference parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Sequence$ResponseGetGroupDifference) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Sequence$ResponseGetGroupDifference parseFrom(AbstractC2383g abstractC2383g) {
        return (Sequence$ResponseGetGroupDifference) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addGroups(int i, GroupsStruct$Group groupsStruct$Group) {
        groupsStruct$Group.getClass();
        ensureGroupsIsMutable();
        this.groups_.add(i, groupsStruct$Group);
    }

    private void addGroupsRefs(int i, PeersStruct$GroupOutPeer peersStruct$GroupOutPeer) {
        peersStruct$GroupOutPeer.getClass();
        ensureGroupsRefsIsMutable();
        this.groupsRefs_.add(i, peersStruct$GroupOutPeer);
    }

    private void addUpdates(int i, SequenceStruct$GroupUpdateContainer sequenceStruct$GroupUpdateContainer) {
        sequenceStruct$GroupUpdateContainer.getClass();
        ensureUpdatesIsMutable();
        this.updates_.add(i, sequenceStruct$GroupUpdateContainer);
    }

    private void addUsers(int i, UsersStruct$User usersStruct$User) {
        usersStruct$User.getClass();
        ensureUsersIsMutable();
        this.users_.add(i, usersStruct$User);
    }

    private void addUsersRefs(int i, PeersStruct$UserOutPeer peersStruct$UserOutPeer) {
        peersStruct$UserOutPeer.getClass();
        ensureUsersRefsIsMutable();
        this.usersRefs_.add(i, peersStruct$UserOutPeer);
    }

    public static Sequence$ResponseGetGroupDifference parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Sequence$ResponseGetGroupDifference) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Sequence$ResponseGetGroupDifference parseFrom(byte[] bArr) {
        return (Sequence$ResponseGetGroupDifference) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Sequence$ResponseGetGroupDifference parseFrom(byte[] bArr, C2394s c2394s) {
        return (Sequence$ResponseGetGroupDifference) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Sequence$ResponseGetGroupDifference parseFrom(InputStream inputStream) {
        return (Sequence$ResponseGetGroupDifference) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Sequence$ResponseGetGroupDifference parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Sequence$ResponseGetGroupDifference) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Sequence$ResponseGetGroupDifference parseFrom(AbstractC2384h abstractC2384h) {
        return (Sequence$ResponseGetGroupDifference) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Sequence$ResponseGetGroupDifference parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Sequence$ResponseGetGroupDifference) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
