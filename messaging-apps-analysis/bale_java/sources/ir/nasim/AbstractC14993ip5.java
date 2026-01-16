package ir.nasim;

import java.util.List;

/* renamed from: ir.nasim.ip5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC14993ip5 {
    private static final List a = AbstractC11342cq6.K(AbstractC11342cq6.D(AbstractC9962aq6.c(new C24664z00().a().iterator()), new InterfaceC14603iB2() { // from class: ir.nasim.hp5
        @Override // ir.nasim.InterfaceC14603iB2
        public final Object invoke(Object obj, Object obj2) {
            return AbstractC14993ip5.b(((Integer) obj).intValue(), (A00) obj2);
        }
    }));

    /* renamed from: ir.nasim.ip5$a */
    static final class a implements InterfaceC14603iB2 {
        final /* synthetic */ A00 a;

        a(A00 a00) {
            this.a = a00;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                AbstractC24074y00.i(this.a, interfaceC22053ub1, 0);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C15800kB6 b(int i, A00 a00) {
        AbstractC13042fc3.i(a00, "previewParam");
        return new C15800kB6("ir.nasim.components.list_PreviewBaleListSwitch_null_Components_PreviewBaleListSwitch-Component-en_1_null_" + i, "Components", "PreviewBaleListSwitch - Component - en", "", AbstractC19242q11.c(-91826936, true, new a(a00)), null, false, null, null, null, null, 1952, null);
    }

    public static final List c() {
        return a;
    }
}
