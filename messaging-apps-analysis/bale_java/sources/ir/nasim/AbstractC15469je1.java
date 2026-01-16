package ir.nasim;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* renamed from: ir.nasim.je1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC15469je1 {
    private static final String f = HI3.f("ConstraintTracker");
    protected final InterfaceC5684Kj7 a;
    protected final Context b;
    private final Object c = new Object();
    private final Set d = new LinkedHashSet();
    Object e;

    /* renamed from: ir.nasim.je1$a */
    class a implements Runnable {
        final /* synthetic */ List a;

        a(List list) {
            this.a = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                ((InterfaceC12451ee1) it.next()).a(AbstractC15469je1.this.e);
            }
        }
    }

    AbstractC15469je1(Context context, InterfaceC5684Kj7 interfaceC5684Kj7) {
        this.b = context.getApplicationContext();
        this.a = interfaceC5684Kj7;
    }

    public void a(InterfaceC12451ee1 interfaceC12451ee1) {
        synchronized (this.c) {
            try {
                if (this.d.add(interfaceC12451ee1)) {
                    if (this.d.size() == 1) {
                        this.e = b();
                        HI3.c().a(f, String.format("%s: initial state = %s", getClass().getSimpleName(), this.e), new Throwable[0]);
                        e();
                    }
                    interfaceC12451ee1.a(this.e);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public abstract Object b();

    public void c(InterfaceC12451ee1 interfaceC12451ee1) {
        synchronized (this.c) {
            try {
                if (this.d.remove(interfaceC12451ee1) && this.d.isEmpty()) {
                    f();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void d(Object obj) {
        synchronized (this.c) {
            try {
                Object obj2 = this.e;
                if (obj2 != obj && (obj2 == null || !obj2.equals(obj))) {
                    this.e = obj;
                    this.a.a().execute(new a(new ArrayList(this.d)));
                }
            } finally {
            }
        }
    }

    public abstract void e();

    public abstract void f();
}
