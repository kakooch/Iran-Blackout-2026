package ir.nasim;

import android.os.Bundle;
import androidx.lifecycle.j;
import ir.nasim.BK5;
import ir.nasim.C18145o96;
import java.util.Iterator;
import java.util.Map;

/* renamed from: ir.nasim.Rb6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C7289Rb6 {
    private static final b g = new b(null);
    private boolean b;
    private Bundle c;
    private boolean d;
    private BK5.b e;
    private final C18145o96 a = new C18145o96();
    private boolean f = true;

    /* renamed from: ir.nasim.Rb6$a */
    public interface a {
        void a(InterfaceC7760Tb6 interfaceC7760Tb6);
    }

    /* renamed from: ir.nasim.Rb6$b */
    private static final class b {
        private b() {
        }

        public /* synthetic */ b(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.Rb6$c */
    public interface c {
        Bundle b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(C7289Rb6 c7289Rb6, InterfaceC18633oz3 interfaceC18633oz3, j.a aVar) {
        AbstractC13042fc3.i(c7289Rb6, "this$0");
        AbstractC13042fc3.i(interfaceC18633oz3, "<anonymous parameter 0>");
        AbstractC13042fc3.i(aVar, "event");
        if (aVar == j.a.ON_START) {
            c7289Rb6.f = true;
        } else if (aVar == j.a.ON_STOP) {
            c7289Rb6.f = false;
        }
    }

    public final Bundle b(String str) {
        AbstractC13042fc3.i(str, "key");
        if (!this.d) {
            throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component".toString());
        }
        Bundle bundle = this.c;
        if (bundle == null) {
            return null;
        }
        Bundle bundle2 = bundle != null ? bundle.getBundle(str) : null;
        Bundle bundle3 = this.c;
        if (bundle3 != null) {
            bundle3.remove(str);
        }
        Bundle bundle4 = this.c;
        if (bundle4 == null || bundle4.isEmpty()) {
            this.c = null;
        }
        return bundle2;
    }

    public final c c(String str) {
        AbstractC13042fc3.i(str, "key");
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            AbstractC13042fc3.h(entry, "components");
            String str2 = (String) entry.getKey();
            c cVar = (c) entry.getValue();
            if (AbstractC13042fc3.d(str2, str)) {
                return cVar;
            }
        }
        return null;
    }

    public final void e(androidx.lifecycle.j jVar) {
        AbstractC13042fc3.i(jVar, "lifecycle");
        if (!(!this.b)) {
            throw new IllegalStateException("SavedStateRegistry was already attached.".toString());
        }
        jVar.a(new androidx.lifecycle.n() { // from class: ir.nasim.Qb6
            @Override // androidx.lifecycle.n
            public final void s(InterfaceC18633oz3 interfaceC18633oz3, j.a aVar) {
                C7289Rb6.d(this.a, interfaceC18633oz3, aVar);
            }
        });
        this.b = true;
    }

    public final void f(Bundle bundle) {
        if (!this.b) {
            throw new IllegalStateException("You must call performAttach() before calling performRestore(Bundle).".toString());
        }
        if (!(!this.d)) {
            throw new IllegalStateException("SavedStateRegistry was already restored.".toString());
        }
        this.c = bundle != null ? bundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key") : null;
        this.d = true;
    }

    public final void g(Bundle bundle) {
        AbstractC13042fc3.i(bundle, "outBundle");
        Bundle bundle2 = new Bundle();
        Bundle bundle3 = this.c;
        if (bundle3 != null) {
            bundle2.putAll(bundle3);
        }
        C18145o96.d dVarI = this.a.i();
        AbstractC13042fc3.h(dVarI, "this.components.iteratorWithAdditions()");
        while (dVarI.hasNext()) {
            Map.Entry entry = (Map.Entry) dVarI.next();
            bundle2.putBundle((String) entry.getKey(), ((c) entry.getValue()).b());
        }
        if (bundle2.isEmpty()) {
            return;
        }
        bundle.putBundle("androidx.lifecycle.BundlableSavedStateRegistry.key", bundle2);
    }

    public final void h(String str, c cVar) {
        AbstractC13042fc3.i(str, "key");
        AbstractC13042fc3.i(cVar, "provider");
        if (((c) this.a.r(str, cVar)) != null) {
            throw new IllegalArgumentException("SavedStateProvider with the given key is already registered".toString());
        }
    }

    public final void i(Class cls) throws NoSuchMethodException, SecurityException {
        AbstractC13042fc3.i(cls, "clazz");
        if (!this.f) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState".toString());
        }
        BK5.b bVar = this.e;
        if (bVar == null) {
            bVar = new BK5.b(this);
        }
        this.e = bVar;
        try {
            cls.getDeclaredConstructor(null);
            BK5.b bVar2 = this.e;
            if (bVar2 != null) {
                String name = cls.getName();
                AbstractC13042fc3.h(name, "clazz.name");
                bVar2.a(name);
            }
        } catch (NoSuchMethodException e) {
            throw new IllegalArgumentException("Class " + cls.getSimpleName() + " must have default constructor in order to be automatically recreated", e);
        }
    }

    public final void j(String str) {
        AbstractC13042fc3.i(str, "key");
        this.a.t(str);
    }
}
