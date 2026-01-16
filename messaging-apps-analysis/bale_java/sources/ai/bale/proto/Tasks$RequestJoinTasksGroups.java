package ai.bale.proto;

import ai.bale.proto.PeersStruct$Peer;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class Tasks$RequestJoinTasksGroups extends GeneratedMessageLite implements U64 {
    private static final Tasks$RequestJoinTasksGroups DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int PEER_FIELD_NUMBER = 1;
    private int bitField0_;
    private PeersStruct$Peer peer_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Tasks$RequestJoinTasksGroups.DEFAULT_INSTANCE);
        }
    }

    static {
        Tasks$RequestJoinTasksGroups tasks$RequestJoinTasksGroups = new Tasks$RequestJoinTasksGroups();
        DEFAULT_INSTANCE = tasks$RequestJoinTasksGroups;
        GeneratedMessageLite.registerDefaultInstance(Tasks$RequestJoinTasksGroups.class, tasks$RequestJoinTasksGroups);
    }

    private Tasks$RequestJoinTasksGroups() {
    }

    private void clearPeer() {
        this.peer_ = null;
        this.bitField0_ &= -2;
    }

    public static Tasks$RequestJoinTasksGroups getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergePeer(PeersStruct$Peer peersStruct$Peer) {
        peersStruct$Peer.getClass();
        PeersStruct$Peer peersStruct$Peer2 = this.peer_;
        if (peersStruct$Peer2 == null || peersStruct$Peer2 == PeersStruct$Peer.getDefaultInstance()) {
            this.peer_ = peersStruct$Peer;
        } else {
            this.peer_ = (PeersStruct$Peer) ((PeersStruct$Peer.a) PeersStruct$Peer.newBuilder(this.peer_).v(peersStruct$Peer)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Tasks$RequestJoinTasksGroups parseDelimitedFrom(InputStream inputStream) {
        return (Tasks$RequestJoinTasksGroups) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Tasks$RequestJoinTasksGroups parseFrom(ByteBuffer byteBuffer) {
        return (Tasks$RequestJoinTasksGroups) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setPeer(PeersStruct$Peer peersStruct$Peer) {
        peersStruct$Peer.getClass();
        this.peer_ = peersStruct$Peer;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (g2.a[gVar.ordinal()]) {
            case 1:
                return new Tasks$RequestJoinTasksGroups();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "peer_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Tasks$RequestJoinTasksGroups.class) {
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

    public PeersStruct$Peer getPeer() {
        PeersStruct$Peer peersStruct$Peer = this.peer_;
        return peersStruct$Peer == null ? PeersStruct$Peer.getDefaultInstance() : peersStruct$Peer;
    }

    public boolean hasPeer() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(Tasks$RequestJoinTasksGroups tasks$RequestJoinTasksGroups) {
        return (a) DEFAULT_INSTANCE.createBuilder(tasks$RequestJoinTasksGroups);
    }

    public static Tasks$RequestJoinTasksGroups parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Tasks$RequestJoinTasksGroups) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Tasks$RequestJoinTasksGroups parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Tasks$RequestJoinTasksGroups) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Tasks$RequestJoinTasksGroups parseFrom(AbstractC2383g abstractC2383g) {
        return (Tasks$RequestJoinTasksGroups) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static Tasks$RequestJoinTasksGroups parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Tasks$RequestJoinTasksGroups) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Tasks$RequestJoinTasksGroups parseFrom(byte[] bArr) {
        return (Tasks$RequestJoinTasksGroups) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Tasks$RequestJoinTasksGroups parseFrom(byte[] bArr, C2394s c2394s) {
        return (Tasks$RequestJoinTasksGroups) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Tasks$RequestJoinTasksGroups parseFrom(InputStream inputStream) {
        return (Tasks$RequestJoinTasksGroups) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Tasks$RequestJoinTasksGroups parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Tasks$RequestJoinTasksGroups) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Tasks$RequestJoinTasksGroups parseFrom(AbstractC2384h abstractC2384h) {
        return (Tasks$RequestJoinTasksGroups) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Tasks$RequestJoinTasksGroups parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Tasks$RequestJoinTasksGroups) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
