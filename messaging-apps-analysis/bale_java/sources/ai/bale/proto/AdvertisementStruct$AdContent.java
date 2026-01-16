package ai.bale.proto;

import ai.bale.proto.AdvertisementStruct$BaleAd;
import ai.bale.proto.AdvertisementStruct$BaleChannelAd;
import ai.bale.proto.AdvertisementStruct$BaleCustomAd;
import ai.bale.proto.AdvertisementStruct$BaleSponsoredMessageAd;
import ai.bale.proto.AdvertisementStruct$BaleUnderPeerAd;
import ai.bale.proto.AdvertisementStruct$NoAd;
import ai.bale.proto.AdvertisementStruct$TapsellAd;
import ai.bale.proto.AdvertisementStruct$YektanetAd;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes8.dex */
public final class AdvertisementStruct$AdContent extends GeneratedMessageLite implements InterfaceC1846d {
    public static final int BALE_AD_FIELD_NUMBER = 3;
    public static final int BALE_CHANNEL_AD_FIELD_NUMBER = 6;
    public static final int BALE_CUSTOM_AD_FIELD_NUMBER = 5;
    public static final int BALE_SPONSORED_MESSAGE_AD_FIELD_NUMBER = 7;
    public static final int BALE_UNDER_PEER_AD_FIELD_NUMBER = 8;
    private static final AdvertisementStruct$AdContent DEFAULT_INSTANCE;
    public static final int NO_AD_FIELD_NUMBER = 4;
    private static volatile KW4 PARSER = null;
    public static final int TAPSELL_AD_FIELD_NUMBER = 2;
    public static final int YEKTANET_AD_FIELD_NUMBER = 1;
    private int traitCase_ = 0;
    private Object trait_;

    public static final class a extends GeneratedMessageLite.b implements InterfaceC1846d {
        private a() {
            super(AdvertisementStruct$AdContent.DEFAULT_INSTANCE);
        }
    }

    public enum b {
        YEKTANET_AD(1),
        TAPSELL_AD(2),
        BALE_AD(3),
        NO_AD(4),
        BALE_CUSTOM_AD(5),
        BALE_CHANNEL_AD(6),
        BALE_SPONSORED_MESSAGE_AD(7),
        BALE_UNDER_PEER_AD(8),
        TRAIT_NOT_SET(0);

        private final int a;

        b(int i) {
            this.a = i;
        }

        public static b j(int i) {
            switch (i) {
                case 0:
                    return TRAIT_NOT_SET;
                case 1:
                    return YEKTANET_AD;
                case 2:
                    return TAPSELL_AD;
                case 3:
                    return BALE_AD;
                case 4:
                    return NO_AD;
                case 5:
                    return BALE_CUSTOM_AD;
                case 6:
                    return BALE_CHANNEL_AD;
                case 7:
                    return BALE_SPONSORED_MESSAGE_AD;
                case 8:
                    return BALE_UNDER_PEER_AD;
                default:
                    return null;
            }
        }
    }

