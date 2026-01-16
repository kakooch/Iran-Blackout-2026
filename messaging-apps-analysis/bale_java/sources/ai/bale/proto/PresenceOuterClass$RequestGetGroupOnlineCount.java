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
public final class PresenceOuterClass$RequestGetGroupOnlineCount extends GeneratedMessageLite implements U64 {
    private static final PresenceOuterClass$RequestGetGroupOnlineCount DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int PEER_FIELD_NUMBER = 1;
    private int bitField0_;
    private PeersStruct$GroupOutPeer peer_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(PeersStruct$GroupOutPeer peersStruct$GroupOutPeer) {
            q();
            ((PresenceOuterClass$RequestGetGroupOnlineCount) this.b).setPeer(peersStruct$GroupOutPeer);
            return this;
        }

        private a() {
            super(PresenceOuterClass$RequestGetGroupOnlineCount.DEFAULT_INSTANCE);
        }
    }

    static {
        PresenceOuterClass$RequestGetGroupOnlineCount presenceOuterClass$RequestGetGroupOnlineCount = new PresenceOuterClass$RequestGetGroupOnlineCount();
        DEFAULT_INSTANCE = presenceOuterClass$RequestGetGroupOnlineCount;
        GeneratedMessageLite.registerDefaultInstance(PresenceOuterClass$RequestGetGroupOnlineCount.class, presenceOuterClass$RequestGetGroupOnlineCount);
    }

    private PresenceOuterClass$RequestGetGroupOnlineCount() {
    }

    private void clearPeer() {
        this.peer_ = null;
        this.bitField0_ &= -2;
    }

    public static PresenceOuterClass$RequestGetGroupOnlineCount getDefaultInstance() {
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

    public static PresenceOuterClass$RequestGetGroupOnlineCount parseDelimitedFrom(InputStream inputStream) {
        return (PresenceOuterClass$RequestGetGroupOnlineCount) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PresenceOuterClass$RequestGetGroupOnlineCount parseFrom(ByteBuffer byteBuffer) {
        return (PresenceOuterClass$RequestGetGroupOnlineCount) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
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
        switch (AbstractC1866j1.a[gVar.ordinal()]) {
            case 1:
                return new PresenceOuterClass$RequestGetGroupOnlineCount();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "peer_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (PresenceOuterClass$RequestGetGroupOnlineCount.class) {
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

    public static a newBuilder(PresenceOuterClass$RequestGetGroupOnlineCount presenceOuterClass$RequestGetGroupOnlineCount) {
        return (a) DEFAULT_INSTANCE.createBuilder(presenceOuterClass$RequestGetGroupOnlineCount);
    }

    public static PresenceOuterClass$RequestGetGroupOnlineCount parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (PresenceOuterClass$RequestGetGroupOnlineCount) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PresenceOuterClass$RequestGetGroupOnlineCount parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (PresenceOuterClass$RequestGetGroupOnlineCount) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static PresenceOuterClass$RequestGetGroupOnlineCount parseFrom(AbstractC2383g abstractC2383g) {
        return (PresenceOuterClass$RequestGetGroupOnlineCount) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static PresenceOuterClass$RequestGetGroupOnlineCount parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (PresenceOuterClass$RequestGetGroupOnlineCount) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static PresenceOuterClass$RequestGetGroupOnlineCount parseFrom(byte[] bArr) {
        return (PresenceOuterClass$RequestGetGroupOnlineCount) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PresenceOuterClass$RequestGetGroupOnlineCount parseFrom(byte[] bArr, C2394s c2394s) {
        return (PresenceOuterClass$RequestGetGroupOnlineCount) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static PresenceOuterClass$RequestGetGroupOnlineCount parseFrom(InputStream inputStream) {
        return (PresenceOuterClass$RequestGetGroupOnlineCount) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PresenceOuterClass$RequestGetGroupOnlineCount parseFrom(InputStream inputStream, C2394s c2394s) {
        return (PresenceOuterClass$RequestGetGroupOnlineCount) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PresenceOuterClass$RequestGetGroupOnlineCount parseFrom(AbstractC2384h abstractC2384h) {
        return (PresenceOuterClass$RequestGetGroupOnlineCount) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static PresenceOuterClass$RequestGetGroupOnlineCount parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (PresenceOuterClass$RequestGetGroupOnlineCount) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
