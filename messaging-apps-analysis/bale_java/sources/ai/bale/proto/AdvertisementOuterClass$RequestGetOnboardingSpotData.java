package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC23297wh;
import ir.nasim.EnumC4473Fh;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes8.dex */
public final class AdvertisementOuterClass$RequestGetOnboardingSpotData extends GeneratedMessageLite implements U64 {
    private static final AdvertisementOuterClass$RequestGetOnboardingSpotData DEFAULT_INSTANCE;
    public static final int ONBOARDING_SPOT_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int SUGGESTED_PEER_TYPE_FIELD_NUMBER = 2;
    private int onboardingSpot_;
    private int suggestedPeerType_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(EnumC23297wh enumC23297wh) {
            q();
            ((AdvertisementOuterClass$RequestGetOnboardingSpotData) this.b).setOnboardingSpot(enumC23297wh);
            return this;
        }

        public a B(EnumC4473Fh enumC4473Fh) {
            q();
            ((AdvertisementOuterClass$RequestGetOnboardingSpotData) this.b).setSuggestedPeerType(enumC4473Fh);
            return this;
        }

        private a() {
            super(AdvertisementOuterClass$RequestGetOnboardingSpotData.DEFAULT_INSTANCE);
        }
    }

    static {
        AdvertisementOuterClass$RequestGetOnboardingSpotData advertisementOuterClass$RequestGetOnboardingSpotData = new AdvertisementOuterClass$RequestGetOnboardingSpotData();
        DEFAULT_INSTANCE = advertisementOuterClass$RequestGetOnboardingSpotData;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementOuterClass$RequestGetOnboardingSpotData.class, advertisementOuterClass$RequestGetOnboardingSpotData);
    }

    private AdvertisementOuterClass$RequestGetOnboardingSpotData() {
    }

    private void clearOnboardingSpot() {
        this.onboardingSpot_ = 0;
    }

    private void clearSuggestedPeerType() {
        this.suggestedPeerType_ = 0;
    }

    public static AdvertisementOuterClass$RequestGetOnboardingSpotData getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AdvertisementOuterClass$RequestGetOnboardingSpotData parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$RequestGetOnboardingSpotData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$RequestGetOnboardingSpotData parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementOuterClass$RequestGetOnboardingSpotData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOnboardingSpot(EnumC23297wh enumC23297wh) {
        this.onboardingSpot_ = enumC23297wh.getNumber();
    }

    private void setOnboardingSpotValue(int i) {
        this.onboardingSpot_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSuggestedPeerType(EnumC4473Fh enumC4473Fh) {
        this.suggestedPeerType_ = enumC4473Fh.getNumber();
    }

    private void setSuggestedPeerTypeValue(int i) {
        this.suggestedPeerType_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1840b.a[gVar.ordinal()]) {
            case 1:
                return new AdvertisementOuterClass$RequestGetOnboardingSpotData();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0002\f", new Object[]{"onboardingSpot_", "suggestedPeerType_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementOuterClass$RequestGetOnboardingSpotData.class) {
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

    public EnumC23297wh getOnboardingSpot() {
        EnumC23297wh enumC23297whJ = EnumC23297wh.j(this.onboardingSpot_);
        return enumC23297whJ == null ? EnumC23297wh.UNRECOGNIZED : enumC23297whJ;
    }

    public int getOnboardingSpotValue() {
        return this.onboardingSpot_;
    }

    public EnumC4473Fh getSuggestedPeerType() {
        EnumC4473Fh enumC4473FhJ = EnumC4473Fh.j(this.suggestedPeerType_);
        return enumC4473FhJ == null ? EnumC4473Fh.UNRECOGNIZED : enumC4473FhJ;
    }

    public int getSuggestedPeerTypeValue() {
        return this.suggestedPeerType_;
    }

    public static a newBuilder(AdvertisementOuterClass$RequestGetOnboardingSpotData advertisementOuterClass$RequestGetOnboardingSpotData) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementOuterClass$RequestGetOnboardingSpotData);
    }

    public static AdvertisementOuterClass$RequestGetOnboardingSpotData parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestGetOnboardingSpotData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$RequestGetOnboardingSpotData parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestGetOnboardingSpotData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementOuterClass$RequestGetOnboardingSpotData parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementOuterClass$RequestGetOnboardingSpotData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AdvertisementOuterClass$RequestGetOnboardingSpotData parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestGetOnboardingSpotData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementOuterClass$RequestGetOnboardingSpotData parseFrom(byte[] bArr) {
        return (AdvertisementOuterClass$RequestGetOnboardingSpotData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementOuterClass$RequestGetOnboardingSpotData parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestGetOnboardingSpotData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AdvertisementOuterClass$RequestGetOnboardingSpotData parseFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$RequestGetOnboardingSpotData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$RequestGetOnboardingSpotData parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestGetOnboardingSpotData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$RequestGetOnboardingSpotData parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementOuterClass$RequestGetOnboardingSpotData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementOuterClass$RequestGetOnboardingSpotData parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestGetOnboardingSpotData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