    static {
        AdvertisementStruct$AdContent advertisementStruct$AdContent = new AdvertisementStruct$AdContent();
        DEFAULT_INSTANCE = advertisementStruct$AdContent;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementStruct$AdContent.class, advertisementStruct$AdContent);
    }

    private AdvertisementStruct$AdContent() {
    }

    private void clearBaleAd() {
        if (this.traitCase_ == 3) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearBaleChannelAd() {
        if (this.traitCase_ == 6) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearBaleCustomAd() {
        if (this.traitCase_ == 5) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearBaleSponsoredMessageAd() {
        if (this.traitCase_ == 7) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearBaleUnderPeerAd() {
        if (this.traitCase_ == 8) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearNoAd() {
        if (this.traitCase_ == 4) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearTapsellAd() {
        if (this.traitCase_ == 2) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearTrait() {
        this.traitCase_ = 0;
        this.trait_ = null;
    }

    private void clearYektanetAd() {
        if (this.traitCase_ == 1) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    public static AdvertisementStruct$AdContent getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeBaleAd(AdvertisementStruct$BaleAd advertisementStruct$BaleAd) {
        advertisementStruct$BaleAd.getClass();
        if (this.traitCase_ != 3 || this.trait_ == AdvertisementStruct$BaleAd.getDefaultInstance()) {
            this.trait_ = advertisementStruct$BaleAd;
        } else {
            this.trait_ = ((AdvertisementStruct$BaleAd.a) AdvertisementStruct$BaleAd.newBuilder((AdvertisementStruct$BaleAd) this.trait_).v(advertisementStruct$BaleAd)).j();
        }
        this.traitCase_ = 3;
    }

    private void mergeBaleChannelAd(AdvertisementStruct$BaleChannelAd advertisementStruct$BaleChannelAd) {
        advertisementStruct$BaleChannelAd.getClass();
        if (this.traitCase_ != 6 || this.trait_ == AdvertisementStruct$BaleChannelAd.getDefaultInstance()) {
            this.trait_ = advertisementStruct$BaleChannelAd;
        } else {
            this.trait_ = ((AdvertisementStruct$BaleChannelAd.a) AdvertisementStruct$BaleChannelAd.newBuilder((AdvertisementStruct$BaleChannelAd) this.trait_).v(advertisementStruct$BaleChannelAd)).j();
        }
        this.traitCase_ = 6;
    }

    private void mergeBaleCustomAd(AdvertisementStruct$BaleCustomAd advertisementStruct$BaleCustomAd) {
        advertisementStruct$BaleCustomAd.getClass();
        if (this.traitCase_ != 5 || this.trait_ == AdvertisementStruct$BaleCustomAd.getDefaultInstance()) {
            this.trait_ = advertisementStruct$BaleCustomAd;
        } else {
            this.trait_ = ((AdvertisementStruct$BaleCustomAd.a) AdvertisementStruct$BaleCustomAd.newBuilder((AdvertisementStruct$BaleCustomAd) this.trait_).v(advertisementStruct$BaleCustomAd)).j();
        }
        this.traitCase_ = 5;
    }

    private void mergeBaleSponsoredMessageAd(AdvertisementStruct$BaleSponsoredMessageAd advertisementStruct$BaleSponsoredMessageAd) {
        advertisementStruct$BaleSponsoredMessageAd.getClass();
        if (this.traitCase_ != 7 || this.trait_ == AdvertisementStruct$BaleSponsoredMessageAd.getDefaultInstance()) {
            this.trait_ = advertisementStruct$BaleSponsoredMessageAd;
        } else {
            this.trait_ = ((AdvertisementStruct$BaleSponsoredMessageAd.a) AdvertisementStruct$BaleSponsoredMessageAd.newBuilder((AdvertisementStruct$BaleSponsoredMessageAd) this.trait_).v(advertisementStruct$BaleSponsoredMessageAd)).j();
        }
        this.traitCase_ = 7;
    }

    private void mergeBaleUnderPeerAd(AdvertisementStruct$BaleUnderPeerAd advertisementStruct$BaleUnderPeerAd) {
        advertisementStruct$BaleUnderPeerAd.getClass();
        if (this.traitCase_ != 8 || this.trait_ == AdvertisementStruct$BaleUnderPeerAd.getDefaultInstance()) {
            this.trait_ = advertisementStruct$BaleUnderPeerAd;
        } else {
            this.trait_ = ((AdvertisementStruct$BaleUnderPeerAd.a) AdvertisementStruct$BaleUnderPeerAd.newBuilder((AdvertisementStruct$BaleUnderPeerAd) this.trait_).v(advertisementStruct$BaleUnderPeerAd)).j();
        }
        this.traitCase_ = 8;
    }

    private void mergeNoAd(AdvertisementStruct$NoAd advertisementStruct$NoAd) {
        advertisementStruct$NoAd.getClass();
        if (this.traitCase_ != 4 || this.trait_ == AdvertisementStruct$NoAd.getDefaultInstance()) {
            this.trait_ = advertisementStruct$NoAd;
        } else {
            this.trait_ = ((AdvertisementStruct$NoAd.a) AdvertisementStruct$NoAd.newBuilder((AdvertisementStruct$NoAd) this.trait_).v(advertisementStruct$NoAd)).j();
        }
        this.traitCase_ = 4;
    }

    private void mergeTapsellAd(AdvertisementStruct$TapsellAd advertisementStruct$TapsellAd) {
        advertisementStruct$TapsellAd.getClass();
        if (this.traitCase_ != 2 || this.trait_ == AdvertisementStruct$TapsellAd.getDefaultInstance()) {
            this.trait_ = advertisementStruct$TapsellAd;
        } else {
            this.trait_ = ((AdvertisementStruct$TapsellAd.a) AdvertisementStruct$TapsellAd.newBuilder((AdvertisementStruct$TapsellAd) this.trait_).v(advertisementStruct$TapsellAd)).j();
        }
        this.traitCase_ = 2;
    }

    private void mergeYektanetAd(AdvertisementStruct$YektanetAd advertisementStruct$YektanetAd) {
        advertisementStruct$YektanetAd.getClass();
        if (this.traitCase_ != 1 || this.trait_ == AdvertisementStruct$YektanetAd.getDefaultInstance()) {
            this.trait_ = advertisementStruct$YektanetAd;
        } else {
            this.trait_ = ((AdvertisementStruct$YektanetAd.a) AdvertisementStruct$YektanetAd.newBuilder((AdvertisementStruct$YektanetAd) this.trait_).v(advertisementStruct$YektanetAd)).j();
        }
        this.traitCase_ = 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AdvertisementStruct$AdContent parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementStruct$AdContent) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementStruct$AdContent parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementStruct$AdContent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setBaleAd(AdvertisementStruct$BaleAd advertisementStruct$BaleAd) {
        advertisementStruct$BaleAd.getClass();
        this.trait_ = advertisementStruct$BaleAd;
        this.traitCase_ = 3;
    }

    private void setBaleChannelAd(AdvertisementStruct$BaleChannelAd advertisementStruct$BaleChannelAd) {
        advertisementStruct$BaleChannelAd.getClass();
        this.trait_ = advertisementStruct$BaleChannelAd;
        this.traitCase_ = 6;
    }

    private void setBaleCustomAd(AdvertisementStruct$BaleCustomAd advertisementStruct$BaleCustomAd) {
        advertisementStruct$BaleCustomAd.getClass();
        this.trait_ = advertisementStruct$BaleCustomAd;
        this.traitCase_ = 5;
    }

    private void setBaleSponsoredMessageAd(AdvertisementStruct$BaleSponsoredMessageAd advertisementStruct$BaleSponsoredMessageAd) {
        advertisementStruct$BaleSponsoredMessageAd.getClass();
        this.trait_ = advertisementStruct$BaleSponsoredMessageAd;
        this.traitCase_ = 7;
    }

    private void setBaleUnderPeerAd(AdvertisementStruct$BaleUnderPeerAd advertisementStruct$BaleUnderPeerAd) {
        advertisementStruct$BaleUnderPeerAd.getClass();
        this.trait_ = advertisementStruct$BaleUnderPeerAd;
        this.traitCase_ = 8;
    }

    private void setNoAd(AdvertisementStruct$NoAd advertisementStruct$NoAd) {
        advertisementStruct$NoAd.getClass();
        this.trait_ = advertisementStruct$NoAd;
        this.traitCase_ = 4;
    }

    private void setTapsellAd(AdvertisementStruct$TapsellAd advertisementStruct$TapsellAd) {
        advertisementStruct$TapsellAd.getClass();
        this.trait_ = advertisementStruct$TapsellAd;
        this.traitCase_ = 2;
    }

    private void setYektanetAd(AdvertisementStruct$YektanetAd advertisementStruct$YektanetAd) {
        advertisementStruct$YektanetAd.getClass();
        this.trait_ = advertisementStruct$YektanetAd;
        this.traitCase_ = 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1843c.a[gVar.ordinal()]) {
            case 1:
                return new AdvertisementStruct$AdContent();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\b\u0001\u0000\u0001\b\b\u0000\u0000\u0000\u0001<\u0000\u0002<\u0000\u0003<\u0000\u0004<\u0000\u0005<\u0000\u0006<\u0000\u0007<\u0000\b<\u0000", new Object[]{"trait_", "traitCase_", AdvertisementStruct$YektanetAd.class, AdvertisementStruct$TapsellAd.class, AdvertisementStruct$BaleAd.class, AdvertisementStruct$NoAd.class, AdvertisementStruct$BaleCustomAd.class, AdvertisementStruct$BaleChannelAd.class, AdvertisementStruct$BaleSponsoredMessageAd.class, AdvertisementStruct$BaleUnderPeerAd.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementStruct$AdContent.class) {
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

    public AdvertisementStruct$BaleAd getBaleAd() {
        return this.traitCase_ == 3 ? (AdvertisementStruct$BaleAd) this.trait_ : AdvertisementStruct$BaleAd.getDefaultInstance();
    }

    public AdvertisementStruct$BaleChannelAd getBaleChannelAd() {
        return this.traitCase_ == 6 ? (AdvertisementStruct$BaleChannelAd) this.trait_ : AdvertisementStruct$BaleChannelAd.getDefaultInstance();
    }

    public AdvertisementStruct$BaleCustomAd getBaleCustomAd() {
        return this.traitCase_ == 5 ? (AdvertisementStruct$BaleCustomAd) this.trait_ : AdvertisementStruct$BaleCustomAd.getDefaultInstance();
    }

    public AdvertisementStruct$BaleSponsoredMessageAd getBaleSponsoredMessageAd() {
        return this.traitCase_ == 7 ? (AdvertisementStruct$BaleSponsoredMessageAd) this.trait_ : AdvertisementStruct$BaleSponsoredMessageAd.getDefaultInstance();
    }

    public AdvertisementStruct$BaleUnderPeerAd getBaleUnderPeerAd() {
        return this.traitCase_ == 8 ? (AdvertisementStruct$BaleUnderPeerAd) this.trait_ : AdvertisementStruct$BaleUnderPeerAd.getDefaultInstance();
    }

    public AdvertisementStruct$NoAd getNoAd() {
        return this.traitCase_ == 4 ? (AdvertisementStruct$NoAd) this.trait_ : AdvertisementStruct$NoAd.getDefaultInstance();
    }

    public AdvertisementStruct$TapsellAd getTapsellAd() {
        return this.traitCase_ == 2 ? (AdvertisementStruct$TapsellAd) this.trait_ : AdvertisementStruct$TapsellAd.getDefaultInstance();
    }

    public b getTraitCase() {
        return b.j(this.traitCase_);
    }

    public AdvertisementStruct$YektanetAd getYektanetAd() {
        return this.traitCase_ == 1 ? (AdvertisementStruct$YektanetAd) this.trait_ : AdvertisementStruct$YektanetAd.getDefaultInstance();
    }

    public boolean hasBaleAd() {
        return this.traitCase_ == 3;
    }

    public boolean hasBaleChannelAd() {
        return this.traitCase_ == 6;
    }

    public boolean hasBaleCustomAd() {
        return this.traitCase_ == 5;
    }

    public boolean hasBaleSponsoredMessageAd() {
        return this.traitCase_ == 7;
    }

    public boolean hasBaleUnderPeerAd() {
        return this.traitCase_ == 8;
    }

    public boolean hasNoAd() {
        return this.traitCase_ == 4;
    }

    public boolean hasTapsellAd() {
        return this.traitCase_ == 2;
    }

    public boolean hasYektanetAd() {
        return this.traitCase_ == 1;
    }

    public static a newBuilder(AdvertisementStruct$AdContent advertisementStruct$AdContent) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementStruct$AdContent);
    }

    public static AdvertisementStruct$AdContent parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementStruct$AdContent) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementStruct$AdContent parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementStruct$AdContent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementStruct$AdContent parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementStruct$AdContent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AdvertisementStruct$AdContent parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementStruct$AdContent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementStruct$AdContent parseFrom(byte[] bArr) {
        return (AdvertisementStruct$AdContent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementStruct$AdContent parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementStruct$AdContent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AdvertisementStruct$AdContent parseFrom(InputStream inputStream) {
        return (AdvertisementStruct$AdContent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementStruct$AdContent parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementStruct$AdContent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementStruct$AdContent parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementStruct$AdContent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementStruct$AdContent parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementStruct$AdContent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
