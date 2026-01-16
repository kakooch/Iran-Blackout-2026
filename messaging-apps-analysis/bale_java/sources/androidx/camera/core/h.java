package androidx.camera.core;

import android.media.ImageReader;
import android.util.LongSparseArray;
import android.view.Surface;
import androidx.camera.core.e;
import ir.nasim.AbstractC4980Hj5;
import ir.nasim.JB0;
import ir.nasim.O23;
import ir.nasim.PI3;
import ir.nasim.QB0;
import ir.nasim.RB0;
import ir.nasim.W13;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public class h implements O23, e.a {
    private final Object a;
    private JB0 b;
    private int c;
    private O23.a d;
    private boolean e;
    private final O23 f;
    O23.a g;
    private Executor h;
    private final LongSparseArray i;
    private final LongSparseArray j;
    private int k;
    private final List l;
    private final List m;

    class a extends JB0 {
        a() {
        }

        @Override // ir.nasim.JB0
        public void b(int i, QB0 qb0) {
            super.b(i, qb0);
            h.this.s(qb0);
        }
    }

    public h(int i, int i2, int i3, int i4) {
        this(j(i, i2, i3, i4));
    }

    private static O23 j(int i, int i2, int i3, int i4) {
        return new d(ImageReader.newInstance(i, i2, i3, i4));
    }

    private void k(f fVar) {
        synchronized (this.a) {
            try {
                int iIndexOf = this.l.indexOf(fVar);
                if (iIndexOf >= 0) {
                    this.l.remove(iIndexOf);
                    int i = this.k;
                    if (iIndexOf <= i) {
                        this.k = i - 1;
                    }
                }
                this.m.remove(fVar);
                if (this.c > 0) {
                    n(this.f);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void l(j jVar) {
        final O23.a aVar;
        Executor executor;
        synchronized (this.a) {
            try {
                if (this.l.size() < e()) {
                    jVar.a(this);
                    this.l.add(jVar);
                    aVar = this.g;
                    executor = this.h;
                } else {
                    PI3.a("TAG", "Maximum image number reached.");
                    jVar.close();
                    aVar = null;
                    executor = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (aVar != null) {
            if (executor != null) {
                executor.execute(new Runnable() { // from class: ir.nasim.xe4
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.o(aVar);
                    }
                });
            } else {
                aVar.a(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o(O23.a aVar) {
        aVar.a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p(O23 o23) {
        synchronized (this.a) {
            this.c++;
        }
        n(o23);
    }

    private void q() {
        synchronized (this.a) {
            try {
                for (int size = this.i.size() - 1; size >= 0; size--) {
                    W13 w13 = (W13) this.i.valueAt(size);
                    long timestamp = w13.getTimestamp();
                    f fVar = (f) this.j.get(timestamp);
                    if (fVar != null) {
                        this.j.remove(timestamp);
                        this.i.removeAt(size);
                        l(new j(fVar, w13));
                    }
                }
                r();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void r() {
        synchronized (this.a) {
            try {
                if (this.j.size() != 0 && this.i.size() != 0) {
                    long jKeyAt = this.j.keyAt(0);
                    Long lValueOf = Long.valueOf(jKeyAt);
                    long jKeyAt2 = this.i.keyAt(0);
                    AbstractC4980Hj5.a(!Long.valueOf(jKeyAt2).equals(lValueOf));
                    if (jKeyAt2 > jKeyAt) {
                        for (int size = this.j.size() - 1; size >= 0; size--) {
                            if (this.j.keyAt(size) < jKeyAt2) {
                                ((f) this.j.valueAt(size)).close();
                                this.j.removeAt(size);
                            }
                        }
                    } else {
                        for (int size2 = this.i.size() - 1; size2 >= 0; size2--) {
                            if (this.i.keyAt(size2) < jKeyAt) {
                                this.i.removeAt(size2);
                            }
                        }
                    }
                }
            } finally {
            }
        }
    }

    @Override // androidx.camera.core.e.a
    public void a(f fVar) {
        synchronized (this.a) {
            k(fVar);
        }
    }

    @Override // ir.nasim.O23
    public f b() {
        synchronized (this.a) {
            try {
                if (this.l.isEmpty()) {
                    return null;
                }
                if (this.k >= this.l.size()) {
                    throw new IllegalStateException("Maximum image number reached.");
                }
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < this.l.size() - 1; i++) {
                    if (!this.m.contains(this.l.get(i))) {
                        arrayList.add((f) this.l.get(i));
                    }
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((f) it.next()).close();
                }
                int size = this.l.size();
                List list = this.l;
                this.k = size;
                f fVar = (f) list.get(size - 1);
                this.m.add(fVar);
                return fVar;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // ir.nasim.O23
    public int c() {
        int iC;
        synchronized (this.a) {
            iC = this.f.c();
        }
        return iC;
    }

    @Override // ir.nasim.O23
    public void close() {
        synchronized (this.a) {
            try {
                if (this.e) {
                    return;
                }
                Iterator it = new ArrayList(this.l).iterator();
                while (it.hasNext()) {
                    ((f) it.next()).close();
                }
                this.l.clear();
                this.f.close();
                this.e = true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // ir.nasim.O23
    public void d() {
        synchronized (this.a) {
            this.f.d();
            this.g = null;
            this.h = null;
            this.c = 0;
        }
    }

    @Override // ir.nasim.O23
    public int e() {
        int iE;
        synchronized (this.a) {
            iE = this.f.e();
        }
        return iE;
    }

    @Override // ir.nasim.O23
    public void f(O23.a aVar, Executor executor) {
        synchronized (this.a) {
            this.g = (O23.a) AbstractC4980Hj5.g(aVar);
            this.h = (Executor) AbstractC4980Hj5.g(executor);
            this.f.f(this.d, executor);
        }
    }

    @Override // ir.nasim.O23
    public f g() {
        synchronized (this.a) {
            try {
                if (this.l.isEmpty()) {
                    return null;
                }
                if (this.k >= this.l.size()) {
                    throw new IllegalStateException("Maximum image number reached.");
                }
                List list = this.l;
                int i = this.k;
                this.k = i + 1;
                f fVar = (f) list.get(i);
                this.m.add(fVar);
                return fVar;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // ir.nasim.O23
    public int getHeight() {
        int height;
        synchronized (this.a) {
            height = this.f.getHeight();
        }
        return height;
    }

    @Override // ir.nasim.O23
    public Surface getSurface() {
        Surface surface;
        synchronized (this.a) {
            surface = this.f.getSurface();
        }
        return surface;
    }

    @Override // ir.nasim.O23
    public int getWidth() {
        int width;
        synchronized (this.a) {
            width = this.f.getWidth();
        }
        return width;
    }

    public JB0 m() {
        return this.b;
    }

    void n(O23 o23) {
        f fVarG;
        synchronized (this.a) {
            try {
                if (this.e) {
                    return;
                }
                int size = this.j.size() + this.l.size();
                if (size >= o23.e()) {
                    PI3.a("MetadataImageReader", "Skip to acquire the next image because the acquired image count has reached the max images count.");
                    return;
                }
                do {
                    try {
                        fVarG = o23.g();
                        if (fVarG != null) {
                            this.c--;
                            size++;
                            this.j.put(fVarG.u1().getTimestamp(), fVarG);
                            q();
                        }
                    } catch (IllegalStateException e) {
                        PI3.b("MetadataImageReader", "Failed to acquire next image.", e);
                        fVarG = null;
                    }
                    if (fVarG == null || this.c <= 0) {
                        break;
                    }
                } while (size < o23.e());
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    void s(QB0 qb0) {
        synchronized (this.a) {
            try {
                if (this.e) {
                    return;
                }
                this.i.put(qb0.getTimestamp(), new RB0(qb0));
                q();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    h(O23 o23) {
        this.a = new Object();
        this.b = new a();
        this.c = 0;
        this.d = new O23.a() { // from class: ir.nasim.we4
            @Override // ir.nasim.O23.a
            public final void a(O23 o232) {
                this.a.p(o232);
            }
        };
        this.e = false;
        this.i = new LongSparseArray();
        this.j = new LongSparseArray();
        this.m = new ArrayList();
        this.f = o23;
        this.k = 0;
        this.l = new ArrayList(e());
    }
}
