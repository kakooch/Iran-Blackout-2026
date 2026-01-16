package ir.nasim;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.Log;
import android.util.Size;
import androidx.camera.core.impl.C;
import androidx.camera.core.impl.v;
import ir.nasim.C17604nF1;
import ir.nasim.K12;
import ir.nasim.N12;
import ir.nasim.P27;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* renamed from: ir.nasim.eY6, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C12398eY6 extends AbstractC15273jI7 {
    v.b A;
    v.b B;
    private v.c C;
    private final C13625gY6 p;
    private final C24991zY7 q;
    private final C6012Lu3 r;
    private final C6012Lu3 s;
    private P27 t;
    private P27 u;
    private N12 v;
    private C27 w;
    private C27 x;
    private C27 y;
    private C27 z;

    /* renamed from: ir.nasim.eY6$a */
    interface a {
    }

    public C12398eY6(InterfaceC15221jD0 interfaceC15221jD0, InterfaceC15221jD0 interfaceC15221jD02, C6012Lu3 c6012Lu3, C6012Lu3 c6012Lu32, Set set, androidx.camera.core.impl.D d) {
        super(i0(set));
        this.p = i0(set);
        this.r = c6012Lu3;
        this.s = c6012Lu32;
        this.q = new C24991zY7(interfaceC15221jD0, interfaceC15221jD02, set, d, new a() { // from class: ir.nasim.cY6
        });
    }

    private void Y(v.b bVar, final String str, final String str2, final androidx.camera.core.impl.C c, final androidx.camera.core.impl.w wVar, final androidx.camera.core.impl.w wVar2) {
        v.c cVar = this.C;
        if (cVar != null) {
            cVar.b();
        }
        v.c cVar2 = new v.c(new v.d() { // from class: ir.nasim.dY6
            @Override // androidx.camera.core.impl.v.d
            public final void a(androidx.camera.core.impl.v vVar, v.g gVar) {
                this.a.n0(str, str2, c, wVar, wVar2, vVar, gVar);
            }
        });
        this.C = cVar2;
        bVar.q(cVar2);
    }

    private void Z() {
        v.c cVar = this.C;
        if (cVar != null) {
            cVar.b();
            this.C = null;
        }
        C27 c27 = this.w;
        if (c27 != null) {
            c27.i();
            this.w = null;
        }
        C27 c272 = this.x;
        if (c272 != null) {
            c272.i();
            this.x = null;
        }
        C27 c273 = this.y;
        if (c273 != null) {
            c273.i();
            this.y = null;
        }
        C27 c274 = this.z;
        if (c274 != null) {
            c274.i();
            this.z = null;
        }
        P27 p27 = this.u;
        if (p27 != null) {
            p27.h();
            this.u = null;
        }
        N12 n12 = this.v;
        if (n12 != null) {
            n12.f();
            this.v = null;
        }
        P27 p272 = this.t;
        if (p272 != null) {
            p272.h();
            this.t = null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private List a0(String str, String str2, androidx.camera.core.impl.C c, androidx.camera.core.impl.w wVar, androidx.camera.core.impl.w wVar2) {
        AbstractC17949np7.a();
        if (wVar2 != null) {
            b0(str, str2, c, wVar, wVar2);
            c0(str, str2, c, wVar, wVar2);
            this.v = j0(f(), r(), wVar, this.r, this.s);
            Map mapA = this.q.A(this.y, this.z, x(), z() != null);
            N12.c cVarI = this.v.i(N12.b.d(this.y, this.z, new ArrayList(mapA.values())));
            HashMap map = new HashMap();
            for (Map.Entry entry : mapA.entrySet()) {
                map.put((AbstractC15273jI7) entry.getKey(), (C27) cVarI.get(entry.getValue()));
            }
            this.q.K(map);
            return AbstractC22311v13.a(new Object[]{this.A.o(), this.B.o()});
        }
        b0(str, str2, c, wVar, null);
        InterfaceC15221jD0 interfaceC15221jD0F = f();
        Objects.requireNonNull(interfaceC15221jD0F);
        this.u = l0(interfaceC15221jD0F, wVar);
        Map mapZ = this.q.z(this.y, x(), z() != null);
        P27.c cVarL = this.u.l(P27.b.c(this.y, new ArrayList(mapZ.values())));
        HashMap map2 = new HashMap();
        for (Map.Entry entry2 : mapZ.entrySet()) {
            map2.put((AbstractC15273jI7) entry2.getKey(), (C27) cVarL.get(entry2.getValue()));
        }
        this.q.K(map2);
        return AbstractC22311v13.a(new Object[]{this.A.o()});
    }

    private void b0(String str, String str2, androidx.camera.core.impl.C c, androidx.camera.core.impl.w wVar, androidx.camera.core.impl.w wVar2) {
        Matrix matrixU = u();
        InterfaceC15221jD0 interfaceC15221jD0F = f();
        Objects.requireNonNull(interfaceC15221jD0F);
        boolean zP = interfaceC15221jD0F.p();
        Rect rectH0 = h0(wVar.e());
        Objects.requireNonNull(rectH0);
        InterfaceC15221jD0 interfaceC15221jD0F2 = f();
        Objects.requireNonNull(interfaceC15221jD0F2);
        int iP = p(interfaceC15221jD0F2);
        InterfaceC15221jD0 interfaceC15221jD0F3 = f();
        Objects.requireNonNull(interfaceC15221jD0F3);
        C27 c27 = new C27(3, 34, wVar, matrixU, zP, rectH0, iP, -1, B(interfaceC15221jD0F3));
        this.w = c27;
        InterfaceC15221jD0 interfaceC15221jD0F4 = f();
        Objects.requireNonNull(interfaceC15221jD0F4);
        this.y = k0(c27, interfaceC15221jD0F4);
        v.b bVarD0 = d0(this.w, c, wVar);
        this.A = bVarD0;
        Y(bVarD0, str, str2, c, wVar, wVar2);
    }

    private void c0(String str, String str2, androidx.camera.core.impl.C c, androidx.camera.core.impl.w wVar, androidx.camera.core.impl.w wVar2) {
        Matrix matrixU = u();
        InterfaceC15221jD0 interfaceC15221jD0R = r();
        Objects.requireNonNull(interfaceC15221jD0R);
        boolean zP = interfaceC15221jD0R.p();
        Rect rectH0 = h0(wVar2.e());
        Objects.requireNonNull(rectH0);
        InterfaceC15221jD0 interfaceC15221jD0R2 = r();
        Objects.requireNonNull(interfaceC15221jD0R2);
        int iP = p(interfaceC15221jD0R2);
        InterfaceC15221jD0 interfaceC15221jD0R3 = r();
        Objects.requireNonNull(interfaceC15221jD0R3);
        C27 c27 = new C27(3, 34, wVar2, matrixU, zP, rectH0, iP, -1, B(interfaceC15221jD0R3));
        this.x = c27;
        InterfaceC15221jD0 interfaceC15221jD0R4 = r();
        Objects.requireNonNull(interfaceC15221jD0R4);
        this.z = k0(c27, interfaceC15221jD0R4);
        v.b bVarD0 = d0(this.x, c, wVar2);
        this.B = bVarD0;
        Y(bVarD0, str, str2, c, wVar, wVar2);
    }

    private v.b d0(C27 c27, androidx.camera.core.impl.C c, androidx.camera.core.impl.w wVar) {
        v.b bVarP = v.b.p(c, wVar.e());
        p0(bVarP);
        o0(wVar.e(), bVarP);
        bVarP.m(c27.o(), wVar.b(), null, -1);
        bVarP.j(this.q.C());
        if (wVar.d() != null) {
            bVarP.g(wVar.d());
        }
        return bVarP;
    }

    public static List e0(AbstractC15273jI7 abstractC15273jI7) {
        ArrayList arrayList = new ArrayList();
        if (m0(abstractC15273jI7)) {
            Iterator it = ((C12398eY6) abstractC15273jI7).g0().iterator();
            while (it.hasNext()) {
                arrayList.add(((AbstractC15273jI7) it.next()).i().N());
            }
        } else {
            arrayList.add(abstractC15273jI7.i().N());
        }
        return arrayList;
    }

    private static int f0(AbstractC15273jI7 abstractC15273jI7) {
        return abstractC15273jI7.i().J().o();
    }

    private Rect h0(Size size) {
        return z() != null ? z() : new Rect(0, 0, size.getWidth(), size.getHeight());
    }

    private static C13625gY6 i0(Set set) {
        androidx.camera.core.impl.p pVarA = new C13007fY6().a();
        pVarA.p(androidx.camera.core.impl.n.h, 34);
        ArrayList arrayList = new ArrayList();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            AbstractC15273jI7 abstractC15273jI7 = (AbstractC15273jI7) it.next();
            if (abstractC15273jI7.i().b(androidx.camera.core.impl.C.B)) {
                arrayList.add(abstractC15273jI7.i().N());
            } else {
                Log.e("StreamSharing", "A child does not have capture type.");
            }
        }
        pVarA.p(C13625gY6.I, arrayList);
        pVarA.p(androidx.camera.core.impl.o.m, 2);
        return new C13625gY6(androidx.camera.core.impl.r.X(pVarA));
    }

    private N12 j0(InterfaceC15221jD0 interfaceC15221jD0, InterfaceC15221jD0 interfaceC15221jD02, androidx.camera.core.impl.w wVar, C6012Lu3 c6012Lu3, C6012Lu3 c6012Lu32) {
        return new N12(interfaceC15221jD0, interfaceC15221jD02, K12.a.a(wVar.b(), c6012Lu3, c6012Lu32));
    }

    private C27 k0(C27 c27, InterfaceC15221jD0 interfaceC15221jD0) {
        k();
        return c27;
    }

    private P27 l0(InterfaceC15221jD0 interfaceC15221jD0, androidx.camera.core.impl.w wVar) {
        k();
        return new P27(interfaceC15221jD0, C17604nF1.a.a(wVar.b()));
    }

    public static boolean m0(AbstractC15273jI7 abstractC15273jI7) {
        return abstractC15273jI7 instanceof C12398eY6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n0(String str, String str2, androidx.camera.core.impl.C c, androidx.camera.core.impl.w wVar, androidx.camera.core.impl.w wVar2, androidx.camera.core.impl.v vVar, v.g gVar) {
        if (f() == null) {
            return;
        }
        Z();
        U(a0(str, str2, c, wVar, wVar2));
        F();
        this.q.I();
    }

    private void o0(Size size, v.b bVar) {
        Iterator it = g0().iterator();
        while (it.hasNext()) {
            androidx.camera.core.impl.v vVarO = v.b.p(((AbstractC15273jI7) it.next()).i(), size).o();
            bVar.c(vVarO.i());
            bVar.a(vVarO.m());
            bVar.d(vVarO.k());
            bVar.b(vVarO.c());
            bVar.g(vVarO.f());
        }
    }

    private void p0(v.b bVar) {
        Iterator it = g0().iterator();
        int iE = -1;
        while (it.hasNext()) {
            iE = androidx.camera.core.impl.v.e(iE, f0((AbstractC15273jI7) it.next()));
        }
        if (iE != -1) {
            bVar.w(iE);
        }
    }

    @Override // ir.nasim.AbstractC15273jI7
    public void H() {
        super.H();
        this.q.m();
    }

    @Override // ir.nasim.AbstractC15273jI7
    protected androidx.camera.core.impl.C J(InterfaceC14623iD0 interfaceC14623iD0, C.a aVar) {
        this.q.F(aVar.a());
        return aVar.b();
    }

    @Override // ir.nasim.AbstractC15273jI7
    public void K() {
        super.K();
        this.q.G();
    }

    @Override // ir.nasim.AbstractC15273jI7
    public void L() {
        super.L();
        this.q.H();
    }

    @Override // ir.nasim.AbstractC15273jI7
    protected androidx.camera.core.impl.w M(androidx.camera.core.impl.j jVar) {
        this.A.g(jVar);
        U(AbstractC22311v13.a(new Object[]{this.A.o()}));
        return d().g().d(jVar).a();
    }

    @Override // ir.nasim.AbstractC15273jI7
    protected androidx.camera.core.impl.w N(androidx.camera.core.impl.w wVar, androidx.camera.core.impl.w wVar2) {
        U(a0(h(), s(), i(), wVar, wVar2));
        D();
        return wVar;
    }

    @Override // ir.nasim.AbstractC15273jI7
    public void O() {
        super.O();
        Z();
        this.q.M();
    }

    public Set g0() {
        return this.q.y();
    }

    @Override // ir.nasim.AbstractC15273jI7
    public androidx.camera.core.impl.C j(boolean z, androidx.camera.core.impl.D d) {
        androidx.camera.core.impl.j jVarA = d.a(this.p.N(), 1);
        if (z) {
            jVarA = androidx.camera.core.impl.j.O(jVarA, this.p.getConfig());
        }
        if (jVarA == null) {
            return null;
        }
        return y(jVarA).b();
    }

    @Override // ir.nasim.AbstractC15273jI7
    public Set w() {
        HashSet hashSet = new HashSet();
        hashSet.add(3);
        return hashSet;
    }

    @Override // ir.nasim.AbstractC15273jI7
    public C.a y(androidx.camera.core.impl.j jVar) {
        return new C13007fY6(androidx.camera.core.impl.q.a0(jVar));
    }
}
