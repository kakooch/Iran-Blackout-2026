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
public final class UpdateBoxStruct$WeakFatUpdate extends GeneratedMessageLite implements U64 {
    public static final int DATE_FIELD_NUMBER = 1;
    private static final UpdateBoxStruct$WeakFatUpdate DEFAULT_INSTANCE;
    public static final int GROUPS_FIELD_NUMBER = 5;
    private static volatile KW4 PARSER = null;
    public static final int UPDATE_FIELD_NUMBER = 3;
    public static final int UPDATE_HEADER_FIELD_NUMBER = 2;
    public static final int USERS_FIELD_NUMBER = 4;
    private long date_;
    private int updateHeader_;
    private AbstractC2383g update_ = AbstractC2383g.b;
    private B.j users_ = GeneratedMessageLite.emptyProtobufList();
    private B.j groups_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(UpdateBoxStruct$WeakFatUpdate.DEFAULT_INSTANCE);
        }
    }

    static {
        UpdateBoxStruct$WeakFatUpdate updateBoxStruct$WeakFatUpdate = new UpdateBoxStruct$WeakFatUpdate();
        DEFAULT_INSTANCE = updateBoxStruct$WeakFatUpdate;
        GeneratedMessageLite.registerDefaultInstance(UpdateBoxStruct$WeakFatUpdate.class, updateBoxStruct$WeakFatUpdate);
    }

    private UpdateBoxStruct$WeakFatUpdate() {
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

    private void clearDate() {
        this.date_ = 0L;
    }

    private void clearGroups() {
        this.groups_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearUpdate() {
        this.update_ = getDefaultInstance().getUpdate();
    }

    private void clearUpdateHeader() {
        this.updateHeader_ = 0;
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

    public static UpdateBoxStruct$WeakFatUpdate getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static UpdateBoxStruct$WeakFatUpdate parseDelimitedFrom(InputStream inputStream) {
        return (UpdateBoxStruct$WeakFatUpdate) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UpdateBoxStruct$WeakFatUpdate parseFrom(ByteBuffer byteBuffer) {
        return (UpdateBoxStruct$WeakFatUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
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

    private void setDate(long j) {
        this.date_ = j;
    }

    private void setGroups(int i, GroupsStruct$Group groupsStruct$Group) {
        groupsStruct$Group.getClass();
        ensureGroupsIsMutable();
        this.groups_.set(i, groupsStruct$Group);
    }

    private void setUpdate(AbstractC2383g abstractC2383g) {
        abstractC2383g.getClass();
        this.update_ = abstractC2383g;
    }

    private void setUpdateHeader(int i) {
        this.updateHeader_ = i;
    }

    private void setUsers(int i, UsersStruct$User usersStruct$User) {
        usersStruct$User.getClass();
        ensureUsersIsMutable();
        this.users_.set(i, usersStruct$User);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (o2.a[gVar.ordinal()]) {
            case 1:
                return new UpdateBoxStruct$WeakFatUpdate();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0002\u0000\u0001\u0002\u0002\u0004\u0003\n\u0004\u001b\u0005\u001b", new Object[]{"date_", "updateHeader_", "update_", "users_", UsersStruct$User.class, "groups_", GroupsStruct$Group.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (UpdateBoxStruct$WeakFatUpdate.class) {
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

    public AbstractC2383g getUpdate() {
        return this.update_;
    }

    public int getUpdateHeader() {
        return this.updateHeader_;
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

    public static a newBuilder(UpdateBoxStruct$WeakFatUpdate updateBoxStruct$WeakFatUpdate) {
        return (a) DEFAULT_INSTANCE.createBuilder(updateBoxStruct$WeakFatUpdate);
    }

    public static UpdateBoxStruct$WeakFatUpdate parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (UpdateBoxStruct$WeakFatUpdate) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static UpdateBoxStruct$WeakFatUpdate parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (UpdateBoxStruct$WeakFatUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static UpdateBoxStruct$WeakFatUpdate parseFrom(AbstractC2383g abstractC2383g) {
        return (UpdateBoxStruct$WeakFatUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
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

    public static UpdateBoxStruct$WeakFatUpdate parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (UpdateBoxStruct$WeakFatUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static UpdateBoxStruct$WeakFatUpdate parseFrom(byte[] bArr) {
        return (UpdateBoxStruct$WeakFatUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static UpdateBoxStruct$WeakFatUpdate parseFrom(byte[] bArr, C2394s c2394s) {
        return (UpdateBoxStruct$WeakFatUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static UpdateBoxStruct$WeakFatUpdate parseFrom(InputStream inputStream) {
        return (UpdateBoxStruct$WeakFatUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UpdateBoxStruct$WeakFatUpdate parseFrom(InputStream inputStream, C2394s c2394s) {
        return (UpdateBoxStruct$WeakFatUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static UpdateBoxStruct$WeakFatUpdate parseFrom(AbstractC2384h abstractC2384h) {
        return (UpdateBoxStruct$WeakFatUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static UpdateBoxStruct$WeakFatUpdate parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (UpdateBoxStruct$WeakFatUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
