package ir.nasim;

import com.google.android.gms.tasks.DuplicateTaskCompletionException;
import com.google.android.gms.tasks.RuntimeExecutionException;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;

/* loaded from: classes3.dex */
final class yv8 extends Task {
    private final Object a = new Object();
    private final Cu8 b = new Cu8();
    private boolean c;
    private volatile boolean d;
    private Object e;
    private Exception f;

    yv8() {
    }

    private final void w() {
        AbstractC3795Cj5.n(this.c, "Task is not yet complete");
    }

    private final void x() {
        if (this.d) {
            throw new CancellationException("Task is already canceled.");
        }
    }

    private final void y() {
        if (this.c) {
            throw DuplicateTaskCompletionException.a(this);
        }
    }

    private final void z() {
        synchronized (this.a) {
            try {
                if (this.c) {
                    this.b.b(this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.tasks.Task
    public final Task a(Executor executor, VI4 vi4) {
        this.b.a(new No8(executor, vi4));
        z();
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    public final Task b(WI4 wi4) {
        this.b.a(new Jq8(AbstractC6151Mj7.a, wi4));
        z();
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    public final Task c(Executor executor, WI4 wi4) {
        this.b.a(new Jq8(executor, wi4));
        z();
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    public final Task d(InterfaceC14681iJ4 interfaceC14681iJ4) {
        e(AbstractC6151Mj7.a, interfaceC14681iJ4);
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    public final Task e(Executor executor, InterfaceC14681iJ4 interfaceC14681iJ4) {
        this.b.a(new Mr8(executor, interfaceC14681iJ4));
        z();
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    public final Task f(InterfaceC13497gK4 interfaceC13497gK4) {
        g(AbstractC6151Mj7.a, interfaceC13497gK4);
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    public final Task g(Executor executor, InterfaceC13497gK4 interfaceC13497gK4) {
        this.b.a(new C24596ys8(executor, interfaceC13497gK4));
        z();
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    public final Task h(Executor executor, InterfaceC20886sm1 interfaceC20886sm1) {
        yv8 yv8Var = new yv8();
        this.b.a(new Ol8(executor, interfaceC20886sm1, yv8Var));
        z();
        return yv8Var;
    }

    @Override // com.google.android.gms.tasks.Task
    public final Task i(InterfaceC20886sm1 interfaceC20886sm1) {
        return j(AbstractC6151Mj7.a, interfaceC20886sm1);
    }

    @Override // com.google.android.gms.tasks.Task
    public final Task j(Executor executor, InterfaceC20886sm1 interfaceC20886sm1) {
        yv8 yv8Var = new yv8();
        this.b.a(new C20312rn8(executor, interfaceC20886sm1, yv8Var));
        z();
        return yv8Var;
    }

    @Override // com.google.android.gms.tasks.Task
    public final Exception k() {
        Exception exc;
        synchronized (this.a) {
            exc = this.f;
        }
        return exc;
    }

    @Override // com.google.android.gms.tasks.Task
    public final Object l() {
        Object obj;
        synchronized (this.a) {
            try {
                w();
                x();
                Exception exc = this.f;
                if (exc != null) {
                    throw new RuntimeExecutionException(exc);
                }
                obj = this.e;
            } catch (Throwable th) {
                throw th;
            }
        }
        return obj;
    }

    @Override // com.google.android.gms.tasks.Task
    public final Object m(Class cls) {
        Object obj;
        synchronized (this.a) {
            try {
                w();
                x();
                if (cls.isInstance(this.f)) {
                    throw ((Throwable) cls.cast(this.f));
                }
                Exception exc = this.f;
                if (exc != null) {
                    throw new RuntimeExecutionException(exc);
                }
                obj = this.e;
            } catch (Throwable th) {
                throw th;
            }
        }
        return obj;
    }

    @Override // com.google.android.gms.tasks.Task
    public final boolean n() {
        return this.d;
    }

    @Override // com.google.android.gms.tasks.Task
    public final boolean o() {
        boolean z;
        synchronized (this.a) {
            z = this.c;
        }
        return z;
    }

    @Override // com.google.android.gms.tasks.Task
    public final boolean p() {
        boolean z;
        synchronized (this.a) {
            try {
                z = false;
                if (this.c && !this.d && this.f == null) {
                    z = true;
                }
            } finally {
            }
        }
        return z;
    }

    @Override // com.google.android.gms.tasks.Task
    public final Task q(Executor executor, G07 g07) {
        yv8 yv8Var = new yv8();
        this.b.a(new Rt8(executor, g07, yv8Var));
        z();
        return yv8Var;
    }

    public final void r(Exception exc) {
        AbstractC3795Cj5.k(exc, "Exception must not be null");
        synchronized (this.a) {
            y();
            this.c = true;
            this.f = exc;
        }
        this.b.b(this);
    }

    public final void s(Object obj) {
        synchronized (this.a) {
            y();
            this.c = true;
            this.e = obj;
        }
        this.b.b(this);
    }

    public final boolean t() {
        synchronized (this.a) {
            try {
                if (this.c) {
                    return false;
                }
                this.c = true;
                this.d = true;
                this.b.b(this);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean u(Exception exc) {
        AbstractC3795Cj5.k(exc, "Exception must not be null");
        synchronized (this.a) {
            try {
                if (this.c) {
                    return false;
                }
                this.c = true;
                this.f = exc;
                this.b.b(this);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean v(Object obj) {
        synchronized (this.a) {
            try {
                if (this.c) {
                    return false;
                }
                this.c = true;
                this.e = obj;
                this.b.b(this);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
