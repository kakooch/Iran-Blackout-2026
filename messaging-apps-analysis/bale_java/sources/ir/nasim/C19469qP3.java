package ir.nasim;

import ai.bale.proto.MarketOuterClass$ResponseGetCategories;
import ai.bale.proto.MarketOuterClass$ResponseSetOnboardingData;
import ai.bale.proto.MarketStruct$MarketCategory;
import ir.nasim.SO3;
import ir.nasim.core.modules.market.model.MarketCategory;
import ir.nasim.core.modules.market.model.MarketSection;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.qP3, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C19469qP3 extends VW7 {
    public static final int c = QQ3.f;
    private final QQ3 b;

    public C19469qP3(QQ3 qq3) {
        AbstractC13042fc3.i(qq3, "marketModule");
        this.b = qq3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V0(C20298rm4 c20298rm4, MarketOuterClass$ResponseGetCategories marketOuterClass$ResponseGetCategories) {
        AbstractC13042fc3.i(c20298rm4, "$liveData");
        ArrayList arrayList = new ArrayList();
        List<MarketStruct$MarketCategory> categoriesList = marketOuterClass$ResponseGetCategories.getCategoriesList();
        AbstractC13042fc3.h(categoriesList, "getCategoriesList(...)");
        for (MarketStruct$MarketCategory marketStruct$MarketCategory : categoriesList) {
            int id = marketStruct$MarketCategory.getId();
            String title = marketStruct$MarketCategory.getTitle();
            AbstractC13042fc3.h(title, "getTitle(...)");
            MarketSection.Companion companion = MarketSection.INSTANCE;
            String drawableId = marketStruct$MarketCategory.getDrawableId();
            AbstractC13042fc3.h(drawableId, "getDrawableId(...)");
            arrayList.add(new MarketCategory(id, title, Integer.valueOf(companion.d(drawableId)), false));
        }
        c20298rm4.n(new C5354Iz1(arrayList));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W0(C20298rm4 c20298rm4, Exception exc) {
        AbstractC13042fc3.i(c20298rm4, "$liveData");
        c20298rm4.n(new C5354Iz1((Throwable) exc));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y0(C20298rm4 c20298rm4, MarketOuterClass$ResponseSetOnboardingData marketOuterClass$ResponseSetOnboardingData) {
        AbstractC13042fc3.i(c20298rm4, "$liveData");
        c20298rm4.n(new C5354Iz1(marketOuterClass$ResponseSetOnboardingData));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z0(C20298rm4 c20298rm4, Exception exc) {
        AbstractC13042fc3.i(c20298rm4, "$liveData");
        c20298rm4.n(new C5354Iz1((Throwable) exc));
    }

    public androidx.lifecycle.r U0() {
        final C20298rm4 c20298rm4 = new C20298rm4();
        this.b.O(0, 0, this.b.N(), false).m0(new InterfaceC24449ye1() { // from class: ir.nasim.mP3
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C19469qP3.V0(c20298rm4, (MarketOuterClass$ResponseGetCategories) obj);
            }
        }).E(new InterfaceC24449ye1() { // from class: ir.nasim.nP3
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C19469qP3.W0(c20298rm4, (Exception) obj);
            }
        });
        return c20298rm4;
    }

    public androidx.lifecycle.r X0(boolean z, ArrayList arrayList) {
        final C20298rm4 c20298rm4 = new C20298rm4();
        this.b.j0(new SO3.h(z, null, arrayList)).m0(new InterfaceC24449ye1() { // from class: ir.nasim.oP3
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C19469qP3.Y0(c20298rm4, (MarketOuterClass$ResponseSetOnboardingData) obj);
            }
        }).E(new InterfaceC24449ye1() { // from class: ir.nasim.pP3
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C19469qP3.Z0(c20298rm4, (Exception) obj);
            }
        });
        return c20298rm4;
    }
}
