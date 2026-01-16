package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC25071zh;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes8.dex */
public final class AdvertisementOuterClass$ResponseGetFactorEligibleAds extends GeneratedMessageLite implements U64 {
    public static final int ADS_FIELD_NUMBER = 1;
    private static final AdvertisementOuterClass$ResponseGetFactorEligibleAds DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private B.j ads_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(AdvertisementOuterClass$ResponseGetFactorEligibleAds.DEFAULT_INSTANCE);
        }
    }

    static {
        AdvertisementOuterClass$ResponseGetFactorEligibleAds advertisementOuterClass$ResponseGetFactorEligibleAds = new AdvertisementOuterClass$ResponseGetFactorEligibleAds();
        DEFAULT_INSTANCE = advertisementOuterClass$ResponseGetFactorEligibleAds;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementOuterClass$ResponseGetFactorEligibleAds.class, advertisementOuterClass$ResponseGetFactorEligibleAds);
    }

    private AdvertisementOuterClass$ResponseGetFactorEligibleAds() {
    }

    private void addAds(AdvertisementStruct$PaidAdData advertisementStruct$PaidAdData) {
        advertisementStruct$PaidAdData.getClass();
        ensureAdsIsMutable();
        this.ads_.add(advertisementStruct$PaidAdData);
    }

    private void addAllAds(Iterable<? extends AdvertisementStruct$PaidAdData> iterable) {
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

    public static AdvertisementOuterClass$ResponseGetFactorEligibleAds getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AdvertisementOuterClass$ResponseGetFactorEligibleAds parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$ResponseGetFactorEligibleAds) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$ResponseGetFactorEligibleAds parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementOuterClass$ResponseGetFactorEligibleAds) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeAds(int i) {
        ensureAdsIsMutable();
        this.ads_.remove(i);
    }

    private void setAds(int i, AdvertisementStruct$PaidAdData advertisementStruct$PaidAdData) {
        advertisementStruct$PaidAdData.getClass();
        ensureAdsIsMutable();
        this.ads_.set(i, advertisementStruct$PaidAdData);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1840b.a[gVar.ordinal()]) {
            case 1:
                return new AdvertisementOuterClass$ResponseGetFactorEligibleAds();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"ads_", AdvertisementStruct$PaidAdData.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementOuterClass$ResponseGetFactorEligibleAds.class) {
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

    public AdvertisementStruct$PaidAdData getAds(int i) {
        return (AdvertisementStruct$PaidAdData) this.ads_.get(i);
    }

    public int getAdsCount() {
        return this.ads_.size();
    }

    public List<AdvertisementStruct$PaidAdData> getAdsList() {
        return this.ads_;
    }

    public InterfaceC25071zh getAdsOrBuilder(int i) {
        return (InterfaceC25071zh) this.ads_.get(i);
    }

    public List<? extends InterfaceC25071zh> getAdsOrBuilderList() {
        return this.ads_;
    }

    public static a newBuilder(AdvertisementOuterClass$ResponseGetFactorEligibleAds advertisementOuterClass$ResponseGetFactorEligibleAds) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementOuterClass$ResponseGetFactorEligibleAds);
    }

    public static AdvertisementOuterClass$ResponseGetFactorEligibleAds parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetFactorEligibleAds) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetFactorEligibleAds parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetFactorEligibleAds) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetFactorEligibleAds parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementOuterClass$ResponseGetFactorEligibleAds) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addAds(int i, AdvertisementStruct$PaidAdData advertisementStruct$PaidAdData) {
        advertisementStruct$PaidAdData.getClass();
        ensureAdsIsMutable();
        this.ads_.add(i, advertisementStruct$PaidAdData);
    }

    public static AdvertisementOuterClass$ResponseGetFactorEligibleAds parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetFactorEligibleAds) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetFactorEligibleAds parseFrom(byte[] bArr) {
        return (AdvertisementOuterClass$ResponseGetFactorEligibleAds) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementOuterClass$ResponseGetFactorEligibleAds parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetFactorEligibleAds) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetFactorEligibleAds parseFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$ResponseGetFactorEligibleAds) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$ResponseGetFactorEligibleAds parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetFactorEligibleAds) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetFactorEligibleAds parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementOuterClass$ResponseGetFactorEligibleAds) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementOuterClass$ResponseGetFactorEligibleAds parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetFactorEligibleAds) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
