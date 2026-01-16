package ir.nasim;

import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.WindowInsets;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;

/* loaded from: classes2.dex */
public class O98 {
    public static final O98 b;
    private final l a;

    static class a {
        private static Field a;
        private static Field b;
        private static Field c;
        private static boolean d;

        static {
            try {
                Field declaredField = View.class.getDeclaredField("mAttachInfo");
                a = declaredField;
                declaredField.setAccessible(true);
                Class<?> cls = Class.forName("android.view.View$AttachInfo");
                Field declaredField2 = cls.getDeclaredField("mStableInsets");
                b = declaredField2;
                declaredField2.setAccessible(true);
                Field declaredField3 = cls.getDeclaredField("mContentInsets");
                c = declaredField3;
                declaredField3.setAccessible(true);
                d = true;
            } catch (ReflectiveOperationException e) {
                Log.w("WindowInsetsCompat", "Failed to get visible insets from AttachInfo " + e.getMessage(), e);
            }
        }

        public static O98 a(View view) throws IllegalAccessException, IllegalArgumentException {
            if (d && view.isAttachedToWindow()) {
                try {
                    Object obj = a.get(view.getRootView());
                    if (obj != null) {
                        Rect rect = (Rect) b.get(obj);
                        Rect rect2 = (Rect) c.get(obj);
                        if (rect != null && rect2 != null) {
                            O98 o98A = new b().c(L93.c(rect)).d(L93.c(rect2)).a();
                            o98A.w(o98A);
                            o98A.d(view.getRootView());
                            return o98A;
                        }
                    }
                } catch (IllegalAccessException e) {
                    Log.w("WindowInsetsCompat", "Failed to get insets from AttachInfo. " + e.getMessage(), e);
                }
            }
            return null;
        }
    }

    private static class e extends d {
        e() {
        }

        @Override // ir.nasim.O98.f
        void c(int i, L93 l93) {
            this.c.setInsets(n.a(i), l93.e());
        }

        @Override // ir.nasim.O98.f
        void i(int i, boolean z) {
            this.c.setVisible(n.a(i), z);
        }

        e(O98 o98) {
            super(o98);
        }
    }

    private static class f {
        private final O98 a;
        L93[] b;

        f() {
            this(new O98((O98) null));
        }

        protected final void a() {
            L93[] l93Arr = this.b;
            if (l93Arr != null) {
                L93 l93F = l93Arr[m.e(1)];
                L93 l93F2 = this.b[m.e(2)];
                if (l93F2 == null) {
                    l93F2 = this.a.f(2);
                }
                if (l93F == null) {
                    l93F = this.a.f(1);
                }
                g(L93.a(l93F, l93F2));
                L93 l93 = this.b[m.e(16)];
                if (l93 != null) {
                    f(l93);
                }
                L93 l932 = this.b[m.e(32)];
                if (l932 != null) {
                    d(l932);
                }
                L93 l933 = this.b[m.e(64)];
                if (l933 != null) {
                    h(l933);
                }
            }
        }

        abstract O98 b();

        void c(int i, L93 l93) {
            if (this.b == null) {
                this.b = new L93[9];
            }
            for (int i2 = 1; i2 <= 256; i2 <<= 1) {
                if ((i & i2) != 0) {
                    this.b[m.e(i2)] = l93;
                }
            }
        }

        abstract void e(L93 l93);

        abstract void g(L93 l93);

        f(O98 o98) {
            this.a = o98;
        }

        void d(L93 l93) {
        }

        void f(L93 l93) {
        }

        void h(L93 l93) {
        }

        void i(int i, boolean z) {
        }
    }

    private static class i extends h {
        i(O98 o98, WindowInsets windowInsets) {
            super(o98, windowInsets);
        }

        @Override // ir.nasim.O98.l
        O98 a() {
            return O98.z(this.c.consumeDisplayCutout());
        }

