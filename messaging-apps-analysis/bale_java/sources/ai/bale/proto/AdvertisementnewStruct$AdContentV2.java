package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC23897xi;
import ir.nasim.InterfaceC20251ri;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class AdvertisementnewStruct$AdContentV2 extends GeneratedMessageLite implements U64 {
    public static final int ADS_FIELD_NUMBER = 2;
    private static final AdvertisementnewStruct$AdContentV2 DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int TOKEN_FIELD_NUMBER = 3;
    public static final int TYPE_FIELD_NUMBER = 1;
    private B.j ads_ = GeneratedMessageLite.emptyProtobufList();
    private String token_ = "";
    private int type_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(AdvertisementnewStruct$AdContentV2.DEFAULT_INSTANCE);
        }
    }

    static {
        AdvertisementnewStruct$AdContentV2 advertisementnewStruct$AdContentV2 = new AdvertisementnewStruct$AdContentV2();
        DEFAULT_INSTANCE = advertisementnewStruct$AdContentV2;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementnewStruct$AdContentV2.class, advertisementnewStruct$AdContentV2);
    }

    private AdvertisementnewStruct$AdContentV2() {
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

    private void clearToken() {
        this.token_ = getDefaultInstance().getToken();
    }

    private void clearType() {
        this.type_ = 0;
    }

    private void ensureAdsIsMutable() {
        B.j jVar = this.ads_;
        if (jVar.u()) {
            return;
        }
        this.ads_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static AdvertisementnewStruct$AdContentV2 getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AdvertisementnewStruct$AdContentV2 parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementnewStruct$AdContentV2) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementnewStruct$AdContentV2 parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementnewStruct$AdContentV2) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
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

    private void setToken(String str) {
        str.getClass();
        this.token_ = str;
    }

    private void setTokenBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.token_ = abstractC2383g.f0();
    }

    private void setType(EnumC23897xi enumC23897xi) {
        this.type_ = enumC23897xi.getNumber();
    }

    private void setTypeValue(int i) {
        this.type_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1852f.a[gVar.ordinal()]) {
            case 1:
                return new AdvertisementnewStruct$AdContentV2();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0001\u0000\u0001\f\u0002\u001b\u0003Ȉ", new Object[]{"type_", "ads_", AdvertisementnewStruct$AdData.class, "token_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementnewStruct$AdContentV2.class) {
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

    public String getToken() {
        return this.token_;
    }

    public AbstractC2383g getTokenBytes() {
        return AbstractC2383g.N(this.token_);
    }

    public EnumC23897xi getType() {
        EnumC23897xi enumC23897xiJ = EnumC23897xi.j(this.type_);
        return enumC23897xiJ == null ? EnumC23897xi.UNRECOGNIZED : enumC23897xiJ;
    }

    public int getTypeValue() {
        return this.type_;
    }

    public static a newBuilder(AdvertisementnewStruct$AdContentV2 advertisementnewStruct$AdContentV2) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementnewStruct$AdContentV2);
    }

    public static AdvertisementnewStruct$AdContentV2 parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementnewStruct$AdContentV2) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementnewStruct$AdContentV2 parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementnewStruct$AdContentV2) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementnewStruct$AdContentV2 parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementnewStruct$AdContentV2) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addAds(int i, AdvertisementnewStruct$AdData advertisementnewStruct$AdData) {
        advertisementnewStruct$AdData.getClass();
        ensureAdsIsMutable();
        this.ads_.add(i, advertisementnewStruct$AdData);
    }

    public static AdvertisementnewStruct$AdContentV2 parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementnewStruct$AdContentV2) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementnewStruct$AdContentV2 parseFrom(byte[] bArr) {
        return (AdvertisementnewStruct$AdContentV2) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementnewStruct$AdContentV2 parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementnewStruct$AdContentV2) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AdvertisementnewStruct$AdContentV2 parseFrom(InputStream inputStream) {
        return (AdvertisementnewStruct$AdContentV2) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementnewStruct$AdContentV2 parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementnewStruct$AdContentV2) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementnewStruct$AdContentV2 parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementnewStruct$AdContentV2) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementnewStruct$AdContentV2 parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementnewStruct$AdContentV2) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
