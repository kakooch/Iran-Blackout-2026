package ir.nasim;

import android.util.Log;
import java.util.LinkedHashSet;
import java.util.Set;

/* renamed from: ir.nasim.ij3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C14931ij3 {
    public static final a d = new a(null);
    private final Set a = new LinkedHashSet();
    private final Set b = new LinkedHashSet();
    private SA2 c;

    /* renamed from: ir.nasim.ij3$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    private final void c() {
        SA2 sa2;
        if (this.a.isEmpty()) {
            Log.e("JobCompletionTracker", "pendingJobs is empty!");
            return;
        }
        if (!this.b.containsAll(this.a) || (sa2 = this.c) == null || sa2 == null || !((Boolean) sa2.invoke()).booleanValue()) {
            return;
        }
        this.c = null;
        b();
        a();
    }

    public final void a() {
        this.b.clear();
    }

    public final void b() {
        this.a.clear();
    }

    public final void d(Comparable comparable) {
        AbstractC13042fc3.i(comparable, "jobId");
        this.b.add(comparable);
        c();
    }

    public final void e(SA2 sa2) {
        AbstractC13042fc3.i(sa2, "job");
        this.c = sa2;
        c();
    }

    public final void f(Comparable... comparableArr) {
        AbstractC13042fc3.i(comparableArr, "jobIds");
        AbstractC13610gX0.E(this.a, comparableArr);
    }
}
