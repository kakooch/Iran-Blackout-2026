package ai.bale.proto;

import ai.bale.proto.GroupsStruct$Permissions;
import ai.bale.proto.PeersStruct$GroupOutPeer;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class GroupsOuterClass$UpdateGroupDefaultPermissionsChanged extends GeneratedMessageLite implements U64 {
    private static final GroupsOuterClass$UpdateGroupDefaultPermissionsChanged DEFAULT_INSTANCE;
    public static final int GROUP_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int PERMISSIONS_FIELD_NUMBER = 2;
    private int bitField0_;
    private PeersStruct$GroupOutPeer group_;
    private GroupsStruct$Permissions permissions_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(GroupsOuterClass$UpdateGroupDefaultPermissionsChanged.DEFAULT_INSTANCE);
        }
    }

    static {
        GroupsOuterClass$UpdateGroupDefaultPermissionsChanged groupsOuterClass$UpdateGroupDefaultPermissionsChanged = new GroupsOuterClass$UpdateGroupDefaultPermissionsChanged();
        DEFAULT_INSTANCE = groupsOuterClass$UpdateGroupDefaultPermissionsChanged;
        GeneratedMessageLite.registerDefaultInstance(GroupsOuterClass$UpdateGroupDefaultPermissionsChanged.class, groupsOuterClass$UpdateGroupDefaultPermissionsChanged);
    }

    private GroupsOuterClass$UpdateGroupDefaultPermissionsChanged() {
    }

    private void clearGroup() {
        this.group_ = null;
        this.bitField0_ &= -2;
    }

    private void clearPermissions() {
        this.permissions_ = null;
        this.bitField0_ &= -3;
    }

    public static GroupsOuterClass$UpdateGroupDefaultPermissionsChanged getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeGroup(PeersStruct$GroupOutPeer peersStruct$GroupOutPeer) {
        peersStruct$GroupOutPeer.getClass();
        PeersStruct$GroupOutPeer peersStruct$GroupOutPeer2 = this.group_;
        if (peersStruct$GroupOutPeer2 == null || peersStruct$GroupOutPeer2 == PeersStruct$GroupOutPeer.getDefaultInstance()) {
            this.group_ = peersStruct$GroupOutPeer;
        } else {
            this.group_ = (PeersStruct$GroupOutPeer) ((PeersStruct$GroupOutPeer.a) PeersStruct$GroupOutPeer.newBuilder(this.group_).v(peersStruct$GroupOutPeer)).j();
        }
        this.bitField0_ |= 1;
    }

    private void mergePermissions(GroupsStruct$Permissions groupsStruct$Permissions) {
        groupsStruct$Permissions.getClass();
        GroupsStruct$Permissions groupsStruct$Permissions2 = this.permissions_;
        if (groupsStruct$Permissions2 == null || groupsStruct$Permissions2 == GroupsStruct$Permissions.getDefaultInstance()) {
            this.permissions_ = groupsStruct$Permissions;
        } else {
            this.permissions_ = (GroupsStruct$Permissions) ((GroupsStruct$Permissions.a) GroupsStruct$Permissions.newBuilder(this.permissions_).v(groupsStruct$Permissions)).j();
        }
        this.bitField0_ |= 2;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static GroupsOuterClass$UpdateGroupDefaultPermissionsChanged parseDelimitedFrom(InputStream inputStream) {
        return (GroupsOuterClass$UpdateGroupDefaultPermissionsChanged) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GroupsOuterClass$UpdateGroupDefaultPermissionsChanged parseFrom(ByteBuffer byteBuffer) {
        return (GroupsOuterClass$UpdateGroupDefaultPermissionsChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setGroup(PeersStruct$GroupOutPeer peersStruct$GroupOutPeer) {
        peersStruct$GroupOutPeer.getClass();
        this.group_ = peersStruct$GroupOutPeer;
        this.bitField0_ |= 1;
    }

    private void setPermissions(GroupsStruct$Permissions groupsStruct$Permissions) {
        groupsStruct$Permissions.getClass();
        this.permissions_ = groupsStruct$Permissions;
        this.bitField0_ |= 2;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1874m0.a[gVar.ordinal()]) {
            case 1:
                return new GroupsOuterClass$UpdateGroupDefaultPermissionsChanged();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001", new Object[]{"bitField0_", "group_", "permissions_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (GroupsOuterClass$UpdateGroupDefaultPermissionsChanged.class) {
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

    public PeersStruct$GroupOutPeer getGroup() {
        PeersStruct$GroupOutPeer peersStruct$GroupOutPeer = this.group_;
        return peersStruct$GroupOutPeer == null ? PeersStruct$GroupOutPeer.getDefaultInstance() : peersStruct$GroupOutPeer;
    }

    public GroupsStruct$Permissions getPermissions() {
        GroupsStruct$Permissions groupsStruct$Permissions = this.permissions_;
        return groupsStruct$Permissions == null ? GroupsStruct$Permissions.getDefaultInstance() : groupsStruct$Permissions;
    }

    public boolean hasGroup() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasPermissions() {
        return (this.bitField0_ & 2) != 0;
    }

    public static a newBuilder(GroupsOuterClass$UpdateGroupDefaultPermissionsChanged groupsOuterClass$UpdateGroupDefaultPermissionsChanged) {
        return (a) DEFAULT_INSTANCE.createBuilder(groupsOuterClass$UpdateGroupDefaultPermissionsChanged);
    }

    public static GroupsOuterClass$UpdateGroupDefaultPermissionsChanged parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (GroupsOuterClass$UpdateGroupDefaultPermissionsChanged) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GroupsOuterClass$UpdateGroupDefaultPermissionsChanged parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (GroupsOuterClass$UpdateGroupDefaultPermissionsChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static GroupsOuterClass$UpdateGroupDefaultPermissionsChanged parseFrom(AbstractC2383g abstractC2383g) {
        return (GroupsOuterClass$UpdateGroupDefaultPermissionsChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static GroupsOuterClass$UpdateGroupDefaultPermissionsChanged parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (GroupsOuterClass$UpdateGroupDefaultPermissionsChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static GroupsOuterClass$UpdateGroupDefaultPermissionsChanged parseFrom(byte[] bArr) {
        return (GroupsOuterClass$UpdateGroupDefaultPermissionsChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GroupsOuterClass$UpdateGroupDefaultPermissionsChanged parseFrom(byte[] bArr, C2394s c2394s) {
        return (GroupsOuterClass$UpdateGroupDefaultPermissionsChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static GroupsOuterClass$UpdateGroupDefaultPermissionsChanged parseFrom(InputStream inputStream) {
        return (GroupsOuterClass$UpdateGroupDefaultPermissionsChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GroupsOuterClass$UpdateGroupDefaultPermissionsChanged parseFrom(InputStream inputStream, C2394s c2394s) {
        return (GroupsOuterClass$UpdateGroupDefaultPermissionsChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GroupsOuterClass$UpdateGroupDefaultPermissionsChanged parseFrom(AbstractC2384h abstractC2384h) {
        return (GroupsOuterClass$UpdateGroupDefaultPermissionsChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static GroupsOuterClass$UpdateGroupDefaultPermissionsChanged parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (GroupsOuterClass$UpdateGroupDefaultPermissionsChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
