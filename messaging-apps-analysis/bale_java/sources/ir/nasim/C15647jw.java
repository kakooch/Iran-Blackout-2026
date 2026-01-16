package ir.nasim;

import ai.bale.proto.VitrineOuterClass$BannerItem;
import ai.bale.proto.VitrineOuterClass$BannerSection;
import ir.nasim.jaryan.discover.model.BannerSection;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.jw, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C15647jw implements InterfaceC14123hO3 {
    private final C15056iw a;

    public C15647jw(C15056iw c15056iw) {
        AbstractC13042fc3.i(c15056iw, "bannerItemMapper");
        this.a = c15056iw;
    }

    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public BannerSection a(VitrineOuterClass$BannerSection vitrineOuterClass$BannerSection) {
        AbstractC13042fc3.i(vitrineOuterClass$BannerSection, "input");
        List<VitrineOuterClass$BannerItem> itemsList = vitrineOuterClass$BannerSection.getItemsList();
        AbstractC13042fc3.h(itemsList, "getItemsList(...)");
        List<VitrineOuterClass$BannerItem> list = itemsList;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
        for (VitrineOuterClass$BannerItem vitrineOuterClass$BannerItem : list) {
            C15056iw c15056iw = this.a;
            AbstractC13042fc3.f(vitrineOuterClass$BannerItem);
            arrayList.add(c15056iw.a(vitrineOuterClass$BannerItem));
        }
        return new BannerSection(arrayList, vitrineOuterClass$BannerSection.getId().getValue());
    }
}
