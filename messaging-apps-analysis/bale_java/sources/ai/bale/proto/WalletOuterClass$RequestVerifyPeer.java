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
public final class WalletOuterClass$RequestVerifyPeer extends GeneratedMessageLite implements U64 {
    private static final WalletOuterClass$RequestVerifyPeer DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int TARGET_PEER_FIELD_NUMBER = 1;
    private int bitField0_;
    private PeersStruct$Peer targetPeer_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(WalletOuterClass$RequestVerifyPeer.DEFAULT_INSTANCE);
        }
    }

    static {
        WalletOuterClass$RequestVerifyPeer walletOuterClass$RequestVerifyPeer = new WalletOuterClass$RequestVerifyPeer();
        DEFAULT_INSTANCE = walletOuterClass$RequestVerifyPeer;
        GeneratedMessageLite.registerDefaultInstance(WalletOuterClass$RequestVerifyPeer.class, walletOuterClass$RequestVerifyPeer);
    }

    private WalletOuterClass$RequestVerifyPeer() {
    }

    private void clearTargetPeer() {
        this.targetPeer_ = null;
        this.bitField0_ &= -2;
    }

    public static WalletOuterClass$RequestVerifyPeer getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeTargetPeer(PeersStruct$Peer peersStruct$Peer) {
        peersStruct$Peer.getClass();
        PeersStruct$Peer peersStruct$Peer2 = this.targetPeer_;
        if (peersStruct$Peer2 == null || peersStruct$Peer2 == PeersStruct$Peer.getDefaultInstance()) {
            this.targetPeer_ = peersStruct$Peer;
        } else {
            this.targetPeer_ = (PeersStruct$Peer) ((PeersStruct$Peer.a) PeersStruct$Peer.newBuilder(this.targetPeer_).v(peersStruct$Peer)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static WalletOuterClass$RequestVerifyPeer parseDelimitedFrom(InputStream inputStream) {
        return (WalletOuterClass$RequestVerifyPeer) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static WalletOuterClass$RequestVerifyPeer parseFrom(ByteBuffer byteBuffer) {
        return (WalletOuterClass$RequestVerifyPeer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setTargetPeer(PeersStruct$Peer peersStruct$Peer) {
        peersStruct$Peer.getClass();
        this.targetPeer_ = peersStruct$Peer;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (u2.a[gVar.ordinal()]) {
            case 1:
                return new WalletOuterClass$RequestVerifyPeer();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "targetPeer_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (WalletOuterClass$RequestVerifyPeer.class) {
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

    public PeersStruct$Peer getTargetPeer() {
        PeersStruct$Peer peersStruct$Peer = this.targetPeer_;
        return peersStruct$Peer == null ? PeersStruct$Peer.getDefaultInstance() : peersStruct$Peer;
    }

    public boolean hasTargetPeer() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(WalletOuterClass$RequestVerifyPeer walletOuterClass$RequestVerifyPeer) {
        return (a) DEFAULT_INSTANCE.createBuilder(walletOuterClass$RequestVerifyPeer);
    }

    public static WalletOuterClass$RequestVerifyPeer parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (WalletOuterClass$RequestVerifyPeer) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static WalletOuterClass$RequestVerifyPeer parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (WalletOuterClass$RequestVerifyPeer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static WalletOuterClass$RequestVerifyPeer parseFrom(AbstractC2383g abstractC2383g) {
        return (WalletOuterClass$RequestVerifyPeer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static WalletOuterClass$RequestVerifyPeer parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (WalletOuterClass$RequestVerifyPeer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static WalletOuterClass$RequestVerifyPeer parseFrom(byte[] bArr) {
        return (WalletOuterClass$RequestVerifyPeer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static WalletOuterClass$RequestVerifyPeer parseFrom(byte[] bArr, C2394s c2394s) {
        return (WalletOuterClass$RequestVerifyPeer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static WalletOuterClass$RequestVerifyPeer parseFrom(InputStream inputStream) {
        return (WalletOuterClass$RequestVerifyPeer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static WalletOuterClass$RequestVerifyPeer parseFrom(InputStream inputStream, C2394s c2394s) {
        return (WalletOuterClass$RequestVerifyPeer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static WalletOuterClass$RequestVerifyPeer parseFrom(AbstractC2384h abstractC2384h) {
        return (WalletOuterClass$RequestVerifyPeer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static WalletOuterClass$RequestVerifyPeer parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (WalletOuterClass$RequestVerifyPeer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
