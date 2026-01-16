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
public final class GarsonStruct$GarsonBannersSection extends GeneratedMessageLite implements U64 {
    public static final int BANNERS_FIELD_NUMBER = 1;
    private static final GarsonStruct$GarsonBannersSection DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private B.j banners_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(GarsonStruct$GarsonBannersSection.DEFAULT_INSTANCE);
        }
    }

    static {
        GarsonStruct$GarsonBannersSection garsonStruct$GarsonBannersSection = new GarsonStruct$GarsonBannersSection();
        DEFAULT_INSTANCE = garsonStruct$GarsonBannersSection;
        GeneratedMessageLite.registerDefaultInstance(GarsonStruct$GarsonBannersSection.class, garsonStruct$GarsonBannersSection);
    }

    private GarsonStruct$GarsonBannersSection() {
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

    public static GarsonStruct$GarsonBannersSection getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static GarsonStruct$GarsonBannersSection parseDelimitedFrom(InputStream inputStream) {
        return (GarsonStruct$GarsonBannersSection) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GarsonStruct$GarsonBannersSection parseFrom(ByteBuffer byteBuffer) {
        return (GarsonStruct$GarsonBannersSection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
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
        switch (AbstractC1850e0.a[gVar.ordinal()]) {
            case 1:
                return new GarsonStruct$GarsonBannersSection();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"banners_", GarsonStruct$GarsonBanner.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (GarsonStruct$GarsonBannersSection.class) {
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

    public static a newBuilder(GarsonStruct$GarsonBannersSection garsonStruct$GarsonBannersSection) {
        return (a) DEFAULT_INSTANCE.createBuilder(garsonStruct$GarsonBannersSection);
    }

    public static GarsonStruct$GarsonBannersSection parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (GarsonStruct$GarsonBannersSection) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GarsonStruct$GarsonBannersSection parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (GarsonStruct$GarsonBannersSection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static GarsonStruct$GarsonBannersSection parseFrom(AbstractC2383g abstractC2383g) {
        return (GarsonStruct$GarsonBannersSection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addBanners(int i, GarsonStruct$GarsonBanner garsonStruct$GarsonBanner) {
        garsonStruct$GarsonBanner.getClass();
        ensureBannersIsMutable();
        this.banners_.add(i, garsonStruct$GarsonBanner);
    }

    public static GarsonStruct$GarsonBannersSection parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (GarsonStruct$GarsonBannersSection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static GarsonStruct$GarsonBannersSection parseFrom(byte[] bArr) {
        return (GarsonStruct$GarsonBannersSection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GarsonStruct$GarsonBannersSection parseFrom(byte[] bArr, C2394s c2394s) {
        return (GarsonStruct$GarsonBannersSection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static GarsonStruct$GarsonBannersSection parseFrom(InputStream inputStream) {
        return (GarsonStruct$GarsonBannersSection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GarsonStruct$GarsonBannersSection parseFrom(InputStream inputStream, C2394s c2394s) {
        return (GarsonStruct$GarsonBannersSection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GarsonStruct$GarsonBannersSection parseFrom(AbstractC2384h abstractC2384h) {
        return (GarsonStruct$GarsonBannersSection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static GarsonStruct$GarsonBannersSection parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (GarsonStruct$GarsonBannersSection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
