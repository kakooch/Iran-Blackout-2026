package androidx.work;

import android.content.Context;
import androidx.annotation.Keep;
import ir.nasim.AbstractC22650vb8;
import ir.nasim.C5314Iu6;
import ir.nasim.InterfaceC5684Kj7;
import ir.nasim.InterfaceFutureC15215jC3;
import java.util.UUID;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public abstract class ListenableWorker {
    private Context a;
    private WorkerParameters b;
    private volatile boolean c;
    private boolean d;
    private boolean e;

    public static abstract class a {

        /* renamed from: androidx.work.ListenableWorker$a$a, reason: collision with other inner class name */
        public static final class C0134a extends a {
            private final androidx.work.b a;

            public C0134a() {
                this(androidx.work.b.c);
            }

            public androidx.work.b e() {
                return this.a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || C0134a.class != obj.getClass()) {
                    return false;
                }
                return this.a.equals(((C0134a) obj).a);
            }

            public int hashCode() {
                return (C0134a.class.getName().hashCode() * 31) + this.a.hashCode();
            }

            public String toString() {
                return "Failure {mOutputData=" + this.a + '}';
            }

            public C0134a(androidx.work.b bVar) {
                this.a = bVar;
            }
        }

        public static final class b extends a {
            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && b.class == obj.getClass();
            }

            public int hashCode() {
                return b.class.getName().hashCode();
            }

            public String toString() {
                return "Retry";
            }
        }

        public static final class c extends a {
            private final androidx.work.b a;

            public c() {
                this(androidx.work.b.c);
            }

            public androidx.work.b e() {
                return this.a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || c.class != obj.getClass()) {
                    return false;
                }
                return this.a.equals(((c) obj).a);
            }

            public int hashCode() {
                return (c.class.getName().hashCode() * 31) + this.a.hashCode();
            }

            public String toString() {
                return "Success {mOutputData=" + this.a + '}';
            }

            public c(androidx.work.b bVar) {
                this.a = bVar;
            }
        }

        a() {
        }

        public static a a() {
            return new C0134a();
        }

        public static a b() {
            return new b();
        }

        public static a c() {
            return new c();
        }

        public static a d(androidx.work.b bVar) {
            return new c(bVar);
        }
    }

    @Keep
    public ListenableWorker(Context context, WorkerParameters workerParameters) {
        if (context == null) {
            throw new IllegalArgumentException("Application Context is null");
        }
        if (workerParameters == null) {
            throw new IllegalArgumentException("WorkerParameters is null");
        }
        this.a = context;
        this.b = workerParameters;
    }

    public final Context a() {
        return this.a;
    }

    public Executor c() {
        return this.b.a();
    }

    public InterfaceFutureC15215jC3 d() {
        C5314Iu6 c5314Iu6T = C5314Iu6.t();
        c5314Iu6T.q(new IllegalStateException("Expedited WorkRequests require a ListenableWorker to provide an implementation for `getForegroundInfoAsync()`"));
        return c5314Iu6T;
    }

    public final UUID f() {
        return this.b.c();
    }

    public final b g() {
        return this.b.d();
    }

    public InterfaceC5684Kj7 h() {
        return this.b.e();
    }

    public AbstractC22650vb8 i() {
        return this.b.f();
    }

    public boolean j() {
        return this.e;
    }

    public final boolean k() {
        return this.c;
    }

    public final boolean l() {
        return this.d;
    }

    public void m() {
    }

    public void n(boolean z) {
        this.e = z;
    }

    public final void o() {
        this.d = true;
    }

    public abstract InterfaceFutureC15215jC3 p();

    public final void q() {
        this.c = true;
        m();
    }
}
