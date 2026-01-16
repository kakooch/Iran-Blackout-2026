package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC11867dh;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes8.dex */
public final class AdvertisementOuterClass$ResponseGetActiveAds extends GeneratedMessageLite implements U64 {
    public static final int ADS_FIELD_NUMBER = 1;
    private static final AdvertisementOuterClass$ResponseGetActiveAds DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private B.j ads_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(AdvertisementOuterClass$ResponseGetActiveAds.DEFAULT_INSTANCE);
        }
    }

    static {
        AdvertisementOuterClass$ResponseGetActiveAds advertisementOuterClass$ResponseGetActiveAds = new AdvertisementOuterClass$ResponseGetActiveAds();
        DEFAULT_INSTANCE = advertisementOuterClass$ResponseGetActiveAds;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementOuterClass$ResponseGetActiveAds.class, advertisementOuterClass$ResponseGetActiveAds);
    }

    private AdvertisementOuterClass$ResponseGetActiveAds() {
    }

    private void addAds(AdvertisementStruct$DialogAdOrder advertisementStruct$DialogAdOrder) {
        advertisementStruct$DialogAdOrder.getClass();
        ensureAdsIsMutable();
        this.ads_.add(advertisementStruct$DialogAdOrder);
    }

    private void addAllAds(Iterable<? extends AdvertisementStruct$DialogAdOrder> iterable) {
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

    public static AdvertisementOuterClass$ResponseGetActiveAds getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AdvertisementOuterClass$ResponseGetActiveAds parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$ResponseGetActiveAds) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$ResponseGetActiveAds parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementOuterClass$ResponseGetActiveAds) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeAds(int i) {
        ensureAdsIsMutable();
        this.ads_.remove(i);
    }

    private void setAds(int i, AdvertisementStruct$DialogAdOrder advertisementStruct$DialogAdOrder) {
        advertisementStruct$DialogAdOrder.getClass();
        ensureAdsIsMutable();
        this.ads_.set(i, advertisementStruct$DialogAdOrder);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1840b.a[gVar.ordinal()]) {
            case 1:
                return new AdvertisementOuterClass$ResponseGetActiveAds();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"ads_", AdvertisementStruct$DialogAdOrder.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementOuterClass$ResponseGetActiveAds.class) {
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

    public AdvertisementStruct$DialogAdOrder getAds(int i) {
        return (AdvertisementStruct$DialogAdOrder) this.ads_.get(i);
    }

    public int getAdsCount() {
        return this.ads_.size();
    }

    public List<AdvertisementStruct$DialogAdOrder> getAdsList() {
        return this.ads_;
    }

    public InterfaceC11867dh getAdsOrBuilder(int i) {
        return (InterfaceC11867dh) this.ads_.get(i);
    }

    public List<? extends InterfaceC11867dh> getAdsOrBuilderList() {
        return this.ads_;
    }

    public static a newBuilder(AdvertisementOuterClass$ResponseGetActiveAds advertisementOuterClass$ResponseGetActiveAds) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementOuterClass$ResponseGetActiveAds);
    }

    public static AdvertisementOuterClass$ResponseGetActiveAds parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetActiveAds) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetActiveAds parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetActiveAds) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetActiveAds parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementOuterClass$ResponseGetActiveAds) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addAds(int i, AdvertisementStruct$DialogAdOrder advertisementStruct$DialogAdOrder) {
        advertisementStruct$DialogAdOrder.getClass();
        ensureAdsIsMutable();
        this.ads_.add(i, advertisementStruct$DialogAdOrder);
    }

    public static AdvertisementOuterClass$ResponseGetActiveAds parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetActiveAds) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetActiveAds parseFrom(byte[] bArr) {
        return (AdvertisementOuterClass$ResponseGetActiveAds) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementOuterClass$ResponseGetActiveAds parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetActiveAds) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetActiveAds parseFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$ResponseGetActiveAds) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$ResponseGetActiveAds parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetActiveAds) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetActiveAds parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementOuterClass$ResponseGetActiveAds) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementOuterClass$ResponseGetActiveAds parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetActiveAds) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
