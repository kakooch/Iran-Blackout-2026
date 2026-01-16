package ai.bale.proto;

import ai.bale.proto.PeersStruct$GroupOutPeer;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC3996Dg;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes8.dex */
public final class AdvertisementStruct$ChannelIncomeFactor extends GeneratedMessageLite implements InterfaceC3996Dg {
    public static final int CHANNEL_ID_FIELD_NUMBER = 1;
    private static final AdvertisementStruct$ChannelIncomeFactor DEFAULT_INSTANCE;
    public static final int FILE_ID_FIELD_NUMBER = 3;
    public static final int OWNER_ID_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private PeersStruct$GroupOutPeer channelId_;
    private long fileId_;
    private int ownerId_;

    public static final class a extends GeneratedMessageLite.b implements InterfaceC3996Dg {
        private a() {
            super(AdvertisementStruct$ChannelIncomeFactor.DEFAULT_INSTANCE);
        }
    }

    static {
        AdvertisementStruct$ChannelIncomeFactor advertisementStruct$ChannelIncomeFactor = new AdvertisementStruct$ChannelIncomeFactor();
        DEFAULT_INSTANCE = advertisementStruct$ChannelIncomeFactor;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementStruct$ChannelIncomeFactor.class, advertisementStruct$ChannelIncomeFactor);
    }

    private AdvertisementStruct$ChannelIncomeFactor() {
    }

    private void clearChannelId() {
        this.channelId_ = null;
        this.bitField0_ &= -2;
    }

    private void clearFileId() {
        this.fileId_ = 0L;
    }

    private void clearOwnerId() {
        this.ownerId_ = 0;
    }

    public static AdvertisementStruct$ChannelIncomeFactor getDefaultInstance() {
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

    public static AdvertisementStruct$ChannelIncomeFactor parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementStruct$ChannelIncomeFactor) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementStruct$ChannelIncomeFactor parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementStruct$ChannelIncomeFactor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setChannelId(PeersStruct$GroupOutPeer peersStruct$GroupOutPeer) {
        peersStruct$GroupOutPeer.getClass();
        this.channelId_ = peersStruct$GroupOutPeer;
        this.bitField0_ |= 1;
    }

    private void setFileId(long j) {
        this.fileId_ = j;
    }

    private void setOwnerId(int i) {
        this.ownerId_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1843c.a[gVar.ordinal()]) {
            case 1:
                return new AdvertisementStruct$ChannelIncomeFactor();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002\u0004\u0003\u0002", new Object[]{"bitField0_", "channelId_", "ownerId_", "fileId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementStruct$ChannelIncomeFactor.class) {
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

    public long getFileId() {
        return this.fileId_;
    }

    public int getOwnerId() {
        return this.ownerId_;
    }

    public boolean hasChannelId() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(AdvertisementStruct$ChannelIncomeFactor advertisementStruct$ChannelIncomeFactor) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementStruct$ChannelIncomeFactor);
    }

    public static AdvertisementStruct$ChannelIncomeFactor parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementStruct$ChannelIncomeFactor) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementStruct$ChannelIncomeFactor parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementStruct$ChannelIncomeFactor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementStruct$ChannelIncomeFactor parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementStruct$ChannelIncomeFactor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AdvertisementStruct$ChannelIncomeFactor parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementStruct$ChannelIncomeFactor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementStruct$ChannelIncomeFactor parseFrom(byte[] bArr) {
        return (AdvertisementStruct$ChannelIncomeFactor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementStruct$ChannelIncomeFactor parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementStruct$ChannelIncomeFactor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AdvertisementStruct$ChannelIncomeFactor parseFrom(InputStream inputStream) {
        return (AdvertisementStruct$ChannelIncomeFactor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementStruct$ChannelIncomeFactor parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementStruct$ChannelIncomeFactor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementStruct$ChannelIncomeFactor parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementStruct$ChannelIncomeFactor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementStruct$ChannelIncomeFactor parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementStruct$ChannelIncomeFactor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
