package androidx.fragment.app;

import android.view.ViewGroup;
import androidx.lifecycle.j;
import ir.nasim.C4404Ez2;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public abstract class x {
    private final o a;
    private final ClassLoader b;
    int d;
    int e;
    int f;
    int g;
    int h;
    boolean i;
    String k;
    int l;
    CharSequence m;
    int n;
    CharSequence o;
    ArrayList p;
    ArrayList q;
    ArrayList s;
    ArrayList c = new ArrayList();
    boolean j = true;
    boolean r = false;

    static final class a {
        int a;
        Fragment b;
        boolean c;
        int d;
        int e;
        int f;
        int g;
        j.b h;
        j.b i;

        a() {
        }

        a(int i, Fragment fragment) {
            this.a = i;
            this.b = fragment;
            this.c = false;
            j.b bVar = j.b.RESUMED;
            this.h = bVar;
            this.i = bVar;
        }

        a(int i, Fragment fragment, boolean z) {
            this.a = i;
            this.b = fragment;
            this.c = z;
            j.b bVar = j.b.RESUMED;
            this.h = bVar;
            this.i = bVar;
        }

        a(int i, Fragment fragment, j.b bVar) {
            this.a = i;
            this.b = fragment;
            this.c = false;
            this.h = fragment.L0;
            this.i = bVar;
        }
    }

    x(o oVar, ClassLoader classLoader) {
        this.a = oVar;
        this.b = classLoader;
    }

    public x b(int i, Fragment fragment) {
        m(i, fragment, null, 1);
        return this;
    }

    public x c(int i, Fragment fragment, String str) {
        m(i, fragment, str, 1);
        return this;
    }

    public final x d(ViewGroup viewGroup, Fragment fragment, String str) {
        fragment.A0 = viewGroup;
        fragment.r = true;
        return c(viewGroup.getId(), fragment, str);
    }

    public x e(Fragment fragment, String str) {
        m(0, fragment, str, 1);
        return this;
    }

    void f(a aVar) {
        this.c.add(aVar);
        aVar.d = this.d;
        aVar.e = this.e;
        aVar.f = this.f;
        aVar.g = this.g;
    }

    public x g(String str) {
        if (!this.j) {
            throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
        }
        this.i = true;
        this.k = str;
        return this;
    }

    public abstract int h();

    public abstract int i();

    public abstract void j();

    public abstract void k();

    public x l() {
        if (this.i) {
            throw new IllegalStateException("This transaction is already being added to the back stack");
        }
        this.j = false;
        return this;
    }

    void m(int i, Fragment fragment, String str, int i2) {
        String str2 = fragment.K0;
        if (str2 != null) {
            C4404Ez2.f(fragment, str2);
        }
        Class<?> cls = fragment.getClass();
        int modifiers = cls.getModifiers();
        if (cls.isAnonymousClass() || !Modifier.isPublic(modifiers) || (cls.isMemberClass() && !Modifier.isStatic(modifiers))) {
            throw new IllegalStateException("Fragment " + cls.getCanonicalName() + " must be a public static class to be  properly recreated from instance state.");
        }
        if (str != null) {
            String str3 = fragment.B;
            if (str3 != null && !str.equals(str3)) {
                throw new IllegalStateException("Can't change tag of fragment " + fragment + ": was " + fragment.B + " now " + str);
            }
            fragment.B = str;
        }
        if (i != 0) {
            if (i == -1) {
                throw new IllegalArgumentException("Can't add fragment " + fragment + " with tag " + str + " to container view with no id");
            }
            int i3 = fragment.z;
            if (i3 != 0 && i3 != i) {
                throw new IllegalStateException("Can't change container ID of fragment " + fragment + ": was " + fragment.z + " now " + i);
            }
            fragment.z = i;
            fragment.A = i;
        }
        f(new a(i2, fragment));
    }

    public x n(Fragment fragment) {
        f(new a(4, fragment));
        return this;
    }

    public abstract boolean o();

    public x p(Fragment fragment) {
        f(new a(3, fragment));
        return this;
    }

    public x q(int i, Fragment fragment) {
        return r(i, fragment, null);
    }

    public x r(int i, Fragment fragment, String str) {
        if (i == 0) {
            throw new IllegalArgumentException("Must use non-zero containerViewId");
        }
        m(i, fragment, str, 2);
        return this;
    }

    x s(boolean z, Runnable runnable) {
        if (!z) {
            l();
        }
        if (this.s == null) {
            this.s = new ArrayList();
        }
        this.s.add(runnable);
        return this;
    }

    public x t(int i, int i2, int i3, int i4) {
        this.d = i;
        this.e = i2;
        this.f = i3;
        this.g = i4;
        return this;
    }

    public x u(Fragment fragment, j.b bVar) {
        f(new a(10, fragment, bVar));
        return this;
    }

    public x v(boolean z) {
        this.r = z;
        return this;
    }

    public x w(int i) {
        this.h = i;
        return this;
    }

    public x x(Fragment fragment) {
        f(new a(5, fragment));
        return this;
    }
}
