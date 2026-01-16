package ir.nasim;

import androidx.lifecycle.G;
import ir.nasim.AbstractC20375ru1;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: ir.nasim.cX7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract /* synthetic */ class AbstractC10983cX7 {
    public static final /* synthetic */ VW7 a(Class cls, InterfaceC15408jX7 interfaceC15408jX7, String str, G.c cVar, InterfaceC22053ub1 interfaceC22053ub1, int i, int i2) {
        AbstractC13042fc3.i(cls, "modelClass");
        interfaceC22053ub1.A(-1252471378);
        if ((i2 & 2) != 0 && (interfaceC15408jX7 = C24834zH3.a.a(interfaceC22053ub1, 6)) == null) {
            throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
        }
        if ((i2 & 4) != 0) {
            str = null;
        }
        G.c cVar2 = (i2 & 8) != 0 ? null : cVar;
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(-1252471378, i, -1, "androidx.lifecycle.viewmodel.compose.viewModel (ViewModel.android.kt:85)");
        }
        VW7 vw7B = AbstractC10393bX7.b(interfaceC15408jX7, AbstractC4762Gl3.e(cls), str, cVar2, null, 8, null);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        interfaceC22053ub1.U();
        return vw7B;
    }

    public static final VW7 b(Class cls, InterfaceC15408jX7 interfaceC15408jX7, String str, G.c cVar, AbstractC20375ru1 abstractC20375ru1, InterfaceC22053ub1 interfaceC22053ub1, int i, int i2) {
        AbstractC13042fc3.i(cls, "modelClass");
        interfaceC22053ub1.A(-1566358618);
        if ((i2 & 2) != 0 && (interfaceC15408jX7 = C24834zH3.a.a(interfaceC22053ub1, 6)) == null) {
            throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
        }
        if ((i2 & 4) != 0) {
            str = null;
        }
        if ((i2 & 8) != 0) {
            cVar = null;
        }
        if ((i2 & 16) != 0) {
            abstractC20375ru1 = interfaceC15408jX7 instanceof androidx.lifecycle.h ? ((androidx.lifecycle.h) interfaceC15408jX7).p3() : AbstractC20375ru1.a.b;
        }
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(-1566358618, i, -1, "androidx.lifecycle.viewmodel.compose.viewModel (ViewModel.android.kt:123)");
        }
        VW7 vw7A = ZW7.a(interfaceC15408jX7, AbstractC4762Gl3.e(cls), str, cVar, abstractC20375ru1);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        interfaceC22053ub1.U();
        return vw7A;
    }
}
