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
public final class GroupsOuterClass$RequestFetchGroupAdmins extends GeneratedMessageLite implements U64 {
    private static final GroupsOuterClass$RequestFetchGroupAdmins DEFAULT_INSTANCE;
    public static final int GROUP_OUT_PEER_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private PeersStruct$GroupOutPeer groupOutPeer_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(PeersStruct$GroupOutPeer peersStruct$GroupOutPeer) {
            q();
            ((GroupsOuterClass$RequestFetchGroupAdmins) this.b).setGroupOutPeer(peersStruct$GroupOutPeer);
            return this;
        }

        private a() {
            super(GroupsOuterClass$RequestFetchGroupAdmins.DEFAULT_INSTANCE);
        }
    }

    static {
        GroupsOuterClass$RequestFetchGroupAdmins groupsOuterClass$RequestFetchGroupAdmins = new GroupsOuterClass$RequestFetchGroupAdmins();
        DEFAULT_INSTANCE = groupsOuterClass$RequestFetchGroupAdmins;
        GeneratedMessageLite.registerDefaultInstance(GroupsOuterClass$RequestFetchGroupAdmins.class, groupsOuterClass$RequestFetchGroupAdmins);
    }

    private GroupsOuterClass$RequestFetchGroupAdmins() {
    }

    private void clearGroupOutPeer() {
        this.groupOutPeer_ = null;
        this.bitField0_ &= -2;
    }

    public static GroupsOuterClass$RequestFetchGroupAdmins getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeGroupOutPeer(PeersStruct$GroupOutPeer peersStruct$GroupOutPeer) {
        peersStruct$GroupOutPeer.getClass();
        PeersStruct$GroupOutPeer peersStruct$GroupOutPeer2 = this.groupOutPeer_;
        if (peersStruct$GroupOutPeer2 == null || peersStruct$GroupOutPeer2 == PeersStruct$GroupOutPeer.getDefaultInstance()) {
            this.groupOutPeer_ = peersStruct$GroupOutPeer;
        } else {
            this.groupOutPeer_ = (PeersStruct$GroupOutPeer) ((PeersStruct$GroupOutPeer.a) PeersStruct$GroupOutPeer.newBuilder(this.groupOutPeer_).v(peersStruct$GroupOutPeer)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static GroupsOuterClass$RequestFetchGroupAdmins parseDelimitedFrom(InputStream inputStream) {
        return (GroupsOuterClass$RequestFetchGroupAdmins) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GroupsOuterClass$RequestFetchGroupAdmins parseFrom(ByteBuffer byteBuffer) {
        return (GroupsOuterClass$RequestFetchGroupAdmins) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setGroupOutPeer(PeersStruct$GroupOutPeer peersStruct$GroupOutPeer) {
        peersStruct$GroupOutPeer.getClass();
        this.groupOutPeer_ = peersStruct$GroupOutPeer;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1874m0.a[gVar.ordinal()]) {
            case 1:
                return new GroupsOuterClass$RequestFetchGroupAdmins();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "groupOutPeer_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (GroupsOuterClass$RequestFetchGroupAdmins.class) {
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

    public PeersStruct$GroupOutPeer getGroupOutPeer() {
        PeersStruct$GroupOutPeer peersStruct$GroupOutPeer = this.groupOutPeer_;
        return peersStruct$GroupOutPeer == null ? PeersStruct$GroupOutPeer.getDefaultInstance() : peersStruct$GroupOutPeer;
    }

    public boolean hasGroupOutPeer() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(GroupsOuterClass$RequestFetchGroupAdmins groupsOuterClass$RequestFetchGroupAdmins) {
        return (a) DEFAULT_INSTANCE.createBuilder(groupsOuterClass$RequestFetchGroupAdmins);
    }

    public static GroupsOuterClass$RequestFetchGroupAdmins parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (GroupsOuterClass$RequestFetchGroupAdmins) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GroupsOuterClass$RequestFetchGroupAdmins parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (GroupsOuterClass$RequestFetchGroupAdmins) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static GroupsOuterClass$RequestFetchGroupAdmins parseFrom(AbstractC2383g abstractC2383g) {
        return (GroupsOuterClass$RequestFetchGroupAdmins) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static GroupsOuterClass$RequestFetchGroupAdmins parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (GroupsOuterClass$RequestFetchGroupAdmins) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static GroupsOuterClass$RequestFetchGroupAdmins parseFrom(byte[] bArr) {
        return (GroupsOuterClass$RequestFetchGroupAdmins) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GroupsOuterClass$RequestFetchGroupAdmins parseFrom(byte[] bArr, C2394s c2394s) {
        return (GroupsOuterClass$RequestFetchGroupAdmins) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static GroupsOuterClass$RequestFetchGroupAdmins parseFrom(InputStream inputStream) {
        return (GroupsOuterClass$RequestFetchGroupAdmins) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GroupsOuterClass$RequestFetchGroupAdmins parseFrom(InputStream inputStream, C2394s c2394s) {
        return (GroupsOuterClass$RequestFetchGroupAdmins) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GroupsOuterClass$RequestFetchGroupAdmins parseFrom(AbstractC2384h abstractC2384h) {
        return (GroupsOuterClass$RequestFetchGroupAdmins) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static GroupsOuterClass$RequestFetchGroupAdmins parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (GroupsOuterClass$RequestFetchGroupAdmins) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
