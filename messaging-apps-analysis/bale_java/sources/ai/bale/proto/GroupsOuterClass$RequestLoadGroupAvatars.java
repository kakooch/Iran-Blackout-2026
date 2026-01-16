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
public final class GroupsOuterClass$RequestLoadGroupAvatars extends GeneratedMessageLite implements U64 {
    private static final GroupsOuterClass$RequestLoadGroupAvatars DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int PEER_FIELD_NUMBER = 1;
    private int bitField0_;
    private PeersStruct$GroupOutPeer peer_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(PeersStruct$GroupOutPeer peersStruct$GroupOutPeer) {
            q();
            ((GroupsOuterClass$RequestLoadGroupAvatars) this.b).setPeer(peersStruct$GroupOutPeer);
            return this;
        }

        private a() {
            super(GroupsOuterClass$RequestLoadGroupAvatars.DEFAULT_INSTANCE);
        }
    }

    static {
        GroupsOuterClass$RequestLoadGroupAvatars groupsOuterClass$RequestLoadGroupAvatars = new GroupsOuterClass$RequestLoadGroupAvatars();
        DEFAULT_INSTANCE = groupsOuterClass$RequestLoadGroupAvatars;
        GeneratedMessageLite.registerDefaultInstance(GroupsOuterClass$RequestLoadGroupAvatars.class, groupsOuterClass$RequestLoadGroupAvatars);
    }

    private GroupsOuterClass$RequestLoadGroupAvatars() {
    }

    private void clearPeer() {
        this.peer_ = null;
        this.bitField0_ &= -2;
    }

    public static GroupsOuterClass$RequestLoadGroupAvatars getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergePeer(PeersStruct$GroupOutPeer peersStruct$GroupOutPeer) {
        peersStruct$GroupOutPeer.getClass();
        PeersStruct$GroupOutPeer peersStruct$GroupOutPeer2 = this.peer_;
        if (peersStruct$GroupOutPeer2 == null || peersStruct$GroupOutPeer2 == PeersStruct$GroupOutPeer.getDefaultInstance()) {
            this.peer_ = peersStruct$GroupOutPeer;
        } else {
            this.peer_ = (PeersStruct$GroupOutPeer) ((PeersStruct$GroupOutPeer.a) PeersStruct$GroupOutPeer.newBuilder(this.peer_).v(peersStruct$GroupOutPeer)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static GroupsOuterClass$RequestLoadGroupAvatars parseDelimitedFrom(InputStream inputStream) {
        return (GroupsOuterClass$RequestLoadGroupAvatars) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GroupsOuterClass$RequestLoadGroupAvatars parseFrom(ByteBuffer byteBuffer) {
        return (GroupsOuterClass$RequestLoadGroupAvatars) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPeer(PeersStruct$GroupOutPeer peersStruct$GroupOutPeer) {
        peersStruct$GroupOutPeer.getClass();
        this.peer_ = peersStruct$GroupOutPeer;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1874m0.a[gVar.ordinal()]) {
            case 1:
                return new GroupsOuterClass$RequestLoadGroupAvatars();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "peer_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (GroupsOuterClass$RequestLoadGroupAvatars.class) {
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

    public PeersStruct$GroupOutPeer getPeer() {
        PeersStruct$GroupOutPeer peersStruct$GroupOutPeer = this.peer_;
        return peersStruct$GroupOutPeer == null ? PeersStruct$GroupOutPeer.getDefaultInstance() : peersStruct$GroupOutPeer;
    }

    public boolean hasPeer() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(GroupsOuterClass$RequestLoadGroupAvatars groupsOuterClass$RequestLoadGroupAvatars) {
        return (a) DEFAULT_INSTANCE.createBuilder(groupsOuterClass$RequestLoadGroupAvatars);
    }

    public static GroupsOuterClass$RequestLoadGroupAvatars parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (GroupsOuterClass$RequestLoadGroupAvatars) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GroupsOuterClass$RequestLoadGroupAvatars parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (GroupsOuterClass$RequestLoadGroupAvatars) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static GroupsOuterClass$RequestLoadGroupAvatars parseFrom(AbstractC2383g abstractC2383g) {
        return (GroupsOuterClass$RequestLoadGroupAvatars) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static GroupsOuterClass$RequestLoadGroupAvatars parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (GroupsOuterClass$RequestLoadGroupAvatars) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static GroupsOuterClass$RequestLoadGroupAvatars parseFrom(byte[] bArr) {
        return (GroupsOuterClass$RequestLoadGroupAvatars) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GroupsOuterClass$RequestLoadGroupAvatars parseFrom(byte[] bArr, C2394s c2394s) {
        return (GroupsOuterClass$RequestLoadGroupAvatars) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static GroupsOuterClass$RequestLoadGroupAvatars parseFrom(InputStream inputStream) {
        return (GroupsOuterClass$RequestLoadGroupAvatars) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GroupsOuterClass$RequestLoadGroupAvatars parseFrom(InputStream inputStream, C2394s c2394s) {
        return (GroupsOuterClass$RequestLoadGroupAvatars) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GroupsOuterClass$RequestLoadGroupAvatars parseFrom(AbstractC2384h abstractC2384h) {
        return (GroupsOuterClass$RequestLoadGroupAvatars) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static GroupsOuterClass$RequestLoadGroupAvatars parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (GroupsOuterClass$RequestLoadGroupAvatars) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
