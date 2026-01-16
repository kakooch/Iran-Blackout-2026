package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC23877xg;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes8.dex */
public final class AdvertisementOuterClass$ResponseGetCampaignAds extends GeneratedMessageLite implements U64 {
    public static final int DATA_FIELD_NUMBER = 1;
    private static final AdvertisementOuterClass$ResponseGetCampaignAds DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private B.j data_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(AdvertisementOuterClass$ResponseGetCampaignAds.DEFAULT_INSTANCE);
        }
    }

    static {
        AdvertisementOuterClass$ResponseGetCampaignAds advertisementOuterClass$ResponseGetCampaignAds = new AdvertisementOuterClass$ResponseGetCampaignAds();
        DEFAULT_INSTANCE = advertisementOuterClass$ResponseGetCampaignAds;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementOuterClass$ResponseGetCampaignAds.class, advertisementOuterClass$ResponseGetCampaignAds);
    }

    private AdvertisementOuterClass$ResponseGetCampaignAds() {
    }

    private void addAllData(Iterable<? extends AdvertisementStruct$CampaignData> iterable) {
        ensureDataIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.data_);
    }

    private void addData(AdvertisementStruct$CampaignData advertisementStruct$CampaignData) {
        advertisementStruct$CampaignData.getClass();
        ensureDataIsMutable();
        this.data_.add(advertisementStruct$CampaignData);
    }

    private void clearData() {
        this.data_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureDataIsMutable() {
        B.j jVar = this.data_;
        if (jVar.u()) {
            return;
        }
        this.data_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static AdvertisementOuterClass$ResponseGetCampaignAds getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AdvertisementOuterClass$ResponseGetCampaignAds parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$ResponseGetCampaignAds) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$ResponseGetCampaignAds parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementOuterClass$ResponseGetCampaignAds) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeData(int i) {
        ensureDataIsMutable();
        this.data_.remove(i);
    }

    private void setData(int i, AdvertisementStruct$CampaignData advertisementStruct$CampaignData) {
        advertisementStruct$CampaignData.getClass();
        ensureDataIsMutable();
        this.data_.set(i, advertisementStruct$CampaignData);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1840b.a[gVar.ordinal()]) {
            case 1:
                return new AdvertisementOuterClass$ResponseGetCampaignAds();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"data_", AdvertisementStruct$CampaignData.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementOuterClass$ResponseGetCampaignAds.class) {
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

    public AdvertisementStruct$CampaignData getData(int i) {
        return (AdvertisementStruct$CampaignData) this.data_.get(i);
    }

    public int getDataCount() {
        return this.data_.size();
    }

    public List<AdvertisementStruct$CampaignData> getDataList() {
        return this.data_;
    }

    public InterfaceC23877xg getDataOrBuilder(int i) {
        return (InterfaceC23877xg) this.data_.get(i);
    }

    public List<? extends InterfaceC23877xg> getDataOrBuilderList() {
        return this.data_;
    }

    public static a newBuilder(AdvertisementOuterClass$ResponseGetCampaignAds advertisementOuterClass$ResponseGetCampaignAds) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementOuterClass$ResponseGetCampaignAds);
    }

    public static AdvertisementOuterClass$ResponseGetCampaignAds parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetCampaignAds) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetCampaignAds parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetCampaignAds) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetCampaignAds parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementOuterClass$ResponseGetCampaignAds) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addData(int i, AdvertisementStruct$CampaignData advertisementStruct$CampaignData) {
        advertisementStruct$CampaignData.getClass();
        ensureDataIsMutable();
        this.data_.add(i, advertisementStruct$CampaignData);
    }

    public static AdvertisementOuterClass$ResponseGetCampaignAds parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetCampaignAds) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetCampaignAds parseFrom(byte[] bArr) {
        return (AdvertisementOuterClass$ResponseGetCampaignAds) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementOuterClass$ResponseGetCampaignAds parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetCampaignAds) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetCampaignAds parseFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$ResponseGetCampaignAds) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$ResponseGetCampaignAds parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetCampaignAds) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetCampaignAds parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementOuterClass$ResponseGetCampaignAds) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementOuterClass$ResponseGetCampaignAds parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetCampaignAds) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
