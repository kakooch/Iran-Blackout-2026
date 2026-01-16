package ir.nasim;

import android.os.SystemClock;
import android.util.SparseIntArray;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;
import ir.nasim.tgwidgets.editor.messenger.Utilities;
import java.util.ArrayList;

/* loaded from: classes7.dex */
public class QU1 {
    static ArrayList j;
    private static QU1 k;
    private static final ArrayList l = new ArrayList();
    private static final Runnable m = new b();
    private int d;
    private int e;
    private int g;
    private boolean h;
    private ArrayList a = new ArrayList(10);
    private SparseIntArray b = new SparseIntArray();
    private ArrayList c = new ArrayList(10);
    private Runnable i = new a();
    private int f = Utilities.b.nextInt();

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() throws InterruptedException {
            if (!QU1.this.a.isEmpty()) {
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                int i = 0;
                while (i < QU1.this.a.size()) {
                    HU1 hu1 = (HU1) QU1.this.a.get(i);
                    if (hu1.e() < jElapsedRealtime - 30000) {
                        hu1.k();
                        QU1.this.a.remove(i);
                        QU1.this.e--;
                        i--;
                    }
                    i++;
                }
            }
            if (QU1.this.a.isEmpty() && QU1.this.c.isEmpty()) {
                QU1.this.h = false;
            } else {
                Utilities.e.j(this, 30000L);
                QU1.this.h = true;
            }
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            QU1.n();
        }
    }

    private QU1(int i) {
        this.d = i;
    }

    public static void k(Runnable runnable) {
        l(runnable, false);
    }

    public static void l(Runnable runnable, boolean z) {
        if (Thread.currentThread() != AbstractC14047hG.b.getLooper().getThread()) {
            if (AbstractC8814Xl0.a) {
                AbstractC6403Nl2.d(new RuntimeException("wrong thread"));
                return;
            }
            return;
        }
        if (j == null) {
            ArrayList arrayList = l;
            if (arrayList.isEmpty()) {
                j = new ArrayList(100);
            } else {
                j = (ArrayList) arrayList.remove(arrayList.size() - 1);
            }
            if (!z) {
                AbstractC21455b.m1(m);
            }
        }
        j.add(runnable);
        if (z) {
            Runnable runnable2 = m;
            AbstractC21455b.t(runnable2);
            runnable2.run();
        }
    }

    private void m(ArrayList arrayList) throws InterruptedException {
        final HU1 hu1;
        for (int i = 0; i < arrayList.size(); i++) {
            final Runnable runnable = (Runnable) arrayList.get(i);
            if (runnable != null) {
                if (!this.c.isEmpty() && (this.g / 2 <= this.c.size() || (this.a.isEmpty() && this.e >= this.d))) {
                    hu1 = (HU1) this.c.remove(0);
                } else if (this.a.isEmpty()) {
                    hu1 = new HU1("DispatchQueuePoolThreadSafety_" + this.f + "_" + Utilities.b.nextInt());
                    hu1.setPriority(10);
                    this.e = this.e + 1;
                } else {
                    hu1 = (HU1) this.a.remove(0);
                }
                if (!this.h) {
                    Utilities.e.j(this.i, 30000L);
                    this.h = true;
                }
                this.g++;
                this.c.add(hu1);
                this.b.put(hu1.d, this.b.get(hu1.d, 0) + 1);
                if (hu1.getPriority() != 10) {
                    hu1.setPriority(10);
                }
                hu1.i(new Runnable() { // from class: ir.nasim.OU1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.p(runnable, hu1);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void n() {
        ArrayList arrayList = j;
        if (arrayList == null || arrayList.isEmpty()) {
            j = null;
            return;
        }
        final ArrayList arrayList2 = j;
        j = null;
        if (k == null) {
            k = new QU1(Math.max(1, Runtime.getRuntime().availableProcessors()));
        }
        Utilities.e.i(new Runnable() { // from class: ir.nasim.MU1
            @Override // java.lang.Runnable
            public final void run() throws InterruptedException {
                QU1.r(arrayList2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o(HU1 hu1) {
        this.g--;
        int i = this.b.get(hu1.d) - 1;
        if (i != 0) {
            this.b.put(hu1.d, i);
            return;
        }
        this.b.delete(hu1.d);
        this.c.remove(hu1);
        this.a.add(hu1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p(Runnable runnable, final HU1 hu1) {
        runnable.run();
        Utilities.e.i(new Runnable() { // from class: ir.nasim.PU1
            @Override // java.lang.Runnable
            public final void run() {
                this.a.o(hu1);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void q(ArrayList arrayList) {
        l.add(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void r(final ArrayList arrayList) throws InterruptedException {
        k.m(arrayList);
        arrayList.clear();
        AbstractC21455b.m1(new Runnable() { // from class: ir.nasim.NU1
            @Override // java.lang.Runnable
            public final void run() {
                QU1.q(arrayList);
            }
        });
    }
}
