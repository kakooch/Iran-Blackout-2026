package androidx.fragment.app;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.C19938rB7;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes2.dex */
public final class r {
    private final FragmentManager a;
    private final CopyOnWriteArrayList b;

    private static final class a {
        private final FragmentManager.l a;
        private final boolean b;

        public a(FragmentManager.l lVar, boolean z) {
            AbstractC13042fc3.i(lVar, "callback");
            this.a = lVar;
            this.b = z;
        }

        public final FragmentManager.l a() {
            return this.a;
        }

        public final boolean b() {
            return this.b;
        }
    }

    public r(FragmentManager fragmentManager) {
        AbstractC13042fc3.i(fragmentManager, "fragmentManager");
        this.a = fragmentManager;
        this.b = new CopyOnWriteArrayList();
    }

    public final void a(Fragment fragment, Bundle bundle, boolean z) {
        AbstractC13042fc3.i(fragment, "f");
        Fragment fragmentG0 = this.a.G0();
        if (fragmentG0 != null) {
            FragmentManager fragmentManagerV5 = fragmentG0.V5();
            AbstractC13042fc3.h(fragmentManagerV5, "parent.getParentFragmentManager()");
            fragmentManagerV5.F0().a(fragment, bundle, true);
        }
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (!z || aVar.b()) {
                aVar.a().a(this.a, fragment, bundle);
            }
        }
    }

    public final void b(Fragment fragment, boolean z) {
        AbstractC13042fc3.i(fragment, "f");
        Context contextK = this.a.D0().k();
        Fragment fragmentG0 = this.a.G0();
        if (fragmentG0 != null) {
            FragmentManager fragmentManagerV5 = fragmentG0.V5();
            AbstractC13042fc3.h(fragmentManagerV5, "parent.getParentFragmentManager()");
            fragmentManagerV5.F0().b(fragment, true);
        }
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (!z || aVar.b()) {
                aVar.a().b(this.a, fragment, contextK);
            }
        }
    }

    public final void c(Fragment fragment, Bundle bundle, boolean z) {
        AbstractC13042fc3.i(fragment, "f");
        Fragment fragmentG0 = this.a.G0();
        if (fragmentG0 != null) {
            FragmentManager fragmentManagerV5 = fragmentG0.V5();
            AbstractC13042fc3.h(fragmentManagerV5, "parent.getParentFragmentManager()");
            fragmentManagerV5.F0().c(fragment, bundle, true);
        }
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (!z || aVar.b()) {
                aVar.a().c(this.a, fragment, bundle);
            }
        }
    }

    public final void d(Fragment fragment, boolean z) {
        AbstractC13042fc3.i(fragment, "f");
        Fragment fragmentG0 = this.a.G0();
        if (fragmentG0 != null) {
            FragmentManager fragmentManagerV5 = fragmentG0.V5();
            AbstractC13042fc3.h(fragmentManagerV5, "parent.getParentFragmentManager()");
            fragmentManagerV5.F0().d(fragment, true);
        }
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (!z || aVar.b()) {
                aVar.a().d(this.a, fragment);
            }
        }
    }

    public final void e(Fragment fragment, boolean z) {
        AbstractC13042fc3.i(fragment, "f");
        Fragment fragmentG0 = this.a.G0();
        if (fragmentG0 != null) {
            FragmentManager fragmentManagerV5 = fragmentG0.V5();
            AbstractC13042fc3.h(fragmentManagerV5, "parent.getParentFragmentManager()");
            fragmentManagerV5.F0().e(fragment, true);
        }
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (!z || aVar.b()) {
                aVar.a().e(this.a, fragment);
            }
        }
    }

    public final void f(Fragment fragment, boolean z) {
        AbstractC13042fc3.i(fragment, "f");
        Fragment fragmentG0 = this.a.G0();
        if (fragmentG0 != null) {
            FragmentManager fragmentManagerV5 = fragmentG0.V5();
            AbstractC13042fc3.h(fragmentManagerV5, "parent.getParentFragmentManager()");
            fragmentManagerV5.F0().f(fragment, true);
        }
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (!z || aVar.b()) {
                aVar.a().f(this.a, fragment);
            }
        }
    }

    public final void g(Fragment fragment, boolean z) {
        AbstractC13042fc3.i(fragment, "f");
        Context contextK = this.a.D0().k();
        Fragment fragmentG0 = this.a.G0();
        if (fragmentG0 != null) {
            FragmentManager fragmentManagerV5 = fragmentG0.V5();
            AbstractC13042fc3.h(fragmentManagerV5, "parent.getParentFragmentManager()");
            fragmentManagerV5.F0().g(fragment, true);
        }
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (!z || aVar.b()) {
                aVar.a().g(this.a, fragment, contextK);
            }
        }
    }

    public final void h(Fragment fragment, Bundle bundle, boolean z) {
        AbstractC13042fc3.i(fragment, "f");
        Fragment fragmentG0 = this.a.G0();
        if (fragmentG0 != null) {
            FragmentManager fragmentManagerV5 = fragmentG0.V5();
            AbstractC13042fc3.h(fragmentManagerV5, "parent.getParentFragmentManager()");
            fragmentManagerV5.F0().h(fragment, bundle, true);
        }
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (!z || aVar.b()) {
                aVar.a().h(this.a, fragment, bundle);
            }
        }
    }

    public final void i(Fragment fragment, boolean z) {
        AbstractC13042fc3.i(fragment, "f");
        Fragment fragmentG0 = this.a.G0();
        if (fragmentG0 != null) {
            FragmentManager fragmentManagerV5 = fragmentG0.V5();
            AbstractC13042fc3.h(fragmentManagerV5, "parent.getParentFragmentManager()");
            fragmentManagerV5.F0().i(fragment, true);
        }
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (!z || aVar.b()) {
                aVar.a().i(this.a, fragment);
            }
        }
    }

    public final void j(Fragment fragment, Bundle bundle, boolean z) {
        AbstractC13042fc3.i(fragment, "f");
        AbstractC13042fc3.i(bundle, "outState");
        Fragment fragmentG0 = this.a.G0();
        if (fragmentG0 != null) {
            FragmentManager fragmentManagerV5 = fragmentG0.V5();
            AbstractC13042fc3.h(fragmentManagerV5, "parent.getParentFragmentManager()");
            fragmentManagerV5.F0().j(fragment, bundle, true);
        }
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (!z || aVar.b()) {
                aVar.a().j(this.a, fragment, bundle);
            }
        }
    }

    public final void k(Fragment fragment, boolean z) {
        AbstractC13042fc3.i(fragment, "f");
        Fragment fragmentG0 = this.a.G0();
        if (fragmentG0 != null) {
            FragmentManager fragmentManagerV5 = fragmentG0.V5();
            AbstractC13042fc3.h(fragmentManagerV5, "parent.getParentFragmentManager()");
            fragmentManagerV5.F0().k(fragment, true);
        }
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (!z || aVar.b()) {
                aVar.a().k(this.a, fragment);
            }
        }
    }

    public final void l(Fragment fragment, boolean z) {
        AbstractC13042fc3.i(fragment, "f");
        Fragment fragmentG0 = this.a.G0();
        if (fragmentG0 != null) {
            FragmentManager fragmentManagerV5 = fragmentG0.V5();
            AbstractC13042fc3.h(fragmentManagerV5, "parent.getParentFragmentManager()");
            fragmentManagerV5.F0().l(fragment, true);
        }
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (!z || aVar.b()) {
                aVar.a().l(this.a, fragment);
            }
        }
    }

    public final void m(Fragment fragment, View view, Bundle bundle, boolean z) {
        AbstractC13042fc3.i(fragment, "f");
        AbstractC13042fc3.i(view, "v");
        Fragment fragmentG0 = this.a.G0();
        if (fragmentG0 != null) {
            FragmentManager fragmentManagerV5 = fragmentG0.V5();
            AbstractC13042fc3.h(fragmentManagerV5, "parent.getParentFragmentManager()");
            fragmentManagerV5.F0().m(fragment, view, bundle, true);
        }
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (!z || aVar.b()) {
                aVar.a().m(this.a, fragment, view, bundle);
            }
        }
    }

    public final void n(Fragment fragment, boolean z) {
        AbstractC13042fc3.i(fragment, "f");
        Fragment fragmentG0 = this.a.G0();
        if (fragmentG0 != null) {
            FragmentManager fragmentManagerV5 = fragmentG0.V5();
            AbstractC13042fc3.h(fragmentManagerV5, "parent.getParentFragmentManager()");
            fragmentManagerV5.F0().n(fragment, true);
        }
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (!z || aVar.b()) {
                aVar.a().n(this.a, fragment);
            }
        }
    }

    public final void o(FragmentManager.l lVar, boolean z) {
        AbstractC13042fc3.i(lVar, "cb");
        this.b.add(new a(lVar, z));
    }

    public final void p(FragmentManager.l lVar) {
        AbstractC13042fc3.i(lVar, "cb");
        synchronized (this.b) {
            try {
                int size = this.b.size();
                int i = 0;
                while (true) {
                    if (i >= size) {
                        break;
                    }
                    if (((a) this.b.get(i)).a() == lVar) {
                        this.b.remove(i);
                        break;
                    }
                    i++;
                }
                C19938rB7 c19938rB7 = C19938rB7.a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
