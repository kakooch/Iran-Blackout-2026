package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC18580ot7;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
final class k implements Runnable {
    static final ThreadLocal e = new ThreadLocal();
    static Comparator f = new a();
    long b;
    long c;
    ArrayList a = new ArrayList();
    private ArrayList d = new ArrayList();

    class a implements Comparator {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(c cVar, c cVar2) {
            RecyclerView recyclerView = cVar.d;
            if ((recyclerView == null) != (cVar2.d == null)) {
                return recyclerView == null ? 1 : -1;
            }
            boolean z = cVar.a;
            if (z != cVar2.a) {
                return z ? -1 : 1;
            }
            int i = cVar2.b - cVar.b;
            if (i != 0) {
                return i;
            }
            int i2 = cVar.c - cVar2.c;
            if (i2 != 0) {
                return i2;
            }
            return 0;
        }
    }

    static class b implements RecyclerView.p.c {
        int a;
        int b;
        int[] c;
        int d;

        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.p.c
        public void a(int i, int i2) {
            if (i < 0) {
                throw new IllegalArgumentException("Layout positions must be non-negative");
            }
            if (i2 < 0) {
                throw new IllegalArgumentException("Pixel distance must be non-negative");
            }
            int i3 = this.d;
            int i4 = i3 * 2;
            int[] iArr = this.c;
            if (iArr == null) {
                int[] iArr2 = new int[4];
                this.c = iArr2;
                Arrays.fill(iArr2, -1);
            } else if (i4 >= iArr.length) {
                int[] iArr3 = new int[i3 * 4];
                this.c = iArr3;
                System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
            }
            int[] iArr4 = this.c;
            iArr4[i4] = i;
            iArr4[i4 + 1] = i2;
            this.d++;
        }

        void b() {
            int[] iArr = this.c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.d = 0;
        }

        void c(RecyclerView recyclerView, boolean z) {
            this.d = 0;
            int[] iArr = this.c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            RecyclerView.p pVar = recyclerView.m;
            if (recyclerView.l == null || pVar == null || !pVar.w0()) {
                return;
            }
            if (z) {
                if (!recyclerView.d.p()) {
                    pVar.q(recyclerView.l.getItemCount(), this);
                }
            } else if (!recyclerView.hasPendingAdapterUpdates()) {
                pVar.p(this.a, this.b, recyclerView.Y0, this);
            }
            int i = this.d;
            if (i > pVar.m) {
                pVar.m = i;
                pVar.n = z;
                recyclerView.b.K();
            }
        }

        boolean d(int i) {
            if (this.c != null) {
                int i2 = this.d * 2;
                for (int i3 = 0; i3 < i2; i3 += 2) {
                    if (this.c[i3] == i) {
                        return true;
                    }
                }
            }
            return false;
        }

        void e(int i, int i2) {
            this.a = i;
            this.b = i2;
        }
    }

    static class c {
        public boolean a;
        public int b;
        public int c;
        public RecyclerView d;
        public int e;

        c() {
        }

        public void a() {
            this.a = false;
            this.b = 0;
            this.c = 0;
            this.d = null;
            this.e = 0;
        }
    }

    k() {
    }

