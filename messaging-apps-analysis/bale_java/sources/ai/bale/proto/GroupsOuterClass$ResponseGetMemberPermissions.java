package ai.bale.proto;

import ai.bale.proto.GroupsStruct$Permissions;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class GroupsOuterClass$ResponseGetMemberPermissions extends GeneratedMessageLite implements U64 {
    private static final GroupsOuterClass$ResponseGetMemberPermissions DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int PERMISSIONS_FIELD_NUMBER = 1;
    private int bitField0_;
    private GroupsStruct$Permissions permissions_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(GroupsOuterClass$ResponseGetMemberPermissions.DEFAULT_INSTANCE);
        }
    }

    static {
        GroupsOuterClass$ResponseGetMemberPermissions groupsOuterClass$ResponseGetMemberPermissions = new GroupsOuterClass$ResponseGetMemberPermissions();
        DEFAULT_INSTANCE = groupsOuterClass$ResponseGetMemberPermissions;
        GeneratedMessageLite.registerDefaultInstance(GroupsOuterClass$ResponseGetMemberPermissions.class, groupsOuterClass$ResponseGetMemberPermissions);
    }

    private GroupsOuterClass$ResponseGetMemberPermissions() {
    }

    private void clearPermissions() {
        this.permissions_ = null;
        this.bitField0_ &= -2;
    }

    public static GroupsOuterClass$ResponseGetMemberPermissions getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergePermissions(GroupsStruct$Permissions groupsStruct$Permissions) {
        groupsStruct$Permissions.getClass();
        GroupsStruct$Permissions groupsStruct$Permissions2 = this.permissions_;
        if (groupsStruct$Permissions2 == null || groupsStruct$Permissions2 == GroupsStruct$Permissions.getDefaultInstance()) {
            this.permissions_ = groupsStruct$Permissions;
        } else {
            this.permissions_ = (GroupsStruct$Permissions) ((GroupsStruct$Permissions.a) GroupsStruct$Permissions.newBuilder(this.permissions_).v(groupsStruct$Permissions)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static GroupsOuterClass$ResponseGetMemberPermissions parseDelimitedFrom(InputStream inputStream) {
        return (GroupsOuterClass$ResponseGetMemberPermissions) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GroupsOuterClass$ResponseGetMemberPermissions parseFrom(ByteBuffer byteBuffer) {
        return (GroupsOuterClass$ResponseGetMemberPermissions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setPermissions(GroupsStruct$Permissions groupsStruct$Permissions) {
        groupsStruct$Permissions.getClass();
        this.permissions_ = groupsStruct$Permissions;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1874m0.a[gVar.ordinal()]) {
            case 1:
                return new GroupsOuterClass$ResponseGetMemberPermissions();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "permissions_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (GroupsOuterClass$ResponseGetMemberPermissions.class) {
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

    public GroupsStruct$Permissions getPermissions() {
        GroupsStruct$Permissions groupsStruct$Permissions = this.permissions_;
        return groupsStruct$Permissions == null ? GroupsStruct$Permissions.getDefaultInstance() : groupsStruct$Permissions;
    }

    public boolean hasPermissions() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(GroupsOuterClass$ResponseGetMemberPermissions groupsOuterClass$ResponseGetMemberPermissions) {
        return (a) DEFAULT_INSTANCE.createBuilder(groupsOuterClass$ResponseGetMemberPermissions);
    }

    public static GroupsOuterClass$ResponseGetMemberPermissions parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (GroupsOuterClass$ResponseGetMemberPermissions) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GroupsOuterClass$ResponseGetMemberPermissions parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (GroupsOuterClass$ResponseGetMemberPermissions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static GroupsOuterClass$ResponseGetMemberPermissions parseFrom(AbstractC2383g abstractC2383g) {
        return (GroupsOuterClass$ResponseGetMemberPermissions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static GroupsOuterClass$ResponseGetMemberPermissions parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (GroupsOuterClass$ResponseGetMemberPermissions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static GroupsOuterClass$ResponseGetMemberPermissions parseFrom(byte[] bArr) {
        return (GroupsOuterClass$ResponseGetMemberPermissions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GroupsOuterClass$ResponseGetMemberPermissions parseFrom(byte[] bArr, C2394s c2394s) {
        return (GroupsOuterClass$ResponseGetMemberPermissions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static GroupsOuterClass$ResponseGetMemberPermissions parseFrom(InputStream inputStream) {
        return (GroupsOuterClass$ResponseGetMemberPermissions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GroupsOuterClass$ResponseGetMemberPermissions parseFrom(InputStream inputStream, C2394s c2394s) {
        return (GroupsOuterClass$ResponseGetMemberPermissions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GroupsOuterClass$ResponseGetMemberPermissions parseFrom(AbstractC2384h abstractC2384h) {
        return (GroupsOuterClass$ResponseGetMemberPermissions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static GroupsOuterClass$ResponseGetMemberPermissions parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (GroupsOuterClass$ResponseGetMemberPermissions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
