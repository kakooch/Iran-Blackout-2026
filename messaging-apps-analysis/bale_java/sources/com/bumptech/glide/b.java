package com.bumptech.glide;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.util.Log;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.load.engine.j;
import ir.nasim.AbstractC13438gE;
import ir.nasim.AbstractC18350oW3;
import ir.nasim.AbstractC3322Aj5;
import ir.nasim.C12361eU5;
import ir.nasim.C17491n33;
import ir.nasim.C20107rU5;
import ir.nasim.C20651sN3;
import ir.nasim.InterfaceC13106fg0;
import ir.nasim.InterfaceC21549tj7;
import ir.nasim.InterfaceC4688Gd1;
import ir.nasim.K34;
import ir.nasim.L34;
import ir.nasim.LJ;
import ir.nasim.YM7;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class b implements ComponentCallbacks2 {
    private static volatile b k;
    private static volatile boolean l;
    private final j a;
    private final InterfaceC13106fg0 b;
    private final K34 c;
    private final d d;
    private final LJ e;
    private final C12361eU5 f;
    private final InterfaceC4688Gd1 g;
    private final a i;
    private final List h = new ArrayList();
    private L34 j = L34.NORMAL;

    public interface a {
        C20107rU5 a();
    }

    b(Context context, j jVar, K34 k34, InterfaceC13106fg0 interfaceC13106fg0, LJ lj, C12361eU5 c12361eU5, InterfaceC4688Gd1 interfaceC4688Gd1, int i, a aVar, Map map, List list, List list2, AbstractC13438gE abstractC13438gE, e eVar) {
        this.a = jVar;
        this.b = interfaceC13106fg0;
        this.e = lj;
        this.c = k34;
        this.f = c12361eU5;
        this.g = interfaceC4688Gd1;
        this.i = aVar;
        this.d = new d(context, lj, f.d(this, list2, abstractC13438gE), new C17491n33(), aVar, map, list, jVar, eVar, i);
    }

    static void a(Context context, GeneratedAppGlideModule generatedAppGlideModule) {
        if (l) {
            throw new IllegalStateException("Glide has been called recursively, this is probably an internal library error!");
        }
        l = true;
        try {
            m(context, generatedAppGlideModule);
        } finally {
            l = false;
        }
    }

    public static b c(Context context) {
        if (k == null) {
            GeneratedAppGlideModule generatedAppGlideModuleD = d(context.getApplicationContext());
            synchronized (b.class) {
                try {
                    if (k == null) {
                        a(context, generatedAppGlideModuleD);
                    }
                } finally {
                }
            }
        }
        return k;
    }

    private static GeneratedAppGlideModule d(Context context) {
        try {
            return (GeneratedAppGlideModule) GeneratedAppGlideModuleImpl.class.getDeclaredConstructor(Context.class).newInstance(context.getApplicationContext());
        } catch (ClassNotFoundException unused) {
            if (Log.isLoggable("Glide", 5)) {
                Log.w("Glide", "Failed to find GeneratedAppGlideModule. You should include an annotationProcessor compile dependency on com.github.bumptech.glide:compiler in your application and a @GlideModule annotated AppGlideModule implementation or LibraryGlideModules will be silently ignored");
            }
            return null;
        } catch (IllegalAccessException e) {
            q(e);
            return null;
        } catch (InstantiationException e2) {
            q(e2);
            return null;
        } catch (NoSuchMethodException e3) {
            q(e3);
            return null;
        } catch (InvocationTargetException e4) {
            q(e4);
            return null;
        }
    }

    private static C12361eU5 l(Context context) {
        AbstractC3322Aj5.e(context, "You cannot start a load on a not yet attached View or a Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
        return c(context).k();
    }

    private static void m(Context context, GeneratedAppGlideModule generatedAppGlideModule) throws IllegalAccessException, InstantiationException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        n(context, new c(), generatedAppGlideModule);
    }

    private static void n(Context context, c cVar, GeneratedAppGlideModule generatedAppGlideModule) throws IllegalAccessException, InstantiationException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        Context applicationContext = context.getApplicationContext();
        List listEmptyList = Collections.emptyList();
        if (generatedAppGlideModule == null || generatedAppGlideModule.c()) {
            listEmptyList = new C20651sN3(applicationContext).b();
        }
        if (generatedAppGlideModule != null && !generatedAppGlideModule.d().isEmpty()) {
            generatedAppGlideModule.d();
            Iterator it = listEmptyList.iterator();
            if (it.hasNext()) {
                AbstractC18350oW3.a(it.next());
                throw null;
            }
        }
        if (Log.isLoggable("Glide", 3)) {
            Iterator it2 = listEmptyList.iterator();
            if (it2.hasNext()) {
                AbstractC18350oW3.a(it2.next());
                new StringBuilder().append("Discovered GlideModule from manifest: ");
                throw null;
            }
        }
        cVar.b(generatedAppGlideModule != null ? generatedAppGlideModule.e() : null);
        Iterator it3 = listEmptyList.iterator();
        if (it3.hasNext()) {
            AbstractC18350oW3.a(it3.next());
            throw null;
        }
        if (generatedAppGlideModule != null) {
            generatedAppGlideModule.b(applicationContext, cVar);
        }
        b bVarA = cVar.a(applicationContext, listEmptyList, generatedAppGlideModule);
        applicationContext.registerComponentCallbacks(bVarA);
        k = bVarA;
    }

    private static void q(Exception exc) {
        throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", exc);
    }

    public static h t(Context context) {
        return l(context).f(context);
    }

    public static h u(View view) {
        return l(view.getContext()).g(view);
    }

    public static h v(Fragment fragment) {
        return l(fragment.G5()).h(fragment);
    }

    public static h w(FragmentActivity fragmentActivity) {
        return l(fragmentActivity).i(fragmentActivity);
    }

    public void b() {
        YM7.b();
        this.c.b();
        this.b.b();
        this.e.b();
    }

    public LJ e() {
        return this.e;
    }

    public InterfaceC13106fg0 f() {
        return this.b;
    }

    InterfaceC4688Gd1 g() {
        return this.g;
    }

    public Context h() {
        return this.d.getBaseContext();
    }

    d i() {
        return this.d;
    }

    public Registry j() {
        return this.d.i();
    }

    public C12361eU5 k() {
        return this.f;
    }

    void o(h hVar) {
        synchronized (this.h) {
            try {
                if (this.h.contains(hVar)) {
                    throw new IllegalStateException("Cannot register already registered manager");
                }
                this.h.add(hVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        b();
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        r(i);
    }

    boolean p(InterfaceC21549tj7 interfaceC21549tj7) {
        synchronized (this.h) {
            try {
                Iterator it = this.h.iterator();
                while (it.hasNext()) {
                    if (((h) it.next()).G(interfaceC21549tj7)) {
                        return true;
                    }
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void r(int i) {
        YM7.b();
        synchronized (this.h) {
            try {
                Iterator it = this.h.iterator();
                while (it.hasNext()) {
                    ((h) it.next()).onTrimMemory(i);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.c.a(i);
        this.b.a(i);
        this.e.a(i);
    }

    void s(h hVar) {
        synchronized (this.h) {
            try {
                if (!this.h.contains(hVar)) {
                    throw new IllegalStateException("Cannot unregister not yet registered manager");
                }
                this.h.remove(hVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
