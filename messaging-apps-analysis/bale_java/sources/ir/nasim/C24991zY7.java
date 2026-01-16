package ir.nasim;

import android.graphics.Rect;
import android.util.Pair;
import android.util.Size;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.v;
import ir.nasim.AbstractC15273jI7;
import ir.nasim.C12398eY6;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* renamed from: ir.nasim.zY7, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C24991zY7 implements AbstractC15273jI7.b {
    final Set a;
    private final androidx.camera.core.impl.D e;
    private final InterfaceC15221jD0 f;
    private final InterfaceC15221jD0 g;
    private final Set i;
    private final Map j;
    private final C24377yW5 k;
    private C24377yW5 l;
    final Map b = new HashMap();
    private final Map c = new HashMap();
    final Map d = new HashMap();
    private final JB0 h = s();

    /* renamed from: ir.nasim.zY7$a */
    class a extends JB0 {
        a() {
        }

        @Override // ir.nasim.JB0
        public void b(int i, QB0 qb0) {
            super.b(i, qb0);
            Iterator it = C24991zY7.this.a.iterator();
            while (it.hasNext()) {
                C24991zY7.J(qb0, ((AbstractC15273jI7) it.next()).v(), i);
            }
        }
    }

    C24991zY7(InterfaceC15221jD0 interfaceC15221jD0, InterfaceC15221jD0 interfaceC15221jD02, Set set, androidx.camera.core.impl.D d, C12398eY6.a aVar) {
        this.f = interfaceC15221jD0;
        this.g = interfaceC15221jD02;
        this.e = d;
        this.a = set;
        Map mapL = L(interfaceC15221jD0, set, d);
        this.j = mapL;
        HashSet hashSet = new HashSet(mapL.values());
        this.i = hashSet;
        this.k = new C24377yW5(interfaceC15221jD0, hashSet);
        if (interfaceC15221jD02 != null) {
            this.l = new C24377yW5(interfaceC15221jD02, hashSet);
        }
        Iterator it = set.iterator();
        while (it.hasNext()) {
            AbstractC15273jI7 abstractC15273jI7 = (AbstractC15273jI7) it.next();
            this.d.put(abstractC15273jI7, Boolean.FALSE);
            this.c.put(abstractC15273jI7, new C24397yY7(interfaceC15221jD0, this, aVar));
        }
    }

    private static int B(Set set) {
        Iterator it = set.iterator();
        int iMax = 0;
        while (it.hasNext()) {
            iMax = Math.max(iMax, ((androidx.camera.core.impl.C) it.next()).z(0));
        }
        return iMax;
    }

    private C27 D(AbstractC15273jI7 abstractC15273jI7) {
        C27 c27 = (C27) this.b.get(abstractC15273jI7);
        Objects.requireNonNull(c27);
        return c27;
    }

    private boolean E(AbstractC15273jI7 abstractC15273jI7) {
        Boolean bool = (Boolean) this.d.get(abstractC15273jI7);
        Objects.requireNonNull(bool);
        return bool.booleanValue();
    }

    static void J(QB0 qb0, androidx.camera.core.impl.v vVar, int i) {
        Iterator it = vVar.i().iterator();
        while (it.hasNext()) {
            ((JB0) it.next()).b(i, new AY7(vVar.j().j(), qb0));
        }
    }

    private static Map L(InterfaceC15221jD0 interfaceC15221jD0, Set set, androidx.camera.core.impl.D d) {
        HashMap map = new HashMap();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            AbstractC15273jI7 abstractC15273jI7 = (AbstractC15273jI7) it.next();
            map.put(abstractC15273jI7, abstractC15273jI7.C(interfaceC15221jD0.j(), null, abstractC15273jI7.j(true, d)));
        }
        return map;
    }

    private MM4 r(AbstractC15273jI7 abstractC15273jI7, C24377yW5 c24377yW5, InterfaceC15221jD0 interfaceC15221jD0, C27 c27, int i, boolean z) {
        int iK = interfaceC15221jD0.a().k(i);
        boolean zL = AbstractC14447hv7.l(c27.q());
        androidx.camera.core.impl.C c = (androidx.camera.core.impl.C) this.j.get(abstractC15273jI7);
        Objects.requireNonNull(c);
        Pair pairS = c24377yW5.s(c, c27.n(), AbstractC14447hv7.g(c27.q()), z);
        Rect rect = (Rect) pairS.first;
        Size size = (Size) pairS.second;
        int iV = v(abstractC15273jI7, this.f);
        C24397yY7 c24397yY7 = (C24397yY7) this.c.get(abstractC15273jI7);
        Objects.requireNonNull(c24397yY7);
        c24397yY7.m(iV);
        int iU = AbstractC14447hv7.u((c27.p() + iV) - iK);
        return MM4.h(x(abstractC15273jI7), u(abstractC15273jI7), rect, AbstractC14447hv7.o(size, iU), iU, abstractC15273jI7.B(interfaceC15221jD0) ^ zL);
    }

    private static void t(C27 c27, DeferrableSurface deferrableSurface, androidx.camera.core.impl.v vVar) {
        c27.u();
        try {
            c27.B(deferrableSurface);
        } catch (DeferrableSurface.SurfaceClosedException unused) {
            if (vVar.d() != null) {
                vVar.d().a(vVar, v.g.SESSION_ERROR_SURFACE_NEEDS_RESET);
            }
        }
    }

    private static int u(AbstractC15273jI7 abstractC15273jI7) {
        return abstractC15273jI7 instanceof C24677z13 ? 256 : 34;
    }

    private int v(AbstractC15273jI7 abstractC15273jI7, InterfaceC15221jD0 interfaceC15221jD0) {
        return interfaceC15221jD0.a().k(((androidx.camera.core.impl.o) abstractC15273jI7.i()).C(0));
    }

    static DeferrableSurface w(AbstractC15273jI7 abstractC15273jI7) {
        List listN = abstractC15273jI7 instanceof C24677z13 ? abstractC15273jI7.v().n() : abstractC15273jI7.v().j().i();
        AbstractC4980Hj5.i(listN.size() <= 1);
        if (listN.size() == 1) {
            return (DeferrableSurface) listN.get(0);
        }
        return null;
    }

    private static int x(AbstractC15273jI7 abstractC15273jI7) {
        if (abstractC15273jI7 instanceof C8112Uo5) {
            return 1;
        }
        return abstractC15273jI7 instanceof C24677z13 ? 4 : 2;
    }

    Map A(C27 c27, C27 c272, int i, boolean z) {
        HashMap map = new HashMap();
        for (AbstractC15273jI7 abstractC15273jI7 : this.a) {
            MM4 mm4R = r(abstractC15273jI7, this.k, this.f, c27, i, z);
            C24377yW5 c24377yW5 = this.l;
            InterfaceC15221jD0 interfaceC15221jD0 = this.g;
            Objects.requireNonNull(interfaceC15221jD0);
            map.put(abstractC15273jI7, AbstractC24676z12.c(mm4R, r(abstractC15273jI7, c24377yW5, interfaceC15221jD0, c272, i, z)));
        }
        return map;
    }

    JB0 C() {
        return this.h;
    }

    void F(androidx.camera.core.impl.p pVar) {
        pVar.p(androidx.camera.core.impl.o.s, this.k.o(pVar));
        pVar.p(androidx.camera.core.impl.C.x, Integer.valueOf(B(this.i)));
        C15116j22 c15116j22D = AbstractC17480n22.d(this.i);
        if (c15116j22D == null) {
            throw new IllegalArgumentException("Failed to merge child dynamic ranges, can not find a dynamic range that satisfies all children.");
        }
        pVar.p(androidx.camera.core.impl.n.i, c15116j22D);
        for (AbstractC15273jI7 abstractC15273jI7 : this.a) {
            if (abstractC15273jI7.i().v() != 0) {
                pVar.p(androidx.camera.core.impl.C.D, Integer.valueOf(abstractC15273jI7.i().v()));
            }
            if (abstractC15273jI7.i().B() != 0) {
                pVar.p(androidx.camera.core.impl.C.C, Integer.valueOf(abstractC15273jI7.i().B()));
            }
        }
    }

    void G() {
        for (AbstractC15273jI7 abstractC15273jI7 : this.a) {
            abstractC15273jI7.K();
            abstractC15273jI7.I();
        }
    }

    void H() {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((AbstractC15273jI7) it.next()).L();
        }
    }

    void I() {
        AbstractC17949np7.a();
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            f((AbstractC15273jI7) it.next());
        }
    }

    void K(Map map) {
        this.b.clear();
        this.b.putAll(map);
        for (Map.Entry entry : this.b.entrySet()) {
            AbstractC15273jI7 abstractC15273jI7 = (AbstractC15273jI7) entry.getKey();
            C27 c27 = (C27) entry.getValue();
            abstractC15273jI7.S(c27.n());
            abstractC15273jI7.R(c27.q());
            abstractC15273jI7.V(c27.r(), null);
            abstractC15273jI7.G();
        }
    }

    void M() {
        for (AbstractC15273jI7 abstractC15273jI7 : this.a) {
            C24397yY7 c24397yY7 = (C24397yY7) this.c.get(abstractC15273jI7);
            Objects.requireNonNull(c24397yY7);
            abstractC15273jI7.T(c24397yY7);
        }
    }

    @Override // ir.nasim.AbstractC15273jI7.b
    public void c(AbstractC15273jI7 abstractC15273jI7) {
        AbstractC17949np7.a();
        if (E(abstractC15273jI7)) {
            this.d.put(abstractC15273jI7, Boolean.FALSE);
            D(abstractC15273jI7).m();
        }
    }

    @Override // ir.nasim.AbstractC15273jI7.b
    public void f(AbstractC15273jI7 abstractC15273jI7) {
        DeferrableSurface deferrableSurfaceW;
        AbstractC17949np7.a();
        C27 c27D = D(abstractC15273jI7);
        if (E(abstractC15273jI7) && (deferrableSurfaceW = w(abstractC15273jI7)) != null) {
            t(c27D, deferrableSurfaceW, abstractC15273jI7.v());
        }
    }

    @Override // ir.nasim.AbstractC15273jI7.b
    public void g(AbstractC15273jI7 abstractC15273jI7) {
        AbstractC17949np7.a();
        if (E(abstractC15273jI7)) {
            C27 c27D = D(abstractC15273jI7);
            DeferrableSurface deferrableSurfaceW = w(abstractC15273jI7);
            if (deferrableSurfaceW != null) {
                t(c27D, deferrableSurfaceW, abstractC15273jI7.v());
            } else {
                c27D.m();
            }
        }
    }

    @Override // ir.nasim.AbstractC15273jI7.b
    public void k(AbstractC15273jI7 abstractC15273jI7) {
        AbstractC17949np7.a();
        if (E(abstractC15273jI7)) {
            return;
        }
        this.d.put(abstractC15273jI7, Boolean.TRUE);
        DeferrableSurface deferrableSurfaceW = w(abstractC15273jI7);
        if (deferrableSurfaceW != null) {
            t(D(abstractC15273jI7), deferrableSurfaceW, abstractC15273jI7.v());
        }
    }

    void m() {
        for (AbstractC15273jI7 abstractC15273jI7 : this.a) {
            C24397yY7 c24397yY7 = (C24397yY7) this.c.get(abstractC15273jI7);
            Objects.requireNonNull(c24397yY7);
            abstractC15273jI7.b(c24397yY7, null, null, abstractC15273jI7.j(true, this.e));
        }
    }

    JB0 s() {
        return new a();
    }

    Set y() {
        return this.a;
    }

    Map z(C27 c27, int i, boolean z) {
        HashMap map = new HashMap();
        for (AbstractC15273jI7 abstractC15273jI7 : this.a) {
            map.put(abstractC15273jI7, r(abstractC15273jI7, this.k, this.f, c27, i, z));
        }
        return map;
    }
}
