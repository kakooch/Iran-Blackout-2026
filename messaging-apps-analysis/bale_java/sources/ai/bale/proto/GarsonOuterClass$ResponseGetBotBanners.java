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
public final class GarsonOuterClass$ResponseGetBotBanners extends GeneratedMessageLite implements U64 {
    public static final int BANNERS_FIELD_NUMBER = 1;
    private static final GarsonOuterClass$ResponseGetBotBanners DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private B.j banners_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(GarsonOuterClass$ResponseGetBotBanners.DEFAULT_INSTANCE);
        }
    }

    static {
        GarsonOuterClass$ResponseGetBotBanners garsonOuterClass$ResponseGetBotBanners = new GarsonOuterClass$ResponseGetBotBanners();
        DEFAULT_INSTANCE = garsonOuterClass$ResponseGetBotBanners;
        GeneratedMessageLite.registerDefaultInstance(GarsonOuterClass$ResponseGetBotBanners.class, garsonOuterClass$ResponseGetBotBanners);
    }

    private GarsonOuterClass$ResponseGetBotBanners() {
    }

    private void addAllBanners(Iterable<? extends GarsonStruct$GarsonBanner> iterable) {
        ensureBannersIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.banners_);
    }

    private void addBanners(GarsonStruct$GarsonBanner garsonStruct$GarsonBanner) {
        garsonStruct$GarsonBanner.getClass();
        ensureBannersIsMutable();
        this.banners_.add(garsonStruct$GarsonBanner);
    }

    private void clearBanners() {
        this.banners_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureBannersIsMutable() {
        B.j jVar = this.banners_;
        if (jVar.u()) {
            return;
        }
        this.banners_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static GarsonOuterClass$ResponseGetBotBanners getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static GarsonOuterClass$ResponseGetBotBanners parseDelimitedFrom(InputStream inputStream) {
        return (GarsonOuterClass$ResponseGetBotBanners) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GarsonOuterClass$ResponseGetBotBanners parseFrom(ByteBuffer byteBuffer) {
        return (GarsonOuterClass$ResponseGetBotBanners) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeBanners(int i) {
        ensureBannersIsMutable();
        this.banners_.remove(i);
    }

    private void setBanners(int i, GarsonStruct$GarsonBanner garsonStruct$GarsonBanner) {
        garsonStruct$GarsonBanner.getClass();
        ensureBannersIsMutable();
        this.banners_.set(i, garsonStruct$GarsonBanner);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1847d0.a[gVar.ordinal()]) {
            case 1:
                return new GarsonOuterClass$ResponseGetBotBanners();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"banners_", GarsonStruct$GarsonBanner.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (GarsonOuterClass$ResponseGetBotBanners.class) {
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

    public GarsonStruct$GarsonBanner getBanners(int i) {
        return (GarsonStruct$GarsonBanner) this.banners_.get(i);
    }

    public int getBannersCount() {
        return this.banners_.size();
    }

    public List<GarsonStruct$GarsonBanner> getBannersList() {
        return this.banners_;
    }

    public InterfaceC1853f0 getBannersOrBuilder(int i) {
        return (InterfaceC1853f0) this.banners_.get(i);
    }

    public List<? extends InterfaceC1853f0> getBannersOrBuilderList() {
        return this.banners_;
    }

    public static a newBuilder(GarsonOuterClass$ResponseGetBotBanners garsonOuterClass$ResponseGetBotBanners) {
        return (a) DEFAULT_INSTANCE.createBuilder(garsonOuterClass$ResponseGetBotBanners);
    }

    public static GarsonOuterClass$ResponseGetBotBanners parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (GarsonOuterClass$ResponseGetBotBanners) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GarsonOuterClass$ResponseGetBotBanners parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (GarsonOuterClass$ResponseGetBotBanners) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static GarsonOuterClass$ResponseGetBotBanners parseFrom(AbstractC2383g abstractC2383g) {
        return (GarsonOuterClass$ResponseGetBotBanners) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addBanners(int i, GarsonStruct$GarsonBanner garsonStruct$GarsonBanner) {
        garsonStruct$GarsonBanner.getClass();
        ensureBannersIsMutable();
        this.banners_.add(i, garsonStruct$GarsonBanner);
    }

    public static GarsonOuterClass$ResponseGetBotBanners parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (GarsonOuterClass$ResponseGetBotBanners) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static GarsonOuterClass$ResponseGetBotBanners parseFrom(byte[] bArr) {
        return (GarsonOuterClass$ResponseGetBotBanners) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GarsonOuterClass$ResponseGetBotBanners parseFrom(byte[] bArr, C2394s c2394s) {
        return (GarsonOuterClass$ResponseGetBotBanners) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static GarsonOuterClass$ResponseGetBotBanners parseFrom(InputStream inputStream) {
        return (GarsonOuterClass$ResponseGetBotBanners) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GarsonOuterClass$ResponseGetBotBanners parseFrom(InputStream inputStream, C2394s c2394s) {
        return (GarsonOuterClass$ResponseGetBotBanners) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GarsonOuterClass$ResponseGetBotBanners parseFrom(AbstractC2384h abstractC2384h) {
        return (GarsonOuterClass$ResponseGetBotBanners) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static GarsonOuterClass$ResponseGetBotBanners parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (GarsonOuterClass$ResponseGetBotBanners) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
