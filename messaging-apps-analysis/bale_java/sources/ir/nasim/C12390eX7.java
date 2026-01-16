package ir.nasim;

import androidx.lifecycle.G;
import ir.nasim.C13617gX7;

/* renamed from: ir.nasim.eX7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C12390eX7 {
    private final C14819iX7 a;
    private final G.c b;
    private final AbstractC20375ru1 c;

    public C12390eX7(C14819iX7 c14819iX7, G.c cVar, AbstractC20375ru1 abstractC20375ru1) {
        AbstractC13042fc3.i(c14819iX7, "store");
        AbstractC13042fc3.i(cVar, "factory");
        AbstractC13042fc3.i(abstractC20375ru1, "extras");
        this.a = c14819iX7;
        this.b = cVar;
        this.c = abstractC20375ru1;
    }

    public static /* synthetic */ VW7 b(C12390eX7 c12390eX7, InterfaceC11299cm3 interfaceC11299cm3, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = C13617gX7.a.c(interfaceC11299cm3);
        }
        return c12390eX7.a(interfaceC11299cm3, str);
    }

    public final VW7 a(InterfaceC11299cm3 interfaceC11299cm3, String str) {
        AbstractC13042fc3.i(interfaceC11299cm3, "modelClass");
        AbstractC13042fc3.i(str, "key");
        VW7 vw7B = this.a.b(str);
        if (!interfaceC11299cm3.k(vw7B)) {
            C13170fm4 c13170fm4 = new C13170fm4(this.c);
            c13170fm4.c(C13617gX7.a.a, str);
            VW7 vw7A = AbstractC12999fX7.a(this.b, interfaceC11299cm3, c13170fm4);
            this.a.d(str, vw7A);
            return vw7A;
        }
        Object obj = this.b;
        if (obj instanceof G.e) {
            AbstractC13042fc3.f(vw7B);
            ((G.e) obj).d(vw7B);
        }
        AbstractC13042fc3.g(vw7B, "null cannot be cast to non-null type T of androidx.lifecycle.viewmodel.ViewModelProviderImpl.getViewModel");
        return vw7B;
    }
}
