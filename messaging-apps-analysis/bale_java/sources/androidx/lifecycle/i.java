package androidx.lifecycle;

import android.os.Bundle;
import androidx.lifecycle.j;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.C14819iX7;
import ir.nasim.C7289Rb6;
import ir.nasim.InterfaceC15408jX7;
import ir.nasim.InterfaceC18633oz3;
import ir.nasim.InterfaceC7760Tb6;
import ir.nasim.VW7;
import java.util.Iterator;

/* loaded from: classes2.dex */
public final class i {
    public static final i a = new i();

    public static final class a implements C7289Rb6.a {
        @Override // ir.nasim.C7289Rb6.a
        public void a(InterfaceC7760Tb6 interfaceC7760Tb6) throws NoSuchMethodException, SecurityException {
            AbstractC13042fc3.i(interfaceC7760Tb6, "owner");
            if (!(interfaceC7760Tb6 instanceof InterfaceC15408jX7)) {
                throw new IllegalStateException("Internal error: OnRecreation should be registered only on components that implement ViewModelStoreOwner".toString());
            }
            C14819iX7 c14819iX7D1 = ((InterfaceC15408jX7) interfaceC7760Tb6).d1();
            C7289Rb6 c7289Rb6V1 = interfaceC7760Tb6.v1();
            Iterator it = c14819iX7D1.c().iterator();
            while (it.hasNext()) {
                VW7 vw7B = c14819iX7D1.b((String) it.next());
                AbstractC13042fc3.f(vw7B);
                i.a(vw7B, c7289Rb6V1, interfaceC7760Tb6.getLifecycle());
            }
            if (!c14819iX7D1.c().isEmpty()) {
                c7289Rb6V1.i(a.class);
            }
        }
    }

    public static final class b implements n {
        final /* synthetic */ j a;
        final /* synthetic */ C7289Rb6 b;

        b(j jVar, C7289Rb6 c7289Rb6) {
            this.a = jVar;
            this.b = c7289Rb6;
        }

        @Override // androidx.lifecycle.n
        public void s(InterfaceC18633oz3 interfaceC18633oz3, j.a aVar) throws NoSuchMethodException, SecurityException {
            AbstractC13042fc3.i(interfaceC18633oz3, "source");
            AbstractC13042fc3.i(aVar, "event");
            if (aVar == j.a.ON_START) {
                this.a.d(this);
                this.b.i(a.class);
            }
        }
    }

    private i() {
    }

    public static final void a(VW7 vw7, C7289Rb6 c7289Rb6, j jVar) {
        AbstractC13042fc3.i(vw7, "viewModel");
        AbstractC13042fc3.i(c7289Rb6, "registry");
        AbstractC13042fc3.i(jVar, "lifecycle");
        A a2 = (A) vw7.K0("androidx.lifecycle.savedstate.vm.tag");
        if (a2 == null || a2.d()) {
            return;
        }
        a2.a(c7289Rb6, jVar);
        a.c(c7289Rb6, jVar);
    }

    public static final A b(C7289Rb6 c7289Rb6, j jVar, String str, Bundle bundle) {
        AbstractC13042fc3.i(c7289Rb6, "registry");
        AbstractC13042fc3.i(jVar, "lifecycle");
        AbstractC13042fc3.f(str);
        A a2 = new A(str, y.f.a(c7289Rb6.b(str), bundle));
        a2.a(c7289Rb6, jVar);
        a.c(c7289Rb6, jVar);
        return a2;
    }

    private final void c(C7289Rb6 c7289Rb6, j jVar) throws NoSuchMethodException, SecurityException {
        j.b bVarB = jVar.b();
        if (bVarB == j.b.INITIALIZED || bVarB.j(j.b.STARTED)) {
            c7289Rb6.i(a.class);
        } else {
            jVar.a(new b(jVar, c7289Rb6));
        }
    }
}
