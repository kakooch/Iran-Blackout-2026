package ir.nasim;

import android.content.Context;
import ir.nasim.AbstractC8743Xd1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class Na8 implements AbstractC8743Xd1.a {
    private static final String d = HI3.f("WorkConstraintsTracker");
    private final Ma8 a;
    private final AbstractC8743Xd1[] b;
    private final Object c;

    public Na8(Context context, InterfaceC5684Kj7 interfaceC5684Kj7, Ma8 ma8) {
        Context applicationContext = context.getApplicationContext();
        this.a = ma8;
        this.b = new AbstractC8743Xd1[]{new C23848xd0(applicationContext, interfaceC5684Kj7), new C25032zd0(applicationContext, interfaceC5684Kj7), new NO6(applicationContext, interfaceC5684Kj7), new C7656Sq4(applicationContext, interfaceC5684Kj7), new C3866Cr4(applicationContext, interfaceC5684Kj7), new C15602jr4(applicationContext, interfaceC5684Kj7), new C13811gr4(applicationContext, interfaceC5684Kj7)};
        this.c = new Object();
    }

    @Override // ir.nasim.AbstractC8743Xd1.a
    public void a(List list) {
        synchronized (this.c) {
            try {
                ArrayList arrayList = new ArrayList();
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    String str = (String) it.next();
                    if (c(str)) {
                        HI3.c().a(d, String.format("Constraints met for %s", str), new Throwable[0]);
                        arrayList.add(str);
                    }
                }
                Ma8 ma8 = this.a;
                if (ma8 != null) {
                    ma8.e(arrayList);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // ir.nasim.AbstractC8743Xd1.a
    public void b(List list) {
        synchronized (this.c) {
            try {
                Ma8 ma8 = this.a;
                if (ma8 != null) {
                    ma8.b(list);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean c(String str) {
        synchronized (this.c) {
            try {
                for (AbstractC8743Xd1 abstractC8743Xd1 : this.b) {
                    if (abstractC8743Xd1.d(str)) {
                        HI3.c().a(d, String.format("Work %s constrained by %s", str, abstractC8743Xd1.getClass().getSimpleName()), new Throwable[0]);
                        return false;
                    }
                }
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void d(Iterable iterable) {
        synchronized (this.c) {
            try {
                for (AbstractC8743Xd1 abstractC8743Xd1 : this.b) {
                    abstractC8743Xd1.g(null);
                }
                for (AbstractC8743Xd1 abstractC8743Xd12 : this.b) {
                    abstractC8743Xd12.e(iterable);
                }
                for (AbstractC8743Xd1 abstractC8743Xd13 : this.b) {
                    abstractC8743Xd13.g(this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void e() {
        synchronized (this.c) {
            try {
                for (AbstractC8743Xd1 abstractC8743Xd1 : this.b) {
                    abstractC8743Xd1.f();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
