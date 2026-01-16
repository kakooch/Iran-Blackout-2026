package bale.smart_support.v1;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC20582sF6;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes2.dex */
public final class SmartSupportOuterClass$ResponseGetActivePackages extends GeneratedMessageLite implements U64 {
    private static final SmartSupportOuterClass$ResponseGetActivePackages DEFAULT_INSTANCE;
    public static final int PACKAGES_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private B.j packages_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(SmartSupportOuterClass$ResponseGetActivePackages.DEFAULT_INSTANCE);
        }
    }

    static {
        SmartSupportOuterClass$ResponseGetActivePackages smartSupportOuterClass$ResponseGetActivePackages = new SmartSupportOuterClass$ResponseGetActivePackages();
        DEFAULT_INSTANCE = smartSupportOuterClass$ResponseGetActivePackages;
        GeneratedMessageLite.registerDefaultInstance(SmartSupportOuterClass$ResponseGetActivePackages.class, smartSupportOuterClass$ResponseGetActivePackages);
    }

    private SmartSupportOuterClass$ResponseGetActivePackages() {
    }

    private void addAllPackages(Iterable<? extends SmartSupportStruct$Package> iterable) {
        ensurePackagesIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.packages_);
    }

    private void addPackages(SmartSupportStruct$Package smartSupportStruct$Package) {
        smartSupportStruct$Package.getClass();
        ensurePackagesIsMutable();
        this.packages_.add(smartSupportStruct$Package);
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

    public static SmartSupportOuterClass$ResponseGetActivePackages getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SmartSupportOuterClass$ResponseGetActivePackages parseDelimitedFrom(InputStream inputStream) {
        return (SmartSupportOuterClass$ResponseGetActivePackages) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SmartSupportOuterClass$ResponseGetActivePackages parseFrom(ByteBuffer byteBuffer) {
        return (SmartSupportOuterClass$ResponseGetActivePackages) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removePackages(int i) {
        ensurePackagesIsMutable();
        this.packages_.remove(i);
    }

    private void setPackages(int i, SmartSupportStruct$Package smartSupportStruct$Package) {
        smartSupportStruct$Package.getClass();
        ensurePackagesIsMutable();
        this.packages_.set(i, smartSupportStruct$Package);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (b.a[gVar.ordinal()]) {
            case 1:
                return new SmartSupportOuterClass$ResponseGetActivePackages();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"packages_", SmartSupportStruct$Package.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SmartSupportOuterClass$ResponseGetActivePackages.class) {
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

    public SmartSupportStruct$Package getPackages(int i) {
        return (SmartSupportStruct$Package) this.packages_.get(i);
    }

    public int getPackagesCount() {
        return this.packages_.size();
    }

    public List<SmartSupportStruct$Package> getPackagesList() {
        return this.packages_;
    }

    public InterfaceC20582sF6 getPackagesOrBuilder(int i) {
        return (InterfaceC20582sF6) this.packages_.get(i);
    }

    public List<? extends InterfaceC20582sF6> getPackagesOrBuilderList() {
        return this.packages_;
    }

    public static a newBuilder(SmartSupportOuterClass$ResponseGetActivePackages smartSupportOuterClass$ResponseGetActivePackages) {
        return (a) DEFAULT_INSTANCE.createBuilder(smartSupportOuterClass$ResponseGetActivePackages);
    }

    public static SmartSupportOuterClass$ResponseGetActivePackages parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SmartSupportOuterClass$ResponseGetActivePackages) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SmartSupportOuterClass$ResponseGetActivePackages parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SmartSupportOuterClass$ResponseGetActivePackages) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SmartSupportOuterClass$ResponseGetActivePackages parseFrom(AbstractC2383g abstractC2383g) {
        return (SmartSupportOuterClass$ResponseGetActivePackages) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addPackages(int i, SmartSupportStruct$Package smartSupportStruct$Package) {
        smartSupportStruct$Package.getClass();
        ensurePackagesIsMutable();
        this.packages_.add(i, smartSupportStruct$Package);
    }

    public static SmartSupportOuterClass$ResponseGetActivePackages parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SmartSupportOuterClass$ResponseGetActivePackages) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SmartSupportOuterClass$ResponseGetActivePackages parseFrom(byte[] bArr) {
        return (SmartSupportOuterClass$ResponseGetActivePackages) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SmartSupportOuterClass$ResponseGetActivePackages parseFrom(byte[] bArr, C2394s c2394s) {
        return (SmartSupportOuterClass$ResponseGetActivePackages) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SmartSupportOuterClass$ResponseGetActivePackages parseFrom(InputStream inputStream) {
        return (SmartSupportOuterClass$ResponseGetActivePackages) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SmartSupportOuterClass$ResponseGetActivePackages parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SmartSupportOuterClass$ResponseGetActivePackages) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SmartSupportOuterClass$ResponseGetActivePackages parseFrom(AbstractC2384h abstractC2384h) {
        return (SmartSupportOuterClass$ResponseGetActivePackages) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SmartSupportOuterClass$ResponseGetActivePackages parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SmartSupportOuterClass$ResponseGetActivePackages) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
