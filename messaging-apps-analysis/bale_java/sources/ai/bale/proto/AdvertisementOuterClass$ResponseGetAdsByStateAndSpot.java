package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC4455Ff;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes8.dex */
public final class AdvertisementOuterClass$ResponseGetAdsByStateAndSpot extends GeneratedMessageLite implements U64 {
    public static final int ADS_FIELD_NUMBER = 1;
    private static final AdvertisementOuterClass$ResponseGetAdsByStateAndSpot DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private B.j ads_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(AdvertisementOuterClass$ResponseGetAdsByStateAndSpot.DEFAULT_INSTANCE);
        }
    }

    static {
        AdvertisementOuterClass$ResponseGetAdsByStateAndSpot advertisementOuterClass$ResponseGetAdsByStateAndSpot = new AdvertisementOuterClass$ResponseGetAdsByStateAndSpot();
        DEFAULT_INSTANCE = advertisementOuterClass$ResponseGetAdsByStateAndSpot;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementOuterClass$ResponseGetAdsByStateAndSpot.class, advertisementOuterClass$ResponseGetAdsByStateAndSpot);
    }

    private AdvertisementOuterClass$ResponseGetAdsByStateAndSpot() {
    }

    private void addAds(AdvertisementStruct$AdData advertisementStruct$AdData) {
        advertisementStruct$AdData.getClass();
        ensureAdsIsMutable();
        this.ads_.add(advertisementStruct$AdData);
    }

    private void addAllAds(Iterable<? extends AdvertisementStruct$AdData> iterable) {
        ensureAdsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.ads_);
    }

    private void clearAds() {
        this.ads_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureAdsIsMutable() {
        B.j jVar = this.ads_;
        if (jVar.u()) {
            return;
        }
        this.ads_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static AdvertisementOuterClass$ResponseGetAdsByStateAndSpot getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AdvertisementOuterClass$ResponseGetAdsByStateAndSpot parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$ResponseGetAdsByStateAndSpot) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$ResponseGetAdsByStateAndSpot parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementOuterClass$ResponseGetAdsByStateAndSpot) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeAds(int i) {
        ensureAdsIsMutable();
        this.ads_.remove(i);
    }

    private void setAds(int i, AdvertisementStruct$AdData advertisementStruct$AdData) {
        advertisementStruct$AdData.getClass();
        ensureAdsIsMutable();
        this.ads_.set(i, advertisementStruct$AdData);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1840b.a[gVar.ordinal()]) {
            case 1:
                return new AdvertisementOuterClass$ResponseGetAdsByStateAndSpot();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"ads_", AdvertisementStruct$AdData.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementOuterClass$ResponseGetAdsByStateAndSpot.class) {
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

    public AdvertisementStruct$AdData getAds(int i) {
        return (AdvertisementStruct$AdData) this.ads_.get(i);
    }

    public int getAdsCount() {
        return this.ads_.size();
    }

    public List<AdvertisementStruct$AdData> getAdsList() {
        return this.ads_;
    }

    public InterfaceC4455Ff getAdsOrBuilder(int i) {
        return (InterfaceC4455Ff) this.ads_.get(i);
    }

    public List<? extends InterfaceC4455Ff> getAdsOrBuilderList() {
        return this.ads_;
    }

    public static a newBuilder(AdvertisementOuterClass$ResponseGetAdsByStateAndSpot advertisementOuterClass$ResponseGetAdsByStateAndSpot) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementOuterClass$ResponseGetAdsByStateAndSpot);
    }

    public static AdvertisementOuterClass$ResponseGetAdsByStateAndSpot parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetAdsByStateAndSpot) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetAdsByStateAndSpot parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetAdsByStateAndSpot) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetAdsByStateAndSpot parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementOuterClass$ResponseGetAdsByStateAndSpot) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addAds(int i, AdvertisementStruct$AdData advertisementStruct$AdData) {
        advertisementStruct$AdData.getClass();
        ensureAdsIsMutable();
        this.ads_.add(i, advertisementStruct$AdData);
    }

    public static AdvertisementOuterClass$ResponseGetAdsByStateAndSpot parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetAdsByStateAndSpot) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetAdsByStateAndSpot parseFrom(byte[] bArr) {
        return (AdvertisementOuterClass$ResponseGetAdsByStateAndSpot) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementOuterClass$ResponseGetAdsByStateAndSpot parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetAdsByStateAndSpot) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetAdsByStateAndSpot parseFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$ResponseGetAdsByStateAndSpot) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$ResponseGetAdsByStateAndSpot parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetAdsByStateAndSpot) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetAdsByStateAndSpot parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementOuterClass$ResponseGetAdsByStateAndSpot) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementOuterClass$ResponseGetAdsByStateAndSpot parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetAdsByStateAndSpot) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
