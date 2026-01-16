package ai.bale.proto;

import ai.bale.proto.AdvertisementStruct$ContactPopularChannels;
import ai.bale.proto.AdvertisementStruct$SuggestedChannels;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes8.dex */
public final class AdvertisementOuterClass$ResponseGetOnboardingSpotData extends GeneratedMessageLite implements U64 {
    public static final int CONTACT_CHANNELS_FIELD_NUMBER = 1;
    private static final AdvertisementOuterClass$ResponseGetOnboardingSpotData DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int SUGGESTED_CHANNELS_FIELD_NUMBER = 2;
    private int traitCase_ = 0;
    private Object trait_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(AdvertisementOuterClass$ResponseGetOnboardingSpotData.DEFAULT_INSTANCE);
        }
    }

    public enum b {
        CONTACT_CHANNELS(1),
        SUGGESTED_CHANNELS(2),
        TRAIT_NOT_SET(0);

        private final int a;

        b(int i) {
            this.a = i;
        }

        public static b j(int i) {
            if (i == 0) {
                return TRAIT_NOT_SET;
            }
            if (i == 1) {
                return CONTACT_CHANNELS;
            }
            if (i != 2) {
                return null;
            }
            return SUGGESTED_CHANNELS;
        }
    }

    static {
        AdvertisementOuterClass$ResponseGetOnboardingSpotData advertisementOuterClass$ResponseGetOnboardingSpotData = new AdvertisementOuterClass$ResponseGetOnboardingSpotData();
        DEFAULT_INSTANCE = advertisementOuterClass$ResponseGetOnboardingSpotData;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementOuterClass$ResponseGetOnboardingSpotData.class, advertisementOuterClass$ResponseGetOnboardingSpotData);
    }

    private AdvertisementOuterClass$ResponseGetOnboardingSpotData() {
    }

    private void clearContactChannels() {
        if (this.traitCase_ == 1) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearSuggestedChannels() {
        if (this.traitCase_ == 2) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearTrait() {
        this.traitCase_ = 0;
        this.trait_ = null;
    }

    public static AdvertisementOuterClass$ResponseGetOnboardingSpotData getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeContactChannels(AdvertisementStruct$ContactPopularChannels advertisementStruct$ContactPopularChannels) {
        advertisementStruct$ContactPopularChannels.getClass();
        if (this.traitCase_ != 1 || this.trait_ == AdvertisementStruct$ContactPopularChannels.getDefaultInstance()) {
            this.trait_ = advertisementStruct$ContactPopularChannels;
        } else {
            this.trait_ = ((AdvertisementStruct$ContactPopularChannels.a) AdvertisementStruct$ContactPopularChannels.newBuilder((AdvertisementStruct$ContactPopularChannels) this.trait_).v(advertisementStruct$ContactPopularChannels)).j();
        }
        this.traitCase_ = 1;
    }

    private void mergeSuggestedChannels(AdvertisementStruct$SuggestedChannels advertisementStruct$SuggestedChannels) {
        advertisementStruct$SuggestedChannels.getClass();
        if (this.traitCase_ != 2 || this.trait_ == AdvertisementStruct$SuggestedChannels.getDefaultInstance()) {
            this.trait_ = advertisementStruct$SuggestedChannels;
        } else {
            this.trait_ = ((AdvertisementStruct$SuggestedChannels.a) AdvertisementStruct$SuggestedChannels.newBuilder((AdvertisementStruct$SuggestedChannels) this.trait_).v(advertisementStruct$SuggestedChannels)).j();
        }
        this.traitCase_ = 2;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AdvertisementOuterClass$ResponseGetOnboardingSpotData parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$ResponseGetOnboardingSpotData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$ResponseGetOnboardingSpotData parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementOuterClass$ResponseGetOnboardingSpotData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setContactChannels(AdvertisementStruct$ContactPopularChannels advertisementStruct$ContactPopularChannels) {
        advertisementStruct$ContactPopularChannels.getClass();
        this.trait_ = advertisementStruct$ContactPopularChannels;
        this.traitCase_ = 1;
    }

    private void setSuggestedChannels(AdvertisementStruct$SuggestedChannels advertisementStruct$SuggestedChannels) {
        advertisementStruct$SuggestedChannels.getClass();
        this.trait_ = advertisementStruct$SuggestedChannels;
        this.traitCase_ = 2;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1840b.a[gVar.ordinal()]) {
            case 1:
                return new AdvertisementOuterClass$ResponseGetOnboardingSpotData();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0001\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001<\u0000\u0002<\u0000", new Object[]{"trait_", "traitCase_", AdvertisementStruct$ContactPopularChannels.class, AdvertisementStruct$SuggestedChannels.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementOuterClass$ResponseGetOnboardingSpotData.class) {
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

    public AdvertisementStruct$ContactPopularChannels getContactChannels() {
        return this.traitCase_ == 1 ? (AdvertisementStruct$ContactPopularChannels) this.trait_ : AdvertisementStruct$ContactPopularChannels.getDefaultInstance();
    }

    public AdvertisementStruct$SuggestedChannels getSuggestedChannels() {
        return this.traitCase_ == 2 ? (AdvertisementStruct$SuggestedChannels) this.trait_ : AdvertisementStruct$SuggestedChannels.getDefaultInstance();
    }

    public b getTraitCase() {
        return b.j(this.traitCase_);
    }

    public boolean hasContactChannels() {
        return this.traitCase_ == 1;
    }

    public boolean hasSuggestedChannels() {
        return this.traitCase_ == 2;
    }

    public static a newBuilder(AdvertisementOuterClass$ResponseGetOnboardingSpotData advertisementOuterClass$ResponseGetOnboardingSpotData) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementOuterClass$ResponseGetOnboardingSpotData);
    }

    public static AdvertisementOuterClass$ResponseGetOnboardingSpotData parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetOnboardingSpotData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetOnboardingSpotData parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetOnboardingSpotData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetOnboardingSpotData parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementOuterClass$ResponseGetOnboardingSpotData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AdvertisementOuterClass$ResponseGetOnboardingSpotData parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetOnboardingSpotData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetOnboardingSpotData parseFrom(byte[] bArr) {
        return (AdvertisementOuterClass$ResponseGetOnboardingSpotData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementOuterClass$ResponseGetOnboardingSpotData parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetOnboardingSpotData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetOnboardingSpotData parseFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$ResponseGetOnboardingSpotData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$ResponseGetOnboardingSpotData parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetOnboardingSpotData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$ResponseGetOnboardingSpotData parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementOuterClass$ResponseGetOnboardingSpotData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementOuterClass$ResponseGetOnboardingSpotData parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementOuterClass$ResponseGetOnboardingSpotData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
