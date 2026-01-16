package ir.nasim;

import android.content.Context;
import android.content.ContextWrapper;
import android.view.LayoutInflater;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.j;

/* renamed from: ir.nasim.kW7, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C15990kW7 implements LE2 {
    private volatile Object a;
    private final Object b = new Object();
    private final boolean c;
    private final View d;

    /* renamed from: ir.nasim.kW7$b */
    public interface b {
        InterfaceC15399jW7 j();
    }

    /* renamed from: ir.nasim.kW7$c */
    public interface c {
        InterfaceC18372oY7 z();
    }

    public C15990kW7(View view, boolean z) {
        this.d = view;
        this.c = z;
    }

    private Object a() {
        LE2 le2B = b(false);
        return this.c ? ((c) D92.a(le2B, c.class)).z().b(this.d).a() : ((b) D92.a(le2B, b.class)).j().b(this.d).a();
    }

    private LE2 b(boolean z) {
        if (this.c) {
            Context contextC = c(a.class, z);
            if (contextC instanceof a) {
                return (LE2) ((a) contextC).d();
            }
            if (z) {
                return null;
            }
            AbstractC4497Fj5.d(!(r5 instanceof LE2), "%s, @WithFragmentBindings Hilt view must be attached to an @AndroidEntryPoint Fragment. Was attached to context %s", this.d.getClass(), c(LE2.class, z).getClass().getName());
        } else {
            Object objC = c(LE2.class, z);
            if (objC instanceof LE2) {
                return (LE2) objC;
            }
            if (z) {
                return null;
            }
        }
        throw new IllegalStateException(String.format("%s, Hilt view must be attached to an @AndroidEntryPoint Fragment or Activity.", this.d.getClass()));
    }

    private Context c(Class cls, boolean z) {
        Context contextD = d(this.d.getContext(), cls);
        if (contextD != AbstractC19095pm1.a(contextD.getApplicationContext())) {
            return contextD;
        }
        AbstractC4497Fj5.d(z, "%s, Hilt view cannot be created using the application context. Use a Hilt Fragment or Activity context.", this.d.getClass());
        return null;
    }

    private static Context d(Context context, Class cls) {
        while ((context instanceof ContextWrapper) && !cls.isInstance(context)) {
            context = ((ContextWrapper) context).getBaseContext();
        }
        return context;
    }

    @Override // ir.nasim.LE2
    public Object N2() {
        if (this.a == null) {
            synchronized (this.b) {
                try {
                    if (this.a == null) {
                        this.a = a();
                    }
                } finally {
                }
            }
        }
        return this.a;
    }

    /* renamed from: ir.nasim.kW7$a */
    public static final class a extends ContextWrapper {
        private Fragment a;
        private LayoutInflater b;
        private LayoutInflater c;
        private final androidx.lifecycle.n d;

        /* renamed from: ir.nasim.kW7$a$a, reason: collision with other inner class name */
        class C1352a implements androidx.lifecycle.n {
            C1352a() {
            }

            @Override // androidx.lifecycle.n
            public void s(InterfaceC18633oz3 interfaceC18633oz3, j.a aVar) {
                if (aVar == j.a.ON_DESTROY) {
                    a.this.a = null;
                    a.this.b = null;
                    a.this.c = null;
                }
            }
        }

        a(Context context, Fragment fragment) {
            super((Context) AbstractC4497Fj5.b(context));
            C1352a c1352a = new C1352a();
            this.d = c1352a;
            this.b = null;
            Fragment fragment2 = (Fragment) AbstractC4497Fj5.b(fragment);
            this.a = fragment2;
            fragment2.getLifecycle().a(c1352a);
        }

        Fragment d() {
            AbstractC4497Fj5.c(this.a, "The fragment has already been destroyed.");
            return this.a;
        }

        @Override // android.content.ContextWrapper, android.content.Context
        public Object getSystemService(String str) {
            if (!"layout_inflater".equals(str)) {
                return getBaseContext().getSystemService(str);
            }
            if (this.c == null) {
                if (this.b == null) {
                    this.b = (LayoutInflater) getBaseContext().getSystemService("layout_inflater");
                }
                this.c = this.b.cloneInContext(this);
            }
            return this.c;
        }

        a(LayoutInflater layoutInflater, Fragment fragment) {
            super((Context) AbstractC4497Fj5.b(((LayoutInflater) AbstractC4497Fj5.b(layoutInflater)).getContext()));
            C1352a c1352a = new C1352a();
            this.d = c1352a;
            this.b = layoutInflater;
            Fragment fragment2 = (Fragment) AbstractC4497Fj5.b(fragment);
            this.a = fragment2;
            fragment2.getLifecycle().a(c1352a);
        }
    }
}
