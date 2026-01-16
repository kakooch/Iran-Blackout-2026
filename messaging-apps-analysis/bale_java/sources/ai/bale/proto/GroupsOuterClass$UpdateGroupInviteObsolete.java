package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Int32Value;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class GroupsOuterClass$UpdateGroupInviteObsolete extends GeneratedMessageLite implements U64 {
    public static final int DATE_FIELD_NUMBER = 8;
    private static final GroupsOuterClass$UpdateGroupInviteObsolete DEFAULT_INSTANCE;
    public static final int GROUP_ID_FIELD_NUMBER = 1;
    public static final int INVITE_UID_FIELD_NUMBER = 5;
    public static final int IS_JOINED_FIELD_NUMBER = 11;
    private static volatile KW4 PARSER = null;
    public static final int RID_FIELD_NUMBER = 9;
    public static final int SEQ_FIELD_NUMBER = 10;
    private int bitField0_;
    private long date_;
    private int groupId_;
    private int inviteUid_;
    private boolean isJoined_;
    private long rid_;
    private Int32Value seq_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(GroupsOuterClass$UpdateGroupInviteObsolete.DEFAULT_INSTANCE);
        }
    }

    static {
        GroupsOuterClass$UpdateGroupInviteObsolete groupsOuterClass$UpdateGroupInviteObsolete = new GroupsOuterClass$UpdateGroupInviteObsolete();
        DEFAULT_INSTANCE = groupsOuterClass$UpdateGroupInviteObsolete;
        GeneratedMessageLite.registerDefaultInstance(GroupsOuterClass$UpdateGroupInviteObsolete.class, groupsOuterClass$UpdateGroupInviteObsolete);
    }

    private GroupsOuterClass$UpdateGroupInviteObsolete() {
    }

    private void clearDate() {
        this.date_ = 0L;
    }

    private void clearGroupId() {
        this.groupId_ = 0;
    }

    private void clearInviteUid() {
        this.inviteUid_ = 0;
    }

    private void clearIsJoined() {
        this.isJoined_ = false;
    }

    private void clearRid() {
        this.rid_ = 0L;
    }

    private void clearSeq() {
        this.seq_ = null;
        this.bitField0_ &= -2;
    }

    public static GroupsOuterClass$UpdateGroupInviteObsolete getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeSeq(Int32Value int32Value) {
        int32Value.getClass();
        Int32Value int32Value2 = this.seq_;
        if (int32Value2 == null || int32Value2 == Int32Value.getDefaultInstance()) {
            this.seq_ = int32Value;
        } else {
            this.seq_ = (Int32Value) ((Int32Value.b) Int32Value.newBuilder(this.seq_).v(int32Value)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static GroupsOuterClass$UpdateGroupInviteObsolete parseDelimitedFrom(InputStream inputStream) {
        return (GroupsOuterClass$UpdateGroupInviteObsolete) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GroupsOuterClass$UpdateGroupInviteObsolete parseFrom(ByteBuffer byteBuffer) {
        return (GroupsOuterClass$UpdateGroupInviteObsolete) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
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

    private void setInviteUid(int i) {
        this.inviteUid_ = i;
    }

    private void setIsJoined(boolean z) {
        this.isJoined_ = z;
    }

    private void setRid(long j) {
        this.rid_ = j;
    }

    private void setSeq(Int32Value int32Value) {
        int32Value.getClass();
        this.seq_ = int32Value;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1874m0.a[gVar.ordinal()]) {
            case 1:
                return new GroupsOuterClass$UpdateGroupInviteObsolete();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0006\u0000\u0001\u0001\u000b\u0006\u0000\u0000\u0000\u0001\u0004\u0005\u0004\b\u0002\t\u0002\nဉ\u0000\u000b\u0007", new Object[]{"bitField0_", "groupId_", "inviteUid_", "date_", "rid_", "seq_", "isJoined_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (GroupsOuterClass$UpdateGroupInviteObsolete.class) {
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

    public int getInviteUid() {
        return this.inviteUid_;
    }

    public boolean getIsJoined() {
        return this.isJoined_;
    }

    public long getRid() {
        return this.rid_;
    }

    public Int32Value getSeq() {
        Int32Value int32Value = this.seq_;
        return int32Value == null ? Int32Value.getDefaultInstance() : int32Value;
    }

    public boolean hasSeq() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(GroupsOuterClass$UpdateGroupInviteObsolete groupsOuterClass$UpdateGroupInviteObsolete) {
        return (a) DEFAULT_INSTANCE.createBuilder(groupsOuterClass$UpdateGroupInviteObsolete);
    }

    public static GroupsOuterClass$UpdateGroupInviteObsolete parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (GroupsOuterClass$UpdateGroupInviteObsolete) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GroupsOuterClass$UpdateGroupInviteObsolete parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (GroupsOuterClass$UpdateGroupInviteObsolete) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static GroupsOuterClass$UpdateGroupInviteObsolete parseFrom(AbstractC2383g abstractC2383g) {
        return (GroupsOuterClass$UpdateGroupInviteObsolete) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static GroupsOuterClass$UpdateGroupInviteObsolete parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (GroupsOuterClass$UpdateGroupInviteObsolete) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static GroupsOuterClass$UpdateGroupInviteObsolete parseFrom(byte[] bArr) {
        return (GroupsOuterClass$UpdateGroupInviteObsolete) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GroupsOuterClass$UpdateGroupInviteObsolete parseFrom(byte[] bArr, C2394s c2394s) {
        return (GroupsOuterClass$UpdateGroupInviteObsolete) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static GroupsOuterClass$UpdateGroupInviteObsolete parseFrom(InputStream inputStream) {
        return (GroupsOuterClass$UpdateGroupInviteObsolete) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GroupsOuterClass$UpdateGroupInviteObsolete parseFrom(InputStream inputStream, C2394s c2394s) {
        return (GroupsOuterClass$UpdateGroupInviteObsolete) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GroupsOuterClass$UpdateGroupInviteObsolete parseFrom(AbstractC2384h abstractC2384h) {
        return (GroupsOuterClass$UpdateGroupInviteObsolete) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static GroupsOuterClass$UpdateGroupInviteObsolete parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (GroupsOuterClass$UpdateGroupInviteObsolete) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
