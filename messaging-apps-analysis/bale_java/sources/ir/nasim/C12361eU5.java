package ir.nasim;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* renamed from: ir.nasim.eU5, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C12361eU5 implements Handler.Callback {
    private static final b f = new a();
    private volatile com.bumptech.glide.h a;
    private final b b;
    private final KJ c = new KJ();
    private final InterfaceC7974Tz2 d;
    private final C20424rz3 e;

    /* renamed from: ir.nasim.eU5$a */
    class a implements b {
        a() {
        }

        @Override // ir.nasim.C12361eU5.b
        public com.bumptech.glide.h a(com.bumptech.glide.b bVar, InterfaceC11426cz3 interfaceC11426cz3, InterfaceC12970fU5 interfaceC12970fU5, Context context) {
            return new com.bumptech.glide.h(bVar, interfaceC11426cz3, interfaceC12970fU5, context);
        }
    }

    /* renamed from: ir.nasim.eU5$b */
    public interface b {
        com.bumptech.glide.h a(com.bumptech.glide.b bVar, InterfaceC11426cz3 interfaceC11426cz3, InterfaceC12970fU5 interfaceC12970fU5, Context context);
    }

    public C12361eU5(b bVar) {
        bVar = bVar == null ? f : bVar;
        this.b = bVar;
        this.e = new C20424rz3(bVar);
        this.d = b();
    }

    private static void a(Activity activity) {
        if (activity.isDestroyed()) {
            throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
        }
    }

    private static InterfaceC7974Tz2 b() {
        return (C18331oU2.f && C18331oU2.e) ? new C13198fp2() : new C17166mW1();
    }

    private static Activity c(Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return c(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    private static void d(Collection collection, Map map) {
        if (collection == null) {
            return;
        }
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            Fragment fragment = (Fragment) it.next();
            if (fragment != null && fragment.o6() != null) {
                map.put(fragment.o6(), fragment);
                d(fragment.F5().C0(), map);
            }
        }
    }

    private Fragment e(View view, FragmentActivity fragmentActivity) {
        this.c.clear();
        d(fragmentActivity.B0().C0(), this.c);
        View viewFindViewById = fragmentActivity.findViewById(android.R.id.content);
        Fragment fragment = null;
        while (!view.equals(viewFindViewById) && (fragment = (Fragment) this.c.get(view)) == null && (view.getParent() instanceof View)) {
            view = (View) view.getParent();
        }
        this.c.clear();
        return fragment;
    }

    private com.bumptech.glide.h j(Context context) {
        if (this.a == null) {
            synchronized (this) {
                try {
                    if (this.a == null) {
                        this.a = this.b.a(com.bumptech.glide.b.c(context.getApplicationContext()), new C13456gG(), new D72(), context.getApplicationContext());
                    }
                } finally {
                }
            }
        }
        return this.a;
    }

    private static boolean k(Context context) {
        Activity activityC = c(context);
        return activityC == null || !activityC.isFinishing();
    }

    public com.bumptech.glide.h f(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("You cannot start a load on a null Context");
        }
        if (YM7.t() && !(context instanceof Application)) {
            if (context instanceof FragmentActivity) {
                return i((FragmentActivity) context);
            }
            if (context instanceof ContextWrapper) {
                ContextWrapper contextWrapper = (ContextWrapper) context;
                if (contextWrapper.getBaseContext().getApplicationContext() != null) {
                    return f(contextWrapper.getBaseContext());
                }
            }
        }
        return j(context);
    }

    public com.bumptech.glide.h g(View view) {
        if (YM7.s()) {
            return f(view.getContext().getApplicationContext());
        }
        AbstractC3322Aj5.d(view);
        AbstractC3322Aj5.e(view.getContext(), "Unable to obtain a request manager for a view without a Context");
        Activity activityC = c(view.getContext());
        if (activityC == null) {
            return f(view.getContext().getApplicationContext());
        }
        if (!(activityC instanceof FragmentActivity)) {
            return f(view.getContext().getApplicationContext());
        }
        FragmentActivity fragmentActivity = (FragmentActivity) activityC;
        Fragment fragmentE = e(view, fragmentActivity);
        return fragmentE != null ? h(fragmentE) : i(fragmentActivity);
    }

    public com.bumptech.glide.h h(Fragment fragment) {
        AbstractC3322Aj5.e(fragment.G5(), "You cannot start a load on a fragment before it is attached or after it is destroyed");
        if (YM7.s()) {
            return f(fragment.G5().getApplicationContext());
        }
        if (fragment.A5() != null) {
            this.d.a(fragment.A5());
        }
        FragmentManager fragmentManagerF5 = fragment.F5();
        Context contextG5 = fragment.G5();
        return this.e.b(contextG5, com.bumptech.glide.b.c(contextG5.getApplicationContext()), fragment.getLifecycle(), fragmentManagerF5, fragment.D6());
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        return false;
    }

    public com.bumptech.glide.h i(FragmentActivity fragmentActivity) {
        if (YM7.s()) {
            return f(fragmentActivity.getApplicationContext());
        }
        a(fragmentActivity);
        this.d.a(fragmentActivity);
        boolean zK = k(fragmentActivity);
        return this.e.b(fragmentActivity, com.bumptech.glide.b.c(fragmentActivity.getApplicationContext()), fragmentActivity.getLifecycle(), fragmentActivity.B0(), zK);
    }
}
