package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC19634qh;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes8.dex */
public final class AdvertisementOuterClass$ResponseGetUserOnboardingScenario extends GeneratedMessageLite implements U64 {
    private static final AdvertisementOuterClass$ResponseGetUserOnboardingScenario DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int SCENARIO_FIELD_NUMBER = 1;
    private int scenario_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(AdvertisementOuterClass$ResponseGetUserOnboardingScenario.DEFAULT_INSTANCE);
        }
    }

    static {
        AdvertisementOuterClass$ResponseGetUserOnboardingScenario advertisementOuterClass$ResponseGetUserOnboardingScenario = new AdvertisementOuterClass$ResponseGetUserOnboardingScenario();
        DEFAULT_INSTANCE = advertisementOuterClass$ResponseGetUserOnboardingScenario;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementOuterClass$ResponseGetUserOnboardingScenario.class, advertisementOuterClass$ResponseGetUserOnboardingScenario);
    }

    private AdvertisementOuterClass$ResponseGetUserOnboardingScenario() {
    }

    private void clearScenario() {
        this.scenario_ = 0;
    }

    public static AdvertisementOuterClass$ResponseGetUserOnboardingScenario getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AdvertisementOuterClass$ResponseGetUserOnboardingScenario parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$ResponseGetUserOnboardingScenario) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$ResponseGetUserOnboardingScenario parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementOuterClass$ResponseGetUserOnboardingScenario) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setScenario(EnumC19634qh enumC19634qh) {
        this.scenario_ = enumC19634qh.getNumber();
    }

    private void setScenarioValue(int i) {
        this.scenario_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1840b.a[gVar.ordinal()]) {
            case 1:
                return new AdvertisementOuterClass$ResponseGetUserOnboardingScenario();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\f", new Object[]{"scenario_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementOuterClass$ResponseGetUserOnboardingScenario.class) {
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

    public EnumC19634qh getScenario() {
        EnumC19634qh enumC19634qhJ = EnumC19634qh.j(this.scenario_);
        return enumC19634qhJ == null ? EnumC19634qh.UNRECOGNIZED : enumC19634qhJ;
    }

    public int getScenarioValue() {
        return this.scenario_;
    }

    public static a newBuilder(AdvertisementOuterClass$ResponseGetUserOnboardingScenario advertisementOuterClass$ResponseGetUserOnboardingScenario) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementOuterClass$ResponseGetUserOnboardingScenario);
    }

    public static AdvertisementOuterClass$ResponseGetUserOnboardingScenario parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetUserOnboardingScenario) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetUserOnboardingScenario parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetUserOnboardingScenario) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetUserOnboardingScenario parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementOuterClass$ResponseGetUserOnboardingScenario) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AdvertisementOuterClass$ResponseGetUserOnboardingScenario parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetUserOnboardingScenario) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetUserOnboardingScenario parseFrom(byte[] bArr) {
        return (AdvertisementOuterClass$ResponseGetUserOnboardingScenario) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementOuterClass$ResponseGetUserOnboardingScenario parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetUserOnboardingScenario) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetUserOnboardingScenario parseFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$ResponseGetUserOnboardingScenario) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$ResponseGetUserOnboardingScenario parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetUserOnboardingScenario) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetUserOnboardingScenario parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementOuterClass$ResponseGetUserOnboardingScenario) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementOuterClass$ResponseGetUserOnboardingScenario parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetUserOnboardingScenario) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
