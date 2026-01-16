package ir.nasim;

import ai.bale.proto.MarketOuterClass$ResponseSetOnboardingData;
import ir.nasim.SO3;
import java.util.ArrayList;

/* renamed from: ir.nasim.rQ3, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C20069rQ3 extends VW7 {
    public static final int c = QQ3.f;
    private final QQ3 b;

    public C20069rQ3(QQ3 qq3) {
        AbstractC13042fc3.i(qq3, "marketModule");
        this.b = qq3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T0(C20298rm4 c20298rm4, MarketOuterClass$ResponseSetOnboardingData marketOuterClass$ResponseSetOnboardingData) {
        AbstractC13042fc3.i(c20298rm4, "$liveData");
        c20298rm4.n(new C5354Iz1(marketOuterClass$ResponseSetOnboardingData));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U0(C20298rm4 c20298rm4, Exception exc) {
        AbstractC13042fc3.i(c20298rm4, "$liveData");
        c20298rm4.n(new C5354Iz1((Throwable) exc));
    }

    public androidx.lifecycle.r S0(boolean z, Integer num, ArrayList arrayList) {
        AbstractC13042fc3.i(arrayList, "categoryIds");
        final C20298rm4 c20298rm4 = new C20298rm4();
        this.b.j0(new SO3.h(z, num != null ? num.intValue() == 0 ? EnumC10336bU3.UserGender_MALE : EnumC10336bU3.UserGender_FEMALE : null, arrayList)).m0(new InterfaceC24449ye1() { // from class: ir.nasim.pQ3
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C20069rQ3.T0(c20298rm4, (MarketOuterClass$ResponseSetOnboardingData) obj);
            }
        }).E(new InterfaceC24449ye1() { // from class: ir.nasim.qQ3
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C20069rQ3.U0(c20298rm4, (Exception) obj);
            }
        });
        return c20298rm4;
    }
}
