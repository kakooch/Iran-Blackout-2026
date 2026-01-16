package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC3831Cn5;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class PremiumStruct$Bundle extends GeneratedMessageLite implements U64 {
    private static final PremiumStruct$Bundle DEFAULT_INSTANCE;
    public static final int FEATURES_FIELD_NUMBER = 6;
    private static volatile KW4 PARSER;
    private B.j features_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(PremiumStruct$Bundle.DEFAULT_INSTANCE);
        }
    }

    static {
        PremiumStruct$Bundle premiumStruct$Bundle = new PremiumStruct$Bundle();
        DEFAULT_INSTANCE = premiumStruct$Bundle;
        GeneratedMessageLite.registerDefaultInstance(PremiumStruct$Bundle.class, premiumStruct$Bundle);
    }

    private PremiumStruct$Bundle() {
    }

    private void addAllFeatures(Iterable<? extends PremiumStruct$FeatureInfo> iterable) {
        ensureFeaturesIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.features_);
    }

    private void addFeatures(PremiumStruct$FeatureInfo premiumStruct$FeatureInfo) {
        premiumStruct$FeatureInfo.getClass();
        ensureFeaturesIsMutable();
        this.features_.add(premiumStruct$FeatureInfo);
    }

    private void clearFeatures() {
        this.features_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureFeaturesIsMutable() {
        B.j jVar = this.features_;
        if (jVar.u()) {
            return;
        }
        this.features_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static PremiumStruct$Bundle getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static PremiumStruct$Bundle parseDelimitedFrom(InputStream inputStream) {
        return (PremiumStruct$Bundle) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PremiumStruct$Bundle parseFrom(ByteBuffer byteBuffer) {
        return (PremiumStruct$Bundle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeFeatures(int i) {
        ensureFeaturesIsMutable();
        this.features_.remove(i);
    }

    private void setFeatures(int i, PremiumStruct$FeatureInfo premiumStruct$FeatureInfo) {
        premiumStruct$FeatureInfo.getClass();
        ensureFeaturesIsMutable();
        this.features_.set(i, premiumStruct$FeatureInfo);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1863i1.a[gVar.ordinal()]) {
            case 1:
                return new PremiumStruct$Bundle();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0006\u0006\u0001\u0000\u0001\u0000\u0006\u001b", new Object[]{"features_", PremiumStruct$FeatureInfo.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (PremiumStruct$Bundle.class) {
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

    public PremiumStruct$FeatureInfo getFeatures(int i) {
        return (PremiumStruct$FeatureInfo) this.features_.get(i);
    }

    public int getFeaturesCount() {
        return this.features_.size();
    }

    public List<PremiumStruct$FeatureInfo> getFeaturesList() {
        return this.features_;
    }

    public InterfaceC3831Cn5 getFeaturesOrBuilder(int i) {
        return (InterfaceC3831Cn5) this.features_.get(i);
    }

    public List<? extends InterfaceC3831Cn5> getFeaturesOrBuilderList() {
        return this.features_;
    }

    public static a newBuilder(PremiumStruct$Bundle premiumStruct$Bundle) {
        return (a) DEFAULT_INSTANCE.createBuilder(premiumStruct$Bundle);
    }

    public static PremiumStruct$Bundle parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (PremiumStruct$Bundle) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PremiumStruct$Bundle parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (PremiumStruct$Bundle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static PremiumStruct$Bundle parseFrom(AbstractC2383g abstractC2383g) {
        return (PremiumStruct$Bundle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addFeatures(int i, PremiumStruct$FeatureInfo premiumStruct$FeatureInfo) {
        premiumStruct$FeatureInfo.getClass();
        ensureFeaturesIsMutable();
        this.features_.add(i, premiumStruct$FeatureInfo);
    }

    public static PremiumStruct$Bundle parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (PremiumStruct$Bundle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static PremiumStruct$Bundle parseFrom(byte[] bArr) {
        return (PremiumStruct$Bundle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PremiumStruct$Bundle parseFrom(byte[] bArr, C2394s c2394s) {
        return (PremiumStruct$Bundle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static PremiumStruct$Bundle parseFrom(InputStream inputStream) {
        return (PremiumStruct$Bundle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PremiumStruct$Bundle parseFrom(InputStream inputStream, C2394s c2394s) {
        return (PremiumStruct$Bundle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PremiumStruct$Bundle parseFrom(AbstractC2384h abstractC2384h) {
        return (PremiumStruct$Bundle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static PremiumStruct$Bundle parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (PremiumStruct$Bundle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
