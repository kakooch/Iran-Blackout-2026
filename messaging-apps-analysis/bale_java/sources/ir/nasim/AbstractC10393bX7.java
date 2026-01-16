package ir.nasim;

import androidx.lifecycle.G;
import ir.nasim.AbstractC20375ru1;

/* renamed from: ir.nasim.bX7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
abstract /* synthetic */ class AbstractC10393bX7 {
    public static final VW7 a(InterfaceC15408jX7 interfaceC15408jX7, InterfaceC11299cm3 interfaceC11299cm3, String str, G.c cVar, AbstractC20375ru1 abstractC20375ru1) {
        AbstractC13042fc3.i(interfaceC15408jX7, "<this>");
        AbstractC13042fc3.i(interfaceC11299cm3, "modelClass");
        AbstractC13042fc3.i(abstractC20375ru1, "extras");
        androidx.lifecycle.G gA = cVar != null ? androidx.lifecycle.G.b.a(interfaceC15408jX7.d1(), cVar, abstractC20375ru1) : interfaceC15408jX7 instanceof androidx.lifecycle.h ? androidx.lifecycle.G.b.a(interfaceC15408jX7.d1(), ((androidx.lifecycle.h) interfaceC15408jX7).n3(), abstractC20375ru1) : G.b.c(androidx.lifecycle.G.b, interfaceC15408jX7, null, null, 6, null);
        return str != null ? gA.c(str, interfaceC11299cm3) : gA.a(interfaceC11299cm3);
    }

    public static /* synthetic */ VW7 b(InterfaceC15408jX7 interfaceC15408jX7, InterfaceC11299cm3 interfaceC11299cm3, String str, G.c cVar, AbstractC20375ru1 abstractC20375ru1, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            cVar = null;
        }
        if ((i & 8) != 0) {
            abstractC20375ru1 = interfaceC15408jX7 instanceof androidx.lifecycle.h ? ((androidx.lifecycle.h) interfaceC15408jX7).p3() : AbstractC20375ru1.a.b;
        }
        return ZW7.a(interfaceC15408jX7, interfaceC11299cm3, str, cVar, abstractC20375ru1);
    }

    public static final VW7 c(InterfaceC11299cm3 interfaceC11299cm3, InterfaceC15408jX7 interfaceC15408jX7, String str, G.c cVar, AbstractC20375ru1 abstractC20375ru1, InterfaceC22053ub1 interfaceC22053ub1, int i, int i2) {
        AbstractC13042fc3.i(interfaceC11299cm3, "modelClass");
        interfaceC22053ub1.A(1673618944);
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
            AbstractC5138Ib1.Q(1673618944, i, -1, "androidx.lifecycle.viewmodel.compose.viewModel (ViewModel.kt:102)");
        }
        VW7 vw7A = ZW7.a(interfaceC15408jX7, interfaceC11299cm3, str, cVar, abstractC20375ru1);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        interfaceC22053ub1.U();
        return vw7A;
    }
}
