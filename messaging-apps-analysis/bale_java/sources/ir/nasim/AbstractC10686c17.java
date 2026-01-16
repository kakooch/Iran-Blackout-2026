package ir.nasim;

import java.util.List;

/* renamed from: ir.nasim.c17, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public abstract class AbstractC10686c17 {
    private static final List a = AbstractC11342cq6.K(AbstractC11342cq6.D(AbstractC9962aq6.c(new C12093e17().a().iterator()), new InterfaceC14603iB2() { // from class: ir.nasim.b17
        @Override // ir.nasim.InterfaceC14603iB2
        public final Object invoke(Object obj, Object obj2) {
            return AbstractC10686c17.b(((Integer) obj).intValue(), (List) obj2);
        }
    }));

    /* renamed from: ir.nasim.c17$a */
    static final class a implements InterfaceC14603iB2 {
        final /* synthetic */ List a;

        a(List list) {
            this.a = list;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                AbstractC16293l17.k(this.a, interfaceC22053ub1, 0);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C15800kB6 b(int i, List list) {
        AbstractC13042fc3.i(list, "previewParam");
        return new C15800kB6("ir.nasim.onboarding.ui.screen_SuggestedServicePeersLoadedScreen_null_DefaultGroup_SuggestedServicePeersLoadedScreen_0_null_" + i, "Default Group", "SuggestedServicePeersLoadedScreen", "", AbstractC19242q11.c(1125055357, true, new a(list)), null, false, null, null, null, null, 1952, null);
    }

    public static final List c() {
        return a;
    }
}
