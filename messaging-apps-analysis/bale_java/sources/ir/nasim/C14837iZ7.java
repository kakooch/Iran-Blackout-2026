package ir.nasim;

import ai.bale.proto.MarketStruct$MarketCategory;
import ai.bale.proto.VitrineOuterClass$BannerSection;
import ai.bale.proto.VitrineOuterClass$PeerCategorySection;
import ai.bale.proto.VitrineOuterClass$VitrineSection;
import ir.nasim.jaryan.discover.model.DiscoverSection;

/* renamed from: ir.nasim.iZ7, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C14837iZ7 implements InterfaceC14123hO3 {
    private final BA a;
    private final C21010sz b;
    private final C15647jw c;

    public C14837iZ7(BA ba, C21010sz c21010sz, C15647jw c15647jw) {
        AbstractC13042fc3.i(ba, "peerSectionMapper");
        AbstractC13042fc3.i(c21010sz, "marketSectionMapper");
        AbstractC13042fc3.i(c15647jw, "bannerSectionMapper");
        this.a = ba;
        this.b = c21010sz;
        this.c = c15647jw;
    }

    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public DiscoverSection a(VitrineOuterClass$VitrineSection vitrineOuterClass$VitrineSection) {
        DiscoverSection discoverSection;
        AbstractC13042fc3.i(vitrineOuterClass$VitrineSection, "input");
        if (vitrineOuterClass$VitrineSection.hasPeerSection()) {
            BA ba = this.a;
            VitrineOuterClass$PeerCategorySection peerSection = vitrineOuterClass$VitrineSection.getPeerSection();
            AbstractC13042fc3.h(peerSection, "getPeerSection(...)");
            discoverSection = new DiscoverSection(ba.a(peerSection), null, null);
        } else if (vitrineOuterClass$VitrineSection.hasMarketsSection()) {
            C21010sz c21010sz = this.b;
            MarketStruct$MarketCategory marketCategory = vitrineOuterClass$VitrineSection.getMarketsSection().getMarketCategory();
            AbstractC13042fc3.h(marketCategory, "getMarketCategory(...)");
            discoverSection = new DiscoverSection(null, null, c21010sz.a(marketCategory));
        } else {
            if (!vitrineOuterClass$VitrineSection.hasBannerSection()) {
                return null;
            }
            C15647jw c15647jw = this.c;
            VitrineOuterClass$BannerSection bannerSection = vitrineOuterClass$VitrineSection.getBannerSection();
            AbstractC13042fc3.h(bannerSection, "getBannerSection(...)");
            discoverSection = new DiscoverSection(null, c15647jw.a(bannerSection), null);
        }
        return discoverSection;
    }
}
