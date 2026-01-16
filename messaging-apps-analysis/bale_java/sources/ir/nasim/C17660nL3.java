package ir.nasim;

import java.util.LinkedHashMap;
import java.util.Map;

/* renamed from: ir.nasim.nL3, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C17660nL3 {
    private int a;
    private final C18251oL3 b;
    private final C14069hI3 c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;

    public C17660nL3(int i) {
        this.a = i;
        if (!(i > 0)) {
            AbstractC22970w76.a("maxSize <= 0");
        }
        this.b = new C18251oL3(0, 0.75f);
        this.c = new C14069hI3();
    }

    private final int h(Object obj, Object obj2) {
        int iJ = j(obj, obj2);
        if (!(iJ >= 0)) {
            AbstractC22970w76.b("Negative size: " + obj + '=' + obj2);
        }
        return iJ;
    }

    protected Object a(Object obj) {
        AbstractC13042fc3.i(obj, "key");
        return null;
    }

    protected void b(boolean z, Object obj, Object obj2, Object obj3) {
        AbstractC13042fc3.i(obj, "key");
        AbstractC13042fc3.i(obj2, "oldValue");
    }

    public final void c() {
        l(-1);
    }

    public final Object d(Object obj) {
        Object objD;
        AbstractC13042fc3.i(obj, "key");
        synchronized (this.c) {
            Object objA = this.b.a(obj);
            if (objA != null) {
                this.h++;
                return objA;
            }
            this.i++;
            Object objA2 = a(obj);
            if (objA2 == null) {
                return null;
            }
            synchronized (this.c) {
                try {
                    this.f++;
                    objD = this.b.d(obj, objA2);
                    if (objD != null) {
                        this.b.d(obj, objD);
                    } else {
                        this.d += h(obj, objA2);
                        C19938rB7 c19938rB7 = C19938rB7.a;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (objD != null) {
                b(false, obj, objA2, objD);
                return objD;
            }
            l(this.a);
            return objA2;
        }
    }

    public final int e() {
        int i;
        synchronized (this.c) {
            i = this.a;
        }
        return i;
    }

    public final Object f(Object obj, Object obj2) {
        Object objD;
        AbstractC13042fc3.i(obj, "key");
        AbstractC13042fc3.i(obj2, "value");
        synchronized (this.c) {
            try {
                this.e++;
                this.d += h(obj, obj2);
                objD = this.b.d(obj, obj2);
                if (objD != null) {
                    this.d -= h(obj, objD);
                }
                C19938rB7 c19938rB7 = C19938rB7.a;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (objD != null) {
            b(false, obj, objD, obj2);
        }
        l(this.a);
        return objD;
    }

    public final Object g(Object obj) {
        Object objE;
        AbstractC13042fc3.i(obj, "key");
        synchronized (this.c) {
            try {
                objE = this.b.e(obj);
                if (objE != null) {
                    this.d -= h(obj, objE);
                }
                C19938rB7 c19938rB7 = C19938rB7.a;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (objE != null) {
            b(false, obj, objE, null);
        }
        return objE;
    }

    public final int i() {
        int i;
        synchronized (this.c) {
            i = this.d;
        }
        return i;
    }

    protected int j(Object obj, Object obj2) {
        AbstractC13042fc3.i(obj, "key");
        AbstractC13042fc3.i(obj2, "value");
        return 1;
    }

    public final Map k() {
        LinkedHashMap linkedHashMap;
        synchronized (this.c) {
            linkedHashMap = new LinkedHashMap(this.b.b().size());
            for (Map.Entry entry : this.b.b()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap;
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0062, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void l(int r7) {
        /*
            r6 = this;
        L0:
            ir.nasim.hI3 r0 = r6.c
            monitor-enter(r0)
            int r1 = r6.d     // Catch: java.lang.Throwable -> L15
            r2 = 1
            if (r1 < 0) goto L19
            ir.nasim.oL3 r1 = r6.b     // Catch: java.lang.Throwable -> L15
            boolean r1 = r1.c()     // Catch: java.lang.Throwable -> L15
            if (r1 == 0) goto L17
            int r1 = r6.d     // Catch: java.lang.Throwable -> L15
            if (r1 != 0) goto L19
            goto L17
        L15:
            r7 = move-exception
            goto L63
        L17:
            r1 = r2
            goto L1a
        L19:
            r1 = 0
        L1a:
            if (r1 != 0) goto L21
            java.lang.String r1 = "LruCache.sizeOf() is reporting inconsistent results!"
            ir.nasim.AbstractC22970w76.b(r1)     // Catch: java.lang.Throwable -> L15
        L21:
            int r1 = r6.d     // Catch: java.lang.Throwable -> L15
            if (r1 <= r7) goto L61
            ir.nasim.oL3 r1 = r6.b     // Catch: java.lang.Throwable -> L15
            boolean r1 = r1.c()     // Catch: java.lang.Throwable -> L15
            if (r1 == 0) goto L2e
            goto L61
        L2e:
            ir.nasim.oL3 r1 = r6.b     // Catch: java.lang.Throwable -> L15
            java.util.Set r1 = r1.b()     // Catch: java.lang.Throwable -> L15
            java.lang.Iterable r1 = (java.lang.Iterable) r1     // Catch: java.lang.Throwable -> L15
            java.lang.Object r1 = ir.nasim.ZW0.r0(r1)     // Catch: java.lang.Throwable -> L15
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1     // Catch: java.lang.Throwable -> L15
            if (r1 != 0) goto L40
            monitor-exit(r0)
            return
        L40:
            java.lang.Object r3 = r1.getKey()     // Catch: java.lang.Throwable -> L15
            java.lang.Object r1 = r1.getValue()     // Catch: java.lang.Throwable -> L15
            ir.nasim.oL3 r4 = r6.b     // Catch: java.lang.Throwable -> L15
            r4.e(r3)     // Catch: java.lang.Throwable -> L15
            int r4 = r6.d     // Catch: java.lang.Throwable -> L15
            int r5 = r6.h(r3, r1)     // Catch: java.lang.Throwable -> L15
            int r4 = r4 - r5
            r6.d = r4     // Catch: java.lang.Throwable -> L15
            int r4 = r6.g     // Catch: java.lang.Throwable -> L15
            int r4 = r4 + r2
            r6.g = r4     // Catch: java.lang.Throwable -> L15
            monitor-exit(r0)
            r0 = 0
            r6.b(r2, r3, r1, r0)
            goto L0
        L61:
            monitor-exit(r0)
            return
        L63:
            monitor-exit(r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C17660nL3.l(int):void");
    }

    public String toString() {
        String str;
        synchronized (this.c) {
            try {
                int i = this.h;
                int i2 = this.i + i;
                str = "LruCache[maxSize=" + this.a + ",hits=" + this.h + ",misses=" + this.i + ",hitRate=" + (i2 != 0 ? (i * 100) / i2 : 0) + "%]";
            } catch (Throwable th) {
                throw th;
            }
        }
        return str;
    }
}
