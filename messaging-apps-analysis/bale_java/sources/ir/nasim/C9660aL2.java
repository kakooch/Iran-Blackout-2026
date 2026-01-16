package ir.nasim;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* renamed from: ir.nasim.aL2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C9660aL2 implements InterfaceC4435Fc6, Ma8, InterfaceC9244Zc2 {
    private static final String i = HI3.f("GreedyScheduler");
    private final Context a;
    private final Za8 b;
    private final Na8 c;
    private IG1 e;
    private boolean f;
    Boolean h;
    private final Set d = new HashSet();
    private final Object g = new Object();

    public C9660aL2(Context context, androidx.work.a aVar, InterfaceC5684Kj7 interfaceC5684Kj7, Za8 za8) {
        this.a = context;
        this.b = za8;
        this.c = new Na8(context, interfaceC5684Kj7, this);
        this.e = new IG1(this, aVar.k());
    }

    private void g() {
        this.h = Boolean.valueOf(AbstractC7905Tr5.b(this.a, this.b.i()));
    }

    private void h() {
        if (this.f) {
            return;
        }
        this.b.m().c(this);
        this.f = true;
    }

    private void i(String str) {
        synchronized (this.g) {
            try {
                Iterator it = this.d.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    C17810nb8 c17810nb8 = (C17810nb8) it.next();
                    if (c17810nb8.a.equals(str)) {
                        HI3.c().a(i, String.format("Stopping tracking for %s", str), new Throwable[0]);
                        this.d.remove(c17810nb8);
                        this.c.d(this.d);
                        break;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // ir.nasim.InterfaceC4435Fc6
    public void a(String str) {
        if (this.h == null) {
            g();
        }
        if (!this.h.booleanValue()) {
            HI3.c().d(i, "Ignoring schedule request in non-main process", new Throwable[0]);
            return;
        }
        h();
        HI3.c().a(i, String.format("Cancelling work ID %s", str), new Throwable[0]);
        IG1 ig1 = this.e;
        if (ig1 != null) {
            ig1.b(str);
        }
        this.b.x(str);
    }

    @Override // ir.nasim.Ma8
    public void b(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            HI3.c().a(i, String.format("Constraints not met: Cancelling work ID %s", str), new Throwable[0]);
            this.b.x(str);
        }
    }

    @Override // ir.nasim.InterfaceC4435Fc6
    public boolean c() {
        return false;
    }

    @Override // ir.nasim.InterfaceC9244Zc2
    public void d(String str, boolean z) {
        i(str);
    }

    @Override // ir.nasim.Ma8
    public void e(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            HI3.c().a(i, String.format("Constraints met: Scheduling work ID %s", str), new Throwable[0]);
            this.b.u(str);
        }
    }

    @Override // ir.nasim.InterfaceC4435Fc6
    public void f(C17810nb8... c17810nb8Arr) {
        if (this.h == null) {
            g();
        }
        if (!this.h.booleanValue()) {
            HI3.c().d(i, "Ignoring schedule request in a secondary process", new Throwable[0]);
            return;
        }
        h();
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        for (C17810nb8 c17810nb8 : c17810nb8Arr) {
            long jA = c17810nb8.a();
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (c17810nb8.b == Ta8.ENQUEUED) {
                if (jCurrentTimeMillis < jA) {
                    IG1 ig1 = this.e;
                    if (ig1 != null) {
                        ig1.a(c17810nb8);
                    }
                } else if (!c17810nb8.b()) {
                    HI3.c().a(i, String.format("Starting work for %s", c17810nb8.a), new Throwable[0]);
                    this.b.u(c17810nb8.a);
                } else if (c17810nb8.j.h()) {
                    HI3.c().a(i, String.format("Ignoring WorkSpec %s, Requires device idle.", c17810nb8), new Throwable[0]);
                } else if (c17810nb8.j.e()) {
                    HI3.c().a(i, String.format("Ignoring WorkSpec %s, Requires ContentUri triggers.", c17810nb8), new Throwable[0]);
                } else {
                    hashSet.add(c17810nb8);
                    hashSet2.add(c17810nb8.a);
                }
            }
        }
        synchronized (this.g) {
            try {
                if (!hashSet.isEmpty()) {
                    HI3.c().a(i, String.format("Starting tracking for [%s]", TextUtils.join(",", hashSet2)), new Throwable[0]);
                    this.d.addAll(hashSet);
                    this.c.d(this.d);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
