package ir.nasim;

import android.os.Looper;
import android.util.AndroidRuntimeException;
import android.view.View;
import ir.nasim.C3645Bt;
import java.util.ArrayList;

/* renamed from: ir.nasim.e22, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC12098e22 implements C3645Bt.b {
    public static final s m = new g("translationX");
    public static final s n = new h("translationY");
    public static final s o = new i("translationZ");
    public static final s p = new j("scaleX");
    public static final s q = new k("scaleY");
    public static final s r = new l("rotation");
    public static final s s = new m("rotationX");
    public static final s t = new n("rotationY");
    public static final s u = new o("x");
    public static final s v = new a("y");
    public static final s w = new b("z");
    public static final s x = new c("alpha");
    public static final s y = new d("scrollX");
    public static final s z = new e("scrollY");
    float a;
    float b;
    boolean c;
    final Object d;
    final AbstractC13799gq2 e;
    boolean f;
    float g;
    float h;
    private long i;
    private float j;
    private final ArrayList k;
    private final ArrayList l;

    /* renamed from: ir.nasim.e22$a */
    static class a extends s {
        a(String str) {
            super(str, null);
        }

        @Override // ir.nasim.AbstractC13799gq2
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getY();
        }

        @Override // ir.nasim.AbstractC13799gq2
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f) {
            view.setY(f);
        }
    }

    /* renamed from: ir.nasim.e22$b */
    static class b extends s {
        b(String str) {
            super(str, null);
        }

        @Override // ir.nasim.AbstractC13799gq2
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return AbstractC12990fW7.M(view);
        }

        @Override // ir.nasim.AbstractC13799gq2
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f) {
            AbstractC12990fW7.O0(view, f);
        }
    }

    /* renamed from: ir.nasim.e22$c */
    static class c extends s {
        c(String str) {
            super(str, null);
        }

        @Override // ir.nasim.AbstractC13799gq2
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getAlpha();
        }

        @Override // ir.nasim.AbstractC13799gq2
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f) {
            view.setAlpha(f);
        }
    }

    /* renamed from: ir.nasim.e22$d */
    static class d extends s {
        d(String str) {
            super(str, null);
        }

        @Override // ir.nasim.AbstractC13799gq2
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getScrollX();
        }

        @Override // ir.nasim.AbstractC13799gq2
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f) {
            view.setScrollX((int) f);
        }
    }

    /* renamed from: ir.nasim.e22$e */
    static class e extends s {
        e(String str) {
            super(str, null);
        }

        @Override // ir.nasim.AbstractC13799gq2
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getScrollY();
        }

        @Override // ir.nasim.AbstractC13799gq2
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f) {
            view.setScrollY((int) f);
        }
    }

    /* renamed from: ir.nasim.e22$f */
    class f extends AbstractC13799gq2 {
        final /* synthetic */ C19136pq2 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(String str, C19136pq2 c19136pq2) {
            super(str);
            this.b = c19136pq2;
        }

        @Override // ir.nasim.AbstractC13799gq2
        public float a(Object obj) {
            return this.b.a();
        }

        @Override // ir.nasim.AbstractC13799gq2
        public void b(Object obj, float f) {
            this.b.b(f);
        }
    }

    /* renamed from: ir.nasim.e22$g */
    static class g extends s {
        g(String str) {
            super(str, null);
        }

        @Override // ir.nasim.AbstractC13799gq2
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getTranslationX();
        }

        @Override // ir.nasim.AbstractC13799gq2
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f) {
            view.setTranslationX(f);
        }
    }

    /* renamed from: ir.nasim.e22$h */
    static class h extends s {
        h(String str) {
            super(str, null);
        }

        @Override // ir.nasim.AbstractC13799gq2
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getTranslationY();
        }

        @Override // ir.nasim.AbstractC13799gq2
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f) {
            view.setTranslationY(f);
        }
    }

    /* renamed from: ir.nasim.e22$i */
    static class i extends s {
        i(String str) {
            super(str, null);
        }

        @Override // ir.nasim.AbstractC13799gq2
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return AbstractC12990fW7.K(view);
        }

        @Override // ir.nasim.AbstractC13799gq2
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f) {
            AbstractC12990fW7.M0(view, f);
        }
    }

    /* renamed from: ir.nasim.e22$j */
    static class j extends s {
        j(String str) {
            super(str, null);
        }

        @Override // ir.nasim.AbstractC13799gq2
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getScaleX();
        }

        @Override // ir.nasim.AbstractC13799gq2
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f) {
            view.setScaleX(f);
        }
    }

    /* renamed from: ir.nasim.e22$k */
    static class k extends s {
        k(String str) {
            super(str, null);
        }

        @Override // ir.nasim.AbstractC13799gq2
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getScaleY();
        }

        @Override // ir.nasim.AbstractC13799gq2
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f) {
            view.setScaleY(f);
        }
    }

    /* renamed from: ir.nasim.e22$l */
    static class l extends s {
        l(String str) {
            super(str, null);
        }

        @Override // ir.nasim.AbstractC13799gq2
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getRotation();
        }

        @Override // ir.nasim.AbstractC13799gq2
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f) {
            view.setRotation(f);
        }
    }

    /* renamed from: ir.nasim.e22$m */
    static class m extends s {
        m(String str) {
            super(str, null);
        }

        @Override // ir.nasim.AbstractC13799gq2
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getRotationX();
        }

        @Override // ir.nasim.AbstractC13799gq2
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f) {
            view.setRotationX(f);
        }
    }

    /* renamed from: ir.nasim.e22$n */
    static class n extends s {
        n(String str) {
            super(str, null);
        }

        @Override // ir.nasim.AbstractC13799gq2
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getRotationY();
        }

        @Override // ir.nasim.AbstractC13799gq2
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f) {
            view.setRotationY(f);
        }
    }

    /* renamed from: ir.nasim.e22$o */
    static class o extends s {
        o(String str) {
            super(str, null);
        }

        @Override // ir.nasim.AbstractC13799gq2
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getX();
        }

        @Override // ir.nasim.AbstractC13799gq2
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f) {
            view.setX(f);
        }
    }

    /* renamed from: ir.nasim.e22$p */
    static class p {
        float a;
        float b;

        p() {
        }
    }

    /* renamed from: ir.nasim.e22$q */
    public interface q {
        void a(AbstractC12098e22 abstractC12098e22, boolean z, float f, float f2);
    }

    /* renamed from: ir.nasim.e22$r */
    public interface r {
        void a(AbstractC12098e22 abstractC12098e22, float f, float f2);
    }

    /* renamed from: ir.nasim.e22$s */
    public static abstract class s extends AbstractC13799gq2 {
        /* synthetic */ s(String str, g gVar) {
            this(str);
        }

        private s(String str) {
            super(str);
        }
    }

    AbstractC12098e22(C19136pq2 c19136pq2) {
        this.a = 0.0f;
        this.b = Float.MAX_VALUE;
        this.c = false;
        this.f = false;
        this.g = Float.MAX_VALUE;
        this.h = -Float.MAX_VALUE;
        this.i = 0L;
        this.k = new ArrayList();
        this.l = new ArrayList();
        this.d = null;
        this.e = new f("FloatValueHolder", c19136pq2);
        this.j = 1.0f;
    }

    private void e(boolean z2) {
        this.f = false;
        C3645Bt.d().g(this);
        this.i = 0L;
        this.c = false;
        for (int i2 = 0; i2 < this.k.size(); i2++) {
            if (this.k.get(i2) != null) {
                ((q) this.k.get(i2)).a(this, z2, this.b, this.a);
            }
        }
        k(this.k);
    }

    private float f() {
        return this.e.a(this.d);
    }

    private static void j(ArrayList arrayList, Object obj) {
        int iIndexOf = arrayList.indexOf(obj);
        if (iIndexOf >= 0) {
            arrayList.set(iIndexOf, null);
        }
    }

    private static void k(ArrayList arrayList) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size) == null) {
                arrayList.remove(size);
            }
        }
    }

    private void t() {
        if (this.f) {
            return;
        }
        this.f = true;
        if (!this.c) {
            this.b = f();
        }
        float f2 = this.b;
        if (f2 > this.g || f2 < this.h) {
            throw new IllegalArgumentException("Starting value need to be in between min value and max value");
        }
        C3645Bt.d().a(this, 0L);
    }

    @Override // ir.nasim.C3645Bt.b
    public boolean a(long j2) {
        long j3 = this.i;
        if (j3 == 0) {
            this.i = j2;
            o(this.b);
            return false;
        }
        this.i = j2;
        boolean zU = u(j2 - j3);
        float fMin = Math.min(this.b, this.g);
        this.b = fMin;
        float fMax = Math.max(fMin, this.h);
        this.b = fMax;
        o(fMax);
        if (zU) {
            e(false);
        }
        return zU;
    }

    public AbstractC12098e22 b(q qVar) {
        if (!this.k.contains(qVar)) {
            this.k.add(qVar);
        }
        return this;
    }

    public AbstractC12098e22 c(r rVar) {
        if (h()) {
            throw new UnsupportedOperationException("Error: Update listeners must be added beforethe animation.");
        }
        if (!this.l.contains(rVar)) {
            this.l.add(rVar);
        }
        return this;
    }

    public void d() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new AndroidRuntimeException("Animations may only be canceled on the main thread");
        }
        if (this.f) {
            e(true);
        }
    }

    float g() {
        return this.j * 0.75f;
    }

    public boolean h() {
        return this.f;
    }

    public void i(q qVar) {
        j(this.k, qVar);
    }

    public AbstractC12098e22 l(float f2) {
        this.g = f2;
        return this;
    }

    public AbstractC12098e22 m(float f2) {
        this.h = f2;
        return this;
    }

    public AbstractC12098e22 n(float f2) {
        if (f2 <= 0.0f) {
            throw new IllegalArgumentException("Minimum visible change must be positive.");
        }
        this.j = f2;
        r(f2 * 0.75f);
        return this;
    }

    void o(float f2) {
        this.e.b(this.d, f2);
        for (int i2 = 0; i2 < this.l.size(); i2++) {
            if (this.l.get(i2) != null) {
                ((r) this.l.get(i2)).a(this, this.b, this.a);
            }
        }
        k(this.l);
    }

    public AbstractC12098e22 p(float f2) {
        this.b = f2;
        this.c = true;
        return this;
    }

    public AbstractC12098e22 q(float f2) {
        this.a = f2;
        return this;
    }

    abstract void r(float f2);

    public void s() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new AndroidRuntimeException("Animations may only be started on the main thread");
        }
        if (this.f) {
            return;
        }
        t();
    }

    abstract boolean u(long j2);

    AbstractC12098e22(Object obj, AbstractC13799gq2 abstractC13799gq2) {
        this.a = 0.0f;
        this.b = Float.MAX_VALUE;
        this.c = false;
        this.f = false;
        this.g = Float.MAX_VALUE;
        this.h = -Float.MAX_VALUE;
        this.i = 0L;
        this.k = new ArrayList();
        this.l = new ArrayList();
        this.d = obj;
        this.e = abstractC13799gq2;
        if (abstractC13799gq2 != r && abstractC13799gq2 != s && abstractC13799gq2 != t) {
            if (abstractC13799gq2 == x) {
                this.j = 0.00390625f;
                return;
            } else if (abstractC13799gq2 != p && abstractC13799gq2 != q) {
                this.j = 1.0f;
                return;
            } else {
                this.j = 0.00390625f;
                return;
            }
        }
        this.j = 0.1f;
    }
}
