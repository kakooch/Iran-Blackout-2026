package ir.nasim;

import android.gov.nist.core.Separators;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.Size;
import androidx.camera.core.impl.C;
import androidx.camera.core.impl.CameraControlInternal;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.j;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/* renamed from: ir.nasim.jI7, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC15273jI7 {
    private androidx.camera.core.impl.C d;
    private androidx.camera.core.impl.C e;
    private androidx.camera.core.impl.C f;
    private androidx.camera.core.impl.w g;
    private androidx.camera.core.impl.C h;
    private Rect i;
    private InterfaceC15221jD0 k;
    private InterfaceC15221jD0 l;
    private String m;
    private final Set a = new HashSet();
    private final Object b = new Object();
    private a c = a.INACTIVE;
    private Matrix j = new Matrix();
    private androidx.camera.core.impl.v n = androidx.camera.core.impl.v.b();
    private androidx.camera.core.impl.v o = androidx.camera.core.impl.v.b();

    /* renamed from: ir.nasim.jI7$a */
    enum a {
        ACTIVE,
        INACTIVE
    }

    /* renamed from: ir.nasim.jI7$b */
    public interface b {
        void c(AbstractC15273jI7 abstractC15273jI7);

        void f(AbstractC15273jI7 abstractC15273jI7);

        void g(AbstractC15273jI7 abstractC15273jI7);

        void k(AbstractC15273jI7 abstractC15273jI7);
    }

    protected AbstractC15273jI7(androidx.camera.core.impl.C c) {
        this.e = c;
        this.f = c;
    }

    private void P(b bVar) {
        this.a.remove(bVar);
    }

    private void a(b bVar) {
        this.a.add(bVar);
    }

    public boolean A(int i) {
        Iterator it = w().iterator();
        while (it.hasNext()) {
            if (AbstractC3797Cj7.b(i, ((Integer) it.next()).intValue())) {
                return true;
            }
        }
        return false;
    }

    public boolean B(InterfaceC15221jD0 interfaceC15221jD0) {
        int iM = m();
        if (iM == -1 || iM == 0) {
            return false;
        }
        if (iM == 1) {
            return true;
        }
        if (iM == 2) {
            return interfaceC15221jD0.l();
        }
        throw new AssertionError("Unknown mirrorMode: " + iM);
    }

    public androidx.camera.core.impl.C C(InterfaceC14623iD0 interfaceC14623iD0, androidx.camera.core.impl.C c, androidx.camera.core.impl.C c2) {
        androidx.camera.core.impl.q qVarZ;
        if (c2 != null) {
            qVarZ = androidx.camera.core.impl.q.a0(c2);
            qVarZ.b0(InterfaceC24505yj7.F);
        } else {
            qVarZ = androidx.camera.core.impl.q.Z();
        }
        if (this.e.b(androidx.camera.core.impl.o.j) || this.e.b(androidx.camera.core.impl.o.n)) {
            j.a aVar = androidx.camera.core.impl.o.r;
            if (qVarZ.b(aVar)) {
                qVarZ.b0(aVar);
            }
        }
        androidx.camera.core.impl.C c3 = this.e;
        j.a aVar2 = androidx.camera.core.impl.o.r;
        if (c3.b(aVar2)) {
            j.a aVar3 = androidx.camera.core.impl.o.p;
            if (qVarZ.b(aVar3) && ((C22601vW5) this.e.a(aVar2)).d() != null) {
                qVarZ.b0(aVar3);
            }
        }
        Iterator it = this.e.e().iterator();
        while (it.hasNext()) {
            androidx.camera.core.impl.j.D(qVarZ, qVarZ, this.e, (j.a) it.next());
        }
        if (c != null) {
            for (j.a aVar4 : c.e()) {
                if (!aVar4.c().equals(InterfaceC24505yj7.F.c())) {
                    androidx.camera.core.impl.j.D(qVarZ, qVarZ, c, aVar4);
                }
            }
        }
        if (qVarZ.b(androidx.camera.core.impl.o.n)) {
            j.a aVar5 = androidx.camera.core.impl.o.j;
            if (qVarZ.b(aVar5)) {
                qVarZ.b0(aVar5);
            }
        }
        j.a aVar6 = androidx.camera.core.impl.o.r;
        if (qVarZ.b(aVar6) && ((C22601vW5) qVarZ.a(aVar6)).a() != 0) {
            qVarZ.p(androidx.camera.core.impl.C.z, Boolean.TRUE);
        }
        return J(interfaceC14623iD0, y(qVarZ));
    }

    protected final void D() {
        this.c = a.ACTIVE;
        G();
    }

    protected final void E() {
        this.c = a.INACTIVE;
        G();
    }

    protected final void F() {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((b) it.next()).f(this);
        }
    }

    public final void G() {
        int iOrdinal = this.c.ordinal();
        if (iOrdinal == 0) {
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                ((b) it.next()).k(this);
            }
        } else {
            if (iOrdinal != 1) {
                return;
            }
            Iterator it2 = this.a.iterator();
            while (it2.hasNext()) {
                ((b) it2.next()).c(this);
            }
        }
    }

    protected abstract androidx.camera.core.impl.C J(InterfaceC14623iD0 interfaceC14623iD0, C.a aVar);

    protected abstract androidx.camera.core.impl.w M(androidx.camera.core.impl.j jVar);

    protected abstract androidx.camera.core.impl.w N(androidx.camera.core.impl.w wVar, androidx.camera.core.impl.w wVar2);

    public void Q(YC0 yc0) {
        AbstractC4980Hj5.a(true);
    }

    public void R(Matrix matrix) {
        this.j = new Matrix(matrix);
    }

    public void S(Rect rect) {
        this.i = rect;
    }

    public final void T(InterfaceC15221jD0 interfaceC15221jD0) {
        O();
        synchronized (this.b) {
            try {
                InterfaceC15221jD0 interfaceC15221jD02 = this.k;
                if (interfaceC15221jD0 == interfaceC15221jD02) {
                    P(interfaceC15221jD02);
                    this.k = null;
                }
                InterfaceC15221jD0 interfaceC15221jD03 = this.l;
                if (interfaceC15221jD0 == interfaceC15221jD03) {
                    P(interfaceC15221jD03);
                    this.l = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.g = null;
        this.i = null;
        this.f = this.e;
        this.d = null;
        this.h = null;
    }

    protected void U(List list) {
        if (list.isEmpty()) {
            return;
        }
        this.n = (androidx.camera.core.impl.v) list.get(0);
        if (list.size() > 1) {
            this.o = (androidx.camera.core.impl.v) list.get(1);
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            for (DeferrableSurface deferrableSurface : ((androidx.camera.core.impl.v) it.next()).n()) {
                if (deferrableSurface.g() == null) {
                    deferrableSurface.s(getClass());
                }
            }
        }
    }

    public void V(androidx.camera.core.impl.w wVar, androidx.camera.core.impl.w wVar2) {
        this.g = N(wVar, wVar2);
    }

    public void W(androidx.camera.core.impl.j jVar) {
        this.g = M(jVar);
    }

    public final void b(InterfaceC15221jD0 interfaceC15221jD0, InterfaceC15221jD0 interfaceC15221jD02, androidx.camera.core.impl.C c, androidx.camera.core.impl.C c2) {
        synchronized (this.b) {
            try {
                this.k = interfaceC15221jD0;
                this.l = interfaceC15221jD02;
                a(interfaceC15221jD0);
                if (interfaceC15221jD02 != null) {
                    a(interfaceC15221jD02);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.d = c;
        this.h = c2;
        this.f = C(interfaceC15221jD0.j(), this.d, this.h);
        H();
    }

    protected int c() {
        return ((androidx.camera.core.impl.o) this.f).r(-1);
    }

    public androidx.camera.core.impl.w d() {
        return this.g;
    }

    public Size e() {
        androidx.camera.core.impl.w wVar = this.g;
        if (wVar != null) {
            return wVar.e();
        }
        return null;
    }

    public InterfaceC15221jD0 f() {
        InterfaceC15221jD0 interfaceC15221jD0;
        synchronized (this.b) {
            interfaceC15221jD0 = this.k;
        }
        return interfaceC15221jD0;
    }

    protected CameraControlInternal g() {
        synchronized (this.b) {
            try {
                InterfaceC15221jD0 interfaceC15221jD0 = this.k;
                if (interfaceC15221jD0 == null) {
                    return CameraControlInternal.a;
                }
                return interfaceC15221jD0.b();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    protected String h() {
        return ((InterfaceC15221jD0) AbstractC4980Hj5.h(f(), "No camera attached to use case: " + this)).j().b();
    }

    public androidx.camera.core.impl.C i() {
        return this.f;
    }

    public abstract androidx.camera.core.impl.C j(boolean z, androidx.camera.core.impl.D d);

    public YC0 k() {
        return null;
    }

    public int l() {
        return this.f.getInputFormat();
    }

    protected int m() {
        return ((androidx.camera.core.impl.o) this.f).U(-1);
    }

    public String n() {
        String strS = this.f.s("<UnknownUseCase-" + hashCode() + Separators.GREATER_THAN);
        Objects.requireNonNull(strS);
        return strS;
    }

    public String o() {
        return this.m;
    }

    protected int p(InterfaceC15221jD0 interfaceC15221jD0) {
        return q(interfaceC15221jD0, false);
    }

    protected int q(InterfaceC15221jD0 interfaceC15221jD0, boolean z) {
        int iK = interfaceC15221jD0.j().k(x());
        return (interfaceC15221jD0.p() || !z) ? iK : AbstractC14447hv7.u(-iK);
    }

    public InterfaceC15221jD0 r() {
        InterfaceC15221jD0 interfaceC15221jD0;
        synchronized (this.b) {
            interfaceC15221jD0 = this.l;
        }
        return interfaceC15221jD0;
    }

    protected String s() {
        if (r() == null) {
            return null;
        }
        return r().j().b();
    }

    public androidx.camera.core.impl.v t() {
        return this.o;
    }

    public Matrix u() {
        return this.j;
    }

    public androidx.camera.core.impl.v v() {
        return this.n;
    }

    protected abstract Set w();

    protected int x() {
        return ((androidx.camera.core.impl.o) this.f).C(0);
    }

    public abstract C.a y(androidx.camera.core.impl.j jVar);

    public Rect z() {
        return this.i;
    }

    public void H() {
    }

    public void I() {
    }

    public void K() {
    }

    public void L() {
    }

    public void O() {
    }
}
