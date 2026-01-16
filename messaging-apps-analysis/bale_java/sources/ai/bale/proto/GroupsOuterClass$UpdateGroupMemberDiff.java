package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.CS2;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class GroupsOuterClass$UpdateGroupMemberDiff extends GeneratedMessageLite implements U64 {
    public static final int ADDED_MEMBERS_FIELD_NUMBER = 2;
    private static final GroupsOuterClass$UpdateGroupMemberDiff DEFAULT_INSTANCE;
    public static final int MEMBERS_COUNT_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER = null;
    public static final int REMOVED_USERS_FIELD_NUMBER = 1;
    private int membersCount_;
    private int removedUsersMemoizedSerializedSize = -1;
    private B.g removedUsers_ = GeneratedMessageLite.emptyIntList();
    private B.j addedMembers_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(GroupsOuterClass$UpdateGroupMemberDiff.DEFAULT_INSTANCE);
        }
    }

    static {
        GroupsOuterClass$UpdateGroupMemberDiff groupsOuterClass$UpdateGroupMemberDiff = new GroupsOuterClass$UpdateGroupMemberDiff();
        DEFAULT_INSTANCE = groupsOuterClass$UpdateGroupMemberDiff;
        GeneratedMessageLite.registerDefaultInstance(GroupsOuterClass$UpdateGroupMemberDiff.class, groupsOuterClass$UpdateGroupMemberDiff);
    }

    private GroupsOuterClass$UpdateGroupMemberDiff() {
    }

    private void addAddedMembers(GroupsStruct$Member groupsStruct$Member) {
        groupsStruct$Member.getClass();
        ensureAddedMembersIsMutable();
        this.addedMembers_.add(groupsStruct$Member);
    }

    private void addAllAddedMembers(Iterable<? extends GroupsStruct$Member> iterable) {
        ensureAddedMembersIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.addedMembers_);
    }

    private void addAllRemovedUsers(Iterable<? extends Integer> iterable) {
        ensureRemovedUsersIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.removedUsers_);
    }

    private void addRemovedUsers(int i) {
        ensureRemovedUsersIsMutable();
        this.removedUsers_.b1(i);
    }

    private void clearAddedMembers() {
        this.addedMembers_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearMembersCount() {
        this.membersCount_ = 0;
    }

    private void clearRemovedUsers() {
        this.removedUsers_ = GeneratedMessageLite.emptyIntList();
    }

    private void ensureAddedMembersIsMutable() {
        B.j jVar = this.addedMembers_;
        if (jVar.u()) {
            return;
        }
        this.addedMembers_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    private void ensureRemovedUsersIsMutable() {
        B.g gVar = this.removedUsers_;
        if (gVar.u()) {
            return;
        }
        this.removedUsers_ = GeneratedMessageLite.mutableCopy(gVar);
    }

    public static GroupsOuterClass$UpdateGroupMemberDiff getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static GroupsOuterClass$UpdateGroupMemberDiff parseDelimitedFrom(InputStream inputStream) {
        return (GroupsOuterClass$UpdateGroupMemberDiff) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GroupsOuterClass$UpdateGroupMemberDiff parseFrom(ByteBuffer byteBuffer) {
        return (GroupsOuterClass$UpdateGroupMemberDiff) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeAddedMembers(int i) {
        ensureAddedMembersIsMutable();
        this.addedMembers_.remove(i);
    }

    private void setAddedMembers(int i, GroupsStruct$Member groupsStruct$Member) {
        groupsStruct$Member.getClass();
        ensureAddedMembersIsMutable();
        this.addedMembers_.set(i, groupsStruct$Member);
    }

    private void setMembersCount(int i) {
        this.membersCount_ = i;
    }

    private void setRemovedUsers(int i, int i2) {
        ensureRemovedUsersIsMutable();
        this.removedUsers_.U(i, i2);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1874m0.a[gVar.ordinal()]) {
            case 1:
                return new GroupsOuterClass$UpdateGroupMemberDiff();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0002\u0000\u0001'\u0002\u001b\u0003\u0004", new Object[]{"removedUsers_", "addedMembers_", GroupsStruct$Member.class, "membersCount_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (GroupsOuterClass$UpdateGroupMemberDiff.class) {
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

    public GroupsStruct$Member getAddedMembers(int i) {
        return (GroupsStruct$Member) this.addedMembers_.get(i);
    }

    public int getAddedMembersCount() {
        return this.addedMembers_.size();
    }

    public List<GroupsStruct$Member> getAddedMembersList() {
        return this.addedMembers_;
    }

    public CS2 getAddedMembersOrBuilder(int i) {
        return (CS2) this.addedMembers_.get(i);
    }

    public List<? extends CS2> getAddedMembersOrBuilderList() {
        return this.addedMembers_;
    }

    public int getMembersCount() {
        return this.membersCount_;
    }

    public int getRemovedUsers(int i) {
        return this.removedUsers_.getInt(i);
    }

    public int getRemovedUsersCount() {
        return this.removedUsers_.size();
    }

    public List<Integer> getRemovedUsersList() {
        return this.removedUsers_;
    }

    public static a newBuilder(GroupsOuterClass$UpdateGroupMemberDiff groupsOuterClass$UpdateGroupMemberDiff) {
        return (a) DEFAULT_INSTANCE.createBuilder(groupsOuterClass$UpdateGroupMemberDiff);
    }

    public static GroupsOuterClass$UpdateGroupMemberDiff parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (GroupsOuterClass$UpdateGroupMemberDiff) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GroupsOuterClass$UpdateGroupMemberDiff parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (GroupsOuterClass$UpdateGroupMemberDiff) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static GroupsOuterClass$UpdateGroupMemberDiff parseFrom(AbstractC2383g abstractC2383g) {
        return (GroupsOuterClass$UpdateGroupMemberDiff) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addAddedMembers(int i, GroupsStruct$Member groupsStruct$Member) {
        groupsStruct$Member.getClass();
        ensureAddedMembersIsMutable();
        this.addedMembers_.add(i, groupsStruct$Member);
    }

    public static GroupsOuterClass$UpdateGroupMemberDiff parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (GroupsOuterClass$UpdateGroupMemberDiff) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static GroupsOuterClass$UpdateGroupMemberDiff parseFrom(byte[] bArr) {
        return (GroupsOuterClass$UpdateGroupMemberDiff) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GroupsOuterClass$UpdateGroupMemberDiff parseFrom(byte[] bArr, C2394s c2394s) {
        return (GroupsOuterClass$UpdateGroupMemberDiff) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static GroupsOuterClass$UpdateGroupMemberDiff parseFrom(InputStream inputStream) {
        return (GroupsOuterClass$UpdateGroupMemberDiff) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GroupsOuterClass$UpdateGroupMemberDiff parseFrom(InputStream inputStream, C2394s c2394s) {
        return (GroupsOuterClass$UpdateGroupMemberDiff) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GroupsOuterClass$UpdateGroupMemberDiff parseFrom(AbstractC2384h abstractC2384h) {
        return (GroupsOuterClass$UpdateGroupMemberDiff) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static GroupsOuterClass$UpdateGroupMemberDiff parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (GroupsOuterClass$UpdateGroupMemberDiff) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
