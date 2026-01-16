package com.google.android.exoplayer2.drm;

import android.os.Handler;
import com.google.android.exoplayer2.source.MediaSource;
import ir.nasim.AbstractC20011rK;
import ir.nasim.AbstractC9683aN7;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes2.dex */
public interface h {

    public static class a {
        public final int a;
        public final MediaSource.MediaPeriodId b;
        private final CopyOnWriteArrayList c;

        /* renamed from: com.google.android.exoplayer2.drm.h$a$a, reason: collision with other inner class name */
        private static final class C0160a {
            public Handler a;
            public h b;

            public C0160a(Handler handler, h hVar) {
                this.a = handler;
                this.b = hVar;
            }
        }

        public a() {
            this(new CopyOnWriteArrayList(), 0, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void n(h hVar) {
            hVar.Q(this.a, this.b);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void o(h hVar) {
            hVar.q(this.a, this.b);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void p(h hVar) {
            hVar.Y(this.a, this.b);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void q(h hVar, int i) {
            hVar.r(this.a, this.b);
            hVar.U(this.a, this.b, i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void r(h hVar, Exception exc) {
            hVar.z(this.a, this.b, exc);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void s(h hVar) {
            hVar.V(this.a, this.b);
        }

        public void g(Handler handler, h hVar) {
            AbstractC20011rK.e(handler);
            AbstractC20011rK.e(hVar);
            this.c.add(new C0160a(handler, hVar));
        }

        public void h() {
            Iterator it = this.c.iterator();
            while (it.hasNext()) {
                C0160a c0160a = (C0160a) it.next();
                final h hVar = c0160a.b;
                AbstractC9683aN7.J0(c0160a.a, new Runnable() { // from class: ir.nasim.c12
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.n(hVar);
                    }
                });
            }
        }

        public void i() {
            Iterator it = this.c.iterator();
            while (it.hasNext()) {
                C0160a c0160a = (C0160a) it.next();
                final h hVar = c0160a.b;
                AbstractC9683aN7.J0(c0160a.a, new Runnable() { // from class: ir.nasim.a12
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.o(hVar);
                    }
                });
            }
        }

        public void j() {
            Iterator it = this.c.iterator();
            while (it.hasNext()) {
                C0160a c0160a = (C0160a) it.next();
                final h hVar = c0160a.b;
                AbstractC9683aN7.J0(c0160a.a, new Runnable() { // from class: ir.nasim.b12
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.p(hVar);
                    }
                });
            }
        }

        public void k(final int i) {
            Iterator it = this.c.iterator();
            while (it.hasNext()) {
                C0160a c0160a = (C0160a) it.next();
                final h hVar = c0160a.b;
                AbstractC9683aN7.J0(c0160a.a, new Runnable() { // from class: ir.nasim.Z02
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.q(hVar, i);
                    }
                });
            }
        }

        public void l(final Exception exc) {
            Iterator it = this.c.iterator();
            while (it.hasNext()) {
                C0160a c0160a = (C0160a) it.next();
                final h hVar = c0160a.b;
                AbstractC9683aN7.J0(c0160a.a, new Runnable() { // from class: ir.nasim.X02
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.r(hVar, exc);
                    }
                });
            }
        }

        public void m() {
            Iterator it = this.c.iterator();
            while (it.hasNext()) {
                C0160a c0160a = (C0160a) it.next();
                final h hVar = c0160a.b;
                AbstractC9683aN7.J0(c0160a.a, new Runnable() { // from class: ir.nasim.Y02
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.s(hVar);
                    }
                });
            }
        }

        public void t(h hVar) {
            Iterator it = this.c.iterator();
            while (it.hasNext()) {
                C0160a c0160a = (C0160a) it.next();
                if (c0160a.b == hVar) {
                    this.c.remove(c0160a);
                }
            }
        }

        public a u(int i, MediaSource.MediaPeriodId mediaPeriodId) {
            return new a(this.c, i, mediaPeriodId);
        }

        private a(CopyOnWriteArrayList copyOnWriteArrayList, int i, MediaSource.MediaPeriodId mediaPeriodId) {
            this.c = copyOnWriteArrayList;
            this.a = i;
            this.b = mediaPeriodId;
        }
    }

    void Q(int i, MediaSource.MediaPeriodId mediaPeriodId);

    void U(int i, MediaSource.MediaPeriodId mediaPeriodId, int i2);

    void V(int i, MediaSource.MediaPeriodId mediaPeriodId);

    void Y(int i, MediaSource.MediaPeriodId mediaPeriodId);

    void q(int i, MediaSource.MediaPeriodId mediaPeriodId);

    default void r(int i, MediaSource.MediaPeriodId mediaPeriodId) {
    }

    void z(int i, MediaSource.MediaPeriodId mediaPeriodId, Exception exc);
}
