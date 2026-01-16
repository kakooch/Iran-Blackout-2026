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
public final class GroupsOuterClass$RequestRemoveUserAdmin extends GeneratedMessageLite implements U64 {
    private static final GroupsOuterClass$RequestRemoveUserAdmin DEFAULT_INSTANCE;
    public static final int GROUP_PEER_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int USER_PEER_FIELD_NUMBER = 2;
    private int bitField0_;
    private PeersStruct$GroupOutPeer groupPeer_;
    private PeersStruct$UserOutPeer userPeer_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(PeersStruct$GroupOutPeer peersStruct$GroupOutPeer) {
            q();
            ((GroupsOuterClass$RequestRemoveUserAdmin) this.b).setGroupPeer(peersStruct$GroupOutPeer);
            return this;
        }

        public a B(PeersStruct$UserOutPeer peersStruct$UserOutPeer) {
            q();
            ((GroupsOuterClass$RequestRemoveUserAdmin) this.b).setUserPeer(peersStruct$UserOutPeer);
            return this;
        }

        private a() {
            super(GroupsOuterClass$RequestRemoveUserAdmin.DEFAULT_INSTANCE);
        }
    }

    static {
        GroupsOuterClass$RequestRemoveUserAdmin groupsOuterClass$RequestRemoveUserAdmin = new GroupsOuterClass$RequestRemoveUserAdmin();
        DEFAULT_INSTANCE = groupsOuterClass$RequestRemoveUserAdmin;
        GeneratedMessageLite.registerDefaultInstance(GroupsOuterClass$RequestRemoveUserAdmin.class, groupsOuterClass$RequestRemoveUserAdmin);
    }

    private GroupsOuterClass$RequestRemoveUserAdmin() {
    }

    private void clearGroupPeer() {
        this.groupPeer_ = null;
        this.bitField0_ &= -2;
    }

    private void clearUserPeer() {
        this.userPeer_ = null;
        this.bitField0_ &= -3;
    }

    public static GroupsOuterClass$RequestRemoveUserAdmin getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeGroupPeer(PeersStruct$GroupOutPeer peersStruct$GroupOutPeer) {
        peersStruct$GroupOutPeer.getClass();
        PeersStruct$GroupOutPeer peersStruct$GroupOutPeer2 = this.groupPeer_;
        if (peersStruct$GroupOutPeer2 == null || peersStruct$GroupOutPeer2 == PeersStruct$GroupOutPeer.getDefaultInstance()) {
            this.groupPeer_ = peersStruct$GroupOutPeer;
        } else {
            this.groupPeer_ = (PeersStruct$GroupOutPeer) ((PeersStruct$GroupOutPeer.a) PeersStruct$GroupOutPeer.newBuilder(this.groupPeer_).v(peersStruct$GroupOutPeer)).j();
        }
        this.bitField0_ |= 1;
    }

    private void mergeUserPeer(PeersStruct$UserOutPeer peersStruct$UserOutPeer) {
        peersStruct$UserOutPeer.getClass();
        PeersStruct$UserOutPeer peersStruct$UserOutPeer2 = this.userPeer_;
        if (peersStruct$UserOutPeer2 == null || peersStruct$UserOutPeer2 == PeersStruct$UserOutPeer.getDefaultInstance()) {
            this.userPeer_ = peersStruct$UserOutPeer;
        } else {
            this.userPeer_ = (PeersStruct$UserOutPeer) ((PeersStruct$UserOutPeer.a) PeersStruct$UserOutPeer.newBuilder(this.userPeer_).v(peersStruct$UserOutPeer)).j();
        }
        this.bitField0_ |= 2;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static GroupsOuterClass$RequestRemoveUserAdmin parseDelimitedFrom(InputStream inputStream) {
        return (GroupsOuterClass$RequestRemoveUserAdmin) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GroupsOuterClass$RequestRemoveUserAdmin parseFrom(ByteBuffer byteBuffer) {
        return (GroupsOuterClass$RequestRemoveUserAdmin) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setGroupPeer(PeersStruct$GroupOutPeer peersStruct$GroupOutPeer) {
        peersStruct$GroupOutPeer.getClass();
        this.groupPeer_ = peersStruct$GroupOutPeer;
        this.bitField0_ |= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUserPeer(PeersStruct$UserOutPeer peersStruct$UserOutPeer) {
        peersStruct$UserOutPeer.getClass();
        this.userPeer_ = peersStruct$UserOutPeer;
        this.bitField0_ |= 2;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1874m0.a[gVar.ordinal()]) {
            case 1:
                return new GroupsOuterClass$RequestRemoveUserAdmin();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001", new Object[]{"bitField0_", "groupPeer_", "userPeer_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (GroupsOuterClass$RequestRemoveUserAdmin.class) {
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

    public PeersStruct$GroupOutPeer getGroupPeer() {
        PeersStruct$GroupOutPeer peersStruct$GroupOutPeer = this.groupPeer_;
        return peersStruct$GroupOutPeer == null ? PeersStruct$GroupOutPeer.getDefaultInstance() : peersStruct$GroupOutPeer;
    }

    public PeersStruct$UserOutPeer getUserPeer() {
        PeersStruct$UserOutPeer peersStruct$UserOutPeer = this.userPeer_;
        return peersStruct$UserOutPeer == null ? PeersStruct$UserOutPeer.getDefaultInstance() : peersStruct$UserOutPeer;
    }

    public boolean hasGroupPeer() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasUserPeer() {
        return (this.bitField0_ & 2) != 0;
    }

    public static a newBuilder(GroupsOuterClass$RequestRemoveUserAdmin groupsOuterClass$RequestRemoveUserAdmin) {
        return (a) DEFAULT_INSTANCE.createBuilder(groupsOuterClass$RequestRemoveUserAdmin);
    }

    public static GroupsOuterClass$RequestRemoveUserAdmin parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (GroupsOuterClass$RequestRemoveUserAdmin) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GroupsOuterClass$RequestRemoveUserAdmin parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (GroupsOuterClass$RequestRemoveUserAdmin) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static GroupsOuterClass$RequestRemoveUserAdmin parseFrom(AbstractC2383g abstractC2383g) {
        return (GroupsOuterClass$RequestRemoveUserAdmin) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static GroupsOuterClass$RequestRemoveUserAdmin parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (GroupsOuterClass$RequestRemoveUserAdmin) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static GroupsOuterClass$RequestRemoveUserAdmin parseFrom(byte[] bArr) {
        return (GroupsOuterClass$RequestRemoveUserAdmin) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GroupsOuterClass$RequestRemoveUserAdmin parseFrom(byte[] bArr, C2394s c2394s) {
        return (GroupsOuterClass$RequestRemoveUserAdmin) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static GroupsOuterClass$RequestRemoveUserAdmin parseFrom(InputStream inputStream) {
        return (GroupsOuterClass$RequestRemoveUserAdmin) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GroupsOuterClass$RequestRemoveUserAdmin parseFrom(InputStream inputStream, C2394s c2394s) {
        return (GroupsOuterClass$RequestRemoveUserAdmin) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GroupsOuterClass$RequestRemoveUserAdmin parseFrom(AbstractC2384h abstractC2384h) {
        return (GroupsOuterClass$RequestRemoveUserAdmin) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static GroupsOuterClass$RequestRemoveUserAdmin parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (GroupsOuterClass$RequestRemoveUserAdmin) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
