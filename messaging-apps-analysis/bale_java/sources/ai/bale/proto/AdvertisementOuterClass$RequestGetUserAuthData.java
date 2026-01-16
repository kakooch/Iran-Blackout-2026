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
public final class AdvertisementOuterClass$RequestGetUserAuthData extends GeneratedMessageLite implements U64 {
    public static final int CHANNEL_ID_FIELD_NUMBER = 1;
    private static final AdvertisementOuterClass$RequestGetUserAuthData DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private PeersStruct$GroupOutPeer channelId_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(AdvertisementOuterClass$RequestGetUserAuthData.DEFAULT_INSTANCE);
        }
    }

    static {
        AdvertisementOuterClass$RequestGetUserAuthData advertisementOuterClass$RequestGetUserAuthData = new AdvertisementOuterClass$RequestGetUserAuthData();
        DEFAULT_INSTANCE = advertisementOuterClass$RequestGetUserAuthData;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementOuterClass$RequestGetUserAuthData.class, advertisementOuterClass$RequestGetUserAuthData);
    }

    private AdvertisementOuterClass$RequestGetUserAuthData() {
    }

    private void clearChannelId() {
        this.channelId_ = null;
        this.bitField0_ &= -2;
    }

    public static AdvertisementOuterClass$RequestGetUserAuthData getDefaultInstance() {
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
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AdvertisementOuterClass$RequestGetUserAuthData parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$RequestGetUserAuthData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$RequestGetUserAuthData parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementOuterClass$RequestGetUserAuthData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setChannelId(PeersStruct$GroupOutPeer peersStruct$GroupOutPeer) {
        peersStruct$GroupOutPeer.getClass();
        this.channelId_ = peersStruct$GroupOutPeer;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1840b.a[gVar.ordinal()]) {
            case 1:
                return new AdvertisementOuterClass$RequestGetUserAuthData();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "channelId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementOuterClass$RequestGetUserAuthData.class) {
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

    public PeersStruct$GroupOutPeer getChannelId() {
        PeersStruct$GroupOutPeer peersStruct$GroupOutPeer = this.channelId_;
        return peersStruct$GroupOutPeer == null ? PeersStruct$GroupOutPeer.getDefaultInstance() : peersStruct$GroupOutPeer;
    }

    public boolean hasChannelId() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(AdvertisementOuterClass$RequestGetUserAuthData advertisementOuterClass$RequestGetUserAuthData) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementOuterClass$RequestGetUserAuthData);
    }

    public static AdvertisementOuterClass$RequestGetUserAuthData parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestGetUserAuthData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$RequestGetUserAuthData parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestGetUserAuthData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementOuterClass$RequestGetUserAuthData parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementOuterClass$RequestGetUserAuthData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AdvertisementOuterClass$RequestGetUserAuthData parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestGetUserAuthData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementOuterClass$RequestGetUserAuthData parseFrom(byte[] bArr) {
        return (AdvertisementOuterClass$RequestGetUserAuthData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementOuterClass$RequestGetUserAuthData parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestGetUserAuthData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AdvertisementOuterClass$RequestGetUserAuthData parseFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$RequestGetUserAuthData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$RequestGetUserAuthData parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestGetUserAuthData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$RequestGetUserAuthData parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementOuterClass$RequestGetUserAuthData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementOuterClass$RequestGetUserAuthData parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestGetUserAuthData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
