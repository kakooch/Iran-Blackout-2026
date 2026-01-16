package ai.bale.proto;

import ai.bale.proto.PeersStruct$GroupOutPeer;
import ai.bale.proto.PeersStruct$UserOutPeer;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class GroupsOuterClass$RequestGetMemberPermissions extends GeneratedMessageLite implements U64 {
    private static final GroupsOuterClass$RequestGetMemberPermissions DEFAULT_INSTANCE;
    public static final int GROUP_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int USER_FIELD_NUMBER = 2;
    private int bitField0_;
    private PeersStruct$GroupOutPeer group_;
    private PeersStruct$UserOutPeer user_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(PeersStruct$GroupOutPeer peersStruct$GroupOutPeer) {
            q();
            ((GroupsOuterClass$RequestGetMemberPermissions) this.b).setGroup(peersStruct$GroupOutPeer);
            return this;
        }

        public a B(PeersStruct$UserOutPeer peersStruct$UserOutPeer) {
            q();
            ((GroupsOuterClass$RequestGetMemberPermissions) this.b).setUser(peersStruct$UserOutPeer);
            return this;
        }

        private a() {
            super(GroupsOuterClass$RequestGetMemberPermissions.DEFAULT_INSTANCE);
        }
    }

    static {
        GroupsOuterClass$RequestGetMemberPermissions groupsOuterClass$RequestGetMemberPermissions = new GroupsOuterClass$RequestGetMemberPermissions();
        DEFAULT_INSTANCE = groupsOuterClass$RequestGetMemberPermissions;
        GeneratedMessageLite.registerDefaultInstance(GroupsOuterClass$RequestGetMemberPermissions.class, groupsOuterClass$RequestGetMemberPermissions);
    }

    private GroupsOuterClass$RequestGetMemberPermissions() {
    }

    private void clearGroup() {
        this.group_ = null;
        this.bitField0_ &= -2;
    }

    private void clearUser() {
        this.user_ = null;
        this.bitField0_ &= -3;
    }

    public static GroupsOuterClass$RequestGetMemberPermissions getDefaultInstance() {
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

    private void mergeUser(PeersStruct$UserOutPeer peersStruct$UserOutPeer) {
        peersStruct$UserOutPeer.getClass();
        PeersStruct$UserOutPeer peersStruct$UserOutPeer2 = this.user_;
        if (peersStruct$UserOutPeer2 == null || peersStruct$UserOutPeer2 == PeersStruct$UserOutPeer.getDefaultInstance()) {
            this.user_ = peersStruct$UserOutPeer;
        } else {
            this.user_ = (PeersStruct$UserOutPeer) ((PeersStruct$UserOutPeer.a) PeersStruct$UserOutPeer.newBuilder(this.user_).v(peersStruct$UserOutPeer)).j();
        }
        this.bitField0_ |= 2;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static GroupsOuterClass$RequestGetMemberPermissions parseDelimitedFrom(InputStream inputStream) {
        return (GroupsOuterClass$RequestGetMemberPermissions) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GroupsOuterClass$RequestGetMemberPermissions parseFrom(ByteBuffer byteBuffer) {
        return (GroupsOuterClass$RequestGetMemberPermissions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setGroup(PeersStruct$GroupOutPeer peersStruct$GroupOutPeer) {
        peersStruct$GroupOutPeer.getClass();
        this.group_ = peersStruct$GroupOutPeer;
        this.bitField0_ |= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUser(PeersStruct$UserOutPeer peersStruct$UserOutPeer) {
        peersStruct$UserOutPeer.getClass();
        this.user_ = peersStruct$UserOutPeer;
        this.bitField0_ |= 2;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1874m0.a[gVar.ordinal()]) {
            case 1:
                return new GroupsOuterClass$RequestGetMemberPermissions();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001", new Object[]{"bitField0_", "group_", "user_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (GroupsOuterClass$RequestGetMemberPermissions.class) {
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

    public PeersStruct$UserOutPeer getUser() {
        PeersStruct$UserOutPeer peersStruct$UserOutPeer = this.user_;
        return peersStruct$UserOutPeer == null ? PeersStruct$UserOutPeer.getDefaultInstance() : peersStruct$UserOutPeer;
    }

    public boolean hasGroup() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasUser() {
        return (this.bitField0_ & 2) != 0;
    }

    public static a newBuilder(GroupsOuterClass$RequestGetMemberPermissions groupsOuterClass$RequestGetMemberPermissions) {
        return (a) DEFAULT_INSTANCE.createBuilder(groupsOuterClass$RequestGetMemberPermissions);
    }

    public static GroupsOuterClass$RequestGetMemberPermissions parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (GroupsOuterClass$RequestGetMemberPermissions) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GroupsOuterClass$RequestGetMemberPermissions parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (GroupsOuterClass$RequestGetMemberPermissions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static GroupsOuterClass$RequestGetMemberPermissions parseFrom(AbstractC2383g abstractC2383g) {
        return (GroupsOuterClass$RequestGetMemberPermissions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static GroupsOuterClass$RequestGetMemberPermissions parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (GroupsOuterClass$RequestGetMemberPermissions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static GroupsOuterClass$RequestGetMemberPermissions parseFrom(byte[] bArr) {
        return (GroupsOuterClass$RequestGetMemberPermissions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GroupsOuterClass$RequestGetMemberPermissions parseFrom(byte[] bArr, C2394s c2394s) {
        return (GroupsOuterClass$RequestGetMemberPermissions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static GroupsOuterClass$RequestGetMemberPermissions parseFrom(InputStream inputStream) {
        return (GroupsOuterClass$RequestGetMemberPermissions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GroupsOuterClass$RequestGetMemberPermissions parseFrom(InputStream inputStream, C2394s c2394s) {
        return (GroupsOuterClass$RequestGetMemberPermissions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GroupsOuterClass$RequestGetMemberPermissions parseFrom(AbstractC2384h abstractC2384h) {
        return (GroupsOuterClass$RequestGetMemberPermissions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static GroupsOuterClass$RequestGetMemberPermissions parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (GroupsOuterClass$RequestGetMemberPermissions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
