package ir.nasim;

import java.util.List;

/* renamed from: ir.nasim.sp5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC20920sp5 {
    private static final List a = AbstractC11342cq6.K(AbstractC11342cq6.D(AbstractC9962aq6.c(new C13350g47().a().iterator()), new InterfaceC14603iB2() { // from class: ir.nasim.rp5
        @Override // ir.nasim.InterfaceC14603iB2
        public final Object invoke(Object obj, Object obj2) {
            return AbstractC20920sp5.b(((Integer) obj).intValue(), (C10) obj2);
        }
    }));

    /* renamed from: ir.nasim.sp5$a */
    static final class a implements InterfaceC14603iB2 {
        final /* synthetic */ C10 a;

        a(C10 c10) {
            this.a = c10;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                B10.h(this.a, interfaceC22053ub1, 0);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C15800kB6 b(int i, C10 c10) {
        AbstractC13042fc3.i(c10, "previewParam");
        return new C15800kB6("ir.nasim.components.switchbutton_PreviewBaleSwitch_null_switch_switch_0_null_" + i, "switch", "switch", "", AbstractC19242q11.c(-150950007, true, new a(c10)), null, false, null, null, null, null, 1952, null);
    }

    public static final List c() {
        return a;
    }
}
