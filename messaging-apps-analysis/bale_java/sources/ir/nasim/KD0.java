package ir.nasim;

import ir.nasim.InterfaceC15221jD0;
import ir.nasim.MC0;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* loaded from: classes.dex */
public final class KD0 implements MC0.a {
    private final StringBuilder a = new StringBuilder();
    private final Object b;
    private int c;
    private final MC0 d;
    private final Map e;
    private int f;

    private static class a {
        private InterfaceC15221jD0.a a;
        private final Executor b;
        private final b c;
        private final c d;

        a(InterfaceC15221jD0.a aVar, Executor executor, b bVar, c cVar) {
            this.a = aVar;
            this.b = executor;
            this.c = bVar;
            this.d = cVar;
        }

        InterfaceC15221jD0.a a() {
            return this.a;
        }

        void b() {
            try {
                Executor executor = this.b;
                final b bVar = this.c;
                Objects.requireNonNull(bVar);
                executor.execute(new Runnable() { // from class: ir.nasim.JD0
                    @Override // java.lang.Runnable
                    public final void run() {
                        bVar.a();
                    }
                });
            } catch (RejectedExecutionException e) {
                PI3.d("CameraStateRegistry", "Unable to notify camera to configure.", e);
            }
        }

        void c() {
            try {
                Executor executor = this.b;
                final c cVar = this.d;
                Objects.requireNonNull(cVar);
                executor.execute(new Runnable() { // from class: ir.nasim.ID0
                    @Override // java.lang.Runnable
                    public final void run() {
                        cVar.a();
                    }
                });
            } catch (RejectedExecutionException e) {
                PI3.d("CameraStateRegistry", "Unable to notify camera to open.", e);
            }
        }

        InterfaceC15221jD0.a d(InterfaceC15221jD0.a aVar) {
            InterfaceC15221jD0.a aVar2 = this.a;
            this.a = aVar;
            return aVar2;
        }
    }

    public interface b {
        void a();
    }

    public interface c {
        void a();
    }

    public KD0(MC0 mc0, int i) {
        Object obj = new Object();
        this.b = obj;
        this.e = new HashMap();
        this.c = i;
        synchronized (obj) {
            this.d = mc0;
            this.f = this.c;
        }
    }

    private a b(String str) {
        for (HB0 hb0 : this.e.keySet()) {
            if (str.equals(((InterfaceC14623iD0) hb0.a()).b())) {
                return (a) this.e.get(hb0);
            }
        }
        return null;
    }

    private static boolean d(InterfaceC15221jD0.a aVar) {
        return aVar != null && aVar.j();
    }

    private void f() {
        if (PI3.f("CameraStateRegistry")) {
            this.a.setLength(0);
            this.a.append("Recalculating open cameras:\n");
            this.a.append(String.format(Locale.US, "%-45s%-22s\n", "Camera", "State"));
            this.a.append("-------------------------------------------------------------------\n");
        }
        int i = 0;
        for (Map.Entry entry : this.e.entrySet()) {
            if (PI3.f("CameraStateRegistry")) {
                this.a.append(String.format(Locale.US, "%-45s%-22s\n", ((HB0) entry.getKey()).toString(), ((a) entry.getValue()).a() != null ? ((a) entry.getValue()).a().toString() : "UNKNOWN"));
            }
            if (d(((a) entry.getValue()).a())) {
                i++;
            }
        }
        if (PI3.f("CameraStateRegistry")) {
            this.a.append("-------------------------------------------------------------------\n");
            this.a.append(String.format(Locale.US, "Open count: %d (Max allowed: %d)", Integer.valueOf(i), Integer.valueOf(this.c)));
            PI3.a("CameraStateRegistry", this.a.toString());
        }
        this.f = Math.max(this.c - i, 0);
    }

    private static void h(HB0 hb0, InterfaceC15221jD0.a aVar) throws Throwable {
        if (C16807lt7.d()) {
            C16807lt7.f("CX:State[" + hb0 + "]", aVar.ordinal());
        }
    }

    private InterfaceC15221jD0.a k(HB0 hb0) {
        a aVar = (a) this.e.remove(hb0);
        if (aVar == null) {
            return null;
        }
        f();
        return aVar.a();
    }

    private InterfaceC15221jD0.a l(HB0 hb0, InterfaceC15221jD0.a aVar) throws Throwable {
        InterfaceC15221jD0.a aVarD = ((a) AbstractC4980Hj5.h((a) this.e.get(hb0), "Cannot update state of camera which has not yet been registered. Register with CameraStateRegistry.registerCamera()")).d(aVar);
        InterfaceC15221jD0.a aVar2 = InterfaceC15221jD0.a.OPENING;
        if (aVar == aVar2) {
            AbstractC4980Hj5.j(d(aVar) || aVarD == aVar2, "Cannot mark camera as opening until camera was successful at calling CameraStateRegistry.tryOpenCamera()");
        }
        if (aVarD != aVar) {
            h(hb0, aVar);
            f();
        }
        return aVarD;
    }

