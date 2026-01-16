package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class GroupsOuterClass$UpdateGroupMembersCountChanged extends GeneratedMessageLite implements U64 {
    private static final GroupsOuterClass$UpdateGroupMembersCountChanged DEFAULT_INSTANCE;
    public static final int GROUP_ID_FIELD_NUMBER = 1;
    public static final int MEMBERS_COUNT_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER;
    private int groupId_;
    private int membersCount_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(GroupsOuterClass$UpdateGroupMembersCountChanged.DEFAULT_INSTANCE);
        }
    }

    static {
        GroupsOuterClass$UpdateGroupMembersCountChanged groupsOuterClass$UpdateGroupMembersCountChanged = new GroupsOuterClass$UpdateGroupMembersCountChanged();
        DEFAULT_INSTANCE = groupsOuterClass$UpdateGroupMembersCountChanged;
        GeneratedMessageLite.registerDefaultInstance(GroupsOuterClass$UpdateGroupMembersCountChanged.class, groupsOuterClass$UpdateGroupMembersCountChanged);
    }

    private GroupsOuterClass$UpdateGroupMembersCountChanged() {
    }

    private void clearGroupId() {
        this.groupId_ = 0;
    }

    private void clearMembersCount() {
        this.membersCount_ = 0;
    }

    public static GroupsOuterClass$UpdateGroupMembersCountChanged getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static GroupsOuterClass$UpdateGroupMembersCountChanged parseDelimitedFrom(InputStream inputStream) {
        return (GroupsOuterClass$UpdateGroupMembersCountChanged) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GroupsOuterClass$UpdateGroupMembersCountChanged parseFrom(ByteBuffer byteBuffer) {
        return (GroupsOuterClass$UpdateGroupMembersCountChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setGroupId(int i) {
        this.groupId_ = i;
    }

    private void setMembersCount(int i) {
        this.membersCount_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1874m0.a[gVar.ordinal()]) {
            case 1:
                return new GroupsOuterClass$UpdateGroupMembersCountChanged();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0004\u0002\u0004", new Object[]{"groupId_", "membersCount_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (GroupsOuterClass$UpdateGroupMembersCountChanged.class) {
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

    public int getMembersCount() {
        return this.membersCount_;
    }

    public static a newBuilder(GroupsOuterClass$UpdateGroupMembersCountChanged groupsOuterClass$UpdateGroupMembersCountChanged) {
        return (a) DEFAULT_INSTANCE.createBuilder(groupsOuterClass$UpdateGroupMembersCountChanged);
    }

    public static GroupsOuterClass$UpdateGroupMembersCountChanged parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (GroupsOuterClass$UpdateGroupMembersCountChanged) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GroupsOuterClass$UpdateGroupMembersCountChanged parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (GroupsOuterClass$UpdateGroupMembersCountChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static GroupsOuterClass$UpdateGroupMembersCountChanged parseFrom(AbstractC2383g abstractC2383g) {
        return (GroupsOuterClass$UpdateGroupMembersCountChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static GroupsOuterClass$UpdateGroupMembersCountChanged parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (GroupsOuterClass$UpdateGroupMembersCountChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static GroupsOuterClass$UpdateGroupMembersCountChanged parseFrom(byte[] bArr) {
        return (GroupsOuterClass$UpdateGroupMembersCountChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GroupsOuterClass$UpdateGroupMembersCountChanged parseFrom(byte[] bArr, C2394s c2394s) {
        return (GroupsOuterClass$UpdateGroupMembersCountChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static GroupsOuterClass$UpdateGroupMembersCountChanged parseFrom(InputStream inputStream) {
        return (GroupsOuterClass$UpdateGroupMembersCountChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GroupsOuterClass$UpdateGroupMembersCountChanged parseFrom(InputStream inputStream, C2394s c2394s) {
        return (GroupsOuterClass$UpdateGroupMembersCountChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GroupsOuterClass$UpdateGroupMembersCountChanged parseFrom(AbstractC2384h abstractC2384h) {
        return (GroupsOuterClass$UpdateGroupMembersCountChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static GroupsOuterClass$UpdateGroupMembersCountChanged parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (GroupsOuterClass$UpdateGroupMembersCountChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
