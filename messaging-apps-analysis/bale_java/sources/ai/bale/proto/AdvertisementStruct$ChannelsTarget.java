package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class AdvertisementStruct$ChannelsTarget extends GeneratedMessageLite implements U64 {
    public static final int CHANNEL_IDS_FIELD_NUMBER = 1;
    private static final AdvertisementStruct$ChannelsTarget DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private int channelIdsMemoizedSerializedSize = -1;
    private B.g channelIds_ = GeneratedMessageLite.emptyIntList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(AdvertisementStruct$ChannelsTarget.DEFAULT_INSTANCE);
        }
    }

    static {
        AdvertisementStruct$ChannelsTarget advertisementStruct$ChannelsTarget = new AdvertisementStruct$ChannelsTarget();
        DEFAULT_INSTANCE = advertisementStruct$ChannelsTarget;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementStruct$ChannelsTarget.class, advertisementStruct$ChannelsTarget);
    }

    private AdvertisementStruct$ChannelsTarget() {
    }

    private void addAllChannelIds(Iterable<? extends Integer> iterable) {
        ensureChannelIdsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.channelIds_);
    }

    private void addChannelIds(int i) {
        ensureChannelIdsIsMutable();
        this.channelIds_.b1(i);
    }

    private void clearChannelIds() {
        this.channelIds_ = GeneratedMessageLite.emptyIntList();
    }

    private void ensureChannelIdsIsMutable() {
        B.g gVar = this.channelIds_;
        if (gVar.u()) {
            return;
        }
        this.channelIds_ = GeneratedMessageLite.mutableCopy(gVar);
    }

    public static AdvertisementStruct$ChannelsTarget getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AdvertisementStruct$ChannelsTarget parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementStruct$ChannelsTarget) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementStruct$ChannelsTarget parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementStruct$ChannelsTarget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setChannelIds(int i, int i2) {
        ensureChannelIdsIsMutable();
        this.channelIds_.U(i, i2);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1843c.a[gVar.ordinal()]) {
            case 1:
                return new AdvertisementStruct$ChannelsTarget();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001'", new Object[]{"channelIds_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementStruct$ChannelsTarget.class) {
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

    public int getChannelIds(int i) {
        return this.channelIds_.getInt(i);
    }

    public int getChannelIdsCount() {
        return this.channelIds_.size();
    }

    public List<Integer> getChannelIdsList() {
        return this.channelIds_;
    }

    public static a newBuilder(AdvertisementStruct$ChannelsTarget advertisementStruct$ChannelsTarget) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementStruct$ChannelsTarget);
    }

    public static AdvertisementStruct$ChannelsTarget parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementStruct$ChannelsTarget) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementStruct$ChannelsTarget parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementStruct$ChannelsTarget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementStruct$ChannelsTarget parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementStruct$ChannelsTarget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AdvertisementStruct$ChannelsTarget parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementStruct$ChannelsTarget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementStruct$ChannelsTarget parseFrom(byte[] bArr) {
        return (AdvertisementStruct$ChannelsTarget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementStruct$ChannelsTarget parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementStruct$ChannelsTarget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AdvertisementStruct$ChannelsTarget parseFrom(InputStream inputStream) {
        return (AdvertisementStruct$ChannelsTarget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementStruct$ChannelsTarget parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementStruct$ChannelsTarget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementStruct$ChannelsTarget parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementStruct$ChannelsTarget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementStruct$ChannelsTarget parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementStruct$ChannelsTarget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
