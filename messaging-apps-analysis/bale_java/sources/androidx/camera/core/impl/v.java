package androidx.camera.core.impl;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.params.InputConfiguration;
import android.util.Range;
import android.util.Size;
import androidx.camera.core.impl.C1923d;
import androidx.camera.core.impl.i;
import androidx.camera.core.impl.v;
import ir.nasim.C10706c37;
import ir.nasim.C15116j22;
import ir.nasim.JB0;
import ir.nasim.PI3;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public final class v {
    private static final List j = Arrays.asList(1, 5, 3);
    private final List a;
    private final f b;
    private final List c;
    private final List d;
    private final List e;
    private final d f;
    private final i g;
    private final int h;
    private InputConfiguration i;

    static class a {
        d f;
        InputConfiguration g;
        f i;
        final Set a = new LinkedHashSet();
        final i.a b = new i.a();
        final List c = new ArrayList();
        final List d = new ArrayList();
        final List e = new ArrayList();
        int h = 0;

        a() {
        }
    }

    public static class b extends a {
        public static b p(C c, Size size) {
            e eVarT = c.T(null);
            if (eVarT != null) {
                b bVar = new b();
                eVarT.a(size, c, bVar);
                return bVar;
            }
            throw new IllegalStateException("Implementation is missing option unpacker for " + c.s(c.toString()));
        }

        public b a(Collection collection) {
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                JB0 jb0 = (JB0) it.next();
                this.b.c(jb0);
                if (!this.e.contains(jb0)) {
                    this.e.add(jb0);
                }
            }
            return this;
        }

        public b b(Collection collection) {
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                f((CameraDevice.StateCallback) it.next());
            }
            return this;
        }

        public b c(Collection collection) {
            this.b.a(collection);
            return this;
        }

        public b d(List list) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                k((CameraCaptureSession.StateCallback) it.next());
            }
            return this;
        }

        public b e(JB0 jb0) {
            this.b.c(jb0);
            if (!this.e.contains(jb0)) {
                this.e.add(jb0);
            }
            return this;
        }

        public b f(CameraDevice.StateCallback stateCallback) {
            if (this.c.contains(stateCallback)) {
                return this;
            }
            this.c.add(stateCallback);
            return this;
        }

        public b g(j jVar) {
            this.b.e(jVar);
            return this;
        }

        public b h(DeferrableSurface deferrableSurface) {
            return i(deferrableSurface, C15116j22.d);
        }

        public b i(DeferrableSurface deferrableSurface, C15116j22 c15116j22) {
            this.a.add(f.a(deferrableSurface).b(c15116j22).a());
            return this;
        }

        public b j(JB0 jb0) {
            this.b.c(jb0);
            return this;
        }

        public b k(CameraCaptureSession.StateCallback stateCallback) {
            if (this.d.contains(stateCallback)) {
                return this;
            }
            this.d.add(stateCallback);
            return this;
        }

        public b l(DeferrableSurface deferrableSurface) {
            return m(deferrableSurface, C15116j22.d, null, -1);
        }

        public b m(DeferrableSurface deferrableSurface, C15116j22 c15116j22, String str, int i) {
            this.a.add(f.a(deferrableSurface).d(str).b(c15116j22).c(i).a());
            this.b.f(deferrableSurface);
            return this;
        }

        public b n(String str, Object obj) {
            this.b.g(str, obj);
            return this;
        }

        public v o() {
            return new v(new ArrayList(this.a), new ArrayList(this.c), new ArrayList(this.d), new ArrayList(this.e), this.b.h(), this.f, this.g, this.h, this.i);
        }

        public b q(d dVar) {
            this.f = dVar;
            return this;
        }

        public b r(Range range) {
            this.b.o(range);
            return this;
        }

        public b s(j jVar) {
            this.b.p(jVar);
            return this;
        }

        public b t(InputConfiguration inputConfiguration) {
            this.g = inputConfiguration;
            return this;
        }

        public b u(DeferrableSurface deferrableSurface) {
            this.i = f.a(deferrableSurface).a();
            return this;
        }

        public b v(int i) {
            if (i != 0) {
                this.b.q(i);
            }
            return this;
        }

        public b w(int i) {
            this.b.r(i);
            return this;
        }

        public b x(int i) {
            if (i != 0) {
                this.b.t(i);
            }
            return this;
        }
    }

    public static final class c implements d {
        private final AtomicBoolean a = new AtomicBoolean(false);
        private final d b;

        public c(d dVar) {
            this.b = dVar;
        }

        @Override // androidx.camera.core.impl.v.d
        public void a(v vVar, g gVar) {
            if (this.a.get()) {
                return;
            }
            this.b.a(vVar, gVar);
        }

        public void b() {
            this.a.set(true);
        }
    }

    public interface d {
        void a(v vVar, g gVar);
    }

    public interface e {
        void a(Size size, C c, b bVar);
    }

    public static abstract class f {

        public static abstract class a {
            public abstract f a();

            public abstract a b(C15116j22 c15116j22);

            public abstract a c(int i);

            public abstract a d(String str);

            public abstract a e(List list);

            public abstract a f(int i);
        }

        public static a a(DeferrableSurface deferrableSurface) {
            return new C1923d.b().g(deferrableSurface).e(Collections.emptyList()).d(null).c(-1).f(-1).b(C15116j22.d);
        }

        public abstract C15116j22 b();

        public abstract int c();

        public abstract String d();

        public abstract List e();

        public abstract DeferrableSurface f();

        public abstract int g();
    }

    public enum g {
        SESSION_ERROR_SURFACE_NEEDS_RESET,
        SESSION_ERROR_UNKNOWN
    }

    public static final class h extends a {
        private final C10706c37 j = new C10706c37();
        private boolean k = true;
        private boolean l = false;
        private List m = new ArrayList();

        private List d() {
            ArrayList arrayList = new ArrayList();
            for (f fVar : this.a) {
                arrayList.add(fVar.f());
                Iterator it = fVar.e().iterator();
                while (it.hasNext()) {
                    arrayList.add((DeferrableSurface) it.next());
                }
            }
            return arrayList;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void f(v vVar, g gVar) {
            Iterator it = this.m.iterator();
            while (it.hasNext()) {
                ((d) it.next()).a(vVar, gVar);
            }
        }

        private void g(Range range) {
            Range range2 = w.a;
            if (range.equals(range2)) {
                return;
            }
            if (this.b.k().equals(range2)) {
                this.b.o(range);
            } else {
                if (this.b.k().equals(range)) {
                    return;
                }
                this.k = false;
                PI3.a("ValidatingBuilder", "Different ExpectedFrameRateRange values");
            }
        }

        private void h(int i) {
            if (i != 0) {
                this.b.q(i);
            }
        }

        private void i(int i) {
            if (i != 0) {
                this.b.t(i);
            }
        }

        public void b(v vVar) {
            i iVarJ = vVar.j();
            if (iVarJ.k() != -1) {
                this.l = true;
                this.b.r(v.e(iVarJ.k(), this.b.m()));
            }
            g(iVarJ.e());
            h(iVarJ.h());
            i(iVarJ.l());
            this.b.b(vVar.j().j());
            this.c.addAll(vVar.c());
            this.d.addAll(vVar.k());
            this.b.a(vVar.i());
            this.e.addAll(vVar.m());
            if (vVar.d() != null) {
                this.m.add(vVar.d());
            }
            if (vVar.g() != null) {
                this.g = vVar.g();
            }
            this.a.addAll(vVar.h());
            this.b.l().addAll(iVarJ.i());
            if (!d().containsAll(this.b.l())) {
                PI3.a("ValidatingBuilder", "Invalid configuration due to capture request surfaces are not a subset of surfaces");
                this.k = false;
            }
            if (vVar.l() != this.h && vVar.l() != 0 && this.h != 0) {
                PI3.a("ValidatingBuilder", "Invalid configuration due to that two non-default session types are set");
                this.k = false;
            } else if (vVar.l() != 0) {
                this.h = vVar.l();
            }
            if (vVar.b != null) {
                if (this.i == vVar.b || this.i == null) {
                    this.i = vVar.b;
                } else {
                    PI3.a("ValidatingBuilder", "Invalid configuration due to that two different postview output configs are set");
                    this.k = false;
                }
            }
            this.b.e(iVarJ.g());
        }

        public v c() {
            if (!this.k) {
                throw new IllegalArgumentException("Unsupported session configuration combination");
            }
            ArrayList arrayList = new ArrayList(this.a);
            this.j.d(arrayList);
            return new v(arrayList, new ArrayList(this.c), new ArrayList(this.d), new ArrayList(this.e), this.b.h(), !this.m.isEmpty() ? new d() { // from class: ir.nasim.Vt6
                @Override // androidx.camera.core.impl.v.d
                public final void a(androidx.camera.core.impl.v vVar, v.g gVar) {
                    this.a.f(vVar, gVar);
                }
            } : null, this.g, this.h, this.i);
        }

        public boolean e() {
            return this.l && this.k;
        }
    }

    v(List list, List list2, List list3, List list4, i iVar, d dVar, InputConfiguration inputConfiguration, int i, f fVar) {
        this.a = list;
        this.c = Collections.unmodifiableList(list2);
        this.d = Collections.unmodifiableList(list3);
        this.e = Collections.unmodifiableList(list4);
        this.f = dVar;
        this.g = iVar;
        this.i = inputConfiguration;
        this.h = i;
        this.b = fVar;
    }

    public static v b() {
        return new v(new ArrayList(), new ArrayList(0), new ArrayList(0), new ArrayList(0), new i.a().h(), null, null, 0, null);
    }

    public static int e(int i, int i2) {
        List list = j;
        return list.indexOf(Integer.valueOf(i)) >= list.indexOf(Integer.valueOf(i2)) ? i : i2;
    }

    public List c() {
        return this.c;
    }

    public d d() {
        return this.f;
    }

    public j f() {
        return this.g.g();
    }

    public InputConfiguration g() {
        return this.i;
    }

    public List h() {
        return this.a;
    }

    public List i() {
        return this.g.c();
    }

    public i j() {
        return this.g;
    }

    public List k() {
        return this.d;
    }

    public int l() {
        return this.h;
    }

    public List m() {
        return this.e;
    }

    public List n() {
        ArrayList arrayList = new ArrayList();
        for (f fVar : this.a) {
            arrayList.add(fVar.f());
            Iterator it = fVar.e().iterator();
            while (it.hasNext()) {
                arrayList.add((DeferrableSurface) it.next());
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    public int o() {
        return this.g.k();
    }
}
