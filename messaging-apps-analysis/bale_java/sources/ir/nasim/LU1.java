package ir.nasim;

import android.os.SystemClock;
import android.util.SparseIntArray;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;
import ir.nasim.tgwidgets.editor.messenger.Utilities;
import java.util.LinkedList;

/* loaded from: classes7.dex */
public class LU1 {
    private int d;
    private int e;
    private int g;
    private boolean h;
    private LinkedList a = new LinkedList();
    private SparseIntArray b = new SparseIntArray();
    private LinkedList c = new LinkedList();
    private Runnable i = new a();
    private int f = Utilities.b.nextInt();

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!LU1.this.a.isEmpty()) {
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                int size = LU1.this.a.size();
                int i = 0;
                while (i < size) {
                    HU1 hu1 = (HU1) LU1.this.a.get(i);
                    if (hu1.e() < jElapsedRealtime - 30000) {
                        hu1.k();
                        LU1.this.a.remove(i);
                        LU1.this.e--;
                        i--;
                        size--;
                    }
                    i++;
                }
            }
            if (LU1.this.a.isEmpty() && LU1.this.c.isEmpty()) {
                LU1.this.h = false;
            } else {
                AbstractC21455b.n1(this, 30000L);
                LU1.this.h = true;
            }
        }
    }

    public LU1(int i) {
        this.d = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i(HU1 hu1) {
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
    public /* synthetic */ void j(Runnable runnable, final HU1 hu1) {
        runnable.run();
        AbstractC21455b.m1(new Runnable() { // from class: ir.nasim.KU1
            @Override // java.lang.Runnable
            public final void run() {
                this.a.i(hu1);
            }
        });
    }

    public void h(final Runnable runnable) {
        final HU1 hu1;
        if (!this.c.isEmpty() && (this.g / 2 <= this.c.size() || (this.a.isEmpty() && this.e >= this.d))) {
            hu1 = (HU1) this.c.remove(0);
        } else if (this.a.isEmpty()) {
            hu1 = new HU1("DispatchQueuePool" + this.f + "_" + Utilities.b.nextInt());
            hu1.setPriority(10);
            this.e = this.e + 1;
        } else {
            hu1 = (HU1) this.a.remove(0);
        }
        if (!this.h) {
            AbstractC21455b.n1(this.i, 30000L);
            this.h = true;
        }
        this.g++;
        this.c.add(hu1);
        this.b.put(hu1.d, this.b.get(hu1.d, 0) + 1);
        if (hu1.getPriority() != 10) {
            hu1.setPriority(10);
        }
        hu1.i(new Runnable() { // from class: ir.nasim.JU1
            @Override // java.lang.Runnable
            public final void run() {
                this.a.j(runnable, hu1);
            }
        });
    }
}
