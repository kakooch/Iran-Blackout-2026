package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC6355Ng;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class AdvertisementStruct$ContactPopularChannels extends GeneratedMessageLite implements U64 {
    public static final int BANNER_URL_FIELD_NUMBER = 2;
    public static final int CHANNELS_FIELD_NUMBER = 1;
    private static final AdvertisementStruct$ContactPopularChannels DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private B.j channels_ = GeneratedMessageLite.emptyProtobufList();
    private String bannerUrl_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(AdvertisementStruct$ContactPopularChannels.DEFAULT_INSTANCE);
        }
    }

    static {
        AdvertisementStruct$ContactPopularChannels advertisementStruct$ContactPopularChannels = new AdvertisementStruct$ContactPopularChannels();
        DEFAULT_INSTANCE = advertisementStruct$ContactPopularChannels;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementStruct$ContactPopularChannels.class, advertisementStruct$ContactPopularChannels);
    }

    private AdvertisementStruct$ContactPopularChannels() {
    }

    private void addAllChannels(Iterable<? extends AdvertisementStruct$ContactPopularChannel> iterable) {
        ensureChannelsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.channels_);
    }

    private void addChannels(AdvertisementStruct$ContactPopularChannel advertisementStruct$ContactPopularChannel) {
        advertisementStruct$ContactPopularChannel.getClass();
        ensureChannelsIsMutable();
        this.channels_.add(advertisementStruct$ContactPopularChannel);
    }

    private void clearBannerUrl() {
        this.bannerUrl_ = getDefaultInstance().getBannerUrl();
    }

    private void clearChannels() {
        this.channels_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureChannelsIsMutable() {
        B.j jVar = this.channels_;
        if (jVar.u()) {
            return;
        }
        this.channels_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static AdvertisementStruct$ContactPopularChannels getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AdvertisementStruct$ContactPopularChannels parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementStruct$ContactPopularChannels) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementStruct$ContactPopularChannels parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementStruct$ContactPopularChannels) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeChannels(int i) {
        ensureChannelsIsMutable();
        this.channels_.remove(i);
    }

    private void setBannerUrl(String str) {
        str.getClass();
        this.bannerUrl_ = str;
    }

    private void setBannerUrlBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.bannerUrl_ = abstractC2383g.f0();
    }

    private void setChannels(int i, AdvertisementStruct$ContactPopularChannel advertisementStruct$ContactPopularChannel) {
        advertisementStruct$ContactPopularChannel.getClass();
        ensureChannelsIsMutable();
        this.channels_.set(i, advertisementStruct$ContactPopularChannel);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1843c.a[gVar.ordinal()]) {
            case 1:
                return new AdvertisementStruct$ContactPopularChannels();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001b\u0002Ȉ", new Object[]{"channels_", AdvertisementStruct$ContactPopularChannel.class, "bannerUrl_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementStruct$ContactPopularChannels.class) {
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

    public String getBannerUrl() {
        return this.bannerUrl_;
    }

    public AbstractC2383g getBannerUrlBytes() {
        return AbstractC2383g.N(this.bannerUrl_);
    }

    public AdvertisementStruct$ContactPopularChannel getChannels(int i) {
        return (AdvertisementStruct$ContactPopularChannel) this.channels_.get(i);
    }

    public int getChannelsCount() {
        return this.channels_.size();
    }

    public List<AdvertisementStruct$ContactPopularChannel> getChannelsList() {
        return this.channels_;
    }

    public InterfaceC6355Ng getChannelsOrBuilder(int i) {
        return (InterfaceC6355Ng) this.channels_.get(i);
    }

    public List<? extends InterfaceC6355Ng> getChannelsOrBuilderList() {
        return this.channels_;
    }

    public static a newBuilder(AdvertisementStruct$ContactPopularChannels advertisementStruct$ContactPopularChannels) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementStruct$ContactPopularChannels);
    }

    public static AdvertisementStruct$ContactPopularChannels parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementStruct$ContactPopularChannels) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementStruct$ContactPopularChannels parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementStruct$ContactPopularChannels) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementStruct$ContactPopularChannels parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementStruct$ContactPopularChannels) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addChannels(int i, AdvertisementStruct$ContactPopularChannel advertisementStruct$ContactPopularChannel) {
        advertisementStruct$ContactPopularChannel.getClass();
        ensureChannelsIsMutable();
        this.channels_.add(i, advertisementStruct$ContactPopularChannel);
    }

    public static AdvertisementStruct$ContactPopularChannels parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementStruct$ContactPopularChannels) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementStruct$ContactPopularChannels parseFrom(byte[] bArr) {
        return (AdvertisementStruct$ContactPopularChannels) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementStruct$ContactPopularChannels parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementStruct$ContactPopularChannels) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AdvertisementStruct$ContactPopularChannels parseFrom(InputStream inputStream) {
        return (AdvertisementStruct$ContactPopularChannels) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementStruct$ContactPopularChannels parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementStruct$ContactPopularChannels) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementStruct$ContactPopularChannels parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementStruct$ContactPopularChannels) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementStruct$ContactPopularChannels parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementStruct$ContactPopularChannels) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
