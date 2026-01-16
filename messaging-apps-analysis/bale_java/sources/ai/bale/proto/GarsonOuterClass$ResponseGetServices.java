package ai.bale.proto;

import ai.bale.proto.GarsonStruct$GarsonServices;
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
public final class GarsonOuterClass$ResponseGetServices extends GeneratedMessageLite implements U64 {
    public static final int BANNERS_FIELD_NUMBER = 4;
    public static final int DATA_FIELD_NUMBER = 3;
    private static final GarsonOuterClass$ResponseGetServices DEFAULT_INSTANCE;
    public static final int IS_CHANGED_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int SECTIONS_FIELD_NUMBER = 6;
    public static final int SERVICES_FIELD_NUMBER = 5;
    public static final int VERSION_FIELD_NUMBER = 1;
    private int bitField0_;
    private boolean isChanged_;
    private GarsonStruct$GarsonServices services_;
    private int version_;
    private String data_ = "";
    private B.j banners_ = GeneratedMessageLite.emptyProtobufList();
    private B.j sections_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(GarsonOuterClass$ResponseGetServices.DEFAULT_INSTANCE);
        }
    }

    static {
        GarsonOuterClass$ResponseGetServices garsonOuterClass$ResponseGetServices = new GarsonOuterClass$ResponseGetServices();
        DEFAULT_INSTANCE = garsonOuterClass$ResponseGetServices;
        GeneratedMessageLite.registerDefaultInstance(GarsonOuterClass$ResponseGetServices.class, garsonOuterClass$ResponseGetServices);
    }

    private GarsonOuterClass$ResponseGetServices() {
    }

    private void addAllBanners(Iterable<? extends GarsonStruct$GarsonBanner> iterable) {
        ensureBannersIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.banners_);
    }

    private void addAllSections(Iterable<? extends GarsonStruct$GarsonSection> iterable) {
        ensureSectionsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.sections_);
    }

    private void addBanners(GarsonStruct$GarsonBanner garsonStruct$GarsonBanner) {
        garsonStruct$GarsonBanner.getClass();
        ensureBannersIsMutable();
        this.banners_.add(garsonStruct$GarsonBanner);
    }

    private void addSections(GarsonStruct$GarsonSection garsonStruct$GarsonSection) {
        garsonStruct$GarsonSection.getClass();
        ensureSectionsIsMutable();
        this.sections_.add(garsonStruct$GarsonSection);
    }

    private void clearBanners() {
        this.banners_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearData() {
        this.data_ = getDefaultInstance().getData();
    }

    private void clearIsChanged() {
        this.isChanged_ = false;
    }

    private void clearSections() {
        this.sections_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearServices() {
        this.services_ = null;
        this.bitField0_ &= -2;
    }

    private void clearVersion() {
        this.version_ = 0;
    }

    private void ensureBannersIsMutable() {
        B.j jVar = this.banners_;
        if (jVar.u()) {
            return;
        }
        this.banners_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    private void ensureSectionsIsMutable() {
        B.j jVar = this.sections_;
        if (jVar.u()) {
            return;
        }
        this.sections_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static GarsonOuterClass$ResponseGetServices getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeServices(GarsonStruct$GarsonServices garsonStruct$GarsonServices) {
        garsonStruct$GarsonServices.getClass();
        GarsonStruct$GarsonServices garsonStruct$GarsonServices2 = this.services_;
        if (garsonStruct$GarsonServices2 == null || garsonStruct$GarsonServices2 == GarsonStruct$GarsonServices.getDefaultInstance()) {
            this.services_ = garsonStruct$GarsonServices;
        } else {
            this.services_ = (GarsonStruct$GarsonServices) ((GarsonStruct$GarsonServices.a) GarsonStruct$GarsonServices.newBuilder(this.services_).v(garsonStruct$GarsonServices)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static GarsonOuterClass$ResponseGetServices parseDelimitedFrom(InputStream inputStream) {
        return (GarsonOuterClass$ResponseGetServices) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GarsonOuterClass$ResponseGetServices parseFrom(ByteBuffer byteBuffer) {
        return (GarsonOuterClass$ResponseGetServices) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeBanners(int i) {
        ensureBannersIsMutable();
        this.banners_.remove(i);
    }

    private void removeSections(int i) {
        ensureSectionsIsMutable();
        this.sections_.remove(i);
    }

    private void setBanners(int i, GarsonStruct$GarsonBanner garsonStruct$GarsonBanner) {
        garsonStruct$GarsonBanner.getClass();
        ensureBannersIsMutable();
        this.banners_.set(i, garsonStruct$GarsonBanner);
    }

    private void setData(String str) {
        str.getClass();
        this.data_ = str;
    }

    private void setDataBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.data_ = abstractC2383g.f0();
    }

    private void setIsChanged(boolean z) {
        this.isChanged_ = z;
    }

    private void setSections(int i, GarsonStruct$GarsonSection garsonStruct$GarsonSection) {
        garsonStruct$GarsonSection.getClass();
        ensureSectionsIsMutable();
        this.sections_.set(i, garsonStruct$GarsonSection);
    }

    private void setServices(GarsonStruct$GarsonServices garsonStruct$GarsonServices) {
        garsonStruct$GarsonServices.getClass();
        this.services_ = garsonStruct$GarsonServices;
        this.bitField0_ |= 1;
    }

    private void setVersion(int i) {
        this.version_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1847d0.a[gVar.ordinal()]) {
            case 1:
                return new GarsonOuterClass$ResponseGetServices();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0002\u0000\u0001\u0004\u0002\u0007\u0003Ȉ\u0004\u001b\u0005ဉ\u0000\u0006\u001b", new Object[]{"bitField0_", "version_", "isChanged_", "data_", "banners_", GarsonStruct$GarsonBanner.class, "services_", "sections_", GarsonStruct$GarsonSection.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (GarsonOuterClass$ResponseGetServices.class) {
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

    @Deprecated
    public GarsonStruct$GarsonBanner getBanners(int i) {
        return (GarsonStruct$GarsonBanner) this.banners_.get(i);
    }

    @Deprecated
    public int getBannersCount() {
        return this.banners_.size();
    }

    @Deprecated
    public List<GarsonStruct$GarsonBanner> getBannersList() {
        return this.banners_;
    }

    @Deprecated
    public InterfaceC1853f0 getBannersOrBuilder(int i) {
        return (InterfaceC1853f0) this.banners_.get(i);
    }

    @Deprecated
    public List<? extends InterfaceC1853f0> getBannersOrBuilderList() {
        return this.banners_;
    }

    @Deprecated
    public String getData() {
        return this.data_;
    }

    @Deprecated
    public AbstractC2383g getDataBytes() {
        return AbstractC2383g.N(this.data_);
    }

    public boolean getIsChanged() {
        return this.isChanged_;
    }

    public GarsonStruct$GarsonSection getSections(int i) {
        return (GarsonStruct$GarsonSection) this.sections_.get(i);
    }

    public int getSectionsCount() {
        return this.sections_.size();
    }

    public List<GarsonStruct$GarsonSection> getSectionsList() {
        return this.sections_;
    }

    public InterfaceC1859h0 getSectionsOrBuilder(int i) {
        return (InterfaceC1859h0) this.sections_.get(i);
    }

    public List<? extends InterfaceC1859h0> getSectionsOrBuilderList() {
        return this.sections_;
    }

    public GarsonStruct$GarsonServices getServices() {
        GarsonStruct$GarsonServices garsonStruct$GarsonServices = this.services_;
        return garsonStruct$GarsonServices == null ? GarsonStruct$GarsonServices.getDefaultInstance() : garsonStruct$GarsonServices;
    }

    public int getVersion() {
        return this.version_;
    }

    public boolean hasServices() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(GarsonOuterClass$ResponseGetServices garsonOuterClass$ResponseGetServices) {
        return (a) DEFAULT_INSTANCE.createBuilder(garsonOuterClass$ResponseGetServices);
    }

    public static GarsonOuterClass$ResponseGetServices parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (GarsonOuterClass$ResponseGetServices) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GarsonOuterClass$ResponseGetServices parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (GarsonOuterClass$ResponseGetServices) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static GarsonOuterClass$ResponseGetServices parseFrom(AbstractC2383g abstractC2383g) {
        return (GarsonOuterClass$ResponseGetServices) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addBanners(int i, GarsonStruct$GarsonBanner garsonStruct$GarsonBanner) {
        garsonStruct$GarsonBanner.getClass();
        ensureBannersIsMutable();
        this.banners_.add(i, garsonStruct$GarsonBanner);
    }

    private void addSections(int i, GarsonStruct$GarsonSection garsonStruct$GarsonSection) {
        garsonStruct$GarsonSection.getClass();
        ensureSectionsIsMutable();
        this.sections_.add(i, garsonStruct$GarsonSection);
    }

    public static GarsonOuterClass$ResponseGetServices parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (GarsonOuterClass$ResponseGetServices) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static GarsonOuterClass$ResponseGetServices parseFrom(byte[] bArr) {
        return (GarsonOuterClass$ResponseGetServices) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GarsonOuterClass$ResponseGetServices parseFrom(byte[] bArr, C2394s c2394s) {
        return (GarsonOuterClass$ResponseGetServices) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static GarsonOuterClass$ResponseGetServices parseFrom(InputStream inputStream) {
        return (GarsonOuterClass$ResponseGetServices) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GarsonOuterClass$ResponseGetServices parseFrom(InputStream inputStream, C2394s c2394s) {
        return (GarsonOuterClass$ResponseGetServices) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GarsonOuterClass$ResponseGetServices parseFrom(AbstractC2384h abstractC2384h) {
        return (GarsonOuterClass$ResponseGetServices) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static GarsonOuterClass$ResponseGetServices parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (GarsonOuterClass$ResponseGetServices) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
