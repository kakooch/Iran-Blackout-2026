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
public final class GroupsOuterClass$UpdateGroupUserInvitedObsolete extends GeneratedMessageLite implements U64 {
    public static final int DATE_FIELD_NUMBER = 4;
    private static final GroupsOuterClass$UpdateGroupUserInvitedObsolete DEFAULT_INSTANCE;
    public static final int GROUP_ID_FIELD_NUMBER = 1;
    public static final int INVITER_UID_FIELD_NUMBER = 3;
    public static final int IS_JOINED_FIELD_NUMBER = 6;
    private static volatile KW4 PARSER = null;
    public static final int RID_FIELD_NUMBER = 5;
    public static final int UID_FIELD_NUMBER = 2;
    private long date_;
    private int groupId_;
    private int inviterUid_;
    private boolean isJoined_;
    private long rid_;
    private int uid_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(GroupsOuterClass$UpdateGroupUserInvitedObsolete.DEFAULT_INSTANCE);
        }
    }

    static {
        GroupsOuterClass$UpdateGroupUserInvitedObsolete groupsOuterClass$UpdateGroupUserInvitedObsolete = new GroupsOuterClass$UpdateGroupUserInvitedObsolete();
        DEFAULT_INSTANCE = groupsOuterClass$UpdateGroupUserInvitedObsolete;
        GeneratedMessageLite.registerDefaultInstance(GroupsOuterClass$UpdateGroupUserInvitedObsolete.class, groupsOuterClass$UpdateGroupUserInvitedObsolete);
    }

    private GroupsOuterClass$UpdateGroupUserInvitedObsolete() {
    }

    private void clearDate() {
        this.date_ = 0L;
    }

    private void clearGroupId() {
        this.groupId_ = 0;
    }

    private void clearInviterUid() {
        this.inviterUid_ = 0;
    }

    private void clearIsJoined() {
        this.isJoined_ = false;
    }

    private void clearRid() {
        this.rid_ = 0L;
    }

    private void clearUid() {
        this.uid_ = 0;
    }

    public static GroupsOuterClass$UpdateGroupUserInvitedObsolete getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static GroupsOuterClass$UpdateGroupUserInvitedObsolete parseDelimitedFrom(InputStream inputStream) {
        return (GroupsOuterClass$UpdateGroupUserInvitedObsolete) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GroupsOuterClass$UpdateGroupUserInvitedObsolete parseFrom(ByteBuffer byteBuffer) {
        return (GroupsOuterClass$UpdateGroupUserInvitedObsolete) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setDate(long j) {
        this.date_ = j;
    }

    private void setGroupId(int i) {
        this.groupId_ = i;
    }

    private void setInviterUid(int i) {
        this.inviterUid_ = i;
    }

    private void setIsJoined(boolean z) {
        this.isJoined_ = z;
    }

    private void setRid(long j) {
        this.rid_ = j;
    }

    private void setUid(int i) {
        this.uid_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1874m0.a[gVar.ordinal()]) {
            case 1:
                return new GroupsOuterClass$UpdateGroupUserInvitedObsolete();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0006\u0000\u0000\u0001\u0006\u0006\u0000\u0000\u0000\u0001\u0004\u0002\u0004\u0003\u0004\u0004\u0002\u0005\u0002\u0006\u0007", new Object[]{"groupId_", "uid_", "inviterUid_", "date_", "rid_", "isJoined_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (GroupsOuterClass$UpdateGroupUserInvitedObsolete.class) {
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

    public int getGroupId() {
        return this.groupId_;
    }

    public int getInviterUid() {
        return this.inviterUid_;
    }

    public boolean getIsJoined() {
        return this.isJoined_;
    }

    public long getRid() {
        return this.rid_;
    }

    public int getUid() {
        return this.uid_;
    }

    public static a newBuilder(GroupsOuterClass$UpdateGroupUserInvitedObsolete groupsOuterClass$UpdateGroupUserInvitedObsolete) {
        return (a) DEFAULT_INSTANCE.createBuilder(groupsOuterClass$UpdateGroupUserInvitedObsolete);
    }

    public static GroupsOuterClass$UpdateGroupUserInvitedObsolete parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (GroupsOuterClass$UpdateGroupUserInvitedObsolete) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GroupsOuterClass$UpdateGroupUserInvitedObsolete parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (GroupsOuterClass$UpdateGroupUserInvitedObsolete) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static GroupsOuterClass$UpdateGroupUserInvitedObsolete parseFrom(AbstractC2383g abstractC2383g) {
        return (GroupsOuterClass$UpdateGroupUserInvitedObsolete) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static GroupsOuterClass$UpdateGroupUserInvitedObsolete parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (GroupsOuterClass$UpdateGroupUserInvitedObsolete) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static GroupsOuterClass$UpdateGroupUserInvitedObsolete parseFrom(byte[] bArr) {
        return (GroupsOuterClass$UpdateGroupUserInvitedObsolete) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GroupsOuterClass$UpdateGroupUserInvitedObsolete parseFrom(byte[] bArr, C2394s c2394s) {
        return (GroupsOuterClass$UpdateGroupUserInvitedObsolete) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static GroupsOuterClass$UpdateGroupUserInvitedObsolete parseFrom(InputStream inputStream) {
        return (GroupsOuterClass$UpdateGroupUserInvitedObsolete) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GroupsOuterClass$UpdateGroupUserInvitedObsolete parseFrom(InputStream inputStream, C2394s c2394s) {
        return (GroupsOuterClass$UpdateGroupUserInvitedObsolete) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GroupsOuterClass$UpdateGroupUserInvitedObsolete parseFrom(AbstractC2384h abstractC2384h) {
        return (GroupsOuterClass$UpdateGroupUserInvitedObsolete) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static GroupsOuterClass$UpdateGroupUserInvitedObsolete parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (GroupsOuterClass$UpdateGroupUserInvitedObsolete) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
