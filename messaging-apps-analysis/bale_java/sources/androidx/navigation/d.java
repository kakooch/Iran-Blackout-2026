package androidx.navigation;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.lifecycle.AbstractC1965a;
import androidx.lifecycle.B;
import androidx.lifecycle.C;
import androidx.lifecycle.G;
import androidx.lifecycle.j;
import androidx.lifecycle.y;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC13269fw3;
import ir.nasim.AbstractC20375ru1;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.C13170fm4;
import ir.nasim.C14819iX7;
import ir.nasim.C7289Rb6;
import ir.nasim.C7523Sb6;
import ir.nasim.ED1;
import ir.nasim.InterfaceC12574eq4;
import ir.nasim.InterfaceC15408jX7;
import ir.nasim.InterfaceC18633oz3;
import ir.nasim.InterfaceC7760Tb6;
import ir.nasim.InterfaceC9173Yu3;
import ir.nasim.SA2;
import ir.nasim.VW7;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.UUID;

/* loaded from: classes2.dex */
public final class d implements InterfaceC18633oz3, InterfaceC15408jX7, androidx.lifecycle.h, InterfaceC7760Tb6 {
    public static final a o = new a(null);
    private final Context a;
    private i b;
    private final Bundle c;
    private j.b d;
    private final InterfaceC12574eq4 e;
    private final String f;
    private final Bundle g;
    private androidx.lifecycle.p h;
    private final C7523Sb6 i;
    private boolean j;
    private final InterfaceC9173Yu3 k;
    private final InterfaceC9173Yu3 l;
    private j.b m;
    private final G.c n;

    public static final class a {
        private a() {
        }

        public static /* synthetic */ d b(a aVar, Context context, i iVar, Bundle bundle, j.b bVar, InterfaceC12574eq4 interfaceC12574eq4, String str, Bundle bundle2, int i, Object obj) {
            String str2;
            Bundle bundle3 = (i & 4) != 0 ? null : bundle;
            j.b bVar2 = (i & 8) != 0 ? j.b.CREATED : bVar;
            InterfaceC12574eq4 interfaceC12574eq42 = (i & 16) != 0 ? null : interfaceC12574eq4;
            if ((i & 32) != 0) {
                String string = UUID.randomUUID().toString();
                AbstractC13042fc3.h(string, "randomUUID().toString()");
                str2 = string;
            } else {
                str2 = str;
            }
            return aVar.a(context, iVar, bundle3, bVar2, interfaceC12574eq42, str2, (i & 64) != 0 ? null : bundle2);
        }

