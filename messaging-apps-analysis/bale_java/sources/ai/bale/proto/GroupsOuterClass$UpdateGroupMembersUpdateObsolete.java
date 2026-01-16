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
public final class GroupsOuterClass$UpdateGroupMembersUpdateObsolete extends GeneratedMessageLite implements U64 {
    private static final GroupsOuterClass$UpdateGroupMembersUpdateObsolete DEFAULT_INSTANCE;
    public static final int GROUP_ID_FIELD_NUMBER = 1;
    public static final int MEMBERS_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER;
    private int groupId_;
    private B.j members_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(GroupsOuterClass$UpdateGroupMembersUpdateObsolete.DEFAULT_INSTANCE);
        }
    }

    static {
        GroupsOuterClass$UpdateGroupMembersUpdateObsolete groupsOuterClass$UpdateGroupMembersUpdateObsolete = new GroupsOuterClass$UpdateGroupMembersUpdateObsolete();
        DEFAULT_INSTANCE = groupsOuterClass$UpdateGroupMembersUpdateObsolete;
        GeneratedMessageLite.registerDefaultInstance(GroupsOuterClass$UpdateGroupMembersUpdateObsolete.class, groupsOuterClass$UpdateGroupMembersUpdateObsolete);
    }

    private GroupsOuterClass$UpdateGroupMembersUpdateObsolete() {
    }

    private void addAllMembers(Iterable<? extends GroupsStruct$Member> iterable) {
        ensureMembersIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.members_);
    }

    private void addMembers(GroupsStruct$Member groupsStruct$Member) {
        groupsStruct$Member.getClass();
        ensureMembersIsMutable();
        this.members_.add(groupsStruct$Member);
    }

    private void clearGroupId() {
        this.groupId_ = 0;
    }

    private void clearMembers() {
        this.members_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureMembersIsMutable() {
        B.j jVar = this.members_;
        if (jVar.u()) {
            return;
        }
        this.members_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static GroupsOuterClass$UpdateGroupMembersUpdateObsolete getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static GroupsOuterClass$UpdateGroupMembersUpdateObsolete parseDelimitedFrom(InputStream inputStream) {
        return (GroupsOuterClass$UpdateGroupMembersUpdateObsolete) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GroupsOuterClass$UpdateGroupMembersUpdateObsolete parseFrom(ByteBuffer byteBuffer) {
        return (GroupsOuterClass$UpdateGroupMembersUpdateObsolete) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeMembers(int i) {
        ensureMembersIsMutable();
        this.members_.remove(i);
    }

    private void setGroupId(int i) {
        this.groupId_ = i;
    }

    private void setMembers(int i, GroupsStruct$Member groupsStruct$Member) {
        groupsStruct$Member.getClass();
        ensureMembersIsMutable();
        this.members_.set(i, groupsStruct$Member);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1874m0.a[gVar.ordinal()]) {
            case 1:
                return new GroupsOuterClass$UpdateGroupMembersUpdateObsolete();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u0004\u0002\u001b", new Object[]{"groupId_", "members_", GroupsStruct$Member.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (GroupsOuterClass$UpdateGroupMembersUpdateObsolete.class) {
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

    public int getGroupId() {
        return this.groupId_;
    }

    public GroupsStruct$Member getMembers(int i) {
        return (GroupsStruct$Member) this.members_.get(i);
    }

    public int getMembersCount() {
        return this.members_.size();
    }

    public List<GroupsStruct$Member> getMembersList() {
        return this.members_;
    }

    public CS2 getMembersOrBuilder(int i) {
        return (CS2) this.members_.get(i);
    }

    public List<? extends CS2> getMembersOrBuilderList() {
        return this.members_;
    }

    public static a newBuilder(GroupsOuterClass$UpdateGroupMembersUpdateObsolete groupsOuterClass$UpdateGroupMembersUpdateObsolete) {
        return (a) DEFAULT_INSTANCE.createBuilder(groupsOuterClass$UpdateGroupMembersUpdateObsolete);
    }

    public static GroupsOuterClass$UpdateGroupMembersUpdateObsolete parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (GroupsOuterClass$UpdateGroupMembersUpdateObsolete) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GroupsOuterClass$UpdateGroupMembersUpdateObsolete parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (GroupsOuterClass$UpdateGroupMembersUpdateObsolete) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static GroupsOuterClass$UpdateGroupMembersUpdateObsolete parseFrom(AbstractC2383g abstractC2383g) {
        return (GroupsOuterClass$UpdateGroupMembersUpdateObsolete) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addMembers(int i, GroupsStruct$Member groupsStruct$Member) {
        groupsStruct$Member.getClass();
        ensureMembersIsMutable();
        this.members_.add(i, groupsStruct$Member);
    }

    public static GroupsOuterClass$UpdateGroupMembersUpdateObsolete parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (GroupsOuterClass$UpdateGroupMembersUpdateObsolete) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static GroupsOuterClass$UpdateGroupMembersUpdateObsolete parseFrom(byte[] bArr) {
        return (GroupsOuterClass$UpdateGroupMembersUpdateObsolete) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GroupsOuterClass$UpdateGroupMembersUpdateObsolete parseFrom(byte[] bArr, C2394s c2394s) {
        return (GroupsOuterClass$UpdateGroupMembersUpdateObsolete) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static GroupsOuterClass$UpdateGroupMembersUpdateObsolete parseFrom(InputStream inputStream) {
        return (GroupsOuterClass$UpdateGroupMembersUpdateObsolete) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GroupsOuterClass$UpdateGroupMembersUpdateObsolete parseFrom(InputStream inputStream, C2394s c2394s) {
        return (GroupsOuterClass$UpdateGroupMembersUpdateObsolete) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GroupsOuterClass$UpdateGroupMembersUpdateObsolete parseFrom(AbstractC2384h abstractC2384h) {
        return (GroupsOuterClass$UpdateGroupMembersUpdateObsolete) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static GroupsOuterClass$UpdateGroupMembersUpdateObsolete parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (GroupsOuterClass$UpdateGroupMembersUpdateObsolete) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