        @Override // ir.nasim.O98.g, ir.nasim.O98.l
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof i)) {
                return false;
            }
            i iVar = (i) obj;
            return Objects.equals(this.c, iVar.c) && Objects.equals(this.g, iVar.g);
        }

        @Override // ir.nasim.O98.l
        C20112rV1 f() {
            return C20112rV1.f(this.c.getDisplayCutout());
        }

        @Override // ir.nasim.O98.l
        public int hashCode() {
            return this.c.hashCode();
        }

        i(O98 o98, i iVar) {
            super(o98, iVar);
        }
    }

    private static class k extends j {
        static final O98 q = O98.z(WindowInsets.CONSUMED);

        k(O98 o98, WindowInsets windowInsets) {
            super(o98, windowInsets);
        }

        @Override // ir.nasim.O98.g, ir.nasim.O98.l
        public L93 g(int i) {
            return L93.d(this.c.getInsets(n.a(i)));
        }

        @Override // ir.nasim.O98.g, ir.nasim.O98.l
        public L93 h(int i) {
            return L93.d(this.c.getInsetsIgnoringVisibility(n.a(i)));
        }

        @Override // ir.nasim.O98.g, ir.nasim.O98.l
        public boolean q(int i) {
            return this.c.isVisible(n.a(i));
        }

        k(O98 o98, k kVar) {
            super(o98, kVar);
        }

        @Override // ir.nasim.O98.g, ir.nasim.O98.l
        final void d(View view) {
        }
    }

    public static final class m {
        static int a() {
            return -1;
        }

        public static int b() {
            return 4;
        }

        public static int c() {
            return 128;
        }

        public static int d() {
            return 8;
        }

        static int e(int i) {
            if (i == 1) {
                return 0;
            }
            if (i == 2) {
                return 1;
            }
            if (i == 4) {
                return 2;
            }
            if (i == 8) {
                return 3;
            }
            if (i == 16) {
                return 4;
            }
            if (i == 32) {
                return 5;
            }
            if (i == 64) {
                return 6;
            }
            if (i == 128) {
                return 7;
            }
            if (i == 256) {
                return 8;
            }
            throw new IllegalArgumentException("type needs to be >= FIRST and <= LAST, type=" + i);
        }

        public static int f() {
            return 32;
        }

        public static int g() {
            return 2;
        }

        public static int h() {
            return 1;
        }

        public static int i() {
            return 7;
        }

        public static int j() {
            return 16;
        }

        public static int k() {
            return 64;
        }
    }

    private static final class n {
        static int a(int i) {
            int iStatusBars;
            int i2 = 0;
            for (int i3 = 1; i3 <= 256; i3 <<= 1) {
                if ((i & i3) != 0) {
                    if (i3 == 1) {
                        iStatusBars = WindowInsets.Type.statusBars();
                    } else if (i3 == 2) {
                        iStatusBars = WindowInsets.Type.navigationBars();
                    } else if (i3 == 4) {
                        iStatusBars = WindowInsets.Type.captionBar();
                    } else if (i3 == 8) {
                        iStatusBars = WindowInsets.Type.ime();
                    } else if (i3 == 16) {
                        iStatusBars = WindowInsets.Type.systemGestures();
                    } else if (i3 == 32) {
                        iStatusBars = WindowInsets.Type.mandatorySystemGestures();
                    } else if (i3 == 64) {
                        iStatusBars = WindowInsets.Type.tappableElement();
                    } else if (i3 == 128) {
                        iStatusBars = WindowInsets.Type.displayCutout();
                    }
                    i2 |= iStatusBars;
                }
            }
            return i2;
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 30) {
            b = k.q;
        } else {
            b = l.b;
        }
    }

    private O98(WindowInsets windowInsets) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 30) {
            this.a = new k(this, windowInsets);
            return;
        }
        if (i2 >= 29) {
            this.a = new j(this, windowInsets);
        } else if (i2 >= 28) {
            this.a = new i(this, windowInsets);
        } else {
            this.a = new h(this, windowInsets);
        }
    }

    public static O98 A(WindowInsets windowInsets, View view) {
        O98 o98 = new O98((WindowInsets) AbstractC4980Hj5.g(windowInsets));
        if (view != null && view.isAttachedToWindow()) {
            o98.w(AbstractC12990fW7.H(view));
            o98.d(view.getRootView());
        }
        return o98;
    }

    static L93 q(L93 l93, int i2, int i3, int i4, int i5) {
        int iMax = Math.max(0, l93.a - i2);
        int iMax2 = Math.max(0, l93.b - i3);
        int iMax3 = Math.max(0, l93.c - i4);
        int iMax4 = Math.max(0, l93.d - i5);
        return (iMax == i2 && iMax2 == i3 && iMax3 == i4 && iMax4 == i5) ? l93 : L93.b(iMax, iMax2, iMax3, iMax4);
    }

    public static O98 z(WindowInsets windowInsets) {
        return A(windowInsets, null);
    }

    public O98 a() {
        return this.a.a();
    }

    public O98 b() {
        return this.a.b();
    }

    public O98 c() {
        return this.a.c();
    }

    void d(View view) {
        this.a.d(view);
    }

    public C20112rV1 e() {
        return this.a.f();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof O98) {
            return FG4.a(this.a, ((O98) obj).a);
        }
        return false;
    }

    public L93 f(int i2) {
        return this.a.g(i2);
    }

    public L93 g(int i2) {
        return this.a.h(i2);
    }

    public L93 h() {
        return this.a.j();
    }

    public int hashCode() {
        l lVar = this.a;
        if (lVar == null) {
            return 0;
        }
        return lVar.hashCode();
    }

    public L93 i() {
        return this.a.k();
    }

    public int j() {
        return this.a.l().d;
    }

    public int k() {
        return this.a.l().a;
    }

    public int l() {
        return this.a.l().c;
    }

    public int m() {
        return this.a.l().b;
    }

    public boolean n() {
        L93 l93F = f(m.a());
        L93 l93 = L93.e;
        return (l93F.equals(l93) && g(m.a() ^ m.d()).equals(l93) && e() == null) ? false : true;
    }

    public boolean o() {
        return !this.a.l().equals(L93.e);
    }

    public O98 p(int i2, int i3, int i4, int i5) {
        return this.a.n(i2, i3, i4, i5);
    }

    public boolean r() {
        return this.a.o();
    }

    public boolean s(int i2) {
        return this.a.q(i2);
    }

    public O98 t(int i2, int i3, int i4, int i5) {
        return new b(this).d(L93.b(i2, i3, i4, i5)).a();
    }

    void u(L93[] l93Arr) {
        this.a.r(l93Arr);
    }

    void v(L93 l93) {
        this.a.s(l93);
    }

    void w(O98 o98) {
        this.a.t(o98);
    }

    void x(L93 l93) {
        this.a.u(l93);
    }

    public WindowInsets y() {
        l lVar = this.a;
        if (lVar instanceof g) {
            return ((g) lVar).c;
        }
        return null;
    }

    private static class c extends f {
        private static Field e = null;
        private static boolean f = false;
        private static Constructor g = null;
        private static boolean h = false;
        private WindowInsets c;
        private L93 d;

        c() {
            this.c = j();
        }

        private static WindowInsets j() {
            if (!f) {
                try {
                    e = WindowInsets.class.getDeclaredField("CONSUMED");
                } catch (ReflectiveOperationException e2) {
                    Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets.CONSUMED field", e2);
                }
                f = true;
            }
            Field field = e;
            if (field != null) {
                try {
                    WindowInsets windowInsets = (WindowInsets) field.get(null);
                    if (windowInsets != null) {
                        return new WindowInsets(windowInsets);
                    }
                } catch (ReflectiveOperationException e3) {
                    Log.i("WindowInsetsCompat", "Could not get value from WindowInsets.CONSUMED field", e3);
                }
            }
            if (!h) {
                try {
                    g = WindowInsets.class.getConstructor(Rect.class);
                } catch (ReflectiveOperationException e4) {
                    Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets(Rect) constructor", e4);
                }
                h = true;
            }
            Constructor constructor = g;
            if (constructor != null) {
                try {
                    return (WindowInsets) constructor.newInstance(new Rect());
                } catch (ReflectiveOperationException e5) {
                    Log.i("WindowInsetsCompat", "Could not invoke WindowInsets(Rect) constructor", e5);
                }
            }
            return null;
        }

        @Override // ir.nasim.O98.f
        O98 b() {
            a();
            O98 o98Z = O98.z(this.c);
            o98Z.u(this.b);
            o98Z.x(this.d);
            return o98Z;
        }

        @Override // ir.nasim.O98.f
        void e(L93 l93) {
            this.d = l93;
        }

        @Override // ir.nasim.O98.f
        void g(L93 l93) {
            WindowInsets windowInsets = this.c;
            if (windowInsets != null) {
                this.c = windowInsets.replaceSystemWindowInsets(l93.a, l93.b, l93.c, l93.d);
            }
        }

        c(O98 o98) {
            super(o98);
            this.c = o98.y();
        }
    }

    private static class d extends f {
        final WindowInsets.Builder c;

        d() {
            this.c = EI6.a();
        }

        @Override // ir.nasim.O98.f
        O98 b() {
            a();
            O98 o98Z = O98.z(this.c.build());
            o98Z.u(this.b);
            return o98Z;
        }

        @Override // ir.nasim.O98.f
        void d(L93 l93) {
            this.c.setMandatorySystemGestureInsets(l93.e());
        }

        @Override // ir.nasim.O98.f
        void e(L93 l93) {
            this.c.setStableInsets(l93.e());
        }

        @Override // ir.nasim.O98.f
        void f(L93 l93) {
            this.c.setSystemGestureInsets(l93.e());
        }

        @Override // ir.nasim.O98.f
        void g(L93 l93) {
            this.c.setSystemWindowInsets(l93.e());
        }

        @Override // ir.nasim.O98.f
        void h(L93 l93) {
            this.c.setTappableElementInsets(l93.e());
        }

        d(O98 o98) {
            WindowInsets.Builder builderA;
            super(o98);
            WindowInsets windowInsetsY = o98.y();
            if (windowInsetsY != null) {
                builderA = U98.a(windowInsetsY);
            } else {
                builderA = EI6.a();
            }
            this.c = builderA;
        }
    }

    private static class h extends g {
        private L93 m;

        h(O98 o98, WindowInsets windowInsets) {
            super(o98, windowInsets);
            this.m = null;
        }

        @Override // ir.nasim.O98.l
        O98 b() {
            return O98.z(this.c.consumeStableInsets());
        }

        @Override // ir.nasim.O98.l
        O98 c() {
            return O98.z(this.c.consumeSystemWindowInsets());
        }

        @Override // ir.nasim.O98.l
        final L93 j() {
            if (this.m == null) {
                this.m = L93.b(this.c.getStableInsetLeft(), this.c.getStableInsetTop(), this.c.getStableInsetRight(), this.c.getStableInsetBottom());
            }
            return this.m;
        }

        @Override // ir.nasim.O98.l
        boolean o() {
            return this.c.isConsumed();
        }

        @Override // ir.nasim.O98.l
        public void u(L93 l93) {
            this.m = l93;
        }

        h(O98 o98, h hVar) {
            super(o98, hVar);
            this.m = null;
            this.m = hVar.m;
        }
    }

    private static class g extends l {
        private static boolean h = false;
        private static Method i;
        private static Class j;
        private static Field k;
        private static Field l;
        final WindowInsets c;
        private L93[] d;
        private L93 e;
        private O98 f;
        L93 g;

        g(O98 o98, WindowInsets windowInsets) {
            super(o98);
            this.e = null;
            this.c = windowInsets;
        }

        private static void A() throws ClassNotFoundException, SecurityException {
            try {
                i = View.class.getDeclaredMethod("getViewRootImpl", null);
                Class<?> cls = Class.forName("android.view.View$AttachInfo");
                j = cls;
                k = cls.getDeclaredField("mVisibleInsets");
                l = Class.forName("android.view.ViewRootImpl").getDeclaredField("mAttachInfo");
                k.setAccessible(true);
                l.setAccessible(true);
            } catch (ReflectiveOperationException e) {
                Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e.getMessage(), e);
            }
            h = true;
        }

        private L93 v(int i2, boolean z) {
            L93 l93A = L93.e;
            for (int i3 = 1; i3 <= 256; i3 <<= 1) {
                if ((i2 & i3) != 0) {
                    l93A = L93.a(l93A, w(i3, z));
                }
            }
            return l93A;
        }

        private L93 x() {
            O98 o98 = this.f;
            return o98 != null ? o98.h() : L93.e;
        }

        private L93 y(View view) throws IllegalAccessException, ClassNotFoundException, SecurityException, IllegalArgumentException, InvocationTargetException {
            if (Build.VERSION.SDK_INT >= 30) {
                throw new UnsupportedOperationException("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
            }
            if (!h) {
                A();
            }
            Method method = i;
            if (method != null && j != null && k != null) {
                try {
                    Object objInvoke = method.invoke(view, null);
                    if (objInvoke == null) {
                        Log.w("WindowInsetsCompat", "Failed to get visible insets. getViewRootImpl() returned null from the provided view. This means that the view is either not attached or the method has been overridden", new NullPointerException());
                        return null;
                    }
                    Rect rect = (Rect) k.get(l.get(objInvoke));
                    if (rect != null) {
                        return L93.c(rect);
                    }
                    return null;
                } catch (ReflectiveOperationException e) {
                    Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e.getMessage(), e);
                }
            }
            return null;
        }

        @Override // ir.nasim.O98.l
        void d(View view) throws IllegalAccessException, ClassNotFoundException, SecurityException, IllegalArgumentException, InvocationTargetException {
            L93 l93Y = y(view);
            if (l93Y == null) {
                l93Y = L93.e;
            }
            s(l93Y);
        }

        @Override // ir.nasim.O98.l
        void e(O98 o98) {
            o98.w(this.f);
            o98.v(this.g);
        }

        @Override // ir.nasim.O98.l
        public boolean equals(Object obj) {
            if (super.equals(obj)) {
                return Objects.equals(this.g, ((g) obj).g);
            }
            return false;
        }

        @Override // ir.nasim.O98.l
        public L93 g(int i2) {
            return v(i2, false);
        }

        @Override // ir.nasim.O98.l
        public L93 h(int i2) {
            return v(i2, true);
        }

        @Override // ir.nasim.O98.l
        final L93 l() {
            if (this.e == null) {
                this.e = L93.b(this.c.getSystemWindowInsetLeft(), this.c.getSystemWindowInsetTop(), this.c.getSystemWindowInsetRight(), this.c.getSystemWindowInsetBottom());
            }
            return this.e;
        }

        @Override // ir.nasim.O98.l
        O98 n(int i2, int i3, int i4, int i5) {
            b bVar = new b(O98.z(this.c));
            bVar.d(O98.q(l(), i2, i3, i4, i5));
            bVar.c(O98.q(j(), i2, i3, i4, i5));
            return bVar.a();
        }

        @Override // ir.nasim.O98.l
        boolean p() {
            return this.c.isRound();
        }

        @Override // ir.nasim.O98.l
        boolean q(int i2) {
            for (int i3 = 1; i3 <= 256; i3 <<= 1) {
                if ((i2 & i3) != 0 && !z(i3)) {
                    return false;
                }
            }
            return true;
        }

        @Override // ir.nasim.O98.l
        public void r(L93[] l93Arr) {
            this.d = l93Arr;
        }

        @Override // ir.nasim.O98.l
        void s(L93 l93) {
            this.g = l93;
        }

        @Override // ir.nasim.O98.l
        void t(O98 o98) {
            this.f = o98;
        }

        protected L93 w(int i2, boolean z) {
            L93 l93H;
            int i3;
            if (i2 == 1) {
                return z ? L93.b(0, Math.max(x().b, l().b), 0, 0) : L93.b(0, l().b, 0, 0);
            }
            if (i2 == 2) {
                if (z) {
                    L93 l93X = x();
                    L93 l93J = j();
                    return L93.b(Math.max(l93X.a, l93J.a), 0, Math.max(l93X.c, l93J.c), Math.max(l93X.d, l93J.d));
                }
                L93 l93L = l();
                O98 o98 = this.f;
                l93H = o98 != null ? o98.h() : null;
                int iMin = l93L.d;
                if (l93H != null) {
                    iMin = Math.min(iMin, l93H.d);
                }
                return L93.b(l93L.a, 0, l93L.c, iMin);
            }
            if (i2 != 8) {
                if (i2 == 16) {
                    return k();
                }
                if (i2 == 32) {
                    return i();
                }
                if (i2 == 64) {
                    return m();
                }
                if (i2 != 128) {
                    return L93.e;
                }
                O98 o982 = this.f;
                C20112rV1 c20112rV1E = o982 != null ? o982.e() : f();
                return c20112rV1E != null ? L93.b(c20112rV1E.b(), c20112rV1E.d(), c20112rV1E.c(), c20112rV1E.a()) : L93.e;
            }
            L93[] l93Arr = this.d;
            l93H = l93Arr != null ? l93Arr[m.e(8)] : null;
            if (l93H != null) {
                return l93H;
            }
            L93 l93L2 = l();
            L93 l93X2 = x();
            int i4 = l93L2.d;
            if (i4 > l93X2.d) {
                return L93.b(0, 0, 0, i4);
            }
            L93 l93 = this.g;
            return (l93 == null || l93.equals(L93.e) || (i3 = this.g.d) <= l93X2.d) ? L93.e : L93.b(0, 0, 0, i3);
        }

        protected boolean z(int i2) {
            if (i2 != 1 && i2 != 2) {
                if (i2 == 4) {
                    return false;
                }
                if (i2 != 8 && i2 != 128) {
                    return true;
                }
            }
            return !w(i2, false).equals(L93.e);
        }

        g(O98 o98, g gVar) {
            this(o98, new WindowInsets(gVar.c));
        }
    }

    private static class j extends i {
        private L93 n;
        private L93 o;
        private L93 p;

        j(O98 o98, WindowInsets windowInsets) {
            super(o98, windowInsets);
            this.n = null;
            this.o = null;
            this.p = null;
        }

        @Override // ir.nasim.O98.l
        L93 i() {
            if (this.o == null) {
                this.o = L93.d(this.c.getMandatorySystemGestureInsets());
            }
            return this.o;
        }

        @Override // ir.nasim.O98.l
        L93 k() {
            if (this.n == null) {
                this.n = L93.d(this.c.getSystemGestureInsets());
            }
            return this.n;
        }

        @Override // ir.nasim.O98.l
        L93 m() {
            if (this.p == null) {
                this.p = L93.d(this.c.getTappableElementInsets());
            }
            return this.p;
        }

        @Override // ir.nasim.O98.g, ir.nasim.O98.l
        O98 n(int i, int i2, int i3, int i4) {
            return O98.z(this.c.inset(i, i2, i3, i4));
        }

        j(O98 o98, j jVar) {
            super(o98, jVar);
            this.n = null;
            this.o = null;
            this.p = null;
        }

        @Override // ir.nasim.O98.h, ir.nasim.O98.l
        public void u(L93 l93) {
        }
    }

    public static final class b {
        private final f a;

        public b() {
            int i = Build.VERSION.SDK_INT;
            if (i >= 30) {
                this.a = new e();
            } else if (i >= 29) {
                this.a = new d();
            } else {
                this.a = new c();
            }
        }

        public O98 a() {
            return this.a.b();
        }

        public b b(int i, L93 l93) {
            this.a.c(i, l93);
            return this;
        }

        public b c(L93 l93) {
            this.a.e(l93);
            return this;
        }

        public b d(L93 l93) {
            this.a.g(l93);
            return this;
        }

        public b e(int i, boolean z) {
            this.a.i(i, z);
            return this;
        }

        public b(O98 o98) {
            int i = Build.VERSION.SDK_INT;
            if (i >= 30) {
                this.a = new e(o98);
            } else if (i >= 29) {
                this.a = new d(o98);
            } else {
                this.a = new c(o98);
            }
        }
    }

    public O98(O98 o98) {
        if (o98 != null) {
            l lVar = o98.a;
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 30 && (lVar instanceof k)) {
                this.a = new k(this, (k) lVar);
            } else if (i2 >= 29 && (lVar instanceof j)) {
                this.a = new j(this, (j) lVar);
            } else if (i2 >= 28 && (lVar instanceof i)) {
                this.a = new i(this, (i) lVar);
            } else if (lVar instanceof h) {
                this.a = new h(this, (h) lVar);
            } else if (lVar instanceof g) {
                this.a = new g(this, (g) lVar);
            } else {
                this.a = new l(this);
            }
            lVar.e(this);
            return;
        }
        this.a = new l(this);
    }

    private static class l {
        static final O98 b = new b().a().a().b().c();
        final O98 a;

        l(O98 o98) {
            this.a = o98;
        }

        O98 a() {
            return this.a;
        }

        O98 b() {
            return this.a;
        }

        O98 c() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof l)) {
                return false;
            }
            l lVar = (l) obj;
            return p() == lVar.p() && o() == lVar.o() && FG4.a(l(), lVar.l()) && FG4.a(j(), lVar.j()) && FG4.a(f(), lVar.f());
        }

        C20112rV1 f() {
            return null;
        }

        L93 g(int i) {
            return L93.e;
        }

        L93 h(int i) {
            if ((i & 8) == 0) {
                return L93.e;
            }
            throw new IllegalArgumentException("Unable to query the maximum insets for IME");
        }

        public int hashCode() {
            return FG4.b(Boolean.valueOf(p()), Boolean.valueOf(o()), l(), j(), f());
        }

        L93 i() {
            return l();
        }

        L93 j() {
            return L93.e;
        }

        L93 k() {
            return l();
        }

        L93 l() {
            return L93.e;
        }

        L93 m() {
            return l();
        }

        O98 n(int i, int i2, int i3, int i4) {
            return b;
        }

        boolean o() {
            return false;
        }

        boolean p() {
            return false;
        }

        boolean q(int i) {
            return true;
        }

        void d(View view) {
        }

        void e(O98 o98) {
        }

        public void r(L93[] l93Arr) {
        }

        void s(L93 l93) {
        }

        void t(O98 o98) {
        }

        public void u(L93 l93) {
        }
    }
}
