package ir.nasim;

import ir.nasim.AbstractC3967Dc6;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class JG4 extends AbstractC22307v1 {
    final long b;
    final TimeUnit c;
    final AbstractC3967Dc6 d;

    static final class a extends AtomicReference implements Runnable, GV1 {
        final Object a;
        final long b;
        final b c;
        final AtomicBoolean d = new AtomicBoolean();

        a(Object obj, long j, b bVar) {
            this.a = obj;
            this.b = j;
            this.c = bVar;
        }

        public void a(GV1 gv1) {
            OV1.p(this, gv1);
        }

        @Override // ir.nasim.GV1
        public void dispose() {
            OV1.a(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.d.compareAndSet(false, true)) {
                this.c.d(this.b, this.a, this);
            }
        }
    }

    static final class b implements PG4, GV1 {
        final PG4 a;
        final long b;
        final TimeUnit c;
        final AbstractC3967Dc6.a d;
        GV1 e;
        GV1 f;
        volatile long g;
        boolean h;

        b(PG4 pg4, long j, TimeUnit timeUnit, AbstractC3967Dc6.a aVar) {
            this.a = pg4;
            this.b = j;
            this.c = timeUnit;
            this.d = aVar;
        }

        @Override // ir.nasim.PG4
        public void a(Throwable th) {
            if (this.h) {
                D76.d(th);
                return;
            }
            GV1 gv1 = this.f;
            if (gv1 != null) {
                gv1.dispose();
            }
            this.h = true;
            this.a.a(th);
            this.d.dispose();
        }

        @Override // ir.nasim.PG4
        public void b(GV1 gv1) {
            if (OV1.s(this.e, gv1)) {
                this.e = gv1;
                this.a.b(this);
            }
        }

        @Override // ir.nasim.PG4
        public void c() {
            if (this.h) {
                return;
            }
            this.h = true;
            GV1 gv1 = this.f;
            if (gv1 != null) {
                gv1.dispose();
            }
            a aVar = (a) gv1;
            if (aVar != null) {
                aVar.run();
            }
            this.a.c();
            this.d.dispose();
        }

        void d(long j, Object obj, a aVar) {
            if (j == this.g) {
                this.a.e(obj);
                aVar.dispose();
            }
        }

        @Override // ir.nasim.GV1
        public void dispose() {
            this.e.dispose();
            this.d.dispose();
        }

        @Override // ir.nasim.PG4
        public void e(Object obj) {
            if (this.h) {
                return;
            }
            long j = this.g + 1;
            this.g = j;
            GV1 gv1 = this.f;
            if (gv1 != null) {
                gv1.dispose();
            }
            a aVar = new a(obj, j, this);
            this.f = aVar;
            aVar.a(this.d.a(aVar, this.b, this.c));
        }
    }

    public JG4(NG4 ng4, long j, TimeUnit timeUnit, AbstractC3967Dc6 abstractC3967Dc6) {
        super(ng4);
        this.b = j;
        this.c = timeUnit;
        this.d = abstractC3967Dc6;
    }

    @Override // ir.nasim.IG4
    public void j(PG4 pg4) {
        this.a.d(new b(new C24574yq6(pg4), this.b, this.c, this.d.a()));
    }
}
