package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC20251ri;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class Advertisementnew$ResponseGetAdsByStateAndSpot extends GeneratedMessageLite implements U64 {
    public static final int ADS_FIELD_NUMBER = 1;
    private static final Advertisementnew$ResponseGetAdsByStateAndSpot DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private B.j ads_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Advertisementnew$ResponseGetAdsByStateAndSpot.DEFAULT_INSTANCE);
        }
    }

    static {
        Advertisementnew$ResponseGetAdsByStateAndSpot advertisementnew$ResponseGetAdsByStateAndSpot = new Advertisementnew$ResponseGetAdsByStateAndSpot();
        DEFAULT_INSTANCE = advertisementnew$ResponseGetAdsByStateAndSpot;
        GeneratedMessageLite.registerDefaultInstance(Advertisementnew$ResponseGetAdsByStateAndSpot.class, advertisementnew$ResponseGetAdsByStateAndSpot);
    }

    private Advertisementnew$ResponseGetAdsByStateAndSpot() {
    }

    private void addAds(AdvertisementnewStruct$AdData advertisementnewStruct$AdData) {
        advertisementnewStruct$AdData.getClass();
        ensureAdsIsMutable();
        this.ads_.add(advertisementnewStruct$AdData);
    }

    private void addAllAds(Iterable<? extends AdvertisementnewStruct$AdData> iterable) {
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

    public static Advertisementnew$ResponseGetAdsByStateAndSpot getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Advertisementnew$ResponseGetAdsByStateAndSpot parseDelimitedFrom(InputStream inputStream) {
        return (Advertisementnew$ResponseGetAdsByStateAndSpot) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Advertisementnew$ResponseGetAdsByStateAndSpot parseFrom(ByteBuffer byteBuffer) {
        return (Advertisementnew$ResponseGetAdsByStateAndSpot) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeAds(int i) {
        ensureAdsIsMutable();
        this.ads_.remove(i);
    }

    private void setAds(int i, AdvertisementnewStruct$AdData advertisementnewStruct$AdData) {
        advertisementnewStruct$AdData.getClass();
        ensureAdsIsMutable();
        this.ads_.set(i, advertisementnewStruct$AdData);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1849e.a[gVar.ordinal()]) {
            case 1:
                return new Advertisementnew$ResponseGetAdsByStateAndSpot();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"ads_", AdvertisementnewStruct$AdData.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Advertisementnew$ResponseGetAdsByStateAndSpot.class) {
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

    public AdvertisementnewStruct$AdData getAds(int i) {
        return (AdvertisementnewStruct$AdData) this.ads_.get(i);
    }

    public int getAdsCount() {
        return this.ads_.size();
    }

    public List<AdvertisementnewStruct$AdData> getAdsList() {
        return this.ads_;
    }

    public InterfaceC20251ri getAdsOrBuilder(int i) {
        return (InterfaceC20251ri) this.ads_.get(i);
    }

    public List<? extends InterfaceC20251ri> getAdsOrBuilderList() {
        return this.ads_;
    }

    public static a newBuilder(Advertisementnew$ResponseGetAdsByStateAndSpot advertisementnew$ResponseGetAdsByStateAndSpot) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementnew$ResponseGetAdsByStateAndSpot);
    }

    public static Advertisementnew$ResponseGetAdsByStateAndSpot parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Advertisementnew$ResponseGetAdsByStateAndSpot) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Advertisementnew$ResponseGetAdsByStateAndSpot parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Advertisementnew$ResponseGetAdsByStateAndSpot) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Advertisementnew$ResponseGetAdsByStateAndSpot parseFrom(AbstractC2383g abstractC2383g) {
        return (Advertisementnew$ResponseGetAdsByStateAndSpot) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addAds(int i, AdvertisementnewStruct$AdData advertisementnewStruct$AdData) {
        advertisementnewStruct$AdData.getClass();
        ensureAdsIsMutable();
        this.ads_.add(i, advertisementnewStruct$AdData);
    }

    public static Advertisementnew$ResponseGetAdsByStateAndSpot parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Advertisementnew$ResponseGetAdsByStateAndSpot) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Advertisementnew$ResponseGetAdsByStateAndSpot parseFrom(byte[] bArr) {
        return (Advertisementnew$ResponseGetAdsByStateAndSpot) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Advertisementnew$ResponseGetAdsByStateAndSpot parseFrom(byte[] bArr, C2394s c2394s) {
        return (Advertisementnew$ResponseGetAdsByStateAndSpot) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Advertisementnew$ResponseGetAdsByStateAndSpot parseFrom(InputStream inputStream) {
        return (Advertisementnew$ResponseGetAdsByStateAndSpot) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Advertisementnew$ResponseGetAdsByStateAndSpot parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Advertisementnew$ResponseGetAdsByStateAndSpot) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Advertisementnew$ResponseGetAdsByStateAndSpot parseFrom(AbstractC2384h abstractC2384h) {
        return (Advertisementnew$ResponseGetAdsByStateAndSpot) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Advertisementnew$ResponseGetAdsByStateAndSpot parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Advertisementnew$ResponseGetAdsByStateAndSpot) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
