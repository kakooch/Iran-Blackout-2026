package ir.nasim;

import ai.bale.proto.AdvertisementStruct$BaleCustomAd;
import ir.nasim.AbstractC16345l7;
import ir.nasim.core.modules.file.entity.FileReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.Ob, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C6565Ob implements SB3 {
    private final AbstractC16345l7.a b(AdvertisementStruct$BaleCustomAd advertisementStruct$BaleCustomAd) {
        C12056dy c12056dy = new C12056dy(advertisementStruct$BaleCustomAd.getImageLocation().getFileLocation().getFileId(), advertisementStruct$BaleCustomAd.getImageLocation().getFileLocation().getAccessHash(), Integer.valueOf(advertisementStruct$BaleCustomAd.getImageLocation().getFileLocation().getFileStorageVersion().getValue()));
        String title = advertisementStruct$BaleCustomAd.getTitle();
        AbstractC13042fc3.h(title, "getTitle(...)");
        FileReference fileReference = new FileReference(c12056dy, title, advertisementStruct$BaleCustomAd.getDescription(), advertisementStruct$BaleCustomAd.getImageLocation().getFileSize());
        String title2 = advertisementStruct$BaleCustomAd.getTitle();
        AbstractC13042fc3.h(title2, "getTitle(...)");
        String description = advertisementStruct$BaleCustomAd.getDescription();
        AbstractC13042fc3.h(description, "getDescription(...)");
        String link = advertisementStruct$BaleCustomAd.getLink();
        AbstractC13042fc3.h(link, "getLink(...)");
        String id = advertisementStruct$BaleCustomAd.getId();
        AbstractC13042fc3.h(id, "getId(...)");
        long accessHash = advertisementStruct$BaleCustomAd.getAccessHash();
        int tag1 = advertisementStruct$BaleCustomAd.getTag1();
        int tag2 = advertisementStruct$BaleCustomAd.getTag2();
        String linkTitle = advertisementStruct$BaleCustomAd.getLinkTitle();
        AbstractC13042fc3.h(linkTitle, "getLinkTitle(...)");
        return new AbstractC16345l7.a(fileReference, null, title2, description, link, id, accessHash, tag1, tag2, linkTitle, null, 1024, null);
    }

    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public List a(List list) {
        AbstractC13042fc3.i(list, "input");
        List list2 = list;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list2, 10));
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(b((AdvertisementStruct$BaleCustomAd) it.next()));
        }
        return arrayList;
    }
}