    @Override // ir.nasim.MC0.a
    public void a(int i, int i2) {
        synchronized (this.b) {
            boolean z = true;
            this.c = i2 == 2 ? 2 : 1;
            boolean z2 = i != 2 && i2 == 2;
            if (i != 2 || i2 == 2) {
                z = false;
            }
            if (z2 || z) {
                f();
            }
        }
    }

    public boolean c() {
        synchronized (this.b) {
            try {
                Iterator it = this.e.entrySet().iterator();
                while (it.hasNext()) {
                    if (((a) ((Map.Entry) it.next()).getValue()).a() == InterfaceC15221jD0.a.CLOSING) {
                        return true;
                    }
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x003e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void e(ir.nasim.HB0 r7, ir.nasim.InterfaceC15221jD0.a r8, boolean r9) {
        /*
            r6 = this;
            java.lang.Object r0 = r6.b
            monitor-enter(r0)
            int r1 = r6.f     // Catch: java.lang.Throwable -> Le
            ir.nasim.jD0$a r2 = ir.nasim.InterfaceC15221jD0.a.RELEASED     // Catch: java.lang.Throwable -> Le
            if (r8 != r2) goto L11
            ir.nasim.jD0$a r2 = r6.k(r7)     // Catch: java.lang.Throwable -> Le
            goto L15
        Le:
            r7 = move-exception
            goto Lbf
        L11:
            ir.nasim.jD0$a r2 = r6.l(r7, r8)     // Catch: java.lang.Throwable -> Le
        L15:
            if (r2 != r8) goto L19
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Le
            return
        L19:
            ir.nasim.MC0 r2 = r6.d     // Catch: java.lang.Throwable -> Le
            int r2 = r2.c()     // Catch: java.lang.Throwable -> Le
            r3 = 2
            r4 = 0
            if (r2 != r3) goto L3e
            ir.nasim.jD0$a r2 = ir.nasim.InterfaceC15221jD0.a.CONFIGURED     // Catch: java.lang.Throwable -> Le
            if (r8 != r2) goto L3e
            ir.nasim.hD0 r2 = r7.a()     // Catch: java.lang.Throwable -> Le
            ir.nasim.iD0 r2 = (ir.nasim.InterfaceC14623iD0) r2     // Catch: java.lang.Throwable -> Le
            java.lang.String r2 = r2.b()     // Catch: java.lang.Throwable -> Le
            ir.nasim.MC0 r3 = r6.d     // Catch: java.lang.Throwable -> Le
            java.lang.String r2 = r3.b(r2)     // Catch: java.lang.Throwable -> Le
            if (r2 == 0) goto L3e
            ir.nasim.KD0$a r2 = r6.b(r2)     // Catch: java.lang.Throwable -> Le
            goto L3f
        L3e:
            r2 = r4
        L3f:
            r3 = 1
            if (r1 >= r3) goto L7f
            int r1 = r6.f     // Catch: java.lang.Throwable -> Le
            if (r1 <= 0) goto L7f
            java.util.HashMap r4 = new java.util.HashMap     // Catch: java.lang.Throwable -> Le
            r4.<init>()     // Catch: java.lang.Throwable -> Le
            java.util.Map r8 = r6.e     // Catch: java.lang.Throwable -> Le
            java.util.Set r8 = r8.entrySet()     // Catch: java.lang.Throwable -> Le
            java.util.Iterator r8 = r8.iterator()     // Catch: java.lang.Throwable -> Le
        L55:
            boolean r1 = r8.hasNext()     // Catch: java.lang.Throwable -> Le
            if (r1 == 0) goto L97
            java.lang.Object r1 = r8.next()     // Catch: java.lang.Throwable -> Le
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1     // Catch: java.lang.Throwable -> Le
            java.lang.Object r3 = r1.getValue()     // Catch: java.lang.Throwable -> Le
            ir.nasim.KD0$a r3 = (ir.nasim.KD0.a) r3     // Catch: java.lang.Throwable -> Le
            ir.nasim.jD0$a r3 = r3.a()     // Catch: java.lang.Throwable -> Le
            ir.nasim.jD0$a r5 = ir.nasim.InterfaceC15221jD0.a.PENDING_OPEN     // Catch: java.lang.Throwable -> Le
            if (r3 != r5) goto L55
            java.lang.Object r3 = r1.getKey()     // Catch: java.lang.Throwable -> Le
            ir.nasim.HB0 r3 = (ir.nasim.HB0) r3     // Catch: java.lang.Throwable -> Le
            java.lang.Object r1 = r1.getValue()     // Catch: java.lang.Throwable -> Le
            ir.nasim.KD0$a r1 = (ir.nasim.KD0.a) r1     // Catch: java.lang.Throwable -> Le
            r4.put(r3, r1)     // Catch: java.lang.Throwable -> Le
            goto L55
        L7f:
            ir.nasim.jD0$a r1 = ir.nasim.InterfaceC15221jD0.a.PENDING_OPEN     // Catch: java.lang.Throwable -> Le
            if (r8 != r1) goto L97
            int r8 = r6.f     // Catch: java.lang.Throwable -> Le
            if (r8 <= 0) goto L97
            java.util.HashMap r4 = new java.util.HashMap     // Catch: java.lang.Throwable -> Le
            r4.<init>()     // Catch: java.lang.Throwable -> Le
            java.util.Map r8 = r6.e     // Catch: java.lang.Throwable -> Le
            java.lang.Object r8 = r8.get(r7)     // Catch: java.lang.Throwable -> Le
            ir.nasim.KD0$a r8 = (ir.nasim.KD0.a) r8     // Catch: java.lang.Throwable -> Le
            r4.put(r7, r8)     // Catch: java.lang.Throwable -> Le
        L97:
            if (r4 == 0) goto L9e
            if (r9 != 0) goto L9e
            r4.remove(r7)     // Catch: java.lang.Throwable -> Le
        L9e:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Le
            if (r4 == 0) goto Lb9
            java.util.Collection r7 = r4.values()
            java.util.Iterator r7 = r7.iterator()
        La9:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto Lb9
            java.lang.Object r8 = r7.next()
            ir.nasim.KD0$a r8 = (ir.nasim.KD0.a) r8
            r8.c()
            goto La9
        Lb9:
            if (r2 == 0) goto Lbe
            r2.b()
        Lbe:
            return
        Lbf:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Le
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.KD0.e(ir.nasim.HB0, ir.nasim.jD0$a, boolean):void");
    }

    public void g(HB0 hb0, Executor executor, b bVar, c cVar) {
        synchronized (this.b) {
            AbstractC4980Hj5.j(!this.e.containsKey(hb0), "Camera is already registered: " + hb0);
            this.e.put(hb0, new a(null, executor, bVar, cVar));
        }
    }

    public boolean i(HB0 hb0) {
        boolean z;
        synchronized (this.b) {
            try {
                a aVar = (a) AbstractC4980Hj5.h((a) this.e.get(hb0), "Camera must first be registered with registerCamera()");
                z = false;
                if (PI3.f("CameraStateRegistry")) {
                    this.a.setLength(0);
                    this.a.append(String.format(Locale.US, "tryOpenCamera(%s) [Available Cameras: %d, Already Open: %b (Previous state: %s)]", hb0, Integer.valueOf(this.f), Boolean.valueOf(d(aVar.a())), aVar.a()));
                }
                if (this.f > 0 || d(aVar.a())) {
                    InterfaceC15221jD0.a aVar2 = InterfaceC15221jD0.a.OPENING;
                    aVar.d(aVar2);
                    h(hb0, aVar2);
                    z = true;
                }
                if (PI3.f("CameraStateRegistry")) {
                    this.a.append(String.format(Locale.US, " --> %s", z ? "SUCCESS" : "FAIL"));
                    PI3.a("CameraStateRegistry", this.a.toString());
                }
                if (z) {
                    f();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }

    public boolean j(String str, String str2) {
        synchronized (this.b) {
            try {
                boolean z = true;
                if (this.d.c() != 2) {
                    return true;
                }
                a aVarB = b(str);
                InterfaceC15221jD0.a aVarA = aVarB != null ? aVarB.a() : null;
                a aVarB2 = str2 != null ? b(str2) : null;
                InterfaceC15221jD0.a aVarA2 = aVarB2 != null ? aVarB2.a() : null;
                InterfaceC15221jD0.a aVar = InterfaceC15221jD0.a.OPEN;
                boolean z2 = aVar.equals(aVarA) || InterfaceC15221jD0.a.CONFIGURED.equals(aVarA);
                boolean z3 = aVar.equals(aVarA2) || InterfaceC15221jD0.a.CONFIGURED.equals(aVarA2);
                if (!z2 || !z3) {
                    z = false;
                }
                return z;
            } finally {
            }
        }
    }
}
