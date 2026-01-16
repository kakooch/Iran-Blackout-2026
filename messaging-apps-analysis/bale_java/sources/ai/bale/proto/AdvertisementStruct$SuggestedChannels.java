package ai.bale.proto;

import ai.bale.proto.CollectionsStruct$StringValue;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC12469eg;
import ir.nasim.EnumC13105fg;
import ir.nasim.InterfaceC21521th;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class AdvertisementStruct$SuggestedChannels extends GeneratedMessageLite implements U64 {
    public static final int BANNER_URL_FIELD_NUMBER = 2;
    private static final AdvertisementStruct$SuggestedChannels DEFAULT_INSTANCE;
    public static final int DESCRIPTION_FIELD_NUMBER = 4;
    public static final int DIALOG_IMAGE_POSITION_FIELD_NUMBER = 5;
    public static final int IMAGE_COVER_FIELD_NUMBER = 6;
    public static final int INNER_BANNER_TITLE_FIELD_NUMBER = 8;
    public static final int INNER_BANNER_URL_FIELD_NUMBER = 7;
    private static volatile KW4 PARSER = null;
    public static final int PEERS_FIELD_NUMBER = 1;
    public static final int TITLE_FIELD_NUMBER = 3;
    private int bitField0_;
    private CollectionsStruct$StringValue description_;
    private int dialogImagePosition_;
    private int imageCover_;
    private CollectionsStruct$StringValue title_;
    private B.j peers_ = GeneratedMessageLite.emptyProtobufList();
    private String bannerUrl_ = "";
    private String innerBannerUrl_ = "";
    private String innerBannerTitle_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(AdvertisementStruct$SuggestedChannels.DEFAULT_INSTANCE);
        }
    }

    static {
        AdvertisementStruct$SuggestedChannels advertisementStruct$SuggestedChannels = new AdvertisementStruct$SuggestedChannels();
        DEFAULT_INSTANCE = advertisementStruct$SuggestedChannels;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementStruct$SuggestedChannels.class, advertisementStruct$SuggestedChannels);
    }

    private AdvertisementStruct$SuggestedChannels() {
    }

    private void addAllPeers(Iterable<? extends AdvertisementStruct$OnboardingPeers> iterable) {
        ensurePeersIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.peers_);
    }

    private void addPeers(AdvertisementStruct$OnboardingPeers advertisementStruct$OnboardingPeers) {
        advertisementStruct$OnboardingPeers.getClass();
        ensurePeersIsMutable();
        this.peers_.add(advertisementStruct$OnboardingPeers);
    }

    private void clearBannerUrl() {
        this.bannerUrl_ = getDefaultInstance().getBannerUrl();
    }

    private void clearDescription() {
        this.description_ = null;
        this.bitField0_ &= -3;
    }

    private void clearDialogImagePosition() {
        this.dialogImagePosition_ = 0;
    }

    private void clearImageCover() {
        this.imageCover_ = 0;
    }

    private void clearInnerBannerTitle() {
        this.innerBannerTitle_ = getDefaultInstance().getInnerBannerTitle();
    }

    private void clearInnerBannerUrl() {
        this.innerBannerUrl_ = getDefaultInstance().getInnerBannerUrl();
    }

    private void clearPeers() {
        this.peers_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearTitle() {
        this.title_ = null;
        this.bitField0_ &= -2;
    }

    private void ensurePeersIsMutable() {
        B.j jVar = this.peers_;
        if (jVar.u()) {
            return;
        }
        this.peers_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static AdvertisementStruct$SuggestedChannels getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeDescription(CollectionsStruct$StringValue collectionsStruct$StringValue) {
        collectionsStruct$StringValue.getClass();
        CollectionsStruct$StringValue collectionsStruct$StringValue2 = this.description_;
        if (collectionsStruct$StringValue2 == null || collectionsStruct$StringValue2 == CollectionsStruct$StringValue.getDefaultInstance()) {
            this.description_ = collectionsStruct$StringValue;
        } else {
            this.description_ = (CollectionsStruct$StringValue) ((CollectionsStruct$StringValue.a) CollectionsStruct$StringValue.newBuilder(this.description_).v(collectionsStruct$StringValue)).j();
        }
        this.bitField0_ |= 2;
    }

    private void mergeTitle(CollectionsStruct$StringValue collectionsStruct$StringValue) {
        collectionsStruct$StringValue.getClass();
        CollectionsStruct$StringValue collectionsStruct$StringValue2 = this.title_;
        if (collectionsStruct$StringValue2 == null || collectionsStruct$StringValue2 == CollectionsStruct$StringValue.getDefaultInstance()) {
            this.title_ = collectionsStruct$StringValue;
        } else {
            this.title_ = (CollectionsStruct$StringValue) ((CollectionsStruct$StringValue.a) CollectionsStruct$StringValue.newBuilder(this.title_).v(collectionsStruct$StringValue)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AdvertisementStruct$SuggestedChannels parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementStruct$SuggestedChannels) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementStruct$SuggestedChannels parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementStruct$SuggestedChannels) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removePeers(int i) {
        ensurePeersIsMutable();
        this.peers_.remove(i);
    }

    private void setBannerUrl(String str) {
        str.getClass();
        this.bannerUrl_ = str;
    }

    private void setBannerUrlBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.bannerUrl_ = abstractC2383g.f0();
    }

    private void setDescription(CollectionsStruct$StringValue collectionsStruct$StringValue) {
        collectionsStruct$StringValue.getClass();
        this.description_ = collectionsStruct$StringValue;
        this.bitField0_ |= 2;
    }

    private void setDialogImagePosition(EnumC13105fg enumC13105fg) {
        this.dialogImagePosition_ = enumC13105fg.getNumber();
    }

    private void setDialogImagePositionValue(int i) {
        this.dialogImagePosition_ = i;
    }

    private void setImageCover(EnumC12469eg enumC12469eg) {
        this.imageCover_ = enumC12469eg.getNumber();
    }

    private void setImageCoverValue(int i) {
        this.imageCover_ = i;
    }

    private void setInnerBannerTitle(String str) {
        str.getClass();
        this.innerBannerTitle_ = str;
    }

    private void setInnerBannerTitleBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.innerBannerTitle_ = abstractC2383g.f0();
    }

    private void setInnerBannerUrl(String str) {
        str.getClass();
        this.innerBannerUrl_ = str;
    }

    private void setInnerBannerUrlBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.innerBannerUrl_ = abstractC2383g.f0();
    }

    private void setPeers(int i, AdvertisementStruct$OnboardingPeers advertisementStruct$OnboardingPeers) {
        advertisementStruct$OnboardingPeers.getClass();
        ensurePeersIsMutable();
        this.peers_.set(i, advertisementStruct$OnboardingPeers);
    }

    private void setTitle(CollectionsStruct$StringValue collectionsStruct$StringValue) {
        collectionsStruct$StringValue.getClass();
        this.title_ = collectionsStruct$StringValue;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1843c.a[gVar.ordinal()]) {
            case 1:
                return new AdvertisementStruct$SuggestedChannels();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\b\u0000\u0001\u0001\b\b\u0000\u0001\u0000\u0001\u001b\u0002Ȉ\u0003ဉ\u0000\u0004ဉ\u0001\u0005\f\u0006\f\u0007Ȉ\bȈ", new Object[]{"bitField0_", "peers_", AdvertisementStruct$OnboardingPeers.class, "bannerUrl_", "title_", "description_", "dialogImagePosition_", "imageCover_", "innerBannerUrl_", "innerBannerTitle_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementStruct$SuggestedChannels.class) {
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

    public String getBannerUrl() {
        return this.bannerUrl_;
    }

    public AbstractC2383g getBannerUrlBytes() {
        return AbstractC2383g.N(this.bannerUrl_);
    }

    public CollectionsStruct$StringValue getDescription() {
        CollectionsStruct$StringValue collectionsStruct$StringValue = this.description_;
        return collectionsStruct$StringValue == null ? CollectionsStruct$StringValue.getDefaultInstance() : collectionsStruct$StringValue;
    }

    public EnumC13105fg getDialogImagePosition() {
        EnumC13105fg enumC13105fgJ = EnumC13105fg.j(this.dialogImagePosition_);
        return enumC13105fgJ == null ? EnumC13105fg.UNRECOGNIZED : enumC13105fgJ;
    }

    public int getDialogImagePositionValue() {
        return this.dialogImagePosition_;
    }

    public EnumC12469eg getImageCover() {
        EnumC12469eg enumC12469egJ = EnumC12469eg.j(this.imageCover_);
        return enumC12469egJ == null ? EnumC12469eg.UNRECOGNIZED : enumC12469egJ;
    }

    public int getImageCoverValue() {
        return this.imageCover_;
    }

    public String getInnerBannerTitle() {
        return this.innerBannerTitle_;
    }

    public AbstractC2383g getInnerBannerTitleBytes() {
        return AbstractC2383g.N(this.innerBannerTitle_);
    }

    public String getInnerBannerUrl() {
        return this.innerBannerUrl_;
    }

    public AbstractC2383g getInnerBannerUrlBytes() {
        return AbstractC2383g.N(this.innerBannerUrl_);
    }

    public AdvertisementStruct$OnboardingPeers getPeers(int i) {
        return (AdvertisementStruct$OnboardingPeers) this.peers_.get(i);
    }

    public int getPeersCount() {
        return this.peers_.size();
    }

    public List<AdvertisementStruct$OnboardingPeers> getPeersList() {
        return this.peers_;
    }

    public InterfaceC21521th getPeersOrBuilder(int i) {
        return (InterfaceC21521th) this.peers_.get(i);
    }

    public List<? extends InterfaceC21521th> getPeersOrBuilderList() {
        return this.peers_;
    }

    public CollectionsStruct$StringValue getTitle() {
        CollectionsStruct$StringValue collectionsStruct$StringValue = this.title_;
        return collectionsStruct$StringValue == null ? CollectionsStruct$StringValue.getDefaultInstance() : collectionsStruct$StringValue;
    }

    public boolean hasDescription() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasTitle() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(AdvertisementStruct$SuggestedChannels advertisementStruct$SuggestedChannels) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementStruct$SuggestedChannels);
    }

    public static AdvertisementStruct$SuggestedChannels parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementStruct$SuggestedChannels) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementStruct$SuggestedChannels parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementStruct$SuggestedChannels) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementStruct$SuggestedChannels parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementStruct$SuggestedChannels) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addPeers(int i, AdvertisementStruct$OnboardingPeers advertisementStruct$OnboardingPeers) {
        advertisementStruct$OnboardingPeers.getClass();
        ensurePeersIsMutable();
        this.peers_.add(i, advertisementStruct$OnboardingPeers);
    }

    public static AdvertisementStruct$SuggestedChannels parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementStruct$SuggestedChannels) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementStruct$SuggestedChannels parseFrom(byte[] bArr) {
        return (AdvertisementStruct$SuggestedChannels) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementStruct$SuggestedChannels parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementStruct$SuggestedChannels) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AdvertisementStruct$SuggestedChannels parseFrom(InputStream inputStream) {
        return (AdvertisementStruct$SuggestedChannels) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementStruct$SuggestedChannels parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementStruct$SuggestedChannels) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementStruct$SuggestedChannels parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementStruct$SuggestedChannels) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementStruct$SuggestedChannels parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementStruct$SuggestedChannels) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
