package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC6116Mg;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes8.dex */
public final class AdvertisementOuterClass$ResponseGetMyContactPopularChannels extends GeneratedMessageLite implements U64 {
    public static final int CHANNELS_FIELD_NUMBER = 1;
    private static final AdvertisementOuterClass$ResponseGetMyContactPopularChannels DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private B.j channels_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(AdvertisementOuterClass$ResponseGetMyContactPopularChannels.DEFAULT_INSTANCE);
        }
    }

    static {
        AdvertisementOuterClass$ResponseGetMyContactPopularChannels advertisementOuterClass$ResponseGetMyContactPopularChannels = new AdvertisementOuterClass$ResponseGetMyContactPopularChannels();
        DEFAULT_INSTANCE = advertisementOuterClass$ResponseGetMyContactPopularChannels;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementOuterClass$ResponseGetMyContactPopularChannels.class, advertisementOuterClass$ResponseGetMyContactPopularChannels);
    }

    private AdvertisementOuterClass$ResponseGetMyContactPopularChannels() {
    }

    private void addAllChannels(Iterable<? extends AdvertisementStruct$ContactPopularChannelData> iterable) {
        ensureChannelsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.channels_);
    }

    private void addChannels(int i, AdvertisementStruct$ContactPopularChannelData advertisementStruct$ContactPopularChannelData) {
        advertisementStruct$ContactPopularChannelData.getClass();
        ensureChannelsIsMutable();
        this.channels_.add(i, advertisementStruct$ContactPopularChannelData);
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

    public static AdvertisementOuterClass$ResponseGetMyContactPopularChannels getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AdvertisementOuterClass$ResponseGetMyContactPopularChannels parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$ResponseGetMyContactPopularChannels) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$ResponseGetMyContactPopularChannels parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementOuterClass$ResponseGetMyContactPopularChannels) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeChannels(int i) {
        ensureChannelsIsMutable();
        this.channels_.remove(i);
    }

    private void setChannels(int i, AdvertisementStruct$ContactPopularChannelData advertisementStruct$ContactPopularChannelData) {
        advertisementStruct$ContactPopularChannelData.getClass();
        ensureChannelsIsMutable();
        this.channels_.set(i, advertisementStruct$ContactPopularChannelData);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1840b.a[gVar.ordinal()]) {
            case 1:
                return new AdvertisementOuterClass$ResponseGetMyContactPopularChannels();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"channels_", AdvertisementStruct$ContactPopularChannelData.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementOuterClass$ResponseGetMyContactPopularChannels.class) {
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

    public AdvertisementStruct$ContactPopularChannelData getChannels(int i) {
        return (AdvertisementStruct$ContactPopularChannelData) this.channels_.get(i);
    }

    public int getChannelsCount() {
        return this.channels_.size();
    }

    public List<AdvertisementStruct$ContactPopularChannelData> getChannelsList() {
        return this.channels_;
    }

    public InterfaceC6116Mg getChannelsOrBuilder(int i) {
        return (InterfaceC6116Mg) this.channels_.get(i);
    }

    public List<? extends InterfaceC6116Mg> getChannelsOrBuilderList() {
        return this.channels_;
    }

    private void addChannels(AdvertisementStruct$ContactPopularChannelData advertisementStruct$ContactPopularChannelData) {
        advertisementStruct$ContactPopularChannelData.getClass();
        ensureChannelsIsMutable();
        this.channels_.add(advertisementStruct$ContactPopularChannelData);
    }

    public static a newBuilder(AdvertisementOuterClass$ResponseGetMyContactPopularChannels advertisementOuterClass$ResponseGetMyContactPopularChannels) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementOuterClass$ResponseGetMyContactPopularChannels);
    }

    public static AdvertisementOuterClass$ResponseGetMyContactPopularChannels parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetMyContactPopularChannels) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetMyContactPopularChannels parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetMyContactPopularChannels) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetMyContactPopularChannels parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementOuterClass$ResponseGetMyContactPopularChannels) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementOuterClass$ResponseGetMyContactPopularChannels parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetMyContactPopularChannels) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetMyContactPopularChannels parseFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$ResponseGetMyContactPopularChannels) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$ResponseGetMyContactPopularChannels parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetMyContactPopularChannels) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetMyContactPopularChannels parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementOuterClass$ResponseGetMyContactPopularChannels) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static AdvertisementOuterClass$ResponseGetMyContactPopularChannels parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetMyContactPopularChannels) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetMyContactPopularChannels parseFrom(byte[] bArr) {
        return (AdvertisementOuterClass$ResponseGetMyContactPopularChannels) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementOuterClass$ResponseGetMyContactPopularChannels parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetMyContactPopularChannels) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }
}
