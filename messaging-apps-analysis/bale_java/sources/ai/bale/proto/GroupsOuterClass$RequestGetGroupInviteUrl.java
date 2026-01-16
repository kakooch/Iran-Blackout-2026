package ai.bale.proto;

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
public final class GroupsOuterClass$RequestGetGroupInviteUrl extends GeneratedMessageLite implements U64 {
    private static final GroupsOuterClass$RequestGetGroupInviteUrl DEFAULT_INSTANCE;
    public static final int GROUP_PEER_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private PeersStruct$GroupOutPeer groupPeer_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(PeersStruct$GroupOutPeer peersStruct$GroupOutPeer) {
            q();
            ((GroupsOuterClass$RequestGetGroupInviteUrl) this.b).setGroupPeer(peersStruct$GroupOutPeer);
            return this;
        }

        private a() {
            super(GroupsOuterClass$RequestGetGroupInviteUrl.DEFAULT_INSTANCE);
        }
    }

    static {
        GroupsOuterClass$RequestGetGroupInviteUrl groupsOuterClass$RequestGetGroupInviteUrl = new GroupsOuterClass$RequestGetGroupInviteUrl();
        DEFAULT_INSTANCE = groupsOuterClass$RequestGetGroupInviteUrl;
        GeneratedMessageLite.registerDefaultInstance(GroupsOuterClass$RequestGetGroupInviteUrl.class, groupsOuterClass$RequestGetGroupInviteUrl);
    }

    private GroupsOuterClass$RequestGetGroupInviteUrl() {
    }

    private void clearGroupPeer() {
        this.groupPeer_ = null;
        this.bitField0_ &= -2;
    }

    public static GroupsOuterClass$RequestGetGroupInviteUrl getDefaultInstance() {
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

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static GroupsOuterClass$RequestGetGroupInviteUrl parseDelimitedFrom(InputStream inputStream) {
        return (GroupsOuterClass$RequestGetGroupInviteUrl) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GroupsOuterClass$RequestGetGroupInviteUrl parseFrom(ByteBuffer byteBuffer) {
        return (GroupsOuterClass$RequestGetGroupInviteUrl) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
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

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1874m0.a[gVar.ordinal()]) {
            case 1:
                return new GroupsOuterClass$RequestGetGroupInviteUrl();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "groupPeer_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (GroupsOuterClass$RequestGetGroupInviteUrl.class) {
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

    public boolean hasGroupPeer() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(GroupsOuterClass$RequestGetGroupInviteUrl groupsOuterClass$RequestGetGroupInviteUrl) {
        return (a) DEFAULT_INSTANCE.createBuilder(groupsOuterClass$RequestGetGroupInviteUrl);
    }

    public static GroupsOuterClass$RequestGetGroupInviteUrl parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (GroupsOuterClass$RequestGetGroupInviteUrl) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GroupsOuterClass$RequestGetGroupInviteUrl parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (GroupsOuterClass$RequestGetGroupInviteUrl) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static GroupsOuterClass$RequestGetGroupInviteUrl parseFrom(AbstractC2383g abstractC2383g) {
        return (GroupsOuterClass$RequestGetGroupInviteUrl) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static GroupsOuterClass$RequestGetGroupInviteUrl parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (GroupsOuterClass$RequestGetGroupInviteUrl) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static GroupsOuterClass$RequestGetGroupInviteUrl parseFrom(byte[] bArr) {
        return (GroupsOuterClass$RequestGetGroupInviteUrl) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GroupsOuterClass$RequestGetGroupInviteUrl parseFrom(byte[] bArr, C2394s c2394s) {
        return (GroupsOuterClass$RequestGetGroupInviteUrl) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static GroupsOuterClass$RequestGetGroupInviteUrl parseFrom(InputStream inputStream) {
        return (GroupsOuterClass$RequestGetGroupInviteUrl) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GroupsOuterClass$RequestGetGroupInviteUrl parseFrom(InputStream inputStream, C2394s c2394s) {
        return (GroupsOuterClass$RequestGetGroupInviteUrl) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GroupsOuterClass$RequestGetGroupInviteUrl parseFrom(AbstractC2384h abstractC2384h) {
        return (GroupsOuterClass$RequestGetGroupInviteUrl) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static GroupsOuterClass$RequestGetGroupInviteUrl parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (GroupsOuterClass$RequestGetGroupInviteUrl) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
