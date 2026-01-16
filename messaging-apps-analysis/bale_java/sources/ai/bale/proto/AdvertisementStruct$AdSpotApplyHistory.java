package ai.bale.proto;

import ai.bale.proto.PeersStruct$GroupOutPeer;
import ai.bale.proto.PeersStruct$UserOutPeer;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC4938Hf;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes8.dex */
public final class AdvertisementStruct$AdSpotApplyHistory extends GeneratedMessageLite implements U64 {
    public static final int AD_SPOT_FIELD_NUMBER = 3;
    public static final int CHANNEL_ID_FIELD_NUMBER = 2;
    private static final AdvertisementStruct$AdSpotApplyHistory DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int USER_ID_FIELD_NUMBER = 1;
    private int adSpot_;
    private int bitField0_;
    private PeersStruct$GroupOutPeer channelId_;
    private PeersStruct$UserOutPeer userId_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(AdvertisementStruct$AdSpotApplyHistory.DEFAULT_INSTANCE);
        }
    }

    static {
        AdvertisementStruct$AdSpotApplyHistory advertisementStruct$AdSpotApplyHistory = new AdvertisementStruct$AdSpotApplyHistory();
        DEFAULT_INSTANCE = advertisementStruct$AdSpotApplyHistory;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementStruct$AdSpotApplyHistory.class, advertisementStruct$AdSpotApplyHistory);
    }

    private AdvertisementStruct$AdSpotApplyHistory() {
    }

    private void clearAdSpot() {
        this.adSpot_ = 0;
    }

    private void clearChannelId() {
        this.channelId_ = null;
        this.bitField0_ &= -3;
    }

    private void clearUserId() {
        this.userId_ = null;
        this.bitField0_ &= -2;
    }

    public static AdvertisementStruct$AdSpotApplyHistory getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeChannelId(PeersStruct$GroupOutPeer peersStruct$GroupOutPeer) {
        peersStruct$GroupOutPeer.getClass();
        PeersStruct$GroupOutPeer peersStruct$GroupOutPeer2 = this.channelId_;
        if (peersStruct$GroupOutPeer2 == null || peersStruct$GroupOutPeer2 == PeersStruct$GroupOutPeer.getDefaultInstance()) {
            this.channelId_ = peersStruct$GroupOutPeer;
        } else {
            this.channelId_ = (PeersStruct$GroupOutPeer) ((PeersStruct$GroupOutPeer.a) PeersStruct$GroupOutPeer.newBuilder(this.channelId_).v(peersStruct$GroupOutPeer)).j();
        }
        this.bitField0_ |= 2;
    }

    private void mergeUserId(PeersStruct$UserOutPeer peersStruct$UserOutPeer) {
        peersStruct$UserOutPeer.getClass();
        PeersStruct$UserOutPeer peersStruct$UserOutPeer2 = this.userId_;
        if (peersStruct$UserOutPeer2 == null || peersStruct$UserOutPeer2 == PeersStruct$UserOutPeer.getDefaultInstance()) {
            this.userId_ = peersStruct$UserOutPeer;
        } else {
            this.userId_ = (PeersStruct$UserOutPeer) ((PeersStruct$UserOutPeer.a) PeersStruct$UserOutPeer.newBuilder(this.userId_).v(peersStruct$UserOutPeer)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AdvertisementStruct$AdSpotApplyHistory parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementStruct$AdSpotApplyHistory) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementStruct$AdSpotApplyHistory parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementStruct$AdSpotApplyHistory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAdSpot(EnumC4938Hf enumC4938Hf) {
        this.adSpot_ = enumC4938Hf.getNumber();
    }

    private void setAdSpotValue(int i) {
        this.adSpot_ = i;
    }

    private void setChannelId(PeersStruct$GroupOutPeer peersStruct$GroupOutPeer) {
        peersStruct$GroupOutPeer.getClass();
        this.channelId_ = peersStruct$GroupOutPeer;
        this.bitField0_ |= 2;
    }

    private void setUserId(PeersStruct$UserOutPeer peersStruct$UserOutPeer) {
        peersStruct$UserOutPeer.getClass();
        this.userId_ = peersStruct$UserOutPeer;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1843c.a[gVar.ordinal()]) {
            case 1:
                return new AdvertisementStruct$AdSpotApplyHistory();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003\f", new Object[]{"bitField0_", "userId_", "channelId_", "adSpot_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementStruct$AdSpotApplyHistory.class) {
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

    public EnumC4938Hf getAdSpot() {
        EnumC4938Hf enumC4938HfJ = EnumC4938Hf.j(this.adSpot_);
        return enumC4938HfJ == null ? EnumC4938Hf.UNRECOGNIZED : enumC4938HfJ;
    }

    public int getAdSpotValue() {
        return this.adSpot_;
    }

    public PeersStruct$GroupOutPeer getChannelId() {
        PeersStruct$GroupOutPeer peersStruct$GroupOutPeer = this.channelId_;
        return peersStruct$GroupOutPeer == null ? PeersStruct$GroupOutPeer.getDefaultInstance() : peersStruct$GroupOutPeer;
    }

    public PeersStruct$UserOutPeer getUserId() {
        PeersStruct$UserOutPeer peersStruct$UserOutPeer = this.userId_;
        return peersStruct$UserOutPeer == null ? PeersStruct$UserOutPeer.getDefaultInstance() : peersStruct$UserOutPeer;
    }

    public boolean hasChannelId() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasUserId() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(AdvertisementStruct$AdSpotApplyHistory advertisementStruct$AdSpotApplyHistory) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementStruct$AdSpotApplyHistory);
    }

    public static AdvertisementStruct$AdSpotApplyHistory parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementStruct$AdSpotApplyHistory) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementStruct$AdSpotApplyHistory parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementStruct$AdSpotApplyHistory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementStruct$AdSpotApplyHistory parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementStruct$AdSpotApplyHistory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AdvertisementStruct$AdSpotApplyHistory parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementStruct$AdSpotApplyHistory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementStruct$AdSpotApplyHistory parseFrom(byte[] bArr) {
        return (AdvertisementStruct$AdSpotApplyHistory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementStruct$AdSpotApplyHistory parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementStruct$AdSpotApplyHistory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AdvertisementStruct$AdSpotApplyHistory parseFrom(InputStream inputStream) {
        return (AdvertisementStruct$AdSpotApplyHistory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementStruct$AdSpotApplyHistory parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementStruct$AdSpotApplyHistory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementStruct$AdSpotApplyHistory parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementStruct$AdSpotApplyHistory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementStruct$AdSpotApplyHistory parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementStruct$AdSpotApplyHistory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
