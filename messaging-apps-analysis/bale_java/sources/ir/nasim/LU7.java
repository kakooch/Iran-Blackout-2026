package ir.nasim;

import android.os.Handler;
import android.os.SystemClock;

/* loaded from: classes2.dex */
public interface LU7 {

    public static final class a {
        private final Handler a;
        private final LU7 b;

        public a(Handler handler, LU7 lu7) {
            this.a = lu7 != null ? (Handler) AbstractC20011rK.e(handler) : null;
            this.b = lu7;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void q(String str, long j, long j2) {
            ((LU7) AbstractC9683aN7.j(this.b)).g(str, j, j2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void r(String str) {
            ((LU7) AbstractC9683aN7.j(this.b)).f(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void s(JB1 jb1) {
            jb1.c();
            ((LU7) AbstractC9683aN7.j(this.b)).j(jb1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void t(int i, long j) {
            ((LU7) AbstractC9683aN7.j(this.b)).G(i, j);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void u(JB1 jb1) {
            ((LU7) AbstractC9683aN7.j(this.b)).A(jb1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void v(com.google.android.exoplayer2.X x, MB1 mb1) {
            ((LU7) AbstractC9683aN7.j(this.b)).q(x);
            ((LU7) AbstractC9683aN7.j(this.b)).M(x, mb1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void w(Object obj, long j) {
            ((LU7) AbstractC9683aN7.j(this.b)).I(obj, j);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void x(long j, int i) {
            ((LU7) AbstractC9683aN7.j(this.b)).O(j, i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void y(Exception exc) {
            ((LU7) AbstractC9683aN7.j(this.b)).y(exc);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void z(C12372eV7 c12372eV7) {
            ((LU7) AbstractC9683aN7.j(this.b)).l(c12372eV7);
        }

        public void A(final Object obj) {
            if (this.a != null) {
                final long jElapsedRealtime = SystemClock.elapsedRealtime();
                this.a.post(new Runnable() { // from class: ir.nasim.DU7
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.w(obj, jElapsedRealtime);
                    }
                });
            }
        }

        public void B(final long j, final int i) {
            Handler handler = this.a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: ir.nasim.KU7
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.x(j, i);
                    }
                });
            }
        }

        public void C(final Exception exc) {
            Handler handler = this.a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: ir.nasim.GU7
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.y(exc);
                    }
                });
            }
        }

        public void D(final C12372eV7 c12372eV7) {
            Handler handler = this.a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: ir.nasim.BU7
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.z(c12372eV7);
                    }
                });
            }
        }

        public void k(final String str, final long j, final long j2) {
            Handler handler = this.a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: ir.nasim.HU7
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.q(str, j, j2);
                    }
                });
            }
        }

        public void l(final String str) {
            Handler handler = this.a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: ir.nasim.EU7
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.r(str);
                    }
                });
            }
        }

        public void m(final JB1 jb1) {
            jb1.c();
            Handler handler = this.a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: ir.nasim.FU7
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.s(jb1);
                    }
                });
            }
        }

        public void n(final int i, final long j) {
            Handler handler = this.a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: ir.nasim.CU7
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.t(i, j);
                    }
                });
            }
        }

        public void o(final JB1 jb1) {
            Handler handler = this.a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: ir.nasim.IU7
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.u(jb1);
                    }
                });
            }
        }

        public void p(final com.google.android.exoplayer2.X x, final MB1 mb1) {
            Handler handler = this.a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: ir.nasim.JU7
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.v(x, mb1);
                    }
                });
            }
        }
    }

    void A(JB1 jb1);

    void G(int i, long j);

    void I(Object obj, long j);

    void M(com.google.android.exoplayer2.X x, MB1 mb1);

    void O(long j, int i);

    void f(String str);

    void g(String str, long j, long j2);

    void j(JB1 jb1);

    void l(C12372eV7 c12372eV7);

    void y(Exception exc);

    default void q(com.google.android.exoplayer2.X x) {
    }
}
