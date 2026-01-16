package com.google.android.exoplayer2.audio;

import android.os.Handler;
import com.google.android.exoplayer2.X;
import ir.nasim.AbstractC20011rK;
import ir.nasim.AbstractC9683aN7;
import ir.nasim.JB1;
import ir.nasim.MB1;

/* loaded from: classes2.dex */
public interface b {

    public static final class a {
        private final Handler a;
        private final b b;

        public a(Handler handler, b bVar) {
            this.a = bVar != null ? (Handler) AbstractC20011rK.e(handler) : null;
            this.b = bVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void A(int i, long j, long j2) {
            ((b) AbstractC9683aN7.j(this.b)).N(i, j, j2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void r(Exception exc) {
            ((b) AbstractC9683aN7.j(this.b)).L(exc);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void s(Exception exc) {
            ((b) AbstractC9683aN7.j(this.b)).c(exc);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void t(String str, long j, long j2) {
            ((b) AbstractC9683aN7.j(this.b)).n(str, j, j2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void u(String str) {
            ((b) AbstractC9683aN7.j(this.b)).m(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void v(JB1 jb1) {
            jb1.c();
            ((b) AbstractC9683aN7.j(this.b)).d(jb1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void w(JB1 jb1) {
            ((b) AbstractC9683aN7.j(this.b)).D(jb1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void x(X x, MB1 mb1) {
            ((b) AbstractC9683aN7.j(this.b)).P(x);
            ((b) AbstractC9683aN7.j(this.b)).E(x, mb1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void y(long j) {
            ((b) AbstractC9683aN7.j(this.b)).w(j);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void z(boolean z) {
            ((b) AbstractC9683aN7.j(this.b)).b(z);
        }

        public void B(final long j) {
            Handler handler = this.a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: ir.nasim.fP
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.y(j);
                    }
                });
            }
        }

        public void C(final boolean z) {
            Handler handler = this.a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: ir.nasim.lP
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.z(z);
                    }
                });
            }
        }

        public void D(final int i, final long j, final long j2) {
            Handler handler = this.a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: ir.nasim.kP
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.A(i, j, j2);
                    }
                });
            }
        }

        public void k(final Exception exc) {
            Handler handler = this.a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: ir.nasim.eP
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.r(exc);
                    }
                });
            }
        }

        public void l(final Exception exc) {
            Handler handler = this.a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: ir.nasim.jP
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.s(exc);
                    }
                });
            }
        }

        public void m(final String str, final long j, final long j2) {
            Handler handler = this.a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: ir.nasim.dP
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.t(str, j, j2);
                    }
                });
            }
        }

        public void n(final String str) {
            Handler handler = this.a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: ir.nasim.cP
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.u(str);
                    }
                });
            }
        }

        public void o(final JB1 jb1) {
            jb1.c();
            Handler handler = this.a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: ir.nasim.hP
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.v(jb1);
                    }
                });
            }
        }

        public void p(final JB1 jb1) {
            Handler handler = this.a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: ir.nasim.gP
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.w(jb1);
                    }
                });
            }
        }

        public void q(final X x, final MB1 mb1) {
            Handler handler = this.a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: ir.nasim.iP
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.x(x, mb1);
                    }
                });
            }
        }
    }

    void D(JB1 jb1);

    void E(X x, MB1 mb1);

    void L(Exception exc);

    void N(int i, long j, long j2);

    default void P(X x) {
    }

    void b(boolean z);

    void c(Exception exc);

    void d(JB1 jb1);

    void m(String str);

    void n(String str, long j, long j2);

    void w(long j);
}
