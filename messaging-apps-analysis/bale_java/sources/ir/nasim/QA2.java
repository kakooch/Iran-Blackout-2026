package ir.nasim;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class QA2 {
    private final Executor a;
    private final SA2 b;
    private final Object c;
    private int d;
    private boolean e;
    private boolean f;
    private final List g;
    private final Runnable h;

    public QA2(Executor executor, SA2 sa2) {
        AbstractC13042fc3.i(executor, "executor");
        AbstractC13042fc3.i(sa2, "reportFullyDrawn");
        this.a = executor;
        this.b = sa2;
        this.c = new Object();
        this.g = new ArrayList();
        this.h = new Runnable() { // from class: ir.nasim.PA2
            @Override // java.lang.Runnable
            public final void run() {
                QA2.d(this.a);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(QA2 qa2) {
        AbstractC13042fc3.i(qa2, "this$0");
        synchronized (qa2.c) {
            try {
                qa2.e = false;
                if (qa2.d == 0 && !qa2.f) {
                    qa2.b.invoke();
                    qa2.b();
                }
                C19938rB7 c19938rB7 = C19938rB7.a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void b() {
        synchronized (this.c) {
            try {
                this.f = true;
                Iterator it = this.g.iterator();
                while (it.hasNext()) {
                    ((SA2) it.next()).invoke();
                }
                this.g.clear();
                C19938rB7 c19938rB7 = C19938rB7.a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean c() {
        boolean z;
        synchronized (this.c) {
            z = this.f;
        }
        return z;
    }
}
