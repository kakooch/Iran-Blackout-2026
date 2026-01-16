package androidx.navigation;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import androidx.lifecycle.j;
import androidx.navigation.d;
import androidx.navigation.f;
import androidx.navigation.h;
import androidx.navigation.i;
import androidx.navigation.m;
import androidx.navigation.p;
import ir.nasim.AbstractC10360bX0;
import ir.nasim.AbstractC11342cq6;
import ir.nasim.AbstractC11420cy6;
import ir.nasim.AbstractC12281eL6;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC13269fw3;
import ir.nasim.AbstractC13610gX0;
import ir.nasim.AbstractC14201hX0;
import ir.nasim.AbstractC15401jX0;
import ir.nasim.AbstractC18350oW3;
import ir.nasim.AbstractC19138pq4;
import ir.nasim.AbstractC19810qy7;
import ir.nasim.AbstractC23070wI4;
import ir.nasim.AbstractC6459Nq2;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.AbstractC9363Zp4;
import ir.nasim.AbstractC9766aX0;
import ir.nasim.AbstractC9962aq6;
import ir.nasim.BJ;
import ir.nasim.C11637dL5;
import ir.nasim.C14819iX7;
import ir.nasim.C15017is;
import ir.nasim.C19938rB7;
import ir.nasim.C23903xi5;
import ir.nasim.C6650Oj7;
import ir.nasim.C9663aL5;
import ir.nasim.DJ;
import ir.nasim.ED1;
import ir.nasim.EnumC6162Ml0;
import ir.nasim.InterfaceC10258bL6;
import ir.nasim.InterfaceC18042nz3;
import ir.nasim.InterfaceC18633oz3;
import ir.nasim.InterfaceC23384wp6;
import ir.nasim.InterfaceC3621Bq2;
import ir.nasim.InterfaceC4557Fq2;
import ir.nasim.InterfaceC8327Vm4;
import ir.nasim.InterfaceC9173Yu3;
import ir.nasim.InterfaceC9336Zm4;
import ir.nasim.SA2;
import ir.nasim.UA2;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public abstract class e {
    public static final a H = new a(null);
    private static boolean I = true;
    private UA2 A;
    private final Map B;
    private int C;
    private final List D;
    private final InterfaceC9173Yu3 E;
    private final InterfaceC8327Vm4 F;
    private final InterfaceC4557Fq2 G;
    private final Context a;
    private Activity b;
    private androidx.navigation.l c;
    private androidx.navigation.j d;
    private Bundle e;
    private Parcelable[] f;
    private boolean g;
    private final BJ h;
    private final InterfaceC9336Zm4 i;
    private final InterfaceC10258bL6 j;
    private final InterfaceC9336Zm4 k;
    private final InterfaceC10258bL6 l;
    private final Map m;
    private final Map n;
    private final Map o;
    private final Map p;
    private InterfaceC18633oz3 q;
    private androidx.navigation.f r;
    private final CopyOnWriteArrayList s;
    private j.b t;
    private final InterfaceC18042nz3 u;
    private final AbstractC23070wI4 v;
    private boolean w;
    private q x;
    private final Map y;
    private UA2 z;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    private final class b extends AbstractC19138pq4 {
        private final p g;
        final /* synthetic */ e h;

        static final class a extends AbstractC8614Ws3 implements SA2 {
            final /* synthetic */ androidx.navigation.d f;
            final /* synthetic */ boolean g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(androidx.navigation.d dVar, boolean z) {
                super(0);
                this.f = dVar;
                this.g = z;
            }

            public final void a() {
                b.super.g(this.f, this.g);
            }

            @Override // ir.nasim.SA2
            public /* bridge */ /* synthetic */ Object invoke() {
                a();
                return C19938rB7.a;
            }
        }

        public b(e eVar, p pVar) {
            AbstractC13042fc3.i(pVar, "navigator");
            this.h = eVar;
            this.g = pVar;
        }

        @Override // ir.nasim.AbstractC19138pq4
        public androidx.navigation.d a(androidx.navigation.i iVar, Bundle bundle) {
            AbstractC13042fc3.i(iVar, "destination");
            return d.a.b(androidx.navigation.d.o, this.h.A(), iVar, bundle, this.h.G(), this.h.r, null, null, 96, null);
        }

        @Override // ir.nasim.AbstractC19138pq4
        public void e(androidx.navigation.d dVar) {
            androidx.navigation.f fVar;
            AbstractC13042fc3.i(dVar, "entry");
            boolean zD = AbstractC13042fc3.d(this.h.B.get(dVar), Boolean.TRUE);
            super.e(dVar);
            this.h.B.remove(dVar);
            if (this.h.h.contains(dVar)) {
                if (d()) {
                    return;
                }
                this.h.o0();
                this.h.i.c(AbstractC15401jX0.p1(this.h.h));
                this.h.k.c(this.h.f0());
                return;
            }
            this.h.n0(dVar);
            if (dVar.getLifecycle().b().j(j.b.CREATED)) {
                dVar.k(j.b.DESTROYED);
            }
            BJ bj = this.h.h;
            if (!(bj instanceof Collection) || !bj.isEmpty()) {
                Iterator<E> it = bj.iterator();
                while (it.hasNext()) {
                    if (AbstractC13042fc3.d(((androidx.navigation.d) it.next()).f(), dVar.f())) {
                        break;
                    }
                }
                if (!zD && (fVar = this.h.r) != null) {
                    fVar.R0(dVar.f());
                }
            } else if (!zD) {
                fVar.R0(dVar.f());
            }
            this.h.o0();
            this.h.k.c(this.h.f0());
        }

        @Override // ir.nasim.AbstractC19138pq4
        public void g(androidx.navigation.d dVar, boolean z) throws Resources.NotFoundException {
            AbstractC13042fc3.i(dVar, "popUpTo");
            p pVarE = this.h.x.e(dVar.e().B());
            if (!AbstractC13042fc3.d(pVarE, this.g)) {
                Object obj = this.h.y.get(pVarE);
                AbstractC13042fc3.f(obj);
                ((b) obj).g(dVar, z);
            } else {
                UA2 ua2 = this.h.A;
                if (ua2 == null) {
                    this.h.Y(dVar, new a(dVar, z));
                } else {
                    ua2.invoke(dVar);
                    super.g(dVar, z);
                }
            }
        }

        @Override // ir.nasim.AbstractC19138pq4
        public void h(androidx.navigation.d dVar, boolean z) {
            AbstractC13042fc3.i(dVar, "popUpTo");
            super.h(dVar, z);
            this.h.B.put(dVar, Boolean.valueOf(z));
        }

        @Override // ir.nasim.AbstractC19138pq4
        public void i(androidx.navigation.d dVar) {
            AbstractC13042fc3.i(dVar, "backStackEntry");
            p pVarE = this.h.x.e(dVar.e().B());
            if (!AbstractC13042fc3.d(pVarE, this.g)) {
                Object obj = this.h.y.get(pVarE);
                if (obj != null) {
                    ((b) obj).i(dVar);
                    return;
                }
                throw new IllegalStateException(("NavigatorBackStack for " + dVar.e().B() + " should already be created").toString());
            }
            UA2 ua2 = this.h.z;
            if (ua2 != null) {
                ua2.invoke(dVar);
                m(dVar);
                return;
            }
            Log.i("NavController", "Ignoring add of destination " + dVar.e() + " outside of the call to navigate(). ");
        }

        public final void m(androidx.navigation.d dVar) {
            AbstractC13042fc3.i(dVar, "backStackEntry");
            super.i(dVar);
        }
    }

    static final class c extends AbstractC8614Ws3 implements UA2 {
        public static final c e = new c();

        c() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Context invoke(Context context) {
            AbstractC13042fc3.i(context, "it");
            if (context instanceof ContextWrapper) {
                return ((ContextWrapper) context).getBaseContext();
            }
            return null;
        }
    }

    static final class d extends AbstractC8614Ws3 implements UA2 {
        public static final d e = new d();

        d() {
            super(1);
        }

        public final void a(androidx.navigation.n nVar) {
            AbstractC13042fc3.i(nVar, "$this$navOptions");
            nVar.i(true);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((androidx.navigation.n) obj);
            return C19938rB7.a;
        }
    }

    /* renamed from: androidx.navigation.e$e, reason: collision with other inner class name */
    static final class C0101e extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ C9663aL5 e;
        final /* synthetic */ C9663aL5 f;
        final /* synthetic */ e g;
        final /* synthetic */ boolean h;
        final /* synthetic */ BJ i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0101e(C9663aL5 c9663aL5, C9663aL5 c9663aL52, e eVar, boolean z, BJ bj) {
            super(1);
            this.e = c9663aL5;
            this.f = c9663aL52;
            this.g = eVar;
            this.h = z;
            this.i = bj;
        }

        public final void a(androidx.navigation.d dVar) {
            AbstractC13042fc3.i(dVar, "entry");
            this.e.a = true;
            this.f.a = true;
            this.g.d0(dVar, this.h, this.i);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((androidx.navigation.d) obj);
            return C19938rB7.a;
        }
    }

    static final class f extends AbstractC8614Ws3 implements UA2 {
        public static final f e = new f();

        f() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final androidx.navigation.i invoke(androidx.navigation.i iVar) {
            AbstractC13042fc3.i(iVar, "destination");
            androidx.navigation.j jVarC = iVar.C();
            if (jVarC == null || jVarC.g0() != iVar.A()) {
                return null;
            }
            return iVar.C();
        }
    }

    static final class g extends AbstractC8614Ws3 implements UA2 {
        g() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(androidx.navigation.i iVar) {
            AbstractC13042fc3.i(iVar, "destination");
            return Boolean.valueOf(!e.this.o.containsKey(Integer.valueOf(iVar.A())));
        }
    }

    static final class h extends AbstractC8614Ws3 implements UA2 {
        public static final h e = new h();

        h() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final androidx.navigation.i invoke(androidx.navigation.i iVar) {
            AbstractC13042fc3.i(iVar, "destination");
            androidx.navigation.j jVarC = iVar.C();
            if (jVarC == null || jVarC.g0() != iVar.A()) {
                return null;
            }
            return iVar.C();
        }
    }

    static final class i extends AbstractC8614Ws3 implements UA2 {
        i() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(androidx.navigation.i iVar) {
            AbstractC13042fc3.i(iVar, "destination");
            return Boolean.valueOf(!e.this.o.containsKey(Integer.valueOf(iVar.A())));
        }
    }

    static final class j extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ C9663aL5 e;
        final /* synthetic */ List f;
        final /* synthetic */ C11637dL5 g;
        final /* synthetic */ e h;
        final /* synthetic */ Bundle i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        j(C9663aL5 c9663aL5, List list, C11637dL5 c11637dL5, e eVar, Bundle bundle) {
            super(1);
            this.e = c9663aL5;
            this.f = list;
            this.g = c11637dL5;
            this.h = eVar;
            this.i = bundle;
        }

        public final void a(androidx.navigation.d dVar) {
            List listM;
            AbstractC13042fc3.i(dVar, "entry");
            this.e.a = true;
            int iIndexOf = this.f.indexOf(dVar);
            if (iIndexOf != -1) {
                int i = iIndexOf + 1;
                listM = this.f.subList(this.g.a, i);
                this.g.a = i;
            } else {
                listM = AbstractC10360bX0.m();
            }
            this.h.p(dVar.e(), this.i, dVar, listM);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((androidx.navigation.d) obj);
            return C19938rB7.a;
        }
    }

    static final class k extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ androidx.navigation.i e;
        final /* synthetic */ e f;

        static final class a extends AbstractC8614Ws3 implements UA2 {
            public static final a e = new a();

            a() {
                super(1);
            }

            public final void a(C15017is c15017is) {
                AbstractC13042fc3.i(c15017is, "$this$anim");
                c15017is.e(0);
                c15017is.f(0);
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((C15017is) obj);
                return C19938rB7.a;
            }
        }

        static final class b extends AbstractC8614Ws3 implements UA2 {
            public static final b e = new b();

            b() {
                super(1);
            }

            public final void a(C23903xi5 c23903xi5) {
                AbstractC13042fc3.i(c23903xi5, "$this$popUpTo");
                c23903xi5.d(true);
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((C23903xi5) obj);
                return C19938rB7.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        k(androidx.navigation.i iVar, e eVar) {
            super(1);
            this.e = iVar;
            this.f = eVar;
        }

        public final void a(androidx.navigation.n nVar) {
            AbstractC13042fc3.i(nVar, "$this$navOptions");
            nVar.a(a.e);
            androidx.navigation.i iVar = this.e;
            if (iVar instanceof androidx.navigation.j) {
                InterfaceC23384wp6<androidx.navigation.i> interfaceC23384wp6C = androidx.navigation.i.j.c(iVar);
                e eVar = this.f;
                for (androidx.navigation.i iVar2 : interfaceC23384wp6C) {
                    androidx.navigation.i iVarD = eVar.D();
                    if (AbstractC13042fc3.d(iVar2, iVarD != null ? iVarD.C() : null)) {
                        return;
                    }
                }
                if (e.I) {
                    nVar.c(androidx.navigation.j.p.a(this.f.F()).A(), b.e);
                }
            }
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((androidx.navigation.n) obj);
            return C19938rB7.a;
        }
    }

    static final class l extends AbstractC8614Ws3 implements SA2 {
        l() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final androidx.navigation.l invoke() {
            androidx.navigation.l lVar = e.this.c;
            return lVar == null ? new androidx.navigation.l(e.this.A(), e.this.x) : lVar;
        }
    }

    static final class m extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ C9663aL5 e;
        final /* synthetic */ e f;
        final /* synthetic */ androidx.navigation.i g;
        final /* synthetic */ Bundle h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        m(C9663aL5 c9663aL5, e eVar, androidx.navigation.i iVar, Bundle bundle) {
            super(1);
            this.e = c9663aL5;
            this.f = eVar;
            this.g = iVar;
            this.h = bundle;
        }

        public final void a(androidx.navigation.d dVar) {
            AbstractC13042fc3.i(dVar, "it");
            this.e.a = true;
            e.q(this.f, this.g, this.h, dVar, null, 8, null);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((androidx.navigation.d) obj);
            return C19938rB7.a;
        }
    }

    public static final class n extends AbstractC23070wI4 {
        n() {
            super(false);
        }

        @Override // ir.nasim.AbstractC23070wI4
        public void d() {
            e.this.V();
        }
    }

    static final class o extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ String e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        o(String str) {
            super(1);
            this.e = str;
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(String str) {
            return Boolean.valueOf(AbstractC13042fc3.d(str, this.e));
        }
    }

    public e(Context context) {
        Object next;
        AbstractC13042fc3.i(context, "context");
        this.a = context;
        Iterator it = AbstractC9962aq6.j(context, c.e).iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (((Context) next) instanceof Activity) {
                    break;
                }
            }
        }
        this.b = (Activity) next;
        this.h = new BJ();
        InterfaceC9336Zm4 interfaceC9336Zm4A = AbstractC12281eL6.a(AbstractC10360bX0.m());
        this.i = interfaceC9336Zm4A;
        this.j = AbstractC6459Nq2.c(interfaceC9336Zm4A);
        InterfaceC9336Zm4 interfaceC9336Zm4A2 = AbstractC12281eL6.a(AbstractC10360bX0.m());
        this.k = interfaceC9336Zm4A2;
        this.l = AbstractC6459Nq2.c(interfaceC9336Zm4A2);
        this.m = new LinkedHashMap();
        this.n = new LinkedHashMap();
        this.o = new LinkedHashMap();
        this.p = new LinkedHashMap();
        this.s = new CopyOnWriteArrayList();
        this.t = j.b.INITIALIZED;
        this.u = new androidx.lifecycle.n() { // from class: ir.nasim.Sp4
            @Override // androidx.lifecycle.n
            public final void s(InterfaceC18633oz3 interfaceC18633oz3, j.a aVar) {
                androidx.navigation.e.M(this.a, interfaceC18633oz3, aVar);
            }
        };
        this.v = new n();
        this.w = true;
        this.x = new q();
        this.y = new LinkedHashMap();
        this.B = new LinkedHashMap();
        q qVar = this.x;
        qVar.b(new androidx.navigation.k(qVar));
        this.x.b(new androidx.navigation.a(this.a));
        this.D = new ArrayList();
        this.E = AbstractC13269fw3.a(new l());
        InterfaceC8327Vm4 interfaceC8327Vm4B = AbstractC11420cy6.b(1, 0, EnumC6162Ml0.DROP_OLDEST, 2, null);
        this.F = interfaceC8327Vm4B;
        this.G = AbstractC6459Nq2.b(interfaceC8327Vm4B);
    }

    private final int E() {
        BJ bj = this.h;
        int i2 = 0;
        if (!(bj instanceof Collection) || !bj.isEmpty()) {
            Iterator<E> it = bj.iterator();
            while (it.hasNext()) {
                if ((!(((androidx.navigation.d) it.next()).e() instanceof androidx.navigation.j)) && (i2 = i2 + 1) < 0) {
                    AbstractC10360bX0.v();
                }
            }
        }
        return i2;
    }

    private final List K(BJ bj) throws Resources.NotFoundException {
        androidx.navigation.i iVarF;
        ArrayList arrayList = new ArrayList();
        androidx.navigation.d dVar = (androidx.navigation.d) this.h.P();
        if (dVar == null || (iVarF = dVar.e()) == null) {
            iVarF = F();
        }
        if (bj != null) {
            Iterator<E> it = bj.iterator();
            while (it.hasNext()) {
                NavBackStackEntryState navBackStackEntryState = (NavBackStackEntryState) it.next();
                androidx.navigation.i iVarW = w(iVarF, navBackStackEntryState.getDestinationId());
                if (iVarW == null) {
                    throw new IllegalStateException(("Restore State failed: destination " + androidx.navigation.i.j.b(this.a, navBackStackEntryState.getDestinationId()) + " cannot be found from the current destination " + iVarF).toString());
                }
                arrayList.add(navBackStackEntryState.c(this.a, iVarW, G(), this.r));
                iVarF = iVarW;
            }
        }
        return arrayList;
    }

    private final boolean L(androidx.navigation.i iVar, Bundle bundle) {
        androidx.navigation.i iVarE;
        int iNextIndex;
        androidx.navigation.d dVarB = B();
        int iA = iVar instanceof androidx.navigation.j ? androidx.navigation.j.p.a((androidx.navigation.j) iVar).A() : iVar.A();
        if (dVarB == null || (iVarE = dVarB.e()) == null || iA != iVarE.A()) {
            return false;
        }
        BJ<androidx.navigation.d> bj = new BJ();
        BJ bj2 = this.h;
        ListIterator<E> listIterator = bj2.listIterator(bj2.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                iNextIndex = -1;
                break;
            }
            if (((androidx.navigation.d) listIterator.previous()).e() == iVar) {
                iNextIndex = listIterator.nextIndex();
                break;
            }
        }
        while (AbstractC10360bX0.o(this.h) >= iNextIndex) {
            androidx.navigation.d dVar = (androidx.navigation.d) this.h.removeLast();
            n0(dVar);
            bj.addFirst(new androidx.navigation.d(dVar, dVar.e().o(bundle)));
        }
        for (androidx.navigation.d dVar2 : bj) {
            androidx.navigation.j jVarC = dVar2.e().C();
            if (jVarC != null) {
                N(dVar2, y(jVarC.A()));
            }
            this.h.add(dVar2);
        }
        for (androidx.navigation.d dVar3 : bj) {
            this.x.e(dVar3.e().B()).g(dVar3);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M(e eVar, InterfaceC18633oz3 interfaceC18633oz3, j.a aVar) {
        AbstractC13042fc3.i(eVar, "this$0");
        AbstractC13042fc3.i(interfaceC18633oz3, "<anonymous parameter 0>");
        AbstractC13042fc3.i(aVar, "event");
        eVar.t = aVar.j();
        if (eVar.d != null) {
            Iterator<E> it = eVar.h.iterator();
            while (it.hasNext()) {
                ((androidx.navigation.d) it.next()).h(aVar);
            }
        }
    }

    private final void N(androidx.navigation.d dVar, androidx.navigation.d dVar2) {
        this.m.put(dVar, dVar2);
        if (this.n.get(dVar2) == null) {
            this.n.put(dVar2, new AtomicInteger(0));
        }
        Object obj = this.n.get(dVar2);
        AbstractC13042fc3.f(obj);
        ((AtomicInteger) obj).incrementAndGet();
    }

    private final void P(androidx.navigation.i iVar, Bundle bundle, androidx.navigation.m mVar, p.a aVar) throws Resources.NotFoundException {
        boolean z;
        boolean z2;
        boolean zA0;
        Iterator it = this.y.values().iterator();
        while (it.hasNext()) {
            ((b) it.next()).k(true);
        }
        C9663aL5 c9663aL5 = new C9663aL5();
        if (mVar == null) {
            z = false;
        } else {
            if (mVar.f() != null) {
                String strF = mVar.f();
                AbstractC13042fc3.f(strF);
                zA0 = b0(strF, mVar.g(), mVar.i());
            } else {
                if (mVar.e() != -1) {
                    zA0 = a0(mVar.e(), mVar.g(), mVar.i());
                }
                z = false;
            }
            z = zA0;
        }
        Bundle bundleO = iVar.o(bundle);
        if (mVar != null && mVar.j() && this.o.containsKey(Integer.valueOf(iVar.A()))) {
            c9663aL5.a = h0(iVar.A(), bundleO, mVar, aVar);
            z2 = false;
        } else {
            z2 = mVar != null && mVar.h() && L(iVar, bundle);
            if (!z2) {
                T(this.x.e(iVar.B()), AbstractC9766aX0.e(d.a.b(androidx.navigation.d.o, this.a, iVar, bundleO, G(), this.r, null, null, 96, null)), mVar, aVar, new m(c9663aL5, this, iVar, bundleO));
            }
        }
        p0();
        Iterator it2 = this.y.values().iterator();
        while (it2.hasNext()) {
            ((b) it2.next()).k(false);
        }
        if (z || c9663aL5.a || z2) {
            s();
        } else {
            o0();
        }
    }

    public static /* synthetic */ void S(e eVar, String str, androidx.navigation.m mVar, p.a aVar, int i2, Object obj) throws Resources.NotFoundException {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: navigate");
        }
        if ((i2 & 2) != 0) {
            mVar = null;
        }
        if ((i2 & 4) != 0) {
            aVar = null;
        }
        eVar.Q(str, mVar, aVar);
    }

    private final void T(p pVar, List list, androidx.navigation.m mVar, p.a aVar, UA2 ua2) {
        this.z = ua2;
        pVar.e(list, mVar, aVar);
        this.z = null;
    }

    private final void U(Bundle bundle) throws Resources.NotFoundException {
        Activity activity;
        ArrayList<String> stringArrayList;
        Bundle bundle2 = this.e;
        if (bundle2 != null && (stringArrayList = bundle2.getStringArrayList("android-support-nav:controller:navigatorState:names")) != null) {
            Iterator<String> it = stringArrayList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                q qVar = this.x;
                AbstractC13042fc3.h(next, "name");
                p pVarE = qVar.e(next);
                Bundle bundle3 = bundle2.getBundle(next);
                if (bundle3 != null) {
                    pVarE.h(bundle3);
                }
            }
        }
        Parcelable[] parcelableArr = this.f;
        if (parcelableArr != null) {
            for (Parcelable parcelable : parcelableArr) {
                AbstractC13042fc3.g(parcelable, "null cannot be cast to non-null type androidx.navigation.NavBackStackEntryState");
                NavBackStackEntryState navBackStackEntryState = (NavBackStackEntryState) parcelable;
                androidx.navigation.i iVarV = v(navBackStackEntryState.getDestinationId());
                if (iVarV == null) {
                    throw new IllegalStateException("Restoring the Navigation back stack failed: destination " + androidx.navigation.i.j.b(this.a, navBackStackEntryState.getDestinationId()) + " cannot be found from the current destination " + D());
                }
                androidx.navigation.d dVarC = navBackStackEntryState.c(this.a, iVarV, G(), this.r);
                p pVarE2 = this.x.e(iVarV.B());
                Map map = this.y;
                Object bVar = map.get(pVarE2);
                if (bVar == null) {
                    bVar = new b(this, pVarE2);
                    map.put(pVarE2, bVar);
                }
                this.h.add(dVarC);
                ((b) bVar).m(dVarC);
                androidx.navigation.j jVarC = dVarC.e().C();
                if (jVarC != null) {
                    N(dVarC, y(jVarC.A()));
                }
            }
            p0();
            this.f = null;
        }
        Collection collectionValues = this.x.f().values();
        ArrayList<p> arrayList = new ArrayList();
        for (Object obj : collectionValues) {
            if (!((p) obj).c()) {
                arrayList.add(obj);
            }
        }
        for (p pVar : arrayList) {
            Map map2 = this.y;
            Object bVar2 = map2.get(pVar);
            if (bVar2 == null) {
                bVar2 = new b(this, pVar);
                map2.put(pVar, bVar2);
            }
            pVar.f((b) bVar2);
        }
        if (this.d == null || !this.h.isEmpty()) {
            s();
            return;
        }
        if (!this.g && (activity = this.b) != null) {
            AbstractC13042fc3.f(activity);
            if (J(activity.getIntent())) {
                return;
            }
        }
        androidx.navigation.j jVar = this.d;
        AbstractC13042fc3.f(jVar);
        P(jVar, bundle, null, null);
    }

    private final void Z(p pVar, androidx.navigation.d dVar, boolean z, UA2 ua2) {
        this.A = ua2;
        pVar.j(dVar, z);
        this.A = null;
    }

    private final boolean a0(int i2, boolean z, boolean z2) throws Resources.NotFoundException {
        androidx.navigation.i iVarE;
        if (this.h.isEmpty()) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = AbstractC15401jX0.T0(this.h).iterator();
        while (true) {
            if (!it.hasNext()) {
                iVarE = null;
                break;
            }
            iVarE = ((androidx.navigation.d) it.next()).e();
            p pVarE = this.x.e(iVarE.B());
            if (z || iVarE.A() != i2) {
                arrayList.add(pVarE);
            }
            if (iVarE.A() == i2) {
                break;
            }
        }
        if (iVarE != null) {
            return t(arrayList, iVarE, z, z2);
        }
        Log.i("NavController", "Ignoring popBackStack to destination " + androidx.navigation.i.j.b(this.a, i2) + " as it was not found on the current back stack");
        return false;
    }

    private final boolean b0(String str, boolean z, boolean z2) {
        Object objPrevious;
        if (this.h.isEmpty()) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        BJ bj = this.h;
        ListIterator<E> listIterator = bj.listIterator(bj.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                objPrevious = null;
                break;
            }
            objPrevious = listIterator.previous();
            androidx.navigation.d dVar = (androidx.navigation.d) objPrevious;
            boolean zI = dVar.e().I(str, dVar.c());
            if (z || !zI) {
                arrayList.add(this.x.e(dVar.e().B()));
            }
            if (zI) {
                break;
            }
        }
        androidx.navigation.d dVar2 = (androidx.navigation.d) objPrevious;
        androidx.navigation.i iVarE = dVar2 != null ? dVar2.e() : null;
        if (iVarE != null) {
            return t(arrayList, iVarE, z, z2);
        }
        Log.i("NavController", "Ignoring popBackStack to route " + str + " as it was not found on the current back stack");
        return false;
    }

    static /* synthetic */ boolean c0(e eVar, int i2, boolean z, boolean z2, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: popBackStackInternal");
        }
        if ((i3 & 4) != 0) {
            z2 = false;
        }
        return eVar.a0(i2, z, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d0(androidx.navigation.d dVar, boolean z, BJ bj) {
        androidx.navigation.f fVar;
        InterfaceC10258bL6 interfaceC10258bL6C;
        Set set;
        androidx.navigation.d dVar2 = (androidx.navigation.d) this.h.last();
        if (!AbstractC13042fc3.d(dVar2, dVar)) {
            throw new IllegalStateException(("Attempted to pop " + dVar.e() + ", which is not the top of the back stack (" + dVar2.e() + ')').toString());
        }
        this.h.removeLast();
        b bVar = (b) this.y.get(H().e(dVar2.e().B()));
        boolean z2 = true;
        if ((bVar == null || (interfaceC10258bL6C = bVar.c()) == null || (set = (Set) interfaceC10258bL6C.getValue()) == null || !set.contains(dVar2)) && !this.n.containsKey(dVar2)) {
            z2 = false;
        }
        j.b bVarB = dVar2.getLifecycle().b();
        j.b bVar2 = j.b.CREATED;
        if (bVarB.j(bVar2)) {
            if (z) {
                dVar2.k(bVar2);
                bj.addFirst(new NavBackStackEntryState(dVar2));
            }
            if (z2) {
                dVar2.k(bVar2);
            } else {
                dVar2.k(j.b.DESTROYED);
                n0(dVar2);
            }
        }
        if (z || z2 || (fVar = this.r) == null) {
            return;
        }
        fVar.R0(dVar2.f());
    }

    static /* synthetic */ void e0(e eVar, androidx.navigation.d dVar, boolean z, BJ bj, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: popEntryFromBackStack");
        }
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            bj = new BJ();
        }
        eVar.d0(dVar, z, bj);
    }

    private final boolean h0(int i2, Bundle bundle, androidx.navigation.m mVar, p.a aVar) {
        if (!this.o.containsKey(Integer.valueOf(i2))) {
            return false;
        }
        String str = (String) this.o.get(Integer.valueOf(i2));
        AbstractC13610gX0.I(this.o.values(), new o(str));
        return u(K((BJ) AbstractC19810qy7.d(this.p).remove(str)), bundle, mVar, aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p(androidx.navigation.i iVar, Bundle bundle, androidx.navigation.d dVar, List list) {
        BJ<androidx.navigation.d> bj;
        androidx.navigation.i iVar2;
        androidx.navigation.d dVar2;
        Bundle bundle2;
        boolean z;
        Object objPrevious;
        androidx.navigation.j jVar;
        Object objPrevious2;
        List list2;
        Bundle bundle3;
        Bundle bundle4 = bundle;
        androidx.navigation.d dVar3 = dVar;
        List list3 = list;
        androidx.navigation.i iVarE = dVar.e();
        if (!(iVarE instanceof InterfaceC3621Bq2)) {
            while (!this.h.isEmpty() && (((androidx.navigation.d) this.h.last()).e() instanceof InterfaceC3621Bq2) && c0(this, ((androidx.navigation.d) this.h.last()).e().A(), true, false, 4, null)) {
            }
        }
        BJ bj2 = new BJ();
        boolean z2 = true;
        Object obj = null;
        if (iVar instanceof androidx.navigation.j) {
            androidx.navigation.i iVar3 = iVarE;
            while (true) {
                AbstractC13042fc3.f(iVar3);
                androidx.navigation.j jVarC = iVar3.C();
                if (jVarC != null) {
                    ListIterator listIterator = list3.listIterator(list.size());
                    while (true) {
                        if (listIterator.hasPrevious()) {
                            objPrevious2 = listIterator.previous();
                            if (AbstractC13042fc3.d(((androidx.navigation.d) objPrevious2).e(), jVarC)) {
                                break;
                            }
                        } else {
                            objPrevious2 = null;
                            break;
                        }
                    }
                    androidx.navigation.d dVarB = (androidx.navigation.d) objPrevious2;
                    if (dVarB == null) {
                        iVar2 = iVarE;
                        list2 = list3;
                        bundle3 = bundle4;
                        dVar2 = dVar3;
                        dVarB = d.a.b(androidx.navigation.d.o, this.a, jVarC, bundle, G(), this.r, null, null, 96, null);
                    } else {
                        iVar2 = iVarE;
                        list2 = list3;
                        dVar2 = dVar3;
                        bundle3 = bundle4;
                    }
                    bj2.addFirst(dVarB);
                    if ((this.h.isEmpty() ^ z2) && ((androidx.navigation.d) this.h.last()).e() == jVarC) {
                        list3 = list2;
                        bundle2 = bundle3;
                        jVar = jVarC;
                        z = z2;
                        bj = bj2;
                        e0(this, (androidx.navigation.d) this.h.last(), false, null, 6, null);
                    } else {
                        list3 = list2;
                        bundle2 = bundle3;
                        jVar = jVarC;
                        z = z2;
                        bj = bj2;
                    }
                } else {
                    jVar = jVarC;
                    bj = bj2;
                    iVar2 = iVarE;
                    dVar2 = dVar3;
                    bundle2 = bundle4;
                    z = z2;
                }
                if (jVar == null || jVar == iVar) {
                    break;
                }
                bj2 = bj;
                iVar3 = jVar;
                z2 = z;
                bundle4 = bundle2;
                iVarE = iVar2;
                dVar3 = dVar2;
            }
        } else {
            bj = bj2;
            iVar2 = iVarE;
            dVar2 = dVar3;
            bundle2 = bundle4;
            z = true;
        }
        androidx.navigation.i iVarE2 = bj.isEmpty() ? iVar2 : ((androidx.navigation.d) bj.first()).e();
        while (iVarE2 != null && v(iVarE2.A()) != iVarE2) {
            iVarE2 = iVarE2.C();
            if (iVarE2 != null) {
                Bundle bundle5 = (bundle2 == null || bundle.isEmpty() != z) ? bundle2 : null;
                ListIterator listIterator2 = list3.listIterator(list.size());
                while (true) {
                    if (listIterator2.hasPrevious()) {
                        objPrevious = listIterator2.previous();
                        if (AbstractC13042fc3.d(((androidx.navigation.d) objPrevious).e(), iVarE2)) {
                            break;
                        }
                    } else {
                        objPrevious = null;
                        break;
                    }
                }
                androidx.navigation.d dVarB2 = (androidx.navigation.d) objPrevious;
                if (dVarB2 == null) {
                    dVarB2 = d.a.b(androidx.navigation.d.o, this.a, iVarE2, iVarE2.o(bundle5), G(), this.r, null, null, 96, null);
                }
                bj.addFirst(dVarB2);
            }
        }
        androidx.navigation.i iVarE3 = bj.isEmpty() ? iVar2 : ((androidx.navigation.d) bj.first()).e();
        while (!this.h.isEmpty() && (((androidx.navigation.d) this.h.last()).e() instanceof androidx.navigation.j)) {
            androidx.navigation.i iVarE4 = ((androidx.navigation.d) this.h.last()).e();
            AbstractC13042fc3.g(iVarE4, "null cannot be cast to non-null type androidx.navigation.NavGraph");
            if (((androidx.navigation.j) iVarE4).a0(iVarE3.A(), false) != null) {
                break;
            } else {
                e0(this, (androidx.navigation.d) this.h.last(), false, null, 6, null);
            }
        }
        androidx.navigation.d dVar4 = (androidx.navigation.d) this.h.N();
        if (dVar4 == null) {
            dVar4 = (androidx.navigation.d) bj.N();
        }
        if (!AbstractC13042fc3.d(dVar4 != null ? dVar4.e() : null, this.d)) {
            ListIterator listIterator3 = list3.listIterator(list.size());
            while (true) {
                if (!listIterator3.hasPrevious()) {
                    break;
                }
                Object objPrevious3 = listIterator3.previous();
                androidx.navigation.i iVarE5 = ((androidx.navigation.d) objPrevious3).e();
                androidx.navigation.j jVar2 = this.d;
                AbstractC13042fc3.f(jVar2);
                if (AbstractC13042fc3.d(iVarE5, jVar2)) {
                    obj = objPrevious3;
                    break;
                }
            }
            androidx.navigation.d dVarB3 = (androidx.navigation.d) obj;
            if (dVarB3 == null) {
                d.a aVar = androidx.navigation.d.o;
                Context context = this.a;
                androidx.navigation.j jVar3 = this.d;
                AbstractC13042fc3.f(jVar3);
                androidx.navigation.j jVar4 = this.d;
                AbstractC13042fc3.f(jVar4);
                dVarB3 = d.a.b(aVar, context, jVar3, jVar4.o(bundle2), G(), this.r, null, null, 96, null);
            }
            bj.addFirst(dVarB3);
        }
        for (androidx.navigation.d dVar5 : bj) {
            Object obj2 = this.y.get(this.x.e(dVar5.e().B()));
            if (obj2 == null) {
                throw new IllegalStateException(("NavigatorBackStack for " + iVar.B() + " should already be created").toString());
            }
            ((b) obj2).m(dVar5);
        }
        this.h.addAll(bj);
        this.h.add(dVar2);
        for (androidx.navigation.d dVar6 : AbstractC15401jX0.S0(bj, dVar2)) {
            androidx.navigation.j jVarC2 = dVar6.e().C();
            if (jVarC2 != null) {
                N(dVar6, y(jVarC2.A()));
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x000e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void p0() {
        /*
            r3 = this;
            ir.nasim.wI4 r0 = r3.v
            boolean r1 = r3.w
            if (r1 == 0) goto Le
            int r1 = r3.E()
            r2 = 1
            if (r1 <= r2) goto Le
            goto Lf
        Le:
            r2 = 0
        Lf:
            r0.j(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.e.p0():void");
    }

    static /* synthetic */ void q(e eVar, androidx.navigation.i iVar, Bundle bundle, androidx.navigation.d dVar, List list, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addEntryToBackStack");
        }
        if ((i2 & 8) != 0) {
            list = AbstractC10360bX0.m();
        }
        eVar.p(iVar, bundle, dVar, list);
    }

    private final boolean r(int i2) {
        Iterator it = this.y.values().iterator();
        while (it.hasNext()) {
            ((b) it.next()).k(true);
        }
        boolean zH0 = h0(i2, null, AbstractC9363Zp4.a(d.e), null);
        Iterator it2 = this.y.values().iterator();
        while (it2.hasNext()) {
            ((b) it2.next()).k(false);
        }
        return zH0 && a0(i2, true, false);
    }

    private final boolean s() {
        while (!this.h.isEmpty() && (((androidx.navigation.d) this.h.last()).e() instanceof androidx.navigation.j)) {
            e0(this, (androidx.navigation.d) this.h.last(), false, null, 6, null);
        }
        androidx.navigation.d dVar = (androidx.navigation.d) this.h.P();
        if (dVar != null) {
            this.D.add(dVar);
        }
        this.C++;
        o0();
        int i2 = this.C - 1;
        this.C = i2;
        if (i2 == 0) {
            List<androidx.navigation.d> listP1 = AbstractC15401jX0.p1(this.D);
            this.D.clear();
            for (androidx.navigation.d dVar2 : listP1) {
                Iterator it = this.s.iterator();
                if (it.hasNext()) {
                    AbstractC18350oW3.a(it.next());
                    dVar2.e();
                    dVar2.c();
                    throw null;
                }
                this.F.c(dVar2);
            }
            this.i.c(AbstractC15401jX0.p1(this.h));
            this.k.c(f0());
        }
        return dVar != null;
    }

    private final boolean t(List list, androidx.navigation.i iVar, boolean z, boolean z2) {
        C9663aL5 c9663aL5 = new C9663aL5();
        BJ bj = new BJ();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            p pVar = (p) it.next();
            C9663aL5 c9663aL52 = new C9663aL5();
            Z(pVar, (androidx.navigation.d) this.h.last(), z2, new C0101e(c9663aL52, c9663aL5, this, z2, bj));
            if (!c9663aL52.a) {
                break;
            }
        }
        if (z2) {
            if (!z) {
                for (androidx.navigation.i iVar2 : AbstractC11342cq6.I(AbstractC9962aq6.j(iVar, f.e), new g())) {
                    Map map = this.o;
                    Integer numValueOf = Integer.valueOf(iVar2.A());
                    NavBackStackEntryState navBackStackEntryState = (NavBackStackEntryState) bj.N();
                    map.put(numValueOf, navBackStackEntryState != null ? navBackStackEntryState.getId() : null);
                }
            }
            if (!bj.isEmpty()) {
                NavBackStackEntryState navBackStackEntryState2 = (NavBackStackEntryState) bj.first();
                Iterator it2 = AbstractC11342cq6.I(AbstractC9962aq6.j(v(navBackStackEntryState2.getDestinationId()), h.e), new i()).iterator();
                while (it2.hasNext()) {
                    this.o.put(Integer.valueOf(((androidx.navigation.i) it2.next()).A()), navBackStackEntryState2.getId());
                }
                if (this.o.values().contains(navBackStackEntryState2.getId())) {
                    this.p.put(navBackStackEntryState2.getId(), bj);
                }
            }
        }
        p0();
        return c9663aL5.a;
    }

    private final boolean u(List list, Bundle bundle, androidx.navigation.m mVar, p.a aVar) {
        androidx.navigation.d dVar;
        androidx.navigation.i iVarE;
        ArrayList<List> arrayList = new ArrayList();
        ArrayList<androidx.navigation.d> arrayList2 = new ArrayList();
        for (Object obj : list) {
            if (!(((androidx.navigation.d) obj).e() instanceof androidx.navigation.j)) {
                arrayList2.add(obj);
            }
        }
        for (androidx.navigation.d dVar2 : arrayList2) {
            List list2 = (List) AbstractC15401jX0.F0(arrayList);
            if (AbstractC13042fc3.d((list2 == null || (dVar = (androidx.navigation.d) AbstractC15401jX0.C0(list2)) == null || (iVarE = dVar.e()) == null) ? null : iVarE.B(), dVar2.e().B())) {
                list2.add(dVar2);
            } else {
                arrayList.add(AbstractC10360bX0.s(dVar2));
            }
        }
        C9663aL5 c9663aL5 = new C9663aL5();
        for (List list3 : arrayList) {
            T(this.x.e(((androidx.navigation.d) AbstractC15401jX0.q0(list3)).e().B()), list3, mVar, aVar, new j(c9663aL5, list, new C11637dL5(), this, bundle));
        }
        return c9663aL5.a;
    }

    private final androidx.navigation.i w(androidx.navigation.i iVar, int i2) {
        androidx.navigation.j jVarC;
        if (iVar.A() == i2) {
            return iVar;
        }
        if (iVar instanceof androidx.navigation.j) {
            jVarC = (androidx.navigation.j) iVar;
        } else {
            jVarC = iVar.C();
            AbstractC13042fc3.f(jVarC);
        }
        return jVarC.Z(i2);
    }

    private final String x(int[] iArr) {
        androidx.navigation.j jVar;
        androidx.navigation.j jVar2 = this.d;
        int length = iArr.length;
        int i2 = 0;
        while (true) {
            androidx.navigation.i iVarZ = null;
            if (i2 >= length) {
                return null;
            }
            int i3 = iArr[i2];
            if (i2 == 0) {
                androidx.navigation.j jVar3 = this.d;
                AbstractC13042fc3.f(jVar3);
                if (jVar3.A() == i3) {
                    iVarZ = this.d;
                }
            } else {
                AbstractC13042fc3.f(jVar2);
                iVarZ = jVar2.Z(i3);
            }
            if (iVarZ == null) {
                return androidx.navigation.i.j.b(this.a, i3);
            }
            if (i2 != iArr.length - 1 && (iVarZ instanceof androidx.navigation.j)) {
                while (true) {
                    jVar = (androidx.navigation.j) iVarZ;
                    AbstractC13042fc3.f(jVar);
                    if (!(jVar.Z(jVar.g0()) instanceof androidx.navigation.j)) {
                        break;
                    }
                    iVarZ = jVar.Z(jVar.g0());
                }
                jVar2 = jVar;
            }
            i2++;
        }
    }

    public final Context A() {
        return this.a;
    }

    public androidx.navigation.d B() {
        return (androidx.navigation.d) this.h.P();
    }

    public final InterfaceC4557Fq2 C() {
        return this.G;
    }

    public androidx.navigation.i D() {
        androidx.navigation.d dVarB = B();
        if (dVarB != null) {
            return dVarB.e();
        }
        return null;
    }

    public androidx.navigation.j F() {
        androidx.navigation.j jVar = this.d;
        if (jVar == null) {
            throw new IllegalStateException("You must call setGraph() before calling getGraph()".toString());
        }
        AbstractC13042fc3.g(jVar, "null cannot be cast to non-null type androidx.navigation.NavGraph");
        return jVar;
    }

    public final j.b G() {
        return this.q == null ? j.b.CREATED : this.t;
    }

    public q H() {
        return this.x;
    }

    public final InterfaceC10258bL6 I() {
        return this.l;
    }

    public boolean J(Intent intent) throws Resources.NotFoundException {
        int[] intArray;
        androidx.navigation.i iVarZ;
        androidx.navigation.j jVar;
        Bundle bundle;
        int i2 = 0;
        if (intent == null) {
            return false;
        }
        Bundle extras = intent.getExtras();
        if (extras != null) {
            try {
                intArray = extras.getIntArray("android-support-nav:controller:deepLinkIds");
            } catch (Exception e) {
                Log.e("NavController", "handleDeepLink() could not extract deepLink from " + intent, e);
            }
        } else {
            intArray = null;
        }
        ArrayList parcelableArrayList = extras != null ? extras.getParcelableArrayList("android-support-nav:controller:deepLinkArgs") : null;
        Bundle bundle2 = new Bundle();
        Bundle bundle3 = extras != null ? extras.getBundle("android-support-nav:controller:deepLinkExtras") : null;
        if (bundle3 != null) {
            bundle2.putAll(bundle3);
        }
        if (intArray == null || intArray.length == 0) {
            androidx.navigation.j jVar2 = this.d;
            AbstractC13042fc3.f(jVar2);
            i.b bVarL = jVar2.L(new androidx.navigation.h(intent));
            if (bVarL != null) {
                androidx.navigation.i iVarH = bVarL.h();
                int[] iArrV = androidx.navigation.i.v(iVarH, null, 1, null);
                Bundle bundleO = iVarH.o(bVarL.i());
                if (bundleO != null) {
                    bundle2.putAll(bundleO);
                }
                intArray = iArrV;
                parcelableArrayList = null;
            }
        }
        if (intArray == null || intArray.length == 0) {
            return false;
        }
        String strX = x(intArray);
        if (strX != null) {
            Log.i("NavController", "Could not find destination " + strX + " in the navigation graph, ignoring the deep link from " + intent);
            return false;
        }
        bundle2.putParcelable("android-support-nav:controller:deepLinkIntent", intent);
        int length = intArray.length;
        Bundle[] bundleArr = new Bundle[length];
        for (int i3 = 0; i3 < length; i3++) {
            Bundle bundle4 = new Bundle();
            bundle4.putAll(bundle2);
            if (parcelableArrayList != null && (bundle = (Bundle) parcelableArrayList.get(i3)) != null) {
                bundle4.putAll(bundle);
            }
            bundleArr[i3] = bundle4;
        }
        int flags = intent.getFlags();
        int i4 = 268435456 & flags;
        if (i4 != 0 && (flags & 32768) == 0) {
            intent.addFlags(32768);
            C6650Oj7 c6650Oj7H = C6650Oj7.o(this.a).h(intent);
            AbstractC13042fc3.h(c6650Oj7H, "create(context)\n        …ntWithParentStack(intent)");
            c6650Oj7H.r();
            Activity activity = this.b;
            if (activity != null) {
                activity.finish();
                activity.overridePendingTransition(0, 0);
            }
            return true;
        }
        if (i4 != 0) {
            if (!this.h.isEmpty()) {
                androidx.navigation.j jVar3 = this.d;
                AbstractC13042fc3.f(jVar3);
                c0(this, jVar3.A(), true, false, 4, null);
            }
            while (i2 < intArray.length) {
                int i5 = intArray[i2];
                int i6 = i2 + 1;
                Bundle bundle5 = bundleArr[i2];
                androidx.navigation.i iVarV = v(i5);
                if (iVarV == null) {
                    throw new IllegalStateException("Deep Linking failed: destination " + androidx.navigation.i.j.b(this.a, i5) + " cannot be found from the current destination " + D());
                }
                P(iVarV, bundle5, AbstractC9363Zp4.a(new k(iVarV, this)), null);
                i2 = i6;
            }
            this.g = true;
            return true;
        }
        androidx.navigation.j jVar4 = this.d;
        int length2 = intArray.length;
        for (int i7 = 0; i7 < length2; i7++) {
            int i8 = intArray[i7];
            Bundle bundle6 = bundleArr[i7];
            if (i7 == 0) {
                iVarZ = this.d;
            } else {
                AbstractC13042fc3.f(jVar4);
                iVarZ = jVar4.Z(i8);
            }
            if (iVarZ == null) {
                throw new IllegalStateException("Deep Linking failed: destination " + androidx.navigation.i.j.b(this.a, i8) + " cannot be found in graph " + jVar4);
            }
            if (i7 == intArray.length - 1) {
                m.a aVar = new m.a();
                androidx.navigation.j jVar5 = this.d;
                AbstractC13042fc3.f(jVar5);
                P(iVarZ, bundle6, m.a.i(aVar, jVar5.A(), true, false, 4, null).b(0).c(0).a(), null);
            } else if (iVarZ instanceof androidx.navigation.j) {
                while (true) {
                    jVar = (androidx.navigation.j) iVarZ;
                    AbstractC13042fc3.f(jVar);
                    if (!(jVar.Z(jVar.g0()) instanceof androidx.navigation.j)) {
                        break;
                    }
                    iVarZ = jVar.Z(jVar.g0());
                }
                jVar4 = jVar;
            }
        }
        this.g = true;
        return true;
    }

    public void O(androidx.navigation.h hVar, androidx.navigation.m mVar, p.a aVar) throws Resources.NotFoundException {
        AbstractC13042fc3.i(hVar, "request");
        androidx.navigation.j jVar = this.d;
        if (jVar == null) {
            throw new IllegalArgumentException(("Cannot navigate to " + hVar + ". Navigation graph has not been set for NavController " + this + '.').toString());
        }
        AbstractC13042fc3.f(jVar);
        i.b bVarL = jVar.L(hVar);
        if (bVarL == null) {
            throw new IllegalArgumentException("Navigation destination that matches request " + hVar + " cannot be found in the navigation graph " + this.d);
        }
        Bundle bundleO = bVarL.h().o(bVarL.i());
        if (bundleO == null) {
            bundleO = new Bundle();
        }
        androidx.navigation.i iVarH = bVarL.h();
        Intent intent = new Intent();
        intent.setDataAndType(hVar.c(), hVar.b());
        intent.setAction(hVar.a());
        bundleO.putParcelable("android-support-nav:controller:deepLinkIntent", intent);
        P(iVarH, bundleO, mVar, aVar);
    }

    public final void Q(String str, androidx.navigation.m mVar, p.a aVar) throws Resources.NotFoundException {
        AbstractC13042fc3.i(str, "route");
        h.a.C0104a c0104a = h.a.d;
        Uri uri = Uri.parse(androidx.navigation.i.j.a(str));
        AbstractC13042fc3.e(uri, "Uri.parse(this)");
        O(c0104a.a(uri).a(), mVar, aVar);
    }

    public final void R(String str, UA2 ua2) throws Resources.NotFoundException {
        AbstractC13042fc3.i(str, "route");
        AbstractC13042fc3.i(ua2, "builder");
        S(this, str, AbstractC9363Zp4.a(ua2), null, 4, null);
    }

    public boolean V() {
        if (this.h.isEmpty()) {
            return false;
        }
        androidx.navigation.i iVarD = D();
        AbstractC13042fc3.f(iVarD);
        return W(iVarD.A(), true);
    }

    public boolean W(int i2, boolean z) {
        return X(i2, z, false);
    }

    public boolean X(int i2, boolean z, boolean z2) {
        return a0(i2, z, z2) && s();
    }

    public final void Y(androidx.navigation.d dVar, SA2 sa2) throws Resources.NotFoundException {
        AbstractC13042fc3.i(dVar, "popUpTo");
        AbstractC13042fc3.i(sa2, "onComplete");
        int iIndexOf = this.h.indexOf(dVar);
        if (iIndexOf < 0) {
            Log.i("NavController", "Ignoring pop of " + dVar + " as it was not found on the current back stack");
            return;
        }
        int i2 = iIndexOf + 1;
        if (i2 != this.h.size()) {
            a0(((androidx.navigation.d) this.h.get(i2)).e().A(), true, false);
        }
        e0(this, dVar, false, null, 6, null);
        sa2.invoke();
        p0();
        s();
    }

    public final List f0() {
        ArrayList arrayList = new ArrayList();
        Iterator it = this.y.values().iterator();
        while (it.hasNext()) {
            Iterable iterable = (Iterable) ((b) it.next()).c().getValue();
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : iterable) {
                androidx.navigation.d dVar = (androidx.navigation.d) obj;
                if (!arrayList.contains(dVar) && !dVar.g().j(j.b.STARTED)) {
                    arrayList2.add(obj);
                }
            }
            AbstractC13610gX0.D(arrayList, arrayList2);
        }
        BJ bj = this.h;
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : bj) {
            androidx.navigation.d dVar2 = (androidx.navigation.d) obj2;
            if (!arrayList.contains(dVar2) && dVar2.g().j(j.b.STARTED)) {
                arrayList3.add(obj2);
            }
        }
        AbstractC13610gX0.D(arrayList, arrayList3);
        ArrayList arrayList4 = new ArrayList();
        for (Object obj3 : arrayList) {
            if (!(((androidx.navigation.d) obj3).e() instanceof androidx.navigation.j)) {
                arrayList4.add(obj3);
            }
        }
        return arrayList4;
    }

    public void g0(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        bundle.setClassLoader(this.a.getClassLoader());
        this.e = bundle.getBundle("android-support-nav:controller:navigatorState");
        this.f = bundle.getParcelableArray("android-support-nav:controller:backStack");
        this.p.clear();
        int[] intArray = bundle.getIntArray("android-support-nav:controller:backStackDestIds");
        ArrayList<String> stringArrayList = bundle.getStringArrayList("android-support-nav:controller:backStackIds");
        if (intArray != null && stringArrayList != null) {
            int length = intArray.length;
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                this.o.put(Integer.valueOf(intArray[i2]), stringArrayList.get(i3));
                i2++;
                i3++;
            }
        }
        ArrayList<String> stringArrayList2 = bundle.getStringArrayList("android-support-nav:controller:backStackStates");
        if (stringArrayList2 != null) {
            for (String str : stringArrayList2) {
                Parcelable[] parcelableArray = bundle.getParcelableArray("android-support-nav:controller:backStackStates:" + str);
                if (parcelableArray != null) {
                    Map map = this.p;
                    AbstractC13042fc3.h(str, "id");
                    BJ bj = new BJ(parcelableArray.length);
                    Iterator itA = DJ.a(parcelableArray);
                    while (itA.hasNext()) {
                        Parcelable parcelable = (Parcelable) itA.next();
                        AbstractC13042fc3.g(parcelable, "null cannot be cast to non-null type androidx.navigation.NavBackStackEntryState");
                        bj.add((NavBackStackEntryState) parcelable);
                    }
                    map.put(str, bj);
                }
            }
        }
        this.g = bundle.getBoolean("android-support-nav:controller:deepLinkHandled");
    }

    public Bundle i0() {
        Bundle bundle;
        ArrayList<String> arrayList = new ArrayList<>();
        Bundle bundle2 = new Bundle();
        for (Map.Entry entry : this.x.f().entrySet()) {
            String str = (String) entry.getKey();
            Bundle bundleI = ((p) entry.getValue()).i();
            if (bundleI != null) {
                arrayList.add(str);
                bundle2.putBundle(str, bundleI);
            }
        }
        if (!arrayList.isEmpty()) {
            bundle = new Bundle();
            bundle2.putStringArrayList("android-support-nav:controller:navigatorState:names", arrayList);
            bundle.putBundle("android-support-nav:controller:navigatorState", bundle2);
        } else {
            bundle = null;
        }
        if (!this.h.isEmpty()) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            Parcelable[] parcelableArr = new Parcelable[this.h.size()];
            Iterator<E> it = this.h.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                parcelableArr[i2] = new NavBackStackEntryState((androidx.navigation.d) it.next());
                i2++;
            }
            bundle.putParcelableArray("android-support-nav:controller:backStack", parcelableArr);
        }
        if (!this.o.isEmpty()) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            int[] iArr = new int[this.o.size()];
            ArrayList<String> arrayList2 = new ArrayList<>();
            int i3 = 0;
            for (Map.Entry entry2 : this.o.entrySet()) {
                int iIntValue = ((Number) entry2.getKey()).intValue();
                String str2 = (String) entry2.getValue();
                iArr[i3] = iIntValue;
                arrayList2.add(str2);
                i3++;
            }
            bundle.putIntArray("android-support-nav:controller:backStackDestIds", iArr);
            bundle.putStringArrayList("android-support-nav:controller:backStackIds", arrayList2);
        }
        if (!this.p.isEmpty()) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            ArrayList<String> arrayList3 = new ArrayList<>();
            for (Map.Entry entry3 : this.p.entrySet()) {
                String str3 = (String) entry3.getKey();
                BJ bj = (BJ) entry3.getValue();
                arrayList3.add(str3);
                Parcelable[] parcelableArr2 = new Parcelable[bj.size()];
                int i4 = 0;
                for (Object obj : bj) {
                    int i5 = i4 + 1;
                    if (i4 < 0) {
                        AbstractC10360bX0.w();
                    }
                    parcelableArr2[i4] = (NavBackStackEntryState) obj;
                    i4 = i5;
                }
                bundle.putParcelableArray("android-support-nav:controller:backStackStates:" + str3, parcelableArr2);
            }
            bundle.putStringArrayList("android-support-nav:controller:backStackStates", arrayList3);
        }
        if (this.g) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("android-support-nav:controller:deepLinkHandled", this.g);
        }
        return bundle;
    }

    public void j0(androidx.navigation.j jVar) throws Resources.NotFoundException {
        AbstractC13042fc3.i(jVar, "graph");
        k0(jVar, null);
    }

    public void k0(androidx.navigation.j jVar, Bundle bundle) throws Resources.NotFoundException {
        AbstractC13042fc3.i(jVar, "graph");
        if (!AbstractC13042fc3.d(this.d, jVar)) {
            androidx.navigation.j jVar2 = this.d;
            if (jVar2 != null) {
                for (Integer num : new ArrayList(this.o.keySet())) {
                    AbstractC13042fc3.h(num, "id");
                    r(num.intValue());
                }
                c0(this, jVar2.A(), true, false, 4, null);
            }
            this.d = jVar;
            U(bundle);
            return;
        }
        int iO = jVar.d0().o();
        for (int i2 = 0; i2 < iO; i2++) {
            androidx.navigation.i iVar = (androidx.navigation.i) jVar.d0().p(i2);
            androidx.navigation.j jVar3 = this.d;
            AbstractC13042fc3.f(jVar3);
            int iK = jVar3.d0().k(i2);
            androidx.navigation.j jVar4 = this.d;
            AbstractC13042fc3.f(jVar4);
            jVar4.d0().n(iK, iVar);
        }
        for (androidx.navigation.d dVar : this.h) {
            List<androidx.navigation.i> listU = AbstractC14201hX0.U(AbstractC11342cq6.K(androidx.navigation.i.j.c(dVar.e())));
            androidx.navigation.i iVarZ = this.d;
            AbstractC13042fc3.f(iVarZ);
            for (androidx.navigation.i iVar2 : listU) {
                if (!AbstractC13042fc3.d(iVar2, this.d) || !AbstractC13042fc3.d(iVarZ, jVar)) {
                    if (iVarZ instanceof androidx.navigation.j) {
                        iVarZ = ((androidx.navigation.j) iVarZ).Z(iVar2.A());
                        AbstractC13042fc3.f(iVarZ);
                    }
                }
            }
            dVar.j(iVarZ);
        }
    }

    public void l0(InterfaceC18633oz3 interfaceC18633oz3) {
        androidx.lifecycle.j lifecycle;
        AbstractC13042fc3.i(interfaceC18633oz3, "owner");
        if (AbstractC13042fc3.d(interfaceC18633oz3, this.q)) {
            return;
        }
        InterfaceC18633oz3 interfaceC18633oz32 = this.q;
        if (interfaceC18633oz32 != null && (lifecycle = interfaceC18633oz32.getLifecycle()) != null) {
            lifecycle.d(this.u);
        }
        this.q = interfaceC18633oz3;
        interfaceC18633oz3.getLifecycle().a(this.u);
    }

    public void m0(C14819iX7 c14819iX7) {
        AbstractC13042fc3.i(c14819iX7, "viewModelStore");
        androidx.navigation.f fVar = this.r;
        f.b bVar = androidx.navigation.f.c;
        if (AbstractC13042fc3.d(fVar, bVar.a(c14819iX7))) {
            return;
        }
        if (!this.h.isEmpty()) {
            throw new IllegalStateException("ViewModelStore should be set before setGraph call".toString());
        }
        this.r = bVar.a(c14819iX7);
    }

    public final androidx.navigation.d n0(androidx.navigation.d dVar) {
        AbstractC13042fc3.i(dVar, "child");
        androidx.navigation.d dVar2 = (androidx.navigation.d) this.m.remove(dVar);
        if (dVar2 == null) {
            return null;
        }
        AtomicInteger atomicInteger = (AtomicInteger) this.n.get(dVar2);
        Integer numValueOf = atomicInteger != null ? Integer.valueOf(atomicInteger.decrementAndGet()) : null;
        if (numValueOf != null && numValueOf.intValue() == 0) {
            b bVar = (b) this.y.get(this.x.e(dVar2.e().B()));
            if (bVar != null) {
                bVar.e(dVar2);
            }
            this.n.remove(dVar2);
        }
        return dVar2;
    }

    public final void o0() {
        AtomicInteger atomicInteger;
        InterfaceC10258bL6 interfaceC10258bL6C;
        Set set;
        List<androidx.navigation.d> listP1 = AbstractC15401jX0.p1(this.h);
        if (listP1.isEmpty()) {
            return;
        }
        androidx.navigation.i iVarE = ((androidx.navigation.d) AbstractC15401jX0.C0(listP1)).e();
        ArrayList arrayList = new ArrayList();
        if (iVarE instanceof InterfaceC3621Bq2) {
            Iterator it = AbstractC15401jX0.T0(listP1).iterator();
            while (it.hasNext()) {
                androidx.navigation.i iVarE2 = ((androidx.navigation.d) it.next()).e();
                arrayList.add(iVarE2);
                if (!(iVarE2 instanceof InterfaceC3621Bq2) && !(iVarE2 instanceof androidx.navigation.j)) {
                    break;
                }
            }
        }
        HashMap map = new HashMap();
        for (androidx.navigation.d dVar : AbstractC15401jX0.T0(listP1)) {
            j.b bVarG = dVar.g();
            androidx.navigation.i iVarE3 = dVar.e();
            if (iVarE != null && iVarE3.A() == iVarE.A()) {
                j.b bVar = j.b.RESUMED;
                if (bVarG != bVar) {
                    b bVar2 = (b) this.y.get(H().e(dVar.e().B()));
                    if (AbstractC13042fc3.d((bVar2 == null || (interfaceC10258bL6C = bVar2.c()) == null || (set = (Set) interfaceC10258bL6C.getValue()) == null) ? null : Boolean.valueOf(set.contains(dVar)), Boolean.TRUE) || ((atomicInteger = (AtomicInteger) this.n.get(dVar)) != null && atomicInteger.get() == 0)) {
                        map.put(dVar, j.b.STARTED);
                    } else {
                        map.put(dVar, bVar);
                    }
                }
                androidx.navigation.i iVar = (androidx.navigation.i) AbstractC15401jX0.s0(arrayList);
                if (iVar != null && iVar.A() == iVarE3.A()) {
                    AbstractC13610gX0.L(arrayList);
                }
                iVarE = iVarE.C();
            } else if ((!arrayList.isEmpty()) && iVarE3.A() == ((androidx.navigation.i) AbstractC15401jX0.q0(arrayList)).A()) {
                androidx.navigation.i iVar2 = (androidx.navigation.i) AbstractC13610gX0.L(arrayList);
                if (bVarG == j.b.RESUMED) {
                    dVar.k(j.b.STARTED);
                } else {
                    j.b bVar3 = j.b.STARTED;
                    if (bVarG != bVar3) {
                        map.put(dVar, bVar3);
                    }
                }
                androidx.navigation.j jVarC = iVar2.C();
                if (jVarC != null && !arrayList.contains(jVarC)) {
                    arrayList.add(jVarC);
                }
            } else {
                dVar.k(j.b.CREATED);
            }
        }
        for (androidx.navigation.d dVar2 : listP1) {
            j.b bVar4 = (j.b) map.get(dVar2);
            if (bVar4 != null) {
                dVar2.k(bVar4);
            } else {
                dVar2.l();
            }
        }
    }

    public final androidx.navigation.i v(int i2) {
        androidx.navigation.i iVarE;
        androidx.navigation.j jVar = this.d;
        if (jVar == null) {
            return null;
        }
        AbstractC13042fc3.f(jVar);
        if (jVar.A() == i2) {
            return this.d;
        }
        androidx.navigation.d dVar = (androidx.navigation.d) this.h.P();
        if (dVar == null || (iVarE = dVar.e()) == null) {
            iVarE = this.d;
            AbstractC13042fc3.f(iVarE);
        }
        return w(iVarE, i2);
    }

    public androidx.navigation.d y(int i2) {
        Object objPrevious;
        BJ bj = this.h;
        ListIterator<E> listIterator = bj.listIterator(bj.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                objPrevious = null;
                break;
            }
            objPrevious = listIterator.previous();
            if (((androidx.navigation.d) objPrevious).e().A() == i2) {
                break;
            }
        }
        androidx.navigation.d dVar = (androidx.navigation.d) objPrevious;
        if (dVar != null) {
            return dVar;
        }
        throw new IllegalArgumentException(("No destination with ID " + i2 + " is on the NavController's back stack. The current destination is " + D()).toString());
    }

    public final androidx.navigation.d z(String str) {
        Object objPrevious;
        AbstractC13042fc3.i(str, "route");
        BJ bj = this.h;
        ListIterator<E> listIterator = bj.listIterator(bj.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                objPrevious = null;
                break;
            }
            objPrevious = listIterator.previous();
            androidx.navigation.d dVar = (androidx.navigation.d) objPrevious;
            if (dVar.e().I(str, dVar.c())) {
                break;
            }
        }
        androidx.navigation.d dVar2 = (androidx.navigation.d) objPrevious;
        if (dVar2 != null) {
            return dVar2;
        }
        throw new IllegalArgumentException(("No destination with route " + str + " is on the NavController's back stack. The current destination is " + D()).toString());
    }
}