        public final d a(Context context, i iVar, Bundle bundle, j.b bVar, InterfaceC12574eq4 interfaceC12574eq4, String str, Bundle bundle2) {
            AbstractC13042fc3.i(iVar, "destination");
            AbstractC13042fc3.i(bVar, "hostLifecycleState");
            AbstractC13042fc3.i(str, "id");
            return new d(context, iVar, bundle, bVar, interfaceC12574eq4, str, bundle2, null);
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    private static final class b extends AbstractC1965a {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(InterfaceC7760Tb6 interfaceC7760Tb6) {
            super(interfaceC7760Tb6, null);
            AbstractC13042fc3.i(interfaceC7760Tb6, "owner");
        }

        @Override // androidx.lifecycle.AbstractC1965a
        protected VW7 f(String str, Class cls, y yVar) {
            AbstractC13042fc3.i(str, "key");
            AbstractC13042fc3.i(cls, "modelClass");
            AbstractC13042fc3.i(yVar, "handle");
            return new c(yVar);
        }
    }

    private static final class c extends VW7 {
        private final y b;

        public c(y yVar) {
            AbstractC13042fc3.i(yVar, "handle");
            this.b = yVar;
        }

        public final y P0() {
            return this.b;
        }
    }

    /* renamed from: androidx.navigation.d$d, reason: collision with other inner class name */
    static final class C0100d extends AbstractC8614Ws3 implements SA2 {
        C0100d() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C invoke() {
            Context context = d.this.a;
            Context applicationContext = context != null ? context.getApplicationContext() : null;
            Application application = applicationContext instanceof Application ? (Application) applicationContext : null;
            d dVar = d.this;
            return new C(application, dVar, dVar.c());
        }
    }

    static final class e extends AbstractC8614Ws3 implements SA2 {
        e() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final y invoke() {
            if (!d.this.j) {
                throw new IllegalStateException("You cannot access the NavBackStackEntry's SavedStateHandle until it is added to the NavController's back stack (i.e., the Lifecycle of the NavBackStackEntry reaches the CREATED state).".toString());
            }
            if (d.this.getLifecycle().b() != j.b.DESTROYED) {
                return ((c) new G(d.this, new b(d.this)).b(c.class)).P0();
            }
            throw new IllegalStateException("You cannot access the NavBackStackEntry's SavedStateHandle after the NavBackStackEntry is destroyed.".toString());
        }
    }

    public /* synthetic */ d(Context context, i iVar, Bundle bundle, j.b bVar, InterfaceC12574eq4 interfaceC12574eq4, String str, Bundle bundle2, ED1 ed1) {
        this(context, iVar, bundle, bVar, interfaceC12574eq4, str, bundle2);
    }

    private final C d() {
        return (C) this.k.getValue();
    }

    public final Bundle c() {
        if (this.c == null) {
            return null;
        }
        return new Bundle(this.c);
    }

    @Override // ir.nasim.InterfaceC15408jX7
    public C14819iX7 d1() {
        if (!this.j) {
            throw new IllegalStateException("You cannot access the NavBackStackEntry's ViewModels until it is added to the NavController's back stack (i.e., the Lifecycle of the NavBackStackEntry reaches the CREATED state).".toString());
        }
        if (getLifecycle().b() == j.b.DESTROYED) {
            throw new IllegalStateException("You cannot access the NavBackStackEntry's ViewModels after the NavBackStackEntry is destroyed.".toString());
        }
        InterfaceC12574eq4 interfaceC12574eq4 = this.e;
        if (interfaceC12574eq4 != null) {
            return interfaceC12574eq4.F(this.f);
        }
        throw new IllegalStateException("You must call setViewModelStore() on your NavHostController before accessing the ViewModelStore of a navigation graph.".toString());
    }

    public final i e() {
        return this.b;
    }

    public boolean equals(Object obj) {
        Set<String> setKeySet;
        if (obj == null || !(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        if (!AbstractC13042fc3.d(this.f, dVar.f) || !AbstractC13042fc3.d(this.b, dVar.b) || !AbstractC13042fc3.d(getLifecycle(), dVar.getLifecycle()) || !AbstractC13042fc3.d(v1(), dVar.v1())) {
            return false;
        }
        if (!AbstractC13042fc3.d(this.c, dVar.c)) {
            Bundle bundle = this.c;
            if (bundle == null || (setKeySet = bundle.keySet()) == null) {
                return false;
            }
            Set<String> set = setKeySet;
            if (!(set instanceof Collection) || !set.isEmpty()) {
                for (String str : set) {
                    Object obj2 = this.c.get(str);
                    Bundle bundle2 = dVar.c;
                    if (!AbstractC13042fc3.d(obj2, bundle2 != null ? bundle2.get(str) : null)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public final String f() {
        return this.f;
    }

    public final j.b g() {
        return this.m;
    }

    @Override // ir.nasim.InterfaceC18633oz3
    public androidx.lifecycle.j getLifecycle() {
        return this.h;
    }

    public final void h(j.a aVar) {
        AbstractC13042fc3.i(aVar, "event");
        this.d = aVar.j();
        l();
    }

    public int hashCode() {
        Set<String> setKeySet;
        int iHashCode = (this.f.hashCode() * 31) + this.b.hashCode();
        Bundle bundle = this.c;
        if (bundle != null && (setKeySet = bundle.keySet()) != null) {
            Iterator<T> it = setKeySet.iterator();
            while (it.hasNext()) {
                int i = iHashCode * 31;
                Object obj = this.c.get((String) it.next());
                iHashCode = i + (obj != null ? obj.hashCode() : 0);
            }
        }
        return (((iHashCode * 31) + getLifecycle().hashCode()) * 31) + v1().hashCode();
    }

    public final void i(Bundle bundle) {
        AbstractC13042fc3.i(bundle, "outBundle");
        this.i.e(bundle);
    }

    public final void j(i iVar) {
        AbstractC13042fc3.i(iVar, "<set-?>");
        this.b = iVar;
    }

    public final void k(j.b bVar) {
        AbstractC13042fc3.i(bVar, "maxState");
        this.m = bVar;
        l();
    }

    public final void l() {
        if (!this.j) {
            this.i.c();
            this.j = true;
            if (this.e != null) {
                B.c(this);
            }
            this.i.d(this.g);
        }
        if (this.d.ordinal() < this.m.ordinal()) {
            this.h.n(this.d);
        } else {
            this.h.n(this.m);
        }
    }

    @Override // androidx.lifecycle.h
    public G.c n3() {
        return this.n;
    }

    @Override // androidx.lifecycle.h
    public AbstractC20375ru1 p3() {
        C13170fm4 c13170fm4 = new C13170fm4(null, 1, null);
        Context context = this.a;
        Context applicationContext = context != null ? context.getApplicationContext() : null;
        Application application = applicationContext instanceof Application ? (Application) applicationContext : null;
        if (application != null) {
            c13170fm4.c(G.a.h, application);
        }
        c13170fm4.c(B.a, this);
        c13170fm4.c(B.b, this);
        Bundle bundleC = c();
        if (bundleC != null) {
            c13170fm4.c(B.c, bundleC);
        }
        return c13170fm4;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(d.class.getSimpleName());
        sb.append('(' + this.f + ')');
        sb.append(" destination=");
        sb.append(this.b);
        String string = sb.toString();
        AbstractC13042fc3.h(string, "sb.toString()");
        return string;
    }

    @Override // ir.nasim.InterfaceC7760Tb6
    public C7289Rb6 v1() {
        return this.i.b();
    }

    private d(Context context, i iVar, Bundle bundle, j.b bVar, InterfaceC12574eq4 interfaceC12574eq4, String str, Bundle bundle2) {
        this.a = context;
        this.b = iVar;
        this.c = bundle;
        this.d = bVar;
        this.e = interfaceC12574eq4;
        this.f = str;
        this.g = bundle2;
        this.h = new androidx.lifecycle.p(this);
        this.i = C7523Sb6.d.a(this);
        this.k = AbstractC13269fw3.a(new C0100d());
        this.l = AbstractC13269fw3.a(new e());
        this.m = j.b.INITIALIZED;
        this.n = d();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public d(d dVar, Bundle bundle) {
        this(dVar.a, dVar.b, bundle, dVar.d, dVar.e, dVar.f, dVar.g);
        AbstractC13042fc3.i(dVar, "entry");
        this.d = dVar.d;
        k(dVar.m);
    }
}
