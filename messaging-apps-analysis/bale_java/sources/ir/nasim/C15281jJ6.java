package ir.nasim;

import ai.bale.proto.AdvertisementStruct$BaleSponsoredMessageAd;
import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.jJ6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C15281jJ6 implements InterfaceC14123hO3 {
    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C14683iJ6 a(AdvertisementStruct$BaleSponsoredMessageAd advertisementStruct$BaleSponsoredMessageAd) {
        AbstractC13042fc3.i(advertisementStruct$BaleSponsoredMessageAd, "input");
        String caption = advertisementStruct$BaleSponsoredMessageAd.getCaption();
        String link = advertisementStruct$BaleSponsoredMessageAd.getLink();
        if (link != null && link.length() != 0) {
            caption = caption + Separators.RETURN;
        }
        String str = caption;
        String id = advertisementStruct$BaleSponsoredMessageAd.getId();
        AbstractC13042fc3.h(id, "getId(...)");
        int tag1 = advertisementStruct$BaleSponsoredMessageAd.getTag1();
        int tag2 = advertisementStruct$BaleSponsoredMessageAd.getTag2();
        AbstractC13042fc3.f(str);
        return new C14683iJ6(id, tag1, tag2, str, C18732p92.o0(advertisementStruct$BaleSponsoredMessageAd.getImageLocation()), advertisementStruct$BaleSponsoredMessageAd.getLink(), advertisementStruct$BaleSponsoredMessageAd.getLinkTitle());
    }
}
