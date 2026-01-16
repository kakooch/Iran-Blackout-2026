package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Int32Value;
import ir.nasim.InterfaceC23748xS2;
import ir.nasim.KW4;
import ir.nasim.OM7;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes.dex */
public final class UpdateBoxStruct$NewFatSeqUpdate extends GeneratedMessageLite implements U64 {
    private static final UpdateBoxStruct$NewFatSeqUpdate DEFAULT_INSTANCE;
    public static final int GROUPS_FIELD_NUMBER = 6;
    private static volatile KW4 PARSER = null;
    public static final int ROUTE_ID_FIELD_NUMBER = 7;
    public static final int SEQ_FIELD_NUMBER = 1;
    public static final int STATE_FIELD_NUMBER = 2;
    public static final int UPDATE_FIELD_NUMBER = 4;
    public static final int UPDATE_HEADER_FIELD_NUMBER = 3;
    public static final int USERS_FIELD_NUMBER = 5;
    private int bitField0_;
    private B.j groups_;
    private Int32Value routeId_;
    private int seq_;
    private AbstractC2383g state_;
    private int updateHeader_;
    private AbstractC2383g update_;
    private B.j users_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(UpdateBoxStruct$NewFatSeqUpdate.DEFAULT_INSTANCE);
        }
    }

    static {
        UpdateBoxStruct$NewFatSeqUpdate updateBoxStruct$NewFatSeqUpdate = new UpdateBoxStruct$NewFatSeqUpdate();
        DEFAULT_INSTANCE = updateBoxStruct$NewFatSeqUpdate;
        GeneratedMessageLite.registerDefaultInstance(UpdateBoxStruct$NewFatSeqUpdate.class, updateBoxStruct$NewFatSeqUpdate);
    }

    private UpdateBoxStruct$NewFatSeqUpdate() {
        AbstractC2383g abstractC2383g = AbstractC2383g.b;
        this.state_ = abstractC2383g;
        this.update_ = abstractC2383g;
        this.users_ = GeneratedMessageLite.emptyProtobufList();
        this.groups_ = GeneratedMessageLite.emptyProtobufList();
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

    private void clearRouteId() {
        this.routeId_ = null;
        this.bitField0_ &= -2;
    }

    private void clearSeq() {
        this.seq_ = 0;
    }

    private void clearState() {
        this.state_ = getDefaultInstance().getState();
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

    public static UpdateBoxStruct$NewFatSeqUpdate getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeRouteId(Int32Value int32Value) {
        int32Value.getClass();
        Int32Value int32Value2 = this.routeId_;
        if (int32Value2 == null || int32Value2 == Int32Value.getDefaultInstance()) {
            this.routeId_ = int32Value;
        } else {
            this.routeId_ = (Int32Value) ((Int32Value.b) Int32Value.newBuilder(this.routeId_).v(int32Value)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static UpdateBoxStruct$NewFatSeqUpdate parseDelimitedFrom(InputStream inputStream) {
        return (UpdateBoxStruct$NewFatSeqUpdate) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UpdateBoxStruct$NewFatSeqUpdate parseFrom(ByteBuffer byteBuffer) {
        return (UpdateBoxStruct$NewFatSeqUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
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

    private void setRouteId(Int32Value int32Value) {
        int32Value.getClass();
        this.routeId_ = int32Value;
        this.bitField0_ |= 1;
    }

    private void setSeq(int i) {
        this.seq_ = i;
    }

    private void setState(AbstractC2383g abstractC2383g) {
        abstractC2383g.getClass();
        this.state_ = abstractC2383g;
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
                return new UpdateBoxStruct$NewFatSeqUpdate();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0002\u0000\u0001\u0004\u0002\n\u0003\u0004\u0004\n\u0005\u001b\u0006\u001b\u0007ဉ\u0000", new Object[]{"bitField0_", "seq_", "state_", "updateHeader_", "update_", "users_", UsersStruct$User.class, "groups_", GroupsStruct$Group.class, "routeId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (UpdateBoxStruct$NewFatSeqUpdate.class) {
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

    public Int32Value getRouteId() {
        Int32Value int32Value = this.routeId_;
        return int32Value == null ? Int32Value.getDefaultInstance() : int32Value;
    }

    public int getSeq() {
        return this.seq_;
    }

    public AbstractC2383g getState() {
        return this.state_;
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

    public boolean hasRouteId() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(UpdateBoxStruct$NewFatSeqUpdate updateBoxStruct$NewFatSeqUpdate) {
        return (a) DEFAULT_INSTANCE.createBuilder(updateBoxStruct$NewFatSeqUpdate);
    }

    public static UpdateBoxStruct$NewFatSeqUpdate parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (UpdateBoxStruct$NewFatSeqUpdate) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static UpdateBoxStruct$NewFatSeqUpdate parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (UpdateBoxStruct$NewFatSeqUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static UpdateBoxStruct$NewFatSeqUpdate parseFrom(AbstractC2383g abstractC2383g) {
        return (UpdateBoxStruct$NewFatSeqUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
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

    public static UpdateBoxStruct$NewFatSeqUpdate parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (UpdateBoxStruct$NewFatSeqUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static UpdateBoxStruct$NewFatSeqUpdate parseFrom(byte[] bArr) {
        return (UpdateBoxStruct$NewFatSeqUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static UpdateBoxStruct$NewFatSeqUpdate parseFrom(byte[] bArr, C2394s c2394s) {
        return (UpdateBoxStruct$NewFatSeqUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static UpdateBoxStruct$NewFatSeqUpdate parseFrom(InputStream inputStream) {
        return (UpdateBoxStruct$NewFatSeqUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UpdateBoxStruct$NewFatSeqUpdate parseFrom(InputStream inputStream, C2394s c2394s) {
        return (UpdateBoxStruct$NewFatSeqUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static UpdateBoxStruct$NewFatSeqUpdate parseFrom(AbstractC2384h abstractC2384h) {
        return (UpdateBoxStruct$NewFatSeqUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static UpdateBoxStruct$NewFatSeqUpdate parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (UpdateBoxStruct$NewFatSeqUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
