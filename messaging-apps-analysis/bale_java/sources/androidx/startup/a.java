package androidx.startup;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import ir.nasim.AbstractC10810cE5;
import ir.nasim.C16807lt7;
import ir.nasim.E73;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
public final class a {
    private static volatile a d;
    private static final Object e = new Object();
    final Context c;
    final Set b = new HashSet();
    final Map a = new HashMap();

    a(Context context) {
        this.c = context.getApplicationContext();
    }

    private Object d(Class cls, Set set) {
        Object objA;
        if (C16807lt7.d()) {
            try {
                C16807lt7.a(cls.getSimpleName());
            } catch (Throwable th) {
                C16807lt7.b();
                throw th;
            }
        }
        if (set.contains(cls)) {
            throw new IllegalStateException(String.format("Cannot initialize %s. Cycle detected.", cls.getName()));
        }
        if (this.a.containsKey(cls)) {
            objA = this.a.get(cls);
        } else {
            set.add(cls);
            try {
                E73 e73 = (E73) cls.getDeclaredConstructor(null).newInstance(null);
                List<Class> listB = e73.b();
                if (!listB.isEmpty()) {
                    for (Class cls2 : listB) {
                        if (!this.a.containsKey(cls2)) {
                            d(cls2, set);
                        }
                    }
                }
                objA = e73.a(this.c);
                set.remove(cls);
                this.a.put(cls, objA);
            } catch (Throwable th2) {
                throw new StartupException(th2);
            }
        }
        C16807lt7.b();
        return objA;
    }

    public static a e(Context context) {
        if (d == null) {
            synchronized (e) {
                try {
                    if (d == null) {
                        d = new a(context);
                    }
                } finally {
                }
            }
        }
        return d;
    }

    void a() {
        try {
            try {
                C16807lt7.a("Startup");
                b(this.c.getPackageManager().getProviderInfo(new ComponentName(this.c.getPackageName(), InitializationProvider.class.getName()), 128).metaData);
            } catch (PackageManager.NameNotFoundException e2) {
                throw new StartupException(e2);
            }
        } finally {
            C16807lt7.b();
        }
    }

    void b(Bundle bundle) throws ClassNotFoundException {
        String string = this.c.getString(AbstractC10810cE5.androidx_startup);
        if (bundle != null) {
            try {
                HashSet hashSet = new HashSet();
                for (String str : bundle.keySet()) {
                    if (string.equals(bundle.getString(str, null))) {
                        Class<?> cls = Class.forName(str);
                        if (E73.class.isAssignableFrom(cls)) {
                            this.b.add(cls);
                        }
                    }
                }
                Iterator it = this.b.iterator();
                while (it.hasNext()) {
                    d((Class) it.next(), hashSet);
                }
            } catch (ClassNotFoundException e2) {
                throw new StartupException(e2);
            }
        }
    }

    Object c(Class cls) {
        Object objD;
        synchronized (e) {
            try {
                objD = this.a.get(cls);
                if (objD == null) {
                    objD = d(cls, new HashSet());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return objD;
    }

    public Object f(Class cls) {
        return c(cls);
    }

    public boolean g(Class cls) {
        return this.b.contains(cls);
    }
}
