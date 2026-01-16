package ai.bale.proto;

import ai.bale.proto.PeersStruct$GroupOutPeer;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC4938Hf;
import ir.nasim.EnumC8025Uf;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes8.dex */
public final class AdvertisementOuterClass$RequestGetAdProvider extends GeneratedMessageLite implements U64 {
    public static final int AD_COUNT_FIELD_NUMBER = 4;
    public static final int AD_SPOT_FIELD_NUMBER = 3;
    public static final int AD_TYPE_FIELD_NUMBER = 2;
    private static final AdvertisementOuterClass$RequestGetAdProvider DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int PEER_ID_FIELD_NUMBER = 1;
    private long adCount_;
    private int adSpot_;
    private int adType_;
    private int bitField0_;
    private PeersStruct$GroupOutPeer peerId_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(long j) {
            q();
            ((AdvertisementOuterClass$RequestGetAdProvider) this.b).setAdCount(j);
            return this;
        }

        public a B(EnumC4938Hf enumC4938Hf) {
            q();
            ((AdvertisementOuterClass$RequestGetAdProvider) this.b).setAdSpot(enumC4938Hf);
            return this;
        }

        public a C(EnumC8025Uf enumC8025Uf) {
            q();
            ((AdvertisementOuterClass$RequestGetAdProvider) this.b).setAdType(enumC8025Uf);
            return this;
        }

        public a D(PeersStruct$GroupOutPeer peersStruct$GroupOutPeer) {
            q();
            ((AdvertisementOuterClass$RequestGetAdProvider) this.b).setPeerId(peersStruct$GroupOutPeer);
            return this;
        }

        private a() {
            super(AdvertisementOuterClass$RequestGetAdProvider.DEFAULT_INSTANCE);
        }
    }

    static {
        AdvertisementOuterClass$RequestGetAdProvider advertisementOuterClass$RequestGetAdProvider = new AdvertisementOuterClass$RequestGetAdProvider();
        DEFAULT_INSTANCE = advertisementOuterClass$RequestGetAdProvider;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementOuterClass$RequestGetAdProvider.class, advertisementOuterClass$RequestGetAdProvider);
    }

    private AdvertisementOuterClass$RequestGetAdProvider() {
    }

    private void clearAdCount() {
        this.adCount_ = 0L;
    }

    private void clearAdSpot() {
        this.adSpot_ = 0;
    }

    private void clearAdType() {
        this.adType_ = 0;
    }

    private void clearPeerId() {
        this.peerId_ = null;
        this.bitField0_ &= -2;
    }

    public static AdvertisementOuterClass$RequestGetAdProvider getDefaultInstance() {
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

    public static AdvertisementOuterClass$RequestGetAdProvider parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$RequestGetAdProvider) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$RequestGetAdProvider parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementOuterClass$RequestGetAdProvider) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAdCount(long j) {
        this.adCount_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAdSpot(EnumC4938Hf enumC4938Hf) {
        this.adSpot_ = enumC4938Hf.getNumber();
    }

    private void setAdSpotValue(int i) {
        this.adSpot_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAdType(EnumC8025Uf enumC8025Uf) {
        this.adType_ = enumC8025Uf.getNumber();
    }

    private void setAdTypeValue(int i) {
        this.adType_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPeerId(PeersStruct$GroupOutPeer peersStruct$GroupOutPeer) {
        peersStruct$GroupOutPeer.getClass();
        this.peerId_ = peersStruct$GroupOutPeer;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1840b.a[gVar.ordinal()]) {
            case 1:
                return new AdvertisementOuterClass$RequestGetAdProvider();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002\f\u0003\f\u0004\u0002", new Object[]{"bitField0_", "peerId_", "adType_", "adSpot_", "adCount_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementOuterClass$RequestGetAdProvider.class) {
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

    public long getAdCount() {
        return this.adCount_;
    }

    public EnumC4938Hf getAdSpot() {
        EnumC4938Hf enumC4938HfJ = EnumC4938Hf.j(this.adSpot_);
        return enumC4938HfJ == null ? EnumC4938Hf.UNRECOGNIZED : enumC4938HfJ;
    }

    public int getAdSpotValue() {
        return this.adSpot_;
    }

    public EnumC8025Uf getAdType() {
        EnumC8025Uf enumC8025UfJ = EnumC8025Uf.j(this.adType_);
        return enumC8025UfJ == null ? EnumC8025Uf.UNRECOGNIZED : enumC8025UfJ;
    }

    public int getAdTypeValue() {
        return this.adType_;
    }

    public PeersStruct$GroupOutPeer getPeerId() {
        PeersStruct$GroupOutPeer peersStruct$GroupOutPeer = this.peerId_;
        return peersStruct$GroupOutPeer == null ? PeersStruct$GroupOutPeer.getDefaultInstance() : peersStruct$GroupOutPeer;
    }

    public boolean hasPeerId() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(AdvertisementOuterClass$RequestGetAdProvider advertisementOuterClass$RequestGetAdProvider) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementOuterClass$RequestGetAdProvider);
    }

    public static AdvertisementOuterClass$RequestGetAdProvider parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestGetAdProvider) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$RequestGetAdProvider parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestGetAdProvider) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementOuterClass$RequestGetAdProvider parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementOuterClass$RequestGetAdProvider) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AdvertisementOuterClass$RequestGetAdProvider parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestGetAdProvider) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementOuterClass$RequestGetAdProvider parseFrom(byte[] bArr) {
        return (AdvertisementOuterClass$RequestGetAdProvider) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementOuterClass$RequestGetAdProvider parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestGetAdProvider) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AdvertisementOuterClass$RequestGetAdProvider parseFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$RequestGetAdProvider) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$RequestGetAdProvider parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestGetAdProvider) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$RequestGetAdProvider parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementOuterClass$RequestGetAdProvider) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementOuterClass$RequestGetAdProvider parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestGetAdProvider) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
