package ir.nasim;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import ir.nasim.AbstractC6245Mu2;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* renamed from: ir.nasim.ru2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
abstract class AbstractC20376ru2 {
    static final C17660nL3 a = new C17660nL3(16);
    private static final ExecutorService b = AbstractC17716nR5.a("fonts-androidx", 10, AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_COUNT_UPPER_BOUND);
    static final Object c = new Object();
    static final C24792zC6 d = new C24792zC6();

    /* renamed from: ir.nasim.ru2$a */
    class a implements Callable {
        final /* synthetic */ String a;
        final /* synthetic */ Context b;
        final /* synthetic */ C19767qu2 c;
        final /* synthetic */ int d;

        a(String str, Context context, C19767qu2 c19767qu2, int i) {
            this.a = str;
            this.b = context;
            this.c = c19767qu2;
            this.d = i;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public e call() {
            return AbstractC20376ru2.c(this.a, this.b, this.c, this.d);
        }
    }

    /* renamed from: ir.nasim.ru2$b */
    class b implements InterfaceC25043ze1 {
        final /* synthetic */ C17558nA0 a;

        b(C17558nA0 c17558nA0) {
            this.a = c17558nA0;
        }

        @Override // ir.nasim.InterfaceC25043ze1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(e eVar) {
            if (eVar == null) {
                eVar = new e(-3);
            }
            this.a.b(eVar);
        }
    }

    /* renamed from: ir.nasim.ru2$c */
    class c implements Callable {
        final /* synthetic */ String a;
        final /* synthetic */ Context b;
        final /* synthetic */ C19767qu2 c;
        final /* synthetic */ int d;

        c(String str, Context context, C19767qu2 c19767qu2, int i) {
            this.a = str;
            this.b = context;
            this.c = c19767qu2;
            this.d = i;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public e call() {
            try {
                return AbstractC20376ru2.c(this.a, this.b, this.c, this.d);
            } catch (Throwable unused) {
                return new e(-3);
            }
        }
    }

    /* renamed from: ir.nasim.ru2$d */
    class d implements InterfaceC25043ze1 {
        final /* synthetic */ String a;

        d(String str) {
            this.a = str;
        }

        @Override // ir.nasim.InterfaceC25043ze1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(e eVar) {
            synchronized (AbstractC20376ru2.c) {
                try {
                    C24792zC6 c24792zC6 = AbstractC20376ru2.d;
                    ArrayList arrayList = (ArrayList) c24792zC6.get(this.a);
                    if (arrayList == null) {
                        return;
                    }
                    c24792zC6.remove(this.a);
                    for (int i = 0; i < arrayList.size(); i++) {
                        ((InterfaceC25043ze1) arrayList.get(i)).accept(eVar);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    private static String a(C19767qu2 c19767qu2, int i) {
        return c19767qu2.d() + "-" + i;
    }

    private static int b(AbstractC6245Mu2.a aVar) {
        int i = 1;
        if (aVar.c() != 0) {
            return aVar.c() != 1 ? -3 : -2;
        }
        AbstractC6245Mu2.b[] bVarArrB = aVar.b();
        if (bVarArrB != null && bVarArrB.length != 0) {
            i = 0;
            for (AbstractC6245Mu2.b bVar : bVarArrB) {
                int iB = bVar.b();
                if (iB != 0) {
                    if (iB < 0) {
                        return -3;
                    }
                    return iB;
                }
            }
        }
        return i;
    }

    static e c(String str, Context context, C19767qu2 c19767qu2, int i) {
        C17660nL3 c17660nL3 = a;
        Typeface typeface = (Typeface) c17660nL3.d(str);
        if (typeface != null) {
            return new e(typeface);
        }
        try {
            AbstractC6245Mu2.a aVarE = AbstractC19176pu2.e(context, c19767qu2, null);
            int iB = b(aVarE);
            if (iB != 0) {
                return new e(iB);
            }
            Typeface typefaceB = AbstractC10050az7.b(context, null, aVarE.b(), i);
            if (typefaceB == null) {
                return new e(-3);
            }
            c17660nL3.f(str, typefaceB);
            return new e(typefaceB);
        } catch (PackageManager.NameNotFoundException unused) {
            return new e(-1);
        }
    }

    static Typeface d(Context context, C19767qu2 c19767qu2, int i, Executor executor, C17558nA0 c17558nA0) {
        String strA = a(c19767qu2, i);
        Typeface typeface = (Typeface) a.d(strA);
        if (typeface != null) {
            c17558nA0.b(new e(typeface));
            return typeface;
        }
        b bVar = new b(c17558nA0);
        synchronized (c) {
            try {
                C24792zC6 c24792zC6 = d;
                ArrayList arrayList = (ArrayList) c24792zC6.get(strA);
                if (arrayList != null) {
                    arrayList.add(bVar);
                    return null;
                }
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(bVar);
                c24792zC6.put(strA, arrayList2);
                c cVar = new c(strA, context, c19767qu2, i);
                if (executor == null) {
                    executor = b;
                }
                AbstractC17716nR5.b(executor, cVar, new d(strA));
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    static Typeface e(Context context, C19767qu2 c19767qu2, C17558nA0 c17558nA0, int i, int i2) {
        String strA = a(c19767qu2, i);
        Typeface typeface = (Typeface) a.d(strA);
        if (typeface != null) {
            c17558nA0.b(new e(typeface));
            return typeface;
        }
        if (i2 == -1) {
            e eVarC = c(strA, context, c19767qu2, i);
            c17558nA0.b(eVarC);
            return eVarC.a;
        }
        try {
            e eVar = (e) AbstractC17716nR5.c(b, new a(strA, context, c19767qu2, i), i2);
            c17558nA0.b(eVar);
            return eVar.a;
        } catch (InterruptedException unused) {
            c17558nA0.b(new e(-3));
            return null;
        }
    }

    /* renamed from: ir.nasim.ru2$e */
    static final class e {
        final Typeface a;
        final int b;

        e(int i) {
            this.a = null;
            this.b = i;
        }

        boolean a() {
            return this.b == 0;
        }

        e(Typeface typeface) {
            this.a = typeface;
            this.b = 0;
        }
    }
}
