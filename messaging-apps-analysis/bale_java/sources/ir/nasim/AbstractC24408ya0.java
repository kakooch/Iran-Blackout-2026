package ir.nasim;

import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.ya0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC24408ya0 {
    private final d c;
    protected C13505gL3 e;
    final List a = new ArrayList(1);
    private boolean b = false;
    protected float d = 0.0f;
    private Object f = null;
    private float g = -1.0f;
    private float h = -1.0f;

    /* renamed from: ir.nasim.ya0$b */
    public interface b {
        void a();
    }

    /* renamed from: ir.nasim.ya0$c */
    private static final class c implements d {
        private c() {
        }

        @Override // ir.nasim.AbstractC24408ya0.d
        public boolean a(float f) {
            throw new IllegalStateException("not implemented");
        }

        @Override // ir.nasim.AbstractC24408ya0.d
        public C24561yp3 b() {
            throw new IllegalStateException("not implemented");
        }

        @Override // ir.nasim.AbstractC24408ya0.d
        public boolean c(float f) {
            return false;
        }

        @Override // ir.nasim.AbstractC24408ya0.d
        public float d() {
            return 0.0f;
        }

        @Override // ir.nasim.AbstractC24408ya0.d
        public float e() {
            return 1.0f;
        }

        @Override // ir.nasim.AbstractC24408ya0.d
        public boolean isEmpty() {
            return true;
        }
    }

    /* renamed from: ir.nasim.ya0$d */
    private interface d {
        boolean a(float f);

        C24561yp3 b();

        boolean c(float f);

        float d();

        float e();

        boolean isEmpty();
    }

    /* renamed from: ir.nasim.ya0$e */
    private static final class e implements d {
        private final List a;
        private C24561yp3 c = null;
        private float d = -1.0f;
        private C24561yp3 b = f(0.0f);

        e(List list) {
            this.a = list;
        }

        private C24561yp3 f(float f) {
            List list = this.a;
            C24561yp3 c24561yp3 = (C24561yp3) list.get(list.size() - 1);
            if (f >= c24561yp3.f()) {
                return c24561yp3;
            }
            for (int size = this.a.size() - 2; size >= 1; size--) {
                C24561yp3 c24561yp32 = (C24561yp3) this.a.get(size);
                if (this.b != c24561yp32 && c24561yp32.a(f)) {
                    return c24561yp32;
                }
            }
            return (C24561yp3) this.a.get(0);
        }

        @Override // ir.nasim.AbstractC24408ya0.d
        public boolean a(float f) {
            C24561yp3 c24561yp3 = this.c;
            C24561yp3 c24561yp32 = this.b;
            if (c24561yp3 == c24561yp32 && this.d == f) {
                return true;
            }
            this.c = c24561yp32;
            this.d = f;
            return false;
        }

        @Override // ir.nasim.AbstractC24408ya0.d
        public C24561yp3 b() {
            return this.b;
        }

        @Override // ir.nasim.AbstractC24408ya0.d
        public boolean c(float f) {
            if (this.b.a(f)) {
                return !this.b.i();
            }
            this.b = f(f);
            return true;
        }

        @Override // ir.nasim.AbstractC24408ya0.d
        public float d() {
            return ((C24561yp3) this.a.get(0)).f();
        }

        @Override // ir.nasim.AbstractC24408ya0.d
        public float e() {
            return ((C24561yp3) this.a.get(r0.size() - 1)).c();
        }

        @Override // ir.nasim.AbstractC24408ya0.d
        public boolean isEmpty() {
            return false;
        }
    }

    /* renamed from: ir.nasim.ya0$f */
    private static final class f implements d {
        private final C24561yp3 a;
        private float b = -1.0f;

        f(List list) {
            this.a = (C24561yp3) list.get(0);
        }

        @Override // ir.nasim.AbstractC24408ya0.d
        public boolean a(float f) {
            if (this.b == f) {
                return true;
            }
            this.b = f;
            return false;
        }

        @Override // ir.nasim.AbstractC24408ya0.d
        public C24561yp3 b() {
            return this.a;
        }

        @Override // ir.nasim.AbstractC24408ya0.d
        public boolean c(float f) {
            return !this.a.i();
        }

        @Override // ir.nasim.AbstractC24408ya0.d
        public float d() {
            return this.a.f();
        }

        @Override // ir.nasim.AbstractC24408ya0.d
        public float e() {
            return this.a.c();
        }

        @Override // ir.nasim.AbstractC24408ya0.d
        public boolean isEmpty() {
            return false;
        }
    }

    AbstractC24408ya0(List list) {
        this.c = q(list);
    }

    private float g() {
        if (this.g == -1.0f) {
            this.g = this.c.d();
        }
        return this.g;
    }

    private static d q(List list) {
        return list.isEmpty() ? new c() : list.size() == 1 ? new f(list) : new e(list);
    }

    public void a(b bVar) {
        this.a.add(bVar);
    }

    protected C24561yp3 b() {
        if (AbstractC6219Mr3.h()) {
            AbstractC6219Mr3.b("BaseKeyframeAnimation#getCurrentKeyframe");
        }
        C24561yp3 c24561yp3B = this.c.b();
        if (AbstractC6219Mr3.h()) {
            AbstractC6219Mr3.c("BaseKeyframeAnimation#getCurrentKeyframe");
        }
        return c24561yp3B;
    }

    float c() {
        if (this.h == -1.0f) {
            this.h = this.c.e();
        }
        return this.h;
    }

    protected float d() {
        Interpolator interpolator;
        C24561yp3 c24561yp3B = b();
        if (c24561yp3B == null || c24561yp3B.i() || (interpolator = c24561yp3B.d) == null) {
            return 0.0f;
        }
        return interpolator.getInterpolation(e());
    }

    float e() {
        if (this.b) {
            return 0.0f;
        }
        C24561yp3 c24561yp3B = b();
        if (c24561yp3B.i()) {
            return 0.0f;
        }
        return (this.d - c24561yp3B.f()) / (c24561yp3B.c() - c24561yp3B.f());
    }

    public float f() {
        return this.d;
    }

    public Object h() {
        float fE = e();
        if (this.e == null && this.c.a(fE) && !p()) {
            return this.f;
        }
        C24561yp3 c24561yp3B = b();
        Interpolator interpolator = c24561yp3B.e;
        Object objI = (interpolator == null || c24561yp3B.f == null) ? i(c24561yp3B, d()) : j(c24561yp3B, fE, interpolator.getInterpolation(fE), c24561yp3B.f.getInterpolation(fE));
        this.f = objI;
        return objI;
    }

    abstract Object i(C24561yp3 c24561yp3, float f2);

    protected Object j(C24561yp3 c24561yp3, float f2, float f3, float f4) {
        throw new UnsupportedOperationException("This animation does not support split dimensions!");
    }

    public boolean k() {
        return this.e != null;
    }

    public void l() {
        if (AbstractC6219Mr3.h()) {
            AbstractC6219Mr3.b("BaseKeyframeAnimation#notifyListeners");
        }
        for (int i = 0; i < this.a.size(); i++) {
            ((b) this.a.get(i)).a();
        }
        if (AbstractC6219Mr3.h()) {
            AbstractC6219Mr3.c("BaseKeyframeAnimation#notifyListeners");
        }
    }

    public void m() {
        this.b = true;
    }

    public void n(float f2) {
        if (AbstractC6219Mr3.h()) {
            AbstractC6219Mr3.b("BaseKeyframeAnimation#setProgress");
        }
        if (this.c.isEmpty()) {
            if (AbstractC6219Mr3.h()) {
                AbstractC6219Mr3.c("BaseKeyframeAnimation#setProgress");
                return;
            }
            return;
        }
        if (f2 < g()) {
            f2 = g();
        } else if (f2 > c()) {
            f2 = c();
        }
        if (f2 == this.d) {
            if (AbstractC6219Mr3.h()) {
                AbstractC6219Mr3.c("BaseKeyframeAnimation#setProgress");
            }
        } else {
            this.d = f2;
            if (this.c.c(f2)) {
                l();
            }
            if (AbstractC6219Mr3.h()) {
                AbstractC6219Mr3.c("BaseKeyframeAnimation#setProgress");
            }
        }
    }

    public void o(C13505gL3 c13505gL3) {
        C13505gL3 c13505gL32 = this.e;
        if (c13505gL32 != null) {
            c13505gL32.c(null);
        }
        this.e = c13505gL3;
        if (c13505gL3 != null) {
            c13505gL3.c(this);
        }
    }

    protected boolean p() {
        return false;
    }
}
