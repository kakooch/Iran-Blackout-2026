package com.google.android.gms.measurement.internal;

import ir.nasim.AbstractC3795Cj5;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/* loaded from: classes3.dex */
final class D1 extends FutureTask implements Comparable {
    private final long a;
    final boolean b;
    private final String c;
    final /* synthetic */ F1 d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    D1(F1 f1, Runnable runnable, boolean z, String str) {
        super(runnable, null);
        this.d = f1;
        AbstractC3795Cj5.j(str);
        long andIncrement = F1.l.getAndIncrement();
        this.a = andIncrement;
        this.c = str;
        this.b = z;
        if (andIncrement == Long.MAX_VALUE) {
            f1.a.b().r().a("Tasks index overflow");
        }
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        D1 d1 = (D1) obj;
        boolean z = this.b;
        if (z == d1.b) {
            long j = this.a;
            long j2 = d1.a;
            if (j < j2) {
                return -1;
            }
            if (j <= j2) {
                this.d.a.b().t().b("Two tasks share the same index. index", Long.valueOf(this.a));
                return 0;
            }
        } else if (z) {
            return -1;
        }
        return 1;
    }

    @Override // java.util.concurrent.FutureTask
    protected final void setException(Throwable th) {
        this.d.a.b().r().b(this.c, th);
        super.setException(th);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    D1(F1 f1, Callable callable, boolean z, String str) {
        super(callable);
        this.d = f1;
        AbstractC3795Cj5.j("Task exception on worker thread");
        long andIncrement = F1.l.getAndIncrement();
        this.a = andIncrement;
        this.c = "Task exception on worker thread";
        this.b = z;
        if (andIncrement == Long.MAX_VALUE) {
            f1.a.b().r().a("Tasks index overflow");
        }
    }
}
