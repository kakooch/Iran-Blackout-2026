package ai.bale.proto;

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
public final class PresenceStruct$UserOnline extends GeneratedMessageLite implements U64 {
    private static final PresenceStruct$UserOnline DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int PEER_FIELD_NUMBER = 1;
    private int bitField0_;
    private PeersStruct$UserOutPeer peer_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(PresenceStruct$UserOnline.DEFAULT_INSTANCE);
        }
    }

    static {
        PresenceStruct$UserOnline presenceStruct$UserOnline = new PresenceStruct$UserOnline();
        DEFAULT_INSTANCE = presenceStruct$UserOnline;
        GeneratedMessageLite.registerDefaultInstance(PresenceStruct$UserOnline.class, presenceStruct$UserOnline);
    }

    private PresenceStruct$UserOnline() {
    }

    private void clearPeer() {
        this.peer_ = null;
        this.bitField0_ &= -2;
    }

    public static PresenceStruct$UserOnline getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergePeer(PeersStruct$UserOutPeer peersStruct$UserOutPeer) {
        peersStruct$UserOutPeer.getClass();
        PeersStruct$UserOutPeer peersStruct$UserOutPeer2 = this.peer_;
        if (peersStruct$UserOutPeer2 == null || peersStruct$UserOutPeer2 == PeersStruct$UserOutPeer.getDefaultInstance()) {
            this.peer_ = peersStruct$UserOutPeer;
        } else {
            this.peer_ = (PeersStruct$UserOutPeer) ((PeersStruct$UserOutPeer.a) PeersStruct$UserOutPeer.newBuilder(this.peer_).v(peersStruct$UserOutPeer)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static PresenceStruct$UserOnline parseDelimitedFrom(InputStream inputStream) {
        return (PresenceStruct$UserOnline) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PresenceStruct$UserOnline parseFrom(ByteBuffer byteBuffer) {
        return (PresenceStruct$UserOnline) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setPeer(PeersStruct$UserOutPeer peersStruct$UserOutPeer) {
        peersStruct$UserOutPeer.getClass();
        this.peer_ = peersStruct$UserOutPeer;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1869k1.a[gVar.ordinal()]) {
            case 1:
                return new PresenceStruct$UserOnline();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "peer_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (PresenceStruct$UserOnline.class) {
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

    public PeersStruct$UserOutPeer getPeer() {
        PeersStruct$UserOutPeer peersStruct$UserOutPeer = this.peer_;
        return peersStruct$UserOutPeer == null ? PeersStruct$UserOutPeer.getDefaultInstance() : peersStruct$UserOutPeer;
    }

    public boolean hasPeer() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(PresenceStruct$UserOnline presenceStruct$UserOnline) {
        return (a) DEFAULT_INSTANCE.createBuilder(presenceStruct$UserOnline);
    }

    public static PresenceStruct$UserOnline parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (PresenceStruct$UserOnline) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PresenceStruct$UserOnline parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (PresenceStruct$UserOnline) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static PresenceStruct$UserOnline parseFrom(AbstractC2383g abstractC2383g) {
        return (PresenceStruct$UserOnline) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static PresenceStruct$UserOnline parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (PresenceStruct$UserOnline) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static PresenceStruct$UserOnline parseFrom(byte[] bArr) {
        return (PresenceStruct$UserOnline) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PresenceStruct$UserOnline parseFrom(byte[] bArr, C2394s c2394s) {
        return (PresenceStruct$UserOnline) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static PresenceStruct$UserOnline parseFrom(InputStream inputStream) {
        return (PresenceStruct$UserOnline) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PresenceStruct$UserOnline parseFrom(InputStream inputStream, C2394s c2394s) {
        return (PresenceStruct$UserOnline) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PresenceStruct$UserOnline parseFrom(AbstractC2384h abstractC2384h) {
        return (PresenceStruct$UserOnline) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static PresenceStruct$UserOnline parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (PresenceStruct$UserOnline) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
