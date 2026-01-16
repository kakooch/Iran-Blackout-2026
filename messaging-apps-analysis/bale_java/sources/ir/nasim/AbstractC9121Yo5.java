package ir.nasim;

import java.util.List;

/* renamed from: ir.nasim.Yo5, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC9121Yo5 {
    private static final List a = AbstractC11342cq6.K(AbstractC11342cq6.D(AbstractC9962aq6.c(new O9().a().iterator()), new InterfaceC14603iB2() { // from class: ir.nasim.Xo5
        @Override // ir.nasim.InterfaceC14603iB2
        public final Object invoke(Object obj, Object obj2) {
            return AbstractC9121Yo5.b(((Integer) obj).intValue(), (C8870Xr2) obj2);
        }
    }));

    /* renamed from: ir.nasim.Yo5$a */
    static final class a implements InterfaceC14603iB2 {
        final /* synthetic */ C8870Xr2 a;

        a(C8870Xr2 c8870Xr2) {
            this.a = c8870Xr2;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                F9.y(this.a, interfaceC22053ub1, 0);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C15800kB6 b(int i, C8870Xr2 c8870Xr2) {
        AbstractC13042fc3.i(c8870Xr2, "previewParam");
        return new C15800kB6("ir.nasim.dialoglist.ui.folders.component_PreviewAddFoldersBottomSheetFa_null_DefaultGroup_PreviewAddFoldersBottomSheetFa_0_null_" + i, "Default Group", "PreviewAddFoldersBottomSheetFa", "", AbstractC19242q11.c(144632431, true, new a(c8870Xr2)), null, false, null, null, null, null, 1952, null);
    }

    public static final List c() {
        return a;
    }
}
