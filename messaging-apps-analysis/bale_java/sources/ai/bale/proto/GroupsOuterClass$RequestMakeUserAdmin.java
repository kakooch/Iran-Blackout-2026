package ai.bale.proto;

import ai.bale.proto.PeersStruct$GroupOutPeer;
import ai.bale.proto.PeersStruct$UserOutPeer;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.StringValue;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class GroupsOuterClass$RequestMakeUserAdmin extends GeneratedMessageLite implements U64 {
    public static final int ADMIN_TITLE_FIELD_NUMBER = 3;
    private static final GroupsOuterClass$RequestMakeUserAdmin DEFAULT_INSTANCE;
    public static final int GROUP_PEER_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int USER_PEER_FIELD_NUMBER = 2;
    private StringValue adminTitle_;
    private int bitField0_;
    private PeersStruct$GroupOutPeer groupPeer_;
    private PeersStruct$UserOutPeer userPeer_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(StringValue stringValue) {
            q();
            ((GroupsOuterClass$RequestMakeUserAdmin) this.b).setAdminTitle(stringValue);
            return this;
        }

        public a B(PeersStruct$GroupOutPeer peersStruct$GroupOutPeer) {
            q();
            ((GroupsOuterClass$RequestMakeUserAdmin) this.b).setGroupPeer(peersStruct$GroupOutPeer);
            return this;
        }

        public a C(PeersStruct$UserOutPeer peersStruct$UserOutPeer) {
            q();
            ((GroupsOuterClass$RequestMakeUserAdmin) this.b).setUserPeer(peersStruct$UserOutPeer);
            return this;
        }

        private a() {
            super(GroupsOuterClass$RequestMakeUserAdmin.DEFAULT_INSTANCE);
        }
    }

    static {
        GroupsOuterClass$RequestMakeUserAdmin groupsOuterClass$RequestMakeUserAdmin = new GroupsOuterClass$RequestMakeUserAdmin();
        DEFAULT_INSTANCE = groupsOuterClass$RequestMakeUserAdmin;
        GeneratedMessageLite.registerDefaultInstance(GroupsOuterClass$RequestMakeUserAdmin.class, groupsOuterClass$RequestMakeUserAdmin);
    }

    private GroupsOuterClass$RequestMakeUserAdmin() {
    }

    private void clearAdminTitle() {
        this.adminTitle_ = null;
        this.bitField0_ &= -5;
    }

    private void clearGroupPeer() {
        this.groupPeer_ = null;
        this.bitField0_ &= -2;
    }

    private void clearUserPeer() {
        this.userPeer_ = null;
        this.bitField0_ &= -3;
    }

    public static GroupsOuterClass$RequestMakeUserAdmin getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeAdminTitle(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.adminTitle_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.adminTitle_ = stringValue;
        } else {
            this.adminTitle_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.adminTitle_).v(stringValue)).j();
        }
        this.bitField0_ |= 4;
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

    public static GroupsOuterClass$RequestMakeUserAdmin parseDelimitedFrom(InputStream inputStream) {
        return (GroupsOuterClass$RequestMakeUserAdmin) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GroupsOuterClass$RequestMakeUserAdmin parseFrom(ByteBuffer byteBuffer) {
        return (GroupsOuterClass$RequestMakeUserAdmin) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAdminTitle(StringValue stringValue) {
        stringValue.getClass();
        this.adminTitle_ = stringValue;
        this.bitField0_ |= 4;
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
                return new GroupsOuterClass$RequestMakeUserAdmin();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"bitField0_", "groupPeer_", "userPeer_", "adminTitle_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (GroupsOuterClass$RequestMakeUserAdmin.class) {
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

    public StringValue getAdminTitle() {
        StringValue stringValue = this.adminTitle_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public PeersStruct$GroupOutPeer getGroupPeer() {
        PeersStruct$GroupOutPeer peersStruct$GroupOutPeer = this.groupPeer_;
        return peersStruct$GroupOutPeer == null ? PeersStruct$GroupOutPeer.getDefaultInstance() : peersStruct$GroupOutPeer;
    }

    public PeersStruct$UserOutPeer getUserPeer() {
        PeersStruct$UserOutPeer peersStruct$UserOutPeer = this.userPeer_;
        return peersStruct$UserOutPeer == null ? PeersStruct$UserOutPeer.getDefaultInstance() : peersStruct$UserOutPeer;
    }

    public boolean hasAdminTitle() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasGroupPeer() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasUserPeer() {
        return (this.bitField0_ & 2) != 0;
    }

    public static a newBuilder(GroupsOuterClass$RequestMakeUserAdmin groupsOuterClass$RequestMakeUserAdmin) {
        return (a) DEFAULT_INSTANCE.createBuilder(groupsOuterClass$RequestMakeUserAdmin);
    }

    public static GroupsOuterClass$RequestMakeUserAdmin parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (GroupsOuterClass$RequestMakeUserAdmin) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GroupsOuterClass$RequestMakeUserAdmin parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (GroupsOuterClass$RequestMakeUserAdmin) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static GroupsOuterClass$RequestMakeUserAdmin parseFrom(AbstractC2383g abstractC2383g) {
        return (GroupsOuterClass$RequestMakeUserAdmin) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static GroupsOuterClass$RequestMakeUserAdmin parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (GroupsOuterClass$RequestMakeUserAdmin) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static GroupsOuterClass$RequestMakeUserAdmin parseFrom(byte[] bArr) {
        return (GroupsOuterClass$RequestMakeUserAdmin) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GroupsOuterClass$RequestMakeUserAdmin parseFrom(byte[] bArr, C2394s c2394s) {
        return (GroupsOuterClass$RequestMakeUserAdmin) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static GroupsOuterClass$RequestMakeUserAdmin parseFrom(InputStream inputStream) {
        return (GroupsOuterClass$RequestMakeUserAdmin) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GroupsOuterClass$RequestMakeUserAdmin parseFrom(InputStream inputStream, C2394s c2394s) {
        return (GroupsOuterClass$RequestMakeUserAdmin) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GroupsOuterClass$RequestMakeUserAdmin parseFrom(AbstractC2384h abstractC2384h) {
        return (GroupsOuterClass$RequestMakeUserAdmin) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static GroupsOuterClass$RequestMakeUserAdmin parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (GroupsOuterClass$RequestMakeUserAdmin) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
