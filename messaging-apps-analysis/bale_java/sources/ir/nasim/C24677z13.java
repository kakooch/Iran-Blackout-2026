package ir.nasim;

import android.net.Uri;
import android.util.Log;
import android.util.Pair;
import android.util.Rational;
import android.util.Size;
import androidx.camera.core.impl.C;
import androidx.camera.core.impl.D;
import androidx.camera.core.impl.j;
import androidx.camera.core.impl.v;
import androidx.camera.core.internal.compat.quirk.SoftwareJpegEncodingPreferredQuirk;
import ir.nasim.C22601vW5;
import ir.nasim.O23;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: ir.nasim.z13, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C24677z13 extends AbstractC15273jI7 {
    public static final c B = new c();
    static final C21417td2 C = new C21417td2();
    private final A13 A;
    private final O23.a p;
    private final int q;
    private final AtomicReference r;
    private final int s;
    private int t;
    private Rational u;
    private C3269Ad6 v;
    v.b w;
    private E23 x;
    private C17889nj7 y;
    private v.c z;

    /* renamed from: ir.nasim.z13$a */
    class a implements A13 {
        a() {
        }
    }

    /* renamed from: ir.nasim.z13$b */
    public static final class b implements C.a {
        private final androidx.camera.core.impl.q a;

        public b() {
            this(androidx.camera.core.impl.q.Z());
        }

        public static b d(androidx.camera.core.impl.j jVar) {
            return new b(androidx.camera.core.impl.q.a0(jVar));
        }

        @Override // ir.nasim.InterfaceC3513Be2
        public androidx.camera.core.impl.p a() {
            return this.a;
        }

        public C24677z13 c() {
            Integer num = (Integer) a().g(androidx.camera.core.impl.m.L, null);
            if (num != null) {
                a().p(androidx.camera.core.impl.n.h, num);
            } else if (C24677z13.k0(a())) {
                a().p(androidx.camera.core.impl.n.h, 4101);
                a().p(androidx.camera.core.impl.n.i, C15116j22.c);
            } else {
                a().p(androidx.camera.core.impl.n.h, 256);
            }
            androidx.camera.core.impl.m mVarB = b();
            androidx.camera.core.impl.o.u(mVarB);
            C24677z13 c24677z13 = new C24677z13(mVarB);
            Size size = (Size) a().g(androidx.camera.core.impl.o.n, null);
            if (size != null) {
                c24677z13.o0(new Rational(size.getWidth(), size.getHeight()));
            }
            AbstractC4980Hj5.h((Executor) a().g(InterfaceC25045ze3.E, AbstractC20567sE0.b()), "The IO executor can't be null");
            androidx.camera.core.impl.p pVarA = a();
            j.a aVar = androidx.camera.core.impl.m.J;
            if (pVarA.b(aVar)) {
                Integer num2 = (Integer) a().a(aVar);
                if (num2 == null || !(num2.intValue() == 0 || num2.intValue() == 1 || num2.intValue() == 3 || num2.intValue() == 2)) {
                    throw new IllegalArgumentException("The flash mode is not allowed to set: " + num2);
                }
                if (num2.intValue() == 3 && a().g(androidx.camera.core.impl.m.S, null) == null) {
                    throw new IllegalArgumentException("The flash mode is not allowed to set to FLASH_MODE_SCREEN without setting ScreenFlash");
                }
            }
            return c24677z13;
        }

        @Override // androidx.camera.core.impl.C.a
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public androidx.camera.core.impl.m b() {
            return new androidx.camera.core.impl.m(androidx.camera.core.impl.r.X(this.a));
        }

        public b f(D.b bVar) {
            a().p(androidx.camera.core.impl.C.B, bVar);
            return this;
        }

        public b g(C15116j22 c15116j22) {
            a().p(androidx.camera.core.impl.n.i, c15116j22);
            return this;
        }

        public b h(int i) {
            a().p(androidx.camera.core.impl.m.M, Integer.valueOf(i));
            return this;
        }

        public b i(C22601vW5 c22601vW5) {
            a().p(androidx.camera.core.impl.o.r, c22601vW5);
            return this;
        }

        public b j(int i) {
            a().p(androidx.camera.core.impl.C.x, Integer.valueOf(i));
            return this;
        }

        public b k(int i) {
            if (i == -1) {
                i = 0;
            }
            a().p(androidx.camera.core.impl.o.j, Integer.valueOf(i));
            return this;
        }

        public b l(Class cls) {
            a().p(InterfaceC24505yj7.G, cls);
            if (a().g(InterfaceC24505yj7.F, null) == null) {
                m(cls.getCanonicalName() + "-" + UUID.randomUUID());
            }
            return this;
        }

        public b m(String str) {
            a().p(InterfaceC24505yj7.F, str);
            return this;
        }

        private b(androidx.camera.core.impl.q qVar) {
            this.a = qVar;
            Class cls = (Class) qVar.g(InterfaceC24505yj7.G, null);
            if (cls == null || cls.equals(C24677z13.class)) {
                f(D.b.IMAGE_CAPTURE);
                l(C24677z13.class);
                return;
            }
            throw new IllegalArgumentException("Invalid target class configuration for " + this + ": " + cls);
        }
    }

    /* renamed from: ir.nasim.z13$c */
    public static final class c {
        private static final C22601vW5 a;
        private static final androidx.camera.core.impl.m b;
        private static final C15116j22 c;

        static {
            C22601vW5 c22601vW5A = new C22601vW5.a().d(C18829pK.c).e(C23787xW5.c).a();
            a = c22601vW5A;
            C15116j22 c15116j22 = C15116j22.d;
            c = c15116j22;
            b = new b().j(4).k(0).i(c22601vW5A).h(0).g(c15116j22).b();
        }

        public androidx.camera.core.impl.m a() {
            return b;
        }
    }

    /* renamed from: ir.nasim.z13$d */
    public static final class d {
    }

    /* renamed from: ir.nasim.z13$e */
    public static class e {
        private final Uri a;

        public e(Uri uri) {
            this.a = uri;
        }
    }

    /* renamed from: ir.nasim.z13$f */
    public interface f {
        void clear();
    }

    /* renamed from: ir.nasim.z13$g */
    public interface g {
        void a();
    }

    C24677z13(androidx.camera.core.impl.m mVar) {
        super(mVar);
        this.p = new O23.a() { // from class: ir.nasim.x13
            @Override // ir.nasim.O23.a
            public final void a(O23 o23) {
                C24677z13.n0(o23);
            }
        };
        this.r = new AtomicReference(null);
        this.t = -1;
        this.u = null;
        this.A = new a();
        androidx.camera.core.impl.m mVar2 = (androidx.camera.core.impl.m) i();
        if (mVar2.b(androidx.camera.core.impl.m.I)) {
            this.q = mVar2.V();
        } else {
            this.q = 1;
        }
        this.s = mVar2.X(0);
        this.v = C3269Ad6.d(mVar2.a0());
    }

    private void Z() {
        this.v.c();
        C17889nj7 c17889nj7 = this.y;
        if (c17889nj7 != null) {
            c17889nj7.b();
        }
    }

    private void b0() {
        c0(false);
    }

    private void c0(boolean z) {
        C17889nj7 c17889nj7;
        Log.d("ImageCapture", "clearPipeline");
        AbstractC17949np7.a();
        v.c cVar = this.z;
        if (cVar != null) {
            cVar.b();
            this.z = null;
        }
        E23 e23 = this.x;
        if (e23 != null) {
            e23.a();
            this.x = null;
        }
        if (z || (c17889nj7 = this.y) == null) {
            return;
        }
        c17889nj7.b();
        this.y = null;
    }

    private v.b d0(String str, androidx.camera.core.impl.m mVar, androidx.camera.core.impl.w wVar) {
        AbstractC17949np7.a();
        Log.d("ImageCapture", String.format("createPipeline(cameraId: %s, streamSpec: %s)", str, wVar));
        Size sizeE = wVar.e();
        InterfaceC15221jD0 interfaceC15221jD0F = f();
        Objects.requireNonNull(interfaceC15221jD0F);
        boolean z = !interfaceC15221jD0F.p();
        if (this.x != null) {
            AbstractC4980Hj5.i(z);
            this.x.a();
        }
        if (((Boolean) i().g(androidx.camera.core.impl.m.U, Boolean.FALSE)).booleanValue()) {
            i0();
        }
        k();
        this.x = new E23(mVar, sizeE, null, z, null, 35);
        if (this.y == null) {
            this.y = new C17889nj7(this.A);
        }
        this.y.g(this.x);
        v.b bVarB = this.x.b(wVar.e());
        if (g0() == 2 && !wVar.f()) {
            g().a(bVarB);
        }
        if (wVar.d() != null) {
            bVarB.g(wVar.d());
        }
        v.c cVar = this.z;
        if (cVar != null) {
            cVar.b();
        }
        v.c cVar2 = new v.c(new v.d() { // from class: ir.nasim.y13
            @Override // androidx.camera.core.impl.v.d
            public final void a(androidx.camera.core.impl.v vVar, v.g gVar) {
                this.a.m0(vVar, gVar);
            }
        });
        this.z = cVar2;
        bVarB.q(cVar2);
        return bVarB;
    }

    private int f0() {
        InterfaceC15221jD0 interfaceC15221jD0F = f();
        if (interfaceC15221jD0F != null) {
            return interfaceC15221jD0F.a().d();
        }
        return -1;
    }

    private InterfaceC12025du6 i0() {
        f().d().E(null);
        return null;
    }

    private static boolean j0(List list, int i) {
        if (list == null) {
            return false;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (((Integer) ((Pair) it.next()).first).equals(Integer.valueOf(i))) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean k0(androidx.camera.core.impl.p pVar) {
        return Objects.equals(pVar.g(androidx.camera.core.impl.m.M, null), 1);
    }

    private boolean l0() {
        if (f() == null) {
            return false;
        }
        f().d().E(null);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m0(androidx.camera.core.impl.v vVar, v.g gVar) {
        if (f() == null) {
            return;
        }
        this.y.e();
        c0(true);
        v.b bVarD0 = d0(h(), (androidx.camera.core.impl.m) i(), (androidx.camera.core.impl.w) AbstractC4980Hj5.g(d()));
        this.w = bVarD0;
        U(AbstractC22311v13.a(new Object[]{bVarD0.o()}));
        F();
        this.y.f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void n0(O23 o23) {
        try {
            androidx.camera.core.f fVarB = o23.b();
            try {
                Log.d("ImageCapture", "Discarding ImageProxy which was inadvertently acquired: " + fVarB);
                if (fVarB != null) {
                    fVarB.close();
                }
            } finally {
            }
        } catch (IllegalStateException e2) {
            Log.e("ImageCapture", "Failed to acquire latest image.", e2);
        }
    }

    private void p0() {
        q0(this.v);
    }

    private void q0(f fVar) {
        g().b(fVar);
    }

    private void r0() {
        synchronized (this.r) {
            try {
                if (this.r.get() != null) {
                    return;
                }
                g().d(h0());
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // ir.nasim.AbstractC15273jI7
    public void H() {
        AbstractC4980Hj5.h(f(), "Attached camera cannot be null");
        if (h0() == 3 && f0() != 0) {
            throw new IllegalArgumentException("Not a front camera despite setting FLASH_MODE_SCREEN in ImageCapture");
        }
    }

    @Override // ir.nasim.AbstractC15273jI7
    public void I() {
        PI3.a("ImageCapture", "onCameraControlReady");
        r0();
        p0();
    }

    @Override // ir.nasim.AbstractC15273jI7
    protected androidx.camera.core.impl.C J(InterfaceC14623iD0 interfaceC14623iD0, C.a aVar) {
        if (interfaceC14623iD0.g().a(SoftwareJpegEncodingPreferredQuirk.class)) {
            Boolean bool = Boolean.FALSE;
            androidx.camera.core.impl.p pVarA = aVar.a();
            j.a aVar2 = androidx.camera.core.impl.m.P;
            Boolean bool2 = Boolean.TRUE;
            if (bool.equals(pVarA.g(aVar2, bool2))) {
                PI3.l("ImageCapture", "Device quirk suggests software JPEG encoder, but it has been explicitly disabled.");
            } else {
                PI3.e("ImageCapture", "Requesting software JPEG due to device quirk.");
                aVar.a().p(aVar2, bool2);
            }
        }
        boolean zE0 = e0(aVar.a());
        Integer num = (Integer) aVar.a().g(androidx.camera.core.impl.m.L, null);
        if (num != null) {
            AbstractC4980Hj5.b(!l0() || num.intValue() == 256, "Cannot set non-JPEG buffer format with Extensions enabled.");
            aVar.a().p(androidx.camera.core.impl.n.h, Integer.valueOf(zE0 ? 35 : num.intValue()));
        } else if (k0(aVar.a())) {
            aVar.a().p(androidx.camera.core.impl.n.h, 4101);
            aVar.a().p(androidx.camera.core.impl.n.i, C15116j22.c);
        } else if (zE0) {
            aVar.a().p(androidx.camera.core.impl.n.h, 35);
        } else {
            List list = (List) aVar.a().g(androidx.camera.core.impl.o.q, null);
            if (list == null || j0(list, 256)) {
                aVar.a().p(androidx.camera.core.impl.n.h, 256);
            } else if (j0(list, 35)) {
                aVar.a().p(androidx.camera.core.impl.n.h, 35);
            }
        }
        return aVar.b();
    }

    @Override // ir.nasim.AbstractC15273jI7
    public void L() {
        Z();
    }

    @Override // ir.nasim.AbstractC15273jI7
    protected androidx.camera.core.impl.w M(androidx.camera.core.impl.j jVar) {
        this.w.g(jVar);
        U(AbstractC22311v13.a(new Object[]{this.w.o()}));
        return d().g().d(jVar).a();
    }

    @Override // ir.nasim.AbstractC15273jI7
    protected androidx.camera.core.impl.w N(androidx.camera.core.impl.w wVar, androidx.camera.core.impl.w wVar2) {
        v.b bVarD0 = d0(h(), (androidx.camera.core.impl.m) i(), wVar);
        this.w = bVarD0;
        U(AbstractC22311v13.a(new Object[]{bVarD0.o()}));
        D();
        return wVar;
    }

    @Override // ir.nasim.AbstractC15273jI7
    public void O() {
        Z();
        b0();
        q0(null);
    }

    boolean e0(androidx.camera.core.impl.p pVar) {
        boolean z;
        Boolean bool = Boolean.TRUE;
        j.a aVar = androidx.camera.core.impl.m.P;
        Boolean bool2 = Boolean.FALSE;
        boolean z2 = false;
        if (bool.equals(pVar.g(aVar, bool2))) {
            if (l0()) {
                PI3.l("ImageCapture", "Software JPEG cannot be used with Extensions.");
                z = false;
            } else {
                z = true;
            }
            Integer num = (Integer) pVar.g(androidx.camera.core.impl.m.L, null);
            if (num == null || num.intValue() == 256) {
                z2 = z;
            } else {
                PI3.l("ImageCapture", "Software JPEG cannot be used with non-JPEG output buffer format.");
            }
            if (!z2) {
                PI3.l("ImageCapture", "Unable to support software JPEG. Disabling.");
                pVar.p(aVar, bool2);
            }
        }
        return z2;
    }

    public int g0() {
        return this.q;
    }

    public int h0() {
        int iW;
        synchronized (this.r) {
            iW = this.t;
            if (iW == -1) {
                iW = ((androidx.camera.core.impl.m) i()).W(2);
            }
        }
        return iW;
    }

    @Override // ir.nasim.AbstractC15273jI7
    public androidx.camera.core.impl.C j(boolean z, androidx.camera.core.impl.D d2) {
        c cVar = B;
        androidx.camera.core.impl.j jVarA = d2.a(cVar.a().N(), g0());
        if (z) {
            jVarA = androidx.camera.core.impl.j.O(jVarA, cVar.a());
        }
        if (jVarA == null) {
            return null;
        }
        return y(jVarA).b();
    }

    public void o0(Rational rational) {
        this.u = rational;
    }

    public String toString() {
        return "ImageCapture:" + n();
    }

    @Override // ir.nasim.AbstractC15273jI7
    public Set w() {
        HashSet hashSet = new HashSet();
        hashSet.add(4);
        return hashSet;
    }

    @Override // ir.nasim.AbstractC15273jI7
    public C.a y(androidx.camera.core.impl.j jVar) {
        return b.d(jVar);
    }
}
