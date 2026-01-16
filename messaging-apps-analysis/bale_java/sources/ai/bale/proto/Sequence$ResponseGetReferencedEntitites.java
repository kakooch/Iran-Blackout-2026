package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC23748xS2;
import ir.nasim.KW4;
import ir.nasim.OM7;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes.dex */
public final class Sequence$ResponseGetReferencedEntitites extends GeneratedMessageLite implements U64 {
    private static final Sequence$ResponseGetReferencedEntitites DEFAULT_INSTANCE;
    public static final int GROUPS_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int USERS_FIELD_NUMBER = 1;
    private B.j users_ = GeneratedMessageLite.emptyProtobufList();
    private B.j groups_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Sequence$ResponseGetReferencedEntitites.DEFAULT_INSTANCE);
        }
    }

    static {
        Sequence$ResponseGetReferencedEntitites sequence$ResponseGetReferencedEntitites = new Sequence$ResponseGetReferencedEntitites();
        DEFAULT_INSTANCE = sequence$ResponseGetReferencedEntitites;
        GeneratedMessageLite.registerDefaultInstance(Sequence$ResponseGetReferencedEntitites.class, sequence$ResponseGetReferencedEntitites);
    }

    private Sequence$ResponseGetReferencedEntitites() {
    }

    private void addAllGroups(Iterable<? extends GroupsStruct$Group> iterable) {
        ensureGroupsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.groups_);
    }

    private void addAllUsers(Iterable<? extends UsersStruct$User> iterable) {
        ensureUsersIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.users_);
    }

    private void addGroups(GroupsStruct$Group groupsStruct$Group) {
        groupsStruct$Group.getClass();
        ensureGroupsIsMutable();
        this.groups_.add(groupsStruct$Group);
    }

    private void addUsers(UsersStruct$User usersStruct$User) {
        usersStruct$User.getClass();
        ensureUsersIsMutable();
        this.users_.add(usersStruct$User);
    }

    private void clearGroups() {
        this.groups_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearUsers() {
        this.users_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureGroupsIsMutable() {
        B.j jVar = this.groups_;
        if (jVar.u()) {
            return;
        }
        this.groups_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    private void ensureUsersIsMutable() {
        B.j jVar = this.users_;
        if (jVar.u()) {
            return;
        }
        this.users_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static Sequence$ResponseGetReferencedEntitites getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Sequence$ResponseGetReferencedEntitites parseDelimitedFrom(InputStream inputStream) {
        return (Sequence$ResponseGetReferencedEntitites) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Sequence$ResponseGetReferencedEntitites parseFrom(ByteBuffer byteBuffer) {
        return (Sequence$ResponseGetReferencedEntitites) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeGroups(int i) {
        ensureGroupsIsMutable();
        this.groups_.remove(i);
    }

    private void removeUsers(int i) {
        ensureUsersIsMutable();
        this.users_.remove(i);
    }

    private void setGroups(int i, GroupsStruct$Group groupsStruct$Group) {
        groupsStruct$Group.getClass();
        ensureGroupsIsMutable();
        this.groups_.set(i, groupsStruct$Group);
    }

    private void setUsers(int i, UsersStruct$User usersStruct$User) {
        usersStruct$User.getClass();
        ensureUsersIsMutable();
        this.users_.set(i, usersStruct$User);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (S1.a[gVar.ordinal()]) {
            case 1:
                return new Sequence$ResponseGetReferencedEntitites();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0002\u0000\u0001\u001b\u0002\u001b", new Object[]{"users_", UsersStruct$User.class, "groups_", GroupsStruct$Group.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Sequence$ResponseGetReferencedEntitites.class) {
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

    public static a newBuilder(Sequence$ResponseGetReferencedEntitites sequence$ResponseGetReferencedEntitites) {
        return (a) DEFAULT_INSTANCE.createBuilder(sequence$ResponseGetReferencedEntitites);
    }

    public static Sequence$ResponseGetReferencedEntitites parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Sequence$ResponseGetReferencedEntitites) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Sequence$ResponseGetReferencedEntitites parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Sequence$ResponseGetReferencedEntitites) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Sequence$ResponseGetReferencedEntitites parseFrom(AbstractC2383g abstractC2383g) {
        return (Sequence$ResponseGetReferencedEntitites) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addGroups(int i, GroupsStruct$Group groupsStruct$Group) {
        groupsStruct$Group.getClass();
        ensureGroupsIsMutable();
        this.groups_.add(i, groupsStruct$Group);
    }

    private void addUsers(int i, UsersStruct$User usersStruct$User) {
        usersStruct$User.getClass();
        ensureUsersIsMutable();
        this.users_.add(i, usersStruct$User);
    }

    public static Sequence$ResponseGetReferencedEntitites parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Sequence$ResponseGetReferencedEntitites) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Sequence$ResponseGetReferencedEntitites parseFrom(byte[] bArr) {
        return (Sequence$ResponseGetReferencedEntitites) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Sequence$ResponseGetReferencedEntitites parseFrom(byte[] bArr, C2394s c2394s) {
        return (Sequence$ResponseGetReferencedEntitites) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Sequence$ResponseGetReferencedEntitites parseFrom(InputStream inputStream) {
        return (Sequence$ResponseGetReferencedEntitites) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Sequence$ResponseGetReferencedEntitites parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Sequence$ResponseGetReferencedEntitites) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Sequence$ResponseGetReferencedEntitites parseFrom(AbstractC2384h abstractC2384h) {
        return (Sequence$ResponseGetReferencedEntitites) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Sequence$ResponseGetReferencedEntitites parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Sequence$ResponseGetReferencedEntitites) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
