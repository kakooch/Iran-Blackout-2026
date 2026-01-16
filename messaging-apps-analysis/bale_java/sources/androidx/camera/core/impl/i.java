package androidx.camera.core.impl;

import android.util.Range;
import androidx.camera.core.impl.j;
import ir.nasim.C11310cn4;
import ir.nasim.C14935ij7;
import ir.nasim.JB0;
import ir.nasim.QB0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/* loaded from: classes.dex */
public final class i {
    public static final j.a i = j.a.a("camerax.core.captureConfig.rotation", Integer.TYPE);
    public static final j.a j = j.a.a("camerax.core.captureConfig.jpegQuality", Integer.class);
    private static final j.a k = j.a.a("camerax.core.captureConfig.resolvedFrameRate", Range.class);
    final List a;
    final j b;
    final int c;
    final boolean d;
    final List e;
    private final boolean f;
    private final C14935ij7 g;
    private final QB0 h;

    public interface b {
        void a(C c, a aVar);
    }

    i(List list, j jVar, int i2, boolean z, List list2, boolean z2, C14935ij7 c14935ij7, QB0 qb0) {
        this.a = list;
        this.b = jVar;
        this.c = i2;
        this.e = Collections.unmodifiableList(list2);
        this.f = z2;
        this.g = c14935ij7;
        this.h = qb0;
        this.d = z;
    }

    public static i b() {
        return new a().h();
    }

    public List c() {
        return this.e;
    }

    public QB0 d() {
        return this.h;
    }

    public Range e() {
        Range range = (Range) this.b.g(k, w.a);
        Objects.requireNonNull(range);
        return range;
    }

    public int f() {
        Object objD = this.g.d("CAPTURE_CONFIG_ID_KEY");
        if (objD == null) {
            return -1;
        }
        return ((Integer) objD).intValue();
    }

    public j g() {
        return this.b;
    }

    public int h() {
        Integer num = (Integer) this.b.g(C.C, 0);
        Objects.requireNonNull(num);
        return num.intValue();
    }

    public List i() {
        return Collections.unmodifiableList(this.a);
    }

    public C14935ij7 j() {
        return this.g;
    }

    public int k() {
        return this.c;
    }

    public int l() {
        Integer num = (Integer) this.b.g(C.D, 0);
        Objects.requireNonNull(num);
        return num.intValue();
    }

    public boolean m() {
        return this.f;
    }

    public static final class a {
        private final Set a;
        private p b;
        private int c;
        private boolean d;
        private List e;
        private boolean f;
        private C11310cn4 g;
        private QB0 h;

        public a() {
            this.a = new HashSet();
            this.b = q.Z();
            this.c = -1;
            this.d = false;
            this.e = new ArrayList();
            this.f = false;
            this.g = C11310cn4.g();
        }

        public static a i(C c) {
            b bVarO = c.o(null);
            if (bVarO != null) {
                a aVar = new a();
                bVarO.a(c, aVar);
                return aVar;
            }
            throw new IllegalStateException("Implementation is missing option unpacker for " + c.s(c.toString()));
        }

        public static a j(i iVar) {
            return new a(iVar);
        }

        public void a(Collection collection) {
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                c((JB0) it.next());
            }
        }

        public void b(C14935ij7 c14935ij7) {
            this.g.f(c14935ij7);
        }

        public void c(JB0 jb0) {
            if (this.e.contains(jb0)) {
                return;
            }
            this.e.add(jb0);
        }

        public void d(j.a aVar, Object obj) {
            this.b.p(aVar, obj);
        }

        public void e(j jVar) {
            for (j.a aVar : jVar.e()) {
                this.b.g(aVar, null);
                this.b.n(aVar, jVar.h(aVar), jVar.a(aVar));
            }
        }

        public void f(DeferrableSurface deferrableSurface) {
            this.a.add(deferrableSurface);
        }

        public void g(String str, Object obj) {
            this.g.i(str, obj);
        }

        public i h() {
            return new i(new ArrayList(this.a), r.X(this.b), this.c, this.d, new ArrayList(this.e), this.f, C14935ij7.c(this.g), this.h);
        }

        public Range k() {
            return (Range) this.b.g(i.k, w.a);
        }

        public Set l() {
            return this.a;
        }

        public int m() {
            return this.c;
        }

        public void n(QB0 qb0) {
            this.h = qb0;
        }

        public void o(Range range) {
            d(i.k, range);
        }

        public void p(j jVar) {
            this.b = q.a0(jVar);
        }

        public void q(int i) {
            if (i != 0) {
                d(C.C, Integer.valueOf(i));
            }
        }

        public void r(int i) {
            this.c = i;
        }

        public void s(boolean z) {
            this.f = z;
        }

        public void t(int i) {
            if (i != 0) {
                d(C.D, Integer.valueOf(i));
            }
        }

        private a(i iVar) {
            HashSet hashSet = new HashSet();
            this.a = hashSet;
            this.b = q.Z();
            this.c = -1;
            this.d = false;
            this.e = new ArrayList();
            this.f = false;
            this.g = C11310cn4.g();
            hashSet.addAll(iVar.a);
            this.b = q.a0(iVar.b);
            this.c = iVar.c;
            this.e.addAll(iVar.c());
            this.f = iVar.m();
            this.g = C11310cn4.h(iVar.j());
            this.d = iVar.d;
        }
    }
}
