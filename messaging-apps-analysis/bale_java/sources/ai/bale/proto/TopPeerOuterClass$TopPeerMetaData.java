package ai.bale.proto;

import ai.bale.proto.PeersStruct$OutPeer;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC7677Ss7;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class TopPeerOuterClass$TopPeerMetaData extends GeneratedMessageLite implements InterfaceC7677Ss7 {
    private static final TopPeerOuterClass$TopPeerMetaData DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int PEER_FIELD_NUMBER = 2;
    public static final int SCORE_FIELD_NUMBER = 1;
    private int bitField0_;
    private PeersStruct$OutPeer peer_;
    private long score_;

    public static final class a extends GeneratedMessageLite.b implements InterfaceC7677Ss7 {
        private a() {
            super(TopPeerOuterClass$TopPeerMetaData.DEFAULT_INSTANCE);
        }
    }

    static {
        TopPeerOuterClass$TopPeerMetaData topPeerOuterClass$TopPeerMetaData = new TopPeerOuterClass$TopPeerMetaData();
        DEFAULT_INSTANCE = topPeerOuterClass$TopPeerMetaData;
        GeneratedMessageLite.registerDefaultInstance(TopPeerOuterClass$TopPeerMetaData.class, topPeerOuterClass$TopPeerMetaData);
    }

    private TopPeerOuterClass$TopPeerMetaData() {
    }

    private void clearPeer() {
        this.peer_ = null;
        this.bitField0_ &= -2;
    }

    private void clearScore() {
        this.score_ = 0L;
    }

    public static TopPeerOuterClass$TopPeerMetaData getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergePeer(PeersStruct$OutPeer peersStruct$OutPeer) {
        peersStruct$OutPeer.getClass();
        PeersStruct$OutPeer peersStruct$OutPeer2 = this.peer_;
        if (peersStruct$OutPeer2 == null || peersStruct$OutPeer2 == PeersStruct$OutPeer.getDefaultInstance()) {
            this.peer_ = peersStruct$OutPeer;
        } else {
            this.peer_ = (PeersStruct$OutPeer) ((PeersStruct$OutPeer.a) PeersStruct$OutPeer.newBuilder(this.peer_).v(peersStruct$OutPeer)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static TopPeerOuterClass$TopPeerMetaData parseDelimitedFrom(InputStream inputStream) {
        return (TopPeerOuterClass$TopPeerMetaData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static TopPeerOuterClass$TopPeerMetaData parseFrom(ByteBuffer byteBuffer) {
        return (TopPeerOuterClass$TopPeerMetaData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setPeer(PeersStruct$OutPeer peersStruct$OutPeer) {
        peersStruct$OutPeer.getClass();
        this.peer_ = peersStruct$OutPeer;
        this.bitField0_ |= 1;
    }

    private void setScore(long j) {
        this.score_ = j;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (l2.a[gVar.ordinal()]) {
            case 1:
                return new TopPeerOuterClass$TopPeerMetaData();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0002\u0002ဉ\u0000", new Object[]{"bitField0_", "score_", "peer_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (TopPeerOuterClass$TopPeerMetaData.class) {
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

    public PeersStruct$OutPeer getPeer() {
        PeersStruct$OutPeer peersStruct$OutPeer = this.peer_;
        return peersStruct$OutPeer == null ? PeersStruct$OutPeer.getDefaultInstance() : peersStruct$OutPeer;
    }

    public long getScore() {
        return this.score_;
    }

    public boolean hasPeer() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(TopPeerOuterClass$TopPeerMetaData topPeerOuterClass$TopPeerMetaData) {
        return (a) DEFAULT_INSTANCE.createBuilder(topPeerOuterClass$TopPeerMetaData);
    }

    public static TopPeerOuterClass$TopPeerMetaData parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (TopPeerOuterClass$TopPeerMetaData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static TopPeerOuterClass$TopPeerMetaData parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (TopPeerOuterClass$TopPeerMetaData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static TopPeerOuterClass$TopPeerMetaData parseFrom(AbstractC2383g abstractC2383g) {
        return (TopPeerOuterClass$TopPeerMetaData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static TopPeerOuterClass$TopPeerMetaData parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (TopPeerOuterClass$TopPeerMetaData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static TopPeerOuterClass$TopPeerMetaData parseFrom(byte[] bArr) {
        return (TopPeerOuterClass$TopPeerMetaData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static TopPeerOuterClass$TopPeerMetaData parseFrom(byte[] bArr, C2394s c2394s) {
        return (TopPeerOuterClass$TopPeerMetaData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static TopPeerOuterClass$TopPeerMetaData parseFrom(InputStream inputStream) {
        return (TopPeerOuterClass$TopPeerMetaData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static TopPeerOuterClass$TopPeerMetaData parseFrom(InputStream inputStream, C2394s c2394s) {
        return (TopPeerOuterClass$TopPeerMetaData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static TopPeerOuterClass$TopPeerMetaData parseFrom(AbstractC2384h abstractC2384h) {
        return (TopPeerOuterClass$TopPeerMetaData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static TopPeerOuterClass$TopPeerMetaData parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (TopPeerOuterClass$TopPeerMetaData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
