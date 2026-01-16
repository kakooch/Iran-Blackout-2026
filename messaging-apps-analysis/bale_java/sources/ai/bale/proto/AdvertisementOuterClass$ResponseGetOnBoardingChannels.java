package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC19043ph;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes8.dex */
public final class AdvertisementOuterClass$ResponseGetOnBoardingChannels extends GeneratedMessageLite implements U64 {
    public static final int CHANNELS_FIELD_NUMBER = 1;
    private static final AdvertisementOuterClass$ResponseGetOnBoardingChannels DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int SHOW_ON_BOARDING_FIELD_NUMBER = 2;
    private B.j channels_ = GeneratedMessageLite.emptyProtobufList();
    private boolean showOnBoarding_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(AdvertisementOuterClass$ResponseGetOnBoardingChannels.DEFAULT_INSTANCE);
        }
    }

    static {
        AdvertisementOuterClass$ResponseGetOnBoardingChannels advertisementOuterClass$ResponseGetOnBoardingChannels = new AdvertisementOuterClass$ResponseGetOnBoardingChannels();
        DEFAULT_INSTANCE = advertisementOuterClass$ResponseGetOnBoardingChannels;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementOuterClass$ResponseGetOnBoardingChannels.class, advertisementOuterClass$ResponseGetOnBoardingChannels);
    }

    private AdvertisementOuterClass$ResponseGetOnBoardingChannels() {
    }

    private void addAllChannels(Iterable<? extends AdvertisementStruct$OnBoardingChannelData> iterable) {
        ensureChannelsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.channels_);
    }

    private void addChannels(AdvertisementStruct$OnBoardingChannelData advertisementStruct$OnBoardingChannelData) {
        advertisementStruct$OnBoardingChannelData.getClass();
        ensureChannelsIsMutable();
        this.channels_.add(advertisementStruct$OnBoardingChannelData);
    }

    private void clearChannels() {
        this.channels_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearShowOnBoarding() {
        this.showOnBoarding_ = false;
    }

    private void ensureChannelsIsMutable() {
        B.j jVar = this.channels_;
        if (jVar.u()) {
            return;
        }
        this.channels_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static AdvertisementOuterClass$ResponseGetOnBoardingChannels getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AdvertisementOuterClass$ResponseGetOnBoardingChannels parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$ResponseGetOnBoardingChannels) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$ResponseGetOnBoardingChannels parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementOuterClass$ResponseGetOnBoardingChannels) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeChannels(int i) {
        ensureChannelsIsMutable();
        this.channels_.remove(i);
    }

    private void setChannels(int i, AdvertisementStruct$OnBoardingChannelData advertisementStruct$OnBoardingChannelData) {
        advertisementStruct$OnBoardingChannelData.getClass();
        ensureChannelsIsMutable();
        this.channels_.set(i, advertisementStruct$OnBoardingChannelData);
    }

    private void setShowOnBoarding(boolean z) {
        this.showOnBoarding_ = z;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1840b.a[gVar.ordinal()]) {
            case 1:
                return new AdvertisementOuterClass$ResponseGetOnBoardingChannels();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001b\u0002\u0007", new Object[]{"channels_", AdvertisementStruct$OnBoardingChannelData.class, "showOnBoarding_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementOuterClass$ResponseGetOnBoardingChannels.class) {
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

    public AdvertisementStruct$OnBoardingChannelData getChannels(int i) {
        return (AdvertisementStruct$OnBoardingChannelData) this.channels_.get(i);
    }

    public int getChannelsCount() {
        return this.channels_.size();
    }

    public List<AdvertisementStruct$OnBoardingChannelData> getChannelsList() {
        return this.channels_;
    }

    public InterfaceC19043ph getChannelsOrBuilder(int i) {
        return (InterfaceC19043ph) this.channels_.get(i);
    }

    public List<? extends InterfaceC19043ph> getChannelsOrBuilderList() {
        return this.channels_;
    }

    public boolean getShowOnBoarding() {
        return this.showOnBoarding_;
    }

    public static a newBuilder(AdvertisementOuterClass$ResponseGetOnBoardingChannels advertisementOuterClass$ResponseGetOnBoardingChannels) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementOuterClass$ResponseGetOnBoardingChannels);
    }

    public static AdvertisementOuterClass$ResponseGetOnBoardingChannels parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetOnBoardingChannels) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetOnBoardingChannels parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetOnBoardingChannels) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetOnBoardingChannels parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementOuterClass$ResponseGetOnBoardingChannels) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addChannels(int i, AdvertisementStruct$OnBoardingChannelData advertisementStruct$OnBoardingChannelData) {
        advertisementStruct$OnBoardingChannelData.getClass();
        ensureChannelsIsMutable();
        this.channels_.add(i, advertisementStruct$OnBoardingChannelData);
    }

    public static AdvertisementOuterClass$ResponseGetOnBoardingChannels parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetOnBoardingChannels) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetOnBoardingChannels parseFrom(byte[] bArr) {
        return (AdvertisementOuterClass$ResponseGetOnBoardingChannels) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementOuterClass$ResponseGetOnBoardingChannels parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetOnBoardingChannels) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetOnBoardingChannels parseFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$ResponseGetOnBoardingChannels) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$ResponseGetOnBoardingChannels parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetOnBoardingChannels) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetOnBoardingChannels parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementOuterClass$ResponseGetOnBoardingChannels) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementOuterClass$ResponseGetOnBoardingChannels parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetOnBoardingChannels) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
