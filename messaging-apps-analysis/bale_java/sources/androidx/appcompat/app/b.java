package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.app.LocaleManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.LocaleList;
import android.util.Log;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.window.OnBackInvokedDispatcher;
import androidx.appcompat.app.f;
import androidx.appcompat.widget.E;
import androidx.appcompat.widget.Toolbar;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import ir.nasim.C7139Ql0;
import ir.nasim.JH3;
import ir.nasim.OD;
import ir.nasim.PJ;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.Iterator;

/* loaded from: classes.dex */
public abstract class b {
    static f.a a = new f.a(new f.b());
    private static int b = -100;
    private static JH3 c = null;
    private static JH3 d = null;
    private static Boolean e = null;
    private static boolean f = false;
    private static final PJ g = new PJ();
    private static final Object h = new Object();
    private static final Object i = new Object();

    static class a {
        static LocaleList a(String str) {
            return LocaleList.forLanguageTags(str);
        }
    }

    /* renamed from: androidx.appcompat.app.b$b, reason: collision with other inner class name */
    static class C0012b {
        static LocaleList a(Object obj) {
            return ((LocaleManager) obj).getApplicationLocales();
        }

        static void b(Object obj, LocaleList localeList) {
            ((LocaleManager) obj).setApplicationLocales(localeList);
        }
    }

    b() {
    }

    static void G(b bVar) {
        synchronized (h) {
            H(bVar);
        }
    }

    private static void H(b bVar) {
        synchronized (h) {
            try {
                Iterator it = g.iterator();
                while (it.hasNext()) {
                    b bVar2 = (b) ((WeakReference) it.next()).get();
                    if (bVar2 == bVar || bVar2 == null) {
                        it.remove();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void J(boolean z) {
        E.c(z);
    }

    public static void N(int i2) {
        if (i2 != -1 && i2 != 0 && i2 != 1 && i2 != 2 && i2 != 3) {
            Log.d("AppCompatDelegate", "setDefaultNightMode() called with an unknown mode");
        } else if (b != i2) {
            b = i2;
            g();
        }
    }

    static void S(final Context context) {
        if (w(context)) {
            if (C7139Ql0.d()) {
                if (f) {
                    return;
                }
                a.execute(new Runnable() { // from class: ir.nasim.PD
                    @Override // java.lang.Runnable
                    public final void run() throws IOException {
                        androidx.appcompat.app.b.x(context);
                    }
                });
                return;
            }
            synchronized (i) {
                try {
                    JH3 jh3 = c;
                    if (jh3 == null) {
                        if (d == null) {
                            d = JH3.b(f.b(context));
                        }
                        if (d.e()) {
                        } else {
                            c = d;
                        }
                    } else if (!jh3.equals(d)) {
                        JH3 jh32 = c;
                        d = jh32;
                        f.a(context, jh32.g());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    static void d(b bVar) {
        synchronized (h) {
            H(bVar);
            g.add(new WeakReference(bVar));
        }
    }

    private static void g() {
        synchronized (h) {
            try {
                Iterator it = g.iterator();
                while (it.hasNext()) {
                    b bVar = (b) ((WeakReference) it.next()).get();
                    if (bVar != null) {
                        bVar.f();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static b j(Activity activity, OD od) {
        return new c(activity, od);
    }

    public static b k(Dialog dialog, OD od) {
        return new c(dialog, od);
    }

    public static JH3 m() {
        if (C7139Ql0.d()) {
            Object objQ = q();
            if (objQ != null) {
                return JH3.i(C0012b.a(objQ));
            }
        } else {
            JH3 jh3 = c;
            if (jh3 != null) {
                return jh3;
            }
        }
        return JH3.d();
    }

    public static int o() {
        return b;
    }

    static Object q() {
        Context contextN;
        Iterator it = g.iterator();
        while (it.hasNext()) {
            b bVar = (b) ((WeakReference) it.next()).get();
            if (bVar != null && (contextN = bVar.n()) != null) {
                return contextN.getSystemService(CommonUrlParts.LOCALE);
            }
        }
        return null;
    }

    static JH3 s() {
        return c;
    }

    static boolean w(Context context) {
        if (e == null) {
            try {
                Bundle bundle = AppLocalesMetadataHolderService.a(context).metaData;
                if (bundle != null) {
                    e = Boolean.valueOf(bundle.getBoolean("autoStoreLocales"));
                }
            } catch (PackageManager.NameNotFoundException unused) {
                Log.d("AppCompatDelegate", "Checking for metadata for AppLocalesMetadataHolderService : Service not found");
                e = Boolean.FALSE;
            }
        }
        return e.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void x(Context context) throws IOException {
        f.c(context);
        f = true;
    }

    public abstract void A();

    public abstract void B(Bundle bundle);

    public abstract void C();

    public abstract void D(Bundle bundle);

    public abstract void E();

    public abstract void F();

    public abstract boolean I(int i2);

    public abstract void K(int i2);

    public abstract void L(View view);

    public abstract void M(View view, ViewGroup.LayoutParams layoutParams);

    public void O(OnBackInvokedDispatcher onBackInvokedDispatcher) {
    }

    public abstract void P(Toolbar toolbar);

    public abstract void Q(int i2);

    public abstract void R(CharSequence charSequence);

    public abstract void e(View view, ViewGroup.LayoutParams layoutParams);

    public abstract boolean f();

    public void h(Context context) {
    }

    public Context i(Context context) {
        h(context);
        return context;
    }

    public abstract View l(int i2);

    public abstract Context n();

    public abstract int p();

    public abstract MenuInflater r();

    public abstract ActionBar t();

    public abstract void u();

    public abstract void v();

    public abstract void y(Configuration configuration);

    public abstract void z(Bundle bundle);
}
