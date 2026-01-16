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

/* loaded from: classes8.dex */
public final class AdvertisementOuterClass$RequestGetChannelShowAdTimeRestrict extends GeneratedMessageLite implements U64 {
    private static final AdvertisementOuterClass$RequestGetChannelShowAdTimeRestrict DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int PEER_ID_FIELD_NUMBER = 1;
    private int bitField0_;
    private PeersStruct$GroupOutPeer peerId_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(AdvertisementOuterClass$RequestGetChannelShowAdTimeRestrict.DEFAULT_INSTANCE);
        }
    }

    static {
        AdvertisementOuterClass$RequestGetChannelShowAdTimeRestrict advertisementOuterClass$RequestGetChannelShowAdTimeRestrict = new AdvertisementOuterClass$RequestGetChannelShowAdTimeRestrict();
        DEFAULT_INSTANCE = advertisementOuterClass$RequestGetChannelShowAdTimeRestrict;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementOuterClass$RequestGetChannelShowAdTimeRestrict.class, advertisementOuterClass$RequestGetChannelShowAdTimeRestrict);
    }

    private AdvertisementOuterClass$RequestGetChannelShowAdTimeRestrict() {
    }

    private void clearPeerId() {
        this.peerId_ = null;
        this.bitField0_ &= -2;
    }

    public static AdvertisementOuterClass$RequestGetChannelShowAdTimeRestrict getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergePeerId(PeersStruct$GroupOutPeer peersStruct$GroupOutPeer) {
        peersStruct$GroupOutPeer.getClass();
        PeersStruct$GroupOutPeer peersStruct$GroupOutPeer2 = this.peerId_;
        if (peersStruct$GroupOutPeer2 == null || peersStruct$GroupOutPeer2 == PeersStruct$GroupOutPeer.getDefaultInstance()) {
            this.peerId_ = peersStruct$GroupOutPeer;
        } else {
            this.peerId_ = (PeersStruct$GroupOutPeer) ((PeersStruct$GroupOutPeer.a) PeersStruct$GroupOutPeer.newBuilder(this.peerId_).v(peersStruct$GroupOutPeer)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AdvertisementOuterClass$RequestGetChannelShowAdTimeRestrict parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$RequestGetChannelShowAdTimeRestrict) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$RequestGetChannelShowAdTimeRestrict parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementOuterClass$RequestGetChannelShowAdTimeRestrict) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setPeerId(PeersStruct$GroupOutPeer peersStruct$GroupOutPeer) {
        peersStruct$GroupOutPeer.getClass();
        this.peerId_ = peersStruct$GroupOutPeer;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1840b.a[gVar.ordinal()]) {
            case 1:
                return new AdvertisementOuterClass$RequestGetChannelShowAdTimeRestrict();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "peerId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementOuterClass$RequestGetChannelShowAdTimeRestrict.class) {
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

    public PeersStruct$GroupOutPeer getPeerId() {
        PeersStruct$GroupOutPeer peersStruct$GroupOutPeer = this.peerId_;
        return peersStruct$GroupOutPeer == null ? PeersStruct$GroupOutPeer.getDefaultInstance() : peersStruct$GroupOutPeer;
    }

    public boolean hasPeerId() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(AdvertisementOuterClass$RequestGetChannelShowAdTimeRestrict advertisementOuterClass$RequestGetChannelShowAdTimeRestrict) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementOuterClass$RequestGetChannelShowAdTimeRestrict);
    }

    public static AdvertisementOuterClass$RequestGetChannelShowAdTimeRestrict parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestGetChannelShowAdTimeRestrict) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$RequestGetChannelShowAdTimeRestrict parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestGetChannelShowAdTimeRestrict) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementOuterClass$RequestGetChannelShowAdTimeRestrict parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementOuterClass$RequestGetChannelShowAdTimeRestrict) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AdvertisementOuterClass$RequestGetChannelShowAdTimeRestrict parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestGetChannelShowAdTimeRestrict) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementOuterClass$RequestGetChannelShowAdTimeRestrict parseFrom(byte[] bArr) {
        return (AdvertisementOuterClass$RequestGetChannelShowAdTimeRestrict) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementOuterClass$RequestGetChannelShowAdTimeRestrict parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestGetChannelShowAdTimeRestrict) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AdvertisementOuterClass$RequestGetChannelShowAdTimeRestrict parseFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$RequestGetChannelShowAdTimeRestrict) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$RequestGetChannelShowAdTimeRestrict parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestGetChannelShowAdTimeRestrict) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$RequestGetChannelShowAdTimeRestrict parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementOuterClass$RequestGetChannelShowAdTimeRestrict) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementOuterClass$RequestGetChannelShowAdTimeRestrict parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestGetChannelShowAdTimeRestrict) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
