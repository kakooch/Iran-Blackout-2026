package ir.nasim;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.WindowInsetsAnimation;
import android.view.WindowInsetsAnimation$Callback;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import ir.nasim.O98;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class B98 {
    private e a;

    private static class c extends e {
        private static final Interpolator e = new PathInterpolator(0.0f, 1.1f, 0.0f, 1.0f);
        private static final Interpolator f = new C20827sg2();
        private static final Interpolator g = new DecelerateInterpolator();

        private static class a implements View.OnApplyWindowInsetsListener {
            final b a;
            private O98 b;

            /* renamed from: ir.nasim.B98$c$a$a, reason: collision with other inner class name */
            class C0273a implements ValueAnimator.AnimatorUpdateListener {
                final /* synthetic */ B98 a;
                final /* synthetic */ O98 b;
                final /* synthetic */ O98 c;
                final /* synthetic */ int d;
                final /* synthetic */ View e;

                C0273a(B98 b98, O98 o98, O98 o982, int i, View view) {
                    this.a = b98;
                    this.b = o98;
                    this.c = o982;
                    this.d = i;
                    this.e = view;
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    this.a.e(valueAnimator.getAnimatedFraction());
                    c.k(this.e, c.o(this.b, this.c, this.a.b(), this.d), Collections.singletonList(this.a));
                }
            }

            class b extends AnimatorListenerAdapter {
                final /* synthetic */ B98 a;
                final /* synthetic */ View b;

                b(B98 b98, View view) {
                    this.a = b98;
                    this.b = view;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    this.a.e(1.0f);
                    c.i(this.b, this.a);
                }
            }

            /* renamed from: ir.nasim.B98$c$a$c, reason: collision with other inner class name */
            class RunnableC0274c implements Runnable {
                final /* synthetic */ View a;
                final /* synthetic */ B98 b;
                final /* synthetic */ a c;
                final /* synthetic */ ValueAnimator d;

                RunnableC0274c(View view, B98 b98, a aVar, ValueAnimator valueAnimator) {
                    this.a = view;
                    this.b = b98;
                    this.c = aVar;
                    this.d = valueAnimator;
                }

                @Override // java.lang.Runnable
                public void run() {
                    c.l(this.a, this.b, this.c);
                    this.d.start();
                }
            }

            a(View view, b bVar) {
                this.a = bVar;
                O98 o98H = AbstractC12990fW7.H(view);
                this.b = o98H != null ? new O98.b(o98H).a() : null;
            }

            @Override // android.view.View.OnApplyWindowInsetsListener
            public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                if (!view.isLaidOut()) {
                    this.b = O98.A(windowInsets, view);
                    return c.m(view, windowInsets);
                }
                O98 o98A = O98.A(windowInsets, view);
                if (this.b == null) {
                    this.b = AbstractC12990fW7.H(view);
                }
                if (this.b == null) {
                    this.b = o98A;
                    return c.m(view, windowInsets);
                }
                b bVarN = c.n(view);
                if (bVarN != null && Objects.equals(bVarN.a, windowInsets)) {
                    return c.m(view, windowInsets);
                }
                int iE = c.e(o98A, this.b);
                if (iE == 0) {
                    return c.m(view, windowInsets);
                }
                O98 o98 = this.b;
                B98 b98 = new B98(iE, c.g(iE, o98A, o98), 160L);
                b98.e(0.0f);
                ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(b98.a());
                a aVarF = c.f(o98A, o98, iE);
                c.j(view, b98, windowInsets, false);
                duration.addUpdateListener(new C0273a(b98, o98A, o98, iE, view));
                duration.addListener(new b(b98, view));
                OK4.a(view, new RunnableC0274c(view, b98, aVarF, duration));
                this.b = o98A;
                return c.m(view, windowInsets);
            }
        }

        c(int i, Interpolator interpolator, long j) {
            super(i, interpolator, j);
        }

        static int e(O98 o98, O98 o982) {
            int i = 0;
            for (int i2 = 1; i2 <= 256; i2 <<= 1) {
                if (!o98.f(i2).equals(o982.f(i2))) {
                    i |= i2;
                }
            }
            return i;
        }

        static a f(O98 o98, O98 o982, int i) {
            L93 l93F = o98.f(i);
            L93 l93F2 = o982.f(i);
            return new a(L93.b(Math.min(l93F.a, l93F2.a), Math.min(l93F.b, l93F2.b), Math.min(l93F.c, l93F2.c), Math.min(l93F.d, l93F2.d)), L93.b(Math.max(l93F.a, l93F2.a), Math.max(l93F.b, l93F2.b), Math.max(l93F.c, l93F2.c), Math.max(l93F.d, l93F2.d)));
        }

        static Interpolator g(int i, O98 o98, O98 o982) {
            return (i & 8) != 0 ? o98.f(O98.m.d()).d > o982.f(O98.m.d()).d ? e : f : g;
        }

        private static View.OnApplyWindowInsetsListener h(View view, b bVar) {
            return new a(view, bVar);
        }

        static void i(View view, B98 b98) {
            b bVarN = n(view);
            if (bVarN != null) {
                bVarN.c(b98);
                if (bVarN.a() == 0) {
                    return;
                }
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i = 0; i < viewGroup.getChildCount(); i++) {
                    i(viewGroup.getChildAt(i), b98);
                }
            }
        }

        static void j(View view, B98 b98, WindowInsets windowInsets, boolean z) {
            b bVarN = n(view);
            if (bVarN != null) {
                bVarN.a = windowInsets;
                if (!z) {
                    bVarN.d(b98);
                    z = bVarN.a() == 0;
                }
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i = 0; i < viewGroup.getChildCount(); i++) {
                    j(viewGroup.getChildAt(i), b98, windowInsets, z);
                }
            }
        }

        static void k(View view, O98 o98, List list) {
            b bVarN = n(view);
            if (bVarN != null) {
                o98 = bVarN.e(o98, list);
                if (bVarN.a() == 0) {
                    return;
                }
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i = 0; i < viewGroup.getChildCount(); i++) {
                    k(viewGroup.getChildAt(i), o98, list);
                }
            }
        }

        static void l(View view, B98 b98, a aVar) {
            b bVarN = n(view);
            if (bVarN != null) {
                bVarN.f(b98, aVar);
                if (bVarN.a() == 0) {
                    return;
                }
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i = 0; i < viewGroup.getChildCount(); i++) {
                    l(viewGroup.getChildAt(i), b98, aVar);
                }
            }
        }

        static WindowInsets m(View view, WindowInsets windowInsets) {
            return view.getTag(AbstractC24197yC5.tag_on_apply_window_listener) != null ? windowInsets : view.onApplyWindowInsets(windowInsets);
        }

        static b n(View view) {
            Object tag = view.getTag(AbstractC24197yC5.tag_window_insets_animation_callback);
            if (tag instanceof a) {
                return ((a) tag).a;
            }
            return null;
        }

        static O98 o(O98 o98, O98 o982, float f2, int i) {
            O98.b bVar = new O98.b(o98);
            for (int i2 = 1; i2 <= 256; i2 <<= 1) {
                if ((i & i2) == 0) {
                    bVar.b(i2, o98.f(i2));
                } else {
                    L93 l93F = o98.f(i2);
                    L93 l93F2 = o982.f(i2);
                    float f3 = 1.0f - f2;
                    bVar.b(i2, O98.q(l93F, (int) (((l93F.a - l93F2.a) * f3) + 0.5d), (int) (((l93F.b - l93F2.b) * f3) + 0.5d), (int) (((l93F.c - l93F2.c) * f3) + 0.5d), (int) (((l93F.d - l93F2.d) * f3) + 0.5d)));
                }
            }
            return bVar.a();
        }

        static void p(View view, b bVar) {
            Object tag = view.getTag(AbstractC24197yC5.tag_on_apply_window_listener);
            if (bVar == null) {
                view.setTag(AbstractC24197yC5.tag_window_insets_animation_callback, null);
                if (tag == null) {
                    view.setOnApplyWindowInsetsListener(null);
                    return;
                }
                return;
            }
            View.OnApplyWindowInsetsListener onApplyWindowInsetsListenerH = h(view, bVar);
            view.setTag(AbstractC24197yC5.tag_window_insets_animation_callback, onApplyWindowInsetsListenerH);
            if (tag == null) {
                view.setOnApplyWindowInsetsListener(onApplyWindowInsetsListenerH);
            }
        }
    }

    private static class e {
        private final int a;
        private float b;
        private final Interpolator c;
        private final long d;

        e(int i, Interpolator interpolator, long j) {
            this.a = i;
            this.c = interpolator;
            this.d = j;
        }

        public long a() {
            return this.d;
        }

        public float b() {
            Interpolator interpolator = this.c;
            return interpolator != null ? interpolator.getInterpolation(this.b) : this.b;
        }

        public int c() {
            return this.a;
        }

        public void d(float f) {
            this.b = f;
        }
    }

    public B98(int i, Interpolator interpolator, long j) {
        if (Build.VERSION.SDK_INT >= 30) {
            this.a = new d(i, interpolator, j);
        } else {
            this.a = new c(i, interpolator, j);
        }
    }

    static void d(View view, b bVar) {
        if (Build.VERSION.SDK_INT >= 30) {
            d.h(view, bVar);
        } else {
            c.p(view, bVar);
        }
    }

    static B98 f(WindowInsetsAnimation windowInsetsAnimation) {
        return new B98(windowInsetsAnimation);
    }

    public long a() {
        return this.a.a();
    }

    public float b() {
        return this.a.b();
    }

    public int c() {
        return this.a.c();
    }

    public void e(float f) {
        this.a.d(f);
    }

    private static class d extends e {
        private final WindowInsetsAnimation e;

        private static class a extends WindowInsetsAnimation$Callback {
            private final b a;
            private List b;
            private ArrayList c;
            private final HashMap d;

            a(b bVar) {
                super(bVar.a());
                this.d = new HashMap();
                this.a = bVar;
            }

            private B98 a(WindowInsetsAnimation windowInsetsAnimation) {
                B98 b98 = (B98) this.d.get(windowInsetsAnimation);
                if (b98 != null) {
                    return b98;
                }
                B98 b98F = B98.f(windowInsetsAnimation);
                this.d.put(windowInsetsAnimation, b98F);
                return b98F;
            }

            public void onEnd(WindowInsetsAnimation windowInsetsAnimation) {
                this.a.c(a(windowInsetsAnimation));
                this.d.remove(windowInsetsAnimation);
            }

            public void onPrepare(WindowInsetsAnimation windowInsetsAnimation) {
                this.a.d(a(windowInsetsAnimation));
            }

            public WindowInsets onProgress(WindowInsets windowInsets, List list) {
                ArrayList arrayList = this.c;
                if (arrayList == null) {
                    ArrayList arrayList2 = new ArrayList(list.size());
                    this.c = arrayList2;
                    this.b = Collections.unmodifiableList(arrayList2);
                } else {
                    arrayList.clear();
                }
                for (int size = list.size() - 1; size >= 0; size--) {
                    WindowInsetsAnimation windowInsetsAnimationA = M98.a(list.get(size));
                    B98 b98A = a(windowInsetsAnimationA);
                    b98A.e(windowInsetsAnimationA.getFraction());
                    this.c.add(b98A);
                }
                return this.a.e(O98.z(windowInsets), this.b).y();
            }

            public WindowInsetsAnimation.Bounds onStart(WindowInsetsAnimation windowInsetsAnimation, WindowInsetsAnimation.Bounds bounds) {
                return this.a.f(a(windowInsetsAnimation), a.e(bounds)).d();
            }
        }

        d(WindowInsetsAnimation windowInsetsAnimation) {
            super(0, null, 0L);
            this.e = windowInsetsAnimation;
        }

        public static WindowInsetsAnimation.Bounds e(a aVar) {
            K98.a();
            return J98.a(aVar.a().e(), aVar.b().e());
        }

        public static L93 f(WindowInsetsAnimation.Bounds bounds) {
            return L93.d(bounds.getUpperBound());
        }

        public static L93 g(WindowInsetsAnimation.Bounds bounds) {
            return L93.d(bounds.getLowerBound());
        }

        public static void h(View view, b bVar) {
            view.setWindowInsetsAnimationCallback(bVar != null ? new a(bVar) : null);
        }

        @Override // ir.nasim.B98.e
        public long a() {
            return this.e.getDurationMillis();
        }

        @Override // ir.nasim.B98.e
        public float b() {
            return this.e.getInterpolatedFraction();
        }

        @Override // ir.nasim.B98.e
        public int c() {
            return this.e.getTypeMask();
        }

        @Override // ir.nasim.B98.e
        public void d(float f) {
            this.e.setFraction(f);
        }

        d(int i, Interpolator interpolator, long j) {
            this(I98.a(i, interpolator, j));
        }
    }

    public static final class a {
        private final L93 a;
        private final L93 b;

        public a(L93 l93, L93 l932) {
            this.a = l93;
            this.b = l932;
        }

        public static a e(WindowInsetsAnimation.Bounds bounds) {
            return new a(bounds);
        }

        public L93 a() {
            return this.a;
        }

        public L93 b() {
            return this.b;
        }

        public a c(L93 l93) {
            return new a(O98.q(this.a, l93.a, l93.b, l93.c, l93.d), O98.q(this.b, l93.a, l93.b, l93.c, l93.d));
        }

        public WindowInsetsAnimation.Bounds d() {
            return d.e(this);
        }

        public String toString() {
            return "Bounds{lower=" + this.a + " upper=" + this.b + "}";
        }

        private a(WindowInsetsAnimation.Bounds bounds) {
            this.a = d.g(bounds);
            this.b = d.f(bounds);
        }
    }

    private B98(WindowInsetsAnimation windowInsetsAnimation) {
        this(0, null, 0L);
        if (Build.VERSION.SDK_INT >= 30) {
            this.a = new d(windowInsetsAnimation);
        }
    }

    public static abstract class b {
        WindowInsets a;
        private final int b;

        public b(int i) {
            this.b = i;
        }

        public final int a() {
            return this.b;
        }

        public abstract O98 e(O98 o98, List list);

        public void c(B98 b98) {
        }

        public void d(B98 b98) {
        }

        public a f(B98 b98, a aVar) {
            return aVar;
        }
    }
}
