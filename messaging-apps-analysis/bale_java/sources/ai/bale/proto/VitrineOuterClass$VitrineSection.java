package ai.bale.proto;

import ai.bale.proto.VitrineOuterClass$BannerSection;
import ai.bale.proto.VitrineOuterClass$MarketCategorySection;
import ai.bale.proto.VitrineOuterClass$PeerCategorySection;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class VitrineOuterClass$VitrineSection extends GeneratedMessageLite implements s2 {
    public static final int BANNER_SECTION_FIELD_NUMBER = 1;
    private static final VitrineOuterClass$VitrineSection DEFAULT_INSTANCE;
    public static final int MARKETS_SECTION_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int PEER_SECTION_FIELD_NUMBER = 3;
    private int traitCase_ = 0;
    private Object trait_;

    public static final class a extends GeneratedMessageLite.b implements s2 {
        private a() {
            super(VitrineOuterClass$VitrineSection.DEFAULT_INSTANCE);
        }
    }

    public enum b {
        BANNER_SECTION(1),
        MARKETS_SECTION(2),
        PEER_SECTION(3),
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
                return BANNER_SECTION;
            }
            if (i == 2) {
                return MARKETS_SECTION;
            }
            if (i != 3) {
                return null;
            }
            return PEER_SECTION;
        }
    }

    static {
        VitrineOuterClass$VitrineSection vitrineOuterClass$VitrineSection = new VitrineOuterClass$VitrineSection();
        DEFAULT_INSTANCE = vitrineOuterClass$VitrineSection;
        GeneratedMessageLite.registerDefaultInstance(VitrineOuterClass$VitrineSection.class, vitrineOuterClass$VitrineSection);
    }

    private VitrineOuterClass$VitrineSection() {
    }

    private void clearBannerSection() {
        if (this.traitCase_ == 1) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearMarketsSection() {
        if (this.traitCase_ == 2) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearPeerSection() {
        if (this.traitCase_ == 3) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearTrait() {
        this.traitCase_ = 0;
        this.trait_ = null;
    }

    public static VitrineOuterClass$VitrineSection getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeBannerSection(VitrineOuterClass$BannerSection vitrineOuterClass$BannerSection) {
        vitrineOuterClass$BannerSection.getClass();
        if (this.traitCase_ != 1 || this.trait_ == VitrineOuterClass$BannerSection.getDefaultInstance()) {
            this.trait_ = vitrineOuterClass$BannerSection;
        } else {
            this.trait_ = ((VitrineOuterClass$BannerSection.a) VitrineOuterClass$BannerSection.newBuilder((VitrineOuterClass$BannerSection) this.trait_).v(vitrineOuterClass$BannerSection)).j();
        }
        this.traitCase_ = 1;
    }

    private void mergeMarketsSection(VitrineOuterClass$MarketCategorySection vitrineOuterClass$MarketCategorySection) {
        vitrineOuterClass$MarketCategorySection.getClass();
        if (this.traitCase_ != 2 || this.trait_ == VitrineOuterClass$MarketCategorySection.getDefaultInstance()) {
            this.trait_ = vitrineOuterClass$MarketCategorySection;
        } else {
            this.trait_ = ((VitrineOuterClass$MarketCategorySection.a) VitrineOuterClass$MarketCategorySection.newBuilder((VitrineOuterClass$MarketCategorySection) this.trait_).v(vitrineOuterClass$MarketCategorySection)).j();
        }
        this.traitCase_ = 2;
    }

    private void mergePeerSection(VitrineOuterClass$PeerCategorySection vitrineOuterClass$PeerCategorySection) {
        vitrineOuterClass$PeerCategorySection.getClass();
        if (this.traitCase_ != 3 || this.trait_ == VitrineOuterClass$PeerCategorySection.getDefaultInstance()) {
            this.trait_ = vitrineOuterClass$PeerCategorySection;
        } else {
            this.trait_ = ((VitrineOuterClass$PeerCategorySection.a) VitrineOuterClass$PeerCategorySection.newBuilder((VitrineOuterClass$PeerCategorySection) this.trait_).v(vitrineOuterClass$PeerCategorySection)).j();
        }
        this.traitCase_ = 3;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static VitrineOuterClass$VitrineSection parseDelimitedFrom(InputStream inputStream) {
        return (VitrineOuterClass$VitrineSection) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static VitrineOuterClass$VitrineSection parseFrom(ByteBuffer byteBuffer) {
        return (VitrineOuterClass$VitrineSection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setBannerSection(VitrineOuterClass$BannerSection vitrineOuterClass$BannerSection) {
        vitrineOuterClass$BannerSection.getClass();
        this.trait_ = vitrineOuterClass$BannerSection;
        this.traitCase_ = 1;
    }

    private void setMarketsSection(VitrineOuterClass$MarketCategorySection vitrineOuterClass$MarketCategorySection) {
        vitrineOuterClass$MarketCategorySection.getClass();
        this.trait_ = vitrineOuterClass$MarketCategorySection;
        this.traitCase_ = 2;
    }

    private void setPeerSection(VitrineOuterClass$PeerCategorySection vitrineOuterClass$PeerCategorySection) {
        vitrineOuterClass$PeerCategorySection.getClass();
        this.trait_ = vitrineOuterClass$PeerCategorySection;
        this.traitCase_ = 3;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (r2.a[gVar.ordinal()]) {
            case 1:
                return new VitrineOuterClass$VitrineSection();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0001\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001<\u0000\u0002<\u0000\u0003<\u0000", new Object[]{"trait_", "traitCase_", VitrineOuterClass$BannerSection.class, VitrineOuterClass$MarketCategorySection.class, VitrineOuterClass$PeerCategorySection.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (VitrineOuterClass$VitrineSection.class) {
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

    public VitrineOuterClass$BannerSection getBannerSection() {
        return this.traitCase_ == 1 ? (VitrineOuterClass$BannerSection) this.trait_ : VitrineOuterClass$BannerSection.getDefaultInstance();
    }

    public VitrineOuterClass$MarketCategorySection getMarketsSection() {
        return this.traitCase_ == 2 ? (VitrineOuterClass$MarketCategorySection) this.trait_ : VitrineOuterClass$MarketCategorySection.getDefaultInstance();
    }

    public VitrineOuterClass$PeerCategorySection getPeerSection() {
        return this.traitCase_ == 3 ? (VitrineOuterClass$PeerCategorySection) this.trait_ : VitrineOuterClass$PeerCategorySection.getDefaultInstance();
    }

    public b getTraitCase() {
        return b.j(this.traitCase_);
    }

    public boolean hasBannerSection() {
        return this.traitCase_ == 1;
    }

    public boolean hasMarketsSection() {
        return this.traitCase_ == 2;
    }

    public boolean hasPeerSection() {
        return this.traitCase_ == 3;
    }

    public static a newBuilder(VitrineOuterClass$VitrineSection vitrineOuterClass$VitrineSection) {
        return (a) DEFAULT_INSTANCE.createBuilder(vitrineOuterClass$VitrineSection);
    }

    public static VitrineOuterClass$VitrineSection parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (VitrineOuterClass$VitrineSection) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static VitrineOuterClass$VitrineSection parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (VitrineOuterClass$VitrineSection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static VitrineOuterClass$VitrineSection parseFrom(AbstractC2383g abstractC2383g) {
        return (VitrineOuterClass$VitrineSection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static VitrineOuterClass$VitrineSection parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (VitrineOuterClass$VitrineSection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static VitrineOuterClass$VitrineSection parseFrom(byte[] bArr) {
        return (VitrineOuterClass$VitrineSection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static VitrineOuterClass$VitrineSection parseFrom(byte[] bArr, C2394s c2394s) {
        return (VitrineOuterClass$VitrineSection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static VitrineOuterClass$VitrineSection parseFrom(InputStream inputStream) {
        return (VitrineOuterClass$VitrineSection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static VitrineOuterClass$VitrineSection parseFrom(InputStream inputStream, C2394s c2394s) {
        return (VitrineOuterClass$VitrineSection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static VitrineOuterClass$VitrineSection parseFrom(AbstractC2384h abstractC2384h) {
        return (VitrineOuterClass$VitrineSection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static VitrineOuterClass$VitrineSection parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (VitrineOuterClass$VitrineSection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
