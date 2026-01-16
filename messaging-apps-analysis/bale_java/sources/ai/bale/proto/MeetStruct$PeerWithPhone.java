package ai.bale.proto;

import ai.bale.proto.PeersStruct$Peer;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class MeetStruct$PeerWithPhone extends GeneratedMessageLite implements U64 {
    private static final MeetStruct$PeerWithPhone DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int PEER_FIELD_NUMBER = 1;
    public static final int PHONE_NO_FIELD_NUMBER = 2;
    private int bitField0_;
    private PeersStruct$Peer peer_;
    private String phoneNo_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MeetStruct$PeerWithPhone.DEFAULT_INSTANCE);
        }
    }

    static {
        MeetStruct$PeerWithPhone meetStruct$PeerWithPhone = new MeetStruct$PeerWithPhone();
        DEFAULT_INSTANCE = meetStruct$PeerWithPhone;
        GeneratedMessageLite.registerDefaultInstance(MeetStruct$PeerWithPhone.class, meetStruct$PeerWithPhone);
    }

    private MeetStruct$PeerWithPhone() {
    }

    private void clearPeer() {
        this.peer_ = null;
        this.bitField0_ &= -2;
    }

    private void clearPhoneNo() {
        this.phoneNo_ = getDefaultInstance().getPhoneNo();
    }

    public static MeetStruct$PeerWithPhone getDefaultInstance() {
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

    public static MeetStruct$PeerWithPhone parseDelimitedFrom(InputStream inputStream) {
        return (MeetStruct$PeerWithPhone) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MeetStruct$PeerWithPhone parseFrom(ByteBuffer byteBuffer) {
        return (MeetStruct$PeerWithPhone) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setPeer(PeersStruct$Peer peersStruct$Peer) {
        peersStruct$Peer.getClass();
        this.peer_ = peersStruct$Peer;
        this.bitField0_ |= 1;
    }

    private void setPhoneNo(String str) {
        str.getClass();
        this.phoneNo_ = str;
    }

    private void setPhoneNoBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.phoneNo_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (G0.a[gVar.ordinal()]) {
            case 1:
                return new MeetStruct$PeerWithPhone();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002Ȉ", new Object[]{"bitField0_", "peer_", "phoneNo_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MeetStruct$PeerWithPhone.class) {
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

    public String getPhoneNo() {
        return this.phoneNo_;
    }

    public AbstractC2383g getPhoneNoBytes() {
        return AbstractC2383g.N(this.phoneNo_);
    }

    public boolean hasPeer() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(MeetStruct$PeerWithPhone meetStruct$PeerWithPhone) {
        return (a) DEFAULT_INSTANCE.createBuilder(meetStruct$PeerWithPhone);
    }

    public static MeetStruct$PeerWithPhone parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MeetStruct$PeerWithPhone) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MeetStruct$PeerWithPhone parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MeetStruct$PeerWithPhone) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MeetStruct$PeerWithPhone parseFrom(AbstractC2383g abstractC2383g) {
        return (MeetStruct$PeerWithPhone) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MeetStruct$PeerWithPhone parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MeetStruct$PeerWithPhone) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MeetStruct$PeerWithPhone parseFrom(byte[] bArr) {
        return (MeetStruct$PeerWithPhone) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MeetStruct$PeerWithPhone parseFrom(byte[] bArr, C2394s c2394s) {
        return (MeetStruct$PeerWithPhone) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MeetStruct$PeerWithPhone parseFrom(InputStream inputStream) {
        return (MeetStruct$PeerWithPhone) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MeetStruct$PeerWithPhone parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MeetStruct$PeerWithPhone) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MeetStruct$PeerWithPhone parseFrom(AbstractC2384h abstractC2384h) {
        return (MeetStruct$PeerWithPhone) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MeetStruct$PeerWithPhone parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MeetStruct$PeerWithPhone) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