    private void b() {
        c cVar;
        int size = this.a.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            RecyclerView recyclerView = (RecyclerView) this.a.get(i2);
            if (recyclerView.getWindowVisibility() == 0) {
                recyclerView.X0.c(recyclerView, false);
                i += recyclerView.X0.d;
            }
        }
        this.d.ensureCapacity(i);
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            RecyclerView recyclerView2 = (RecyclerView) this.a.get(i4);
            if (recyclerView2.getWindowVisibility() == 0) {
                b bVar = recyclerView2.X0;
                int iAbs = Math.abs(bVar.a) + Math.abs(bVar.b);
                for (int i5 = 0; i5 < bVar.d * 2; i5 += 2) {
                    if (i3 >= this.d.size()) {
                        cVar = new c();
                        this.d.add(cVar);
                    } else {
                        cVar = (c) this.d.get(i3);
                    }
                    int[] iArr = bVar.c;
                    int i6 = iArr[i5 + 1];
                    cVar.a = i6 <= iAbs;
                    cVar.b = iAbs;
                    cVar.c = i6;
                    cVar.d = recyclerView2;
                    cVar.e = iArr[i5];
                    i3++;
                }
            }
        }
        Collections.sort(this.d, f);
    }

    private void c(c cVar, long j) {
        RecyclerView.C cI = i(cVar.d, cVar.e, cVar.a ? Long.MAX_VALUE : j);
        if (cI == null || cI.b == null || !cI.V() || cI.X()) {
            return;
        }
        h((RecyclerView) cI.b.get(), j);
    }

    private void d(long j) {
        for (int i = 0; i < this.d.size(); i++) {
            c cVar = (c) this.d.get(i);
            if (cVar.d == null) {
                return;
            }
            c(cVar, j);
            cVar.a();
        }
    }

    static boolean e(RecyclerView recyclerView, int i) {
        int iJ = recyclerView.e.j();
        for (int i2 = 0; i2 < iJ; i2++) {
            RecyclerView.C cX = RecyclerView.X(recyclerView.e.i(i2));
            if (cX.c == i && !cX.X()) {
                return true;
            }
        }
        return false;
    }

    private void h(RecyclerView recyclerView, long j) {
        if (recyclerView == null) {
            return;
        }
        if (recyclerView.H && recyclerView.e.j() != 0) {
            recyclerView.E0();
        }
        b bVar = recyclerView.X0;
        bVar.c(recyclerView, true);
        if (bVar.d != 0) {
            try {
                AbstractC18580ot7.a("RV Nested Prefetch");
                recyclerView.Y0.f(recyclerView.l);
                for (int i = 0; i < bVar.d * 2; i += 2) {
                    i(recyclerView, bVar.c[i], j);
                }
            } finally {
                AbstractC18580ot7.b();
            }
        }
    }

    private RecyclerView.C i(RecyclerView recyclerView, int i, long j) {
        if (e(recyclerView, i)) {
            return null;
        }
        RecyclerView.v vVar = recyclerView.b;
        try {
            recyclerView.s0();
            RecyclerView.C cI = vVar.I(i, false, j);
            if (cI != null) {
                if (!cI.V() || cI.X()) {
                    vVar.a(cI, false);
                } else {
                    vVar.B(cI.a);
                }
            }
            recyclerView.u0(false);
            return cI;
        } catch (Throwable th) {
            recyclerView.u0(false);
            throw th;
        }
    }

    public void a(RecyclerView recyclerView) {
        this.a.add(recyclerView);
    }

    void f(RecyclerView recyclerView, int i, int i2) {
        if (recyclerView.isAttachedToWindow() && this.b == 0) {
            this.b = recyclerView.getNanoTime();
            recyclerView.post(this);
        }
        recyclerView.X0.e(i, i2);
    }

    void g(long j) {
        b();
        d(j);
    }

    public void j(RecyclerView recyclerView) {
        this.a.remove(recyclerView);
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            AbstractC18580ot7.a("RV Prefetch");
            if (!this.a.isEmpty()) {
                int size = this.a.size();
                long jMax = 0;
                for (int i = 0; i < size; i++) {
                    RecyclerView recyclerView = (RecyclerView) this.a.get(i);
                    if (recyclerView.getWindowVisibility() == 0) {
                        jMax = Math.max(recyclerView.getDrawingTime(), jMax);
                    }
                }
                if (jMax != 0) {
                    g(TimeUnit.MILLISECONDS.toNanos(jMax) + this.c);
                    this.b = 0L;
                    AbstractC18580ot7.b();
                }
            }
        } finally {
            this.b = 0L;
            AbstractC18580ot7.b();
        }
    }
}
