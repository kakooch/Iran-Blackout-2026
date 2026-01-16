package ai.bale.proto;

import ai.bale.proto.PeersStruct$GroupOutPeer;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC5415Jg;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class AdvertisementStruct$ChannelsView extends GeneratedMessageLite implements InterfaceC5415Jg {
    public static final int CHANNEL_ID_FIELD_NUMBER = 1;
    private static final AdvertisementStruct$ChannelsView DEFAULT_INSTANCE;
    public static final int MEMBER_COUNT_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER = null;
    public static final int VIEW_COUNT_FIELD_NUMBER = 2;
    private int bitField0_;
    private PeersStruct$GroupOutPeer channelId_;
    private int memberCount_;
    private long viewCount_;

    public static final class a extends GeneratedMessageLite.b implements InterfaceC5415Jg {
        private a() {
            super(AdvertisementStruct$ChannelsView.DEFAULT_INSTANCE);
        }
    }

    static {
        AdvertisementStruct$ChannelsView advertisementStruct$ChannelsView = new AdvertisementStruct$ChannelsView();
        DEFAULT_INSTANCE = advertisementStruct$ChannelsView;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementStruct$ChannelsView.class, advertisementStruct$ChannelsView);
    }

    private AdvertisementStruct$ChannelsView() {
    }

    private void clearChannelId() {
        this.channelId_ = null;
        this.bitField0_ &= -2;
    }

    private void clearMemberCount() {
        this.memberCount_ = 0;
    }

    private void clearViewCount() {
        this.viewCount_ = 0L;
    }

    public static AdvertisementStruct$ChannelsView getDefaultInstance() {
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

    public static AdvertisementStruct$ChannelsView parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementStruct$ChannelsView) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementStruct$ChannelsView parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementStruct$ChannelsView) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setChannelId(PeersStruct$GroupOutPeer peersStruct$GroupOutPeer) {
        peersStruct$GroupOutPeer.getClass();
        this.channelId_ = peersStruct$GroupOutPeer;
        this.bitField0_ |= 1;
    }

    private void setMemberCount(int i) {
        this.memberCount_ = i;
    }

    private void setViewCount(long j) {
        this.viewCount_ = j;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1843c.a[gVar.ordinal()]) {
            case 1:
                return new AdvertisementStruct$ChannelsView();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002\u0002\u0003\u0004", new Object[]{"bitField0_", "channelId_", "viewCount_", "memberCount_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementStruct$ChannelsView.class) {
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

    public int getMemberCount() {
        return this.memberCount_;
    }

    public long getViewCount() {
        return this.viewCount_;
    }

    public boolean hasChannelId() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(AdvertisementStruct$ChannelsView advertisementStruct$ChannelsView) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementStruct$ChannelsView);
    }

    public static AdvertisementStruct$ChannelsView parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementStruct$ChannelsView) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementStruct$ChannelsView parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementStruct$ChannelsView) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementStruct$ChannelsView parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementStruct$ChannelsView) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AdvertisementStruct$ChannelsView parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementStruct$ChannelsView) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementStruct$ChannelsView parseFrom(byte[] bArr) {
        return (AdvertisementStruct$ChannelsView) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementStruct$ChannelsView parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementStruct$ChannelsView) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AdvertisementStruct$ChannelsView parseFrom(InputStream inputStream) {
        return (AdvertisementStruct$ChannelsView) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementStruct$ChannelsView parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementStruct$ChannelsView) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementStruct$ChannelsView parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementStruct$ChannelsView) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementStruct$ChannelsView parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementStruct$ChannelsView) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
