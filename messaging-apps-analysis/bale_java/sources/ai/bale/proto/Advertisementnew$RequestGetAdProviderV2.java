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

/* loaded from: classes9.dex */
public final class Advertisementnew$RequestGetAdProviderV2 extends GeneratedMessageLite implements U64 {
    public static final int AD_COUNT_FIELD_NUMBER = 4;
    public static final int AD_SPOT_FIELD_NUMBER = 3;
    public static final int AD_TYPE_FIELD_NUMBER = 2;
    private static final Advertisementnew$RequestGetAdProviderV2 DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int PEER_ID_FIELD_NUMBER = 1;
    private long adCount_;
    private int adSpot_;
    private int adType_;
    private PeersStruct$GroupOutPeer peerId_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Advertisementnew$RequestGetAdProviderV2.DEFAULT_INSTANCE);
        }
    }

    static {
        Advertisementnew$RequestGetAdProviderV2 advertisementnew$RequestGetAdProviderV2 = new Advertisementnew$RequestGetAdProviderV2();
        DEFAULT_INSTANCE = advertisementnew$RequestGetAdProviderV2;
        GeneratedMessageLite.registerDefaultInstance(Advertisementnew$RequestGetAdProviderV2.class, advertisementnew$RequestGetAdProviderV2);
    }

    private Advertisementnew$RequestGetAdProviderV2() {
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
    }

    public static Advertisementnew$RequestGetAdProviderV2 getDefaultInstance() {
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
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Advertisementnew$RequestGetAdProviderV2 parseDelimitedFrom(InputStream inputStream) {
        return (Advertisementnew$RequestGetAdProviderV2) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Advertisementnew$RequestGetAdProviderV2 parseFrom(ByteBuffer byteBuffer) {
        return (Advertisementnew$RequestGetAdProviderV2) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAdCount(long j) {
        this.adCount_ = j;
    }

    private void setAdSpot(EnumC4938Hf enumC4938Hf) {
        this.adSpot_ = enumC4938Hf.getNumber();
    }

    private void setAdSpotValue(int i) {
        this.adSpot_ = i;
    }

    private void setAdType(EnumC8025Uf enumC8025Uf) {
        this.adType_ = enumC8025Uf.getNumber();
    }

    private void setAdTypeValue(int i) {
        this.adType_ = i;
    }

    private void setPeerId(PeersStruct$GroupOutPeer peersStruct$GroupOutPeer) {
        peersStruct$GroupOutPeer.getClass();
        this.peerId_ = peersStruct$GroupOutPeer;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1849e.a[gVar.ordinal()]) {
            case 1:
                return new Advertisementnew$RequestGetAdProviderV2();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\t\u0002\f\u0003\f\u0004\u0002", new Object[]{"peerId_", "adType_", "adSpot_", "adCount_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Advertisementnew$RequestGetAdProviderV2.class) {
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
        return this.peerId_ != null;
    }

    public static a newBuilder(Advertisementnew$RequestGetAdProviderV2 advertisementnew$RequestGetAdProviderV2) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementnew$RequestGetAdProviderV2);
    }

    public static Advertisementnew$RequestGetAdProviderV2 parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Advertisementnew$RequestGetAdProviderV2) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Advertisementnew$RequestGetAdProviderV2 parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Advertisementnew$RequestGetAdProviderV2) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Advertisementnew$RequestGetAdProviderV2 parseFrom(AbstractC2383g abstractC2383g) {
        return (Advertisementnew$RequestGetAdProviderV2) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static Advertisementnew$RequestGetAdProviderV2 parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Advertisementnew$RequestGetAdProviderV2) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Advertisementnew$RequestGetAdProviderV2 parseFrom(byte[] bArr) {
        return (Advertisementnew$RequestGetAdProviderV2) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Advertisementnew$RequestGetAdProviderV2 parseFrom(byte[] bArr, C2394s c2394s) {
        return (Advertisementnew$RequestGetAdProviderV2) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Advertisementnew$RequestGetAdProviderV2 parseFrom(InputStream inputStream) {
        return (Advertisementnew$RequestGetAdProviderV2) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Advertisementnew$RequestGetAdProviderV2 parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Advertisementnew$RequestGetAdProviderV2) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Advertisementnew$RequestGetAdProviderV2 parseFrom(AbstractC2384h abstractC2384h) {
        return (Advertisementnew$RequestGetAdProviderV2) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Advertisementnew$RequestGetAdProviderV2 parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Advertisementnew$RequestGetAdProviderV2) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
