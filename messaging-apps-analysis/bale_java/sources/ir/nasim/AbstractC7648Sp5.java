package ir.nasim;

import java.util.List;

/* renamed from: ir.nasim.Sp5, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public abstract class AbstractC7648Sp5 {
    private static final List a = AbstractC11342cq6.K(AbstractC11342cq6.D(AbstractC9962aq6.c(new C13751gl4().a().iterator()), new InterfaceC14603iB2() { // from class: ir.nasim.Rp5
        @Override // ir.nasim.InterfaceC14603iB2
        public final Object invoke(Object obj, Object obj2) {
            return AbstractC7648Sp5.b(((Integer) obj).intValue(), (XV4) obj2);
        }
    }));

    /* renamed from: ir.nasim.Sp5$a */
    static final class a implements InterfaceC14603iB2 {
        final /* synthetic */ XV4 a;

        a(XV4 xv4) {
            this.a = xv4;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                AbstractC11912dl4.l(this.a, interfaceC22053ub1, 0);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C15800kB6 b(int i, XV4 xv4) {
        AbstractC13042fc3.i(xv4, "previewParam");
        return new C15800kB6("ir.nasim.settings.ui.multiaccount_PreviewMultiAccountBottomSheetListItem_null_DefaultGroup_PreviewMultiAccountBottomSheetListItem_0_null_" + i, "Default Group", "PreviewMultiAccountBottomSheetListItem", "", AbstractC19242q11.c(-963295891, true, new a(xv4)), null, false, null, null, null, null, 1952, null);
    }

    public static final List c() {
        return a;
    }
}
