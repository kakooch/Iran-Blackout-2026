package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import androidx.work.impl.background.systemalarm.e;
import ir.nasim.AbstractC24092y18;
import ir.nasim.C17810nb8;
import ir.nasim.C21403tb8;
import ir.nasim.HI3;
import ir.nasim.InterfaceC9244Zc2;
import ir.nasim.Ma8;
import ir.nasim.Na8;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public class d implements Ma8, InterfaceC9244Zc2, C21403tb8.b {
    private static final String j = HI3.f("DelayMetCommandHandler");
    private final Context a;
    private final int b;
    private final String c;
    private final e d;
    private final Na8 e;
    private PowerManager.WakeLock h;
    private boolean i = false;
    private int g = 0;
    private final Object f = new Object();

    d(Context context, int i, String str, e eVar) {
        this.a = context;
        this.b = i;
        this.d = eVar;
        this.c = str;
        this.e = new Na8(context, eVar.f(), this);
    }

    private void c() {
        synchronized (this.f) {
            try {
                this.e.e();
                this.d.h().c(this.c);
                PowerManager.WakeLock wakeLock = this.h;
                if (wakeLock != null && wakeLock.isHeld()) {
                    HI3.c().a(j, String.format("Releasing wakelock %s for WorkSpec %s", this.h, this.c), new Throwable[0]);
                    this.h.release();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void g() {
        synchronized (this.f) {
            try {
                if (this.g < 2) {
                    this.g = 2;
                    HI3 hi3C = HI3.c();
                    String str = j;
                    hi3C.a(str, String.format("Stopping work for WorkSpec %s", this.c), new Throwable[0]);
                    Intent intentF = b.f(this.a, this.c);
                    e eVar = this.d;
                    eVar.k(new e.b(eVar, intentF, this.b));
                    if (this.d.e().g(this.c)) {
                        HI3.c().a(str, String.format("WorkSpec %s needs to be rescheduled", this.c), new Throwable[0]);
                        Intent intentE = b.e(this.a, this.c);
                        e eVar2 = this.d;
                        eVar2.k(new e.b(eVar2, intentE, this.b));
                    } else {
                        HI3.c().a(str, String.format("Processor does not have WorkSpec %s. No need to reschedule ", this.c), new Throwable[0]);
                    }
                } else {
                    HI3.c().a(j, String.format("Already stopped work for %s", this.c), new Throwable[0]);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // ir.nasim.C21403tb8.b
    public void a(String str) {
        HI3.c().a(j, String.format("Exceeded time limits on execution for %s", str), new Throwable[0]);
        g();
    }

    @Override // ir.nasim.Ma8
    public void b(List list) {
        g();
    }

    @Override // ir.nasim.InterfaceC9244Zc2
    public void d(String str, boolean z) {
        HI3.c().a(j, String.format("onExecuted %s, %s", str, Boolean.valueOf(z)), new Throwable[0]);
        c();
        if (z) {
            Intent intentE = b.e(this.a, this.c);
            e eVar = this.d;
            eVar.k(new e.b(eVar, intentE, this.b));
        }
        if (this.i) {
            Intent intentA = b.a(this.a);
            e eVar2 = this.d;
            eVar2.k(new e.b(eVar2, intentA, this.b));
        }
    }

    @Override // ir.nasim.Ma8
    public void e(List list) {
        if (list.contains(this.c)) {
            synchronized (this.f) {
                try {
                    if (this.g == 0) {
                        this.g = 1;
                        HI3.c().a(j, String.format("onAllConstraintsMet for %s", this.c), new Throwable[0]);
                        if (this.d.e().j(this.c)) {
                            this.d.h().b(this.c, 600000L, this);
                        } else {
                            c();
                        }
                    } else {
                        HI3.c().a(j, String.format("Already started work for %s", this.c), new Throwable[0]);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    void f() {
        this.h = AbstractC24092y18.b(this.a, String.format("%s (%s)", this.c, Integer.valueOf(this.b)));
        HI3 hi3C = HI3.c();
        String str = j;
        hi3C.a(str, String.format("Acquiring wakelock %s for WorkSpec %s", this.h, this.c), new Throwable[0]);
        this.h.acquire();
        C17810nb8 c17810nb8G = this.d.g().o().Q().g(this.c);
        if (c17810nb8G == null) {
            g();
            return;
        }
        boolean zB = c17810nb8G.b();
        this.i = zB;
        if (zB) {
            this.e.d(Collections.singletonList(c17810nb8G));
        } else {
            HI3.c().a(str, String.format("No constraints for %s", this.c), new Throwable[0]);
            e(Collections.singletonList(this.c));
        }
    }
}
