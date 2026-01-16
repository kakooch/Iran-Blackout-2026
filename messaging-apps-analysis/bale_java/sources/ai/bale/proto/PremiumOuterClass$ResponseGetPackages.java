package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.r0;
import ir.nasim.InterfaceC4533Fn5;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: classes9.dex */
public final class PremiumOuterClass$ResponseGetPackages extends GeneratedMessageLite implements U64 {
    public static final int BUNDLES_FIELD_NUMBER = 2;
    private static final PremiumOuterClass$ResponseGetPackages DEFAULT_INSTANCE;
    public static final int PACKAGES_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private com.google.protobuf.J bundles_ = com.google.protobuf.J.e();
    private B.j packages_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(PremiumOuterClass$ResponseGetPackages.DEFAULT_INSTANCE);
        }
    }

    private static final class b {
        static final com.google.protobuf.I a = com.google.protobuf.I.d(r0.b.e, 0L, r0.b.m, PremiumStruct$Bundle.getDefaultInstance());
    }

    static {
        PremiumOuterClass$ResponseGetPackages premiumOuterClass$ResponseGetPackages = new PremiumOuterClass$ResponseGetPackages();
        DEFAULT_INSTANCE = premiumOuterClass$ResponseGetPackages;
        GeneratedMessageLite.registerDefaultInstance(PremiumOuterClass$ResponseGetPackages.class, premiumOuterClass$ResponseGetPackages);
    }

    private PremiumOuterClass$ResponseGetPackages() {
    }

    private void addAllPackages(Iterable<? extends PremiumStruct$PackageInfo> iterable) {
        ensurePackagesIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.packages_);
    }

    private void addPackages(PremiumStruct$PackageInfo premiumStruct$PackageInfo) {
        premiumStruct$PackageInfo.getClass();
        ensurePackagesIsMutable();
        this.packages_.add(premiumStruct$PackageInfo);
    }

    private void clearPackages() {
        this.packages_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensurePackagesIsMutable() {
        B.j jVar = this.packages_;
        if (jVar.u()) {
            return;
        }
        this.packages_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static PremiumOuterClass$ResponseGetPackages getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private Map<Long, PremiumStruct$Bundle> getMutableBundlesMap() {
        return internalGetMutableBundles();
    }

    private com.google.protobuf.J internalGetBundles() {
        return this.bundles_;
    }

    private com.google.protobuf.J internalGetMutableBundles() {
        if (!this.bundles_.n()) {
            this.bundles_ = this.bundles_.s();
        }
        return this.bundles_;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static PremiumOuterClass$ResponseGetPackages parseDelimitedFrom(InputStream inputStream) {
        return (PremiumOuterClass$ResponseGetPackages) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PremiumOuterClass$ResponseGetPackages parseFrom(ByteBuffer byteBuffer) {
        return (PremiumOuterClass$ResponseGetPackages) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removePackages(int i) {
        ensurePackagesIsMutable();
        this.packages_.remove(i);
    }

    private void setPackages(int i, PremiumStruct$PackageInfo premiumStruct$PackageInfo) {
        premiumStruct$PackageInfo.getClass();
        ensurePackagesIsMutable();
        this.packages_.set(i, premiumStruct$PackageInfo);
    }

    public boolean containsBundles(long j) {
        return internalGetBundles().containsKey(Long.valueOf(j));
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1860h1.a[gVar.ordinal()]) {
            case 1:
                return new PremiumOuterClass$ResponseGetPackages();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0001\u0001\u0000\u0001\u001b\u00022", new Object[]{"packages_", PremiumStruct$PackageInfo.class, "bundles_", b.a});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (PremiumOuterClass$ResponseGetPackages.class) {
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
    public Map<Long, PremiumStruct$Bundle> getBundles() {
        return getBundlesMap();
    }

    public int getBundlesCount() {
        return internalGetBundles().size();
    }

    public Map<Long, PremiumStruct$Bundle> getBundlesMap() {
        return Collections.unmodifiableMap(internalGetBundles());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PremiumStruct$Bundle getBundlesOrDefault(long j, PremiumStruct$Bundle premiumStruct$Bundle) {
        com.google.protobuf.J jInternalGetBundles = internalGetBundles();
        return jInternalGetBundles.containsKey(Long.valueOf(j)) ? (PremiumStruct$Bundle) jInternalGetBundles.get(Long.valueOf(j)) : premiumStruct$Bundle;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PremiumStruct$Bundle getBundlesOrThrow(long j) {
        com.google.protobuf.J jInternalGetBundles = internalGetBundles();
        if (jInternalGetBundles.containsKey(Long.valueOf(j))) {
            return (PremiumStruct$Bundle) jInternalGetBundles.get(Long.valueOf(j));
        }
        throw new IllegalArgumentException();
    }

    public PremiumStruct$PackageInfo getPackages(int i) {
        return (PremiumStruct$PackageInfo) this.packages_.get(i);
    }

    public int getPackagesCount() {
        return this.packages_.size();
    }

    public List<PremiumStruct$PackageInfo> getPackagesList() {
        return this.packages_;
    }

    public InterfaceC4533Fn5 getPackagesOrBuilder(int i) {
        return (InterfaceC4533Fn5) this.packages_.get(i);
    }

    public List<? extends InterfaceC4533Fn5> getPackagesOrBuilderList() {
        return this.packages_;
    }

    public static a newBuilder(PremiumOuterClass$ResponseGetPackages premiumOuterClass$ResponseGetPackages) {
        return (a) DEFAULT_INSTANCE.createBuilder(premiumOuterClass$ResponseGetPackages);
    }

    public static PremiumOuterClass$ResponseGetPackages parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (PremiumOuterClass$ResponseGetPackages) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PremiumOuterClass$ResponseGetPackages parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (PremiumOuterClass$ResponseGetPackages) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static PremiumOuterClass$ResponseGetPackages parseFrom(AbstractC2383g abstractC2383g) {
        return (PremiumOuterClass$ResponseGetPackages) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addPackages(int i, PremiumStruct$PackageInfo premiumStruct$PackageInfo) {
        premiumStruct$PackageInfo.getClass();
        ensurePackagesIsMutable();
        this.packages_.add(i, premiumStruct$PackageInfo);
    }

    public static PremiumOuterClass$ResponseGetPackages parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (PremiumOuterClass$ResponseGetPackages) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static PremiumOuterClass$ResponseGetPackages parseFrom(byte[] bArr) {
        return (PremiumOuterClass$ResponseGetPackages) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PremiumOuterClass$ResponseGetPackages parseFrom(byte[] bArr, C2394s c2394s) {
        return (PremiumOuterClass$ResponseGetPackages) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static PremiumOuterClass$ResponseGetPackages parseFrom(InputStream inputStream) {
        return (PremiumOuterClass$ResponseGetPackages) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PremiumOuterClass$ResponseGetPackages parseFrom(InputStream inputStream, C2394s c2394s) {
        return (PremiumOuterClass$ResponseGetPackages) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PremiumOuterClass$ResponseGetPackages parseFrom(AbstractC2384h abstractC2384h) {
        return (PremiumOuterClass$ResponseGetPackages) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static PremiumOuterClass$ResponseGetPackages parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (PremiumOuterClass$ResponseGetPackages) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
