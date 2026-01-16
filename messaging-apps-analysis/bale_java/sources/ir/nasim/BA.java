package ir.nasim;

import ai.bale.proto.VitrineOuterClass$PeerCategorySection;
import ai.bale.proto.VitrineOuterClass$PeerItem;
import ir.nasim.jaryan.discover.model.PeerSection;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes6.dex */
public final class BA implements InterfaceC14123hO3 {
    private final C24173yA a;

    public BA(C24173yA c24173yA) {
        AbstractC13042fc3.i(c24173yA, "peerItemMapper");
        this.a = c24173yA;
    }

    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public PeerSection a(VitrineOuterClass$PeerCategorySection vitrineOuterClass$PeerCategorySection) {
        AbstractC13042fc3.i(vitrineOuterClass$PeerCategorySection, "input");
        List<VitrineOuterClass$PeerItem> itemsList = vitrineOuterClass$PeerCategorySection.getItemsList();
        AbstractC13042fc3.h(itemsList, "getItemsList(...)");
        List<VitrineOuterClass$PeerItem> list = itemsList;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
        for (VitrineOuterClass$PeerItem vitrineOuterClass$PeerItem : list) {
            C24173yA c24173yA = this.a;
            AbstractC13042fc3.f(vitrineOuterClass$PeerItem);
            arrayList.add(c24173yA.a(vitrineOuterClass$PeerItem));
        }
        String title = vitrineOuterClass$PeerCategorySection.getTitle();
        AbstractC13042fc3.h(title, "getTitle(...)");
        return new PeerSection(arrayList, title, vitrineOuterClass$PeerCategorySection.getItemsCount(), vitrineOuterClass$PeerCategorySection.getId().getValue());
    }
}
