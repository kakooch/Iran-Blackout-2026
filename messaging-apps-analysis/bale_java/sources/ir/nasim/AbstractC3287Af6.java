package ir.nasim;

import java.util.List;

/* renamed from: ir.nasim.Af6, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC3287Af6 {
    private static final List a = AbstractC11342cq6.K(AbstractC11342cq6.D(AbstractC9962aq6.c(new C3296Ag6().a().iterator()), new InterfaceC14603iB2() { // from class: ir.nasim.zf6
        @Override // ir.nasim.InterfaceC14603iB2
        public final Object invoke(Object obj, Object obj2) {
            return AbstractC3287Af6.b(((Integer) obj).intValue(), (C25068zg6) obj2);
        }
    }));

    /* renamed from: ir.nasim.Af6$a */
    static final class a implements InterfaceC14603iB2 {
        final /* synthetic */ C25068zg6 a;

        a(C25068zg6 c25068zg6) {
            this.a = c25068zg6;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                AbstractC24464yf6.g(this.a, interfaceC22053ub1, 0);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C15800kB6 b(int i, C25068zg6 c25068zg6) {
        AbstractC13042fc3.i(c25068zg6, "previewParam");
        return new C15800kB6("ir.nasim.chat.search_SearchBarResultsAndConfigsPreview_null_Search_SearchChat_0_ResultBar_" + i, "Search", "SearchChat", "", AbstractC19242q11.c(-907304104, true, new a(c25068zg6)), "ResultBar", false, null, null, null, null, 1920, null);
    }

    public static final List c() {
        return a;
    }
}
