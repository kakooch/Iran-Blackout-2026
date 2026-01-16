package ai.bale.proto;

import ai.bale.proto.PeersStruct$ExPeer;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC15129j35;
import ir.nasim.InterfaceC6355Ng;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class AdvertisementStruct$ContactPopularChannel extends GeneratedMessageLite implements InterfaceC6355Ng {
    public static final int CONTACT_MEMBER_COUNT_FIELD_NUMBER = 3;
    private static final AdvertisementStruct$ContactPopularChannel DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int PEER_FIELD_NUMBER = 1;
    public static final int PEER_IDENTITY_FIELD_NUMBER = 2;
    private int bitField0_;
    private int contactMemberCount_;
    private int peerIdentity_;
    private PeersStruct$ExPeer peer_;

    public static final class a extends GeneratedMessageLite.b implements InterfaceC6355Ng {
        private a() {
            super(AdvertisementStruct$ContactPopularChannel.DEFAULT_INSTANCE);
        }
    }

    static {
        AdvertisementStruct$ContactPopularChannel advertisementStruct$ContactPopularChannel = new AdvertisementStruct$ContactPopularChannel();
        DEFAULT_INSTANCE = advertisementStruct$ContactPopularChannel;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementStruct$ContactPopularChannel.class, advertisementStruct$ContactPopularChannel);
    }

    private AdvertisementStruct$ContactPopularChannel() {
    }

    private void clearContactMemberCount() {
        this.contactMemberCount_ = 0;
    }

    private void clearPeer() {
        this.peer_ = null;
        this.bitField0_ &= -2;
    }

    private void clearPeerIdentity() {
        this.peerIdentity_ = 0;
    }

    public static AdvertisementStruct$ContactPopularChannel getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergePeer(PeersStruct$ExPeer peersStruct$ExPeer) {
        peersStruct$ExPeer.getClass();
        PeersStruct$ExPeer peersStruct$ExPeer2 = this.peer_;
        if (peersStruct$ExPeer2 == null || peersStruct$ExPeer2 == PeersStruct$ExPeer.getDefaultInstance()) {
            this.peer_ = peersStruct$ExPeer;
        } else {
            this.peer_ = (PeersStruct$ExPeer) ((PeersStruct$ExPeer.a) PeersStruct$ExPeer.newBuilder(this.peer_).v(peersStruct$ExPeer)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AdvertisementStruct$ContactPopularChannel parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementStruct$ContactPopularChannel) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementStruct$ContactPopularChannel parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementStruct$ContactPopularChannel) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setContactMemberCount(int i) {
        this.contactMemberCount_ = i;
    }

    private void setPeer(PeersStruct$ExPeer peersStruct$ExPeer) {
        peersStruct$ExPeer.getClass();
        this.peer_ = peersStruct$ExPeer;
        this.bitField0_ |= 1;
    }

    private void setPeerIdentity(EnumC15129j35 enumC15129j35) {
        this.peerIdentity_ = enumC15129j35.getNumber();
    }

    private void setPeerIdentityValue(int i) {
        this.peerIdentity_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1843c.a[gVar.ordinal()]) {
            case 1:
                return new AdvertisementStruct$ContactPopularChannel();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002\f\u0003\u0004", new Object[]{"bitField0_", "peer_", "peerIdentity_", "contactMemberCount_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementStruct$ContactPopularChannel.class) {
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

    public int getContactMemberCount() {
        return this.contactMemberCount_;
    }

    public PeersStruct$ExPeer getPeer() {
        PeersStruct$ExPeer peersStruct$ExPeer = this.peer_;
        return peersStruct$ExPeer == null ? PeersStruct$ExPeer.getDefaultInstance() : peersStruct$ExPeer;
    }

    public EnumC15129j35 getPeerIdentity() {
        EnumC15129j35 enumC15129j35J = EnumC15129j35.j(this.peerIdentity_);
        return enumC15129j35J == null ? EnumC15129j35.UNRECOGNIZED : enumC15129j35J;
    }

    public int getPeerIdentityValue() {
        return this.peerIdentity_;
    }

    public boolean hasPeer() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(AdvertisementStruct$ContactPopularChannel advertisementStruct$ContactPopularChannel) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementStruct$ContactPopularChannel);
    }

    public static AdvertisementStruct$ContactPopularChannel parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementStruct$ContactPopularChannel) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementStruct$ContactPopularChannel parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementStruct$ContactPopularChannel) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementStruct$ContactPopularChannel parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementStruct$ContactPopularChannel) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AdvertisementStruct$ContactPopularChannel parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementStruct$ContactPopularChannel) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementStruct$ContactPopularChannel parseFrom(byte[] bArr) {
        return (AdvertisementStruct$ContactPopularChannel) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementStruct$ContactPopularChannel parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementStruct$ContactPopularChannel) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AdvertisementStruct$ContactPopularChannel parseFrom(InputStream inputStream) {
        return (AdvertisementStruct$ContactPopularChannel) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementStruct$ContactPopularChannel parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementStruct$ContactPopularChannel) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementStruct$ContactPopularChannel parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementStruct$ContactPopularChannel) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementStruct$ContactPopularChannel parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementStruct$ContactPopularChannel) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
